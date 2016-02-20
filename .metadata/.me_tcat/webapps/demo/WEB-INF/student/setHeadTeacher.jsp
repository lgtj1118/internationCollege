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
    <script src="js/jquery/jquery-1.6.min.js"type="text/javascript"></script>
	<script src="js/ligerUI/core/base.js" type="text/javascript"></script>
	<script src="js/ligerUI/ligerui.all.js" type="text/javascript"></script>
	<script src="js/ligerUI/plugins/ligerDateEditor.js" type="text/javascript"></script>
<script type="text/javascript">
    var ClassData = { Rows: [<%String s = (String) request.getAttribute("classlist");%> <%=s%>]};
    var ClassList = ClassData.Rows;
    
   	$(f_initGrid);
	var manager, g;
	function f_initGrid() {
		g = manager = $("#maingrid").ligerGrid(
			{columns : [
			{display : '序号',  name : 'id',     width : 40,  type : 'int',hide:true},
			{display : '姓名', name : 'teachername', minWidth : 80,  editor:{type:'text'}	},
			{display : '职称', name : 'position', minWidth : 30,  editor:{type:'text'}},	
            {display : '编号', name : 'identificationnum', minWidth : 30 }, 
            {display : '电话', name : 'telephone', minWidth : 120 },
            {display : '邮箱', name : 'email', minWidth : 120 }
            ],
			onSelectRow : function(rowdata, rowindex) {
				$("#txtrowindex").val(rowindex);
			},
			//checkbox:true,
			enabledEdit : true,
			clickToEdit : false,
			isScroll : false,
			rownumbers:true, 
			pageSize:15,
			url :"${pageContext.request.contextPath}/system/Class_classTeacherList.action",
			width : '100%',
			});
	}	 
	
	 function confirm () {
	  	var row = manager.getSelectedRow();
	  	var ident =  row.identificationnum;
	  	if (ident == ""){
	  		alert("请选择班主任！");
	  		return;
	  	}
	 	var url = "${pageContext.request.contextPath}/system/Class_howManyClass.action?queryID=" + ident;
	 	//alert("here");		
			$.ajax({  
		        type : "POST",  
		        url : url,
		        dataType : "JSON", 
		        error: function (){
		        	alert("服务器错误，请联系管理员!");
		        },
		        success : function(data) {
		        	if (data.length > 0){
		        		var msg = "该教师已经是";	
		        		for(var n=0;n<data.length;n++){
		        			msg = msg + data[n].classname + " ";	
		          		}; 
		          		msg = msg + "的班主任了，是否继续？";
		          		tips(msg, ident);
		          		return;	
		        	} else {
		        		print(ident);
		        	};
		        }  
		    }); 
	 }
	 
	 function print(ident){
	  //alert("here");
	  var url = "${pageContext.request.contextPath}/system/Class_setHeadTeacher.action?queryID="+ident;
	  $.post(url, null, function() {
			parent.m.hide();
			//parent.window.location.reload();
			parent.g.loadData();
		});
	}
	 
	 function tips (msg, ident) { 	
	 	$.ligerDialog.confirm(msg, function (yes)
       {
 			if (yes == true){
 				print(ident);
 			}   
       }); 
	 }
	 
	 function fuzzy () {
		var t = $("#keyword").val();
		$("#maingrid").ligerGrid({
		  url:"${pageContext.request.contextPath}/system/Class_classTeacherFuzzy.action?fuzzyText=" + encodeURI(encodeURI(t)),
		});
	}
	 
</script>
	</head>
	<body style="padding: 2px">
	 <!-- <a class="l-button" style="width:70px;float:left; margin:3px;" onclick="tips('aa')">选&nbsp;&nbsp;择</a> -->       
	 <!-- <a class="l-button" style="width:70px;float:left; margin:3px;" onclick="print()">打&nbsp;&nbsp;印</a> -->
	 
	 <table style="width:800px;margin-bottom: 10px">
	 	<tr>
	 		<td width="30px"></td>
	 		<td><input type="text" id="keyword" onkeyup="fuzzy()" style="font-size:12px; width:180px;" placeholder="姓名 编号 职称"></td>
	 		<td width="30px"></td>
	 		<td><a class="l-button" style="width:150px;font-size:12px;float:left; margin:3px;" onclick="confirm()">设置为班主任</a></td>
	 		<td></td>
	 	</tr>
	 </table>
	 
		<div class="l-clear"></div>
		<div id="maingrid" ></div>
	</body>
</html>

