package org.apache.jsp.WEB_002dINF.course;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;

public final class evalutionanalysis_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fs_005fif_005ftest;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fs_005felse;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fs_005fif_005ftest = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fs_005felse = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fs_005fif_005ftest.release();
    _005fjspx_005ftagPool_005fs_005felse.release();
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
      out.write("    <title>天津工业大学国际教育学院学生教师课务系统</title>\r\n");
      out.write("    \r\n");
      out.write("\t<meta http-equiv=\"pragma\" content=\"no-cache\">\r\n");
      out.write("\t<meta http-equiv=\"cache-control\" content=\"no-cache\">\r\n");
      out.write("\t<meta http-equiv=\"expires\" content=\"0\">    \r\n");
      out.write("\t<meta http-equiv=\"keywords\" content=\"keyword1,keyword2,keyword3\">\r\n");
      out.write("\t<meta http-equiv=\"description\" content=\"天津工业大学国际教育学院学生教师课务系统\">\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write(".data-list{min-height:500px;color:#333;}\r\n");
      out.write(".data-table{ border:1px #ebebeb solid; border-bottom:none;width:60%;border-spacing: 0px;margin: auto;}\r\n");
      out.write(".data-table td{height:28px; padding-left:5px; border-bottom:1px #ebebeb solid;}\r\n");
      out.write(".td-cb{ width:20px;}\r\n");
      out.write(".data-table a{ color:#3377aa;text-decoration:none;}\r\n");
      out.write(".data-table a:hover{background:none;color:#3377aa;text-decoration:underline;}\r\n");
      out.write(".data-table tbody tr:hover{ background:#ffffe1;}\r\n");
      out.write("\r\n");
      out.write("td .action{ width:20px; position:relative;}\r\n");
      out.write(".ac td .act-box a{text-decoration:none;}\r\n");
      out.write(".action .arrow{ text-align:center; width:16px; height:16px; border:1px solid #DADADA; cursor:pointer; z-index:-1;}\r\n");
      out.write(".action .arrow img{ margin-top:6px;}\r\n");
      out.write(".action .act-box{ position:absolute; min-width:80px; text-align:center; right:2px; background-color:White; border:1px solid #DADADA; display:none; z-index:100;}\r\n");
      out.write(".act-box a{ display:block; width:80px; height:20px; line-height:20px;text-decoration:none;}\r\n");
      out.write(".act-box a:hover{ color:White; background:#37A; text-decoration:none;}\r\n");
      out.write("\r\n");
      out.write("</style>\r\n");
      out.write("  </head>\r\n");
      out.write("  \r\n");
      out.write("  <body>\r\n");
      out.write("    <h3 align=\"center\"><font face=\"微软雅黑\">评价分析</font></h3><br>\r\n");
      out.write("    <div id=\"contain\">\r\n");
      out.write("       <table class=\"data-table\" id=\"data-table\">\r\n");
      out.write("            <thead>\r\n");
      out.write("                <tr>\r\n");
      out.write("                    <td>类型</td><td>详情</td>\r\n");
      out.write("                </tr>               \r\n");
      out.write("            </thead>\r\n");
      out.write("            <tbody>\r\n");
      out.write("               <tr>\r\n");
      out.write("                    <td>教学态度</td><td><span class=\"type\" >");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${incicators1 }", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write(" </span></td>\r\n");
      out.write("               </tr>\r\n");
      out.write("               <tr>\r\n");
      out.write("                    <td>因材施教</td><td><span class=\"type\" >");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${incicators2 }", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write(" </span></td>\r\n");
      out.write("               </tr>\r\n");
      out.write("               <tr>\r\n");
      out.write("                    <td>教学内容</td><td><span class=\"type\" >");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${incicators3 }", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write(" </span></td>\r\n");
      out.write("               </tr>\r\n");
      out.write("               <tr>\r\n");
      out.write("                    <td>语言板书</td><td><span class=\"type\" >");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${incicators4 }", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write(" </span></td>\r\n");
      out.write("               </tr>\r\n");
      out.write("                <tr>\r\n");
      out.write("                    <td>教学方法</td><td><span class=\"type\" >");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${incicators5 }", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write(" </span></td>\r\n");
      out.write("               </tr>\r\n");
      out.write("                <tr>\r\n");
      out.write("                    <td>教学效果</td><td><span class=\"type\" >");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${incicators6 }", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write(" </span></td>\r\n");
      out.write("               </tr>\r\n");
      out.write("                <tr>\r\n");
      out.write("                    <td>总体印象</td><td><span class=\"type\" >");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${incicators7 }", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write(" </span></td>\r\n");
      out.write("               </tr>\r\n");
      out.write("                <tr>\r\n");
      out.write("                    <td>合计（分）</td><td><span class=\"type\" >\r\n");
      out.write("                      ");
      if (_jspx_meth_s_005fif_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("                      ");
      if (_jspx_meth_s_005felse_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("                    </span></td>\r\n");
      out.write("               </tr>\r\n");
      out.write("            </tbody>\r\n");
      out.write("        </table>\r\n");
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
    // /WEB-INF/course/evalutionanalysis.jsp(73,22) name = test type = java.lang.String reqTime = false required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_s_005fif_005f0.setTest("#summary<60");
    int _jspx_eval_s_005fif_005f0 = _jspx_th_s_005fif_005f0.doStartTag();
    if (_jspx_eval_s_005fif_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      if (_jspx_eval_s_005fif_005f0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.pushBody();
        _jspx_th_s_005fif_005f0.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
        _jspx_th_s_005fif_005f0.doInitBody();
      }
      do {
        out.write("\r\n");
        out.write("                       <font color=\"red\" > </font>  \r\n");
        out.write("                      ");
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

  private boolean _jspx_meth_s_005felse_005f0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  s:else
    org.apache.struts2.views.jsp.ElseTag _jspx_th_s_005felse_005f0 = (org.apache.struts2.views.jsp.ElseTag) _005fjspx_005ftagPool_005fs_005felse.get(org.apache.struts2.views.jsp.ElseTag.class);
    _jspx_th_s_005felse_005f0.setPageContext(_jspx_page_context);
    _jspx_th_s_005felse_005f0.setParent(null);
    int _jspx_eval_s_005felse_005f0 = _jspx_th_s_005felse_005f0.doStartTag();
    if (_jspx_eval_s_005felse_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      if (_jspx_eval_s_005felse_005f0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.pushBody();
        _jspx_th_s_005felse_005f0.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
        _jspx_th_s_005felse_005f0.doInitBody();
      }
      do {
        out.write("\r\n");
        out.write("                         ");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${summary }", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
        out.write("\r\n");
        out.write("                      ");
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
}
