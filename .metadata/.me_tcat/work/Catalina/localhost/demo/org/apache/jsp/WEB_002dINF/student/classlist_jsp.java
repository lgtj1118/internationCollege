package org.apache.jsp.WEB_002dINF.student;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;

public final class classlist_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\t<base href=\"");
      out.print(basePath);
      out.write("\">\r\n");
      out.write("\t<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\r\n");
      out.write("\t\t<title>班级列表</title>\r\n");
      out.write("\t<link href=\"");
      out.print(basePath);
      out.write("js/ligerUI/skins/Aqua/css/ligerui-all.css\" rel=\"stylesheet\"type=\"text/css\" />\t\r\n");
      out.write("\t<link href=\"");
      out.print(basePath );
      out.write("js/ligerUI/skins/Gray/css/all.css\" rel=\"stylesheet\" type=\"text/css\"/>\t\r\n");
      out.write("    <link href=\"js/ligerUI/skins/ligerui-icons.css\" rel=\"stylesheet\" type=\"text/css\">\r\n");
      out.write("    <script type=\"text/javascript\" src=\"js/jquery-validation/jquery.validate.min.js\" charset=\"utf-8\"></script>\r\n");
      out.write("    <script type=\"text/javascript\" src=\"js/json2.js\" charset=\"utf-8\"></script>\r\n");
      out.write("    <!-- <script type=\"text/javascript\" src=\"js/jquery-validation/jquery.metadata.js\" charset=\"utf-8\"></script>\r\n");
      out.write("    <script type=\"text/javascript\" src=\"js/jquery-validation/messages_cn.js\" charset=\"utf-8\"></script> -->\r\n");
      out.write("    <script src=\"js/jquery/jquery-1.3.2.min.js\"type=\"text/javascript\"></script>\r\n");
      out.write("\t<script src=\"js/ligerUI/core/base.js\" type=\"text/javascript\"></script>\r\n");
      out.write("\t<script src=\"js/ligerUI/ligerui.all.js\" type=\"text/javascript\"></script>\r\n");
      out.write("\t<script src=\"js/ligerUI/plugins/ligerToolBar.js\" type=\"text/javascript\"></script>\r\n");
      out.write("\t<script type=\"text/javascript\">\r\n");
      out.write("\tvar ClassData = {Rows: [\r\n");
      out.write("\t\t");
String  s= (String) request.getAttribute("classlist");
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
      out.write("\t\t\t\tdisplay : 'ID',\r\n");
      out.write("\t\t\t\tname : 'id',\r\n");
      out.write("\t\t\t\twidth : 60,\r\n");
      out.write("\t\t\t\thide:true,\r\n");
      out.write("\t\t\t\ttype : 'int'\r\n");
      out.write("\t\t\t}, {\r\n");
      out.write("\t\t\t\tdisplay : '班级名称',\r\n");
      out.write("\t\t\t\tname : 'classname',\r\n");
      out.write("\t\t\t\tminWidth : 150,\r\n");
      out.write("\t\t\t\teditor: { type: 'text'}\r\n");
      out.write("\t\t\t}, {\r\n");
      out.write("\t\t\t\tdisplay : '班级英文名称',\r\n");
      out.write("\t\t\t\tname : 'classname_en',\r\n");
      out.write("\t\t\t\tminWidth : 150,\r\n");
      out.write("\t\t\t\teditor: { type: 'text'}\r\n");
      out.write("\t\t\t},{\r\n");
      out.write("\t\t\t\tdisplay : '班级专业',\r\n");
      out.write("\t\t\t\tname : 'major',\r\n");
      out.write("\t\t\t\tminWidth : 150,\r\n");
      out.write("\t\t\t\teditor: { type: 'text'}\r\n");
      out.write("\t\t\t} , {\r\n");
      out.write("\t\t\t\tdisplay : '班主任',\r\n");
      out.write("\t\t\t\tname : 'ClassTeacher',\r\n");
      out.write("\t\t\t\tminWidth : 150,\r\n");
      out.write("\t\t\t\teditor: { type: 'text'}\r\n");
      out.write("\t\t\t}, {\r\n");
      out.write("\t\t\t\tdisplay : '助理班主任',\r\n");
      out.write("\t\t\t\tname : 'Assistantteacher',\r\n");
      out.write("\t\t\t\tminWidth : 150,\r\n");
      out.write("\t\t\t\teditor: { type: 'text'}\r\n");
      out.write("\t\t\t},  {\r\n");
      out.write("\t\t\t\tdisplay : '班长',\r\n");
      out.write("\t\t\t\tname : 'Classminitor',\r\n");
      out.write("\t\t\t\tminWidth : 150,\r\n");
      out.write("\t\t\t\teditor: { type: 'text'}\r\n");
      out.write("\t\t\t},{\r\n");
      out.write("\t\t\t\t\tdisplay : '班内学生',\r\n");
      out.write("\t\t\t\t\tisSort : false,\r\n");
      out.write("\t\t\t\t\twidth : 120,\r\n");
      out.write("\t\t\t\t\trender : function() {\r\n");
      out.write("\t\t\t\t\t\tvar h = \"\";\r\n");
      out.write("\t\t\t\t\t\th += \"<a style='color:#000;' href='javascript:classstu(\"+ \")'>管理</a> \";\r\n");
      out.write("\t\t\t\t\t\treturn h;\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t},  {\r\n");
      out.write("\t\t\t\tdisplay : '状态',\r\n");
      out.write("\t\t\t\tname : 'type',\r\n");
      out.write("\t\t\t\tminWidth : 150,\r\n");
      out.write("\t\t\t\trender: function (item)\r\n");
      out.write("                    {\r\n");
      out.write("                        if (parseInt(item.type) == 0){ var h=\"<span style='color:green;'>正常</span>\" ;return h;}\r\n");
      out.write("                        else if (parseInt(item.type) == 1) { var h=\"<span style='color:red;'>已删除</span>\" ;return h;}\r\n");
      out.write("                        else if (parseInt(item.type) == 2) { var h=\"<span style='color:orange;'>已毕业</span>\" ;return h;}\r\n");
      out.write("                        \r\n");
      out.write("                    }\t\r\n");
      out.write("\t\t\t} ],\r\n");
      out.write("\t\t\t\t\tonSelectRow : function(rowdata, rowindex) {\r\n");
      out.write("\t\t\t\t\t\t$(\"#txtrowindex\").val(rowindex);\r\n");
      out.write("\t\t\t\t\t},\r\n");
      out.write("\t\t\t\t\tenabledEdit : true,\r\n");
      out.write("\t\t\t\t\tclickToEdit : false,\r\n");
      out.write("\t\t\t\t\tisScroll : false,\r\n");
      out.write("\t\t\t         rownumbers:true,\r\n");
      out.write("\t\t\t         pageSize:30,\r\n");
      out.write("\t\t\t\t\t//data : ClassData,\r\n");
      out.write("\t\t\t\t\turl: '");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/system/Class_classList.action',\r\n");
      out.write("\t\t\t\t\twidth : '100%',\r\n");
      out.write("\t\t\t\t\ttoolbar: { items: [{ text: '添加',click: addclass,  icon: 'add' },\r\n");
      out.write("\t\t\t\t\t                   { text: '修改',click: beginEdit,  icon: 'edit' },\r\n");
      out.write("\t\t\t\t\t                   { text: '删除',click: deleteclass,  icon: 'delete' },\r\n");
      out.write("\t\t\t\t\t                   { text: '重置',click: recoveryclass,  icon: 'save' },\r\n");
      out.write("\t\t\t\t\t                   { text: '批量添加', click: addbatchclass, icon:'add'}\r\n");
      out.write("\t\t\t\t\t                   ]}\r\n");
      out.write("\t\t\t\t});\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\tvar m;\r\n");
      out.write("\tfunction setAssis (classid){\r\n");
      out.write("\t\tvar url = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/system/Class_jmpAssisList.action?ids=\" + classid;\r\n");
      out.write("\t\t m=$.ligerDialog.open({\r\n");
      out.write("\t\t\turl : url,\r\n");
      out.write("\t\t\theight : 400,\r\n");
      out.write("\t\t\twidth : 1000,\r\n");
      out.write("\t\t\tisDrag:true,\r\n");
      out.write("\t\t\tshowMax:true,\r\n");
      out.write("\t\t\tshowToggle:true,\r\n");
      out.write("\t\t\tslide: false,\t\t\t\r\n");
      out.write("\t\t\tmodal:false,\r\n");
      out.write("\t\t\tleft:50,\r\n");
      out.write("\t\t\ttitle:'设置助理班主任',\r\n");
      out.write("\t\t\tallowClose:true,\r\n");
      out.write("\t\t    isResize : false\r\n");
      out.write("\t\t});\r\n");
      out.write("\t}\r\n");
      out.write("\tvar m;\r\n");
      out.write("\tfunction setHeadTeacher (classid) {\r\n");
      out.write("\t\tvar url = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/system/Class_jmpHeadTeacher.action?ids=\" + classid;\r\n");
      out.write("\t\t m=$.ligerDialog.open({\r\n");
      out.write("\t\t\turl : url,\r\n");
      out.write("\t\t\theight : 500,\r\n");
      out.write("\t\t\twidth : 800,\r\n");
      out.write("\t\t\tisDrag:true,\r\n");
      out.write("\t\t\tshowMax:true,\r\n");
      out.write("\t\t\tshowToggle:true,\r\n");
      out.write("\t\t\tslide: false,\t\t\t\r\n");
      out.write("\t\t\tmodal:false,\r\n");
      out.write("\t\t\tleft:200,\r\n");
      out.write("\t\t\ttitle:'设置班主任',\r\n");
      out.write("\t\t\tallowClose:true,\r\n");
      out.write("\t\t    isResize : false\r\n");
      out.write("\t\t});\r\n");
      out.write("\t}\r\n");
      out.write("    function classstu(){\r\n");
      out.write("     var row = manager.getSelectedRow();\r\n");
      out.write("\t \tif (!row) {\r\n");
      out.write("\t\t\talert('请选择班级！');\r\n");
      out.write("\t\t\treturn;\r\n");
      out.write("\t\t}\r\n");
      out.write("    var str = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/system/Class_classstulist.action?cls.id=\"+row.id;\r\n");
      out.write("    var str1 = row.Classname;\r\n");
      out.write("\t\tm=$.ligerDialog.open({\r\n");
      out.write("\t\t\turl : str,\r\n");
      out.write("\t\t\theight : 650,\r\n");
      out.write("\t\t\twidth : 1000,\r\n");
      out.write("\t\t\ttitle:str1,\r\n");
      out.write("\t\t\tisDrag:true,\r\n");
      out.write("\t\t\tshowMax:true,\r\n");
      out.write("\t\t\tshowToggle:true,\r\n");
      out.write("\t\t\tslide: false,\r\n");
      out.write("\t\t\ttitle:'班级学生',\t\t\t\r\n");
      out.write("\t\t\tmodal:false,\r\n");
      out.write("\t\t\tisResize : true\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\t\r\n");
      out.write("}\r\n");
      out.write("    var m;\r\n");
      out.write("\tfunction beginEdit() {\r\n");
      out.write("       var row = manager.getSelectedRow();\r\n");
      out.write("       if (!row) { alert('请选择一个班级！'); return; }\r\n");
      out.write("       var str =\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/system/Class_classedit.action?cls.id=\"+ row.id;\r\n");
      out.write("\t   m=$.ligerDialog.open({\r\n");
      out.write("\t\t\turl : str,\r\n");
      out.write("\t\t\theight : 400,\r\n");
      out.write("\t\t\twidth : 400,\r\n");
      out.write("\t\t\ttitle:'更新班级',\r\n");
      out.write("\t\t\tisDrag:true,\r\n");
      out.write("\t\t\tisResize : true\r\n");
      out.write("\t\t});  \r\n");
      out.write("\t}\r\n");
      out.write("\tvar m;\r\n");
      out.write("    function addclass(){\r\n");
      out.write("\tvar str = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/system/Class_classbeginadd.action\";\r\n");
      out.write("\t\tm=$.ligerDialog.open({\r\n");
      out.write("\t\t\turl : str,\r\n");
      out.write("\t\t\theight : 400,\r\n");
      out.write("\t\t\twidth : 400,\r\n");
      out.write("\t\t\ttitle:'添加班级',\r\n");
      out.write("\t\t\tisResize : true\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\t\r\n");
      out.write("\t}\r\n");
      out.write("\tfunction addbatchclass(){\r\n");
      out.write("\tvar str = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/system/Class_classbatchadd.action\";\r\n");
      out.write("\t\tm=$.ligerDialog.open({\t\t   \r\n");
      out.write("\t\t\turl : str,\r\n");
      out.write("\t\t\theight : 400,\r\n");
      out.write("\t\t\twidth : 800,\r\n");
      out.write("\t\t\tisResize : true\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\t\r\n");
      out.write("\t}\r\n");
      out.write("\tfunction deleteclass() {\r\n");
      out.write("\tvar row = manager.getSelectedRow();\r\n");
      out.write("\tif (!row) {alert('请选择一个班级！');return;}\r\n");
      out.write("\tif(row.type==2){\r\n");
      out.write("\t  alert(\"该班级已毕业，无需删除！\");\r\n");
      out.write("\t}else{\r\n");
      out.write("\t  $.ligerDialog.confirm('该班如果存在学生，将不被删除。如果没有学生，第一次删除将使班级处于删除状态，第二次将彻底删除？', function (yes){\r\n");
      out.write("       if(yes){\t\r\n");
      out.write("               $.ligerDialog.prompt('请输入确认密码', function (yes, value){\r\n");
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
      out.write("\t                         $.post(\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/system/Class_classdelete.action?cls.id=\"+ row.id,null,function(){\r\n");
      out.write("\t\t\t\t\t            // manager.deleteSelectedRow();\r\n");
      out.write("\t\t\t\t\t            //window.location.reload();\r\n");
      out.write("\t\t\t\t\t            g.loadData();\r\n");
      out.write("\t\t\t\t             });\r\n");
      out.write("\t\t                   }\r\n");
      out.write("\t\t                });\r\n");
      out.write("\t               }\r\n");
      out.write("\t            });\r\n");
      out.write("\t   }\r\n");
      out.write("\t });\r\n");
      out.write("\t }\t\r\n");
      out.write("}\r\n");
      out.write("\tfunction recoveryclass(){\r\n");
      out.write("\t  var row = manager.getSelectedRow();\r\n");
      out.write("\t  if(!row){alert(\"请先选择一个班级！\");return;}\r\n");
      out.write("\t  if(row.type==0){alert(\"该班级无需重置！\");return;}\r\n");
      out.write("\t  else if(row.type==2){alert(\"该班级已毕业无需重置！\");return;}\r\n");
      out.write("\t  else{\r\n");
      out.write("\t     $.post(\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/system/Class_classrecovery.action?cls.id=\"+row.id,null,function(){\r\n");
      out.write("\t       alert(\"该班级已重置！\");\r\n");
      out.write("\t       g.loadData();\r\n");
      out.write("\t     })\r\n");
      out.write("\t  }\r\n");
      out.write("\t}\t\r\n");
      out.write("</script>\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write(".links{\r\n");
      out.write(" cursor: pointer;\r\n");
      out.write("}\r\n");
      out.write(".links:hover{\r\n");
      out.write("  color: red;\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("\t</head>\r\n");
      out.write("\t<body style=\"padding: 2px\">\r\n");
      out.write("\t        <div style=\"margin-top:5px;margin-left: 10px;margin-bottom: 10px;\" ><font size=\"3\"><strong><font size=\"4\">注</font>：</strong></font><br />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 可点击班级班主任、助理班主任，进行班主任、助理班主任设置。</div>\r\n");
      out.write("\t\t\t<!-- <a class=\"l-button\" style=\"width:60px;float:left; margin:3px;\" onclick=\"addclass()\">添&nbsp;加</a>\r\n");
      out.write("\t\t\t<a class=\"l-button\" style=\"width:80px;float:left; margin:3px;\" onclick=\"addbatchclass()\">批量添加</a>\r\n");
      out.write("\t\t\t<a class=\"l-button\" style=\"width:60px;float:left; margin:3px;\" onclick=\"deleteclass()\">删&nbsp;除</a>\r\n");
      out.write("\t\t\t<a class=\"l-button\" style=\"width:60px;float:left; margin:3px;\" onclick=\"recoveryclass()\">重&nbsp;置</a>\r\n");
      out.write("\t\t\t<a class=\"l-button\" style=\"width:60px;float:left; margin:3px;\" onclick=\"beginEdit()\">修&nbsp;改</a> -->\r\n");
      out.write("\t\t\t<!-- <a class=\"l-button\" style=\"width:80px;float:left; margin:3px;\" onclick=\"cancelEdit()\">取消修改</a>\r\n");
      out.write("\t\t    <a class=\"l-button\" style=\"width:70px;float:left; margin:3px;\" onclick=\"endEdit()\">保存</a> -->\r\n");
      out.write("\t\t<div class=\"l-clear\"></div>\r\n");
      out.write("\t\t<div id=\"maingrid\" ></div>\r\n");
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
