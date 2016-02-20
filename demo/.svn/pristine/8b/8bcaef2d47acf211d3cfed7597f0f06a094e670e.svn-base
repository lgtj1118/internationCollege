<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<base href="<%=basePath%>">
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>班级列表</title>
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
	var JusticelData = {Rows: [
		<%String  s= (String) request.getAttribute("justicellist");%>
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
				hide:true,
				type : 'int'
			}, {
				display : '文件标题',
				name : 'title',
				minWidth : 150,
				editor: { type: 'text'}
			}, {
				display : '创建时间',
				name : 'createdtime',
				minWidth : 150,
				editor: { type: 'text'}
			},{ display: '操作', isSort: false, width: 100, render: function (rowdata, rowindex, value)
                {
                    var h = "";
                  //  h += "<a href='javascript:edit(" + rowindex + ")'>修改</a> ";
                  //  h +=" ";
                    h += "<a href='javascript:deleteRow(" + rowindex + ")'>删除</a> ";
                    return h;
                }
                }],
					onSelectRow : function(rowdata, rowindex) {
						$("#txtrowindex").val(rowindex);
					},
					enabledEdit : true,
					clickToEdit : false,
					isScroll : false,
			         rownumbers:true,
			         pageSize:30,
					//data : JusticelData,
					url:'${pageContext.request.contextPath}/system/Manage_justicellist.action',
					width : '100%',
					toolbar: { items: [{ text: '添加',click: addrow,  icon: 'add' } ]}
				});
	}
    function edit(rowid){
        	var row = manager.getSelectedRow();
        	var str = "${pageContext.request.contextPath}/system/Manage_justiceledit.action?certify.id="+row.id;
        	m=$.ligerDialog.open({
			url : str,
			height : 300,
			width : 400,
			isDrag:true,
			title:'更新文件',
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
                	$.post("${pageContext.request.contextPath}/system/Manage_justiceldelete.action?ids="+did,function(){	               	                
	                manager.deleteRow(rowid);	                	                
	                });
                }                
            }
        }
        function addrow(){
        var str = "${pageContext.request.contextPath}/system/Manage_justicelbegainadd.action";
        m=$.ligerDialog.open({
			url : str,
			height : 300,
			width : 450,
			isDrag:true,
			title:'上传文件',
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
			<!-- <a class="l-button" style="width:60px;float:left; margin:3px;" onclick="addrow()">添&nbsp;加</a> -->
			
		<div class="l-clear"></div>
		<div id="maingrid" ></div>
	</body>
</html>
