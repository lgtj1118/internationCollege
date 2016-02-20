<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>班级列表</title>
	<link href="<%=basePath%>js/ligerUI/skins/Aqua/css/ligerui-all.css" rel="stylesheet"type="text/css" />	
	<link href="<%=basePath %>js/ligerUI/skins/Gray/css/all.css" rel="stylesheet" type="text/css"/>	
    <script type="text/javascript" src="<%=basePath %>js/jquery-validation/jquery.validate.min.js" charset="utf-8"></script>
    <script type="text/javascript" src="<%=basePath %>js/json2.js" charset="utf-8"></script>
    <script type="text/javascript" src="<%=basePath %>js/jquery-validation/jquery.metadata.js" charset="utf-8"></script>
    <script type="text/javascript" src="<%=basePath %>js/jquery-validation/messages_cn.js" charset="utf-8"></script>
    <script type="text/javascript" src="<%=basePath %>js/ligerUI/plugins/ligerTab.js"></script>
    <script type="text/javascript" src="<%=basePath %>js/jquery/jquery-1.3.2.min.js"></script>
	<script src="<%=basePath %>js/ligerUI/core/base.js" type="text/javascript"></script>
	<script src="<%=basePath %>js/ligerUI/ligerui.all.js" type="text/javascript"></script>	
	<script type="text/javascript">
	var ClassData = {Rows: [
		<%String  s= (String) request.getAttribute("classlist");%>
		<%=s%>
		 ]};		
	$(f_initGrid);
	var manager, g;
	function f_initGrid() {
		g = manager = $("#maingrid").ligerGrid(
				{
				columns : [{
				display : 'ID',
				name : 'Classid',
				width : 60,
				hide:true,
				type : 'int'
			}, {
				display : '班级名称',
				name : 'Classname',
				minWidth : 150,
				editor: { type: 'text'}
			}, {
				display : '班级专业',
				name : 'Classmajor',
				minWidth : 150,
				editor: { type: 'text'}
			}],
					onSelectRow : function(rowdata, rowindex) {
						$("#txtrowindex").val(rowindex);
					},
					enabledEdit : true,
					clickToEdit : false,
					isScroll : false,
			        rownumbers:true,
			        pageSize:30,
			        checkbox:true,
					data : ClassData,
					width : '100%'
				});
	}
	function addclass() {
	var row = manager.getSelectedRow();
		if (!row) {
			alert('请至少选定一个班级！');
			return;
		}
		var rows = g.getCheckedRows();
        var str = "";
        $(rows).each(function(){
           str += this.Classid +",";
        });
        $.post("${pageContext.request.contextPath}/system/Manage_semestercourseclassset.action?ids="+ str+"&semChosenCourse.id="+$("#semestercourseid").val(),null,function(){
           //alert("选定成功！");
           parent.m.hide();
           parent.g.loadData();
        });

	}	 
</script>
	</head>
	<body style="padding: 2px">
	        <input id="semestercourseid" value="${semestercourseid }" type="hidden" />
			<a class="l-button" style="width:60px;float:left; margin:3px;" onclick="addclass()">选&nbsp;&nbsp;定</a>			
		<div class="l-clear"></div>
		<div id="maingrid" ></div>
	</body>
</html>
