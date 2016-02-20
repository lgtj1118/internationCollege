package org.apache.jsp.WEB_002dINF.arrange;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;

public final class courseteacherselect_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("   var sexData = [{ Sex: 1, text: '男' }, { Sex: 2, text: '女'}];\r\n");
      out.write("   $(f_initGrid);\r\n");
      out.write("\tvar manager, g;\r\n");
      out.write("\tfunction f_initGrid() {\r\n");
      out.write("\t\tg = manager = $(\"#maingrid\").ligerGrid(\r\n");
      out.write("\t\t\t{columns : [\r\n");
      out.write("\t\t\t{   display : '序号',  name : 'id',     width : 40,  type : 'int',hide:true\r\n");
      out.write("\t\t\t},{display : '编号', name : 'identificationnum', minWidth : 100,  editor:{type:'text'}\t\r\n");
      out.write("\t\t\t},{display : '姓名', name : 'teachername', minWidth : 100,  editor:{type:'text'}\t\r\n");
      out.write("\t\t\t} ,{display : '性别', name : 'sex',minWidth : 80,editor: { type: 'text'}\r\n");
      out.write("\t\t\t}, {display : '电话号码', name : 'telephone',minWidth : 100, editor: { type: 'text'}\r\n");
      out.write("\t\t\t}, {display : '职称', name : 'position',  minWidth : 120, editor: { type: 'text'}\r\n");
      out.write("\t\t\t}],\r\n");
      out.write("\t\t\t\t\tonSelectRow : function(rowdata, rowindex) {\r\n");
      out.write("\t\t\t\t\t\t$(\"#txtrowindex\").val(rowindex);\r\n");
      out.write("\t\t\t\t\t},\r\n");
      out.write("\t\t\t\t\tenabledEdit : true,\r\n");
      out.write("\t\t\t\t\tclickToEdit : false,\r\n");
      out.write("\t\t\t\t\tisScroll : false,\r\n");
      out.write("\t\t\t\t\trownumbers:true, \r\n");
      out.write("\t\t\t\t\tpageSize:20,\r\n");
      out.write("\t\t\t\t\turl :'");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/system/Manage_courseteacherlist.action',\r\n");
      out.write("\t\t\t\t\twidth : '100%'\r\n");
      out.write("\t\t\t\t});\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\tfunction addteacher() {\r\n");
      out.write("\tvar row = manager.getSelectedRow();\r\n");
      out.write("\t\tif (!row) {alert('请选择一名教师！');return;}\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t$.post(\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/system/Manage_semesterteacherendadd.action?teacher.identificationnum=\"+ row.identificationnum+\"&semChosenCourse.id=\"+$(\"#semestercourseid\").val() ,null,function(){\r\n");
      out.write("\t\t   //alert(\"设定成功！\");\r\n");
      out.write("\t\t   parent.m.hide();\r\n");
      out.write("\t\t   parent.g.loadData();\r\n");
      out.write("\t\t }) \r\n");
      out.write("\t\t }\r\n");
      out.write("\t\t /* $.ajax({  \r\n");
      out.write("\t\t   type : \"POST\",  \r\n");
      out.write("\t\t   url : url,\r\n");
      out.write("\t\t   error: function (){\r\n");
      out.write("\t\t        alert(\"服务器错误，请联系管理员!\");\r\n");
      out.write("\t\t   },\r\n");
      out.write("\t\t   success : function(data) {\r\n");
      out.write("\t\t       if (data.length > 0){\r\n");
      out.write("\t\t        \tvar msg = \"该教师已经是\";\t\r\n");
      out.write("\t\t        \tfor(var n=0;n<data.length;n++){\r\n");
      out.write("\t\t        \t\t\tmsg = msg + data[n].classname + \" \";\t\r\n");
      out.write("\t\t          \t}; \r\n");
      out.write("\t\t          \tmsg = msg + \"的任课教师，是否继续？\";\r\n");
      out.write("\t\t          \ttips(msg, ident);\r\n");
      out.write("\t\t          \t\treturn;\t\r\n");
      out.write("\t\t        \t} else {\r\n");
      out.write("\t\t        \t\tprint(ident);\r\n");
      out.write("\t\t        \t};\r\n");
      out.write("\t\t      } \r\n");
      out.write("\t\t      }\r\n");
      out.write("\t}); \r\n");
      out.write("\t\r\n");
      out.write("\t}\t \r\n");
      out.write("function print(ident){\r\n");
      out.write("\t  //alert(\"here\");\r\n");
      out.write("\t  var url = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/system/Manage_semesterteacherendadd.action?teacher.identificationnum=\"+ row.identificationnum+\"&semChosenCourse.id=\"+$(\"#semestercourseid\").val();\r\n");
      out.write("\t  $.post(url, null, function() {\r\n");
      out.write("\t\t\tparent.m.hide();\r\n");
      out.write("\t\t\tparent.window.location.reload();\r\n");
      out.write("\t\t});\r\n");
      out.write("\t}\r\n");
      out.write("\t \r\n");
      out.write("\t function tips (msg, ident) { \t\r\n");
      out.write("\t \t$.ligerDialog.confirm(msg, function (yes)\r\n");
      out.write("       {\r\n");
      out.write(" \t\t\tif (yes == true){\r\n");
      out.write(" \t\t\t\tprint(ident);\r\n");
      out.write(" \t\t\t}   \r\n");
      out.write("       }); \r\n");
      out.write("\t } */\r\n");
      out.write("\t  function fuzzy () {\r\n");
      out.write("\t\tvar t = $(\"#keyword\").val();\r\n");
      out.write("\t\t$(\"#maingrid\").ligerGrid({\r\n");
      out.write("\t\t  url:\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/system/Manage_teacherFuzzy.action?fuzzyText=\" + encodeURI(encodeURI(t)) ,\r\n");
      out.write("\t\t});\r\n");
      out.write("\t}\r\n");
      out.write("\t \r\n");
      out.write("</script>\r\n");
      out.write("\t</head>\r\n");
      out.write("\t<body style=\"padding: 2px\">\r\n");
      out.write("\t <input id=\"semestercourseid\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${semestercourseid }", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\" type=\"hidden\" />\r\n");
      out.write("\t <table style=\"margin:5px;\" >\r\n");
      out.write("\t    <tr>\r\n");
      out.write("\t       <td> <input type=\"text\" id=\"keyword\" onkeyup=\"fuzzy()\"   style=\"font-size:12px; width:180px;\" placeholder=\"姓名 编号 职称\"></td>\r\n");
      out.write("\t       <td><a class=\"l-button\" style=\"width:70px;float:left; margin:3px;font-size: 12px;\" onclick=\"addteacher()\">选&nbsp;定</a>\t \t </td>\r\n");
      out.write("\t    </tr>\t \r\n");
      out.write("\t </table>\r\n");
      out.write("\t    \r\n");
      out.write("\t     \r\n");
      out.write("\t <div class=\"l-clear\"></div>\r\n");
      out.write("\t <div id=\"maingrid\" ></div>\r\n");
      out.write("\t</body>\r\n");
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
