<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">   
    <title>天津工业大学排课管理系统</title>	   
	<link href="<%=basePath%>js/ligerUI/skins/Aqua/css/ligerui-all.css" rel="stylesheet"type="text/css" />	
	<link href="<%=basePath %>js/ligerUI/skins/Gray/css/all.css" rel="stylesheet" type="text/css"/>	
	<link href="<%=basePath%>css/date.css" rel="stylesheet" type="text/css"/>
    <script src="js/jquery/jquery-1.6.min.js"type="text/javascript"></script>
    <script src="js/jquery/jquery.js"type="text/javascript"></script>
	<script src="js/ligerUI/core/base.js" type="text/javascript"></script>
	<script src="js/ligerUI/ligerui.all.js" type="text/javascript"></script>
	<script src="js/ligerUI/plugins/ligerDateEditor.js" type="text/javascript"></script>
	<script src="<%=basePath%>js/jquery.date_input.pack.js" type="text/javascript"></script>
<script type="text/javascript">
    $(function(){
	  $('.date_picker').date_input();
   })
    var AttendenceData = { 
	Rows: [<%String s = (String) request.getAttribute("attendencelist");%> <%=s%>]};
    var TypeData = [{ type: 0, text: '正常' }, { type: 1, text: '迟到'}, { type: 2, text: '早退'}, { type: 3, text: '旷课'}];
   $(f_initGrid);
	var manager, g;
	function f_initGrid() {
		g = manager = $("#maingrid").ligerGrid(
			{columns : [
			{   display : '序号',  name : 'id',     width : 40,  type : 'int',hide:true
			}, {display : '学号', name : 'stunum',  minWidth : 120, editor: { type: 'text'}
			}, {display : '中文名', name : 'stuname',minWidth : 80, editor: { type: 'text'}
			}, {display : '课程名称', name : 'coursename',minWidth : 80, editor: { type: 'text'}
			}, {display : '日期', name : 'date',minWidth : 80, editor: { type: 'text'}
			}, {display : '时间', name : 'time',minWidth : 80, editor: { type: 'text'}			
            }, {display : '考勤状态', name : 'type',minWidth : 80, 
            editor: { type: 'select', data: TypeData, valueField: 'type' },
                    render: function (item)
                    {
                        if (parseInt(item.type) == 0){ var h="<span style='color:black;'>正常</span>" ;return h;}
                        else if (parseInt(item.type) == 1) { var h="<span style='color:orange;'>迟到</span>" ;return h;}
                        else if (parseInt(item.type) == 2) { var h="<span style='color:blue;'>早退</span>" ;return h;}
                        else if (parseInt(item.type) == 3) { var h="<span style='color:red;'>旷课</span>" ;return h;}
                    }}
			],
					onSelectRow : function(rowdata, rowindex) {
						$("#txtrowindex").val(rowindex);
					},
					enabledEdit : true,
					clickToEdit : false,
					isScroll : false,
			        rownumbers:true,
			        pageSize:10,
					url : '${pageContext.request.contextPath}/system/Manage_personattendencelist.action',
					width : '100%'
				});//'${pageContext.request.contextPath}/system/Manage_attendencestulist.action'
	}	
  function f_search(){ 
   if ((document.all.course.value =="")&&(document.all.date.value =="")&&(document.all.type.value =="")){
	$("#maingrid").ligerGrid({
		  url:'${pageContext.request.contextPath}/system/Manage_personattendencelist.action'
		})
   }else{
       // alert($("#course option:selected").val());
		var str = "${pageContext.request.contextPath}/system/Manage_stuattendenceresearch.action?attendence.choosencourseid=" + encodeURI(encodeURI($("#course option:selected").val())
		+"&attendence.date="+encodeURI(encodeURI($("#date").val()))
		+"&attendence.type="+encodeURI(encodeURI($("#type").val())));
		$("#maingrid").ligerGrid({
		  url:str
		})
   }
  }
    
</script>
<style type="text/css">
body{font-size: 12px;padding: 2px}
.l-table-edit-td{font-size: 14px;padding: 5px;margin-left: 2px;}
.link{width:160px;height:25px;background: #fefefe;border: 1px solid #bbb;font-size: 14px;color: #333;border-radius: 3px;}
.data-table{ border:1px #ebebeb solid; border-bottom:none;width:70%;border-spacing: 0px;margin: auto;}
.data-table td{height:28px; padding-left:5px; border-bottom:1px #ebebeb solid;}
.td-cb{ width:20px;}
.data-table a{ color:#3377aa;text-decoration:none;}
.data-table a:hover{background:none;color:#3377aa;text-decoration:underline;}
.data-table tbody tr:hover{ background:#ffffe1;}
td .action{ width:20px; position:relative;}
.ac td .act-box a{text-decoration:none;}
.action .arrow{ text-align:center; width:16px; height:16px; border:1px solid #DADADA; cursor:pointer; z-index:-1;}
.action .arrow img{ margin-top:6px;}
.action .act-box{ position:absolute; min-width:80px; text-align:center; right:2px; background-color:White; border:1px solid #DADADA; display:none; z-index:100;}
.act-box a{ display:block; width:80px; height:20px; line-height:20px;text-decoration:none;}
.act-box a:hover{ color:White; background:#37A; text-decoration:none;}
#content{
  margin-top:20px;
}
#table3{
  margin:auto;
  margin-top: 10px;
  font-size: 15px;
  width: 350px;
}
#head{
 width: 99%;
 height:100px;
 margin:auto;
 border:4px solid #c6c6c6 ;
}
.title{
 float: left;
 height: 100%;
 width: 10%;
 text-aligncenter;
 border-right:2px solid #c6c6c6 ;
}
.search{
  float: left;
  margin-top: 25px;
}
.l-table-edit{
 margin-top: 10px;
 margin-left: 20px;
}
.link{
width:160px;height:25px;background: #fefefe;border: 1px solid #bbb;font-size: 14px;color: #333;border-radius: 3px;
}
.l-button{
 width:70px;float:left; margin:20px 160px 5px ;
 border-radiux:5px;
}
</style>
	</head>
	<body >
	<div id="head">
	      <div class="title" ><br><br><div align="center"><font face="微软雅黑" color="#400000" size="4"><strong>条件选择</strong></font></div></div>
	      <div class="search" >
		  <table cellpadding="0" cellspacing="0" class="l-table-edit" >
			<tr>
				<td align="right" class="l-table-edit-td">&nbsp;课程:</td>
				<td align="left" class="l-table-edit-td">
				  <select name="course" id="course" ltype="select" class="link">
						<option></option>
						<s:iterator value="#courselist" id="gg">
						   <option value="<s:property value="#gg.num"/>"><s:property value="#gg.coursename" /></option>
						</s:iterator>
				</select>
				</td>
				<td align="right" class="l-table-edit-td">&nbsp;时间:</td>
				<td align="left" class="l-table-edit-td"><input  id="date" class="date_picker link"></td>
			    <!-- <td align="right" class="l-table-edit-td">&nbsp;节次:</td>
				<td align="left" class="l-table-edit-td">
				  <select id="time" name="time" class="link"   >
				    <option value=""></option>
				    <option value="8:20-10:00">第一大节</option>				  
				    <option value="10:20-12:00">第二大节</option>
				    <option value="14:00-15:40">第三大节</option>
				    <option value="16:00-17:40">第四大节</option>
				    <option value="18:30-20:10">第五大节</option>
				  </select>
				</td> -->
				<td align="right" class="l-table-edit-td">&nbsp;出勤状态:</td>
				<td align="left" class="l-table-edit-td">
				  <select id="type" name="type" class="link"  >
				    <option value=""></option>
				    <option value="0">正常</option>				  
				    <option value="1">迟到</option>
				    <option value="2">早退</option>
				    <option value="3">旷课</option>				    
				  </select>
				</td>
			</tr>
		</table>
		<a class="l-button" onclick="f_search()"><strong>查&nbsp;&nbsp;询</strong></a>
		</div>
	    </div>	
		<div style="margin-top:20px;font-size: 16px;margin-left: 30px;">考勤记录：</div>
	    <div class="l-clear"></div>
		<div id="maingrid" ></div>
		<div  style="display:none;">
	

</body>
</html>