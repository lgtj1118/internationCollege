package org.apache.jsp.WEB_002dINF.arrange;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.tjpu.bean.ClassroomModel;
import com.opensymphony.xwork2.ActionContext;
import com.tjpu.bean.Syllabus;
import com.tjpu.bean.ChosenCourseModel;
import java.util.*;
import java.io.*;

public final class adjustCourseInArrange_jsp extends org.apache.jasper.runtime.HttpJspBase
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
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<base href=\"");
      out.print(basePath);
      out.write("\">\r\n");
      out.write("\r\n");
      out.write("<title>天津工业大学排课管理系统</title>\r\n");
      out.write("\r\n");
      out.write("<meta http-equiv=\"pragma\" content=\"no-cache\">\r\n");
      out.write("<meta http-equiv=\"cache-control\" content=\"no-cache\">\r\n");
      out.write("<meta http-equiv=\"expires\" content=\"0\">\r\n");
      out.write("\r\n");
      out.write(" <script src=\"");
      out.print(basePath);
      out.write("js/jquery/jquery-1.6.min.js\" type=\"text/javascript\"></script>\r\n");
      out.write("<script src=\"js/ligerUI/ligerui.all.js\" type=\"text/javascript\"></script>\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\tfunction btnclose() {\r\n");
      out.write("\t\tparent.window.location.reload();\r\n");
      out.write("\t\twindow.close();\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\tfunction tonsubmit() {\r\n");
      out.write("\t\tif (!flag){\r\n");
      out.write("\t\t\talert(\"不可交换的位置！\");\r\n");
      out.write("\t\t\treturn;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t//var newnum = $(\"#options\").val();\r\n");
      out.write("\t\tvar newnum = $(\"#newnum\").val();\r\n");
      out.write("\t\tvar old = $(\"#oldnum\").val();\r\n");
      out.write("\t\t//alert(newnum);\r\n");
      out.write("\t\tvar str = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/system/Manage_applyNewSyllabus.action?newnum=\"\r\n");
      out.write("\t\t\t\t+ newnum + \"&oldnum=\" + old;\r\n");
      out.write("\t\t$.post(str, null, function() {\r\n");
      out.write("\t\t\tparent.m.hide();\r\n");
      out.write("\t\t\tparent.window.location.reload();\r\n");
      out.write("\t\t});\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\tvar flag = false;\r\n");
      out.write("\t\t\r\n");
      out.write("\tfunction tips() {\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tvar week = $(\"#week\").val();\r\n");
      out.write("\t\tvar slot = $(\"#slot\").val();\r\n");
      out.write("\t\tvar room = $(\"#room\").val();\r\n");
      out.write("\t\tvar oldnum = $(\"#oldnum\").val();\r\n");
      out.write("\t\r\n");
      out.write("\t\t//alert(room);\r\n");
      out.write("\t\tvar url = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/system/Manage_adjustTips.action?newSlot=\" + slot\r\n");
      out.write("\t\t\t\t\t+ \"&plandate=\" + week + \"&newRoomNum=\" + room + \"&oldnum=\" + oldnum;\r\n");
      out.write("\t\t\t$.ajax({  \r\n");
      out.write("\t\t        type : \"POST\",  \r\n");
      out.write("\t\t        url : url,\r\n");
      out.write("\t\t        dataType : \"JSON\", \r\n");
      out.write("\t\t        error: function (){\r\n");
      out.write("\t\t        \talert(\"数据传输错误，请联系管理员！\");\r\n");
      out.write("\t\t        },\r\n");
      out.write("\t\t        success : function(data) { \r\n");
      out.write("\t\t        \t\r\n");
      out.write("\t\t        \tif (data.length > 0){\r\n");
      out.write("\t\t        \t\tfor(var n=0;n<data.length;n++){\r\n");
      out.write("\t\t        \t\t\t//alert(data[n].courseName);\r\n");
      out.write("\t\t                \t$(\"#newCourseName\").val(data[n].courseName);\r\n");
      out.write("\t\t                \t$(\"#newnum\").val(data[n].num);\r\n");
      out.write("\t\t                \tflag = true;\r\n");
      out.write("\t\t          \t\t}\r\n");
      out.write("\t\t        \t} else {\r\n");
      out.write("\t\t        \t\t$(\"#newCourseName\").val(\"不可交换的位置！\");\r\n");
      out.write("\t\t        \t\t$(\"#newnum\").val(\"\");\r\n");
      out.write("\t\t        \t\tflag = false;\r\n");
      out.write("\t\t        \t}\r\n");
      out.write("\t\t        }  \r\n");
      out.write("\t\t    }); \r\n");
      out.write("\t}\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write("body {\r\n");
      out.write("\tfont-size: 12px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".l-table-edit {\r\n");
      out.write("\t\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".l-table-edit-td {\r\n");
      out.write("\tpadding: 4px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".l-button-submit,.l-button-test {\r\n");
      out.write("\twidth: 80px;\r\n");
      out.write("\tfloat: left;\r\n");
      out.write("\tmargin-left: 10px;\r\n");
      out.write("\tpadding-bottom: 2px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".l-verify-tip {\r\n");
      out.write("\tleft: 230px;\r\n");
      out.write("\ttop: 120px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("#errorLabelContainer {\r\n");
      out.write("\tpadding: 10px;\r\n");
      out.write("\twidth: 300px;\r\n");
      out.write("\tborder: 1px solid #FF4466;\r\n");
      out.write("\tdisplay: none;\r\n");
      out.write("\tbackground: #FFEEEE;\r\n");
      out.write("\tcolor: Red;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".link {\r\n");
      out.write("\twidth: 170px;\r\n");
      out.write("\theight: 25px;\r\n");
      out.write("\tbackground: #fefefe;\r\n");
      out.write("\tborder: 1px solid #bbb;\r\n");
      out.write("\tfont-size: 12px;\r\n");
      out.write("\tcolor: #333;\r\n");
      out.write("\tborder-radius: 3px;\r\n");
      out.write("}\r\n");
      out.write("/* .date_selector .month_nav{float: left;width: 40%;}\r\n");
      out.write(".date_selector .year_nav{float: right;width: 35%;margin-right: 60px;} */\r\n");
      out.write("textarea {\r\n");
      out.write("\twidth: 100%;\r\n");
      out.write("\theight: 100px;\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("\t");

		ChosenCourseModel old = (ChosenCourseModel)ActionContext.getContext().get("old");
	 
      out.write("\r\n");
      out.write("\t<input type=\"hidden\" value=");
      out.print(old.getNum());
      out.write(" id=\"oldnum\">\r\n");
      out.write("\t<input type=\"hidden\" id=\"newnum\"> \r\n");
      out.write("\t<table cellpadding=\"0\" cellspacing=\"0\" class=\"l-table-edit\" >\r\n");
      out.write("    \t<tr style=\"font-size:12px\">\r\n");
      out.write("    \t\t<td align=\"center\" class=\"l-table-edit-td\">课程名</td>\r\n");
      out.write("    \t\t<td align=\"center\" class=\"l-table-edit-td\">\r\n");
      out.write("    \t\t\t<input type=\"text\" class=\"link\" disabled value=\"");
      out.print(old.getCourse().getCoursename());
      out.write("\">\r\n");
      out.write("\t\t\t</td>\r\n");
      out.write("\t\t\t<td align=\"center\" class=\"l-table-edit-td\">课程号</td>\r\n");
      out.write("    \t\t<td align=\"center\" class=\"l-table-edit-td\">\r\n");
      out.write("    \t\t\t<input type=\"text\" class=\"link\" disabled value=\"");
      out.print(old.getCourse().getNum());
      out.write("\">\r\n");
      out.write("\t\t\t</td>\r\n");
      out.write("\t\t\t<td align=\"center\" class=\"l-table-edit-td\"></td>\r\n");
      out.write("    \t\t<td align=\"left\"></td>\r\n");
      out.write("    \t</tr>\r\n");
      out.write("    \t<tr style=\"font-size:12px\">\r\n");
      out.write("    \t\t<td align=\"center\" class=\"l-table-edit-td\"><strong>可调换位置</strong></td>\r\n");
      out.write("    \t\t<td align=\"left\"></td>\r\n");
      out.write("    \t</tr>\r\n");
      out.write("    \t<tr style=\"font-size:12px\">\r\n");
      out.write("    \t\t<td align=\"center\" class=\"l-table-edit-td\">礼拜</td>\r\n");
      out.write("    \t\t<td align=\"center\" class=\"l-table-edit-td\" class=\"link\">\r\n");
      out.write("    \t\t\t<select id=\"week\" onchange=\"tips()\" class=\"link\">\r\n");
      out.write("    \t\t\t\t<option value=\"0\">星期一</option>\r\n");
      out.write("    \t\t\t\t<option value=\"1\">星期二</option>\r\n");
      out.write("    \t\t\t\t<option value=\"2\">星期三</option>\r\n");
      out.write("    \t\t\t\t<option value=\"3\">星期四</option>\r\n");
      out.write("    \t\t\t\t<option value=\"4\">星期五</option>\r\n");
      out.write("    \t\t\t</select>\r\n");
      out.write("    \t\t</td>\r\n");
      out.write("    \t\t\r\n");
      out.write("\t\t\t<td align=\"center\" class=\"l-table-edit-td\">节次</td>\r\n");
      out.write("\t\t\t<td align=\"center\" class=\"l-table-edit-td\">\r\n");
      out.write("\t\t\t\t<select id=\"slot\" onchange=\"tips()\" class=\"link\">\r\n");
      out.write("    \t\t\t\t<option value=\"0\">第一大节</option>\r\n");
      out.write("    \t\t\t\t<option value=\"1\">第二大节</option>\r\n");
      out.write("    \t\t\t\t<option value=\"2\">第三大节</option>\r\n");
      out.write("    \t\t\t\t<option value=\"3\">第四大节</option>\r\n");
      out.write("    \t\t\t\t<option value=\"4\">第五大节</option>\r\n");
      out.write("    \t\t\t</select>\r\n");
      out.write("\t\t\t</td>\r\n");
      out.write("\t\t\t<td align=\"left\"></td>\r\n");
      out.write("    \t</tr>\r\n");
      out.write("    \t<tr style=\"font-size:12px\">\r\n");
      out.write("    \t\t<td align=\"center\" class=\"l-table-edit-td\">可用教室</td>\r\n");
      out.write("    \t\t<td align=\"center\" class=\"l-table-edit-td\">\r\n");
      out.write("    \t\t\t<select id=\"room\" onchange=\"tips()\" class=\"link\"  >\r\n");
      out.write("    \t\t\t\t");

    					List<ClassroomModel> rooms = (List<ClassroomModel>)ActionContext.getContext().get("rooms");
    					for (ClassroomModel r : rooms){
    				
      out.write("\r\n");
      out.write("    \t\t\t\t\t<option value=\"");
      out.print(r.getNum());
      out.write('"');
      out.write('>');
      out.print(r.getAddress() );
      out.write("</option>\r\n");
      out.write("    \t\t\t\t");
	
    					}
    				 
      out.write("\r\n");
      out.write("    \t\t\t</select>\r\n");
      out.write("    \t\t</td>\r\n");
      out.write("    \t\t\r\n");
      out.write("\t\t\t<td align=\"center\" class=\"l-table-edit-td\">课程名</td>\r\n");
      out.write("\t\t\t<td align=\"center\" class=\"l-table-edit-td\">\r\n");
      out.write("\t\t\t\t<input type=\"text\" class=\"link\" disabled id=\"newCourseName\">\r\n");
      out.write("\t\t\t</td>\r\n");
      out.write("\t\t\t<td align=\"left\"></td>\r\n");
      out.write("    \t</tr>\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t\t<td align=\"right\" class=\"l-table-edit-td\"></td>\r\n");
      out.write("\t\t\t\t<td align=\"right\" class=\"l-table-edit-td\"></td>\r\n");
      out.write("\t\t\t\t<td align=\"left\" class=\"l-table-edit-td\">\r\n");
      out.write("\t\t\t\t\t<input type=\"submit\" value=\"调&nbsp;&nbsp;换\" id=\"Button1\" \r\n");
      out.write("\t\t\t\t\t\tonclick=\"tonsubmit()\" class=\"l-button l-button-submit\" />\r\n");
      out.write("\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t<td align=\"left\">\r\n");
      out.write("\t\t\t\t<td align=\"left\">\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("    </table>\r\n");
      out.write("  \r\n");
      out.write("    <script type=\"text/javascript\">tips();</script>\r\n");
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
