package org.apache.jsp.WEB_002dINF.student;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;

public final class setHeadTeacher_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("    <title>天津工业大学国际教育学院教学服务系统</title>\t   \r\n");
      out.write("\t<link href=\"");
      out.print(basePath);
      out.write("js/ligerUI/skins/Aqua/css/ligerui-all.css\" rel=\"stylesheet\"type=\"text/css\" />\t\r\n");
      out.write("\t<link href=\"");
      out.print(basePath );
      out.write("js/ligerUI/skins/Gray/css/all.css\" rel=\"stylesheet\" type=\"text/css\"/>\t\r\n");
      out.write("    <script src=\"js/jquery/jquery-1.6.min.js\"type=\"text/javascript\"></script>\r\n");
      out.write("\t<script src=\"js/ligerUI/core/base.js\" type=\"text/javascript\"></script>\r\n");
      out.write("\t<script src=\"js/ligerUI/ligerui.all.js\" type=\"text/javascript\"></script>\r\n");
      out.write("\t<script src=\"js/ligerUI/plugins/ligerDateEditor.js\" type=\"text/javascript\"></script>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("    var ClassData = { Rows: [");
String s = (String) request.getAttribute("classlist");
      out.write(' ');
      out.print(s);
      out.write("]};\r\n");
      out.write("    var ClassList = ClassData.Rows;\r\n");
      out.write("    \r\n");
      out.write("   \t$(f_initGrid);\r\n");
      out.write("\tvar manager, g;\r\n");
      out.write("\tfunction f_initGrid() {\r\n");
      out.write("\t\tg = manager = $(\"#maingrid\").ligerGrid(\r\n");
      out.write("\t\t\t{columns : [\r\n");
      out.write("\t\t\t{display : '序号',  name : 'id',     width : 40,  type : 'int',hide:true},\r\n");
      out.write("\t\t\t{display : '姓名', name : 'teachername', minWidth : 80,  editor:{type:'text'}\t},\r\n");
      out.write("\t\t\t{display : '职称', name : 'position', minWidth : 30,  editor:{type:'text'}},\t\r\n");
      out.write("            {display : '编号', name : 'identificationnum', minWidth : 30 }, \r\n");
      out.write("            {display : '电话', name : 'telephone', minWidth : 120 },\r\n");
      out.write("            {display : '邮箱', name : 'email', minWidth : 120 }\r\n");
      out.write("            ],\r\n");
      out.write("\t\t\tonSelectRow : function(rowdata, rowindex) {\r\n");
      out.write("\t\t\t\t$(\"#txtrowindex\").val(rowindex);\r\n");
      out.write("\t\t\t},\r\n");
      out.write("\t\t\t//checkbox:true,\r\n");
      out.write("\t\t\tenabledEdit : true,\r\n");
      out.write("\t\t\tclickToEdit : false,\r\n");
      out.write("\t\t\tisScroll : false,\r\n");
      out.write("\t\t\trownumbers:true, \r\n");
      out.write("\t\t\tpageSize:15,\r\n");
      out.write("\t\t\turl :\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/system/Class_classTeacherList.action\",\r\n");
      out.write("\t\t\twidth : '100%',\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t}\t \r\n");
      out.write("\t\r\n");
      out.write("\t function confirm () {\r\n");
      out.write("\t  \tvar row = manager.getSelectedRow();\r\n");
      out.write("\t  \tvar ident =  row.identificationnum;\r\n");
      out.write("\t  \tif (ident == \"\"){\r\n");
      out.write("\t  \t\talert(\"请选择班主任！\");\r\n");
      out.write("\t  \t\treturn;\r\n");
      out.write("\t  \t}\r\n");
      out.write("\t \tvar url = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/system/Class_howManyClass.action?queryID=\" + ident;\r\n");
      out.write("\t \t//alert(\"here\");\t\t\r\n");
      out.write("\t\t\t$.ajax({  \r\n");
      out.write("\t\t        type : \"POST\",  \r\n");
      out.write("\t\t        url : url,\r\n");
      out.write("\t\t        dataType : \"JSON\", \r\n");
      out.write("\t\t        error: function (){\r\n");
      out.write("\t\t        \talert(\"服务器错误，请联系管理员!\");\r\n");
      out.write("\t\t        },\r\n");
      out.write("\t\t        success : function(data) {\r\n");
      out.write("\t\t        \tif (data.length > 0){\r\n");
      out.write("\t\t        \t\tvar msg = \"该教师已经是\";\t\r\n");
      out.write("\t\t        \t\tfor(var n=0;n<data.length;n++){\r\n");
      out.write("\t\t        \t\t\tmsg = msg + data[n].classname + \" \";\t\r\n");
      out.write("\t\t          \t\t}; \r\n");
      out.write("\t\t          \t\tmsg = msg + \"的班主任了，是否继续？\";\r\n");
      out.write("\t\t          \t\ttips(msg, ident);\r\n");
      out.write("\t\t          \t\treturn;\t\r\n");
      out.write("\t\t        \t} else {\r\n");
      out.write("\t\t        \t\tprint(ident);\r\n");
      out.write("\t\t        \t};\r\n");
      out.write("\t\t        }  \r\n");
      out.write("\t\t    }); \r\n");
      out.write("\t }\r\n");
      out.write("\t \r\n");
      out.write("\t function print(ident){\r\n");
      out.write("\t  //alert(\"here\");\r\n");
      out.write("\t  var url = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/system/Class_setHeadTeacher.action?queryID=\"+ident;\r\n");
      out.write("\t  $.post(url, null, function() {\r\n");
      out.write("\t\t\tparent.m.hide();\r\n");
      out.write("\t\t\t//parent.window.location.reload();\r\n");
      out.write("\t\t\tparent.g.loadData();\r\n");
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
      out.write("\t }\r\n");
      out.write("\t \r\n");
      out.write("\t function fuzzy () {\r\n");
      out.write("\t\tvar t = $(\"#keyword\").val();\r\n");
      out.write("\t\t$(\"#maingrid\").ligerGrid({\r\n");
      out.write("\t\t  url:\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/system/Class_classTeacherFuzzy.action?fuzzyText=\" + encodeURI(encodeURI(t)),\r\n");
      out.write("\t\t});\r\n");
      out.write("\t}\r\n");
      out.write("\t \r\n");
      out.write("</script>\r\n");
      out.write("\t</head>\r\n");
      out.write("\t<body style=\"padding: 2px\">\r\n");
      out.write("\t <!-- <a class=\"l-button\" style=\"width:70px;float:left; margin:3px;\" onclick=\"tips('aa')\">选&nbsp;&nbsp;择</a> -->       \r\n");
      out.write("\t <!-- <a class=\"l-button\" style=\"width:70px;float:left; margin:3px;\" onclick=\"print()\">打&nbsp;&nbsp;印</a> -->\r\n");
      out.write("\t \r\n");
      out.write("\t <table style=\"width:800px;margin-bottom: 10px\">\r\n");
      out.write("\t \t<tr>\r\n");
      out.write("\t \t\t<td width=\"30px\"></td>\r\n");
      out.write("\t \t\t<td><input type=\"text\" id=\"keyword\" onkeyup=\"fuzzy()\" style=\"font-size:12px; width:180px;\" placeholder=\"姓名 编号 职称\"></td>\r\n");
      out.write("\t \t\t<td width=\"30px\"></td>\r\n");
      out.write("\t \t\t<td><a class=\"l-button\" style=\"width:150px;font-size:12px;float:left; margin:3px;\" onclick=\"confirm()\">设置为班主任</a></td>\r\n");
      out.write("\t \t\t<td></td>\r\n");
      out.write("\t \t</tr>\r\n");
      out.write("\t </table>\r\n");
      out.write("\t \r\n");
      out.write("\t\t<div class=\"l-clear\"></div>\r\n");
      out.write("\t\t<div id=\"maingrid\" ></div>\r\n");
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
