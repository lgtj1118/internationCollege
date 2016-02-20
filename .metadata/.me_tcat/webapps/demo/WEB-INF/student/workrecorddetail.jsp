<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>天津工业大学排课管理系统</title>
<link href="<%=basePath%>js/ligerUI/skins/Gray/css/form.css" rel="stylesheet"type="text/css" />
<link href="<%=basePath%>js/ligerUI/skins/Gray/css/common.css" rel="stylesheet"type="text/css" />
<script src="<%=basePath%>js/jquery/jquery-1.6.min.js" type="text/javascript"></script>
<script src="<%=basePath%>js/ligerUI/core/base.js" type="text/javascript"></script>
<script src="<%=basePath%>js/ligerUI/plugins/ligerForm.js" type="text/javascript"></script>
<script src="<%=basePath%>js/ligerUI/plugins/ligerDateEditor.js" type="text/javascript"></script>
<script src="<%=basePath%>js/ligerUI/plugins/ligerComboBox.js" type="text/javascript"></script>
<script src="<%=basePath%>js/ligerUI/plugins/ligerSpinner.js" type="text/javascript"></script>
<script src="<%=basePath%>js/ligerUI/plugins/ligerTextBox.js" type="text/javascript"></script>
<%-- <script src="<%=basePath%>js/ligerUI/plugins/ligerRadio.js" type="text/javascript"></script> --%>
<script src="<%=basePath%>js/ligerUI/plugins/ligerTip.js" type="text/javascript"></script>
<script src="<%=basePath%>js/jquery-validation/jquery.validate.min.js"type="text/javascript"></script>
<script src="<%=basePath%>js/jquery-validation/jquery.metadata.js" type="text/javascript"></script>
<script src="<%=basePath%>js/jquery-validation/messages_cn.js" type="text/javascript"></script>
<script type="text/javascript">
  function tabclose(){
   top.f_closeTab();
  }
</script>
<style type="text/css">
body{ font-size:12px;}
.l-table-edit {}
.l-table-edit-td{ padding:4px;}
.l-button-submit,.l-button-test{width:80px; float:left; margin-left:10px; padding-bottom:2px;}
.l-verify-tip{ left:230px; top:120px;}
#errorLabelContainer{ padding:10px; width:300px; border:1px solid #FF4466; display:none; background:#FFEEEE; color:Red;}
#contain{
 margin:auto;
 width:80%;
 margin-top: 30px;
}
table{
  text-align: right;
  width:80%;
  margin:auto;
  height:450px;
 /*  border: 1px solid #3c3c3c; */
}
table td{
  border: 1px solid #c6c6c6 ;
}
table th{
 border: 1px solid #c6c6c6 ;
 text-align: center;
}
.l-table-edit-td{
 height: 50px;
}

</style>

</head>

<body style="padding: 10px">
<div id="contain">
<div align="center"><strong><font size="3">班主任工作记录表</font></strong>	</div><br/>
		<div id="errorLabelContainer" class="l-text-invalid"></div>
		<table cellpadding="0" cellspacing="0" class="l-table-edit">
			<tr>
				<td align="center" class="l-table-edit-td" style="width:80px;" >班主任姓名</td>
				<td align="center" class="l-table-edit-td">${sessionScope.user.realname }</td>
				<td align="center" class="l-table-edit-td" style="width: 80px;" >负责班级</td>
				<td align="center" class="l-table-edit-td">
				<s:iterator value="#teacherc" id="c" >
				   <s:if test="#c.id==#workrecord.classid">
				      <s:property value="#c.classname"  />
				   </s:if>
				     </s:iterator>
				</td>
				<td align="center" class="l-table-edit-td" style="width: 80px;" >班长姓名</td>
				<td align="center" class="l-table-edit-td">${student.stuname }</td>			
			</tr>
			<tr>
				<td class="l-table-edit-td" align="center">本月班会次数</td>
				<td align="center" class="l-table-edit-td">${workrecord.classmeetingfrequency }</td>
				<td align="center" class="l-table-edit-td">本月约谈人数</td>
				<td align="center" class="l-table-edit-td">${workrecord.appointmentnumber }</td>
				<td align="center" class="l-table-edit-td">自我工作评价</td>
				<td align="left" class="l-table-edit-td">
				 <s:if test="#workrecord.selfevalution==0"> 优秀</s:if>
				 <s:elseif test="#workrecord.selfevalution==1">良</s:elseif>
				 <s:elseif test="#workrecord.selfevalution==2">中等</s:elseif>
				 <s:elseif test="#workrecord.selfevalution==3">不好</s:elseif>				    
				</td>			
			</tr>
			<tr>
			  <td align="center">学生身心情况</td>
			  <th colspan="6">${workrecord.physicalmentalcondition }</th>
			</tr>
			<tr>
			  <td align="center">学生上课情况</td>
			  <th colspan="6">${workrecord.studyingcondition }</th>
			</tr>
			<tr>
			  <td style="width:100px;" align="center">学生反映的课程、老师、学院问题</td>
			  <th colspan="6">${workrecord.feedback }</th>
			</tr>						 									
		</table>
		<div style="float: right; margin-right: 100px;margin-top: 30px;"  ><font size="3">日期：</font>${workrecord.date } </div>
		<br />
        <div style="float: center;margin-top:50px;margin-left: 50%;" ><button onclick="tabclose()" style="margin:auto; width: 70px;"  >关&nbsp;&nbsp;闭</button></div>
</div>
</body>
</html>