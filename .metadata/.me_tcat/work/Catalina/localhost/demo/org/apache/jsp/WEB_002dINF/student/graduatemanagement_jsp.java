package org.apache.jsp.WEB_002dINF.student;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;

public final class graduatemanagement_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\r\n");
      out.write("\r\n");
      out.write("<html xmlns=\"http://www.w3.org/1999/xhtml\">\r\n");
      out.write("\t<head>\r\n");
      out.write("\t<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\r\n");
      out.write("\t\t<title>班级列表</title>\r\n");
      out.write("\t<link href=\"");
      out.print(basePath);
      out.write("js/ligerUI/skins/Aqua/css/ligerui-all.css\" rel=\"stylesheet\"type=\"text/css\" />\t\r\n");
      out.write("\t<link href=\"");
      out.print(basePath );
      out.write("js/ligerUI/skins/Gray/css/all.css\" rel=\"stylesheet\" type=\"text/css\"/>\t\r\n");
      out.write("    <script type=\"text/javascript\" src=\"");
      out.print(basePath );
      out.write("js/jquery-validation/jquery.validate.min.js\" charset=\"utf-8\"></script>\r\n");
      out.write("    <script type=\"text/javascript\" src=\"");
      out.print(basePath );
      out.write("js/json2.js\" charset=\"utf-8\"></script>\r\n");
      out.write("    <script type=\"text/javascript\" src=\"");
      out.print(basePath );
      out.write("js/jquery-validation/jquery.metadata.js\" charset=\"utf-8\"></script>\r\n");
      out.write("    <script type=\"text/javascript\" src=\"");
      out.print(basePath );
      out.write("js/jquery-validation/messages_cn.js\" charset=\"utf-8\"></script>\r\n");
      out.write("    <script type=\"text/javascript\" src=\"");
      out.print(basePath );
      out.write("js/ligerUI/plugins/ligerTab.js\"></script>\r\n");
      out.write("    <script type=\"text/javascript\" src=\"");
      out.print(basePath );
      out.write("js/jquery/jquery-1.3.2.min.js\"></script>\r\n");
      out.write("\t<script src=\"");
      out.print(basePath );
      out.write("js/ligerUI/core/base.js\" type=\"text/javascript\"></script>\r\n");
      out.write("\t<script src=\"");
      out.print(basePath );
      out.write("js/ligerUI/ligerui.all.js\" type=\"text/javascript\"></script>\t\r\n");
      out.write("\t<script type=\"text/javascript\">\r\n");
      out.write("\tvar ClassData = {Rows: [\r\n");
      out.write("\t\t");
String  s= (String) request.getAttribute("classlist");
      out.write("\r\n");
      out.write("\t\t");
      out.print(s);
      out.write("\r\n");
      out.write("\t\t ]};\t\t\r\n");
      out.write("\t$(f_initGrid);\r\n");
      out.write("\tvar manager, g;\r\n");
      out.write("\tfunction f_initGrid() {\r\n");
      out.write("\t\tg = manager = $(\"#maingrid\").ligerGrid(\r\n");
      out.write("\t\t\t\t{\r\n");
      out.write("\t\t\t\tcolumns : [{\r\n");
      out.write("\t\t\t\tdisplay : 'ID',\r\n");
      out.write("\t\t\t\tname : 'id',\r\n");
      out.write("\t\t\t\tminWidth : 60,\r\n");
      out.write("\t\t\t\thide:true,\r\n");
      out.write("\t\t\t\ttype : 'int'\r\n");
      out.write("\t\t\t}, {\r\n");
      out.write("\t\t\t\tdisplay : '班级名称',\r\n");
      out.write("\t\t\t\tname : 'classname',\r\n");
      out.write("\t\t\t\tminWidth : 150,\r\n");
      out.write("\t\t\t\teditor: { type: 'text'}\r\n");
      out.write("\t\t\t}, {\r\n");
      out.write("\t\t\t\tdisplay : '班级专业',\r\n");
      out.write("\t\t\t\tname : 'major',\r\n");
      out.write("\t\t\t\tminWidth : 150,\r\n");
      out.write("\t\t\t\teditor: { type: 'text'}\r\n");
      out.write("\t\t\t}/* , {\r\n");
      out.write("\t\t\t\tdisplay : '班主任',\r\n");
      out.write("\t\t\t\tname : 'ClassTeacher',\r\n");
      out.write("\t\t\t\twidth : 150,\r\n");
      out.write("\t\t\t\teditor: { type: 'text'}\r\n");
      out.write("\t\t\t}, {\r\n");
      out.write("\t\t\t\tdisplay : '助理班主任',\r\n");
      out.write("\t\t\t\tname : 'Assistantteacher',\r\n");
      out.write("\t\t\t\twidth : 150,\r\n");
      out.write("\t\t\t\teditor: { type: 'text'}\r\n");
      out.write("\t\t\t} , {\r\n");
      out.write("\t\t\t\tdisplay : '班长',\r\n");
      out.write("\t\t\t\tname : 'Classmajor',\r\n");
      out.write("\t\t\t\tminWidth : 150,\r\n");
      out.write("\t\t\t\teditor: { type: 'text'}\r\n");
      out.write("\t\t\t}*/, {\r\n");
      out.write("\t\t\t\tdisplay : '状态',\r\n");
      out.write("\t\t\t\tname : 'type',\r\n");
      out.write("\t\t\t\tminWidth : 150,\r\n");
      out.write("\t\t\t\teditor: { type: 'text'},\r\n");
      out.write("\t\t\t\trender: function (item)\r\n");
      out.write("                    {\r\n");
      out.write("                        if (parseInt(item.type) == 0){ var h=\"<span style='color:green;'>正常</span>\" ;return h;}\r\n");
      out.write("                        else if (parseInt(item.type) == 1) { var h=\"<span style='color:red;'>已删除</span>\" ;return h;}\r\n");
      out.write("                        else if (parseInt(item.type) == 2) { var h=\"<span style='color:orange;'>已毕业</span>\" ;return h;}\r\n");
      out.write("                        \r\n");
      out.write("                    }\t\r\n");
      out.write("\t\t\t},{\r\n");
      out.write("\t\t\t\t\tdisplay : '班内学生',\r\n");
      out.write("\t\t\t\t\tisSort : false,\r\n");
      out.write("\t\t\t\t\tminWidth : 120,\r\n");
      out.write("\t\t\t\t\trender : function() {\r\n");
      out.write("\t\t\t\t\t\tvar h = \"\";\r\n");
      out.write("\t\t\t\t\t\th += \"<a style='color:#000;' href='javascript:classstu(\"+ \")'>管理</a> \";\r\n");
      out.write("\t\t\t\t\t\treturn h;\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t} ],\r\n");
      out.write("\t\t\t\t\tonSelectRow : function(rowdata, rowindex) {\r\n");
      out.write("\t\t\t\t\t\t$(\"#txtrowindex\").val(rowindex);\r\n");
      out.write("\t\t\t\t\t},\r\n");
      out.write("\t\t\t\t\tenabledEdit : true,\r\n");
      out.write("\t\t\t\t\tclickToEdit : false,\r\n");
      out.write("\t\t\t\t\tisScroll : false,\r\n");
      out.write("\t\t\t         rownumbers:true,\r\n");
      out.write("\t\t\t         pageSize:20,\r\n");
      out.write("\t\t\t\t\t//data : ClassData,\r\n");
      out.write("\t\t\t\t\turl: '");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/system/Class_classList.action',\r\n");
      out.write("\t\t\t\t\twidth : '100%'\r\n");
      out.write("\t\t\t\t});\r\n");
      out.write("\t}\r\n");
      out.write("    function classstu(){\r\n");
      out.write("     var row = manager.getSelectedRow();\r\n");
      out.write("\t \tif (!row) {alert('请选择班级！');return;}\r\n");
      out.write("\t \tif(row.type==1){\r\n");
      out.write("\t \t  alert(\"该班级已删除，不能审核！\");\r\n");
      out.write("\t \t}else{\r\n");
      out.write("          var str = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/system/Class_graduatestulist.action?cls.id=\"+row.id;\r\n");
      out.write("\t\t top.f_addTab('graduatestu','学生列表',str);\r\n");
      out.write("\t\t }\r\n");
      out.write("}\r\n");
      out.write("\t\r\n");
      out.write("</script>\r\n");
      out.write("\t</head>\r\n");
      out.write("\t<body style=\"padding: 2px\">\r\n");
      out.write("\t\t<br />\r\n");
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
