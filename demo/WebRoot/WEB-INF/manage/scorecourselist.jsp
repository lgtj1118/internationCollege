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
	<!-- <script type="text/javascript" src="js/semester.js" ></script> -->
<script type="text/javascript"> 
$(document).ready(function(){			
	var nowDate = new Date();
	var nowYear = nowDate.getFullYear();
	var lastYear = parseInt(nowYear)-1;
	var before = parseInt(lastYear)-1;
	var nextYear = parseInt(nowYear)+1;
	var nowuptext = lastYear+"-"+nowYear+"学年第一学期";//2014-2015
	var nowupvalue = lastYear+"01";
	var nowdowntext = lastYear+"-"+nowYear + "学年第二学期";
	var nowdownvalue = nowYear+"02";
	var lastuptext = before+"-"+lastYear+"学年第一学期";
	var lastupvalue = before+"01";
	var lastdowntext = before+"-"+lastYear+"学年第二学期";
	var lastdownvalue = lastYear+"02";
	var nextuptext = nowYear+"-"+nextYear+"学年第一学期";
	var nextupvalue = nowYear+"01";
	var nextdowntext = nowYear+"-"+nextYear+"学年第二学期";
	var nextdownvalue = nextYear+"02";
	var semester = document.getElementById("semester");
	var objOption=document.createElement("OPTION"); 
    var objOption1=document.createElement("OPTION");
    var objOption2=document.createElement("OPTION"); 
    var objOption3=document.createElement("OPTION"); 
    var objOption4=document.createElement("OPTION"); 
    var objOption5=document.createElement("OPTION"); 
    objOption.value=nowupvalue;   objOption.text=nowuptext;
    objOption1.value=nowdownvalue;  objOption1.text=nowdowntext;
    objOption2.value=lastupvalue;  objOption2.text=lastuptext;
    objOption3.value=lastdownvalue;  objOption3.text=lastdowntext;
    objOption4.value=nextupvalue;  objOption4.text=nextuptext;
    objOption5.value=nextdownvalue;  objOption5.text=nextdowntext;
    var month = nowDate.getMonth();
	var now;
	if (month > 9) {
		now = nowYear + "01";
	} else {
		now = nowYear + "02";
	}
	if(now==nowupvalue){
		semester.add(objOption2);
        semester.add(objOption3);
        semester.add(objOption);
        semester.options[semester.options.length-1].selected='selected';
        semester.add(objOption1);                
        semester.add(objOption4);
        semester.add(objOption5);        		
	}else if(now==nowdownvalue) {
		semester.add(objOption2);
        semester.add(objOption3);
        semester.add(objOption);        
        semester.add(objOption1); 
        semester.options[semester.options.length-1].selected='selected';
        semester.add(objOption4);
        semester.add(objOption5);
	}
        
    
}) 
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
				name : 'num',
				minWidth : 40,
				editor: { type: 'text'}
			} , {
				display : '课程名称',
				name : 'coursename',
				minWidth : 120,
				editor: { type: 'text'}
			}/* , {
				display : '负责教师',
				name : 'teacher',
				width : 120,
				editor: { type: 'text'}
			} */,{
					display : '操作',
					isSort : false,
					minWidth : 120,
					render : function() {
						var h = "";
						h += "<a style='color:#000;' href='javascript:loadscore("+ ")'>查看成绩</a>&nbsp; ";
						h += "<a style='color:#000;' href='javascript:entryscore("+ ")'>录入成绩</a> ";
						return h;
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
					url :'${pageContext.request.contextPath}/system/Manage_attendencecourselist.action',
					width : '100%'
				});
	}
    function entryscore(){
      var semester = $("#semester option:selected").val();
      var major = $("#major").val();
      if(semester.length==0){
        alert("请选择学期");
      }else{
        var row = manager.getSelectedRow();	
        var flag = 0;//录入成绩
        var str = "${pageContext.request.contextPath}/system/Manage_scoreentry.action?course.num="+row.num+"&course.coursename="+row.coursename+"&semChosenCourse.semester="+semester+"&flag="+flag;		  
	    var tabid = "entrycourseclasslist";
        top.f_addTab(tabid,"录入"+row.coursename+"成绩",str);
      }    
    }
	function loadscore(){
	  var semester = $("#semester option:selected").val();
      var major = $("#major").val();
      if(semester.length==0){
        alert("请选择学期");
      }else{
      var row = manager.getSelectedRow();	
      var str = "${pageContext.request.contextPath}/system/Manage_loadcoursescore.action?course.num="+row.num+"&course.coursename="+row.coursename+"&semChosenCourse.semester="+semester;		  
	  var tabid = "loadcourseclasslist";
      top.f_addTab(tabid,"查看"+row.coursename+"成绩",str);
     }
    }
    function f_search(){
      var semester = $("#semester option:selected").val();
       var major = $("#major").val();
      if(semester.length==0){
        $("#maingrid").ligerGrid({
			url : '${pageContext.request.contextPath}/system/Manage_attendencecourselist.action'
		})
      }else{
         var str = "${pageContext.request.contextPath}/system/Manage_searchsemestercourselist.action?semChosenCourse.semester="+semester;
         $("#maingrid").ligerGrid({
			url : str
		})
      }
    }
</script>
<style type="text/css">
#head{
 width: 99%;
 height:90px;
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
  margin-top: 25px;
}
.l-table-edit{
 margin-top: 10px;
 margin-left: 20px;
}
.link{
width:180px;height:25px;background: #fefefe;border: 1px solid #bbb;font-size: 14px;color: #333;border-radius: 3px;
}
.l-button{
 width:70px;float:left; margin:20px 160px 5px ;
 border-radiux:5px;
}
</style>
	</head>
	<body style="padding: 2px">	
	    <div id="head">
	      <div class="title" ><br><br><div align="center"><font face="微软雅黑" color="#400000" size="4"><strong>条件选择</strong></font></div></div>
	      <div class="search" >
	         <table cellpadding="0" cellspacing="0" class="l-table-edit" >
			<tr>
				<td align="right" class="l-table-edit-td">&nbsp;开课学期:&nbsp;</td>
				<td align="left" class="l-table-edit-td">
				   <select id="semester" name="semester" class="link" onchange="f_search()" >
				      <option value="" ></option>
				      <!-- <option value="201301" >2013年上学期</option>
				      <option value="201302" >2013年下学期</option>
				      <option value="201401" >2014年上学期</option>
				      <option value="201402" >2014年下学期</option>
				      <option value="201501" >2015年上学期</option>
				      <option value="201502">2015年下学期</option> -->
				   </select>
				</td>
			    <td align="right" class="l-table-edit-td">&nbsp;&nbsp;专业:&nbsp;</td>
				<td align="left" class="l-table-edit-td">
				  <input id="major" class="link" name="major" value="汉语言" disabled="disabled" />
				</td>
				
				<td align="right" class="l-table-edit-td"></td>
				<td align="left" class="l-table-edit-td"></td>				
			</tr>
			<tr>
			  <th colspan="6"><div id="result1"></div></th>
			</tr>						
		</table>
		<!-- <a class="l-button" onclick="f_search()"><strong>查&nbsp;&nbsp;询</strong></a> -->
	      </div>
	    </div>			
		<div class="l-clear"></div>
		<div id="maingrid" ></div>
	</body>
</html>
