package org.apache.jsp.WEB_002dINF.course;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;

public final class courseattendencestatistical_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\t<link href=\"");
      out.print(basePath);
      out.write("css/date.css\" rel=\"stylesheet\" type=\"text/css\"/>\r\n");
      out.write("\t<link href=\"js/ligerUI/skins/ligerui-icons.css\" rel=\"stylesheet\" type=\"text/css\">\r\n");
      out.write("\t<script src=\"js/ligerUI/plugins/ligerToolBar.js\" type=\"text/javascript\"></script>\r\n");
      out.write("    <script src=\"js/jquery/jquery-1.6.min.js\"type=\"text/javascript\"></script>\r\n");
      out.write("    <script src=\"js/jquery/jquery.js\"type=\"text/javascript\"></script>\r\n");
      out.write("\t<script src=\"js/ligerUI/core/base.js\" type=\"text/javascript\"></script>\r\n");
      out.write("\t<script src=\"js/ligerUI/ligerui.all.js\" type=\"text/javascript\"></script>\r\n");
      out.write("\t<script src=\"js/ligerUI/plugins/ligerDateEditor.js\" type=\"text/javascript\"></script>\r\n");
      out.write("\t<script src=\"");
      out.print(basePath);
      out.write("js/jquery.date_input.pack.js\" type=\"text/javascript\"></script>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("    $(function(){\r\n");
      out.write("\t  $('.date_picker').date_input();\r\n");
      out.write("   })\r\n");
      out.write("    var AttendenceData = { \r\n");
      out.write("\tRows: [");
String s = (String) request.getAttribute("attendencelist");
      out.write(' ');
      out.print(s);
      out.write("]};\r\n");
      out.write("    var TypeData = [{ type: 0, text: '正常' }, { type: 1, text: '迟到'}, { type: 2, text: '早退'}, { type: 3, text: '旷课'}];\r\n");
      out.write("   $(f_initGrid);\r\n");
      out.write("\tvar manager, g;\r\n");
      out.write("\tfunction f_initGrid() {\r\n");
      out.write("\t\tg = manager = $(\"#maingrid\").ligerGrid(\r\n");
      out.write("\t\t\t{columns : [\r\n");
      out.write("\t\t\t{   display : '序号',  name : 'id',     width : 40,  type : 'int',hide:true\r\n");
      out.write("\t\t\t}, {display : '护照号', name : 'passport',  minWidth : 120, editor: { type: 'text'}\r\n");
      out.write("\t\t\t}, {display : '中文名', name : 'stuname',minWidth : 80, editor: { type: 'text'}\r\n");
      out.write("\t\t\t},{\r\n");
      out.write("\t\t\t\tdisplay : '考勤状态',columns:[\r\n");
      out.write("\t\t\t\t{ display:'正常' , name:'normal',minWidth : 60,editor: { type: 'int'} },\r\n");
      out.write("\t\t\t\t{ display:'迟到' , name:'late',  minWidth : 60,editor: { type: 'int'} },\r\n");
      out.write("\t\t\t\t{ display:'早退' , name:'leaveearly',  minWidth : 60,editor: { type: 'int'} },\r\n");
      out.write("\t\t\t\t{ display:'旷课' , name:'truancy',  minWidth : 60,editor: { type: 'int'} },\t\t\t\t\r\n");
      out.write("\t\t\t\t]\t\t\t\r\n");
      out.write("\t\t\t},{ display:'缺勤率（%）' , name:'probability',  minWidth : 60,editor: { type: 'int'},\r\n");
      out.write("\t\t\t    render:function (item) {\r\n");
      out.write("\t\t\t\t\tif (parseInt(item.probability)<=10) {\r\n");
      out.write("\t\t\t\t\t\treturn \"<font style='color:black'>\"+item.probability+\"</font>\";\r\n");
      out.write("\t\t\t\t\t} else if(parseInt(item.probability)>10&&parseInt(item.probability)<=20) {\r\n");
      out.write("\t\t\t\t\t\treturn \"<font style='color:orange'>\"+item.probability+\"</font>\";\r\n");
      out.write("\t\t\t\t\t}else{\r\n");
      out.write("\t\t\t\t\t    return \"<font style='color:red'>\"+item.probability+\"</font>\";\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t } ],\r\n");
      out.write("\t\t\t\t\tonSelectRow : function(rowdata, rowindex) {\r\n");
      out.write("\t\t\t\t\t\t$(\"#txtrowindex\").val(rowindex);\r\n");
      out.write("\t\t\t\t\t},\r\n");
      out.write("\t\t\t\t\tenabledEdit : true,\r\n");
      out.write("\t\t\t\t\tclickToEdit : false,\r\n");
      out.write("\t\t\t\t\tisScroll : false,\r\n");
      out.write("\t\t\t        rownumbers:true,\r\n");
      out.write("\t\t\t        pageSize:10,\r\n");
      out.write("\t\t\t\t\turl : '");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/system/Manage_attendencestatistical.action',\r\n");
      out.write("\t\t\t\t\twidth : '99%',\r\n");
      out.write("\t\t\t\t\ttoolbar: { items: [\t\t\t\t\t                   \r\n");
      out.write("                                       { text: '导出',click: itemclick,  icon: 'outbox' }               \r\n");
      out.write("                    ]}\r\n");
      out.write("\t\t\t\t});//'");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/system/Manage_attendencestulist.action'\r\n");
      out.write("\t}\t\r\n");
      out.write("  function f_search(){ \r\n");
      out.write("      var startdate = $(\"#startdate\").val();\r\n");
      out.write("      var enddate = $(\"#enddate\").val();\r\n");
      out.write("      if(startdate.length==0&&enddate.length!=0){\r\n");
      out.write("        alert(\"请输入起始日期！\");\r\n");
      out.write("      }else{\r\n");
      out.write("        if(startdate.length!=0&&enddate.length==0){\r\n");
      out.write("           alert(\"请输入截止日期！\");\r\n");
      out.write("        }else{\r\n");
      out.write("          if (startdate.length==0&&enddate.length==0) {\r\n");
      out.write("\t\t\t$(\"#maingrid\").ligerGrid({\r\n");
      out.write("\t\t\t\t\turl : '");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/system/Manage_attendencestatistical.action'\r\n");
      out.write("\t\t\t })\r\n");
      out.write("\t      } else {\r\n");
      out.write("\t       var str = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/system/Manage_singlecourseattendencestatistical.action?course.num=\"+$(\"#coursenum\").val()+\"&cls.id=\"+$(\"#classid\").val()+\"&startdate=\"+startdate+\"&enddate=\"+enddate;\r\n");
      out.write("\t\t   $(\"#maingrid\").ligerGrid({\r\n");
      out.write("\t\t\t url : str\r\n");
      out.write("\t\t   })\r\n");
      out.write("\t     }\r\n");
      out.write("       }\r\n");
      out.write("    }\r\n");
      out.write("  }\r\n");
      out.write("  function itemclick(){\r\n");
      out.write("      var startdate = $(\"#startdate\").val();\r\n");
      out.write("      var enddate = $(\"#enddate\").val();\r\n");
      out.write("      if(startdate.length==0&&enddate.length!=0){\r\n");
      out.write("        alert(\"请输入起始日期！\");\r\n");
      out.write("      }else{\r\n");
      out.write("        if(startdate.length!=0&&enddate.length==0){\r\n");
      out.write("           alert(\"请输入截止日期！\");\r\n");
      out.write("        }else{\r\n");
      out.write("           var str = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/system/Manage_classattendencedownload.action?course.num=\"+$(\"#coursenum\").val()+\"&cls.id=\"+$(\"#classid\").val()+\"&startdate=\"+startdate+\"&enddate=\"+enddate; \r\n");
      out.write("           window.location.href=str;\r\n");
      out.write("        } \r\n");
      out.write("      }   \r\n");
      out.write("  }\r\n");
      out.write("    \r\n");
      out.write("</script>\r\n");
      out.write("\t</head>\r\n");
      out.write("\t<style type=\"text/css\">\r\n");
      out.write("body{\r\n");
      out.write("  font-size: 12px;\r\n");
      out.write("}\r\n");
      out.write("#head{\r\n");
      out.write(" width: 99%;\r\n");
      out.write(" height:100px;\r\n");
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
      out.write("width:180px;height:25px;background: #fefefe;border: 1px solid #bbb;font-size: 14px;color: #333;border-radius: 3px;\r\n");
      out.write("}\r\n");
      out.write(".l-button{\r\n");
      out.write(" width:70px;float:left; margin:0px 160px 5px ;\r\n");
      out.write(" border-radiux:5px;\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("\t</head>\r\n");
      out.write("\t<body >\r\n");
      out.write("\t<div id=\"head\">\r\n");
      out.write("\t\t  <div class=\"title\" ><br><br><div align=\"center\"><font face=\"微软雅黑\" color=\"#400000\" size=\"4\"><strong>条件选择</strong></font></div></div>\r\n");
      out.write("\t      <div class=\"search\" >\t        \r\n");
      out.write("\t\t  <table  cellpadding=\"0\" cellspacing=\"0\" class=\"l-table-edit\"  >\t\t\t \r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t    <td align=\"right\" class=\"l-table-edit-td\" width=\"100px\" >&nbsp;&nbsp;起始日期:&nbsp;</td>\r\n");
      out.write("\t\t\t\t<td align=\"left\" class=\"l-table-edit-td\">\r\n");
      out.write("\t\t\t\t  <input  id=\"startdate\"   class=\"date_picker link\" >\r\n");
      out.write("\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t<td align=\"right\" class=\"l-table-edit-td\">&nbsp;&nbsp;截止日期:&nbsp;</td>\r\n");
      out.write("\t\t\t\t<td align=\"left\" class=\"l-table-edit-td\">\r\n");
      out.write("\t\t\t\t  <input  id=\"enddate\"   class=\"date_picker link\"  >\r\n");
      out.write("\t\t\t\t</td>\t\r\n");
      out.write("\t\t\t</tr>\t\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t</table>\r\n");
      out.write("\t\t<a class=\"l-button\" style=\"width:70px;float:left; margin:0px 160px 5px ;\" onclick=\"f_search()\">查&nbsp;&nbsp;询</a>\t\t\r\n");
      out.write("\t\t </div>\r\n");
      out.write("\t    </div>\t\r\n");
      out.write("\t    <input id=\"classid\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${classid }", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\" type=\"hidden\" />\r\n");
      out.write("\t    <input id=\"coursenum\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${coursenum }", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\" type=\"hidden\" />\t    \r\n");
      out.write("\t\t<div style=\"margin-top:20px;font-size: 16px;margin-left: 10px;\">考勤统计：</div>\r\n");
      out.write("\t    <div class=\"l-clear\"></div>\r\n");
      out.write("\t\t<div id=\"maingrid\" ></div>\r\n");
      out.write("\t\t<div  style=\"display:none;\">\r\n");
      out.write("\t\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
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
