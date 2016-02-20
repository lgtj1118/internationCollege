package org.apache.jsp.WEB_002dINF.manage;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;

public final class rolelist_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\tvar manager, g;\r\n");
      out.write("\tfunction f_initGrid() {\r\n");
      out.write("\t\tg = manager = $(\"#maingrid\").ligerGrid(\r\n");
      out.write("\t\t\t{columns : [\r\n");
      out.write("\t\t\t{   display : 'ID',  name : 'id',     width : 60,  type : 'int',hide:false\r\n");
      out.write("\t\t\t}, {display : '名称', name : 'rolename',  minWidth : 100, editor: { type: 'text'}\r\n");
      out.write("\t\t\t} ,{display : '角色描述', name : 'roledescribe',minWidth : 120,editor: { type: 'text'}\r\n");
      out.write("\t\t\t}, {display : '等级', name : 'rolerank',minWidth : 120,  type: 'text'\r\n");
      out.write("\t\t\t}, {display : '创建时间', name : 'createdate',minWidth : 100\r\n");
      out.write("\t\t\t}, {\r\n");
      out.write("\t\t\t\tdisplay : '权限设置',\r\n");
      out.write("\t\t\t\tisSort : false,\r\n");
      out.write("\t\t\t\twidth : 120,\r\n");
      out.write("\t\t\t\trender : function() {\r\n");
      out.write("\t\t\t\t\tvar h = \"\";\r\n");
      out.write("\t\t\t\t\th += \"<a style='color:#000;' href='javascript:rolemenu(\"+ \")'>查看 / 设置</a> \";\r\n");
      out.write("\t\t\t\t\treturn h;\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t}],\r\n");
      out.write("\t\t\tonSelectRow : function(rowdata, rowindex) {\r\n");
      out.write("\t\t\t\t$(\"#txtrowindex\").val(rowindex);\r\n");
      out.write("\t\t\t},\r\n");
      out.write("\t\t\tcheckbox:false,\r\n");
      out.write("\t\t\tenabledEdit : true,\r\n");
      out.write("\t\t\tclickToEdit : false,\r\n");
      out.write("\t\t\tisScroll : false,\r\n");
      out.write("\t\t\trownumbers:true, \r\n");
      out.write("\t\t\tpageSize:30,\r\n");
      out.write("\t\t\turl :'");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/system/User_rolelist.action',\r\n");
      out.write("\t\t\twidth : '100%'\r\n");
      out.write("\t\t});\r\n");
      out.write("\t}\r\n");
      out.write("\tvar p;\r\n");
      out.write("\tfunction rolemenu(){\r\n");
      out.write("     var row = manager.getSelectedRow();\r\n");
      out.write("\t \tif (!row) {\r\n");
      out.write("\t\t\talert('请选择用户！');\r\n");
      out.write("\t\t\treturn;\r\n");
      out.write("\t\t}\r\n");
      out.write("    var str = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/system/User_rolemenu.action?role.rolerank=\"+row.rolerank+\"&role.id=\"+row.id;\r\n");
      out.write("    p=$.ligerDialog.open({\r\n");
      out.write("\t\t\turl : str,\r\n");
      out.write("\t\t\theight : 600,\r\n");
      out.write("\t\t\twidth : 400,\r\n");
      out.write("\t\t\tisDrag:true,\r\n");
      out.write("\t\t\ttitle:'角色权限设置',\r\n");
      out.write("\t\t\tshowMax:true,\r\n");
      out.write("\t\t\tshowToggle:true,\r\n");
      out.write("\t\t\tslide: false,\t\t\t\r\n");
      out.write("\t\t\tmodal:false,\r\n");
      out.write("\t\t\tleft:300,\r\n");
      out.write("\t\t\tallowClose:true,\r\n");
      out.write("\t\t    isResize : false\r\n");
      out.write("\t\t});\r\n");
      out.write("}\r\n");
      out.write("\tfunction beginEdit() {\r\n");
      out.write("            var row = manager.getSelectedRow();\r\n");
      out.write("            if (!row) { alert('请选择一个角色！'); return; }\r\n");
      out.write("            manager.beginEdit(row);\r\n");
      out.write("        }\r\n");
      out.write("\tfunction cancelEdit(rowid) {\r\n");
      out.write("\t\tmanager.cancelEdit(rowid);\r\n");
      out.write("\t}\r\n");
      out.write("\tfunction endEdit(rowid) {\r\n");
      out.write("\t var row = manager.getSelectedRow();\r\n");
      out.write("\t manager.endEdit(row);\r\n");
      out.write("\t $.post(\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/system/User_roleupdate.action?role.id=\"+ row.id\r\n");
      out.write("\t\t\t\t+\"&role.rolename=\"+encodeURI(encodeURI(row.rolename))\r\n");
      out.write("\t\t\t\t+\"&role.roledescribe=\"+encodeURI(encodeURI(row.roledescribe))\r\n");
      out.write("\t\t\t\t+\"&role.rolerank=\"+encodeURI(encodeURI(row.rolerank))\r\n");
      out.write("\t\t\t\t+\"&role.createdate=\"+encodeURI(encodeURI(row.createdate)));\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\tfunction deleterow() {\r\n");
      out.write("\tvar row = manager.getSelectedRow();\r\n");
      out.write("\t\tif (!row) {\r\n");
      out.write("\t\t\talert('请选择一个角色！');\r\n");
      out.write("\t\t\treturn;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tif (confirm('确定删除?该角色对应的用户将删除！'))\r\n");
      out.write("            {\r\n");
      out.write("              var rows = g.getCheckedRows();\r\n");
      out.write("              var str = \"\";\r\n");
      out.write("              $(rows).each(function(){\r\n");
      out.write("              str += this.id +\",\";\r\n");
      out.write("              });\r\n");
      out.write("              $.post(\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/system/User_roledelete.action?ids=\"+ str);\r\n");
      out.write("\t\t\t  manager.deleteSelectedRow();\t\r\n");
      out.write("            }\r\n");
      out.write("\t}\t \r\n");
      out.write("\tvar m;\r\n");
      out.write("\tfunction addrow(){\r\n");
      out.write("\tvar win1;\r\n");
      out.write("\tif (win1) win1.show();\r\n");
      out.write("\telse{\r\n");
      out.write("\tvar str = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/system/User_rolebeginadd.action\";\r\n");
      out.write("\t\tm=$.ligerDialog.open({\r\n");
      out.write("\t\t\turl : str,\r\n");
      out.write("\t\t\theight : 320,\r\n");
      out.write("\t\t\twidth : 380,\r\n");
      out.write("\t\t\tisDrag:true,\r\n");
      out.write("\t\t\ttitle:'添加角色',\r\n");
      out.write("\t\t\tshowMax:true,\r\n");
      out.write("\t\t\tshowToggle:true,\r\n");
      out.write("\t\t\tslide: false,\t\t\t\r\n");
      out.write("\t\t\tmodal:false,\r\n");
      out.write("\t\t\tleft:300,\r\n");
      out.write("\t\t\tallowClose:true,\r\n");
      out.write("\t\t    isResize : false\r\n");
      out.write("\t\t});}\r\n");
      out.write("\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t}\r\n");
      out.write("</script>\r\n");
      out.write("\t</head>\r\n");
      out.write("\t<body style=\"padding: 2px\">\r\n");
      out.write("\t <!-- <a class=\"l-button\" style=\"width:70px;float:left; margin:3px;\" onclick=\"addrow()\">添&nbsp;&nbsp;加</a>       \r\n");
      out.write("\t <a class=\"l-button\" style=\"width:70px;float:left; margin:3px;\" onclick=\"deleterow()\">删&nbsp;&nbsp;除</a>\r\n");
      out.write("\t <a class=\"l-button\" style=\"width:70px;float:left; margin:3px;\" onclick=\"beginEdit()\">修&nbsp;&nbsp;改</a>\r\n");
      out.write("\t <a class=\"l-button\" style=\"width:80px;float:left; margin:3px;\" onclick=\"cancelEdit()\">取消修改</a>\r\n");
      out.write("\t <a class=\"l-button\" style=\"width:70px;float:left; margin:3px;\" onclick=\"endEdit()\">保存</a> -->\r\n");
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
