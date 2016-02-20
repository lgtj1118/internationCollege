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
	<%-- <script type="text/javascript" src="js/semester.js" ></script> --%>
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
				minWidth : 40,
				editor: { type: 'text'}
			} , {
				display : '课程名称',
				name : 'coursename',
				minWidth : 120,
				editor: { type: 'text'}
			}, {
				display : '学号',
				name : 'stuid',
				width : 120,
				editor: { type: 'text'}
			}, {
				display : '姓名',
				name : 'stuname',
				width : 120,
				editor: { type: 'text'}
			}, {
				display : '班级',
				name : 'classname',
				width : 120,
				editor: { type: 'text'}
			}, {
				display : '成绩',
				width : 80,
				columns:[{
				   display:'出勤',
				   name:'attendence',
				   editor:{type:'text'}
				},{
				   display:'平时',
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
				}]}/*,{
				   display:'综合',
				   name:'summaryscore',
				   editor:{type:'text'}
				
			} */, {
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
			        url:'${pageContext.request.contextPath}/system/Manage_allstuscorelist.action',
					width : '100%'
				});
	}
   function check(){
     var studentid = $("#stuid").val();
     var reg = /^[\u4e00-\u9fa5]+$/gi;
		if (reg.test(studentid)) {
			$("#result").html("学号不能包含中文！");
			$("#result").show();
			return false;
		} else {
			$("#result").hide();
		}$.post("${pageContext.request.contextPath}/system/Manage_stucheck.action?stu.stuid="
						+ $("#stuid").val(), null, function(data) {
					if (data == "fail") {
						$("#result").html("该学号不存在!");
						$("#result").show();						
					} else {
						$("#result").hide();
					}
				});		
   }
   function f_search(){
      var semester = $("#semester").val();
      var classid = $("#classid").val();
      var studentid = $("#stuid").val();
      if (semester.length==0&&classid.length==0&&studentid.length==0) {
			$("#maingrid").ligerGrid({
					url : ''
			   })
	  } else {
	     var str = "${pageContext.request.contextPath}/system/Manage_searchstuscorelist.action?semChosenCourse.semester="+semester+"&cls.id="+classid+"&stu.stuid="+studentid;
		  $("#maingrid").ligerGrid({
			url : str
		 })
	  }
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
 width:70px;float:left; margin:15px 160px 5px ;
 border-radiux:5px;
}
</style>
	</head>
	<body style="padding: 2px">	
	    <div id="head">
	      <div class="title" ><br><br><div align="center"><font face="微软雅黑" color="#400000" size="4"><strong>条件选择</strong></font></div></div>
	      <div class="search" >
	         <table cellpadding="0" cellspacing="0" class="l-table-edit" width="100%" >
			<tr>
				<td>
					<select id="searchType">
						<option>班级</option>
						<option>班级</option>
						<option>班级</option>
						<option>班级</option>
					</select>
				</td>
			   <%-- <td align="right" class="l-table-edit-td">&nbsp;&nbsp;&nbsp;开课学期:&nbsp;</td>
				<td align="left" class="l-table-edit-td">
				   <select id="semester" name="semester" class="link" >
				      <option value="" ></option>				     
				   </select>
				</td>
				<td align="right" class="l-table-edit-td">&nbsp;&nbsp;学生学号:&nbsp;</td>
				<td align="left" class="l-table-edit-td">
				  <input id="stuid" class="link" name="stuid" value="" onblur="check()" />
				</td> --%>
			</tr>
		</table>
		<a class="l-button" onclick="f_search()"><strong>查&nbsp;&nbsp;询</strong></a>
	      </div>
	    </div>			
		<div class="l-clear"></div>
		<div id="maingrid" ></div>
	</body>
</html>
