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
				check();
				check1();
				if(flg&&flg1){
				  $.post("${pageContext.request.contextPath}/system/Stu_stuchangepwd.action?stu.id="+ $("#userid").val()		       
		        +"&stu.password="+ encodeURI(encodeURI($("#newpwd").val())),null,function(){
		        alert('修改成功!');
		        parent.m.hide();
	            window.location.reload();
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
	var oldpwd=$("#oldpwd").val();
	  if(oldpwd.length==0){
	    $("#result").html("原密码不能为空!");
		$("#result").show();
		flg = false;
	  }else{
	  $("#result").hide();	    
		$.post("${pageContext.request.contextPath}/system/Stu_pwdcheck.action?stu.id="+ $("#userid").val()
		      +"&stu.password="+$("#oldpwd").val() , null, function(data) {
					if (data == "fail") {
						$("#result").html("输入的密码不正确!");
						$("#result").show();
						flg = false;
					} else {
						$("#result").hide();
						flg= true;
					}
				});
	  }   						
	}
	var flg1 = false;
	function check1(){
	 var str1 = document.getElementById("newpwd").value;
	 var str2 = document.getElementById("newpwd1").value;
	 if(str1.length==0||str2.length==0){
	    $("#result1").html("新密码不能为空！");
	    $("#result1").show();
	    flg1= false;
	 }else{
	  $("#result1").hide();
	    if(str1==str2){
	      $("#result1").hide();
	       flg1= true;
	    }else{
	       $("#result1").html("两次输入密码不一致！");
	       $("#result1").show();
	       flg1= false;
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
		<div id="errorLabelContainer" class="l-text-invalid"></div>
		<table cellpadding="0" cellspacing="0" class="l-table-edit">
			<tr><input id="userid" value="${userid }" type="hidden"/>
				<td align="right" class="l-table-edit-td"><label>原密码:</label><font color="#ff0000">*</font></td>
				<td align="left" class="l-table-edit-td"><input name="oldpwd"type="password" onchange="check()" id="oldpwd" ltype="text" placeholder="请输入原密码"  /></td>
				<td align="left"><div id="result" style="color: red;"></div></td>
			</tr>
			<tr>
				<td align="right" class="l-table-edit-td">新密码:<font color="#ff0000">*</font></td>
				<td align="left" class="l-table-edit-td"><input name="newpwd"type="password" id="newpwd" ltype="text" placeholder="请输入新密码"  /></td>
				<td align="left"></td>
			</tr>
			<tr>
				<td align="right" class="l-table-edit-td">确认密码:<font color="#ff0000">*</font></td>
				<td align="left" class="l-table-edit-td"><input name="newpwd1"type="password" id="newpwd1" onchange="check1()"placeholder="请再次输入新密码" ltype="text" /></td>
			    <td align="left"><div id="result1" style="color: red;"></div></td>
			</tr>			 
			
			<tr>
				<th align="center" class="l-table-edit-td"colspan="3"></th>								
			</tr>
			<tr>
				<td align="right" class="l-table-edit-td"></td>
				<td align="left" class="l-table-edit-td"><br />
				<input type="submit" value="修&nbsp;&nbsp;改" id="Button1" class="l-button l-button-submit" />
				</td>
				<td align="left"></td>
			</tr>
		</table>
		<br />
	</form>
</body>
</html>