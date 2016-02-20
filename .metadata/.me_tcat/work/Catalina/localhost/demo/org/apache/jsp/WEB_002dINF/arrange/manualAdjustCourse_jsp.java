package org.apache.jsp.WEB_002dINF.arrange;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import org.springframework.web.context.request.SessionScope;
import java.util.*;

public final class manualAdjustCourse_jsp extends org.apache.jasper.runtime.HttpJspBase
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
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">\r\n");
      out.write("<html>\r\n");
      out.write("  <head>\r\n");
      out.write("    <base href=\"");
      out.print(basePath);
      out.write("\">   \r\n");
      out.write("    <title>天津工业大学排课管理系统</title>\t   \r\n");
      out.write("\t<link href=\"");
      out.print(basePath);
      out.write("js/ligerUI/skins/Aqua/css/ligerui-all.css\" rel=\"stylesheet\"type=\"text/css\" />\t\r\n");
      out.write("\t<link href=\"");
      out.print(basePath );
      out.write("js/ligerUI/skins/Gray/css/all.css\" rel=\"stylesheet\" type=\"text/css\"/>\t\r\n");
      out.write("     <link href=\"js/ligerUI/skins/ligerui-icons.css\" rel=\"stylesheet\" type=\"text/css\">\r\n");
      out.write("    <script type=\"text/javascript\" src=\"js/jquery-validation/jquery.validate.min.js\" charset=\"utf-8\"></script>\r\n");
      out.write("    <script type=\"text/javascript\" src=\"js/json2.js\" charset=\"utf-8\"></script>\r\n");
      out.write("    <!-- <script type=\"text/javascript\" src=\"js/jquery-validation/jquery.metadata.js\" charset=\"utf-8\"></script>\r\n");
      out.write("    <script type=\"text/javascript\" src=\"js/jquery-validation/messages_cn.js\" charset=\"utf-8\"></script> -->\r\n");
      out.write("    <script src=\"js/jquery/jquery-1.3.2.min.js\"type=\"text/javascript\"></script>\r\n");
      out.write("\t<script src=\"js/ligerUI/core/base.js\" type=\"text/javascript\"></script>\r\n");
      out.write("\t<script src=\"js/ligerUI/ligerui.all.js\" type=\"text/javascript\"></script>\r\n");
      out.write("\t<script src=\"js/ligerUI/plugins/ligerToolBar.js\" type=\"text/javascript\"></script>\r\n");
      out.write("<script type=\"text/javascript\">  \r\n");
      out.write("   var CoursecreditData = { \r\n");
      out.write("\t         Rows: [");
String ss=(String) request.getAttribute("coursecredit");
      out.print(ss);
      out.write("]};\r\n");
      out.write("   var CourseCredit = CoursecreditData.Rows;\r\n");
      out.write("   var CourseCharacterData = { \r\n");
      out.write("\t        Rows: [ ");
String sss=(String) request.getAttribute("character");
      out.write(' ');
      out.print(sss);
      out.write("]};\r\n");
      out.write("   var CourseCharacter = CourseCharacterData.Rows;\r\n");
      out.write("   var CourseCheckwayData = { \r\n");
      out.write("\t        Rows: [");
String ssss=(String) request.getAttribute("checkway");
      out.write(' ');
      out.print(ssss);
      out.write("]};\r\n");
      out.write("   var CourseCheckway = CourseCheckwayData.Rows;\r\n");
      out.write("  \r\n");
      out.write("\t$(f_initGrid);\r\n");
      out.write("\tvar manager, g;\r\n");
      out.write("\tfunction f_initGrid() {\r\n");
      out.write("\t\tg = manager = $(\"#maingrid\").ligerGrid(\r\n");
      out.write("\t\t\t\t{\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t\tcolumns : [{\r\n");
      out.write("\t\t\t\tdisplay : 'note',\r\n");
      out.write("\t\t\t\tname : 'note',\r\n");
      out.write("\t\t\t\twidth : 60,\r\n");
      out.write("\t\t\t\thide:true,\r\n");
      out.write("\t\t\t\ttype : 'int'\r\n");
      out.write("\t\t\t}, {\r\n");
      out.write("\t\t\t\tdisplay : '课程编号',\r\n");
      out.write("\t\t\t\tname : 'num',\r\n");
      out.write("\t\t\t\tWidth : 60,\r\n");
      out.write("\t\t\t} , {\r\n");
      out.write("\t\t\t\tdisplay : '课程名称',\r\n");
      out.write("\t\t\t\tname : 'courseName',\r\n");
      out.write("\t\t\t\twidth : 120,\r\n");
      out.write("\t\t\t},{\r\n");
      out.write("\t\t\t\tdisplay : '上课时间',columns:[\r\n");
      out.write("\t\t\t\t{ display:'礼拜' , name:'day',width : 60,  },\r\n");
      out.write("\t\t\t\t{ display:'大节' , name:'slot',  width : 60  }\r\n");
      out.write("\t\t\t\t]\t\t\t\r\n");
      out.write("\t\t\t} , {\r\n");
      out.write("\t\t\t\tdisplay : '教室',\r\n");
      out.write("\t\t\t\tname : 'roomNum',\r\n");
      out.write("\t\t\t\twidth : 200,\r\n");
      out.write("\t\t\t} , {\r\n");
      out.write("\t\t\t\tdisplay : '上课班级',\r\n");
      out.write("\t\t\t\tname : 'className',\r\n");
      out.write("\t\t\t\twidth : 200,\t\t\t\t\r\n");
      out.write("\t\t\t} /* , {\r\n");
      out.write("\t\t\t\tdisplay : '考核方式',\r\n");
      out.write("\t\t\t\tname : 'checkway',\r\n");
      out.write("\t\t\t\tminWidth : 120,\r\n");
      out.write("\t\t\t\teditor: { type: 'select', data: CourseCheckway, valueColumnName: 'Coursecheckway', displayColumnName: 'Coursecheckway' }, \r\n");
      out.write("                  render: function (item)\r\n");
      out.write("                    {\r\n");
      out.write("                        for (var i = 0; i < CourseCheckway.length; i++)\r\n");
      out.write("                        {\r\n");
      out.write("                            if (CourseCheckway[i]['Coursecheckway'] == item.checkway)\r\n");
      out.write("                                return CourseCheckway[i]['Coursecheckway'];\r\n");
      out.write("                        }\r\n");
      out.write("                        return item.Coursecheckway;\r\n");
      out.write("                    } \r\n");
      out.write("\t\t\t}  */\r\n");
      out.write("\t\t\t , {\r\n");
      out.write("\t\t\t\tdisplay : '任课教师',\r\n");
      out.write("\t\t\t\tname : 'teacherName',\r\n");
      out.write("\t\t\t\twidth : 60,\r\n");
      out.write("\t\t\t\teditor: { type: 'text'}\r\n");
      out.write("\t\t\t}  ],\r\n");
      out.write("\t\t\t\t\tonSelectRow : function(rowdata, rowindex) {\r\n");
      out.write("\t\t\t\t\t\t$(\"#txtrowindex\").val(rowindex);\r\n");
      out.write("\t\t\t\t\t},\r\n");
      out.write("\t\t\t\t\tenabledEdit : true,\r\n");
      out.write("\t\t\t\t\tclickToEdit : false,\r\n");
      out.write("\t\t\t\t\tisScroll : false,\r\n");
      out.write("\t\t\t\t\tcheckbox:false,\r\n");
      out.write("\t\t\t        rownumbers:true,\r\n");
      out.write("\t\t\t        pageSize:10,\r\n");
      out.write("\t\t\t\t\turl :'");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/system/Manage_semesterChosenDat.action',\r\n");
      out.write("\t\t\t\t\twidth : '100%',\r\n");
      out.write("\t\t\t\t});\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\tfunction fuzzy () {\r\n");
      out.write("\t\tvar t = $(\"#searchText\").val();\r\n");
      out.write("\t\t$(\"#maingrid\").ligerGrid({\r\n");
      out.write("\t\t  url:\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/system/Manage_semesterFuzzy.action?newnum=\" + encodeURI(encodeURI(t)),\r\n");
      out.write("\t\t  \t/* + \"&queryType=\" + $(\"#coursecharacter\").val() , */\r\n");
      out.write("\t\t});\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\tfunction tosubmit(){\r\n");
      out.write("\t\t var row = manager.getSelectedRow();\r\n");
      out.write("\t\t if (!row) { alert('请选择一个课程！'); return; }\r\n");
      out.write("\t\t var str = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/system/Manage_insertIntoSyllabus.action?insertID=\" + row.note;\r\n");
      out.write("\t\t $.post(str, null, function() {\r\n");
      out.write("\t\t\tparent.m.hide();\r\n");
      out.write("\t\t\tparent.window.location.reload();\r\n");
      out.write("\t\t});\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("</script>\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write("#head{\r\n");
      out.write(" width: 99%;\r\n");
      out.write(" height:80px;\r\n");
      out.write(" margin:auto;\r\n");
      out.write(" border:4px solid #c6c6c6 ;\r\n");
      out.write("}\r\n");
      out.write(".title{\r\n");
      out.write(" float: left;\r\n");
      out.write(" height: 100%;\r\n");
      out.write(" width: 10%;\r\n");
      out.write(" text-aligncenter;\r\n");
      out.write(" border-right:2px solid #c6c6c6 ;\r\n");
      out.write("}\r\n");
      out.write(".search{\r\n");
      out.write("  float: left;\r\n");
      out.write("}\r\n");
      out.write(".l-table-edit{\r\n");
      out.write(" height:100%;\r\n");
      out.write(" align:center;\r\n");
      out.write("}\r\n");
      out.write(".search.l-table-edit td{\r\n");
      out.write("  border-bottom: 1px solid #c6c6c6 ;\r\n");
      out.write("}\r\n");
      out.write(".link{\r\n");
      out.write("width:160px;height:25px;background: #fefefe;border: 1px solid #bbb;font-size: 14px;color: #333;border-radius: 3px;\r\n");
      out.write("}\r\n");
      out.write(".l-button{\r\n");
      out.write(" width:70px;float:left; margin:15px 160px 5px ;\r\n");
      out.write(" border-radiux:5px;\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("\t</head>\r\n");
      out.write("\t<body style=\"padding: 2px\">\t\t\r\n");
      out.write("\t\t<div id=\"head\">\r\n");
      out.write("\t      <div class=\"search\" >\r\n");
      out.write("\t         <table cellpadding=\"0\" cellspacing=\"0\" class=\"l-table-edit\" width=\"100%\" >\r\n");
      out.write("\t\t\t  \r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td align=\"right\" class=\"l-table-edit-td\" width=\"100px\" >&nbsp;&nbsp;关键字:&nbsp;</td>\r\n");
      out.write("\t\t\t\t<td align=\"left\" class=\"l-table-edit-td\">\r\n");
      out.write("\t\t\t\t  <input id=\"searchText\" onkeyup=\"fuzzy()\" class=\"link\" name=\"searchText\" />\r\n");
      out.write("\t\t\t\t</td>\t\t\r\n");
      out.write("\t\t\t   <!-- <td align=\"right\" class=\"l-table-edit-td\">&nbsp;&nbsp;&nbsp;课程性质:&nbsp;</td>\r\n");
      out.write("\t\t\t\t<td align=\"left\" class=\"l-table-edit-td\">\r\n");
      out.write("\t\t\t\t   <select id=\"coursecharacter\" name=\"coursecharacter\" class=\"link\" >\r\n");
      out.write("\t\t\t\t      <option value=\"-1\" ></option>\r\n");
      out.write("\t\t\t\t      <option value=\"0\" >必修</option>\r\n");
      out.write("\t\t\t\t      <option value=\"1\" >限选</option>\r\n");
      out.write("\t\t\t\t      <option value=\"2\" >任选</option>\t\t\t\t \r\n");
      out.write("\t\t\t\t   </select>\r\n");
      out.write("\t\t\t\t</td> -->\r\n");
      out.write("\t\t\t\t<td align=\"left\" class=\"l-table-edit-td\">\r\n");
      out.write("\t\t\t\t<a class=\"l-button\" onclick=\"tosubmit()\"><strong>置&nbsp;&nbsp;入</strong></a>\r\n");
      out.write("\t\t\t\t</td>\r\n");
      out.write("\t\t\t</tr>\t\t\t\t\t\t\r\n");
      out.write("\t\t</table>\r\n");
      out.write("\t\t<!-- <a class=\"l-button\" onclick=\"f_search()\"><strong>查&nbsp;&nbsp;询</strong></a> -->\r\n");
      out.write("\t\t\r\n");
      out.write("\t      </div>\r\n");
      out.write("\t    </div>\t\t\r\n");
      out.write("\t\t<div class=\"l-clear\"></div>\r\n");
      out.write("\t\t<div id=\"maingrid\" ></div>\r\n");
      out.write("\t</body>\r\n");
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
