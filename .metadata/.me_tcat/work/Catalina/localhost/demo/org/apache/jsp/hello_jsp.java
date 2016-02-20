package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;

public final class hello_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fs_005fif_005ftest;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fs_005felse;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fs_005fif_005ftest = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fs_005felse = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fs_005fif_005ftest.release();
    _005fjspx_005ftagPool_005fs_005felse.release();
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
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\r\n");
      out.write("<html xmlns=\"http://www.w3.org/1999/xhtml\">\r\n");
      out.write("  <head>\r\n");
      out.write("    <base href=\"");
      out.print(basePath);
      out.write("\">   \r\n");
      out.write("    <title></title>\r\n");
      out.write("\t<link href=\"");
      out.print(basePath);
      out.write("js/ligerUI/skins/Aqua/css/ligerui-all.css\" rel=\"stylesheet\"type=\"text/css\" />\t\r\n");
      out.write("\t<link href=\"");
      out.print(basePath );
      out.write("js/ligerUI/skins/Gray/css/all.css\" rel=\"stylesheet\" type=\"text/css\"/>\t\r\n");
      out.write("    <script type=\"text/javascript\" src=\"");
      out.print(basePath );
      out.write("js/jquery/jquery-1.3.2.min.js\"></script>\r\n");
      out.write("\t<script src=\"");
      out.print(basePath );
      out.write("js/ligerUI/core/base.js\" type=\"text/javascript\"></script>\r\n");
      out.write("\t<script src=\"");
      out.print(basePath );
      out.write("js/ligerUI/ligerui.all.js\" type=\"text/javascript\"></script>\r\n");
      out.write("\t<!-- <script type=\"text/javascript\">\r\n");
      out.write("        var manager;\r\n");
      out.write("        $(function ()\r\n");
      out.write("        {\r\n");
      out.write("            $(\"#portalMain\").ligerPortal({\r\n");
      out.write("                draggable : true,\r\n");
      out.write("                rows: [ \r\n");
      out.write("                    {\r\n");
      out.write("                        columns: [\r\n");
      out.write("                       /* {\r\n");
      out.write("                            width: 500,                            \r\n");
      out.write("                            panels: [{\r\n");
      out.write("                                title: '公告',\r\n");
      out.write("                                width: '100%',\r\n");
      out.write("                                height: 300,\r\n");
      out.write("                               url: 'system/User_announcementlist.action'\r\n");
      out.write("                            }]\r\n");
      out.write("                        } ,,{\r\n");
      out.write("                            width: 400,\r\n");
      out.write("                            panels: [{\r\n");
      out.write("                                title: '常用链接',\r\n");
      out.write("                                width: '100%',\r\n");
      out.write("                                height: 300,\r\n");
      out.write("                                url:'system/User_hellolinks.action'\r\n");
      out.write("                            }]\r\n");
      out.write("                        } */{\r\n");
      out.write("                            width: '60%',\r\n");
      out.write("                            panels: [{\r\n");
      out.write("                                title: '提醒事项',\r\n");
      out.write("                                width: '98%',\r\n");
      out.write("                                height: 300,\r\n");
      out.write("                                url:'system/Stu_stupermission.action'\r\n");
      out.write("                            }]\r\n");
      out.write("                        } ]\r\n");
      out.write("                    }\r\n");
      out.write("                ]\r\n");
      out.write("            }); \r\n");
      out.write("        }); \r\n");
      out.write("    </script> -->\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write("#contain{ \r\n");
      out.write("  margin-top: 20px;\r\n");
      out.write("  margin-left: 30px;\r\n");
      out.write("  height: 90%;\r\n");
      out.write("  \r\n");
      out.write("}\r\n");
      out.write("#frameset{\r\n");
      out.write("  height: 100%;\r\n");
      out.write("}\r\n");
      out.write(".iframe1{\r\n");
      out.write("width:80%;height: 300px;border: 0px;\r\n");
      out.write("}\r\n");
      out.write(".iframe2{\r\n");
      out.write("  margin-top:10px;\r\n");
      out.write("  width:80%;height: 300px;border:0px;\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body style=\"padding:10px\">\r\n");
      out.write("      <!-- <div style=\"width:98%;height: 50%;margin-top: 3%;margin-left: 20px;\" id=\"portalMain\"> </div>  --> \r\n");
      out.write("      <div id=\"contain\" >         \r\n");
      out.write("           ");
      if (_jspx_meth_s_005fif_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("           ");
      if (_jspx_meth_s_005felse_005f0(_jspx_page_context))
        return;
      out.write(" \r\n");
      out.write("         \r\n");
      out.write("      </div>      \r\n");
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

  private boolean _jspx_meth_s_005fif_005f0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  s:if
    org.apache.struts2.views.jsp.IfTag _jspx_th_s_005fif_005f0 = (org.apache.struts2.views.jsp.IfTag) _005fjspx_005ftagPool_005fs_005fif_005ftest.get(org.apache.struts2.views.jsp.IfTag.class);
    _jspx_th_s_005fif_005f0.setPageContext(_jspx_page_context);
    _jspx_th_s_005fif_005f0.setParent(null);
    // /hello.jsp(80,11) name = test type = java.lang.String reqTime = false required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_s_005fif_005f0.setTest("#session.user.roles.rolerank==0||#session.user.roles.rolerank==1");
    int _jspx_eval_s_005fif_005f0 = _jspx_th_s_005fif_005f0.doStartTag();
    if (_jspx_eval_s_005fif_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      if (_jspx_eval_s_005fif_005f0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.pushBody();
        _jspx_th_s_005fif_005f0.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
        _jspx_th_s_005fif_005f0.doInitBody();
      }
      do {
        out.write("\r\n");
        out.write("             <frameset rows=\"45%,45%\" id=\"frameset\" >\r\n");
        out.write("                <iframe class=\"iframe1\" src=\"system/User_announcementlist.action\" scrolling=\"no\" ></iframe>\r\n");
        out.write("                <iframe class=\"iframe2\" src=\"system/Stu_stupermission.action\"     scrolling=\"no\" ></iframe>\r\n");
        out.write("             </frameset>\r\n");
        out.write("           ");
        int evalDoAfterBody = _jspx_th_s_005fif_005f0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
      if (_jspx_eval_s_005fif_005f0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.popBody();
      }
    }
    if (_jspx_th_s_005fif_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fs_005fif_005ftest.reuse(_jspx_th_s_005fif_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fs_005fif_005ftest.reuse(_jspx_th_s_005fif_005f0);
    return false;
  }

  private boolean _jspx_meth_s_005felse_005f0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  s:else
    org.apache.struts2.views.jsp.ElseTag _jspx_th_s_005felse_005f0 = (org.apache.struts2.views.jsp.ElseTag) _005fjspx_005ftagPool_005fs_005felse.get(org.apache.struts2.views.jsp.ElseTag.class);
    _jspx_th_s_005felse_005f0.setPageContext(_jspx_page_context);
    _jspx_th_s_005felse_005f0.setParent(null);
    int _jspx_eval_s_005felse_005f0 = _jspx_th_s_005felse_005f0.doStartTag();
    if (_jspx_eval_s_005felse_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      if (_jspx_eval_s_005felse_005f0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.pushBody();
        _jspx_th_s_005felse_005f0.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
        _jspx_th_s_005felse_005f0.doInitBody();
      }
      do {
        out.write("\r\n");
        out.write("            <frameset rows=\"100%\" id=\"frameset\" >\r\n");
        out.write("               <iframe src=\"system/User_announcementlist.action\" class=\"iframe1\" scrolling=\"no\"></iframe>\r\n");
        out.write("            </frameset>\r\n");
        out.write("           ");
        int evalDoAfterBody = _jspx_th_s_005felse_005f0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
      if (_jspx_eval_s_005felse_005f0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.popBody();
      }
    }
    if (_jspx_th_s_005felse_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fs_005felse.reuse(_jspx_th_s_005felse_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fs_005felse.reuse(_jspx_th_s_005felse_005f0);
    return false;
  }
}
