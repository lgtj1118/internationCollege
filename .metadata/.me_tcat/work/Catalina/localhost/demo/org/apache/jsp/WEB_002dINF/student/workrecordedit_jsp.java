package org.apache.jsp.WEB_002dINF.student;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;

public final class workrecordedit_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fs_005fiterator_005fvalue_005fid;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fs_005fif_005ftest;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fs_005fproperty_005fvalue_005fnobody;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fs_005felse;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fs_005felseif_005ftest;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fs_005fiterator_005fvalue_005fid = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fs_005fif_005ftest = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fs_005fproperty_005fvalue_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fs_005felse = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fs_005felseif_005ftest = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fs_005fiterator_005fvalue_005fid.release();
    _005fjspx_005ftagPool_005fs_005fif_005ftest.release();
    _005fjspx_005ftagPool_005fs_005fproperty_005fvalue_005fnobody.release();
    _005fjspx_005ftagPool_005fs_005felse.release();
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
      out.write("                    if (element.hasClass(\"l-textarea\")) {\r\n");
      out.write("                        element.addClass(\"l-textarea-invalid\");\r\n");
      out.write("                    }\r\n");
      out.write("                    else if (element.hasClass(\"l-text-field\")) {\r\n");
      out.write("                        element.parent().addClass(\"l-text-invalid\");\r\n");
      out.write("                    }\r\n");
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
      out.write("\t\t\t\t$(\"form .l-text,.l-textarea\").ligerHideTip();\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\tcheck1();\r\n");
      out.write("\t\t\t\tcheckclass();\r\n");
      out.write("\t\t\t\tchecknum();\r\n");
      out.write("\t\t\t\tchecksis();\r\n");
      out.write("\t\t\t\tif(flg1&&flg2&&flg&&flg4){\r\n");
      out.write("\t\t\t\tvar url = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/system/Class_workrecordupdate.action?classrecord.classid=\"+ encodeURI(encodeURI($(\"#classid\").val()))\r\n");
      out.write("\t\t        +\"&classrecord.id=\"+encodeURI(encodeURI($(\"#id\").val()))\r\n");
      out.write("\t\t        +\"&classrecord.teacherid=\"+encodeURI(encodeURI($(\"#teacherid\").val()))\r\n");
      out.write("\t\t        +\"&classrecord.classmeetingfrequency=\"+encodeURI(encodeURI($(\"#classmeetingfrequency\").val()))\r\n");
      out.write("\t\t        +\"&&classrecord.appointmentnumber=\"+encodeURI(encodeURI($(\"#appointmentnumber\").val()))\r\n");
      out.write("\t\t        +\"&classrecord.selfevalution=\"+encodeURI(encodeURI($(\"#selfevalution\").val()))\r\n");
      out.write("\t\t        +\"&classrecord.physicalmentalcondition=\"+encodeURI(encodeURI($(\"#physicalmentalcondition\").val()))\r\n");
      out.write("\t\t        +\"&classrecord.studyingcondition=\"+encodeURI(encodeURI($(\"#studyingcondition\").val()))\r\n");
      out.write("\t\t        +\"&classrecord.feedback=\"+encodeURI(encodeURI($(\"#feedback\").val()));\r\n");
      out.write("\t\t        $.post(url,null,function(){\r\n");
      out.write("\t\t          top.f_closeTab();\r\n");
      out.write("\t\t       }); \r\n");
      out.write("\t\t       } \r\n");
      out.write("\t\t\t }\t\t\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\t$(\"form\").ligerForm();\r\n");
      out.write("\t\t$(\".l-button-test\").click(function() {\r\n");
      out.write("\t\t\talert(v.element($(\"#txtName\")));\r\n");
      out.write("\t\t});\r\n");
      out.write("\t});\t\r\n");
      out.write("\tvar flg4=false;\r\n");
      out.write("\tfunction checkclass(){\r\n");
      out.write("\t  var classid = $(\"#classid\").val();\r\n");
      out.write("\t  if(classid.length==0){\r\n");
      out.write("\t     $(\"#result3\").html(\"班级不能为空！\");\r\n");
      out.write("\t     $(\"#result3\").show();\r\n");
      out.write("\t     flg4= false;\r\n");
      out.write("\t  }else{\r\n");
      out.write("\t     $(\"#result3\").hide();\r\n");
      out.write("\t     flg4= true;\r\n");
      out.write("\t  }\r\n");
      out.write("\t}\r\n");
      out.write("\tfunction check(){\t  \r\n");
      out.write("\t  $(\"#classmonitor\").val(\"\");\r\n");
      out.write("\t    \r\n");
      out.write("\t  var classid = $(\"#classid\").val();\r\n");
      out.write("\t  $.post(\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/system/Class_checkmonitor.action?cls.id=\"+classid,null,function(data){\r\n");
      out.write("\t    //alert(data);\r\n");
      out.write("\t    $(\"#classmonitor\").val(data);//填充内容\r\n");
      out.write("\t  })\r\n");
      out.write("\t}\r\n");
      out.write("\tvar flg = false;\t\r\n");
      out.write("\tfunction check1(){\r\n");
      out.write("\t  var classmeeting =$(\"#classmeetingfrequency\").val();\r\n");
      out.write("\t  if(classmeeting.length==0){\r\n");
      out.write("\t    $(\"#result\").html(\"本月班会次数不能为空！\");\r\n");
      out.write("\t    $(\"#result\").show();\r\n");
      out.write("\t    flg = false;\r\n");
      out.write("\t  }else{\r\n");
      out.write("\t    $(\"#result\").hide();\r\n");
      out.write("\t    if(isNaN(classmeeting)){\r\n");
      out.write("\t       $(\"#result\").html(\"本月班会次数只能为数字！\");\r\n");
      out.write("\t       $(\"#result\").show();\r\n");
      out.write("\t       flg = false;\r\n");
      out.write("\t    }else{\r\n");
      out.write("\t      $(\"#result\").hide();\r\n");
      out.write("\t      flg= true;\r\n");
      out.write("\t    }\r\n");
      out.write("\t  }\r\n");
      out.write("\t}\r\n");
      out.write("\tvar flg1 = false;\t\r\n");
      out.write("\tfunction checknum(){\r\n");
      out.write("\t  var classmeeting =$(\"#appointmentnumber\").val();\r\n");
      out.write("\t  if(classmeeting.length==0){\r\n");
      out.write("\t    $(\"#result1\").html(\"本月约谈人数不能为空！\");\r\n");
      out.write("\t    $(\"#result1\").show();\r\n");
      out.write("\t    flg1 = false;\r\n");
      out.write("\t  }else{\r\n");
      out.write("\t    $(\"#result1\").hide();\r\n");
      out.write("\t    if(isNaN(classmeeting)){\r\n");
      out.write("\t       $(\"#result1\").html(\"本月约谈人数只能为数字！\");\r\n");
      out.write("\t       $(\"#result1\").show();\r\n");
      out.write("\t       flg1 = false;\r\n");
      out.write("\t    }else{\r\n");
      out.write("\t      $(\"#result1\").hide();\r\n");
      out.write("\t      flg1= true;\r\n");
      out.write("\t    }\r\n");
      out.write("\t  }\r\n");
      out.write("\t}\r\n");
      out.write("\tvar flg2 = fasle;\r\n");
      out.write("\tfunction checksis(){\r\n");
      out.write("\t   var physicalmentalcondition = $(\"#physicalmentalcondition\").val();\r\n");
      out.write("\t   var studyingcondition = $(\"#studyingcondition\").val();\r\n");
      out.write("\t   if(physicalmentalcondition.lenght==0){\r\n");
      out.write("\t     $(\"#result2\").html(\"学生身心情况不能为空！\");\r\n");
      out.write("\t     $(\"#result2\").show();\r\n");
      out.write("\t     flg2=false;\r\n");
      out.write("\t     return false;\r\n");
      out.write("\t   }else{\r\n");
      out.write("\t     $(\"#result2\").hide();\r\n");
      out.write("\t      if(studyingcondition.length==0){\r\n");
      out.write("\t         $(\"#result2\").html(\"学生上课情况不能为空！\");\r\n");
      out.write("\t         $(\"#result2\").show();\r\n");
      out.write("\t         flg2=false;\r\n");
      out.write("\t         return false;\r\n");
      out.write("\t      }else{\r\n");
      out.write("\t        $(\"#result2\").hide();\r\n");
      out.write("\t        flg2= true;\r\n");
      out.write("\t      }\r\n");
      out.write("\t   }\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("</script>\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write("body{ font-size:12px;}\r\n");
      out.write(".l-table-edit {}\r\n");
      out.write(".l-table-edit-td{ padding:4px;}\r\n");
      out.write(".l-button-submit,.l-button-test{width:80px; float:left; margin-left:10px; padding-bottom:2px;}\r\n");
      out.write(".l-verify-tip{ left:230px; top:120px;}\r\n");
      out.write("#errorLabelContainer{ padding:10px; width:300px; border:1px solid #FF4466; display:none; background:#FFEEEE; color:Red;}\r\n");
      out.write("#contain{\r\n");
      out.write(" /* margin:auto; */\r\n");
      out.write(" width:85%;\r\n");
      out.write(" margin-top: 30px;\r\n");
      out.write(" margin-left:100px;\r\n");
      out.write("}\r\n");
      out.write("table{\r\n");
      out.write("  text-align: right;\r\n");
      out.write("}\r\n");
      out.write("textarea {\r\n");
      out.write("\twidth: 100%;\r\n");
      out.write("\tfont-size: 12px;\r\n");
      out.write("\theight:60px;\r\n");
      out.write("\tmargin-top:10px;\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body style=\"padding: 10px\">\r\n");
      out.write("<div id=\"contain\">\r\n");
      out.write("<div align=\"center\"><strong><font size=\"3\">班主任工作记录表</font></strong>\t</div><br/>\r\n");
      out.write("<form name=\"form1\" method=\"post\" action=\"\" id=\"form1\">\r\n");
      out.write("\t\t<div id=\"errorLabelContainer\" class=\"l-text-invalid\"></div>\r\n");
      out.write("\t\t<input id=\"id\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${work.id}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\" type=\"hidden\" />\r\n");
      out.write("\t\t<table cellpadding=\"0\" cellspacing=\"0\" class=\"l-table-edit\">\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td align=\"right\" class=\"l-table-edit-td\">班主任姓名:<input id=\"teacherid\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${sessionScope.user.usernum}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\" type=\"hidden\" /></td>\r\n");
      out.write("\t\t\t\t<td align=\"left\" class=\"l-table-edit-td\"><input name=\"classteacher\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${sessionScope.user.realname }", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\" disabled=\"disabled\" type=\"text\"  id=\"classteacher\" ltype=\"text\"   /></td>\r\n");
      out.write("\t\t\t\t<td align=\"right\" class=\"l-table-edit-td\"></td>\r\n");
      out.write("\t\t\t\t<td align=\"right\" class=\"l-table-edit-td\">负责班级:</td>\r\n");
      out.write("\t\t\t\t<td align=\"left\" class=\"l-table-edit-td\">\r\n");
      out.write("\t\t\t\t  <select id=\"classid\" type=\"select\" onchange=\"check(),checkclass()\"  >\r\n");
      out.write("\t\t\t\t   ");
      if (_jspx_meth_s_005fiterator_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t\t\t</select>\r\n");
      out.write("\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t<td align=\"right\" class=\"l-table-edit-td\"><div id=\"result3\" style=\"color: red;\" ></div></td>\r\n");
      out.write("\t\t\t\t<td align=\"right\" class=\"l-table-edit-td\">班长姓名:</td>\r\n");
      out.write("\t\t\t\t<td valign=\"top\"><br /></td><td align=\"left\" class=\"l-table-edit-td\"><input name=\"classmonitor\"type=\"text\"  id=\"classmonitor\"  ltype=\"text\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${stu.stuname }", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\"  /></td>\t\t\t\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td align=\"right\" class=\"l-table-edit-td\">本月班会次数:<font color=\"#ff0000\">*</font></td>\r\n");
      out.write("\t\t\t\t<td align=\"left\" class=\"l-table-edit-td\"><input name=\"classmeetingfrequency\" onchange=\"check1()\" type=\"text\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${work.classmeetingfrequency }", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\" id=\"classmeetingfrequency\" ltype=\"text\"   /></td>\r\n");
      out.write("\t\t\t\t<td align=\"right\" class=\"l-table-edit-td\"><div id=\"result\" style=\"color: red;\" ></div></td>\r\n");
      out.write("\t\t\t\t<td align=\"right\" class=\"l-table-edit-td\">本月约谈人数:<font color=\"#ff0000\">*</font></td>\r\n");
      out.write("\t\t\t\t<td align=\"left\" class=\"l-table-edit-td\"><input name=\"appointmentnumber\"type=\"text\" onchange=\"checknum();\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${work.appointmentnumber }", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\" id=\"appointmentnumber\" ltype=\"text\"  /></td>\r\n");
      out.write("\t\t\t\t<td align=\"right\" class=\"l-table-edit-td\"></td>\r\n");
      out.write("\t\t\t\t<td align=\"right\" class=\"l-table-edit-td\">自我工作评价:</td>\r\n");
      out.write("\t\t\t\t<td valign=\"top\"><div id=\"result1\" style=\"color: red;\" ></div></td>\r\n");
      out.write("\t\t\t\t<td align=\"left\" class=\"l-table-edit-td\">\r\n");
      out.write("\t\t\t\t <select id=\"selfevalution\" >\r\n");
      out.write("\t\t\t\t   ");
      if (_jspx_meth_s_005fif_005f1(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t\t\t   ");
      if (_jspx_meth_s_005felseif_005f0(_jspx_page_context))
        return;
      out.write(" \r\n");
      out.write("\t\t\t\t   ");
      if (_jspx_meth_s_005felseif_005f1(_jspx_page_context))
        return;
      out.write(" \r\n");
      out.write("\t\t\t\t   ");
      if (_jspx_meth_s_005felseif_005f2(_jspx_page_context))
        return;
      out.write(" \r\n");
      out.write("\t\t\t\t </select>\r\n");
      out.write("\t\t\t\t</td>\t\t\t\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t  <td>学生身心情况：<font color=\"#ff0000\">*</font></td>\r\n");
      out.write("\t\t\t  <th colspan=\"6\"><textarea id=\"physicalmentalcondition\" onchange=\"checksis()\"   >");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${work.physicalmentalcondition }", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("</textarea></th>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t  <td>学生上课情况：<font color=\"#ff0000\">*</font></td>\r\n");
      out.write("\t\t\t  <th colspan=\"6\"><textarea id=\"studyingcondition\" onchange=\"checksis()\" >");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${work.studyingcondition }", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("</textarea></th>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t  <td>学生反映的课程、老师、学院问题：</td>\r\n");
      out.write("\t\t\t  <th colspan=\"6\"><textarea id=\"feedback\" >");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${work.feedback }", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("</textarea></th>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t \t\t\t\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td align=\"right\" class=\"l-table-edit-td\"></td>\r\n");
      out.write("\t\t\t\t<td align=\"left\"><div id=\"result2\" style=\"color: red;\"></div></td>\r\n");
      out.write("\t\t\t\t<td align=\"left\" class=\"l-table-edit-td\"></td>\t\t\t\t\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<th align=\"center\" class=\"l-table-edit-td\"colspan=\"3\"><div id=\"result2\" style=\"color: red;\"></div></th>\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td align=\"right\" class=\"l-table-edit-td\"></td>\r\n");
      out.write("\t\t\t\t<td align=\"right\" class=\"l-table-edit-td\"></td>\r\n");
      out.write("\t\t\t\t<td align=\"right\" class=\"l-table-edit-td\"></td>\r\n");
      out.write("\t\t\t\t<td align=\"left\" class=\"l-table-edit-td\"><br />\r\n");
      out.write("\t\t\t\t <input type=\"submit\" value=\"更&nbsp;&nbsp;新\" id=\"Button1\" class=\"l-button l-button-submit\" />\r\n");
      out.write("\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t<td align=\"right\" class=\"l-table-edit-td\"></td>\r\n");
      out.write("\t\t\t\t<td align=\"left\">\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t</table>\r\n");
      out.write("\t\t<br />\r\n");
      out.write("\t</form>\r\n");
      out.write("</div>\r\n");
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

  private boolean _jspx_meth_s_005fiterator_005f0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  s:iterator
    org.apache.struts2.views.jsp.IteratorTag _jspx_th_s_005fiterator_005f0 = (org.apache.struts2.views.jsp.IteratorTag) _005fjspx_005ftagPool_005fs_005fiterator_005fvalue_005fid.get(org.apache.struts2.views.jsp.IteratorTag.class);
    _jspx_th_s_005fiterator_005f0.setPageContext(_jspx_page_context);
    _jspx_th_s_005fiterator_005f0.setParent(null);
    // /WEB-INF/student/workrecordedit.jsp(205,7) name = value type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_s_005fiterator_005f0.setValue("#teacherclass");
    // /WEB-INF/student/workrecordedit.jsp(205,7) name = id type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_s_005fiterator_005f0.setId("c");
    int _jspx_eval_s_005fiterator_005f0 = _jspx_th_s_005fiterator_005f0.doStartTag();
    if (_jspx_eval_s_005fiterator_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      if (_jspx_eval_s_005fiterator_005f0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.pushBody();
        _jspx_th_s_005fiterator_005f0.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
        _jspx_th_s_005fiterator_005f0.doInitBody();
      }
      do {
        out.write("\r\n");
        out.write("\t\t\t\t     ");
        if (_jspx_meth_s_005fif_005f0(_jspx_th_s_005fiterator_005f0, _jspx_page_context))
          return true;
        out.write("\r\n");
        out.write("\t\t\t\t     ");
        if (_jspx_meth_s_005felse_005f0(_jspx_th_s_005fiterator_005f0, _jspx_page_context))
          return true;
        out.write("\r\n");
        out.write("\t\t\t\t   ");
        int evalDoAfterBody = _jspx_th_s_005fiterator_005f0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
      if (_jspx_eval_s_005fiterator_005f0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.popBody();
      }
    }
    if (_jspx_th_s_005fiterator_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fs_005fiterator_005fvalue_005fid.reuse(_jspx_th_s_005fiterator_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fs_005fiterator_005fvalue_005fid.reuse(_jspx_th_s_005fiterator_005f0);
    return false;
  }

  private boolean _jspx_meth_s_005fif_005f0(javax.servlet.jsp.tagext.JspTag _jspx_th_s_005fiterator_005f0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  s:if
    org.apache.struts2.views.jsp.IfTag _jspx_th_s_005fif_005f0 = (org.apache.struts2.views.jsp.IfTag) _005fjspx_005ftagPool_005fs_005fif_005ftest.get(org.apache.struts2.views.jsp.IfTag.class);
    _jspx_th_s_005fif_005f0.setPageContext(_jspx_page_context);
    _jspx_th_s_005fif_005f0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_s_005fiterator_005f0);
    // /WEB-INF/student/workrecordedit.jsp(206,9) name = test type = java.lang.String reqTime = false required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_s_005fif_005f0.setTest("#c.id==#work.classid");
    int _jspx_eval_s_005fif_005f0 = _jspx_th_s_005fif_005f0.doStartTag();
    if (_jspx_eval_s_005fif_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      if (_jspx_eval_s_005fif_005f0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.pushBody();
        _jspx_th_s_005fif_005f0.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
        _jspx_th_s_005fif_005f0.doInitBody();
      }
      do {
        out.write("\r\n");
        out.write("\t\t\t\t      <option value=\"");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${c.id }", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
        out.write("\" selected=\"selected\" >");
        if (_jspx_meth_s_005fproperty_005f0(_jspx_th_s_005fif_005f0, _jspx_page_context))
          return true;
        out.write("</option>\r\n");
        out.write("\t\t\t\t     ");
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

  private boolean _jspx_meth_s_005fproperty_005f0(javax.servlet.jsp.tagext.JspTag _jspx_th_s_005fif_005f0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  s:property
    org.apache.struts2.views.jsp.PropertyTag _jspx_th_s_005fproperty_005f0 = (org.apache.struts2.views.jsp.PropertyTag) _005fjspx_005ftagPool_005fs_005fproperty_005fvalue_005fnobody.get(org.apache.struts2.views.jsp.PropertyTag.class);
    _jspx_th_s_005fproperty_005f0.setPageContext(_jspx_page_context);
    _jspx_th_s_005fproperty_005f0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_s_005fif_005f0);
    // /WEB-INF/student/workrecordedit.jsp(207,56) name = value type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_s_005fproperty_005f0.setValue("#c.classname");
    int _jspx_eval_s_005fproperty_005f0 = _jspx_th_s_005fproperty_005f0.doStartTag();
    if (_jspx_th_s_005fproperty_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fs_005fproperty_005fvalue_005fnobody.reuse(_jspx_th_s_005fproperty_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fs_005fproperty_005fvalue_005fnobody.reuse(_jspx_th_s_005fproperty_005f0);
    return false;
  }

  private boolean _jspx_meth_s_005felse_005f0(javax.servlet.jsp.tagext.JspTag _jspx_th_s_005fiterator_005f0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  s:else
    org.apache.struts2.views.jsp.ElseTag _jspx_th_s_005felse_005f0 = (org.apache.struts2.views.jsp.ElseTag) _005fjspx_005ftagPool_005fs_005felse.get(org.apache.struts2.views.jsp.ElseTag.class);
    _jspx_th_s_005felse_005f0.setPageContext(_jspx_page_context);
    _jspx_th_s_005felse_005f0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_s_005fiterator_005f0);
    int _jspx_eval_s_005felse_005f0 = _jspx_th_s_005felse_005f0.doStartTag();
    if (_jspx_eval_s_005felse_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      if (_jspx_eval_s_005felse_005f0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.pushBody();
        _jspx_th_s_005felse_005f0.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
        _jspx_th_s_005felse_005f0.doInitBody();
      }
      do {
        out.write("\r\n");
        out.write("\t\t\t\t        <option value=\"");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${c.id }", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
        out.write('"');
        out.write(' ');
        out.write('>');
        if (_jspx_meth_s_005fproperty_005f1(_jspx_th_s_005felse_005f0, _jspx_page_context))
          return true;
        out.write("</option>\r\n");
        out.write("\t\t\t\t     ");
        int evalDoAfterBody = _jspx_th_s_005felse_005f0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
      if (_jspx_eval_s_005felse_005f0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.popBody();
      }
    }
    if (_jspx_th_s_005felse_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fs_005felse.reuse(_jspx_th_s_005felse_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fs_005felse.reuse(_jspx_th_s_005felse_005f0);
    return false;
  }

  private boolean _jspx_meth_s_005fproperty_005f1(javax.servlet.jsp.tagext.JspTag _jspx_th_s_005felse_005f0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  s:property
    org.apache.struts2.views.jsp.PropertyTag _jspx_th_s_005fproperty_005f1 = (org.apache.struts2.views.jsp.PropertyTag) _005fjspx_005ftagPool_005fs_005fproperty_005fvalue_005fnobody.get(org.apache.struts2.views.jsp.PropertyTag.class);
    _jspx_th_s_005fproperty_005f1.setPageContext(_jspx_page_context);
    _jspx_th_s_005fproperty_005f1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_s_005felse_005f0);
    // /WEB-INF/student/workrecordedit.jsp(210,38) name = value type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_s_005fproperty_005f1.setValue("#c.classname");
    int _jspx_eval_s_005fproperty_005f1 = _jspx_th_s_005fproperty_005f1.doStartTag();
    if (_jspx_th_s_005fproperty_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fs_005fproperty_005fvalue_005fnobody.reuse(_jspx_th_s_005fproperty_005f1);
      return true;
    }
    _005fjspx_005ftagPool_005fs_005fproperty_005fvalue_005fnobody.reuse(_jspx_th_s_005fproperty_005f1);
    return false;
  }

  private boolean _jspx_meth_s_005fif_005f1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  s:if
    org.apache.struts2.views.jsp.IfTag _jspx_th_s_005fif_005f1 = (org.apache.struts2.views.jsp.IfTag) _005fjspx_005ftagPool_005fs_005fif_005ftest.get(org.apache.struts2.views.jsp.IfTag.class);
    _jspx_th_s_005fif_005f1.setPageContext(_jspx_page_context);
    _jspx_th_s_005fif_005f1.setParent(null);
    // /WEB-INF/student/workrecordedit.jsp(230,7) name = test type = java.lang.String reqTime = false required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_s_005fif_005f1.setTest("#work.selfevalution==0");
    int _jspx_eval_s_005fif_005f1 = _jspx_th_s_005fif_005f1.doStartTag();
    if (_jspx_eval_s_005fif_005f1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      if (_jspx_eval_s_005fif_005f1 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.pushBody();
        _jspx_th_s_005fif_005f1.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
        _jspx_th_s_005fif_005f1.doInitBody();
      }
      do {
        out.write("\r\n");
        out.write("\t\t\t\t      <option value=\"0\" selected=\"selected\" >优秀</option>\r\n");
        out.write("\t\t\t\t      <option value=\"1\" >良</option>\r\n");
        out.write("\t\t\t\t      <option value=\"2\" >中等</option>\r\n");
        out.write("\t\t\t\t      <option value=\"3\" >不好</option>\r\n");
        out.write("\t\t\t\t   ");
        int evalDoAfterBody = _jspx_th_s_005fif_005f1.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
      if (_jspx_eval_s_005fif_005f1 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.popBody();
      }
    }
    if (_jspx_th_s_005fif_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fs_005fif_005ftest.reuse(_jspx_th_s_005fif_005f1);
      return true;
    }
    _005fjspx_005ftagPool_005fs_005fif_005ftest.reuse(_jspx_th_s_005fif_005f1);
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
    // /WEB-INF/student/workrecordedit.jsp(236,7) name = test type = java.lang.String reqTime = false required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_s_005felseif_005f0.setTest("#work.selfevalution==1");
    int _jspx_eval_s_005felseif_005f0 = _jspx_th_s_005felseif_005f0.doStartTag();
    if (_jspx_eval_s_005felseif_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      if (_jspx_eval_s_005felseif_005f0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.pushBody();
        _jspx_th_s_005felseif_005f0.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
        _jspx_th_s_005felseif_005f0.doInitBody();
      }
      do {
        out.write("\r\n");
        out.write("\t\t\t\t      <option value=\"1\" selected=\"selected\" >良</option>\r\n");
        out.write("\t\t\t\t      <option value=\"0\"  >优秀</option>\t\t\t\t      \r\n");
        out.write("\t\t\t\t      <option value=\"2\" >中等</option>\r\n");
        out.write("\t\t\t\t      <option value=\"3\" >不好</option>\r\n");
        out.write("\t\t\t\t   ");
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
    // /WEB-INF/student/workrecordedit.jsp(242,7) name = test type = java.lang.String reqTime = false required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_s_005felseif_005f1.setTest("#work.selfevalution==2");
    int _jspx_eval_s_005felseif_005f1 = _jspx_th_s_005felseif_005f1.doStartTag();
    if (_jspx_eval_s_005felseif_005f1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      if (_jspx_eval_s_005felseif_005f1 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.pushBody();
        _jspx_th_s_005felseif_005f1.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
        _jspx_th_s_005felseif_005f1.doInitBody();
      }
      do {
        out.write("\r\n");
        out.write("\t\t\t\t      <option value=\"2\" selected=\"selected\" >中等</option>\r\n");
        out.write("\t\t\t\t      <option value=\"0\"  >优秀</option>\t\r\n");
        out.write("\t\t\t\t      <option value=\"1\" >良</option>\t\t\t      \t\t\t\t      \r\n");
        out.write("\t\t\t\t      <option value=\"3\" >不好</option>\r\n");
        out.write("\t\t\t\t   ");
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

  private boolean _jspx_meth_s_005felseif_005f2(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  s:elseif
    org.apache.struts2.views.jsp.ElseIfTag _jspx_th_s_005felseif_005f2 = (org.apache.struts2.views.jsp.ElseIfTag) _005fjspx_005ftagPool_005fs_005felseif_005ftest.get(org.apache.struts2.views.jsp.ElseIfTag.class);
    _jspx_th_s_005felseif_005f2.setPageContext(_jspx_page_context);
    _jspx_th_s_005felseif_005f2.setParent(null);
    // /WEB-INF/student/workrecordedit.jsp(248,7) name = test type = java.lang.String reqTime = false required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_s_005felseif_005f2.setTest("#work.selfevalution==3");
    int _jspx_eval_s_005felseif_005f2 = _jspx_th_s_005felseif_005f2.doStartTag();
    if (_jspx_eval_s_005felseif_005f2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      if (_jspx_eval_s_005felseif_005f2 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.pushBody();
        _jspx_th_s_005felseif_005f2.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
        _jspx_th_s_005felseif_005f2.doInitBody();
      }
      do {
        out.write("\r\n");
        out.write("\t\t\t\t      <option value=\"3\" selected=\"selected\"  >不好</option>\r\n");
        out.write("\t\t\t\t      <option value=\"0\"  >优秀</option>\t\r\n");
        out.write("\t\t\t\t      <option value=\"1\" >良</option>\t\t\r\n");
        out.write("\t\t\t\t      <option value=\"2\" >中等</option>\t      \t\t\t\t      \r\n");
        out.write("\t\t\t\t      \r\n");
        out.write("\t\t\t\t   ");
        int evalDoAfterBody = _jspx_th_s_005felseif_005f2.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
      if (_jspx_eval_s_005felseif_005f2 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.popBody();
      }
    }
    if (_jspx_th_s_005felseif_005f2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fs_005felseif_005ftest.reuse(_jspx_th_s_005felseif_005f2);
      return true;
    }
    _005fjspx_005ftagPool_005fs_005felseif_005ftest.reuse(_jspx_th_s_005felseif_005f2);
    return false;
  }
}
