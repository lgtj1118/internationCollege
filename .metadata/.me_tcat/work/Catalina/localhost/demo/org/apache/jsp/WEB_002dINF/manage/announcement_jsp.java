package org.apache.jsp.WEB_002dINF.manage;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;

public final class announcement_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("                { display: '主键', name: 'id', width: 50, type: 'int', /* frozen: true, */hide:true },\r\n");
      out.write("                { display: '标题', name: 'title',minWidth: 80,\r\n");
      out.write("                    editor: { type: 'text' }\r\n");
      out.write("                },\r\n");
      out.write("                { display: '创建时间', name: 'createdtime',Width: 100\r\n");
      out.write("                },\r\n");
      out.write("                { display: '操作', isSort: false, minWidth: 200, render: function (rowdata, rowindex, value)\r\n");
      out.write("                {\r\n");
      out.write("                    var h = \"\";\r\n");
      out.write("                    h += \"<a href='javascript:edit(\" + rowindex + \")'>修改</a> \";\r\n");
      out.write("                    h +=\" \";\r\n");
      out.write("                    h += \"<a href='javascript:deleteRow(\" + rowindex + \")'>删除</a> \";\r\n");
      out.write("                    return h;\r\n");
      out.write("                }\r\n");
      out.write("                }\r\n");
      out.write("                ],\r\n");
      out.write("                onSelectRow: function (rowdata, rowindex)\r\n");
      out.write("                {\r\n");
      out.write("                    $(\"#txtrowindex\").val(rowindex);\r\n");
      out.write("                },\r\n");
      out.write("                enabledEdit: true,clickToEdit:false, isScroll: false,\r\n");
      out.write("                url:'system/Manage_announcementlist.action',\r\n");
      out.write("                pageSize:20,\r\n");
      out.write("                rownumbers:true,\r\n");
      out.write("                width: '100%'\r\n");
      out.write("               \r\n");
      out.write("            });   \r\n");
      out.write("        }\r\n");
      out.write("        function edit(rowid){\r\n");
      out.write("        \tvar row = manager.getSelectedRow();\r\n");
      out.write("        \tvar str = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/system/Manage_announcementedit.action?announcement.id=\"+row.id;\r\n");
      out.write("        \tm=$.ligerDialog.open({\r\n");
      out.write("\t\t\turl : str,\r\n");
      out.write("\t\t\theight : 550,\r\n");
      out.write("\t\t\twidth : 800,\r\n");
      out.write("\t\t\tisDrag:true,\r\n");
      out.write("\t\t\ttitle:'更新公告',\r\n");
      out.write("\t\t\tshowMax:true,\r\n");
      out.write("\t\t\tshowToggle:true,\r\n");
      out.write("\t\t\tslide: false,\t\t\t\r\n");
      out.write("\t\t\tmodal:false,\r\n");
      out.write("\t\t\tallowClose:true,\r\n");
      out.write("\t\t    isResize : false\r\n");
      out.write("\t\t});\r\n");
      out.write("        }\r\n");
      out.write("        function deleteRow(rowid)\r\n");
      out.write("        {\r\n");
      out.write("            if (confirm('确定删除?'))\r\n");
      out.write("            {\r\n");
      out.write("               var did = manager.getRow(rowid).id;\r\n");
      out.write("                if(did!=null){\r\n");
      out.write("                \t$.post('system/Manage_announcementdelete.action',{ids:did},function(){\t               \t                \r\n");
      out.write("\t                manager.deleteRow(rowid);\t                \t                \r\n");
      out.write("\t                });\r\n");
      out.write("                }                \r\n");
      out.write("            }\r\n");
      out.write("        }\r\n");
      out.write("        function addrow(){\r\n");
      out.write("        var str = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/system/Manage_announcementbegainadd.action\";\r\n");
      out.write("        m=$.ligerDialog.open({\r\n");
      out.write("\t\t\turl : str,\r\n");
      out.write("\t\t\theight : 550,\r\n");
      out.write("\t\t\twidth : 800,\r\n");
      out.write("\t\t\tisDrag:true,\r\n");
      out.write("\t\t\ttitle:'添加公告',\r\n");
      out.write("\t\t\tshowMax:true,\r\n");
      out.write("\t\t\tshowToggle:true,\r\n");
      out.write("\t\t\tslide: false,\t\t\t\r\n");
      out.write("\t\t\tmodal:false,\r\n");
      out.write("\t\t\tallowClose:true,\r\n");
      out.write("\t\t    isResize : false\r\n");
      out.write("\t\t});\r\n");
      out.write("        }\r\n");
      out.write("</script>\r\n");
      out.write("\t</head>\r\n");
      out.write("\t<body style=\"padding: 2px\">\r\n");
      out.write("\t<br> <a class=\"l-button\" style=\"width:120px;float:left; margin:10px;\" onclick=\"addrow()\">添加新公告</a>       \r\n");
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
