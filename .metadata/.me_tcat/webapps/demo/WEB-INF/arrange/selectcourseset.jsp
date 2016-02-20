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
    <title>天津工业大学国际教育学院教学服务系统</title>	   
	<link href="<%=basePath%>js/ligerUI/skins/Aqua/css/ligerui-all.css" rel="stylesheet"type="text/css" />	
	<link href="<%=basePath %>js/ligerUI/skins/Gray/css/all.css" rel="stylesheet" type="text/css"/>	
    <link href="js/ligerUI/skins/ligerui-icons.css" rel="stylesheet" type="text/css">
    <script type="text/javascript" src="js/json2.js" charset="utf-8"></script>
    <script src="js/jquery/jquery-1.6.min.js"type="text/javascript"></script>
	<script src="js/ligerUI/core/base.js" type="text/javascript"></script>
	<script src="js/ligerUI/ligerui.all.js" type="text/javascript"></script>
	<script src="js/ligerUI/plugins/ligerToolBar.js" type="text/javascript"></script>
<script type="text/javascript">  
	$(f_initGrid);
	var manager, g;
	function f_initGrid() {
		g = manager = $("#maingrid").ligerGrid(
				{
			 columns : [{
				display : 'ID',
				name : 'id',
				width : 60,
				hide:true,
				type : 'int'
			}, {
				display : '课程编号',
				name : 'coursenum',
				minWidth : 120
			}, {
				display : '课程名称',
				name : 'coursename',
				minWidth : 120
			},{
				display : '开课周数',columns:[
				{ display:'起始周' , name:'begainweek',minWidth : 60},
				{ display:'结束周' , name:'endweek',  minWidth : 60}
				]			
			} , {
				display : '学分',
				name : 'credits',
				minWidth : 60				
			}, {
				display : '开课人数',
				name : 'stuNum',
				minWidth : 80,
				editor: { type: 'int'}
			}, {
				display : '任课教师',
				name : 'teachername',
				width : 120				
			} , {
				display : '上课班级',
				name : 'classes',
				width : 120				
			}  ],
					onSelectRow : function(rowdata, rowindex) {
						$("#txtrowindex").val(rowindex);
					},
					enabledEdit : true,
					clickToEdit : true,
					isScroll : false,
					checkbox:false,
			        rownumbers:true,
			        pageSize:15,
					url :'${pageContext.request.contextPath}/system/Manage_semesterselectcourselist.action',
					width : '100%'
							
				});
	}
	function f_save(){
	   var updated = $("#maingrid").ligerGrid('getChanges', "updateds");
	   var effectRow = new Object(); 
	   var test = new Array();
	   if (updated.length) { 
	     effectRow["updateds"] = encodeURI(JSON2.stringify(updated),"UTF-8");
	     test = JSON2.stringify(updated);
	   }
	   var ff=effectRow["updateds"];	 
	   var flg = true;
	   var tt = eval(test);	
	   var t= /^[0-9]*[1-9][0-9]*$/;
       for(var i=0;i<tt.length;i++){ 
	      if(t.test(tt[i].stuNum)){
	        if(tt[i].stuNum>200){
	          alert("人数设置不符合小于200的要求，请重新设置！");
	          flg = false;
	        }else{
	          continue;
	        }
	        
	      }else{
	        $.ligerDialog.warn("课程编号："+tt[i].coursenum+" 课程名称："+tt[i].coursename+" 的人数设置不正确，请修改后保存！");	
            flg = false;
	      }	      
	   }
	   if(flg){
	     $.post("${pageContext.request.contextPath}/system/Manage_semesterselectcourseupdate.action",effectRow, function(){   
          alert("更新成功！");
          window.location.reload();
         }); 
	   }	     
	} 
    
</script>
<style type="text/css">

.l-button{
 width:70px;float:left; margin:15px 160px 5px ;
 border-radiux:5px;
}
</style>
	</head>
	<body style="padding: 2px">	
	     <div style="margin:10px;" ><font size="4"><strong>注：</strong></font><br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 请点击课程开课人数，设置课程人数，设置后点击保存</div>	
		 <a class="l-button"style="width:60px;float:left;  margin-left:10px;"onclick="f_save()">保&nbsp;存</a>
		<div class="l-clear"></div>
		<div id="maingrid" ></div>
	</body>
</html>
