package org.apache.jsp.WEB_002dINF.course;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;

public final class tabcourseattendenceload_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write('\r');
      out.write('\n');

	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";

      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\r\n");
      out.write("\r\n");
      out.write("<html xmlns=\"http://www.w3.org/1999/xhtml\">\r\n");
      out.write("<head>\r\n");
      out.write("<title></title>\r\n");
      out.write("<link href=\"");
      out.print(basePath);
      out.write("js/ligerUI/skins/Aqua/css/ligerui-all.css\" rel=\"stylesheet\"type=\"text/css\" />\r\n");
      out.write("<link href=\"");
      out.print(basePath);
      out.write("js/ligerUI/skins/Gray/css/all.css\" rel=\"stylesheet\"type=\"text/css\" />\r\n");
      out.write(" <script src=\"");
      out.print(basePath);
      out.write("js/jquery/jquery-1.6.min.js\" type=\"text/javascript\"></script>\r\n");
      out.write("<script src=\"");
      out.print(basePath);
      out.write("js/ligerUI/core/base.js\" type=\"text/javascript\"></script>\r\n");
      out.write("<script src=\"");
      out.print(basePath);
      out.write("js/ligerUI/plugins/ligerTab.js\" type=\"text/javascript\"></script>\r\n");
      out.write("<script src=\"");
      out.print(basePath);
      out.write("js/ligerUI/pluginsligerForm.js\" type=\"text/javascript\"></script>\r\n");
      out.write("<script src=\"");
      out.print(basePath);
      out.write("js/ligerUI/pluginsligerComboBox.js\" type=\"text/javascript\"></script>\r\n");
      out.write("<script src=\"");
      out.print(basePath);
      out.write("js/ligerUI/pluginsligerSpinner.js\" type=\"text/javascript\"></script>\r\n");
      out.write("<script src=\"");
      out.print(basePath);
      out.write("js/ligerUI/pluginsligerTextBox.js\" type=\"text/javascript\"></script>\r\n");
      out.write("<script src=\"");
      out.print(basePath);
      out.write("js/ligerUI/pluginsligerTip.js\" type=\"text/javascript\"></script>\r\n");
      out.write("<script type=\"text/javascript\">\t\r\n");
      out.write("  $(function (){ $(\"#navtab1\").ligerTab();});\r\n");
      out.write("</script>\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write(".l-verify-tip {\r\n");
      out.write("\tleft: 230px;\r\n");
      out.write("\ttop: 120px;\r\n");
      out.write("}\r\n");
      out.write("body {\r\n");
      out.write("\tfont-size: 14px;\r\n");
      out.write("\twidth: 99.9%;\r\n");
      out.write("\theight:99.9%;\r\n");
      out.write("}\r\n");
      out.write(".l-table-edit-td {\r\n");
      out.write("\tpadding: 4px;\r\n");
      out.write("}\r\n");
      out.write(".s {\r\n");
      out.write("\twidth: 61px;\r\n");
      out.write("\theight: 18px;\r\n");
      out.write("\tdisplay: inline-block;\r\n");
      out.write("\tbackground-color: #eeeeee;\r\n");
      out.write("\ttext-align: center;\r\n");
      out.write("\tfont-size: 13px;\r\n");
      out.write("}\r\n");
      out.write(".l-button-submit,.l-button-test {\r\n");
      out.write("\twidth: 60px;\r\n");
      out.write("\tfloat: left;\r\n");
      out.write("\tmargin-left: 10px;\r\n");
      out.write("\tpadding-bottom: 2px;\r\n");
      out.write("}\r\n");
      out.write(".l-verify-tip {\r\n");
      out.write("\tleft: 230px;\r\n");
      out.write("\ttop: 120px;\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("</head>\r\n");
      out.write("<body >    \r\n");
      out.write("\t<div id=\"navtab1\"style=\"width: 100%;   \">\r\n");
      out.write("\t\t<div tabid=\"home\"  title=\"考勤记录\" lselected=\"true\" style=\"height:620px\"  >\r\n");
      out.write("\t\t\t<iframe frameborder=\"0\" name=\"ifream1\" id=\"ifream1\"\r\n");
      out.write("\t\t\t\tsrc=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/system/Manage_courseattendenceload.action?course.num=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${courseid}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\"></iframe>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t\t<div title=\"考勤统计\" style=\"height:620px;\">\t\t\t\r\n");
      out.write("\t\t\t\t<iframe frameborder=\"1\" name=\"ifream2\"  id=\"ifream2\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/system/Manage_courseattendenceclass.action?course.num=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${courseid}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\"></iframe>\t\t\t\r\n");
      out.write("\t\t    </div>\t\t \t\t  \r\n");
      out.write("\t</div>\t\t\t\r\n");
      out.write("</body>\r\n");
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
}
