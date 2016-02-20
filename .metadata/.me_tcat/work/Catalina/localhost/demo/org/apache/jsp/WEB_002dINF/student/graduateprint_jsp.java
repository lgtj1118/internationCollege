package org.apache.jsp.WEB_002dINF.student;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;

public final class graduateprint_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\t<script type=\"text/javascript\" src=\"js/jquery/jquery-1.4.4.min.js\" ></script>\r\n");
      out.write("\t<script type=\"text/javascript\" src=\"js/jquery.jqprint-0.3.js\" ></script>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("   function tabclose(){\r\n");
      out.write("     top.f_closeTab();\r\n");
      out.write("   }\r\n");
      out.write("   function tabprint(){\r\n");
      out.write("     $(\"#contain\").jqprint();\r\n");
      out.write("     \r\n");
      out.write("   }\r\n");
      out.write("</script>\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write("table{\r\n");
      out.write("  border: 1px solid #000 ;\r\n");
      out.write("  width:800px;\r\n");
      out.write("  margin: auto;\r\n");
      out.write("\r\n");
      out.write("}\r\n");
      out.write("#head{\r\n");
      out.write(" margin: auto;\r\n");
      out.write(" }\r\n");
      out.write("table td {\r\n");
      out.write("  border: 0px solid #000 ;\r\n");
      out.write("}\r\n");
      out.write("table th {\r\n");
      out.write("  border: 0px solid #000 ;\r\n");
      out.write("}\r\n");
      out.write(".content{\r\n");
      out.write(" margin:10px 20px 20px;\r\n");
      out.write(" margin:auto;\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("</head>  \r\n");
      out.write("  <body  >\r\n");
      out.write("    <div id=\"head\" ><input align=\"center\" type=\"button\" value=\"关&nbsp;&nbsp;闭\" onclick=\"tabclose()\" ><input type=\"button\" value=\"打&nbsp;&nbsp;印\" onclick=\"tabprint()\" ></div>   \r\n");
      out.write("    <div id=\"contain\">\r\n");
      out.write("    <table class=\"content\" >\r\n");
      out.write("       <tbody>\r\n");
      out.write("          <tr><td valign=\"top\"><br></td><th align=\"center\" colspan=\"10\" ><strong>普 通 高 等 学 校</strong></th><th rowspan=\"2\" colspan=\"5\" ><img src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write('/');
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${student.imgurl }", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\" style=\"margin-top: 20px;margin-bottom:20px; width: 120px;height:150px;\" ></th><td valign=\"top\"><br></td></tr>\r\n");
      out.write("          <tr align=\"center\"><td valign=\"top\"><br></td><th colspan=\"10\" ><font size=\"7\" face=\"隶书\" color=\"#ff0000\">毕 业 证 书</font></th><td valign=\"top\"><br></td></tr>\r\n");
      out.write("          <tr height=\"50px\" ><td valign=\"top\"><br></td><th align=\"center\" colspan=\"6\" style=\"font-weight: normal;\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${student.firstname }", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("&nbsp;");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${student.lastname }", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("</th><th align=\"center\" colspan=\"4\" >");
      if (_jspx_meth_s_005fif_005f0(_jspx_page_context))
        return;
      if (_jspx_meth_s_005felseif_005f0(_jspx_page_context))
        return;
      out.write("，<strong>国籍</strong></th><th align=\"center\" colspan=\"4\" style=\"font-weight: normal;\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${student.nation }", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("</th><td valign=\"top\"><br></td><td valign=\"top\"><br></td></tr>\r\n");
      out.write("          <tr align=\"center\" height=\"50px\"><td valign=\"top\">&nbsp;<br></td><td>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${year }", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("</td><td><strong>年</strong></td><td>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${month }", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("</td><td><strong>月</strong></td><td>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${day }", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("</td><td><strong>日生，于</strong></td><td>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${startyear }", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("</td><td><strong>年</strong></td><td width=\"50px\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${startmonth }", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("</td><td><strong>月至</strong></td><td>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${endyear }", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("</td><td><strong>年</strong></td><td>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${endmonth }", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("</td><td valign=\"top\"><br></td><td><strong>月</strong></td><td valign=\"top\">&nbsp; <br></td></tr>\r\n");
      out.write("          <tr height=\"50px\"><td valign=\"top\"><br></td><td><strong>在本校</strong></td><th colspan=\"5\" >");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${student.studentType }", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("</th><td align=\"center\"><strong>专业</strong></td><td>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${summaryyear }", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("</td><td align=\"center\"><strong>年制</strong></td><td align=\"center\" >本</td><th colspan=\"5\" >科学习，修完教学计</th><td valign=\"top\"><br></td></tr>\r\n");
      out.write("          <tr height=\"50px\"><td valign=\"top\"><br></td><th colspan=\"14\" align=\"left\" >划规定的全部课程，成绩合格，准予毕业。</th><td valign=\"top\"><br></td><td valign=\"top\"><br></td></tr>\r\n");
      out.write("          <tr height=\"100px\" ><td valign=\"top\"><br></td><td><br></td><th colspan=\"3\" >校&nbsp;&nbsp;&nbsp;&nbsp;名:</th><th colspan=\"3\" style=\"font-weight: normal;\">天津工业大学</th><th colspan=\"3\" >校（院）长：</th><th colspan=\"4\" ><br></th><td valign=\"top\"><br></td><td valign=\"top\"><br></td></tr>\r\n");
      out.write("          <tr><td valign=\"top\"><br></td><th colspan=\"2\" >证书编号：<br><br></th><th colspan=\"7\" ><br></th><td align=\"center\" >2014<strong>年</strong></td><td align=\"center\" width=\"40px\" >6</td><td align=\"center\" width=\"40px\" ><strong>月</strong></td><td align=\"center\" width=\"40px\" >19</td><td valign=\"top\"><br></td><td align=\"center\" width=\"40px\" ><strong>日</strong></td><td valign=\"top\"><br></td></tr>\r\n");
      out.write("       </tbody>         \r\n");
      out.write("      </table>\r\n");
      out.write("    </div>\r\n");
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

  private boolean _jspx_meth_s_005fif_005f0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  s:if
    org.apache.struts2.views.jsp.IfTag _jspx_th_s_005fif_005f0 = (org.apache.struts2.views.jsp.IfTag) _005fjspx_005ftagPool_005fs_005fif_005ftest.get(org.apache.struts2.views.jsp.IfTag.class);
    _jspx_th_s_005fif_005f0.setPageContext(_jspx_page_context);
    _jspx_th_s_005fif_005f0.setParent(null);
    // /WEB-INF/student/graduateprint.jsp(54,199) name = test type = java.lang.String reqTime = false required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_s_005fif_005f0.setTest("#student.sex=='男'.toString()");
    int _jspx_eval_s_005fif_005f0 = _jspx_th_s_005fif_005f0.doStartTag();
    if (_jspx_eval_s_005fif_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      if (_jspx_eval_s_005fif_005f0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.pushBody();
        _jspx_th_s_005fif_005f0.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
        _jspx_th_s_005fif_005f0.doInitBody();
      }
      do {
        out.write("<strong>先生</strong>");
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
    // /WEB-INF/student/graduateprint.jsp(54,267) name = test type = java.lang.String reqTime = false required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_s_005felseif_005f0.setTest("#student.sex=='女'.toString()");
    int _jspx_eval_s_005felseif_005f0 = _jspx_th_s_005felseif_005f0.doStartTag();
    if (_jspx_eval_s_005felseif_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      if (_jspx_eval_s_005felseif_005f0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.pushBody();
        _jspx_th_s_005felseif_005f0.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
        _jspx_th_s_005felseif_005f0.doInitBody();
      }
      do {
        out.write("<strong>女士</strong>，");
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
}
