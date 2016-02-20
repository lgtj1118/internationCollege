<%@page import="org.springframework.web.context.request.SessionScope"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">   
    <title></title>	   
	<link href="<%=basePath%>js/ligerUI/skins/Aqua/css/ligerui-all.css" rel="stylesheet"type="text/css" />	
	<link href="<%=basePath %>js/ligerUI/skins/Gray/css/all.css" rel="stylesheet" type="text/css"/>	
    <script type="text/javascript" src="js/jquery-validation/jquery.validate.min.js" charset="utf-8"></script>
    <script type="text/javascript" src="js/json2.js" charset="utf-8"></script>
    <script type="text/javascript" src="js/jquery-validation/jquery.metadata.js" charset="utf-8"></script>
    <script type="text/javascript" src="js/jquery-validation/messages_cn.js" charset="utf-8"></script>
    <script src="js/jquery/jquery-1.3.2.min.js"type="text/javascript"></script>
	<script src="js/ligerUI/core/base.js" type="text/javascript"></script>
	<script src="js/ligerUI/ligerui.all.js" type="text/javascript"></script>
<script type="text/javascript">  
	$(f_initGrid);
	var manager, g;
	function f_initGrid() {
		g = manager = $("#maingrid").ligerGrid({
			columns : [{
				display : '教师编号',
				name : 'identificationnum',
				minWidth : 120,
				editor: { type: 'text'}
			} , {
				display : '教师姓名',
				name : 'teachername',
				minWidth : 120,
				editor: { type: 'text'}
			}, {
				display : '管理班级',
				name : 'telephone',
				minWidth : 120,
				editor: { type: 'text'}
			} ],
					onSelectRow : function(rowdata, rowindex) {
						$("#txtrowindex").val(rowindex);
					},
					enabledEdit : true,
					clickToEdit : false,
					isScroll : false,
					checkbox:false,
			        rownumbers:true,
					url :'${pageContext.request.contextPath}/system/Manage_classteacherevalutionmap.action',
					width : '100%'
				});
	}
	var m;
    function loadevalution(){
      var row = manager.getSelectedRow();
      var str = "${pageContext.request.contextPath}/system/Manage_loadclassteacherevalution.action?evalution.teacher="+row.identificationnum;
	  top.f_addTab('loadevalution',row.teachername+'教师评价',str);
	}
	function evalutionanalysis(){
      var row = manager.getSelectedRow();
	  var str = "${pageContext.request.contextPath}/system/Manage_classteacherevalutionanalysis.action";
	  top.f_addTab('evalutionanalysis','班主任评价分析',str);
	}
</script>
	</head>
	<body style="padding: 2px">		
		<a class="l-button" title="评价详情及分析" style="width:60px;float:left; margin:3px;" onclick="loadevalution()">查&nbsp;&nbsp;看</a>			
		<a class="l-button" style="width:60px;float:left; margin:3px;" onclick="evalutionanalysis()">统计分析</a>
		<div class="l-clear"></div>
		<div id="maingrid" ></div>
	</body>
</html>
