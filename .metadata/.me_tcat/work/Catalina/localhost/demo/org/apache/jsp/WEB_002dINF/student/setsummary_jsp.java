package org.apache.jsp.WEB_002dINF.student;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;

public final class setsummary_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<title></title>\r\n");
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
      out.write("\tvar eee;\r\n");
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
      out.write("                invalidHandler: function (form, validator) {\r\n");
      out.write("                    var errors = validator.numberOfInvalids();\r\n");
      out.write("                    if (errors) {\r\n");
      out.write("                        var message = errors == 1\r\n");
      out.write("                          ? '该字段不能为空！'\r\n");
      out.write("                          : '这 ' + errors + ' 个字段不能为空！';\r\n");
      out.write("                        $(\"#errorLabelContainer\").html(message).show();\r\n");
      out.write("                    }\r\n");
      out.write("                },               \r\n");
      out.write("\t\t\tsubmitHandler : function() {\r\n");
      out.write("\t\t\t\t$(\"form .l-text,.l-textarea\").ligerHideTip();\t\r\n");
      out.write("\t\t\t\tcheck();\r\n");
      out.write("\t\t\t\tif(flg){\r\n");
      out.write("\t\t\t\t    $.post(\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/system/Manage_coursesummarydone.action?classid=\"+ $(\"#classid\").val()\r\n");
      out.write("\t\t        +\"&semester=\"+encodeURI(encodeURI($(\"#semester\").val()))\r\n");
      out.write("\t\t        +\"&coursenum=\"+$(\"#coursenum\").val()\t\t        \r\n");
      out.write("\t\t        +\"&chosenCourse.midexam=\"+parseInt($(\"#midexam\").val())\r\n");
      out.write("\t\t        +\"&chosenCourse.finalexam=\"+parseInt($(\"#finalexam\").val())\r\n");
      out.write("\t\t        +\"&chosenCourse.attendence=\"+$(\"#attendence\").val()\r\n");
      out.write("\t\t        +\"&chosenCourse.homework=\"+$(\"#homework\").val() \r\n");
      out.write("\t\t        ,null,function(){\r\n");
      out.write("\t\t        //alert('生成成功!');\r\n");
      out.write("\t\t        parent.m.hide();\r\n");
      out.write("\t\t        parent.window.location.reload();\r\n");
      out.write("\t            //parent.g.loadData();\r\n");
      out.write("\t\t       });\t\r\n");
      out.write("\t\t\t\t}\t\t\t\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t}\t\t\t\t \t\t\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\t$(\"form\").ligerForm();\r\n");
      out.write("\t\t$(\".l-button-test\").click(function() {\r\n");
      out.write("\t\t\talert(v.element($(\"#txtName\")));\r\n");
      out.write("\t\t});\r\n");
      out.write("\r\n");
      out.write("\t});\t\r\n");
      out.write("  var flg= false;\r\n");
      out.write("  function check(){\r\n");
      out.write("\t  var attendence = $(\"#attendence\").val();\r\n");
      out.write("\t  //var reg = /^0\\.\\d+$/;\r\n");
      out.write("\t  var homework = $(\"#homework\").val();\r\n");
      out.write("\t  var midexam = $(\"#midexam\").val();\r\n");
      out.write("\t  var finalexam = $(\"#finalexam\").val();\r\n");
      out.write("\t if(parseInt(attendence)+parseInt(homework)+parseInt(midexam)+parseInt(finalexam)==100){\r\n");
      out.write("\t    $(\"#result\").hide();\r\n");
      out.write("\t    flg=true;\r\n");
      out.write("\t  }else{\r\n");
      out.write("\t    $(\"#result\").html(\"比例设置不能不等于100\")\r\n");
      out.write("\t    $(\"#result\").show();\r\n");
      out.write("\t    flg=false;\r\n");
      out.write("\t  }\r\n");
      out.write("\t} \r\n");
      out.write("</script>\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write("body{ font-size:12px;}\r\n");
      out.write(".l-table-edit {}\r\n");
      out.write(".l-table-edit-td{ padding:4px;}\r\n");
      out.write(".l-button-submit,.l-button-test{width:80px; float:left; margin-left:10px; padding-bottom:2px;}\r\n");
      out.write(".l-verify-tip{ left:230px; top:120px;}\r\n");
      out.write("#errorLabelContainer{ padding:10px; width:300px; border:1px solid #FF4466; display:none; background:#FFEEEE; color:Red;}\r\n");
      out.write("\r\n");
      out.write("</style>\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body style=\"padding: 10px\">\r\n");
      out.write("\r\n");
      out.write("\t<form name=\"form1\" method=\"post\" action=\"\" id=\"form1\"><div align=\"center\"> \r\n");
      out.write("\t\t</div><h2 align=\"center\">总评计算设置</h2>\r\n");
      out.write("\t\t<input id=\"semester\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${semester }", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\" type=\"hidden\" />\r\n");
      out.write("        <input id=\"coursenum\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${coursenum }", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\" type=\"hidden\"/>\r\n");
      out.write("        <input id=\"classid\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${clsid }", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\" type=\"hidden\"/>\t\r\n");
      out.write("\t\t<table cellpadding=\"0\" cellspacing=\"0\" class=\"l-table-edit\">\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td align=\"right\" class=\"l-table-edit-td\">考勤成绩比例:<font color=\"#ff0000\">*</font></td>\r\n");
      out.write("\t\t\t\t<td align=\"left\" class=\"l-table-edit-td\"><input name=\"attendence\"type=\"text\" id=\"attendence\" ltype=\"text\" value=\"10\" onchange=\"check()\" /></td>\r\n");
      out.write("\t\t\t\t<td align=\"left\">%</td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td align=\"right\" class=\"l-table-edit-td\">平时成绩比例:<font color=\"#ff0000\">*</font></td>\r\n");
      out.write("\t\t\t\t<td align=\"left\" class=\"l-table-edit-td\"><input name=\"homework\"type=\"text\" id=\"homework\"  value=\"20\" onchange=\"check()\" /></td>\r\n");
      out.write("\t\t\t\t<td align=\"left\">%</td>\r\n");
      out.write("\t\t\t</tr>\t\t\t\t\t\t\t\t\t\t\t\t \t\t\t\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td align=\"right\" class=\"l-table-edit-td\">期中成绩比例:<font color=\"#ff0000\">*</font></td>\r\n");
      out.write("\t\t\t\t<td align=\"left\" class=\"l-table-edit-td\"><input name=\"midexam\"type=\"text\" id=\"midexam\" ltype=\"text\" value=\"30\" onchange=\"check()\"  /></td>\r\n");
      out.write("\t\t\t\t<td align=\"left\">%</td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td align=\"right\" class=\"l-table-edit-td\">期末成绩比例:<font color=\"#ff0000\">*</font></td>\r\n");
      out.write("\t\t\t\t<td align=\"left\" class=\"l-table-edit-td\"><input name=\"finalexam\"type=\"text\" id=\"finalexam\" ltype=\"text\" value=\"40\" onchange=\"check()\"  /></td>\r\n");
      out.write("\t\t\t\t<td align=\"left\">%</td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td align=\"center\" colspan=\"3\" ><div id=\"result\" style=\"color: red;\" ></div></td>\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td align=\"right\" class=\"l-table-edit-td\"></td>\r\n");
      out.write("\t\t\t\t<td align=\"left\" class=\"l-table-edit-td\"><br />\r\n");
      out.write("\t\t\t\t <input type=\"submit\" value=\"设&nbsp;&nbsp;置\" id=\"Button1\" class=\"l-button l-button-submit\" />\r\n");
      out.write("\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t<td align=\"left\">\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t</table>\r\n");
      out.write("\t\t<br />\r\n");
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
