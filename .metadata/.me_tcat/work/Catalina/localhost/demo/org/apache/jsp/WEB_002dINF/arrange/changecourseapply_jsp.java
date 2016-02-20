package org.apache.jsp.WEB_002dINF.arrange;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;
import com.tjpu.bean.Syllabus;
import com.opensymphony.xwork2.ActionContext;

public final class changecourseapply_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\r\n");
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
      out.write("<title>天津工业大学排课管理系统</title>\r\n");
      out.write("\r\n");
      out.write("<link href=\"");
      out.print(basePath);
      out.write("js/ligerUI/skins/Gray/css/form.css\"\r\n");
      out.write("\trel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("<link href=\"");
      out.print(basePath);
      out.write("js/ligerUI/skins/Gray/css/common.css\"\r\n");
      out.write("\trel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("<link href=\"");
      out.print(basePath);
      out.write("css/date.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("<script src=\"");
      out.print(basePath);
      out.write("js/jquery/jquery-1.6.min.js\"\r\n");
      out.write("\ttype=\"text/javascript\"></script>\r\n");
      out.write("<script src=\"");
      out.print(basePath);
      out.write("js/ligerUI/core/base.js\"\r\n");
      out.write("\ttype=\"text/javascript\"></script>\r\n");
      out.write("<script src=\"");
      out.print(basePath);
      out.write("js/ligerUI/plugins/ligerForm.js\"\r\n");
      out.write("\ttype=\"text/javascript\"></script>\r\n");
      out.write("<script src=\"");
      out.print(basePath);
      out.write("js/ligerUI/plugins/ligerDateEditor.js\"\r\n");
      out.write("\ttype=\"text/javascript\"></script>\r\n");
      out.write("<script src=\"");
      out.print(basePath);
      out.write("js/ligerUI/plugins/ligerComboBox.js\"\r\n");
      out.write("\ttype=\"text/javascript\"></script>\r\n");
      out.write("<script src=\"");
      out.print(basePath);
      out.write("js/ligerUI/plugins/ligerSpinner.js\"\r\n");
      out.write("\ttype=\"text/javascript\"></script>\r\n");
      out.write("<script src=\"");
      out.print(basePath);
      out.write("js/ligerUI/plugins/ligerTextBox.js\"\r\n");
      out.write("\ttype=\"text/javascript\"></script>\r\n");
      out.write("\r\n");
      out.write("<script src=\"");
      out.print(basePath);
      out.write("js/ligerUI/plugins/ligerTip.js\"\r\n");
      out.write("\ttype=\"text/javascript\"></script>\r\n");
      out.write("<script src=\"");
      out.print(basePath);
      out.write("js/jquery-validation/jquery.validate.min.js\"\r\n");
      out.write("\ttype=\"text/javascript\"></script>\r\n");
      out.write("<script src=\"");
      out.print(basePath);
      out.write("js/jquery-validation/jquery.metadata.js\"\r\n");
      out.write("\ttype=\"text/javascript\"></script>\r\n");
      out.write("<script src=\"");
      out.print(basePath);
      out.write("js/jquery-validation/messages_cn.js\"\r\n");
      out.write("\ttype=\"text/javascript\"></script>\r\n");
      out.write("<script src=\"");
      out.print(basePath);
      out.write("js/jquery.date_input.pack.js\"\r\n");
      out.write("\ttype=\"text/javascript\"></script>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\t$(function() {\r\n");
      out.write("\t\t$('.date_picker').date_input();\r\n");
      out.write("\t})\r\n");
      out.write("\tvar eee;\r\n");
      out.write("\t$(function() {\r\n");
      out.write("\t\t$.metadata.setType(\"attr\", \"validate\");\r\n");
      out.write("\t\tvar v = $(\"form\")\r\n");
      out.write("\t\t\t\t.validate(\r\n");
      out.write("\t\t\t\t\t\t{\r\n");
      out.write("\t\t\t\t\t\t\t//调试状态，不会提交数据的\r\n");
      out.write("\t\t\t\t\t\t\tdebug : true,\r\n");
      out.write("\t\t\t\t\t\t\terrorPlacement : function(lable, element) {\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\tif (element.hasClass(\"l-textarea\")) {\r\n");
      out.write("\t\t\t\t\t\t\t\t\telement.addClass(\"l-textarea-invalid\");\r\n");
      out.write("\t\t\t\t\t\t\t\t} else if (element.hasClass(\"l-text-field\")) {\r\n");
      out.write("\t\t\t\t\t\t\t\t\telement.parent().addClass(\"l-text-invalid\");\r\n");
      out.write("\t\t\t\t\t\t\t\t}\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\tvar nextCell = element.parents(\"td:first\")\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t.next(\"td\");\r\n");
      out.write("\t\t\t\t\t\t\t\tif (nextCell.find(\"div.l-exclamation\").length == 0) {\r\n");
      out.write("\t\t\t\t\t\t\t\t\t$(\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t'<div class=\"l-exclamation\" title=\"'\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t+ lable.html() + '\"></div>')\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t.appendTo(nextCell).ligerTip();\r\n");
      out.write("\t\t\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\t\t},\r\n");
      out.write("\t\t\t\t\t\t\tinvalidHandler : function(form, validator) {\r\n");
      out.write("\t\t\t\t\t\t\t\tvar errors = validator.numberOfInvalids();\r\n");
      out.write("\t\t\t\t\t\t\t\tif (errors) {\r\n");
      out.write("\t\t\t\t\t\t\t\t\tvar message = errors == 1 ? '该字段不能为空！'\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t: '这 ' + errors + ' 个字段不能为空！';\r\n");
      out.write("\t\t\t\t\t\t\t\t\t$(\"#errorLabelContainer\").html(message)\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t.show();\r\n");
      out.write("\t\t\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\t\t},\r\n");
      out.write("\t\t\t\t\t\t\tsubmitHandler : function() {\r\n");
      out.write("\t\t\t\t\t\t\t\t$(\"form .l-text,.l-textarea\").ligerHideTip();\r\n");
      out.write("\t\t\t\t\t\t\t\tif (flg) {\r\n");
      out.write("\t\t\t\t\t\t\t\t\t$\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t.post(\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/system/Class_classendadd.action?cls.classname=\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t+ encodeURI(encodeURI($(\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"#classname\")\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t.val()))\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t+ \"&cls.major=\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t+ encodeURI(encodeURI($(\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"#major\")\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t.val())),\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\tnull,\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\tfunction() {\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\talert('添加成功!');\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\tparent.m.hide();\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\tparent.g.window.location\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t.reload();\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\tparent.g.loadData();\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t});\r\n");
      out.write("\t\t\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\t});\r\n");
      out.write("\t\t$(\"form\").ligerForm();\r\n");
      out.write("\t\t$(\".l-button-test\").click(function() {\r\n");
      out.write("\t\t\talert(v.element($(\"#txtName\")));\r\n");
      out.write("\t\t});\r\n");
      out.write("\r\n");
      out.write("\t});\r\n");
      out.write("\tvar flg = true;\r\n");
      out.write("\tfunction check() {\r\n");
      out.write("\t\t$\r\n");
      out.write("\t\t\t\t.post(\r\n");
      out.write("\t\t\t\t\t\t\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/system/Class_classcheck.action?cls.classname=\"\r\n");
      out.write("\t\t\t\t\t\t\t\t+ $(\"#classname\").val(), null, function(data) {\r\n");
      out.write("\t\t\t\t\t\t\tif (data == \"fail\") {\r\n");
      out.write("\t\t\t\t\t\t\t\t$(\"#result\").html(\"该班级名称已经存在!\");\r\n");
      out.write("\t\t\t\t\t\t\t\t$(\"#result\").show();\r\n");
      out.write("\t\t\t\t\t\t\t\tflg = false;\r\n");
      out.write("\t\t\t\t\t\t\t} else {\r\n");
      out.write("\t\t\t\t\t\t\t\t$(\"#result\").hide();\r\n");
      out.write("\t\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\t});\r\n");
      out.write("\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("   // function selectOnClick() {\r\n");
      out.write("    \t//alert(\"here\");\r\n");
      out.write("    \t/* $.ajax( {  \r\n");
      out.write("\t        type : \"POST\",  \r\n");
      out.write("\t        url : \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/system/Manage_getDat.action\",  \r\n");
      out.write("\t        data : {},  \r\n");
      out.write("\t        dataType : \"JSON\",  \r\n");
      out.write("\t        success : function(data) {\r\n");
      out.write("\t        \t//alert(data);  \r\n");
      out.write("\t            $('#element_id').cxSelect({ \r\n");
      out.write("\t\t\t\t  url: data,  \r\n");
      out.write("\t\t\t\t  selects: ['province', 'city', 'area'], \r\n");
      out.write("\t\t\t\t  nodata: 'none'\r\n");
      out.write("\t\t\t\t}); \r\n");
      out.write("\t        }  \r\n");
      out.write("    \t}); */\r\n");
      out.write("    //};\r\n");
      out.write("   \r\n");
      out.write("</script>\r\n");
      out.write("<style type=\"text/css\">\r\n");
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
      out.write("\r\n");
      out.write("textarea {\r\n");
      out.write("\twidth: 100%;\r\n");
      out.write("\theight: 100px;\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body style=\"padding: 10px\">\r\n");
      out.write("\t<form name=\"form1\" method=\"post\" action=\"\" id=\"form1\">\r\n");
      out.write("\t\t<div id=\"errorLabelContainer\" class=\"l-text-invalid\"></div>\r\n");
      out.write("\t\t<table cellpadding=\"0\" cellspacing=\"0\" class=\"l-table-edit\">\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td align=\"center\" class=\"l-table-edit-td\">课程编号:</td>\r\n");
      out.write("\t\t\t\t<td align=\"left\" class=\"l-table-edit-td\"><input\r\n");
      out.write("\t\t\t\t\tname=\"oldcoursenum\" type=\"text\" onblur=\"check()\" id=\"oldcoursenum\"\r\n");
      out.write("\t\t\t\t\tltype=\"text\" validate=\"{required:true,minlength:1,maxlength:20}\" />\r\n");
      out.write("\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t<td align=\"center\" width=\"70px\">课程名称:</td>\r\n");
      out.write("\t\t\t\t<!-- <td align=\"left\" class=\"l-table-edit-td\"><input\r\n");
      out.write("\t\t\t\t\tname=\"oldcoursename\" type=\"text\" id=\"coursename\" ltype=\"text\"\r\n");
      out.write("\t\t\t\t\tvalidate=\"{required:true,minlength:1,maxlength:20}\" />\r\n");
      out.write("\t\t\t\t</td> -->\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t");

							List<Syllabus> oldCourses = (List<Syllabus>) ActionContext.getContext().get("oldCourses");
							
					
      out.write("\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t<select id=\"oldCourseName\">\r\n");
      out.write("\t\t\t\t\t\t");

							for (Syllabus s : oldCourses) {
						
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t<option value=\"");
      out.print(s.getId() );
      out.write('"');
      out.write('>');
      out.write(' ');
      out.print(s.getCourseName() );
      out.write(" </option>\r\n");
      out.write("\t\t\t\t\t\t");

							}
						 
      out.write("\t\r\n");
      out.write("\t\t\t\t\t</select>\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t<select id=\"test123\"></select>\r\n");
      out.write("\t\t\t\t\t<script type=\"text/javascript\">\r\n");
      out.write("\t\t\t\t\t\t $(document).ready(function(){\r\n");
      out.write("\t\t\t\t\t\t    $(\"#oldCourseName\").change(selectChange());\r\n");
      out.write("\t\t\t\t\t\t});\r\n");
      out.write("\t\t\t\t\t\t //$(\"#test123\").append(\"<option>s</option>\");\r\n");
      out.write("\t\t\t\t\t\tfunction selectChange () {\r\n");
      out.write("\t\t\t\t\t\t\t//alert(\"here\");\r\n");
      out.write("\t\t\t\t\t\t\tvar oldCourse = $(\"#oldCourseName\").val();\r\n");
      out.write("\t\t\t\t\t\t\tvar url = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/system/Manage_getDat.action\";\r\n");
      out.write("\t\t\t\t\t\t\t $.ajax({  \r\n");
      out.write("\t\t\t\t\t\t        type : \"POST\",  \r\n");
      out.write("\t\t\t\t\t\t        url : url,\r\n");
      out.write("\t\t\t\t\t\t        dataType : \"JSON\", \r\n");
      out.write("\t\t\t\t\t\t        error: function (){\r\n");
      out.write("\t\t\t\t\t\t        \talert(\"error function\");\r\n");
      out.write("\t\t\t\t\t\t        },\r\n");
      out.write("\t\t\t\t\t\t        success : function(data) {\r\n");
      out.write("\t\t\t\t\t\t        \t//alert(data.length);  \r\n");
      out.write("\t\t\t\t\t\t          \tfor(var n=0;n<data.length;n++){\r\n");
      out.write("\t\t\t\t\t\t            \t//alert(eval(data[n]).v);\r\n");
      out.write("\t\t\t\t\t\t            \t//alert($(\"#newtime\").val());\r\n");
      out.write("\t\t\t\t\t\t                //$(\"#newtime\").append(\"<option>\"+eval(data[n]).v+\"</option>\");\r\n");
      out.write("\t\t\t\t\t\t                //$(\"#test123\").append(\"<option>s</option>\");\r\n");
      out.write("\t\t\t\t\t\t                //$(\"<option value='n+1'>第N+1项</option>\").appendTo(\"#value\"); \r\n");
      out.write("\t\t\t\t\t\t                document.getElementById(\"test123\").options.add(new Option(\"test\",\"test\"))\r\n");
      out.write("\t\t\t\t\t\t          \t} \r\n");
      out.write("\t\t\t\t\t\t        }  \r\n");
      out.write("\t\t\t\t\t\t    });\r\n");
      out.write("\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t</script>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td align=\"center\" class=\"l-table-edit-td\">新课程编号:</td>\r\n");
      out.write("\t\t\t\t<td align=\"left\" class=\"l-table-edit-td\"><input\r\n");
      out.write("\t\t\t\t\tname=\"coursenum\" type=\"text\" onblur=\"check()\" id=\"coursenum\"\r\n");
      out.write("\t\t\t\t\tltype=\"text\" validate=\"{required:true,minlength:1,maxlength:20}\" />\r\n");
      out.write("\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t<td align=\"center\" width=\"70px\">新课程名称:</td>\r\n");
      out.write("\t\t\t\t<td align=\"left\" class=\"l-table-edit-td\">\r\n");
      out.write("\t\t\t\t<input name=\"coursename\" type=\"text\" id=\"coursename\" ltype=\"text\"\r\n");
      out.write("\t\t\t\t\tvalidate=\"{required:true,minlength:1,maxlength:20}\" />\t\t\r\n");
      out.write("\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t<td align=\"left\"></td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td align=\"center\" class=\"l-table-edit-td\">计划上课日期:</td>\r\n");
      out.write("\t\t\t\t<td align=\"left\" class=\"l-table-edit-td\"><input name=\"plandate\"\r\n");
      out.write("\t\t\t\t\tid=\"plandate\" class=\"date_picker \" />\r\n");
      out.write("\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t<td align=\"center\" class=\"l-table-edit-td\">计划上课日期:</td>\r\n");
      out.write("\t\t\t\t<td align=\"left\" class=\"l-table-edit-td\"><input name=\"plandate\"\r\n");
      out.write("\t\t\t\t\tid=\"plandate\" class=\"date_picker \" /></td>\r\n");
      out.write("\t\t\t\t<td align=\"left\"></td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td align=\"center\" class=\"l-table-edit-td\">节次:</td>\r\n");
      out.write("\t\t\t\t<td align=\"left\" class=\"l-table-edit-td\">\r\n");
      out.write("\t\t\t\t<select id=\"newtime\" class=\"link\">\r\n");
      out.write("\t\t\t\t\t\t<option id=\"value\"> value</option>\r\n");
      out.write("\t\t\t\t</select>\r\n");
      out.write("\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t<td align=\"center\" class=\"l-table-edit-td\">节次:</td>\r\n");
      out.write("\t\t\t\t<td align=\"left\" class=\"l-table-edit-td\"><select id=\"oldtime\"\r\n");
      out.write("\t\t\t\t\tname=\"oldtime\" class=\"link\">\r\n");
      out.write("\t\t\t\t\t\t<option value=\"8:20-10:00\">第一大节</option>\r\n");
      out.write("\t\t\t\t\t\t<option value=\"10:20-12:00\">第二大节</option>\r\n");
      out.write("\t\t\t\t\t\t<option value=\"14:00-15:40\">第三大节</option>\r\n");
      out.write("\t\t\t\t\t\t<option value=\"16:00-17:40\">第四大节</option>\r\n");
      out.write("\t\t\t\t\t\t<option value=\"18:30-20:10\">第五大节</option>\r\n");
      out.write("\t\t\t\t</select></td>\r\n");
      out.write("\t\t\t\t<td align=\"left\"></td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td align=\"center\" class=\"l-table-edit-td\">调课原因:</td>\r\n");
      out.write("\t\t\t\t<th align=\"left\" class=\"l-table-edit-td\" colspan=\"4\"><textarea\r\n");
      out.write("\t\t\t\t\t\tid=\"reason\"></textarea></th>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<th align=\"center\" class=\"l-table-edit-td\" colspan=\"3\"><div\r\n");
      out.write("\t\t\t\t\t\tid=\"result\" style=\"color: red;\"></div></th>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td align=\"right\" class=\"l-table-edit-td\"></td>\r\n");
      out.write("\t\t\t\t<td align=\"right\" class=\"l-table-edit-td\"></td>\r\n");
      out.write("\t\t\t\t<td align=\"left\" class=\"l-table-edit-td\"><input type=\"submit\"\r\n");
      out.write("\t\t\t\t\tvalue=\"申&nbsp;&nbsp;请\" id=\"Button1\"\r\n");
      out.write("\t\t\t\t\tclass=\"l-button l-button-submit\" />\r\n");
      out.write("\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t<td align=\"left\">\r\n");
      out.write("\t\t\t\t\t<td align=\"left\">\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t</table>\r\n");
      out.write("\t\t<br />\r\n");
      out.write("\t</form>\r\n");
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
