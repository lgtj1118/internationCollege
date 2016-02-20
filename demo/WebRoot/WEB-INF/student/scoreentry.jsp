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
			},{
					display : '操作',
					isSort : false,
					width : 120,
					render : function() {
						var h = "";
						h += "<a style='color:#000;' href='javascript:courseclassscoreentry("+ ")'>录入成绩</a> ";
						return h;
					}
			} ],
					onSelectRow : function(rowdata, rowindex) {
						$("#txtrowindex").val(rowindex);
					},
					enabledEdit : true,
					clickToEdit : false,
					isScroll : false,
			         rownumbers:true,
			         pageSize:30,
					data : ClassData,
					width : '100%'
				});
	}
    function courseclassscoreentry(){
     var row = manager.getSelectedRow();
	 	if (!row) {
			alert('请选择班级！');
			return;
		}
	var semester = $("#semester").val();
	var coursenum = $("#coursenum").val();
    var str = "${pageContext.request.contextPath}/system/Manage_courseclassscoreadd.action?cls.id="+row.Classid+"&semChosenCourse.semester="+semester+"&course.num="+coursenum+"&flag="+$("#flag").val();
    window.location.href=str;
		
}
	
</script>
	</head>
	<body style="padding: 2px">
        <br/>
        <input id="semester" value="${semester }" type="hidden" />
        <input id="coursenum" value="${coursenum }" type="hidden"/>
        <input id="flag" value="${flag }" type="hidden"/>
		<div class="l-clear"></div>
		<div id="maingrid" ></div>
	</body>
</html>