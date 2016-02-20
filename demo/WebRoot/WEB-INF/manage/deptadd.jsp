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
				if(flg){    
				$.post("${pageContext.request.contextPath}/system/User_deptendadd.action?dept.deptname="+ encodeURI(encodeURI($("#deptname").val()))
		       // +"&dept.deptresponsible="+ encodeURI(encodeURI($("#deptresponsible").val()))
		        ,null,function(){
		        //alert('添加成功!');
		        parent.m.hide();
		        parent.g.loadData();
	            //parent.window.location.reload();
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
	  var deptname=$("#deptname").val();
	  if(deptname.length==0){
	    $("#result").html("部门名称不能为空！");
	    $("#result").show();
	    flg=false;
	  }else{
	    if(!isNaN(deptname)){
	      $("#result").html("部门名称不能全部为数字！");
	      $("#result").show();
	      flg=false; 
	    }else{
	    $("#result").hide();
	     if(deptname.length<2){
	       $("#result").html("部门名称不能小于两个字符！");
	       $("#result").show();
	       flg=false;   
	     }else{
	     $("#result").hide();
	     $.post("${pageContext.request.contextPath}/system/User_deptcheck.action?dept.deptname="
						+  encodeURI(encodeURI($("#deptname").val())), null, function(data) {
					if (data == "fail") {
						$("#result").html("该部门名称已经存在!");
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
		
		<table cellpadding="0" cellspacing="0" class="l-table-edit">
			<tr>
				<td align="right" class="l-table-edit-td">部门名称:<font color="#ff0000">*</font></td>
				<td align="left" class="l-table-edit-td"><input name="deptname"type="text"  id="deptname" onchange="check()" ltype="text" placeholder="请输入部门名称"  /></td>
				<td align="left"></td>
			</tr>
			<!-- <tr>
				<td align="right" class="l-table-edit-td">负责人:</td>
				<td align="left" class="l-table-edit-td"><input name="deptresponsible"type="text"  id="deptresponsible" ltype="text" placeholder="请输入负责人"  /></td>
				<td align="left"></td>
			</tr> -->
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