<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title></title>
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
	var TeacherData = {Rows: [
		<%String  s= (String) request.getAttribute("teacherlist");%>
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
				display : '编号',
				name : 'identificationnum',
				minWidth : 150,
				editor: { type: 'text'}
			}, {
				display : '姓名',
				name : 'teachername',
				minWidth : 150,
				editor: { type: 'text'}
			}, {
				display : '性别',
				name : 'sex',
				minWidth : 150,
				editor: { type: 'text'}
			}, {
				display : '电话号码',
				name : 'telephone',
				minWidth : 150,
				editor: { type: 'text'}
			} , {
				display : '邮箱',
				name : 'email',
				minWidth : 150,
				editor: { type: 'text'}
			}, {
				display : '职称',
				name : 'position',
				minWidth : 150,
				editor: { type: 'text'}
			},{display:'状态', name:'deleted', minWidth:40, render: function (item)
                  {
                      if (parseInt(item.deleted) == 1){ var h="<span style='color:red;'>账号不可用</span>" ;return h;}
                      else if (parseInt(item.deleted) == 0) { var h="<span style='color:green;'>正常</span>" ;return h;}                                
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
					//data : TeacherData,
					url:'${pageContext.request.contextPath}/system/User_deptmemberlist.action',
					width : '100%'
				});
	}
function beginEdit() {
       var row = manager.getSelectedRow();
       if (!row) { alert('请选择一名教师！'); return; }
       var str = "${pageContext.request.contextPath}/system/Manage_teacheredit.action?teacher.id="+ row.id
				+"&teacher.sex="+row.sex
				+"&teacher.teachername="+row.teachername
				+"&teacher.email="+row.email
				+"&teacher.identificationnum="+row.identificationnum
				+"&teacher.position="+row.position
				+"&teacher.telephone="+row.telephone;
	   m=$.ligerDialog.open({
			url : str,
			height : 450,
			width : 400,
			isDrag:true,
			showMax:true,
			showToggle:true,
			slide: false,			
			modal:false,
			left:200,
			title:'更新教师',
			allowClose:true,
		    isResize : false
		});		
	}
	function deleterow() {
	var row = manager.getSelectedRow();
		if (!row) {
			alert('请选择一名教师！');
			return;
		}
		if (confirm('如果是部门负责人，将不被删除，否则第一次将撤销其权限，第二次如果没有与学期课程关联，将彻底删除?'))
            {
              var rows = g.getCheckedRows();
              var str = "";
              $(rows).each(function(){
              str += this.id + ",";
              });
              $.post("${pageContext.request.contextPath}/system/Manage_teacherdelete.action?ids="+ str);
			  //manager.deleteSelectedRow();	
				window.location.reload();
            }
	}	 
	var m;
	function addteacher(){
	var str = "${pageContext.request.contextPath}/system/Manage_teacherbeginadd.action?depid="+$("#deptid").val();
		m=$.ligerDialog.open({
			url : str,
			height : 450,
			width : 400,
			isDrag:true,
			showMax:true,
			showToggle:true,
			slide: false,			
			modal:false,
			left:200,
			title:'添加教师',
			allowClose:true,
		    isResize : false
		});		
	}
	function addbatchteacher(){
	var str = "${pageContext.request.contextPath}/system/Manage_teacherbatchadd.action";
		m=$.ligerDialog.open({
			url : str,
			height : 500,
			width : 800,
			isResize : true
		});
		
	}
	function f_set(){
	  var row = g.getSelectedRow();
	  var ident = row.identificationnum;
	  if(!row){alert("请先选择一位教师！");}
	  if(row.deleted==0){
	     var url = "${pageContext.request.contextPath}/system/User_searchResponsible.action?teacherid=" + row.identificationnum+"&dept.deptid="+$("#deptid").val();	
			$.ajax({  
		        type : "POST",  
		        url : url,
		        dataType : "JSON", 
		        error: function (){
		        	;
		        },
		        success : function(data) {
		        	if (data.length > 0){
		        		var msg = data;
		          		tips(msg, ident);
		          		return;	
		        	} else {
		        		print(ident);
		        	};
		       }  
		    }); 
	  }else if(row.deleted==1) {
	     alert("该教师状态不可用，不能设置为部门负责人！");
	  }
	  
	 }
	 
	 function print(ident){
	  var url = "${pageContext.request.contextPath}/system/User_setResponsible.action?teacherid="+ident+"&dept.deptid="+$("#deptid").val();
	  $.post(url, null, function() {
	        alert("设置成功！");
			parent.m.hide();
			parent.window.location.reload();
		});
	}
	 
	 function tips (msg, ident) { 	
	 	$.ligerDialog.confirm(msg, function (yes){
 			if (yes == true){
 				print(ident);
 			}   
       }); 
	
	}
	function recover(){
		var row = manager.getSelectedRow();
		if (!row) {
			alert('请选择一名教师！');
			return;
		}
		if (confirm('重置账号之后会恢复教师权限，并把密码设为123456。'))
        {
              var rows = g.getCheckedRows();
              var str = "";
              $(rows).each(function(){
              str += this.id;
              });
              $.post("${pageContext.request.contextPath}/system/Manage_teacherRecover.action?ids="+ str,null,function(){
              window.location.reload();
              });
			  //manager.deleteSelectedRow();	
				
         }
	}
</script>
	</head>
	<body style="padding: 2px">
<!-- 	 <a class="l-button" style="width:70px;float:left; margin:3px;" onclick="addteacher()">添&nbsp;&nbsp;加</a>
	  <a class="l-button" style="width:70px;float:left; margin:3px;" onclick="addbatchteacher()">批量添加</a>  
	 <a class="l-button" style="width:70px;float:left; margin:3px;" onclick="beginEdit()">修&nbsp;&nbsp;改</a>
	 <a class="l-button" style="width:70px;float:left; margin:3px;" onclick="deleterow()">删&nbsp;&nbsp;除</a>	 
	 <a class="l-button" style="width:70px;float:left; margin:3px;" onclick="recover()">重&nbsp;&nbsp;置</a>	  -->
	 <a class="l-button" style="width:100px;float:left; margin:3px;" onclick="f_set()">设置为部门负责人</a>	 
	 <!-- <a class="l-button" style="width:70px;float:left; margin:3px;" onclick="endEdit()">保存</a> -->
	 <input id="deptid" value="${deptid }" type="hidden" />	
	 	<div class="l-clear"></div>
		<div id="maingrid" ></div>
	</body>
</html>