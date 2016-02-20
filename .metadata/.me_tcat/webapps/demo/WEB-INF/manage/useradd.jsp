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
                          ? '该字段输入有误！'
                          : '这 ' + errors + ' 个字段输入有误！';
                        $("#errorLabelContainer").html(message).show();
                    }
                },
                success: function (lable) {
                    var element = $("#" + lable.attr("for"));
                    var nextCell = element.parents("td:first").next("td");
                    if (element.hasClass("l-textarea")) {
                        element.removeClass("l-textarea-invalid");
                    }
                    else if (element.hasClass("l-text-field")) {
                        element.parent().removeClass("l-text-invalid");
                    }
                    nextCell.find("div.l-exclamation").remove();
                },
			submitHandler : function() {
				$("form .l-text,.l-textarea").ligerHideTip();
				check();
				check2();
				checkmobile();
				checkemail();
				if((flg)&&(flg1)&&flg3&&flg4){
				var sexid=1;
				if(document.getElementById("r2").checked){
	                 sexid="女";
                }else{
                  sexid="男";
                }              
				$.post("${pageContext.request.contextPath}/system/User_userendadd.action?user.usernum="+ $("#usernum").val()
		        +"&user.sex="+ encodeURI(encodeURI(sexid))
		        +"&deid="+ $("#depid").val()
		        +"&roles="+$("#role").val()	            
		        +"&user.username="+ encodeURI(encodeURI($("#username").val()))
		        +"&user.realname="+ encodeURI(encodeURI($("#realname").val()))
		        +"&user.telephone="+ encodeURI(encodeURI($("#telephone").val()))
		        +"&user.email="+ encodeURI(encodeURI($("#email").val())),null,function(){
		        //alert('添加成功!');
		        parent.m.hide();
	            parent.g.loadData();
		       });
			 }
			}
		});
		$("form").ligerForm();
		$(".l-button-test").click(function() {
			alert(v.element($("#txtName")));
		});

	});
	<%-- function refresh() {
	window.document.getElementById("checkimg").src = "<%=basePath%>admin/validatecode.jsp?"+ Math.random();
	}
	
	function checkcode() {
		$.post(
				"${pageContext.request.contextPath}/system/User_checkcode.action?code="
						+ $("#yan").val(), null, function(data) {
					if (data == "fail") {
						$("#result2").html("验证码输入错误！");
						flg = false;
						$("#result2").show();
					} else {
						$("#result2").hide();
						flg = true;
					}
				});
	} --%>
	var flg = false;
	function check() {	    
		var str = document.getElementById("usernum").value;
		var reg = /^[A-Za-z0-9]+$/;
		if(str.length==0){
		    $("#result").html("用户编号不能为空！");
			$("#result").show();
			flg = false;
			$("#usernum").focus();   
			return false;
		}else{
		   if(str.length<6){
		      $("#result").html("用户编号不能小于6位！");
			  $("#result").show();
			  flg = false;
		   }else{
		     $("#result").hide();
		      if (!reg.test(str)) {
			  $("#result").html("用户编号只能为英文或数字！");
			  $("#result").show();
			  flg = false;
			  $("#usernum").focus();
			return false;
		   } else {
			  $("#result").hide();
		      $.post("${pageContext.request.contextPath}/system/User_usercheck1.action?user.usernum="
						+ $("#usernum").val(), null, function(data) {
					if (data == "fail") {
						$("#result").html("该用户编号已经存在!");
						$("#result").show();
						flg = false;
					} else {
						$("#result").hide();
						flg=true;
					}
			});
		}
		   }
		   
		}					
	}
	var flg1 = false;
	function check2(){
	  var username=$("#realname").val();
	  if(username.length==0){
	      $("#result2").html("真实姓名不能为空!");
		 $("#result2").show();
		 flg1 = false; //就弹出提示信息    
	  }else{
	     $("#result2").hide();
	     var reg =/^[a-zA-Z\u4e00-\u9fa5]{2,}$/;
	     if(!reg.test(username)){
	         $("#result2").html("真实姓名由2个以上的中英文字符组成!");
		     $("#result2").show();
		     flg1 = false; //就弹出提示信息    
	     }else{
	         $("#result2").hide();
	          flg1 = true;
	     }
	  }
	}
	var flg3 = false;
	function checkmobile(){
	  var isMobile=/^(?:13\d|15\d|18\d)\d{5}(\d{3}|\*{3})$/; //手机号码验证规则
	  var mobile = document.getElementById("telephone").value;
	  if(mobile.length==0){
	     $("#result3").html("手机号码不能为空!");
		 $("#result3").show();
		// $("#telephone").focus();       //输入框获得光标
		 flg3 = false; //就弹出提示信息        
	  }else{
	     $("#result3").hide();
	     if(!isMobile.test(mobile)){ //如果用户输入的值不同时满足手机号的正则
            $("#result3").html("请输入正确的11位手机号!");
		    $("#result3").show();
		    //$("#telephone").focus();       //输入框获得光标
		    flg3 = false; //就弹出提示信息        
         }else{
            $("#result3").hide();
            flg3=true;
         }
	  }
	  
	}	
	var flg4 = false;
	function checkemail() { 
	var email = $("#email").val();
	if(email.length==0){
	  $("#result4").html("邮箱地址不能为空!");
	  $("#result4").show();
	  flg4 = false; //就弹出提示信息   
	}else{
	  $("#result4").hide();
	  if (!$("#email").val().match(/^\w+((-\w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z0-9]+$/)) { 
        $("#result4").html("请输入正确的邮箱地址!");
		$("#result4").show();
		//$("#email").focus();       //输入框获得光标
		flg4 = false; //就弹出提示信息   
     }else{
         $("#result4").hide();
         flg4=true;
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
#errorLabelContainer{ padding:10px; width:200px; border:1px solid #FF4466; display:none; background:#FFEEEE; color:Red;}
</style>

</head>

<body style="padding: 10px">

	<form name="form1" method="post" action="" id="form1">
		
		<table cellpadding="0" cellspacing="0" class="l-table-edit">
			<tr>
				<td align="right" class="l-table-edit-td">用户编号:<font color="#ff0000">*</font></td>
				<td align="left" class="l-table-edit-td"><input name="usernum"type="text"  id="usernum" onchange="check()" ltype="text" placeholder="请输入用户编号"  /></td>
				<td align="left"><div id="result" style="color: red;"></div></td>
			</tr>
			<tr>
				<td align="right" class="l-table-edit-td">用户名:</td>
				<td align="left" class="l-table-edit-td"><input name="username"type="text"  id="username" ltype="text" placeholder="请输入用户名" onchange="check1()"  /></td>
				<td align="left"><div id="result1" style="color: red;"></div></td>
			</tr>
			<tr>
				<td align="right" class="l-table-edit-td">姓名:<font color="#ff0000">*</font></td>
				<td align="left" class="l-table-edit-td"><input name="realname"type="text" id="realname" onchange="check2()" ltype="text" /></td>
				<td align="left"><div id="result2" style="color: red;"></div></td>
			</tr>
			
			<tr>
				<td align="right" class="l-table-edit-td">电话:<font color="#ff0000">*</font></td>
				<td align="left" class="l-table-edit-td"><input name="telephone"type="text" onchange="checkmobile()" id="telephone" ltype="text"  /></td>
				<td align="left"><div id="result3" style="color: red;"></div></td>
			</tr>
			<tr>
				<td align="right" class="l-table-edit-td">E-mail:<font color="#ff0000">*</font></td>
				<td align="left" class="l-table-edit-td"><input name="email"type="text" id="email" onchange="checkemail()" ltype="text" /></td>
				<td align="left"><div id="result4" style="color: red;"></div></td>
			</tr>
			<tr>
				<td align="right" class="l-table-edit-td" valign="top">性别:</td>
				<td align="left" class="l-table-edit-td"><input id="r1"
					type="radio" name="rbtnl" value="1" checked="checked" /><label
					for="rbtnl_0">男</label> <input id="r2" type="radio" name="rbtnl"
					value="2" /><label for="rbtnl_1">女</label></td>
				<td align="left"></td>
			</tr>
			<tr>
				<td align="right" class="l-table-edit-td">部门:</td>
				<td align="left" class="l-table-edit-td">
				<select name="depid" id="depid" ltype="select" style="width:140px;" >
						<s:iterator value="#deptlist" id="gg">
							<option value="<s:property value="#gg.deptid"/>"><s:property value="#gg.deptname" /></option>
						</s:iterator>
				</select></td>
			</tr>
			<tr>
				<td align="right" class="l-table-edit-td">角色:</td>
				<td align="left" class="l-table-edit-td">
				<select  name="role" id="role" ltype="select" style="width: 140px;" >  
                              <option value="1">管理员</option>                                    
                              <!--<option value="2">任课教师</option> 
                              <option value="3">学生</option>  --> 
                    </select></td>
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
				<td align="left" class="l-table-edit-td"><br /> <input
					type="submit" value="添&nbsp;&nbsp;加" id="Button1"
					class="l-button l-button-submit" />
				</td>
				</td>
				<td align="left">
			</tr>
		</table>
		<br />
	</form>
</body>
</html>