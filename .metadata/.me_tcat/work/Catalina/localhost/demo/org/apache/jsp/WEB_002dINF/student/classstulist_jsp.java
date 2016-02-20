package org.apache.jsp.WEB_002dINF.student;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;

public final class classstulist_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("    <title></title>\t   \r\n");
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
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("   $(f_initGrid);\r\n");
      out.write("\tvar manager, g;\r\n");
      out.write("\tfunction f_initGrid() {\r\n");
      out.write("\t\tg = manager = $(\"#maingrid\").ligerGrid(\r\n");
      out.write("\t\t\t{columns : [\r\n");
      out.write("\t\t\t{   display : '序号',  name : 'id',     minWidth : 40,  type : 'int',hide:true\r\n");
      out.write("\t\t\t}, {display : '护照号', name : 'passport',  minWidth : 120 \r\n");
      out.write("\t\t\t}, {display : '学号', name : 'stuid',  minWidth : 120 \r\n");
      out.write("\t\t\t} ,{display : '密码', name : 'password',minWidth : 80,hide:true,editor: { type: 'password'}\r\n");
      out.write("\t\t\t}, {display : '英文名', name : 'firstname',minWidth : 100, editor: { type: 'text'}\r\n");
      out.write("\t\t\t}, {display : '英文姓', name : 'lastname',minWidth : 100, editor: { type: 'text'}\r\n");
      out.write("\t\t\t}, {display : '中文名', name : 'stuname',minWidth : 80, editor: { type: 'text'}\r\n");
      out.write("\t\t\t} ,{display : '性别', name : 'stusex', minWidth : 50,  editor:{type:'text'}\t\t\t\t\r\n");
      out.write("\t\t\t} ,{display : '电话', name : 'telephone', minWidth : 100,  editor:{type:'text'} \r\n");
      out.write("             } ,{display : '住址', name : 'roomplace', minWidth : 120,  editor:{type:'text'}\r\n");
      out.write("             } ,{display : '国籍', name : 'nation', minWidth : 100,  editor:{type:'text'}\t}\r\n");
      out.write("             ,{display : '学生类别', name : 'studentType', minWidth : 80,  editor:{type:'text'}\t}],\r\n");
      out.write("\t\t\tonSelectRow : function(rowdata, rowindex) {\r\n");
      out.write("\t\t\t\t$(\"#txtrowindex\").val(rowindex);\r\n");
      out.write("\t\t\t},\r\n");
      out.write("\t\t\t\tcheckbox:true,\r\n");
      out.write("\t\t\t\tenabledEdit : true,\r\n");
      out.write("\t\t\t\tclickToEdit : false,\r\n");
      out.write("\t\t\t\tisScroll : false,\r\n");
      out.write("\t\t\t\trownumbers:true, \r\n");
      out.write("\t\t\t\tselectRowButtonOnly:false,\r\n");
      out.write("\t\t\t\tpageSize:30,\r\n");
      out.write("\t\t\t\turl :'");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/system/Class_loadclassstu.action',\r\n");
      out.write("\t\t\t\twidth : '100%',\r\n");
      out.write("\t\t\t\ttoolbar: { items: [\r\n");
      out.write("                         { text: '导出',click: itemclick,  icon: 'add' }               \r\n");
      out.write("                    ]}\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t}\r\n");
      out.write("\tfunction itemclick(item){\r\n");
      out.write("       var str = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/system/Class_classstudownload.action?cls.id=\"+$(\"#classid\").val(); \r\n");
      out.write("       window.location.href=str;\r\n");
      out.write("        }\r\n");
      out.write("\tvar m;\r\n");
      out.write("\tfunction beginEdit() {\r\n");
      out.write("            var row = manager.getSelectedRow();\r\n");
      out.write("            if (!row) { alert('请选择一名学生！'); return; }\r\n");
      out.write("            var row = manager.getSelectedRow();\r\n");
      out.write("       if (!row) { alert('请选择一名学生！'); return; }      \r\n");
      out.write("       var str = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/system/Stu_stuedit.action?stu.id=\"+ row.id;\r\n");
      out.write("       m=$.ligerDialog.open({\r\n");
      out.write("\t\t\turl : str,\r\n");
      out.write("\t\t\theight : 450,\r\n");
      out.write("\t\t\twidth : 600,\r\n");
      out.write("\t\t\tisDrag:true,\r\n");
      out.write("\t\t\tshowMax:true,\r\n");
      out.write("\t\t\tshowToggle:true,\r\n");
      out.write("\t\t\tslide: false,\t\t\t\r\n");
      out.write("\t\t\tmodal:false,\r\n");
      out.write("\t\t\tleft:200,\r\n");
      out.write("\t\t\ttitle:'学生更新',\r\n");
      out.write("\t\t\tallowClose:true,\r\n");
      out.write("\t\t    isResize : false\r\n");
      out.write("\t\t});\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\tfunction deleterow() {\r\n");
      out.write("\tvar row = manager.getSelectedRow();\r\n");
      out.write("\t\tif (!row) {\r\n");
      out.write("\t\t\talert('请选择一名学生！');\r\n");
      out.write("\t\t\treturn;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tif (confirm('确定删除?'))\r\n");
      out.write("            {\r\n");
      out.write("              var rows = g.getCheckedRows();\r\n");
      out.write("              var str = \"\";\r\n");
      out.write("              $(rows).each(function(){\r\n");
      out.write("              str += this.id +\",\";\r\n");
      out.write("              });\r\n");
      out.write("              $.post(\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/system/Stu_studelete.action?ids=\"+ str);\r\n");
      out.write("\t\t\t  manager.deleteSelectedRow();\t\r\n");
      out.write("            }\r\n");
      out.write("\t}\t \r\n");
      out.write("\tvar m;\r\n");
      out.write("\tfunction addstu(){\t\r\n");
      out.write("\tvar str = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/system/Stu_classstubeginadd.action?cls.id=\"+$(\"#classid\").val();\r\n");
      out.write("\t\tm=$.ligerDialog.open({\r\n");
      out.write("\t\t\turl : str,\r\n");
      out.write("\t\t\theight : 500,\r\n");
      out.write("\t\t\twidth : 700,\r\n");
      out.write("\t\t\tisDrag:true,\r\n");
      out.write("\t\t\tshowMax:true,\r\n");
      out.write("\t\t\tshowToggle:true,\r\n");
      out.write("\t\t\tslide: false,\t\t\t\r\n");
      out.write("\t\t\tmodal:false,\r\n");
      out.write("\t\t\tleft:50,\r\n");
      out.write("\t\t\tallowClose:true,\r\n");
      out.write("\t\t    isResize : false\r\n");
      out.write("\t\t});\t\t\r\n");
      out.write("\t}\r\n");
      out.write("\tfunction addbatchstu(){\r\n");
      out.write("\tvar str = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/system/Stu_classstubatchadd.action?cls.id=\"+$(\"#classid\").val();\r\n");
      out.write("\t\tm=$.ligerDialog.open({\r\n");
      out.write("\t\t\turl : str,\r\n");
      out.write("\t\t\theight : 500,\r\n");
      out.write("\t\t\twidth : 800,\r\n");
      out.write("\t\t\tisResize : true\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\t\r\n");
      out.write("\t}\r\n");
      out.write("\tfunction minitor(){\r\n");
      out.write("\t var row = manager.getSelectedRow();\r\n");
      out.write("\t ident = row.passport;\r\n");
      out.write("\t\tif (!row) {alert('请选择一名学生！');return;}\r\n");
      out.write("\t\t /* $.post(\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/system/Class_classminitorset.action?cls.id=\"+$(\"#classid\").val()\r\n");
      out.write("\t     +\"&ids=\"+row.id,null,function(){\r\n");
      out.write("\t       alert(\"设置成功！\");\r\n");
      out.write("\t     });\r\n");
      out.write("\t     } */\r\n");
      out.write("\t \tvar url = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/system/Class_issetminitor.action?queryID=\"+$(\"#classid\").val();\r\n");
      out.write("\t \t$.ajax({  \r\n");
      out.write("\t\t   type : \"POST\",  \r\n");
      out.write("\t\t   url : url,\r\n");
      out.write("\t\t   error: function (){\r\n");
      out.write("\t\t        alert(\"服务器错误，请联系管理员!\");\r\n");
      out.write("\t\t   },\r\n");
      out.write("\t\t   success : function(data) {\r\n");
      out.write("\t\t       if (data.length > 0){\r\n");
      out.write("\t\t        if(data==row.stuid){\r\n");
      out.write("\t\t          alert(\"该学生已是班级班长，无需设置！\");\r\n");
      out.write("\t\t        }else{\r\n");
      out.write("\t\t         var msg = \"该已设置护照号：\";\r\n");
      out.write("\t\t         msg = msg + data+ \" \";\t\t\t       \r\n");
      out.write("\t\t         msg = msg + \"为该班班长，是否继续？\";\r\n");
      out.write("\t\t         tips(msg, ident);\r\n");
      out.write("\t\t         return;\t\r\n");
      out.write("\t\t        }\r\n");
      out.write("\t\t       \r\n");
      out.write("\t\t      } else {\r\n");
      out.write("\t\t        print(ident);\r\n");
      out.write("\t\t      };\r\n");
      out.write("\t\t}  \r\n");
      out.write("\t}); \r\n");
      out.write("\t }\r\n");
      out.write("\t \r\n");
      out.write("\t function print(ident){\r\n");
      out.write("\t  //alert(\"here\");\r\n");
      out.write("\t  var url = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/system/Class_classminitorset.action?cls.id=\"+$(\"#classid\").val()+\"&ids=\"+ident;\r\n");
      out.write("\t  $.post(url, null, function() {\r\n");
      out.write("\t\t\tparent.m.hide();\r\n");
      out.write("\t\t\tparent.window.location.reload();\r\n");
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
      out.write("</script>\r\n");
      out.write("\t</head>\r\n");
      out.write("\t<body style=\"padding: 2px\">\r\n");
      out.write("\t<input id=\"classid\"  value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${classesid }", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\" type=\"hidden\" />\r\n");
      out.write("\t  <!-- <a class=\"l-button\" style=\"width:70px;float:left; margin:3px;\" onclick=\"addstu()\">添&nbsp;&nbsp;加</a>\r\n");
      out.write("\t <a class=\"l-button\" style=\"width:70px;float:left; margin:3px;\" onclick=\"addbatchstu()\">批量添加</a>       \r\n");
      out.write("\t <a class=\"l-button\" style=\"width:70px;float:left; margin:3px;\" onclick=\"deleterow()\">删&nbsp;&nbsp;除</a>\r\n");
      out.write("\t <a class=\"l-button\" style=\"width:70px;float:left; margin:3px;\" onclick=\"beginEdit()\">修&nbsp;&nbsp;改</a>\r\n");
      out.write("\t <a class=\"l-button\" style=\"width:80px;float:left; margin:3px;\" onclick=\"cancelEdit()\">取消修改</a>\r\n");
      out.write("\t <a class=\"l-button\" style=\"width:70px;float:left; margin:3px;\" onclick=\"endEdit()\">保存</a> -->\r\n");
      out.write("\t <a class=\"l-button\" style=\"width:70px;float:left; margin:3px;\" onclick=\"minitor()\">设置为班长</a>\t \t \r\n");
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
