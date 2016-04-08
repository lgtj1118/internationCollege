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
				checkmobile();
				//checkemail();&&flg2
				check3();
				checkdept();
				if(flg1&&flg3&&flg4){
				var sexid=1;
				if(document.getElementById("r2").checked){
	                 sexid="女";
                }else{
                  sexid="男";
                }              
				$.post("${pageContext.request.contextPath}/system/Manage_teacherupdate.action?teacher.identificationnum="+ $("#usernum").val()
		        +"&teacher.sex="+ encodeURI(encodeURI(sexid))
		        +"&teacher.id="+ encodeURI(encodeURI($("#id").val()))
		        +"&depid="+ $("#depid").val()
		        //+"&role="+$("#role").val()	
		        +"&teacher.position="+ encodeURI(encodeURI($("#position").val()))            
		        +"&teacher.teachername="+ encodeURI(encodeURI($("#realname").val()))
		        +"&teacher.telephone="+ encodeURI(encodeURI($("#telephone").val()))
		        +"&teacher.email="+ encodeURI(encodeURI($("#email").val())),null,function(){
		        //alert('更新成功!');
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
    var flg = true;
	function check() {	    
		var str = document.getElementById("usernum").value;
		if(str.length==0){
		    $("#result").html("用户编号不能为空！");
			$("#result").show();
			flg = false;
		}else{
		   $("#result").hide();
		   var reg = /^[\u4e00-\u9fa5]+$/gi;
		 if (reg.test(str)) {
			$("#result").html("用户编号不能包含中文！");
			$("#result").show();
			flg = false;
			document.regFrm.username.focus();
			return false;
		} else {
			$("#result").hide();
			if(str.length!=8){
			   $("#result").html("用户编号为8位有效数字！");
			   $("#result").show();
			   flg = false;
			}else{
			$("#result").hide();
			   $.post("${pageContext.request.contextPath}/system/Manage_teachercheck.action?teacher.identificationnum="
						+ $("#usernum").val(), null, function(data) {
					if (data == "fail") {
						$("#result").html("该用户编号已经存在!");
						$("#result").show();
						flg = false;
					} else {
						$("#result").hide();
						flg = false;
					}
				});
			}
		   } 
		}
		
				
	}
	var flg1 = false;
	function checkmobile(){
	 
	  var isMobile=/^(?:13\d|15\d|18\d)\d{5}(\d{3}|\*{3})$/; //手机号码验证规则
	  var mobile = document.getElementById("telephone").value;
	  if(mobile.length==0){
	     $("#result1").html("手机号码不能为空!");
		 $("#result1").show();
		 $("#telephone").focus();       //输入框获得光标
		 flg1 = false; //就弹出提示信息   
	  }else{
	  $("#result1").hide();
	   if(!isMobile.test(mobile)){ //如果用户输入的值不同时满足手机号的正则
         $("#result1").html("请输入正确的11位手机号!");
		 $("#result1").show();
		 $("#telephone").focus();       //输入框获得光标
		 flg1 = false; //就弹出提示信息        
      }else{
         $("#result1").hide();
         flg1=true;
      }
	  }
	  
	}	
	var flg2 = false;
	function checkemail() { 
	 var email = $("#email").val();
	 if(email.length!=0){
	   /*  $("#result2").html("邮箱地址不能为空!");
		$("#result2").show();
		$("#email").focus();       //输入框获得光标
		flg2 = false; //就弹出提示信息
	 }else{ */
	   $("#result2").hide();
	   if (!$("#email").val().match(/^\w+((-\w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z0-9]+$/)) { 
        $("#result2").html("请输入正确的邮箱地址!");
		$("#result2").show();
		$("#email").focus();       //输入框获得光标
		flg2 = false; //就弹出提示信息   
     }else{
         $("#result2").hide();
         flg2=true;
     }
	 }     
} 
var flg3=false;
	function check3(){
	  var realname=$("#realname").val();
	  if(realname==0){
	   $("#result3").html("教师姓名不能为空！");
	   $("#result3").show();
	   flg3=false;
	  }else{
	    $("#result3").hide();
	    var reg = /^[a-zA-Z\u4e00-\u9fa5]{2,}$/;
	    if(!reg.test(realname)){
	    $("#result3").html("姓名由2个以上的中英文字符组成！");
	         $("#result3").show();
	         flg3=false; 
	     }else{
	        $("#result3").hide();
	        flg3=true;
	     }
	  }
	}
	var flg4=false;
	function checkdept(){
	  var deptid = $("#deptids").val();
	  var newdeptid = $("#depid").val();
	  var teachername = $("#realname").val();
	  $.post("${pageContext.request.contextPath}/system/User_deptcheckteacher.action?dept.deptid="+deptid+"&identificationnum="+$("#identificationnum").val()+"&newdeptid="+newdeptid,null,function(data){
	     if(data=="fail"){
	        $("#result4").html("该老师已经设置为部门负责人，不能修改部门，如需修改，请先修改部门负责人！");
	        $("#result4").show();
	        flg4 = false;
	     }else{
	        $("#result4").hide();
	        flg4=true;
	     }	     
	  })
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
		<input id="id" value="${teachers.id }" type="hidden" />
		<input id="identificationnum" value="${teachers.identificationnum }" type="hidden" />
		<input id="deptids" value="${teachers.dept.deptid }" type="hidden" />
		<table cellpadding="0" cellspacing="0" class="l-table-edit">
			<tr>
				<td align="right" class="l-table-edit-td">用户编号:<font color="#ff0000">*</font></td>
				<td align="left" class="l-table-edit-td"><input name="usernum" value="${teachers.identificationnum }" type="text"  onchange="check()" id="usernum" disabled="disabled" ltype="text" placeholder="请输入用户编号"  /></td>
				<td align="left"><div id="result" style="color: red;"></div></td>
			</tr>			
			<tr>
				<td align="right" class="l-table-edit-td">姓名:<font color="#ff0000">*</font></td>
				<td align="left" class="l-table-edit-td"><input name="realname"type="text" value="${teachers.teachername }" id="realname" onchange="check3()" ltype="text"/></td>
				<td align="left"><div id="result3" style="color: red;"></div></td>
			</tr>
			<tr>
				<td align="right" class="l-table-edit-td" valign="top">性别:</td>
				<td align="left" class="l-table-edit-td">
                  <s:if test="#teachers.sex=='男'.toString()">
				   <input id="r1" type="radio" name="rbtnl" value="1" checked="checked" />
				     <label for="rbtnl_0">男</label> 
				   <input id="r2" type="radio" name="rbtnl" value="2" />
				     <label for="rbtnl_1">女</label>
				</s:if>
				<s:if test="#teachers.sex=='女'.toString()">
				   <input id="r1" type="radio" name="rbtnl" value="1"  />
				     <label for="rbtnl_0">男</label> 
				   <input id="r2" type="radio" name="rbtnl" value="2" checked="checked"/>
				     <label for="rbtnl_1">女</label>
				</s:if>
                </td>
				<td align="left"></td>
			</tr>
			<tr>
				<td align="right" class="l-table-edit-td">电话:<font color="#ff0000">*</font></td>
				<td align="left" class="l-table-edit-td"><input name="telephone" value="${teachers.telephone }" onchange="checkmobile()" type="text" id="telephone" ltype="text" style="width: 170px;" /></td>
				<td align="left"><div id="result1" style="color: red;"></div></td>
			</tr>
			<tr>
				<td align="right" class="l-table-edit-td">E-mail:</td>
				<td align="left" class="l-table-edit-td"><input name="email"type="text" id="email" value="${teachers.email }" onchange="checkemail()" ltype="text" style="width: 170px;" /></td>
				<td align="left"><div id="result2" style="color: red;"></div></td>
			</tr>
			<tr>
				<td align="right" class="l-table-edit-td">职称:<font color="#ff0000">*</font></td>
				<td align="left" class="l-table-edit-td">
				   <input id="position" name="position" value="${ teachers.position}" disabled="disabled" style="width: 170px;" />
				</td>
			</tr>
			<tr>
				<td align="right" class="l-table-edit-td">部门:<font color="#ff0000">*</font></td>
				<td align="left" class="l-table-edit-td">
				<select name="depid" id="depid" ltype="select" style="width: 170px;" onchange="checkdept()" >
						<s:iterator value="#deptlist" id="gg">
						  <s:if test="#gg.deptid==#teachers.dept.deptid">
				              <option value="<s:property value="#gg.deptid"/>" selected="selected" ><s:property value="#gg.deptname" /></option>
				          </s:if>
							<option value="<s:property value="#gg.deptid"/>"><s:property value="#gg.deptname" /></option>
						</s:iterator>
				</select></td>
				<td align="left"><div id="result4" style="color: red;"></div></td>
			</tr>
			
			<!-- <tr>
				<td align="right" class="l-table-edit-td">角色:</td>
				<td align="left" class="l-table-edit-td">
				<select  name="role" id="role">  
                              <option value="2">任课教师</option>       
                              <option value="3">班主任</option>  
                </select></td>
			</tr>	 -->		 
			
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
					type="submit" value="更&nbsp;&nbsp;新" id="Button1"
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