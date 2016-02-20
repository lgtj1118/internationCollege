package org.apache.jsp.WEB_002dINF.manage;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;

public final class announcementadd_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html;charset=GBK");
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
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";

      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<title>天津工业大学排课管理系统</title>\r\n");
      out.write("<link href=\"");
      out.print(basePath);
      out.write("js/ligerUI/skins/Gray/css/form.css\" rel=\"stylesheet\"type=\"text/css\" />\r\n");
      out.write("<link href=\"");
      out.print(basePath);
      out.write("js/ligerUI/skins/Gray/css/common.css\" rel=\"stylesheet\"type=\"text/css\" />\r\n");
      out.write("<script src=\"");
      out.print(basePath);
      out.write("js/jquery/jquery-1.6.min.js\" type=\"text/javascript\"></script>\r\n");
      out.write("<script src=\"");
      out.print(basePath);
      out.write("js/ligerUI/core/base.js\" type=\"text/javascript\"></script>\r\n");
      out.write("<script src=\"");
      out.print(basePath);
      out.write("js/ligerUI/plugins/ligerForm.js\" type=\"text/javascript\"></script>\r\n");
      out.write("<script src=\"");
      out.print(basePath);
      out.write("js/ligerUI/plugins/ligerDateEditor.js\" type=\"text/javascript\"></script>\r\n");
      out.write("<script src=\"");
      out.print(basePath);
      out.write("js/ligerUI/plugins/ligerComboBox.js\" type=\"text/javascript\"></script>\r\n");
      out.write("<script src=\"");
      out.print(basePath);
      out.write("js/ligerUI/plugins/ligerSpinner.js\" type=\"text/javascript\"></script>\r\n");
      out.write("<script src=\"");
      out.print(basePath);
      out.write("js/ligerUI/plugins/ligerTextBox.js\" type=\"text/javascript\"></script>\r\n");
      out.write("\r\n");
      out.write("<script src=\"");
      out.print(basePath);
      out.write("js/ligerUI/plugins/ligerTip.js\" type=\"text/javascript\"></script>\r\n");
      out.write("<script src=\"");
      out.print(basePath);
      out.write("js/jquery-validation/jquery.validate.min.js\"type=\"text/javascript\"></script>\r\n");
      out.write("<script src=\"");
      out.print(basePath);
      out.write("js/jquery-validation/jquery.metadata.js\" type=\"text/javascript\"></script>\r\n");
      out.write("<script src=\"");
      out.print(basePath);
      out.write("js/jquery-validation/messages_cn.js\" type=\"text/javascript\"></script>\r\n");
      out.write("\t<script charset=\"utf-8\" src=\"");
      out.print(basePath );
      out.write("js/kediter/themes/default/default.css\"  type=\"text/javascript\"></script>\r\n");
      out.write("    <script charset=\"utf-8\" src=\"");
      out.print(basePath );
      out.write("js/kediter/lang/zh_CN.js\" type=\"text/javascript\"></script>\r\n");
      out.write("\t<script charset=\"utf-8\" src=\"");
      out.print(basePath );
      out.write("js/kediter/kindeditor-min.js\" type=\"text/javascript\"></script>\r\n");
      out.write("\t<script>\r\n");
      out.write("\t\tvar editor;\r\n");
      out.write("\t\tKindEditor.ready(function(K) {\r\n");
      out.write("\t\t\t\teditor = K.create('textarea[id=\"content\"]', {\r\n");
      out.write("\t\t\t\t\tallowFileManager : false,\r\n");
      out.write("\t\t\t\t\tnewlineTag : 'br',\r\n");
      out.write("\t\t\t        cssPath : '");
      out.print(basePath );
      out.write("js/plugins/code/prettify.css',\r\n");
      out.write("\t\t\t\t    uploadJson : '");
      out.print(basePath );
      out.write("/upload/upload_json.jsp',\r\n");
      out.write("\t\t\t\t    fileManagerJson : '");
      out.print(basePath );
      out.write("/upload/file_manager_json.jsp',\t\t\t\t    \t\t\t\r\n");
      out.write("\t\t\t\t});\t\t\t\t\r\n");
      out.write("\t\t\t}); \r\n");
      out.write("        function check(){           \r\n");
      out.write("\t\t        alert('添加成功!');\r\n");
      out.write("\t\t        parent.m.hide();\r\n");
      out.write("\t\t        parent.g.loadData();\t\t    \r\n");
      out.write("        }\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write("body {\r\n");
      out.write("\tfont-size: 12px;\r\n");
      out.write("}\r\n");
      out.write(".l-table-edit {\r\n");
      out.write("\tfont-size: 12px;\r\n");
      out.write("}\r\n");
      out.write(".l-table-edit-td {\r\n");
      out.write("\tpadding: 4px;\r\n");
      out.write("}\r\n");
      out.write(".l-button-submit {\r\n");
      out.write("\twidth: 150px;\r\n");
      out.write("\theight: 30px;\r\n");
      out.write("\tpadding-bottom: 2px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("</style>\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body style=\"padding:10px; margin-bottom: 10px;\">\r\n");
      out.write("\r\n");
      out.write("\t<form name=\"form1\" method=\"post\" namespace=\"/system\" action=\"Manage_announcementendadd.action\"  id=\"form1\">\r\n");
      out.write("\t\t<div></div>\r\n");
      out.write("\t\t<table cellpadding=\"0\" cellspacing=\"0\" class=\"l-table-edit\">\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td align=\"left\" class=\"l-table-edit-td\">标题:</td>\r\n");
      out.write("\t\t\t\t<td align=\"left\" class=\"l-table-edit-td\">\r\n");
      out.write("\t\t\t\t<input name=\"announcement.title\" value=\"\" type=\"text\"\r\n");
      out.write("\t\t\t\t\tid=\"title\" ltype=\"text\" style=\"width:200px;height: 20px;\" validate=\"{required:true,minlength:3}\" /></td>\r\n");
      out.write("\t\t\t\t<td align=\"left\"></td>\r\n");
      out.write("\t\t\t</tr>\t\t\t\t\t\t\r\n");
      out.write("\t\t\t<tr><td align=\"left\" class=\"l-table-edit-td\">内容:</td></tr>\r\n");
      out.write("\t\t</table>\r\n");
      out.write("\t\t<div style=\"width:100%\">\r\n");
      out.write("\t\t\t<div>\r\n");
      out.write("\t\t\t\t<textarea id=\"content\" name=\"announcement.content\" rows=\"15\" cols=\"80\"style=\"width: 100%; height:300px;\"></textarea>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\t\t\r\n");
      out.write("\t\t<br />\t\t\r\n");
      out.write("\t\t<div style=\"width:150px; margin:0px auto;\">\r\n");
      out.write("\t\t\t<input type=\"submit\" value=\"提交\" id=\"Button1\" onclick=\"check()\" class=\"l-button l-button-submit\" />\r\n");
      out.write("\t\t\t<!-- <input type=\"button\" value=\"提交\" id=\"Button1\" onclick=\"add()\" class=\"l-button l-button-submit\" /> -->\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</form>\r\n");
      out.write("\r\n");
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
