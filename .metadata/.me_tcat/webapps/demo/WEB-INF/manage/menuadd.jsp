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
				checkname();
				checkengname();
				if(flg&&flg1){         
				$.post("${pageContext.request.contextPath}/system/Menu_menuendadd.action?menu.namenav="+ encodeURI(encodeURI($("#name").val()))
		        +"&menu.enname="+ encodeURI(encodeURI($("#enname").val()))
		        +"&id="+ encodeURI(encodeURI($("#parentnav").val()))
		        +"&menu.menuurl="+ encodeURI(encodeURI($("#menuurl").val())),null,function(){
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
	var flg = false;
	function checkname() {	    
	  var name = $("#name").val();
	  if(name.length==0){
	     $("#result").html("菜单名不能为空！");
	     $("#result").shou();
	     flg=false;
	  }else{
	    $("#result").hide();
	    var reg = /^[\u4e00-\u9fa5]{2,}$/gi;
	     if(!reg.test(name)){
	         $("#result").html("菜单名只能为两个字符以上的中文！");
	         $("#result").show();
	         flg=false; 
	     }else{
	        $("#result").hide();
	        flg=true;
	     }
	  }
	}	
	var flg1 = false;
	function checkengname() {	    
	  var name = $("#enname").val();
	  if(name.length==0){
	     $("#result1").html("英文名称不能为空！");
	     $("#result1").shou();
	     flg1=false;
	  }else{
	    $("#result1").hide();
	    var reg = /^[a-zA-z]{2,}$/;
	     if(!reg.test(name)){
	         $("#result1").html("英文名只能为两个字符以上的英文！");
	         $("#result1").show();
	         flg1=false; 
	     }else{
	        $("#result1").hide();
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
		<div id="errorLabelContainer" class="l-text-invalid"></div>
		<table cellpadding="0" cellspacing="0" class="l-table-edit">
			<tr>
				<td align="right" class="l-table-edit-td">父节点:</td>
				<td align="left" class="l-table-edit-td">
				<select name="parentnav" id="parentnav" ltype="select">
				     <option value="1">0</option>
						<s:iterator value="#menulist" id="gg">
							<option value="<s:property value="#gg.Id"/>"><s:property value="#gg.namenav" /></option>
						</s:iterator>
				</select></td>
				<td align="left"></td>
			</tr>
			<tr>
				<td align="right" class="l-table-edit-td">节点名称:<font color="#ff0000">*</font></td>
				<td align="left" class="l-table-edit-td"><input name="name"type="text"  id="name" ltype="text" onchange="checkname()" placeholder="菜单名称"  /></td>
				<td align="left"><div id="result"  style="color: red" ></div></td>
			</tr>
			<tr>
				<td align="right" class="l-table-edit-td">英文名称:<font color="#ff0000">*</font></td>
				<td align="left" class="l-table-edit-td"><input name="enname"type="text" id="enname" placeholder="菜单英文名称" onchange="checkengname()" ltype="text" /></td>
				<td align="left"><div id="result1"  style="color: red" ></div></td>
			</tr>
			<tr>
				<td align="right" class="l-table-edit-td">地址链接:</td>
				<td align="left" class="l-table-edit-td"><input name="menuurl"type="text" id="menuurl" ltype="text" placeholder="菜单链接"/></td>
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