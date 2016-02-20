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
			    checkmajor();
			    check1();
				if(flg&&flg1&&flg2)	{			
				$.post("${pageContext.request.contextPath}/system/Class_classupdate.action?cls.classname="+ encodeURI(encodeURI($("#classname").val()))
		        +"&cls.id="+encodeURI(encodeURI($("#id").val()))
		        +"&cls.classname_en="+encodeURI(encodeURI($("#classnameEN").val()))
		        +"&cls.major="+encodeURI(encodeURI($("#major").val())),null,function(){
		        //alert('更新成功!');
		        parent.m.hide();
		        //parent.g.window.location.reload();
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
    var flg=false;	
	function check() {	
	 var classname = $("#classname").val();
	  var reg= /^\d+$/; 
	 if(classname.length==0){
	   $("#result").html("班级名称不能为空!");
	   $("#result").show();
	    form.classname.focus();
	    flg=false;
		return false;
	 }else{
	    if(!isNaN(classname)){
	       $("#result").html("班级名称不能全是数字!");
	       $("#result").show();
	      // form.classname.focus();
	       flg=false;
		   return false;
	    }else{
	       $("#result").hide();
	       $.post("${pageContext.request.contextPath}/system/Class_classcheckagain.action?cls.classname="
					+ encodeURI(encodeURI($("#classname").val()))+"&cls.id="+$("#id").val(), null, function(data) {
					if (data == "fail") {
						$("#result").html("该班级名称已经存在!");
						$("#result").show();
						//form.classname.focus();
						flg = false;
						return false;
					} else {
						$("#result").hide();
						flg=true;
						return true;
					}
			});
	    }
	 }    		
		
			
	}
	var flg1=false;
	function checkmajor(){
	   var major = $("#major").val();
	   var reg= /^[\u4E00-\u9FA5]+$/; 
	   if(major.length==0){
	     $("#result1").html("专业不能为空!");
	     $("#result1").show();
	     flg1=false;
	     return false;
	   }else{
	      $("#result1").hide();
	      if(!reg.test(major)){
	         $("#result1").html("专业名称必须是中文!");
	         $("#result1").show();
	         // form.classname.focus();
	         flg1=false;
		     return false;
	      }else{
	         $("#result1").hide();
	         flg1=true;
	      }
	    }
	}	
		var flg2=false;
	function check1(){
	   var major = $("#classnameEN").val();
	   var reg= /^[a-zA-Z0-9]{2,}$/; 
	   if(major.length==0){
	     $("#result2").html("不能为空!");
	     $("#result2").show();
	     flg2=false;
	     return false;
	   }else{
	      $("#result1").hide();
	      if(!reg.test(major)){
	         $("#result2").html("英文名必须为两个及以上字符!");
	         $("#result2").show();
	         // form.classname.focus();
	         flg2=false;
		     return false;
	      }else{
	         $("#result2").hide();
	         flg2=true;
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
		<input id="id" value="${ classes.id}" type="hidden" />
		<table cellpadding="0" cellspacing="0" class="l-table-edit">
			<tr>
				<td align="right" class="l-table-edit-td">班级名称:<font color="#ff0000">*</font></td>
				<td align="left" class="l-table-edit-td"><input name="classname" value="${classes.classname }" type="text"  id="classname" onchange="check()" ltype="text" placeholder="请输入班级名称"  /></td>
				<td align="left"><div id="result" style="color: red;"></div></td>
			</tr>
			<tr>
				<td align="right" class="l-table-edit-td">英文名称:<font color="#ff0000">*</font></td>
				<td align="left" class="l-table-edit-td"><input name="classnameEN"type="text" id="classnameEN" value="${classes.classname_en }" ltype="text" onchange="check1()"  /></td>
				<td align="left"><div id="result2" style="color: red;"></div></td>
			</tr>
			<tr>
				<td align="right" class="l-table-edit-td">专业:<font color="#ff0000">*</font></td>
				<td align="left" class="l-table-edit-td"><input name="major"type="text" value="${classes.major }" id="major" ltype="text" onchange="checkmajor()" /></td>
				<td align="left"><div id="result1" style="color: red;"></div></td>
			</tr>									 			
			<tr>
				<td align="right" class="l-table-edit-td"></td>
				<td align="left" class="l-table-edit-td"><br />
				 <input type="submit" value="更&nbsp;&nbsp;新" id="Button1" class="l-button l-button-submit" />
				</td>
				</td>
				<td align="left">
			</tr>
		</table>
		<br />
	</form>
</body>
</html>