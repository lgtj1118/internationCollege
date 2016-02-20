package org.apache.jsp.WEB_002dINF.student;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;

public final class leavemanage_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("    <title>天津工业大学排课管理系统</title>\r\n");
      out.write("    \r\n");
      out.write("\t<meta http-equiv=\"pragma\" content=\"no-cache\">\r\n");
      out.write("\t<meta http-equiv=\"cache-control\" content=\"no-cache\">\r\n");
      out.write("\t<meta http-equiv=\"expires\" content=\"0\">    \r\n");
      out.write("\t<meta http-equiv=\"keywords\" content=\"keyword1,keyword2,keyword3\">\r\n");
      out.write("\t<meta http-equiv=\"description\" content=\"天津工业大学排课管理系统\">\r\n");
      out.write("<script language=\"javascript\" type=\"text/javascript\"> \r\n");
      out.write("\tvar i = 5;\r\n");
      out.write("\tvar intervalid;\r\n");
      out.write("\tintervalid = setInterval(\"fun()\", 1000);\r\n");
      out.write("\tfunction fun(){\r\n");
      out.write("\t\tif (i == 0) {\r\n");
      out.write("\t\t\t//window.location.href = \"../index.html\";\r\n");
      out.write("\t\t\tdocument.getElementById(\"read\").disabled=false;\r\n");
      out.write("\t\t\tdocument.getElementById(\"mes\").style.display=\"none\";\r\n");
      out.write("\t\t\tclearInterval(intervalid);\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tdocument.getElementById(\"mes\").innerHTML = i;\r\n");
      out.write("\t\ti--;\r\n");
      out.write("\t}\r\n");
      out.write("\tfunction leavemanage(){\r\n");
      out.write("\t window.location.href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/system/Manage_leavemanage.action\";\r\n");
      out.write("\t}//onload=\"fun()\"\r\n");
      out.write("</script> \r\n");
      out.write("  \r\n");
      out.write("  </head> \r\n");
      out.write("  <body >\r\n");
      out.write("    <div id=\"contain\" style=\"width: 80%;\">\r\n");
      out.write("      <h2 align=\"center\"><font face=\"微软雅黑\">天津工业大学国际教育学院请假管理条例</font></h2>\r\n");
      out.write("      <p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font face=\"微软雅黑\">&nbsp;一、学生因生病或其它原因无法进行正常上课时，务必办理请假手续。学生请假手续由学院教学办211办公室统一管理。学生需要请假先到学院401教室领取请假表，并填写表格中的相关内容，填完后将表格提交给401教室值班人。</font></p> \r\n");
      out.write("      <p><font face=\"微软雅黑\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;二、短期请假：请假时间少于3个工作日（含3日）由班主任签字，到学院教学办211办公室负责人审批后方可。学生需将请假批准单出示给任课老师；无法及时到401室办理请假手续者，须补办，并在上课之前告知任课老师。</font></p>\r\n");
      out.write("      <p><font face=\"微软雅黑\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;三、长期请假：请假时间多于4个工作日（含4日）由主管教学院长审核批准后方可离校。学生一学期请假时间最长不得超过22个工作日，如超过22个工作日到401室办理休学手续。</font></p>\r\n");
      out.write("      <p><font face=\"微软雅黑\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;四、学生因事请假务必提前两天到学院401室办理请假手续；特殊情况特殊处理。</font></p>\r\n");
      out.write("      <p><font face=\"微软雅黑\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;五、学生在请假期满后，须及时返校学习，并到401室销假。</font></p>\r\n");
      out.write("      <p><font face=\"微软雅黑\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;六、未经请假或请假未经批准而缺席者，视为旷课。</font></p>\r\n");
      out.write("      <p><font face=\"微软雅黑\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;七、如请假外出，应保证在外出活动期间不可参加任何违反学校规定以及违法的活动，外出期间请注意安全，如果发生安全事故，责任由外出人员自负。</font></p>\r\n");
      out.write("      <div align=\"right\"><font face=\"微软雅黑\"><span style=\"margin-right: 100px;\">天津工业大学</span></font> \r\n");
      out.write("      </div><p style=\"margin-right: 100px;\" align=\"right\"><font face=\"微软雅黑\">国际教育学院</font></p><div align=\"right\"> \r\n");
      out.write("      </div><p style=\"margin-right: 100px;\" align=\"right\"><font face=\"微软雅黑\">2015年1月26日</font></p>\r\n");
      out.write("      <div align=\"center\"><button id=\"read\" type=\"button\"  onclick=\"leavemanage()\"><!-- <span id=\"mes\">5</span> -->知道了</button></div>\r\n");
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
}
