package org.apache.jsp.WEB_002dINF.course;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;

public final class allevalutionanalysis_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\t\t\t}, {\r\n");
      out.write("\t\t\t\tdisplay : '课程号',\r\n");
      out.write("\t\t\t\tname : 'coursenum',\r\n");
      out.write("\t\t\t\tminWidth : 60,\r\n");
      out.write("\t\t\t\teditor: { type: 'text'}\r\n");
      out.write("\t\t\t}, {\r\n");
      out.write("\t\t\t\tdisplay : '课程名称',\r\n");
      out.write("\t\t\t\tname : 'coursename',\r\n");
      out.write("\t\t\t\tminWidth : 60,\r\n");
      out.write("\t\t\t\teditor: { type: 'text'}\r\n");
      out.write("\t\t\t}, {\r\n");
      out.write("\t\t\t\tdisplay : '任课教师',\r\n");
      out.write("\t\t\t\tname : 'teachername',\r\n");
      out.write("\t\t\t\tminWidth : 60,\r\n");
      out.write("\t\t\t\teditor: { type: 'text'}\r\n");
      out.write("\t\t\t},{display : '评价标准',columns:[\r\n");
      out.write("\t\t\t   { display : '教学态度', name : 'incicators1', minWidth : 80,\r\n");
      out.write("\t\t\t        render: function (item){\r\n");
      out.write("                        if (parseInt(item.incicators1) < 60){ var h=\"<font color='red' >\"+item.incicators1+\"</font>\" ;return h;}\r\n");
      out.write("                        else{ var h=item.incicators1 ;return h;}\r\n");
      out.write("                    }\t\r\n");
      out.write("               }, \r\n");
      out.write("\t\t\t   { display : '因材施教', name : 'incicators2', minWidth : 80,\r\n");
      out.write("\t\t\t        render: function (item){\r\n");
      out.write("                        if (parseInt(item.incicators2) < 60){ var h=\"<font color='red' >\"+item.incicators2+\"</font>\" ;return h;}\r\n");
      out.write("                        else{ var h=item.incicators2 ;return h;}\r\n");
      out.write("                    }\t\r\n");
      out.write("               },  \r\n");
      out.write("\t\t\t   { display : '教学内容', name : 'incicators3', minWidth : 80,\r\n");
      out.write("\t\t\t        render: function (item){\r\n");
      out.write("                        if (parseInt(item.incicators3) < 60){ var h=\"<font color='red' >\"+item.incicators3+\"</font>\" ;return h;}\r\n");
      out.write("                        else{ var h=item.incicators3 ;return h;}\r\n");
      out.write("                    }\t\r\n");
      out.write("               },  \r\n");
      out.write("\t\t\t   { display : '语言板书', name : 'incicators4', minWidth : 80,\r\n");
      out.write("\t\t\t        render: function (item){\r\n");
      out.write("                        if (parseInt(item.incicators4) < 60){ var h=\"<font color='red' >\"+item.incicators4+\"</font>\" ;return h;}\r\n");
      out.write("                        else{ var h=item.incicators4 ;return h;}\r\n");
      out.write("                    }\r\n");
      out.write("\t\t\t   }, \r\n");
      out.write("\t\t\t   { display : '教学方法', name : 'incicators5', minWidth : 80,\r\n");
      out.write("\t\t\t        render: function (item){\r\n");
      out.write("                        if (parseInt(item.incicators5) < 60){ var h=\"<font color='red' >\"+item.incicators5+\"</font>\" ;return h;}\r\n");
      out.write("                        else{ var h=item.incicators5 ;return h;}\r\n");
      out.write("                    }\r\n");
      out.write("\t\t\t   }, \r\n");
      out.write("\t\t\t   { display : '教学效果', name : 'incicators6', minWidth : 80,\r\n");
      out.write("\t\t\t        render: function (item){\r\n");
      out.write("                        if (parseInt(item.incicators6) < 60){ var h=\"<font color='red' >\"+item.incicators6+\"</font>\" ;return h;}\r\n");
      out.write("                        else{ var h=item.incicators6 ;return h;}\r\n");
      out.write("                    }\r\n");
      out.write("\t\t\t   }, \r\n");
      out.write("\t\t\t   { display : '总体印象', name : 'incicators7', minWidth : 80,\r\n");
      out.write("\t\t\t        render: function (item){\r\n");
      out.write("                        if (parseInt(item.incicators7) < 60){ var h=\"<font color='red' >\"+item.incicators7+\"</font>\" ;return h;}\r\n");
      out.write("                        else{ var h=item.incicators7 ;return h;}\r\n");
      out.write("                    }\r\n");
      out.write("\t\t\t   }, \r\n");
      out.write("\t\t\t   { display : '合计', name : 'summary', minWidth : 80,\r\n");
      out.write("\t\t\t        render: function (item){\r\n");
      out.write("                        if (parseInt(item.summary) < 60){ var h=\"<font color='red' >\"+item.summary+\"</font>\" ;return h;}\r\n");
      out.write("                        else{ var h=item.summary ;return h;}\r\n");
      out.write("                    }\r\n");
      out.write("\t\t\t    }]\r\n");
      out.write("\t\t\t }],\r\n");
      out.write("\t\t\t\t\tonSelectRow : function(rowdata, rowindex) {\r\n");
      out.write("\t\t\t\t\t\t$(\"#txtrowindex\").val(rowindex);\r\n");
      out.write("\t\t\t\t\t},\r\n");
      out.write("\t\t\t\t\tenabledEdit : true,\r\n");
      out.write("\t\t\t\t\tclickToEdit : false,\r\n");
      out.write("\t\t\t\t\tisScroll : false,\r\n");
      out.write("\t\t\t        rownumbers:true,\r\n");
      out.write("\t\t\t        pageSize:20,\r\n");
      out.write("\t\t\t\t\t//data : EvalutionData,\r\n");
      out.write("\t\t\t\t\turl:'");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/system/Manage_allEvalutionResult.action',\r\n");
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
      out.write("\" type=\"hidden\" />\t\t\r\n");
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
