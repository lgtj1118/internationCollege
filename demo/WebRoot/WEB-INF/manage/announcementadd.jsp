<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title></title>
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
	<script charset="utf-8" src="<%=basePath %>js/kediter/themes/default/default.css"  type="text/javascript"></script>
    <script charset="utf-8" src="<%=basePath %>js/kediter/lang/zh_CN.js" type="text/javascript"></script>
	<script charset="utf-8" src="<%=basePath %>js/kediter/kindeditor-min.js" type="text/javascript"></script>
	<script>
		var editor;
		KindEditor.ready(function(K) {
				editor = K.create('textarea[id="content"]', {
					allowFileManager : false,
					newlineTag : 'br',
			        cssPath : '<%=basePath %>js/plugins/code/prettify.css',
				    uploadJson : '<%=basePath %>/upload/upload_json.jsp',
				    fileManagerJson : '<%=basePath %>/upload/file_manager_json.jsp',				    			
				    allowFileManager : true,
                    afterCreate : function() {
                      var self = this;
                      K.ctrl(document, 13, function() {
                        self.sync();
                        document.forms['form1'].submit();
                      });
                      K.ctrl(self.edit.doc, 13, function() {
                        self.sync();
                        document.forms['form1'].submit();
                      });
                   }				    			
				});				
			}); 	
 function check() {
	var title = $("#title").val();
	if (title.length == 0) {
		$("#result").html("标题不能为空！").show();
		return false;
	} else {
		editor.sync();
	    $("#form1").submit();
		alert("添加成功！");
		parent.m.hide();
		//parent.g.loadData();
		windows.location.reload();
	}
}
</script>


<style type="text/css">
body {
	font-size: 12px;
}
.l-table-edit {
	font-size: 12px;
}
.l-table-edit-td {
	padding: 4px;
}
.l-button-submit {
	width: 150px;
	height: 30px;
	padding-bottom: 2px;
}

</style>

</head>

<body style="padding:10px; margin-bottom: 10px;">

	<form name="form1" method="post" namespace="/system" action="Manage_announcementendadd.action"  id="form1">
		<div></div>
		<table cellpadding="0" cellspacing="0" class="l-table-edit">
			<tr>
				<td align="left" class="l-table-edit-td">标题:</td>
				<td align="left" class="l-table-edit-td">
				<input name="announcement.title" value="" type="text"
					id="title" ltype="text" style="width:200px;height: 20px;" onchange="checktitle()" /></td>
				<td align="left"><font size="2" color="#ff0000">(*标题不能为空!)</font></td>
			</tr>						
			<tr><td align="left" class="l-table-edit-td">内容:</td></tr>
		</table>
		<div style="width:100%">
			<div>
				<textarea id="content" name="announcement.content" rows="15" cols="80"style="width: 100%; height:300px;"></textarea>
			</div>
		</div>		
		<br />		
		<div style="width:150px; margin:0px auto;">
			<input type="button" value="提交" id="Button1" onclick="check()" class="l-button l-button-submit" />
			<!-- <input type="button" value="提交" id="Button1" onclick="add()" class="l-button l-button-submit" /> -->
		</div>
	</form>


</body>
</html>