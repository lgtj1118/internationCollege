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
<title>天津工业大学国际教育学院教学服务系统</title>
<link href="<%=basePath%>js/ligerUI/skins/Gray/css/form.css" rel="stylesheet"type="text/css" />
<link href="<%=basePath%>js/ligerUI/skins/Gray/css/common.css" rel="stylesheet"type="text/css" />
<link href="<%=basePath%>css/date.css" rel="stylesheet" type="text/css"/>
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
<script src="<%=basePath%>js/jquery.date_input.pack.js" type="text/javascript"></script>
<script type="text/javascript">
	 $(function(){
	  $('.date_picker').date_input();
   })
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
				checkname();
				checkengname();							
				checknation();
				checkpassport();
				checknum();
				//checktype();
				checkmajor();
				checkdate();
				checkmobile();
				checkval();
				checkroom();
				checksource();
				checkbrith();
				var test = (flg)&&(flg1)&&(flg2)&&(flg3)&&(flg5)&&(flg6)&&(flg7)&&(flg8)&&(flg9)&&(flgtest)&&(flgtest1)&&(flgt);
				if(test){			
				  var sexid=1;
				  if(document.getElementById("r2").checked){
	                 sexid="女";
                  }else{
                  sexid="男";
                  }
                  
				$.post("${pageContext.request.contextPath}/system/Stu_stuendadd.action?stu.stuid="+ $("#stunum").val()
		        +"&stu.sex="+ encodeURI(encodeURI(sexid))
		        +"&classid="+ $("#classid").val()
		        +"&stu.stuname="+ encodeURI(encodeURI($("#stuname").val()))	            
		        +"&stu.firstname="+ encodeURI(encodeURI($("#firstname").val()))
		        +"&stu.lastname="+ encodeURI(encodeURI($("#lastname").val()))
		        +"&stu.nation="+ encodeURI(encodeURI($("#nation").val()))
		        +"&stu.studentType="+ encodeURI(encodeURI($("#studenttype").val()))
		        +"&stu.passport="+ encodeURI(encodeURI($("#passport").val()))
		        +"&stu.startdate="+ encodeURI(encodeURI($("#startdate").val()))
		        +"&stu.enddate="+ encodeURI(encodeURI($("#enddate").val()))
		        +"&stu.brithdate="+ encodeURI(encodeURI($("#brithdate").val()))
		        +"&stu.telephone="+ encodeURI(encodeURI($("#telephone").val()))
		        +"&stu.validResidencePermit="+ encodeURI(encodeURI($("#validResidencePermit").val()))
		        +"&stu.roomplace="+ encodeURI(encodeURI($("#roomplace").val()))
		        +"&stu.source="+ encodeURI(encodeURI($("#source").val())),null,function(){
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
	function checkname(){
	 var name = $("#stuname").val();
	  if(name.length==0){
	     $("#result").html("姓名不能为空！");
	     $("#result").show();
	     flg=false;
	  }else{
	     $("#result").hide();
	     var reg = /^[\u4e00-\u9fa5]{2,}$/gi;
	     if(!reg.test(name)){
	         $("#result").html("姓名只能为两个字符以上的汉字！");
	         $("#result").show();
	         flg=false; 
	     }else{
	         $("#result").hide();
	        flg=true;
	     }
	  }
	}
 var flg1=false;
	function checknation(){
	var name = $("#nation").val();
	  if(name.length==0){
	     $("#result1").html("国籍不能为空！");
	     $("#result1").show();
	     flg1=false;
	  }else{
	     $("#result1").hide();
	     if(!isNaN(name)){
	         $("#result1").html("国籍不能为数字！");
	         $("#result1").show();
	         flg1=false; 
	     }else{
	        $("#result1").hide();
	        flg1=true;
	     }
	  }
	}
	var flg2=false;
	function checkpassport(){
	   var str = document.getElementById("passport").value;
	   if(str.length<6){
	        $("#result2").html("护照号不足6位！");
			$("#result2").show();
			flg2 = false;
			//document.regFrm.username.focus();
			return false;
	   }else{
	       $("#result2").hide();
	        var reg = /^[A-Za-z0-9]+$/;
		if (!reg.test(str)) {
			$("#result2").html("护照只能为数字与英文字符！");
			$("#result2").show();
			flg2 = false;
			//document.regFrm.username.focus();
			return false;
		} else {
			$("#result2").hide();
		    $.post("${pageContext.request.contextPath}/system/Stu_stucheck.action?stu.passport="
						+ $("#passport").val(), null, function(data) {
					if (data == "fail") {
						$("#result2").html("护照号输入不能相同!");
						$("#result2").show();
						flg2 = false;
					} else {
						$("#result2").hide();
						flg2=true;
					}
				});	
	   }	
	   }
			
	}
	var flg3=false;
	function checknum(){
	 var stunum = $("#stunum").val();
	 if(stunum.length==0){
	    $("#result3").html("学号不能为空！");
	    $("#result3").show();
	   flg3 = false;
	   return false;
	 }else{
	   $("#result3").hide();
	   if(isNaN(stunum)){
	    $("#result3").html("学号只能为数字！");
		$("#result3").show();
		flg3 = false;
		return false; 
	   }else{
	      $("#result3").hide();
	      if(stunum.length!=12){
	         $("#result3").html("学号只能为12位有效数字！");
		     $("#result3").show();
		     flg3 = false;
		     return false; 
	      }else{
	         $("#result3").hide();
	         $.post("${pageContext.request.contextPath}/system/Stu_stucheckstunum.action?stu.stuid="
						+ $("#stunum").val(), null, function(data) {
					if (data == "fail") {
						$("#result3").html("已存在该学号，请重新输入!");
						$("#result3").show();
						flg3 = false;
					} else {
						$("#result3").hide();
						flg3=true;
					}
			});	
	      }
		    	
	   }
	   }
	}
	 var flg4=false;
	function checktype(){
	var name = $("#studenttype").val();
	if(name.length==0){
	     $("#result4").html("学生类型不能为空！");
	     $("#resul4").show();
	     flg4=false;
	  }else{
	     $("#result4").hide();
	      var reg = /^[\u4e00-\u9fa5]+$/gi;
	     if(!reg.test(name)){
	         $("#result4").html("学生类型只能为中文！");
	         $("#result4").show();
	         flg4=false; 
	     }else{
	        $("#result4").hide();
	        flg4=true;
	     }
	  }
	}
	var flg5=false;
	function checkmajor(){
	 var name = $("#major").val();
	 if(name.length==0){
	         $("#result5").html("专业不能为空！");
	         $("#result5").show();
	         flg5=false;
	 }else{
	    var reg = /^[\u4e00-\u9fa5]+$/gi;
	     if(!reg.test(name)){
	         $("#result5").html("专业只能为中文！");
	         $("#result5").show();
	         flg5=false; 
	     }else{
	        $("#result5").hide();
	        flg5=true;
	     }
	 }	 
	  }
	  var flg6=false;
	function checkdate(){
	  var startdate=$("#startdate").val();
	  var enddate=$("#enddate").val();
	  var d1 = new Date(startdate.replace(/\-/g, "\/"));
	  var d2 = new Date(enddate.replace(/\-/g, "\/"));
	  if(startdate.length==0||enddate.length==0){
	     $("#result6").html("入校日期或离校日期不能为空！");
         $("#result6").show();
         flg6=false;
          return false; 
	  }else{
	     $("#result6").hide();
	     if(startdate!=""&&enddate!=""&&d1 >=d2){  
           $("#result6").html("入学日期不能大于离校日期！");
          $("#result6").show();
           flg6=false;
           return false;  
         }else{
           $("#result").hide();
           flg6=true;
          } 
	  }	  
} 
var flg7 = true;
	function checkmobile(){
	  var isMobile=/^(?:13\d|15\d|18\d)\d{5}(\d{3}|\*{3})$/; //手机号码验证规则
	  var mobile = $("#telephone").val();
	  if(mobile.length==0){
	     $("#result7").html("手机号码不能为空!");
		 $("#result7").show();
		 //$("#telephone").focus();       //输入框获得光标
		 flg7 = false; //就弹出提示信息        
	  }else{
	     $("#result7").hide();
	     if(!isMobile.test(mobile)){ //如果用户输入的值不同时满足手机号的正则
         $("#result7").html("请输入正确的11位手机号!");
		 $("#result7").show();
		 //$("#telephone").focus();       //输入框获得光标
		 flg7 = false; //就弹出提示信息        
      }else{
         $("#result7").hide();
         flg7=true;
      }
	  }
	  }
	  var flg8=false;
	function checkval(){
	 var name = $("#validResidencePermit").val();
	 var startdate =$("#startdate").val();
	 var d1 = new Date(startdate.replace(/\-/g, "\/"));
	  var d2 = new Date(name.replace(/\-/g, "\/"));
	 if(name.length==0){
	         $("#result8").html("居留许可有效期不能为空！");
	         $("#result8").show();
	         flg8=false;  
	 }else{
	   $("#result8").hide();
	   if(startdate!=""&&name!=""&&d1 >=d2){  
	      $("#result8").html("居留许可有效期不能早于入学时间！");
	      $("#result8").show();
	      flg8=false; 
	   }else{
	      $("#result8").hide();
	      flg8=true;
	   }
	 }
	}
	var flg9=false;
	function checkroom(){
	   var name = $("#roomplace").val();
	   var reg = /^[\u4e00-\u9fa5]+$/gi;
	   if(name==0){
	         $("#result9").html("住宿地点不能为空！");
	         $("#result9").show();
	         flg9=false; 
	   }else{
	     $("#result9").hide();
	     if(!isNaN(name)){
	         $("#result9").html("住宿地点不能全是数字！");
	         $("#result9").show();
	         flg9=false; 
	     }else{
	        $("#result9").hide();
	        flg9=true;
	     }
	   }
	}
	var flgtest=false;
	function checksource(){
	   var name = $("#source").val();
	   var reg = /^[\u4e00-\u9fa5]+$/gi;
	   if(name==0){
	         $("#result10").html("来源不能为空！");
	         $("#result10").show();
	         flgtest=false; 
	   } else{
	   if(!reg.test(name)){
	         $("#result10").html("请输入正确的汉字！");
	         $("#result10").show();
	         flgtest=false; 
	     }else{
	        $("#result10").hide();
	        flgtest=true;
	     }
	   }
	}
var flgtest1=false;
	function checkbrith(){
	 var start = $("#startdate").val();
	 var brithdate =$("#brithdate").val();
	 var d1 = new Date(start.replace(/\-/g, "\/"));
	 var d2 = new Date(brithdate.replace(/\-/g, "\/"));
	 if(brithdate.length==0){
	         $("#result11").html("出生日期不能为空！");
	         $("#result11").show();
	         flgtest1=false;  
	 }else{
	   if(start!=""&&brithdate!=""&&d2 >=d1){  
	      $("#result11").html("出生日期填写有误！");
	      $("#result11").show();
	      flgtest1=false; 
	   }else{
	      
	      var age = jsGetAge(brithdate);
	      if (age < 15 || age > 45){
	      	$("#result11").html("年龄必须大于15岁且小于45岁！");
	      	$("#result11").show();
	      	flgtest1=false; 
	      } else {
	      	$("#result11").hide();
	      	flgtest1=true;
	      }
	   }
	 }
	}
	
	
	function jsGetAge(strBirthday)
	{       
		var returnAge;
		var strBirthdayArr=strBirthday.split("-");
		var birthYear = strBirthdayArr[0];
		var birthMonth = strBirthdayArr[1];
		var birthDay = strBirthdayArr[2];
		
		d = new Date();
		var nowYear = d.getFullYear();
		var nowMonth = d.getMonth() + 1;
		var nowDay = d.getDate()
		
		if(nowYear == birthYear)
		{	
			if(birthMonth<nowMonth)
				returnAge=0;//同年月份为今月前，0岁
			else
				if(birthMonth==nowMonth && birthDay<=nowDay)
					returnAge = 0;//同年同月日期为今天前 0岁
				else 
					returnAge = -1;//同年同月但日为今天后或今月后，日期无效
		}
		else
		{
			var ageDiff = nowYear - birthYear ; //年之差
			if(ageDiff > 0)
			{
				if(nowMonth == birthMonth)
				{
					var dayDiff = nowDay - birthDay;//日之差
					if(dayDiff < 0)
					{
						returnAge = ageDiff - 1;
					}
					else
					{
						returnAge = ageDiff ;
					}
				}
				else
				{
					var monthDiff = nowMonth - birthMonth;//月之差
					if(monthDiff < 0)
					{
						returnAge = ageDiff - 1;
					}
					else
					{
						returnAge = ageDiff ;
					}
				}
			}
			else
			{
				returnAge = -1;//返回-1 表示出生日期输入错误 晚于今天
			}
		}
		return returnAge;//返回周岁年龄
}
var flgt = false;
function checkengname(){
   var firstname =$("#firstname").val();
   var lastname = $("#lastname").val();
   if(firstname.length==0){
      $("#result12").html("英文名不能为空");
      $("#result12").show();
      flgt=false;
   }else{
     $("#result12").hide();
     if(lastname.length==0){
        $("#result12").html("英文姓不能为空");
        $("#result12").show();
        flgt=false;
     }else{
        $("#result12").hide();
        var reg = /^[a-zA-Z]{2,}$/;
        if(!reg.test(firstname)||!reg.test(lastname)){
          $("#result12").html("英文名或英文姓为两个及以上的字符！");
          $("#result12").show();
          flgt=false;
        }else{
        //$("#result12").hide();
        /// if(firstname.length>=2&&lastname.legnth>=2){
            $("#result12").hide();
          flgt=true;
         //}else{
          // $("#result12").html("请填写大于两个字符的英文名或英文姓！");
          // $("#result12").show();
        // }
          
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
		
		<table cellpadding="0" cellspacing="0" class="l-table-edit" align="center" >
			
			<tr>
				<td align="right" class="l-table-edit-td">英文名:<font color="#ff0000">*</font></td>
				<td align="left" class="l-table-edit-td"><input name="firstname"type="text" id="firstname" ltype="text" onchange="checkengname()" /></td>
				<td align="left"></td>
				<td align="right" class="l-table-edit-td">英文姓:<font color="#ff0000">*</font></td>
				<td align="left" class="l-table-edit-td"><input name="lastname"type="text" id="lastname" ltype="text" onchange="checkengname()" /></td>
				<td align="left"><div id="result12" style="color: red;"></div></td>
			</tr>
			<tr>
				<td align="right" class="l-table-edit-td">姓名:<font color="#ff0000">*</font></td>
				<td align="left" class="l-table-edit-td"><input name="stuname"type="text" onchange="checkname()" id="stuname" ltype="text"  /></td>
				<td align="left"><div id="result" style="color: red;"></div></td>
				<td align="right" class="l-table-edit-td">国家:<font color="#ff0000">*</font></td>
				<td align="left" class="l-table-edit-td"><input name="nation"type="text" id="nation" onchange="checknation()" ltype="text"  /></td>
				<td align="left"><div id="result1" style="color: red;"></div></td>
			</tr>
			<tr>
			    <td align="right" class="l-table-edit-td">护照号:<font color="#ff0000">*</font></td>
				<td align="left" class="l-table-edit-td"><input name="passport"type="text" onchange="checkpassport()" id="passport" ltype="text" placeholder="请输入护照号" /></td>
				<td align="left"><div id="result2" style="color: red;"></div></td>
				<td align="right" class="l-table-edit-td">学号:<font color="#ff0000">*</font></td>
				<td align="left" class="l-table-edit-td"><input name="stunum"type="text" id="stunum" onchange="checknum()" ltype="text"  /></td>
				<td align="left"><div id="result3" style="color: red;"></div></td>
			</tr>
						
			<tr>
				<td align="right" class="l-table-edit-td">学生类别:<font color="#ff0000">*</font></td>
				<td align="left" class="l-table-edit-td"><input name="studenttype" type="text" id="studenttype" onchange="checktype()" ltype="text" value="语言"  /></td>
				<td align="left"><div id="result4" style="color: red;"></div></td>
				<td align="right" class="l-table-edit-td">专业:<font color="#ff0000">*</font></td>
				<td align="left" class="l-table-edit-td"><input name="major"type="text" id="major" onchange="checkmajor()" ltype="text" value=""  /></td>
				<td align="left"><div id="result5" style="color: red;"></div></td>
			</tr>
			<tr>
				<td align="right" class="l-table-edit-td">入学时间:<font color="#ff0000">*</font></td>
				<td align="left" class="l-table-edit-td"><input name="startdate"type="text" id="startdate" class="date_picker link" ltype="text"  /></td>
				<td align="left"></td>
				<td align="right" class="l-table-edit-td">离校时间:<font color="#ff0000">*</font></td>
				<td align="left" class="l-table-edit-td"><input name="enddate"type="text" id="enddate" class="date_picker link" ltype="text" onchange="checkdate()"  /></td>
				<td align="left"><div id="result6" style="color: red;"></div></td>
			</tr>
			<tr>
				<td align="right" class="l-table-edit-td">联系方式:<font color="#ff0000">*</font></td>
				<td align="left" class="l-table-edit-td"><input name="telephone"type="text" id="telephone" ltype="text" onchange="checkmobile()"  /></td>
				<td align="left"><div id="result7" style="color: red;"></div></td>
				<td align="right" class="l-table-edit-td">居留许可有效期:<font color="#ff0000">*</font></td>
				<td align="left" class="l-table-edit-td"><input name="validResidencePermit"type="text" onchange="checkval()" class="date_picker link" id="validResidencePermit" ltype="text"  /></td>
				<td align="left"><div id="result8" style="color: red;"></div></td>
			</tr>
			<tr>
				<td align="right" class="l-table-edit-td">住宿地点:<font color="#ff0000">*</font></td>
				<td align="left" class="l-table-edit-td"><input name="roomplace"type="text" id="roomplace" ltype="text" onchange="checkroom()" /></td>
				<td align="left"><div id="result9" style="color: red;"></div></td>
				<td align="right" class="l-table-edit-td">学生来源:<font color="#ff0000">*</font></td>
				<td align="left" class="l-table-edit-td"><input name="source"type="text" id="source" onchange="checksource()" ltype="text"  /></td>
				<td align="left"><div id="result10" style="color: red;"></div></td>
			</tr>	
			<tr>
				<td align="right" class="l-table-edit-td">出生年月:<font color="#ff0000">*</font></td>
				<td align="left" class="l-table-edit-td"><input name="brithdate"type="text" id="brithdate" onchange="checkbrith()" class="date_picker link" ltype="text" /></td>
				<td align="left"><div id="result11" style="color: red;"></div></td>
				<td align="right" class="l-table-edit-td">性别:</td>
				<td align="left" class="l-table-edit-td">
				   <input id="r1" type="radio" name="rbtnl" value="1" checked="checked" />
				   <label for="rbtnl_0">男</label> 
				    <input id="r2" type="radio" name="rbtnl" value="2" />
				   <label for="rbtnl_1">女</label>
				</td>
				<td align="left"></td>
			</tr>
			<td align="right" class="l-table-edit-td">班级:</td>
				<td align="left" class="l-table-edit-td">
                   <select name="classid" id="classid" ltype="select" style="width:140px;" >
						<s:iterator value="#classlist" id="gg">
							<s:if test="#gg.id==#clsid">
							     <option value="<s:property value="#gg.id"/>"><s:property value="#gg.classname" /></option>
							</s:if>
						</s:iterator>
				</select>
                </td>
			    <td align="right" class="l-table-edit-td"></td>
				<td align="left" class="l-table-edit-td"></td>
				<td align="left"></td>
				
				<td align="left"></td>
			</tr>				 
			
			<tr>
				<td align="right" class="l-table-edit-td"></td>
				<td align="left" class="l-table-edit-td"></td>
				<th align="left" colspan="2"><input class="l-button l-button-submit" type="submit" value="添&nbsp;加"/></th>
				<td align="left" class="l-table-edit-td"></td>
				<td align="left"></td>							
			</tr>
		</table>
		<br />
	</form>
</body>
</html>