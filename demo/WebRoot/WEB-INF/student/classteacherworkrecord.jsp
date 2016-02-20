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
                { display: '主键', name: 'id', width: 50, type: 'int',hide:true },
                { display: '日期', name: 'date',minWidth: 80,editor: { type: 'text' } },
                { display: '班级', name: 'classname',minWidth: 100},
                { display: '本月班会次数', name: 'classmeetingfrequency',minWidth: 100},
                { display: '本月约谈人数', name: 'appointmentnumber',minWidth: 100},
                { display: '操作', isSort: false, minWidth: 200, render: function (rowdata, rowindex, value)
                {
                    var h = "";
                    h += "<a href='javascript:detail(" + rowindex + ")'>详情  </a> ";
                    h += "<a href='javascript:edit(" + rowindex + ")'>  修改 </a> ";
                    h +=" ";
                    h += "<a href='javascript:deleteRow(" + rowindex + ")'> 删除 </a> ";
                    return h;
                }
                }
                ],
                onSelectRow: function (rowdata, rowindex)
                {
                    $("#txtrowindex").val(rowindex);
                },
                enabledEdit: true,clickToEdit:false, isScroll: false,
                url:'system/Class_workrecordlist.action',
                rownumbers:true,
                pageSize:20,
                width: '100%'
               
            });   
        }
        
        function detail(rowid){
        	var row = manager.getSelectedRow();
        	location.href = "${pageContext.request.contextPath}/system/Class_workrecorddetail.action?classrecord.id="+row.id;       	
        }
        var m;
        function edit(rowid){
        	var row = manager.getSelectedRow();
        	location.href = "${pageContext.request.contextPath}/system/Class_workrecordedit.action?classrecord.id="+row.id;       	
           /*  m=$.ligerDialog.open({
			url : str,
			height : 450,
			width : 600,
			isDrag:true,
			showMax:true,
			showToggle:true,
			slide: false,			
			modal:false,
			left:200,
			title:'班主任工作记录更新',
			allowClose:true,
		    isResize : false
		}); */
        }
        function deleteRow(rowid)
        {
            if (confirm('确定删除?'))
            {
               var did = manager.getRow(rowid).id;
                if(did!=null){
                	$.post('system/Class_workrecorddelete.action',{ids:did},function(){	               	                
	                manager.deleteRow(rowid);	                	                
	                });
                }                
            }
        }
        function addrow(){
        if(${user.roles.rolerank==2}){
          location.href = "${pageContext.request.contextPath}/system/Class_workrecordbegainadd.action";                
        }else{
          alert("只有班主任能添加工作记录！");
        }
        }
</script>
	</head>
	<body style="padding: 2px">
	<br> <a class="l-button" style="width:120px;float:left; margin:10px;" onclick="addrow()">添加工作记录</a>       
	 	<div class="l-clear"></div>
		<div id="maingrid" ></div>
	</body>
</html>

