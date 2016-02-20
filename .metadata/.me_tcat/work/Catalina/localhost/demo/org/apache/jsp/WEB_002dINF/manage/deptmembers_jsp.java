package org.apache.jsp.WEB_002dINF.manage;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;

public final class deptmembers_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\r\n");
      out.write("\r\n");
      out.write("<html xmlns=\"http://www.w3.org/1999/xhtml\">\r\n");
      out.write("\t<head>\r\n");
      out.write("\t<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\r\n");
      out.write("\t\t<title></title>\r\n");
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
      out.write("\t<script type=\"text/javascript\">\r\n");
      out.write("\tvar TeacherData = {Rows: [\r\n");
      out.write("\t\t");
String  s= (String) request.getAttribute("teacherlist");
      out.write("\r\n");
      out.write("\t\t");
      out.print(s);
      out.write("\r\n");
      out.write("\t\t ]};\t\t\r\n");
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
      out.write("\t\t\t\tdisplay : '编号',\r\n");
      out.write("\t\t\t\tname : 'identificationnum',\r\n");
      out.write("\t\t\t\tminWidth : 150,\r\n");
      out.write("\t\t\t\teditor: { type: 'text'}\r\n");
      out.write("\t\t\t}, {\r\n");
      out.write("\t\t\t\tdisplay : '姓名',\r\n");
      out.write("\t\t\t\tname : 'teachername',\r\n");
      out.write("\t\t\t\tminWidth : 150,\r\n");
      out.write("\t\t\t\teditor: { type: 'text'}\r\n");
      out.write("\t\t\t}, {\r\n");
      out.write("\t\t\t\tdisplay : '性别',\r\n");
      out.write("\t\t\t\tname : 'sex',\r\n");
      out.write("\t\t\t\tminWidth : 150,\r\n");
      out.write("\t\t\t\teditor: { type: 'text'}\r\n");
      out.write("\t\t\t}, {\r\n");
      out.write("\t\t\t\tdisplay : '电话号码',\r\n");
      out.write("\t\t\t\tname : 'telephone',\r\n");
      out.write("\t\t\t\tminWidth : 150,\r\n");
      out.write("\t\t\t\teditor: { type: 'text'}\r\n");
      out.write("\t\t\t} , {\r\n");
      out.write("\t\t\t\tdisplay : '邮箱',\r\n");
      out.write("\t\t\t\tname : 'email',\r\n");
      out.write("\t\t\t\tminWidth : 150,\r\n");
      out.write("\t\t\t\teditor: { type: 'text'}\r\n");
      out.write("\t\t\t}, {\r\n");
      out.write("\t\t\t\tdisplay : '职称',\r\n");
      out.write("\t\t\t\tname : 'position',\r\n");
      out.write("\t\t\t\tminWidth : 150,\r\n");
      out.write("\t\t\t\teditor: { type: 'text'}\r\n");
      out.write("\t\t\t},{display:'状态', name:'deleted', minWidth:40, render: function (item)\r\n");
      out.write("                  {\r\n");
      out.write("                      if (parseInt(item.deleted) == 1){ var h=\"<span style='color:red;'>账号不可用</span>\" ;return h;}\r\n");
      out.write("                      else if (parseInt(item.deleted) == 0) { var h=\"<span style='color:green;'>正常</span>\" ;return h;}                                \r\n");
      out.write("                 }\r\n");
      out.write("\t\t\t} ],\r\n");
      out.write("\t\t\t\t\tonSelectRow : function(rowdata, rowindex) {\r\n");
      out.write("\t\t\t\t\t\t$(\"#txtrowindex\").val(rowindex);\r\n");
      out.write("\t\t\t\t\t},\r\n");
      out.write("\t\t\t\t\tenabledEdit : true,\r\n");
      out.write("\t\t\t\t\tclickToEdit : false,\r\n");
      out.write("\t\t\t\t\tisScroll : false,\r\n");
      out.write("\t\t\t         rownumbers:true,\r\n");
      out.write("\t\t\t         pageSize:30,\r\n");
      out.write("\t\t\t\t\t//data : TeacherData,\r\n");
      out.write("\t\t\t\t\turl:'");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/system/User_deptmemberlist.action',\r\n");
      out.write("\t\t\t\t\twidth : '100%'\r\n");
      out.write("\t\t\t\t});\r\n");
      out.write("\t}\r\n");
      out.write("function beginEdit() {\r\n");
      out.write("       var row = manager.getSelectedRow();\r\n");
      out.write("       if (!row) { alert('请选择一名教师！'); return; }\r\n");
      out.write("       var str = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/system/Manage_teacheredit.action?teacher.id=\"+ row.id\r\n");
      out.write("\t\t\t\t+\"&teacher.sex=\"+row.sex\r\n");
      out.write("\t\t\t\t+\"&teacher.teachername=\"+row.teachername\r\n");
      out.write("\t\t\t\t+\"&teacher.email=\"+row.email\r\n");
      out.write("\t\t\t\t+\"&teacher.identificationnum=\"+row.identificationnum\r\n");
      out.write("\t\t\t\t+\"&teacher.position=\"+row.position\r\n");
      out.write("\t\t\t\t+\"&teacher.telephone=\"+row.telephone;\r\n");
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
      out.write("\tfunction deleterow() {\r\n");
      out.write("\tvar row = manager.getSelectedRow();\r\n");
      out.write("\t\tif (!row) {\r\n");
      out.write("\t\t\talert('请选择一名教师！');\r\n");
      out.write("\t\t\treturn;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tif (confirm('如果是部门负责人，将不被删除，否则第一次将撤销其权限，第二次如果没有与学期课程关联，将彻底删除?'))\r\n");
      out.write("            {\r\n");
      out.write("              var rows = g.getCheckedRows();\r\n");
      out.write("              var str = \"\";\r\n");
      out.write("              $(rows).each(function(){\r\n");
      out.write("              str += this.id + \",\";\r\n");
      out.write("              });\r\n");
      out.write("              $.post(\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/system/Manage_teacherdelete.action?ids=\"+ str);\r\n");
      out.write("\t\t\t  //manager.deleteSelectedRow();\t\r\n");
      out.write("\t\t\t\twindow.location.reload();\r\n");
      out.write("            }\r\n");
      out.write("\t}\t \r\n");
      out.write("\tvar m;\r\n");
      out.write("\tfunction addteacher(){\r\n");
      out.write("\tvar str = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/system/Manage_teacherbeginadd.action?depid=\"+$(\"#deptid\").val();\r\n");
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
      out.write("\tfunction f_set(){\r\n");
      out.write("\t  var row = g.getSelectedRow();\r\n");
      out.write("\t  var ident = row.identificationnum;\r\n");
      out.write("\t  if(!row){alert(\"请先选择一位教师！\");}\r\n");
      out.write("\t  if(row.deleted==0){\r\n");
      out.write("\t     var url = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/system/User_searchResponsible.action?teacherid=\" + row.identificationnum+\"&dept.deptid=\"+$(\"#deptid\").val();\t\r\n");
      out.write("\t\t\t$.ajax({  \r\n");
      out.write("\t\t        type : \"POST\",  \r\n");
      out.write("\t\t        url : url,\r\n");
      out.write("\t\t        dataType : \"JSON\", \r\n");
      out.write("\t\t        error: function (){\r\n");
      out.write("\t\t        \t;\r\n");
      out.write("\t\t        },\r\n");
      out.write("\t\t        success : function(data) {\r\n");
      out.write("\t\t        \tif (data.length > 0){\r\n");
      out.write("\t\t        \t\tvar msg = data;\r\n");
      out.write("\t\t          \t\ttips(msg, ident);\r\n");
      out.write("\t\t          \t\treturn;\t\r\n");
      out.write("\t\t        \t} else {\r\n");
      out.write("\t\t        \t\tprint(ident);\r\n");
      out.write("\t\t        \t};\r\n");
      out.write("\t\t       }  \r\n");
      out.write("\t\t    }); \r\n");
      out.write("\t  }else if(row.deleted==1) {\r\n");
      out.write("\t     alert(\"该教师状态不可用，不能设置为部门负责人！\");\r\n");
      out.write("\t  }\r\n");
      out.write("\t  \r\n");
      out.write("\t }\r\n");
      out.write("\t \r\n");
      out.write("\t function print(ident){\r\n");
      out.write("\t  var url = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/system/User_setResponsible.action?teacherid=\"+ident+\"&dept.deptid=\"+$(\"#deptid\").val();\r\n");
      out.write("\t  $.post(url, null, function() {\r\n");
      out.write("\t        alert(\"设置成功！\");\r\n");
      out.write("\t\t\tparent.m.hide();\r\n");
      out.write("\t\t\tparent.window.location.reload();\r\n");
      out.write("\t\t});\r\n");
      out.write("\t}\r\n");
      out.write("\t \r\n");
      out.write("\t function tips (msg, ident) { \t\r\n");
      out.write("\t \t$.ligerDialog.confirm(msg, function (yes){\r\n");
      out.write(" \t\t\tif (yes == true){\r\n");
      out.write(" \t\t\t\tprint(ident);\r\n");
      out.write(" \t\t\t}   \r\n");
      out.write("       }); \r\n");
      out.write("\t\r\n");
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
      out.write("              window.location.reload();\r\n");
      out.write("              });\r\n");
      out.write("\t\t\t  //manager.deleteSelectedRow();\t\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("         }\r\n");
      out.write("\t}\r\n");
      out.write("</script>\r\n");
      out.write("\t</head>\r\n");
      out.write("\t<body style=\"padding: 2px\">\r\n");
      out.write("<!-- \t <a class=\"l-button\" style=\"width:70px;float:left; margin:3px;\" onclick=\"addteacher()\">添&nbsp;&nbsp;加</a>\r\n");
      out.write("\t  <a class=\"l-button\" style=\"width:70px;float:left; margin:3px;\" onclick=\"addbatchteacher()\">批量添加</a>  \r\n");
      out.write("\t <a class=\"l-button\" style=\"width:70px;float:left; margin:3px;\" onclick=\"beginEdit()\">修&nbsp;&nbsp;改</a>\r\n");
      out.write("\t <a class=\"l-button\" style=\"width:70px;float:left; margin:3px;\" onclick=\"deleterow()\">删&nbsp;&nbsp;除</a>\t \r\n");
      out.write("\t <a class=\"l-button\" style=\"width:70px;float:left; margin:3px;\" onclick=\"recover()\">重&nbsp;&nbsp;置</a>\t  -->\r\n");
      out.write("\t <a class=\"l-button\" style=\"width:100px;float:left; margin:3px;\" onclick=\"f_set()\">设置为部门负责人</a>\t \r\n");
      out.write("\t <!-- <a class=\"l-button\" style=\"width:70px;float:left; margin:3px;\" onclick=\"endEdit()\">保存</a> -->\r\n");
      out.write("\t <input id=\"deptid\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${deptid }", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\" type=\"hidden\" />\t\r\n");
      out.write("\t \t<div class=\"l-clear\"></div>\r\n");
      out.write("\t\t<div id=\"maingrid\" ></div>\r\n");
      out.write("\t</body>\r\n");
      out.write("</html>");
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
