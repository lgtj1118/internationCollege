<%@page import="org.springframework.web.context.request.SessionScope"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">   
    <title>天津工业大学国际教育学院教学服务系统</title>	   
	<link href="<%=basePath%>js/ligerUI/skins/Aqua/css/ligerui-all.css" rel="stylesheet"type="text/css" />	
	<link href="<%=basePath %>js/ligerUI/skins/Gray/css/all.css" rel="stylesheet" type="text/css"/>	
     <link href="js/ligerUI/skins/ligerui-icons.css" rel="stylesheet" type="text/css">
    <script type="text/javascript" src="js/json2.js" charset="utf-8"></script>
    <script src="js/jquery/jquery-1.3.2.min.js"type="text/javascript"></script>
	<script src="js/ligerUI/core/base.js" type="text/javascript"></script>
	<script src="js/ligerUI/ligerui.all.js" type="text/javascript"></script>
	<script src="js/ligerUI/plugins/ligerToolBar.js" type="text/javascript"></script>
<script type="text/javascript">  
	$(f_initGrid);
	var manager, g;
	function f_initGrid() {
		g = manager = $("#maingrid").ligerGrid(
				{
			
				columns : [{
				display : 'ID',
				name : 'id',
				width : 60,
				hide:true,
				type : 'int'
			}, {
				display : '流水号',
				name : 'serial',
				minWidth : 120,
				editor: { type: 'text'}
			} , {
				display : '年份',
				name : 'year',
				minWidth : 120,
				editor: { type: 'text'}
			} , {
				display : '操作类型',
				name : 'fileType',
				minWidth : 120,
				editor: { type: 'text'}
			} , {
				display : '操作对象',
				name : 'fileName',
				minWidth : 120,
				editor: { type: 'text'}
			} , {
				display : '操作者ID',
				name : 'operaterNum',
				minWidth : 120,
				editor: { type: 'text'}
			} , {
				display : '操作者姓名',
				name : 'operaterName',
				minWidth : 120,
				editor: { type: 'text'}
			} , {
				display : '操作者身份',
				name : 'operaterType',
				minWidth : 120
				
			} , {
				display : '操作时间',
				name : 'date',
				minWidth : 120,
				editor: { type: 'text'}
			}],
					onSelectRow : function(rowdata, rowindex) {
						$("#txtrowindex").val(rowindex);
					},
					enabledEdit : true,
					clickToEdit : false,
					isScroll : false,
					checkbox:false,
			        rownumbers:true,
			        pageSize:15,
					url :'${pageContext.request.contextPath}/system/User_printSystemLog.action',
					width : '100%'
				});
	}
	
	function fuzzy () {
		var t = $("#searchText").val();
		$("#maingrid").ligerGrid({
		  url:"${pageContext.request.contextPath}/system/User_fuzzyLog.action?fuzzyText=" + encodeURI(encodeURI(t))
		});
	}

</script>
<style type="text/css">
#head{
 width: 99%;
 height:80px;
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
}
.l-table-edit{
 height:90px;
 align:center;
 width: 100%;
}
.search.l-table-edit td{
  border-bottom: 1px solid #c6c6c6 ;
}
.link{
width:160px;height:25px;background: #fefefe;border: 1px solid #bbb;font-size: 14px;color: #333;border-radius: 3px;
}
.l-button{
 width:70px;float:left; margin:15px 160px 5px ;
 border-radiux:5px;
}
.l-dialog{
  width:300px;
}
</style>
	</head>
	<body style="padding: 2px">		
		<div id="head">
	      <div class="search" >
	         <table cellpadding="0" cellspacing="0" class="l-table-edit" width="100%" >
			<tr>
				<td align="left" class="l-table-edit-td" style="margin-left:20px">
				  <input id="searchText" class="link" style="margin-left:20px; width:300px;" onkeyup="fuzzy()" name="searchText" placeholder="年份 操作者姓名 操作者ID 流水号"/>
				</td>		
			</tr>						
		</table>
	      </div>
	    </div>		
		<div class="l-clear"></div>
		<div id="maingrid" ></div>
	</body>
</html>
