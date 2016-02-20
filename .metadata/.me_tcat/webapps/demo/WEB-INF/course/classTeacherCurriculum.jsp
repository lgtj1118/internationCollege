<%@page import="com.tjpu.bean.AdjustcourseModel"%>
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
<link href="<%=basePath%>js/ligerUI/skins/Aqua/css/ligerui-all.css"
	rel="stylesheet" type="text/css" />
<link href="<%=basePath%>js/ligerUI/skins/Gray/css/all.css"
	rel="stylesheet" type="text/css" />
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
	width: 150px;
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

a {
	text-decoration: none;
}

a:hover {
	color: #c6c6c6;
	cursor: pointer;
}

a:actived {
	text-decoration: none;
}
</style>
</head>
<body style="padding: 2px; ">
	<br>

	<div style="font-size:large; font-weight: bold; width: 300px; margin-right: 0px">教师课表</div>
	
	<div>
		<a class="l-button" style="width:60px;float:left;margin-top:10px; margin-bottom: 10px" href="system/Class_downloadSyllabus.action">下载</a>
	</div>
	<div class="l-clear"></div>
	<div>
		<table class="gridtable" align="center">
			<!-- <tr>
				<th colspan="2" style="width:50px"></th> -->
			<tr>
				<th style="width:53px"></th>
				<%
					List<Syllabus> courses = (List<Syllabus>) ActionContext
							.getContext().get("courses");
					String week[] = new String[] { "一", "二", "三", "四", "五"};
					for (String n : week) {
				%>
				<th>周<%=n%></th>

				<%
					}
				%>
			</tr>

			<%
				int day = 5;
				int slot = 0;
				for (Syllabus course : courses) {
				
					if (day == 5) {
						day = 0;
						if (slot == 5){
							break;
						}
			%>
			<tr>
				<td>第<%=week[slot]%>大节</td>
				<td align="center"><pre
						style="word-wrap: break-word; table-layout: fixed; width: 100%"><%=course.getCourseName()%><br><%=course.getTeacherName()%><br><%=course.getClassName()%><%=course.getRoomNum()%><br><%=course.getNote() %></pre>

				</td>

				<%
						slot++;
					} else if (day == 4) {
				%>
				
				<td align="center"><pre
						style="word-wrap: break-word; table-layout: fixed; width: 100%"><%=course.getCourseName()%><br><%=course.getTeacherName()%><br><%=course.getClassName()%><%=course.getRoomNum()%><br><%=course.getNote() %></pre>
				</td>
			</tr>
			<%
				} else {
			%>
			<td align="center"><pre
						style="word-wrap: break-word; table-layout: fixed; width: 100%"><%=course.getCourseName()%><br><%=course.getTeacherName()%><br><%=course.getClassName()%><%=course.getRoomNum()%><br><%=course.getNote() %></pre>

			</td>
			<%
				}
					day++;
				}
			%>
			</tr>
		</table>
	</div>
	<div>
	<p>
		<%  List<AdjustcourseModel> relateAdjust = (List<AdjustcourseModel>) ActionContext.getContext().get("relateAdjust");
			
			for (AdjustcourseModel i : relateAdjust) {
		%>
				<strong style="color:red">*</strong><%=i.getOlddate() %>第<%=i.getOldslot()%>大节的<%=i.getOldCourseName() %>调换至&nbsp;&nbsp;<%=i.getNewroomName()%>&nbsp;&nbsp;<%=i.getNewdate() %>第<%=i.getNewslot() %>大节<%=i.getNewCourseName() %><br>
		<%
			}
		%>
		</p>
	</div>
	<%	List<List<Syllabus>> courses2 = (List<List<Syllabus>>) ActionContext.getContext().get("courses2");
		int classNameIndex = 0;
		List<String> className = (List<String>) ActionContext.getContext().get("className"); 
		for (List<Syllabus> i : courses2) {
		%>
		<br>
		<br>
		<div style="font-size:large; font-weight: bold; width: 300px; margin-right: 0px"><%=className.get(classNameIndex++) %></div>	
	<div>
		<a class="l-button" style="width:60px;float:left;margin-top:10px; margin-bottom: 10px" href="system/Class_downloadOnChargedSyllabus.action?num=<%=courses2.indexOf(i)%>">下载</a>
	</div>
		<div>
		<table class="gridtable" align="center">
			<tr>
				<th style="width:53px"></th>
				<%
					for (String n : week) {
				%>
				<th>周<%=n%></th>

				<%
					}
				%>
			</tr>

			<%
				day = 5;
				slot = 0;
				for (Syllabus course : i) {
				
					if (day == 5) {
						day = 0;
						if (slot == 5){
							break;
						}
			%>
			<tr>
				<td>第<%=week[slot]%>大节</td>
				<td align="center"><pre
						style="word-wrap: break-word; table-layout: fixed; width: 100%"><%=course.getCourseName()%><br><%=course.getTeacherName()%><br><%=course.getClassName()%><%=course.getRoomNum()%><br><%=course.getNote() %></pre>

				</td>

				<%
						slot++;
					} else if (day == 4) {
				%>
				
				<td align="center"><pre
						style="word-wrap: break-word; table-layout: fixed; width: 100%"><%=course.getCourseName()%><br><%=course.getTeacherName()%><br><%=course.getClassName()%><%=course.getRoomNum()%><br><%=course.getNote() %></pre>
				</td>
			</tr>
			<%
				} else {
			%>
			<td align="center"><pre
						style="word-wrap: break-word; table-layout: fixed; width: 100%"><%=course.getCourseName()%><br><%=course.getTeacherName()%><br><%=course.getClassName()%><%=course.getRoomNum()%><br><%=course.getNote() %></pre>

			</td>
			<%
				}
					day++;
				}
			%>
			</tr>
		</table>
	</div>
	<%
		}
		
	%>
</body>
</html>
