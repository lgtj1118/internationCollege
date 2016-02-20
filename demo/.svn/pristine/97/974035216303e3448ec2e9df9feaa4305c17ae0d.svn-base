<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>公告</title>
<style type="text/css">
body{
background-color: #f2f2f2;
margin-top:-10px;
}
.top{
 height: 100px;
 width: 100%;
 background-color: #005ea5;
}
#contain{
  margin: auto;
  width: 90%;
  height:auto;  
  background-color: #fff;
}
#title{ 
  height:120px;
  width:100%;
  margin:auto;
  border-bottom: 2px solid #f2f2f2;
  background-color: #fff;
}
.title2{
  margin-top: 20px;
}
#content{
margin-top: 30px;
margin: auto;
width:80%;
}
.content1{
 margin: auto;
 height: 100px;
}
</style>
  </head>
  
  <body>
	<div class="top" align="center">
                   <br><br> <font color="#ffffff" size="6" face="华文新魏"><strong>天津工业大学国际教育学院</strong></font>
	</div>
	<div id="contain">
	  <div id="title">
	     <div class="title1" align="center" style="font-size: 25px;"><br>${announcements.title}</div>
	     <div class="title2" align="center" style="font-size: 12px;">上传时间：${announcements.createdtime }</div>
	  </div>
	  <div id="content" >
	     ${announcements.content }
	     <div class="content1" ></div>
	  </div>
	</div>
  </body>
</html>
