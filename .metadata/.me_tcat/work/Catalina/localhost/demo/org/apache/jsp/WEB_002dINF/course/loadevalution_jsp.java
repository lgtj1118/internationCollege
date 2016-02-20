package org.apache.jsp.WEB_002dINF.course;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;

public final class loadevalution_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\t\t<title>教学评价列表</title>\r\n");
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
      out.write("\tvar EvalutionData = {Rows: [\r\n");
      out.write("\t\t");
String  s= (String) request.getAttribute("evalutionlist");
      out.write("\r\n");
      out.write("\t\t");
      out.print(s);
      out.write("\r\n");
      out.write("\t\t ]};\r\n");
      out.write("    var TestData =[{test:1,text:'优秀'},{test:2,text:'良好'},{test:3,text:'及格'},{test:4,text:'不及格'}]\t;\t\r\n");
      out.write("\t$(f_initGrid);\r\n");
      out.write("\tvar manager, g;\r\n");
      out.write("\tfunction f_initGrid() {\r\n");
      out.write("\t\tg = manager = $(\"#maingrid\").ligerGrid(\r\n");
      out.write("\t\t\t\t{\r\n");
      out.write("\t\t\t\tcolumns : [{\r\n");
      out.write("\t\t\t\tdisplay : 'id',\r\n");
      out.write("\t\t\t\tname : 'id',\r\n");
      out.write("\t\t\t\tminWidth : 80,\r\n");
      out.write("\t\t\t\thide:true,\r\n");
      out.write("\t\t\t\ttype : 'int'\r\n");
      out.write("\t\t\t}/* , {\r\n");
      out.write("\t\t\t\tdisplay : '学号',\r\n");
      out.write("\t\t\t\tname : 'stuid',\r\n");
      out.write("\t\t\t\tminWidth : 60,\r\n");
      out.write("\t\t\t\teditor: { type: 'text'}\r\n");
      out.write("\t\t\t} */, {\r\n");
      out.write("\t\t\t\tdisplay : '教学态度',\r\n");
      out.write("\t\t\t\tname : 'incicators1',\r\n");
      out.write("\t\t\t\tminWidth : 80,\r\n");
      out.write("\t\t\t\teditor: { type: 'select', data: TestData, valueColumnName: 'incicators1' },\r\n");
      out.write("                    render: function (item)\r\n");
      out.write("                    {\r\n");
      out.write("                        if (parseInt(item.incicators1) == 1) return '优秀';\r\n");
      out.write("                        else if(parseInt(item.incicators1) == 2) return '良好';\r\n");
      out.write("                        else if(parseInt(item.incicators1) == 3) return '及格';\r\n");
      out.write("                        else if(parseInt(item.incicators1) == 4) return '不及格';\r\n");
      out.write("                    }\r\n");
      out.write("\t\t\t}, {\r\n");
      out.write("\t\t\t\tdisplay : '因材施教',\r\n");
      out.write("\t\t\t\tname : 'incicators2',\r\n");
      out.write("\t\t\t\tminWidth : 80,\r\n");
      out.write("\t\t\t\teditor: { type: 'select', data: TestData, valueColumnName: 'incicators2' },\r\n");
      out.write("                    render: function (item)\r\n");
      out.write("                    {\r\n");
      out.write("                        if (parseInt(item.incicators2) == 1) return '优秀';\r\n");
      out.write("                        else if(parseInt(item.incicators2) == 2) return '良好';\r\n");
      out.write("                        else if(parseInt(item.incicators2) == 3) return '及格';\r\n");
      out.write("                        else if(parseInt(item.incicators2) == 4) return '不及格';\r\n");
      out.write("                    }\r\n");
      out.write("\t\t\t}, {\r\n");
      out.write("\t\t\t\tdisplay : '教学内容',\r\n");
      out.write("\t\t\t\tname : 'incicators3',\r\n");
      out.write("\t\t\t\tminWidth : 80,\r\n");
      out.write("\t\t\t\teditor: { type: 'select', data: TestData, valueColumnName: 'incicators3' },\r\n");
      out.write("                    render: function (item)\r\n");
      out.write("                    {\r\n");
      out.write("                        if (parseInt(item.incicators3) == 1) return '优秀';\r\n");
      out.write("                        else if(parseInt(item.incicators3) == 2) return '良好';\r\n");
      out.write("                        else if(parseInt(item.incicators3) == 3) return '及格';\r\n");
      out.write("                        else if(parseInt(item.incicators3) == 4) return '不及格';\r\n");
      out.write("                    }\r\n");
      out.write("\t\t\t}, {\r\n");
      out.write("\t\t\t\tdisplay : '语言板书',\r\n");
      out.write("\t\t\t\tname : 'incicators4',\r\n");
      out.write("\t\t\t\tminWidth : 80,\r\n");
      out.write("\t\t\t\teditor: { type: 'select', data: TestData, valueColumnName: 'incicators4' },\r\n");
      out.write("                    render: function (item)\r\n");
      out.write("                    {\r\n");
      out.write("                        if (parseInt(item.incicators4) == 1) return '优秀';\r\n");
      out.write("                        else if(parseInt(item.incicators4) == 2) return '良好';\r\n");
      out.write("                        else if(parseInt(item.incicators4) == 3) return '及格';\r\n");
      out.write("                        else if(parseInt(item.incicators4) == 4) return '不及格';\r\n");
      out.write("                    }\r\n");
      out.write("\t\t\t}, {\r\n");
      out.write("\t\t\t\tdisplay : '教学方法',\r\n");
      out.write("\t\t\t\tname : 'incicators5',\r\n");
      out.write("\t\t\t\tminWidth : 80,\r\n");
      out.write("\t\t\t\teditor: { type: 'select', data: TestData, valueColumnName: 'incicators5' },\r\n");
      out.write("                    render: function (item)\r\n");
      out.write("                    {\r\n");
      out.write("                        if (parseInt(item.incicators5) == 1) return '优秀';\r\n");
      out.write("                        else if(parseInt(item.incicators5) == 2) return '良好';\r\n");
      out.write("                        else if(parseInt(item.incicators5) == 3) return '及格';\r\n");
      out.write("                        else if(parseInt(item.incicators5) == 4) return '不及格';\r\n");
      out.write("                    }\r\n");
      out.write("\t\t\t}, {\r\n");
      out.write("\t\t\t\tdisplay : '教学效果',\r\n");
      out.write("\t\t\t\tname : 'incicators6',\r\n");
      out.write("\t\t\t\tminWidth : 80,\r\n");
      out.write("\t\t\t\teditor: { type: 'select', data: TestData, valueColumnName: 'incicators6' },\r\n");
      out.write("                    render: function (item)\r\n");
      out.write("                    {\r\n");
      out.write("                        if (parseInt(item.incicators6) == 1) return '优秀';\r\n");
      out.write("                        else if(parseInt(item.incicators6) == 2) return '良好';\r\n");
      out.write("                        else if(parseInt(item.incicators6) == 3) return '及格';\r\n");
      out.write("                        else if(parseInt(item.incicators6) == 4) return '不及格';\r\n");
      out.write("                    }\r\n");
      out.write("\t\t\t}, {\r\n");
      out.write("\t\t\t\tdisplay : '总体印象',\r\n");
      out.write("\t\t\t\tname : 'incicators7',\r\n");
      out.write("\t\t\t\tminWidth : 80,\r\n");
      out.write("\t\t\t\teditor: { type: 'select', data: TestData, valueColumnName: 'incicators7' },\r\n");
      out.write("                    render: function (item)\r\n");
      out.write("                    {\r\n");
      out.write("                        if (parseInt(item.incicators7) == 1) return '优秀';\r\n");
      out.write("                        else if(parseInt(item.incicators7) == 2) return '良好';\r\n");
      out.write("                        else if(parseInt(item.incicators7) == 3) return '及格';\r\n");
      out.write("                        else if(parseInt(item.incicators7) == 4) return '不及格';\r\n");
      out.write("                    }\r\n");
      out.write("\t\t\t}/* , {\r\n");
      out.write("\t\t\t\tdisplay : '合计',\r\n");
      out.write("\t\t\t\tname : 'summary',\r\n");
      out.write("\t\t\t\tminWidth : 80,\r\n");
      out.write("\t\t\t\teditor: { type: 'select', data: TestData, valueColumnName: 'summary' },\r\n");
      out.write("                    render: function (item)\r\n");
      out.write("                    {\r\n");
      out.write("                        if (parseInt(item.summary) == 1) return '优秀';\r\n");
      out.write("                        else if(parseInt(item.summary) == 2) return '良好';\r\n");
      out.write("                        else if(parseInt(item.summary) == 3) return '及格';\r\n");
      out.write("                        else if(parseInt(item.summary) == 4) return '不及格';\r\n");
      out.write("                    }\r\n");
      out.write("\t\t\t} */, {\r\n");
      out.write("\t\t\t\tdisplay : '突出优点或问题',\r\n");
      out.write("\t\t\t\tname : 'extrude',\r\n");
      out.write("\t\t\t\tminWidth : 200,\r\n");
      out.write("\t\t\t\teditor: { type: 'text'}\r\n");
      out.write("\t\t\t}, {\r\n");
      out.write("\t\t\t\tdisplay : '建议与希望',\r\n");
      out.write("\t\t\t\tname : 'advice',\r\n");
      out.write("\t\t\t\tminWidth : 200,\r\n");
      out.write("\t\t\t\teditor: { type: 'text'}\r\n");
      out.write("\t\t\t} ],\r\n");
      out.write("\t\t\t\t\tonSelectRow : function(rowdata, rowindex) {\r\n");
      out.write("\t\t\t\t\t\t$(\"#txtrowindex\").val(rowindex);\r\n");
      out.write("\t\t\t\t\t},\r\n");
      out.write("\t\t\t\t\tenabledEdit : true,\r\n");
      out.write("\t\t\t\t\tclickToEdit : false,\r\n");
      out.write("\t\t\t\t\tisScroll : false,\r\n");
      out.write("\t\t\t        rownumbers:true,\r\n");
      out.write("\t\t\t        pageSize:30,\r\n");
      out.write("\t\t\t\t\tdata : EvalutionData,\r\n");
      out.write("\t\t\t\t\twidth : '100%'\r\n");
      out.write("\t\t\t\t});\r\n");
      out.write("\t}\r\n");
      out.write("    function fenxi(){\r\n");
      out.write("      var str = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/system/Manage_evalutionanalysis.action?course.num=\"+$(\"#courseid\").val();\r\n");
      out.write("      m=$.ligerDialog.open({\r\n");
      out.write("\t\t\turl : str,\r\n");
      out.write("\t\t\theight : 450,\r\n");
      out.write("\t\t\twidth : 430,\r\n");
      out.write("\t\t\ttitle:'评价分析',\r\n");
      out.write("\t\t\tisDrag:true,\r\n");
      out.write("\t\t\tisResize : true\r\n");
      out.write("\t\t});\r\n");
      out.write("    }\r\n");
      out.write("</script>\r\n");
      out.write("\t</head>\r\n");
      out.write("\t<body style=\"padding: 2px\">\r\n");
      out.write("\t    <input id=\"courseid\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${courseid }", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\" type=\"hidden\" />\r\n");
      out.write("\t\t<a class=\"l-button\" style=\"width:60px;float:left; margin:3px;\" onclick=\"fenxi()\">分&nbsp;析</a>\r\n");
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
