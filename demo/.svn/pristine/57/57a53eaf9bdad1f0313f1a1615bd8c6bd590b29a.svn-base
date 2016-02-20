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
#head{
 width: 99%;
 height:80px;
 margin:auto;
 border:4px solid #c6c6c6 ;
}
.title{
 float: left;
 height: 100%;
 width: 10%;
 text-aligncenter;
 border-right:2px solid #c6c6c6 ;
}
.search{
  float: left;
}
.l-table-edit{
 height:100%;
 align:center;
}
.search.l-table-edit td{
  border-bottom: 1px solid #c6c6c6 ;
}
.link{
width:160px;height:25px;background: #fefefe;border: 1px solid #bbb;font-size: 14px;color: #333;border-radius: 3px;
}
.l-button{
 width:70px;float:left; margin:15px 160px 5px ;
 border-radiux:5px;
}
</style>
</head>
<body style="padding: 2px; " >
<div id="head">
	      <div class="title" ><br><br><div align="center"><font face="微软雅黑" color="#400000" size="4"><strong>条件选择</strong></font></div></div>
	      <div class="search" >
	         <table cellpadding="0" cellspacing="0" class="l-table-edit" width="100%" >
			  <tr>				
			    <td align="right" class="l-table-edit-td" width="100px" >&nbsp;&nbsp;学期:&nbsp;</td>
				<td align="left" class="l-table-edit-td">
				  <input id="num" class="link" name="num"  />
				</td>
				<td align="right" class="l-table-edit-td" width="100px" >&nbsp;&nbsp;课程名称:&nbsp;</td>
				<td align="left" class="l-table-edit-td">
				  <input id="coursename" class="link" name="coursename" value=""  />
				</td>				
			</tr>
			<tr>
			   <td align="right" class="l-table-edit-td">&nbsp;&nbsp;&nbsp;教室:&nbsp;</td>
				<td align="left" class="l-table-edit-td">
				   <input id="coursename" class="link" name="coursename" value=""  />
				</td>
				<td align="right" class="l-table-edit-td">&nbsp;&nbsp;&nbsp;班级:&nbsp;</td>
				<td align="left" class="l-table-edit-td">
				   <input id="coursename" class="link" name="coursename" value=""  />
				</td>
			</tr>						
		</table>
		<a class="l-button" onclick="f_search()"><strong>查&nbsp;&nbsp;询</strong></a>
	      </div>
	    </div>		
	<dir style="float: left; padding-left:10px">
		<table>			
			<% 
				List<Syllabus> unable = (List<Syllabus>) ActionContext.getContext().get("unable");
				int ucount = 0;
				for (Syllabus s : unable) {
					if (ucount == 0) {
			%>
						<tr><td><%=s.getCourseName() %></td>
			<%
					} else if (ucount == 4){
						ucount = 0;
			%>
						<td><%=s.getCourseName() %></td></tr>
			<%
					} else{
			%>
						<td><%=s.getCourseName() %></td>
			<%
					}
				}
				while (ucount != 0 && ucount < 4) {
					ucount ++;
			%>
				<td></td>
			<%
				}
			 %>
				</tr>
			
		</table>
	</dir>
	<div class="l-clear"></div>
	<div>
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
				 
				   <pre style="word-wrap: break-word; table-layout: fixed; width: 100%"><%=course.getCourseName()%><br><%=course.getTeacherName()%><br><%=course.getClassName()%></pre>
				  
				</td>
				<%
					} else {
				%>
			</tr>
			<tr>
				<td><%=new String("第" + week[slot] + "大节")%></td>
				<td align="center">
					
				    <pre style="word-wrap: break-word; table-layout: fixed; width: 100%"><%=course.getCourseName()%><br><%=course.getTeacherName()%><br><%=course.getClassName()%></pre>
				 
				</td>
				<%
					}
							slot++;
						} else {
				%>
				<td align="center">
				 
				   <pre style="word-wrap: break-word; table-layout: fixed; width: 100%"><%=course.getCourseName()%><br><%=course.getTeacherName()%><br><%=course.getClassName()%></pre>
				 
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
