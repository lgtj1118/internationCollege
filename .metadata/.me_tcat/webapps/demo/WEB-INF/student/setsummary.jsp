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
				check();
				if(flg){
				    $.post("${pageContext.request.contextPath}/system/Manage_coursesummarydone.action?classid="+ $("#classid").val()
		        +"&semester="+encodeURI(encodeURI($("#semester").val()))
		        +"&coursenum="+$("#coursenum").val()		        
		        +"&chosenCourse.midexam="+parseInt($("#midexam").val())
		        +"&chosenCourse.finalexam="+parseInt($("#finalexam").val())
		        +"&chosenCourse.attendence="+$("#attendence").val()
		        +"&chosenCourse.homework="+$("#homework").val() 
		        ,null,function(){
		        //alert('生成成功!');
		        parent.m.hide();
		        parent.window.location.reload();
	            //parent.g.loadData();
		       });	
				}											
			}				 		
		});
		$("form").ligerForm();
		$(".l-button-test").click(function() {
			alert(v.element($("#txtName")));
		});

	});	
  var flg= false;
  function check(){
	  var attendence = $("#attendence").val();
	  //var reg = /^0\.\d+$/;
	  var homework = $("#homework").val();
	  var midexam = $("#midexam").val();
	  var finalexam = $("#finalexam").val();
	 if(parseInt(attendence)+parseInt(homework)+parseInt(midexam)+parseInt(finalexam)==100){
	    $("#result").hide();
	    flg=true;
	  }else{
	    $("#result").html("比例设置不能不等于100")
	    $("#result").show();
	    flg=false;
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

	<form name="form1" method="post" action="" id="form1"><div align="center"> 
		</div><h2 align="center">总评计算设置</h2>
		<input id="semester" value="${semester }" type="hidden" />
        <input id="coursenum" value="${coursenum }" type="hidden"/>
        <input id="classid" value="${clsid }" type="hidden"/>	
		<table cellpadding="0" cellspacing="0" class="l-table-edit">
			<tr>
				<td align="right" class="l-table-edit-td">考勤成绩比例:<font color="#ff0000">*</font></td>
				<td align="left" class="l-table-edit-td"><input name="attendence"type="text" id="attendence" ltype="text" value="10" onchange="check()" disabled="disabled" /></td>
				<td align="left">%</td>
			</tr>
			<tr>
				<td align="right" class="l-table-edit-td">作业成绩比例:<font color="#ff0000">*</font></td>
				<td align="left" class="l-table-edit-td"><input name="homework"type="text" id="homework"  value="20" onchange="check()" disabled="disabled" /></td>
				<td align="left">%</td>
			</tr>												 			
			<tr>
				<td align="right" class="l-table-edit-td">期中成绩比例:<font color="#ff0000">*</font></td>
				<td align="left" class="l-table-edit-td"><input name="midexam"type="text" id="midexam" ltype="text" value="30" onchange="check()" disabled="disabled"  /></td>
				<td align="left">%</td>
			</tr>
			<tr>
				<td align="right" class="l-table-edit-td">期末成绩比例:<font color="#ff0000">*</font></td>
				<td align="left" class="l-table-edit-td"><input name="finalexam"type="text" id="finalexam" ltype="text" value="40" onchange="check()" disabled="disabled"  /></td>
				<td align="left">%</td>
			</tr>
			<tr>
				<td align="center" colspan="3" ><div id="result" style="color: red;" ></div></td>
				
			</tr>
			<tr>
				<td align="right" class="l-table-edit-td"></td>
				<td align="left" class="l-table-edit-td"><br />
				 <input type="submit" value="设&nbsp;&nbsp;置" id="Button1" class="l-button l-button-submit" />
				</td>
				</td>
				<td align="left">
			</tr>
		</table>
		<br />
	</form>
</body>
</html>