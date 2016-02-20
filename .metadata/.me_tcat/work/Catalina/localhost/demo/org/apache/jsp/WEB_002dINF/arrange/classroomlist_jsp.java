package org.apache.jsp.WEB_002dINF.arrange;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;

public final class classroomlist_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("js/ligerUI/skins/Aqua/css/ligerui-all.css\"rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("<link href=\"");
      out.print(basePath);
      out.write("js/ligerUI/skins/Gray/css/all.css\"rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("<script type=\"text/javascript\"src=\"js/jquery-validation/jquery.validate.min.js\" charset=\"utf-8\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"js/json2.js\" charset=\"utf-8\"></script>\r\n");
      out.write("<script type=\"text/javascript\"src=\"js/jquery-validation/jquery.metadata.js\" charset=\"utf-8\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"js/jquery-validation/messages_cn.js\"charset=\"utf-8\"></script>\r\n");
      out.write("<script src=\"js/jquery/jquery-1.3.2.min.js\" type=\"text/javascript\"></script>\r\n");
      out.write("<script src=\"js/ligerUI/core/base.js\" type=\"text/javascript\"></script>\r\n");
      out.write("<script src=\"js/ligerUI/ligerui.all.js\" type=\"text/javascript\"></script>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\t$(f_initGrid);\r\n");
      out.write("\tvar manager, g;\r\n");
      out.write("\tfunction f_initGrid() {\r\n");
      out.write("\t\tg = manager = $(\"#maingrid\").ligerGrid(\r\n");
      out.write("\t\t\t\t\t\t{\r\n");
      out.write("\t\t\t\t\t\t\tcolumns : [ {\r\n");
      out.write("\t\t\t\t\t\t\t\tdisplay : 'ID',\r\n");
      out.write("\t\t\t\t\t\t\t\tname : 'id',\r\n");
      out.write("\t\t\t\t\t\t\t\twidth : 60,\r\n");
      out.write("\t\t\t\t\t\t\t\ttype : 'int',\r\n");
      out.write("\t\t\t\t\t\t\t\thide : true\r\n");
      out.write("\t\t\t\t\t\t\t}, {\r\n");
      out.write("\t\t\t\t\t\t\t\tdisplay : '编号',\r\n");
      out.write("\t\t\t\t\t\t\t\tname : 'num',\r\n");
      out.write("\t\t\t\t\t\t\t\tminWidth : 120,\r\n");
      out.write("\t\t\t\t\t\t\t\teditor : {\r\n");
      out.write("\t\t\t\t\t\t\t\t\ttype : 'text'\r\n");
      out.write("\t\t\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\t\t}, {\r\n");
      out.write("\t\t\t\t\t\t\t\tdisplay : '名称',\r\n");
      out.write("\t\t\t\t\t\t\t\tname : 'roomname',\r\n");
      out.write("\t\t\t\t\t\t\t\tminWidth : 120,\r\n");
      out.write("\t\t\t\t\t\t\t\teditor : {\r\n");
      out.write("\t\t\t\t\t\t\t\t\ttype : 'text'\r\n");
      out.write("\t\t\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\t\t}, {\r\n");
      out.write("\t\t\t\t\t\t\t\tdisplay : '位置',\r\n");
      out.write("\t\t\t\t\t\t\t\tname : 'roomplace',\r\n");
      out.write("\t\t\t\t\t\t\t\tminWidth : 140,\r\n");
      out.write("\t\t\t\t\t\t\t\teditor : {\r\n");
      out.write("\t\t\t\t\t\t\t\t\ttype : 'text'\r\n");
      out.write("\t\t\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\t\t}, {\r\n");
      out.write("\t\t\t\t\t\t\t\tdisplay : '类型',\r\n");
      out.write("\t\t\t\t\t\t\t\tname : 'roomtype',\r\n");
      out.write("\t\t\t\t\t\t\t\tminWidth : 120,\r\n");
      out.write("\t\t\t\t\t\t\t\teditor : {\r\n");
      out.write("\t\t\t\t\t\t\t\t\ttype : 'text'\r\n");
      out.write("\t\t\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\t\t}, {\r\n");
      out.write("\t\t\t\t\t\t\t\tdisplay : '容量',\r\n");
      out.write("\t\t\t\t\t\t\t\tname : 'roomcapacity',\r\n");
      out.write("\t\t\t\t\t\t\t\tminWidth : 100,\r\n");
      out.write("\t\t\t\t\t\t\t\teditor : {\r\n");
      out.write("\t\t\t\t\t\t\t\t\ttype : 'text'\r\n");
      out.write("\t\t\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\t\t}, {\r\n");
      out.write("\t\t\t\t\t\t\t\tdisplay : '实际容量',\r\n");
      out.write("\t\t\t\t\t\t\t\tname : 'realcapacity',\r\n");
      out.write("\t\t\t\t\t\t\t\tminWidth : 100,\r\n");
      out.write("\t\t\t\t\t\t\t\teditor : {\r\n");
      out.write("\t\t\t\t\t\t\t\t\ttype : 'text'\r\n");
      out.write("\t\t\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\t\t}, {\r\n");
      out.write("\t\t\t\t\t\t\t\tdisplay : '备注',\r\n");
      out.write("\t\t\t\t\t\t\t\tname : 'note',\r\n");
      out.write("\t\t\t\t\t\t\t\tminWidth : 120,\r\n");
      out.write("\t\t\t\t\t\t\t\teditor : {\r\n");
      out.write("\t\t\t\t\t\t\t\t\ttype : 'text'\r\n");
      out.write("\t\t\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\t\t} ],\r\n");
      out.write("\t\t\t\t\t\t\tonSelectRow : function(rowdata, rowindex) {\r\n");
      out.write("\t\t\t\t\t\t\t\t$(\"#txtrowindex\").val(rowindex);\r\n");
      out.write("\t\t\t\t\t\t\t},\r\n");
      out.write("\t\t\t\t\t\t\t//checkbox:true,\r\n");
      out.write("\t\t\t\t\t\t\tenabledEdit : true,\r\n");
      out.write("\t\t\t\t\t\t\tclickToEdit : false,\r\n");
      out.write("\t\t\t\t\t\t\tisScroll : false,\r\n");
      out.write("\t\t\t\t\t\t\trownumbers : true,\r\n");
      out.write("\t\t\t\t\t\t\tpageSize : 30,\r\n");
      out.write("\t\t\t\t\t\t\turl : '");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/system/Manage_semesterroomlist.action',\r\n");
      out.write("\t\t\t\t\t\t\twidth : '100%'\r\n");
      out.write("\t\t\t\t\t\t});\r\n");
      out.write("\t}\r\n");
      out.write("\tfunction f_next(){\r\n");
      out.write("\t var str = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/system/Manage_getSyllabus.action?semChosenCourse.semester=\"+$(\"#semester\").val();\r\n");
      out.write("\t window.location.href=str;\r\n");
      out.write("\t}\r\n");
      out.write("</script>\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write("body {\r\n");
      out.write("\tfont-size: 12px;\r\n");
      out.write("}\r\n");
      out.write(".l-button{\r\n");
      out.write(" font-size: 12px;\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("</head>\r\n");
      out.write("<body style=\"padding: 2px; \">\r\n");
      out.write("    <input id=\"semester\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${semester }", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\" type=\"hidden\"  />\r\n");
      out.write("\t<dir style=\"float: left; padding-left:0px\">\r\n");
      out.write("\t\t\t<table>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td colspan=\"4\"><img alt=\"flow_chat\"src=\"images/flow_chat2.jpg\" height=\"100px\"></td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td height=\"25px\"> \t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t      <a class=\"l-button\"style=\"width:60px;float:left;  margin-left:10px;\" onclick=\"f_next()\" >排课</a></td>\r\n");
      out.write("\t\t\t\t\t<td></td>\r\n");
      out.write("\t\t\t\t\t<td></td>\r\n");
      out.write("\t\t\t\t\t<td></td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t</table>\r\n");
      out.write("\t\t</dir>\r\n");
      out.write("\t\t<div class=\"l-clear\"></div>\r\n");
      out.write("\t\t<div id=\"maingrid\"></div>\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
      out.write("\r\n");
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
