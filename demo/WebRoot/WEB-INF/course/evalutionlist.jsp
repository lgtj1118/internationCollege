<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<title>天津工业大学国际教育学院教学服务系统</title>
<link href="<%=basePath%>js/ligerUI/skins/Gray/css/form.cssrel="stylesheet" type="text/css" />
<link href="<%=basePath%>js/ligerUI/skins/Gray/css/common.css"rel="stylesheet" type="text/css" />
<script src="<%=basePath%>js/jquery/jquery-1.3.2.min.js"type="text/javascript"></script>
<script src="<%=basePath%>js/ligerUI/core/base.js"type="text/javascript"></script>
<script src="<%=basePath%>js/ligerUI/ligerui.all.js"type="text/javascript"></script>
<script src="<%=basePath%>js/jquery-validation/jquery.validate.min.js"type="text/javascript"></script>
<script src="<%=basePath%>js/jquery-validation/jquery.metadata.js"type="text/javascript"></script>
<script src="<%=basePath%>js/jquery-validation/messages_cn.js"type="text/javascript"></script>
<script type="text/javascript">
	var eee;
	$(function(){
		$.metadata.setType("attr", "validate");
		var v = $("form").validate({
				debug : true,
				errorPlacement : function(lable , element){
					if (element.hasClass("l-textarea")) {
						element.ligerTip({
							content : lable.html(),
							target : element[0]
						});
					} else if (element.hasClass("l-text-field")) {
						element.parent().ligerTip({
							content : lable.html(),
							target : element[0]
						});
					} else {
						lable.appendTo(element.parents("td:first").next("td"));
					}
				},
				success : function(lable){
					lable.ligerHideTip();
					lable.remove();
				},
				submitHandler : function(){
					$("form .l-text,.l-textarea").ligerHideTip();
					var val1=$('input:radio[name="incicators1"]:checked').val();
					var val2=$('input:radio[name="incicators2"]:checked').val();
					var val3=$('input:radio[name="incicators3"]:checked').val();
					var val4=$('input:radio[name="incicators4"]:checked').val();
					var val5=$('input:radio[name="incicators5"]:checked').val();
					var val6=$('input:radio[name="incicators6"]:checked').val();
					var val7=$('input:radio[name="incicators7"]:checked').val();
					//var val8=$('input:radio[name="summary"]:checked').val();
					var flag = $("#flg").val();
					if((val1==null)||(val2==null)||(val3==null)||(val4==null)||(val5==null)||(val6==null)||(val7==null)){alert('请全部选中');return false;}
					else{
					  if(flag==0){
					      $.post("${pageContext.request.contextPath}/system/Manage_evalutionteacheradd.action?evalution.courseid=" + encodeURI(encodeURI($("#courseid").val()))
					         + "&evalution.teacher=" + encodeURI(encodeURI($("#teacher").val()))
					         + "&evalution.incicators1=" + val1
					         + "&evalution.incicators2=" + val2
					         + "&evalution.incicators3=" + val3
					         + "&evalution.incicators4=" + val4
					         + "&evalution.incicators5=" + val5
					         + "&evalution.incicators6=" + val6
					         + "&evalution.incicators7=" + val7
					         // + "&evalution.summary=" + val8
					         + "&evalution.flag=" + $("#flg").val()
					         + "&evalution.extrude=" + encodeURI(encodeURI($("#extrude").val()))
					         + "&evalution.advice=" + encodeURI(encodeURI($("#advice").val()))					   
					         , null, function(){
					      	  alert('评价成功!');	
					          document.getElementById("Button1").value="已提交";	
					          document.getElementById("Button1").disabled=true;
					          top.f_closeTab();	
						  }); 
					  }else{
					      $.post("${pageContext.request.contextPath}/system/Manage_evalutionteacheradd.action?evalution.teacher=" + encodeURI(encodeURI($("#teacher").val()))
					         + "&evalution.incicators1=" + val1
					         + "&evalution.incicators2=" + val2
					         + "&evalution.incicators3=" + val3
					         + "&evalution.incicators4=" + val4
					         + "&evalution.incicators5=" + val5
					         + "&evalution.incicators6=" + val6
					         + "&evalution.incicators7=" + val7
					         // + "&evalution.summary=" + val8
					         + "&evalution.flag=" + $("#flg").val()
					         + "&evalution.extrude=" + encodeURI(encodeURI($("#extrude").val()))
					         + "&evalution.advice=" + encodeURI(encodeURI($("#advice").val()))					   
					         , null, function(){
					      	    alert('评价成功!');	
					            document.getElementById("Button1").value="已提交";	
					            document.getElementById("Button1").disabled=true;
					            top.f_closeTab();	
						    }); 
					  }
					  
					}					
				}
			});
		$("form").ligerForm();
		$(".l-button-test").click(function(){
			alert(v.element($("#txtName")));
		});
	});
	var i = 30;
	var intervalid;
	intervalid = setInterval("fun()", 1000);
	function fun(){
		if (i == 0) {
			document.getElementById("Button1").disabled=false;
			document.getElementById("mes").style.display="none";
			document.getElementById("mes1").style.display="none";
			clearInterval(intervalid);
		}
		document.getElementById("mes").innerHTML = i;
		i--;
	}
	
</script>
<style type="text/css">
#content {
	width: 90%;
	text-align: center;
}
table {
	margin: 10px 50px auto;
	width: 100%;
	border-collapse:collapse;
	border: 2px solid #d7d7d7;
}
table td,th{
   border:2px solid #d7d7d7;
   margin: 5px 2px 5px;
   text-align: center;
   padding: 5px 10px;
   font-size: 14px;
}
textarea {
	width: 100%;
	height:60px;
}
label{
  width: 100%;
  height: 20px;
}
input {
	width: 100%;
	height: 20px;
	
}
.tabletd{
   text-align: left;
   margin-left: 10px;
}

</style>
</head>
<body onload="fun()">
	<div id="contain">
		<div id="content">
			<form name="form1" method="post" action="" id="form1">			
			<input type="hidden" value="${flag }" id="flg"/>
				<table>
					<tr>
						<th colspan="6" height="100px"><font size="5" face="微软雅黑">对外汉语课程教学质量调查表（试用）</font><br>
						<br> <span align="cnter"> 天津工业大学  &nbsp;&nbsp; 国际教育学院 &nbsp; &nbsp; </span></th>
					</tr>
					<s:if test="#flag==1">
					  <tr>
						<th rowspan="2" width="80px">指 标</td>
						<td>班主任</td><th colspan="4"><input value="${te.identificationnum }" id="teacher" type="hidden" />${te.teachername }</th>
					</tr>
					</s:if>
					<s:elseif test="#flag==0">
					<input type="hidden" value="${courses.num }" id="courseid"/>
					    <tr>
						<th rowspan="3" width="80px">指 标</td>
						<td>课程名称</td><th colspan="4">${courses.coursename}</th>
					</tr>
					<tr>
						<td>任课教师</td><th colspan="4"><input value="${te.identificationnum }" id="teacher" type="hidden" />${te.teachername }</th>
					</tr>
					</s:elseif>
					 
					<tr>
						<td>内涵/评价等级</td>
						<td >优秀≥90</td>
						<td >良好≥75</td>
						<td >及格≥60</td>
						<td >不及格<60</td>
					</tr>
					<tr>
						<td>教学态度</td>
						<td class="tabletd">备课充分，讲课认真</td>
						<td ><label><input name="incicators1" type="radio" value="1" align="center" /></label> </td>
						<td><label><input name="incicators1" type="radio" value="2" /></label> </td>
						<td><label><input name="incicators1" type="radio" value="3" /></label> </td>
						<td><label><input name="incicators1" type="radio" value="4" /></label> </td>
					</tr>
					<tr>
						<td>因材施教</td>
						<td class="tabletd">针对留学生的不同特点进行教学</td>
						<td><label><input name="incicators2" type="radio" value="1" /></label> </td>
						<td><label><input name="incicators2" type="radio" value="2" /></label> </td>
						<td><label><input name="incicators2" type="radio" value="3" /></label> </td>
						<td><label><input name="incicators2" type="radio" value="4" /></label> </td>
					</tr>
					<tr>
						<td>教学内容</td>
						<td class="tabletd">精选教学内容，突出重点难点</td>
						<td><label><input name="incicators3" type="radio" value="1" /></label> </td>
						<td><label><input name="incicators3" type="radio" value="2" /></label> </td>
						<td><label><input name="incicators3" type="radio" value="3" /></label> </td>
						<td><label><input name="incicators3" type="radio" value="4" /></label> </td>
					</tr>
					<tr>
						<td>语言板书</td>
						<td class="tabletd">发音标准，语言精练生动、富于启发性、板书规范、层次分明</td>
						<td><label><input name="incicators4" type="radio" value="1" /></label> </td>
						<td><label><input name="incicators4" type="radio" value="2" /></label> </td>
						<td><label><input name="incicators4" type="radio" value="3" /></label> </td>
						<td><label><input name="incicators4" type="radio" value="4" /></label> </td>
					</tr>
					<tr>
						<td>教学方法</td>
						<td class="tabletd">根据课程特点，精心设计情景教学、增加会话机会、提高理解和语言表达能力</td>
						<td><label><input name="incicators5" type="radio" value="1" /></label> </td>
						<td><label><input name="incicators5" type="radio" value="2" /></label> </td>
						<td><label><input name="incicators5" type="radio" value="3" /></label> </td>
						<td><label><input name="incicators5" type="radio" value="4" /></label> </td>
					</tr>
					<tr>
						<td>教学效果</td>
						<td class="tabletd">通过课程学习，汉语知识明显长进，具有一定的听、说、读、写能力</td>
						<td><label><input name="incicators6" type="radio" value="1" /></label> </td>
						<td><label><input name="incicators6" type="radio" value="2" /></label> </td>
						<td><label><input name="incicators6" type="radio" value="3" /></label> </td>
						<td><label><input name="incicators6" type="radio" value="4" /></label> </td>
					</tr>
					<tr>
						<td>综合评价</td>
						<td class="tabletd">对任课教师的总印象</td>
						<td><label><input name="incicators7" type="radio" value="1" /></label> </td>
						<td><label><input name="incicators7" type="radio" value="2" /></label> </td>
						<td><label><input name="incicators7" type="radio" value="3" /></label> </td>
						<td><label><input name="incicators7" type="radio" value="4" /></label> </td>
					</tr>
					<!-- <tr>
						<th colspan="2">合计（分）
						</td>
						<td><label><input name="summary"  type="radio" value="1" /></label> </td>
						<td><label><input name="summary"  type="radio" value="2" /></label> </td>
						<td><label><input name="summary"  type="radio" value="3" /></label> </td>
						<td><label><input name="summary"  type="radio" value="4" /></label> </td>
					</tr> -->
					<tr>
						<th colspan="2">突出优点或问题</td>
						<th colspan="4"><textarea id="extrude" placeholder="请输入优点或问题"></textarea></th>
					</tr>
					<tr>
						<th colspan="2">建议与希望</td>
						<th colspan="4"><textarea id="advice" placeholder="建议与希望"></textarea></th>
					</tr>
					<tr>
						<th colspan="6" class="tabletd" style="font-size: 12px;">注：请选择认定分数的栏目</th>
					</tr>
				</table>
				<input type="submit" value="提&nbsp;&nbsp;交" id="Button1" disabled="disabled" align="center" class="l-button l-button-submit"  ></input><span id="mes" style="color: #D7d7d7" >30</span ><span id="mes1" style="color: #D7d7d7">秒后可操作</span>
			</form>
		</div>

	</div>
</body>
</html>
