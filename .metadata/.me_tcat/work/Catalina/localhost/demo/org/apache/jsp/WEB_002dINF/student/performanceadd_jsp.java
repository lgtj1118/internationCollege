package org.apache.jsp.WEB_002dINF.student;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;

public final class performanceadd_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fs_005fiterator_005fvalue_005fid;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fs_005fiterator_005fvalue_005fid = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fs_005fiterator_005fvalue_005fid.release();
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
      out.write("\t\t\t\tcheck();\r\n");
      out.write("\t\t\t\tcheck1();\r\n");
      out.write("\t\t\t\tif(flg&&flg1){\r\n");
      out.write("\t\t\t\t$.post(\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/system/Class_performanceendadd.action?performance.passport=\"+ encodeURI(encodeURI($(\"#stuid option:selected\").val()))\r\n");
      out.write("\t\t        +\"&performance.study=\"+encodeURI(encodeURI($(\"#study\").val()))\r\n");
      out.write("\t\t        +\"&performance.dailylife=\"+encodeURI(encodeURI($(\"#dailylife\").val()))\r\n");
      out.write("\t\t        +\"&performance.event=\"+encodeURI(encodeURI($(\"#event\").val()))\r\n");
      out.write("\t\t        +\"&performance.outstanding=\"+encodeURI(encodeURI($(\"#outstanding\").val()))\r\n");
      out.write("\t\t        +\"&performance.psychicology=\"+encodeURI(encodeURI($(\"#psychicology\").val()))\r\n");
      out.write("\t\t        +\"&performance.remark=\"+encodeURI(encodeURI($(\"#remark\").val()))\t\t  \r\n");
      out.write("\t\t        ,null,function(){\r\n");
      out.write("\t\t        //alert('添加成功!');\r\n");
      out.write("\t\t        parent.m.hide();\r\n");
      out.write("\t\t        parent.window.location.reload();\r\n");
      out.write("\t\t       });\t \r\n");
      out.write("\t\t       }\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t }\t\t\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\t$(\"form\").ligerForm();\r\n");
      out.write("\t\t$(\".l-button-test\").click(function() {\r\n");
      out.write("\t\t\talert(v.element($(\"#txtName\")));\r\n");
      out.write("\t\t});\r\n");
      out.write("\t});\t\r\n");
      out.write("\tvar flg = false;\r\n");
      out.write("    function check() {\t\r\n");
      out.write("     var stuname = $(\"#stuid\").val();\r\n");
      out.write("     if(stuname.length==0){\r\n");
      out.write("       $(\"#result\").html(\"学生姓名不能为空!\");\t\t\t\t\t\t\r\n");
      out.write("\t   $(\"#result\").show();\t\r\n");
      out.write("\t    flg = false;\r\n");
      out.write("     }else{\r\n");
      out.write("         $(\"#result\").hide();\r\n");
      out.write("\t\t flg = true;\t\r\n");
      out.write("        /* $.post(\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/system/Stu_stucheckname.action?stu.stuname=\"\r\n");
      out.write("\t\t\t\t\t+ encodeURI(encodeURI($(\"#stuid\").val())), null, function(data) {\r\n");
      out.write("\t\t\t\t\tif (data == \"fail\") {\r\n");
      out.write("\t\t\t\t\t    $(\"#result\").html(\"该学生姓名不存在!\");\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t$(\"#result\").show();\t\r\n");
      out.write("\t\t\t\t\t\tflg = false;\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t} else {\t\t\t\t\t   \r\n");
      out.write("\t\t\t\t\t\t$(\"#result\").hide();\r\n");
      out.write("\t\t\t\t\t\tflg = true;\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t});\t */\t\t\r\n");
      out.write("     }   \t\t\t\t\r\n");
      out.write("\t}\t\r\n");
      out.write("\tvar flg1=false;\r\n");
      out.write("\tfunction check1(){\r\n");
      out.write("\t   var event = $(\"#event\").val();\r\n");
      out.write("\t   var study = $(\"#study\").val();\r\n");
      out.write("\t   var dailylife = $(\"#dailylife\").val();\r\n");
      out.write("\t   var outstanding = $(\"#outstanding\").val();\r\n");
      out.write("\t   var psychicology = $(\"#psychicology\").val();\r\n");
      out.write("\t   if(event.length==0||dailylife.length==0||outstanding.length==0||psychicology.length==0){\r\n");
      out.write("\t     $(\"#result1\").html(\"各项表现不能为空！\");\r\n");
      out.write("\t     $(\"#result1\").show();\r\n");
      out.write("\t     flg1=false;\r\n");
      out.write("\t   }else{\r\n");
      out.write("\t      $(\"#result1\").hide();\r\n");
      out.write("\t      flg1=true;\r\n");
      out.write("\t   }\r\n");
      out.write("\t}\r\n");
      out.write("\t function checkstu(){\r\n");
      out.write("\t  var classid = $(\"#classid option:selected\").val();\r\n");
      out.write(" \t\tvar url = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/system/Class_classStuList.action?cls.id=\" + classid;\r\n");
      out.write("\t\t$.ajax({  \r\n");
      out.write("\t        type : \"POST\",  \r\n");
      out.write("\t        url : url,\r\n");
      out.write("\t        dataType : \"JSON\", \r\n");
      out.write("\t        error: function (){\r\n");
      out.write("\t        \t;\r\n");
      out.write("\t        },\r\n");
      out.write("\t        success : function(data) {\r\n");
      out.write("\t        \t$(\"#stuid\").empty(); \r\n");
      out.write("\t        \tif (data.length > 0){\r\n");
      out.write("\t        \t    document.getElementById(\"stuid\").options.add(new Option('',''));\r\n");
      out.write("\t        \t\tfor(var n=0;n<data.length;n++){\r\n");
      out.write("\t        \t\t   document.getElementById(\"stuid\").options.add(new Option(data[n].stuname,data[n].passport));\r\n");
      out.write("\t          \t\t} \r\n");
      out.write("\t        \t} else {\r\n");
      out.write("\t        \t}\r\n");
      out.write("\t        }  \r\n");
      out.write("\t    }); \r\n");
      out.write("\t} \t\r\n");
      out.write("</script>\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write("body{ font-size:12px;}\r\n");
      out.write(".l-table-edit {}\r\n");
      out.write(".l-table-edit-td{ padding:4px;}\r\n");
      out.write(".l-button-submit,.l-button-test{width:80px; float:left; margin-left:10px; padding-bottom:2px;}\r\n");
      out.write(".l-verify-tip{ left:230px; top:120px;}\r\n");
      out.write("#errorLabelContainer{ padding:10px; width:300px; border:1px solid #FF4466; display:none; background:#FFEEEE; color:Red;}\r\n");
      out.write("\r\n");
      out.write("table{\r\n");
      out.write("  text-align: center;\r\n");
      out.write("}\r\n");
      out.write("textarea {\r\n");
      out.write("\twidth: 220px;\r\n");
      out.write("\theight:70px;\r\n");
      out.write("\tfont-size: 12px;\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body style=\"padding: 10px\">\r\n");
      out.write("<div align=\"center\"><strong><font size=\"3\">平时表现</font></strong>\t</div><br/>\r\n");
      out.write("<form name=\"form1\" method=\"post\" action=\"\" id=\"form1\">\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<table cellpadding=\"0\" cellspacing=\"0\" class=\"l-table-edit\">\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td align=\"right\" >班级:<font color=\"#ff0000\">*</font></td>\r\n");
      out.write("\t\t\t\t<td align=\"left\" class=\"l-table-edit-td\">\r\n");
      out.write("\t\t\t\t   <select id=\"classid\" onchange=\"checkstu()\" >\r\n");
      out.write("\t\t\t        <option value=\"\" ></option>\r\n");
      out.write("\t\t\t        ");
      if (_jspx_meth_s_005fiterator_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t\t      </select>\r\n");
      out.write("\t\t\t\t</td>\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t<td align=\"right\" >姓名:<font color=\"#ff0000\">*</font></td>\r\n");
      out.write("\t\t\t\t<td align=\"left\" class=\"l-table-edit-td\">\r\n");
      out.write("\t\t\t\t <select id=\"stuid\" name=\"stuid\" type=\"select\" style=\"width:120px;\" onchange=\"check()\" ></select>\t\t\t\t\r\n");
      out.write("\t\t\t\t</td>\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td align=\"right\" class=\"l-table-edit-td\" >学习方面:<font color=\"#ff0000\">*</font></td>\r\n");
      out.write("\t\t\t\t<td align=\"left\" class=\"l-table-edit-td\"><textarea id=\"study\" onchange=\"check1()\" ></textarea> </td>\t\t\t\r\n");
      out.write("\t\t\t    <td class=\"l-table-edit-td\">生活方面：<font color=\"#ff0000\">*</font></td>\r\n");
      out.write("\t\t\t    <td class=\"l-table-edit-td\"><textarea id=\"dailylife\" onchange=\"check1()\" ></textarea></td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t   <td class=\"l-table-edit-td\">活动能力：<font color=\"#ff0000\">*</font></td>\r\n");
      out.write("\t\t\t   <td class=\"l-table-edit-td\"><textarea id=\"event\" onchange=\"check1()\" ></textarea></td>\r\n");
      out.write("\t\t\t   <td class=\"l-table-edit-td\">突出表现：<font color=\"#ff0000\">*</font></td>\r\n");
      out.write("\t\t\t  <td class=\"l-table-edit-td\"><textarea id=\"outstanding\" onchange=\"check1()\"  ></textarea></td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t  <td class=\"l-table-edit-td\">心理：<font color=\"#ff0000\">*</font></td>\r\n");
      out.write("\t\t\t  <td class=\"l-table-edit-td\"><textarea id=\"psychicology\" onchange=\"check1()\" ></textarea></td>\r\n");
      out.write("\t\t\t  <td class=\"l-table-edit-td\">备注：</td>\r\n");
      out.write("\t\t\t  <td class=\"l-table-edit-td\"><textarea id=remark ></textarea></td>\r\n");
      out.write("\t\t\t</tr>\t\t\t \t\t\t\t\t\t\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<th align=\"center\" class=\"l-table-edit-td\"colspan=\"3\"><div id=\"result\" style=\"color: red;\"></div><div id=\"result1\" style=\"color: red;\"></div></th>\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td align=\"right\" class=\"l-table-edit-td\"></td>\t\r\n");
      out.write("\t\t\t\t<td align=\"right\" class=\"l-table-edit-td\"></td>\t\t\t\t\t\t\t\t \r\n");
      out.write("\t\t\t\t<td align=\"right\" class=\"l-table-edit-td\"><input type=\"submit\" value=\"添&nbsp;&nbsp;加\" id=\"Button1\" class=\"l-button l-button-submit\" /></td>\r\n");
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

  private boolean _jspx_meth_s_005fiterator_005f0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  s:iterator
    org.apache.struts2.views.jsp.IteratorTag _jspx_th_s_005fiterator_005f0 = (org.apache.struts2.views.jsp.IteratorTag) _005fjspx_005ftagPool_005fs_005fiterator_005fvalue_005fid.get(org.apache.struts2.views.jsp.IteratorTag.class);
    _jspx_th_s_005fiterator_005f0.setPageContext(_jspx_page_context);
    _jspx_th_s_005fiterator_005f0.setParent(null);
    // /WEB-INF/student/performanceadd.jsp(171,11) name = value type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_s_005fiterator_005f0.setValue("#classlist");
    // /WEB-INF/student/performanceadd.jsp(171,11) name = id type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
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
        out.write("\t\t\t          <option value=\"");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${c.id }", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
        out.write('"');
        out.write(' ');
        out.write('>');
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${c.classname }", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
        out.write("</option>\r\n");
        out.write("\t\t\t        ");
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
}
