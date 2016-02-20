<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title></title>
<link href="<%=basePath%>js/ligerUI/skins/Gray/css/form.css" rel="stylesheet"type="text/css" />
<link href="<%=basePath%>js/ligerUI/skins/Gray/css/common.css" rel="stylesheet"type="text/css" />
<script src="<%=basePath%>js/jquery/jquery-1.6.min.js" type="text/javascript"></script>
<script src="<%=basePath%>js/ligerUI/core/base.js" type="text/javascript"></script>
<script src="<%=basePath%>js/ligerUI/plugins/ligerForm.js" type="text/javascript"></script>
<script src="<%=basePath%>js/ligerUI/plugins/ligerDateEditor.js" type="text/javascript"></script>
<script src="<%=basePath%>js/ligerUI/plugins/ligerComboBox.js" type="text/javascript"></script>
<script src="<%=basePath%>js/ligerUI/plugins/ligerSpinner.js" type="text/javascript"></script>
<script src="<%=basePath%>js/ligerUI/plugins/ligerTextBox.js" type="text/javascript"></script>
<%-- <script src="<%=basePath%>js/ligerUI/plugins/ligerRadio.js" type="text/javascript"></script> --%>
<script src="<%=basePath%>js/ligerUI/plugins/ligerTip.js" type="text/javascript"></script>
<script src="<%=basePath%>js/jquery-validation/jquery.validate.min.js"type="text/javascript"></script>
<script src="<%=basePath%>js/jquery-validation/jquery.metadata.js" type="text/javascript"></script>
<script src="<%=basePath%>js/jquery-validation/messages_cn.js" type="text/javascript"></script>
<script type="text/javascript">
	var eee;
        $(function () {
            $.metadata.setType("attr", "validate");
            var v = $("form").validate({
                //调试状态，不会提交数据的
                debug: true,
                errorPlacement: function (lable, element) {

                    if (element.hasClass("l-textarea")) {
                        element.addClass("l-textarea-invalid");
                    }
                    else if (element.hasClass("l-text-field")) {
                        element.parent().addClass("l-text-invalid");
                    }

                    var nextCell = element.parents("td:first").next("td");
                    if (nextCell.find("div.l-exclamation").length == 0) {
                        $('<div class="l-exclamation" title="' + lable.html() + '"></div>').appendTo(nextCell).ligerTip();
                    }
                },
                invalidHandler: function (form, validator) {
                    var errors = validator.numberOfInvalids();
                    if (errors) {
                        var message = errors == 1
                          ? '该字段不能为空！'
                          : '这 ' + errors + ' 个字段不能为空！';
                        $("#errorLabelContainer").html(message).show();
                    }
                },
			submitHandler : function() {
				$("form .l-text,.l-textarea").ligerHideTip();	
				check1();
				if(flg1){			
				$.post("${pageContext.request.contextPath}/system/Manage_courseclassscoreendadd.action?chosenCourse.courseId="+$("#coursenum").val()
				+"&chosenCourse.passport="+$("#stunum").val()
				+"&chosenCourse.attendence="+$("#attendence").val()
				+"&chosenCourse.homework="+$("#homework").val()
				+"&chosenCourse.midexam="+$("#midexam").val()
				+"&chosenCourse.finalexam="+$("#finalexam").val()
				+"&chosenCourse.semester="+$("#semester").val()
				,null,function(){
		       // alert('添加成功!');
		        parent.m.hide();
		        parent.window.location.reload();
	           // parent.g.loadData();
		       });
			 }	
			 }		
		});
		$("form").ligerForm();
		$(".l-button-test").click(function() {
			alert(v.element($("#txtName")));
		});

	});	
	var flg = true;
	function check() {	    		
		$.post("${pageContext.request.contextPath}/system/Class_stucheck.action?stu.stuid="
					+ $("#stunum").val()+"&cls.id="+$("#classid").val()+"&stu.stuname="+$("#stuname").val(), null, function(data) {
					if (data == "fail") {
						$("#result").html("该班级不存在该学生或学号跟学生姓名不符!");
						$("#result").show();
						flg = false;
					} else {
						$("#result").hide();
					}
				});
			
	}
	var flg1 = false;
	function check1(){
	  var attendence = $("#attendence").val();
	  var homework = $("#homework").val();
	  var midexam = $("#midexam").val();
	  var finalexam = $("#finalexam").val();
	  if(attendence.length==0||homework==0||midexam==0||finalexam==0){
	    $("#result2").html("成绩填写不能留空!");
		$("#result2").show();
		flg1 = false;
	  }else{
	   $("#result2").hide();
	   if(isNaN(attendence)||isNaN(homework)||isNaN(midexam)||isNaN(finalexam)){
	      $("#result2").html("成绩只能为数字!");
		  $("#result2").show();
		  flg1 = false;
	   }else{
	     $("#result2").hide();
	     if((parseInt(attendence)>100)||(parseInt(homework)>100)||(parseInt(midexam)>100)||(parseInt(finalexam)>100)){
	        $("#result2").html("成绩填写有误，请重新填写!");
		    $("#result2").show();
		    flg1 = false;
	     }else{
	       $("#result2").hide();
	       flg1=true;
	     }	  
	  }
	  
	  }	  
	}	
</script>
<style type="text/css">
body{ font-size:12px;}
.l-table-edit {}
.l-table-edit-td{ padding:4px;}
.l-button-submit,.l-button-test{width:80px; float:left; margin-left:10px; padding-bottom:2px;}
.l-verify-tip{ left:230px; top:120px;}
#errorLabelContainer{ padding:10px; width:300px; border:1px solid #FF4466; display:none; background:#FFEEEE; color:Red;}

</style>

</head>

<body style="padding: 10px">
    
	<form name="form1" method="post" action="" id="form1">
	    <input id="semester" value="${semester }" type="hidden" />
    <input id="coursenum" value="${coursenum }" type="hidden"/>
    <input id="classid" value="${classid }" type="hidden"/>
		<div id="errorLabelContainer" class="l-text-invalid"></div>
		<table cellpadding="0" cellspacing="0" class="l-table-edit">
			<tr>
				<td align="right" class="l-table-edit-td">护照号:</td>
				<td align="left" class="l-table-edit-td"><input name="stunum"type="text"  id="stunum" ltype="text" value="${student.passport }" disabled="disabled" /></td>
				<td align="left"></td>
			</tr>
			<tr>
				<td align="right" class="l-table-edit-td">姓名:</td>
				<td align="left" class="l-table-edit-td"><input name="stuname"type="text" id="stuname" value="${student.stuname }" disabled="disabled" /></td>
				<td align="left"><label></label></td>
			</tr>
			<tr>
				<td align="right" class="l-table-edit-td">出勤成绩:</td>
				<s:if test="#cho.attendence==null" >
				   <td align="left" class="l-table-edit-td"><input name="attendence"type="text"  id="attendence" onchange="check1()" ltype="text"  value="0"  /></td>
				</s:if>
				<s:else>
				   <td align="left" class="l-table-edit-td"><input name="attendence"type="text"  id="attendence" onchange="check1()" ltype="text"  value="${cho.attendence }"  /></td>
				</s:else>
				<td align="left"></td>
			</tr>
			<tr>
				<td align="right" class="l-table-edit-td">作业成绩:</td>
				<s:if test="#cho.homework==null" >
				   <td align="left" class="l-table-edit-td"><input name="homework"type="text"  id="homework" onchange="check1()" ltype="text"  value="0"  /></td>
				</s:if>
				<s:else>
				   <td align="left" class="l-table-edit-td"><input name="homework"type="text"  id="homework" onchange="check1()" ltype="text"  value="${cho.homework }"  /></td>
				</s:else>
				<td align="left"></td>
			</tr>
			<tr>
				<td align="right" class="l-table-edit-td">期中成绩:</td>
				<s:if test="#cho.midexam==null" >
				   <td align="left" class="l-table-edit-td"><input name="midexam"type="text"  id="midexam" onchange="check1()" ltype="text"  value="0"  /></td>
				</s:if>
				<s:else>
				   <td align="left" class="l-table-edit-td"><input name="midexam"type="text"  id="midexam" onchange="check1()" ltype="text"  value="${cho.midexam }"  /></td>
				</s:else>
				<td align="left"><label></label></td>
			</tr>
			<tr>
				<td align="right" class="l-table-edit-td">期末成绩:</td>
				<s:if test="#cho.finalexam==null" >
				   <td align="left" class="l-table-edit-td"><input name="finalexam"type="text"  id="finalexam" onchange="check1()" ltype="text"  value="0"  /></td>
				</s:if>
				<s:else>
				   <td align="left" class="l-table-edit-td"><input name="finalexam"type="text"  id="finalexam" onchange="check1()" ltype="text"  value="${cho.finalexam }"  /></td>
				</s:else>
				<td align="left"></td>
			</tr>									 			
			<tr>
				<td align="right" class="l-table-edit-td"></td>
				<td align="left"><div id="result2" style="color: red;"></div></td>
				<td align="left" class="l-table-edit-td"></td>
				
			</tr>
			<tr>
				<th align="center" class="l-table-edit-td"colspan="3"><div id="result" style="color: red;"></div></th>								
			</tr>
			<tr>
				<td align="right" class="l-table-edit-td"></td>
				<td align="left" class="l-table-edit-td"><br />
				 <input type="submit" value="保&nbsp;&nbsp;存" id="Button1" class="l-button l-button-submit" />
				</td>
				</td>
				<td align="left">
			</tr>
		</table>
		<br />
	</form>
</body>
</html>