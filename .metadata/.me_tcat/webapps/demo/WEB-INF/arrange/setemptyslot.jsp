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
	function f_addselect(){
	  var slottable = document.getElementById("setslot");
	  var size=$('select').size()/2;
	  NewRow = slottable.insertRow(-1); 
	  NewRow.setAttribute('class', 'tabletr');//添加行
      newcell1= NewRow.insertCell(-1);                     //添加列
      newcell2=NewRow.insertCell(-1);
      newcell3=NewRow.insertCell(-1);
      newcell4=NewRow.insertCell(-1);
      newcell1.setAttribute('class','l-table-edit-td');  
	  newcell2.setAttribute('class','l-table-edit-td');  
	  newcell3.setAttribute('class','l-table-edit-td');  
	  newcell4.setAttribute('class','l-table-edit-td');  
      newcell1.innerHTML = "星期:&nbsp;";
      var num =parseInt(size)+parseInt(1);  
      var select = "<select id='weekday"+num+"'><option value='' ></option> <option value='0' >周一</option><option value='1' >周二</option><option value='2' >周三</option><option value='3' >周四</option> <option value='4' >周五</option><option value='5' >周六</option><option value='6' >周天</option> </select>";
      var slot = "<select id='slot"+num+"'><option value='' ></option> <option value='0' >第一大节</option><option value='1' >第二大节</option><option value='2' >第三大节</option><option value='3' >第四大节</option> <option value='4' >第五大节</option> </select>";//添加数据
      newcell2.innerHTML=select;//
      newcell3.innerHTML = "节次:&nbsp;";
      newcell4.innerHTML =  slot;  
	}
	var flg = true;
	function f_next(){
	   var size=$('select').size()/2;
	   var str = "";
	   for(var i=1;i<=size;i++){
	      var weekday ,slot;
	      weekday = $("#weekday"+i+" option:selected").val();
	      slot = $("#slot"+i+" option:selected").val();
	      if(weekday.length!=0){
	        if(slot.length!=0){
	            var test = parseInt(weekday)*5+parseInt(slot);
	            str = str + test+",";
	            $("#result").hide();
	        }else{
	            $("#result").html("请设置节次！");
	            $("#result").show();
	            flg=false;
	            $("#slot").focus();
	        }
	      }
	   }	  
	   if(flg){
	      parent.m.hide();
	      var url ="Manage_chkRooms.action?semChosenCourse.semester="+$("#semester").val()+"&setemptyslot="+str;
	      parent.window.location.href=url;
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
select {
	width:160px;
}
.tabletr{
 text-align: center;
 margin-top: 10px;
}
</style>

</head>

<body style="padding: 10px">

	<form name="form1" method="post" action="" id="form1">
	    <input id="semester" value="${semester }" type="hidden"  />
		<div id="errorLabelContainer" class="l-text-invalid"></div>
		<div align="center" style="font-size: 16px;" >设定选修课程上课时间</div>
		<table id="setslot" cellpadding="0" cellspacing="0" class="l-table-edit" align="center" >
			<tr class="tabletr" >
				<td  class="l-table-edit-td">星期:&nbsp;</td>
				<td  class="l-table-edit-td">
				   <select id="weekday1" name="weekday1" >
				       <option value="" ></option>
				       <option value="0" >周一</option>
				       <option value="1" >周二</option>
				       <option value="2" >周三</option>
				       <option value="3" >周四</option>
				       <option value="4" >周五</option>
				       <option value="5" >周六</option>
				       <option value="6" >周天</option>
				   </select>
				</td>
				<td  class="l-table-edit-td">节次:</td>
				<td  class="l-table-edit-td">
				   <select id="slot1" name="slot1" >
				       <option value="" ></option>
				       <option value="0" >第一大节</option>
				       <option value="1" >第二大节</option>
				       <option value="2" >第三大节</option>
				       <option value="3" >第四大节</option>
				       <option value="4" >第五大节</option>
				   </select>
				</td>
			</tr>
			<tr class="tabletr">
				<td  class="l-table-edit-td">星期:&nbsp;</td>
				<td  class="l-table-edit-td">
				   <select id="weekday2" name="weekday2" >
				       <option value="" ></option>
				       <option value="0" >周一</option>
				       <option value="1" >周二</option>
				       <option value="2" >周三</option>
				       <option value="3" >周四</option>
				       <option value="4" >周五</option>
				       <option value="5" >周六</option>
				       <option value="6" >周天</option>
				   </select>
				</td>
				<td  class="l-table-edit-td">节次:</td>
				<td  class="l-table-edit-td">
				   <select id="slot2" name="slot2" >
				       <option value="" ></option>
				       <option value="0" >第一大节</option>
				       <option value="1" >第二大节</option>
				       <option value="2" >第三大节</option>
				       <option value="3" >第四大节</option>
				       <option value="4" >第五大节</option>
				   </select>
				</td>
			</tr>	 			
			<tr class="tabletr" >
				<td  class="l-table-edit-td">星期:&nbsp;</td>
				<td  class="l-table-edit-td">
				   <select id="weekday3" name="weekday3" >
				       <option value="" ></option>
				       <option value="0" >周一</option>
				       <option value="1" >周二</option>
				       <option value="2" >周三</option>
				       <option value="3" >周四</option>
				       <option value="4" >周五</option>
				       <option value="5" >周六</option>
				       <option value="6" >周天</option>
				   </select>
				</td>
				<td  class="l-table-edit-td">节次:</td>
				<td  class="l-table-edit-td">
				   <select id="slot3" name="slot3" >
				       <option value="" ></option>
				       <option value="0" >第一大节</option>
				       <option value="1" >第二大节</option>
				       <option value="2" >第三大节</option>
				       <option value="3" >第四大节</option>
				       <option value="4" >第五大节</option>
				   </select>
				</td>
			</tr>			
			
			<tr>
			   <td colspan="4" align="center" ><br /></td>
			</tr>			
		</table>
		<div align="center"><strong>注：</strong>如无需设定的定上课日期，可留空点击设置！</div>
		<div align="center">
		<input type="button" style="margin-right: 120px;margin-top:30px;" onclick="f_next()" value="设&nbsp;置" id="Button1" class="l-button" />
		<input type="button" style="margin-left: 10px;margin-top:30px;"  onclick="f_addselect()" value="添加一行" id="Button" class="l-button " />
		     
				
		</div>
		<br />
	</form>
</body>
</html>