<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
	<meta http-equiv="description" content="天津工业大学排课管理系统">
<script language="javascript" type="text/javascript"> 
	var i = 5;
	var intervalid;
	intervalid = setInterval("fun()", 1000);
	function fun(){
		if (i == 0) {
			//window.location.href = "../index.html";
			document.getElementById("read").disabled=false;
			document.getElementById("mes").style.display="none";
			clearInterval(intervalid);
		}
		document.getElementById("mes").innerHTML = i;
		i--;
	}
	function leavemanage(){
	 window.location.href="${pageContext.request.contextPath}/system/Manage_leavemanage.action";
	}//onload="fun()"
</script> 
  
  </head> 
  <body >
    <div id="contain" style="width: 80%;">
      <h2 align="center"><font face="微软雅黑">天津工业大学国际教育学院请假管理条例</font></h2>
      <p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font face="微软雅黑">&nbsp;一、学生因生病或其它原因无法进行正常上课时，务必办理请假手续。学生请假手续由学院教学办211办公室统一管理。学生需要请假先到学院401教室领取请假表，并填写表格中的相关内容，填完后将表格提交给401教室值班人。</font></p> 
      <p><font face="微软雅黑">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;二、短期请假：请假时间少于3个工作日（含3日）由班主任签字，到学院教学办211办公室负责人审批后方可。学生需将请假批准单出示给任课老师；无法及时到401室办理请假手续者，须补办，并在上课之前告知任课老师。</font></p>
      <p><font face="微软雅黑">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;三、长期请假：请假时间多于4个工作日（含4日）由主管教学院长审核批准后方可离校。学生一学期请假时间最长不得超过22个工作日，如超过22个工作日到401室办理休学手续。</font></p>
      <p><font face="微软雅黑">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;四、学生因事请假务必提前两天到学院401室办理请假手续；特殊情况特殊处理。</font></p>
      <p><font face="微软雅黑">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;五、学生在请假期满后，须及时返校学习，并到401室销假。</font></p>
      <p><font face="微软雅黑">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;六、未经请假或请假未经批准而缺席者，视为旷课。</font></p>
      <p><font face="微软雅黑">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;七、如请假外出，应保证在外出活动期间不可参加任何违反学校规定以及违法的活动，外出期间请注意安全，如果发生安全事故，责任由外出人员自负。</font></p>
      <div align="right"><font face="微软雅黑"><span style="margin-right: 100px;">天津工业大学</span></font> 
      </div><p style="margin-right: 100px;" align="right"><font face="微软雅黑">国际教育学院</font></p><div align="right"> 
      </div><p style="margin-right: 100px;" align="right"><font face="微软雅黑">2015年1月26日</font></p>
      <div align="center"><button id="read" type="button"  onclick="leavemanage()"><!-- <span id="mes">5</span> -->知道了</button></div>
    </div>
  </body>
</html>
