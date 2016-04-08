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
    <script src="<%=basePath%>js/ligerUI/plugins/ligerDateEditor.js" type="text/javascript"></script>
	<script src="<%=basePath%>js/jquery.date_input.pack.js" type="text/javascript"></script>
	<link href="<%=basePath%>js/ligerUI/skins/Gray/css/form.css"rel="stylesheet" type="text/css" />
	<link href="<%=basePath%>js/ligerUI/skins/Gray/css/common.css"rel="stylesheet" type="text/css" />
	<link href="<%=basePath%>css/date.css" rel="stylesheet" type="text/css" />
	<style type="text/css">
body {
	font-size: 12px;
}

.l-table-edit {
	margin-left: 80px;
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
/* .date_selector .month_nav{float: left;width: 40%;}
.date_selector .year_nav{float: right;width: 35%;margin-right: 60px;} */
textarea {
	width: 100%;
	height: 100px;
}
</style>
  </head>
  <script type="text/javascript">	
		function uniqueChk (){
			var num = $("#number").val();
			var name = $("#name").val();			
			var url = "${pageContext.request.contextPath}/system/Class_courseUniqueChk.action?course.coursename="
					    + encodeURI(encodeURI(name))
						+ "&course.num=" + num;
			$.ajax({  
		        type : "POST",  
		        url : url,
		        dataType : "JSON", 
		        error: function (){
		        	alert("数据传输错误，请联系管理员！");
		        	return false;
		        },
		        success : function(data) {
		        	
		        	if (data.length > 0){ 
		        		//alert("not pass");
		        		return false;
		        	} else {	   
		        		//alert("pass");    		
		        		return true;
		        	}
		        }  
		    }); 		
		}
		
		function clear(){
			$("#msg").text(" ");
		}
		
		function err (msg){
			$("#msg").text(msg);
		}
		
		function submit(){
			var number = $("#number");
 			var name = $("#name");
 			var beginweek = $("#beginweek");
 			var endweek = $("#endweek");
 			var credit = $("#credit");
 			var weeklesson = $("#weeklesson");
 			var character = $("#character");
 			var college = $("#college");
 			var teacher = $("#teacher");
 			var nameEN = $("#nameEN");
 			clear();
			/* if (!validate_required(number,"课程编号不能为空")){
				return false;
			}
			var reg1 = /^[1-9][0-9]{7}$/;
			
			if (!reg1.test(number.val())){
				err("课程编号只能为8位数字");
				return false;
			} */
			
			if (!validate_required(name,"课程名不能为空")){
				return false;
			}
			//var reg = /^(?![0-9])[a-zA-Z0-9_\u4e00-\u9fa5]{2,}$/;
			var reg = /^\S{2,}$/;
			if(!reg.test(name.val())){
				err("课程名由2个以上的中英文字符组成");
				return;
			}
			//alert("here");
			var regx = /^[a-zA-Z\s]{2,}$/;
			//alert($("#nameEN").val());
			if (!validate_required(nameEN, "课程英文名不能为空")) {
				return;			
			}
			
			if (!regx.test(nameEN.val())) {
				err ("课程英文名应由2个或以上英文字符构成");
				return;
			}
			
			/* var url1 = "${pageContext.request.contextPath}/system/Class_courseUniqueChk.action?course.coursename="
					    + encodeURI(encodeURI(name.val()))
						+ "&course.num=" + number.val();

			$.ajax({  
		        type : "POST",  
		        url : url1,
		        dataType : "JSON", 
		        error: function (){
		        	err("课程编号不能与之前的课程重复");
		        	return;
		        },
		        success : function(data) {
		        	if (data.length > 0){ 
		        		err("课程编号不能与之前的课程重复");
		        		return;
		        	} else { */
		        		//alert("pass");
		        		
			if (!validate_required(beginweek,"起始周不能为空")){
				return false;
			}
			var reg2 = /^[0-9]+$/;
			if (!reg2.test(beginweek.val())) {
				err("起始周只能是数字");
				return;
			}
			if (!validate_required(endweek,"结束周不能为空")){
				return false;
			}
			
			var reg3 = /^[0-9]{1,2}$/;
			if (!reg3.test(endweek.val())){
				err("结束周只能是数字");
				return;
			}
			if(parseInt(endweek.val()) > 21){
				err("结束周不能晚于21周");
				return;
			}
			
			var start = parseInt(beginweek.val());
			var end = parseInt(endweek.val());
			if (start > end){
				err("结束周不能早于起始周");
				return;
			}
			
			if (!validate_required(credit,"学分不能为空")){
				return false;
			}
			if (!validate_required(weeklesson,"周学时不能为空")){
				return false;
			}
			if (!validate_required(character,"课程类型不能为空")){
				return false;
			}
			if (!validate_required(college,"开设学院不能为空")){
				return false;
			}
			
			var teacher = $("#teacher").val();

			if(teacher != ""){
				var regg = /^[a-zA-Z\s\u4e00-\u9fa5]{2,}$/;
				if (!regg.test(teacher)){
					err("教师姓名只能由2个以上的中英文组成");
					return;
				}
				
			} 
			
			 var url = "${pageContext.request.contextPath}/system/Class_courseendadd.action?course.coursename="
				+  encodeURI(encodeURI($("#name").val()))
		        +"&course.teacher="+  encodeURI(encodeURI($("#teacher").val()))
		        +"&course.character="+  encodeURI(encodeURI($("#character").val()))
		        +"&course.beginweeks="+ $("#beginweek").val()
		        +"&course.endweeks="+ $("#endweek").val()
		        +"&course.credits="+ $("#credit").val()
		        +"&course.weeklesson="+ $("#weeklesson").val()
		        +"&course.academic="+ encodeURI(encodeURI($("#college").val()))
		        +"&course.num="+  encodeURI(encodeURI($("#number").val()))
		        +"&course.coursename_en=" + nameEN.val();
    		
    		//alert(nameEN.val());
    		
    		$.post(url,null,function(){
    		    parent.window.location.reload();
    		    window.close(); 
	        });
		     /*    	}
		        }  
		    });  */
		    
		}
		
		function validate_required(ids,alerttxt)
		{
			if (ids.val() == null || ids.val() == ""){
				$("#msg").text(alerttxt);
				ids.focus();
				return false;
			}
			return true;
		}
		
		
		
		
		
	</script>
	
	
  <body>
  
    <table cellpadding="0" cellspacing="0" class="l-table-edit" >
    	<tr style="font-size:12px">
    		<td align="center" class="l-table-edit-td">课程编号<font style="color:red; font-size:20">*</font></td>
    		<td align="center" class="l-table-edit-td">
				<input type="text" class="link" onchange="clear()" id="number">
			</td>
    		<td align="left"></td>
    	</tr>
    	<tr style="font-size:12px">
    		<td align="center" class="l-table-edit-td">课程名<font style="color:red; font-size:20">*</font></td>
    		<td align="center" class="l-table-edit-td">
				<input type="text" class="link" id="name" onchange="clear()" >
			</td>
    		<td align="left"></td>
    	</tr>
    	<tr style="font-size:12px">
    		<td align="center" class="l-table-edit-td">课程名(英文)<font style="color:red; font-size:20">*</font></td>
    		<td align="center" class="l-table-edit-td">
				<input type="text" class="link" id="nameEN" onchange="clear()" >
			</td>
    		<td align="left"></td>
    	</tr>
    	<tr style="font-size:12px">
    		<td align="center" class="l-table-edit-td">起始周<font style="color:red; font-size:20">*</font></td>
    		<td align="center" class="l-table-edit-td">
				<input type="text" class="link"  id="beginweek" onchange="clear()" >
			</td>
    		<td align="left"></td>
    	</tr>
    	
    	<tr style="font-size:12px">
    		<td align="center" class="l-table-edit-td">结束周<font style="color:red; font-size:20">*</font></td>
    		<td align="center" class="l-table-edit-td">
				<input type="text" class="link" id="endweek" onchange="clear()" >
			</td>
    		<td align="left"></td>
    	</tr>
    	<tr style="font-size:12px">
			<td align="center" class="l-table-edit-td">学分<font style="color:red; font-size:20">*</font></td>
    		<td align="center" class="l-table-edit-td" onchange="clear()" >
				<select id="credit" class="link">
					<option value="0.5">0.5</option>
					<option value="1">1</option>
					<option value="1.5">1.5</option>
					<option value="2">2</option>
					<option value="3">3</option>
					<option value="4">4</option>
					<option value="5">5</option>
					<option value="6">6</option>
					<option value="7">7</option>
					<option value="8">8</option>
					<option value="9">9</option>
				</select>
			</td>
    		<td align="left"></td>
		</tr>
		<tr style="font-size:12px">
			<td align="center" class="l-table-edit-td">周课时<font style="color:red; font-size:20">*</font></td>
    		<td align="center" class="l-table-edit-td" onchange="clear()" >
				<select id="weeklesson" class="link">
					<option value="1">1</option>
					<option value="2">2</option>
					<option value="3">3</option>
					<option value="4">4</option>
					<option value="5">5</option>
					<option value="6">6</option>
					<option value="7">7</option>
					<option value="8">8</option>
					<option value="9">9</option>
					<option value="10">10</option>
				</select>
			</td>
    		<td align="left"></td>
		</tr>
		<tr style="font-size:12px">
			<td align="center" class="l-table-edit-td">课程性质<font style="color:red; font-size:20">*</font></td>
    		<td align="center" class="l-table-edit-td" onchange="clear()" >
				<select id="character" class="link" >
				    <option value="必修">必修</option>
				    <option value="限选">限选</option>
				    <option value="任选">任选</option>
				</select>
			</td>
    		<td align="left"></td>
		</tr>
		<tr style="font-size:12px">
			<td align="center" class="l-table-edit-td">开设学院<font style="color:red; font-size:20">*</font></td>
    		<td align="center" class="l-table-edit-td" >
				 <select id="college"  class="link" onchange="clear()" >
						<option value="国际教育学院 "  >国际教育学院</option>
						<option value="纺织学院">纺织学院</option>
						<option value="材料科学与工程学院">材料科学与工程学院</option>
						<option value="环境与化学工程学院">环境与化学工程学院</option>
						<option value="机械工程学院">机械工程学院</option>
						<option value="计算机科学与软件学院">计算机科学与软件学院</option>
						<option value="电气工程与自动化学院 ">电气工程与自动化学院</option>
						<option value="电子与信息工程学院 ">电子与信息工程学院</option>
						<option value="理学院">理学院</option>
						<option value="艺术与服装学院">艺术与服装学院</option>
						<option value="管理学院 ">管理学院</option>
						<option value="经济学院">经济学院</option>
						<option value="人文与法学院">人文与法学院</option>
						<option value="外国语学院 ">外国语学院</option>
						<option value="马克思主义学院">马克思主义学院</option>
						<option value="应用技术学院">应用技术学院</option>
						<option value="继续教育学院">继续教育学院</option>
				</select>
			</td>
    		<td align="left"></td>
		</tr>
		<tr style="font-size:12px">
			<td align="center" class="l-table-edit-td">负责教师</td>
    		<td align="center" class="l-table-edit-td" >
				<input type="text" class="link" id="teacher">
			</td>
    		<td align="left"></td>
		</tr>
		<tr style="font-size:12px">
			<td align="center" class="l-table-edit-td"></td>
    		<td align="center" class="l-table-edit-td">
				<input type="submit" value="提&nbsp;交" id="Button1" 
						onclick="submit()" class="l-button l-button-submit" />
			</td>
    		<td align="left"></td>
				<!-- <td align="right" class="l-table-edit-td"></td>
				<td align="right" class="l-table-edit-td"></td>
				<td align="left" class="l-table-edit-td">
					<input type="submit" value="申&nbsp;&nbsp;请" id="Button1" 
						onclick="tosubmit()" class="l-button l-button-submit" />
				</td>
				<td align="left">
				<td align="left"> -->
		</tr>
    </table>
    <table style="font-size:14px; margin-left: 10px;">
   		<tr>
   			<p id="msg" style="color:red"></p>
   		</tr> 
    </table>
  </body>
  
</html>
