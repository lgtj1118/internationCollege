<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"  %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">    
    <title>常用链接</title>
<style type="text/css">
a{margin-left: 30px;margin-top: 8px;font-family: 微软雅黑;color: black;text-decoration: none;}
a:hover{text-decoration:underline;}/*鼠标滑过样式*/
a:visited {color:#333;text-decoration:none;}/*访问后的样式*/
</style>
    </head>
  
  <body>
    <s:iterator  value="#link" id="link" >
     <a href="${link.linksaddress }" target="_blank">${link.title}</a><br>
    </s:iterator>
  </body>
</html>
