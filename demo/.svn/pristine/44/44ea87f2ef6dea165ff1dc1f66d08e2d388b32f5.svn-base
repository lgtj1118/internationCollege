<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>error.html</title>
	
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="this is my page">
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <script src="<%=basePath%>js/jquery/jquery-1.3.2.min.js"type="text/javascript"></script>
    <script src="<%=basePath%>js/ligerUI/core/base.js"type="text/javascript"></script>
<script type="text/javascript">
  var i = 5;
	var intervalid;
	intervalid = setInterval("fun()", 1000);
	function fun(){
		if (i == 0) {
			top.f_closeTab();
		}
		document.getElementById("mes").innerHTML = i;
		i--;
	}
  function tabclose(){
   top.f_closeTab();
  }
</script>   
<style type="text/css">
div {
	margin:0 auto;
	padding:0;
}
a{
	cursor:pointer;
}
</style>
  </head>
  
  <body onload="fun()" >
     <div style="border:0px solid #000;width: 600px;height: 300px;background-color: #fff;margin-top: 100px" >
    <div>
     <img alt="" src="<%=basePath %>images/ku.jpg"></img>
     额。。。您是少数来到这里的人之一！
     </div>
      <br>
     <div style="padding-left: 100px">
         事情是这样的，您遇到了一点小麻烦，您访问的页面似乎不存在了。
     </div>
      <br>
     <div style="padding-left: 100px">
     您可以直接回到<a onclick="tabclose()" ><font style="color: blue">首页</font></a>继续浏览其他内容。
     </div>
      <br>
     <div style="padding-left: 100px">
     当然，您也可以什么都不做，
 <span id="mes" style="color:red;"><br>5</span>s 后我们将送您回到首页。<br/>
   <br> 谢谢您的访问！
     </div>
      </div>
  </body>
</html>
