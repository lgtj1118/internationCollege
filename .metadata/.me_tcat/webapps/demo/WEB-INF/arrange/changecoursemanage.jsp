<%@page import="org.springframework.web.context.request.SessionScope"%>
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
    var StatusData = [{ status: 0, text: '审核中' }, { status: 1, text: '批准'}, { status: 2, text: '未批准'}]; 
	$(f_initGrid);
	var manager, g;
	function f_initGrid() {
		g = manager = $("#maingrid").ligerGrid(
				{
				columns : [
				{ display : '序号',name : 'id',width : 60,hide:true,type : 'int'}, 
				{ display : '原课程',columns:[
					 {display : '课程编号', name : 'oldcoursenum', minWidth : 100,editor: { type: 'text'}} ,
					 {display : '课程名称', name : 'oldCourseName', minWidth : 120,editor: { type: 'text'}} ,
					 {display : '地点',    name : 'oldroomName',   minWidth : 150,editor: { type: 'text'}} , 
					 {display : '教师编号', name : 'applyTeacher.identificationnum',width : 120,hide:false,editor: { type: 'text'}},
					 {display : '任课教师', name : 'applyTeacher.teachername',width : 120,hide:false,editor: { type: 'text'}}
				]}, 
				{ display : '调整课程',columns:[
					 {display : '课程编号',name : 'newcoursenum',minWidth : 100,editor: { type: 'text'}} ,
					 {display : '课程名称',name : 'newCourseName',minWidth : 120,editor: { type: 'text'}} ,
					 {display : '地点',name : 'newroomName',minWidth : 150,editor: { type: 'text'}} ,
					 {display : '教师编号', name : 'newTeacher.identificationnum',width : 120,hide:false,editor: { type: 'text'}},
					 {display : '任课教师', name : 'newTeacher.teachername',width : 120,hide:false,editor: { type: 'text'}}
				]} , 
				{ display : '调课原因',name : 'reason',minWidth : 160,editor: { type: 'text'}}  , 
				{ display : '课程原始时间',
				columns:[
				{ display:'上课日期' , name:'olddate',minWidth : 120,editor: { type: 'int'} },
				{ display:'节次' , name:'oldslot',  minWidth : 60,editor: { type: 'int'} }
				]			
			} ,{display : '计划上课时间',
				columns:[
				{ display:'上课日期' , name:'newdate',minWidth : 120,editor: { type: 'int'} },
				{ display:'节次' , name:'newslot',  minWidth : 60,editor: { type: 'int'} }
				]	
			}, {display : '申请日期',name : 'applytime',width : 120,editor: { type: 'text'}}  , 
			{   display : '状态',name : 'status',width : 120,
				editor: { type: 'select', data: StatusData, valueField: 'status' },
                    render: function (item)
                    {
                        if (parseInt(item.status) == 0){ var h="<span style='color:red;'>审核中</span>" ;return h;}
                        else if (parseInt(item.status) == 1) { var h="<span style='color:blue;'>批准</span>" ;return h;}
                        else if (parseInt(item.status) == 2) { var h="<span style='color:orange;'>未批准</span>" ;return h;}                                   
                   }
			} ],
					onSelectRow : function(rowdata, rowindex) {
						$("#txtrowindex").val(rowindex);
					},
					enabledEdit : true,
					clickToEdit : false,
					isScroll : false,
					checkbox:false,
			        rownumbers:true,
					url :'${pageContext.request.contextPath}/system/Manage_changecourselist.action',
					width : '100%'
				});
	}	
	function add(){
	  var row = manager.getSelectedRow();
	  if (row.status != 0){
	  	alert("只能批准未审核状态的申请");
	  	return;
	  }
	  var flag = true;
	  $.post("${pageContext.request.contextPath}/system/Manage_checkAdjustApply.action?isApprove="+flag+"&adjustcourseID="+row.id,null,function(){
	    //alert("提交成功！");
	    g.loadData();
	  });
	}
	
	function deleterow(){
		var row = manager.getSelectedRow();
		if (row.status != 0){
		  	alert("只能驳回未审核状态的申请");
		  	return;
		 }
		
		var flag = "false";
		$.post("${pageContext.request.contextPath}/system/Manage_checkAdjustApply.action?isApprove="+flag+"&adjustcourseID="+row.id,null,function(){
		  //alert("提交成功！");
		  g.loadData();
		})
	}
</script>
	</head>
	<body style="padding: 2px">		
		<div style="margin-top:10px;" >&nbsp;<font size="2">&nbsp;&nbsp;注：<br>&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp; 申请调课批复前，请先查看申请调课日期相关教室是否已安排课程。</font><br><br></div>
		<a class="l-button" style="width:60px;float:left; margin:3px;" onclick="add()">批&nbsp;&nbsp;准</a>
		<a class="l-button" style="width:60px;float:left; margin:3px;" onclick="deleterow()">驳&nbsp;&nbsp;回</a>			
		<div class="l-clear"></div>
		<div id="maingrid" ></div>
	</body>
</html>