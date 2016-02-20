package org.apache.jsp.WEB_002dINF.course;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.tjpu.bean.AdjustcourseModel;
import com.opensymphony.xwork2.ActionContext;
import com.tjpu.bean.Syllabus;
import com.tjpu.bean.ChosenCourseModel;
import org.springframework.web.context.request.SessionScope;
import java.util.*;
import java.io.*;

public final class classTeacherCurriculum_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\twidth: 150px;\r\n");
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
      out.write("\t<br>\r\n");
      out.write("\r\n");
      out.write("\t<div style=\"font-size:large; font-weight: bold; width: 300px; margin-right: 0px\">教师课表</div>\r\n");
      out.write("\t\r\n");
      out.write("\t<div>\r\n");
      out.write("\t\t<a class=\"l-button\" style=\"width:60px;float:left;margin-top:10px; margin-bottom: 10px\" href=\"system/Class_downloadSyllabus.action\">下载</a>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<div class=\"l-clear\"></div>\r\n");
      out.write("\t<div>\r\n");
      out.write("\t\t<table class=\"gridtable\" align=\"center\">\r\n");
      out.write("\t\t\t<!-- <tr>\r\n");
      out.write("\t\t\t\t<th colspan=\"2\" style=\"width:50px\"></th> -->\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<th style=\"width:53px\"></th>\r\n");
      out.write("\t\t\t\t");

					List<Syllabus> courses = (List<Syllabus>) ActionContext
							.getContext().get("courses");
					String week[] = new String[] { "一", "二", "三", "四", "五"};
					for (String n : week) {
				
      out.write("\r\n");
      out.write("\t\t\t\t<th>周");
      out.print(n);
      out.write("</th>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t");

					}
				
      out.write("\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\r\n");
      out.write("\t\t\t");

				int day = 5;
				int slot = 0;
				for (Syllabus course : courses) {
				
					if (day == 5) {
						day = 0;
						if (slot == 5){
							break;
						}
			
      out.write("\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td>第");
      out.print(week[slot]);
      out.write("大节</td>\r\n");
      out.write("\t\t\t\t<td align=\"center\"><pre\r\n");
      out.write("\t\t\t\t\t\tstyle=\"word-wrap: break-word; table-layout: fixed; width: 100%\">");
      out.print(course.getCourseName());
      out.write("<br>");
      out.print(course.getTeacherName());
      out.write("<br>");
      out.print(course.getClassName());
      out.print(course.getRoomNum());
      out.write("<br>");
      out.print(course.getNote() );
      out.write("</pre>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t</td>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t");

						slot++;
					} else if (day == 4) {
				
      out.write("\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t<td align=\"center\"><pre\r\n");
      out.write("\t\t\t\t\t\tstyle=\"word-wrap: break-word; table-layout: fixed; width: 100%\">");
      out.print(course.getCourseName());
      out.write("<br>");
      out.print(course.getTeacherName());
      out.write("<br>");
      out.print(course.getClassName());
      out.print(course.getRoomNum());
      out.write("<br>");
      out.print(course.getNote() );
      out.write("</pre>\r\n");
      out.write("\t\t\t\t</td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t");

				} else {
			
      out.write("\r\n");
      out.write("\t\t\t<td align=\"center\"><pre\r\n");
      out.write("\t\t\t\t\t\tstyle=\"word-wrap: break-word; table-layout: fixed; width: 100%\">");
      out.print(course.getCourseName());
      out.write("<br>");
      out.print(course.getTeacherName());
      out.write("<br>");
      out.print(course.getClassName());
      out.print(course.getRoomNum());
      out.write("<br>");
      out.print(course.getNote() );
      out.write("</pre>\r\n");
      out.write("\r\n");
      out.write("\t\t\t</td>\r\n");
      out.write("\t\t\t");

				}
					day++;
				}
			
      out.write("\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t</table>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<div>\r\n");
      out.write("\t<p>\r\n");
      out.write("\t\t");
  List<AdjustcourseModel> relateAdjust = (List<AdjustcourseModel>) ActionContext.getContext().get("relateAdjust");
			
			for (AdjustcourseModel i : relateAdjust) {
		
      out.write("\r\n");
      out.write("\t\t\t\t<strong style=\"color:red\">*</strong>");
      out.print(i.getOlddate() );
      out.write('第');
      out.print(i.getOldslot());
      out.write('大');
      out.write('节');
      out.write('的');
      out.print(i.getOldCourseName() );
      out.write("调换至&nbsp;&nbsp;");
      out.print(i.getNewroomName());
      out.write("&nbsp;&nbsp;");
      out.print(i.getNewdate() );
      out.write('第');
      out.print(i.getNewslot() );
      out.write('大');
      out.write('节');
      out.print(i.getNewCourseName() );
      out.write("<br>\r\n");
      out.write("\t\t");

			}
		
      out.write("\r\n");
      out.write("\t\t</p>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t");
	List<List<Syllabus>> courses2 = (List<List<Syllabus>>) ActionContext.getContext().get("courses2");
		int classNameIndex = 0;
		List<String> className = (List<String>) ActionContext.getContext().get("className"); 
		for (List<Syllabus> i : courses2) {
		
      out.write("\r\n");
      out.write("\t\t<br>\r\n");
      out.write("\t\t<br>\r\n");
      out.write("\t\t<div style=\"font-size:large; font-weight: bold; width: 300px; margin-right: 0px\">");
      out.print(className.get(classNameIndex++) );
      out.write("</div>\t\r\n");
      out.write("\t<div>\r\n");
      out.write("\t\t<a class=\"l-button\" style=\"width:60px;float:left;margin-top:10px; margin-bottom: 10px\" href=\"system/Class_downloadOnChargedSyllabus.action?num=");
      out.print(courses2.indexOf(i));
      out.write("\">下载</a>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t\t<div>\r\n");
      out.write("\t\t<table class=\"gridtable\" align=\"center\">\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<th style=\"width:53px\"></th>\r\n");
      out.write("\t\t\t\t");

					for (String n : week) {
				
      out.write("\r\n");
      out.write("\t\t\t\t<th>周");
      out.print(n);
      out.write("</th>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t");

					}
				
      out.write("\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\r\n");
      out.write("\t\t\t");

				day = 5;
				slot = 0;
				for (Syllabus course : i) {
				
					if (day == 5) {
						day = 0;
						if (slot == 5){
							break;
						}
			
      out.write("\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td>第");
      out.print(week[slot]);
      out.write("大节</td>\r\n");
      out.write("\t\t\t\t<td align=\"center\"><pre\r\n");
      out.write("\t\t\t\t\t\tstyle=\"word-wrap: break-word; table-layout: fixed; width: 100%\">");
      out.print(course.getCourseName());
      out.write("<br>");
      out.print(course.getTeacherName());
      out.write("<br>");
      out.print(course.getClassName());
      out.print(course.getRoomNum());
      out.write("<br>");
      out.print(course.getNote() );
      out.write("</pre>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t</td>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t");

						slot++;
					} else if (day == 4) {
				
      out.write("\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t<td align=\"center\"><pre\r\n");
      out.write("\t\t\t\t\t\tstyle=\"word-wrap: break-word; table-layout: fixed; width: 100%\">");
      out.print(course.getCourseName());
      out.write("<br>");
      out.print(course.getTeacherName());
      out.write("<br>");
      out.print(course.getClassName());
      out.print(course.getRoomNum());
      out.write("<br>");
      out.print(course.getNote() );
      out.write("</pre>\r\n");
      out.write("\t\t\t\t</td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t");

				} else {
			
      out.write("\r\n");
      out.write("\t\t\t<td align=\"center\"><pre\r\n");
      out.write("\t\t\t\t\t\tstyle=\"word-wrap: break-word; table-layout: fixed; width: 100%\">");
      out.print(course.getCourseName());
      out.write("<br>");
      out.print(course.getTeacherName());
      out.write("<br>");
      out.print(course.getClassName());
      out.print(course.getRoomNum());
      out.write("<br>");
      out.print(course.getNote() );
      out.write("</pre>\r\n");
      out.write("\r\n");
      out.write("\t\t\t</td>\r\n");
      out.write("\t\t\t");

				}
					day++;
				}
			
      out.write("\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t</table>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t");

		}
		
	
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
