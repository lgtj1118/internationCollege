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
     <link href="js/ligerUI/skins/ligerui-icons.css" rel="stylesheet" type="text/css">
    <script type="text/javascript" src="js/jquery-validation/jquery.validate.min.js" charset="utf-8"></script>
    <script type="text/javascript" src="js/json2.js" charset="utf-8"></script>
    <script type="text/javascript" src="js/jquery-validation/jquery.metadata.js" charset="utf-8"></script>
    <script type="text/javascript" src="js/jquery-validation/messages_cn.js" charset="utf-8"></script>
    <script src="js/jquery/jquery-1.3.2.min.js"type="text/javascript"></script>
	<script src="js/ligerUI/core/base.js" type="text/javascript"></script>
	<script src="js/ligerUI/ligerui.all.js" type="text/javascript"></script>
	<script src="js/ligerUI/plugins/ligerToolBar.js" type="text/javascript"></script>
	<script type="text/javascript" src="js/semester.js" ></script>
<script type="text/javascript">   
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
				display : '课程编号',
				name : 'num',
				minWidth : 80,
				//editor: { type: 'int'}
			}, {
				display : '课程名称',
				name : 'courseName',
				minWidth : 80,
				//editor: { type: 'text'}
			},  {
				display : '开课周数',columns:[
				{ display:'起始周' , name:'beginWeek',minWidth : 60, },
				{ display:'结束周' , name:'endWeek',  minWidth : 60, }
				]			
			} , {
				display : '学分',
				name : 'credits',
				minWidth : 60,
				
			}, {
				display : '教师',columns:[
				   {display : '教师工号',name : 'teacherid',width : 120,}, 
				   {display : '负责教师',name : 'teacher',width : 120,}
				]
			} , {
				display : '开课学生数',
				name : 'stuNum',
				width : 120,
			} /*   , {
				display : '已选人数',
				name : 'havestuNum',
				width : 120,
			}  */, {
				display : '课程类型',
				name : 'courseType',
				minWidth : 60,
				
			} , {
				display : '状态',
				name : 'classes',
				minWidth : 60,
				
			} /* ,{
					display : '操作',
					isSort : false,
					width : 120,
					render : function() {
						var h = "";
						h += "<button type='button' onclick='javascript:selectcourse("+ ")'>选课</button> ";
						h += "&nbsp;&nbsp;";
						h += "<button type='button' onclick='javascript:cancelcourse("+ ")'>退选</button> ";
						return h;
					}
			}*/],
				onSelectRow : function(rowdata, rowindex) {
						$("#txtrowindex").val(rowindex);
					},
					enabledEdit : true,
					clickToEdit : true,
					isScroll : false,
					checkbox:false,
			        rownumbers:true,
			        pageSize:15,
					url :'${pageContext.request.contextPath}/system/Manage_courseListForCourseSelection.action',
					width : '100%',					
				});
	}
	
	
	function add(){
		var semester = $("#semester option:selected").val();
		if (semester.length == 0) {
			alert("请先选择学期！");
		} else {
			var row = manager.getSelectedRow();
			 if (row.classes == "未选") {
				$.post("${pageContext.request.contextPath}/system/Manage_selectCourse.action?selectiveCourseNum=" + row.num + "&semester=" + $("#semester option:selected").val(), null, function(data){
					//alert("提交成功！");
					if(data.length>0){
					   alert(data);
					}
					//window.location.reload();	
					g.loadData();									
				})
			} else {
				alert("不能选择已选的课程");
			} 
			/* if (row.classes == "未选") {
			 var url = "${pageContext.request.contextPath}/system/Manage_selectCourse.action?selectiveCourseNum=" + row.num + "&semester=" + $("#semester option:selected").val()	
			  $.ajax({  
		        type : "POST",  
		        url : url,
		        dataType : "JSON", 
		        error: function (){; },
		        success : function(data) {
		          if(data.lengt>0){
		            alert(data);
		          }else{
		            alert("提交成功！");
		            g.loadData();
		          }
		        }  
		     }); 
	      }else{
	        alert("不能选择已选的课程");
	      } */
		}
	}
	function deleterow(){
		var row = manager.getSelectedRow();
		if (row.classes == "<font color='red' >已选</font>") {
			$.post("${pageContext.request.contextPath}/system/Manage_diselectCoruse.action?selectiveCourseNum=" + row.num, null, function(){
				//alert("提交成功！");
				g.loadData();
			})
		} else {
			alert("不能退选未选的课程");
		}
	}
	function f_search(){
		var semester = $("#semester").val();
		var date = new Date();
		var year = date.getFullYear();
		var month = date.getMonth();
		var now;
		if (month > 9) {
			now = year + "01";
		} else {
			now = year + "02";
		}
		if (now <= semester) {
			var str = "${pageContext.request.contextPath}/system/Manage_SearchcourseListForCourseSelection.action?semester=" + semester;
			$("#maingrid").ligerGrid({
				url : str
			})
		} else {
			alert("请选择本学期或下学期的课程！");
		}
	}
</script>
<style type="text/css">
#head{
 width: 99%;
 height:100px;
 margin:auto;
 border:4px solid #c6c6c6 ;
 display: none;
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
 margin-top:20px;
 align:center;
}
.search.l-table-edit td{
  border-bottom: 1px solid #c6c6c6 ;
}
.link{
width:180px;height:25px;background: #fefefe;border: 1px solid #bbb;font-size: 14px;color: #333;border-radius: 3px;
}
.l-button{
 width:70px;float:left; margin:-10px 160px 5px ;
 border-radiux:5px;
}
#content{
  margin-left: 0px;
  margin-top:30px;
}
</style>
	</head>
	<body style="padding: 2px;font-size: 12px;">	
	<div id="head">
	      <div class="title" ><br><br><div align="center"><font face="微软雅黑" color="#400000" size="4"><strong>条件选择</strong></font></div></div>
	      <div class="search" >
	         <table cellpadding="0" cellspacing="0" class="l-table-edit" width="100%" >			  
			<tr>
			   <td align="right" class="l-table-edit-td">&nbsp;&nbsp;&nbsp;开课学期:&nbsp;</td>
				<td align="left" class="l-table-edit-td">
				   <select id="semester" name="semester" class="link" onchange="f_search()" >
				      <option value="" ></option>				      
				   </select>
				</td>				
			</tr>
			<tr>
			   <td></td><td></td><td></td>
			   <td  ><div id="result" style="color:red; font-size: 10px;"></div></td>
			</tr>						
		</table>
		<!-- <a class="l-button" onclick="f_search()"><strong>查&nbsp;&nbsp;询</strong></a> -->
	      </div>
	    </div>	
	    <div id="content" >
	         <a class="l-button" style="width:60px;float:left; margin:3px;" onclick="add()">选&nbsp;&nbsp;修</a>
		     <a class="l-button" style="width:60px;float:left; margin:3px;" onclick="deleterow()">退&nbsp;&nbsp;选</a>	
	    </div>		
		
		<div class="l-clear"></div>
		<div id="maingrid" ></div>
	</body>
</html>
