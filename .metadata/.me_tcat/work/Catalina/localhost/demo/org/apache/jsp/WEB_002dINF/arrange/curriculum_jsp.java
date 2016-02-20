package org.apache.jsp.WEB_002dINF.arrange;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.opensymphony.xwork2.ActionContext;
import com.tjpu.bean.Syllabus;
import com.tjpu.bean.ChosenCourseModel;
import org.springframework.web.context.request.SessionScope;
import java.util.*;
import java.io.*;

public final class curriculum_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html; charset=utf-8");
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
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");

	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";

      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<base href=\"");
      out.print(basePath);
      out.write("\">\r\n");
      out.write("<title>天津工业大学排课管理系统</title>\r\n");
      out.write("<link href=\"");
      out.print(basePath);
      out.write("js/ligerUI/skins/Aqua/css/ligerui-all.css\"\r\n");
      out.write("\trel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("<link href=\"");
      out.print(basePath);
      out.write("js/ligerUI/skins/Gray/css/all.css\"\r\n");
      out.write("\trel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("<script src=\"js/jquery/jquery-1.3.2.min.js\" type=\"text/javascript\"></script>\r\n");
      out.write("<script src=\"js/ligerUI/ligerui.all.js\" type=\"text/javascript\"></script>\r\n");
      out.write("\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write("table.gridtable {\r\n");
      out.write("\tfont-size: 10px;\r\n");
      out.write("\tcolor: #333333;\r\n");
      out.write("\tborder-width: 1px;\r\n");
      out.write("\twidth: 100%;\r\n");
      out.write("\tborder-color: #666666;\r\n");
      out.write("\tborder-collapse: collapse;\r\n");
      out.write("\ttable-layout: fixed;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("table.gridtable th {\r\n");
      out.write("\tborder-width: 1px;\r\n");
      out.write("\tpadding: 8px;\r\n");
      out.write("\twidth: 200px;\r\n");
      out.write("\tborder-style: solid;\r\n");
      out.write("\tborder-color: #666666;\r\n");
      out.write("\tbackground-color: #dedede;\r\n");
      out.write("\tborder-style: solid;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("table.gridtable td {\r\n");
      out.write("\tborder-width: 1px;\r\n");
      out.write("\tpadding: 8px;\r\n");
      out.write("\tborder-style: solid;\r\n");
      out.write("\tborder-color: #666666;\r\n");
      out.write("\tbackground-color: #ffffff;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("a {\r\n");
      out.write("\ttext-decoration: none;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("a:hover {\r\n");
      out.write("\tcolor: #c6c6c6;\r\n");
      out.write("\tcursor: pointer;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("a:actived {\r\n");
      out.write("\ttext-decoration: none;\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("</head>\r\n");
      out.write("<body style=\"padding: 2px; \">\r\n");
      out.write("\t<dir style=\"float: left; padding-left:10px\">\r\n");
      out.write("\t\t<table>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td colspan=\"4\"><img alt=\"flow_chat\" src=\"images/flow_chat4.jpg\" height=\"100px\"></td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td><font size=\"5\"><strong>保存成功</strong></font></td>\r\n");
      out.write("\t\t\t\t<td><a class=\"l-button\" style=\"width:60px;float:left; margin-left:10px\"  href=\"system/Manage_downloadSyllabus.action\">下载</a></td>\r\n");
      out.write("\t\t\t\t<td></td>\r\n");
      out.write("\t\t\t\t<td></td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t");
      out.write("\r\n");
      out.write("\t\t</table>\r\n");
      out.write("\t</dir>\r\n");
      out.write("\t<div class=\"l-clear\"></div>\r\n");
      out.write("\t<div>\r\n");
      out.write("\t\t<table class=\"gridtable\" align=\"center\">\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<th colspan=\"2\" style=\"width:50px\"></th>\r\n");
      out.write("\t\t\t\t");

					List<Syllabus> courses = (List<Syllabus>) ActionContext
							.getContext().get("arrangedCourses");
					Integer roomCount = (Integer) ActionContext.getContext().get(
							"roomCount");
					List<String> order = (List<String>) ActionContext.getContext().get(
							"rooms");
					String week[] = new String[] { "一", "二", "三", "四", "五", "六" };
					for (String room : order) {
				
      out.write("\r\n");
      out.write("\t\t\t\t<th align=\"center\">");
      out.print(room);
      out.write("</th>\r\n");
      out.write("\t\t\t\t");

					}
				
      out.write("\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t");

					int count = roomCount;
					int day = 0;
					int slot = 0;
					for (Syllabus course : courses) {
						if (count == roomCount) {
							count = 0;
							if (slot > 4) {
								slot = 0;
								day++;
								if (day == 5)
									break;
							}
							if (slot == 0) {
				
      out.write("\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td rowspan=\"5\" style=\"padding:0px;\">\r\n");
      out.write("\t\t\t\t\t<p style=\"width:23px;margin-left: 10px\">");
      out.print(new String("周" + week[day]));
      out.write("</p>\r\n");
      out.write("\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t<td>");
      out.print(new String("第" + week[slot] + "大节"));
      out.write("</td>\r\n");
      out.write("\t\t\t\t<td align=\"center\">\r\n");
      out.write("\t\t\t\t<pre style=\"word-wrap: break-word; table-layout: fixed; width: 100%\">");
      out.print(course.getCourseName());
      out.write("<br>");
      out.print(course.getTeacherName());
      out.write("<br>");
      out.print(course.getClassName());
      out.write("<br>");
      out.print(course.getNote() );
      out.write("</pre>\r\n");
      out.write("\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t");

					} else {
				
      out.write("\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td>");
      out.print(new String("第" + week[slot] + "大节"));
      out.write("</td>\r\n");
      out.write("\t\t\t\t<td align=\"center\">\r\n");
      out.write("\t\t\t\t<pre style=\"word-wrap: break-word; table-layout: fixed; width: 100%\">");
      out.print(course.getCourseName());
      out.write("<br>");
      out.print(course.getTeacherName());
      out.write("<br>");
      out.print(course.getClassName());
      out.write("<br>");
      out.print(course.getNote() );
      out.write("</pre>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t");

					}
							slot++;
						} else {
				
      out.write("\r\n");
      out.write("\t\t\t\t<td align=\"center\">\r\n");
      out.write("\t\t\t\t<pre style=\"word-wrap: break-word; table-layout: fixed; width: 100%\">");
      out.print(course.getCourseName());
      out.write("<br>");
      out.print(course.getTeacherName());
      out.write("<br>");
      out.print(course.getClassName());
      out.write("<br>");
      out.print(course.getNote() );
      out.write("</pre>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t");

					}
						count++;
					}
				
      out.write("\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t</table>\r\n");
      out.write("\t</div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
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
