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
	<script src="js/ligerUI/plugins/ligerToolBar.js" type="text/javascript"></script>
	<link href="js/ligerUI/skins/ligerui-icons.css" rel="stylesheet" type="text/css">
<script type="text/javascript">
var IsmakeupData = [{ ismakeup: 0, text: '否' }, { ismakeup: 1, text: '是'}];  
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
				display : '学期',
				name : 'semester',
				minWidth : 160,
				editor: { type: 'text'}
			} , {
				display : '课程名称',
				name : 'coursename',
				minWidth : 120,
				editor: { type: 'text'}
			}, {
				display : '护照号',
				name : 'passport',
				width : 120,
				editor: { type: 'text'}
			}, {
				display : '姓名',
				name : 'stuname',
				width : 120,
				editor: { type: 'text'}
			}, {
				display : '成绩',
				minWidth : 120,
				columns:[{
				   display:'出勤',
				   name:'attendence',
				   editor:{type:'float'},				     
				   render: function (item)
                    {
                        if (parseInt(item.attendence) < 60){ var h="<font color='red' >"+item.attendence+"</font>" ;return h;}
                        else{ var h=item.attendence;return h;}
                        
                    }
				},{
				   display:'作业',
				   name:'homework',
				   editor:{type:'float'},
				   render: function (item)
                    {
                        if (parseInt(item.homework) < 60){ var h="<font color='red' >"+item.homework+"</font>" ;return h;}
                        else{ var h=item.homework ;return h;}
                        
                    }
				},{
				   display:'期中',
				   name:'midexam',
				   editor:{type:'float'},
				   render: function (item)
                    {
                        if (parseInt(item.midexam) < 60){ var h="<font color='red' >"+item.midexam+"</font>" ;return h;}
                        else{ var h=item.midexam ;return h;}
                        
                    }
				   
				},{
				   display:'期末',
				   name:'finalexam',
				   editor:{type:'float'},
				    render: function (item)
                    {
                        if (parseInt(item.finalexam) < 60){ var h="<font color='red' >"+item.finalexam+"</font>" ;return h;}
                        else{ var h=item.finalexam;return h;}
                        
                    }
				},{
				   display:'综合',
				   name:'summary',
				   editor:{type:'float'},
				   render: function (item)
                    {
                        if (parseInt(item.summary) < 60){ var h="<font color='red' >"+item.summary+"</font>" ;return h;}
                        else{ var h=item.summary;return h;}
                        
                    }
				}]
			}, {
				display : '是否补考',
				name : 'ismakeup',
				width : 60,
				editor: { type: 'select', data: IsmakeupData, valueField: 'ismakeup' },
                    render: function (item)
                    {
                        if (parseInt(item.ismakeup) == 0){ var h="否" ;return h;}
                        else if (parseInt(item.ismakeup) == 1) { var h="<span style='color:red;'>是</span>" ;return h;}
                        
                    }
			}, {
				display : '补考',
				name : 'makeup',
				width : 60,
				editor: { type: 'text'}
			}],
					onSelectRow : function(rowdata, rowindex) {
						$("#txtrowindex").val(rowindex);
					},
					enabledEdit : true,
					clickToEdit : false,
					isScroll : false,
					checkbox:false,
			        rownumbers:true,
					url :'${pageContext.request.contextPath}/system/Manage_stuscorelist.action',
					width : '100%',
					toolbar: { items: [
                         { text: '导出',click: itemclick,  icon: 'save' }/* , { text: '打印',click: printclick,  icon: 'print' } */               
                    ]}
				});
	}
   function itemclick(item){
       var str = "${pageContext.request.contextPath}/system/Manage_courseclassscoredownload.action?semester="+$("#semester").val()+"&coursenum="+$("#coursenum").val()+"&classid="+$("#classid").val(); 
       window.location.href=str;
   }
   function printclick(item){
       var str = "${pageContext.request.contextPath}/system/Manage_courseclassscoreprint.action?semester="+$("#semester").val()+"&coursenum="+$("#coursenum").val()+"&classid="+$("#classid").val(); 
       window.location.href=str;
   }
   
</script>
<style type="text/css">
#head{
 width: 99%;
 height:100px;
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
 height:100%;
 align:center;
}
.search.l-table-edit td{
  border-bottom: 1px solid #c6c6c6 ;
}
.link{
width:160px;height:25px;background: #fefefe;border: 1px solid #bbb;font-size: 14px;color: #333;border-radius: 3px;
}
.l-button{
 width:70px;float:left; margin:15px 20px 5px ;
 border-radiux:5px;
}
</style>
	</head>
	<body style="padding: 2px">	
	    <input id="semester" value="${semester }" type="hidden" />
        <input id="coursenum" value="${coursenum }" type="hidden"/>
        <input id="classid" value="${clsid }" type="hidden"/>	
        
		<div class="l-clear"></div>
		<div id="maingrid" ></div>
	</body>
</html>
