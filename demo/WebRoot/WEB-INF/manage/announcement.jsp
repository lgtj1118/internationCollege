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
        function f_initGrid()
        {
            g = manager = $("#maingrid").ligerGrid({
                columns: [
                { display: '主键', name: 'id', width: 50, type: 'int', /* frozen: true, */hide:true },
                { display: '标题', name: 'title',minWidth: 80,
                    editor: { type: 'text' }
                },
                { display: '创建时间', name: 'createdtime',Width: 100
                },
                { display: '操作', isSort: false, minWidth: 200, render: function (rowdata, rowindex, value)
                {
                    var h = "";
                    h += "<a href='javascript:edit(" + rowindex + ")'>修改</a> ";
                    h +=" ";
                    h += "<a href='javascript:deleteRow(" + rowindex + ")'>删除</a> ";
                    return h;
                }
                }
                ],
                onSelectRow: function (rowdata, rowindex)
                {
                    $("#txtrowindex").val(rowindex);
                },
                enabledEdit: true,clickToEdit:false, isScroll: false,
                url:'system/Manage_announcementlist.action',
                pageSize:20,
                rownumbers:true,
                width: '100%'
               
            });   
        }
        function edit(rowid){
        	var row = manager.getSelectedRow();
        	var str = "${pageContext.request.contextPath}/system/Manage_announcementedit.action?announcement.id="+row.id;
        	m=$.ligerDialog.open({
			url : str,
			height : 550,
			width : 800,
			isDrag:true,
			title:'更新公告',
			showMax:true,
			showToggle:true,
			slide: false,			
			modal:false,
			allowClose:true,
		    isResize : false
		});
        }
        function deleteRow(rowid)
        {
            if (confirm('确定删除?'))
            {
               var did = manager.getRow(rowid).id;
                if(did!=null){
                	$.post('system/Manage_announcementdelete.action',{ids:did},function(){	               	                
	                manager.deleteRow(rowid);	                	                
	                });
                }                
            }
        }
        function addrow(){
        var str = "${pageContext.request.contextPath}/system/Manage_announcementbegainadd.action";
        m=$.ligerDialog.open({
			url : str,
			height : 550,
			width : 800,
			isDrag:true,
			title:'添加公告',
			showMax:true,
			showToggle:true,
			slide: false,			
			modal:false,
			allowClose:true,
		    isResize : false
		});
        }
</script>
	</head>
	<body style="padding: 2px">
	<br> <a class="l-button" style="width:120px;float:left; margin:10px;" onclick="addrow()">添加新公告</a>       
	 	<div class="l-clear"></div>
		<div id="maingrid" ></div>
	</body>
</html>

