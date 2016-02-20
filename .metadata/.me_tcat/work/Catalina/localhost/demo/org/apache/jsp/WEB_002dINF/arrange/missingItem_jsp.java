package org.apache.jsp.WEB_002dINF.arrange;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;
import com.opensymphony.xwork2.ActionContext;

public final class missingItem_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html;charset=UTF8");
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
      out.write("    <title>My JSP 'missingItem.jsp' starting page</title>\r\n");
      out.write("    \r\n");
      out.write("\t<meta http-equiv=\"pragma\" content=\"no-cache\">\r\n");
      out.write("\t<meta http-equiv=\"cache-control\" content=\"no-cache\">\r\n");
      out.write("\t<meta http-equiv=\"expires\" content=\"0\">    \r\n");
      out.write("\t<meta http-equiv=\"keywords\" content=\"keyword1,keyword2,keyword3\">\r\n");
      out.write("\t<meta http-equiv=\"description\" content=\"This is my page\">\r\n");
      out.write("\t<!--\r\n");
      out.write("\t<link rel=\"stylesheet\" type=\"text/css\" href=\"styles.css\">\r\n");
      out.write("\t-->\r\n");
      out.write("\t\r\n");
      out.write("  </head>\r\n");
      out.write("  \r\n");
      out.write("  <body>\r\n");
      out.write(" \r\n");
      out.write("  \t");

  		Map<String, List<String>> errMsg = (Map<String, List<String>>)ActionContext.getContext().get("errorMsg");
  		String roomtype = "no roomType";
		String lesson = "no lesson";
		String teacher = "no teacher";
		String classes = "no class";
		String elective = "no stunum";
		int count = 0;
		int size = 9;
  	 
      out.write("\r\n");
      out.write("   \t<table>\r\n");
      out.write("   \t\t<tr>\r\n");
      out.write("   \t\t\t<td><h1 style=\"color:red\">注意：</h1></td>\r\n");
      out.write("   \t\t\t<td>由于缺少以下信息无法进行排课，请到相关的设置页面进行设置！</td>\r\n");
      out.write("   \t\t</tr>\r\n");
      out.write("   \t\t");

   				if (errMsg.get(classes).size() > 0){
   		 
      out.write("\r\n");
      out.write("   \t\t<tr>\r\n");
      out.write("   \t\t\t<td valign=\"top\" style=\"font-weight: bold;\">缺少上课班级</td>\r\n");
      out.write("   \t\t\t<td>\r\n");
      out.write("   \t\t\t\r\n");
      out.write("   \t\t\t\t");

   					count = 0;
   					for (String name : errMsg.get(classes)){
   						if (count == size){
   							count = 0;
   				
      out.write("\r\n");
      out.write("   \t\t\t\t\t<br>\r\n");
      out.write("   \t\t\t\t");

   						}
   						count++;
   						
   				
      out.write("\r\n");
      out.write("   \t\t\t\t\t");
      out.print(name );
      out.write("\r\n");
      out.write("   \t\t\t\t");

   					}
   				 
      out.write("\r\n");
      out.write("   \t\t\t\r\n");
      out.write("   \t\t\t</td>\r\n");
      out.write("   \t\t</tr>\r\n");
      out.write("   \t\t");
		} 
      out.write("\r\n");
      out.write("   \t\t");

   				if (errMsg.get(lesson).size() > 0){
   		 
      out.write("\r\n");
      out.write("   \t\t<tr>\r\n");
      out.write("   \t\t\t<td valign=\"top\" style=\"font-weight: bold;\">缺少课时信息</td>\r\n");
      out.write("   \t\t\t<td>\r\n");
      out.write("   \t\t\t\r\n");
      out.write("   \t\t\t\t");

   					count = 0;
   					for (String name : errMsg.get(lesson)){
   						if (count == size){
   							count = 0;
   				
      out.write("\r\n");
      out.write("   \t\t\t\t\t<br>\r\n");
      out.write("   \t\t\t\t");

   						}
   						count++;
   						
   				
      out.write("\r\n");
      out.write("   \t\t\t\t\t");
      out.print(name );
      out.write("\r\n");
      out.write("   \t\t\t\t");

   					}
   				 
      out.write("\r\n");
      out.write("   \t\t\t\r\n");
      out.write("   \t\t\t</td>\r\n");
      out.write("   \t\t</tr>\r\n");
      out.write("   \t\t");
		} 
      out.write("\r\n");
      out.write("   \t\t");

   				if (errMsg.get(roomtype).size() > 0){
   		 
      out.write("\r\n");
      out.write("   \t\t<tr>\r\n");
      out.write("   \t\t\t<td valign=\"top\" style=\"font-weight: bold;\">缺少教室类型</td>\r\n");
      out.write("   \t\t\t<td>\r\n");
      out.write("   \t\t\t\r\n");
      out.write("   \t\t\t\t");

   					count = 0;
   					for (String name : errMsg.get(roomtype)){
   						if (count == size){
   							count = 0;
   				
      out.write("\r\n");
      out.write("   \t\t\t\t\t<br>\r\n");
      out.write("   \t\t\t\t");

   						}
   						count++;
   						
   				
      out.write("\r\n");
      out.write("   \t\t\t\t\t");
      out.print(name );
      out.write("\r\n");
      out.write("   \t\t\t\t");

   					}
   				 
      out.write("\r\n");
      out.write("   \t\t\t\r\n");
      out.write("   \t\t\t</td>\r\n");
      out.write("   \t\t</tr>\r\n");
      out.write("   \t\t");
		} 
      out.write("\r\n");
      out.write("   \t\t");

   				if (errMsg.get(teacher).size() > 0){
   		 
      out.write("\r\n");
      out.write("   \t\t<tr>\r\n");
      out.write("   \t\t\t<td valign=\"top\" style=\"font-weight: bold;\">缺少上课教师信息</td>\r\n");
      out.write("   \t\t\t<td>\r\n");
      out.write("   \t\t\t\r\n");
      out.write("   \t\t\t\t");

   					count = 0;
   					for (String name : errMsg.get(teacher)){
   						if (count == size){
   							count = 0;
   				
      out.write("\r\n");
      out.write("   \t\t\t\t\t<br>\r\n");
      out.write("   \t\t\t\t");

   						}
   						count++;
   						
   				
      out.write("\r\n");
      out.write("   \t\t\t\t\t");
      out.print(name );
      out.write("\r\n");
      out.write("   \t\t\t\t");

   					}
   				 
      out.write("\r\n");
      out.write("   \t\t\t</td>\r\n");
      out.write("   \t\t</tr>\r\n");
      out.write("   \t\t");
} 
      out.write("\r\n");
      out.write("   \t\t");

   				if (errMsg.get(roomtype).size() > 0){
   		 
      out.write("\r\n");
      out.write("   \t\t<tr>\r\n");
      out.write("   \t\t\t<td valign=\"top\" style=\"font-weight: bold;\">缺少教室类型</td>\r\n");
      out.write("   \t\t\t<td>\r\n");
      out.write("   \t\t\t\r\n");
      out.write("   \t\t\t\t");

   					count = 0;
   					for (String name : errMsg.get(roomtype)){
   						if (count == size){
   							count = 0;
   				
      out.write("\r\n");
      out.write("   \t\t\t\t\t<br>\r\n");
      out.write("   \t\t\t\t");

   						}
   						count++;
   						
   				
      out.write("\r\n");
      out.write("   \t\t\t\t\t");
      out.print(name );
      out.write("\r\n");
      out.write("   \t\t\t\t");

   					}
   				 
      out.write("\r\n");
      out.write("   \t\t\t\r\n");
      out.write("   \t\t\t</td>\r\n");
      out.write("   \t\t</tr>\r\n");
      out.write("   \t\t");
		} 
      out.write("\r\n");
      out.write("   \t\t");

   				if (errMsg.get(elective).size() > 0){
   		 
      out.write("\r\n");
      out.write("   \t\t<tr>\r\n");
      out.write("   \t\t\t<td valign=\"top\" style=\"font-weight: bold;\">任选课缺少最大选课人数信息</td>\r\n");
      out.write("   \t\t\t<td>\r\n");
      out.write("   \t\t\t\r\n");
      out.write("   \t\t\t\t");

   					count = 0;
   					for (String name : errMsg.get(elective)){
   						if (count == size){
   							count = 0;
   				
      out.write("\r\n");
      out.write("   \t\t\t\t\t<br>\r\n");
      out.write("   \t\t\t\t");

   						}
   						count++;
   						
   				
      out.write("\r\n");
      out.write("   \t\t\t\t\t");
      out.print(name );
      out.write("\r\n");
      out.write("   \t\t\t\t");

   					}
   				 
      out.write("\r\n");
      out.write("   \t\t\t</td>\r\n");
      out.write("   \t\t</tr>\r\n");
      out.write("   \t\t");
} 
      out.write("\r\n");
      out.write("   \t</table>\r\n");
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
