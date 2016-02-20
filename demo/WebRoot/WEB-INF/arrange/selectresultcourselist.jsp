<%@page import="org.springframework.web.context.request.SessionScope"%>
<%@taglib prefix="s" uri="/struts-tags" %>
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
						h += "<a style='color:#000;' href='javascript:loadscore("+ ")'>查看已选学生</a>&nbsp; ";						
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
					/* toolbar: { items: [
					                   { text: '自动选课',click: add,  icon: 'add' }
					                    { text: '重置',click: reset,  icon: 'save' } 					                 
                    ]}	 */
				});
	}
	function loadscore(){
	  var semester = $("#semester option:selected").val();
      var major = $("#major").val();
      if(semester.length==0){
        alert("请选择学期");
      }else{
      var row = manager.getSelectedRow();	
      var str = "${pageContext.request.contextPath}/system/Manage_loadselectcoursestu.action?course.num="+row.num+"&course.coursename="+row.coursename+"&semChosenCourse.semester="+semester;		  
	  var tabid = "selectcoursestulist";
      top.f_addTab(tabid,row.coursename,str);
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
    function add(){
      $.ligerDialog.confirm("自动选课（必修） 会删除学生本学期已选课程（包含已录入成绩），确认自动选课？", function (yes){
      if(yes){
         $.post("${pageContext.request.contextPath}/system/Manage_batchaddstuchosencourse.action",null,function(){
            alert("自动选课成功！");
         });
       }
      });
     }
    /* function reset(){
      alert("save");
    } */
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
 width:70px; margin:20px 160px 5px ;
 border-radiux:5px;
}
.l-button1{
 width:70px; margin:20px 10px 0px ;
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
				   <select id="semester" name="semester" class="link" >
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
		<a class="l-button"  onclick="f_search()"><strong>查&nbsp;&nbsp;询</strong></a>
	      </div>
	    </div>
	    <div style="width: 100%;margin-top: 10px;margin-bottom: 10px;"  >
	       <s:if test="#session.user.roles.rolerank==0||#session.user.roles.rolerank==1">
	         <a class="l-button l-button1" onclick="add()"><strong>自动选课</strong></a>	
	       </s:if>	
	       <s:else></s:else>	
	    </div>	    
		<div class="l-clear"></div>
		<div id="maingrid" ></div>
	</body>
</html>
