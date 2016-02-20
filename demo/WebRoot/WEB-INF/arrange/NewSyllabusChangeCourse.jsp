<%@ page language="java" import="java.util.*" pageEncoding="UTF8"%>
<%@page import="com.tjpu.bean.Syllabus"%>
<%@page import="com.opensymphony.xwork2.ActionContext"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <script src="<%=basePath%>js/jquery/jquery-1.6.min.js" type="text/javascript"></script>
    <link href="<%=basePath%>js/ligerUI/skins/Aqua/css/ligerui-all.css" rel="stylesheet"type="text/css" />	
	<link href="<%=basePath %>js/ligerUI/skins/Gray/css/all.css" rel="stylesheet" type="text/css"/>	
    <link href="<%=basePath%>css/date.css" rel="stylesheet" type="text/css"/>
    <script src="<%=basePath%>js/ligerUI/core/base.js" type="text/javascript"></script>
    
	
	<link href="<%=basePath%>js/ligerUI/skins/Gray/css/form.css"rel="stylesheet" type="text/css" />
	<link href="<%=basePath%>js/ligerUI/skins/Gray/css/common.css"rel="stylesheet" type="text/css" />
	<link href="<%=basePath%>css/date.css" rel="stylesheet" type="text/css" />
	<style type="text/css">
body {
	font-size: 12px;
}

.l-table-edit {
	
}

.l-table-edit-td {
	padding: 4px;
}

.l-button-submit,.l-button-test {
	width: 80px;
	float: left;
	margin-left: 10px;
	padding-bottom: 2px;
}

.l-verify-tip {
	left: 230px;
	top: 120px;
}

#errorLabelContainer {
	padding: 10px;
	width: 300px;
	border: 1px solid #FF4466;
	display: none;
	background: #FFEEEE;
	color: Red;
}

.link {
	width: 170px;
	height: 25px;
	background: #fefefe;
	border: 1px solid #bbb;
	font-size: 12px;
	color: #333;
	border-radius: 3px;
}
.date_selector .month_nav{float: left;width: 40%;}
.date_selector .year_nav{float: right;width: 35%;margin-right: 60px;}
textarea {
	width: 100%;
	height: 100px;
}
</style>
  </head>
  <script type="text/javascript">
		$(document).ready(function(){
			//alert("here");
			//$("#oldCourseName").change(selectChange());
			
		});
		
		
		function tchange() {
			$("#oldSlot").empty();
			$("#origndate").val("");
			//alert("here");
			/* $("#oldSlot").empty();
			var id = $("#oldCourseName").val();
			var url = "${pageContext.request.contextPath}/system/Manage_getCourseSlot.action?oldnum=" + id;
			$.ajax({  
		        type : "POST",  
		        url : url,
		        dataType : "JSON", 
		        error: function (){
		        	alert("error function");
		        },
		        success : function(data) {
		        	//alert(data.length); 
		        	
		          	for(var n=0;n<data.length;n++){
		                document.getElementById("oldSlot").options.add(new Option(data[n].slot + 1,data[n].slot + 1));
		          	} 
		        }  
		    }); */
			
		}
		
		
		function tchange2() {
			$("#newSlot").empty();
			$("#plandate").val("");
			//alert("here");
			/* $("#newSlot").empty();
			var id = $("#newCourseName").val();
			var url = "${pageContext.request.contextPath}/system/Manage_getNewCourseSlot.action?oldnum=" + id;
			$.ajax({  
		        type : "POST",  
		        url : url,
		        dataType : "JSON", 
		        error: function (){
		        	alert("error function");
		        },
		        success : function(data) {
		        	//alert(data.length); 
		        	
		          	for(var n=0;n<data.length;n++){
		                document.getElementById("newSlot").options.add(new Option(data[n].slot + 1,data[n].slot + 1));
		          	} 
		        }  
		    }); */
			
		}
		
		function origDateChange() {
			if ($("#oldCourseName").val() == -1){
				alert("请先选择课程");
				$("#origndate").val("");
				return;
			}
			var orgindate = $("#origndate").val();
			var thisDate = new Date(orgindate);
			var oldNum = $("#oldCourseName").val();
			var today = new Date();
			if (thisDate < today) {
				alert("日期错误");
				$("#origndate").val("");
				return;
			}
			var url = "${pageContext.request.contextPath}/system/Manage_chkOldDate.action?origndate=" + orgindate
					+ "&oldnum=" + oldNum;
			$.ajax({  
		        type : "POST",  
		        url : url,
		        dataType : "JSON", 
		        error: function (){
		        	alert("error function");
		        },
		        success : function(data) {
		        	//alert(data.length);
		        	$("#oldSlot").empty(); 
		        	if (data.length > 0){
		        		for(var n=0;n<data.length;n++){
		        			
		                	document.getElementById("oldSlot").options.add(new Option(data[n].slot + 1,data[n].slot + 1));
		          		}  
		        	} else {
		        		//$("#origDateChk").attr("value","no");
		        		alert("当天没有该课程");
		        		$("#origndate").val("");
		        	}
		        }  
		    }); 
		}
		
		function planDateChange() {
			//alert($("#newCourseName").val());
			if ($("#newCourseName").val() == -1){
				alert("请先选择课程");
				$("#plandate").val("");
				return;
			}
			
			var plandate = $("#plandate").val();
			var thisDate = new Date(plandate);
			var newNum = $("#newCourseName").val();
			var today = new Date();
			//alert(thisDate);
			//alert(today);
			if (thisDate < today) {
				alert("日期错误");
				$("#plandate").val("");
				return;
			}
			var url = "${pageContext.request.contextPath}/system/Manage_chkNewDate.action?plandate=" + plandate
					+ "&newnum=" + newNum;
			$.ajax({  
		        type : "POST",  
		        url : url,
		        dataType : "JSON", 
		        error: function (){
		        	alert("数据传输错误，请联系管理员！");
		        },
		        success : function(data) {
		        	//alert(data.length);
		        	$("#newSlot").empty(); 
		        	if (data.length > 0){
		        		for(var n=0;n<data.length;n++){
		                	document.getElementById("newSlot").options.add(new Option(data[n].slot + 1,data[n].slot + 1));
		          		}
		        	} else {
		        		//$("#origDateChk").attr("value","no");
		        		alert("当天没有该课程");
		        		$("#plandate").val("");
		        	}
		        }  
		    }); 
		}
		
		function tosubmit(){
			var newNum = $("#newCourseName").val();
			var oldNum = $("#oldCourseName").val();
			var reason = $("#reason").val();
			
			if (newNum == -1 || oldNum == -1){
				alert("请选择课程");
				return;
			}
			if (reason == ""){
				alert("请填写理由");
				return;
			}
			var origndate = $("#origndate").val();
			var plandate = $("#plandate").val();
			if (plandate == "") {
				alert("请填写计划日期");
				return;
			}
			if (origndate == "") {
				alert("请填写原课程日期");
				return;
			}
			//alert(plandate);
			var url = "${pageContext.request.contextPath}/system/Manage_applyCurrAdjustment.action?newnum="
				+ newNum + "&oldnum=" + oldNum + "&adjustReason=" + encodeURI(encodeURI(reason)) + "&origndate=" + origndate
				+ "&plandate=" + plandate + "&oldSlot=" + $("#oldSlot").val() + "&newSlot=" + $("#newSlot").val();
			//alert(url);
			$.post(url, null, function() {
			parent.m.hide();
			parent.window.location.reload();
		});
		}
		
	</script>
	
	
  <body>
  
    <table cellpadding="0" cellspacing="0" class="l-table-edit">
    	<tr>
    		<td align="center" class="l-table-edit-td">上课时间</td>
    		<td align="center" class="l-table-edit-td"><select class="link" id="weekDay"></select></td>
			<td align="center" class="l-table-edit-td"></td>
    		<td align="center" class="l-table-edit-td"><select class="link" id="slot"></select></td>
    		<td align="left"></td>
    	</tr>
    	<tr>
    		<td align="center" class="l-table-edit-td"></td>
    		<td align="center" class="l-table-edit-td"><select class="link" id="slot"></select></td>
    		<td align="center" class="l-table-edit-td">课程名：</td>
    		<td align="center" class="l-table-edit-td">
    		<%-- 	<%
					List<Syllabus> oldCourses = (List<Syllabus>) ActionContext.getContext().get("oldCourses");
				%>
				<select id="oldCourseName" onchange="tchange()" class="link" >
				<%
					for (Syllabus s : oldCourses) {
				%>
						<option value="<%=s.getId() %>"> <%=s.getCourseName() %> </option>
				<%
					}
				%>	
				</select> --%>
			</td>
				<td align="left"></td>
    		
    	</tr>
		<tr>
				<td align="right" class="l-table-edit-td"></td>
				<td align="right" class="l-table-edit-td"></td>
				<td align="left" class="l-table-edit-td">
					<input type="submit" value="调换位置" id="Button1" 
						onclick="tosubmit()" class="l-button l-button-submit" />
				</td>
				<td align="left">
				<td align="left">
		</tr>
    </table>
    <table style="font-size:14px">
   		<tr>
   			<td><strong style="color:red">注 &nbsp;</strong></td><td>1.请先选择想要调换的课程</td>
   		</tr> 
   		<tr>
   			<td><strong></strong></td><td>2.再选择日期</td>
   		</tr> 
   		<tr>
   			<td><strong></strong></td><td>3.最后选择调换的上课大节</td>
   		</tr> 
    </table>
  </body>
  
</html>
