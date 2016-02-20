package org.apache.jsp.WEB_002dINF.student;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;

public final class changeimg_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fs_005fform_005fnamespace_005fmethod_005fid_005fenctype_005faction_005facceptcharset;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fs_005fform_005fnamespace_005fmethod_005fid_005fenctype_005faction_005facceptcharset = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fs_005fform_005fnamespace_005fmethod_005fid_005fenctype_005faction_005facceptcharset.release();
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
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">\r\n");
      out.write("<html>\r\n");
      out.write("  <head>\r\n");
      out.write("    <base href=\"");
      out.print(basePath);
      out.write("\">\r\n");
      out.write("    \r\n");
      out.write("    <title></title>\r\n");
      out.write("<link href=\"");
      out.print(basePath);
      out.write("js/ligerUI/skins/Gray/css/common.css\"rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("<script src=\"");
      out.print(basePath);
      out.write("js/jquery/jquery-1.6.min.js\"type=\"text/javascript\"></script>\r\n");
      out.write("<script src=\"");
      out.print(basePath);
      out.write("js/ligerUI/core/base.js\"type=\"text/javascript\"></script>\r\n");
      out.write("<script src=\"");
      out.print(basePath);
      out.write("js/ligerUI/plugins/ligerForm.js\"type=\"text/javascript\"></script>\r\n");
      out.write("<script src=\"");
      out.print(basePath);
      out.write("js/ligerUI/plugins/ligerDateEditor.js\"type=\"text/javascript\"></script>\r\n");
      out.write("<script src=\"");
      out.print(basePath);
      out.write("js/ligerUI/plugins/ligerComboBox.js\"type=\"text/javascript\"></script>\r\n");
      out.write("<script src=\"");
      out.print(basePath);
      out.write("js/ligerUI/plugins/ligerSpinner.js\"type=\"text/javascript\"></script>\r\n");
      out.write("<script src=\"");
      out.print(basePath);
      out.write("js/ligerUI/plugins/ligerTextBox.js\"type=\"text/javascript\"></script>\r\n");
      out.write("\r\n");
      out.write("<script src=\"");
      out.print(basePath);
      out.write("js/ligerUI/plugins/ligerTip.js\"type=\"text/javascript\"></script>\r\n");
      out.write("<script src=\"");
      out.print(basePath);
      out.write("js/jquery-validation/jquery.validate.min.js\"type=\"text/javascript\"></script>\r\n");
      out.write("<script src=\"");
      out.print(basePath);
      out.write("js/jquery-validation/jquery.metadata.js\"type=\"text/javascript\"></script>\r\n");
      out.write("<script src=\"");
      out.print(basePath);
      out.write("js/jquery-validation/messages_cn.js\"type=\"text/javascript\"></script>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("  $(function(){\r\n");
      out.write("\t\t$(\"input[type=file]\").change(function(){\r\n");
      out.write("\t\t\t$(this).parents(\".uploader\").find(\".filename\").val($(this).val());\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\t$(\"input[type=file]\").each(function(){\r\n");
      out.write("\t\t\tif ($(this).val() == \"\") {\r\n");
      out.write("\t\t\t\t$(this).parents(\".uploader\").find(\".filename\").val(\"请选择文件...\");\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t});\r\n");
      out.write("\t});\r\n");
      out.write("</script>\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write("body{font-size: 14px;}\r\n");
      out.write("\r\n");
      out.write(".uploader { position:relative; display:inline-block; overflow:hidden; cursor:default; padding:0; margin:10px 0px; -moz-box-shadow:0px 0px 5px #ddd; -webkit-box-shadow:0px 0px 5px #ddd; box-shadow:0px 0px 5px #ddd; -moz-border-radius:5px; -webkit-border-radius:5px; border-radius:5px; }\r\n");
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
      out.write("\r\n");
      out.write("</style>\r\n");
      out.write("  </head>\r\n");
      out.write("  \r\n");
      out.write("  <body>\r\n");
      out.write("    <p style=\"margin:10px 10px;\">上传自己的真实照片(小于3M，照片名称请用学号)</p>\r\n");
      out.write("\t\t\t");
      if (_jspx_meth_s_005fform_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t\t\r\n");
      out.write("  </body>\r\n");
      out.write("</html>\r\n");
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

  private boolean _jspx_meth_s_005fform_005f0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  s:form
    org.apache.struts2.views.jsp.ui.FormTag _jspx_th_s_005fform_005f0 = (org.apache.struts2.views.jsp.ui.FormTag) _005fjspx_005ftagPool_005fs_005fform_005fnamespace_005fmethod_005fid_005fenctype_005faction_005facceptcharset.get(org.apache.struts2.views.jsp.ui.FormTag.class);
    _jspx_th_s_005fform_005f0.setPageContext(_jspx_page_context);
    _jspx_th_s_005fform_005f0.setParent(null);
    // /WEB-INF/student/changeimg.jsp(79,3) name = action type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_s_005fform_005f0.setAction("Stu_changeimg");
    // /WEB-INF/student/changeimg.jsp(79,3) name = acceptcharset type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_s_005fform_005f0.setAcceptcharset("UTF-8");
    // /WEB-INF/student/changeimg.jsp(79,3) name = enctype type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_s_005fform_005f0.setEnctype("multipart/form-data");
    // /WEB-INF/student/changeimg.jsp(79,3) name = method type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_s_005fform_005f0.setMethod("post");
    // /WEB-INF/student/changeimg.jsp(79,3) name = namespace type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_s_005fform_005f0.setNamespace("/system");
    // /WEB-INF/student/changeimg.jsp(79,3) name = id type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_s_005fform_005f0.setId("form1");
    int _jspx_eval_s_005fform_005f0 = _jspx_th_s_005fform_005f0.doStartTag();
    if (_jspx_eval_s_005fform_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      if (_jspx_eval_s_005fform_005f0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.pushBody();
        _jspx_th_s_005fform_005f0.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
        _jspx_th_s_005fform_005f0.doInitBody();
      }
      do {
        out.write("\r\n");
        out.write("\t\t<table align=\"center\">\r\n");
        out.write("\t\t\t<tr>\r\n");
        out.write("\t\t\t\t<td><div class=\"uploader white\">\r\n");
        out.write("\t\t\t\t\t\t<input type=\"text\" class=\"filename\" readonly /> \r\n");
        out.write("\t\t\t\t\t\t<input accept=\"\" type=\"button\" class=\"button\" value=\"上传...\" />\r\n");
        out.write("\t\t\t\t\t    <input type=\"file\"name=\"image\" size=\"30\" />\r\n");
        out.write("\t\t\t\t\t</div></td>\r\n");
        out.write("\t\t\t</tr>\r\n");
        out.write("\t\t\t<tr><td align=\"center\" ><br><input type=\"submit\" class=\"l-submit\" value=\"提&nbsp;&nbsp;交\" /></td></tr>\r\n");
        out.write("\t\t</table>\t\t\t\t\t\r\n");
        out.write("\t\t\t");
        int evalDoAfterBody = _jspx_th_s_005fform_005f0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
      if (_jspx_eval_s_005fform_005f0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.popBody();
      }
    }
    if (_jspx_th_s_005fform_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fs_005fform_005fnamespace_005fmethod_005fid_005fenctype_005faction_005facceptcharset.reuse(_jspx_th_s_005fform_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fs_005fform_005fnamespace_005fmethod_005fid_005fenctype_005faction_005facceptcharset.reuse(_jspx_th_s_005fform_005f0);
    return false;
  }
}
