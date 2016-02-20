package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;

public final class error_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html;charset=utf-8");
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
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">\r\n");
      out.write("<html>\r\n");
      out.write("  <head>\r\n");
      out.write("    <title>error.html</title>\r\n");
      out.write("\t\r\n");
      out.write("    <meta http-equiv=\"keywords\" content=\"keyword1,keyword2,keyword3\">\r\n");
      out.write("    <meta http-equiv=\"description\" content=\"this is my page\">\r\n");
      out.write("    <meta http-equiv=\"content-type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("    <script src=\"");
      out.print(basePath);
      out.write("js/jquery/jquery-1.3.2.min.js\"type=\"text/javascript\"></script>\r\n");
      out.write("    <script src=\"");
      out.print(basePath);
      out.write("js/ligerUI/core/base.js\"type=\"text/javascript\"></script>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("  var i = 5;\r\n");
      out.write("\tvar intervalid;\r\n");
      out.write("\tintervalid = setInterval(\"fun()\", 1000);\r\n");
      out.write("\tfunction fun(){\r\n");
      out.write("\t\tif (i == 0) {\r\n");
      out.write("\t\t\ttop.f_closeTab();\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tdocument.getElementById(\"mes\").innerHTML = i;\r\n");
      out.write("\t\ti--;\r\n");
      out.write("\t}\r\n");
      out.write("  function tabclose(){\r\n");
      out.write("   top.f_closeTab();\r\n");
      out.write("  }\r\n");
      out.write("</script>   \r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write("div {\r\n");
      out.write("\tmargin:0 auto;\r\n");
      out.write("\tpadding:0;\r\n");
      out.write("}\r\n");
      out.write("a{\r\n");
      out.write("\tcursor:pointer;\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("  </head>\r\n");
      out.write("  \r\n");
      out.write("  <body onload=\"fun()\" >\r\n");
      out.write("     <div style=\"border:0px solid #000;width: 600px;height: 300px;background-color: #fff;margin-top: 100px\" >\r\n");
      out.write("    <div>\r\n");
      out.write("     <img alt=\"\" src=\"");
      out.print(basePath );
      out.write("images/ku.jpg\"></img>\r\n");
      out.write("     额。。。您是少数来到这里的人之一！\r\n");
      out.write("     </div>\r\n");
      out.write("      <br>\r\n");
      out.write("     <div style=\"padding-left: 100px\">\r\n");
      out.write("         事情是这样的，您遇到了一点小麻烦，您访问的页面似乎不存在了。\r\n");
      out.write("     </div>\r\n");
      out.write("      <br>\r\n");
      out.write("     <div style=\"padding-left: 100px\">\r\n");
      out.write("     您可以直接回到<a onclick=\"tabclose()\" ><font style=\"color: blue\">首页</font></a>继续浏览其他内容。\r\n");
      out.write("     </div>\r\n");
      out.write("      <br>\r\n");
      out.write("     <div style=\"padding-left: 100px\">\r\n");
      out.write("     当然，您也可以什么都不做，\r\n");
      out.write(" <span id=\"mes\" style=\"color:red;\"><br>5</span>s 后我们将送您回到首页。<br/>\r\n");
      out.write("   <br> 谢谢您的访问！\r\n");
      out.write("     </div>\r\n");
      out.write("      </div>\r\n");
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
}
