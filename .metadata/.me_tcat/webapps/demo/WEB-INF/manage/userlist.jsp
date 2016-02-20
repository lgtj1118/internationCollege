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
    var DeptData = { 
	  Rows: [<%String s = (String) request.getAttribute("deptlist");%> <%=s%>]};
    var DeptList =DeptData.Rows;
    var RoleData = { 
	  Rows: [<%String ss = (String) request.getAttribute("rolelist");%> <%=ss%>]};
    var RoleList = RoleData.Rows; 
    $(f_initGrid);
	var manager, g;
	function f_initGrid() {
		g = manager = $("#maingrid").ligerGrid(
			{columns : [
			{   display : 'ID',   name : 'id',         width : 60,  type : 'int',hide:false
			}, {display : '用户编号', name : 'usernum',   minWidth : 100, editor: { type: 'text'}
			}, {display : '用户名', name : 'username',   minWidth : 120, editor: { type: 'text'}
			} ,{display : '密码',  name : 'password', hide:true,   minWidth : 120, editor: { type: 'password'}
			}, {display : '姓名',  name : 'realname',   minWidth : 120, editor: { type: 'text'}
			} ,{display : '性别',  name : 'sex',        minWidth : 60,  editor:{type:'text'}	
			} ,{display : '电话',  name : 'telephone',  minWidth : 120,  editor:{type:'text'}	
			} ,{display : 'E-mail', name : 'email',    minWidth : 150,  editor:{type:'text'}				
			} ,{ display: '部门',  name: 'deptid', minWidth: 150, isSort: false,
               editor: { type: 'select', data: DeptList, valueColumnName: 'Deptid', displayColumnName: 'Deptname' }, 
                  render: function (item){
                    for (var i = 0; i < DeptList.length; i++){ 
                        if (DeptList[i]['Deptid'] == item.deptid)
                                return DeptList[i]['Deptname'];
                    }
                        return item.Deptname;
                }
                  
            } ,{ display: '角色', name: 'roleid', minWidth: 120, isSort: false,
                    editor: { type: 'select', data: RoleList, valueColumnName: 'Roleid', displayColumnName: 'Roledescribe' }, 
                    render: function (item)
                    {
                        for (var i = 0; i < RoleList.length; i++)
                        {
                            if (RoleList[i]['Roleid'] == item.roleid)
                                return RoleList[i]['Roledescribe'];
                        }
                        return item.Roledescribe;
                    }
                }],
					onSelectRow : function(rowdata, rowindex) {
						$("#txtrowindex").val(rowindex);
					},
					enabledEdit : true,
					clickToEdit : false,
					isScroll : false,
					rownumbers:true, 
					pageSize:20,
					url :'${pageContext.request.contextPath}/system/User_userlist.action',
					width : '100%',
					toolbar: { items: [{ text: '添加',click: adduser,  icon: 'add' },
					                   { text: '修改',click: beginEdit,  icon: 'edit' },
					                   { text: '删除',click: deleterow,  icon: 'delete' }
					                   /* { text: '重置',click: recover,  icon: 'save' },
					                   { text: '批量添加', click: addbatchteacher, icon:'add'} */
					                   ]}
				});
	}
	var m;
	function beginEdit() {
       var row = manager.getSelectedRow();
       if (!row) { alert('请选择一名用户！'); return; }
       var str = "${pageContext.request.contextPath}/system/User_useredit.action?user.id="+ row.id;
		m=$.ligerDialog.open({
			url : str,
			height : 480,
			title:'更新用户',
			width : 400,
			isDrag:true,
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
		if (!row) { alert('请选择一名用户！'); return; }
		if (confirm('确定删除?')){
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
                               $(rows).each(function(){ str += this.id +","; });
                               $.post("${pageContext.request.contextPath}/system/User_userdelete.action?ids="+ str,null,function(){
                                  manager.deleteSelectedRow();	
                                  g.loadData();
                               });			                     
                           }
                         });
                    }
            });
        }
	}	 
	var m;
	function adduser(){	
	var str = "${pageContext.request.contextPath}/system/User_userbeginadd.action";
		m=$.ligerDialog.open({
			url : str,
			height : 480,
			title:'添加用户',
			width : 400,
			isDrag:true,
			showMax:true,
			showToggle:true,
			slide: false,			
			modal:false,
			left:200,
			allowClose:true,
		    isResize : false
		});		
	}
	function addbatchstu(){
	var str = "${pageContext.request.contextPath}/system/User_userbatchadd.action";
		m=$.ligerDialog.open({
			url : str,
			height : 500,
			width : 800,
			isResize : true
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

