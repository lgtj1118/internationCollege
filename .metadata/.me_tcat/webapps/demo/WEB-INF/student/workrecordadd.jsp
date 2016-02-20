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
				check1();
				checkclass();
				checknum();
				checksis();
				if(flg1&&flg2&&flg&&flg4){
				   $.post("${pageContext.request.contextPath}/system/Class_workrecordendadd.action?classrecord.classid="+ encodeURI(encodeURI($("#classid").val()))
		        +"&classrecord.teacherid="+encodeURI(encodeURI($("#teacherid").val()))
		        +"&classrecord.classmeetingfrequency="+encodeURI(encodeURI($("#classmeetingfrequency").val()))
		        +"&classrecord.appointmentnumber="+encodeURI(encodeURI($("#appointmentnumber").val()))
		        +"&classrecord.selfevalution="+encodeURI(encodeURI($("#selfevalution").val()))
		        +"&classrecord.physicalmentalcondition="+encodeURI(encodeURI($("#physicalmentalcondition").val()))
		        +"&classrecord.studyingcondition="+encodeURI(encodeURI($("#studyingcondition").val()))
		        +"&classrecord.feedback="+encodeURI(encodeURI($("#feedback").val()))
		        ,null,function(){
		        //alert('添加成功!');
		        top.f_closeTab();
		       });	 				
				}								
			 }		
		});
		$("form").ligerForm();
		$(".l-button-test").click(function() {
			alert(v.element($("#txtName")));
		});
	});	
	var flg4=false;
	function checkclass(){
	  var classid = $("#classid").val();
	  if(classid.length==0){
	     $("#result3").html("班级不能为空！");
	     $("#result3").show();
	     flg4= false;
	  }else{
	     $("#result3").hide();
	     flg4= true;
	  }
	}
	function check(){
	  $("#classmonitor").val("");
	  var classid = $("#classid").val();
	  $.post("${pageContext.request.contextPath}/system/Class_checkmonitor.action?cls.id="+classid,null,function(data){
	    //alert(data);
	    $("#classmonitor").val(data);//填充内容
	  })
	}
	var flg = false;	
	function check1(){
	  var classmeeting =$("#classmeetingfrequency").val();
	  if(classmeeting.length==0){
	    $("#result").html("本月班会次数不能为空！");
	    $("#result").show();
	    flg = false;
	  }else{
	    $("#result").hide();
	    if(isNaN(classmeeting)){
	       $("#result").html("本月班会次数只能为数字！");
	       $("#result").show();
	       flg = false;
	    }else{
	      $("#result").hide();
	      flg= true;
	    }
	  }
	}
	var flg1 = false;	
	function checknum(){
	  var classmeeting =$("#appointmentnumber").val();
	  if(classmeeting.length==0){
	    $("#result1").html("本月约谈人数不能为空！");
	    $("#result1").show();
	    flg1 = false;
	  }else{
	    $("#result1").hide();
	    if(isNaN(classmeeting)){
	       $("#result1").html("本月约谈人数只能为数字！");
	       $("#result1").show();
	       flg1 = false;
	    }else{
	      $("#result1").hide();
	      flg1= true;
	    }
	  }
	}
	var flg2 = fasle;
	function checksis(){
	   var physicalmentalcondition = $("#physicalmentalcondition").val();
	   var studyingcondition = $("#studyingcondition").val();
	   if(physicalmentalcondition.lenght==0){
	     $("#result2").html("学生身心情况不能为空！");
	     $("#result2").show();
	     flg2=false;
	     return false;
	   }else{
	     $("#result2").hide();
	      if(studyingcondition.length==0){
	         $("#result2").html("学生上课情况不能为空！");
	         $("#result2").show();
	         flg2=false;
	         return false;
	      }else{
	        $("#result2").hide();
	        flg2= true;
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
#contain{
 /* margin:auto; */
 width:85%;
 margin-top: 30px;
 margin-left:100px;
}
table{
  text-align: right;
}
textarea {
	width: 100%;
	font-size: 12px;
	height:60px;
	margin-top:10px;
}
</style>

</head>

<body style="padding: 10px">
<div id="contain">
<div align="center"><strong><font size="3">班主任工作记录表</font></strong>	</div><br/>
<form name="form1" method="post" action="" id="form1">
		<div id="errorLabelContainer" class="l-text-invalid"></div>
		<table cellpadding="0" cellspacing="0" class="l-table-edit">
			<tr>
				<td align="right" class="l-table-edit-td">班主任姓名:<input id="teacherid" value="${sessionScope.user.usernum }" type="hidden" /></td>
				<td align="left" class="l-table-edit-td"><input name="classteacher" value="${sessionScope.user.realname }" disabled="disabled" type="text"  id="classteacher" ltype="text"   /></td>
				<td align="right" class="l-table-edit-td"></td>
				<td align="right" class="l-table-edit-td">负责班级:</td>
				<td align="left" class="l-table-edit-td">
				   <select id="classid" type="select" onchange="check(),checkclass()"  >
				   <option value="" ></option>
				   <s:iterator value="#teacherclass" id="c" >
				      <option value="${c.id }" >${c.classname }</option>
				   </s:iterator>
				</select>
				</td>
				<td align="right" class="l-table-edit-td"><div id="result3" style="color: red;" ></div></td>
				<td align="right" class="l-table-edit-td">班长姓名:</td>
				<td valign="top"><br /></td><td align="left" class="l-table-edit-td"><input name="classmonitor"type="text"  id="classmonitor"  ltype="text" value=""  /></td>			
			</tr>
			<tr>
				<td align="right" class="l-table-edit-td">本月班会次数:<font color="#ff0000">*</font></td>
				<td align="left" class="l-table-edit-td"><input name="classmeetingfrequency" onchange="check1()" type="text"  id="classmeetingfrequency" ltype="text"   /></td>
				<td align="right" class="l-table-edit-td"><div id="result" style="color: red;" ></div></td>
				<td align="right" class="l-table-edit-td">本月约谈人数:<font color="#ff0000">*</font></td>
				<td align="left" class="l-table-edit-td"><input name="appointmentnumber"type="text" onchange="checknum();"  id="appointmentnumber" ltype="text"  /></td>
				<td align="right" class="l-table-edit-td"></td>
				<td align="right" class="l-table-edit-td">自我工作评价:</td>
				<td valign="top"><div id="result1" style="color: red;" ></div></td>
				<td align="left" class="l-table-edit-td">
				 <select id="selfevalution" >
				    <option value="0" >优秀</option>
				    <option value="1" >良</option>
				    <option value="2" >中等</option>
				    <option value="3" >不好</option>
				 </select>
				</td>			
			</tr>
			<tr>
			  <td>学生身心情况：<font color="#ff0000">*</font></td>
			  <th colspan="6"><textarea id="physicalmentalcondition" onchange="checksis()"  ></textarea></th>
			</tr>
			<tr>
			  <td>学生上课情况：<font color="#ff0000">*</font></td>
			  <th colspan="6"><textarea id="studyingcondition" onchange="checksis()" ></textarea></th>
			</tr>
			<tr>
			  <td>学生反映的课程、老师、学院问题：</td>
			  <th colspan="6"><textarea id="feedback" ></textarea></th>
			</tr>
						 			
			<tr>
				<td align="right" class="l-table-edit-td"></td>
				<td align="left"><div id="result2" style="color: red;"></div></td>
				<td align="left" class="l-table-edit-td"></td>				
			</tr>
			<tr>
				<th align="center" class="l-table-edit-td"colspan="3"><div id="result2" style="color: red;"></div></th>								
			</tr>
			<tr>
				<td align="right" class="l-table-edit-td"></td>
				<td align="right" class="l-table-edit-td"></td>
				<td align="right" class="l-table-edit-td"></td>
				<td align="left" class="l-table-edit-td"><br />
				 <input type="submit" value="添&nbsp;&nbsp;加" id="Button1" class="l-button l-button-submit" />
				</td>
				<td align="right" class="l-table-edit-td"></td>
				<td align="left">
			</tr>
		</table>
		<br />
	</form>
</div>
</body>
</html>