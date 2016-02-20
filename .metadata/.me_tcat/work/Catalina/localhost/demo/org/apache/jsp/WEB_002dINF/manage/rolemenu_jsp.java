package org.apache.jsp.WEB_002dINF.manage;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;
import com.tjpu.bean.Menu;

public final class rolemenu_jsp extends org.apache.jasper.runtime.HttpJspBase
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
	String basePath = request.getScheme() + "://"
	+ request.getServerName() + ":" + request.getServerPort()
	+ path + "/";

      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\r\n");
      out.write("<html xmlns=\"http://www.w3.org/1999/xhtml\">\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\" />\r\n");
      out.write("<title>权限设置</title>\r\n");
      out.write("<script src=\"");
      out.print(basePath);
      out.write("js/jquery/jquery-1.6.min.js\" type=\"text/javascript\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.print(basePath);
      out.write("js/wtree.js\"></script>\r\n");
      out.write("<link rel=\"StyleSheet\" href=\"");
      out.print(basePath);
      out.write("css/dtree.css\" type=\"text/css\" />\r\n");
      out.write("<link href=\"");
      out.print(basePath);
      out.write("js/ligerUI/skins/Gray/css/common.css\" rel=\"stylesheet\"type=\"text/css\" />\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t<p>\r\n");
      out.write("\t\t<a class=\"l-button\"style=\"width: 170px;margin-left: 20px;margin-bottom: 20px;margin-top: 10px ;\" onclick=\"sel()\";>确定修改</a>\r\n");
      out.write("\t</p>\r\n");
      out.write("\t<div id=\"systree\"></div>\r\n");
      out.write("\t<script type=\"text/javascript\">\r\n");
      out.write("\tfunction sel() {\r\n");
      out.write("\t\tvar selids = d.getCheckedNodes();\r\n");
      out.write("\t\tvar str = \"\";\r\n");
      out.write("\t\tfor ( var n = 0; n < selids.length; n++) {\r\n");
      out.write("\t\t\tstr += selids[n] + \";\";\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t$.post(\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/system/Menu_rolemenuupdate.action?ids=\"\r\n");
      out.write("\t\t\t\t+ str+\"&id=\"+$(\"#roleid\").val(),null,function(){\r\n");
      out.write("\t\t\t\t alert(\"修改成功！\");\r\n");
      out.write("\t\t\t\t parent.p.hide();\r\n");
      out.write("\t\t\t\t});\r\n");
      out.write("       \r\n");
      out.write("\t}\r\n");
      out.write("\tvar d = new dTree('d', '");
      out.print(basePath);
      out.write("images/menu/');\r\n");
      out.write("\td.config.check = true;\r\n");
   List<Menu> menulist = (List<Menu>) request.getAttribute("menulist");
	 Iterator<Menu> menuiter = menulist.iterator();
	 Menu m= menuiter.next(); 
      out.write("\r\n");
      out.write("\t d.add(");
      out.print(m.getId());
      out.write(", -1, '");
      out.print(m.getNamenav());
      out.write("', \"javascript:;\", '");
      out.print(m.getNamenav());
      out.write("');\r\n");
   while (menuiter.hasNext()) {
		m = menuiter.next();
      out.write("\r\n");
      out.write("\t\td.add(");
      out.print(m.getId());
      out.write(',');
      out.write(' ');
      out.print(m.getMenu().getId());
      out.write(',');
      out.write(' ');
      out.write('\'');
      out.print(m.getNamenav());
      out.write("', \"javascript:;\",'");
      out.print(m.getNamenav());
      out.write("');\r\n");
}
      out.write("\r\n");
      out.write("\tdocument.getElementById('systree').innerHTML = d;\r\n");
  List<Menu> rolemenu = (List<Menu>) request.getAttribute("rolemenu");
	Iterator<Menu> rolemenuiter = rolemenu.iterator();
      out.write("\t\r\n");
      out.write("\tvar funcs = eval(\"(\"+ \"{funcs:[");
while (rolemenuiter.hasNext()) { Menu rm =rolemenuiter.next();
      out.write("{menudm:'");
      out.print(rm.getId());
      out.write('\'');
      out.write('}');
      out.write(',');
}
      out.write("{menudm:'1'}]}\" + \")\");\r\n");
      out.write("\t\tfor ( var n = 0; n < funcs.funcs.length; n++) {\r\n");
      out.write("\t\t\td.co(funcs.funcs[n].menudm).checked = true;\r\n");
      out.write("\t\t} \r\n");
      out.write("\t</script>\r\n");
      out.write("\t<input id=\"roleid\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${roleid }", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\" type=\"hidden\" />\r\n");
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
