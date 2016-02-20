package org.apache.jsp.WEB_002dINF.manage;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;

public final class departmentmanagement_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\t<link href=\"js/ligerUI/skins/ligerui-icons.css\" rel=\"stylesheet\" type=\"text/css\">\r\n");
      out.write("\t<script src=\"js/ligerUI/plugins/ligerToolBar.js\" type=\"text/javascript\"></script>\r\n");
      out.write("    <script type=\"text/javascript\" src=\"");
      out.print(basePath );
      out.write("js/json2.js\" charset=\"utf-8\"></script>\r\n");
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
      out.write("     $(f_initGrid);\r\n");
      out.write("\tvar manager, g;\r\n");
      out.write("\tfunction f_initGrid() {\r\n");
      out.write("\t\tg = manager = $(\"#maingrid\").ligerGrid(\r\n");
      out.write("\t\t\t{columns : [{\r\n");
      out.write("\t\t\t\tdisplay : '序号',\r\n");
      out.write("\t\t\t\tname : 'deptid',\r\n");
      out.write("\t\t\t\twidth : 60,\r\n");
      out.write("\t\t\t\thide:true,\r\n");
      out.write("\t\t\t\ttype : 'int'\r\n");
      out.write("\t\t\t}, {\r\n");
      out.write("\t\t\t\tdisplay : '部门名称',\r\n");
      out.write("\t\t\t\tname : 'deptname',\r\n");
      out.write("\t\t\t\tminWidth : 150,\r\n");
      out.write("\t\t\t\teditor: { type: 'text'}\r\n");
      out.write("\t\t\t}, {\r\n");
      out.write("\t\t\t\tdisplay : '部门负责人',\r\n");
      out.write("\t\t\t\tname : 'deptresponsible',\r\n");
      out.write("\t\t\t\tminWidth : 150\r\n");
      out.write("\t\t\t\t//editor: { type: 'text'}\r\n");
      out.write("\t\t\t},{\r\n");
      out.write("\t\t\t\t\tdisplay : '部门成员',\r\n");
      out.write("\t\t\t\t\tisSort : false,\r\n");
      out.write("\t\t\t\t\tminWidth : 120,\r\n");
      out.write("\t\t\t\t\trender : function() {\r\n");
      out.write("\t\t\t\t\t\tvar h = \"\";\r\n");
      out.write("\t\t\t\t\t\th += \"<a style='color:#000;' href='javascript:deptmember(\"+ \")'>管理</a> \";\r\n");
      out.write("\t\t\t\t\t\treturn h;\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t} ],\r\n");
      out.write("\t\t\t\t\tonSelectRow : function(rowdata, rowindex) {\r\n");
      out.write("\t\t\t\t\t\t$(\"#txtrowindex\").val(rowindex);\r\n");
      out.write("\t\t\t\t\t},\r\n");
      out.write("\t\t\t\t\tenabledEdit : true,\r\n");
      out.write("\t\t\t\t\tclickToEdit : false,\r\n");
      out.write("\t\t\t\t\tisScroll : false,\r\n");
      out.write("\t\t\t\t\trownumbers:true, \r\n");
      out.write("\t\t\t\t\tpageSize:20,\r\n");
      out.write("\t\t\t\t\turl:'");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/system/User_deptlist.action',\r\n");
      out.write("\t\t\t\t\twidth : '100%',\r\n");
      out.write("\t\t\t\t    toolbar: { items: [{ text: '添加',click: adddept,    icon: 'add' },\r\n");
      out.write("\t\t\t\t\t                   { text: '修改',click: beginEdit,  icon: 'edit' },\r\n");
      out.write("\t\t\t\t\t                   { text: '删除',click: deleterow,  icon: 'delete' },\r\n");
      out.write("\t\t\t\t\t                   { text: '保存',click: endEdit,    icon: 'save' }\r\n");
      out.write("\t\t\t\t\t                  ]}\r\n");
      out.write("\t\t\t\t});\r\n");
      out.write("\t}\r\n");
      out.write("function deptmember(){\r\n");
      out.write("\t var row = manager.getSelectedRow();\r\n");
      out.write("\t  var str = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/system/User_deptmember.action?dept.deptid=\"+row.deptid;\r\n");
      out.write("\t  top.f_addTab('deptmember','部门成员',str);\r\n");
      out.write("\t}\r\n");
      out.write("\tfunction beginEdit() {\r\n");
      out.write("            var row = manager.getSelectedRow();\r\n");
      out.write("            if (!row) { alert('请选择一项！'); return; }\r\n");
      out.write("            manager.beginEdit(row);\r\n");
      out.write("    }\r\n");
      out.write("\tfunction cancelEdit(rowid) {\r\n");
      out.write("\t\tmanager.cancelEdit(rowid);\r\n");
      out.write("\t}\r\n");
      out.write("\tfunction endEdit(rowid) {\r\n");
      out.write("\t var row = manager.getSelectedRow();\r\n");
      out.write("\t manager.endEdit(row);\r\n");
      out.write("\t if(row.deptname.length==0){\r\n");
      out.write("\t   alert(\"部门名称不能为空！\");\r\n");
      out.write("\t   return false;\r\n");
      out.write("\t }else{\r\n");
      out.write("\t   if(!isNaN(row.deptname)){\r\n");
      out.write("\t   alert(\"部门名称不能全是数字！\");\r\n");
      out.write("\t   return false;\r\n");
      out.write("\t  }else{\r\n");
      out.write("\t    $.post(\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/system/User_deptcheckagain.action?dept.deptname=\"\r\n");
      out.write("\t\t\t\t\t\t+encodeURI(encodeURI(row.deptname))+\"&dept.deptid=\"+row.deptid, null, function(data) {\r\n");
      out.write("\t\t\t\t\tif (data == \"fail\") {\r\n");
      out.write("\t\t\t\t\t\talert(\"该部门名称已存在\");\r\n");
      out.write("\t\t\t\t\t\twindow.location.reload();\r\n");
      out.write("\t\t\t\t\t\treturn false;\t\t\t\t\t    \r\n");
      out.write("\t\t\t\t\t} else {\r\n");
      out.write("\t\t\t\t\t\t$.post(\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/system/User_deptupdate.action?dept.deptid=\"+ row.deptid\r\n");
      out.write("\t\t\t\t            +\"&dept.deptname=\"+encodeURI(encodeURI(row.deptname))\r\n");
      out.write("\t\t\t\t            +\"&dept.deptresponsible=\"+encodeURI(encodeURI(row.deptresponsible))\r\n");
      out.write("\t\t\t\t            ,null,function(){\r\n");
      out.write("\t\t\t\t              //window.location.reload();\r\n");
      out.write("\t\t\t\t              g.loadData();\r\n");
      out.write("\t\t\t\t        });\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t});\r\n");
      out.write("\t }\r\n");
      out.write("\t }\r\n");
      out.write("\t \r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("\tfunction deleterow() {\r\n");
      out.write("\t  var row = manager.getSelectedRow();\r\n");
      out.write("\t  if (!row) {alert('请选择一项！');return;}\r\n");
      out.write("\t  $.ligerDialog.confirm('是否删除该部门？该部门如果存在成员，将不被删除。', function (yes){\r\n");
      out.write("       if(yes){\t\r\n");
      out.write("          $.ligerDialog.prompt('请输入确认密码', function (yes, value){\r\n");
      out.write("            if (yes){ //验证密码\r\n");
      out.write("              var userid = ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${sessionScope.user.id}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write(";\r\n");
      out.write("              $.post(\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/system/User_pwdcheck.action?user.id=\"+ userid\r\n");
      out.write("\t\t          +\"&user.password=\"+value , null, function(data) {\r\n");
      out.write("\t\t\t\t\tif (data == \"fail\") {\r\n");
      out.write("\t\t\t\t\t\talert(\"输入的密码不正确!\");\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t} else {\r\n");
      out.write("                        var rows = g.getCheckedRows();\r\n");
      out.write("                        var str = \"\";\r\n");
      out.write("                        $(rows).each(function(){ str += this.deptid +\",\"; });\r\n");
      out.write("                        $.post(\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/system/User_deptdelete.action?ids=\"+ str,null,function(){\r\n");
      out.write("                           g.loadData();\r\n");
      out.write("                        });\r\n");
      out.write("\t\t\t            //manager.deleteSelectedRow();\t\r\n");
      out.write("\t\t                //window.location.reload();\r\n");
      out.write("\t\t            }\r\n");
      out.write("\t           });\r\n");
      out.write("\t        }\r\n");
      out.write("\t      });\r\n");
      out.write("\t    }\r\n");
      out.write("\t  });\t\r\n");
      out.write("} \r\n");
      out.write("\tvar m;\r\n");
      out.write("\tfunction adddept(){\r\n");
      out.write("\tvar str = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/system/User_deptbegainadd.action\";\r\n");
      out.write("\t\tm=$.ligerDialog.open({\r\n");
      out.write("\t\t\turl : str,\r\n");
      out.write("\t\t\theight : 250,\r\n");
      out.write("\t\t\twidth : 350,\r\n");
      out.write("\t\t\tisDrag:true,\r\n");
      out.write("\t\t\tshowMax:true,\r\n");
      out.write("\t\t\tshowToggle:true,\r\n");
      out.write("\t\t\tslide: false,\t\t\t\r\n");
      out.write("\t\t\tmodal:false,\r\n");
      out.write("\t\t\tleft:200,\r\n");
      out.write("\t\t\ttitle:'添加部门',\r\n");
      out.write("\t\t\tallowClose:true,\r\n");
      out.write("\t\t    isResize : false\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t}\r\n");
      out.write("</script>\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write("#head{\r\n");
      out.write(" width: 99%;\r\n");
      out.write(" height:80px;\r\n");
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
      out.write(" height:90px;\r\n");
      out.write(" align:center;\r\n");
      out.write(" width: 100%;\r\n");
      out.write("}\r\n");
      out.write(".search.l-table-edit td{\r\n");
      out.write("  border-bottom: 1px solid #c6c6c6 ;\r\n");
      out.write("}\r\n");
      out.write(".link{\r\n");
      out.write("width:160px;height:25px;background: #fefefe;border: 1px solid #bbb;font-size: 14px;color: #333;border-radius: 3px;\r\n");
      out.write("}\r\n");
      out.write(".l-button{\r\n");
      out.write(" width:70px;float:left; margin:15px 160px 5px ;\r\n");
      out.write(" border-radiux:5px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("</style>\r\n");
      out.write("\t</head>\r\n");
      out.write("\t<body style=\"padding: 2px\">\t\t\r\n");
      out.write("\t    <div class=\"l-clear\"></div>\r\n");
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
