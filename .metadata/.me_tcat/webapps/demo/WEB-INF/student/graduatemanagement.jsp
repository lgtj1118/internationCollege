<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
    <script type="text/javascript" src="<%=basePath %>js/jquery-validation/jquery.validate.min.js" charset="utf-8"></script>
    <script type="text/javascript" src="<%=basePath %>js/json2.js" charset="utf-8"></script>
    <script type="text/javascript" src="<%=basePath %>js/jquery-validation/jquery.metadata.js" charset="utf-8"></script>
    <script type="text/javascript" src="<%=basePath %>js/jquery-validation/messages_cn.js" charset="utf-8"></script>
    <script type="text/javascript" src="<%=basePath %>js/ligerUI/plugins/ligerTab.js"></script>
    <script type="text/javascript" src="<%=basePath %>js/jquery/jquery-1.3.2.min.js"></script>
	<script src="<%=basePath %>js/ligerUI/core/base.js" type="text/javascript"></script>
	<script src="<%=basePath %>js/ligerUI/ligerui.all.js" type="text/javascript"></script>	
	<script type="text/javascript">
	var ClassData = {Rows: [
		<%String  s= (String) request.getAttribute("classlist");%>
		<%=s%>
		 ]};		
	$(f_initGrid);
	var manager, g;
	function f_initGrid() {
		g = manager = $("#maingrid").ligerGrid(
				{
				columns : [{
				display : 'ID',
				name : 'id',
				minWidth : 60,
				hide:true,
				type : 'int'
			}, {
				display : '班级名称',
				name : 'classname',
				minWidth : 150,
				editor: { type: 'text'}
			}, {
				display : '班级专业',
				name : 'major',
				minWidth : 150,
				editor: { type: 'text'}
			}/* , {
				display : '班主任',
				name : 'ClassTeacher',
				width : 150,
				editor: { type: 'text'}
			}, {
				display : '助理班主任',
				name : 'Assistantteacher',
				width : 150,
				editor: { type: 'text'}
			} , {
				display : '班长',
				name : 'Classmajor',
				minWidth : 150,
				editor: { type: 'text'}
			}*/, {
				display : '状态',
				name : 'type',
				minWidth : 150,
				editor: { type: 'text'},
				render: function (item)
                    {
                        if (parseInt(item.type) == 0){ var h="<span style='color:green;'>正常</span>" ;return h;}
                        else if (parseInt(item.type) == 1) { var h="<span style='color:red;'>已删除</span>" ;return h;}
                        else if (parseInt(item.type) == 2) { var h="<span style='color:orange;'>已毕业</span>" ;return h;}
                        
                    }	
			},{
					display : '班内学生',
					isSort : false,
					minWidth : 120,
					render : function() {
						var h = "";
						h += "<a style='color:#000;' href='javascript:classstu("+ ")'>管理</a> ";
						return h;
					}
			} ],
					onSelectRow : function(rowdata, rowindex) {
						$("#txtrowindex").val(rowindex);
					},
					enabledEdit : true,
					clickToEdit : false,
					isScroll : false,
			         rownumbers:true,
			         pageSize:20,
					//data : ClassData,
					url: '${pageContext.request.contextPath}/system/Class_classList.action',
					width : '100%'
				});
	}
    function classstu(){
     var row = manager.getSelectedRow();
	 	if (!row) {alert('请选择班级！');return;}
	 	if(row.type==1){
	 	  alert("该班级已删除，不能审核！");
	 	}else{
          var str = "${pageContext.request.contextPath}/system/Class_graduatestulist.action?cls.id="+row.id;
		 top.f_addTab('graduatestu','学生列表',str);
		 }
}
	
</script>
	</head>
	<body style="padding: 2px">
		<br />
		<div class="l-clear"></div>
		<div id="maingrid" ></div>
	</body>
</html>
