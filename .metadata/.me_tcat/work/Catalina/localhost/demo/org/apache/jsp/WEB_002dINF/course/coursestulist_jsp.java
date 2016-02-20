package org.apache.jsp.WEB_002dINF.course;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import org.springframework.web.context.request.SessionScope;
import java.util.*;

public final class coursestulist_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("    <script type=\"text/javascript\" src=\"js/jquery-validation/jquery.validate.min.js\" charset=\"utf-8\"></script>\r\n");
      out.write("    <script type=\"text/javascript\" src=\"js/json2.js\" charset=\"utf-8\"></script>\r\n");
      out.write("    <script type=\"text/javascript\" src=\"js/jquery-validation/jquery.metadata.js\" charset=\"utf-8\"></script>\r\n");
      out.write("    <script type=\"text/javascript\" src=\"js/jquery-validation/messages_cn.js\" charset=\"utf-8\"></script>\r\n");
      out.write("    <script src=\"js/jquery/jquery-1.3.2.min.js\"type=\"text/javascript\"></script>\r\n");
      out.write("\t<script src=\"js/ligerUI/core/base.js\" type=\"text/javascript\"></script>\r\n");
      out.write("\t<script src=\"js/ligerUI/ligerui.all.js\" type=\"text/javascript\"></script>\r\n");
      out.write("<script type=\"text/javascript\"> \r\n");
      out.write("\t \r\n");
      out.write("   var CourseData = { \r\n");
      out.write("\t        Rows: [");
String s=(String) request.getAttribute("courselist");
      out.print(s);
      out.write("]};\r\n");
      out.write("   var CourseList = CourseData.Rows;\r\n");
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
      out.write("\t$(f_initGrid);\r\n");
      out.write("\tvar manager, g;\r\n");
      out.write("\tfunction f_initGrid() {\r\n");
      out.write("\t\tg = manager = $(\"#maingrid\").ligerGrid(\r\n");
      out.write("\t\t\t\t{\t\t\t\r\n");
      out.write("\t\t\t\tcolumns : [{\r\n");
      out.write("\t\t\t\tdisplay : 'ID',\r\n");
      out.write("\t\t\t\tname : 'id',\r\n");
      out.write("\t\t\t\twidth : 60,\r\n");
      out.write("\t\t\t\thide:true,\r\n");
      out.write("\t\t\t\ttype : 'int'\r\n");
      out.write("\t\t\t}, {\r\n");
      out.write("\t\t\t\tdisplay : '课程编号',\r\n");
      out.write("\t\t\t\tname : 'num',\r\n");
      out.write("\t\t\t\tminWidth : 120,\r\n");
      out.write("\t\t\t\teditor: { type: 'text'}\r\n");
      out.write("\t\t\t} , {\r\n");
      out.write("\t\t\t\tdisplay : '课程名称',\r\n");
      out.write("\t\t\t\tname : 'coursename',\r\n");
      out.write("\t\t\t\tminWidth : 120,\r\n");
      out.write("\t\t\t\teditor: { type: 'text'}\r\n");
      out.write("\t\t\t}, {\r\n");
      out.write("\t\t\t\tdisplay : '课程名称（英文）',\r\n");
      out.write("\t\t\t\tname : 'coursename_en',\r\n");
      out.write("\t\t\t\tminWidth : 120,\r\n");
      out.write("\t\t\t\teditor: { type: 'text'}\r\n");
      out.write("\t\t\t},{\r\n");
      out.write("\t\t\t\tdisplay : '开课周数',columns:[\r\n");
      out.write("\t\t\t\t{ display:'起始周' , name:'beginweeks',minWidth : 60,editor: { type: 'int'} },\r\n");
      out.write("\t\t\t\t{ display:'结束周' , name:'endweeks',  minWidth : 60,editor: { type: 'int'} }\r\n");
      out.write("\t\t\t\t]\t\t\t\r\n");
      out.write("\t\t\t} , {\r\n");
      out.write("\t\t\t\tdisplay : '学分',\r\n");
      out.write("\t\t\t\tname : 'credits',\r\n");
      out.write("\t\t\t\tminWidth : 60\r\n");
      out.write("\t\t\t}, {\r\n");
      out.write("\t\t\t\tdisplay : '学时',columns:[\r\n");
      out.write("\t\t\t\t{ display:'周学时' , name:'weeklesson',minWidth : 60,editor: { type: 'int'} },\r\n");
      out.write("\t\t\t\t{ display:'总学时' , name:'lessoncount',  minWidth : 60,editor: { type: 'int'} }\r\n");
      out.write("\t\t\t\t]\t\t\t\r\n");
      out.write("\t\t\t}, {\r\n");
      out.write("\t\t\t\tdisplay : '课程性质',\r\n");
      out.write("\t\t\t\tname : 'character',\r\n");
      out.write("\t\t\t\tminWidth : 120\t\t\t\r\n");
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
      out.write("\t\t\t}  */, {\r\n");
      out.write("\t\t\t\tdisplay : '开课学院',\r\n");
      out.write("\t\t\t\tname : 'academic',\r\n");
      out.write("\t\t\t\tminWidth : 120\t\t\t\t\r\n");
      out.write("\t\t\t} , {\r\n");
      out.write("\t\t\t\tdisplay : '负责教师',\r\n");
      out.write("\t\t\t\tname : 'teacher',\r\n");
      out.write("\t\t\t\twidth : 120,\r\n");
      out.write("\t\t\t\teditor: { type: 'text'}\r\n");
      out.write("\t\t\t}  , {\r\n");
      out.write("\t\t\t\tdisplay : '状态',\r\n");
      out.write("\t\t\t\tname : 'isDeleted',\r\n");
      out.write("\t\t\t\twidth : 120,\r\n");
      out.write("\t\t\t\teditor: { type: 'text'},\r\n");
      out.write("\t\t\t\trender:function (item) {\r\n");
      out.write("\t\t\t\t\tif (parseInt(item.isDeleted) == 1) {\r\n");
      out.write("\t\t\t\t\t\treturn \"<font style='color:red'>不可用</font>\";\r\n");
      out.write("\t\t\t\t\t} else {\r\n");
      out.write("\t\t\t\t\t\treturn \"<font style='color:green'>正常</font>\";\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t} ],\r\n");
      out.write("\t\t\t\t\tonSelectRow : function(rowdata, rowindex) {\r\n");
      out.write("\t\t\t\t\t\t$(\"#txtrowindex\").val(rowindex);\r\n");
      out.write("\t\t\t\t\t},\r\n");
      out.write("\t\t\t\t\tenabledEdit : true,\r\n");
      out.write("\t\t\t\t\tclickToEdit : false,\r\n");
      out.write("\t\t\t\t\tisScroll : false,\r\n");
      out.write("\t\t\t\t\tcheckbox:false,\r\n");
      out.write("\t\t\t        rownumbers:true,\r\n");
      out.write("\t\t\t        pageSize:15,\r\n");
      out.write("\t\t\t\t\turl :'");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/system/Class_courselist.action',\r\n");
      out.write("\t\t\t\t\twidth : '100%'\r\n");
      out.write("\t\t\t\t});\r\n");
      out.write("\t}\r\n");
      out.write("   function beginEdit() {\r\n");
      out.write("            var row = manager.getSelectedRow();\r\n");
      out.write("            if (!row) { alert('请选择一个课程！'); return; }\r\n");
      out.write("            manager.beginEdit(row);\r\n");
      out.write("        }\r\n");
      out.write("\tfunction cancelEdit(rowid) {\r\n");
      out.write("\t\tmanager.cancelEdit(rowid);\r\n");
      out.write("\t}\r\n");
      out.write("\tfunction endEdit(rowid) {\r\n");
      out.write("\t var row = manager.getSelectedRow();\r\n");
      out.write("\t\tmanager.endEdit(row);\r\n");
      out.write("\t$.post(\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/system/Class_courseupdate.action?course.id=\"+ row.id\r\n");
      out.write("\t\t\t\t+\"&course.num=\"+encodeURI(encodeURI(row.num))\r\n");
      out.write("\t\t\t\t+\"&course.coursename=\"+encodeURI(encodeURI(row.coursename))\r\n");
      out.write("\t\t\t\t+\"&course.beginweeks=\"+encodeURI(encodeURI(row.beginweeks))\r\n");
      out.write("\t\t\t\t+\"&course.endweeks=\"+encodeURI(encodeURI(row.endweeks))\r\n");
      out.write("\t\t\t    +\"&course.credits=\"+encodeURI(encodeURI(row.credits))\r\n");
      out.write("\t\t\t  \t+\"&course.character=\"+encodeURI(encodeURI(row.character))\r\n");
      out.write("\t\t\t    +\"&course.checkway=\"+encodeURI(encodeURI(row.checkway))\r\n");
      out.write("\t\t\t\t+\"&course.teacher=\"+encodeURI(encodeURI(row.teacher))\r\n");
      out.write("\t\t\t\t);\r\n");
      out.write("\t}\r\n");
      out.write("\tvar m;\r\n");
      out.write("    function add(){\r\n");
      out.write("\tvar str = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/system/Class_coursebeginadd.action\";\r\n");
      out.write("\t\tm=$.ligerDialog.open({\r\n");
      out.write("\t\t\turl : str,\r\n");
      out.write("\t\t\theight : 450,\r\n");
      out.write("\t\t\twidth : 430,\r\n");
      out.write("\t\t\ttitle:'课程添加',\r\n");
      out.write("\t\t\tisDrag:true,\r\n");
      out.write("\t\t\tisResize : true\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\t\r\n");
      out.write("\t}\r\n");
      out.write("\tfunction deleterow() {\r\n");
      out.write("\tvar row = manager.getSelectedRow();\r\n");
      out.write("\t\tif (!row) {\r\n");
      out.write("\t\t\talert('请选择课程！');\r\n");
      out.write("\t\t\treturn;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t$.ligerDialog.confirm('请先确认没有班级开设这门课程！', function (yes){\r\n");
      out.write("                       if(yes){\r\n");
      out.write("\t\t  var rows = g.getCheckedRows();\r\n");
      out.write("            var str = \"\";\r\n");
      out.write("            $(rows).each(function ()\r\n");
      out.write("            {\r\n");
      out.write("                str += this.id + \",\";\r\n");
      out.write("            });\r\n");
      out.write("\t     $.post(\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/system/Class_coursedelete.action?ids=\"\r\n");
      out.write("\t\t\t\t+ str);\r\n");
      out.write("\t\t\t manager.deleteSelectedRow();\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t});\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("</script>\r\n");
      out.write("\t</head>\r\n");
      out.write("\t<body style=\"padding: 2px\">\t\r\n");
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
