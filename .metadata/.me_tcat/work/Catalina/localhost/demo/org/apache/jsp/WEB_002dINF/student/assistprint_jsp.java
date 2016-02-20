package org.apache.jsp.WEB_002dINF.student;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;

public final class assistprint_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("    <title>天津工业大学国际教育学院助理班主任报名表</title>\r\n");
      out.write("\t<script type=\"text/javascript\" src=\"js/jquery/jquery-1.4.4.min.js\" ></script>\r\n");
      out.write("\t<script type=\"text/javascript\" src=\"js/jquery.jqprint-0.3.js\" ></script>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("   function tabclose(){\r\n");
      out.write("     window.close();\r\n");
      out.write("   }\r\n");
      out.write("   function tabprint(){\r\n");
      out.write("     $(\"#contain\").jqprint();\r\n");
      out.write("     \r\n");
      out.write("   }\r\n");
      out.write("</script>\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write("#contain{\r\n");
      out.write("  height: 100%;\r\n");
      out.write("  width:80%;\r\n");
      out.write("  margin:auto;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("</style>\r\n");
      out.write("  </head>\r\n");
      out.write("  \r\n");
      out.write("  <body>\r\n");
      out.write("  <div id=\"head\" ><input align=\"center\" type=\"button\" value=\"关&nbsp;&nbsp;闭\" onclick=\"tabclose()\" ><input type=\"button\" value=\"打&nbsp;&nbsp;印\" onclick=\"tabprint()\" ></div>   \r\n");
      out.write("   <div id=\"contain\" ><h2 align=\"center\">天津工业大学国际教育学院助理班主任报名表</h2>\r\n");
      out.write("   <table  border=\"1\" cellspacing=\"0\" cellpadding=\"0\" height=\"90%\" width=\"90%\" align=\"center\" >\r\n");
      out.write("      <div height=\"30%\" >\r\n");
      out.write("      <tr><td align=\"center\">姓名</td><td align=\"center\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${assistteacher.name }", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("</td><td align=\"center\">性别</td><td align=\"center\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${assistteacher.gender }", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("</td><td align=\"center\">出生年月</td><td align=\"center\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${assistteacher.brithdate }", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("</td><th rowspan=\"4\"  height=\"40\"  style=\"font-weight: normal;\">（免冠照片）</th></tr>\r\n");
      out.write("      <tr><td align=\"center\">政治面貌</td><td align=\"center\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${assistteacher.politicalstatus }", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("</td><td align=\"center\">民族</td><td align=\"center\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${assistteacher.nation }", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("</td><td align=\"center\">层次（本/硕）</td><td align=\"center\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${assistteacher.edulevel }", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("</td></tr>\r\n");
      out.write("      <tr><td align=\"center\">学院</td><td align=\"center\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${assistteacher.department }", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("</td><td align=\"center\">专业</td><td>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${assistteacher.major }", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("</td><td align=\"center\">班级</td><td>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${assistteacher.classname }", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("</td></tr>\r\n");
      out.write("      <tr><td align=\"center\">学号</td><td align=\"center\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${assistteacher.assistantnum }", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("</td><td align=\"center\">外语语种</td><td align=\"center\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${assistteacher.secondlanguagetype }", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("</td><td align=\"center\">特长</td><td >");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${assistteacher.forte }", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("</td></tr>     \r\n");
      out.write("      <tr><td align=\"center\">外语水平</td><td align=\"center\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${assistteacher.secondlanguagelevel }", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("</td><th colspan=\"2\" style=\"font-weight: normal;\" align=\"center\">联系方式（手机）</th><td align=\"center\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${assistteacher.telephone }", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("</td><td align=\"center\">邮箱地址</td><td align=\"center\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${assistteacher.email }", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("</td></tr></div>\r\n");
      out.write("      <tr><th colspan=\"7\" align=\"left\"><span style=\"font-weight: normal;\"><br>学院推荐（或推荐人）意见：</span><br><br><br><br><br><br> \r\n");
      out.write("\t\t\t\t\t<div align=\"center\"><span style=\"font-family: 楷体; font-size: 12pt; font-weight: normal;\">学院领导（或推荐人）签字：</span><br></div><br><span style=\"font-family: 楷体; font-size: 12pt;\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 年&nbsp;&nbsp;&nbsp;月&nbsp;&nbsp;日</span><br></th></tr>\r\n");
      out.write("      <tr><th colspan=\"7\" align=\"left\"><span style=\"font-weight: normal;\"><br>国际教育学院意见：</span><br><br><br><br><br><br> \r\n");
      out.write("\t\t\t\t\t<div align=\"center\"><span style=\"font-family: 楷体; font-size: 12pt; font-weight: normal;\">学院领导（或推荐人）签字：</span><br></div><br><span style=\"font-family: 楷体; font-size: 12pt;\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 年&nbsp;&nbsp;&nbsp;月&nbsp;&nbsp;日</span><br></th></tr>\r\n");
      out.write("   </table>\r\n");
      out.write("   </div>\r\n");
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
