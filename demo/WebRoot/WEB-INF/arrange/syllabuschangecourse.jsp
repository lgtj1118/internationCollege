<%@page import="com.opensymphony.xwork2.ActionContext"%>
<%@page import="com.tjpu.bean.Syllabus"%>
<%@page import="com.tjpu.bean.ChosenCourseModel"%>

<%@ page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="java.io.*"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>天津工业大学排课管理系统</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<script src="js/jquery/jquery-1.3.2.min.js" type="text/javascript"></script>
<script src="js/ligerUI/ligerui.all.js" type="text/javascript"></script>
<script type="text/javascript">
	function btnclose() {
		parent.window.location.reload();
		window.close();
	}

	function tonsubmit() {
		//var newnum = $("#options").val();
		var newnum = $("#options").val();
		var old = $("#oldnum").val();
		//alert(newnum);
		var str = "${pageContext.request.contextPath}/system/Manage_applyNewSyllabus.action?newnum="
				+ newnum + "&oldnum=" + old;
		$.post(str, null, function() {
			parent.m.hide();
			parent.window.location.reload();
		});
	}
</script>
</head>

<body>
	<input type="hidden" value=<%=(String) ActionContext.getContext().get("old")%> id="oldnum">
	<table align="center"  >
		<%
			List<Syllabus> options = (List<Syllabus>) ActionContext
					.getContext().get("options");
			boolean isfirst = true;
			String number[] = new String[]{"一","二","三","四","五","六"};
		%>
		<tr>
		   <td align="center" >可调换课程或位置<br></td>
		</tr>
		<tr>
			<td height="50px" ><select id="options">
					<%
						for (Syllabus s : options) {
							if (s.getSlot() < 0) {
								continue;
							}
										if (isfirst){
											isfirst = false;
					%>
					<option value=<%=s.getNum()%> selected="selected"><%=new String().format("周%s 第%s大节  %s", number[s.getDay()],
						number[s.getSlot()], s.getCourseName())%></option>
					<%
						}else{
					%>
					<option value=<%=s.getNum()%>><%=new String().format("周%s 第%s大节  %s", number[s.getDay()],
						number[s.getSlot()], s.getCourseName())%></option>
					<%
						}
									}
					%>
			</select>
			</td>
		</tr>
		<tr>
			<td align="center" ><input type="button" onclick="tonsubmit()" value="确认" /></td>
		</tr>
	</table>

</body>
</html>
