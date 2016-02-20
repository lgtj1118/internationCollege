package org.apache.jsp.WEB_002dINF.student;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;

public final class classroomadd_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("                },\r\n");
      out.write("\t\t\tsubmitHandler : function() {\r\n");
      out.write("\t\t\t\t$(\"form .l-text,.l-textarea\").ligerHideTip();\r\n");
      out.write("\t\t\t\t//check();\r\n");
      out.write("\t\t\t\tcheck1();\r\n");
      out.write("\t\t\t\tcheck2();\r\n");
      out.write("\t\t\t\tcheck3();\r\n");
      out.write("\t\t\t\tif(flg1&&flg2&&flg3){\r\n");
      out.write("\t\t\t\t$.post(\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/system/Class_roomendadd.action?&room.roomname=\"+encodeURI(encodeURI($(\"#roomname\").val()))\r\n");
      out.write("\t\t\t\t+\"&room.roomplace=\"+encodeURI(encodeURI($(\"#roomplace\").val()))\r\n");
      out.write("\t\t\t\t+\"&room.roomcapacity=\"+encodeURI(encodeURI($(\"#roomcapacity\").val()))\r\n");
      out.write("\t\t\t\t+\"&room.realcapacity=\"+encodeURI(encodeURI($(\"#realcapacity\").val()))\r\n");
      out.write("\t\t\t\t+\"&room.note=\"+encodeURI(encodeURI($(\"#note\").val()))\r\n");
      out.write("\t\t\t\t+\"&room.roomtype=\"+encodeURI(encodeURI($(\"#roomtype\").val())),null,function(){\r\n");
      out.write("\t\t        //alert('添加成功!');\r\n");
      out.write("\t\t        parent.m.hide();\r\n");
      out.write("\t            parent.g.loadData();\r\n");
      out.write("\t\t       });\t\t\t \r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\t$(\"form\").ligerForm();\r\n");
      out.write("\t\t$(\".l-button-test\").click(function() {\r\n");
      out.write("\t\t\talert(v.element($(\"#txtName\")));\r\n");
      out.write("\t\t});\r\n");
      out.write("\r\n");
      out.write("\t});\r\n");
      out.write("\tvar flg = false;\r\n");
      out.write("\tfunction check() {\t    \r\n");
      out.write("\t\tvar str = document.getElementById(\"roomname\").value;\r\n");
      out.write("\t\tif(str.length==0){\r\n");
      out.write("\t\t    $(\"#result\").html(\"编号不能为空！\");\r\n");
      out.write("\t\t\t$(\"#result\").show();\r\n");
      out.write("\t\t\tflg=false;\r\n");
      out.write("\t\t\treturn false;\r\n");
      out.write("\t\t}else{\r\n");
      out.write("\t\tvar reg = /^[\\u4e00-\\u9fa5]+$/gi;\r\n");
      out.write("\t\tif (isNaN(str)) {\r\n");
      out.write("\t\t\t$(\"#result\").html(\"编号只能为数字！\");\r\n");
      out.write("\t\t\t$(\"#result\").show();\r\n");
      out.write("\t\t\tflg = false;\r\n");
      out.write("\t\t\tdocument.form1.num.focus();\r\n");
      out.write("\t\t\treturn false;\r\n");
      out.write("\t\t} else {\r\n");
      out.write("\t\t\t$(\"#result\").hide();\r\n");
      out.write("\t\t}$.post(\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/system/Class_roomcheck.action?room.num=\"\r\n");
      out.write("\t\t\t\t\t\t+ $(\"#num\").val(), null, function(data) {\r\n");
      out.write("\t\t\t\t\tif (data == \"fail\") {\r\n");
      out.write("\t\t\t\t\t\t$(\"#result\").html(\"该教室编号已经存在!\");\r\n");
      out.write("\t\t\t\t\t\t$(\"#result\").show();\r\n");
      out.write("\t\t\t\t\t\tflg = false;\r\n");
      out.write("\t\t\t\t\t\treturn false;\r\n");
      out.write("\t\t\t\t\t} else {\r\n");
      out.write("\t\t\t\t\t\t$(\"#result\").hide();\r\n");
      out.write("\t\t\t\t\t\tflg = true;\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t});\t\r\n");
      out.write("\t\t\t}\t\t\t\r\n");
      out.write("\t}\r\n");
      out.write("\tvar flg1 = false;\t\r\n");
      out.write("\tfunction check1(){\r\n");
      out.write("\t \r\n");
      out.write("\tvar str1 = document.getElementById(\"roomcapacity\").value;\r\n");
      out.write("\t\tvar str2 = document.getElementById(\"realcapacity\").value;\r\n");
      out.write("\t\tif (str1.length == 0 || str2.length == 0) {\r\n");
      out.write("\t\t\t$(\"#result1\").html(\"容量不能为空！\");\r\n");
      out.write("\t\t\t$(\"#result1\").show();\r\n");
      out.write("\t\t\tflg1 = false;\r\n");
      out.write("\t\t\treturn false;\r\n");
      out.write("\t\t} else {\r\n");
      out.write("\t\t\tif (isNaN(str1) || isNaN(str2)) {\r\n");
      out.write("\t\t\t\t$(\"#result1\").html(\"容量只能为数字！\");\r\n");
      out.write("\t\t\t\t$(\"#result1\").show();\r\n");
      out.write("\t\t\t\t//$(\"#realcapacity\").Empty();\r\n");
      out.write("\t\t\t\tflg1 = false;\r\n");
      out.write("\t\t\t\treturn false;\r\n");
      out.write("\t\t\t} else {\r\n");
      out.write("\t\t\t\tif (parseInt(str2) > parseInt(str1)) {\r\n");
      out.write("\t\t\t\t\t$(\"#result1\").html(\"实际容量不能大于原本容量！\");\r\n");
      out.write("\t\t\t\t\t$(\"#result1\").show();\r\n");
      out.write("\t\t\t\t\t$(\"realcapacity\").empty();\r\n");
      out.write("\t\t\t\t\tflg1 = false;\r\n");
      out.write("\t\t\t\t\treturn false;\r\n");
      out.write("\t\t\t\t} else {\r\n");
      out.write("\t\t\t\t\t$(\"#result1\").hide();\r\n");
      out.write("\t\t\t\t\tflg1 = true;\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\r\n");
      out.write("\t\t}\r\n");
      out.write("\r\n");
      out.write("\t}\r\n");
      out.write("\tvar flg2 = false;\r\n");
      out.write("\tfunction check2() {\r\n");
      out.write("\t\tvar str = document.getElementById(\"roomname\").value;\r\n");
      out.write("\t\tif(str.length==0){\r\n");
      out.write("\t\t    $(\"#result2\").html(\"教室名称不能为空！\");\r\n");
      out.write("\t\t\t$(\"#result2\").show();\r\n");
      out.write("\t\t\tflg2=false;\r\n");
      out.write("\t\t\treturn false;\r\n");
      out.write("\t\t}else{\r\n");
      out.write("\t\t$(\"#result2\").hide();\r\n");
      out.write("\t\t$.post(\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/system/Class_roomcheck.action?room.roomname=\"\r\n");
      out.write("\t\t\t\t\t\t+ encodeURI(encodeURI($(\"#roomname\").val())), null, function(data) {\r\n");
      out.write("\t\t\t\t\tif (data == \"fail\") {\r\n");
      out.write("\t\t\t\t\t\t$(\"#result2\").html(\"该教室名称已经存在!\");\r\n");
      out.write("\t\t\t\t\t\t$(\"#result2\").show();\r\n");
      out.write("\t\t\t\t\t\tflg2 = false;\r\n");
      out.write("\t\t\t\t\t\treturn false;\r\n");
      out.write("\t\t\t\t\t} else {\r\n");
      out.write("\t\t\t\t\t\t$(\"#result2\").hide();\r\n");
      out.write("\t\t\t\t\t\tflg2 = true;\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t});\t\r\n");
      out.write("\t\t\t}\t\t\t\r\n");
      out.write("\t}\r\n");
      out.write("\tvar flg3 = false;\r\n");
      out.write("\tfunction check3() {\r\n");
      out.write("\t\tvar roomplace = $(\"#roomplace\").val();\r\n");
      out.write("\t\tif (roomplace.length == 0) {\r\n");
      out.write("\t\t\t$(\"#result3\").html(\"教室位置不能为空！\");\r\n");
      out.write("\t\t\t$(\"#result3\").show();\r\n");
      out.write("\t\t\tflg3 = false;\r\n");
      out.write("\t\t\treturn false;\r\n");
      out.write("\t\t} else {\r\n");
      out.write("\t\t$(\"#result3\").hide();\r\n");
      out.write("\t\t   if(!isNaN(roomplace)){\r\n");
      out.write("\t\t      $(\"#result3\").html(\"教室位置不能全为数字！\");\r\n");
      out.write("\t\t\t  $(\"#result3\").show();\r\n");
      out.write("\t\t\t  flg3 = false;\r\n");
      out.write("\t\t\t  return false;\r\n");
      out.write("\t\t   }else{\r\n");
      out.write("\t\t   $(\"#result3\").hide();\r\n");
      out.write("\t\t\tflg3 = true;\r\n");
      out.write("\t\t   }\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("</script>\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write("body{ font-size:12px;}\r\n");
      out.write(".l-table-edit {}\r\n");
      out.write(".l-table-edit-td{ padding:4px;}\r\n");
      out.write(".l-button-submit,.l-button-test{width:80px; float:left; margin-left:10px; padding-bottom:2px;}\r\n");
      out.write(".l-verify-tip{ left:230px; top:120px;}\r\n");
      out.write("#errorLabelContainer{ padding:10px; width:300px; border:1px solid #FF4466; display:none; background:#FFEEEE; color:Red;}\r\n");
      out.write("</style>\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body style=\"padding: 10px\">\r\n");
      out.write("\r\n");
      out.write("\t<form name=\"form1\" method=\"post\" action=\"\" id=\"form1\">\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<table cellpadding=\"0\" cellspacing=\"0\" class=\"l-table-edit\">\r\n");
      out.write("\t\t\t<!-- <tr>\r\n");
      out.write("\t\t\t\t<td align=\"right\" class=\"l-table-edit-td\">编号:<font color=\"#ff0000\">*</font></td>\r\n");
      out.write("\t\t\t\t<td align=\"left\" class=\"l-table-edit-td\"><input name=\"num\"type=\"text\" onchange=\"check()\" id=\"num\" ltype=\"text\" placeholder=\"请输入编号\"  /></td>\r\n");
      out.write("\t\t\t\t<td align=\"left\"><div id=\"result\" style=\"color: red;\"></div></td>\r\n");
      out.write("\t\t\t</tr> -->\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td align=\"right\" class=\"l-table-edit-td\">教室名:<font color=\"#ff0000\">*</font></td>\r\n");
      out.write("\t\t\t\t<td align=\"left\" class=\"l-table-edit-td\"><input name=\"roomname\"type=\"text\" id=\"roomname\" onchange=\"check2()\"  ltype=\"text\" /></td>\r\n");
      out.write("\t\t\t\t<td align=\"left\"><div id=\"result2\" style=\"color: red;\"></div></td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td align=\"right\" class=\"l-table-edit-td\">教室位置:<font color=\"#ff0000\">*</font></td>\r\n");
      out.write("\t\t\t\t<td align=\"left\" class=\"l-table-edit-td\">\r\n");
      out.write("\t\t\t\t<input name=\"roomplace\"type=\"text\" id=\"roomplace\" ltype=\"text\" onchange=\"check3()\"  /></td>\r\n");
      out.write("\t\t\t\t<td align=\"left\"><div id=\"result3\" style=\"color: red;\"></div></td>\r\n");
      out.write("\t\t\t</tr>\t\t\t \r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td align=\"right\" class=\"l-table-edit-td\">教室类型:<font color=\"#ff0000\">*</font></td>\r\n");
      out.write("\t\t\t\t<td align=\"left\" class=\"l-table-edit-td\">\r\n");
      out.write("\t\t\t\t <select id=\"roomtype\" >\r\n");
      out.write("\t\t\t\t   <option value=\"多媒体教室\">多媒体教室</option>\r\n");
      out.write("\t\t\t\t   <option value=\"计算机室\">计算机室</option>\r\n");
      out.write("\t\t\t\t   <option value=\"语音室\">语音室</option>\r\n");
      out.write("\t\t\t\t   <option value=\"体验馆\">体验馆</option>\r\n");
      out.write("\t\t\t\t </select>\r\n");
      out.write("                </td>\r\n");
      out.write("                <td align=\"left\"></td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td align=\"right\" class=\"l-table-edit-td\">容量:<font color=\"#ff0000\">*</font></td>\r\n");
      out.write("\t\t\t\t<td align=\"left\" class=\"l-table-edit-td\">\r\n");
      out.write("\t\t\t\t<input name=\"stuname\"type=\"text\" id=\"roomcapacity\" ltype=\"text\"  /></td>\r\n");
      out.write("\t\t\t\t<td align=\"left\"></td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td align=\"right\" class=\"l-table-edit-td\">实际容量:<font color=\"#ff0000\">*</font></td>\r\n");
      out.write("\t\t\t\t<td align=\"left\" class=\"l-table-edit-td\">\r\n");
      out.write("\t\t\t\t<input name=\"stuname\"type=\"text\" id=\"realcapacity\" onchange=\"check1()\" ltype=\"text\" /></td>\r\n");
      out.write("\t\t\t\t<td align=\"left\"><div id=\"result1\" style=\"color: red;\"></div></td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td align=\"right\" class=\"l-table-edit-td\">备注:</td>\r\n");
      out.write("\t\t\t\t<td align=\"left\" class=\"l-table-edit-td\">\r\n");
      out.write("\t\t\t\t<input name=\"stuname\"type=\"text\" id=\"note\" ltype=\"text\" /></td>\r\n");
      out.write("\t\t\t\t<td align=\"left\"></td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td align=\"right\" class=\"l-table-edit-td\"></td>\r\n");
      out.write("\t\t\t\t<td align=\"left\" class=\"l-table-edit-td\"><br /> <input type=\"submit\" value=\"添&nbsp;&nbsp;加\" id=\"Button1\"\r\n");
      out.write("\t\t\t\t\tclass=\"l-button l-button-submit\" />\r\n");
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
