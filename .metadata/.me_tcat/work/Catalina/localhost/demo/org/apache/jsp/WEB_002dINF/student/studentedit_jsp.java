package org.apache.jsp.WEB_002dINF.student;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;

public final class studentedit_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fs_005fif_005ftest;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fs_005fiterator_005fvar_005fvalue;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fs_005fproperty_005fvalue_005fnobody;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fs_005felse;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fs_005fif_005ftest = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fs_005fiterator_005fvar_005fvalue = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fs_005fproperty_005fvalue_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fs_005felse = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fs_005fif_005ftest.release();
    _005fjspx_005ftagPool_005fs_005fiterator_005fvar_005fvalue.release();
    _005fjspx_005ftagPool_005fs_005fproperty_005fvalue_005fnobody.release();
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
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";

      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\r\n");
      out.write("<html xmlns=\"http://www.w3.org/1999/xhtml\">\r\n");
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
      out.write("<link href=\"");
      out.print(basePath);
      out.write("css/date.css\" rel=\"stylesheet\" type=\"text/css\"/>\r\n");
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
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\t $(function(){\r\n");
      out.write("\t  $('.date_picker').date_input();\r\n");
      out.write("   })\r\n");
      out.write("\tvar eee;\r\n");
      out.write("        $(function () {\r\n");
      out.write("            $.metadata.setType(\"attr\", \"validate\");\r\n");
      out.write("            var v = $(\"form\").validate({\r\n");
      out.write("                //调试状态，不会提交数据的\r\n");
      out.write("                debug: true,\r\n");
      out.write("                errorPlacement: function (lable, element) {\r\n");
      out.write("\r\n");
      out.write("                    if (element.hasClass(\"l-textarea\")) {\r\n");
      out.write("                        element.addClass(\"l-textarea-invalid\");\r\n");
      out.write("                    }\r\n");
      out.write("                    else if (element.hasClass(\"l-text-field\")) {\r\n");
      out.write("                        element.parent().addClass(\"l-text-invalid\");\r\n");
      out.write("                    }\r\n");
      out.write("\r\n");
      out.write("                    var nextCell = element.parents(\"td:first\").next(\"td\");\r\n");
      out.write("                    if (nextCell.find(\"div.l-exclamation\").length == 0) {\r\n");
      out.write("                        $('<div class=\"l-exclamation\" title=\"' + lable.html() + '\"></div>').appendTo(nextCell).ligerTip();\r\n");
      out.write("                    }\r\n");
      out.write("                },\r\n");
      out.write("                invalidHandler: function (form, validator) {\r\n");
      out.write("                    var errors = validator.numberOfInvalids();\r\n");
      out.write("                    if (errors) {\r\n");
      out.write("                        var message = errors == 1\r\n");
      out.write("                          ? '该字段不能为空！'\r\n");
      out.write("                          : '这 ' + errors + ' 个字段不能为空！';\r\n");
      out.write("                        $(\"#errorLabelContainer\").html(message).show();\r\n");
      out.write("                    }\r\n");
      out.write("                },\r\n");
      out.write("\t\t\tsubmitHandler : function() {\r\n");
      out.write("\t\t\t\t$(\"form .l-text,.l-textarea\").ligerHideTip();\r\n");
      out.write("\t\t\t\tcheckname();\r\n");
      out.write("\t\t\t\tcheckengname();\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\tchecknation();\r\n");
      out.write("\t\t\t\tcheckpassport();\r\n");
      out.write("\t\t\t\t//checknum();&&(flg3)\r\n");
      out.write("\t\t\t\t//checktype();\r\n");
      out.write("\t\t\t\tcheckmajor();\r\n");
      out.write("\t\t\t\tcheckdate();\r\n");
      out.write("\t\t\t\tcheckmobile();\r\n");
      out.write("\t\t\t\tcheckval();\r\n");
      out.write("\t\t\t\tcheckroom();\r\n");
      out.write("\t\t\t\tchecksource();\r\n");
      out.write("\t\t\t\tcheckbrith();\r\n");
      out.write("\t\t\t\tvar test = (flg)&&(flg1)&&(flg2)&&(flg5)&&(flg6)&&(flg7)&&(flg8)&&(flg9)&&(flgtest)&&(flgtest1)&&flgt;\r\n");
      out.write("\t\t\t\tif(test){\t\t\r\n");
      out.write("\t\t\t\tvar sexid=1;\r\n");
      out.write("\t\t\t\tif(document.getElementById(\"r2\").checked){\r\n");
      out.write("\t                 sexid=\"女\";\r\n");
      out.write("                }else{\r\n");
      out.write("                  sexid=\"男\";\r\n");
      out.write("                }  \r\n");
      out.write("                $.post(\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/system/Stu_stuupdate.action?stu.stuid=\"+ $(\"#stunum\").val()\r\n");
      out.write("\t\t        +\"&stu.sex=\"+ encodeURI(encodeURI(sexid))\r\n");
      out.write("\t\t        +\"&stu.id=\"+ encodeURI(encodeURI($(\"#id\").val()))\r\n");
      out.write("\t\t        +\"&classid=\"+ $(\"#classid\").val()\r\n");
      out.write("\t\t        +\"&stu.stuname=\"+ encodeURI(encodeURI($(\"#stuname\").val()))\t            \r\n");
      out.write("\t\t        +\"&stu.firstname=\"+ encodeURI(encodeURI($(\"#firstname\").val()))\r\n");
      out.write("\t\t        +\"&stu.lastname=\"+ encodeURI(encodeURI($(\"#lastname\").val()))\r\n");
      out.write("\t\t        +\"&stu.nation=\"+ encodeURI(encodeURI($(\"#nation\").val()))\r\n");
      out.write("\t\t        +\"&stu.studentType=\"+ encodeURI(encodeURI($(\"#studenttype\").val()))\r\n");
      out.write("\t\t        +\"&stu.passport=\"+ encodeURI(encodeURI($(\"#passport\").val()))\r\n");
      out.write("\t\t        +\"&stu.startdate=\"+ encodeURI(encodeURI($(\"#startdate\").val()))\r\n");
      out.write("\t\t        +\"&stu.enddate=\"+ encodeURI(encodeURI($(\"#enddate\").val()))\r\n");
      out.write("\t\t        +\"&stu.telephone=\"+ encodeURI(encodeURI($(\"#telephone\").val()))\r\n");
      out.write("\t\t        +\"&stu.validResidencePermit=\"+ encodeURI(encodeURI($(\"#validResidencePermit\").val()))\r\n");
      out.write("\t\t        +\"&stu.roomplace=\"+ encodeURI(encodeURI($(\"#roomplace\").val()))\r\n");
      out.write("\t\t        +\"&stu.brithdate=\"+ encodeURI(encodeURI($(\"#brithdate\").val()))\r\n");
      out.write("\t\t        +\"&stu.source=\"+ encodeURI(encodeURI($(\"#source\").val())),null,function(){\r\n");
      out.write("\t\t       // alert('更新成功!');\r\n");
      out.write("\t\t        parent.m.hide();\r\n");
      out.write("\t            //parent.window.location.reload();\r\n");
      out.write("\t            parent.g.loadData();\r\n");
      out.write("\t\t       });\r\n");
      out.write("\t\t\t }\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\t$(\"form\").ligerForm();\r\n");
      out.write("\t\t$(\".l-button-test\").click(function() {\r\n");
      out.write("\t\t\talert(v.element($(\"#txtName\")));\r\n");
      out.write("\t\t});\r\n");
      out.write("\r\n");
      out.write("\t});\r\n");
      out.write("\tvar flg = false;\r\n");
      out.write("\tfunction checkname(){\r\n");
      out.write("\t var name = $(\"#stuname\").val();\r\n");
      out.write("\t  if(name.length==0){\r\n");
      out.write("\t     $(\"#result\").html(\"姓名不能为空！\");\r\n");
      out.write("\t     $(\"#result\").show();\r\n");
      out.write("\t     flg=false;\r\n");
      out.write("\t  }else{\r\n");
      out.write("\t     $(\"#result\").hide();\r\n");
      out.write("\t     var reg = /^[\\u4e00-\\u9fa5]{2,}$/gi;\r\n");
      out.write("\t     if(!reg.test(name)){\r\n");
      out.write("\t         $(\"#result\").html(\"姓名只能为两个字符以上的汉字！\");\r\n");
      out.write("\t         $(\"#result\").show();\r\n");
      out.write("\t         flg=false; \r\n");
      out.write("\t     }else{\r\n");
      out.write("\t         $(\"#result\").hide();\r\n");
      out.write("\t        flg=true;\r\n");
      out.write("\t     }\r\n");
      out.write("\t  }\r\n");
      out.write("\t}\r\n");
      out.write(" var flg1=false;\r\n");
      out.write("\tfunction checknation(){\r\n");
      out.write("\tvar name = $(\"#nation\").val();\r\n");
      out.write("\t  if(name.length==0){\r\n");
      out.write("\t     $(\"#result1\").html(\"国籍不能为空！\");\r\n");
      out.write("\t     $(\"#result1\").show();\r\n");
      out.write("\t     flg1=false;\r\n");
      out.write("\t  }else{\r\n");
      out.write("\t     $(\"#result1\").hide();\r\n");
      out.write("\t     if(!isNaN(name)){\r\n");
      out.write("\t         $(\"#result1\").html(\"国籍不能为数字！\");\r\n");
      out.write("\t         $(\"#result1\").show();\r\n");
      out.write("\t         flg1=false; \r\n");
      out.write("\t     }else{\r\n");
      out.write("\t        $(\"#result1\").hide();\r\n");
      out.write("\t        flg1=true;\r\n");
      out.write("\t     }\r\n");
      out.write("\t  }\r\n");
      out.write("\t}\r\n");
      out.write("\tvar flg2=false;\r\n");
      out.write("\tfunction checkpassport(){\r\n");
      out.write("\t   var str = document.getElementById(\"passport\").value;\r\n");
      out.write("\t   if(str.length<6){\r\n");
      out.write("\t        $(\"#result2\").html(\"护照号不足6位！\");\r\n");
      out.write("\t\t\t$(\"#result2\").show();\r\n");
      out.write("\t\t\tflg2 = false;\r\n");
      out.write("\t\t\t//document.regFrm.username.focus();\r\n");
      out.write("\t\t\treturn false;\r\n");
      out.write("\t   }else{\r\n");
      out.write("\t       $(\"#result2\").hide();\r\n");
      out.write("\t        var reg = /^[A-Za-z0-9]+$/;\r\n");
      out.write("\t\tif (!reg.test(str)) {\r\n");
      out.write("\t\t\t$(\"#result2\").html(\"护照只能为数字与英文字符！\");\r\n");
      out.write("\t\t\t$(\"#result2\").show();\r\n");
      out.write("\t\t\tflg2 = false;\r\n");
      out.write("\t\t\t//document.regFrm.username.focus();\r\n");
      out.write("\t\t\treturn false;\r\n");
      out.write("\t\t} else {\r\n");
      out.write("\t\t\t$(\"#result2\").hide();\r\n");
      out.write("\t\t    $.post(\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/system/Stu_stucheckagain.action?stu.passport=\"\r\n");
      out.write("\t\t\t\t\t\t+ $(\"#passport\").val()+\"&stu.id=\"+$(\"#id\").val(), null, function(data) {\r\n");
      out.write("\t\t\t\t\tif (data == \"fail\") {\r\n");
      out.write("\t\t\t\t\t\t$(\"#result2\").html(\"护照号输入不能相同!\");\r\n");
      out.write("\t\t\t\t\t\t$(\"#result2\").show();\r\n");
      out.write("\t\t\t\t\t\tflg2 = false;\r\n");
      out.write("\t\t\t\t\t} else {\r\n");
      out.write("\t\t\t\t\t\t$(\"#result2\").hide();\r\n");
      out.write("\t\t\t\t\t\tflg2=true;\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t});\t\r\n");
      out.write("\t   }\t\r\n");
      out.write("\t   }\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t}\r\n");
      out.write("\tvar flg3=false;\r\n");
      out.write("\tfunction checknum(){\r\n");
      out.write("\t var stunum = $(\"#stunum\").val();\r\n");
      out.write("\t if(stunum.length==0){\r\n");
      out.write("\t    $(\"#result3\").html(\"学号不能为空！\");\r\n");
      out.write("\t    $(\"#result3\").show();\r\n");
      out.write("\t   flg3 = false;\r\n");
      out.write("\t   return false;\r\n");
      out.write("\t }else{\r\n");
      out.write("\t   $(\"#result3\").hide();\r\n");
      out.write("\t   if(isNaN(stunum)){\r\n");
      out.write("\t    $(\"#result3\").html(\"学号只能为数字！\");\r\n");
      out.write("\t\t$(\"#result3\").show();\r\n");
      out.write("\t\tflg3 = false;\r\n");
      out.write("\t\treturn false; \r\n");
      out.write("\t   }else{\r\n");
      out.write("\t      $(\"#result3\").hide();\r\n");
      out.write("\t      if(stunum.length!=10){\r\n");
      out.write("\t        $(\"#result3\").html(\"学号必须为10位！\");\r\n");
      out.write("\t\t    $(\"#result3\").show();\r\n");
      out.write("\t\t    flg3 = false;\r\n");
      out.write("\t      }else{\r\n");
      out.write("\t         $(\"#result3\").hide();\r\n");
      out.write("\t         $.post(\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/system/Stu_stucheckstunumagain.action?stu.stuid=\"\r\n");
      out.write("\t\t\t\t\t\t+ $(\"#stunum\").val()+\"&stu.id=\"+$(\"#id\").val(), null, function(data) {\r\n");
      out.write("\t\t\t\t\tif (data == \"fail\") {\r\n");
      out.write("\t\t\t\t\t\t$(\"#result3\").html(\"已存在该学号，请重新输入!\");\r\n");
      out.write("\t\t\t\t\t\t$(\"#result3\").show();\r\n");
      out.write("\t\t\t\t\t\tflg3 = false;\r\n");
      out.write("\t\t\t\t\t} else {\r\n");
      out.write("\t\t\t\t\t\t$(\"#result3\").hide();\r\n");
      out.write("\t\t\t\t\t\tflg3=true;\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t});\t\t\r\n");
      out.write("\t      }\r\n");
      out.write("\t\t    \r\n");
      out.write("\t   }\r\n");
      out.write("\t   }\r\n");
      out.write("\t}\r\n");
      out.write("\t var flg4=false;\r\n");
      out.write("\tfunction checktype(){\r\n");
      out.write("\tvar name = $(\"#studenttype\").val();\r\n");
      out.write("\tif(name.length==0){\r\n");
      out.write("\t     $(\"#result4\").html(\"学生类型不能为空！\");\r\n");
      out.write("\t     $(\"#resul4\").show();\r\n");
      out.write("\t     flg4=false;\r\n");
      out.write("\t  }else{\r\n");
      out.write("\t     $(\"#result4\").hide();\r\n");
      out.write("\t      var reg = /^[\\u4e00-\\u9fa5]+$/gi;\r\n");
      out.write("\t     if(!reg.test(name)){\r\n");
      out.write("\t         $(\"#result4\").html(\"学生类型只能为中文！\");\r\n");
      out.write("\t         $(\"#result4\").show();\r\n");
      out.write("\t         flg4=false; \r\n");
      out.write("\t     }else{\r\n");
      out.write("\t        $(\"#result4\").hide();\r\n");
      out.write("\t        flg4=true;\r\n");
      out.write("\t     }\r\n");
      out.write("\t  }\r\n");
      out.write("\t}\r\n");
      out.write("\tvar flg5=false;\r\n");
      out.write("\tfunction checkmajor(){\r\n");
      out.write("\t var name = $(\"#major\").val();\r\n");
      out.write("\t if(name.length==0){\r\n");
      out.write("\t         $(\"#result5\").html(\"专业不能为空！\");\r\n");
      out.write("\t         $(\"#result5\").show();\r\n");
      out.write("\t         flg5=false;\r\n");
      out.write("\t }else{\r\n");
      out.write("\t    var reg = /^[\\u4e00-\\u9fa5]+$/gi;\r\n");
      out.write("\t     if(!reg.test(name)){\r\n");
      out.write("\t         $(\"#result5\").html(\"专业只能为中文！\");\r\n");
      out.write("\t         $(\"#result5\").show();\r\n");
      out.write("\t         flg5=false; \r\n");
      out.write("\t     }else{\r\n");
      out.write("\t        $(\"#result5\").hide();\r\n");
      out.write("\t        flg5=true;\r\n");
      out.write("\t     }\r\n");
      out.write("\t }\t \r\n");
      out.write("\t  }\r\n");
      out.write("\t  var flg6=false;\r\n");
      out.write("\tfunction checkdate(){\r\n");
      out.write("\t  var startdate=$(\"#startdate\").val();\r\n");
      out.write("\t  var enddate=$(\"#enddate\").val();\r\n");
      out.write("\t  var a = /^(\\d{4})-(\\d{2})-(\\d{1,2})$/;\r\n");
      out.write("\t  var d1 = new Date(startdate.replace(/\\-/g, \"\\/\"));\r\n");
      out.write("\t  var d2 = new Date(enddate.replace(/\\-/g, \"\\/\"));\r\n");
      out.write("\t  if(startdate.length==0||enddate.length==0){\r\n");
      out.write("\t     $(\"#result6\").html(\"入校日期或离校日期不能为空！\");\r\n");
      out.write("         $(\"#result6\").show();\r\n");
      out.write("         flg6=false;\r\n");
      out.write("         return false; \r\n");
      out.write("\t  }else{\r\n");
      out.write("\t     $(\"#result6\").hide();\r\n");
      out.write("\t     if(!a.test(startdate)||!a.test(enddate)){\r\n");
      out.write("\t         $(\"#result6\").html(\"日期格式不正确！\");\r\n");
      out.write("             $(\"#result6\").show();\r\n");
      out.write("             flg6=false;\r\n");
      out.write("             return false;\r\n");
      out.write("\t     }else{\r\n");
      out.write("\t        $(\"#result6\").hide();\r\n");
      out.write("\t        if(startdate!=\"\"&&enddate!=\"\"&&d1 >=d2){  \r\n");
      out.write("               $(\"#result6\").html(\"入学日期不能大于离校日期！\");\r\n");
      out.write("               $(\"#result6\").show();\r\n");
      out.write("               flg6=false;\r\n");
      out.write("               return false;  \r\n");
      out.write("            }else{\r\n");
      out.write("               $(\"#result\").hide();\r\n");
      out.write("               flg6=true;\r\n");
      out.write("            } \r\n");
      out.write("\t     }\t     \r\n");
      out.write("\t  }\t  \r\n");
      out.write("} \r\n");
      out.write("var flg7 = true;\r\n");
      out.write("\tfunction checkmobile(){\r\n");
      out.write("\t  var isMobile=/^(?:13\\d|15\\d|18\\d)\\d{5}(\\d{3}|\\*{3})$/; //手机号码验证规则\r\n");
      out.write("\t  var mobile = $(\"#telephone\").val();\r\n");
      out.write("\t  if(mobile.length==0){\r\n");
      out.write("\t     $(\"#result7\").html(\"手机号码不能为空!\");\r\n");
      out.write("\t\t $(\"#result7\").show();\r\n");
      out.write("\t\t //$(\"#telephone\").focus();       //输入框获得光标\r\n");
      out.write("\t\t flg7 = false; //就弹出提示信息        \r\n");
      out.write("\t  }else{\r\n");
      out.write("\t     $(\"#result7\").hide();\r\n");
      out.write("\t     if(!isMobile.test(mobile)){ //如果用户输入的值不同时满足手机号的正则\r\n");
      out.write("         $(\"#result7\").html(\"请输入正确的11位手机号!\");\r\n");
      out.write("\t\t $(\"#result7\").show();\r\n");
      out.write("\t\t //$(\"#telephone\").focus();       //输入框获得光标\r\n");
      out.write("\t\t flg7 = false; //就弹出提示信息        \r\n");
      out.write("      }else{\r\n");
      out.write("         $(\"#result7\").hide();\r\n");
      out.write("         flg7=true;\r\n");
      out.write("      }\r\n");
      out.write("\t  }\r\n");
      out.write("\t  }\r\n");
      out.write("\t  var flg8=false;\r\n");
      out.write("\tfunction checkval(){\r\n");
      out.write("\t var name = $(\"#validResidencePermit\").val();\r\n");
      out.write("\t var startdate =$(\"#startdate\").val();\r\n");
      out.write("\t var a = /^(\\d{4})-(\\d{2})-(\\d{1,2})$/\t;  \r\n");
      out.write("\t var d1 = new Date(startdate.replace(/\\-/g, \"\\/\"));\r\n");
      out.write("\t var d2 = new Date(name.replace(/\\-/g, \"\\/\"));\r\n");
      out.write("\t if(name.length==0){\r\n");
      out.write("\t         $(\"#result8\").html(\"居留许可有效期不能为空！\");\r\n");
      out.write("\t         $(\"#result8\").show();\r\n");
      out.write("\t         flg8=false;  \r\n");
      out.write("\t }else{\r\n");
      out.write("\t   $(\"#result8\").hide();\r\n");
      out.write("\t   if(!a.test(startdate)){\r\n");
      out.write("\t      $(\"#result8\").html(\"日期格式不正确！\");\r\n");
      out.write("\t      $(\"#result8\").show();\r\n");
      out.write("\t      flg8=false; \r\n");
      out.write("\t   }else{\r\n");
      out.write("\t       $(\"#result8\").hide();\r\n");
      out.write("\t       if(startdate!=\"\"&&name!=\"\"&&d1 >=d2){  \r\n");
      out.write("\t          $(\"#result8\").html(\"居留许可有效期不能早于入学时间！\");\r\n");
      out.write("\t          $(\"#result8\").show();\r\n");
      out.write("\t          flg8=false; \r\n");
      out.write("\t       }else{\r\n");
      out.write("\t          $(\"#result8\").hide();\r\n");
      out.write("\t          flg8=true;\r\n");
      out.write("\t       }\r\n");
      out.write("\t   }\t   \r\n");
      out.write("\t }\r\n");
      out.write("\t}\r\n");
      out.write("\tvar flg9=false;\r\n");
      out.write("\tfunction checkroom(){\r\n");
      out.write("\t   var name = $(\"#roomplace\").val();\r\n");
      out.write("\t   var reg = /^[\\u4e00-\\u9fa5]+$/gi;\r\n");
      out.write("\t   if(name==0){\r\n");
      out.write("\t         $(\"#result9\").html(\"住宿地点不能为空！\");\r\n");
      out.write("\t         $(\"#result9\").show();\r\n");
      out.write("\t         flg9=false; \r\n");
      out.write("\t   }else{\r\n");
      out.write("\t     $(\"#result9\").hide();\r\n");
      out.write("\t     if(!isNaN(name)){\r\n");
      out.write("\t         $(\"#result9\").html(\"住宿地点不能全是数字！\");\r\n");
      out.write("\t         $(\"#result9\").show();\r\n");
      out.write("\t         flg9=false; \r\n");
      out.write("\t     }else{\r\n");
      out.write("\t        $(\"#result9\").hide();\r\n");
      out.write("\t        flg9=true;\r\n");
      out.write("\t     }\r\n");
      out.write("\t   }\r\n");
      out.write("\t}\r\n");
      out.write("\tvar flgtest=false;\r\n");
      out.write("\tfunction checksource(){\r\n");
      out.write("\t   var name = $(\"#source\").val();\r\n");
      out.write("\t   var reg = /^[\\u4e00-\\u9fa5]+$/gi;\r\n");
      out.write("\t   if(name==0){\r\n");
      out.write("\t         $(\"#result10\").html(\"来源不能为空！\");\r\n");
      out.write("\t         $(\"#result10\").show();\r\n");
      out.write("\t         flgtest=false; \r\n");
      out.write("\t   } else{\r\n");
      out.write("\t   if(!reg.test(name)){\r\n");
      out.write("\t         $(\"#result10\").html(\"请输入正确的汉字！\");\r\n");
      out.write("\t         $(\"#result10\").show();\r\n");
      out.write("\t         flgtest=false; \r\n");
      out.write("\t     }else{\r\n");
      out.write("\t        $(\"#result10\").hide();\r\n");
      out.write("\t        flgtest=true;\r\n");
      out.write("\t     }\r\n");
      out.write("\t   }\r\n");
      out.write("\t}\r\n");
      out.write("\tvar flgtest1=false;\r\n");
      out.write("\tfunction checkbrith(){\r\n");
      out.write("\t var start = $(\"#startdate\").val();\r\n");
      out.write("\t var brithdate =$(\"#brithdate\").val();\r\n");
      out.write("\t var a = /^(\\d{4})-(\\d{2})-(\\d{1,2})$/\t\r\n");
      out.write("\t var d1 = new Date(start.replace(/\\-/g, \"\\/\"));\r\n");
      out.write("\t var d2 = new Date(brithdate.replace(/\\-/g, \"\\/\"));\r\n");
      out.write("\t if(brithdate.length==0){\r\n");
      out.write("\t         $(\"#result11\").html(\"出生日期不能为空！\");\r\n");
      out.write("\t         $(\"#result11\").show();\r\n");
      out.write("\t         flgtest1=false;  \r\n");
      out.write("\t }else{\r\n");
      out.write("\t   $(\"#result11\").hide();\r\n");
      out.write("\t   if(start!=\"\"&&brithdate!=\"\"&&d2 >=d1){  \r\n");
      out.write("\t      $(\"#result11\").html(\"出生日期填写有误！\");\r\n");
      out.write("\t      $(\"#result11\").show();\r\n");
      out.write("\t      flgtest1=false; \r\n");
      out.write("\t   }else{\r\n");
      out.write("\t      $(\"#result11\").hide();\r\n");
      out.write("\t      if(!a.test(brithdate)){\r\n");
      out.write("\t         $(\"#result11\").html(\"日期格式不正确！\");\r\n");
      out.write("\t      \t $(\"#result11\").show();\r\n");
      out.write("\t      \t flgtest1=false; \r\n");
      out.write("\t      }else{\r\n");
      out.write("\t         $(\"#result11\").hide();\r\n");
      out.write("\t         var age = jsGetAge(brithdate);\r\n");
      out.write("\t         if (age < 15 || age > 45){\r\n");
      out.write("\t      \t    $(\"#result11\").html(\"年龄必须大于15岁且小于45岁！\");\r\n");
      out.write("\t      \t    $(\"#result11\").show();\r\n");
      out.write("\t      \t    flgtest1=false; \r\n");
      out.write("\t         } else {\r\n");
      out.write("\t      \t    $(\"#result11\").hide();\r\n");
      out.write("\t      \t    flgtest1=true;\r\n");
      out.write("\t         }\r\n");
      out.write("\t      }\r\n");
      out.write("\t     }\t      \r\n");
      out.write("\t   }\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\tfunction jsGetAge(strBirthday)\r\n");
      out.write("\t{       \r\n");
      out.write("\t\tvar returnAge;\r\n");
      out.write("\t\tvar strBirthdayArr=strBirthday.split(\"-\");\r\n");
      out.write("\t\tvar birthYear = strBirthdayArr[0];\r\n");
      out.write("\t\tvar birthMonth = strBirthdayArr[1];\r\n");
      out.write("\t\tvar birthDay = strBirthdayArr[2];\r\n");
      out.write("\t\t\r\n");
      out.write("\t\td = new Date();\r\n");
      out.write("\t\tvar nowYear = d.getFullYear();\r\n");
      out.write("\t\tvar nowMonth = d.getMonth() + 1;\r\n");
      out.write("\t\tvar nowDay = d.getDate()\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tif(nowYear == birthYear)\r\n");
      out.write("\t\t{\t\r\n");
      out.write("\t\t\tif(birthMonth<nowMonth)\r\n");
      out.write("\t\t\t\treturnAge=0;//同年月份为今月前，0岁\r\n");
      out.write("\t\t\telse\r\n");
      out.write("\t\t\t\tif(birthMonth==nowMonth && birthDay<=nowDay)\r\n");
      out.write("\t\t\t\t\treturnAge = 0;//同年同月日期为今天前 0岁\r\n");
      out.write("\t\t\t\telse \r\n");
      out.write("\t\t\t\t\treturnAge = -1;//同年同月但日为今天后或今月后，日期无效\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\telse\r\n");
      out.write("\t\t{\r\n");
      out.write("\t\t\tvar ageDiff = nowYear - birthYear ; //年之差\r\n");
      out.write("\t\t\tif(ageDiff > 0)\r\n");
      out.write("\t\t\t{\r\n");
      out.write("\t\t\t\tif(nowMonth == birthMonth)\r\n");
      out.write("\t\t\t\t{\r\n");
      out.write("\t\t\t\t\tvar dayDiff = nowDay - birthDay;//日之差\r\n");
      out.write("\t\t\t\t\tif(dayDiff < 0)\r\n");
      out.write("\t\t\t\t\t{\r\n");
      out.write("\t\t\t\t\t\treturnAge = ageDiff - 1;\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\telse\r\n");
      out.write("\t\t\t\t\t{\r\n");
      out.write("\t\t\t\t\t\treturnAge = ageDiff ;\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t\telse\r\n");
      out.write("\t\t\t\t{\r\n");
      out.write("\t\t\t\t\tvar monthDiff = nowMonth - birthMonth;//月之差\r\n");
      out.write("\t\t\t\t\tif(monthDiff < 0)\r\n");
      out.write("\t\t\t\t\t{\r\n");
      out.write("\t\t\t\t\t\treturnAge = ageDiff - 1;\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\telse\r\n");
      out.write("\t\t\t\t\t{\r\n");
      out.write("\t\t\t\t\t\treturnAge = ageDiff ;\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\telse\r\n");
      out.write("\t\t\t{\r\n");
      out.write("\t\t\t\treturnAge = -1;//返回-1 表示出生日期输入错误 晚于今天\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\treturn returnAge;//返回周岁年龄\r\n");
      out.write("}\r\n");
      out.write("var flgt = false;\r\n");
      out.write("function checkengname(){\r\n");
      out.write("   var firstname =$(\"#firstname\").val();\r\n");
      out.write("   var lastname = $(\"#lastname\").val();\r\n");
      out.write("   if(firstname.length==0){\r\n");
      out.write("      $(\"#result12\").html(\"英文名不能为空\");\r\n");
      out.write("      $(\"#result12\").show();\r\n");
      out.write("      flgt=false;\r\n");
      out.write("   }else{\r\n");
      out.write("     $(\"#result12\").hide();\r\n");
      out.write("     if(lastname.length==0){\r\n");
      out.write("        $(\"#result12\").html(\"英文姓不能为空\");\r\n");
      out.write("        $(\"#result12\").show();\r\n");
      out.write("        flgt=false;\r\n");
      out.write("     }else{\r\n");
      out.write("        $(\"#result12\").hide();\r\n");
      out.write("        var reg = /^[a-zA-Z]{2,}$/;\r\n");
      out.write("        if(!reg.test(firstname)||!reg.test(lastname)){\r\n");
      out.write("          $(\"#result12\").html(\"英文名或英文姓为两个及以上的字符！\");\r\n");
      out.write("          $(\"#result12\").show();\r\n");
      out.write("          flgt=false;\r\n");
      out.write("        }else{\r\n");
      out.write("        //$(\"#result12\").hide();\r\n");
      out.write("        /// if(firstname.length>=2&&lastname.legnth>=2){\r\n");
      out.write("            $(\"#result12\").hide();\r\n");
      out.write("          flgt=true;\r\n");
      out.write("         //}else{\r\n");
      out.write("          // $(\"#result12\").html(\"请填写大于两个字符的英文名或英文姓！\");\r\n");
      out.write("          // $(\"#result12\").show();\r\n");
      out.write("        // }\r\n");
      out.write("          \r\n");
      out.write("        }\r\n");
      out.write("     }\r\n");
      out.write("   }\r\n");
      out.write("}\r\n");
      out.write("</script>\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write("body{ font-size:12px;}\r\n");
      out.write(".l-table-edit {}\r\n");
      out.write(".l-table-edit-td{ padding:4px;}\r\n");
      out.write(".l-button-submit,.l-button-test{width:80px; float:left; margin-left:10px; padding-bottom:2px;}\r\n");
      out.write(".l-verify-tip{ left:230px; top:120px;}\r\n");
      out.write("#errorLabelContainer{ padding:10px; width:300px; border:1px solid #FF4466; display:none; background:#FFEEEE; color:Red;}\r\n");
      out.write("</style>\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body style=\"padding: 10px\">\r\n");
      out.write("\r\n");
      out.write("\t<form name=\"form1\" method=\"post\" action=\"\" id=\"form1\">\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<input id=\"id\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${student.id }", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\" type=\"hidden\" />\r\n");
      out.write("\t\t<table cellpadding=\"0\" cellspacing=\"0\" class=\"l-table-edit\">\t\t\t\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td align=\"right\" class=\"l-table-edit-td\">英文名:<font color=\"#ff0000\">*</font></td>\r\n");
      out.write("\t\t\t\t<td align=\"left\" class=\"l-table-edit-td\"><input name=\"firstname\"type=\"text\" id=\"firstname\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${student.firstname }", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\" ltype=\"text\" onchange=\"checkengname()\" /></td>\r\n");
      out.write("\t\t\t\t<td align=\"left\"></td>\r\n");
      out.write("\t\t\t\t<td align=\"right\" class=\"l-table-edit-td\">英文姓:<font color=\"#ff0000\">*</font></td>\r\n");
      out.write("\t\t\t\t<td align=\"left\" class=\"l-table-edit-td\"><input name=\"lastname\"type=\"text\" id=\"lastname\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${student.lastname }", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\" onchange=\"checkengname()\" ltype=\"text\" /></td>\r\n");
      out.write("\t\t\t\t<td align=\"left\"><div id=\"result12\" style=\"color: red;\"></div></td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td align=\"right\" class=\"l-table-edit-td\">姓名:<font color=\"#ff0000\">*</font></td>\r\n");
      out.write("\t\t\t\t<td align=\"left\" class=\"l-table-edit-td\"><input name=\"stuname\"type=\"text\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${student.stuname }", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\" onchange=\"checkname()\"  id=\"stuname\" ltype=\"text\" /></td>\r\n");
      out.write("\t\t\t\t<td align=\"left\"><div id=\"result\" style=\"color: red;\"></div></td>\r\n");
      out.write("\t\t\t\t<td align=\"right\" class=\"l-table-edit-td\">国家:<font color=\"#ff0000\">*</font></td>\r\n");
      out.write("\t\t\t\t<td align=\"left\" class=\"l-table-edit-td\"><input name=\"nation\"type=\"text\" id=\"nation\" disabled=\"disabled\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${student.nation }", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\" onchange=\"checknation()\"  ltype=\"text\" /></td>\r\n");
      out.write("\t\t\t\t<td align=\"left\"><div id=\"result1\" style=\"color: red;\"></div></td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t<td align=\"right\" class=\"l-table-edit-td\">护照号:<font color=\"#ff0000\">*</font></td>\r\n");
      out.write("\t\t\t\t<td align=\"left\" class=\"l-table-edit-td\"><input name=\"passport\"type=\"text\" disabled=\"disabled\" onchange=\"checkpassport()\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${student.passport }", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\" id=\"passport\" ltype=\"text\" placeholder=\"请输入护照号\"  /></td>\r\n");
      out.write("\t\t\t\t<td align=\"left\"><div id=\"result2\" style=\"color: red;\"></div></td>\r\n");
      out.write("\t\t\t\t<td align=\"right\" class=\"l-table-edit-td\">学号:</td>\r\n");
      out.write("\t\t\t\t<td align=\"left\" class=\"l-table-edit-td\"><input name=\"stunum\"type=\"text\" id=\"stunum\"  onchange=\"checknum()\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${student.stuid }", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\" ltype=\"text\" /></td>\r\n");
      out.write("\t\t\t\t<td align=\"left\"><div id=\"result3\" style=\"color: red;\"></div></td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td align=\"right\" class=\"l-table-edit-td\" valign=\"top\">性别:</td>\r\n");
      out.write("\t\t\t\t<td align=\"left\" class=\"l-table-edit-td\">\r\n");
      out.write("\t\t\t\t");
      if (_jspx_meth_s_005fif_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t\t\t");
      if (_jspx_meth_s_005fif_005f1(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t<td align=\"left\"></td>\r\n");
      out.write("\t\t\t\t<td align=\"right\" class=\"l-table-edit-td\">班级:</td>\r\n");
      out.write("\t\t\t\t<td align=\"left\" class=\"l-table-edit-td\">\r\n");
      out.write("\t\t\t\t<select name=\"classid\" id=\"classid\" ltype=\"select\">\t\t\t\t   \r\n");
      out.write("\t\t\t\t\t");
      if (_jspx_meth_s_005fiterator_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t\t\t</select></td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td align=\"right\" class=\"l-table-edit-td\">学生类别:<font color=\"#ff0000\">*</font></td>\r\n");
      out.write("\t\t\t\t<td align=\"left\" class=\"l-table-edit-td\"><input name=\"studenttype\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${student.studentType }", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\" onchange=\"checktype()\" type=\"text\" id=\"studenttype\" ltype=\"text\" /></td>\r\n");
      out.write("\t\t\t\t<td align=\"left\"><div id=\"result4\" style=\"color: red;\"></div></td>\r\n");
      out.write("\t\t\t\t<td align=\"right\" class=\"l-table-edit-td\">专业:</td>\r\n");
      out.write("\t\t\t\t<td align=\"left\" class=\"l-table-edit-td\"><input name=\"major\"type=\"text\" id=\"major\" onchange=\"checkmajor()\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${student.classes.major }", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\"  ltype=\"text\" /></td>\r\n");
      out.write("\t\t\t\t<td align=\"left\"><div id=\"result5\" style=\"color: red;\"></div></td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td align=\"right\" class=\"l-table-edit-td\">入学时间:<font color=\"#ff0000\">*</font></td>\r\n");
      out.write("\t\t\t\t<td align=\"left\" class=\"l-table-edit-td\"><input name=\"startdate\"type=\"text\"  value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${student.startdate }", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\" id=\"startdate\" v ltype=\"text\" class=\"date_picker link\" /></td>\r\n");
      out.write("\t\t\t\t<td align=\"left\"></td>\r\n");
      out.write("\t\t\t\t<td align=\"right\" class=\"l-table-edit-td\">离校时间:<font color=\"#ff0000\">*</font></td>\r\n");
      out.write("\t\t\t\t<td align=\"left\" class=\"l-table-edit-td\"><input name=\"enddate\"type=\"text\" onchange=\"checkdate()\" id=\"enddate\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${student.enddate }", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\" ltype=\"text\" class=\"date_picker link\" /></td>\r\n");
      out.write("\t\t\t\t<td align=\"left\"><div id=\"result6\" style=\"color: red;\"></div></td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td align=\"right\" class=\"l-table-edit-td\">联系方式:<font color=\"#ff0000\">*</font></td>\r\n");
      out.write("\t\t\t\t<td align=\"left\" class=\"l-table-edit-td\"><input name=\"telephone\"type=\"text\" id=\"telephone\" onchange=\"checkmobile()\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${student.telephone }", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\" onblur=\"checkmobile()\" ltype=\"text\" /></td>\r\n");
      out.write("\t\t\t\t<td align=\"left\"><div id=\"result7\" style=\"color: red;\"></div></td>\r\n");
      out.write("\t\t\t\t<td align=\"right\" class=\"l-table-edit-td\">居留许可有效期:<font color=\"#ff0000\">*</font></td>\r\n");
      out.write("\t\t\t\t<td align=\"left\" class=\"l-table-edit-td\"><input name=\"validResidencePermit\"type=\"text\" onchange=\"checkval()\" id=\"validResidencePermit\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${student.validResidencePermit }", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\" ltype=\"text\" class=\"date_picker link\" /></td>\r\n");
      out.write("\t\t\t\t<td align=\"left\"><div id=\"result8\" style=\"color: red;\"></div></td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td align=\"right\" class=\"l-table-edit-td\">住宿地点:<font color=\"#ff0000\">*</font></td>\r\n");
      out.write("\t\t\t\t<td align=\"left\" class=\"l-table-edit-td\"><input name=\"roomplace\"type=\"text\" id=\"roomplace\" onchange=\"checkroom()\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${student.roomplace }", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\" ltype=\"text\" /></td>\r\n");
      out.write("\t\t\t\t<td align=\"left\"><div id=\"result9\" style=\"color: red;\"></div></td>\r\n");
      out.write("\t\t\t\t<td align=\"right\" class=\"l-table-edit-td\">学生来源:<font color=\"#ff0000\">*</font></td>\r\n");
      out.write("\t\t\t\t<td align=\"left\" class=\"l-table-edit-td\"><input name=\"source\"type=\"text\" id=\"source\" onchange=\"checksource()\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${student.source }", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\" ltype=\"text\" /></td>\r\n");
      out.write("\t\t\t\t<td align=\"left\"><div id=\"result10\" style=\"color: red;\"></div></td>\r\n");
      out.write("\t\t\t</tr>\t\t \r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td align=\"right\" class=\"l-table-edit-td\">出生年月:<font color=\"#ff0000\">*</font></td>\r\n");
      out.write("\t\t\t\t<td align=\"left\" class=\"l-table-edit-td\"><input name=\"brithdate\"type=\"text\" id=\"brithdate\" onchange=\"checkbrith()\"  value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${student.brithdate }", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\" onchange=\"checkbrith()\" class=\"date_picker link\" ltype=\"text\" /></td>\r\n");
      out.write("\t\t\t\t<td align=\"left\"><div id=\"result11\" style=\"color: red;\"></div></td>\r\n");
      out.write("\t\t\t\t<td align=\"right\" class=\"l-table-edit-td\"></td>\r\n");
      out.write("\t\t\t\t<td align=\"left\" class=\"l-table-edit-td\">\r\n");
      out.write("\t\t\t\t  \r\n");
      out.write("\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t<td align=\"left\"></td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td align=\"right\" class=\"l-table-edit-td\"></td>\r\n");
      out.write("\t\t\t\t<td align=\"left\" class=\"l-table-edit-td\"></td>\r\n");
      out.write("\t\t\t\t<th align=\"left\" colspan=\"2\"><input class=\"l-button l-button-submit\" type=\"submit\" value=\"更&nbsp;新\"/></th>\r\n");
      out.write("\t\t\t\t<td align=\"left\" class=\"l-table-edit-td\"></td>\r\n");
      out.write("\t\t\t\t<td align=\"left\"></td>\t\t\t\t\t\t\t\r\n");
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

  private boolean _jspx_meth_s_005fif_005f0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  s:if
    org.apache.struts2.views.jsp.IfTag _jspx_th_s_005fif_005f0 = (org.apache.struts2.views.jsp.IfTag) _005fjspx_005ftagPool_005fs_005fif_005ftest.get(org.apache.struts2.views.jsp.IfTag.class);
    _jspx_th_s_005fif_005f0.setPageContext(_jspx_page_context);
    _jspx_th_s_005fif_005f0.setParent(null);
    // /WEB-INF/student/studentedit.jsp(572,4) name = test type = java.lang.String reqTime = false required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_s_005fif_005f0.setTest("#student.sex=='男'.toString()");
    int _jspx_eval_s_005fif_005f0 = _jspx_th_s_005fif_005f0.doStartTag();
    if (_jspx_eval_s_005fif_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      if (_jspx_eval_s_005fif_005f0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.pushBody();
        _jspx_th_s_005fif_005f0.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
        _jspx_th_s_005fif_005f0.doInitBody();
      }
      do {
        out.write("\r\n");
        out.write("\t\t\t\t   <input id=\"r1\" type=\"radio\" name=\"rbtnl\" value=\"1\" checked=\"checked\" />\r\n");
        out.write("\t\t\t\t     <label for=\"rbtnl_0\">男</label> \r\n");
        out.write("\t\t\t\t   <input id=\"r2\" type=\"radio\" name=\"rbtnl\" value=\"2\" />\r\n");
        out.write("\t\t\t\t     <label for=\"rbtnl_1\">女</label>\r\n");
        out.write("\t\t\t\t");
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

  private boolean _jspx_meth_s_005fif_005f1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  s:if
    org.apache.struts2.views.jsp.IfTag _jspx_th_s_005fif_005f1 = (org.apache.struts2.views.jsp.IfTag) _005fjspx_005ftagPool_005fs_005fif_005ftest.get(org.apache.struts2.views.jsp.IfTag.class);
    _jspx_th_s_005fif_005f1.setPageContext(_jspx_page_context);
    _jspx_th_s_005fif_005f1.setParent(null);
    // /WEB-INF/student/studentedit.jsp(578,4) name = test type = java.lang.String reqTime = false required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_s_005fif_005f1.setTest("#student.sex=='女'.toString()");
    int _jspx_eval_s_005fif_005f1 = _jspx_th_s_005fif_005f1.doStartTag();
    if (_jspx_eval_s_005fif_005f1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      if (_jspx_eval_s_005fif_005f1 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.pushBody();
        _jspx_th_s_005fif_005f1.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
        _jspx_th_s_005fif_005f1.doInitBody();
      }
      do {
        out.write("\r\n");
        out.write("\t\t\t\t   <input id=\"r1\" type=\"radio\" name=\"rbtnl\" value=\"1\"  />\r\n");
        out.write("\t\t\t\t     <label for=\"rbtnl_0\">男</label> \r\n");
        out.write("\t\t\t\t   <input id=\"r2\" type=\"radio\" name=\"rbtnl\" value=\"2\" checked=\"checked\"/>\r\n");
        out.write("\t\t\t\t     <label for=\"rbtnl_1\">女</label>\r\n");
        out.write("\t\t\t\t");
        int evalDoAfterBody = _jspx_th_s_005fif_005f1.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
      if (_jspx_eval_s_005fif_005f1 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.popBody();
      }
    }
    if (_jspx_th_s_005fif_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fs_005fif_005ftest.reuse(_jspx_th_s_005fif_005f1);
      return true;
    }
    _005fjspx_005ftagPool_005fs_005fif_005ftest.reuse(_jspx_th_s_005fif_005f1);
    return false;
  }

  private boolean _jspx_meth_s_005fiterator_005f0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  s:iterator
    org.apache.struts2.views.jsp.IteratorTag _jspx_th_s_005fiterator_005f0 = (org.apache.struts2.views.jsp.IteratorTag) _005fjspx_005ftagPool_005fs_005fiterator_005fvar_005fvalue.get(org.apache.struts2.views.jsp.IteratorTag.class);
    _jspx_th_s_005fiterator_005f0.setPageContext(_jspx_page_context);
    _jspx_th_s_005fiterator_005f0.setParent(null);
    // /WEB-INF/student/studentedit.jsp(589,5) name = value type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_s_005fiterator_005f0.setValue("#classlist");
    // /WEB-INF/student/studentedit.jsp(589,5) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_s_005fiterator_005f0.setVar("gg");
    int _jspx_eval_s_005fiterator_005f0 = _jspx_th_s_005fiterator_005f0.doStartTag();
    if (_jspx_eval_s_005fiterator_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      if (_jspx_eval_s_005fiterator_005f0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.pushBody();
        _jspx_th_s_005fiterator_005f0.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
        _jspx_th_s_005fiterator_005f0.doInitBody();
      }
      do {
        out.write("\t\r\n");
        out.write("\t\t\t\t\t  ");
        if (_jspx_meth_s_005fif_005f2(_jspx_th_s_005fiterator_005f0, _jspx_page_context))
          return true;
        out.write("\r\n");
        out.write("\t\t\t\t      ");
        if (_jspx_meth_s_005felse_005f0(_jspx_th_s_005fiterator_005f0, _jspx_page_context))
          return true;
        out.write("\t\t\t\t  \r\n");
        out.write("\t\t\t\t\t");
        int evalDoAfterBody = _jspx_th_s_005fiterator_005f0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
      if (_jspx_eval_s_005fiterator_005f0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.popBody();
      }
    }
    if (_jspx_th_s_005fiterator_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fs_005fiterator_005fvar_005fvalue.reuse(_jspx_th_s_005fiterator_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fs_005fiterator_005fvar_005fvalue.reuse(_jspx_th_s_005fiterator_005f0);
    return false;
  }

  private boolean _jspx_meth_s_005fif_005f2(javax.servlet.jsp.tagext.JspTag _jspx_th_s_005fiterator_005f0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  s:if
    org.apache.struts2.views.jsp.IfTag _jspx_th_s_005fif_005f2 = (org.apache.struts2.views.jsp.IfTag) _005fjspx_005ftagPool_005fs_005fif_005ftest.get(org.apache.struts2.views.jsp.IfTag.class);
    _jspx_th_s_005fif_005f2.setPageContext(_jspx_page_context);
    _jspx_th_s_005fif_005f2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_s_005fiterator_005f0);
    // /WEB-INF/student/studentedit.jsp(590,7) name = test type = java.lang.String reqTime = false required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_s_005fif_005f2.setTest("#gg.id==#student.classes.id");
    int _jspx_eval_s_005fif_005f2 = _jspx_th_s_005fif_005f2.doStartTag();
    if (_jspx_eval_s_005fif_005f2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      if (_jspx_eval_s_005fif_005f2 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.pushBody();
        _jspx_th_s_005fif_005f2.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
        _jspx_th_s_005fif_005f2.doInitBody();
      }
      do {
        out.write("\r\n");
        out.write("\t\t\t\t        <option value=\"");
        if (_jspx_meth_s_005fproperty_005f0(_jspx_th_s_005fif_005f2, _jspx_page_context))
          return true;
        out.write("\" selected=\"selected\" >");
        if (_jspx_meth_s_005fproperty_005f1(_jspx_th_s_005fif_005f2, _jspx_page_context))
          return true;
        out.write("</option>\r\n");
        out.write("\t\t\t\t      ");
        int evalDoAfterBody = _jspx_th_s_005fif_005f2.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
      if (_jspx_eval_s_005fif_005f2 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.popBody();
      }
    }
    if (_jspx_th_s_005fif_005f2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fs_005fif_005ftest.reuse(_jspx_th_s_005fif_005f2);
      return true;
    }
    _005fjspx_005ftagPool_005fs_005fif_005ftest.reuse(_jspx_th_s_005fif_005f2);
    return false;
  }

  private boolean _jspx_meth_s_005fproperty_005f0(javax.servlet.jsp.tagext.JspTag _jspx_th_s_005fif_005f2, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  s:property
    org.apache.struts2.views.jsp.PropertyTag _jspx_th_s_005fproperty_005f0 = (org.apache.struts2.views.jsp.PropertyTag) _005fjspx_005ftagPool_005fs_005fproperty_005fvalue_005fnobody.get(org.apache.struts2.views.jsp.PropertyTag.class);
    _jspx_th_s_005fproperty_005f0.setPageContext(_jspx_page_context);
    _jspx_th_s_005fproperty_005f0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_s_005fif_005f2);
    // /WEB-INF/student/studentedit.jsp(591,27) name = value type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_s_005fproperty_005f0.setValue("#gg.id");
    int _jspx_eval_s_005fproperty_005f0 = _jspx_th_s_005fproperty_005f0.doStartTag();
    if (_jspx_th_s_005fproperty_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fs_005fproperty_005fvalue_005fnobody.reuse(_jspx_th_s_005fproperty_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fs_005fproperty_005fvalue_005fnobody.reuse(_jspx_th_s_005fproperty_005f0);
    return false;
  }

  private boolean _jspx_meth_s_005fproperty_005f1(javax.servlet.jsp.tagext.JspTag _jspx_th_s_005fif_005f2, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  s:property
    org.apache.struts2.views.jsp.PropertyTag _jspx_th_s_005fproperty_005f1 = (org.apache.struts2.views.jsp.PropertyTag) _005fjspx_005ftagPool_005fs_005fproperty_005fvalue_005fnobody.get(org.apache.struts2.views.jsp.PropertyTag.class);
    _jspx_th_s_005fproperty_005f1.setPageContext(_jspx_page_context);
    _jspx_th_s_005fproperty_005f1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_s_005fif_005f2);
    // /WEB-INF/student/studentedit.jsp(591,78) name = value type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_s_005fproperty_005f1.setValue("#gg.classname");
    int _jspx_eval_s_005fproperty_005f1 = _jspx_th_s_005fproperty_005f1.doStartTag();
    if (_jspx_th_s_005fproperty_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fs_005fproperty_005fvalue_005fnobody.reuse(_jspx_th_s_005fproperty_005f1);
      return true;
    }
    _005fjspx_005ftagPool_005fs_005fproperty_005fvalue_005fnobody.reuse(_jspx_th_s_005fproperty_005f1);
    return false;
  }

  private boolean _jspx_meth_s_005felse_005f0(javax.servlet.jsp.tagext.JspTag _jspx_th_s_005fiterator_005f0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  s:else
    org.apache.struts2.views.jsp.ElseTag _jspx_th_s_005felse_005f0 = (org.apache.struts2.views.jsp.ElseTag) _005fjspx_005ftagPool_005fs_005felse.get(org.apache.struts2.views.jsp.ElseTag.class);
    _jspx_th_s_005felse_005f0.setPageContext(_jspx_page_context);
    _jspx_th_s_005felse_005f0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_s_005fiterator_005f0);
    int _jspx_eval_s_005felse_005f0 = _jspx_th_s_005felse_005f0.doStartTag();
    if (_jspx_eval_s_005felse_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      if (_jspx_eval_s_005felse_005f0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.pushBody();
        _jspx_th_s_005felse_005f0.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
        _jspx_th_s_005felse_005f0.doInitBody();
      }
      do {
        out.write("\r\n");
        out.write("\t\t\t\t         <option value=\"");
        if (_jspx_meth_s_005fproperty_005f2(_jspx_th_s_005felse_005f0, _jspx_page_context))
          return true;
        out.write('"');
        out.write('>');
        if (_jspx_meth_s_005fproperty_005f3(_jspx_th_s_005felse_005f0, _jspx_page_context))
          return true;
        out.write("</option>\r\n");
        out.write("\t\t\t\t      ");
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

  private boolean _jspx_meth_s_005fproperty_005f2(javax.servlet.jsp.tagext.JspTag _jspx_th_s_005felse_005f0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  s:property
    org.apache.struts2.views.jsp.PropertyTag _jspx_th_s_005fproperty_005f2 = (org.apache.struts2.views.jsp.PropertyTag) _005fjspx_005ftagPool_005fs_005fproperty_005fvalue_005fnobody.get(org.apache.struts2.views.jsp.PropertyTag.class);
    _jspx_th_s_005fproperty_005f2.setPageContext(_jspx_page_context);
    _jspx_th_s_005fproperty_005f2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_s_005felse_005f0);
    // /WEB-INF/student/studentedit.jsp(594,28) name = value type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_s_005fproperty_005f2.setValue("#gg.id");
    int _jspx_eval_s_005fproperty_005f2 = _jspx_th_s_005fproperty_005f2.doStartTag();
    if (_jspx_th_s_005fproperty_005f2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fs_005fproperty_005fvalue_005fnobody.reuse(_jspx_th_s_005fproperty_005f2);
      return true;
    }
    _005fjspx_005ftagPool_005fs_005fproperty_005fvalue_005fnobody.reuse(_jspx_th_s_005fproperty_005f2);
    return false;
  }

  private boolean _jspx_meth_s_005fproperty_005f3(javax.servlet.jsp.tagext.JspTag _jspx_th_s_005felse_005f0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  s:property
    org.apache.struts2.views.jsp.PropertyTag _jspx_th_s_005fproperty_005f3 = (org.apache.struts2.views.jsp.PropertyTag) _005fjspx_005ftagPool_005fs_005fproperty_005fvalue_005fnobody.get(org.apache.struts2.views.jsp.PropertyTag.class);
    _jspx_th_s_005fproperty_005f3.setPageContext(_jspx_page_context);
    _jspx_th_s_005fproperty_005f3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_s_005felse_005f0);
    // /WEB-INF/student/studentedit.jsp(594,58) name = value type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_s_005fproperty_005f3.setValue("#gg.classname");
    int _jspx_eval_s_005fproperty_005f3 = _jspx_th_s_005fproperty_005f3.doStartTag();
    if (_jspx_th_s_005fproperty_005f3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fs_005fproperty_005fvalue_005fnobody.reuse(_jspx_th_s_005fproperty_005f3);
      return true;
    }
    _005fjspx_005ftagPool_005fs_005fproperty_005fvalue_005fnobody.reuse(_jspx_th_s_005fproperty_005f3);
    return false;
  }
}
