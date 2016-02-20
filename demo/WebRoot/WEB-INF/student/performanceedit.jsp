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
				check1();
				if(flg&&flg1){
				$.post("${pageContext.request.contextPath}/system/Class_performanceupdate.action?performance.passport="+ encodeURI(encodeURI($("#stuid").val()))
		        +"&performance.study="+encodeURI(encodeURI($("#study").val()))
		        +"&performance.dailylife="+encodeURI(encodeURI($("#dailylife").val()))
		        +"&performance.id="+encodeURI(encodeURI($("#id").val()))
		        +"&performance.event="+encodeURI(encodeURI($("#event").val()))
		        +"&performance.outstanding="+encodeURI(encodeURI($("#outstanding").val()))
		        +"&performance.psychicology="+encodeURI(encodeURI($("#psychicology").val()))
		        +"&performance.remark="+encodeURI(encodeURI($("#remark").val()))		  
		        ,null,function(){
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
var flg = false;
    function check() {	
     var stuname = $("#stuname").val();
     if(stuname.length==0){
       $("#result").html("学生姓名不能为空!");						
	   $("#result").show();	
	    flg = false;
     }else{
        $.post("${pageContext.request.contextPath}/system/Stu_stucheckname.action?stu.stuname="
					+ encodeURI(encodeURI($("#stuname").val())), null, function(data) {
					if (data == "fail") {
					    $("#result").html("该学生姓名不存在!");						
						$("#result").show();	
						flg = false;					
					} else {					   
						$("#result").hide();
						flg = true;						
					}
				});			
     }   				
	}	
	var flg1=false;
	function check1(){
	   var event = $("#event").val();
	   var study = $("#study").val();
	   var dailylife = $("#dailylife").val();
	   var outstanding = $("#outstanding").val();
	   var psychicology = $("#psychicology").val();
	   if(event.length==0||dailylife.length==0||outstanding.length==0||psychicology.length==0||study.length==0){
	     $("#result1").html("各项表现不能为空！");
	     $("#result1").show();
	     flg1=false;
	   }else{
	      $("#result1").hide();
	      flg1=true;
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

table{
  text-align: center;
}
textarea {
	width: 220px;
	height:70px;
	font-size: 12px;
}
</style>

</head>

<body style="padding: 10px">
<div align="center"><strong><font size="3">平时表现</font></strong>	</div><br/>
<form name="form1" method="post" action="" id="form1">
		<div id="errorLabelContainer" class="l-text-invalid"></div>
		<input id="id" value="${per.id }" type="hidden" />
		<table cellpadding="0" cellspacing="0" class="l-table-edit">
			<tr>
				<td align="right" class="l-table-edit-td">姓名:<font color="#ff0000">*</font></td>
				<td align="left" class="l-table-edit-td">
				<input id="stuid" value="${stu.stuid }" type="hidden" />
				<input name="stuname" value="${stu.stuname }" type="text" onchange="check()" disabled="disabled" id="stuname" ltype="text"   /></td>				
			    <td class="l-table-edit-td"><div id="result" style="color: red;"></div></td>	
			</tr>
			<tr>
				<td align="right" class="l-table-edit-td">学习方面:<font color="#ff0000">*</font></td>
				<td align="left" class="l-table-edit-td"><textarea id="study"  onchange="check1()" >${per.study }</textarea> </td>			
			    <td>生活方面：<font color="#ff0000">*</font></td>
			    <td><textarea id="dailylife" onchange="check1()"  >${per.dailylife }</textarea></td>
			</tr>
			<tr>
			   <td class="l-table-edit-td" >活动能力：<font color="#ff0000">*</font></td>
			   <td class="l-table-edit-td" ><textarea id="event"  onchange="check1()" >${per.event }</textarea></td>
			   <td>突出表现：<font color="#ff0000">*</font></td>
			  <td><textarea id="outstanding"  onchange="check1()" >${per.outstanding }</textarea></td>
			</tr>
			<tr>
			  <td class="l-table-edit-td" >心理：<font color="#ff0000">*</font></td>
			  <td class="l-table-edit-td" ><textarea id=psychicology  onchange="check1()" >${per.psychicology }</textarea></td>
			  <td class="l-table-edit-td" >备注：</td>
			  <td class="l-table-edit-td" ><textarea id=remark >${per.remark }</textarea></td>
			</tr>			 						
			<tr>
				<th align="center" class="l-table-edit-td"colspan="3"><div id="result1" style="color: red;"></div></th>								
			</tr>
			<tr>
				<td align="right" class="l-table-edit-td"></td>	
				<td align="right" class="l-table-edit-td"></td>								 
				<td align="right" class="l-table-edit-td"><input type="submit" value="更&nbsp;&nbsp;新" id="Button1" class="l-button l-button-submit" /></td>
			</tr>
		</table>
		<br />
	</form>
</body>
</html>