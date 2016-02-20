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
/* 	     var eee;
        $(function ()
        {
            $.metadata.setType("attr", "validate");
            var v = $("form").validate({
                debug: true,
                errorPlacement: function (lable, element)
                {
                    if (element.hasClass("l-textarea"))
                    {
                        element.ligerTip({ content: lable.html(), target: element[0] }); 
                    }
                    else if (element.hasClass("l-text-field"))
                    {
                        element.parent().ligerTip({ content: lable.html(), target: element[0] });
                    }
                    else
                    {
                        lable.appendTo(element.parents("td:first").next("td"));
                    }
                },
                success: function (lable)
                {
                    lable.ligerHideTip();
                    lable.remove();
                },
				submitHandler : function(){
					$("form .l-text,.l-textarea").ligerHideTip();
					if ((flg1) && (flg2)) {
						var sexid = 1;
						if (document.getElementById("r2").checked) {
							sexid = "女";
						} else {
							sexid = "男";
						}
						$.post("${pageContext.request.contextPath}/system/Manage_teacherendadd.action?teacher.identificationnum=" + $("#usernum").val() + "&teacher.sex=" + encodeURI(encodeURI(sexid)) + "&depid=" + $("#depid")
								.val()
							//+"&role="+$("#role").val()	
							+ "&teacher.position=" + encodeURI(encodeURI($("#position option:selected").val())) + "&teacher.teachername=" + encodeURI(encodeURI($("#realname").val())) + "&teacher.telephone=" + encodeURI(encodeURI($("#telephone")
								.val())) + "&teacher.email=" + encodeURI(encodeURI($("#email").val())), null, function(){
								alert('添加成功!');
								parent.m.hide();
								parent.g.loadData();
							});
					}
				}
			});
			
			
		 $("form").ligerForm();
            $(".l-button-test").click(function ()
            {
                alert(v.element($("#txtName")));
            });
        });   */
        
    /*     
    function addTotable (){
    	//alert("1");
    	if (check()){
    		return;
    	}
    	if (!checkname()){
    		alert("not pass");
    		$("#result").text("姓名必须由2个或以上的中英文字符构成!");	
    		return;
    	}
    	alert("pass");
    	if (checkmobile()){
    		return;
    	}
    	if (checkemail()){
    		return;
    	}
    	
    	$.post("${pageContext.request.contextPath}/system/Manage_teacherendadd.action?teacher.identificationnum=" + $("#usernum").val() + "&teacher.sex=" + encodeURI(encodeURI(sexid)) + "&depid=" + $("#depid")
								.val()
							//+"&role="+$("#role").val()	
							+ "&teacher.position=" + encodeURI(encodeURI($("#position option:selected").val())) + "&teacher.teachername=" + encodeURI(encodeURI($("#realname").val())) + "&teacher.telephone=" + encodeURI(encodeURI($("#telephone")
								.val())) + "&teacher.email=" + encodeURI(encodeURI($("#email").val())), null, function(){
								alert('添加成功!');
								parent.m.hide();
								parent.g.loadData();
							});
    }
        
        
	var flg = true;
	function check(){
		var str = document.getElementById("usernum").value;
		var reg = /^(?!0)\d{8}$/;
		if (!reg.test(str)) {
			$("#result").html("用户编号为不能以0开头的8位数字！");
			$("#result").show();
			flg = false;
			document.regFrm.username.focus();
			return false;
		} else {
			$("#result").hide();
		}
		$.post("${pageContext.request.contextPath}/system/Manage_teachercheck.action?teacher.identificationnum=" + $("#usernum").val(), null, function(data){
			if (data == "fail") {
				$("#result").html("该用户编号已经存在!");
				$("#result").show();
				flg = false;
				return false;
			} else {
				$("#result").hide();
				return true;
			}
		});
	}
	var flg1 = true;
	function checkmobile(){
		var isMobile = /^(?:13\d|15\d|18\d)\d{5}(\d{3}|\*{3})$/; //手机号码验证规则
		var mobile = document.getElementById("telephone").value;
		if (!isMobile.test(mobile)) { //如果用户输入的值不同时满足手机号的正则
			$("#result").html("请输入正确的11位手机号!");
			$("#result").show();
			//$("#telephone").focus(); //输入框获得光标
			flg1 = false; //就弹出提示信息      
			return false;  
		} else {
			$("#result").hide();
			return true;
		}
	}
	var flg2 = true;
	function checkemail(){
		if (!$("#email").val().match(/^\w+((-\w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z0-9]+$/)) {
			$("#result").html("请输入正确的邮箱地址!");
			$("#result").show();
			//$("#email").focus(); //输入框获得光标
			flg2 = false; //就弹出提示信息   
			return false;
		} else {
			$("#result").hide();
			return true;
		}
	}
	function checkname(){
	  var realname = $("#realname").val();
	  
	  var reg =  /^[a-zA-Z\u4e00-\u9fa5]{2,}$/;
	  if (!reg.test(realname)) {
        $("#result").html("姓名必须由2个或以上的中英文字符构成!");
		$("#result").show();
		return false;
      } else {
        $("#result").hide();
        return true;
      }
	} */
	
		function clear(){
			$("#msg").text(" ");
		}
		
		function err (msg){
			$("#msg").text(msg);
		}
		
		function submit(){
			var usernum = $("#usernum");
			var realname= $("#realname");
			var telephone = $("#telephone");
			var email = $("#email");
 			
 			clear();
			/* if (!validate_required(usernum," 用户编号不能为空")){
				return false;
			}*/
			var reg1 = /^(?!0)\d{8}$/;
			if(usernum.val()!=null&&usernum.val()!=""){
			  if (!reg1.test(usernum.val())){
				err("用户编号只能为不以0开始8位数字");
				return false;
			  }
			  if (uniqueChk()) {
				err("用户编号重复");
				return;
			  }  
			}
			
			
			if (!validate_required(realname,"姓名不能为空")){
				return false;
			}
			var reg = /^[a-zA-Z\u4e00-\u9fa5]{2,}$/;
			if(!reg.test(realname.val())){
				err("姓名由2个以上的中英文字符组成");
				return;
			}
			if (!validate_required(telephone,"电话号码不能为空")){
				return false;
			}
			var reg2 = /^(1(([35][0-9])|(47)|[8][0126789]))\d{8}$/;
			if(!reg2.test(telephone.val())){
				err("电话号码格式不正确");
				return;
			}
			if (!validate_required(email,"邮箱不能为空")){
				return false;
			}
			var reg3 = /^\w+((-\w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z0-9]+$/;
			if(!reg3.test(email.val())){
				err("邮箱格式不正确");
				return;
			}
			
			var sexid = 1;
			if (document.getElementById("r2").checked) {
				sexid = "女";
			} else {
				sexid = "男";
			}
			 var url = "${pageContext.request.contextPath}/system/Manage_teacherendadd.action?teacher.identificationnum=" + $("#usernum").val() 
			 + "&teacher.sex=" + encodeURI(encodeURI(sexid)) 
			 + "&depid=" + $("#depid").val()//
			 + "&teacher.position=" + encodeURI(encodeURI($("#position option:selected").val())) 
			 + "&teacher.teachername=" + encodeURI(encodeURI($("#realname").val())) 
			 + "&teacher.telephone=" + encodeURI(encodeURI($("#telephone").val())) 
			 + "&teacher.email=" + encodeURI(encodeURI($("#email").val()));

    		$.post(url,null,function(){ 
    		    parent.m.hide();   		
		       	parent.window.location.reload();  
		       	//parent.g.loadData();  		
    			//window.close(); 	             
		     });
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
		
		function uniqueChk (){
			$.post("${pageContext.request.contextPath}/system/Manage_teachercheck.action?teacher.identificationnum=" + $("#usernum").val(), null, function(data){
			if (data == "fail") {
				return false;
			} else {
				return true;
			}
		});
		}
</script>
<style type="text/css">
  body{ font-size:12px;}
        .l-table-edit {}
        .l-table-edit-td{ padding:4px;}
        .l-button-submit,.l-button-test{width:80px; float:left; margin-left:10px; padding-bottom:2px;}
        .l-verify-tip{ left:230px; top:120px;}
</style>

</head>

<body style="padding: 10px">
		<div id="errorLabelContainer" class="l-text-invalid"></div>
		<table cellpadding="0" cellspacing="0" class="l-table-edit">
			<tr>
				<td align="right" class="l-table-edit-td">教师编号:</td>
				<td align="left" class="l-table-edit-td"><input name="usernum"type="text" class="required" id="usernum"  ltype="text" placeholder="请输入教师编号"  nullText="不能为空!" /></td>
				<td align="left" ></td>
			</tr>			
			<tr>
				<td align="right" class="l-table-edit-td">姓名:<font color="#ff0000">*</font></td>
				<td align="left" class="l-table-edit-td"><input name="realname"type="text" id="realname" type="text"  /></td>
				<td align="left"></td>
			</tr>
			
			<tr>
				<td align="right" class="l-table-edit-td">电话:<font color="#ff0000">*</font></td>
				<td align="left" class="l-table-edit-td"><input name="telephone"type="text"  id="telephone" ltype="text" /></td>
				<td align="left"></td>
			</tr>
			<tr>
				<td align="right" class="l-table-edit-td">E-mail:<font color="#ff0000">*</font></td>
				<td align="left" class="l-table-edit-td"><input name="email"type="text" id="email"  ltype="text"  /></td>
				<td align="left"></td>
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
				<td align="right" class="l-table-edit-td">职称:</td>
				<td align="left" class="l-table-edit-td">
				<select name="position" id="position" ltype="select" style="width:150px;" >
					<option value="教授">教授</option>
					<option value="副教授">副教授</option>
					<option value="讲师">讲师</option>
				</select></td>
			</tr>
			<tr>
				<td align="right" class="l-table-edit-td">部门:</td>
				<td align="left" class="l-table-edit-td">
				<select name="depid" id="depid" ltype="select" style="width:150px;"  >
					    <s:iterator value="#deptlist" id="gg">
							<option value="<s:property value="#gg.deptid"/>"><s:property value="#gg.deptname" /></option>
						</s:iterator>					 
				</select></td>
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
				<th align="left" class="l-table-edit-td"colspan="3"></br>注：<font size="1" style="font-weight: normal;" color="#ff0080">用户编号外聘教师无需输入，本校教师必须输入！</font></th>								
				
			</tr>			
			<tr>
				<td align="right" class="l-table-edit-td"></td>
				<td align="left" class="l-table-edit-td"><br /> <input
					onclick="submit()" value="添&nbsp;&nbsp;加" id="Button1"
					class="l-button l-button-submit" />
				</td>
				</td>
				<td align="left">
			</tr>
		</table>
		<p id="msg" style="color:red"></p>
</body>
</html>