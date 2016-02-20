<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
<link href="<%=basePath%>js/ligerUI/skins/Aqua/css/ligerui-all.css" rel="stylesheet"type="text/css" />
<link href="<%=basePath%>js/ligerUI/skins/Gray/css/all.css" rel="stylesheet"type="text/css" />
 <script src="<%=basePath%>js/jquery/jquery-1.6.min.js" type="text/javascript"></script>
<script src="<%=basePath%>js/ligerUI/core/base.js" type="text/javascript"></script>
<script src="<%=basePath%>js/ligerUI/plugins/ligerTab.js" type="text/javascript"></script>
<script src="<%=basePath%>js/ligerUI/pluginsligerForm.js" type="text/javascript"></script>
<script src="<%=basePath%>js/ligerUI/pluginsligerComboBox.js" type="text/javascript"></script>
<script src="<%=basePath%>js/ligerUI/pluginsligerSpinner.js" type="text/javascript"></script>
<script src="<%=basePath%>js/ligerUI/pluginsligerTextBox.js" type="text/javascript"></script>
<script src="<%=basePath%>js/ligerUI/pluginsligerTip.js" type="text/javascript"></script>
<script type="text/javascript">	
  $(function (){ $("#navtab1").ligerTab();});
</script>
<style type="text/css">
.l-verify-tip {
	left: 230px;
	top: 120px;
}
body {
	font-size: 14px;
	width: 99.9%;
	height:99.9%;
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
	width: 60px;
	float: left;
	margin-left: 10px;
	padding-bottom: 2px;
}
.l-verify-tip {
	left: 230px;
	top: 120px;
}
</style>
</head>
<body >    
	<div id="navtab1"style="width: 100%;   ">
		<div tabid="home"  title="考勤记录" lselected="true" style="height:620px"  >
			<iframe frameborder="0" name="ifream1" id="ifream1"
				src="${pageContext.request.contextPath}/system/Manage_courseattendenceload.action?course.num=${courseid}"></iframe>
		</div>
			<div title="考勤统计" style="height:620px;">			
				<iframe frameborder="1" name="ifream2"  id="ifream2" src="${pageContext.request.contextPath}/system/Manage_courseattendenceclass.action?course.num=${courseid}"></iframe>			
		    </div>		 		  
	</div>			
</body>
</html>
