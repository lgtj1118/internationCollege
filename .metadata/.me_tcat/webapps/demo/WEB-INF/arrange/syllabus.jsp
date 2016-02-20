<%@page import="com.opensymphony.xwork2.ActionContext"%>
<%@page import="com.tjpu.bean.Syllabus"%>
<%@page import="com.tjpu.bean.ChosenCourseModel"%>
<%@page import="org.springframework.web.context.request.SessionScope"%>
<%@ page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="java.io.*"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<title>天津工业大学排课管理系统</title>
<link href="<%=basePath%>js/ligerUI/skins/Aqua/css/ligerui-all.css" rel="stylesheet"type="text/css" />	
<link href="<%=basePath %>js/ligerUI/skins/Gray/css/all.css" rel="stylesheet" type="text/css"/>	
<script src="js/jquery/jquery-1.3.2.min.js" type="text/javascript"></script>
<script src="js/ligerUI/ligerui.all.js" type="text/javascript"></script>
<script type="text/javascript">
   var m;
   function changecourse(coursenum, flag){
     if (flag == "")
     	return;
     if(coursenum!=null){
        
        var str = "${pageContext.request.contextPath}/system/Manage_adjustingCurriculums.action?num="+coursenum;
        //m=window.open(str,'800','600');
        m=$.ligerDialog.open({
			url : str,
			height : 480,
			width : 640,
			isDrag:true,
			title:'课程调整',
			showMax:true,
			showToggle:true,
			slide: false,			
			modal:false,
			left:200,
			allowClose:true,
		    isResize : false
	   });	
   }
  }   
</script>
<style type="text/css">
table.gridtable {
	font-size: 10px;
	color: #333333;
	border-width: 1px;
	width: 100%;
	border-color: #666666;
	border-collapse: collapse;
	table-layout: fixed;
}

table.gridtable th {
	border-width: 1px;
	padding: 8px;
	width: 200px;
	border-style: solid;
	border-color: #666666;
	background-color: #dedede;
	border-style: solid;
}

table.gridtable td {
	border-width: 1px;
	padding: 8px;
	border-style: solid;
	border-color: #666666;
	background-color: #ffffff;
}
a{ text-decoration:none;}
a:hover{ color:#c6c6c6; cursor: pointer;  }
a:actived{ text-decoration:none;}
</style>
</head>
<body style="padding: 2px; " >
	<dir style="float: left; padding-left:10px">
		<table>
			<tr>
				<td colspan="4"><img alt="flow_chat"src="images/flow_chat3.jpg" height="100px"></td>
			</tr>
			<tr>
				<td colspan="3"  ><font size="5"><strong>注</strong></font>：如对某一课程排课结果不满意，可点击该课程，选择想要调整的位置时间调整</td>
				<td height="25px">
				<a class="l-button" style="width:60px;float:left; margin-left:10px"  href="system/Manage_saveSyllabus.action">保存</a>
			 </td>
			</tr>
			<tr>
			  	<td></td>
				<td></td>
				<td></td>
				<td></td>
			</tr>
		</table>
	</dir>
	<div class="l-clear"></div>
	<div>
		<table class="gridtable" align="center">
			<% 
				List<Syllabus> unable = (List<Syllabus>) ActionContext.getContext().get("unable");
				int ucount = 0;
				int usize = 8;
				if (unable.size() > 0){
			%>
				<tr><td colspan="8"><strong style="color:red">注：</strong>以下课程是任选课或是无法被排进课表中的课程，但可以点击课程替换课表中已有的课程或空位。</td></tr>
			<%
				}
				for (Syllabus course : unable) {
					if (ucount == 0) {
						ucount++;
			%>
						<tr><td><a onclick="changecourse(<%=course.getNum() %>,'<%=course.getCourseName()%>')"   >
				   <pre style="word-wrap: break-word; table-layout: fixed; width: 100%"><%=course.getCourseName()%><br><%=course.getTeacherName()%><br><%=course.getClassName()%></pre>
				  </a></td>
			<%
					} else if (ucount == usize - 1){
						ucount = 0;
			%>
						<td><a onclick="changecourse(<%=course.getNum() %>,'<%=course.getCourseName()%>')"   >
				   <pre style="word-wrap: break-word; table-layout: fixed; width: 100%"><%=course.getCourseName()%><br><%=course.getTeacherName()%><br><%=course.getClassName()%></pre>
				  </a></td></tr>
			<%
					} else{
			%>
						<td><a onclick="changecourse(<%=course.getNum() %>,'<%=course.getCourseName()%>')"   >
				   <pre style="word-wrap: break-word; table-layout: fixed; width: 100%"><%=course.getCourseName()%><br><%=course.getTeacherName()%><br><%=course.getClassName()%></pre>
				  </a></td>
			<%
						ucount++;
					}
					
				}
				while (ucount != 0 && ucount < usize) {
					ucount ++;
			%>
				<td></td>
			<%
				}
			 %>
				</tr>
		</table>
		<div style="margin: 10px;"></div>
		<div class="l-clear"></div>
		<table class="gridtable" align="center">
			<tr>
				<th colspan="2" style="width:50px"></th>
				<%
					List<Syllabus> courses = (List<Syllabus>) ActionContext.getContext().get("arrangedCourses");
					Integer roomCount = (Integer) ActionContext.getContext().get("roomCount");
					List<String> order = (List<String>) ActionContext.getContext().get("rooms");
					String week[] = new String[] { "一", "二", "三", "四", "五", "六" };
					for (String room : order) {
				%>
				<th align="center" ><%=room%></th>
				<%
					}
				%>
			</tr>
			<tr>
				<%
					int count = roomCount;
					int day = 0;
					int slot = 0;
					for (Syllabus course : courses) {
						if (count == roomCount) {
							count = 0;
							if (slot > 4) {
								slot = 0;
								day++;
								if (day == 5)
									break;
							}
							if (slot == 0) {
				%>
			</tr>
			<tr>
				<td rowspan="5" style="padding:0px;">
				  <p style="width:23px;margin-left: 10px"><%=new String("周" + week[day])%></p>
				</td>
				<td><%=new String("第" + week[slot] + "大节")%></td>
				<td align="center">
				  <a onclick="changecourse(<%=course.getNum() %>,'<%=course.getCourseName()%>')"   >
				   <pre style="word-wrap: break-word; table-layout: fixed; width: 100%"><%=course.getCourseName()%><br><%=course.getTeacherName()%><br><%=course.getClassName()%></pre>
				  </a>
				</td>
				<%
					} else {
				%>
			</tr>
			<tr>
				<td><%=new String("第" + week[slot] + "大节")%></td>
				<td align="center">
					<a onclick="changecourse(<%=course.getNum() %>,'<%=course.getCourseName()%>')" >
				    <pre style="word-wrap: break-word; table-layout: fixed; width: 100%"><%=course.getCourseName()%><br><%=course.getTeacherName()%><br><%=course.getClassName()%></pre>
				  </a>
				</td>
				<%
					}
							slot++;
						} else {
				%>
				<td align="center">
				  <a onclick="changecourse(<%=course.getNum() %>,'<%=course.getCourseName()%>')" >
				   <pre style="word-wrap: break-word; table-layout: fixed; width: 100%"><%=course.getCourseName()%><br><%=course.getTeacherName()%><br><%=course.getClassName()%></pre>
				  </a>
				</td>
				<%
					}
						count++;
					}
				%>
			</tr>
		</table>
	</div>
	
	
</body>
</html>
