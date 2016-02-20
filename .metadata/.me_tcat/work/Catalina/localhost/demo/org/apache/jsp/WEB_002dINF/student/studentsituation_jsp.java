package org.apache.jsp.WEB_002dINF.student;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;

public final class studentsituation_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("    <script type=\"text/javascript\" src=\"js/jquery-validation/jquery.validate.min.js\" charset=\"utf-8\"></script>\r\n");
      out.write("    <script type=\"text/javascript\" src=\"js/json2.js\" charset=\"utf-8\"></script>\r\n");
      out.write("    <script type=\"text/javascript\" src=\"js/jquery-validation/jquery.metadata.js\" charset=\"utf-8\"></script>\r\n");
      out.write("    <script type=\"text/javascript\" src=\"js/jquery-validation/messages_cn.js\" charset=\"utf-8\"></script>\r\n");
      out.write("    <script src=\"js/jquery/jquery-1.3.2.min.js\"type=\"text/javascript\"></script>\r\n");
      out.write("\t<script src=\"js/ligerUI/core/base.js\" type=\"text/javascript\"></script>\r\n");
      out.write("\t<script src=\"js/ligerUI/ligerui.all.js\" type=\"text/javascript\"></script>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("   $(f_initGrid);\r\n");
      out.write("        var manager, g;\r\n");
      out.write("        function f_initGrid()\r\n");
      out.write("        {\r\n");
      out.write("            g = manager = $(\"#maingrid\").ligerGrid({\r\n");
      out.write("                columns: [\r\n");
      out.write("                { display: '主键', name: 'id', width: 50, type: 'int',hide:true },\r\n");
      out.write("                { display: '日期', name: 'date',minWidth: 80 },\r\n");
      out.write("                { display: '姓名', name: 'stuname',minWidth: 80 },\r\n");
      out.write("                { display: '学号', name: 'stuid',minWidth: 80,hide:true },\r\n");
      out.write("                { display: '性别', name: 'sex',minWidth: 100},\r\n");
      out.write("                { display: '平时表现', columns:[\r\n");
      out.write("                   {display: '学习方面', name: 'study', align: 'center', minWidth: 120,editor: { type: 'text' }},\r\n");
      out.write("                   {display: '生活方面', name: 'dailylife', align: 'center', minWidth: 120,editor: { type: 'text' }},\r\n");
      out.write("                   {display: '活动能力', name: 'event', align: 'center', minWidth: 120,editor: { type: 'text' }},\r\n");
      out.write("                   {display: '突出表现', name: 'outstanding', align: 'center', minWidth: 120,editor: { type: 'text' }},\r\n");
      out.write("                   {display: '心理', name: 'psychicology', align: 'center', minWidth: 120,editor: { type: 'text' }}]\r\n");
      out.write("                },\r\n");
      out.write("                { display: '备注', name: 'remark',Width: 100,editor: { type: 'text' }}               \r\n");
      out.write("                ],\r\n");
      out.write("                onSelectRow: function (rowdata, rowindex)\r\n");
      out.write("                {\r\n");
      out.write("                    $(\"#txtrowindex\").val(rowindex);\r\n");
      out.write("                },\r\n");
      out.write("                enabledEdit: true,clickToEdit:false, isScroll: false,\r\n");
      out.write("                url:'");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/system/Class_performancelist.action',\r\n");
      out.write("                rownumbers:true,\r\n");
      out.write("                pageSize:20,\r\n");
      out.write("                width: '100%'\r\n");
      out.write("               \r\n");
      out.write("            });   \r\n");
      out.write("        }\r\n");
      out.write("        function beginEdit() {\r\n");
      out.write("          if(");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${session.user.roles.rolerank==2}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write('|');
      out.write('|');
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${session.user.roles.rolerank==2}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("){\r\n");
      out.write("             var row = manager.getSelectedRow();\r\n");
      out.write("            if (!row) { alert('请选择一项！'); return; }\r\n");
      out.write("            var str =\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/system/Class_performanceedit.action?performance.id=\"+ row.id;\r\n");
      out.write("\t\t\tm=$.ligerDialog.open({\r\n");
      out.write("\t\t\turl : str,\r\n");
      out.write("\t\t\theight : 500,\r\n");
      out.write("\t\t\twidth : 700,\r\n");
      out.write("\t\t\ttitle:'更新',\r\n");
      out.write("\t\t\tisResize : true\r\n");
      out.write("\t\t  });\r\n");
      out.write("          }else{\r\n");
      out.write("            alert(\"您不是任课教师或班主任，不能修改！\");\r\n");
      out.write("          }\r\n");
      out.write("            \r\n");
      out.write("\t}\r\n");
      out.write("\tvar m;\r\n");
      out.write("    function addrow(){\r\n");
      out.write("    if(");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${session.user.roles.rolerank==2}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write('|');
      out.write('|');
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${session.user.roles.rolerank==4}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("){   \r\n");
      out.write("\tvar str = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/system/Class_performancebegainadd.action\";\r\n");
      out.write("\t\tm=$.ligerDialog.open({\r\n");
      out.write("\t\t\turl : str,\r\n");
      out.write("\t\t\theight : 500,\r\n");
      out.write("\t\t\twidth : 700,\r\n");
      out.write("\t\t\tisResize : true\r\n");
      out.write("\t\t});\r\n");
      out.write("\t}\t\r\n");
      out.write("\t}\r\n");
      out.write("\tfunction deleterow() {\r\n");
      out.write("\tif(");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${session.user.roles.rolerank==2}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write('|');
      out.write('|');
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${session.user.roles.rolerank==4}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("){          \r\n");
      out.write("\t    var row = manager.getSelectedRow();\r\n");
      out.write("\t\tif (!row) {alert('请选择一项！');return;}\r\n");
      out.write("\t\t$.ligerDialog.confirm('确认删除学生情况记录？', function (yes){\r\n");
      out.write("           if(yes){\t\t\r\n");
      out.write("\t           $.post(\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/system/Class_performancedelete.action?ids=\"\r\n");
      out.write("\t\t\t\t   + row.id,null,function(){\r\n");
      out.write("\t\t\t\t\t manager.deleteSelectedRow();\r\n");
      out.write("\t\t\t\t});\t\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t}else{\r\n");
      out.write("      alert(\"您不是任课教师或班主任，不能修改！\");\r\n");
      out.write("    }\t\r\n");
      out.write("\t}\t\r\n");
      out.write("</script>\r\n");
      out.write("\t</head>\r\n");
      out.write("\t<body style=\"padding: 2px\">\r\n");
      out.write("\t<br><a class=\"l-button\" style=\"width:60px;float:left; margin:3px;\" onclick=\"addrow()\">添&nbsp;加</a>\r\n");
      out.write("\t\t\t<a class=\"l-button\" style=\"width:60px;float:left; margin:3px;\" onclick=\"deleterow()\">删&nbsp;除</a>\r\n");
      out.write("\t\t\t<a class=\"l-button\" style=\"width:60px;float:left; margin:3px;\" onclick=\"beginEdit()\">修&nbsp;改</a>\r\n");
      out.write("\t\t\t<!-- <a class=\"l-button\" style=\"width:80px;float:left; margin:3px;\" onclick=\"cancelEdit()\">取消修改</a>\r\n");
      out.write("\t\t    <a class=\"l-button\" style=\"width:70px;float:left; margin:3px;\" onclick=\"endEdit()\">保存</a>   -->    \r\n");
      out.write("\t \t<div class=\"l-clear\"></div>\r\n");
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
