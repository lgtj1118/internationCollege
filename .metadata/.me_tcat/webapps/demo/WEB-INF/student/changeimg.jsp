<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title></title>
<link href="<%=basePath%>js/ligerUI/skins/Gray/css/common.css"rel="stylesheet" type="text/css" />
<script src="<%=basePath%>js/jquery/jquery-1.6.min.js"type="text/javascript"></script>
<script src="<%=basePath%>js/ligerUI/core/base.js"type="text/javascript"></script>
<script src="<%=basePath%>js/ligerUI/plugins/ligerForm.js"type="text/javascript"></script>
<script src="<%=basePath%>js/ligerUI/plugins/ligerDateEditor.js"type="text/javascript"></script>
<script src="<%=basePath%>js/ligerUI/plugins/ligerComboBox.js"type="text/javascript"></script>
<script src="<%=basePath%>js/ligerUI/plugins/ligerSpinner.js"type="text/javascript"></script>
<script src="<%=basePath%>js/ligerUI/plugins/ligerTextBox.js"type="text/javascript"></script>
<%-- <script src="<%=basePath%>js/ligerUI/plugins/ligerRadio.js" type="text/javascript"></script> --%>
<script src="<%=basePath%>js/ligerUI/plugins/ligerTip.js"type="text/javascript"></script>
<script src="<%=basePath%>js/jquery-validation/jquery.validate.min.js"type="text/javascript"></script>
<script src="<%=basePath%>js/jquery-validation/jquery.metadata.js"type="text/javascript"></script>
<script src="<%=basePath%>js/jquery-validation/messages_cn.js"type="text/javascript"></script>
<script type="text/javascript">
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
</script>
<style type="text/css">
body{font-size: 14px;}

.uploader { position:relative; display:inline-block; overflow:hidden; cursor:default; padding:0; margin:10px 0px; -moz-box-shadow:0px 0px 5px #ddd; -webkit-box-shadow:0px 0px 5px #ddd; box-shadow:0px 0px 5px #ddd; -moz-border-radius:5px; -webkit-border-radius:5px; border-radius:5px; }
.filename { float:left; display:inline-block; outline:0 none; height:32px; width:180px; margin:0; padding:8px 10px; overflow:hidden; cursor:default; border:1px solid; border-right:0; font:9pt/100% Arial, Helvetica, sans-serif; color:#777; text-shadow:1px 1px 0px #fff; text-overflow:ellipsis; white-space:nowrap; -moz-border-radius:5px 0px 0px 5px; -webkit-border-radius:5px 0px 0px 5px; border-radius:5px 0px 0px 5px; background:#f5f5f5; background:-moz-linear-gradient(top, #fafafa 0%, #eee 100%); background:-webkit-gradient(linear, left top, left bottom, color-stop(0%, #fafafa), color-stop(100%, #f5f5f5)); filter:progid:DXImageTransform.Microsoft.gradient(startColorstr='#fafafa', endColorstr='#f5f5f5', GradientType=0);
border-color:#ccc; -moz-box-shadow:0px 0px 1px #fff inset; -webkit-box-shadow:0px 0px 1px #fff inset; box-shadow:0px 0px 1px #fff inset; -moz-box-sizing:border-box; -webkit-box-sizing:border-box; box-sizing:border-box; }
.button { float:left; height:32px; display:inline-block; outline:0 none; padding:8px 12px; margin:0; cursor:pointer; border:1px solid; font:bold 9pt/100% Arial, Helvetica, sans-serif; -moz-border-radius:0px 5px 5px 0px; -webkit-border-radius:0px 5px 5px 0px; border-radius:0px 5px 5px 0px; -moz-box-shadow:0px 0px 1px #fff inset; -webkit-box-shadow:0px 0px 1px #fff inset; box-shadow:0px 0px 1px #fff inset; }
.uploader input[type=file] { position:absolute; top:0; right:0; bottom:0; border:0; padding:0; margin:0; height:30px; cursor:pointer; filter:alpha(opacity=0); -moz-opacity:0; -khtml-opacity: 0; opacity:0; }
 input[type=button]::-moz-focus-inner {
padding:0;
border:0 none;
-moz-box-sizing:content-box;
}
input[type=button]::-webkit-focus-inner {
padding:0;
border:0 none;
-webkit-box-sizing:content-box;
}
input[type=text]::-moz-focus-inner {
padding:0;
border:0 none;
-moz-box-sizing:content-box;
}
input[type=text]::-webkit-focus-inner {
padding:0;
border:0 none;
-webkit-box-sizing:content-box;
}
/* White Color Scheme ------------------------ */

.white .button { color:#555; text-shadow:1px 1px 0px #fff; background:#ddd; background:-moz-linear-gradient(top, #eeeeee 0%, #dddddd 100%); background:-webkit-gradient(linear, left top, left bottom, color-stop(0%, #eeeeee), color-stop(100%, #dddddd)); filter:progid:DXImageTransform.Microsoft.gradient(startColorstr='#eeeeee', endColorstr='#dddddd', GradientType=0);
border-color:#ccc; }
.white:hover .button { background:#eee; background:-moz-linear-gradient(top, #dddddd 0%, #eeeeee 100%); background:-webkit-gradient(linear, left top, left bottom, color-stop(0%, #dddddd), color-stop(100%, #eeeeee)); filter:progid:DXImageTransform.Microsoft.gradient(startColorstr='#dddddd', endColorstr='#eeeeee', GradientType=0);
}

</style>
  </head>
  
  <body>
    <p style="margin:10px 10px;">上传自己的真实照片(小于3M，照片名称请用学号)</p>
			<s:form action="Stu_changeimg" acceptcharset="UTF-8"  enctype="multipart/form-data" method="post" namespace="/system" id="form1">
		<table align="center">
			<tr>
				<td><div class="uploader white">
						<input type="text" class="filename" readonly /> 
						<input accept="" type="button" class="button" value="上传..." />
					    <input type="file"name="image" size="30" />
					</div></td>
			</tr>
			<tr><td align="center" ><br><input type="submit" class="l-submit" value="提&nbsp;&nbsp;交" /></td></tr>
		</table>					
			</s:form>
			
  </body>
</html>
