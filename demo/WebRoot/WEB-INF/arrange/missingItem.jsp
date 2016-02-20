<%@ page language="java" import="java.util.*" pageEncoding="UTF8"%>
<%@page import="com.opensymphony.xwork2.ActionContext"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'missingItem.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	
  </head>
  
  <body>
 
  	<%
  		Map<String, List<String>> errMsg = (Map<String, List<String>>)ActionContext.getContext().get("errorMsg");
  		String roomtype = "no roomType";
		String lesson = "no lesson";
		String teacher = "no teacher";
		String classes = "no class";
		String elective = "no stunum";
		int count = 0;
		int size = 9;
  	 %>
   	<table>
   		<tr>
   			<td><h1 style="color:red">注意：</h1></td>
   			<td>由于缺少以下信息无法进行排课，请到相关的设置页面进行设置！</td>
   		</tr>
   		<%
   				if (errMsg.get(classes).size() > 0){
   		 %>
   		<tr>
   			<td valign="top" style="font-weight: bold;">缺少上课班级</td>
   			<td>
   			
   				<%
   					count = 0;
   					for (String name : errMsg.get(classes)){
   						if (count == size){
   							count = 0;
   				%>
   					<br>
   				<%
   						}
   						count++;
   						
   				%>
   					<%=name %>
   				<%
   					}
   				 %>
   			
   			</td>
   		</tr>
   		<%		} %>
   		<%
   				if (errMsg.get(lesson).size() > 0){
   		 %>
   		<tr>
   			<td valign="top" style="font-weight: bold;">缺少课时信息</td>
   			<td>
   			
   				<%
   					count = 0;
   					for (String name : errMsg.get(lesson)){
   						if (count == size){
   							count = 0;
   				%>
   					<br>
   				<%
   						}
   						count++;
   						
   				%>
   					<%=name %>
   				<%
   					}
   				 %>
   			
   			</td>
   		</tr>
   		<%		} %>
   		<%
   				if (errMsg.get(roomtype).size() > 0){
   		 %>
   		<tr>
   			<td valign="top" style="font-weight: bold;">缺少教室类型</td>
   			<td>
   			
   				<%
   					count = 0;
   					for (String name : errMsg.get(roomtype)){
   						if (count == size){
   							count = 0;
   				%>
   					<br>
   				<%
   						}
   						count++;
   						
   				%>
   					<%=name %>
   				<%
   					}
   				 %>
   			
   			</td>
   		</tr>
   		<%		} %>
   		<%
   				if (errMsg.get(teacher).size() > 0){
   		 %>
   		<tr>
   			<td valign="top" style="font-weight: bold;">缺少上课教师信息</td>
   			<td>
   			
   				<%
   					count = 0;
   					for (String name : errMsg.get(teacher)){
   						if (count == size){
   							count = 0;
   				%>
   					<br>
   				<%
   						}
   						count++;
   						
   				%>
   					<%=name %>
   				<%
   					}
   				 %>
   			</td>
   		</tr>
   		<%} %>
   		<%
   				if (errMsg.get(roomtype).size() > 0){
   		 %>
   		<tr>
   			<td valign="top" style="font-weight: bold;">缺少教室类型</td>
   			<td>
   			
   				<%
   					count = 0;
   					for (String name : errMsg.get(roomtype)){
   						if (count == size){
   							count = 0;
   				%>
   					<br>
   				<%
   						}
   						count++;
   						
   				%>
   					<%=name %>
   				<%
   					}
   				 %>
   			
   			</td>
   		</tr>
   		<%		} %>
   		<%
   				if (errMsg.get(elective).size() > 0){
   		 %>
   		<tr>
   			<td valign="top" style="font-weight: bold;">任选课缺少最大选课人数信息</td>
   			<td>
   			
   				<%
   					count = 0;
   					for (String name : errMsg.get(elective)){
   						if (count == size){
   							count = 0;
   				%>
   					<br>
   				<%
   						}
   						count++;
   						
   				%>
   					<%=name %>
   				<%
   					}
   				 %>
   			</td>
   		</tr>
   		<%} %>
   	</table>
  </body>
</html>
