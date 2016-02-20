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

<script src="<%=basePath%>js/jquery/jquery-1.6.min.js" type="text/javascript"></script>
<script src="<%=basePath%>js/ligerUI/core/base.js" type="text/javascript"></script>
<%-- <script src="<%=basePath%>js/ligerUI/plugins/ligerRadio.js" type="text/javascript"></script> --%>
<script src="<%=basePath%>js/ligerUI/plugins/ligerTip.js" type="text/javascript"></script>
<script src="<%=basePath%>js/jquery-validation/jquery.validate.js"type="text/javascript"></script>
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
                          ? '该字段有误！'
                          : '这 ' + errors + ' 个字段填写不正确！';
                        $("#errorLabelContainer").html(message).show();
                    } 
                },
                submitHandler : function() {
				$("form .l-text,.l-textarea").ligerHideTip();				
				////var flg = check();
				//var flg1= check1();
				//var flg2= check2();
				//alert(check());
				//if(flg&&flg1&&flg2){
				$.post("${pageContext.request.contextPath}/system/Class_courseendadd.action?course.coursename="
				+  encodeURI(encodeURI($("#coursename").val()))
		        +"&course.teacher="+  encodeURI(encodeURI($("#teacher").val()))
		        +"&course.character="+  encodeURI(encodeURI($("#character").val()))
		        //+"&course.checkway="+  encodeURI(encodeURI($("#checkway").val()))
		        +"&course.beginweeks="+ $("#beginweeks").val()
		        +"&course.endweeks="+ $("#endweeks").val()
		        +"&course.credits="+ $("#credit").val()
		        +"&course.weeklesson="+ $("#weeklesson").val()
		        +"&course.academic="+ $("#academic option:selected").val()
		        +"&course.num="+  encodeURI(encodeURI($("#num").val())),null,function(){
		        //alert('添加成功！');
                 parent.m.hide();
	             parent.g.loadData();
		        });
				}
			//}
		});

	});

	function check() {
	   var str = document.getElementById("coursename").value;
	   var reg =/[\u4e00-\u9fa5]/g;
	   if(!reg.test(str)){
	     $("#result").html("请正确填写课程名！");
	     $("#result").show();
	     return  false;
	   }else{
	   $.post("${pageContext.request.contextPath}/system/Class_coursecheck.action?course.coursename="
						+ $("#coursename").val(), null, function(data) {
					if (data == "fail") {
						$("#result").html("该课程名已经存在!");
						$("#result").show();
						return false;
					} else {
						$("#result").hide();
						return true;
					}
				});
	   }		
	}
	function check1() {
		var str = document.getElementById("num").value;
		var reg =/^(+|-)?d+$/;
		if(reg.test(str)){
		  $.post("${pageContext.request.contextPath}/system/Class_coursecheck1.action?course.num="
						+ $("#num").val(), null, function(data) {
					if (data == "fail") {
						$("#result3").html("该课程编号已经存在!");
						$("#result3").show();
						return false;
					} else {
						$("#result3").hide();
						return true;
					}
				});
			
		}else{
		    $("#result3").html("请输入正确的数字!");
			$("#result3").show();
			return  false;
		}
		
		
	}
	function check2(){
	  var str1 = document.getElementById("beginweeks").value;
	  var str2 = document.getElementById("endweeks").value;
	  if(parseInt(str1)>parseInt(str2)){
	    $("#result2").html("起始周不能大于结束周！");
	    $("#result2").show();
	    return false;
	  }else{
	    $("#result2").hide();
	    return  true;
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
.l-text{
   width: 80px;
}
</style>

</head>

<body style="padding: 10px" onload="refresh()">

	<form name="form1" method="post" action="" id="form1"   >
		<div id="errorLabelContainer" class="l-text-invalid"></div>
		<table cellpadding="0" cellspacing="0" class="l-table-edit">
			<tr>
				<td align="right" class="l-table-edit-td">课程编号:</td>
				<td align="left" class="l-table-edit-td"><input name="num"type="text" onchange="check1()" id="num" ltype="text" /></td>
				<td align="left"><div id="result1" style="margin-top:-10px;color: red;font-size: 10px;"></div>
				   <div id="result3" style="margin-top:-10px;color: red;font-size: 10px;"></div>
				</td>
			</tr>
			<tr>
				<td align="right" class="l-table-edit-td">课程名称:</td>
				<td align="left" class="l-table-edit-td">
				<input name="name" type="text" id="coursename"  ltype="text" onchange="tovalid()" /></td>
				<td align="left"><div id="result" style="color: red;font-size: 10px;"></div></td>
			</tr>
			<tr >
				<td  align="right" class="l-table-edit-td">开课起始周:</td>	<!-- validate="{required:true,minlength:1,maxlength:20}"			 -->
				<td align="left" class="l-table-edit-td"><input name="beginweeks" width="30px" type="text" id="beginweeks"    /></td>
				<td align="left">				
			</tr>
			<tr >
				<td  align="right" class="l-table-edit-td">开课结束周:</td><!-- 	onblur="check2()" validate="{required:true,minlength:1,maxlength:20}"	 -->						
				<td align="left" class="l-table-edit-td"><input name="endweeks" type="text" onchange="check2()" id="endweeks" /></td>
				<td align="left">
			</tr>
			<tr>
				<td align="right" class="l-table-edit-td">学分:</td>
				<td align="left" class="l-table-edit-td">
				<select type="select" id="credit" style="width:155px;" >
				    <option value=""  ></option>
				    <option value="1">1</option>
				    <option value="2">2</option>
				    <option value="3">3</option>
				    <option value="4">4</option>
				    <option value="5">5</option>
				    <option value="6">6</option>
				    <option value="7">7</option>
				</select>
				</td>
				<td align="left"></td>
			</tr>
            <tr>
				<td align="right" class="l-table-edit-td">周课时:</td>
				<td align="left" class="l-table-edit-td">
				<select type="select" id="weeklesson" style="width:155px;" >
				    <option value="1">1</option>
				    <option value="2">2</option>
				    <option value="3">3</option>
				    <option value="4">4</option>
				    <option value="5">5</option>
				    <option value="6">6</option>
				    <option value="7">7</option>
				</select>
				</td>
				<td align="left"></td>
			</tr>
			<tr>
					<td align="right" class="l-table-edit-td">课程性质:</td>
				<td align="left" style="padding-left: 4px">
				<select type="select" id="character" style="width:155px;" >
				    <option value="必修">必修</option>
				    <option value="现选">现选</option>
				    <option value="任选">任选</option>
				</select>
					<!-- <input name="character" type="text"  id="character" ltype='text' value="必修" /> -->
				</td>
					 
				</tr>
				<!-- <tr>
					<td align="right" class="l-table-edit-td">考核方式:</td>
				<td align="left" style="padding-left: 4px">
					<select type="select" id="checkway">
				        <option value="集中式">集中式</option>
				        <option value="非集中式">非集中式</option>
				    </select>
					</td>
					 
				</tr> -->
				
				<tr>
					<td align="right" class="l-table-edit-td">开课学院:</td>
				    <td align="left" style="padding-left: 4px">
				    <select type="select" id="academic" name="academic" style="width: 155px;">
						<option value="国际教育学院 "  >国际教育学院</option>
						<option value="纺织学院">纺织学院</option>
						<option value="材料科学与工程学院">材料科学与工程学院</option>
						<option value="环境与化学工程学院">环境与化学工程学院</option>
						<option value="机械工程学院">机械工程学院</option>
						<option value="计算机科学与软件学院">计算机科学与软件学院</option>
						<option value="电气工程与自动化学院 ">电气工程与自动化学院</option>
						<option value="电子与信息工程学院 ">电子与信息工程学院</option>
						<option value="理学院">理学院</option>
						<option value="艺术与服装学院">艺术与服装学院</option>
						<option value="管理学院 ">管理学院</option>
						<option value="经济学院">经济学院</option>
						<option value="人文与法学院">人文与法学院</option>
						<option value="外国语学院 ">外国语学院</option>
						<option value="马克思主义学院">马克思主义学院</option>
						<option value="应用技术学院">应用技术学院</option>
						<option value="继续教育学院">继续教育学院</option>
				</select>
				</td>					 
				</tr><tr>
					<td align="right" class="l-table-edit-td">负责教师:</td>
				    <td align="left" style="padding-left: 4px">
					   <input name="teacher" type="text"  id="teacher" ltype='text' />
				    </td>
					 
				</tr>			
			<tr>
				<td align="right" class="l-table-edit-td"></td>
				<td align="left"><div id="result2" style="color: red;">
				<td align="left" class="l-table-edit-td"></td>
			</tr>
			<tr>
				<td align="right" class="l-table-edit-td"></td>
				<td align="left"><br /><input type="submit"value="添&nbsp;&nbsp;加" id="Button1"class="l-button l-button-submit" /></td>
				<td align="left" class="l-table-edit-td"></td>	
			</tr>
		</table>
		<br />
	</form>
<script type="text/javascript">
  function tovalid(){
    
  }
</script>
</body>
</html>