package org.apache.jsp.upload;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;

public final class uploadmsg_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\r\n");
      out.write("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">\r\n");
      out.write("<html>\r\n");
      out.write("  <head>\r\n");
      out.write("    <base href=\"");
      out.print(basePath);
      out.write("\">\r\n");
      out.write("    \r\n");
      out.write("    <title>msg</title>\r\n");
      out.write("<link href=\"");
      out.print(basePath);
      out.write("js/ligerUI/skins/Gray/css/form.cssrel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("<link href=\"");
      out.print(basePath);
      out.write("js/ligerUI/skins/Gray/css/common.css\"rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("<script src=\"");
      out.print(basePath);
      out.write("js/jquery/jquery-1.3.2.min.js\"type=\"text/javascript\"></script>\r\n");
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
      out.write("js/ligerUI/plugins/ligerDialog.js\"type=\"text/javascript\"></script>\r\n");
      out.write("<script src=\"");
      out.print(basePath);
      out.write("js/ligerUI/plugins/ligerDrag.js\"type=\"text/javascript\"></script>\r\n");
      out.write("<script src=\"");
      out.print(basePath);
      out.write("js/ligerUI/plugins/ligerSpinner.js\"type=\"text/javascript\"></script>\r\n");
      out.write("<script src=\"");
      out.print(basePath);
      out.write("js/ligerUI/plugins/ligerTextBox.js\"type=\"text/javascript\"></script>\r\n");
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
      out.write("    /* var i = 5;\r\n");
      out.write("\tvar intervalid;\r\n");
      out.write("\tintervalid = setInterval(\"fun()\", 1000);\r\n");
      out.write("\tfunction fun(){\r\n");
      out.write("\t\tif (i == 0) {\r\n");
      out.write("\t\t\tparent.m.hide();\r\n");
      out.write("\t\t\tparent.g.loadData();\r\n");
      out.write("\t\t\t//top.f_closeTab();\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tdocument.getElementById(\"mes\").innerHTML = i;\r\n");
      out.write("\t\ti--;\r\n");
      out.write("\t} */\r\n");
      out.write("\tfunction tabclose(){\r\n");
      out.write("\t   parent.m.hide();\r\n");
      out.write("\t   parent.g.loadData();\r\n");
      out.write("\t  // top.f_closeTab();\r\n");
      out.write("\t}\r\n");
      out.write("</script>\r\n");
      out.write("  </head>\r\n");
      out.write("  \r\n");
      out.write("  <body >  \r\n");
      out.write("      <div style=\"margin-top: 20%;font-size: 20px\"align=\"center\"> <br>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${msg }", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("</div>  \r\n");
      out.write("   <div align=\"center\"  ><font size=\"4\"><span id=\"mes\" style=\"color: rgb(0, 0, 0);\"><br></span><span id=\"mes1\" style=\"color: rgb(0, 0, 0);cursor: pointer;\"><font color=\"#ff0000\"><u><a o=\"\" onclick=\"tabclose()\">关闭</a></u></font></span></font></div>\r\n");
      out.write("  </body>\r\n");
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
