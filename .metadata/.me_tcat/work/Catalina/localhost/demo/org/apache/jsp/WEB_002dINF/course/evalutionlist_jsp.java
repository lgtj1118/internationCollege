package org.apache.jsp.WEB_002dINF.course;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;

public final class evalutionlist_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\r\n");
      out.write("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<base href=\"");
      out.print(basePath);
      out.write("\">\r\n");
      out.write("<title>天津工业大学国际教育学院教学服务系统</title>\r\n");
      out.write("<link href=\"");
      out.print(basePath);
      out.write("js/ligerUI/skins/Gray/css/form.cssrel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("<link href=\"");
      out.print(basePath);
      out.write("js/ligerUI/skins/Gray/css/common.css\"rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("<script src=\"");
      out.print(basePath);
      out.write("js/jquery/jquery-1.3.2.min.js\"type=\"text/javascript\"></script>\r\n");
      out.write("<script src=\"");
      out.print(basePath);
      out.write("js/ligerUI/core/base.js\"type=\"text/javascript\"></script>\r\n");
      out.write("<script src=\"");
      out.print(basePath);
      out.write("js/ligerUI/ligerui.all.js\"type=\"text/javascript\"></script>\r\n");
      out.write("<script src=\"");
      out.print(basePath);
      out.write("js/jquery-validation/jquery.validate.min.js\"type=\"text/javascript\"></script>\r\n");
      out.write("<script src=\"");
      out.print(basePath);
      out.write("js/jquery-validation/jquery.metadata.js\"type=\"text/javascript\"></script>\r\n");
      out.write("<script src=\"");
      out.print(basePath);
      out.write("js/jquery-validation/messages_cn.js\"type=\"text/javascript\"></script>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\tvar eee;\r\n");
      out.write("\t$(function(){\r\n");
      out.write("\t\t$.metadata.setType(\"attr\", \"validate\");\r\n");
      out.write("\t\tvar v = $(\"form\").validate({\r\n");
      out.write("\t\t\t\tdebug : true,\r\n");
      out.write("\t\t\t\terrorPlacement : function(lable , element){\r\n");
      out.write("\t\t\t\t\tif (element.hasClass(\"l-textarea\")) {\r\n");
      out.write("\t\t\t\t\t\telement.ligerTip({\r\n");
      out.write("\t\t\t\t\t\t\tcontent : lable.html(),\r\n");
      out.write("\t\t\t\t\t\t\ttarget : element[0]\r\n");
      out.write("\t\t\t\t\t\t});\r\n");
      out.write("\t\t\t\t\t} else if (element.hasClass(\"l-text-field\")) {\r\n");
      out.write("\t\t\t\t\t\telement.parent().ligerTip({\r\n");
      out.write("\t\t\t\t\t\t\tcontent : lable.html(),\r\n");
      out.write("\t\t\t\t\t\t\ttarget : element[0]\r\n");
      out.write("\t\t\t\t\t\t});\r\n");
      out.write("\t\t\t\t\t} else {\r\n");
      out.write("\t\t\t\t\t\tlable.appendTo(element.parents(\"td:first\").next(\"td\"));\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t},\r\n");
      out.write("\t\t\t\tsuccess : function(lable){\r\n");
      out.write("\t\t\t\t\tlable.ligerHideTip();\r\n");
      out.write("\t\t\t\t\tlable.remove();\r\n");
      out.write("\t\t\t\t},\r\n");
      out.write("\t\t\t\tsubmitHandler : function(){\r\n");
      out.write("\t\t\t\t\t$(\"form .l-text,.l-textarea\").ligerHideTip();\r\n");
      out.write("\t\t\t\t\tvar val1=$('input:radio[name=\"incicators1\"]:checked').val();\r\n");
      out.write("\t\t\t\t\tvar val2=$('input:radio[name=\"incicators2\"]:checked').val();\r\n");
      out.write("\t\t\t\t\tvar val3=$('input:radio[name=\"incicators3\"]:checked').val();\r\n");
      out.write("\t\t\t\t\tvar val4=$('input:radio[name=\"incicators4\"]:checked').val();\r\n");
      out.write("\t\t\t\t\tvar val5=$('input:radio[name=\"incicators5\"]:checked').val();\r\n");
      out.write("\t\t\t\t\tvar val6=$('input:radio[name=\"incicators6\"]:checked').val();\r\n");
      out.write("\t\t\t\t\tvar val7=$('input:radio[name=\"incicators7\"]:checked').val();\r\n");
      out.write("\t\t\t\t\t//var val8=$('input:radio[name=\"summary\"]:checked').val();\r\n");
      out.write("\t\t\t\t\tif((val1==null)||(val2==null)||(val3==null)||(val4==null)||(val5==null)||(val6==null)||(val7==null)){alert('请全部选中');return false;}\r\n");
      out.write("\t\t\t\t\telse{\r\n");
      out.write("\t\t\t\t\t  $.post(\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/system/Manage_evalutionteacheradd.action?evalution.courseid=\" + encodeURI(encodeURI($(\"#courseid\").val()))\r\n");
      out.write("\t\t\t\t\t   + \"&evalution.teacher=\" + encodeURI(encodeURI($(\"#teacher\").val()))\r\n");
      out.write("\t\t\t\t\t   + \"&evalution.incicators1=\" + val1\r\n");
      out.write("\t\t\t\t\t   + \"&evalution.incicators2=\" + val2\r\n");
      out.write("\t\t\t\t\t   + \"&evalution.incicators3=\" + val3\r\n");
      out.write("\t\t\t\t\t   + \"&evalution.incicators4=\" + val4\r\n");
      out.write("\t\t\t\t\t   + \"&evalution.incicators5=\" + val5\r\n");
      out.write("\t\t\t\t\t   + \"&evalution.incicators6=\" + val6\r\n");
      out.write("\t\t\t\t\t   + \"&evalution.incicators7=\" + val7\r\n");
      out.write("\t\t\t\t\t  // + \"&evalution.summary=\" + val8\r\n");
      out.write("\t\t\t\t\t   + \"&evalution.extrude=\" + encodeURI(encodeURI($(\"#extrude\").val()))\r\n");
      out.write("\t\t\t\t\t   + \"&evalution.advice=\" + encodeURI(encodeURI($(\"#advice\").val()))\t\t\t\t\t   \r\n");
      out.write("\t\t\t\t\t   , null, function(){\r\n");
      out.write("\t\t\t\t\t      \talert('评价成功!');\t\r\n");
      out.write("\t\t\t\t\t       document.getElementById(\"Button1\").value=\"已提交\";\t\r\n");
      out.write("\t\t\t\t\t       document.getElementById(\"Button1\").disabled=true;\r\n");
      out.write("\t\t\t\t\t       top.f_closeTab();\t\r\n");
      out.write("\t\t\t\t\t\t}); \r\n");
      out.write("\t\t\t\t\t}\t\t\t\t\t\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t$(\"form\").ligerForm();\r\n");
      out.write("\t\t$(\".l-button-test\").click(function(){\r\n");
      out.write("\t\t\talert(v.element($(\"#txtName\")));\r\n");
      out.write("\t\t});\r\n");
      out.write("\t});\r\n");
      out.write("\tvar i = 30;\r\n");
      out.write("\tvar intervalid;\r\n");
      out.write("\tintervalid = setInterval(\"fun()\", 1000);\r\n");
      out.write("\tfunction fun(){\r\n");
      out.write("\t\tif (i == 0) {\r\n");
      out.write("\t\t\tdocument.getElementById(\"Button1\").disabled=false;\r\n");
      out.write("\t\t\tdocument.getElementById(\"mes\").style.display=\"none\";\r\n");
      out.write("\t\t\tdocument.getElementById(\"mes1\").style.display=\"none\";\r\n");
      out.write("\t\t\tclearInterval(intervalid);\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tdocument.getElementById(\"mes\").innerHTML = i;\r\n");
      out.write("\t\ti--;\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("</script>\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write("#content {\r\n");
      out.write("\twidth: 90%;\r\n");
      out.write("\ttext-align: center;\r\n");
      out.write("}\r\n");
      out.write("table {\r\n");
      out.write("\tmargin: 10px 50px auto;\r\n");
      out.write("\twidth: 100%;\r\n");
      out.write("\tborder-collapse:collapse;\r\n");
      out.write("\tborder: 2px solid #d7d7d7;\r\n");
      out.write("}\r\n");
      out.write("table td,th{\r\n");
      out.write("   border:2px solid #d7d7d7;\r\n");
      out.write("   margin: 5px 2px 5px;\r\n");
      out.write("   text-align: center;\r\n");
      out.write("   padding: 5px 10px;\r\n");
      out.write("   font-size: 14px;\r\n");
      out.write("}\r\n");
      out.write("textarea {\r\n");
      out.write("\twidth: 100%;\r\n");
      out.write("\theight:60px;\r\n");
      out.write("}\r\n");
      out.write("label{\r\n");
      out.write("  width: 100%;\r\n");
      out.write("  height: 20px;\r\n");
      out.write("}\r\n");
      out.write("input {\r\n");
      out.write("\twidth: 100%;\r\n");
      out.write("\theight: 20px;\r\n");
      out.write("\t\r\n");
      out.write("}\r\n");
      out.write(".tabletd{\r\n");
      out.write("   text-align: left;\r\n");
      out.write("   margin-left: 10px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("</style>\r\n");
      out.write("</head>\r\n");
      out.write("<body onload=\"fun()\">\r\n");
      out.write("\t<div id=\"contain\">\r\n");
      out.write("\t\t<div id=\"content\">\r\n");
      out.write("\t\t\t<form name=\"form1\" method=\"post\" action=\"\" id=\"form1\">\r\n");
      out.write("\t\t\t<input type=\"hidden\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${courses.num }", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\" id=\"courseid\"/>\r\n");
      out.write("\t\t\t\t<table>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<th colspan=\"6\" height=\"100px\"><font size=\"5\" face=\"微软雅黑\">对外汉语课程教学质量调查表（试用）</font><br>\r\n");
      out.write("\t\t\t\t\t\t<br> <span align=\"cnter\"> 天津工业大学  &nbsp;&nbsp; 国际教育学院 &nbsp; &nbsp; </span></th>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<th rowspan=\"3\" width=\"80px\">指 标</td>\r\n");
      out.write("\t\t\t\t\t\t<td>课程名称</td><th colspan=\"4\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${courses.coursename}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("</th>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td>任课教师</td><th colspan=\"4\"><input value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${te.identificationnum }", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\" id=\"teacher\" type=\"hidden\" />");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${te.teachername }", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("</th>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td>内涵/评价等级</td>\r\n");
      out.write("\t\t\t\t\t\t<td >优秀≥90</td>\r\n");
      out.write("\t\t\t\t\t\t<td >良好≥75</td>\r\n");
      out.write("\t\t\t\t\t\t<td >及格≥60</td>\r\n");
      out.write("\t\t\t\t\t\t<td >不及格<60</td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td>教学态度</td>\r\n");
      out.write("\t\t\t\t\t\t<td class=\"tabletd\">备课充分，讲课认真</td>\r\n");
      out.write("\t\t\t\t\t\t<td ><label><input name=\"incicators1\" type=\"radio\" value=\"1\" align=\"center\" /></label> </td>\r\n");
      out.write("\t\t\t\t\t\t<td><label><input name=\"incicators1\" type=\"radio\" value=\"2\" /></label> </td>\r\n");
      out.write("\t\t\t\t\t\t<td><label><input name=\"incicators1\" type=\"radio\" value=\"3\" /></label> </td>\r\n");
      out.write("\t\t\t\t\t\t<td><label><input name=\"incicators1\" type=\"radio\" value=\"4\" /></label> </td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td>因材施教</td>\r\n");
      out.write("\t\t\t\t\t\t<td class=\"tabletd\">针对留学生的不同特点进行教学</td>\r\n");
      out.write("\t\t\t\t\t\t<td><label><input name=\"incicators2\" type=\"radio\" value=\"1\" /></label> </td>\r\n");
      out.write("\t\t\t\t\t\t<td><label><input name=\"incicators2\" type=\"radio\" value=\"2\" /></label> </td>\r\n");
      out.write("\t\t\t\t\t\t<td><label><input name=\"incicators2\" type=\"radio\" value=\"3\" /></label> </td>\r\n");
      out.write("\t\t\t\t\t\t<td><label><input name=\"incicators2\" type=\"radio\" value=\"4\" /></label> </td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td>教学内容</td>\r\n");
      out.write("\t\t\t\t\t\t<td class=\"tabletd\">精选教学内容，突出重点难点</td>\r\n");
      out.write("\t\t\t\t\t\t<td><label><input name=\"incicators3\" type=\"radio\" value=\"1\" /></label> </td>\r\n");
      out.write("\t\t\t\t\t\t<td><label><input name=\"incicators3\" type=\"radio\" value=\"2\" /></label> </td>\r\n");
      out.write("\t\t\t\t\t\t<td><label><input name=\"incicators3\" type=\"radio\" value=\"3\" /></label> </td>\r\n");
      out.write("\t\t\t\t\t\t<td><label><input name=\"incicators3\" type=\"radio\" value=\"4\" /></label> </td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td>语言板书</td>\r\n");
      out.write("\t\t\t\t\t\t<td class=\"tabletd\">发音标准，语言精练生动、富于启发性、板书规范、层次分明</td>\r\n");
      out.write("\t\t\t\t\t\t<td><label><input name=\"incicators4\" type=\"radio\" value=\"1\" /></label> </td>\r\n");
      out.write("\t\t\t\t\t\t<td><label><input name=\"incicators4\" type=\"radio\" value=\"2\" /></label> </td>\r\n");
      out.write("\t\t\t\t\t\t<td><label><input name=\"incicators4\" type=\"radio\" value=\"3\" /></label> </td>\r\n");
      out.write("\t\t\t\t\t\t<td><label><input name=\"incicators4\" type=\"radio\" value=\"4\" /></label> </td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td>教学方法</td>\r\n");
      out.write("\t\t\t\t\t\t<td class=\"tabletd\">根据课程特点，精心设计情景教学、增加会话机会、提高理解和语言表达能力</td>\r\n");
      out.write("\t\t\t\t\t\t<td><label><input name=\"incicators5\" type=\"radio\" value=\"1\" /></label> </td>\r\n");
      out.write("\t\t\t\t\t\t<td><label><input name=\"incicators5\" type=\"radio\" value=\"2\" /></label> </td>\r\n");
      out.write("\t\t\t\t\t\t<td><label><input name=\"incicators5\" type=\"radio\" value=\"3\" /></label> </td>\r\n");
      out.write("\t\t\t\t\t\t<td><label><input name=\"incicators5\" type=\"radio\" value=\"4\" /></label> </td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td>教学效果</td>\r\n");
      out.write("\t\t\t\t\t\t<td class=\"tabletd\">通过课程学习，汉语知识明显长进，具有一定的听、说、读、写能力</td>\r\n");
      out.write("\t\t\t\t\t\t<td><label><input name=\"incicators6\" type=\"radio\" value=\"1\" /></label> </td>\r\n");
      out.write("\t\t\t\t\t\t<td><label><input name=\"incicators6\" type=\"radio\" value=\"2\" /></label> </td>\r\n");
      out.write("\t\t\t\t\t\t<td><label><input name=\"incicators6\" type=\"radio\" value=\"3\" /></label> </td>\r\n");
      out.write("\t\t\t\t\t\t<td><label><input name=\"incicators6\" type=\"radio\" value=\"4\" /></label> </td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td>综合评价</td>\r\n");
      out.write("\t\t\t\t\t\t<td class=\"tabletd\">对任课教师的总印象</td>\r\n");
      out.write("\t\t\t\t\t\t<td><label><input name=\"incicators7\" type=\"radio\" value=\"1\" /></label> </td>\r\n");
      out.write("\t\t\t\t\t\t<td><label><input name=\"incicators7\" type=\"radio\" value=\"2\" /></label> </td>\r\n");
      out.write("\t\t\t\t\t\t<td><label><input name=\"incicators7\" type=\"radio\" value=\"3\" /></label> </td>\r\n");
      out.write("\t\t\t\t\t\t<td><label><input name=\"incicators7\" type=\"radio\" value=\"4\" /></label> </td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<!-- <tr>\r\n");
      out.write("\t\t\t\t\t\t<th colspan=\"2\">合计（分）\r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t<td><label><input name=\"summary\"  type=\"radio\" value=\"1\" /></label> </td>\r\n");
      out.write("\t\t\t\t\t\t<td><label><input name=\"summary\"  type=\"radio\" value=\"2\" /></label> </td>\r\n");
      out.write("\t\t\t\t\t\t<td><label><input name=\"summary\"  type=\"radio\" value=\"3\" /></label> </td>\r\n");
      out.write("\t\t\t\t\t\t<td><label><input name=\"summary\"  type=\"radio\" value=\"4\" /></label> </td>\r\n");
      out.write("\t\t\t\t\t</tr> -->\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<th colspan=\"2\">突出优点或问题</td>\r\n");
      out.write("\t\t\t\t\t\t<th colspan=\"4\"><textarea id=\"extrude\" placeholder=\"请输入优点或问题\"></textarea></th>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<th colspan=\"2\">建议与希望</td>\r\n");
      out.write("\t\t\t\t\t\t<th colspan=\"4\"><textarea id=\"advice\" placeholder=\"建议与希望\"></textarea></th>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<th colspan=\"6\" class=\"tabletd\" style=\"font-size: 12px;\">注：请选择认定分数的栏目</th>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t</table>\r\n");
      out.write("\t\t\t\t<input type=\"submit\" value=\"提&nbsp;&nbsp;交\" id=\"Button1\" disabled=\"disabled\" align=\"center\" class=\"l-button l-button-submit\"  ></input><span id=\"mes\" style=\"color: #D7d7d7\" >30</span ><span id=\"mes1\" style=\"color: #D7d7d7\">秒后可操作</span>\r\n");
      out.write("\t\t\t</form>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t</div>\r\n");
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
