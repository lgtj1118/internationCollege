<%@page import="org.springframework.web.context.request.SessionScope"%>
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
    <title>天津工业大学国际教育学院教学服务系统</title>	   
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
				   editor:{type:'text'}
				},{
				   display:'作业',
				   name:'homework',
				   editor:{type:'text'}
				},{
				   display:'期中',
				   name:'midexam',
				   editor:{type:'text'}
				},{
				   display:'期末',
				   name:'finalexam',
				   editor:{type:'text'}
				},{
				   display:'综合',
				   name:'summary',
				   editor:{type:'text'}
				
			    }]}, {
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
			} ],
					onSelectRow : function(rowdata, rowindex) {
						$("#txtrowindex").val(rowindex);
					},
					enabledEdit : true,
					clickToEdit : false,
					isScroll : false,
					checkbox:false,
			        rownumbers:true,
			        pageSize:30,
			        url:'${pageContext.request.contextPath}/system/Manage_makeupstulist.action',
					width : '100%'
				});
	}
   /* function f_scoreadd(){
     var row = manager.getSelectedRow();
     if(!row){
       alert("请选择一个条目！");
       return ;
     }    
     if(row.ismakeup==1){
        alert("该学生已补考，不能再录入成绩！");
     }else{
        var str = "${pageContext.request.contextPath}/system/Manage_courseclassscorebegainadd.action?cls.id="+$("#classid").val()+"&semChosenCourse.semester="+$("#semester").val()+"&course.num="+$("#coursenum").val()+"&stu.stuid="+row.stuid;
        m=$.ligerDialog.open({
			url : str,
			height : 350,
			width : 380,
			isDrag:true,
			showMax:true,
			showToggle:true,
			slide: false,			 
			modal:false,
			left:200,
			title:'添加成绩',
			allowClose:true,
		    isResize : false
		});
     }
     
   } */
   function f_makeupscoreadd(){
     var row = manager.getSelectedRow();
     if(!row){ alert("请选择一个条目！"); return ; }
     if(row.ismakeup==1){
        alert("该学生已补考，不能再录入成绩！");
     }else{
         if(row.summary>=60){
           alert("该学生总评成绩已达60分，无需补考！");
          }else{
             if(row.attendence.length==0&&row.homework.length==0&&row.midexam.length==0&&row.finalexam.length==0){
                alert("该学生还未录入成绩，不能直接录入补考成绩！");
             }else{
                var str = "${pageContext.request.contextPath}/system/Manage_courseclassmakeupscorebegainadd.action?semChosenCourse.semester="+$("#semester").val()+"&course.num="+$("#coursenum").val()+"&stu.passport="+row.passport;
                 m=$.ligerDialog.open({
			           url : str,
			           height : 350,
			           width : 380,
			           isDrag:true,
			           showMax:true,
			          showToggle:true,
			          slide: false,			 
			           modal:false,
			           left:200,
			           title:'添加补考成绩',
			           allowClose:true,
		               isResize : false
		         });
             }             
           }
      }
}
   var m;
   function f_set(){
      var str = "${pageContext.request.contextPath}/system/Manage_setsummary.action?semester="+$("#semester").val()+"&coursenum="+$("#coursenum").val(); 
      m=$.ligerDialog.open({
			url : str,
			height : 350,
			width : 400,
			isDrag:true,
			showMax:true,
			showToggle:true,
			slide: false,			
			modal:false,
			left:200,
			title:'总评计算设置',
			allowClose:true,
		    isResize : false
		});		
   }
</script>
<style type="text/css">
.l-button{
 width:80px;float:left; margin:10px 30px 5px ;
}
</style>
	</head>
	<body style="padding: 2px">	
	    <br>
	    <input id="semester" value="${semester }" type="hidden" />
        <input id="coursenum" value="${coursenum }" type="hidden"/>
        <div>注：<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 请点击学生录入补考成绩</div>
		   <a class="l-button" onclick="f_makeupscoreadd()"><strong>补考成绩录入</strong></a>                			
		<div class="l-clear"></div>
		<div id="maingrid" ></div>
	</body>
</html>
