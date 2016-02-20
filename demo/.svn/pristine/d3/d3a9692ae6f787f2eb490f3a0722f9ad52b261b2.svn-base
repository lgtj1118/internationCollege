<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
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
<link href="<%=basePath%>js/ligerUI/skins/Aqua/css/ligerui-all.css"rel="stylesheet" type="text/css" />
<link href="<%=basePath%>js/ligerUI/skins/Gray/css/all.css"rel="stylesheet" type="text/css" />
<script type="text/javascript"src="js/jquery-validation/jquery.validate.min.js" charset="utf-8"></script>
<script type="text/javascript" src="js/json2.js" charset="utf-8"></script>
<script type="text/javascript"src="js/jquery-validation/jquery.metadata.js" charset="utf-8"></script>
<script type="text/javascript" src="js/jquery-validation/messages_cn.js"charset="utf-8"></script>
<script src="js/jquery/jquery-1.3.2.min.js" type="text/javascript"></script>
<script src="js/ligerUI/core/base.js" type="text/javascript"></script>
<script src="js/ligerUI/ligerui.all.js" type="text/javascript"></script>
<script type="text/javascript">
	$(f_initGrid);
	var manager, g;
	function f_initGrid() {
		g = manager = $("#maingrid").ligerGrid(
						{
							columns : [ {
								display : 'ID',
								name : 'id',
								width : 60,
								type : 'int',
								hide : true
							}, {
								display : '编号',
								name : 'num',
								minWidth : 120,
								editor : {
									type : 'text'
								}
							}, {
								display : '名称',
								name : 'roomname',
								minWidth : 120,
								editor : {
									type : 'text'
								}
							}, {
								display : '位置',
								name : 'roomplace',
								minWidth : 140,
								editor : {
									type : 'text'
								}
							}, {
								display : '类型',
								name : 'roomtype',
								minWidth : 120,
								editor : {
									type : 'text'
								}
							}, {
								display : '容量',
								name : 'roomcapacity',
								minWidth : 100,
								editor : {
									type : 'text'
								}
							}, {
								display : '实际容量',
								name : 'realcapacity',
								minWidth : 100,
								editor : {
									type : 'text'
								}
							}, {
								display : '备注',
								name : 'note',
								minWidth : 120,
								editor : {
									type : 'text'
								}
							} ],
							onSelectRow : function(rowdata, rowindex) {
								$("#txtrowindex").val(rowindex);
							},
							//checkbox:true,
							enabledEdit : true,
							clickToEdit : false,
							isScroll : false,
							rownumbers : true,
							pageSize : 30,
							url : '${pageContext.request.contextPath}/system/Manage_semesterroomlist.action',
							width : '100%'
						});
	}
	function f_next(){
	 var str = "${pageContext.request.contextPath}/system/Manage_getSyllabus.action?semChosenCourse.semester="+$("#semester").val();
	 window.location.href=str;
	}
</script>
<style type="text/css">
body {
	font-size: 12px;
}
.l-button{
 font-size: 12px;
}
</style>
</head>
<body style="padding: 2px; ">
    <input id="semester" value="${semester }" type="hidden"  />
	<dir style="float: left; padding-left:0px">
			<table>
				<tr>
					<td colspan="4"><img alt="flow_chat"src="images/flow_chat2.jpg" height="100px"></td>
				</tr>
				<tr>
					<td height="25px"> 					
					      <a class="l-button"style="width:60px;float:left;  margin-left:10px;" onclick="f_next()" >排课</a></td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
			</table>
		</dir>
		<div class="l-clear"></div>
		<div id="maingrid"></div>
</body>
</html>

