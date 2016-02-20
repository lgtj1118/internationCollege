package org.apache.jsp.WEB_002dINF.arrange;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import org.springframework.web.context.request.SessionScope;
import java.util.*;

public final class semesterclassroom_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("    <script type=\"text/javascript\" src=\"js/jquery-validation/jquery.metadata.js\" charset=\"utf-8\"></script>\r\n");
      out.write("    <script type=\"text/javascript\" src=\"js/jquery-validation/messages_cn.js\" charset=\"utf-8\"></script>\r\n");
      out.write("    <script src=\"js/jquery/jquery-1.3.2.min.js\"type=\"text/javascript\"></script>\r\n");
      out.write("\t<script src=\"js/ligerUI/core/base.js\" type=\"text/javascript\"></script>\r\n");
      out.write("\t<script src=\"js/ligerUI/ligerui.all.js\" type=\"text/javascript\"></script>\r\n");
      out.write("\t<script src=\"js/ligerUI/plugins/ligerToolBar.js\" type=\"text/javascript\"></script>\r\n");
      out.write("\t<script type=\"text/javascript\" src=\"js/semester.js\" ></script>\r\n");
      out.write("<script type=\"text/javascript\">  \r\n");
      out.write("   $(f_initGrid);\r\n");
      out.write("\t$(f_initGrid1);\r\n");
      out.write("\tvar manager, g;\r\n");
      out.write("\tfunction f_initGrid() {\r\n");
      out.write("\t\tg = manager = $(\"#maingrid1\").ligerGrid(\r\n");
      out.write("\t\t{\t\t\t\r\n");
      out.write("\t\t\t\tcolumns : [\r\n");
      out.write("\t\t\t{   display : 'ID',  name : 'id',     width : 60,  type : 'int',hide:true\r\n");
      out.write("\t\t\t}, {display : '编号', name : 'num',  minWidth : 120, editor: { type: 'text'}\r\n");
      out.write("\t\t\t}, {display : '名称', name : 'roomname',  minWidth : 120, editor: { type: 'text'}\r\n");
      out.write("\t\t\t} ,{display : '位置', name : 'roomplace',minWidth : 140,editor: { type: 'text'}\r\n");
      out.write("\t\t\t}, {display : '类型', name : 'roomtype',minWidth : 120, editor: { type: 'text'}\r\n");
      out.write("\t\t\t}, {display : '容量', name : 'roomcapacity',minWidth : 100, editor: { type: 'text'}\r\n");
      out.write("\t\t\t}, {display : '实际容量', name : 'realcapacity',minWidth : 100, editor: { type: 'text'}\t\t\t\r\n");
      out.write("\t\t\t}, {display : '备注', name : 'note',minWidth : 120, editor: { type: 'text'}\r\n");
      out.write("\t\t\t} ],\r\n");
      out.write("\t\t\t\t\tonSelectRow : function(rowdata, rowindex) {\r\n");
      out.write("\t\t\t\t\t\t$(\"#txtrowindex\").val(rowindex);\r\n");
      out.write("\t\t\t\t\t},\r\n");
      out.write("\t\t\t\t\tcheckbox:true,\r\n");
      out.write("\t\t\t\t\tenabledEdit : true,\r\n");
      out.write("\t\t\t\t\tclickToEdit : false,\r\n");
      out.write("\t\t\t\t\tisScroll : false,\r\n");
      out.write("\t\t\t\t\trownumbers:true, \r\n");
      out.write("\t\t\t\t\tpageSize:30,\r\n");
      out.write("\t\t\t\t\ttitle:'待选教室',\r\n");
      out.write("\t\t\t\t\turl :'");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/system/Manage_roomlist.action',\r\n");
      out.write("\t\t\t\t\twidth : '38%'\r\n");
      out.write("\t\t\t\t});\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("var managers, gs;\r\n");
      out.write("\tfunction f_initGrid1() {\r\n");
      out.write("\t\tgs = managers = $(\"#maingrid2\").ligerGrid(\r\n");
      out.write("\t\t\t\t{\t\t\t\r\n");
      out.write("\t\t\t\tcolumns : [\r\n");
      out.write("\t\t\t{   display : 'ID',  name : 'id',     width : 60,  type : 'int',hide:true\r\n");
      out.write("\t\t\t}, {display : '编号', name : 'num',  minWidth : 120, editor: { type: 'text'}\r\n");
      out.write("\t\t\t}, {display : '名称', name : 'roomname',  minWidth : 120, editor: { type: 'text'}\r\n");
      out.write("\t\t\t} ,{display : '位置', name : 'roomplace',minWidth : 140,editor: { type: 'text'}\r\n");
      out.write("\t\t\t}, {display : '类型', name : 'roomtype',minWidth : 120, editor: { type: 'text'}\r\n");
      out.write("\t\t\t}, {display : '容量', name : 'roomcapacity',minWidth : 100, editor: { type: 'text'}\r\n");
      out.write("\t\t\t}, {display : '实际容量', name : 'realcapacity',minWidth : 100, editor: { type: 'text'}\t\t\t\r\n");
      out.write("\t\t\t}, {display : '备注', name : 'note',minWidth : 120, editor: { type: 'text'}\r\n");
      out.write("\t\t\t} ],\r\n");
      out.write("\t\t\t\t\tonSelectRow : function(rowdata, rowindex) {\r\n");
      out.write("\t\t\t\t\t\t$(\"#txtrowindex\").val(rowindex);\r\n");
      out.write("\t\t\t\t\t},\r\n");
      out.write("\t\t\t\t\tcheckbox:true,\r\n");
      out.write("\t\t\t\t\tenabledEdit : true,\r\n");
      out.write("\t\t\t\t\tclickToEdit : false,\r\n");
      out.write("\t\t\t\t\tisScroll : false,\r\n");
      out.write("\t\t\t\t\trownumbers:true, \r\n");
      out.write("\t\t\t\t\tpageSize:30,\r\n");
      out.write("\t\t\t\t\ttitle:'已选教室',\r\n");
      out.write("\t\t\t\t\turl :'");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/system/Manage_semesterroomlist.action',\r\n");
      out.write("\t\t\t\t\twidth : '38%'\r\n");
      out.write("\t\t\t\t});\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\tfunction f_selected(){\r\n");
      out.write("\t var semester = $(\"#semester option:selected\").val();\r\n");
      out.write("       if(semester.length!=0){\r\n");
      out.write("\t       var row = manager.getSelectedRow();\r\n");
      out.write("           if (!row) { alert('请至少选择一个课程！'); return; }\r\n");
      out.write("           var rows = g.getCheckedRows();\r\n");
      out.write("           var str = \"\";\r\n");
      out.write("           $(rows).each(function () {\r\n");
      out.write("               str += this.id + \",\";\r\n");
      out.write("           });\r\n");
      out.write("           $.post(\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/system/Manage_semesterroomadd.action?ids=\"+str+\"&semester=\"+semester,null,function(){\r\n");
      out.write("           alert(\"选定成功！\");\r\n");
      out.write("            window.location.reload();\r\n");
      out.write("           //manager.deleteSelectedRow();\r\n");
      out.write("          })\r\n");
      out.write("\t   }else{\r\n");
      out.write("\t     alert(\"请先选定学期\");\r\n");
      out.write("\t   }\r\n");
      out.write("\t   }\r\n");
      out.write("\tfunction f_delete(){\r\n");
      out.write("\tvar row = managers.getSelectedRow();\r\n");
      out.write("      if (!row) { alert('请至少选择一个课程！'); return; }\r\n");
      out.write("      var rows = gs.getCheckedRows();\r\n");
      out.write("      var str = \"\";\r\n");
      out.write("      $(rows).each(function ()\r\n");
      out.write("      {\r\n");
      out.write("         str += this.id + \",\";\r\n");
      out.write("      });\r\n");
      out.write("      $.post(\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/system/Manage_semesterroomdelete.action?ids=\"+str,null,function(){\r\n");
      out.write("        alert(\"删选成功！\");\r\n");
      out.write("        window.location.reload();        \r\n");
      out.write("      })\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("</script>\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write("#contain{\r\n");
      out.write(" width: 100%;\r\n");
      out.write(" border: 1px solid #c6c6c6;\r\n");
      out.write("}\r\n");
      out.write(".l-button{\r\n");
      out.write(" width:80px; margin:20px 50px ;\r\n");
      out.write(" border-radiux:5px;\r\n");
      out.write("}\r\n");
      out.write("#l-l-button{\r\n");
      out.write(" width:80px; \r\n");
      out.write(" margin-top:100px;\r\n");
      out.write(" border-radiux:5px;\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("\t</head>\r\n");
      out.write("\t<body style=\"padding: 2px\">\t\r\n");
      out.write("\t    <div style=\"margin: 10px;\">选择教室，即可作为本学期课程可用教室</div>\t\t\t\r\n");
      out.write("\t\t<div class=\"l-clear\"></div>\r\n");
      out.write("\t\t<div id=\"maingrid1\" style=\"margin: 4px;margin-left:10px; padding: 0; float: left;\" ></div>\r\n");
      out.write("\t\t<div id=\"btnclass\" style=\"width:14%;margin: 4px; padding: 0; float: left;\" >\r\n");
      out.write("\t\t   <div> 学期：&nbsp;<select id=\"semester\" style=\"\" name=\"semester\" >\r\n");
      out.write("\t\t\t     <option value=\"\" ></option>\t\t\t     \r\n");
      out.write("\t\t   </select></div>\r\n");
      out.write("\t\t   <a class=\"l-button\" onclick=\"f_selected()\"><strong>选定教室>></strong></a>\r\n");
      out.write("\t\t   <a class=\"l-button\" onclick=\"f_delete()\"><strong><<移除教室</strong></a>\r\n");
      out.write("\t\t   <!-- <a class=\"l-button\" onclick=\"f_allselected()\"><strong>全部选定>></strong></a>\r\n");
      out.write("\t\t   <a class=\"l-button\" onclick=\"f_alldelete()\"><strong><<全部移除</strong></a> -->\r\n");
      out.write("\t\t   \r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div id=\"maingrid2\" style=\"margin: 4px;margin-right:10px; padding: 0; margin-left: 10px; float: left;\" ></div>\t\t \r\n");
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
