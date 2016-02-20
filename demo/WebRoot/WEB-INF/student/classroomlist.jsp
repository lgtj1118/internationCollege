<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
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
    <link href="js/ligerUI/skins/ligerui-icons.css" rel="stylesheet" type="text/css">
	<script src="js/ligerUI/plugins/ligerToolBar.js" type="text/javascript"></script>
    <script type="text/javascript" src="js/jquery-validation/jquery.validate.min.js" charset="utf-8"></script>
    <script type="text/javascript" src="js/json2.js" charset="utf-8"></script>
    <script type="text/javascript" src="js/jquery-validation/jquery.metadata.js" charset="utf-8"></script>
    <script type="text/javascript" src="js/jquery-validation/messages_cn.js" charset="utf-8"></script>
    <script src="js/jquery/jquery-1.3.2.min.js"type="text/javascript"></script>
	<script src="js/ligerUI/core/base.js" type="text/javascript"></script>
	<script src="js/ligerUI/ligerui.all.js" type="text/javascript"></script>
<script type="text/javascript">
   var TypeData = [{ isavaible: 0, text: '可用' }, { isavaible: 1, text: '非上课使用'}, { isavaible: 2, text: '维修'}];
   $(f_initGrid);
	var manager, g;
	function f_initGrid() {
		g = manager = $("#maingrid").ligerGrid(
			{columns : [
			/* {   display : 'ID',  name : 'id',     width : 60,  type : 'int',hide:true
			},  */{display : '编号', name : 'num',  minWidth : 120, editor: { type: 'text'}
			}, {display : '名称', name : 'roomname',  minWidth : 120, editor: { type: 'text'}
			} ,{display : '位置', name : 'roomplace',minWidth : 140,editor: { type: 'text'}
			}, {display : '类型', name : 'roomtype',minWidth : 120, editor: { type: 'text'}
			}, {display : '容量', name : 'roomcapacity',minWidth : 100, editor: { type: 'text'}
			}, {display : '实际容量', name : 'realcapacity',minWidth : 100, editor: { type: 'text'}			
			}, {display : '状态', name : 'isavaible',minWidth : 100,editor: { type: 'select', data: TypeData, valueField: 'isavaible' },
                    render: function (item)
                    {
                        if (parseInt(item.isavaible) == 0){ return "可用";}
                        else if (parseInt(item.isavaible) == 1) { return "<font style='color:red'>不可用</font>";}
                        else if (parseInt(item.isavaible) == 2) { return "<font style='color:blue'>维修</font>";}                       
                    }		
			},{display : '是否删除', name : 'deleted',minWidth : 100,
                    render: function (item)
                    {
                        if (parseInt(item.deleted) == 0){ return "否";}
                        else if (parseInt(item.deleted) == 1) { return "<font style='color:red'>是</font>";}                     
                    }		
			}, {display : '备注', name : 'note',minWidth : 120, editor: { type: 'text'}
			} ],
					onSelectRow : function(rowdata, rowindex) {
						$("#txtrowindex").val(rowindex);
					},
					//checkbox:true,
					enabledEdit : true,
					clickToEdit : false,
					isScroll : false,
					rownumbers:true, 
					pageSize:30,
					url :'${pageContext.request.contextPath}/system/Class_roomlist.action',
					width : '100%'
					/* toolbar: { items: [{ text: '添加',click: addrow,  icon: 'add' },
					                   { text: '修改',click: beginEdit,  icon: 'edit' },
					                   { text: '删除',click: deleterow,  icon: 'delete' },
					                   { text: '重置',click: f_recovery,  icon: 'save' },
					                   { text: '批量添加', click: addbatchrow, icon:'add'}
					                   ]} */
				});
	}
	var m;
	function beginEdit() {
      var row = manager.getSelectedRow();
      if (!row) { alert('请选择一个教室！'); return; }
      var str = "${pageContext.request.contextPath}/system/Class_roomedit.action?room.num="+ row.num
	  m=$.ligerDialog.open({
			url : str,
			height : 450,
			width : 450,
			isDrag:true,
			title:'更新教室',
			showMax:true,
			showToggle:true,
			slide: false,			
			modal:false,
			left:200,
			allowClose:true,
		    isResize : false
		});			
	}

	function deleterow() {
	  var row = manager.getSelectedRow();
		if (!row) {alert('请选择一个教室！');return;}
		$.ligerDialog.confirm("是否删除？第一次删除将会使该教室处于删除状态。如果没有与本学期课表相关，第二次将彻底删除，否则不做任何操作。", function (yes){
          if(yes){		  
               $.ligerDialog.prompt('请输入确认密码', function (yes, value){
                   if (yes){ //验证密码
                        var userid = ${sessionScope.user.id};
                        $.post("${pageContext.request.contextPath}/system/User_pwdcheck.action?user.id="+ userid
		                +"&user.password="+value , null, function(data) {
					       if (data == "fail") {
						     alert("输入的密码不正确!");						
					       } else {
                             $.post("${pageContext.request.contextPath}/system/Class_roomdelete.action?room.num="+ row.num);
			                 manager.deleteSelectedRow();	
			                 window.location.reload();
			                 //g.loadData();
                           }
                       });
                   }
              });
         }
       });
	}	 
	var m;
	function addrow(){	
	var str = "${pageContext.request.contextPath}/system/Class_roombeginadd.action";
		m=$.ligerDialog.open({
			url : str,
			height : 450,
			width : 450,
			isDrag:true,
			title:'添加教室',
			showMax:true,
			showToggle:true,
			slide: false,			
			modal:false,
			left:200,
			allowClose:true,
		    isResize : false
		});			
	}
	function addbatchrow(){
	var str = "${pageContext.request.contextPath}/system/Class_roombatchadd.action";
		m=$.ligerDialog.open({
			url : str,
			height : 500,
			width : 800,
			isResize : true
		});
		
	}
	function f_recovery(){
	  var row = g.getSelectedRow();
	  if(!row){alert("请先选择一间教室");return;}
	  if(row.deleted==1){
	    $.post("${pageContext.request.contextPath}/system/Class_roomrecovery.action?room.num="+row.num,null,function(){
	     window.location.reload();
	    });
	  }	  
	}
</script>
	</head>
	<body style="padding: 2px">
	<s:if test="#session.user.roles.rolerank==0||#session.user.roles.rolerank==1">
	   <a class="l-button" style="width:70px;float:left; margin:3px;" onclick="addrow()">添&nbsp;&nbsp;加</a>
	   <a class="l-button" style="width:70px;float:left; margin:3px;" onclick="addbatchrow()">批量添加</a>       
	   <a class="l-button" style="width:70px;float:left; margin:3px;" onclick="deleterow()">删&nbsp;&nbsp;除</a>
	   <a class="l-button" style="width:70px;float:left; margin:3px;" onclick="f_recovery()">重&nbsp;&nbsp;置</a>
	   <a class="l-button" style="width:70px;float:left; margin:3px;" onclick="beginEdit()">修&nbsp;&nbsp;改</a>	   	   
	</s:if>
	<s:else></s:else>
		<div class="l-clear"></div>
		<div id="maingrid" ></div>
	</body>
</html>

