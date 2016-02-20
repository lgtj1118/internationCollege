package org.apache.jsp.WEB_002dINF.manage;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;

public final class teacherbatchadd_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");

	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";

      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\r\n");
      out.write("<html xmlns=\"http://www.w3.org/1999/xhtml\">\r\n");
      out.write("<head>\r\n");
      out.write("<title>天津工业大学排课管理系统</title>\r\n");
      out.write("<link href=\"");
      out.print(basePath);
      out.write("js/ligerUI/skins/Gray/css/form.css\" rel=\"stylesheet\"type=\"text/css\" />\r\n");
      out.write("<link href=\"");
      out.print(basePath);
      out.write("js/ligerUI/skins/Gray/css/common.css\" rel=\"stylesheet\"type=\"text/css\" />\r\n");
      out.write("<script src=\"");
      out.print(basePath);
      out.write("js/jquery/jquery-1.6.min.js\" type=\"text/javascript\"></script>\r\n");
      out.write("<script src=\"");
      out.print(basePath);
      out.write("js/ligerUI/core/base.js\" type=\"text/javascript\"></script>\r\n");
      out.write("<script src=\"");
      out.print(basePath);
      out.write("js/ligerUI/plugins/ligerForm.js\" type=\"text/javascript\"></script>\r\n");
      out.write("<script src=\"");
      out.print(basePath);
      out.write("js/ligerUI/plugins/ligerDateEditor.js\" type=\"text/javascript\"></script>\r\n");
      out.write("<script src=\"");
      out.print(basePath);
      out.write("js/ligerUI/plugins/ligerComboBox.js\" type=\"text/javascript\"></script>\r\n");
      out.write("<script src=\"");
      out.print(basePath);
      out.write("js/ligerUI/plugins/ligerSpinner.js\" type=\"text/javascript\"></script>\r\n");
      out.write("<script src=\"");
      out.print(basePath);
      out.write("js/ligerUI/plugins/ligerTextBox.js\" type=\"text/javascript\"></script>\r\n");
      out.write("\r\n");
      out.write("<script src=\"");
      out.print(basePath);
      out.write("js/ligerUI/plugins/ligerTip.js\" type=\"text/javascript\"></script>\r\n");
      out.write("<script src=\"");
      out.print(basePath);
      out.write("js/jquery-validation/jquery.validate.min.js\"type=\"text/javascript\"></script>\r\n");
      out.write("<script src=\"");
      out.print(basePath);
      out.write("js/jquery-validation/jquery.metadata.js\" type=\"text/javascript\"></script>\r\n");
      out.write("<script src=\"");
      out.print(basePath);
      out.write("js/jquery-validation/messages_cn.js\" type=\"text/javascript\"></script>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\t/* var eee;\r\n");
      out.write("        $(function () {\r\n");
      out.write("            $.metadata.setType(\"attr\", \"validate\");\r\n");
      out.write("            var v = $(\"form\").validate({\r\n");
      out.write("                //调试状态，不会提交数据的\r\n");
      out.write("                debug: true,\r\n");
      out.write("                errorPlacement: function (lable, element) {\r\n");
      out.write("\r\n");
      out.write("                    if (element.hasClass(\"l-textarea\")) {\r\n");
      out.write("                        element.addClass(\"l-textarea-invalid\");\r\n");
      out.write("                    }\r\n");
      out.write("                    else if (element.hasClass(\"l-text-field\")) {\r\n");
      out.write("                        element.parent().addClass(\"l-text-invalid\");\r\n");
      out.write("                    }\r\n");
      out.write("\r\n");
      out.write("                    var nextCell = element.parents(\"td:first\").next(\"td\");\r\n");
      out.write("                    if (nextCell.find(\"div.l-exclamation\").length == 0) {\r\n");
      out.write("                        $('<div class=\"l-exclamation\" title=\"' + lable.html() + '\"></div>').appendTo(nextCell).ligerTip();\r\n");
      out.write("                    }\r\n");
      out.write("                },\r\n");
      out.write("                invalidHandler: function (form, validator) {                    \r\n");
      out.write("                },\r\n");
      out.write("\t\t\tsubmitHandler : function() {\r\n");
      out.write("\t\t\t\t$(\"form .l-text,.l-textarea\").ligerHideTip();\t\r\n");
      out.write("\t\t\t\tif(flg){\t\t\t\r\n");
      out.write("\t\t\t\t$.post(\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/system/Stu_teacheraddbytxt.action\"\r\n");
      out.write("\t\t        ,null,function(){\r\n");
      out.write("\t\t       });\r\n");
      out.write("\t\t\t }\t\r\n");
      out.write("\t\t\t }\t\t\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\t$(\"form\").ligerForm();\r\n");
      out.write("\t\t$(\".l-button-test\").click(function() {\r\n");
      out.write("\t\t\talert(v.element($(\"#txtName\")));\r\n");
      out.write("\t\t});\r\n");
      out.write("\r\n");
      out.write("\t});\t */\r\n");
      out.write("\t$(function(){\r\n");
      out.write("\t\t$(\"input[type=file]\").change(function(){\r\n");
      out.write("\t\t\t$(this).parents(\".uploader\").find(\".filename\").val($(this).val());\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\t$(\"input[type=file]\").each(function(){\r\n");
      out.write("\t\t\tif ($(this).val() == \"\") {\r\n");
      out.write("\t\t\t\t$(this).parents(\".uploader\").find(\".filename\").val(\"请选择文件...\");\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t});\r\n");
      out.write("\t});\r\n");
      out.write("\tvar flg = true;\r\n");
      out.write("\tfunction check() {\t    \t\t\r\n");
      out.write("\t  var filename = document.getElementById(\"txt\").value;\r\n");
      out.write("\t  var mime = filename.toLowerCase().substr(filename.lastIndexOf(\".\"));\r\n");
      out.write("\t  if(mime!=\".xls\"){\r\n");
      out.write("\t    $(\"#result\").html(\"请选择Excel文件 xls 格式 上传！\");\r\n");
      out.write("\t    $(\"#result\").show();\r\n");
      out.write("\t    flg = false;\r\n");
      out.write("\t  }else{\r\n");
      out.write("\t    $(\"#result\").hide();\r\n");
      out.write("\t  }\r\n");
      out.write("\t}\t\r\n");
      out.write("</script>\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write("  body {font-size: 14px;}\r\n");
      out.write("  .l-table-edit-td {padding: 4px;}\r\n");
      out.write("  .s {width: 61px;height: 18px;display: inline-block;background-color: #eeeeee;text-align: center;font-size: 13px;}\r\n");
      out.write("  .l-button-submit,.l-button-test {width: 80px;float: left;margin-left: 150px;padding-bottom: 2px;}\r\n");
      out.write("  .uploader { position:relative; display:inline-block; overflow:hidden; cursor:default; padding:0; margin:10px 0px; -moz-box-shadow:0px 0px 5px #ddd; -webkit-box-shadow:0px 0px 5px #ddd; box-shadow:0px 0px 5px #ddd; -moz-border-radius:5px; -webkit-border-radius:5px; border-radius:5px; }\r\n");
      out.write(".filename { float:left; display:inline-block; outline:0 none; height:32px; width:180px; margin:0; padding:8px 10px; overflow:hidden; cursor:default; border:1px solid; border-right:0; font:9pt/100% Arial, Helvetica, sans-serif; color:#777; text-shadow:1px 1px 0px #fff; text-overflow:ellipsis; white-space:nowrap; -moz-border-radius:5px 0px 0px 5px; -webkit-border-radius:5px 0px 0px 5px; border-radius:5px 0px 0px 5px; background:#f5f5f5; background:-moz-linear-gradient(top, #fafafa 0%, #eee 100%); background:-webkit-gradient(linear, left top, left bottom, color-stop(0%, #fafafa), color-stop(100%, #f5f5f5)); filter:progid:DXImageTransform.Microsoft.gradient(startColorstr='#fafafa', endColorstr='#f5f5f5', GradientType=0);\r\n");
      out.write("border-color:#ccc; -moz-box-shadow:0px 0px 1px #fff inset; -webkit-box-shadow:0px 0px 1px #fff inset; box-shadow:0px 0px 1px #fff inset; -moz-box-sizing:border-box; -webkit-box-sizing:border-box; box-sizing:border-box; }\r\n");
      out.write(".button { float:left; height:32px; display:inline-block; outline:0 none; padding:8px 12px; margin:0; cursor:pointer; border:1px solid; font:bold 9pt/100% Arial, Helvetica, sans-serif; -moz-border-radius:0px 5px 5px 0px; -webkit-border-radius:0px 5px 5px 0px; border-radius:0px 5px 5px 0px; -moz-box-shadow:0px 0px 1px #fff inset; -webkit-box-shadow:0px 0px 1px #fff inset; box-shadow:0px 0px 1px #fff inset; }\r\n");
      out.write(".uploader input[type=file] { position:absolute; top:0; right:0; bottom:0; border:0; padding:0; margin:0; height:30px; cursor:pointer; filter:alpha(opacity=0); -moz-opacity:0; -khtml-opacity: 0; opacity:0; }\r\n");
      out.write(" input[type=button]::-moz-focus-inner {\r\n");
      out.write("padding:0;\r\n");
      out.write("border:0 none;\r\n");
      out.write("-moz-box-sizing:content-box;\r\n");
      out.write("}\r\n");
      out.write("input[type=button]::-webkit-focus-inner {\r\n");
      out.write("padding:0;\r\n");
      out.write("border:0 none;\r\n");
      out.write("-webkit-box-sizing:content-box;\r\n");
      out.write("}\r\n");
      out.write("input[type=text]::-moz-focus-inner {\r\n");
      out.write("padding:0;\r\n");
      out.write("border:0 none;\r\n");
      out.write("-moz-box-sizing:content-box;\r\n");
      out.write("}\r\n");
      out.write("input[type=text]::-webkit-focus-inner {\r\n");
      out.write("padding:0;\r\n");
      out.write("border:0 none;\r\n");
      out.write("-webkit-box-sizing:content-box;\r\n");
      out.write("}\r\n");
      out.write("/* White Color Scheme ------------------------ */\r\n");
      out.write("\r\n");
      out.write(".white .button { color:#555; text-shadow:1px 1px 0px #fff; background:#ddd; background:-moz-linear-gradient(top, #eeeeee 0%, #dddddd 100%); background:-webkit-gradient(linear, left top, left bottom, color-stop(0%, #eeeeee), color-stop(100%, #dddddd)); filter:progid:DXImageTransform.Microsoft.gradient(startColorstr='#eeeeee', endColorstr='#dddddd', GradientType=0);\r\n");
      out.write("border-color:#ccc; }\r\n");
      out.write(".white:hover .button { background:#eee; background:-moz-linear-gradient(top, #dddddd 0%, #eeeeee 100%); background:-webkit-gradient(linear, left top, left bottom, color-stop(0%, #dddddd), color-stop(100%, #eeeeee)); filter:progid:DXImageTransform.Microsoft.gradient(startColorstr='#dddddd', endColorstr='#eeeeee', GradientType=0);\r\n");
      out.write("}\r\n");
      out.write("  \r\n");
      out.write("</style>\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body style=\"padding: 10px\">\r\n");
      out.write("\t<!-- <form name=\"form1\" id=\"form1\" method=\"post\" action=\"Manage_teacheraddbytxt.action\" namespace=\"/system\" enctype=\"multipart/form-data\"> -->\r\n");
      out.write("\t<form name=\"form1\" id=\"form1\" method=\"post\" action=\"Manage_jmpBatchResult.action\" namespace=\"/system\" enctype=\"multipart/form-data\">\r\n");
      out.write("\t\t<table cellpadding=\"0\" cellspacing=\"0\" class=\"l-table-edit\">\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td align=\"left\" class=\"l-table-edit-td\" width=\"90px\">选择Excel文件:</td>\r\n");
      out.write("\t\t\t\t<td align=\"left\" class=\"l-table-edit-td\">\r\n");
      out.write("\t\t\t\t<div class=\"uploader white\">\r\n");
      out.write("\t\t\t\t\t\t<input type=\"text\" class=\"filename\" readonly /> \r\n");
      out.write("\t\t\t\t\t\t<input accept=\"\" type=\"button\" class=\"button\" value=\"上传...\" />\r\n");
      out.write("\t\t\t\t\t    <input type=\"file\"name=\"file\" onblur=\"check()\" size=\"30\" />\r\n");
      out.write("\t\t\t\t\t</div></td>\r\n");
      out.write("\t\t\t\t<td align=\"right\"></td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t  <td align=\"left\" class=\"l-table-edit-td\">文件格式:</td>\r\n");
      out.write("\t\t\t  <td colspan=\"2\">\r\n");
      out.write("\t\t\t  ");
      out.write("\r\n");
      out.write("\t\t\t  请按照编号、姓名、性别、电话号码、邮箱、职称、所属部门的顺序组织文件。<br/>如是外聘教师，编号请写&ldquo;<font color=\"#ff0000\">外聘</font>&rdquo;两字。\r\n");
      out.write("\t\t\t  </td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t<th colspan=\"3\"><div id=\"result\" style=\"color: red;\"></div></th>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<th style=\"text-align:center;\" colspan=\"3\"><br> <input type=\"submit\" value=\"添&nbsp;加\" class=\"l-button l-button-submit\" />\r\n");
      out.write("\t\t\t\t</td></th>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\r\n");
      out.write("\t\t</table>\r\n");
      out.write("\t</form>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
