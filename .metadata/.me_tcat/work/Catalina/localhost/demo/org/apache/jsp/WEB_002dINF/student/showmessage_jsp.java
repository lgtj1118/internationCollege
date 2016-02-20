package org.apache.jsp.WEB_002dINF.student;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;

public final class showmessage_jsp extends org.apache.jasper.runtime.HttpJspBase
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
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\r\n");
      out.write("<html xmlns=\"http://www.w3.org/1999/xhtml\">\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\r\n");
      out.write("<title>系统消息</title>\r\n");
      out.write("<script src=\"");
      out.print(basePath);
      out.write("easyui/jquery-1.6.min.js\"\r\n");
      out.write("\t\t\ttype=\"text/javascript\"></script>\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write(".regis{\r\n");
      out.write("\theight: 220px;\r\n");
      out.write("\twidth: 390px;\r\n");
      out.write("\tbackground-color: #FFF;\r\n");
      out.write("\tborder: #999 1px solid;\r\n");
      out.write("\tbox-shadow: 10px 10px 5px #888888;\r\n");
      out.write("\tmargin-top:50px;\r\n");
      out.write("}\r\n");
      out.write(".TAN_cb {\r\n");
      out.write("width: 200px;\r\n");
      out.write("height: 30px;\r\n");
      out.write("display: block;\r\n");
      out.write("background: url(");
      out.print(basePath);
      out.write("images/11.png) 0 -30px no-repeat;\r\n");
      out.write("color: #fff;\r\n");
      out.write("font-size: 20px;\r\n");
      out.write("text-align: center;\r\n");
      out.write("padding-top: 12px;\r\n");
      out.write("margin: 10px 0 0 0;\r\n");
      out.write("text-decoration:none;\r\n");
      out.write("cursor:pointer;\r\n");
      out.write("\r\n");
      out.write("}\r\n");
      out.write(".z{\r\n");
      out.write("\tmargin-top:45px;\r\n");
      out.write("\t}\r\n");
      out.write("</style>\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("function validate(){\r\n");
      out.write("\ttop.f_closeTab();\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("<div>\r\n");
      out.write("<center><div class=\"regis\">\r\n");
      out.write("  <div style=\"margin-top:0px width:100%; height:40px;border-bottom: 1px solid #DADADA;\">\r\n");
      out.write("<center><p style=\"font-size: 30px\">系统消息</p></center></div>\r\n");
      out.write("       \r\n");
      out.write("    <center>\r\n");
      out.write("    <div class=\"z\" name=\"login\">\r\n");
      out.write("    <div align=\"center\" style=\"font-size: 25px;color: red\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${message }", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("</div>\r\n");
      out.write("    </div>\r\n");
      out.write("    <div>\r\n");
      out.write("  <div id=\"loginButton\" class=\"TAN_cb\" onclick=\"validate()\" style=\"margin-top:20px\">我知道了</div>\r\n");
      out.write("    </div>\r\n");
      out.write("    </center>\r\n");
      out.write("</div>\r\n");
      out.write("</center>\r\n");
      out.write("\r\n");
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
}
