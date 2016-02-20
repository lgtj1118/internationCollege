package org.apache.jsp.WEB_002dINF.student;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;

public final class graduateclassstulist_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("   var StatusData = [{ status: 0, text: '未审核' }, { status: 1, text: '通过'},, { status: 2, text: '未通过'}];\r\n");
      out.write("   $(f_initGrid);\r\n");
      out.write("\tvar manager, g;\r\n");
      out.write("\tfunction f_initGrid() {\r\n");
      out.write("\t\tg = manager = $(\"#maingrid\").ligerGrid(\r\n");
      out.write("\t\t\t{columns : [\r\n");
      out.write("\t\t\t{   display : '序号',  name : 'id',     minWidth : 40,  type : 'int',hide:true\r\n");
      out.write("\t\t\t}, {display : '护照号', name : 'passport',  minWidth : 120, editor: { type: 'text'}\r\n");
      out.write("\t\t\t}, {display : '英文名', name : 'firstname',minWidth : 100, editor: { type: 'text'}\r\n");
      out.write("\t\t\t}, {display : '英文姓', name : 'lastname',minWidth : 100, editor: { type: 'text'}\r\n");
      out.write("\t\t\t}, {display : '中文名', name : 'stuname',minWidth : 80, editor: { type: 'text'}\r\n");
      out.write("\t\t\t} ,{display : '电话', name : 'telephone', minWidth : 100,  editor:{type:'text'} \r\n");
      out.write("            } ,{display : '国籍', name : 'nation', minWidth : 100,  editor:{type:'text'}\t}\r\n");
      out.write("            ,{display : '学生类别', name : 'studentType', minWidth : 80,  editor:{type:'text'}\t}\r\n");
      out.write("            ,{display : '入校时间', name : 'startdate', minWidth : 80, editor:{type:'text'} /* type: 'date', format: 'yyyy-MM-dd', width: 100, editor: { type: 'date'} */\t}\t\r\n");
      out.write("            ,{display : '离校时间', name : 'enddate', minWidth : 80,  editor:{type:'text'}\t}\r\n");
      out.write("            ,{display : '已修学分', name : 'totalcredits', minWidth : 80,  editor:{type:'text'}\t}\r\n");
      out.write("            ,{display : '标准学分', name : 'standardcredits', minWidth : 80,  editor:{type:'text'}\t}\r\n");
      out.write("            ,{display : '状态', name : 'status', minWidth : 80,   editor: { type: 'select', data: StatusData, valueField: 'status' },\r\n");
      out.write("                    render: function (item)\r\n");
      out.write("                    {\r\n");
      out.write("                        if (parseInt(item.status) == 0){ var h=\"<span style='color:red;'>未审核</span>\" ;return h;}\r\n");
      out.write("                        else if (parseInt(item.status) == 1) { var h=\"<span style='color:green;'>通过</span>\" ;return h;}\r\n");
      out.write("                        else if (parseInt(item.status) == 2) { var h=\"<span style='color:orange;'>未通过</span>\" ;return h;}\r\n");
      out.write("                        \r\n");
      out.write("                    }\t}],\r\n");
      out.write("\t\t\tonSelectRow : function(rowdata, rowindex) {\r\n");
      out.write("\t\t\t\t$(\"#txtrowindex\").val(rowindex);\r\n");
      out.write("\t\t\t},\r\n");
      out.write("\t\t\t\t//checkbox:true,\r\n");
      out.write("\t\t\t\tenabledEdit : true,\r\n");
      out.write("\t\t\t\tclickToEdit : false,\r\n");
      out.write("\t\t\t\tisScroll : false,\r\n");
      out.write("\t\t\t\trownumbers:true, \r\n");
      out.write("\t\t\t\tpageSize:30,\r\n");
      out.write("\t\t\t\tcheckbox:true,\r\n");
      out.write("\t\t\t\turl :'");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/system/Class_loadclassstu.action',\r\n");
      out.write("\t\t\t\twidth : '100%'\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t}\r\n");
      out.write("var m;\t\r\n");
      out.write("   function passaudit(){\r\n");
      out.write("    var row = manager.getSelectedRow();\r\n");
      out.write("\tif (!row) {alert('请选择至少一项！');return;}\r\n");
      out.write("\tvar rows = g.getCheckedRows();\r\n");
      out.write("    var str = \"\";\r\n");
      out.write("    $(rows).each(function (){ \r\n");
      out.write("    　　if(this.status!=1){\r\n");
      out.write("         if(parseFloat(this.totalcredits)>=parseFloat(this.standardcredits)){\r\n");
      out.write("            str += this.id+\",\";\r\n");
      out.write("         }\r\n");
      out.write("       }   \r\n");
      out.write("    });\r\n");
      out.write("    if(str.length==0){\r\n");
      out.write("      alert(\"请重新查看各学生审核状态或已修学分！\");\r\n");
      out.write("    }else{\r\n");
      out.write("       $.post(\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/system/Manage_graduatestuauditagree.action?ids=\"+str,null,function(){\r\n");
      out.write("         alert('审核成功！');\r\n");
      out.write("         window.location.reload();\r\n");
      out.write("       });\r\n");
      out.write("    }    \r\n");
      out.write("\t}\r\n");
      out.write("   function refuseaudit(){\r\n");
      out.write("     var row = manager.getSelectedRow();\r\n");
      out.write("\t if (!row) {alert('请选择至少一项！');return;}\r\n");
      out.write("     var rows = g.getCheckedRows();\r\n");
      out.write("     var str = \"\";\r\n");
      out.write("     $(rows).each(function (){ \r\n");
      out.write("    　　       if(this.status!=1&&this.status!=2){\r\n");
      out.write("         if(parseFloat(this.totalcredits)>=parseFloat(this.standardcredits)){\r\n");
      out.write("            $.ligerDialog.confirm('学生护照号：'+this.passport+'已修够学分，确认审核不通过？', function (yes){\r\n");
      out.write("              if(yes){\r\n");
      out.write("                str += this.id+\",\";\r\n");
      out.write("              }\r\n");
      out.write("            });\r\n");
      out.write("         }else{\r\n");
      out.write("             str += this.id+\",\";\r\n");
      out.write("         }\r\n");
      out.write("       }   \r\n");
      out.write("    });\r\n");
      out.write("    if(str.length==0){\r\n");
      out.write("      alert(\"请确认各学生的审核状态！\");\r\n");
      out.write("    }else{\r\n");
      out.write("      $.post(\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/system/Manage_graduatestuauditrefuse.action?ids=\"+str,null,function(){\r\n");
      out.write("                alert('批复成功！');\r\n");
      out.write("                window.location.reload();\r\n");
      out.write("      });\r\n");
      out.write("    }\r\n");
      out.write("}\r\n");
      out.write("</script>\r\n");
      out.write("\t</head>\r\n");
      out.write("\t<body style=\"padding: 2px\">\r\n");
      out.write("\t<input id=\"classid\"  value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${classesid }", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\" type=\"hidden\" />\r\n");
      out.write("\t <a class=\"l-button\" style=\"width:70px;float:left; margin:3px;\" onclick=\"passaudit()\">审核通过</a>\r\n");
      out.write("\t <a class=\"l-button\" style=\"width:70px;float:left; margin:3px;\" onclick=\"refuseaudit()\">不批准</a>\r\n");
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
