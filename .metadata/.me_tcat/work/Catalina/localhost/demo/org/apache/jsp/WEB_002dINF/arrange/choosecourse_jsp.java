package org.apache.jsp.WEB_002dINF.arrange;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import org.springframework.web.context.request.SessionScope;
import java.util.*;

public final class choosecourse_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\t<script type=\"text/javascript\" src=\"js/semester.js\" ></script>\r\n");
      out.write("<script type=\"text/javascript\">   \r\n");
      out.write("\t$(f_initGrid);\r\n");
      out.write("\tvar manager, g;\r\n");
      out.write("\tfunction f_initGrid() {\r\n");
      out.write("\t\tg = manager = $(\"#maingrid\").ligerGrid(\r\n");
      out.write("\t\t\t\t{\t\t\t\r\n");
      out.write("\t\t\t\tcolumns : [{\r\n");
      out.write("\t\t\t\tdisplay : '序号',\r\n");
      out.write("\t\t\t\tname : 'id',\r\n");
      out.write("\t\t\t\twidth : 60,\r\n");
      out.write("\t\t\t\thide:true,\r\n");
      out.write("\t\t\t\ttype : 'int'\r\n");
      out.write("\t\t\t}, {\r\n");
      out.write("\t\t\t\tdisplay : '课程编号',\r\n");
      out.write("\t\t\t\tname : 'num',\r\n");
      out.write("\t\t\t\tminWidth : 80,\r\n");
      out.write("\t\t\t\t//editor: { type: 'int'}\r\n");
      out.write("\t\t\t}, {\r\n");
      out.write("\t\t\t\tdisplay : '课程名称',\r\n");
      out.write("\t\t\t\tname : 'courseName',\r\n");
      out.write("\t\t\t\tminWidth : 80,\r\n");
      out.write("\t\t\t\t//editor: { type: 'text'}\r\n");
      out.write("\t\t\t},  {\r\n");
      out.write("\t\t\t\tdisplay : '开课周数',columns:[\r\n");
      out.write("\t\t\t\t{ display:'起始周' , name:'beginWeek',minWidth : 60, },\r\n");
      out.write("\t\t\t\t{ display:'结束周' , name:'endWeek',  minWidth : 60, }\r\n");
      out.write("\t\t\t\t]\t\t\t\r\n");
      out.write("\t\t\t} , {\r\n");
      out.write("\t\t\t\tdisplay : '学分',\r\n");
      out.write("\t\t\t\tname : 'credits',\r\n");
      out.write("\t\t\t\tminWidth : 60,\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t}, {\r\n");
      out.write("\t\t\t\tdisplay : '教师',columns:[\r\n");
      out.write("\t\t\t\t   {display : '教师工号',name : 'teacherid',width : 120,}, \r\n");
      out.write("\t\t\t\t   {display : '负责教师',name : 'teacher',width : 120,}\r\n");
      out.write("\t\t\t\t]\r\n");
      out.write("\t\t\t} , {\r\n");
      out.write("\t\t\t\tdisplay : '开课学生数',\r\n");
      out.write("\t\t\t\tname : 'stuNum',\r\n");
      out.write("\t\t\t\twidth : 120,\r\n");
      out.write("\t\t\t} /*   , {\r\n");
      out.write("\t\t\t\tdisplay : '已选人数',\r\n");
      out.write("\t\t\t\tname : 'havestuNum',\r\n");
      out.write("\t\t\t\twidth : 120,\r\n");
      out.write("\t\t\t}  */, {\r\n");
      out.write("\t\t\t\tdisplay : '课程类型',\r\n");
      out.write("\t\t\t\tname : 'courseType',\r\n");
      out.write("\t\t\t\tminWidth : 60,\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t} , {\r\n");
      out.write("\t\t\t\tdisplay : '状态',\r\n");
      out.write("\t\t\t\tname : 'classes',\r\n");
      out.write("\t\t\t\tminWidth : 60,\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t} /* ,{\r\n");
      out.write("\t\t\t\t\tdisplay : '操作',\r\n");
      out.write("\t\t\t\t\tisSort : false,\r\n");
      out.write("\t\t\t\t\twidth : 120,\r\n");
      out.write("\t\t\t\t\trender : function() {\r\n");
      out.write("\t\t\t\t\t\tvar h = \"\";\r\n");
      out.write("\t\t\t\t\t\th += \"<button type='button' onclick='javascript:selectcourse(\"+ \")'>选课</button> \";\r\n");
      out.write("\t\t\t\t\t\th += \"&nbsp;&nbsp;\";\r\n");
      out.write("\t\t\t\t\t\th += \"<button type='button' onclick='javascript:cancelcourse(\"+ \")'>退选</button> \";\r\n");
      out.write("\t\t\t\t\t\treturn h;\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t}*/],\r\n");
      out.write("\t\t\t\tonSelectRow : function(rowdata, rowindex) {\r\n");
      out.write("\t\t\t\t\t\t$(\"#txtrowindex\").val(rowindex);\r\n");
      out.write("\t\t\t\t\t},\r\n");
      out.write("\t\t\t\t\tenabledEdit : true,\r\n");
      out.write("\t\t\t\t\tclickToEdit : true,\r\n");
      out.write("\t\t\t\t\tisScroll : false,\r\n");
      out.write("\t\t\t\t\tcheckbox:false,\r\n");
      out.write("\t\t\t        rownumbers:true,\r\n");
      out.write("\t\t\t        pageSize:15,\r\n");
      out.write("\t\t\t\t\turl :'");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/system/Manage_courseListForCourseSelection.action',\r\n");
      out.write("\t\t\t\t\twidth : '100%',\t\t\t\t\t\r\n");
      out.write("\t\t\t\t});\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\tfunction add(){\r\n");
      out.write("\t\tvar semester = $(\"#semester option:selected\").val();\r\n");
      out.write("\t\tif (semester.length == 0) {\r\n");
      out.write("\t\t\talert(\"请先选择学期！\");\r\n");
      out.write("\t\t} else {\r\n");
      out.write("\t\t\tvar row = manager.getSelectedRow();\r\n");
      out.write("\t\t\t if (row.classes == \"未选\") {\r\n");
      out.write("\t\t\t\t$.post(\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/system/Manage_selectCourse.action?selectiveCourseNum=\" + row.num + \"&semester=\" + $(\"#semester option:selected\").val(), null, function(data){\r\n");
      out.write("\t\t\t\t\t//alert(\"提交成功！\");\r\n");
      out.write("\t\t\t\t\tif(data.length>0){\r\n");
      out.write("\t\t\t\t\t   alert(data);\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t//window.location.reload();\t\r\n");
      out.write("\t\t\t\t\tg.loadData();\t\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t})\r\n");
      out.write("\t\t\t} else {\r\n");
      out.write("\t\t\t\talert(\"不能选择已选的课程\");\r\n");
      out.write("\t\t\t} \r\n");
      out.write("\t\t\t/* if (row.classes == \"未选\") {\r\n");
      out.write("\t\t\t var url = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/system/Manage_selectCourse.action?selectiveCourseNum=\" + row.num + \"&semester=\" + $(\"#semester option:selected\").val()\t\r\n");
      out.write("\t\t\t  $.ajax({  \r\n");
      out.write("\t\t        type : \"POST\",  \r\n");
      out.write("\t\t        url : url,\r\n");
      out.write("\t\t        dataType : \"JSON\", \r\n");
      out.write("\t\t        error: function (){; },\r\n");
      out.write("\t\t        success : function(data) {\r\n");
      out.write("\t\t          if(data.lengt>0){\r\n");
      out.write("\t\t            alert(data);\r\n");
      out.write("\t\t          }else{\r\n");
      out.write("\t\t            alert(\"提交成功！\");\r\n");
      out.write("\t\t            g.loadData();\r\n");
      out.write("\t\t          }\r\n");
      out.write("\t\t        }  \r\n");
      out.write("\t\t     }); \r\n");
      out.write("\t      }else{\r\n");
      out.write("\t        alert(\"不能选择已选的课程\");\r\n");
      out.write("\t      } */\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("\tfunction deleterow(){\r\n");
      out.write("\t\tvar row = manager.getSelectedRow();\r\n");
      out.write("\t\tif (row.classes == \"<font color='red' >已选</font>\") {\r\n");
      out.write("\t\t\t$.post(\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/system/Manage_diselectCoruse.action?selectiveCourseNum=\" + row.num, null, function(){\r\n");
      out.write("\t\t\t\t//alert(\"提交成功！\");\r\n");
      out.write("\t\t\t\tg.loadData();\r\n");
      out.write("\t\t\t})\r\n");
      out.write("\t\t} else {\r\n");
      out.write("\t\t\talert(\"不能退选未选的课程\");\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("\tfunction f_search(){\r\n");
      out.write("\t\tvar semester = $(\"#semester\").val();\r\n");
      out.write("\t\tvar date = new Date();\r\n");
      out.write("\t\tvar year = date.getFullYear();\r\n");
      out.write("\t\tvar month = date.getMonth();\r\n");
      out.write("\t\tvar now;\r\n");
      out.write("\t\tif (month > 9) {\r\n");
      out.write("\t\t\tnow = year + \"01\";\r\n");
      out.write("\t\t} else {\r\n");
      out.write("\t\t\tnow = year + \"02\";\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tif (now <= semester) {\r\n");
      out.write("\t\t\tvar str = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/system/Manage_SearchcourseListForCourseSelection.action?semester=\" + semester;\r\n");
      out.write("\t\t\t$(\"#maingrid\").ligerGrid({\r\n");
      out.write("\t\t\t\turl : str\r\n");
      out.write("\t\t\t})\r\n");
      out.write("\t\t} else {\r\n");
      out.write("\t\t\talert(\"请选择本学期或下学期的课程！\");\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("</script>\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write("#head{\r\n");
      out.write(" width: 99%;\r\n");
      out.write(" height:100px;\r\n");
      out.write(" margin:auto;\r\n");
      out.write(" border:4px solid #c6c6c6 ;\r\n");
      out.write(" display: none;\r\n");
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
      out.write(" height:100%;\r\n");
      out.write(" margin-top:20px;\r\n");
      out.write(" align:center;\r\n");
      out.write("}\r\n");
      out.write(".search.l-table-edit td{\r\n");
      out.write("  border-bottom: 1px solid #c6c6c6 ;\r\n");
      out.write("}\r\n");
      out.write(".link{\r\n");
      out.write("width:180px;height:25px;background: #fefefe;border: 1px solid #bbb;font-size: 14px;color: #333;border-radius: 3px;\r\n");
      out.write("}\r\n");
      out.write(".l-button{\r\n");
      out.write(" width:70px;float:left; margin:-10px 160px 5px ;\r\n");
      out.write(" border-radiux:5px;\r\n");
      out.write("}\r\n");
      out.write("#content{\r\n");
      out.write("  margin-left: 0px;\r\n");
      out.write("  margin-top:30px;\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("\t</head>\r\n");
      out.write("\t<body style=\"padding: 2px;font-size: 12px;\">\t\r\n");
      out.write("\t<div id=\"head\">\r\n");
      out.write("\t      <div class=\"title\" ><br><br><div align=\"center\"><font face=\"微软雅黑\" color=\"#400000\" size=\"4\"><strong>条件选择</strong></font></div></div>\r\n");
      out.write("\t      <div class=\"search\" >\r\n");
      out.write("\t         <table cellpadding=\"0\" cellspacing=\"0\" class=\"l-table-edit\" width=\"100%\" >\t\t\t  \r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t   <td align=\"right\" class=\"l-table-edit-td\">&nbsp;&nbsp;&nbsp;开课学期:&nbsp;</td>\r\n");
      out.write("\t\t\t\t<td align=\"left\" class=\"l-table-edit-td\">\r\n");
      out.write("\t\t\t\t   <select id=\"semester\" name=\"semester\" class=\"link\" onchange=\"f_search()\" >\r\n");
      out.write("\t\t\t\t      <option value=\"\" ></option>\t\t\t\t      \r\n");
      out.write("\t\t\t\t   </select>\r\n");
      out.write("\t\t\t\t</td>\t\t\t\t\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t   <td></td><td></td><td></td>\r\n");
      out.write("\t\t\t   <td  ><div id=\"result\" style=\"color:red; font-size: 10px;\"></div></td>\r\n");
      out.write("\t\t\t</tr>\t\t\t\t\t\t\r\n");
      out.write("\t\t</table>\r\n");
      out.write("\t\t<!-- <a class=\"l-button\" onclick=\"f_search()\"><strong>查&nbsp;&nbsp;询</strong></a> -->\r\n");
      out.write("\t      </div>\r\n");
      out.write("\t    </div>\t\r\n");
      out.write("\t    <div id=\"content\" >\r\n");
      out.write("\t         <a class=\"l-button\" style=\"width:60px;float:left; margin:3px;\" onclick=\"add()\">选&nbsp;&nbsp;修</a>\r\n");
      out.write("\t\t     <a class=\"l-button\" style=\"width:60px;float:left; margin:3px;\" onclick=\"deleterow()\">退&nbsp;&nbsp;选</a>\t\r\n");
      out.write("\t    </div>\t\t\r\n");
      out.write("\t\t\r\n");
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
