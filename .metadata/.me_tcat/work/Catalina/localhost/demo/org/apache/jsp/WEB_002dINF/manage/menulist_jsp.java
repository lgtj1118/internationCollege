package org.apache.jsp.WEB_002dINF.manage;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;

public final class menulist_jsp extends org.apache.jasper.runtime.HttpJspBase
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
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";

      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<base href=\"");
      out.print(basePath);
      out.write("\">\r\n");
      out.write("<title>天津工业大学排课管理系统</title>\r\n");
      out.write("<link href=\"");
      out.print(basePath);
      out.write("js/ligerUI/skins/Aqua/css/ligerui-all.css\" rel=\"stylesheet\"type=\"text/css\" />\t\r\n");
      out.write("\t<link href=\"");
      out.print(basePath );
      out.write("js/ligerUI/skins/Gray/css/all.css\" rel=\"stylesheet\" type=\"text/css\"/>\t\r\n");
      out.write("    <link href=\"js/ligerUI/skins/ligerui-icons.css\" rel=\"stylesheet\" type=\"text/css\">\r\n");
      out.write("\t<script src=\"js/ligerUI/plugins/ligerToolBar.js\" type=\"text/javascript\"></script>\r\n");
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
      out.write("var MenuData = {Rows: [\r\n");
      out.write("\t\t");
String  s= (String) request.getAttribute("menulist");
      out.write("\r\n");
      out.write("\t\t");
      out.print(s);
      out.write("\r\n");
      out.write("\t\t ]};\t\r\n");
      out.write("\tvar manager;\r\n");
      out.write("\t$(function(){\r\n");
      out.write("\t\tmanager = $(\"#maingrid\").ligerGrid({\r\n");
      out.write("\t\t\tcolumns : [ {\r\n");
      out.write("\t\t\t\tdisplay : 'ID',\r\n");
      out.write("\t\t\t\tname : 'id',\r\n");
      out.write("\t\t\t\twidth : 40,\r\n");
      out.write("\t\t\t\talign : 'center',\r\n");
      out.write("\t\t\t\ttype: 'int',frozen:true\r\n");
      out.write("\t\t\t},{\r\n");
      out.write("\t\t\t\tdisplay : '导航名',\r\n");
      out.write("\t\t\t\tname : 'name',\r\n");
      out.write("\t\t\t\tWidth : 200,\r\n");
      out.write("\t\t\t\talign : 'left',\r\n");
      out.write("\t\t\t\teditor : {\r\n");
      out.write("\t\t\t\t\ttype : 'text'\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t},{\r\n");
      out.write("\t\t\t\tdisplay : '英文名',\r\n");
      out.write("\t\t\t\tname : 'enname',\r\n");
      out.write("\t\t\t\tWidth : 220,\r\n");
      out.write("\t\t\t\talign : 'center',\r\n");
      out.write("\t\t\t\teditor : {\r\n");
      out.write("\t\t\t\t\ttype : 'text'\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t},{\r\n");
      out.write("\t\t\t\tdisplay : '父节点',\r\n");
      out.write("\t\t\t\tname : 'parentnav',\r\n");
      out.write("\t\t\t\tWidth : 100,\r\n");
      out.write("\t\t\t\talign : 'center',\r\n");
      out.write("\t\t\t\t/* editor : {\r\n");
      out.write("\t\t\t\t\ttype : 'int'\r\n");
      out.write("\t\t\t\t} */\r\n");
      out.write("\t\t\t}, {\r\n");
      out.write("\t\t\t\tdisplay : '路径',\r\n");
      out.write("\t\t\t\tname : 'menuurl',\r\n");
      out.write("\t\t\t\tWidth : 250,\r\n");
      out.write("\t\t\t\talign : 'center'\r\n");
      out.write("\t\t\t\t/* editor : {\r\n");
      out.write("\t\t\t\t\ttype : 'text'\r\n");
      out.write("\t\t\t\t} */\r\n");
      out.write("\t\t\t} ],\r\n");
      out.write("\t\t\t//width : '100%',\r\n");
      out.write("\t\t\tpageSizeOptions : [ 5, 10, 15, 20 ],\r\n");
      out.write("\t\t\theight : '97%',\r\n");
      out.write("\t\t\tonSelectRow : function(rowdata , rowindex){\r\n");
      out.write("\t\t\t\t$(\"#txtrowindex\").val(rowindex);\r\n");
      out.write("\t\t\t},\r\n");
      out.write("\t\t\tdata : MenuData,\r\n");
      out.write("\t\t\talternatingRow : false,\r\n");
      out.write("\t\t\tenabledEdit : true,\r\n");
      out.write("\t\t\tclickToEdit : false,\r\n");
      out.write("\t\t\trownumbers:true,\r\n");
      out.write("\t\t\ttree : {columnName : 'name'},\r\n");
      out.write("\t\t\tcheckbox : false,\r\n");
      out.write("\t\t\tautoCheckChildren : false\r\n");
      out.write("\t\t\t/* toolbar: { items: [{ text: '添加',click: addRow,  icon: 'add' },\r\n");
      out.write("\t\t\t\t\t                   { text: '修改',click: beginEdit,  icon: 'edit' },\r\n");
      out.write("\t\t\t\t\t                   { text: '取消编辑', click: cancelEdit, icon:'save-disabled'},\r\n");
      out.write("\t\t\t\t\t                   { text: '删除',click: deleteRow,  icon: 'delete' },\r\n");
      out.write("\t\t\t\t\t                   { text: '保存',click: endEdit,  icon: 'save' },\r\n");
      out.write("\t\t\t\t\t                   \r\n");
      out.write("\t\t\t\t\t                   ]} */\r\n");
      out.write("\t\t});\r\n");
      out.write("\t});\r\n");
      out.write("\tfunction deleteRow(){\r\n");
      out.write("\t\tvar row = manager.getSelectedRow();\r\n");
      out.write("\t\tif (!row) {alert('请选择一个菜单节点！');return;}\r\n");
      out.write("\t    $.ligerDialog.confirm('对应的子菜单节点和角色中对应菜单也将被删除！确认删除吗？', function (yes){\r\n");
      out.write("         if(yes){\t\r\n");
      out.write("\t       $.ligerDialog.prompt('请输入确认密码', function (yes, value){\r\n");
      out.write("                   if (yes){ //验证密码\r\n");
      out.write("                        var userid = ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${sessionScope.user.id}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write(";\r\n");
      out.write("                        $.post(\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/system/User_pwdcheck.action?user.id=\"+ userid\r\n");
      out.write("\t\t                +\"&user.password=\"+value , null, function(data) {\r\n");
      out.write("\t\t\t\t\t       if (data == \"fail\") {\r\n");
      out.write("\t\t\t\t\t\t     alert(\"输入的密码不正确!\");\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t       } else {\r\n");
      out.write("\t                           $.post(\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/system/Menu_menudelete.action?menu.id=\"\r\n");
      out.write("\t\t\t\t                  + row.id,null,function(){\r\n");
      out.write("\t\t\t\t\t                 manager.deleteSelectedRow();\r\n");
      out.write("\t\t\t\t\t                 window.location.reload(); \r\n");
      out.write("\t\t\t\t               });\r\n");
      out.write("\t\t                   }\r\n");
      out.write("\t\t                });\r\n");
      out.write("\t\t            }\r\n");
      out.write("\t\t        });\r\n");
      out.write("\t\t     }\r\n");
      out.write("\t\t });\r\n");
      out.write("\t}\t\r\n");
      out.write("\tfunction beginEdit() {\r\n");
      out.write("            var row = manager.getSelectedRow();\r\n");
      out.write("            if (!row) { alert('请选择一个菜单节点！'); return; }\r\n");
      out.write("            manager.beginEdit(row);          \r\n");
      out.write("        }\r\n");
      out.write("\tfunction cancelEdit(rowid) {\r\n");
      out.write("\t\tmanager.cancelEdit(rowid);\r\n");
      out.write("\t}\r\n");
      out.write("\tfunction endEdit(rowid) {\r\n");
      out.write("\t var row = manager.getSelectedRow();\r\n");
      out.write("\t\tmanager.endEdit(row);\r\n");
      out.write("\t\tvar reg = /^[\\u4e00-\\u9fa5]+$/gi;\r\n");
      out.write("        if(row.name.length==0||row.enname.length==0){\r\n");
      out.write("           alert(\"导航名称不能为空！\");\r\n");
      out.write("           cancelEdit(rowid);\r\n");
      out.write("           window.location.reload();\r\n");
      out.write("        }else{\r\n");
      out.write("           if(!reg.test(row.name)){\r\n");
      out.write("             alert(\"导航名称只能为中文\");\r\n");
      out.write("             cancelEdit(rowid);\r\n");
      out.write("             window.location.reload();\r\n");
      out.write("           }else{\r\n");
      out.write("              var regx = /^[a-zA-Z]{2,}$/;\r\n");
      out.write("              if(!regx.test(row.enname)){\r\n");
      out.write("                 alert(\"只能为两个以上的英文字符！\");\r\n");
      out.write("                 cancelEdit(rowid);\r\n");
      out.write("                 window.location.reload();             \r\n");
      out.write("              }else{\r\n");
      out.write("                 $.post(\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/system/Menu_menuupdate.action?menu.id=\"+ row.id\r\n");
      out.write("\t\t\t\t+\"&menu.namenav=\"+encodeURI(encodeURI(row.name))\r\n");
      out.write("\t\t\t\t+\"&menu.enname=\"+encodeURI(encodeURI(row.enname))\r\n");
      out.write("\t\t\t\t+\"&id=\"+encodeURI(encodeURI(row.parentnav))\r\n");
      out.write("\t\t\t\t+\"&menu.menuurl=\"+encodeURI(encodeURI(row.menuurl)),null,function(){\r\n");
      out.write("\t\t\t\twindow.location.reload(); \r\n");
      out.write("\t\t\t\t} );\r\n");
      out.write("              }            \r\n");
      out.write("           }\r\n");
      out.write("        }\r\n");
      out.write("           \r\n");
      out.write("\t\r\n");
      out.write("\t}\r\n");
      out.write("    var m;\r\n");
      out.write("\tfunction addRow(){\r\n");
      out.write("\t\tvar str = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/system/Menu_menubeginadd.action\";\r\n");
      out.write("\t\tm=$.ligerDialog.open({\r\n");
      out.write("\t\t\turl : str,\r\n");
      out.write("\t\t\theight : 350,\r\n");
      out.write("\t\t\ttitle:'添加菜单节点',\r\n");
      out.write("\t\t\twidth : 380,\r\n");
      out.write("\t\t\tisResize : true\r\n");
      out.write("\t\t});\t\t\r\n");
      out.write("\t}\r\n");
      out.write("</script>\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write(".l-button {\r\n");
      out.write("\twidth: 120px;\r\n");
      out.write("\tfloat: left;\r\n");
      out.write("\tmargin-left: 10px;\r\n");
      out.write("\tmargin-bottom: 2px;\r\n");
      out.write("\tmargin-top: 2px;\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("</head>\r\n");
      out.write("<body style=\"padding: 4px\">\r\n");
      out.write("\t <div><strong>注意事项</strong>：<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; \r\n");
      out.write("\t               1. 一级菜单，请勿设置链接路径。<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\r\n");
      out.write("2. 菜单添加时，0代表一级菜单。<br><br> \r\n");
      out.write("\t    </div> \r\n");
      out.write("\t<div>\r\n");
      out.write("\t\t<a class=\"l-button\" style=\"width:60px;float:left; margin:3px;\" onclick=\"deleteRow()\">删除</a>\r\n");
      out.write("\t\t<a class=\"l-button\" style=\"width:60px;float:left; margin:3px;\" onclick=\"addRow()\">添加</a> \r\n");
      out.write("\t\t<a class=\"l-button\" style=\"width:60px;float:left; margin:3px;\" onclick=\"beginEdit()\">修&nbsp;改</a>\r\n");
      out.write("\t\t<a class=\"l-button\" style=\"width:80px;float:left; margin:3px;\" onclick=\"cancelEdit()\">取消修改</a>\r\n");
      out.write("\t    <a class=\"l-button\" style=\"width:70px;float:left; margin:3px;\" onclick=\"endEdit()\">保存</a>\t\r\n");
      out.write("\t\t<div class=\"l-clear\"></div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<div id=\"maingrid\"></div>\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
      out.write("\r\n");
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
