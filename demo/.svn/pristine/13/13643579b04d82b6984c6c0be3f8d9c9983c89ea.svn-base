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
	<script type="text/javascript" src="js/jquery/jquery-1.4.4.min.js" ></script>
	<script type="text/javascript" src="js/jquery.jqprint-0.3.js" ></script>
<script type="text/javascript">
   function tabclose(){
     top.f_closeTab();
   }
   function tabprint(){
     $("#contain").jqprint();
     
   }
</script>
<style type="text/css">
table{
  border: 1px solid #000 ;
  width:800px;
  margin: auto;

}
#head{
 margin: auto;
 }
table td {
  border: 0px solid #000 ;
}
table th {
  border: 0px solid #000 ;
}
.content{
 margin:10px 20px 20px;
 margin:auto;
}
</style>
</head>  
  <body  >
    <div id="head" ><input align="center" type="button" value="关&nbsp;&nbsp;闭" onclick="tabclose()" ><input type="button" value="打&nbsp;&nbsp;印" onclick="tabprint()" ></div>   
    <div id="contain">
    <table class="content" >
       <tbody>
          <tr><td valign="top"><br></td><th align="center" colspan="10" ><strong>普 通 高 等 学 校</strong></th><th rowspan="2" colspan="5" ><img src="${pageContext.request.contextPath}/${student.imgurl }" style="margin-top: 20px;margin-bottom:20px; width: 120px;height:150px;" ></th><td valign="top"><br></td></tr>
          <tr align="center"><td valign="top"><br></td><th colspan="10" ><font size="7" face="隶书" color="#ff0000">毕 业 证 书</font></th><td valign="top"><br></td></tr>
          <tr height="50px" ><td valign="top"><br></td><th align="center" colspan="6" style="font-weight: normal;">${student.firstname }&nbsp;${student.lastname }</th><th align="center" colspan="4" ><s:if test="#student.sex=='男'.toString()"><strong>先生</strong></s:if><s:elseif test="#student.sex=='女'.toString()"><strong>女士</strong>，</s:elseif>，<strong>国籍</strong></th><th align="center" colspan="4" style="font-weight: normal;">${student.nation }</th><td valign="top"><br></td><td valign="top"><br></td></tr>
          <tr align="center" height="50px"><td valign="top">&nbsp;<br></td><td>${year }</td><td><strong>年</strong></td><td>${month }</td><td><strong>月</strong></td><td>${day }</td><td><strong>日生，于</strong></td><td>${startyear }</td><td><strong>年</strong></td><td width="50px">${startmonth }</td><td><strong>月至</strong></td><td>${endyear }</td><td><strong>年</strong></td><td>${endmonth }</td><td valign="top"><br></td><td><strong>月</strong></td><td valign="top">&nbsp; <br></td></tr>
          <tr height="50px"><td valign="top"><br></td><td><strong>在本校</strong></td><th colspan="5" >${student.studentType }</th><td align="center"><strong>专业</strong></td><td>${summaryyear }</td><td align="center"><strong>年制</strong></td><td align="center" >本</td><th colspan="5" >科学习，修完教学计</th><td valign="top"><br></td></tr>
          <tr height="50px"><td valign="top"><br></td><th colspan="14" align="left" >划规定的全部课程，成绩合格，准予毕业。</th><td valign="top"><br></td><td valign="top"><br></td></tr>
          <tr height="100px" ><td valign="top"><br></td><td><br></td><th colspan="3" >校&nbsp;&nbsp;&nbsp;&nbsp;名:</th><th colspan="3" style="font-weight: normal;">天津工业大学</th><th colspan="3" >校（院）长：</th><th colspan="4" ><br></th><td valign="top"><br></td><td valign="top"><br></td></tr>
          <tr><td valign="top"><br></td><th colspan="2" >证书编号：<br><br></th><th colspan="7" ><br></th><td align="center" >2014<strong>年</strong></td><td align="center" width="40px" >6</td><td align="center" width="40px" ><strong>月</strong></td><td align="center" width="40px" >19</td><td valign="top"><br></td><td align="center" width="40px" ><strong>日</strong></td><td valign="top"><br></td></tr>
       </tbody>         
      </table>
    </div>
  </body>
</html>
