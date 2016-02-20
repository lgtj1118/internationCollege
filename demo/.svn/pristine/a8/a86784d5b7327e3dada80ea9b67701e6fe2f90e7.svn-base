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
	var LinksData = {Rows: [
		<%String  s= (String) request.getAttribute("linkslist");%>
		<%=s%>
		 ]};		
	$(f_initGrid);
	var manager, g;
	function f_initGrid() {
		g = manager = $("#maingrid").ligerGrid(
				{
				columns : [{
				display : '序号',
				name : 'id',
				width : 60,
				hide:false,
				type : 'int'
			}, {
				display : '标题',
				name : 'title',
				minWidth : 150,
				editor: { type: 'text'}
			}, {
				display : '链接',
				name : 'linksaddress',
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
					data : LinksData,
					width : '100%'
				});
	}    
	function beginEdit() {
            var row = manager.getSelectedRow();
            if (!row) { alert('请选择一项！'); return; }
            manager.beginEdit(row);
        }
	function cancelEdit(rowid) {
		manager.cancelEdit(rowid);
	}
	function endEdit(rowid) {
	 var row = manager.getSelectedRow();
		manager.endEdit(row);
	$.post("${pageContext.request.contextPath}/system/User_linksupdate.action?links.id="+ row.id
				+"&links.title="+encodeURI(encodeURI(row.title))
				+"&links.linksaddress="+encodeURI(encodeURI(row.linksaddress)),null,function(){
				window.location.reload(); 
				} );
	}
	var m;
    function addlinks(){
	var str = "${pageContext.request.contextPath}/system/User_linksbegainadd.action";
		m=$.ligerDialog.open({
			url : str,
			height : 250,
			width : 400,
			title:'添加链接',
			isResize : true
		});
		
	}
	function deletelinks() {
	var row = manager.getSelectedRow();
		if (!row) {
			alert('请选择一项！');
			return;
		}	
	$.post("${pageContext.request.contextPath}/system/User_linksdelete.action?links.id="
		+ row.id,null,function(){
					 manager.deleteSelectedRow();
				});		
	}	
</script>
	</head>
	<body style="padding: 2px">
	        
			<a class="l-button" style="width:60px;float:left; margin:3px;" onclick="addlinks()">添&nbsp;加</a>			
			<a class="l-button" style="width:60px;float:left; margin:3px;" onclick="deletelinks()">删&nbsp;除</a>
			<a class="l-button" style="width:60px;float:left; margin:3px;" onclick="beginEdit()">修&nbsp;改</a>
			<a class="l-button" style="width:80px;float:left; margin:3px;" onclick="cancelEdit()">取消修改</a>
		    <a class="l-button" style="width:70px;float:left; margin:3px;" onclick="endEdit()">保存</a>
		<div class="l-clear"></div>
		<div id="maingrid" ></div>
	</body>
</html>
