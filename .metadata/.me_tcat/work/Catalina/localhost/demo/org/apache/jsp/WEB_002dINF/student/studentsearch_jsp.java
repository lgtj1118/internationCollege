package org.apache.jsp.WEB_002dINF.student;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;

public final class studentsearch_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("    <script type=\"text/javascript\" src=\"js/json.js\" charset=\"utf-8\"></script>\r\n");
      out.write("    <script type=\"text/javascript\" src=\"js/jquery-validation/jquery.metadata.js\" charset=\"utf-8\"></script>\r\n");
      out.write("    <script type=\"text/javascript\" src=\"js/jquery-validation/messages_cn.js\" charset=\"utf-8\"></script>\r\n");
      out.write("    <script src=\"js/jquery/jquery-1.3.2.min.js\"type=\"text/javascript\"></script>\r\n");
      out.write("\t<script src=\"js/ligerUI/core/base.js\" type=\"text/javascript\"></script>\r\n");
      out.write("\t<script src=\"js/ligerUI/ligerui.all.js\" type=\"text/javascript\"></script>\r\n");
      out.write("    <script type=\"text/javascript\">\t\t\t\r\n");
      out.write("\t\tvar ClassData = { \r\n");
      out.write("\tRows: [");
String s = (String) request.getAttribute("classlist");
      out.write(' ');
      out.print(s);
      out.write("]};\r\n");
      out.write("    var ClassList = ClassData.Rows;\r\n");
      out.write("    var sexData = [{ Sex: 1, text: '男' }, { Sex: 2, text: '女'}];\r\n");
      out.write("   $(f_initGrid);\r\n");
      out.write("\tvar manager, g;\r\n");
      out.write("\tfunction f_initGrid() {\r\n");
      out.write("\t\tg = manager = $(\"#maingrid\").ligerGrid(\r\n");
      out.write("\t\t\t{columns : [\r\n");
      out.write("\t\t\t{   display : '序号',  name : 'id',     width : 40,  type : 'int',hide:true\r\n");
      out.write("\t\t\t},{display : '护照', name : 'passport', minWidth : 100,  editor:{type:'text'}\t}\r\n");
      out.write("\t\t\t, {display : '学号', name : 'stuid',  wiminWidthdth : 120, editor: { type: 'text'}\r\n");
      out.write("\t\t\t}, {display : '英文名', name : 'firstname',minWidth : 100, editor: { type: 'text'}\r\n");
      out.write("\t\t\t}, {display : '英文姓', name : 'lastname',minWidth : 100, editor: { type: 'text'}\r\n");
      out.write("\t\t\t}, {display : '中文名', name : 'stuname',minWidth : 80, editor: { type: 'text'}\r\n");
      out.write("\t\t\t} ,{display : '性别', name : 'stusex', minWidth : 50,  editor:{type:'text'}\t\t\t\t\r\n");
      out.write("\t\t\t} ,{ display: '班级',  name: 'classid', minWidth: 100, isSort: false,\r\n");
      out.write("            editor: { type: 'select', data: ClassList, valueColumnName: 'Classid', displayColumnName: 'Classname' }, \r\n");
      out.write("                  render: function (item)\r\n");
      out.write("                    {for (var i = 0; i < ClassList.length; i++)\r\n");
      out.write("                        { if (ClassList[i]['Classid'] == item.classid)\r\n");
      out.write("                                return ClassList[i]['Classname'];\r\n");
      out.write("                        }\r\n");
      out.write("                        return item.Classname;\r\n");
      out.write("                    }\r\n");
      out.write("                }\r\n");
      out.write("             ,{display : '电话', name : 'telephone', minWidth : 100,  editor:{type:'text'} \r\n");
      out.write("             } ,{display : '住址', name : 'roomplace', minWidth : 120,  editor:{type:'text'}\r\n");
      out.write("             } ,{display : '国籍', name : 'nation', minWidth : 100,  editor:{type:'text'}\t}\r\n");
      out.write("             ],\r\n");
      out.write("\t\t\t\t\tonSelectRow : function(rowdata, rowindex) {\r\n");
      out.write("\t\t\t\t\t\t$(\"#txtrowindex\").val(rowindex);\r\n");
      out.write("\t\t\t\t\t},\r\n");
      out.write("\t\t\t\t\t//checkbox:true,\r\n");
      out.write("\t\t\t\t\tenabledEdit : true,\r\n");
      out.write("\t\t\t\t\tclickToEdit : false,\r\n");
      out.write("\t\t\t\t\tisScroll : false,\r\n");
      out.write("\t\t\t\t\trownumbers:true, \r\n");
      out.write("\t\t\t\t\tpageSize:30,\r\n");
      out.write("\t\t\t\t\turl :'");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/system/Stu_stulist.action',\r\n");
      out.write("\t\t\t\t\twidth : '100%'\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t});\r\n");
      out.write("\t}\r\n");
      out.write("\t\tvar flg= false;\r\n");
      out.write("\t\tfunction f_search(){\r\n");
      out.write("\t\t\tif ((document.all.stuname.value ==\"\")&&(document.all.passport.value ==\"\")){\r\n");
      out.write("\t\t\t\t$(\"#maingrid\").ligerGrid({\r\n");
      out.write("\t\t\t\t\turl : '");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/system/Stu_stulist.action'\r\n");
      out.write("\t\t\t   })\r\n");
      out.write("\t\t\t}else{\r\n");
      out.write("\t\t\tvar str =\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/system/Stu_stusearch.action?stu.stuname=\" + encodeURI(encodeURI($(\"#stuname\").val())\r\n");
      out.write("\t\t+\"&stu.passport=\"+encodeURI(encodeURI($(\"#passport\").val())));\r\n");
      out.write("\t\t\t$(\"#maingrid\").ligerGrid({\r\n");
      out.write("\t\t\t\t\turl : str\r\n");
      out.write("\t\t\t   })\r\n");
      out.write("\t\t\t}\t\t\t\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t\r\n");
      out.write("\tfunction fuzzy (){\r\n");
      out.write("\t\tvar query = $(\"#query\").val();\r\n");
      out.write("\t\tvar str =\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/system/Stu_stuFuzzySearch.action?query=\" + encodeURI(encodeURI(query));\r\n");
      out.write("\t\t$(\"#maingrid\").ligerGrid({\r\n");
      out.write("\t\t\t\turl : str,\r\n");
      out.write("\t\t});\r\n");
      out.write("\t}\r\n");
      out.write("</script>\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write("#head{\r\n");
      out.write(" width: 99%;\r\n");
      out.write(" height:90px;\r\n");
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
      out.write("  margin-top: 25px;\r\n");
      out.write("}\r\n");
      out.write(".l-table-edit{\r\n");
      out.write(" margin-top: 10px;\r\n");
      out.write(" margin-left: 20px;\r\n");
      out.write("}\r\n");
      out.write(".link{\r\n");
      out.write("width:200px;height:25px;background: #fefefe;border: 1px solid #bbb;font-size: 14px;color: #333;border-radius: 3px;\r\n");
      out.write("}\r\n");
      out.write(".l-button{\r\n");
      out.write(" width:70px;float:left; margin:20px 160px 5px ;\r\n");
      out.write(" border-radiux:5px;\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("</head>\r\n");
      out.write("\t<body style=\"font-size: 12px;\">\r\n");
      out.write("\t<div id=\"head\">\r\n");
      out.write("\t      <!-- <div class=\"title\" ><br><br><div align=\"center\"><font face=\"微软雅黑\" color=\"#400000\" size=\"4\"><strong>条件选择</strong></font></div></div> -->\r\n");
      out.write("\t      <div class=\"search\" >\r\n");
      out.write("\t         <table cellpadding=\"0\" cellspacing=\"0\" class=\"l-table-edit\" >\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<!-- <td align=\"right\" class=\"l-table-edit-td\">&nbsp;姓名:&nbsp;</td>\r\n");
      out.write("\t\t\t\t<td align=\"left\" class=\"l-table-edit-td\">\r\n");
      out.write("\t\t\t\t   <input id=\"stuname\" class=\"link\" name=\"stuname\"   />\r\n");
      out.write("\t\t\t\t</td>\r\n");
      out.write("\t\t\t    <td align=\"right\" class=\"l-table-edit-td\">&nbsp;&nbsp;护照号:&nbsp;</td>\r\n");
      out.write("\t\t\t\t<td align=\"left\" class=\"l-table-edit-td\">\r\n");
      out.write("\t\t\t\t  <input id=\"passport\" class=\"link\" name=\"passport\"   />\r\n");
      out.write("\t\t\t\t</td> -->\r\n");
      out.write("\t\t\t\t <td align=\"right\" class=\"l-table-edit-td\">&nbsp;&nbsp;关键字:&nbsp;</td>\r\n");
      out.write("\t\t\t\t<td align=\"left\" class=\"l-table-edit-td\">\r\n");
      out.write("\t\t\t\t  <input id=\"query\" class=\"link\" onkeyup=\"fuzzy()\" placeholder=\"学号 姓名 班级 护照 国籍\"/>\r\n");
      out.write("\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t<td align=\"right\" class=\"l-table-edit-td\"></td>\r\n");
      out.write("\t\t\t\t<td align=\"left\" class=\"l-table-edit-td\"></td>\t\t\t\t\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t  <th colspan=\"6\"><div id=\"result1\"></div></th>\r\n");
      out.write("\t\t\t</tr>\t\t\t\t\t\t\r\n");
      out.write("\t\t</table>\r\n");
      out.write("\t\t<!-- <a class=\"l-button\" onclick=\"f_search()\"><strong>查&nbsp;&nbsp;询</strong></a> -->\r\n");
      out.write("\t\t<!-- <a class=\"l-button\" onclick=\"fuzzy()\"><strong>查&nbsp;&nbsp;询</strong></a> -->\r\n");
      out.write("\t      </div>\r\n");
      out.write("\t    </div>\t\t\r\n");
      out.write("\t\t<h2 style=\"margin: 20px;\" ><font face=\"华文楷体\">查询结果显示：</font></h2>\t\t\t  \r\n");
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
