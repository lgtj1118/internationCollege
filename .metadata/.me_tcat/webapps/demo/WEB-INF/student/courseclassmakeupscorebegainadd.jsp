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
<title>天津工业大学排课管理系统</title>
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
				   $.post("${pageContext.request.contextPath}/system/Manage_courseclassmakeupscoreendadd.action?chosenCourse.courseId="+$("#coursenum").val()
				   +"&chosenCourse.passport="+$("#stunum").val()
				   +"&chosenCourse.makeup="+$("#makeup").val()
				   +"&chosenCourse.semester="+$("#semester").val()
				   ,null,function(){
		           // alert('添加成功!');
		           parent.m.hide();
		           parent.window.location.reload();
		         });
			   }	
			 }		
		});
		$("form").ligerForm();
		$(".l-button-test").click(function() {
			alert(v.element($("#txtName")));
		});

	});	
	var flg = false;
	function check() {	    		
		$.post("${pageContext.request.contextPath}/system/Class_stucheck.action?stu.stuid="
					+ $("#stunum").val()+"&cls.id="+$("#classid").val()+"&stu.stuname="+$("#stuname").val(), null, function(data) {
					if (data == "fail") {
						$("#result").html("该班级不存在该学生或学号跟学生姓名不符!");
						$("#result").show();
						flg = false;
					} else {
						$("#result").hide();
						flg=true;
					}
				});
			
	}
	var flg1 = false;
	function check1(){
	  var attendence = $("#makeup").val();
	  var t= /^100|(^([1-9]{0,1})([0-9]{1})(\.[0-9])?)$/;
	  if(!t.test(attendence)){
	    $("#result2").html("成绩只能为0-100之间的数字!");
		$("#result2").show();
		flg1 = false;
	  }else{
	  $("#result2").hide();
	     if((parseInt(attendence)>100)){
	    $("#result2").html("成绩填写有误，请重新填写!");
		$("#result2").show();
		flg1 = false;
	  }else{
	    $("#result2").hide();
	    flg1=true;
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
    <%-- <input id="classid" value="${classid }" type="hidden"/> --%>
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
				<td align="right" class="l-table-edit-td">补考成绩:</td>
				<td align="left" class="l-table-edit-td"><input name="makeup"type="text"  id="makeup" onblur="check1()" ltype="text" value="60"  /></td>
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
				 <input type="submit" value="录&nbsp;&nbsp;入" id="Button1" class="l-button l-button-submit" />
				</td>
				</td>
				<td align="left">
			</tr>
		</table>
		<br />
	</form>
</body>
</html>