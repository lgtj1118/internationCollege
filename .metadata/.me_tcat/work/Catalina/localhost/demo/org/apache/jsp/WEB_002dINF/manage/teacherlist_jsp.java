package org.apache.jsp.WEB_002dINF.manage;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;

public final class teacherlist_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\t\t\t{columns : [\r\n");
      out.write("\t\t\t{   display : '序号',  name : 'id',     width : 40,  type : 'int',hide:true\r\n");
      out.write("\t\t\t},{display : '编号', name : 'identificationnum', minWidth : 100,  editor:{type:'text'}\t\r\n");
      out.write("\t\t\t},{display : '姓名', name : 'teachername', minWidth : 100,  editor:{type:'text'}\t\r\n");
      out.write("\t\t\t} ,{display : '性别', name : 'sex',minWidth : 80,editor: { type: 'text'}\r\n");
      out.write("\t\t\t}, {display : '电话号码', name : 'telephone',minWidth : 100, editor: { type: 'text'}\r\n");
      out.write("\t\t\t}, {display : '邮箱', name : 'email',minWidth : 160, editor: { type: 'text'}\r\n");
      out.write("\t\t\t}, {display : '职称', name : 'position',  minWidth : 120, editor: { type: 'text'}\r\n");
      out.write("\t\t\t}, {display : '所属部门', name : 'deptname',  minWidth : 120, editor: { type: 'text'}\r\n");
      out.write("\t\t\t},{display:'状态', name:'deleted', minWidth:40, render: function (item)\r\n");
      out.write("                  {\r\n");
      out.write("                      if (parseInt(item.deleted) == 1){ var h=\"<span style='color:red;'>账号不可用</span>\" ;return h;}\r\n");
      out.write("                      else if (parseInt(item.deleted) == 0) { var h=\"<span style='color:green;'>正常</span>\" ;return h;}                                \r\n");
      out.write("                 }\r\n");
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
      out.write("/system/Manage_teacherlist.action',\r\n");
      out.write("\t\t\t\t\twidth : '100%',\r\n");
      out.write("\t\t\t\t\ttoolbar: { items: [{ text: '添加',click: addteacher,  icon: 'add' },\r\n");
      out.write("\t\t\t\t\t                   { text: '修改',click: beginEdit,  icon: 'edit' },\r\n");
      out.write("\t\t\t\t\t                   { text: '删除',click: deleterow,  icon: 'delete' },\r\n");
      out.write("\t\t\t\t\t                   { text: '重置',click: recover,  icon: 'save' },\r\n");
      out.write("\t\t\t\t\t                   { text: '批量添加', click: addbatchteacher, icon:'add'}\r\n");
      out.write("\t\t\t\t\t                   ]}\r\n");
      out.write("\t\t\t\t});\r\n");
      out.write("\t}\r\n");
      out.write("\tvar m;\r\n");
      out.write("\tfunction beginEdit() {\r\n");
      out.write("       var row = manager.getSelectedRow();\r\n");
      out.write("       if (!row) { alert('请选择一名教师！'); return; }\r\n");
      out.write("       var str = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/system/Manage_teacheredit.action?teacher.identificationnum=\"+ row.identificationnum;\r\n");
      out.write("\t   m=$.ligerDialog.open({\r\n");
      out.write("\t\t\turl : str,\r\n");
      out.write("\t\t\theight : 450,\r\n");
      out.write("\t\t\twidth : 400,\r\n");
      out.write("\t\t\tisDrag:true,\r\n");
      out.write("\t\t\tshowMax:true,\r\n");
      out.write("\t\t\tshowToggle:true,\r\n");
      out.write("\t\t\tslide: false,\t\t\t\r\n");
      out.write("\t\t\tmodal:false,\r\n");
      out.write("\t\t\tleft:200,\r\n");
      out.write("\t\t\ttitle:'更新教师',\r\n");
      out.write("\t\t\tallowClose:true,\r\n");
      out.write("\t\t    isResize : false\r\n");
      out.write("\t\t});\t\t\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\tfunction deleterow() {\r\n");
      out.write("\tvar row = manager.getSelectedRow();\r\n");
      out.write("\t\tif (!row) {\r\n");
      out.write("\t\t\talert('请选择一名教师！');\r\n");
      out.write("\t\t\treturn;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tif (confirm('如果是部门负责人，将不被删除，否则第一次将撤销其权限，第二次如果没有与学期课程关联，将彻底删除?')){\r\n");
      out.write("             $.ligerDialog.prompt('请输入确认密码', function (yes, value){\r\n");
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
      out.write("                             var rows = g.getCheckedRows();\r\n");
      out.write("                             var str = \"\";\r\n");
      out.write("                             $(rows).each(function(){\r\n");
      out.write("                                str += this.id + \",\";\r\n");
      out.write("                             });\r\n");
      out.write("                             $.post(\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/system/Manage_teacherdelete.action?ids=\"+ str,null,function(){\r\n");
      out.write("                                //manager.deleteSelectedRow();\t\r\n");
      out.write("\t\t\t\t                //window.location.reload();\r\n");
      out.write("\t\t\t\t                g.loadData();\r\n");
      out.write("                             });\r\n");
      out.write("\t\t\t                   \r\n");
      out.write("                           }\r\n");
      out.write("                        });\r\n");
      out.write("                   }\r\n");
      out.write("             });\r\n");
      out.write("           }\r\n");
      out.write("\t}\t \r\n");
      out.write("\tvar m;\r\n");
      out.write("\tfunction addteacher(){\r\n");
      out.write("\tvar str = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/system/Manage_teacherbeginadd.action\";\r\n");
      out.write("\t\tm=$.ligerDialog.open({\r\n");
      out.write("\t\t\turl : str,\r\n");
      out.write("\t\t\theight : 450,\r\n");
      out.write("\t\t\twidth : 400,\r\n");
      out.write("\t\t\tisDrag:true,\r\n");
      out.write("\t\t\tshowMax:true,\r\n");
      out.write("\t\t\tshowToggle:true,\r\n");
      out.write("\t\t\tslide: false,\t\t\t\r\n");
      out.write("\t\t\tmodal:false,\r\n");
      out.write("\t\t\tleft:200,\r\n");
      out.write("\t\t\ttitle:'添加教师',\r\n");
      out.write("\t\t\tallowClose:true,\r\n");
      out.write("\t\t    isResize : false\r\n");
      out.write("\t\t});\t\t\r\n");
      out.write("\t\t//window.open(str, 'newwindow', 'height=450, width=430, top=200, left=400, toolbar=no, menubar=no, scrollbars=yes, resizable=no,location=n o, status=no');\r\n");
      out.write("\t}\r\n");
      out.write("\tfunction addbatchteacher(){\r\n");
      out.write("\tvar str = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/system/Manage_teacherbatchadd.action\";\r\n");
      out.write("\t\tm=$.ligerDialog.open({\r\n");
      out.write("\t\t\turl : str,\r\n");
      out.write("\t\t\theight : 500,\r\n");
      out.write("\t\t\twidth : 800,\r\n");
      out.write("\t\t\tisResize : true\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\t\r\n");
      out.write("\t}\r\n");
      out.write("\tfunction recover(){\r\n");
      out.write("\t\tvar row = manager.getSelectedRow();\r\n");
      out.write("\t\tif (!row) {\r\n");
      out.write("\t\t\talert('请选择一名教师！');\r\n");
      out.write("\t\t\treturn;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tif (confirm('重置账号之后会恢复教师权限，并把密码设为123456。'))\r\n");
      out.write("        {\r\n");
      out.write("              var rows = g.getCheckedRows();\r\n");
      out.write("              var str = \"\";\r\n");
      out.write("              $(rows).each(function(){\r\n");
      out.write("              str += this.id;\r\n");
      out.write("              });\r\n");
      out.write("              $.post(\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/system/Manage_teacherRecover.action?ids=\"+ str,null,function(){\r\n");
      out.write("                //manager.deleteSelectedRow();\t\r\n");
      out.write("\t\t\t\t//window.location.reload();\r\n");
      out.write("\t\t\t\tg.loadData();\r\n");
      out.write("              });\r\n");
      out.write("\t\t\t  \r\n");
      out.write("         }\r\n");
      out.write("\t}\r\n");
      out.write("\tfunction fuzzy () {\r\n");
      out.write("\t\tvar t = $(\"#searchText\").val();\r\n");
      out.write("\t\t$(\"#maingrid\").ligerGrid({\r\n");
      out.write("\t\t  url:\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/system/Manage_teacherFuzzy.action?fuzzyText=\" + encodeURI(encodeURI(t)) \r\n");
      out.write("\t\t});\r\n");
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
      out.write("\t<body style=\"padding: 2px\">\r\n");
      out.write("\t <!-- <a class=\"l-button\" style=\"width:70px;float:left; margin:3px;\" onclick=\"addteacher()\">添&nbsp;&nbsp;加</a>\r\n");
      out.write("\t <a class=\"l-button\" style=\"width:70px;float:left; margin:3px;\" onclick=\"addbatchteacher()\">批量添加</a>       \r\n");
      out.write("\t <a class=\"l-button\" style=\"width:70px;float:left; margin:3px;\" onclick=\"deleterow()\">删&nbsp;&nbsp;除</a>\r\n");
      out.write("\t <a class=\"l-button\" style=\"width:70px;float:left; margin:3px;\" onclick=\"beginEdit()\">修&nbsp;&nbsp;改</a>\r\n");
      out.write("\t <a class=\"l-button\" style=\"width:70px;float:left; margin:3px;\" onclick=\"recover()\">重&nbsp;&nbsp;置</a> -->\r\n");
      out.write("\t<!--  <a class=\"l-button\" style=\"width:80px;float:left; margin:3px;\" onclick=\"cancelEdit()\">取消修改</a>\r\n");
      out.write("\t <a class=\"l-button\" style=\"width:70px;float:left; margin:3px;\" onclick=\"endEdit()\">保存</a>\r\n");
      out.write("\t -->\r\n");
      out.write("\t    <div id=\"head\">\r\n");
      out.write("\t      <div class=\"search\" >\r\n");
      out.write("\t         <table cellpadding=\"0\" cellspacing=\"0\" class=\"l-table-edit\" width=\"100%\" >\t\t\t  \r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td align=\"right\" class=\"l-table-edit-td\" width=\"100px\" >&nbsp;&nbsp;关键字:&nbsp;</td>\r\n");
      out.write("\t\t\t\t<td align=\"left\" class=\"l-table-edit-td\">\r\n");
      out.write("\t\t\t\t  <input id=\"searchText\" class=\"link\" onkeyup=\"fuzzy()\"  name=\"searchText\" /> <!-- \" -->\r\n");
      out.write("\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t<!-- <td><a class=\"l-button\" style=\"width:70px;float:left; margin:3px;\" onclick=\"fuzzy()\">查询</a></td>\t -->\t\t\t\t   \t\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t</table>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t    </div>\t\t\t\r\n");
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
