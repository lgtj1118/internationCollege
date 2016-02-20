<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>  
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>班级列表</title>
	<link href="<%=basePath%>js/ligerUI/skins/Aqua/css/ligerui-all.css" rel="stylesheet"type="text/css" />	
	<link href="<%=basePath %>js/ligerUI/skins/Gray/css/all.css" rel="stylesheet" type="text/css"/>	
	<link href="<%=basePath%>css/date.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="<%=basePath %>js/json2.js" charset="utf-8"></script>
    <script type="text/javascript" src="<%=basePath %>js/jquery/jquery-1.3.2.min.js"></script>
	<script src="<%=basePath %>js/ligerUI/core/base.js" type="text/javascript"></script>
	<script src="<%=basePath %>js/ligerUI/ligerui.all.js" type="text/javascript"></script>
	<script src="<%=basePath%>js/jquery.date_input.pack.js" type="text/javascript"></script>	
	<script type="text/javascript">
     $(function(){
	     $('.date_picker').date_input();
	 })
    var ClassStuData = {Rows: [
		<%String  ss= (String) request.getAttribute("studentlist");%>
		<%=ss%>
		 ]};	
   $(f_initGrid);
	var manager, g;
	function f_initGrid() {
		g = manager = $("#maingrid").ligerGrid(
			{columns : [
			{   display : '序号',  name : 'id',     width : 40,  type : 'int',hide:true
			},{display : '护照号', name : 'passport', minWidth : 100,  editor:{type:'text'}	}
			, {display : '学号', name : 'stuid',  minWidth : 120, editor: { type: 'text'}
			/* }, {display : '英文名', name : 'firstname',minWidth : 100, editor: { type: 'text'}
			}, {display : '英文姓', name : 'lastname',minWidth : 100, editor: { type: 'text'} */
			}, {display : '姓名', name : 'stuname',minWidth : 80, editor: { type: 'text'}			
			}/*  ,{ display: '班级',  name: 'classid', minWidth: 100, isSort: false,
            editor: { type: 'select', data: ClassList, valueColumnName: 'Classid', displayColumnName: 'Classname' }, 
                  render: function (item)
                    {for (var i = 0; i < ClassList.length; i++)
                        { if (ClassList[i]['Classid'] == item.classid)
                                return ClassList[i]['Classname'];
                        }
                        return item.Classname;
                    }
                } */
             ,{display : '电话', name : 'telephone', minWidth : 100,  editor:{type:'text'} }
             ],
					onSelectRow : function(rowdata, rowindex) {
						$("#txtrowindex").val(rowindex);
					},
					checkbox:true,
					enabledEdit : true,
					clickToEdit : false,
					isScroll : false,
					rownumbers:true, 
					pageSize:30,
					//url :'${pageContext.request.contextPath}/system/Stu_attendencestulist.action',
					data:ClassStuData,
					width : '100%'
				});
	} 
	function attendence(){
	  var row = manager.getSelectedRow();
		if (!row) {
			alert('请选择至少一名学生！');
			return;
		}
      var str = "";
      var rows = manager.getCheckedRows();
      $(rows).each(function ()
       {
         str += this.passport + ",";
       });
      var str1="0";
      if((document.all.date.value =="")){
	      $("#result").html("日期不能为空！");
	   $("#result").show();
	   }else{
	      $("#result").hide();
	      check();
	      if(flg){
	         $.post("${pageContext.request.contextPath}/system/Manage_stuattendenceadd.action?ids="+ str
	  +"&attendence.type="+str1
	  +"&attendence.date="+encodeURI(encodeURI($("#date").val()))
	  +"&attendence.time="+encodeURI(encodeURI($("#time option:selected").val()))
	  +"&attendence.choosencourseid="+encodeURI(encodeURI($("#courseid").val()))
		,null,function(){
		manager.deleteSelectedRow();
		alert("操作成功！");
	   });
	      }
	      
	   }
	}
	function late(){
	  var row = manager.getSelectedRow();
		if (!row) {
			alert('请选择至少一名学生！');
			return;
		}
      var str = "";
      var rows = manager.getCheckedRows();
      $(rows).each(function ()
       {
         str += this.passport + ",";
       });
      var str1="1";
      if((document.all.date.value =="")){
	      $("#result").html("日期不能为空！");
	   $("#result").show();
	   }else{
	      $("#result").hide();
	      check();
	      if(flg){
	      $.post("${pageContext.request.contextPath}/system/Manage_stuattendenceadd.action?ids="+ str
	  +"&attendence.type="+str1
	  +"&attendence.date="+encodeURI(encodeURI($("#date").val()))
	  +"&attendence.time="+encodeURI(encodeURI($("#time option:selected").val()))
	  +"&attendence.choosencourseid="+encodeURI(encodeURI($("#courseid").val()))
		,null,function(){
		manager.deleteSelectedRow();
		alert("操作成功！");
	   });	      
	      }	      
	   }	
	}
	function leaveearly(){
	  var row = manager.getSelectedRow();
		if (!row) {
			alert('请选择至少一名学生！');
			return;
		}
      var str = "";
      var rows = manager.getCheckedRows();
      $(rows).each(function ()
       {
         str += this.passport + ",";
       });
      var str1="2";
      if((document.all.date.value =="")){
	      $("#result").html("日期不能为空！");
	   $("#result").show();
	   }else{
	      $("#result").hide();
	      check();
	      if(flg){
	        $.post("${pageContext.request.contextPath}/system/Manage_stuattendenceadd.action?ids="+ str
	  +"&attendence.type="+str1
	  +"&attendence.date="+encodeURI(encodeURI($("#date").val()))
	  +"&attendence.time="+encodeURI(encodeURI($("#time option:selected").val()))
	  +"&attendence.choosencourseid="+encodeURI(encodeURI($("#courseid").val()))
		,null,function(){
		manager.deleteSelectedRow();
		alert("操作成功！");
	   });
	    }	      
	   }
	}
	function notarrival(){
	var row = manager.getSelectedRow();
		if (!row) {
			alert('请选择至少一名学生！');
			return;
		}
      var str = "";
      var rows = manager.getCheckedRows();
      $(rows).each(function ()
       {
         str += this.passport + ",";
       });
      var str1="3";
      if((document.all.date.value =="")){
	      $("#result").html("日期不能为空！");
	   $("#result").show();
	   }else{
	      $("#result").hide();
	      check();
	      if(flg){
	      $.post("${pageContext.request.contextPath}/system/Manage_stuattendenceadd.action?ids="+ str
	  +"&attendence.type="+str1
	  +"&attendence.date="+encodeURI(encodeURI($("#date").val()))
	  +"&attendence.time="+encodeURI(encodeURI($("#time option:selected").val()))
	  +"&attendence.choosencourseid="+encodeURI(encodeURI($("#courseid").val()))
		,null,function(){
		manager.deleteSelectedRow();
		alert("操作成功！");
	   });
	      }	      
	   }
	}
	var flg = false;
	function check(){
	  var date =$("#date").val();
	  var nowDate = new Date();
	  var now = nowDate.getFullYear()+"-"+(parseInt(nowDate.getMonth())+1)+"-"+nowDate.getDate();
	  var d1 = new Date(date.replace(/\-/g, "\/"));
	  var d2 = new Date(now.replace(/\-/g, "\/"));
	  if(d1>d2){  
          $("#result1").html("考勤日期不得晚于今天！");
          $("#result1").show();
           flg=false;
           return false;  
         }else{
           $("#result1").hide();
           flg=true;
          } 
	}
    </script>
    <style type="text/css">
body {
	font-size: 12px;
}
#head{
   margin-top:10px;
   margin-buttom:10px;
}
.l-table-edit-td {
	padding: 4px;
}
.s {
	width: 61px;
	height: 18px;
	display: inline-block;
	background-color: #eeeeee;
	text-align: center;
	font-size: 13px;
}
.l-button-submit,.l-button-test {
	width: 80px;
	float: left;
	margin-left: 10px;
	padding-bottom: 2px;
}
.l-verify-tip {
	left: 230px;
	top: 120px;
}
.link{
width:160px;height:25px;background: #fefefe;border: 1px solid #bbb;font-size: 14px;color: #333;border-radius: 3px;
}
#result{
 color: red;
}
</style>
	</head>
	<body style="padding: 2px">
	<div id="head">
		  <table cellpadding="0" cellspacing="0" class="l-table-edit" >
			<tr>
				<td align="right" class="l-table-edit-td">时间:</td>
				<td align="left" class="l-table-edit-td"><input  id="date" onchange="check()" ltype="text" type="text" class="date_picker link"></td>
			    <td align="right" class="l-table-edit-td">节次:</td>
				<td align="left" class="l-table-edit-td">
				  <select id="time" name="time" class="link"   >
				    <option value="8:20-10:00">第一大节</option>				  
				    <option value="10:20-12:00">第二大节</option>
				    <option value="14:00-15:40">第三大节</option>
				    <option value="16:00-17:40">第四大节</option>
				    <option value="18:30-20:10">第五大节</option>
				  </select>
				</td>
				
				<td align="right" class="l-table-edit-td"><!-- 课程: --><input id="courseid" value="${course.num }" type="hidden"/></td>
				<td align="left" class="l-table-edit-td"><%-- <input class="link" ltype="text" name="coursename"type="text" disabled="disabled" id="coursename" ltype="text" value="${course.coursename }"  type="hidden"/> --%></td>				
			</tr>
			<tr>
			  <th colspan="6"><div id="result"></div><div id="result1" style="color: red;" ></div></th>
			</tr>						
		</table>
		</div>
		<a class="l-button" style="width:70px;float:left; margin:3px;" onclick="attendence()">出&nbsp;&nbsp;勤</a>
		<a class="l-button" style="width:70px;float:left; margin:3px;" onclick="late()">迟&nbsp;&nbsp;到</a>
		<a class="l-button" style="width:70px;float:left; margin:3px;" onclick="leaveearly()">早&nbsp;&nbsp;退</a>
		<a class="l-button" style="width:70px;float:left; margin:3px;" onclick="notarrival()">旷&nbsp;&nbsp;课</a>
		<div class="l-clear"></div>
		<div id="maingrid" ></div>
		<div  style="display:none;">
</div>
	</body>
</html>
