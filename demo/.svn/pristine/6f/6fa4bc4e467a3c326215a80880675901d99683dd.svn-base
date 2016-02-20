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
<link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
<link href="<%=basePath%>js/ligerUI/skins/Gray/css/form.css" rel="stylesheet"type="text/css" />
<link href="<%=basePath%>js/ligerUI/skins/Gray/css/common.css" rel="stylesheet"type="text/css" /> 
<link href="<%=basePath%>css/date.css" rel="stylesheet" type="text/css"/>
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
<script src="<%=basePath%>js/jquery.date_input.pack.js" type="text/javascript"></script>
<link rel="stylesheet" href="/resources/demos/style.css">
<script type="text/javascript">
	function btnclose() {
		parent.window.location.reload();
		window.close();
	}
	
	$(function(){
	  $('#oldDate').date_input();
   });
   
  $(function(){
	  $('#newDate').date_input();
   });
	
	function tonsubmit() {
		var reason = $("#reason").val();
		//alert(reason);
		//var newnum = $("#options").val();
		var newnum = $("#options").val();
		var old = $("#oldnum").val();
		var oldDate = $("#oldDate").val();
		alert(oldDate);
		var newDate = $("newDate").val();
		//alert("test");
		/* var str = "${pageContext.request.contextPath}/system/Manage_applyCurrAdjustment.action?newnum="
				+ newnum + "&oldnum=" + old + "&adjustReason=" + encodeURI(encodeURI(reason)) + "&oldDate=" + oldDate
				+ "&newDate=" + newDate;
		$.post(str, null, function() {
			parent.m.hide();
			parent.window.location.href="${pageContext.request.contextPath}/system/Manage_changecourse.action";
		}); */
	}
</script>
</head>

<body>
	<input type="hidden"
		value=<%=(String) ActionContext.getContext().get("old")%> id="oldnum">
	<table align="center">
		<%
			List<Syllabus> options = (List<Syllabus>) ActionContext
					.getContext().get("options");
			boolean isfirst = true;
			String number[] = new String[] { "一", "二", "三", "四", "五", "六" };
		%>
		<tr>
					<td align="center">可调换课程或位置
			</td>
			<td height="50px"><select id="options">
					<%
						for (Syllabus s : options) {
							if (isfirst) {
								isfirst = false;
					%>
					<option value=<%=s.getNum()%> selected="selected"><%=new String().format("周%s 第%s大节  %s",
							number[s.getDay()], number[s.getSlot()],
							s.getCourseName())%></option>
					<%
						} else {
					%>
					<option value=<%=s.getNum()%>><%=new String().format("周%s 第%s大节  %s",
							number[s.getDay()], number[s.getSlot()],
							s.getCourseName())%></option>
					<%
						}
						}
					%>
			</select></td>
		</tr>
		<tr>
			<td align="center" class="l-table-edit-td">调课原因:</td>
			<td align="left" class="l-table-edit-td">
			<textarea id="reason" style="width:216px; height:126px"></textarea>
			</td>
		</tr>
		<tr>
			<td>原课程日期：</td>
			<td><input type="text" id="oldDate"></td>
		</tr>
		<tr>
			<td>调换课程日期：</td>
			<td><input type="text" id="newDate"></td>
		</tr>
		<tr>
			<td align="center"><input type="button" onclick="tonsubmit()"
				value="确认" />
			</td>
		</tr>
	</table>

</body>
</html>
