package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fs_005fform_005fnamespace_005fmethod_005fid_005faction;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fs_005ftoken_005fnobody;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fs_005fform_005fnamespace_005fmethod_005fid_005faction = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fs_005ftoken_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fs_005fform_005fnamespace_005fmethod_005fid_005faction.release();
    _005fjspx_005ftagPool_005fs_005ftoken_005fnobody.release();
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
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";

      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\r\n");
      out.write("<html xmlns=\"http://www.w3.org/1999/xhtml\">\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\r\n");
      out.write("<meta name=\"keywords\" content=\"排课,管理\" />\r\n");
      out.write("<meta name=\"description\" content=\"排课管理系统\" />\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.print(basePath);
      out.write("css/login.css\" />\r\n");
      out.write("<link rel=\"shortcut icon\" href=\"images/icon.ico\"/>\r\n");
      out.write("<title>天津工业大学国际教育学院教学服务系统</title>\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body >\r\n");
      out.write("<div class=\"main\">\r\n");
      out.write(" <div class=\"top\">\r\n");
      out.write("   <div class=\"header hide\"> </div>\r\n");
      out.write("   <div class=\"headtitle\"><font size=\"6\" face=\"华文新魏\" color=\"#ffffff\"><span style=\"font-size: 50px;\" >&nbsp;&nbsp;天津工业大学</span><br /><span>国际教育学院教学服务系统</span> </font></div>\r\n");
      out.write(" </div>\t\r\n");
      out.write("\t<div class=\"content\">\r\n");
      out.write("\t\t<div class=\"title hide\">管理登录</div>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t");
      if (_jspx_meth_s_005fform_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t</div>\r\n");
      out.write("</div>\r\n");
      out.write("<!-- <script type=\"text/javascript\" src=\"js/placeholder.js\"></script> -->\t\t\t\r\n");
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

  private boolean _jspx_meth_s_005fform_005f0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  s:form
    org.apache.struts2.views.jsp.ui.FormTag _jspx_th_s_005fform_005f0 = (org.apache.struts2.views.jsp.ui.FormTag) _005fjspx_005ftagPool_005fs_005fform_005fnamespace_005fmethod_005fid_005faction.get(org.apache.struts2.views.jsp.ui.FormTag.class);
    _jspx_th_s_005fform_005f0.setPageContext(_jspx_page_context);
    _jspx_th_s_005fform_005f0.setParent(null);
    // /login.jsp(28,2) name = action type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_s_005fform_005f0.setAction("main");
    // /login.jsp(28,2) name = method type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_s_005fform_005f0.setMethod("post");
    // /login.jsp(28,2) name = id type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_s_005fform_005f0.setId("loginForm");
    // /login.jsp(28,2) name = namespace type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_s_005fform_005f0.setNamespace("/");
    int _jspx_eval_s_005fform_005f0 = _jspx_th_s_005fform_005f0.doStartTag();
    if (_jspx_eval_s_005fform_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      if (_jspx_eval_s_005fform_005f0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.pushBody();
        _jspx_th_s_005fform_005f0.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
        _jspx_th_s_005fform_005f0.doInitBody();
      }
      do {
        out.write("\r\n");
        out.write("\t\t\t<fieldset>\r\n");
        out.write("\t\t\t   <div class=\"input\" >\r\n");
        out.write("\t\t\t\t\t<!-- <input class=\"input_all name\" name=\"user.role\"  id=\"name\" placeholder=\"用户类型\" type=\"text\" onFocus=\"this.className='input_all name_now';\" onBlur=\"this.className='input_all name'\" maxLength=\"24\" /> -->\r\n");
        out.write("\t\t\t\t\t<div class=\"input_all name\">\r\n");
        out.write("\t\t\t\t\t<select  name=\"user.roles.rolerank\"style=\"height:41px;width:190px;margin-top:-5px;border: 1.1em;\">  \r\n");
        out.write("                              <option selected=\"selected\" value=\"1\">管理员</option> \r\n");
        out.write("                              <option value=\"0\">超级管理员</option>\r\n");
        out.write("                              <option value=\"2\">任课教师</option>\r\n");
        out.write("                              <!-- <option value=\"4\">班主任</option> -->\r\n");
        out.write("                              <option  value=\"3\">学生</option>        \r\n");
        out.write("                    </select>\r\n");
        out.write("                    </div>\r\n");
        out.write("\t\t\t\t</div>\r\n");
        out.write("\t\t\t\t<div class=\"input\">\r\n");
        out.write("\t\t\t\t\t<input class=\"input_all name\" name=\"user.usernum\"  id=\"name\" placeholder=\"用户名\" type=\"text\" onFocus=\"this.className='input_all name_now';\" onBlur=\"this.className='input_all name'\" maxLength=\"24\"  />\r\n");
        out.write("\t\t\t\t</div>\r\n");
        out.write("\t\t\t\t<div class=\"input\">\r\n");
        out.write("\t\t\t\t\t<input class=\"input_all password\" name=\"user.password\" id=\"password\" type=\"password\" placeholder=\"密码\" onFocus=\"this.className='input_all password_now';\" onBlur=\"this.className='input_all password'\" maxLength=\"24\" />\r\n");
        out.write("\t\t\t\t</div>\r\n");
        out.write("\t\t\t\t<div class=\"checkbox\">\r\n");
        out.write("\t\t\t\t\t<input type=\"checkbox\" name=\"remember\" id=\"remember\" /><label for=\"remember\"><span>记住密码</span><span style=\"color: red; font-size: 10px;\">");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${message }", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
        out.write("</span></label>\r\n");
        out.write("\t\t\t\t</div>\r\n");
        out.write("\t\t\t\t<div class=\"enter\"><input class=\"button hide\" name=\"submit\" type=\"submit\" value=\"登录\" /></div>\r\n");
        out.write("\t\t\t\t<!-- ");
        if (_jspx_meth_s_005ftoken_005f0(_jspx_th_s_005fform_005f0, _jspx_page_context))
          return true;
        out.write(" -->\r\n");
        out.write("\t\t\t</fieldset>\r\n");
        out.write("\t\t");
        int evalDoAfterBody = _jspx_th_s_005fform_005f0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
      if (_jspx_eval_s_005fform_005f0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.popBody();
      }
    }
    if (_jspx_th_s_005fform_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fs_005fform_005fnamespace_005fmethod_005fid_005faction.reuse(_jspx_th_s_005fform_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fs_005fform_005fnamespace_005fmethod_005fid_005faction.reuse(_jspx_th_s_005fform_005f0);
    return false;
  }

  private boolean _jspx_meth_s_005ftoken_005f0(javax.servlet.jsp.tagext.JspTag _jspx_th_s_005fform_005f0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  s:token
    org.apache.struts2.views.jsp.ui.TokenTag _jspx_th_s_005ftoken_005f0 = (org.apache.struts2.views.jsp.ui.TokenTag) _005fjspx_005ftagPool_005fs_005ftoken_005fnobody.get(org.apache.struts2.views.jsp.ui.TokenTag.class);
    _jspx_th_s_005ftoken_005f0.setPageContext(_jspx_page_context);
    _jspx_th_s_005ftoken_005f0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_s_005fform_005f0);
    int _jspx_eval_s_005ftoken_005f0 = _jspx_th_s_005ftoken_005f0.doStartTag();
    if (_jspx_th_s_005ftoken_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fs_005ftoken_005fnobody.reuse(_jspx_th_s_005ftoken_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fs_005ftoken_005fnobody.reuse(_jspx_th_s_005ftoken_005f0);
    return false;
  }
}
