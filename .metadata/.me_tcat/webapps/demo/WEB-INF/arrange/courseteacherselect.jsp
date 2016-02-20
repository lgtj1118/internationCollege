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
    <script type="text/javascript" src="<%=basePath %>js/jquery-validation/jquery.validate.min.js" charset="utf-8"></script>
    <script type="text/javascript" src="<%=basePath %>js/json2.js" charset="utf-8"></script>
    <script type="text/javascript" src="<%=basePath %>js/jquery-validation/jquery.metadata.js" charset="utf-8"></script>
    <script type="text/javascript" src="<%=basePath %>js/jquery-validation/messages_cn.js" charset="utf-8"></script>
    <script type="text/javascript" src="<%=basePath %>js/ligerUI/plugins/ligerTab.js"></script>
    <script type="text/javascript" src="<%=basePath %>js/jquery/jquery-1.3.2.min.js"></script>
	<script src="<%=basePath %>js/ligerUI/core/base.js" type="text/javascript"></script>
	<script src="<%=basePath %>js/ligerUI/ligerui.all.js" type="text/javascript"></script>	
<script type="text/javascript">
   var sexData = [{ Sex: 1, text: '男' }, { Sex: 2, text: '女'}];
   $(f_initGrid);
	var manager, g;
	function f_initGrid() {
		g = manager = $("#maingrid").ligerGrid(
			{columns : [
			{   display : '序号',  name : 'id',     width : 40,  type : 'int',hide:true
			},{display : '编号', name : 'identificationnum', minWidth : 100,  editor:{type:'text'}	
			},{display : '姓名', name : 'teachername', minWidth : 100,  editor:{type:'text'}	
			} ,{display : '性别', name : 'sex',minWidth : 80,editor: { type: 'text'}
			}, {display : '电话号码', name : 'telephone',minWidth : 100, editor: { type: 'text'}
			}, {display : '职称', name : 'position',  minWidth : 120, editor: { type: 'text'}
			}],
					onSelectRow : function(rowdata, rowindex) {
						$("#txtrowindex").val(rowindex);
					},
					enabledEdit : true,
					clickToEdit : false,
					isScroll : false,
					rownumbers:true, 
					pageSize:20,
					url :'${pageContext.request.contextPath}/system/Manage_courseteacherlist.action',
					width : '100%'
				});
	}

	function addteacher() {
	var row = manager.getSelectedRow();
		if (!row) {alert('请选择一名教师！');return;}
		
		$.post("${pageContext.request.contextPath}/system/Manage_semesterteacherendadd.action?teacher.identificationnum="+ row.identificationnum+"&semChosenCourse.id="+$("#semestercourseid").val() ,null,function(){
		   //alert("设定成功！");
		   parent.m.hide();
		   parent.g.loadData();
		 }) 
		 }
		 /* $.ajax({  
		   type : "POST",  
		   url : url,
		   error: function (){
		        alert("服务器错误，请联系管理员!");
		   },
		   success : function(data) {
		       if (data.length > 0){
		        	var msg = "该教师已经是";	
		        	for(var n=0;n<data.length;n++){
		        			msg = msg + data[n].classname + " ";	
		          	}; 
		          	msg = msg + "的任课教师，是否继续？";
		          	tips(msg, ident);
		          		return;	
		        	} else {
		        		print(ident);
		        	};
		      } 
		      }
	}); 
	
	}	 
function print(ident){
	  //alert("here");
	  var url = "${pageContext.request.contextPath}/system/Manage_semesterteacherendadd.action?teacher.identificationnum="+ row.identificationnum+"&semChosenCourse.id="+$("#semestercourseid").val();
	  $.post(url, null, function() {
			parent.m.hide();
			parent.window.location.reload();
		});
	}
	 
	 function tips (msg, ident) { 	
	 	$.ligerDialog.confirm(msg, function (yes)
       {
 			if (yes == true){
 				print(ident);
 			}   
       }); 
	 } */
	  function fuzzy () {
		var t = $("#keyword").val();
		$("#maingrid").ligerGrid({
		  url:"${pageContext.request.contextPath}/system/Manage_teacherFuzzy.action?fuzzyText=" + encodeURI(encodeURI(t)) ,
		});
	}
	 
</script>
	</head>
	<body style="padding: 2px">
	 <input id="semestercourseid" value="${semestercourseid }" type="hidden" />
	 <table style="margin:5px;" >
	    <tr>
	       <td> <input type="text" id="keyword" onkeyup="fuzzy()"   style="font-size:12px; width:180px;" placeholder="姓名 编号 职称"></td>
	       <td><a class="l-button" style="width:70px;float:left; margin:3px;font-size: 12px;" onclick="addteacher()">选&nbsp;定</a>	 	 </td>
	    </tr>	 
	 </table>
	    
	     
	 <div class="l-clear"></div>
	 <div id="maingrid" ></div>
	</body>
</html>

