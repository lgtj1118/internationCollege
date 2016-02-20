<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>教学评价列表</title>
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
	var EvalutionData = {Rows: [
		<%String  s= (String) request.getAttribute("evalutionlist");%>
		<%=s%>
		 ]};
    var TestData =[{test:1,text:'优秀'},{test:2,text:'良好'},{test:3,text:'及格'},{test:4,text:'不及格'}]	;	
	$(f_initGrid);
	var manager, g;
	function f_initGrid() {
		g = manager = $("#maingrid").ligerGrid(
				{
				columns : [{
				display : '教师编号',
				name : 'teacher',
				minWidth : 60,
				editor: { type: 'text'}
			}, {
				display : '教师姓名',
				name : 'teachername',
				minWidth : 60,
				editor: { type: 'text'}
			},{display : '评价标准',columns:[
			   { display : '教学态度', name : 'incicators1', minWidth : 80,
			        render: function (item){
                        if (parseInt(item.incicators1) < 60){ var h="<font color='red' >"+item.incicators1+"</font>" ;return h;}
                        else{ var h=item.incicators1 ;return h;}
                    }	
               }, 
			   { display : '因材施教', name : 'incicators2', minWidth : 80,
			        render: function (item){
                        if (parseInt(item.incicators2) < 60){ var h="<font color='red' >"+item.incicators2+"</font>" ;return h;}
                        else{ var h=item.incicators2 ;return h;}
                    }	
               },  
			   { display : '教学内容', name : 'incicators3', minWidth : 80,
			        render: function (item){
                        if (parseInt(item.incicators3) < 60){ var h="<font color='red' >"+item.incicators3+"</font>" ;return h;}
                        else{ var h=item.incicators3 ;return h;}
                    }	
               },  
			   { display : '语言板书', name : 'incicators4', minWidth : 80,
			        render: function (item){
                        if (parseInt(item.incicators4) < 60){ var h="<font color='red' >"+item.incicators4+"</font>" ;return h;}
                        else{ var h=item.incicators4 ;return h;}
                    }
			   }, 
			   { display : '教学方法', name : 'incicators5', minWidth : 80,
			        render: function (item){
                        if (parseInt(item.incicators5) < 60){ var h="<font color='red' >"+item.incicators5+"</font>" ;return h;}
                        else{ var h=item.incicators5 ;return h;}
                    }
			   }, 
			   { display : '教学效果', name : 'incicators6', minWidth : 80,
			        render: function (item){
                        if (parseInt(item.incicators6) < 60){ var h="<font color='red' >"+item.incicators6+"</font>" ;return h;}
                        else{ var h=item.incicators6 ;return h;}
                    }
			   }, 
			   { display : '总体印象', name : 'incicators7', minWidth : 80,
			        render: function (item){
                        if (parseInt(item.incicators7) < 60){ var h="<font color='red' >"+item.incicators7+"</font>" ;return h;}
                        else{ var h=item.incicators7 ;return h;}
                    }
			   }, 
			   { display : '合计', name : 'summary', minWidth : 80,
			        render: function (item){
                        if (parseInt(item.summary) < 60){ var h="<font color='red' >"+item.summary+"</font>" ;return h;}
                        else{ var h=item.summary ;return h;}
                    }
			    }]
			 }],
					onSelectRow : function(rowdata, rowindex) {
						$("#txtrowindex").val(rowindex);
					},
					enabledEdit : true,
					clickToEdit : false,
					isScroll : false,
			        rownumbers:true,
			        pageSize:20,
					//data : EvalutionData,
					url:'${pageContext.request.contextPath}/system/Manage_allClassteacherEvalutionResult.action',
					width : '100%'
				});
	}
    function fenxi(){
      var str = "${pageContext.request.contextPath}/system/Manage_evalutionanalysis.action?course.num="+$("#courseid").val();
      m=$.ligerDialog.open({
			url : str,
			height : 450,
			width : 430,
			title:'评价分析',
			isDrag:true,
			isResize : true
		});
    }
</script>
	</head>
	<body style="padding: 2px">
	    <input id="courseid" value="${courseid }" type="hidden" />		
		<div class="l-clear"></div>
		<div id="maingrid" ></div>
	</body>
</html>
