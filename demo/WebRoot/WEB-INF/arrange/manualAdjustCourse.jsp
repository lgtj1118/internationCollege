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
    <!-- <script type="text/javascript" src="js/jquery-validation/jquery.metadata.js" charset="utf-8"></script>
    <script type="text/javascript" src="js/jquery-validation/messages_cn.js" charset="utf-8"></script> -->
    <script src="js/jquery/jquery-1.3.2.min.js"type="text/javascript"></script>
	<script src="js/ligerUI/core/base.js" type="text/javascript"></script>
	<script src="js/ligerUI/ligerui.all.js" type="text/javascript"></script>
	<script src="js/ligerUI/plugins/ligerToolBar.js" type="text/javascript"></script>
<script type="text/javascript">  
   var CoursecreditData = { 
	         Rows: [<%String ss=(String) request.getAttribute("coursecredit");%><%=ss%>]};
   var CourseCredit = CoursecreditData.Rows;
   var CourseCharacterData = { 
	        Rows: [ <%String sss=(String) request.getAttribute("character");%> <%=sss%>]};
   var CourseCharacter = CourseCharacterData.Rows;
   var CourseCheckwayData = { 
	        Rows: [<%String ssss=(String) request.getAttribute("checkway");%> <%=ssss%>]};
   var CourseCheckway = CourseCheckwayData.Rows;
  
	$(f_initGrid);
	var manager, g;
	function f_initGrid() {
		g = manager = $("#maingrid").ligerGrid(
				{
			
				columns : [{
				display : 'note',
				name : 'note',
				width : 60,
				hide:true,
				type : 'int'
			}, {
				display : '课程编号',
				name : 'num',
				Width : 60,
			} , {
				display : '课程名称',
				name : 'courseName',
				width : 120,
			},{
				display : '上课时间',columns:[
				{ display:'礼拜' , name:'day',width : 60,  },
				{ display:'大节' , name:'slot',  width : 60  }
				]			
			} , {
				display : '教室',
				name : 'roomNum',
				width : 200,
			} , {
				display : '上课班级',
				name : 'className',
				width : 200,				
			} /* , {
				display : '考核方式',
				name : 'checkway',
				minWidth : 120,
				editor: { type: 'select', data: CourseCheckway, valueColumnName: 'Coursecheckway', displayColumnName: 'Coursecheckway' }, 
                  render: function (item)
                    {
                        for (var i = 0; i < CourseCheckway.length; i++)
                        {
                            if (CourseCheckway[i]['Coursecheckway'] == item.checkway)
                                return CourseCheckway[i]['Coursecheckway'];
                        }
                        return item.Coursecheckway;
                    } 
			}  */
			 , {
				display : '任课教师',
				name : 'teacherName',
				width : 60,
				editor: { type: 'text'}
			}  , {
				display : '学期编号',
				name : 'id',
				width : 100,				
			} ],
					onSelectRow : function(rowdata, rowindex) {
						$("#txtrowindex").val(rowindex);
					},
					enabledEdit : true,
					clickToEdit : false,
					isScroll : false,
					checkbox:false,
			        rownumbers:true,
			        pageSize:10,
					url :'${pageContext.request.contextPath}/system/Manage_semesterChosenDat.action',
					width : '100%',
				});
	}


	function fuzzy () {
		var t = $("#searchText").val();
		$("#maingrid").ligerGrid({
		  url:"${pageContext.request.contextPath}/system/Manage_semesterFuzzy.action?newnum=" + encodeURI(encodeURI(t)),
		  	/* + "&queryType=" + $("#coursecharacter").val() , */
		});
	}
	
	function tosubmit(){
		 var row = manager.getSelectedRow();
		 if (!row) { alert('请选择一个课程！'); return; }
		 var str = "${pageContext.request.contextPath}/system/Manage_insertIntoSyllabus.action?insertID=" + row.id;
		 $.post(str, null, function() {
			parent.m.hide();
			parent.window.location.reload();
		});
	}

</script>
<style type="text/css">
#head{
 width: 99%;
 height:80px;
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
	      <div class="search" >
	         <table cellpadding="0" cellspacing="0" class="l-table-edit" width="100%" >
			  
			<tr>
				<td align="right" class="l-table-edit-td" width="100px" >&nbsp;&nbsp;关键字:&nbsp;</td>
				<td align="left" class="l-table-edit-td">
				  <input id="searchText" onkeyup="fuzzy()" class="link" name="searchText" />
				</td>		
			   <!-- <td align="right" class="l-table-edit-td">&nbsp;&nbsp;&nbsp;课程性质:&nbsp;</td>
				<td align="left" class="l-table-edit-td">
				   <select id="coursecharacter" name="coursecharacter" class="link" >
				      <option value="-1" ></option>
				      <option value="0" >必修</option>
				      <option value="1" >限选</option>
				      <option value="2" >任选</option>				 
				   </select>
				</td> -->
				<td align="left" class="l-table-edit-td">
				<a class="l-button" onclick="tosubmit()"><strong>置&nbsp;&nbsp;入</strong></a>
				</td>
			</tr>						
		</table>
		<!-- <a class="l-button" onclick="f_search()"><strong>查&nbsp;&nbsp;询</strong></a> -->
		
	      </div>
	    </div>		
		<div class="l-clear"></div>
		<div id="maingrid" ></div>
	</body>
</html>
