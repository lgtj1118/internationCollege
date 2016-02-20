<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
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
	<link href="<%=basePath%>css/date.css" rel="stylesheet" type="text/css"/>
    <script src="js/jquery/jquery-1.6.min.js"type="text/javascript"></script>
    <script src="js/jquery/jquery.js"type="text/javascript"></script>
	<script src="js/ligerUI/core/base.js" type="text/javascript"></script>
	<script src="js/ligerUI/ligerui.all.js" type="text/javascript"></script>
	<script src="js/ligerUI/plugins/ligerDateEditor.js" type="text/javascript"></script>
	<script src="<%=basePath%>js/jquery.date_input.pack.js" type="text/javascript"></script>
<script type="text/javascript">
$(function(){
	     $('.date_picker').date_input();
})
  var flg = false;
  function attendencesearch(){
   if ((document.all.course.value =="")&&(document.all.date.value =="")&&(document.all.type.value =="")){
	alert("对不起，请您先输入查询关键字!");
	return;
   }else{
		$.post("${pageContext.request.contextPath}/system/Manage_stuattendenceresearch.action?attendence.choosencourseid=" + encodeURI(encodeURI($("#course").val())
		+"&attendence.date="+encodeURI(encodeURI($("#date").val()))
		+"&attendence.type="+encodeURI(encodeURI($("#type").val()))), null, function(data) {
		if (data == "fail") {
			$("#result").show();
			$("#content").hide();			
			flg = false;
		} else {
			$("#content").html(data);
			$("#content").show();					
		}
	});
   }
  }
    
</script>
<style type="text/css">
body{font-size: 12px;padding: 2px}
.l-table-edit-td{font-size: 14px;padding: 5px;margin-left: 2px;}
.link{width:160px;height:25px;background: #fefefe;border: 1px solid #bbb;font-size: 14px;color: #333;border-radius: 3px;}
.data-table{ border:1px #ebebeb solid; border-bottom:none;width:70%;border-spacing: 0px;margin: auto;}
.data-table td{height:28px; padding-left:5px; border-bottom:1px #ebebeb solid;}
.td-cb{ width:20px;}
.data-table a{ color:#3377aa;text-decoration:none;}
.data-table a:hover{background:none;color:#3377aa;text-decoration:underline;}
.data-table tbody tr:hover{ background:#ffffe1;}
td .action{ width:20px; position:relative;}
.ac td .act-box a{text-decoration:none;}
.action .arrow{ text-align:center; width:16px; height:16px; border:1px solid #DADADA; cursor:pointer; z-index:-1;}
.action .arrow img{ margin-top:6px;}
.action .act-box{ position:absolute; min-width:80px; text-align:center; right:2px; background-color:White; border:1px solid #DADADA; display:none; z-index:100;}
.act-box a{ display:block; width:80px; height:20px; line-height:20px;text-decoration:none;}
.act-box a:hover{ color:White; background:#37A; text-decoration:none;}
#content{
  margin-top:20px;
}
#table3{
  margin:auto;
  margin-top: 10px;
  font-size: 15px;
  width: 350px;
}

</style>
	</head>
	<body ><br>
	<div id="head">
		  <table cellpadding="0" cellspacing="0" class="l-table-edit" >
			<tr>
				<td align="right" class="l-table-edit-td">&nbsp;课程:</td>
				<td align="left" class="l-table-edit-td">
				  <select name="course" id="course" ltype="select" class="link">
						<s:iterator value="#courselist" id="gg">
						   <option value="<s:property value="#gg.Id"/>"><s:property value="#gg.coursename" /></option>
						</s:iterator>
				</select>
				</td>
				<td align="right" class="l-table-edit-td">&nbsp;时间:</td>
				<td align="left" class="l-table-edit-td"><input  id="date" class="date_picker link"></td>
			    <!-- <td align="right" class="l-table-edit-td">&nbsp;节次:</td>
				<td align="left" class="l-table-edit-td">
				  <select id="time" name="time" class="link"   >
				    <option value=""></option>
				    <option value="8:20-10:00">第一大节</option>				  
				    <option value="10:20-12:00">第二大节</option>
				    <option value="14:00-15:40">第三大节</option>
				    <option value="16:00-17:40">第四大节</option>
				    <option value="18:30-20:10">第五大节</option>
				  </select>
				</td> -->
				<td align="right" class="l-table-edit-td">&nbsp;考勤状态:</td>
				<td align="left" class="l-table-edit-td">
				  <select id="type" name="type" class="link"  >
				    <option value=""></option>
				    <option value="0">正常</option>				  
				    <option value="1">迟到</option>
				    <option value="2">早退</option>
				    <option value="3">旷课</option>				    
				  </select>
				</td>
			</tr>						
		</table>
		<a class="l-button" style="width:70px;float:left; margin:5px 40px 5px ;" onclick="attendencesearch()">查&nbsp;&nbsp;询</a>
		</div>
		<div style="margin-top:50px;font-size: 16px;margin-left: 30px;">考勤记录：</div>
	    <div id="content"></div>
	

</body>
</html>