<%@page import="com.opensymphony.xwork2.ActionContext"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
	<base href="<%=basePath%>">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>班级列表</title>
	<link href="<%=basePath%>js/ligerUI/skins/Aqua/css/ligerui-all.css" rel="stylesheet"type="text/css" />	
	<link href="<%=basePath %>js/ligerUI/skins/Gray/css/all.css" rel="stylesheet" type="text/css"/>	
     <link href="js/ligerUI/skins/ligerui-icons.css" rel="stylesheet" type="text/css">
    <script type="text/javascript" src="js/jquery-validation/jquery.validate.min.js" charset="utf-8"></script>
    <script type="text/javascript" src="js/json2.js" charset="utf-8"></script>
    <!-- <script type="text/javascript" src="js/jquery-validation/jquery.metadata.js" charset="utf-8"></script>
    <script type="text/javascript" src="js/jquery-validation/messages_cn.js" charset="utf-8"></script> -->
    <script src="js/jquery/jquery-1.3.2.min.js"type="text/javascript"></script>
	<script src="js/ligerUI/core/base.js" type="text/javascript"></script>
	<script src="js/ligerUI/ligerui.all.js" type="text/javascript"></script>
	<script src="js/ligerUI/plugins/ligerToolBar.js" type="text/javascript"></script>
	
<script type="text/javascript">
		
	$(f_initGrid);
	var manager, g;
	function f_initGrid() {
		g = manager = $("#maingrid").ligerGrid(
				{
				columns : [{
				display : '出错行',
				name : 'line',
				minWidth : 300,
				editor: { type: 'text'}
			}, {
				display : '错误原因',
				name : 'reason',
				minWidth : 150,
				editor: { type: 'text'}
			} ],
					onSelectRow : function(rowdata, rowindex) {
						$("#txtrowindex").val(rowindex);
					},
					enabledEdit : false,
					clickToEdit : false,
					isScroll : true,
			         rownumbers:true,
			         pageSize:30,
					//data : ClassData,
					url: "${pageContext.request.contextPath}/system/Class_batchAddCourses.action",
					width : '100%',
				});
	}
	
	parent.g.loadData();
</script>
<style type="text/css">
.links{
 cursor: pointer;
}
.links:hover{
  color: red;
}
</style>
	</head>
	<body style="padding: 2px">
	        
		<table style="margin: 20px; font-size:14px;">
			<% 
				String count = (String)ActionContext.getContext().get("succeed");
				
				String msg = (String)ActionContext.getContext().get("msg");
			
			 %>
			<tr>
				<td>成功添加<%=count %>条记录</td>
				<td><%=msg %></td>
			</tr>
		</table>
		<div class="l-clear"></div>
		<div id="maingrid" ></div>
	</body>
</html>
