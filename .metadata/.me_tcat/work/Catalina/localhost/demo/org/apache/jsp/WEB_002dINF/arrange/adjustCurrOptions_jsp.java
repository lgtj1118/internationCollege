package org.apache.jsp.WEB_002dINF.arrange;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.opensymphony.xwork2.ActionContext;
import com.tjpu.bean.Syllabus;
import com.tjpu.bean.ChosenCourseModel;
import java.util.*;
import java.io.*;

public final class adjustCurrOptions_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html; charset=utf-8");
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
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");

	String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<base href=\"");
      out.print(basePath);
      out.write("\">\r\n");
      out.write("\r\n");
      out.write("<title>天津工业大学排课管理系统</title>\r\n");
      out.write("\r\n");
      out.write("<meta http-equiv=\"pragma\" content=\"no-cache\">\r\n");
      out.write("<meta http-equiv=\"cache-control\" content=\"no-cache\">\r\n");
      out.write("<meta http-equiv=\"expires\" content=\"0\">\r\n");
      out.write("<meta http-equiv=\"keywords\" content=\"keyword1,keyword2,keyword3\">\r\n");
      out.write("<meta http-equiv=\"description\" content=\"This is my page\">\r\n");
      out.write("<script src=\"js/jquery/jquery-1.3.2.min.js\" type=\"text/javascript\"></script>\r\n");
      out.write("<script src=\"js/ligerUI/ligerui.all.js\" type=\"text/javascript\"></script>\r\n");
      out.write("<link rel=\"stylesheet\" href=\"//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css\">\r\n");
      out.write("<script src=\"//code.jquery.com/jquery-1.10.2.js\"></script>\r\n");
      out.write("<script src=\"//code.jquery.com/ui/1.11.4/jquery-ui.js\"></script>\r\n");
      out.write("<link href=\"");
      out.print(basePath);
      out.write("js/ligerUI/skins/Gray/css/form.css\" rel=\"stylesheet\"type=\"text/css\" />\r\n");
      out.write("<link href=\"");
      out.print(basePath);
      out.write("js/ligerUI/skins/Gray/css/common.css\" rel=\"stylesheet\"type=\"text/css\" /> \r\n");
      out.write("<link href=\"");
      out.print(basePath);
      out.write("css/date.css\" rel=\"stylesheet\" type=\"text/css\"/>\r\n");
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
      out.write("<script src=\"");
      out.print(basePath);
      out.write("js/jquery.date_input.pack.js\" type=\"text/javascript\"></script>\r\n");
      out.write("<link rel=\"stylesheet\" href=\"/resources/demos/style.css\">\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\tfunction btnclose() {\r\n");
      out.write("\t\tparent.window.location.reload();\r\n");
      out.write("\t\twindow.close();\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\t$(function(){\r\n");
      out.write("\t  $('#oldDate').date_input();\r\n");
      out.write("   });\r\n");
      out.write("   \r\n");
      out.write("  $(function(){\r\n");
      out.write("\t  $('#newDate').date_input();\r\n");
      out.write("   });\r\n");
      out.write("\t\r\n");
      out.write("\tfunction tonsubmit() {\r\n");
      out.write("\t\tvar reason = $(\"#reason\").val();\r\n");
      out.write("\t\t//alert(reason);\r\n");
      out.write("\t\t//var newnum = $(\"#options\").val();\r\n");
      out.write("\t\tvar newnum = $(\"#options\").val();\r\n");
      out.write("\t\tvar old = $(\"#oldnum\").val();\r\n");
      out.write("\t\tvar oldDate = $(\"#oldDate\").val();\r\n");
      out.write("\t\talert(oldDate);\r\n");
      out.write("\t\tvar newDate = $(\"newDate\").val();\r\n");
      out.write("\t\t//alert(\"test\");\r\n");
      out.write("\t\t/* var str = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/system/Manage_applyCurrAdjustment.action?newnum=\"\r\n");
      out.write("\t\t\t\t+ newnum + \"&oldnum=\" + old + \"&adjustReason=\" + encodeURI(encodeURI(reason)) + \"&oldDate=\" + oldDate\r\n");
      out.write("\t\t\t\t+ \"&newDate=\" + newDate;\r\n");
      out.write("\t\t$.post(str, null, function() {\r\n");
      out.write("\t\t\tparent.m.hide();\r\n");
      out.write("\t\t\tparent.window.location.href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/system/Manage_changecourse.action\";\r\n");
      out.write("\t\t}); */\r\n");
      out.write("\t}\r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("\t<input type=\"hidden\"\r\n");
      out.write("\t\tvalue=");
      out.print((String) ActionContext.getContext().get("old"));
      out.write(" id=\"oldnum\">\r\n");
      out.write("\t<table align=\"center\">\r\n");
      out.write("\t\t");

			List<Syllabus> options = (List<Syllabus>) ActionContext
					.getContext().get("options");
			boolean isfirst = true;
			String number[] = new String[] { "一", "二", "三", "四", "五", "六" };
		
      out.write("\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td align=\"center\">可调换课程或位置\r\n");
      out.write("\t\t\t</td>\r\n");
      out.write("\t\t\t<td height=\"50px\"><select id=\"options\">\r\n");
      out.write("\t\t\t\t\t");

						for (Syllabus s : options) {
							if (isfirst) {
								isfirst = false;
					
      out.write("\r\n");
      out.write("\t\t\t\t\t<option value=");
      out.print(s.getNum());
      out.write(" selected=\"selected\">");
      out.print(new String().format("周%s 第%s大节  %s",
							number[s.getDay()], number[s.getSlot()],
							s.getCourseName()));
      out.write("</option>\r\n");
      out.write("\t\t\t\t\t");

						} else {
					
      out.write("\r\n");
      out.write("\t\t\t\t\t<option value=");
      out.print(s.getNum());
      out.write('>');
      out.print(new String().format("周%s 第%s大节  %s",
							number[s.getDay()], number[s.getSlot()],
							s.getCourseName()));
      out.write("</option>\r\n");
      out.write("\t\t\t\t\t");

						}
						}
					
      out.write("\r\n");
      out.write("\t\t\t</select></td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t<td align=\"center\" class=\"l-table-edit-td\">调课原因:</td>\r\n");
      out.write("\t\t\t<td align=\"left\" class=\"l-table-edit-td\">\r\n");
      out.write("\t\t\t<textarea id=\"reason\" style=\"width:216px; height:126px\"></textarea>\r\n");
      out.write("\t\t\t</td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t<td>原课程日期：</td>\r\n");
      out.write("\t\t\t<td><input type=\"text\" id=\"oldDate\"></td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t<td>调换课程日期：</td>\r\n");
      out.write("\t\t\t<td><input type=\"text\" id=\"newDate\"></td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t<td align=\"center\"><input type=\"button\" onclick=\"tonsubmit()\"\r\n");
      out.write("\t\t\t\tvalue=\"确认\" />\r\n");
      out.write("\t\t\t</td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t</table>\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
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
