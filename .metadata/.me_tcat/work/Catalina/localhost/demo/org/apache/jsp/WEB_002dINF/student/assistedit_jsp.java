package org.apache.jsp.WEB_002dINF.student;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;

public final class assistedit_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fs_005fif_005ftest;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fs_005felseif_005ftest;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fs_005fif_005ftest = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fs_005felseif_005ftest = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fs_005fif_005ftest.release();
    _005fjspx_005ftagPool_005fs_005felseif_005ftest.release();
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
      out.write("<title></title>\r\n");
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
      out.write("\t$(function(){\r\n");
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
      out.write("                success: function (lable) {\r\n");
      out.write("                    var element = $(\"#\" + lable.attr(\"for\"));\r\n");
      out.write("                    var nextCell = element.parents(\"td:first\").next(\"td\");\r\n");
      out.write("                    if (element.hasClass(\"l-textarea\")) {\r\n");
      out.write("                        element.removeClass(\"l-textarea-invalid\");\r\n");
      out.write("                    }\r\n");
      out.write("                    else if (element.hasClass(\"l-text-field\")) {\r\n");
      out.write("                        element.parent().removeClass(\"l-text-invalid\");\r\n");
      out.write("                    }\r\n");
      out.write("                    nextCell.find(\"div.l-exclamation\").remove();\r\n");
      out.write("                },\r\n");
      out.write("\t\t\tsubmitHandler : function() {\r\n");
      out.write("\t\t\t\t$(\"form .l-text,.l-textarea\").ligerHideTip();\t\t\t\t\r\n");
      out.write("\t\t\t\tcheckname();\r\n");
      out.write("\t\t\t\tchecknum();\r\n");
      out.write("\t\t\t\tcheckemail();\r\n");
      out.write("\t\t\t\tcheckmobile();\r\n");
      out.write("\t\t\t\tcheckmajor();\r\n");
      out.write("\t\t\t\tchecknation();\r\n");
      out.write("\t\t\t\t//checkbrith()\r\n");
      out.write("\t\t\t\tcheckclass();\r\n");
      out.write("\t\t\t\tif(flg1&&flg2&&flg3&&flg4&&flg5&&flg7&&flg8){\r\n");
      out.write("\t\t\t\t  var sexid=1;\r\n");
      out.write("\t\t\t\tif(document.getElementById(\"r2\").checked){\r\n");
      out.write("\t                 sexid=\"女\";\r\n");
      out.write("                }else{\r\n");
      out.write("                  sexid=\"男\";\r\n");
      out.write("                }\r\n");
      out.write("                var secondlanguagetype = $(\"#secondlanguagetype\").val();\r\n");
      out.write("                var secondlanguagelevel = $(\"#secondlanguagelevel\").val();\r\n");
      out.write("                if(secondlanguagetype.length!=0&&secondlanguagelevel.length!=0){\r\n");
      out.write("                   //  if(flg&&flg1&&flg2){\r\n");
      out.write("                  $.post(\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/system/Class_assistantteacherupdate.action?assistantteacher.classname=\"+ encodeURI(encodeURI($(\"#classname\").val()))\r\n");
      out.write("\t\t        +\"&assistantteacher.id=\"+encodeURI(encodeURI($(\"#id\").val()))\r\n");
      out.write("\t\t        +\"&assistantteacher.major=\"+encodeURI(encodeURI($(\"#major\").val()))\r\n");
      out.write("\t\t        +\"&assistantteacher.name=\"+encodeURI(encodeURI($(\"#name\").val()))\r\n");
      out.write("\t\t        +\"&assistantteacher.department=\"+encodeURI(encodeURI($(\"#department\").val()))\r\n");
      out.write("\t\t        +\"&assistantteacher.nation=\"+encodeURI(encodeURI($(\"#nation\").val()))\r\n");
      out.write("\t\t        +\"&assistantteacher.brithdate=\"+encodeURI(encodeURI($(\"#brithdate\").val()))\r\n");
      out.write("\t\t        +\"&assistantteacher.gender=\"+encodeURI(encodeURI(sexid))\r\n");
      out.write("\t\t        +\"&assistantteacher.politicalstatus=\"+encodeURI(encodeURI($(\"#politicalstatus option:selected\").val()))\r\n");
      out.write("\t\t        +\"&assistantteacher.edulevel=\"+encodeURI(encodeURI($(\"#edulevel option:selected\").val()))\r\n");
      out.write("\t\t        +\"&assistantteacher.assistantnum=\"+encodeURI(encodeURI($(\"#assistnum\").val()))\r\n");
      out.write("\t\t        +\"&assistantteacher.secondlanguagetype=\"+encodeURI(encodeURI($(\"#secondlanguagetype option:selected\").val()))\r\n");
      out.write("\t\t        +\"&assistantteacher.secondlanguagelevel=\"+encodeURI(encodeURI($(\"#secondlanguagelevel option:selected\").val()))\r\n");
      out.write("\t\t        +\"&assistantteacher.telephone=\"+encodeURI(encodeURI($(\"#telephone\").val()))\r\n");
      out.write("\t\t        +\"&assistantteacher.email=\"+encodeURI(encodeURI($(\"#email\").val()))\r\n");
      out.write("\t\t        +\"&assistantteacher.forte=\"+encodeURI(encodeURI($(\"#forte\").val())) ,null,function(){\r\n");
      out.write("\t\t        //alert('申请成功!');\r\n");
      out.write("\t\t        parent.m.hide();\r\n");
      out.write("\t            parent.g.loadData();\r\n");
      out.write("\t\t       });\r\n");
      out.write("               // }\t\t\t\r\n");
      out.write("                }else{\r\n");
      out.write("                  alert(\"请选择外语类型或等级!\");\r\n");
      out.write("                }           \r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t\t   \t\t\t\t\r\n");
      out.write("\t\t\t }\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\t$(\"form\").ligerForm();\r\n");
      out.write("\t\t$(\".l-button-test\").click(function() {\r\n");
      out.write("\t\t\talert(v.element($(\"#txtName\")));\r\n");
      out.write("\t\t});\r\n");
      out.write("\t});\t\r\n");
      out.write("\tfunction changeselect(){\r\n");
      out.write("\t  var type=$(\"#secondlanguagetype\").val();\r\n");
      out.write("\t  var slt=document.getElementById(\"secondlanguagelevel\"); \r\n");
      out.write("\t  //slt.options.remove();\r\n");
      out.write("\t  $('#secondlanguagelevel').empty().append( $(\"<option value='' >---请选择语言级别---</option>\") );\r\n");
      out.write("\t if(type==\"英语\"){\r\n");
      out.write("\t     var objOption=document.createElement(\"OPTION\"); \r\n");
      out.write("         var objOption1=document.createElement(\"OPTION\"); \r\n");
      out.write("         objOption.value='四级';  \r\n");
      out.write("         objOption.text='四级';\r\n");
      out.write("         objOption1.value='六级';  \r\n");
      out.write("         objOption1.text='六级';  \r\n");
      out.write("         slt.add(objOption);\r\n");
      out.write("         slt.add(objOption1);  \r\n");
      out.write("\t }else if(type==\"日语\"){\r\n");
      out.write("\t     var objOption=document.createElement(\"OPTION\"); \r\n");
      out.write("         var objOption1=document.createElement(\"OPTION\");\r\n");
      out.write("         var objOption2=document.createElement(\"OPTION\"); \r\n");
      out.write("         objOption.value='一级';  \r\n");
      out.write("         objOption.text='一级';\r\n");
      out.write("         objOption1.value='二级';  \r\n");
      out.write("         objOption1.text='二级';\r\n");
      out.write("         objOption2.value='三级';  \r\n");
      out.write("         objOption2.text='三级';  \r\n");
      out.write("         slt.add(objOption);\r\n");
      out.write("         slt.add(objOption1);  \r\n");
      out.write("         slt.add(objOption2);  \r\n");
      out.write("\t }\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\tvar flg1 = true;\r\n");
      out.write("\tfunction checkmobile(){\r\n");
      out.write("\t\tvar isMobile = /^(?:13\\d|15\\d|18\\d)\\d{5}(\\d{3}|\\*{3})$/; //手机号码验证规则\r\n");
      out.write("\t\tvar mobile = $(\"#telephone\").val();\r\n");
      out.write("\t\tif (mobile.length == 0) {\r\n");
      out.write("\t\t\t$(\"#result1\").html(\"手机号码不能为空!\");\r\n");
      out.write("\t\t\t$(\"#result1\").show();\r\n");
      out.write("\t\t\t//$(\"#telephone\").focus();       //输入框获得光标\r\n");
      out.write("\t\t\tflg1 = false; //就弹出提示信息        \r\n");
      out.write("\t\t} else {\r\n");
      out.write("\t\t\t$(\"#result1\").hide();\r\n");
      out.write("\t\t\tif (!isMobile.test(mobile)) { //如果用户输入的值不同时满足手机号的正则\r\n");
      out.write("\t\t\t\t$(\"#result1\").html(\"请输入正确的11位手机号!\");\r\n");
      out.write("\t\t\t\t$(\"#result1\").show();\r\n");
      out.write("\t\t\t\t//$(\"#telephone\").focus();       //输入框获得光标\r\n");
      out.write("\t\t\t\tflg1 = false; //就弹出提示信息        \r\n");
      out.write("\t\t\t} else {\r\n");
      out.write("\t\t\t\t$(\"#result1\").hide();\r\n");
      out.write("\t\t\t\tflg1 = true;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("\tvar flg2 = false;\r\n");
      out.write("\tfunction checkemail(){\r\n");
      out.write("\t\tvar email = $(\"#email\").val();\r\n");
      out.write("\t\tif (email.length == 0) {\r\n");
      out.write("\t\t\t$(\"#result2\").html(\"邮箱地址不能为空!\");\r\n");
      out.write("\t\t\t$(\"#result2\").show();\r\n");
      out.write("\t\t\t//$(\"#email\").focus(); //输入框获得光标\r\n");
      out.write("\t\t\tflg2 = false; //就弹出提示信息\r\n");
      out.write("\t\t} else {\r\n");
      out.write("\t\t\t$(\"#result2\").hide();\r\n");
      out.write("\t\t\tif (!$(\"#email\").val().match(/^\\w+((-\\w+)|(\\.\\w+))*\\@[A-Za-z0-9]+((\\.|-)[A-Za-z0-9]+)*\\.[A-Za-z0-9]+$/)) {\r\n");
      out.write("\t\t\t\t$(\"#result2\").html(\"请输入正确的邮箱地址!\");\r\n");
      out.write("\t\t\t\t$(\"#result2\").show();\r\n");
      out.write("\t\t\t\t//$(\"#email\").focus(); //输入框获得光标\r\n");
      out.write("\t\t\t\tflg2 = false; //就弹出提示信息   \r\n");
      out.write("\t\t\t} else {\r\n");
      out.write("\t\t\t\t$(\"#result2\").hide();\r\n");
      out.write("\t\t\t\tflg2 = true;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("\tvar flg = true;\r\n");
      out.write("\tfunction check(){\r\n");
      out.write("\t\tvar type = $(\"#secondlanguagetype option:selected\").val();\r\n");
      out.write("\t\tvar level = $(\"#secondlanguagelevel option:selected\").val()\r\n");
      out.write("\t\tif (type.length == 0 || level.length == 0) {\r\n");
      out.write("\t\t\t$(\"#result\").html(\"请选择语言或级别!\");\r\n");
      out.write("\t\t\t$(\"#result\").show();\r\n");
      out.write("\t\t\tflg = false;\r\n");
      out.write("\t\t} else\r\n");
      out.write("\t\t\t$(\"#result\").hide();\r\n");
      out.write("\t}\r\n");
      out.write("\tvar flg3 = false;\r\n");
      out.write("\tfunction checkname(){\r\n");
      out.write("\t\tvar name = $(\"#name\").val();\r\n");
      out.write("\t\tvar reg = /[\\u4e00-\\u9fa5]/g;\r\n");
      out.write("\t\tif (name.length == 0) {\r\n");
      out.write("\t\t\t$(\"#result3\").html(\"名字不能为空!\");\r\n");
      out.write("\t\t\t$(\"#result3\").show();\r\n");
      out.write("\t\t\tflg3 = false;\r\n");
      out.write("\t\t} else {\r\n");
      out.write("\t\t\t$(\"#result3\").hide();\r\n");
      out.write("\t\t\tif (!reg.test(name)) {\r\n");
      out.write("\t\t\t\t$(\"#result3\").html(\"请填写中文名!\");\r\n");
      out.write("\t\t\t\t$(\"#result3\").show();\r\n");
      out.write("\t\t\t\tflg3 = false;\r\n");
      out.write("\t\t\t} else {\r\n");
      out.write("\t\t\t\t$(\"#result3\").hide();\r\n");
      out.write("\t\t\t\tflg3 = true;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("\tvar flg4 = false;\r\n");
      out.write("\tfunction checknation(){\r\n");
      out.write("\t\tvar name = $(\"#nation\").val();\r\n");
      out.write("\t\tvar reg = /[\\u4e00-\\u9fa5]/g;\r\n");
      out.write("\t\tif (name.length == 0) {\r\n");
      out.write("\t\t\t$(\"#result4\").html(\"民族不能为空!\");\r\n");
      out.write("\t\t\t$(\"#result4\").show();\r\n");
      out.write("\t\t\tflg4 = false;\r\n");
      out.write("\t\t} else {\r\n");
      out.write("\t\t\t$(\"#result4\").hide();\r\n");
      out.write("\t\t\tif (!reg.test(name)) {\r\n");
      out.write("\t\t\t\t$(\"#result4\").html(\"请填写中文!\");\r\n");
      out.write("\t\t\t\t$(\"#result4\").show();\r\n");
      out.write("\t\t\t\tflg4 = false;\r\n");
      out.write("\t\t\t} else {\r\n");
      out.write("\t\t\t\t$(\"#result4\").hide();\r\n");
      out.write("\t\t\t\tflg4 = true;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("\tvar flg5 = false;\r\n");
      out.write("\tfunction checkmajor(){\r\n");
      out.write("\t\tvar name = $(\"#major\").val();\r\n");
      out.write("\t\tif (name.length == 0) {\r\n");
      out.write("\t\t\t$(\"#result5\").html(\"专业不能为空！\");\r\n");
      out.write("\t\t\t$(\"#result5\").show();\r\n");
      out.write("\t\t\tflg5 = false;\r\n");
      out.write("\t\t} else {\r\n");
      out.write("\t\t\tvar reg = /^[\\u4e00-\\u9fa5]+$/gi;\r\n");
      out.write("\t\t\tif (!reg.test(name)) {\r\n");
      out.write("\t\t\t\t$(\"#result5\").html(\"专业只能为中文！\");\r\n");
      out.write("\t\t\t\t$(\"#result5\").show();\r\n");
      out.write("\t\t\t\tflg5 = false;\r\n");
      out.write("\t\t\t} else {\r\n");
      out.write("\t\t\t\t$(\"#result5\").hide();\r\n");
      out.write("\t\t\t\tflg5 = true;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("\tvar flg6=false;\r\n");
      out.write("\tfunction checkbrith(){\r\n");
      out.write("\t var brithdate =$(\"#brithdate\").val();\r\n");
      out.write("\t var d2 = new Date(brithdate.replace(/\\-/g, \"\\/\"));\r\n");
      out.write("\t if(brithdate.length==0){\r\n");
      out.write("\t         $(\"#result6\").html(\"出生日期不能为空！\");\r\n");
      out.write("\t         $(\"#result6\").show();\r\n");
      out.write("\t         flg6=false;  \r\n");
      out.write("\t }else{\r\n");
      out.write("\t  \r\n");
      out.write("\t      \r\n");
      out.write("\t      var age = jsGetAge(brithdate);\r\n");
      out.write("\t      if (age < 15 || age > 45){\r\n");
      out.write("\t      \t$(\"#result6\").html(\"年龄必须大于15岁且小于45岁！\");\r\n");
      out.write("\t      \t$(\"#result6\").show();\r\n");
      out.write("\t      \tflg6=false; \r\n");
      out.write("\t      } else {\r\n");
      out.write("\t      \t$(\"#result6\").hide();\r\n");
      out.write("\t      \tflg6=true;\r\n");
      out.write("\t      }\r\n");
      out.write("\r\n");
      out.write("\t }\r\n");
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
      out.write("\tvar flg7 = false;\r\n");
      out.write("\tfunction checknum(){\r\n");
      out.write("\t\tvar stunum = $(\"#assistnum\").val();\r\n");
      out.write("\t\tif (stunum.length == 0) {\r\n");
      out.write("\t\t\t$(\"#result7\").html(\"学号不能为空！\");\r\n");
      out.write("\t\t\t$(\"#result7\").show();\r\n");
      out.write("\t\t\tflg7 = false;\r\n");
      out.write("\t\t\treturn false;\r\n");
      out.write("\t\t} else {\r\n");
      out.write("\t\t\t$(\"#result7\").hide();\r\n");
      out.write("\t\t\tif (isNaN(stunum)) {\r\n");
      out.write("\t\t\t\t$(\"#result7\").html(\"学号只能为数字！\");\r\n");
      out.write("\t\t\t\t$(\"#result7\").show();\r\n");
      out.write("\t\t\t\tflg7 = false;\r\n");
      out.write("\t\t\t\treturn false;\r\n");
      out.write("\t\t\t} else {\r\n");
      out.write("\t\t\t\t$(\"#result7\").hide();\r\n");
      out.write("\t\t\t\tif(stunum.length!=10){\r\n");
      out.write("\t\t\t\t  $(\"#result7\").html(\"学号只能为10位！\");\r\n");
      out.write("\t\t\t\t   $(\"#result7\").show();\r\n");
      out.write("\t\t\t\t  flg7 = false;\r\n");
      out.write("\t\t\t\t  return false;\r\n");
      out.write("\t\t\t\t}else{\r\n");
      out.write("\t\t\t\t   $(\"#result7\").hide();\r\n");
      out.write("\t\t\t\t   flg7 = true;\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("\tvar flg8 = false;\r\n");
      out.write("\tfunction checkclass(){\r\n");
      out.write("\t\tvar classname = $(\"#classname\").val();\r\n");
      out.write("\t\tif (classname.length == 0) {\r\n");
      out.write("\t\t\t$(\"#result8\").html(\"班级不能为空！\");\r\n");
      out.write("\t\t\t$(\"#result8\").show();\r\n");
      out.write("\t\t\tflg8 = false;\r\n");
      out.write("\t\t\treturn false;\r\n");
      out.write("\t\t} else {\r\n");
      out.write("\t\t\t$(\"#result8\").hide();\r\n");
      out.write("\t\t\tvar reg = /^[0-9a-zA-Z\\u4e00-\\u9fa5]{2,}$/;\r\n");
      out.write("\t\t\t//if (!isNaN(stunum)) {\r\n");
      out.write("\t\t\tif (!reg.test(classname)){\r\n");
      out.write("\t\t\t\t$(\"#result8\").html(\"班级格式不正确！\");\r\n");
      out.write("\t\t\t\t$(\"#result8\").show();\r\n");
      out.write("\t\t\t\tflg8 = false;\r\n");
      out.write("\t\t\t\treturn false;\r\n");
      out.write("\t\t\t} else {\r\n");
      out.write("\t\t\t\t$(\"#result8\").hide();\r\n");
      out.write("\t\t\t\tflg8 = true;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("</script>\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write("body {\r\n");
      out.write("\tfont-size: 12px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".l-table-edit-td {\r\n");
      out.write("\tpadding: 4px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".s {\r\n");
      out.write("\twidth: 61px;\r\n");
      out.write("\theight: 18px;\r\n");
      out.write("\tdisplay: inline-block;\r\n");
      out.write("\tbackground-color: #eeeeee;\r\n");
      out.write("\ttext-align: center;\r\n");
      out.write("\tfont-size: 13px;\r\n");
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
      out.write("</style>\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body style=\"padding: 10px\">\r\n");
      out.write("\r\n");
      out.write("\t<form name=\"form1\" method=\"post\" action=\"\" id=\"form1\">\r\n");
      out.write("\t\t<div align=\"center\"><font size=\"3\" face=\"微软雅黑\"><strong>助理班主任录入</strong></font><br></div>\r\n");
      out.write("\t\t<input id=\"id\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${assist.id }", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\" type=\"hidden\"  />\r\n");
      out.write("\t\t<table cellpadding=\"0\" cellspacing=\"0\" class=\"l-table-edit\">\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td align=\"right\" class=\"l-table-edit-td\">姓名:<font color=\"#ff0000\">*</font></td>\r\n");
      out.write("\t\t\t\t<td align=\"left\" class=\"l-table-edit-td\"><input name=\"name\"type=\"text\" onchange=\"checkname()\" id=\"name\" ltype=\"text\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${assist.name }", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\" placeholder=\"请输入姓名\"  /></td>\r\n");
      out.write("\t\t\t\t<td align=\"right\" width=\"30px;\" ><div id=\"result3\" style=\"color: red;\"></div></td>\r\n");
      out.write("\t\t\t\t<td align=\"right\" class=\"l-table-edit-td\">民族:<font color=\"#ff0000\">*</font></td>\r\n");
      out.write("\t\t\t\t<td align=\"left\" class=\"l-table-edit-td\"><input name=\"nation\"type=\"text\" onchange=\"checknation()\" id=\"nation\" ltype=\"text\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${assist.nation }", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\" placeholder=\"请输入民族\" /></td>\t\t\t\t\r\n");
      out.write("\t\t\t\t<td align=\"left\"></td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td align=\"right\" class=\"l-table-edit-td\">学号:<font color=\"#ff0000\">*</font></td>\r\n");
      out.write("\t\t\t\t<td align=\"left\" class=\"l-table-edit-td\"><input name=\"assistnum\"type=\"text\" onchange=\"checknum()\" style=\"width: 175px;\" id=\"assistnum\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${assist.assistantnum }", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\" placeholder=\"请输入学号\" ltype=\"text\" /></td>\r\n");
      out.write("\t\t\t\t<td align=\"right\" ><div id=\"result7\" style=\"color: red;\"></div></td>\r\n");
      out.write("\t\t\t\t<td align=\"right\" class=\"l-table-edit-td\">班级:<font color=\"#ff0000\">*</font></td>\r\n");
      out.write("\t\t\t\t<td align=\"left\" class=\"l-table-edit-td\"><input name=\"classname\"type=\"text\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${assist.classname }", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\"  id=\"classname\" onchange=\"checkclass()\" style=\"width: 175px;\"  ltype=\"text\" placeholder=\"请输入班级名称\"  /></td>\t\t\t\t\r\n");
      out.write("\t\t\t\t<td align=\"left\"><div id=\"result8\" style=\"color: red;\"></div></td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td align=\"right\" class=\"l-table-edit-td\">联系方式:<font color=\"#ff0000\">*</font></td>\r\n");
      out.write("\t\t\t\t<td align=\"left\" class=\"l-table-edit-td\"><input name=\"telephone\"type=\"text\" id=\"telephone\"  value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${assist.telephone }", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\" ltype=\"text\" placeholder=\"手机号码\"  onchange=\"checkmobile()\"  /></td>\r\n");
      out.write("\t\t\t\t<td align=\"right\" ><div id=\"result1\" style=\"color: red;\"></div></td>\r\n");
      out.write("\t\t\t\t<td align=\"right\" class=\"l-table-edit-td\">邮箱:<font color=\"#ff0000\">*</font></td>\r\n");
      out.write("\t\t\t\t<td align=\"left\" class=\"l-table-edit-td\"><input name=\"email\"type=\"text\"  id=\"email\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${assist.email }", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\" ltype=\"text\" placeholder=\"邮箱\" onchange=\"checkemail()\"  /></td>\t\t\t\t\r\n");
      out.write("\t\t\t\t<td align=\"left\"><div id=\"result2\" style=\"color: red;\"></div></td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td align=\"right\" class=\"l-table-edit-td\">出生年月:</td>\r\n");
      out.write("\t\t\t\t<td align=\"left\" class=\"l-table-edit-td\"><input name=\"brithdate\"type=\"text\" onchange=\"checkbrith()\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${assist.brithdate }", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\" id=\"brithdate\" ltype=\"text\" placeholder=\"格式：1900-00-00\" class=\"date_picker link\"  /></td>\r\n");
      out.write("\t\t\t\t<td align=\"right\" ><div id=\"result6\" style=\"color: red;\"></div></td>\r\n");
      out.write("\t\t\t\t<td align=\"right\" class=\"l-table-edit-td\">性别:</td>\r\n");
      out.write("\t\t\t\t");
      if (_jspx_meth_s_005fif_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t\t\t");
      if (_jspx_meth_s_005felseif_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td align=\"right\" class=\"l-table-edit-td\">政治面貌:</td>\r\n");
      out.write("\t\t\t\t<td align=\"left\" class=\"l-table-edit-td\">\r\n");
      out.write("\t\t\t\t  ");
      if (_jspx_meth_s_005fif_005f1(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t\t\t  ");
      if (_jspx_meth_s_005felseif_005f1(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("                <td align=\"right\" ></td>\t\r\n");
      out.write("\t\t\t\t<td align=\"right\" class=\"l-table-edit-td\">层次（本/硕）:</td>\r\n");
      out.write("\t\t\t\t<td align=\"left\" class=\"l-table-edit-td\">\r\n");
      out.write("                    ");
      if (_jspx_meth_s_005fif_005f2(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t\t\t  ");
      if (_jspx_meth_s_005felseif_005f2(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("                </td>\t\t\t\t\r\n");
      out.write("\t\t\t\t<td align=\"left\"></td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td align=\"right\" class=\"l-table-edit-td\">学院:</td>\r\n");
      out.write("\t\t\t\t<td align=\"left\" class=\"l-table-edit-td\">\r\n");
      out.write("\t\t\t\t <select type=\"select\" id=\"department\"  style=\"width: 180px;\"  >\r\n");
      out.write("\t\t\t\t   <option value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${assist.department }", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write(" \" selected=\"selected\" >");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${assist.department }", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write(" </option>\r\n");
      out.write("\t\t\t\t   <option value=\"国际教育学院 \" >国际教育学院 </option>\r\n");
      out.write("\t\t\t\t   <option value=\"纺织学院\" >纺织学院</option>\r\n");
      out.write("\t\t\t\t   <option value=\"材料科学与工程学院\" >材料科学与工程学院</option>\r\n");
      out.write("\t\t\t\t   <option value=\"环境与化学工程学院\" >环境与化学工程学院</option>\r\n");
      out.write("\t\t\t\t   <option value=\"机械工程学院\" >机械工程学院</option>\r\n");
      out.write("\t\t\t\t   <option value=\"计算机科学与软件学院\" >计算机科学与软件学院</option>\r\n");
      out.write("                   <option value=\"电气工程与自动化学院 \" >电气工程与自动化学院 </option>\r\n");
      out.write("\t\t\t\t   <option value=\"电子与信息工程学院 \" >电子与信息工程学院 </option>\r\n");
      out.write("\t\t\t\t   <option value=\"理学院\" >理学院</option>\r\n");
      out.write("\t\t\t\t   <option value=\"艺术与服装学院\" >艺术与服装学院</option>\r\n");
      out.write("\t\t\t\t   <option value=\"管理学院 \" >管理学院 </option>\r\n");
      out.write("\t\t\t\t   <option value=\"经济学院\" >经济学院</option>\r\n");
      out.write("\t\t\t\t   <option value=\"人文与法学院\" >人文与法学院</option>\r\n");
      out.write("\t\t\t\t   <option value=\"外国语学院 \" >外国语学院 </option>\r\n");
      out.write("\t\t\t\t   <option value=\"马克思主义学院\" >马克思主义学院</option>\r\n");
      out.write("\t\t\t\t   <option value=\"应用技术学院\" >应用技术学院</option>\r\n");
      out.write("\t\t\t\t   <option value=\"继续教育学院\" >继续教育学院</option>\r\n");
      out.write("\t\t\t\t   \r\n");
      out.write("\t\t\t\t </select> \r\n");
      out.write("\t\t\t\t</td>\t\t\r\n");
      out.write("\t\t\t\t<td align=\"right\" ></td>\t\t\t\t\r\n");
      out.write("\t\t\t\t<td align=\"right\" class=\"l-table-edit-td\">专业:<font color=\"#ff0000\">*</font></td>\r\n");
      out.write("\t\t\t\t<td align=\"left\" class=\"l-table-edit-td\"><input name=\"major\"type=\"text\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${assist.major }", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\" onchange=\"checkmajor()\" style=\"width: 175px;\" id=\"major\" ltype=\"text\"/></td>\r\n");
      out.write("\t\t\t\t<td align=\"left\"><div id=\"result5\" style=\"color: red;\"></div></td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td align=\"right\" class=\"l-table-edit-td\">外语语种:</td>\r\n");
      out.write("\t\t\t\t<td align=\"left\" class=\"l-table-edit-td\">\r\n");
      out.write("\t\t\t\t<!-- <input name=\"secondlanguagetype\"type=\"text\" id=\"secondlanguagetype\" ltype=\"text\"validate=\"{required:true,minlength:1,maxlength:20}\" type=\"hidden\" /> -->\r\n");
      out.write("\t\t\t\t <select id=\"secondlanguagetype\" onchange=\"changeselect()\" style=\"width: 180px;\" onblur=\"check()\" >\r\n");
      out.write("\t\t\t\t    ");
      if (_jspx_meth_s_005fif_005f3(_jspx_page_context))
        return;
      out.write(" \r\n");
      out.write("\t\t\t\t    ");
      if (_jspx_meth_s_005felseif_005f3(_jspx_page_context))
        return;
      out.write("                   \r\n");
      out.write("\t\t\t\t </select>\t\t\t\r\n");
      out.write("\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t<td align=\"right\" ></td>\r\n");
      out.write("\t\t\t\t<td align=\"right\" class=\"l-table-edit-td\">外语水平:</td>\r\n");
      out.write("\t\t\t\t<td align=\"left\" class=\"l-table-edit-td\">\r\n");
      out.write("\t\t\t\t<!-- <input name=\"secondlanguagelevel\"type=\"hidden\"  id=\"secondlanguagelevel\" ltype=\"text\" placeholder=\"外语水平\" validate=\"{required:true,minlength:1,maxlength:20}\" /> -->\r\n");
      out.write("\t\t\t\t<select  id=\"secondlanguagelevel\" style=\"width: 180px;\" onblur=\"check()\" >\r\n");
      out.write("\t\t\t\t   <option value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${assist.secondlanguagelevel }", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write('"');
      out.write(' ');
      out.write('>');
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${assist.secondlanguagelevel }", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("</option>\r\n");
      out.write("\t\t\t\t</select>\t\t\t\t\r\n");
      out.write("\t\t\t\t</td>\t\t\t\t\r\n");
      out.write("\t\t\t\t<td align=\"left\"></td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<th align=\"right\" class=\"l-table-edit-td\">特长:</td>\r\n");
      out.write("\t\t\t\t<th align=\"left\" class=\"l-table-edit-td\" colspan=\"4\"><textarea id=\"forte\" style=\"width: 450px;height: 150px;\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${assist.forte }", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("</textarea></th>\t\t\t\t\r\n");
      out.write("\t\t\t\t<td align=\"left\"></td>\r\n");
      out.write("\t\t\t</tr>\t\t\t \t\t\t\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td align=\"right\" class=\"l-table-edit-td\"></td>\r\n");
      out.write("\t\t\t\t<td align=\"left\"><div id=\"result2\" style=\"color: red;\"></div></td>\r\n");
      out.write("\t\t\t\t<td align=\"left\" class=\"l-table-edit-td\"></td>\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<th align=\"center\" class=\"l-table-edit-td\"colspan=\"3\"><div id=\"result\" style=\"color: red;\"></div></th>\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td align=\"right\" class=\"l-table-edit-td\"></td>\r\n");
      out.write("\t\t\t\t<td align=\"right\" class=\"l-table-edit-td\"></td>\r\n");
      out.write("\t\t\t\t<td align=\"center\" class=\"l-table-edit-td\" style=\"text-align: center;\" ><br /><input type=\"submit\" value=\"更&nbsp;&nbsp;新\" id=\"Button1\" class=\"l-button l-button-submit\" /> </td>\r\n");
      out.write("\t\t\t\t<td align=\"right\" class=\"l-table-edit-td\"></td>\r\n");
      out.write("\t\t\t\t<td align=\"left\">&nbsp;\r\n");
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
    // /WEB-INF/student/assistedit.jsp(476,4) name = test type = java.lang.String reqTime = false required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_s_005fif_005f0.setTest("#assist.gender=='男'.toString()");
    int _jspx_eval_s_005fif_005f0 = _jspx_th_s_005fif_005f0.doStartTag();
    if (_jspx_eval_s_005fif_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      if (_jspx_eval_s_005fif_005f0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.pushBody();
        _jspx_th_s_005fif_005f0.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
        _jspx_th_s_005fif_005f0.doInitBody();
      }
      do {
        out.write("\r\n");
        out.write("\t\t\t\t   <td align=\"left\" class=\"l-table-edit-td\"><input id=\"r1\" type=\"radio\" name=\"rbtnl\" value=\"1\" checked=\"checked\" />\r\n");
        out.write("\t\t\t\t      <label for=\"rbtnl_0\">男</label> \r\n");
        out.write("\t\t\t\t       <input id=\"r2\" type=\"radio\" name=\"rbtnl\" value=\"2\" />\r\n");
        out.write("\t\t\t\t      <label for=\"rbtnl_1\">女</label></td>\t\t\t\t\r\n");
        out.write("\t\t\t\t   <td align=\"left\"></td>\r\n");
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

  private boolean _jspx_meth_s_005felseif_005f0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  s:elseif
    org.apache.struts2.views.jsp.ElseIfTag _jspx_th_s_005felseif_005f0 = (org.apache.struts2.views.jsp.ElseIfTag) _005fjspx_005ftagPool_005fs_005felseif_005ftest.get(org.apache.struts2.views.jsp.ElseIfTag.class);
    _jspx_th_s_005felseif_005f0.setPageContext(_jspx_page_context);
    _jspx_th_s_005felseif_005f0.setParent(null);
    // /WEB-INF/student/assistedit.jsp(483,4) name = test type = java.lang.String reqTime = false required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_s_005felseif_005f0.setTest("#assist.gender=='女'.toString()");
    int _jspx_eval_s_005felseif_005f0 = _jspx_th_s_005felseif_005f0.doStartTag();
    if (_jspx_eval_s_005felseif_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      if (_jspx_eval_s_005felseif_005f0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.pushBody();
        _jspx_th_s_005felseif_005f0.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
        _jspx_th_s_005felseif_005f0.doInitBody();
      }
      do {
        out.write("\r\n");
        out.write("\t\t\t\t   <td align=\"left\" class=\"l-table-edit-td\">\r\n");
        out.write("\t\t\t\t   <input id=\"r1\" type=\"radio\" name=\"rbtnl\" value=\"1\"  />\r\n");
        out.write("\t\t\t\t      <label for=\"rbtnl_0\">男</label> \r\n");
        out.write("\t\t\t\t       <input id=\"r2\" type=\"radio\" name=\"rbtnl\" value=\"2\" checked=\"checked\" />\r\n");
        out.write("\t\t\t\t      <label for=\"rbtnl_1\">女</label></td>\t\t\t\t\r\n");
        out.write("\t\t\t\t   <td align=\"left\"></td>\r\n");
        out.write("\t\t\t\t");
        int evalDoAfterBody = _jspx_th_s_005felseif_005f0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
      if (_jspx_eval_s_005felseif_005f0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.popBody();
      }
    }
    if (_jspx_th_s_005felseif_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fs_005felseif_005ftest.reuse(_jspx_th_s_005felseif_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fs_005felseif_005ftest.reuse(_jspx_th_s_005felseif_005f0);
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
    // /WEB-INF/student/assistedit.jsp(496,6) name = test type = java.lang.String reqTime = false required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_s_005fif_005f1.setTest("#assist.politicalstatus=='党员'.toString()");
    int _jspx_eval_s_005fif_005f1 = _jspx_th_s_005fif_005f1.doStartTag();
    if (_jspx_eval_s_005fif_005f1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      if (_jspx_eval_s_005fif_005f1 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.pushBody();
        _jspx_th_s_005fif_005f1.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
        _jspx_th_s_005fif_005f1.doInitBody();
      }
      do {
        out.write("\r\n");
        out.write("\t\t\t\t     <select id=\"politicalstatus\" style=\"width: 180px;\" name=\"politicalstatus\"  ltype=\"select\">\r\n");
        out.write("                       <option value=\"党员\" selected=\"selected\" >党员</option>\r\n");
        out.write("                       <option value=\"团员\" >团员</option>\r\n");
        out.write("                   </select>\r\n");
        out.write("\t\t\t\t  ");
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

  private boolean _jspx_meth_s_005felseif_005f1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  s:elseif
    org.apache.struts2.views.jsp.ElseIfTag _jspx_th_s_005felseif_005f1 = (org.apache.struts2.views.jsp.ElseIfTag) _005fjspx_005ftagPool_005fs_005felseif_005ftest.get(org.apache.struts2.views.jsp.ElseIfTag.class);
    _jspx_th_s_005felseif_005f1.setPageContext(_jspx_page_context);
    _jspx_th_s_005felseif_005f1.setParent(null);
    // /WEB-INF/student/assistedit.jsp(502,6) name = test type = java.lang.String reqTime = false required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_s_005felseif_005f1.setTest("#assist.politicalstatus=='团员'.toString()");
    int _jspx_eval_s_005felseif_005f1 = _jspx_th_s_005felseif_005f1.doStartTag();
    if (_jspx_eval_s_005felseif_005f1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      if (_jspx_eval_s_005felseif_005f1 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.pushBody();
        _jspx_th_s_005felseif_005f1.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
        _jspx_th_s_005felseif_005f1.doInitBody();
      }
      do {
        out.write("\r\n");
        out.write("\t\t\t\t     <select id=\"politicalstatus\" style=\"width: 180px;\" name=\"politicalstatus\"  ltype=\"select\">\r\n");
        out.write("                       <option value=\"党员\"  >党员</option>\r\n");
        out.write("                       <option value=\"团员\" selected=\"selected\" >团员</option>\r\n");
        out.write("                   </select>\r\n");
        out.write("\t\t\t\t  ");
        int evalDoAfterBody = _jspx_th_s_005felseif_005f1.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
      if (_jspx_eval_s_005felseif_005f1 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.popBody();
      }
    }
    if (_jspx_th_s_005felseif_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fs_005felseif_005ftest.reuse(_jspx_th_s_005felseif_005f1);
      return true;
    }
    _005fjspx_005ftagPool_005fs_005felseif_005ftest.reuse(_jspx_th_s_005felseif_005f1);
    return false;
  }

  private boolean _jspx_meth_s_005fif_005f2(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  s:if
    org.apache.struts2.views.jsp.IfTag _jspx_th_s_005fif_005f2 = (org.apache.struts2.views.jsp.IfTag) _005fjspx_005ftagPool_005fs_005fif_005ftest.get(org.apache.struts2.views.jsp.IfTag.class);
    _jspx_th_s_005fif_005f2.setPageContext(_jspx_page_context);
    _jspx_th_s_005fif_005f2.setParent(null);
    // /WEB-INF/student/assistedit.jsp(511,20) name = test type = java.lang.String reqTime = false required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_s_005fif_005f2.setTest("#assist.edulevel=='硕士'.toString()");
    int _jspx_eval_s_005fif_005f2 = _jspx_th_s_005fif_005f2.doStartTag();
    if (_jspx_eval_s_005fif_005f2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      if (_jspx_eval_s_005fif_005f2 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.pushBody();
        _jspx_th_s_005fif_005f2.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
        _jspx_th_s_005fif_005f2.doInitBody();
      }
      do {
        out.write("\r\n");
        out.write("\t\t\t\t     <select id=\"edulevel\" style=\"width: 180px;\" name=\"edulevel\"  ltype=\"select\">\r\n");
        out.write("                       <option value=\"硕士\" selected=\"selected\" >硕士</option>\r\n");
        out.write("                       <option value=\"本科\" >本科</option>\r\n");
        out.write("                   </select>\r\n");
        out.write("\t\t\t\t  ");
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

  private boolean _jspx_meth_s_005felseif_005f2(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  s:elseif
    org.apache.struts2.views.jsp.ElseIfTag _jspx_th_s_005felseif_005f2 = (org.apache.struts2.views.jsp.ElseIfTag) _005fjspx_005ftagPool_005fs_005felseif_005ftest.get(org.apache.struts2.views.jsp.ElseIfTag.class);
    _jspx_th_s_005felseif_005f2.setPageContext(_jspx_page_context);
    _jspx_th_s_005felseif_005f2.setParent(null);
    // /WEB-INF/student/assistedit.jsp(517,6) name = test type = java.lang.String reqTime = false required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_s_005felseif_005f2.setTest("#assist.edulevel=='本科'.toString()");
    int _jspx_eval_s_005felseif_005f2 = _jspx_th_s_005felseif_005f2.doStartTag();
    if (_jspx_eval_s_005felseif_005f2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      if (_jspx_eval_s_005felseif_005f2 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.pushBody();
        _jspx_th_s_005felseif_005f2.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
        _jspx_th_s_005felseif_005f2.doInitBody();
      }
      do {
        out.write("\r\n");
        out.write("\t\t\t\t     <select id=\"edulevel\" style=\"width: 180px;\" name=\"edulevel\"  ltype=\"select\">\r\n");
        out.write("                       <option value=\"硕士\"  >硕士</option>\r\n");
        out.write("                       <option value=\"本科\" selected=\"selected\" >本科</option>\r\n");
        out.write("                   </select>\r\n");
        out.write("\t\t\t\t  ");
        int evalDoAfterBody = _jspx_th_s_005felseif_005f2.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
      if (_jspx_eval_s_005felseif_005f2 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.popBody();
      }
    }
    if (_jspx_th_s_005felseif_005f2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fs_005felseif_005ftest.reuse(_jspx_th_s_005felseif_005f2);
      return true;
    }
    _005fjspx_005ftagPool_005fs_005felseif_005ftest.reuse(_jspx_th_s_005felseif_005f2);
    return false;
  }

  private boolean _jspx_meth_s_005fif_005f3(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  s:if
    org.apache.struts2.views.jsp.IfTag _jspx_th_s_005fif_005f3 = (org.apache.struts2.views.jsp.IfTag) _005fjspx_005ftagPool_005fs_005fif_005ftest.get(org.apache.struts2.views.jsp.IfTag.class);
    _jspx_th_s_005fif_005f3.setPageContext(_jspx_page_context);
    _jspx_th_s_005fif_005f3.setParent(null);
    // /WEB-INF/student/assistedit.jsp(562,8) name = test type = java.lang.String reqTime = false required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_s_005fif_005f3.setTest("#assist.secondlanguagetype=='英语'.toString()");
    int _jspx_eval_s_005fif_005f3 = _jspx_th_s_005fif_005f3.doStartTag();
    if (_jspx_eval_s_005fif_005f3 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      if (_jspx_eval_s_005fif_005f3 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.pushBody();
        _jspx_th_s_005fif_005f3.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
        _jspx_th_s_005fif_005f3.doInitBody();
      }
      do {
        out.write("\r\n");
        out.write("\t\t\t\t       <option value=\"英语\" selected=\"selected\" >英语</option>\r\n");
        out.write("\t\t\t\t       <option value=\"日语\" >日语</option>\r\n");
        out.write("\t\t\t\t    ");
        int evalDoAfterBody = _jspx_th_s_005fif_005f3.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
      if (_jspx_eval_s_005fif_005f3 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.popBody();
      }
    }
    if (_jspx_th_s_005fif_005f3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fs_005fif_005ftest.reuse(_jspx_th_s_005fif_005f3);
      return true;
    }
    _005fjspx_005ftagPool_005fs_005fif_005ftest.reuse(_jspx_th_s_005fif_005f3);
    return false;
  }

  private boolean _jspx_meth_s_005felseif_005f3(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  s:elseif
    org.apache.struts2.views.jsp.ElseIfTag _jspx_th_s_005felseif_005f3 = (org.apache.struts2.views.jsp.ElseIfTag) _005fjspx_005ftagPool_005fs_005felseif_005ftest.get(org.apache.struts2.views.jsp.ElseIfTag.class);
    _jspx_th_s_005felseif_005f3.setPageContext(_jspx_page_context);
    _jspx_th_s_005felseif_005f3.setParent(null);
    // /WEB-INF/student/assistedit.jsp(566,8) name = test type = java.lang.String reqTime = false required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_s_005felseif_005f3.setTest("#assist.secondlanguagetype=='日语'.toString()");
    int _jspx_eval_s_005felseif_005f3 = _jspx_th_s_005felseif_005f3.doStartTag();
    if (_jspx_eval_s_005felseif_005f3 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      if (_jspx_eval_s_005felseif_005f3 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.pushBody();
        _jspx_th_s_005felseif_005f3.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
        _jspx_th_s_005felseif_005f3.doInitBody();
      }
      do {
        out.write("\r\n");
        out.write("\t\t\t\t       <option value=\"英语\"  >英语</option>\r\n");
        out.write("\t\t\t\t       <option value=\"日语\" selected=\"selected\" >日语</option>\r\n");
        out.write("\t\t\t\t    ");
        int evalDoAfterBody = _jspx_th_s_005felseif_005f3.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
      if (_jspx_eval_s_005felseif_005f3 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.popBody();
      }
    }
    if (_jspx_th_s_005felseif_005f3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fs_005felseif_005ftest.reuse(_jspx_th_s_005felseif_005f3);
      return true;
    }
    _005fjspx_005ftagPool_005fs_005felseif_005ftest.reuse(_jspx_th_s_005felseif_005f3);
    return false;
  }
}
