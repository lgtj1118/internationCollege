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
	<link href="js/ligerUI/skins/ligerui-icons.css" rel="stylesheet" type="text/css">
	<script src="js/ligerUI/plugins/ligerToolBar.js" type="text/javascript"></script>
    <script type="text/javascript" src="<%=basePath %>js/json2.js" charset="utf-8"></script>
    <script type="text/javascript" src="<%=basePath %>js/ligerUI/plugins/ligerTab.js"></script>
    <script type="text/javascript" src="<%=basePath %>js/jquery/jquery-1.3.2.min.js"></script>
	<script src="<%=basePath %>js/ligerUI/core/base.js" type="text/javascript"></script>
	<script src="<%=basePath %>js/ligerUI/ligerui.all.js" type="text/javascript"></script>	
<script type="text/javascript">
     $(f_initGrid);
	var manager, g;
	function f_initGrid() {
		g = manager = $("#maingrid").ligerGrid(
			{columns : [{
				display : '序号',
				name : 'deptid',
				width : 60,
				hide:true,
				type : 'int'
			}, {
				display : '部门名称',
				name : 'deptname',
				minWidth : 150,
				editor: { type: 'text'}
			}, {
				display : '部门负责人',
				name : 'deptresponsible',
				minWidth : 150
				//editor: { type: 'text'}
			},{
					display : '部门成员',
					isSort : false,
					minWidth : 120,
					render : function() {
						var h = "";
						h += "<a style='color:#000;' href='javascript:deptmember("+ ")'>管理</a> ";
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
					pageSize:20,
					url:'${pageContext.request.contextPath}/system/User_deptlist.action',
					width : '100%',
				    toolbar: { items: [{ text: '添加',click: adddept,    icon: 'add' },
					                   { text: '修改',click: beginEdit,  icon: 'edit' },
					                   { text: '删除',click: deleterow,  icon: 'delete' },
					                   { text: '保存',click: endEdit,    icon: 'save' }
					                  ]}
				});
	}
function deptmember(){
	 var row = manager.getSelectedRow();
	  var str = "${pageContext.request.contextPath}/system/User_deptmember.action?dept.deptid="+row.deptid;
	  top.f_addTab('deptmember','部门成员',str);
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
	 if(row.deptname.length==0){
	   alert("部门名称不能为空！");
	   return false;
	 }else{
	   if(!isNaN(row.deptname)){
	   alert("部门名称不能全是数字！");
	   return false;
	  }else{
	    $.post("${pageContext.request.contextPath}/system/User_deptcheckagain.action?dept.deptname="
						+encodeURI(encodeURI(row.deptname))+"&dept.deptid="+row.deptid, null, function(data) {
					if (data == "fail") {
						alert("该部门名称已存在");
						window.location.reload();
						return false;					    
					} else {
						$.post("${pageContext.request.contextPath}/system/User_deptupdate.action?dept.deptid="+ row.deptid
				            +"&dept.deptname="+encodeURI(encodeURI(row.deptname))
				            +"&dept.deptresponsible="+encodeURI(encodeURI(row.deptresponsible))
				            ,null,function(){
				              //window.location.reload();
				              g.loadData();
				        });
					}
		});
	 }
	 }
	 
}

	function deleterow() {
	  var row = manager.getSelectedRow();
	  if (!row) {alert('请选择一项！');return;}
	  $.ligerDialog.confirm('是否删除该部门？该部门如果存在成员，将不被删除。', function (yes){
       if(yes){	
          $.ligerDialog.prompt('请输入确认密码', function (yes, value){
            if (yes){ //验证密码
              var userid = ${sessionScope.user.id};
              $.post("${pageContext.request.contextPath}/system/User_pwdcheck.action?user.id="+ userid
		          +"&user.password="+value , null, function(data) {
					if (data == "fail") {
						alert("输入的密码不正确!");						
					} else {
                        var rows = g.getCheckedRows();
                        var str = "";
                        $(rows).each(function(){ str += this.deptid +","; });
                        $.post("${pageContext.request.contextPath}/system/User_deptdelete.action?ids="+ str,null,function(){
                           g.loadData();
                        });
			            //manager.deleteSelectedRow();	
		                //window.location.reload();
		            }
	           });
	        }
	      });
	    }
	  });	
} 
	var m;
	function adddept(){
	var str = "${pageContext.request.contextPath}/system/User_deptbegainadd.action";
		m=$.ligerDialog.open({
			url : str,
			height : 250,
			width : 350,
			isDrag:true,
			showMax:true,
			showToggle:true,
			slide: false,			
			modal:false,
			left:200,
			title:'添加部门',
			allowClose:true,
		    isResize : false
		});
	
		
	}
</script>
<style type="text/css">
#head{
 width: 99%;
 height:80px;
 margin:auto;
 border:4px solid #c6c6c6 ;
}
.title{
 float: left;
 height: 100%;
 width: 10%;
 text-aligncenter;
 border-right:2px solid #c6c6c6 ;
}
.search{
  float: left;
}
.l-table-edit{
 height:90px;
 align:center;
 width: 100%;
}
.search.l-table-edit td{
  border-bottom: 1px solid #c6c6c6 ;
}
.link{
width:160px;height:25px;background: #fefefe;border: 1px solid #bbb;font-size: 14px;color: #333;border-radius: 3px;
}
.l-button{
 width:70px;float:left; margin:15px 160px 5px ;
 border-radiux:5px;
}

</style>
	</head>
	<body style="padding: 2px">		
	    <div class="l-clear"></div>
		<div id="maingrid" ></div>
	</body>
</html>

