<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title></title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
<script type="text/javascript">
  function jspprint(){
     window.print();
  }

</script>
<style type="text/css">
#contain {
  width: 800px;
  height:580px;
  border:1px solid #000 ;
  margin:auto;
}
.stuimg{
  float: right;
  margin-right: 80px;
  margin-top:-30px;
  width: 100px;
  height:120px;
  border:1px solid #000; 
}
.content{
  margin-top: 120px;
}
.span {
	margin-top: 10px;
	margin-bottom: 10px;
}
</style>	
	</head>
  
  <body onload="jspprint()" >
    <div id="contain"> 
      <div align="center"><font size="4"><strong><br>普 通 高 等 学 校<br><br></strong></font><font size="7" color="#ff0000" face="楷体"><strong>毕 业 证 书</strong></font> </div>
      <div class="stuimg"><img src="${student.imgurl }" width="100px" height="120px" ></div>
      <div class="content"><span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp;  
${student.firstname } &nbsp;  ${student.lastname } &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp;  <s:if test="#student.sex=='男'.toString()"><strong>先生</strong></s:if><s:elseif test="#student.sex=='女'.toString()"><strong>女士</strong>，</s:elseif>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;   <strong>国籍</strong> &nbsp; &nbsp;&nbsp; &nbsp;  ${student.nation }</span><br><br>&nbsp; &nbsp; &nbsp;&nbsp; &nbsp;  
     <span> ${year } &nbsp; &nbsp;&nbsp; <strong>年 &nbsp;&nbsp;</strong> &nbsp;&nbsp; ${month } &nbsp;&nbsp; <strong>月</strong> &nbsp;&nbsp; ${day } &nbsp;&nbsp; <strong>日生</strong>，<strong>于</strong> &nbsp; &nbsp;&nbsp; ${startyear } &nbsp;&nbsp; <strong>年</strong> &nbsp;&nbsp; ${startmonth } &nbsp; &nbsp;&nbsp; <strong>月至</strong> &nbsp;&nbsp; &nbsp; ${endyear } &nbsp;&nbsp; &nbsp; <strong>年</strong> &nbsp; &nbsp;&nbsp; ${endmonth } &nbsp; &nbsp;&nbsp; <strong>月</strong></span><br><br>&nbsp; &nbsp; &nbsp;&nbsp; &nbsp; <span><strong>在本校</strong> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; ${student.studentType } &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; <strong>专业</strong> &nbsp; &nbsp; &nbsp; ${summaryyear } &nbsp; &nbsp;&nbsp; &nbsp;       <strong>年制</strong> &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp;<strong>   科学习，修完教学计划</strong><br><br>&nbsp; &nbsp; &nbsp;&nbsp; &nbsp; <strong>规定的全部课程，成绩合格，准予毕业。</strong></span><br><br> 
    <span>  <br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; <strong>校 &nbsp; &nbsp; &nbsp;&nbsp; &nbsp;&nbsp; 名:&nbsp; &nbsp; &nbsp; </strong>天津工业大学 &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp;&nbsp; &nbsp;   <strong>校（院）长</strong>：</span><br><br>
<br><br>&nbsp;&nbsp;&nbsp;&nbsp; <strong>证书编号</strong>：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp; <strong>年</strong>&nbsp;&nbsp;&nbsp; &nbsp; &nbsp;&nbsp; <strong>月</strong>&nbsp; &nbsp; &nbsp; &nbsp;&nbsp;&nbsp; <strong>日</strong>
      
      </div>
    </div>
  </body>
</html>
