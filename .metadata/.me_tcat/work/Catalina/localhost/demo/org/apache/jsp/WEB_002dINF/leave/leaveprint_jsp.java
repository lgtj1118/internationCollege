package org.apache.jsp.WEB_002dINF.leave;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;

public final class leaveprint_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fs_005fif_005ftest;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fs_005felseif_005ftest;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fs_005fproperty_005fvalue_005fnobody;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fs_005fif_005ftest = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fs_005felseif_005ftest = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fs_005fproperty_005fvalue_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fs_005fif_005ftest.release();
    _005fjspx_005ftagPool_005fs_005felseif_005ftest.release();
    _005fjspx_005ftagPool_005fs_005fproperty_005fvalue_005fnobody.release();
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
      out.write("#head{\r\n");
      out.write("  margin:auto;\r\n");
      out.write("  width:200px;\r\n");
      out.write("  \r\n");
      out.write("}\r\n");
      out.write("#contain{\r\n");
      out.write("margin:auto;\r\n");
      out.write("}\r\n");
      out.write(".contenttable{\r\n");
      out.write("  margin:auto;\r\n");
      out.write("  width:80%;\r\n");
      out.write("}\r\n");
      out.write(".contenttable td{\r\n");
      out.write("  border: 1px solid #fff ; \r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("  </head>\r\n");
      out.write("  \r\n");
      out.write("  <body>\r\n");
      out.write("    <div id=\"head\" >\r\n");
      out.write("        <font face=\"楷体\"><input align=\"center\" type=\"button\" value=\"关  闭\" onclick=\"tabclose()\"> \n");
      out.write("        <input type=\"button\" value=\"打  印\" onclick=\"tabprint()\"></font>\r\n");
      out.write("    </div>\r\n");
      out.write("    <div id=\"contain\">\r\n");
      out.write("    ");
      if (_jspx_meth_s_005fif_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("    ");
      if (_jspx_meth_s_005felseif_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("     \r\n");
      out.write("     \r\n");
      out.write("      <table class=\"contenttable\" border=\"1\" cellpadding=\"0\" cellspacing=\"0\" >\r\n");
      out.write("\t    <tbody>\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t<td colspan=\"2\" style=\"border:0.5000pt solid windowtext;\" valign=\"center\" width=\"285\"><font face=\"楷体\">&nbsp; \n");
      out.write("\t\t\t\t中文姓名 Chinese&nbsp;Name：&nbsp; ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${student.stuname}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("</font></td>\r\n");
      out.write("\t\t\t<td colspan=\"3\" style=\"border:0.5000pt solid windowtext;\" valign=\"center\" width=\"206\"><font face=\"楷体\"> \n");
      out.write("\t\t\t\t专业 Major：");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${student.classes.major}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("</font></td>\r\n");
      out.write("\t\t\t<td colspan=\"2\" style=\"border:0.5000pt solid windowtext;\" valign=\"center\" width=\"233\"><font face=\"楷体\">&nbsp; \n");
      out.write("\t\t\t\t国籍 Nationality： ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${student.nation }", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\n");
      out.write("\t\t\t</font></td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t<td colspan=\"2\" style=\"border:0.5000pt solid windowtext;\" valign=\"center\" width=\"285\"><font face=\"楷体\">&nbsp; \n");
      out.write("\t\t\t\t英文姓名 Englist Name： &nbsp; ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${student.firstname}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${student.lastname}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write(" \n");
      out.write("\t\t\t</font></td>\r\n");
      out.write("\t\t\t<td colspan=\"3\" style=\"border:0.5000pt solid windowtext;\" valign=\"center\" width=\"206\"><font face=\"楷体\"> \n");
      out.write("\t\t\t\t班级Class： ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${student.classes.classname }", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\n");
      out.write("\t\t\t</font></td>\r\n");
      out.write("\t\t\t<td colspan=\"2\" style=\"border:0.5000pt solid windowtext;\" valign=\"center\" width=\"233\"><font face=\"楷体\">&nbsp; \n");
      out.write("\t\t\t\t联系号码 Contact&nbsp;Number:");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${leaves.telephone }", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write(" \n");
      out.write("\t\t\t</font></td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t<td style=\"border:0.5000pt solid windowtext;\" valign=\"center\" width=\"106\"><div align=\"center\"> \n");
      out.write("\t\t\t\t<font face=\"楷体\"><strong><br><br>请假</strong><br><strong>事由 \n");
      out.write("\t\t\t\tReasons </strong><br><strong>for </strong><br><strong>Leave<br><br><br></strong></font></div> \n");
      out.write("\t\t\t</td>\r\n");
      out.write("\t\t\t<td colspan=\"6\" style=\"border:0.5000pt solid windowtext;\" valign=\"center\" width=\"619\"><font face=\"楷体\">\r\n");
      out.write("\t\t\t\t&nbsp;&nbsp;");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${leaves.leavereason }", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <br><br><br>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; 签字 Signature\r\n");
      out.write("\t\t\t\t： &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <br><br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 年&nbsp;yy&nbsp;&nbsp;&nbsp;&nbsp;月&nbsp;mm&nbsp;&nbsp;&nbsp;&nbsp;日&nbsp;dd\t\t\t\t\r\n");
      out.write("\t\t\t</font></td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t<td style=\"border:0.5000pt solid windowtext;\" valign=\"center\" width=\"106\" align=\"center\">\r\n");
      out.write("\t\t\t\t<font face=\"楷体\"><strong><br>请假时间Leaving&nbsp;period<br><br>\r\n");
      out.write("\t\t\t</strong></font></td>\r\n");
      out.write("\t\t\t<td colspan=\"6\" style=\"border:0.5000pt solid windowtext;\" valign=\"center\" width=\"619\" align=\"center\"><font face=\"楷体\">\r\n");
      out.write("\t\t\t\t从&nbsp; &nbsp;");
      if (_jspx_meth_s_005fproperty_005f0(_jspx_page_context))
        return;
      out.write(" &nbsp;&nbsp; 年 &nbsp; &nbsp;");
      if (_jspx_meth_s_005fproperty_005f1(_jspx_page_context))
        return;
      out.write(" &nbsp; 月&nbsp; &nbsp;");
      if (_jspx_meth_s_005fproperty_005f2(_jspx_page_context))
        return;
      out.write("&nbsp; &nbsp; 日至&nbsp;&nbsp;");
      if (_jspx_meth_s_005fproperty_005f3(_jspx_page_context))
        return;
      out.write(" &nbsp; &nbsp; 年&nbsp; &nbsp;");
      if (_jspx_meth_s_005fproperty_005f4(_jspx_page_context))
        return;
      out.write("&nbsp; 月 &nbsp;");
      if (_jspx_meth_s_005fproperty_005f5(_jspx_page_context))
        return;
      out.write(" &nbsp; 日，共 &nbsp; &nbsp; 天。\r\n");
      out.write("                <br><br>From&nbsp;the &nbsp;&nbsp; &nbsp; yy&nbsp; &nbsp;&nbsp; mm&nbsp; &nbsp; &nbsp; dd&nbsp;&nbsp;to&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;yy&nbsp; &nbsp;&nbsp; mm&nbsp; &nbsp;&nbsp; dd,&nbsp;Totally&nbsp;_____days.\r\n");
      out.write("\t\t\t</font></td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t");
      if (_jspx_meth_s_005fif_005f1(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t");
      if (_jspx_meth_s_005felseif_005f1(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t<td style=\"border:0.5000pt solid windowtext;\" valign=\"center\" width=\"106\" align=\"center\"> \n");
      out.write("\t\t\t\t<font face=\"楷体\"><strong>备注Notes \n");
      out.write("\t\t\t</strong></font></td>\r\n");
      out.write("\t\t\t<td colspan=\"5\" style=\"border:0.5000pt solid windowtext;\" valign=\"center\" width=\"619\"> \n");
      out.write("\t\t\t\t<font face=\"楷体\"><strong></strong></font><p><font face=\"宋体\"><strong>1、此表用于3日及以内的短期请假； This form is used for leave no more 3 days;</strong></font></p><p><font face=\"宋体\"><strong></strong></font></p><p><font face=\"宋体\"><strong>2、学生到学院401室办理请假手续，并将请假批准单出示给任课老师；</strong></font></p><p><font face=\"宋体\"><strong>&nbsp;You need to make an application at room 401, after getting the permission, show it to the course teacher; </strong></font></p><p><font face=\"宋体\"><strong></strong></font></p><p><font face=\"宋体\"><strong>\n");
      out.write("3、无法及时到401室办理请假手续者，须补办，并在上课之前告知任课老师;</strong></font></p><p><font face=\"宋体\"><strong>&nbsp;Fail to go through the procedure in time, you need to inform the course teacher first and you have to do it as soon as possible; </strong></font></p><p><font face=\"宋体\"><strong></strong></font></p><p><font face=\"宋体\"><strong>\n");
      out.write("4、未经请假或请假未经批准而缺席者，视为旷课； \n");
      out.write("</strong></font></p><p><font face=\"宋体\"><strong>Without permission, any leave will be seen as absence; </strong></font></p><p><font face=\"宋体\"><strong></strong></font></p><p><font face=\"宋体\"><strong>\n");
      out.write("5、及时销假：学生需在回校后当天（最晚不超过第2天）将请假单交回401，否则按旷课处理； \n");
      out.write("You need to report back from leave at room 401 within two days after returning to school and give the application form back to 401,failing to obey the rule will be seen as absent; \n");
      out.write("</strong></font></p><p><font face=\"宋体\"><strong></strong></font></p><p><font face=\"宋体\"><strong>6、请假期间注意安全，一切后果自行负责。 \n");
      out.write("You should be responsible for yourself, especially your safety during the days of leave.</strong></font></p><font face=\"宋体\"><strong></strong></font></td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t<td style=\"border:0.5000pt solid windowtext;\" valign=\"center\" width=\"106\" align=\"center\"><font face=\"楷体\"><strong>\r\n");
      out.write("\t\t\t\t销假<br>Report&nbsp;back<br>&nbsp;from&nbsp;Leave\r\n");
      out.write("\t\t\t</strong></font></td>\r\n");
      out.write("\t\t\t<td colspan=\"3\" style=\"border:0.5000pt solid windowtext;\" valign=\"center\" width=\"288\"><p><font face=\"楷体\"><strong>\r\n");
      out.write("\t\t\t\t销假日期Date&nbsp;：\r\n");
      out.write("\t\t\t</strong></font></p></td>\r\n");
      out.write("\t\t\t<td colspan=\"2\" style=\"border:0.5000pt solid windowtext;\" valign=\"center\" width=\"330\"><font face=\"楷体\"><strong>\r\n");
      out.write("\t\t\t\t销假人签字Signature：\r\n");
      out.write("\t\t\t</strong></font></td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t</tbody>\r\n");
      out.write("</table>\r\n");
      out.write("</div>\r\n");
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
    // /WEB-INF/leave/leaveprint.jsp(49,4) name = test type = java.lang.String reqTime = false required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_s_005fif_005f0.setTest("#leaves.type==1");
    int _jspx_eval_s_005fif_005f0 = _jspx_th_s_005fif_005f0.doStartTag();
    if (_jspx_eval_s_005fif_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      if (_jspx_eval_s_005fif_005f0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.pushBody();
        _jspx_th_s_005fif_005f0.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
        _jspx_th_s_005fif_005f0.doInitBody();
      }
      do {
        out.write("\r\n");
        out.write("       <div align=\"center\"> \r\n");
        out.write("\t     <font face=\"楷体\"><span style=\"font-family: 楷体; font-weight: bold; font-size: 18pt;\">&nbsp;天津工业大学国际教育学院学院请假单（一）<br></span>&nbsp;<span style=\"font-family: 'Times New Roman'; font-weight: bold; font-size: 12pt;\">Application&nbsp;Form&nbsp;for&nbsp;Leave&nbsp;of&nbsp;School&nbsp;of&nbsp;International&nbsp;Education,</span><br>&nbsp;<span style=\"font-family: 'Times New Roman'; font-weight: bold; font-size: 12pt;\"> Tianjin&nbsp;Polytechnic&nbsp;University（1）</span><span style=\"font-family: 'Times New Roman'; font-weight: bold; font-size: 12pt;\"><br>（短期请假Short&nbsp;Leave）</span></font> \r\n");
        out.write("         </div>\r\n");
        out.write("         <p class=\"MsoNormal\" style=\"text-align:right;margin-right: 30%;\">\r\n");
        out.write("\t        <font face=\"楷体\"><span style=\"font-family: 楷体_GB2312; font-weight: bold; font-size: 10.5pt;\">&nbsp; 国教院（表</span><span style=\"font-family: 'Times New Roman'; font-weight: bold; font-size: 10.5pt;\">1</span><span style=\"font-family: 楷体_GB2312; font-weight: bold; font-size: 10.5pt;\">）</span><span style=\"font-family: 'Times New Roman'; font-weight: bold; font-size: 10.5pt;\">[2015](&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;)</span><span style=\"font-family: 'Times New Roman'; font-weight: bold; font-size: 12pt;\"></span></font>\r\n");
        out.write("         </p>\r\n");
        out.write("      \r\n");
        out.write("    ");
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
    // /WEB-INF/leave/leaveprint.jsp(58,4) name = test type = java.lang.String reqTime = false required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_s_005felseif_005f0.setTest("#leaves.type==2");
    int _jspx_eval_s_005felseif_005f0 = _jspx_th_s_005felseif_005f0.doStartTag();
    if (_jspx_eval_s_005felseif_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      if (_jspx_eval_s_005felseif_005f0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.pushBody();
        _jspx_th_s_005felseif_005f0.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
        _jspx_th_s_005felseif_005f0.doInitBody();
      }
      do {
        out.write("\r\n");
        out.write("         <div align=\"center\"> \r\n");
        out.write("\t     <font face=\"楷体\"><span style=\"font-family: 楷体; font-weight: bold; font-size: 18pt;\">&nbsp;天津工业大学国际教育学院学院请假单（一）<br></span>&nbsp;<span style=\"font-family: 'Times New Roman'; font-weight: bold; font-size: 12pt;\">Application&nbsp;Form&nbsp;for&nbsp;Leave&nbsp;of&nbsp;School&nbsp;of&nbsp;International&nbsp;Education,</span><br>&nbsp;<span style=\"font-family: 'Times New Roman'; font-weight: bold; font-size: 12pt;\"> Tianjin&nbsp;Polytechnic&nbsp;University（1）</span><span style=\"font-family: 'Times New Roman'; font-weight: bold; font-size: 12pt;\"><br>（长期请假Long&nbsp;Leave）</span></font> \r\n");
        out.write("         </div>\r\n");
        out.write("         <p class=\"MsoNormal\" style=\"text-align:right;margin-right: 30%;\">\r\n");
        out.write("\t        <font face=\"楷体\"><span style=\"font-family: 楷体_GB2312; font-weight: bold; font-size: 10.5pt;\">&nbsp; 国教院（表</span><span style=\"font-family: 'Times New Roman'; font-weight: bold; font-size: 10.5pt;\">2</span><span style=\"font-family: 楷体_GB2312; font-weight: bold; font-size: 10.5pt;\">）</span><span style=\"font-family: 'Times New Roman'; font-weight: bold; font-size: 10.5pt;\">[2015](&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;)</span><span style=\"font-family: 'Times New Roman'; font-weight: bold; font-size: 12pt;\"></span></font>\r\n");
        out.write("         </p>\r\n");
        out.write("    ");
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

  private boolean _jspx_meth_s_005fproperty_005f0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  s:property
    org.apache.struts2.views.jsp.PropertyTag _jspx_th_s_005fproperty_005f0 = (org.apache.struts2.views.jsp.PropertyTag) _005fjspx_005ftagPool_005fs_005fproperty_005fvalue_005fnobody.get(org.apache.struts2.views.jsp.PropertyTag.class);
    _jspx_th_s_005fproperty_005f0.setPageContext(_jspx_page_context);
    _jspx_th_s_005fproperty_005f0.setParent(null);
    // /WEB-INF/leave/leaveprint.jsp(105,18) name = value type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_s_005fproperty_005f0.setValue("#leaves.leavingdate.substring(0,4)");
    int _jspx_eval_s_005fproperty_005f0 = _jspx_th_s_005fproperty_005f0.doStartTag();
    if (_jspx_th_s_005fproperty_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fs_005fproperty_005fvalue_005fnobody.reuse(_jspx_th_s_005fproperty_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fs_005fproperty_005fvalue_005fnobody.reuse(_jspx_th_s_005fproperty_005f0);
    return false;
  }

  private boolean _jspx_meth_s_005fproperty_005f1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  s:property
    org.apache.struts2.views.jsp.PropertyTag _jspx_th_s_005fproperty_005f1 = (org.apache.struts2.views.jsp.PropertyTag) _005fjspx_005ftagPool_005fs_005fproperty_005fvalue_005fnobody.get(org.apache.struts2.views.jsp.PropertyTag.class);
    _jspx_th_s_005fproperty_005f1.setPageContext(_jspx_page_context);
    _jspx_th_s_005fproperty_005f1.setParent(null);
    // /WEB-INF/leave/leaveprint.jsp(105,104) name = value type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_s_005fproperty_005f1.setValue("#leaves.leavingdate.substring(5,7)");
    int _jspx_eval_s_005fproperty_005f1 = _jspx_th_s_005fproperty_005f1.doStartTag();
    if (_jspx_th_s_005fproperty_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fs_005fproperty_005fvalue_005fnobody.reuse(_jspx_th_s_005fproperty_005f1);
      return true;
    }
    _005fjspx_005ftagPool_005fs_005fproperty_005fvalue_005fnobody.reuse(_jspx_th_s_005fproperty_005f1);
    return false;
  }

  private boolean _jspx_meth_s_005fproperty_005f2(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  s:property
    org.apache.struts2.views.jsp.PropertyTag _jspx_th_s_005fproperty_005f2 = (org.apache.struts2.views.jsp.PropertyTag) _005fjspx_005ftagPool_005fs_005fproperty_005fvalue_005fnobody.get(org.apache.struts2.views.jsp.PropertyTag.class);
    _jspx_th_s_005fproperty_005f2.setPageContext(_jspx_page_context);
    _jspx_th_s_005fproperty_005f2.setParent(null);
    // /WEB-INF/leave/leaveprint.jsp(105,183) name = value type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_s_005fproperty_005f2.setValue("#leaves.leavingdate.substring(8)");
    int _jspx_eval_s_005fproperty_005f2 = _jspx_th_s_005fproperty_005f2.doStartTag();
    if (_jspx_th_s_005fproperty_005f2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fs_005fproperty_005fvalue_005fnobody.reuse(_jspx_th_s_005fproperty_005f2);
      return true;
    }
    _005fjspx_005ftagPool_005fs_005fproperty_005fvalue_005fnobody.reuse(_jspx_th_s_005fproperty_005f2);
    return false;
  }

  private boolean _jspx_meth_s_005fproperty_005f3(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  s:property
    org.apache.struts2.views.jsp.PropertyTag _jspx_th_s_005fproperty_005f3 = (org.apache.struts2.views.jsp.PropertyTag) _005fjspx_005ftagPool_005fs_005fproperty_005fvalue_005fnobody.get(org.apache.struts2.views.jsp.PropertyTag.class);
    _jspx_th_s_005fproperty_005f3.setPageContext(_jspx_page_context);
    _jspx_th_s_005fproperty_005f3.setParent(null);
    // /WEB-INF/leave/leaveprint.jsp(105,266) name = value type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_s_005fproperty_005f3.setValue("#leaves.backdate.substring(0,4)");
    int _jspx_eval_s_005fproperty_005f3 = _jspx_th_s_005fproperty_005f3.doStartTag();
    if (_jspx_th_s_005fproperty_005f3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fs_005fproperty_005fvalue_005fnobody.reuse(_jspx_th_s_005fproperty_005f3);
      return true;
    }
    _005fjspx_005ftagPool_005fs_005fproperty_005fvalue_005fnobody.reuse(_jspx_th_s_005fproperty_005f3);
    return false;
  }

  private boolean _jspx_meth_s_005fproperty_005f4(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  s:property
    org.apache.struts2.views.jsp.PropertyTag _jspx_th_s_005fproperty_005f4 = (org.apache.struts2.views.jsp.PropertyTag) _005fjspx_005ftagPool_005fs_005fproperty_005fvalue_005fnobody.get(org.apache.struts2.views.jsp.PropertyTag.class);
    _jspx_th_s_005fproperty_005f4.setPageContext(_jspx_page_context);
    _jspx_th_s_005fproperty_005f4.setParent(null);
    // /WEB-INF/leave/leaveprint.jsp(105,349) name = value type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_s_005fproperty_005f4.setValue("#leaves.backdate.substring(5,7)");
    int _jspx_eval_s_005fproperty_005f4 = _jspx_th_s_005fproperty_005f4.doStartTag();
    if (_jspx_th_s_005fproperty_005f4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fs_005fproperty_005fvalue_005fnobody.reuse(_jspx_th_s_005fproperty_005f4);
      return true;
    }
    _005fjspx_005ftagPool_005fs_005fproperty_005fvalue_005fnobody.reuse(_jspx_th_s_005fproperty_005f4);
    return false;
  }

  private boolean _jspx_meth_s_005fproperty_005f5(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  s:property
    org.apache.struts2.views.jsp.PropertyTag _jspx_th_s_005fproperty_005f5 = (org.apache.struts2.views.jsp.PropertyTag) _005fjspx_005ftagPool_005fs_005fproperty_005fvalue_005fnobody.get(org.apache.struts2.views.jsp.PropertyTag.class);
    _jspx_th_s_005fproperty_005f5.setPageContext(_jspx_page_context);
    _jspx_th_s_005fproperty_005f5.setParent(null);
    // /WEB-INF/leave/leaveprint.jsp(105,418) name = value type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_s_005fproperty_005f5.setValue("#leaves.backdate.substring(8)");
    int _jspx_eval_s_005fproperty_005f5 = _jspx_th_s_005fproperty_005f5.doStartTag();
    if (_jspx_th_s_005fproperty_005f5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fs_005fproperty_005fvalue_005fnobody.reuse(_jspx_th_s_005fproperty_005f5);
      return true;
    }
    _005fjspx_005ftagPool_005fs_005fproperty_005fvalue_005fnobody.reuse(_jspx_th_s_005fproperty_005f5);
    return false;
  }

  private boolean _jspx_meth_s_005fif_005f1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  s:if
    org.apache.struts2.views.jsp.IfTag _jspx_th_s_005fif_005f1 = (org.apache.struts2.views.jsp.IfTag) _005fjspx_005ftagPool_005fs_005fif_005ftest.get(org.apache.struts2.views.jsp.IfTag.class);
    _jspx_th_s_005fif_005f1.setPageContext(_jspx_page_context);
    _jspx_th_s_005fif_005f1.setParent(null);
    // /WEB-INF/leave/leaveprint.jsp(109,2) name = test type = java.lang.String reqTime = false required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_s_005fif_005f1.setTest("#leaves.type==1");
    int _jspx_eval_s_005fif_005f1 = _jspx_th_s_005fif_005f1.doStartTag();
    if (_jspx_eval_s_005fif_005f1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      if (_jspx_eval_s_005fif_005f1 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.pushBody();
        _jspx_th_s_005fif_005f1.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
        _jspx_th_s_005fif_005f1.doInitBody();
      }
      do {
        out.write("\r\n");
        out.write("\t\t   <tr>\r\n");
        out.write("\t\t\t<td style=\"border:0.5000pt solid windowtext;\" valign=\"center\" width=\"106\" align=\"center\"> \r\n");
        out.write("\t\t\t\t<font face=\"楷体\"><strong>批准Approved&nbsp;by \r\n");
        out.write("\t\t\t</strong></font></td>\r\n");
        out.write("\t\t\t<td colspan=\"3\" style=\"border:0.5000pt solid windowtext;\" valign=\"top\" width=\"300\"><font face=\"楷体\">\r\n");
        out.write("\t\t\t\t班主任意见/Supervisor： &nbsp;&nbsp;\r\n");
        out.write("\t\t\t\t<br><br><br><br><br><br><br>签字 Signature：<br><br>&nbsp;<br>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; 年&nbsp;yy&nbsp;&nbsp;&nbsp;&nbsp;月&nbsp;mm&nbsp;&nbsp;&nbsp;&nbsp;日&nbsp;dd\r\n");
        out.write("\t\t\t</font></td>\r\n");
        out.write("\t\t\t<td colspan=\"3\" style=\"border:0.5000pt solid windowtext;\" valign=\"top\" width=\"300\" align=\"left\"><font face=\"楷体\"> \r\n");
        out.write("\t\t\t\t学院教学办意见（211办公室）/Teaching&nbsp;Affairs/Teaching&nbsp;Affairs&nbsp;Administration&nbsp;Office&nbsp;Ⅲ&nbsp;(Room&nbsp;211)&nbsp;： \r\n");
        out.write("\t\t\t\t&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <br><br><br><br><br></font><div align=\"center\"><font face=\"楷体\">&nbsp;签字Signature： <br><br><br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; \r\n");
        out.write("年&nbsp;yy&nbsp;&nbsp;&nbsp;&nbsp;月&nbsp;mm&nbsp;&nbsp;&nbsp;&nbsp;日&nbsp;dd \r\n");
        out.write("\t\t\t</font></div></td>\r\n");
        out.write("\t\t</tr>\r\n");
        out.write("\t\t");
        int evalDoAfterBody = _jspx_th_s_005fif_005f1.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
      if (_jspx_eval_s_005fif_005f1 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.popBody();
      }
    }
    if (_jspx_th_s_005fif_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fs_005fif_005ftest.reuse(_jspx_th_s_005fif_005f1);
      return true;
    }
    _005fjspx_005ftagPool_005fs_005fif_005ftest.reuse(_jspx_th_s_005fif_005f1);
    return false;
  }

  private boolean _jspx_meth_s_005felseif_005f1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  s:elseif
    org.apache.struts2.views.jsp.ElseIfTag _jspx_th_s_005felseif_005f1 = (org.apache.struts2.views.jsp.ElseIfTag) _005fjspx_005ftagPool_005fs_005felseif_005ftest.get(org.apache.struts2.views.jsp.ElseIfTag.class);
    _jspx_th_s_005felseif_005f1.setPageContext(_jspx_page_context);
    _jspx_th_s_005felseif_005f1.setParent(null);
    // /WEB-INF/leave/leaveprint.jsp(125,2) name = test type = java.lang.String reqTime = false required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_s_005felseif_005f1.setTest("#leaves.type==2");
    int _jspx_eval_s_005felseif_005f1 = _jspx_th_s_005felseif_005f1.doStartTag();
    if (_jspx_eval_s_005felseif_005f1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      if (_jspx_eval_s_005felseif_005f1 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.pushBody();
        _jspx_th_s_005felseif_005f1.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
        _jspx_th_s_005felseif_005f1.doInitBody();
      }
      do {
        out.write("\r\n");
        out.write("\t\t   <tr>\r\n");
        out.write("\t\t\t<td style=\"border:0.5000pt solid windowtext;\" valign=\"center\" width=\"106\" align=\"center\"> \r\n");
        out.write("\t\t\t\t<font face=\"楷体\"><strong>批准Approved&nbsp;by \r\n");
        out.write("\t\t\t</strong></font></td>\r\n");
        out.write("\t\t\t<td colspan=\"2\" style=\"border:0.5000pt solid windowtext;\" valign=\"top\" width=\"300\"><font face=\"楷体\">\r\n");
        out.write("\t\t\t\t班主任意见/Supervisor： &nbsp;&nbsp;\r\n");
        out.write("\t\t\t\t<br><br><br><br><br><br><br>签字 Signature：<br><br>&nbsp;<br>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; 年&nbsp;yy&nbsp;&nbsp;&nbsp;&nbsp;月&nbsp;mm&nbsp;&nbsp;&nbsp;&nbsp;日&nbsp;dd\r\n");
        out.write("\t\t\t</font></td>\r\n");
        out.write("\t\t\t<td colspan=\"2\" style=\"border:0.5000pt solid windowtext;\" valign=\"top\" width=\"300\" align=\"left\"><font face=\"楷体\"> \r\n");
        out.write("\t\t\t\t学院教学办意见（211办公室）/Teaching&nbsp;Affairs/Teaching&nbsp;Affairs&nbsp;Administration&nbsp;Office&nbsp;Ⅲ&nbsp;(Room&nbsp;211)&nbsp;： \r\n");
        out.write("\t\t\t\t&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <br><br><br><br><br></font><div align=\"center\"><font face=\"楷体\">&nbsp;签字Signature： <br><br><br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; \r\n");
        out.write("年&nbsp;yy&nbsp;&nbsp;&nbsp;&nbsp;月&nbsp;mm&nbsp;&nbsp;&nbsp;&nbsp;日&nbsp;dd \r\n");
        out.write("\t\t\t</font></div></td>\r\n");
        out.write("\t\t\t<td colspan=\"2\" style=\"border:0.5000pt solid windowtext;\" valign=\"top\" width=\"300\" align=\"left\"><font face=\"楷体\">  \n");
        out.write("\t\t\t\t教学副院长意见/Depty Dean ：  \n");
        out.write("\t\t\t\t&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <br><br><br><br><br></font><div align=\"center\"><font face=\"楷体\">&nbsp;签字Signature： <br><br><br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; \r\n");
        out.write("年&nbsp;yy&nbsp;&nbsp;&nbsp;&nbsp;月&nbsp;mm&nbsp;&nbsp;&nbsp;&nbsp;日&nbsp;dd \r\n");
        out.write("\t\t\t</font></div></td>\r\n");
        out.write("\t\t</tr>\r\n");
        out.write("\t\t");
        int evalDoAfterBody = _jspx_th_s_005felseif_005f1.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
      if (_jspx_eval_s_005felseif_005f1 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.popBody();
      }
    }
    if (_jspx_th_s_005felseif_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fs_005felseif_005ftest.reuse(_jspx_th_s_005felseif_005f1);
      return true;
    }
    _005fjspx_005ftagPool_005fs_005felseif_005ftest.reuse(_jspx_th_s_005felseif_005f1);
    return false;
  }
}
