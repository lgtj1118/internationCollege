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
	var TypeData = [{ type: 1, text: '短假' }, { type: 2, text: '长假'}];
    var StatusData = [{ status: 0, text: '审核中' }, { status: 1, text: '批准'}, { status: 2, text: '未批准'}, { status: 3, text: '已销假'}];  
   $(f_initGrid);
	var manager, g;
	function f_initGrid() {
		g = manager = $("#maingrid").ligerGrid(
			{columns : [
			{  display : '序号',  name : 'id',     width : 40,  type : 'int',hide:true
			},{display : '护照号', name : 'passport',  minWidth : 120, editor: { type: 'text'}
			},{display : '姓名', name : 'stuname',minWidth : 80, editor: { type: 'text'}
			},{display : '电话', name : 'telephone', minWidth : 100,  editor:{type:'text'} 
            },{display : '请假时间', name : 'applydate', minWidth : 100,  editor:{type:'text'}	           				
			},{display : '开始时间', name : 'leavingdate', minWidth : 100,  editor:{type:'text'}				
			},{display : '截止时间', name : 'backdate', minWidth : 100,  editor:{type:'text'}	
			} ,{display : '请假事由', name : 'leavereason', minWidth : 100,  editor:{type:'text'}	
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
                   }}],
			onSelectRow : function(rowdata, rowindex) {
				$("#txtrowindex").val(rowindex);
			},
				checkbox:true,
				enabledEdit : true,
				clickToEdit : false,
				isScroll : false,
				rownumbers:true, 
				pageSize:30,
				url :'${pageContext.request.contextPath}/system/Manage_stuloadleave.action',
				width : '100%'
			});
	}
    function shortleave(){
	   var str = "${pageContext.request.contextPath}/system/Manage_shortleave.action";
	   m=$.ligerDialog.open({
			url : str,
			height : 500,
			width : 650,
			title:'短期请假',
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
	function longleave(){
	   var str = "${pageContext.request.contextPath}/system/Manage_longleave.action";
	   m=$.ligerDialog.open({
			url : str,
			height : 500,
			width : 650,
			title:'长期请假',
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
	function print(){
	   var row = manager.getSelectedRow(); 
	   if(!row){
	     alert("请先选择一项！");
	     return ;
	   }
	   if(row.status==3){
	     var str = "${pageContext.request.contextPath}/system/Manage_leaveprint.action?leave.id="+row.id;
	     window.open(str);
	   }else if(row.status==0||row.status==1||row.status==2) {
	     alert("该请假还未处理，请审核通过后打印！");
	   }else{
	     alert("该请假不能打印！");
	   }
	   
	}
	function leaveedit(){
	   var row = manager.getSelectedRow();
	   if(!row){alert("请先选择一项！");return ;}
	   if(row.status==0){
	     var str = "${pageContext.request.contextPath}/system/Manage_leaveedit.action?leave.id="+row.id;
         m=$.ligerDialog.open({
			url : str,
			height : 500,
			width : 650,
			title:'请假修改',
			isDrag:true,
			showMax:true,
			showToggle:true,
			slide: false,			
			modal:false,
			left:200,
			allowClose:true,
		    isResize : false
		});
	   }else{
	     alert("请假已处理不能修改！");
	   }
	}
	function leavecancel(){
	   var row = manager.getSelectedRow();
	   if(!row){alert("请先选择一项！");return ;}
	   if(row.status==0){
	   $.ligerDialog.confirm('确认取消该请假？', function (yes){
	      $.post("${pageContext.request.contextPath}/system/Manage_leavedelete.action?leave.id="+row.id,null,function(){
	        window.location.reload();
	      });
	      });
	   }else{
	     alert("请假已处理不能取消！");
	   }
	}
	function reloadthistab() {
		g.reload();
	}
</script>
	</head>
	<body style="padding: 2px">
			<a class="l-button" style="width:100px;float:left; margin:3px;" onclick="shortleave()">短期请假申请</a>
			<a class="l-button" style="width:100px;float:left; margin:3px;" onclick="longleave()">长期请假申请</a>
			<a class="l-button" style="width:80px;float:left; margin:3px;" onclick="leaveedit()">修&nbsp;&nbsp;改</a>
			<a class="l-button" style="width:80px;float:left; margin:3px;" onclick="leavecancel()">取&nbsp;&nbsp;消</a>
			<a class="l-button" style="width:60px;float:left; margin:3px;" onclick="print()">打&nbsp;&nbsp;印</a>	
<!-- 			<a class="l-button" style="width:60px;float:left; margin:3px;" onclick="reloadthistab()">reload</a>	 -->	
		<div class="l-clear"></div>
		<div id="maingrid" ></div>
	</body>
</html>
