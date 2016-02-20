package org.apache.jsp.WEB_002dINF.course;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;

public final class courseedit_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fs_005fif_005ftest;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fs_005felseif_005ftest;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fs_005fif_005ftest = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fs_005felseif_005ftest = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fs_005fif_005ftest.release();
    _005fjspx_005ftagPool_005fs_005felseif_005ftest.release();
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
      response.setContentType("text/html; charset=utf-8");
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
      out.write("                invalidHandler: function (form, validator) {\r\n");
      out.write("                    var errors = validator.numberOfInvalids();\r\n");
      out.write("                    if (errors) {\r\n");
      out.write("                        var message = errors == 1\r\n");
      out.write("                          ? '该字段不能为空！'\r\n");
      out.write("                          : '这 ' + errors + ' 个字段不能为空！';\r\n");
      out.write("                        $(\"#errorLabelContainer\").html(message).show();\r\n");
      out.write("                    }\r\n");
      out.write("                },\r\n");
      out.write("                submitHandler : function() {\r\n");
      out.write("\t\t\t\t$(\"form .l-text,.l-textarea\").ligerHideTip();\r\n");
      out.write("\t\t\t\tif(flg){\r\n");
      out.write("\t\t\t\t$.post(\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/system/Class_courseupdate.action?course.coursename=\"\r\n");
      out.write("\t\t\t\t+  encodeURI(encodeURI($(\"#coursename\").val()))\r\n");
      out.write("\t\t        +\"&course.teacher=\"+  encodeURI(encodeURI($(\"#teacher\").val()))\r\n");
      out.write("\t\t        +\"&course.character=\"+  encodeURI(encodeURI($(\"#character\").val()))\r\n");
      out.write("\t\t        +\"&course.id=\"+  encodeURI(encodeURI($(\"#id\").val()))\r\n");
      out.write("\t\t        //+\"&course.checkway=\"+  encodeURI(encodeURI($(\"#checkway\").val()))\r\n");
      out.write("\t\t        +\"&course.beginweeks=\"+ $(\"#beginweeks\").val()\r\n");
      out.write("\t\t        +\"&course.endweeks=\"+ $(\"#endweeks\").val()\r\n");
      out.write("\t\t        +\"&course.credits=\"+ $(\"#credit\").val()\r\n");
      out.write("\t\t        +\"&course.academic=\"+ encodeURI(encodeURI($(\"#academic option:selected\").val()))\r\n");
      out.write("\t\t        +\"&course.num=\"+  encodeURI(encodeURI($(\"#num\").val())),null,function(){\r\n");
      out.write("\t\t        alert('更新成功！');\r\n");
      out.write("                 parent.m.hide();\r\n");
      out.write("\t             parent.g.loadData();\r\n");
      out.write("\t\t        });\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\t$(\"form\").ligerForm();\r\n");
      out.write("\t\t$(\".l-button-test\").click(function() {\r\n");
      out.write("\t\t\talert(v.element($(\"#txtName\")));\r\n");
      out.write("\t\t});\r\n");
      out.write("\r\n");
      out.write("\t});\r\n");
      out.write("\tvar flg = true;\r\n");
      out.write("\tfunction check() {\r\n");
      out.write("\t   var str = document.getElementById(\"coursename\").value;\r\n");
      out.write("\t   if(str.length==0){\r\n");
      out.write("\t     $(\"#result\").html(\"课程名不能为空！\");\r\n");
      out.write("\t     $(\"#result\").show();\r\n");
      out.write("\t   }else{\r\n");
      out.write("\t   $.post(\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/system/Class_coursecheck.action?course.coursename=\"\r\n");
      out.write("\t\t\t\t\t\t+ $(\"#coursename\").val(), null, function(data) {\r\n");
      out.write("\t\t\t\t\tif (data == \"fail\") {\r\n");
      out.write("\t\t\t\t\t\t$(\"#result\").html(\"该课程名已经存在!\");\r\n");
      out.write("\t\t\t\t\t\t$(\"#result\").show();\r\n");
      out.write("\t\t\t\t\t\tflg = false;\r\n");
      out.write("\t\t\t\t\t} else {\r\n");
      out.write("\t\t\t\t\t\t$(\"#result\").hide();\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t});\r\n");
      out.write("\t   }\t\t\r\n");
      out.write("\t}\r\n");
      out.write("\tfunction check1() {\r\n");
      out.write("\t\tvar str = document.getElementById(\"num\").value;\r\n");
      out.write("\t\tvar reg = /^[\\u4e00-\\u9fa5]+$/gi;\r\n");
      out.write("\t\tif(str.length==0){\r\n");
      out.write("\t\t    $(\"#result1\").html(\"课程编号不能为空！\");\r\n");
      out.write("\t\t\t$(\"#result1\").show();\r\n");
      out.write("\t\t}else{\r\n");
      out.write("\t\tif (reg.test(str)) {\r\n");
      out.write("\t\t\t$(\"#result1\").html(\"课程编号不能包含中文！\");\r\n");
      out.write("\t\t\t$(\"#result1\").show();\r\n");
      out.write("\t\t\tflg = false;\r\n");
      out.write("\t\t\treturn false;\r\n");
      out.write("\t\t} else {\r\n");
      out.write("\t\t\t$(\"#result1\").hide();\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t$.post(\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/system/Class_coursecheck1.action?course.num=\"\r\n");
      out.write("\t\t\t\t\t\t+ $(\"#num\").val(), null, function(data) {\r\n");
      out.write("\t\t\t\t\tif (data == \"fail\") {\r\n");
      out.write("\t\t\t\t\t\t$(\"#result\").html(\"该课程编号已经存在!\");\r\n");
      out.write("\t\t\t\t\t\t$(\"#result1\").show();\r\n");
      out.write("\t\t\t\t\t\tflg = false;\r\n");
      out.write("\t\t\t\t\t} else {\r\n");
      out.write("\t\t\t\t\t\t$(\"#result1\").hide();\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t});\r\n");
      out.write("\t\t}\t\t\r\n");
      out.write("\t}\r\n");
      out.write("\tfunction check2(){\r\n");
      out.write("\t  var str1 = document.getElementById(\"beginweeks\").value;\r\n");
      out.write("\t  var str2 = document.getElementById(\"endweeks\").value;\r\n");
      out.write("\t  if(parseInt(str1)>parseInt(str2)){\r\n");
      out.write("\t    $(\"#result2\").html(\"起始周不能大于结束周！\");\r\n");
      out.write("\t    $(\"#result2\").show();\r\n");
      out.write("\t  }else{\r\n");
      out.write("\t    $(\"#result2\").hide();\r\n");
      out.write("\t  }\r\n");
      out.write("\t} */\r\n");
      out.write("\tfunction clear(){\r\n");
      out.write("\t\t\t$(\"#msg\").text(\" \");\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tfunction err (msg){\r\n");
      out.write("\t\t\t$(\"#msg\").text(msg);\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tfunction submit(){\r\n");
      out.write("\t\t\t\r\n");
      out.write(" \t\t\tvar beginweek = $(\"#beginweeks\");\r\n");
      out.write(" \t\t\tvar endweek = $(\"#endweeks\");\r\n");
      out.write(" \t\t\tvar teacher = $(\"#teacher\");\r\n");
      out.write(" \t\t\tclear();\r\n");
      out.write("\r\n");
      out.write("\t\t\t//alert(\"here2\");\r\n");
      out.write("\t\t\tif (!validate_required(beginweek,\"起始周不能为空\")){\r\n");
      out.write("\t\t\t\treturn false;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\tvar reg2 = /^[0-9]+$/;\r\n");
      out.write("\t\t\tif (!reg2.test(beginweek.val())) {\r\n");
      out.write("\t\t\t\terr(\"起始周只能是数字\");\r\n");
      out.write("\t\t\t\treturn;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\tif (!validate_required(endweek,\"结束周不能为空\")){\r\n");
      out.write("\t\t\t\treturn false;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\tvar reg3 = /^[0-9]{1,2}$/;\r\n");
      out.write("\t\t\tif (!reg3.test(endweek.val())){\r\n");
      out.write("\t\t\t\terr(\"结束周只能是数字\");\r\n");
      out.write("\t\t\t\treturn;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\tif (parseInt(endweek.val()) > 21){\r\n");
      out.write("\t\t\t\terr(\"结束周不能晚于21周\");\r\n");
      out.write("\t\t\t\treturn;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\tvar start = parseInt(beginweek.val());\r\n");
      out.write("\t\t\tvar end = parseInt(endweek.val());\r\n");
      out.write("\t\t\tif (start > end){\r\n");
      out.write("\t\t\t\terr(\"结束周不能早于起始周\");\r\n");
      out.write("\t\t\t\treturn;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t\tvar teacher = $(\"#teacher\").val();\r\n");
      out.write("\r\n");
      out.write("\t\t\tif(teacher != \"\"){\r\n");
      out.write("\t\t\t\tvar regg = /^[a-zA-Z\\u4e00-\\u9fa5]{2,}$/;\r\n");
      out.write("\t\t\t\tif (!regg.test(teacher)){\r\n");
      out.write("\t\t\t\t\terr(\"教师姓名只能由2个以上的中英文组成\");\r\n");
      out.write("\t\t\t\t\treturn;\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t} \r\n");
      out.write("\t\t\t var url = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/system/Class_courseupdate.action?course.coursename=\"\r\n");
      out.write("\t\t\t\t+  encodeURI(encodeURI($(\"#coursename\").val()))\r\n");
      out.write("\t\t        +\"&course.teacher=\"+  encodeURI(encodeURI($(\"#teacher\").val()))\r\n");
      out.write("\t\t        +\"&course.character=\"+  encodeURI(encodeURI($(\"#character\").val()))\r\n");
      out.write("\t\t        +\"&course.id=\"+  encodeURI(encodeURI($(\"#id\").val()))\r\n");
      out.write("\t\t        +\"&course.beginweeks=\"+ $(\"#beginweeks\").val()\r\n");
      out.write("\t\t        +\"&course.endweeks=\"+ $(\"#endweeks\").val()\r\n");
      out.write("\t\t        +\"&course.credits=\"+ $(\"#credit\").val()\r\n");
      out.write("\t\t        +\"&course.weeklesson=\"+ $(\"#weeklesson\").val()\r\n");
      out.write("\t\t        +\"&course.academic=\"+ encodeURI(encodeURI($(\"#academic option:selected\").val()))\r\n");
      out.write("\t\t        +\"&course.num=\"+  encodeURI(encodeURI($(\"#num\").val()));\r\n");
      out.write("    \t\t\r\n");
      out.write("    \t\t$.post(url,null,function(){\r\n");
      out.write("    \t\t\r\n");
      out.write("\t\t       \t parent.window.location.reload();\r\n");
      out.write("    \t\t\r\n");
      out.write("    \t\t\twindow.close(); \r\n");
      out.write("\t             \r\n");
      out.write("\t\t     });\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tfunction validate_required(ids,alerttxt)\r\n");
      out.write("\t\t{\r\n");
      out.write("\t\t\tif (ids.val() == null || ids.val() == \"\"){\r\n");
      out.write("\t\t\t\t$(\"#msg\").text(alerttxt);\r\n");
      out.write("\t\t\t\tids.focus();\r\n");
      out.write("\t\t\t\treturn false;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\treturn true;\r\n");
      out.write("\t\t}\r\n");
      out.write("</script>\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write("body{ font-size:12px;}\r\n");
      out.write(".l-table-edit {}\r\n");
      out.write(".l-table-edit-td{ padding:4px;}\r\n");
      out.write(".l-button-submit,.l-button-test{width:80px; float:left; margin-left:10px; padding-bottom:2px;}\r\n");
      out.write(".l-verify-tip{ left:230px; top:120px;}\r\n");
      out.write("#errorLabelContainer{ padding:10px; width:300px; border:1px solid #FF4466; display:none; background:#FFEEEE; color:Red;}\r\n");
      out.write(".l-text{\r\n");
      out.write("   width: 80px;\r\n");
      out.write("}\r\n");
      out.write(".link {\r\n");
      out.write("\twidth: 170px;\r\n");
      out.write("\theight: 25px;\r\n");
      out.write("\tbackground: #fefefe;\r\n");
      out.write("\tborder: 1px solid #bbb;\r\n");
      out.write("\tfont-size: 12px;\r\n");
      out.write("\tcolor: #333;\r\n");
      out.write("\tborder-radius: 3px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("</style>\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body style=\"padding: 10px\">\r\n");
      out.write("\r\n");
      out.write("\t\t<div id=\"errorLabelContainer\" class=\"l-text-invalid\"></div>\r\n");
      out.write("\t\t<input id=\"id\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${courses.id }", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\" type=\"hidden\" />\r\n");
      out.write("\t\t<table cellpadding=\"0\" cellspacing=\"0\" class=\"l-table-edit\">\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td align=\"right\" class=\"l-table-edit-td\">课程编号:</td>\r\n");
      out.write("\t\t\t\t<td align=\"left\" class=\"l-table-edit-td\"><input name=\"num\" disabled type=\"text\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${courses.num }", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\"  id=\"num\" ltype=\"text\"validate=\"{required:true,number:true,minlength:1,maxlength:20}\" /></td>\r\n");
      out.write("\t\t\t\t<td align=\"left\"><div id=\"result1\" style=\"margin-top:-10px;color: red;font-size: 10px;\"></div></td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td align=\"right\" class=\"l-table-edit-td\">课程名称:</td>\r\n");
      out.write("\t\t\t\t<td align=\"left\" class=\"l-table-edit-td\"><input name=\"name\" disabled type=\"text\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${courses.coursename }", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\" id=\"coursename\"  ltype=\"text\" onblur=\"check()\"\r\n");
      out.write("\t\t\t\t\tvalidate=\"{required:true,minlength:1,maxlength:20}\" /></td>\r\n");
      out.write("\t\t\t\t<td align=\"left\"><div id=\"result\" style=\"color: red;font-size: 10px;\"></div></td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr >\r\n");
      out.write("\t\t\t\t<td  align=\"right\" class=\"l-table-edit-td\">开课起始周:</td>\t\t\t\t\r\n");
      out.write("\t\t\t\t<td align=\"left\" class=\"l-table-edit-td\"><input name=\"beginweeks\" width=\"30px\" type=\"text\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${courses.beginweeks }", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\" id=\"beginweeks\" validate=\"{required:true,minlength:1,maxlength:20}\"  /></td>\r\n");
      out.write("\t\t\t\t<td align=\"left\">\t\t\t\t\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr >\r\n");
      out.write("\t\t\t\t<td  align=\"right\" class=\"l-table-edit-td\">开课结束周:</td>\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t<td align=\"left\" class=\"l-table-edit-td\"><input name=\"endweeks\" type=\"text\" id=\"endweeks\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${courses.endweeks }", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\" onblur=\"check2()\" validate=\"{required:true,minlength:1,maxlength:20}\" /></td>\r\n");
      out.write("\t\t\t\t<td align=\"left\">\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td align=\"right\" class=\"l-table-edit-td\">学分:</td>\r\n");
      out.write("\t\t\t\t<td align=\"center\" class=\"l-table-edit-td \">\r\n");
      out.write("\t\t\t\t  <select  id=\"credit\" class=\"link\" disabled=\"disabled\" > \r\n");
      out.write("\t\t\t\t   <option value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${courses.credits}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\"  >");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${courses.credits}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("</option>\r\n");
      out.write("\t\t\t\t    <option value=\"0.5\">0.5</option>\r\n");
      out.write("\t\t\t\t\t<option value=\"1\">1</option>\r\n");
      out.write("\t\t\t\t\t<option value=\"1.5\">1.5</option>\r\n");
      out.write("\t\t\t\t\t<option value=\"2\">2</option>\r\n");
      out.write("\t\t\t\t\t<option value=\"3\">3</option>\r\n");
      out.write("\t\t\t\t\t<option value=\"4\">4</option>\r\n");
      out.write("\t\t\t\t\t<option value=\"5\">5</option>\r\n");
      out.write("\t\t\t\t\t<option value=\"6\">6</option>\r\n");
      out.write("\t\t\t\t\t<option value=\"7\">7</option>\r\n");
      out.write("\t\t\t\t\t<option value=\"8\">8</option>\r\n");
      out.write("\t\t\t\t\t<option value=\"9\">9</option>\r\n");
      out.write("\t\t\t\t    </select>\r\n");
      out.write("\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t<td align=\"left\"></td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("            <tr>\r\n");
      out.write("\t\t\t\t<td align=\"right\" class=\"l-table-edit-td\">周学时:</td>\r\n");
      out.write("\t\t\t\t<td align=\"center\" class=\"l-table-edit-td \">\r\n");
      out.write("\t\t\t\t  <select  id=\"weeklesson\" class=\"link\"> \r\n");
      out.write("\t\t\t\t   <option value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${courses.weeklesson}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write('"');
      out.write('>');
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${courses.weeklesson}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("</option>\r\n");
      out.write("\t\t\t\t    <option value=\"1\">1</option>\r\n");
      out.write("\t\t\t\t\t<option value=\"2\">2</option>\r\n");
      out.write("\t\t\t\t\t<option value=\"3\">3</option>\r\n");
      out.write("\t\t\t\t\t<option value=\"4\">4</option>\r\n");
      out.write("\t\t\t\t\t<option value=\"5\">5</option>\r\n");
      out.write("\t\t\t\t\t<option value=\"6\">6</option>\r\n");
      out.write("\t\t\t\t\t<option value=\"7\">7</option>\r\n");
      out.write("\t\t\t\t\t<option value=\"8\">8</option>\r\n");
      out.write("\t\t\t\t\t<option value=\"9\">9</option>\r\n");
      out.write("\t\t\t\t\t<option value=\"10\">10</option>\r\n");
      out.write("\t\t\t\t    </select>\r\n");
      out.write("\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t<td align=\"left\"></td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td align=\"right\" class=\"l-table-edit-td\">课程性质:</td>\r\n");
      out.write("\t\t\t\t<td align=\"left\"  class=\"l-table-edit-td\">\r\n");
      out.write("\t\t\t\t<select type=\"select\" id=\"character\" class=\"link\">\r\n");
      out.write("\t\t\t\t  ");
      if (_jspx_meth_s_005fif_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t\t\t  ");
      if (_jspx_meth_s_005felseif_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t\t\t  ");
      if (_jspx_meth_s_005felseif_005f1(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t\t\t</select>\r\n");
      out.write("\t\t\t\t\t<!-- <input name=\"character\" type=\"text\"  id=\"character\" ltype='text' value=\"必修\" /> -->\r\n");
      out.write("\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t \r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t");
      out.write("\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td align=\"right\" class=\"l-table-edit-td\">开课学院:</td>\r\n");
      out.write("\t\t\t\t    <td align=\"left\"  class=\"l-table-edit-td\">\r\n");
      out.write("\t\t\t\t    <select type=\"select\" id=\"academic\" name=\"academic\" class=\"link\">\r\n");
      out.write("\t\t\t\t\t\t<option value=\"国际教育学院 \" >国际教育学院</option>\r\n");
      out.write("\t\t\t\t\t\t<option value=\"纺织学院\">纺织学院</option>\r\n");
      out.write("\t\t\t\t\t\t<option value=\"材料科学与工程学院\">材料科学与工程学院</option>\r\n");
      out.write("\t\t\t\t\t\t<option value=\"环境与化学工程学院\">环境与化学工程学院</option>\r\n");
      out.write("\t\t\t\t\t\t<option value=\"机械工程学院\">机械工程学院</option>\r\n");
      out.write("\t\t\t\t\t\t<option value=\"计算机科学与软件学院\">计算机科学与软件学院</option>\r\n");
      out.write("\t\t\t\t\t\t<option value=\"电气工程与自动化学院 \">电气工程与自动化学院</option>\r\n");
      out.write("\t\t\t\t\t\t<option value=\"电子与信息工程学院 \">电子与信息工程学院</option>\r\n");
      out.write("\t\t\t\t\t\t<option value=\"理学院\">理学院</option>\r\n");
      out.write("\t\t\t\t\t\t<option value=\"艺术与服装学院\">艺术与服装学院</option>\r\n");
      out.write("\t\t\t\t\t\t<option value=\"管理学院 \">管理学院</option>\r\n");
      out.write("\t\t\t\t\t\t<option value=\"经济学院\">经济学院</option>\r\n");
      out.write("\t\t\t\t\t\t<option value=\"人文与法学院\">人文与法学院</option>\r\n");
      out.write("\t\t\t\t\t\t<option value=\"外国语学院 \">外国语学院</option>\r\n");
      out.write("\t\t\t\t\t\t<option value=\"马克思主义学院\">马克思主义学院</option>\r\n");
      out.write("\t\t\t\t\t\t<option value=\"应用技术学院\">应用技术学院</option>\r\n");
      out.write("\t\t\t\t\t\t<option value=\"继续教育学院\">继续教育学院</option>\r\n");
      out.write("\t\t\t\t</select>\r\n");
      out.write("\t\t\t\t</td>\t\t\t\t\t \r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td align=\"right\" class=\"l-table-edit-td\">负责教师:</td>\r\n");
      out.write("\t\t\t\t<td align=\"left\" style=\"padding-left: 4px\">\r\n");
      out.write("\t\t\t\t\t<input name=\"teacher\" type=\"text\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${courses.teacher }", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\" id=\"teacher\" ltype='text' />\r\n");
      out.write("\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t \r\n");
      out.write("\t\t\t\t</tr>\t\t\t\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td align=\"right\" class=\"l-table-edit-td\"></td>\r\n");
      out.write("\t\t\t\t<td align=\"left\"><div id=\"result2\" style=\"color: red;\"></div>\r\n");
      out.write("\t\t\t\t<td align=\"left\" class=\"l-table-edit-td\"></td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td align=\"right\" class=\"l-table-edit-td\"></td>\r\n");
      out.write("\t\t\t\t<td align=\"left\"><br /><input onclick=\"submit()\" value=\"更&nbsp;&nbsp;新\" id=\"Button1\"class=\"l-button l-button-submit\" /></td>\r\n");
      out.write("\t\t\t\t<td align=\"left\" class=\"l-table-edit-td\"></td>\t\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t</table>\r\n");
      out.write("\t\t<table style=\"font-size:14px; margin-left: 10px;\">\r\n");
      out.write("   \t\t<tr>\r\n");
      out.write("   \t\t\t<p id=\"msg\" style=\"color:red\"></p>\r\n");
      out.write("   \t\t</tr> \r\n");
      out.write("    </table>\r\n");
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

  private boolean _jspx_meth_s_005fif_005f0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  s:if
    org.apache.struts2.views.jsp.IfTag _jspx_th_s_005fif_005f0 = (org.apache.struts2.views.jsp.IfTag) _005fjspx_005ftagPool_005fs_005fif_005ftest.get(org.apache.struts2.views.jsp.IfTag.class);
    _jspx_th_s_005fif_005f0.setPageContext(_jspx_page_context);
    _jspx_th_s_005fif_005f0.setParent(null);
    // /WEB-INF/course/courseedit.jsp(320,6) name = test type = java.lang.String reqTime = false required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_s_005fif_005f0.setTest("#courses.character=='必修'");
    int _jspx_eval_s_005fif_005f0 = _jspx_th_s_005fif_005f0.doStartTag();
    if (_jspx_eval_s_005fif_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      if (_jspx_eval_s_005fif_005f0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.pushBody();
        _jspx_th_s_005fif_005f0.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
        _jspx_th_s_005fif_005f0.doInitBody();
      }
      do {
        out.write("\r\n");
        out.write("\t\t\t\t     <option value=\"");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${courses.character }", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
        out.write("\" selected=\"selected\" >");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${courses.character }", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
        out.write("</option>\r\n");
        out.write("\t\t\t\t     <option value=\"限选\">限选</option>\r\n");
        out.write("\t\t\t\t     <option value=\"任选\">任选</option>\r\n");
        out.write("\t\t\t\t  ");
        int evalDoAfterBody = _jspx_th_s_005fif_005f0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
      if (_jspx_eval_s_005fif_005f0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.popBody();
      }
    }
    if (_jspx_th_s_005fif_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fs_005fif_005ftest.reuse(_jspx_th_s_005fif_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fs_005fif_005ftest.reuse(_jspx_th_s_005fif_005f0);
    return false;
  }

  private boolean _jspx_meth_s_005felseif_005f0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  s:elseif
    org.apache.struts2.views.jsp.ElseIfTag _jspx_th_s_005felseif_005f0 = (org.apache.struts2.views.jsp.ElseIfTag) _005fjspx_005ftagPool_005fs_005felseif_005ftest.get(org.apache.struts2.views.jsp.ElseIfTag.class);
    _jspx_th_s_005felseif_005f0.setPageContext(_jspx_page_context);
    _jspx_th_s_005felseif_005f0.setParent(null);
    // /WEB-INF/course/courseedit.jsp(325,6) name = test type = java.lang.String reqTime = false required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_s_005felseif_005f0.setTest("#courses.character=='限选'");
    int _jspx_eval_s_005felseif_005f0 = _jspx_th_s_005felseif_005f0.doStartTag();
    if (_jspx_eval_s_005felseif_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      if (_jspx_eval_s_005felseif_005f0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.pushBody();
        _jspx_th_s_005felseif_005f0.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
        _jspx_th_s_005felseif_005f0.doInitBody();
      }
      do {
        out.write("\r\n");
        out.write("\t\t\t\t     <option value=\"");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${courses.character }", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
        out.write("\" selected=\"selected\" >");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${courses.character }", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
        out.write("</option>\r\n");
        out.write("\t\t\t\t     <option value=\"必修\">必修</option>\r\n");
        out.write("\t\t\t\t     <option value=\"任选\">任选</option>\r\n");
        out.write("\t\t\t\t  ");
        int evalDoAfterBody = _jspx_th_s_005felseif_005f0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
      if (_jspx_eval_s_005felseif_005f0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.popBody();
      }
    }
    if (_jspx_th_s_005felseif_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fs_005felseif_005ftest.reuse(_jspx_th_s_005felseif_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fs_005felseif_005ftest.reuse(_jspx_th_s_005felseif_005f0);
    return false;
  }

  private boolean _jspx_meth_s_005felseif_005f1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  s:elseif
    org.apache.struts2.views.jsp.ElseIfTag _jspx_th_s_005felseif_005f1 = (org.apache.struts2.views.jsp.ElseIfTag) _005fjspx_005ftagPool_005fs_005felseif_005ftest.get(org.apache.struts2.views.jsp.ElseIfTag.class);
    _jspx_th_s_005felseif_005f1.setPageContext(_jspx_page_context);
    _jspx_th_s_005felseif_005f1.setParent(null);
    // /WEB-INF/course/courseedit.jsp(330,6) name = test type = java.lang.String reqTime = false required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_s_005felseif_005f1.setTest("#courses.character=='任选'");
    int _jspx_eval_s_005felseif_005f1 = _jspx_th_s_005felseif_005f1.doStartTag();
    if (_jspx_eval_s_005felseif_005f1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      if (_jspx_eval_s_005felseif_005f1 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.pushBody();
        _jspx_th_s_005felseif_005f1.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
        _jspx_th_s_005felseif_005f1.doInitBody();
      }
      do {
        out.write("\r\n");
        out.write("\t\t\t\t     <option value=\"");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${courses.character }", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
        out.write("\" selected=\"selected\" >");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${courses.character }", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
        out.write("</option>\r\n");
        out.write("\t\t\t\t     <option value=\"必修\">必修</option>\r\n");
        out.write("\t\t\t\t     <option value=\"限选\">限选</option>\r\n");
        out.write("\t\t\t\t  ");
        int evalDoAfterBody = _jspx_th_s_005felseif_005f1.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
      if (_jspx_eval_s_005felseif_005f1 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.popBody();
      }
    }
    if (_jspx_th_s_005felseif_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fs_005felseif_005ftest.reuse(_jspx_th_s_005felseif_005f1);
      return true;
    }
    _005fjspx_005ftagPool_005fs_005felseif_005ftest.reuse(_jspx_th_s_005felseif_005f1);
    return false;
  }
}
