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
<script src="<%=basePath%>js/jquery/jquery-1.3.2.min.js" type="text/javascript"></script>
<link href="<%=basePath%>css/date.css" rel="stylesheet" type="text/css"/>
<script src="<%=basePath%>js/jquery.date_input.pack.js" type="text/javascript"></script>
<script src="<%=basePath%>js/ligerUI/core/base.js" type="text/javascript"></script>
<script type="text/javascript" src="<%=basePath %>js/ligerUI/ligerui.all.js" ></script>
<script src="<%=basePath%>js/ligerUI/plugins/ligerTip.js" type="text/javascript"></script>
<script src="<%=basePath%>js/jquery-validation/jquery.validate.min.js"type="text/javascript"></script>
<script src="<%=basePath%>js/jquery-validation/jquery.metadata.js" type="text/javascript"></script>
<script src="<%=basePath%>js/jquery-validation/messages_cn.js" type="text/javascript"></script>
<script type="text/javascript">
$(function(){
	     $('.date_picker').date_input();
	 });
 $(function(){
		$("input[type=file]").change(function(){
			$(this).parents(".uploader").find(".filename").val($(this).val());
		});
		$("input[type=file]").each(function(){
			if ($(this).val() == "") {
				$(this).parents(".uploader").find(".filename").val("请选择文件...");
			}
		});
	});
	var eee;
	$(function(){
		$.metadata.setType("attr", "validate");
		var v = $("form")
			.validate({
				//调试状态，不会提交数据的
				debug : false,
				errorPlacement : function(lable , element){
					if (element.hasClass("l-textarea")) {
						element.addClass("l-textarea-invalid");
					} else if (element.hasClass("l-text-field")) {
						element.parent().addClass("l-text-invalid");
					}
					var nextCell = element.parents("td:first").next("td");
					if (nextCell.find("div.l-exclamation").length == 0) {
						$('<div class="l-exclamation" title="' + lable.html() + '"></div>').appendTo(nextCell).ligerTip();
					}
				},
				invalidHandler : function(form , validator){
					var errors = validator.numberOfInvalids();
					if (errors) {
						var message = errors == 1 ? '请假时间不能为空！' : '这 ' + errors + ' 几项有误！';
						$("#errorLabelContainer").html(message).show();
					}
				},
				submitHandler : function(){
					$("form .l-text,.l-textarea").ligerHideTip();
					var reason = $("#reason").val();
				check();
				if (reason.length == 0) {
						alert("请输入请假原因！");
				} else {
				checkmobile();
				if (flg&&flg7) {
							/* var str = 1;
							$.post("${pageContext.request.contextPath}/system/Manage_leaveadd.action?leave.passport=" + $("#passport").val() 
							+ "&leave.leavingdate=" + encodeURI(encodeURI($("#startdate").val())) 
							+ "&leave.backdate=" + encodeURI(encodeURI($("#enddate").val())) 
							+ "&leave.leavereason=" + encodeURI(encodeURI($("#reason").val())) 
							+ "&leave.telephone=" + encodeURI(encodeURI($("#telephone").val()))
							+ "&leave.type=" + str
							+ "&leaveDoc=" + $("#doc").val() , 
							null, function(){
									//alert('提交成功!');
									parent.m.hide();
									parent.g.loadData();
								}); */
							parent.m.hide();
							submit();
							//parent.g.loadData();
						}
					}
				}
			});
		$("form").ligerForm();
		$(".l-button-test").click(function(){
			alert(v.element($("#txtName")));
		});
	});
   var flg = false;
    function check(){
    var myDate = new Date();
    var year=myDate.getFullYear();
    var month = myDate.getMonth()+1;
    var day = myDate.getDate();
    if(month<10){
      month="0"+month;
    }
    var nowdate = year+"-"+month+"-"+day;
    var startdate = document.getElementById("startdate").value;
    var enddate = document.getElementById("enddate").value;
    var d1 = new Date(startdate.replace(/\-/g, "\/"));  
    var d2 = new Date(enddate.replace(/\-/g, "\/"));
    var d3 = new Date(nowdate.replace(/\-/g, "\/")); 
    var days = d1.getTime() - d3.getTime();
    var day1 = d2.getTime()-d1.getTime();
    var time = parseInt(days / (1000 * 60 * 60 * 24));
    var time1 = parseInt(day1 / (1000 * 60 * 60 * 24));
    if(startdate.length==0){
         $("#result").html("请假开始时间不能为空！");
         $("#result").show();
         flg= false;
         return false;
    }else{
      $("#result").hide();
      if(enddate.length==0){
         $("#result").html("请假截止时间不能为空！");
         $("#result").show();
         flg= false;
         return false;
      }else{
        $("#result").hide();
        if(d1<d3){
           $("#result").html("请假时间不能早于今天！");
           $("#result").show();
           flg= false;
           return false;
       }else{
         $("#result").hide();
         if(time<2){
            $("#result").html("请假时间需提前两天！");
            $("#result").show();
            flg = false;
            return false;
         }else{
           $("#result").hide();
           if(d2<d1){
              $("#result").html("截止时间不能早于开始时间！");
              $("#result").show();
              flg = false;
              return false;
         }else{
             $("#result").hide();
             if(time1>3){
                 $("#result").html("短期请假不能超过三天！");
                 $("#result").show();
                 flg = false;
                 return false;
             }else{
                $("#result").hide();
                $.post("${pageContext.request.contextPath}/system/Manage_checkleave.action?leave.passport="+$("#stuid").val()+"&leave.leavingdate="+$("#startdate").val()
                ,null,function(data){
                  if(data=="fail"){
                    $("#result").html("你还有未销假或未审核的申请，不能再次申请！");
                    $("#result").show();
                    flg = false;
                    return false;
                  }else{
                       $("#result").hide();
                      flg= true;
                  }
                })
               
             }
         }
        }        
      }
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
</script>
<style type="text/css">
body{ font-size:12px;}
.l-table-edit {}
.l-table-edit-td{ padding:4px;}
.l-button-submit,.l-button-test{width:80px; float:left; margin-left:10px; padding-bottom:2px;}
.l-verify-tip{ left:230px; top:120px;}
#errorLabelContainer{ padding:10px; width:300px; border:1px solid #FF4466; display:none; background:#FFEEEE; color:Red;}
.uploader { position:relative; display:inline-block; overflow:hidden; cursor:default; padding:0; -moz-box-shadow:0px 0px 5px #ddd; -webkit-box-shadow:0px 0px 5px #ddd; box-shadow:0px 0px 5px #ddd; -moz-border-radius:5px; -webkit-border-radius:5px; border-radius:5px; }
.filename { float:left; display:inline-block; outline:0 none; margin:0;  overflow:hidden; cursor:default;border-right:0; font:9pt/100% Arial, Helvetica, sans-serif; color:#777; text-shadow:1px 1px 0px #fff; text-overflow:ellipsis; white-space:nowrap;  background:-moz-linear-gradient(top, #fafafa 0%, #eee 100%); background:-webkit-gradient(linear, left top, left bottom, color-stop(0%, #fafafa), color-stop(100%, #f5f5f5)); filter:progid:DXImageTransform.Microsoft.gradient(startColorstr='#fafafa', endColorstr='#f5f5f5', GradientType=0);
border-color:#ccc; -moz-box-shadow:0px 0px 1px #fff inset; -webkit-box-shadow:0px 0px 1px #fff inset; box-shadow:0px 0px 1px #fff inset; -moz-box-sizing:border-box; -webkit-box-sizing:border-box; box-sizing:border-box; }

.uploader input[type=file] { position:absolute; top:0; right:0; bottom:0; border:0; padding:0; margin:0; height:30px; cursor:pointer; filter:alpha(opacity=0); -moz-opacity:0; -khtml-opacity: 0; opacity:0; }

/* White Color Scheme ------------------------ */

.white .button { color:#555; text-shadow:1px 1px 0px #fff; background:#ddd; background:-moz-linear-gradient(top, #eeeeee 0%, #dddddd 100%); background:-webkit-gradient(linear, left top, left bottom, color-stop(0%, #eeeeee), color-stop(100%, #dddddd)); filter:progid:DXImageTransform.Microsoft.gradient(startColorstr='#eeeeee', endColorstr='#dddddd', GradientType=0);
border-color:#ccc; }
.white:hover .button { background:#eee; background:-moz-linear-gradient(top, #dddddd 0%, #eeeeee 100%); background:-webkit-gradient(linear, left top, left bottom, color-stop(0%, #dddddd), color-stop(100%, #eeeeee)); filter:progid:DXImageTransform.Microsoft.gradient(startColorstr='#dddddd', endColorstr='#eeeeee', GradientType=0);
}

</style>

</head>

<body style="padding: 10px">

	<form name="form1" method="post" namespace="/system" action="Manage_leaveadd.action" enctype="multipart/form-data">
		<input type="hidden" name="leave.type" value="1"/>
		<div id="errorLabelContainer" class="l-text-invalid"></div>
		<div><input id="stuid" value="${student.passport }" type="hidden"/></div>
		<table cellpadding="0" cellspacing="0" class="l-table-edit">
			<tr>
				<td align="right" class="l-table-edit-td">姓名:</td>
				<td align="left" class="l-table-edit-td"><input id="stuname" disabled="disabled" value="${student.stuname }"/></td>
				<td align="left"></td>
				<td align="right" class="l-table-edit-td">国家:</td>
				<td align="left" class="l-table-edit-td"><input id="nation" disabled="disabled" value="${student.nation }" /></td>
				<td align="left"></td>
			</tr>
			<tr>
			   <td align="right" class="l-table-edit-td">护照号:</td>
				<td align="left" class="l-table-edit-td"><input name="leave.passport"id="passport" disabled="disabled" value="${student.passport }"  /></td>
				<td align="left"></td>
				<td align="right" class="l-table-edit-td">学号:</td>
				<td align="left" class="l-table-edit-td"><input name="stunum" id="stunum" disabled="disabled" value="${student.stuid }" /></td>
				<td align="left"></td>
			</tr>
			<tr>
				<td align="right" class="l-table-edit-td">班级:</td>
				<td align="left" class="l-table-edit-td"><input id="classname" disabled="disabled" value="${student.classes.classname }"/></td>
				<td align="left"></td>
				<td align="right" class="l-table-edit-td">专业:</td>
				<td align="left" class="l-table-edit-td"><input name="major" disabled="disabled" id="major" value="${student.classes.major }" /></td>
				<td align="left"></td>
			</tr>
			<tr>
				<td align="right" class="l-table-edit-td">联系方式:<font color="#ff0000">*</font></td>
				<td align="left" class="l-table-edit-td"><input name="leave.telephone"id="telephone" onchange="checkmobile()" value="${student.telephone }" onchange="checkmobile()" /></td>
				<td align="left" ><div id="result7" style="color: red;" ></div></td>
				<td align="right" class="l-table-edit-td" width="80px">选择文件:</td>
				<td align="left" class="l-table-edit-td">
				   <div class="uploader">
						<input type="text" name="docName" class="filename" readonly /> 
						<!--  <input accept="" type="button" class="button" value="上传..." />-->
					    <input type="file" name="leaveDoc"  size="30" />
					</div>
                </td>
				<td align="right"></td>
			</tr>		
			<tr>
				<td align="right" class="l-table-edit-td">起始时间:<font color="#ff0000">*</font></td>
				<td align="left" class="l-table-edit-td"><input name="leave.leavingdate"  id="startdate"   class="date_picker link" onchange="check()" ></td>
				<td align="left"></td>
				<td align="right" class="l-table-edit-td">截止时间:<font color="#ff0000">*</font></td>
				<td align="left" class="l-table-edit-td"><input name="leave.backdate"  id="enddate" class="date_picker link" onchange="check()"  ></td>
				<td align="left"></td>
			</tr>
			<tr>
				<td align="right" class="l-table-edit-td">请假事由:<font color="#ff0000">*</font></td>
				<th align="left" class="l-table-edit-td" colspan="5"><textarea name="leave.leavereason" id="reason"  style="width: 400px;height: 200px;"    ></textarea></th>
			</tr>		 
			<tr>
				<th align="center" class="l-table-edit-td"colspan="6"><div id="result" style="color: red;"></div><div id="result1" style="color: red;"></div></th>								
			</tr>
			<tr>
				
				<td align="left" class="l-table-edit-td"></td>
				<td align="left" class="l-table-edit-td"></td>
				<td align="left"></td>
				<td align="left" ><input class="l-button l-button-submit" type="submit"  value="请&nbsp;&nbsp;假"/></td>
				<td align="left"></td>
				<td align="left"></td>							
			</tr>
		</table>
		<br />
	</form>
</body>
</html>