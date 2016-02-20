package org.apache.jsp.WEB_002dINF.student;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import org.springframework.web.context.request.SessionScope;
import java.util.*;

public final class courseclassscoreload_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\t<script src=\"js/ligerUI/plugins/ligerToolBar.js\" type=\"text/javascript\"></script>\r\n");
      out.write("\t<link href=\"js/ligerUI/skins/ligerui-icons.css\" rel=\"stylesheet\" type=\"text/css\">\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("var IsmakeupData = [{ ismakeup: 0, text: '否' }, { ismakeup: 1, text: '是'}];  \r\n");
      out.write("\t$(f_initGrid);\r\n");
      out.write("\tvar manager, g;\r\n");
      out.write("\tfunction f_initGrid() {\r\n");
      out.write("\t\tg = manager = $(\"#maingrid\").ligerGrid(\r\n");
      out.write("\t\t\t\t{\r\n");
      out.write("\t\t\t\tcolumns : [{\r\n");
      out.write("\t\t\t\tdisplay : '序号',\r\n");
      out.write("\t\t\t\tname : 'id',\r\n");
      out.write("\t\t\t\twidth : 60,\r\n");
      out.write("\t\t\t\thide:true,\r\n");
      out.write("\t\t\t\ttype : 'int'\r\n");
      out.write("\t\t\t}, {\r\n");
      out.write("\t\t\t\tdisplay : '学期',\r\n");
      out.write("\t\t\t\tname : 'semester',\r\n");
      out.write("\t\t\t\tminWidth : 160,\r\n");
      out.write("\t\t\t\teditor: { type: 'text'}\r\n");
      out.write("\t\t\t} , {\r\n");
      out.write("\t\t\t\tdisplay : '课程名称',\r\n");
      out.write("\t\t\t\tname : 'coursename',\r\n");
      out.write("\t\t\t\tminWidth : 120,\r\n");
      out.write("\t\t\t\teditor: { type: 'text'}\r\n");
      out.write("\t\t\t}, {\r\n");
      out.write("\t\t\t\tdisplay : '护照号',\r\n");
      out.write("\t\t\t\tname : 'passport',\r\n");
      out.write("\t\t\t\twidth : 120,\r\n");
      out.write("\t\t\t\teditor: { type: 'text'}\r\n");
      out.write("\t\t\t}, {\r\n");
      out.write("\t\t\t\tdisplay : '姓名',\r\n");
      out.write("\t\t\t\tname : 'stuname',\r\n");
      out.write("\t\t\t\twidth : 120,\r\n");
      out.write("\t\t\t\teditor: { type: 'text'}\r\n");
      out.write("\t\t\t}, {\r\n");
      out.write("\t\t\t\tdisplay : '成绩',\r\n");
      out.write("\t\t\t\tminWidth : 120,\r\n");
      out.write("\t\t\t\tcolumns:[{\r\n");
      out.write("\t\t\t\t   display:'出勤',\r\n");
      out.write("\t\t\t\t   name:'attendence',\r\n");
      out.write("\t\t\t\t   editor:{type:'float'},\t\t\t\t     \r\n");
      out.write("\t\t\t\t   render: function (item)\r\n");
      out.write("                    {\r\n");
      out.write("                        if (parseInt(item.attendence) < 60){ var h=\"<font color='red' >\"+item.attendence+\"</font>\" ;return h;}\r\n");
      out.write("                        else{ var h=item.attendence;return h;}\r\n");
      out.write("                        \r\n");
      out.write("                    }\r\n");
      out.write("\t\t\t\t},{\r\n");
      out.write("\t\t\t\t   display:'作业',\r\n");
      out.write("\t\t\t\t   name:'homework',\r\n");
      out.write("\t\t\t\t   editor:{type:'float'},\r\n");
      out.write("\t\t\t\t   render: function (item)\r\n");
      out.write("                    {\r\n");
      out.write("                        if (parseInt(item.homework) < 60){ var h=\"<font color='red' >\"+item.homework+\"</font>\" ;return h;}\r\n");
      out.write("                        else{ var h=item.homework ;return h;}\r\n");
      out.write("                        \r\n");
      out.write("                    }\r\n");
      out.write("\t\t\t\t},{\r\n");
      out.write("\t\t\t\t   display:'期中',\r\n");
      out.write("\t\t\t\t   name:'midexam',\r\n");
      out.write("\t\t\t\t   editor:{type:'float'},\r\n");
      out.write("\t\t\t\t   render: function (item)\r\n");
      out.write("                    {\r\n");
      out.write("                        if (parseInt(item.midexam) < 60){ var h=\"<font color='red' >\"+item.midexam+\"</font>\" ;return h;}\r\n");
      out.write("                        else{ var h=item.midexam ;return h;}\r\n");
      out.write("                        \r\n");
      out.write("                    }\r\n");
      out.write("\t\t\t\t   \r\n");
      out.write("\t\t\t\t},{\r\n");
      out.write("\t\t\t\t   display:'期末',\r\n");
      out.write("\t\t\t\t   name:'finalexam',\r\n");
      out.write("\t\t\t\t   editor:{type:'float'},\r\n");
      out.write("\t\t\t\t    render: function (item)\r\n");
      out.write("                    {\r\n");
      out.write("                        if (parseInt(item.finalexam) < 60){ var h=\"<font color='red' >\"+item.finalexam+\"</font>\" ;return h;}\r\n");
      out.write("                        else{ var h=item.finalexam;return h;}\r\n");
      out.write("                        \r\n");
      out.write("                    }\r\n");
      out.write("\t\t\t\t},{\r\n");
      out.write("\t\t\t\t   display:'综合',\r\n");
      out.write("\t\t\t\t   name:'summary',\r\n");
      out.write("\t\t\t\t   editor:{type:'float'},\r\n");
      out.write("\t\t\t\t   render: function (item)\r\n");
      out.write("                    {\r\n");
      out.write("                        if (parseInt(item.summary) < 60){ var h=\"<font color='red' >\"+item.summary+\"</font>\" ;return h;}\r\n");
      out.write("                        else{ var h=item.summary;return h;}\r\n");
      out.write("                        \r\n");
      out.write("                    }\r\n");
      out.write("\t\t\t\t}]\r\n");
      out.write("\t\t\t}, {\r\n");
      out.write("\t\t\t\tdisplay : '是否补考',\r\n");
      out.write("\t\t\t\tname : 'ismakeup',\r\n");
      out.write("\t\t\t\twidth : 60,\r\n");
      out.write("\t\t\t\teditor: { type: 'select', data: IsmakeupData, valueField: 'ismakeup' },\r\n");
      out.write("                    render: function (item)\r\n");
      out.write("                    {\r\n");
      out.write("                        if (parseInt(item.ismakeup) == 0){ var h=\"否\" ;return h;}\r\n");
      out.write("                        else if (parseInt(item.ismakeup) == 1) { var h=\"<span style='color:red;'>是</span>\" ;return h;}\r\n");
      out.write("                        \r\n");
      out.write("                    }\r\n");
      out.write("\t\t\t}, {\r\n");
      out.write("\t\t\t\tdisplay : '补考',\r\n");
      out.write("\t\t\t\tname : 'makeup',\r\n");
      out.write("\t\t\t\twidth : 60,\r\n");
      out.write("\t\t\t\teditor: { type: 'text'}\r\n");
      out.write("\t\t\t}],\r\n");
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
      out.write("/system/Manage_stuscorelist.action',\r\n");
      out.write("\t\t\t\t\twidth : '100%',\r\n");
      out.write("\t\t\t\t\ttoolbar: { items: [\r\n");
      out.write("                         { text: '导出',click: itemclick,  icon: 'save' }/* , { text: '打印',click: printclick,  icon: 'print' } */               \r\n");
      out.write("                    ]}\r\n");
      out.write("\t\t\t\t});\r\n");
      out.write("\t}\r\n");
      out.write("   function itemclick(item){\r\n");
      out.write("       var str = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/system/Manage_courseclassscoredownload.action?semester=\"+$(\"#semester\").val()+\"&coursenum=\"+$(\"#coursenum\").val()+\"&classid=\"+$(\"#classid\").val(); \r\n");
      out.write("       window.location.href=str;\r\n");
      out.write("   }\r\n");
      out.write("   function printclick(item){\r\n");
      out.write("       var str = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/system/Manage_courseclassscoreprint.action?semester=\"+$(\"#semester\").val()+\"&coursenum=\"+$(\"#coursenum\").val()+\"&classid=\"+$(\"#classid\").val(); \r\n");
      out.write("       window.location.href=str;\r\n");
      out.write("   }\r\n");
      out.write("   \r\n");
      out.write("</script>\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write("#head{\r\n");
      out.write(" width: 99%;\r\n");
      out.write(" height:100px;\r\n");
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
      out.write(" width:70px;float:left; margin:15px 20px 5px ;\r\n");
      out.write(" border-radiux:5px;\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("\t</head>\r\n");
      out.write("\t<body style=\"padding: 2px\">\t\r\n");
      out.write("\t    <input id=\"semester\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${semester }", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\" type=\"hidden\" />\r\n");
      out.write("        <input id=\"coursenum\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${coursenum }", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\" type=\"hidden\"/>\r\n");
      out.write("        <input id=\"classid\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${clsid }", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\" type=\"hidden\"/>\t\r\n");
      out.write("        \r\n");
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
