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
    <script type="text/javascript" src="js/jquery-validation/jquery.validate.min.js" charset="utf-8"></script>
    <script type="text/javascript" src="js/json2.js" charset="utf-8"></script>
    <script type="text/javascript" src="js/jquery-validation/jquery.metadata.js" charset="utf-8"></script>
    <script type="text/javascript" src="js/jquery-validation/messages_cn.js" charset="utf-8"></script>
    <script src="js/jquery/jquery-1.3.2.min.js"type="text/javascript"></script>
	<script src="js/ligerUI/core/base.js" type="text/javascript"></script>
	<script src="js/ligerUI/ligerui.all.js" type="text/javascript"></script>
<script type="text/javascript">
var TypeData = [{ type: 1, text: '短假' }, { type: 2, text: '长假'}];
var StatusData = [{ status: 0, text: '审核中' }, { status: 1, text: '教学办审核中'}, { status: 2, text: '学院审核中'}, { status: 3, text: '批准'}, { status: 4, text: '未批准'}, { status: 5, text: '已销假'}, { status: 4, text: '学院审核中'}];

   $(f_initGrid);
	var manager, g;
	function f_initGrid() {
		g = manager = $("#maingrid").ligerGrid(
			{columns : [
			{  display : '序号',  name : 'id',     width : 40,  type : 'int',hide:true
			},{display : '护照号', name : 'passport',  minWidth : 120, editor: { type: 'text'}
			},{display : '姓名', name : 'stuname',minWidth : 80, editor: { type: 'text'}
			},{display : '班级', name : 'classname',minWidth : 80, editor: { type: 'text'}
			},{display : '电话', name : 'telephone', minWidth : 100,  editor:{type:'text'} 
            },{display : '请假时间', name : 'applydate', minWidth : 100,  editor:{type:'text'}	           				
			},{display : '开始时间', name : 'leavingdate', minWidth : 100,  editor:{type:'text'}				
			},{display : '截止时间', name : 'backdate', minWidth : 100,  editor:{type:'text'}	
			} ,{display : '请假事由', name : 'leavereason', minWidth : 100,  editor:{type:'textarea'}	
			} ,{display : '请假时长', name : 'type', minWidth : 100,  editor: { type: 'select', data: TypeData, valueField: 'type' },
                    render: function (item)
                    {
                        if (parseInt(item.type) == 1){ return '短假';}
                        else if (parseInt(item.type) == 2) { return '长假';}              
                    }
           } ,{display : '状态', name : 'status', minWidth : 100,  editor: { type: 'select', data: StatusData, valueField: 'status' },
                    render: function (item)
                    {
                        if (parseInt(item.status) == 0){ var h="<span style='color:red;'>审核中</span>" ;return h;}                       
                        else if (parseInt(item.status) == 1) { var h="<span style='color:red;'>教学办审核中</span>" ;return h;}
                        else if (parseInt(item.status) == 2) { var h="<span style='color:red;'>院领导审核中</span>" ;return h;}  
                        else if (parseInt(item.status) == 3) { var h="<span style='color:green;'>批准</span>" ;return h;}
                        else if (parseInt(item.status) == 4) { var h="<span style='color:orange;'>未批准</span>" ;return h;}  
                        else if (parseInt(item.status) == 5) { var h="<span style='color:blue;'>已销假</span>" ;return h;}                 
                   }},{display : '附件', name : 'doc', minWidth : 100,  editor:{type:'text'}}],
			onSelectRow : function(rowdata, rowindex) {
				$("#txtrowindex").val(rowindex);
			},
				checkbox:true,
				enabledEdit : true,
				clickToEdit : false,
				isScroll : false,
				rownumbers:true, 
				pageSize:30,
				url :'${pageContext.request.contextPath}/system/Manage_loadstuleave.action',
				width : '100%'
			});
	}
	function approval(){
	  var row = manager.getSelectedRow();
		if (!row) {
			alert('请选择一项！');
			return;
		}
	  var status = row.status;
	  var userrow = ${session.user.roles.rolerank};
	  if(userrow==2){
	    if(status==0){
	     var str = 1;
	     $.post("${pageContext.request.contextPath}/system/Manage_stuleaveupdate.action?leave.id="+row.id+"&leave.status="+str,null,function(){
	         alert("提交成功！");
	         g.loadData();
	     });
	   }else{
	    alert("请确认请假状态！");
	   }
	  }else if(userrow==0){//院领导
	    if(row.type==2){
	      if(status==2){
	        var str = 3;
	          $.post("${pageContext.request.contextPath}/system/Manage_stuleaveupdate.action?leave.id="+row.id+"&leave.status="+str,null,function(){
	             alert("提交成功！");
	             g.loadData();
	          });
	      }else if(status==0||status==1) {
	        alert("教务处处理后方可处理！");
	      }else{
	         alert("该请假已处理！");
	      }
	    }else{
	      alert("无需处理短期请假！");
	    }	    
	  }else if(userrow==1){//教学办
	    if(row.type==1){
	       if(status==1||status==0){
	          var str = 3;
	          $.post("${pageContext.request.contextPath}/system/Manage_stuleaveupdate.action?leave.id="+row.id+"&leave.status="+str,null,function(){
	             alert("提交成功！");
	             g.loadData();
	          });
	       }else{
	         alert("该请假已处理！");
	       }
	    }else{
	       if(status==1||status==0){
	         var str = 2;
	         $.post("${pageContext.request.contextPath}/system/Manage_stuleaveupdate.action?leave.id="+row.id+"&leave.status="+str,null,function(){
	             alert("提交成功！");
	             g.loadData();
	         });
	         }else{
	            alert("该请假已处理！");
	         }
	       }	    	    
	   }	  	  
	}
	function nonapproval(){
	  var row = manager.getSelectedRow();
		if (!row) {
			alert('请选择一项！');
			return;
		}
	  var status = row.status;
	  if(status==0){
	     var str = 4;
	     $.post("${pageContext.request.contextPath}/system/Manage_stuleaveupdate.action?leave.id="+row.id+"&leave.status="+str,null,function(){
	     alert("提交成功！");
	     g.loadData();
	  });
	  }else{
	    alert("该确认请假状态！");
	  }
	  
	}
	function cancelleave(){
	  var row = manager.getSelectedRow();
	  if (!row) {alert('请选择一项！');return;}
	  var status = row.status;
	  if(status==3){
	    var str = 5;
	    $.post("${pageContext.request.contextPath}/system/Manage_stuleaveupdate.action?leave.id="+row.id+"&leave.status="+str,null,function(){
	    alert("提交成功！");
	    g.loadData();
	  });
	  }else{
	    alert("请先确认请假状态！");
	  } 
	  
	}
    function deleteleave() {
	var row = manager.getSelectedRow();
	if (!row) {alert('请选择一项！');return;}
	if(row.status==0||row.status==1||row.status==2){
	   $.ligerDialog.confirm('该请假还未审核，确认删除吗？', function (yes){
        if(yes){	
	     $.post("${pageContext.request.contextPath}/system/Manage_leavedelete.action?leave.id="
				+ row.id,null,function(){
					 manager.deleteSelectedRow();
					 manager.loadData();
				});
		}
		});
	}else if(row.status==3){
	   alert("该请假还未销假，不能删除！");
	}else{
	   $.ligerDialog.confirm('确认删除吗？', function (yes){
        if(yes){	
	     $.post("${pageContext.request.contextPath}/system/Manage_leavedelete.action?leave.id="
				+ row.id,null,function(){
					 manager.deleteSelectedRow();
					 manager.loadData();
				});
		}
		});
	}
	
	}	
</script>
	</head>
	<body style="padding: 2px">
	<s:if test="#session.user.roles.rolerank==0||#session.user.roles.rolerank==1">
	<a class="l-button" style="width:70px;float:left; margin:3px;" onclick="approval()">批&nbsp;&nbsp;准</a>
	    <a class="l-button" style="width:70px;float:left; margin:3px;" onclick="nonapproval()">不批准</a>
	    <a class="l-button" style="width:70px;float:left; margin:3px;" onclick="cancelleave()">销&nbsp;&nbsp;假</a>
	    <a class="l-button" style="width:70px;float:left; margin:3px;" onclick="deleteleave()">删&nbsp;&nbsp;除</a>			
	</s:if>
	<s:elseif test="#session.user.roles.rolerank==2">
	    <a class="l-button" style="width:70px;float:left; margin:3px;" onclick="approval()">批&nbsp;&nbsp;准</a>
	    <a class="l-button" style="width:70px;float:left; margin:3px;" onclick="nonapproval()">不批准</a>
	    <a class="l-button" style="width:70px;float:left; margin:3px;" onclick="cancelleave()">销&nbsp;&nbsp;假</a>
	    <a class="l-button" style="width:70px;float:left; margin:3px;" onclick="deleteleave()">删&nbsp;&nbsp;除</a>			
	</s:elseif>
	 <div class="l-clear"></div>
	 <div id="maingrid" ></div>
	</body>
</html>

