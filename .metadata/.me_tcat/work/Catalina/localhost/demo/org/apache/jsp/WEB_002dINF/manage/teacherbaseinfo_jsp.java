package org.apache.jsp.WEB_002dINF.manage;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;

public final class teacherbaseinfo_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\">\r\n");
      out.write("    \r\n");
      out.write("    <title>天津工业大学排课管理系统</title>\r\n");
      out.write("    <title>天津工业大学排课管理系统</title>\r\n");
      out.write("\t<link href=\"");
      out.print(basePath);
      out.write("js/ligerUI/skins/Aqua/css/ligerui-all.css\" rel=\"stylesheet\"type=\"text/css\" />\t\r\n");
      out.write("\t<link href=\"");
      out.print(basePath );
      out.write("js/ligerUI/skins/Gray/css/all.css\" rel=\"stylesheet\" type=\"text/css\"/>\t\r\n");
      out.write("    <script src=\"js/jquery/jquery-1.3.2.min.js\"type=\"text/javascript\"></script>\r\n");
      out.write("\t<script src=\"js/ligerUI/core/base.js\" type=\"text/javascript\"></script>\r\n");
      out.write("\t<script src=\"js/ligerUI/ligerui.all.js\" type=\"text/javascript\"></script>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("  var m;\r\n");
      out.write("  function teacheredit(){\r\n");
      out.write("    var str = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/system/Manage_teacherbaseupdate.action?teacher.identificationnum=\"+$(\"#id\").val();\r\n");
      out.write("    m=$.ligerDialog.open({\t\t   \r\n");
      out.write("\t\t\turl : str,\r\n");
      out.write("\t\t\theight : 500,\r\n");
      out.write("\t\t\twidth : 400,\r\n");
      out.write("\t\t\ttitle:'个人信息修改',\r\n");
      out.write("\t\t\tisResize : true\r\n");
      out.write("\t\t});\r\n");
      out.write("  }\r\n");
      out.write("  var n ;\r\n");
      out.write("  function changeimgs(){\r\n");
      out.write("    var str = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/system/Manage_teacherbegainchangeimg.action?teacher.identificationnum=\"+$(\"#id\").val();\r\n");
      out.write("    n=$.ligerDialog.open({\t\t   \r\n");
      out.write("\t\t\turl : str,\r\n");
      out.write("\t\t\theight : 400,\r\n");
      out.write("\t\t\twidth : 500,\r\n");
      out.write("\t\t\ttitle:'照片修改',\r\n");
      out.write("\t\t\tisResize : true\r\n");
      out.write("\t\t});\r\n");
      out.write("  }\r\n");
      out.write("</script>\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write("body{\r\n");
      out.write(" /*  background-color: #e9edf0; */\r\n");
      out.write("}\r\n");
      out.write("#container{\r\n");
      out.write(" width: 70%;\r\n");
      out.write(" margin:auto;\r\n");
      out.write(" margin-top:20px;\r\n");
      out.write(" margin-left:20%;\r\n");
      out.write(" height:99%;\r\n");
      out.write(" /* background-color: #fbfaf5; */\r\n");
      out.write(" /* border: 2px solid #cce4ed ; */\r\n");
      out.write("}\r\n");
      out.write("#imginfo{\r\n");
      out.write("  float: left;\r\n");
      out.write("  width: 200px;\r\n");
      out.write("  height:250px;\r\n");
      out.write("  margin-top:20px;\r\n");
      out.write("  /* border: 2px solid #cce4ed ; */\r\n");
      out.write("}\r\n");
      out.write(".imginfo1{\r\n");
      out.write("  width: 150px;\r\n");
      out.write("  height:180px;\r\n");
      out.write("  margin:auto;\r\n");
      out.write("  border: 2px solid #cce4ed ;\r\n");
      out.write("}\r\n");
      out.write("#info{\r\n");
      out.write("margin-top:20px;\r\n");
      out.write("  float: left;\r\n");
      out.write("  width:69%;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".l-edit{\r\n");
      out.write(" text-align: center;\r\n");
      out.write(" color: #cbc6c6;\r\n");
      out.write("}\r\n");
      out.write(".l-edit-l{\r\n");
      out.write(" font-family: 楷体;\r\n");
      out.write("}\r\n");
      out.write(".l-button{\r\n");
      out.write(" width:80px;float:left; margin:3px;\r\n");
      out.write(" margin-left: 30%;\r\n");
      out.write(" margin-top: 30px;\r\n");
      out.write("}\r\n");
      out.write(".a-change{\r\n");
      out.write("  font-size: 10px;\r\n");
      out.write("  float: right;\r\n");
      out.write("  background-color: #fff;\r\n");
      out.write("  text-decoration: none;\r\n");
      out.write("}\r\n");
      out.write("#zhaopian{\r\n");
      out.write(" width: 100%;\r\n");
      out.write(" height: 100%;\r\n");
      out.write("}\r\n");
      out.write("#baseinfo{\r\n");
      out.write("  margin-top:0px;\r\n");
      out.write("  width: 100%;\r\n");
      out.write("}\r\n");
      out.write("#baseinfo td{\r\n");
      out.write("  height: 30px;\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("  </head>\r\n");
      out.write(" \r\n");
      out.write("  <body>\r\n");
      out.write("  <div id=\"container\"  > \r\n");
      out.write("  <h2  style=\"font-family: 微软雅黑;margin-top: 40px ;margin-left: 50%;\" >基本信息</h2>    \r\n");
      out.write("      <div style=\"color: red\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${message }", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("</div> \r\n");
      out.write("      <input id=\"id\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${teachers.identificationnum }", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\" type=\"hidden\">   \r\n");
      out.write("      <div id=\"imginfo\" >\r\n");
      out.write("        <div class=\"imginfo1\" > <img id=\"zhaopian\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${teachers.imgurl }", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\" ></div>\r\n");
      out.write("        <img src=\"images/touxiang.png\" style=\"width:100px;height: 40px; cursor:pointer; margin-left:50px;margin-top: 10px; \" onclick=\"changeimgs()\"  >      \r\n");
      out.write("      </div>\r\n");
      out.write("      <div id=\"info\">\r\n");
      out.write("         <table id=\"baseinfo\" border=\"1\" cellspacing=\"0\" width=\"800px\" align=\"center\">\r\n");
      out.write("        <tr>\r\n");
      out.write("            <td class=\"l-edit\" ><font color=\"#808080\">姓名</font></td><td class=\"l-edit-l\" align=\"center\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${teachers.teachername }", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("</td>\r\n");
      out.write("        </tr>\r\n");
      out.write("        <tr>\r\n");
      out.write("            <td class=\"l-edit\" ><font color=\"#808080\">教师编号</font></td><td class=\"l-edit-l\" align=\"center\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${teachers.identificationnum}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("</td>\r\n");
      out.write("        </tr>\r\n");
      out.write("        <tr>\r\n");
      out.write("            <td class=\"l-edit\" ><font color=\"#808080\">性别</font></td><td class=\"l-edit-l\" align=\"center\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${teachers.sex }", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("</td>\r\n");
      out.write("        </tr>\r\n");
      out.write("        <tr>\r\n");
      out.write("            <td class=\"l-edit\" ><font color=\"#808080\">职称</font></td><td class=\"l-edit-l\" align=\"center\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${teachers.position }", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("</td>\r\n");
      out.write("        </tr>\r\n");
      out.write("         <tr>\r\n");
      out.write("            <td class=\"l-edit\" ><font color=\"#808080\">联系方式</font></td><td class=\"l-edit-l\" align=\"center\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${teachers.telephone }", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("</td>\r\n");
      out.write("        </tr>\r\n");
      out.write("        <tr>\r\n");
      out.write("            <td class=\"l-edit\" ><font color=\"#808080\">所属部门</font></td><td class=\"l-edit-l\" align=\"center\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${dept.deptname}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("</td>\r\n");
      out.write("        </tr>\r\n");
      out.write("        <tr>\r\n");
      out.write("            <td class=\"l-edit\" ><font color=\"#808080\">e-mail</font></td><td class=\"l-edit-l\" align=\"center\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${teachers.email }", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("</td>\r\n");
      out.write("        </tr>       \r\n");
      out.write("      </table>\r\n");
      out.write("      </div>           \r\n");
      out.write("     <input id=\"button\" class=\"l-button\" type=\"button\" value=\"修&nbsp;&nbsp;&nbsp;&nbsp;改\" onclick=\"teacheredit()\"/> \r\n");
      out.write("    </div>\r\n");
      out.write("  </body>\r\n");
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
