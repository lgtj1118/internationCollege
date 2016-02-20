package org.apache.jsp.WEB_002dINF.student;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import org.springframework.web.context.request.SessionScope;
import java.util.*;

public final class makeupcourse_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("    <title>天津工业大学国际教育学院教学服务系统</title>\t   \r\n");
      out.write("\t<link href=\"");
      out.print(basePath);
      out.write("js/ligerUI/skins/Aqua/css/ligerui-all.css\" rel=\"stylesheet\"type=\"text/css\" />\t\r\n");
      out.write("\t<link href=\"");
      out.print(basePath );
      out.write("js/ligerUI/skins/Gray/css/all.css\" rel=\"stylesheet\" type=\"text/css\"/>\t\r\n");
      out.write("    <script type=\"text/javascript\" src=\"js/jquery-validation/jquery.validate.min.js\" charset=\"utf-8\"></script>\r\n");
      out.write("    <script type=\"text/javascript\" src=\"js/json2.js\" charset=\"utf-8\"></script>\r\n");
      out.write("    <script type=\"text/javascript\" src=\"js/jquery-validation/jquery.metadata.js\" charset=\"utf-8\"></script>\r\n");
      out.write("    <script type=\"text/javascript\" src=\"js/jquery-validation/messages_cn.js\" charset=\"utf-8\"></script>\r\n");
      out.write("    <script src=\"js/jquery/jquery-1.3.2.min.js\"type=\"text/javascript\"></script>\r\n");
      out.write("\t<script src=\"js/ligerUI/core/base.js\" type=\"text/javascript\"></script>\r\n");
      out.write("\t<script src=\"js/ligerUI/ligerui.all.js\" type=\"text/javascript\"></script>\r\n");
      out.write("\t<!-- <script type=\"text/javascript\" src=\"js/semester.js\" ></script> -->\r\n");
      out.write("<script type=\"text/javascript\">  \r\n");
      out.write("$(document).ready(function(){\t\t\t\r\n");
      out.write("\tvar nowDate = new Date();\r\n");
      out.write("\tvar nowYear = nowDate.getFullYear();\r\n");
      out.write("\tvar lastYear = parseInt(nowYear)-1;\r\n");
      out.write("\tvar before = parseInt(lastYear)-1;\r\n");
      out.write("\tvar nextYear = parseInt(nowYear)+1;\r\n");
      out.write("\tvar nowuptext = lastYear+\"-\"+nowYear+\"学年第一学期\";//2014-2015\r\n");
      out.write("\tvar nowupvalue = lastYear+\"01\";\r\n");
      out.write("\tvar nowdowntext = lastYear+\"-\"+nowYear + \"学年第二学期\";\r\n");
      out.write("\tvar nowdownvalue = nowYear+\"02\";\r\n");
      out.write("\tvar lastuptext = before+\"-\"+lastYear+\"学年第一学期\";\r\n");
      out.write("\tvar lastupvalue = before+\"01\";\r\n");
      out.write("\tvar lastdowntext = before+\"-\"+lastYear+\"学年第二学期\";\r\n");
      out.write("\tvar lastdownvalue = lastYear+\"02\";\r\n");
      out.write("\tvar nextuptext = nowYear+\"-\"+nextYear+\"学年第一学期\";\r\n");
      out.write("\tvar nextupvalue = nowYear+\"01\";\r\n");
      out.write("\tvar nextdowntext = nowYear+\"-\"+nextYear+\"学年第二学期\";\r\n");
      out.write("\tvar nextdownvalue = nextYear+\"02\";\r\n");
      out.write("\tvar semester = document.getElementById(\"semester\");\r\n");
      out.write("\tvar objOption=document.createElement(\"OPTION\"); \r\n");
      out.write("    var objOption1=document.createElement(\"OPTION\");\r\n");
      out.write("    var objOption2=document.createElement(\"OPTION\"); \r\n");
      out.write("    var objOption3=document.createElement(\"OPTION\"); \r\n");
      out.write("    var objOption4=document.createElement(\"OPTION\"); \r\n");
      out.write("    var objOption5=document.createElement(\"OPTION\"); \r\n");
      out.write("    objOption.value=nowupvalue;   objOption.text=nowuptext;\r\n");
      out.write("    objOption1.value=nowdownvalue;  objOption1.text=nowdowntext;\r\n");
      out.write("    objOption2.value=lastupvalue;  objOption2.text=lastuptext;\r\n");
      out.write("    objOption3.value=lastdownvalue;  objOption3.text=lastdowntext;\r\n");
      out.write("    objOption4.value=nextupvalue;  objOption4.text=nextuptext;\r\n");
      out.write("    objOption5.value=nextdownvalue;  objOption5.text=nextdowntext;\r\n");
      out.write("    var month = nowDate.getMonth();\r\n");
      out.write("\tvar now;\r\n");
      out.write("\tif (month > 9) {\r\n");
      out.write("\t\tnow = nowYear + \"01\";\r\n");
      out.write("\t} else {\r\n");
      out.write("\t\tnow = nowYear + \"02\";\r\n");
      out.write("\t}\r\n");
      out.write("\tif(now==nowupvalue){\r\n");
      out.write("\t\tsemester.add(objOption2);\r\n");
      out.write("        semester.add(objOption3);\r\n");
      out.write("        semester.add(objOption);\r\n");
      out.write("        semester.options[semester.options.length-1].selected='selected';\r\n");
      out.write("        semester.add(objOption1);                \r\n");
      out.write("        semester.add(objOption4);\r\n");
      out.write("        semester.add(objOption5);        \t\t\r\n");
      out.write("\t}else if(now==nowdownvalue) {\r\n");
      out.write("\t\tsemester.add(objOption2);\r\n");
      out.write("        semester.add(objOption3);\r\n");
      out.write("        semester.add(objOption);        \r\n");
      out.write("        semester.add(objOption1); \r\n");
      out.write("        semester.options[semester.options.length-1].selected='selected';\r\n");
      out.write("        semester.add(objOption4);\r\n");
      out.write("        semester.add(objOption5);\r\n");
      out.write("\t}\r\n");
      out.write("        \r\n");
      out.write("    \r\n");
      out.write("})\r\n");
      out.write("\t$(f_initGrid);\r\n");
      out.write("\tvar manager, g;\r\n");
      out.write("\tfunction f_initGrid() {\r\n");
      out.write("\t\tg = manager = $(\"#maingrid\").ligerGrid(\r\n");
      out.write("\t\t\t\t{\r\n");
      out.write("\t\t\t\tcolumns : [{\r\n");
      out.write("\t\t\t\tdisplay : 'ID',\r\n");
      out.write("\t\t\t\tname : 'id',\r\n");
      out.write("\t\t\t\twidth : 60,\r\n");
      out.write("\t\t\t\thide:true,\r\n");
      out.write("\t\t\t\ttype : 'int'\r\n");
      out.write("\t\t\t}, {\r\n");
      out.write("\t\t\t\tdisplay : '课程编号',\r\n");
      out.write("\t\t\t\tname : 'num',\r\n");
      out.write("\t\t\t\tminWidth : 40,\r\n");
      out.write("\t\t\t\teditor: { type: 'text'}\r\n");
      out.write("\t\t\t} , {\r\n");
      out.write("\t\t\t\tdisplay : '课程名称',\r\n");
      out.write("\t\t\t\tname : 'coursename',\r\n");
      out.write("\t\t\t\tminWidth : 120,\r\n");
      out.write("\t\t\t\teditor: { type: 'text'}\r\n");
      out.write("\t\t\t}/* , {\r\n");
      out.write("\t\t\t\tdisplay : '负责教师',\r\n");
      out.write("\t\t\t\tname : 'teacher',\r\n");
      out.write("\t\t\t\twidth : 120,\r\n");
      out.write("\t\t\t\teditor: { type: 'text'}\r\n");
      out.write("\t\t\t} */,{\r\n");
      out.write("\t\t\t\t\tdisplay : '操作',\r\n");
      out.write("\t\t\t\t\tisSort : false,\r\n");
      out.write("\t\t\t\t\tminWidth : 120,\r\n");
      out.write("\t\t\t\t\trender : function() {\r\n");
      out.write("\t\t\t\t\t\tvar h = \"\";\r\n");
      out.write("\t\t\t\t\t\th += \"<a style='color:#000;' href='javascript:entryscore(\"+ \")'>录入补考成绩</a> \";\r\n");
      out.write("\t\t\t\t\t\treturn h;\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t} ],\r\n");
      out.write("\t\t\t\t\tonSelectRow : function(rowdata, rowindex) {\r\n");
      out.write("\t\t\t\t\t\t$(\"#txtrowindex\").val(rowindex);\r\n");
      out.write("\t\t\t\t\t},\r\n");
      out.write("\t\t\t\t\tenabledEdit : true,\r\n");
      out.write("\t\t\t\t\tclickToEdit : false,\r\n");
      out.write("\t\t\t\t\tisScroll : false,\r\n");
      out.write("\t\t\t\t\tcheckbox:false,\r\n");
      out.write("\t\t\t        rownumbers:true,\r\n");
      out.write("\t\t\t\t\turl :'");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/system/Manage_attendencecourselist.action',\r\n");
      out.write("\t\t\t\t\twidth : '100%'\r\n");
      out.write("\t\t\t\t});\r\n");
      out.write("\t}\r\n");
      out.write("    function entryscore(){\r\n");
      out.write("      var semester = $(\"#semester option:selected\").val();\r\n");
      out.write("      var major = $(\"#major\").val();\r\n");
      out.write("      if(semester.length==0){\r\n");
      out.write("        alert(\"请选择学期\");\r\n");
      out.write("      }else{\r\n");
      out.write("        var row = manager.getSelectedRow();\t\r\n");
      out.write("        var flag = 1;//补考\r\n");
      out.write("        var str = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/system/Manage_makeupscoreentry.action?course.num=\"+row.num+\"&course.coursename=\"+row.coursename+\"&semChosenCourse.semester=\"+semester+\"&flag=\"+flag;\t\t  \r\n");
      out.write("\t    var tabid = \"courseclasslist\";\r\n");
      out.write("        top.f_addTab(tabid,row.coursename+\"补考成绩录入\",str);\r\n");
      out.write("      }    \r\n");
      out.write("    }\r\n");
      out.write("    function f_search(){\r\n");
      out.write("      var semester = $(\"#semester option:selected\").val();\r\n");
      out.write("      var major = $(\"#major\").val();\r\n");
      out.write("      if(semester.length==0){\r\n");
      out.write("        $(\"#maingrid\").ligerGrid({\r\n");
      out.write("\t\t\turl : '");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/system/Manage_attendencecourselist.action'\r\n");
      out.write("\t\t})\r\n");
      out.write("      }else{\r\n");
      out.write("         var str = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/system/Manage_searchsemestercourselist.action?semChosenCourse.semester=\"+semester;\r\n");
      out.write("         $(\"#maingrid\").ligerGrid({\r\n");
      out.write("\t\t\turl : str\r\n");
      out.write("\t\t})\r\n");
      out.write("      }\r\n");
      out.write("    }\r\n");
      out.write("</script>\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write("#head{\r\n");
      out.write(" width: 99%;\r\n");
      out.write(" height:90px;\r\n");
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
      out.write("  margin-top: 25px;\r\n");
      out.write("}\r\n");
      out.write(".l-table-edit{\r\n");
      out.write(" margin-top: 10px;\r\n");
      out.write(" margin-left: 20px;\r\n");
      out.write("}\r\n");
      out.write(".link{\r\n");
      out.write("width:180px;height:25px;background: #fefefe;border: 1px solid #bbb;font-size: 14px;color: #333;border-radius: 3px;\r\n");
      out.write("}\r\n");
      out.write(".l-button{\r\n");
      out.write(" width:70px;float:left; margin:20px 160px 5px ;\r\n");
      out.write(" border-radiux:5px;\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("\t</head>\r\n");
      out.write("\t<body style=\"padding: 2px\">\t\r\n");
      out.write("\t    <div id=\"head\">\r\n");
      out.write("\t      <div class=\"title\" ><br><br><div align=\"center\"><font face=\"微软雅黑\" color=\"#400000\" size=\"4\"><strong>条件选择</strong></font></div></div>\r\n");
      out.write("\t      <div class=\"search\" >\r\n");
      out.write("\t         <table cellpadding=\"0\" cellspacing=\"0\" class=\"l-table-edit\" >\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td align=\"right\" class=\"l-table-edit-td\">&nbsp;开课学期:&nbsp;</td>\r\n");
      out.write("\t\t\t\t<td align=\"left\" class=\"l-table-edit-td\">\r\n");
      out.write("\t\t\t\t   <select id=\"semester\" name=\"semester\" class=\"link\" >\r\n");
      out.write("\t\t\t\t      <option value=\"\" ></option>\r\n");
      out.write("\t\t\t\t      <!-- <option value=\"201301\" >2013年上学期</option>\r\n");
      out.write("\t\t\t\t      <option value=\"201302\" >2013年下学期</option>\r\n");
      out.write("\t\t\t\t      <option value=\"201401\" >2014年上学期</option>\r\n");
      out.write("\t\t\t\t      <option value=\"201402\" >2014年下学期</option>\r\n");
      out.write("\t\t\t\t      <option value=\"201501\" >2015年上学期</option>\r\n");
      out.write("\t\t\t\t       <option value=\"201502\">2015年下学期</option> -->\r\n");
      out.write("\t\t\t\t   </select>\r\n");
      out.write("\t\t\t\t</td>\r\n");
      out.write("\t\t\t    <td align=\"right\" class=\"l-table-edit-td\">&nbsp;&nbsp;专业:&nbsp;</td>\r\n");
      out.write("\t\t\t\t<td align=\"left\" class=\"l-table-edit-td\">\r\n");
      out.write("\t\t\t\t  <input id=\"major\" class=\"link\" name=\"major\" value=\"汉语言\" />\r\n");
      out.write("\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t<td align=\"right\" class=\"l-table-edit-td\"></td>\r\n");
      out.write("\t\t\t\t<td align=\"left\" class=\"l-table-edit-td\"></td>\t\t\t\t\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t  <th colspan=\"6\"><div id=\"result1\"></div></th>\r\n");
      out.write("\t\t\t</tr>\t\t\t\t\t\t\r\n");
      out.write("\t\t</table>\r\n");
      out.write("\t\t<a class=\"l-button\" onclick=\"f_search()\"><strong>查&nbsp;&nbsp;询</strong></a>\r\n");
      out.write("\t      </div>\r\n");
      out.write("\t    </div>\t\t\t\r\n");
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
