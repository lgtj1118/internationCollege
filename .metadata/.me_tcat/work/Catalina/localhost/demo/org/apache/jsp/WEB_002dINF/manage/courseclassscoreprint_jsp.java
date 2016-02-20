package org.apache.jsp.WEB_002dINF.manage;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;

public final class courseclassscoreprint_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("    <title>成绩打印</title> \r\n");
      out.write("    <script type=\"text/javascript\" src=\"js/json2.js\" charset=\"utf-8\"></script>\r\n");
      out.write("    <script type=\"text/javascript\" src=\"js/jquery-validation/jquery.metadata.js\" charset=\"utf-8\"></script>\r\n");
      out.write("    <script type=\"text/javascript\" src=\"js/jquery-validation/messages_cn.js\" charset=\"utf-8\"></script>\r\n");
      out.write("    <script src=\"js/jquery/jquery-1.3.2.min.js\"type=\"text/javascript\"></script>\r\n");
      out.write("\t<script src=\"js/ligerUI/core/base.js\" type=\"text/javascript\"></script>\r\n");
      out.write("\t<script src=\"js/ligerUI/ligerui.all.js\" type=\"text/javascript\"></script>\r\n");
      out.write("\t<script type=\"text/javascript\" src=\"js/jquery/jquery-1.4.4.min.js\" ></script>\r\n");
      out.write("\t<script type=\"text/javascript\" src=\"js/jquery.jqprint-0.3.js\" ></script>\r\n");
      out.write("\t<script type=\"text/javascript\" src=\"js/semester.js\" ></script>\r\n");
      out.write("    <script type=\"text/javascript\">\r\n");
      out.write("       function f_tabprint(){\r\n");
      out.write("         $(\"#contain\").jqprint();\r\n");
      out.write("       }\r\n");
      out.write("       function f_close(){\r\n");
      out.write("         window.close();\r\n");
      out.write("       }\r\n");
      out.write("    </script>\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write("\r\n");
      out.write("#contain{\r\n");
      out.write(" width: 80%;\r\n");
      out.write(" border: :1px solid #c6c6c6 ;\r\n");
      out.write(" height:80%;\r\n");
      out.write(" margin:auto;\r\n");
      out.write("}\r\n");
      out.write("#button{\r\n");
      out.write("  margin:auto;\r\n");
      out.write("  width: 150px;\r\n");
      out.write("}\r\n");
      out.write("#content{\r\n");
      out.write("  width: 80%;\r\n");
      out.write("  border: :1px solid #c6c6c6 ;\r\n");
      out.write("  height:80%;\r\n");
      out.write("  margin:auto;\r\n");
      out.write("}\r\n");
      out.write(".table{\r\n");
      out.write("  width: 80%;\r\n");
      out.write("  margin: auto;\r\n");
      out.write("  border:1px solid #c6c6c6;border-collapse: collapse;\r\n");
      out.write("  text-align: center;\r\n");
      out.write("  font-size: 12px;\r\n");
      out.write("}\r\n");
      out.write(".table td{\r\n");
      out.write("  border:1px solid #c6c6c6;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("</style>\r\n");
      out.write("  </head>\r\n");
      out.write("  \r\n");
      out.write("  <body> \r\n");
      out.write("  <div id=\"button\"  >\r\n");
      out.write("      <button type=\"button\" onclick=\"f_close()\" >关闭</button>&nbsp;&nbsp;\r\n");
      out.write("     <button type=\"button\" onclick=\"f_tabprint()\" >打印</button>\r\n");
      out.write("  </div>\r\n");
      out.write("   <div id=\"contain\" >\r\n");
      out.write("      <div id=\"head\" ><h1 align=\"center\" ><font face=\"宋体\">天津工业大学外国留学生成绩单</font></h1><h3 align=\"center\" style=\"margin-top:-20px;\" ><font face=\"宋体\">Academic Transcript for Foreign Student of<br> \r\n");
      out.write("   Tianjin Polytechnic University</font></h3>\r\n");
      out.write("      </div>\r\n");
      out.write("      <div id=\"content\" >\r\n");
      out.write("        <table class=\"table\"  border=\"1\" cellspacing=\"0\" cellpadding=\"0\" >\r\n");
      out.write("           <tr>\r\n");
      out.write("               <td>学期(Term)</td><td>课程名(Course Name)</td><td>学号(No.)</td><td>姓名(Name)</td><td>平时成绩(HomeWork)</td><td>考勤成绩(Attendence)</td><td>期中成绩(Middle-Examnation)</td><td>期末成绩(Final Examnation)</td><td>总成绩(Total Score)</td>\r\n");
      out.write("           </tr>\r\n");
      out.write("           ");
      if (_jspx_meth_s_005fiterator_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("        </table>\r\n");
      out.write("      </div>\r\n");
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

  private boolean _jspx_meth_s_005fiterator_005f0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  s:iterator
    org.apache.struts2.views.jsp.IteratorTag _jspx_th_s_005fiterator_005f0 = (org.apache.struts2.views.jsp.IteratorTag) _005fjspx_005ftagPool_005fs_005fiterator_005fvalue_005fid.get(org.apache.struts2.views.jsp.IteratorTag.class);
    _jspx_th_s_005fiterator_005f0.setPageContext(_jspx_page_context);
    _jspx_th_s_005fiterator_005f0.setParent(null);
    // /WEB-INF/manage/courseclassscoreprint.jsp(77,11) name = value type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_s_005fiterator_005f0.setValue("#scoremodel");
    // /WEB-INF/manage/courseclassscoreprint.jsp(77,11) name = id type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_s_005fiterator_005f0.setId("m");
    int _jspx_eval_s_005fiterator_005f0 = _jspx_th_s_005fiterator_005f0.doStartTag();
    if (_jspx_eval_s_005fiterator_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      if (_jspx_eval_s_005fiterator_005f0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.pushBody();
        _jspx_th_s_005fiterator_005f0.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
        _jspx_th_s_005fiterator_005f0.doInitBody();
      }
      do {
        out.write("\r\n");
        out.write("             <tr>\r\n");
        out.write("               <td>");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${m.semester }", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
        out.write("</td><td>");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${m.course.coursename }", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
        out.write("</td>\r\n");
        out.write("               <td>");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${m.stuid }", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
        out.write("</td><td>");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${m.stuname }", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
        out.write("</td>\r\n");
        out.write("               <td>");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${m.homework }", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
        out.write("</td><td>");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${m.attendence}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
        out.write("</td>\r\n");
        out.write("               <td>");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${m.midexam }", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
        out.write("</td><td>");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${m.finalexam }", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
        out.write("</td>\r\n");
        out.write("               <td>");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${m.summary }", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
        out.write("</td>\r\n");
        out.write("             </tr>\r\n");
        out.write("           ");
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
