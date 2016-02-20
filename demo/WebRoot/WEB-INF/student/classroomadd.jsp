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
				//check();
				check1();
				check2();
				check3();
				if(flg1&&flg2&&flg3){
				$.post("${pageContext.request.contextPath}/system/Class_roomendadd.action?&room.roomname="+encodeURI(encodeURI($("#roomname").val()))
				+"&room.roomplace="+encodeURI(encodeURI($("#roomplace").val()))
				+"&room.roomcapacity="+encodeURI(encodeURI($("#roomcapacity").val()))
				+"&room.realcapacity="+encodeURI(encodeURI($("#realcapacity").val()))
				+"&room.note="+encodeURI(encodeURI($("#note").val()))
				+"&room.roomtype="+encodeURI(encodeURI($("#roomtype").val())),null,function(){
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
	function check() {	    
		var str = document.getElementById("roomname").value;
		if(str.length==0){
		    $("#result").html("编号不能为空！");
			$("#result").show();
			flg=false;
			return false;
		}else{
		var reg = /^[\u4e00-\u9fa5]+$/gi;
		if (isNaN(str)) {
			$("#result").html("编号只能为数字！");
			$("#result").show();
			flg = false;
			document.form1.num.focus();
			return false;
		} else {
			$("#result").hide();
		}$.post("${pageContext.request.contextPath}/system/Class_roomcheck.action?room.num="
						+ $("#num").val(), null, function(data) {
					if (data == "fail") {
						$("#result").html("该教室编号已经存在!");
						$("#result").show();
						flg = false;
						return false;
					} else {
						$("#result").hide();
						flg = true;
					}
				});	
			}			
	}
	var flg1 = false;	
	function check1(){
	 
	var str1 = document.getElementById("roomcapacity").value;
		var str2 = document.getElementById("realcapacity").value;
		if (str1.length == 0 || str2.length == 0) {
			$("#result1").html("容量不能为空！");
			$("#result1").show();
			flg1 = false;
			return false;
		} else {
			if (isNaN(str1) || isNaN(str2)) {
				$("#result1").html("容量只能为数字！");
				$("#result1").show();
				//$("#realcapacity").Empty();
				flg1 = false;
				return false;
			} else {
				if (parseInt(str2) > parseInt(str1)) {
					$("#result1").html("实际容量不能大于原本容量！");
					$("#result1").show();
					$("realcapacity").empty();
					flg1 = false;
					return false;
				} else {
					$("#result1").hide();
					flg1 = true;
				}
			}

		}

	}
	var flg2 = false;
	function check2() {
		var str = document.getElementById("roomname").value;
		if(str.length==0){
		    $("#result2").html("教室名称不能为空！");
			$("#result2").show();
			flg2=false;
			return false;
		}else{
		$("#result2").hide();
		$.post("${pageContext.request.contextPath}/system/Class_roomcheck.action?room.roomname="
						+ encodeURI(encodeURI($("#roomname").val())), null, function(data) {
					if (data == "fail") {
						$("#result2").html("该教室名称已经存在!");
						$("#result2").show();
						flg2 = false;
						return false;
					} else {
						$("#result2").hide();
						flg2 = true;
					}
				});	
			}			
	}
	var flg3 = false;
	function check3() {
		var roomplace = $("#roomplace").val();
		if (roomplace.length == 0) {
			$("#result3").html("教室位置不能为空！");
			$("#result3").show();
			flg3 = false;
			return false;
		} else {
		$("#result3").hide();
		   if(!isNaN(roomplace)){
		      $("#result3").html("教室位置不能全为数字！");
			  $("#result3").show();
			  flg3 = false;
			  return false;
		   }else{
		   $("#result3").hide();
			flg3 = true;
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
			<!-- <tr>
				<td align="right" class="l-table-edit-td">编号:<font color="#ff0000">*</font></td>
				<td align="left" class="l-table-edit-td"><input name="num"type="text" onchange="check()" id="num" ltype="text" placeholder="请输入编号"  /></td>
				<td align="left"><div id="result" style="color: red;"></div></td>
			</tr> -->
			<tr>
				<td align="right" class="l-table-edit-td">教室名:<font color="#ff0000">*</font></td>
				<td align="left" class="l-table-edit-td"><input name="roomname"type="text" id="roomname" onchange="check2()"  ltype="text" /></td>
				<td align="left"><div id="result2" style="color: red;"></div></td>
			</tr>
			
			<tr>
				<td align="right" class="l-table-edit-td">教室位置:<font color="#ff0000">*</font></td>
				<td align="left" class="l-table-edit-td">
				<input name="roomplace"type="text" id="roomplace" ltype="text" onchange="check3()"  /></td>
				<td align="left"><div id="result3" style="color: red;"></div></td>
			</tr>			 
			<tr>
				<td align="right" class="l-table-edit-td">教室类型:<font color="#ff0000">*</font></td>
				<td align="left" class="l-table-edit-td">
				 <select id="roomtype" >
				   <option value="多媒体教室">多媒体教室</option>
				   <option value="计算机室">计算机室</option>
				   <option value="语音室">语音室</option>
				   <option value="体验馆">体验馆</option>
				 </select>
                </td>
                <td align="left"></td>
			</tr>
			<tr>
				<td align="right" class="l-table-edit-td">容量:<font color="#ff0000">*</font></td>
				<td align="left" class="l-table-edit-td">
				<input name="stuname"type="text" id="roomcapacity" ltype="text"  /></td>
				<td align="left"></td>
			</tr>
			<tr>
				<td align="right" class="l-table-edit-td">实际容量:<font color="#ff0000">*</font></td>
				<td align="left" class="l-table-edit-td">
				<input name="stuname"type="text" id="realcapacity" onchange="check1()" ltype="text" /></td>
				<td align="left"><div id="result1" style="color: red;"></div></td>
			</tr>
			<tr>
				<td align="right" class="l-table-edit-td">备注:</td>
				<td align="left" class="l-table-edit-td">
				<input name="stuname"type="text" id="note" ltype="text" /></td>
				<td align="left"></td>
			</tr>
			<tr>
				<td align="right" class="l-table-edit-td"></td>
				<td align="left" class="l-table-edit-td"><br /> <input type="submit" value="添&nbsp;&nbsp;加" id="Button1"
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