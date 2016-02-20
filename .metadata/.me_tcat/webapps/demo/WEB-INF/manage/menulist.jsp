<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
<link href="<%=basePath%>js/ligerUI/skins/Aqua/css/ligerui-all.css" rel="stylesheet"type="text/css" />	
	<link href="<%=basePath %>js/ligerUI/skins/Gray/css/all.css" rel="stylesheet" type="text/css"/>	
    <link href="js/ligerUI/skins/ligerui-icons.css" rel="stylesheet" type="text/css">
	<script src="js/ligerUI/plugins/ligerToolBar.js" type="text/javascript"></script>
    <script type="text/javascript" src="<%=basePath %>js/jquery-validation/jquery.validate.min.js" charset="utf-8"></script>
    <script type="text/javascript" src="<%=basePath %>js/json2.js" charset="utf-8"></script>
    <script type="text/javascript" src="<%=basePath %>js/jquery-validation/jquery.metadata.js" charset="utf-8"></script>
    <script type="text/javascript" src="<%=basePath %>js/jquery-validation/messages_cn.js" charset="utf-8"></script>
    <script type="text/javascript" src="<%=basePath %>js/ligerUI/plugins/ligerTab.js"></script>
    <script type="text/javascript" src="<%=basePath %>js/jquery/jquery-1.3.2.min.js"></script>
	<script src="<%=basePath %>js/ligerUI/core/base.js" type="text/javascript"></script>
	<script src="<%=basePath %>js/ligerUI/ligerui.all.js" type="text/javascript"></script>	
<script type="text/javascript">
var MenuData = {Rows: [
		<%String  s= (String) request.getAttribute("menulist");%>
		<%=s%>
		 ]};	
	var manager;
	$(function(){
		manager = $("#maingrid").ligerGrid({
			columns : [ {
				display : 'ID',
				name : 'id',
				width : 40,
				align : 'center',
				type: 'int',frozen:true
			},{
				display : '导航名',
				name : 'name',
				Width : 200,
				align : 'left',
				editor : {
					type : 'text'
				}
			},{
				display : '英文名',
				name : 'enname',
				Width : 220,
				align : 'center',
				editor : {
					type : 'text'
				}
			},{
				display : '父节点',
				name : 'parentnav',
				Width : 100,
				align : 'center',
				/* editor : {
					type : 'int'
				} */
			}, {
				display : '路径',
				name : 'menuurl',
				Width : 250,
				align : 'center'
				/* editor : {
					type : 'text'
				} */
			} ],
			//width : '100%',
			pageSizeOptions : [ 5, 10, 15, 20 ],
			height : '97%',
			onSelectRow : function(rowdata , rowindex){
				$("#txtrowindex").val(rowindex);
			},
			data : MenuData,
			alternatingRow : false,
			enabledEdit : true,
			clickToEdit : false,
			rownumbers:true,
			tree : {columnName : 'name'},
			checkbox : false,
			autoCheckChildren : false
			/* toolbar: { items: [{ text: '添加',click: addRow,  icon: 'add' },
					                   { text: '修改',click: beginEdit,  icon: 'edit' },
					                   { text: '取消编辑', click: cancelEdit, icon:'save-disabled'},
					                   { text: '删除',click: deleteRow,  icon: 'delete' },
					                   { text: '保存',click: endEdit,  icon: 'save' },
					                   
					                   ]} */
		});
	});
	function deleteRow(){
		var row = manager.getSelectedRow();
		if (!row) {alert('请选择一个菜单节点！');return;}
	    $.ligerDialog.confirm('对应的子菜单节点和角色中对应菜单也将被删除！确认删除吗？', function (yes){
         if(yes){	
	       $.ligerDialog.prompt('请输入确认密码', function (yes, value){
                   if (yes){ //验证密码
                        var userid = ${sessionScope.user.id};
                        $.post("${pageContext.request.contextPath}/system/User_pwdcheck.action?user.id="+ userid
		                +"&user.password="+value , null, function(data) {
					       if (data == "fail") {
						     alert("输入的密码不正确!");						
					       } else {
	                           $.post("${pageContext.request.contextPath}/system/Menu_menudelete.action?menu.id="
				                  + row.id,null,function(){
					                 manager.deleteSelectedRow();
					                 window.location.reload(); 
				               });
		                   }
		                });
		            }
		        });
		     }
		 });
	}	
	function beginEdit() {
            var row = manager.getSelectedRow();
            if (!row) { alert('请选择一个菜单节点！'); return; }
            manager.beginEdit(row);          
        }
	function cancelEdit(rowid) {
		manager.cancelEdit(rowid);
	}
	function endEdit(rowid) {
	 var row = manager.getSelectedRow();
		manager.endEdit(row);
		var reg = /^[\u4e00-\u9fa5]+$/gi;
        if(row.name.length==0||row.enname.length==0){
           alert("导航名称不能为空！");
           cancelEdit(rowid);
           window.location.reload();
        }else{
           if(!reg.test(row.name)){
             alert("导航名称只能为中文");
             cancelEdit(rowid);
             window.location.reload();
           }else{
              var regx = /^[a-zA-Z]{2,}$/;
              if(!regx.test(row.enname)){
                 alert("只能为两个以上的英文字符！");
                 cancelEdit(rowid);
                 window.location.reload();             
              }else{
                 $.post("${pageContext.request.contextPath}/system/Menu_menuupdate.action?menu.id="+ row.id
				+"&menu.namenav="+encodeURI(encodeURI(row.name))
				+"&menu.enname="+encodeURI(encodeURI(row.enname))
				+"&id="+encodeURI(encodeURI(row.parentnav))
				+"&menu.menuurl="+encodeURI(encodeURI(row.menuurl)),null,function(){
				window.location.reload(); 
				} );
              }            
           }
        }
           
	
	}
    var m;
	function addRow(){
		var str = "${pageContext.request.contextPath}/system/Menu_menubeginadd.action";
		m=$.ligerDialog.open({
			url : str,
			height : 350,
			title:'添加菜单节点',
			width : 380,
			isResize : true
		});		
	}
</script>
<style type="text/css">
.l-button {
	width: 120px;
	float: left;
	margin-left: 10px;
	margin-bottom: 2px;
	margin-top: 2px;
}
</style>
</head>
<body style="padding: 4px">
	 <div><strong>注意事项</strong>：<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
	               1. 一级菜单，请勿设置链接路径。<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
2. 菜单添加时，0代表一级菜单。<br><br> 
	    </div> 
	<div>
		<a class="l-button" style="width:60px;float:left; margin:3px;" onclick="deleteRow()">删除</a>
		<a class="l-button" style="width:60px;float:left; margin:3px;" onclick="addRow()">添加</a> 
		<a class="l-button" style="width:60px;float:left; margin:3px;" onclick="beginEdit()">修&nbsp;改</a>
		<a class="l-button" style="width:80px;float:left; margin:3px;" onclick="cancelEdit()">取消修改</a>
	    <a class="l-button" style="width:70px;float:left; margin:3px;" onclick="endEdit()">保存</a>	
		<div class="l-clear"></div>
	</div>
	<div id="maingrid"></div>
</body>
</html>


