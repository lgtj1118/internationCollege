package org.apache.jsp.WEB_002dINF.arrange;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;
import com.tjpu.bean.Syllabus;
import com.opensymphony.xwork2.ActionContext;

public final class newChangeCourseApply_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("    <script src=\"");
      out.print(basePath);
      out.write("js/jquery/jquery-1.6.min.js\" type=\"text/javascript\"></script>\r\n");
      out.write("    <link href=\"");
      out.print(basePath);
      out.write("js/ligerUI/skins/Aqua/css/ligerui-all.css\" rel=\"stylesheet\"type=\"text/css\" />\t\r\n");
      out.write("\t<link href=\"");
      out.print(basePath );
      out.write("js/ligerUI/skins/Gray/css/all.css\" rel=\"stylesheet\" type=\"text/css\"/>\t\r\n");
      out.write("    <link href=\"");
      out.print(basePath);
      out.write("css/date.css\" rel=\"stylesheet\" type=\"text/css\"/>\r\n");
      out.write("    <script src=\"");
      out.print(basePath);
      out.write("js/ligerUI/core/base.js\" type=\"text/javascript\"></script>\r\n");
      out.write("    <script src=\"");
      out.print(basePath);
      out.write("js/ligerUI/plugins/ligerDateEditor.js\" type=\"text/javascript\"></script>\r\n");
      out.write("\t<script src=\"");
      out.print(basePath);
      out.write("js/jquery.date_input.pack.js\" type=\"text/javascript\"></script>\r\n");
      out.write("\t<link href=\"");
      out.print(basePath);
      out.write("js/ligerUI/skins/Gray/css/form.css\"rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("\t<link href=\"");
      out.print(basePath);
      out.write("js/ligerUI/skins/Gray/css/common.css\"rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("\t<link href=\"");
      out.print(basePath);
      out.write("css/date.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("\t<style type=\"text/css\">\r\n");
      out.write("body {\r\n");
      out.write("\tfont-size: 12px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".l-table-edit {\r\n");
      out.write("\t\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".l-table-edit-td {\r\n");
      out.write("\tpadding: 4px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".l-button-submit,.l-button-test {\r\n");
      out.write("\twidth: 80px;\r\n");
      out.write("\tfloat: left;\r\n");
      out.write("\tmargin-left: 10px;\r\n");
      out.write("\tpadding-bottom: 2px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".l-verify-tip {\r\n");
      out.write("\tleft: 230px;\r\n");
      out.write("\ttop: 120px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("#errorLabelContainer {\r\n");
      out.write("\tpadding: 10px;\r\n");
      out.write("\twidth: 300px;\r\n");
      out.write("\tborder: 1px solid #FF4466;\r\n");
      out.write("\tdisplay: none;\r\n");
      out.write("\tbackground: #FFEEEE;\r\n");
      out.write("\tcolor: Red;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".link {\r\n");
      out.write("\twidth: 170px;\r\n");
      out.write("\theight: 25px;\r\n");
      out.write("\tbackground: #fefefe;\r\n");
      out.write("\tborder: 1px solid #bbb;\r\n");
      out.write("\tfont-size: 12px;\r\n");
      out.write("\tcolor: #333;\r\n");
      out.write("\tborder-radius: 3px;\r\n");
      out.write("}\r\n");
      out.write("/* .date_selector .month_nav{float: left;width: 40%;}\r\n");
      out.write(".date_selector .year_nav{float: right;width: 35%;margin-right: 60px;} */\r\n");
      out.write("textarea {\r\n");
      out.write("\twidth: 100%;\r\n");
      out.write("\theight: 100px;\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("  </head>\r\n");
      out.write("  <script type=\"text/javascript\">\r\n");
      out.write("\t\t$(document).ready(function(){\r\n");
      out.write("\t\t\t//alert(\"here\");\r\n");
      out.write("\t\t\t//$(\"#oldCourseName\").change(selectChange());\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t$(function() {\r\n");
      out.write("\t\t\t$('.date_picker').date_input();\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\tfunction tchange() {\r\n");
      out.write("\t\t\t$(\"#oldSlot\").empty();\r\n");
      out.write("\t\t\t$(\"#origndate\").val(\"\");\r\n");
      out.write("\t\t\t//alert(\"here\");\r\n");
      out.write("\t\t\t/* $(\"#oldSlot\").empty();\r\n");
      out.write("\t\t\tvar id = $(\"#oldCourseName\").val();\r\n");
      out.write("\t\t\tvar url = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/system/Manage_getCourseSlot.action?oldnum=\" + id;\r\n");
      out.write("\t\t\t$.ajax({  \r\n");
      out.write("\t\t        type : \"POST\",  \r\n");
      out.write("\t\t        url : url,\r\n");
      out.write("\t\t        dataType : \"JSON\", \r\n");
      out.write("\t\t        error: function (){\r\n");
      out.write("\t\t        \talert(\"error function\");\r\n");
      out.write("\t\t        },\r\n");
      out.write("\t\t        success : function(data) {\r\n");
      out.write("\t\t        \t//alert(data.length); \r\n");
      out.write("\t\t        \t\r\n");
      out.write("\t\t          \tfor(var n=0;n<data.length;n++){\r\n");
      out.write("\t\t                document.getElementById(\"oldSlot\").options.add(new Option(data[n].slot + 1,data[n].slot + 1));\r\n");
      out.write("\t\t          \t} \r\n");
      out.write("\t\t        }  \r\n");
      out.write("\t\t    }); */\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tfunction tchange2() {\r\n");
      out.write("\t\t\t$(\"#newSlot\").empty();\r\n");
      out.write("\t\t\t$(\"#plandate\").val(\"\");\r\n");
      out.write("\t\t\t//alert(\"here\");\r\n");
      out.write("\t\t\t/* $(\"#newSlot\").empty();\r\n");
      out.write("\t\t\tvar id = $(\"#newCourseName\").val();\r\n");
      out.write("\t\t\tvar url = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/system/Manage_getNewCourseSlot.action?oldnum=\" + id;\r\n");
      out.write("\t\t\t$.ajax({  \r\n");
      out.write("\t\t        type : \"POST\",  \r\n");
      out.write("\t\t        url : url,\r\n");
      out.write("\t\t        dataType : \"JSON\", \r\n");
      out.write("\t\t        error: function (){\r\n");
      out.write("\t\t        \talert(\"error function\");\r\n");
      out.write("\t\t        },\r\n");
      out.write("\t\t        success : function(data) {\r\n");
      out.write("\t\t        \t//alert(data.length); \r\n");
      out.write("\t\t        \t\r\n");
      out.write("\t\t          \tfor(var n=0;n<data.length;n++){\r\n");
      out.write("\t\t                document.getElementById(\"newSlot\").options.add(new Option(data[n].slot + 1,data[n].slot + 1));\r\n");
      out.write("\t\t          \t} \r\n");
      out.write("\t\t        }  \r\n");
      out.write("\t\t    }); */\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tfunction origDateChange() {\r\n");
      out.write("\t\t\tif ($(\"#oldCourseName\").val() == -1){\r\n");
      out.write("\t\t\t\talert(\"请先选择课程\");\r\n");
      out.write("\t\t\t\t$(\"#origndate\").val(\"\");\r\n");
      out.write("\t\t\t\treturn;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\tvar orgindate = $(\"#origndate\").val();\r\n");
      out.write("\t\t\tvar thisDate = new Date(orgindate);\r\n");
      out.write("\t\t\tvar oldNum = $(\"#oldCourseName\").val();\r\n");
      out.write("\t\t\tvar today = new Date();\r\n");
      out.write("\t\t\tif (thisDate < today) {\r\n");
      out.write("\t\t\t\talert(\"调课日期不能早于今天！\");\r\n");
      out.write("\t\t\t\t$(\"#origndate\").val(\"\");\r\n");
      out.write("\t\t\t\treturn;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\tvar url = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/system/Manage_chkOldDate.action?origndate=\" + orgindate\r\n");
      out.write("\t\t\t\t\t+ \"&oldnum=\" + oldNum;\r\n");
      out.write("\t\t\t$.ajax({  \r\n");
      out.write("\t\t        type : \"POST\",  \r\n");
      out.write("\t\t        url : url,\r\n");
      out.write("\t\t        dataType : \"JSON\", \r\n");
      out.write("\t\t        error: function (){\r\n");
      out.write("\t\t        \talert(\"error function\");\r\n");
      out.write("\t\t        },\r\n");
      out.write("\t\t        success : function(data) {\r\n");
      out.write("\t\t        \t//alert(data.length);\r\n");
      out.write("\t\t        \t$(\"#oldSlot\").empty(); \r\n");
      out.write("\t\t        \tif (data.length > 0){\r\n");
      out.write("\t\t        \t\tfor(var n=0;n<data.length;n++){\r\n");
      out.write("\t\t        \t\t\t\r\n");
      out.write("\t\t                \tdocument.getElementById(\"oldSlot\").options.add(new Option(data[n].slot + 1,data[n].slot + 1));\r\n");
      out.write("\t\t          \t\t} \r\n");
      out.write("\t\t          \t\tgetOldroom(); \r\n");
      out.write("\t\t        \t} else {\r\n");
      out.write("\t\t        \t\t//$(\"#origDateChk\").attr(\"value\",\"no\");\r\n");
      out.write("\t\t        \t\talert(\"当天没有该课程\");\r\n");
      out.write("\t\t        \t\t$(\"#origndate\").val(\"\");\r\n");
      out.write("\t\t        \t}\r\n");
      out.write("\t\t        }  \r\n");
      out.write("\t\t    }); \r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tfunction planDateChange() {\r\n");
      out.write("\t\t\t//alert($(\"#newCourseName\").val());\r\n");
      out.write("\t\t\tif ($(\"#newCourseName\").val() == -1){\r\n");
      out.write("\t\t\t\talert(\"请先选择课程\");\r\n");
      out.write("\t\t\t\t$(\"#plandate\").val(\"\");\r\n");
      out.write("\t\t\t\treturn;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\tvar plandate = $(\"#plandate\").val();\r\n");
      out.write("\t\t\tvar thisDate = new Date(plandate);\r\n");
      out.write("\t\t\tvar newNum = $(\"#newCourseName\").val();\r\n");
      out.write("\t\t\tvar today = new Date();\r\n");
      out.write("\t\t\t//alert(thisDate);\r\n");
      out.write("\t\t\t//alert(today);\r\n");
      out.write("\t\t\tif (thisDate < today) {\r\n");
      out.write("\t\t\t\talert(\"日期不能早于今天\");\r\n");
      out.write("\t\t\t\t$(\"#plandate\").val(\"\");\r\n");
      out.write("\t\t\t\treturn;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\tvar url = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/system/Manage_chkNewDate.action?plandate=\" + plandate\r\n");
      out.write("\t\t\t\t\t+ \"&newnum=\" + newNum;\r\n");
      out.write("\t\t\t$.ajax({  \r\n");
      out.write("\t\t        type : \"POST\",  \r\n");
      out.write("\t\t        url : url,\r\n");
      out.write("\t\t        dataType : \"JSON\", \r\n");
      out.write("\t\t        error: function (){\r\n");
      out.write("\t\t        \talert(\"数据传输错误，请联系管理员！\");\r\n");
      out.write("\t\t        },\r\n");
      out.write("\t\t        success : function(data) {\r\n");
      out.write("\t\t        \t//alert(data.length);\r\n");
      out.write("\t\t        \t$(\"#newSlot\").empty(); \r\n");
      out.write("\t\t        \tif (data.length > 0){\r\n");
      out.write("\t\t        \t\tfor(var n=0;n<data.length;n++){\r\n");
      out.write("\t\t                \tdocument.getElementById(\"newSlot\").options.add(new Option(data[n].slot + 1,data[n].slot + 1));\r\n");
      out.write("\t\t          \t\t}\r\n");
      out.write("\t\t          \t\tgetNewroom();\r\n");
      out.write("\t\t        \t} else {\r\n");
      out.write("\t\t        \t\t//$(\"#origDateChk\").attr(\"value\",\"no\");\r\n");
      out.write("\t\t        \t\talert(\"当天没有该课程\");\r\n");
      out.write("\t\t        \t\t$(\"#plandate\").val(\"\");\r\n");
      out.write("\t\t        \t}\r\n");
      out.write("\t\t        }  \r\n");
      out.write("\t\t    }); \r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tfunction getOldroom (){\r\n");
      out.write("\t\t\tvar num = $(\"#oldCourseName\").val();\r\n");
      out.write("\t\t\tvar slot = $(\"#oldSlot\").val();\r\n");
      out.write("\t\t\tvar url = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/system/Manage_getOldroom.action?oldSlot=\" + slot;\r\n");
      out.write("\t\t\t$.ajax({  \r\n");
      out.write("\t\t        type : \"POST\",  \r\n");
      out.write("\t\t        url : url,\r\n");
      out.write("\t\t        dataType : \"JSON\", \r\n");
      out.write("\t\t        error: function (){\r\n");
      out.write("\t\t        \talert(\"数据传输错误，请联系管理员！\");\r\n");
      out.write("\t\t        },\r\n");
      out.write("\t\t        success : function(data) {\r\n");
      out.write("\t\t        \t//alert(data.length);\r\n");
      out.write("\t\t        \t$(\"#origRoom\").empty(); \r\n");
      out.write("\t\t        \tif (data.length > 0){\r\n");
      out.write("\t\t        \t\tfor(var n=0;n<data.length;n++){\r\n");
      out.write("\t\t                \tdocument.getElementById(\"origRoom\").options.add(new Option(data[n].note,data[n].roomNum));\r\n");
      out.write("\t\t          \t\t}\r\n");
      out.write("\t\t        \t} else {\r\n");
      out.write("\t\t        \t\t//$(\"#origDateChk\").attr(\"value\",\"no\");\r\n");
      out.write("\t\t        \t\t/* alert(\"当天没有该课程\");\r\n");
      out.write("\t\t        \t\t$(\"#plandate\").val(\"\"); */\r\n");
      out.write("\t\t        \t}\r\n");
      out.write("\t\t        }  \r\n");
      out.write("\t\t    }); \r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tfunction getNewroom(){\r\n");
      out.write("\t\t\tvar num = $(\"#newCourseName\").val();\r\n");
      out.write("\t\t\tvar slot = $(\"#newSlot\").val();\r\n");
      out.write("\t\t\tvar url = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/system/Manage_getNewroom.action?newSlot=\" + slot;\r\n");
      out.write("\t\t\t$.ajax({  \r\n");
      out.write("\t\t        type : \"POST\",  \r\n");
      out.write("\t\t        url : url,\r\n");
      out.write("\t\t        dataType : \"JSON\", \r\n");
      out.write("\t\t        error: function (){\r\n");
      out.write("\t\t        \talert(\"数据传输错误，请联系管理员！\");\r\n");
      out.write("\t\t        },\r\n");
      out.write("\t\t        success : function(data) {\r\n");
      out.write("\t\t        \t//alert(data.length);\r\n");
      out.write("\t\t        \t$(\"#planRoom\").empty(); \r\n");
      out.write("\t\t        \tif (data.length > 0){\r\n");
      out.write("\t\t        \t\tfor(var n=0;n<data.length;n++){\r\n");
      out.write("\t\t                \tdocument.getElementById(\"planRoom\").options.add(new Option(data[n].note,data[n].roomNum));\r\n");
      out.write("\t\t          \t\t}\r\n");
      out.write("\t\t        \t} else {\r\n");
      out.write("\t\t        \t\t//$(\"#origDateChk\").attr(\"value\",\"no\");\r\n");
      out.write("\t\t        \t\t/* alert(\"当天没有该课程\");\r\n");
      out.write("\t\t        \t\t$(\"#plandate\").val(\"\"); */\r\n");
      out.write("\t\t        \t}\r\n");
      out.write("\t\t        }  \r\n");
      out.write("\t\t    }); \r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tfunction tosubmit(){\r\n");
      out.write("\t\t\tvar newNum = $(\"#newCourseName\").val();\r\n");
      out.write("\t\t\tvar oldNum = $(\"#oldCourseName\").val();\r\n");
      out.write("\t\t\tvar reason = $(\"#reason\").val();\r\n");
      out.write("\t\t\tvar oldroom = $(\"#origRoom \").val();\r\n");
      out.write("\t\t\tvar newroom = $(\"#planRoom\").val();\r\n");
      out.write("\t\t\tif (newNum == -1 || oldNum == -1){\r\n");
      out.write("\t\t\t\talert(\"请选择课程\");\r\n");
      out.write("\t\t\t\treturn;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\tif (reason == \"\"){\r\n");
      out.write("\t\t\t\talert(\"请填写理由\");\r\n");
      out.write("\t\t\t\treturn;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\tvar origndate = $(\"#origndate\").val();\r\n");
      out.write("\t\t\tvar plandate = $(\"#plandate\").val();\r\n");
      out.write("\t\t\tif (plandate == \"\") {\r\n");
      out.write("\t\t\t\talert(\"请填写计划日期\");\r\n");
      out.write("\t\t\t\treturn;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\tif (origndate == \"\") {\r\n");
      out.write("\t\t\t\talert(\"请填写原课程日期\");\r\n");
      out.write("\t\t\t\treturn;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t//alert(plandate);\r\n");
      out.write("\t\t\tif (origRoom == \"\" || planRoom == \"\") {\r\n");
      out.write("\t\t\t\treturn;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t//alert(origRoom);\r\n");
      out.write("\t\t\tvar url = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/system/Manage_applyCurrAdjustment.action?newnum=\"\r\n");
      out.write("\t\t\t\t+ newNum + \"&oldnum=\" + oldNum + \"&adjustReason=\" + encodeURI(encodeURI(reason)) + \"&origndate=\" + origndate\r\n");
      out.write("\t\t\t\t+ \"&plandate=\" + plandate + \"&oldSlot=\" + $(\"#oldSlot\").val() + \"&newSlot=\" + $(\"#newSlot\").val()\r\n");
      out.write("\t\t\t\t+ \"&oldRoomNum=\" + $(\"#origRoom\").val() + \"&newRoomNum=\" + $(\"#planRoom\").val() ;\r\n");
      out.write("\t\t\t//alert(url);\r\n");
      out.write("\t\t\t$.post(url, null, function() {\r\n");
      out.write("\t\t\tparent.m.hide();\r\n");
      out.write("\t\t\tparent.window.location.reload();\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t\r\n");
      out.write("\t</script>\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("  <body>\r\n");
      out.write("  \r\n");
      out.write("    <table cellpadding=\"0\" cellspacing=\"0\" class=\"l-table-edit\" >\r\n");
      out.write("    \t<tr style=\"font-size:12px\">\r\n");
      out.write("    \t\t<td align=\"center\" class=\"l-table-edit-td\">课程名</td>\r\n");
      out.write("    \t\t<td align=\"center\" class=\"l-table-edit-td\">");

					List<Syllabus> oldCourses = (List<Syllabus>) ActionContext.getContext().get("oldCourses");
				
      out.write("\r\n");
      out.write("\t\t\t\t<select id=\"oldCourseName\" onchange=\"tchange()\" class=\"link\" >\r\n");
      out.write("\t\t\t\t");

					for (Syllabus s : oldCourses) {
				
      out.write("\r\n");
      out.write("\t\t\t\t\t\t<option value=\"");
      out.print(s.getId() );
      out.write('"');
      out.write('>');
      out.write(' ');
      out.print(s.getCourseName() );
      out.write(" </option>\r\n");
      out.write("\t\t\t\t");

					}
				
      out.write("\t\r\n");
      out.write("\t\t\t\t</select></td>\r\n");
      out.write("\t\t\t<td align=\"center\" class=\"l-table-edit-td\">被调换课程名</td>\r\n");
      out.write("    \t\t<td align=\"center\" class=\"l-table-edit-td\">");

					List<Syllabus> allCourses = (List<Syllabus>) ActionContext.getContext().get("allCourses");
				
      out.write("\r\n");
      out.write("\t\t\t\t<select id=\"newCourseName\" onchange=\"tchange2()\" class=\"link\" >\r\n");
      out.write("\t\t\t\t");

					for (Syllabus s : allCourses) {
				
      out.write("\r\n");
      out.write("\t\t\t\t\t\t<option value=\"");
      out.print(s.getId() );
      out.write('"');
      out.write('>');
      out.write(' ');
      out.print(s.getCourseName() );
      out.write(" </option>\r\n");
      out.write("\t\t\t\t");

					}
				
      out.write("\t\r\n");
      out.write("\t\t\t\t</select></td>\r\n");
      out.write("    \t\t<td align=\"left\"></td>\r\n");
      out.write("    \t</tr>\r\n");
      out.write("    \t<tr style=\"font-size:12px\">\r\n");
      out.write("    \t\t<td align=\"center\" class=\"l-table-edit-td\">课程日期</td>\r\n");
      out.write("    \t\t<td align=\"center\" class=\"l-table-edit-td\"><input id=\"origndate\" onchange=\"origDateChange()\" class=\"date_picker link\"/></td>\r\n");
      out.write("    \t\t<td align=\"center\" class=\"l-table-edit-td\">计划日期</td>\r\n");
      out.write("    \t\t<td align=\"center\" class=\"l-table-edit-td\"><input id=\"plandate\" onchange=\"planDateChange()\" class=\"date_picker link\"/></td>\r\n");
      out.write("\r\n");
      out.write("    \t\t<td align=\"left\"></td>\r\n");
      out.write("    \t</tr>\r\n");
      out.write("    \t<tr style=\"font-size:12px\">\r\n");
      out.write("    \t\t<td align=\"center\" class=\"l-table-edit-td\">节次</td>\r\n");
      out.write("    \t\t<td align=\"center\" class=\"l-table-edit-td\"><select class=\"link\" id=\"oldSlot\" onchange=\"getOldroom()\"></select></td>\r\n");
      out.write("    \t\t\r\n");
      out.write("\t\t\t<td align=\"center\" class=\"l-table-edit-td\">节次</td>\r\n");
      out.write("\t\t\t<td align=\"center\" class=\"l-table-edit-td\"><select id=\"newSlot\" class=\"link\" onchange=\"getNewroom()\"></select></td>\r\n");
      out.write("\t\t\t<td align=\"left\"></td>\r\n");
      out.write("    \t</tr>\r\n");
      out.write("    \t\r\n");
      out.write("    \t<tr style=\"font-size:12px\">\r\n");
      out.write("    \t\t<td align=\"center\" class=\"l-table-edit-td\">原上课教室</td>\r\n");
      out.write("    \t\t<td align=\"center\" class=\"l-table-edit-td\"><select id=\"origRoom\" class=\"link\"></select></td>\r\n");
      out.write("    \t\t<td align=\"center\" class=\"l-table-edit-td\">计划上课教室</td>\r\n");
      out.write("    \t\t<td align=\"center\" class=\"l-table-edit-td\"><select id=\"planRoom\" class=\"link\"></select></td>\r\n");
      out.write("    \t\t<td align=\"left\"></td>\r\n");
      out.write("    \t</tr>\r\n");
      out.write("    \t<tr style=\"font-size:12px\">\r\n");
      out.write("\t\t\t<td align=\"center\" class=\"l-table-edit-td\">调课原因:</td>\r\n");
      out.write("\t\t\t<th align=\"left\" class=\"l-table-edit-td\" colspan=\"4\">\r\n");
      out.write("\t\t\t\t<textarea id=\"reason\"></textarea>\r\n");
      out.write("\t\t\t</th>\r\n");
      out.write("\t\t\t<td align=\"left\"></td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t\t<td align=\"right\" class=\"l-table-edit-td\"></td>\r\n");
      out.write("\t\t\t\t<td align=\"right\" class=\"l-table-edit-td\"></td>\r\n");
      out.write("\t\t\t\t<td align=\"left\" class=\"l-table-edit-td\">\r\n");
      out.write("\t\t\t\t\t<input type=\"submit\" size=\"11px\" value=\"申&nbsp;&nbsp;请\" id=\"Button1\" \r\n");
      out.write("\t\t\t\t\t\tonclick=\"tosubmit()\" class=\"l-button l-button-submit\" />\r\n");
      out.write("\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t<td align=\"left\">\r\n");
      out.write("\t\t\t\t<td align=\"left\">\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("    </table>\r\n");
      out.write("    <table style=\"font-size:14px; margin-left: 10px;\">\r\n");
      out.write("   \t\t<tr>\r\n");
      out.write("   \t\t\t<td><strong style=\"color:red\">注 &nbsp;</strong></td><td>1.请先选择想要调换的课程</td>\r\n");
      out.write("   \t\t</tr> \r\n");
      out.write("   \t\t<tr>\r\n");
      out.write("   \t\t\t<td><strong></strong></td><td>2.再选择日期</td>\r\n");
      out.write("   \t\t</tr> \r\n");
      out.write("   \t\t<tr>\r\n");
      out.write("   \t\t\t<td><strong></strong></td><td>3.最后选择调换的上课大节</td>\r\n");
      out.write("   \t\t</tr> \r\n");
      out.write("    </table>\r\n");
      out.write("  </body>\r\n");
      out.write("  \r\n");
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
