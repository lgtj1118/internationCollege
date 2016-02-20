package org.apache.jsp.WEB_002dINF.manage;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;

public final class teacheradd_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fs_005fiterator_005fvalue_005fid;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fs_005fproperty_005fvalue_005fnobody;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fs_005fiterator_005fvalue_005fid = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fs_005fproperty_005fvalue_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fs_005fiterator_005fvalue_005fid.release();
    _005fjspx_005ftagPool_005fs_005fproperty_005fvalue_005fnobody.release();
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
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("/* \t     var eee;\r\n");
      out.write("        $(function ()\r\n");
      out.write("        {\r\n");
      out.write("            $.metadata.setType(\"attr\", \"validate\");\r\n");
      out.write("            var v = $(\"form\").validate({\r\n");
      out.write("                debug: true,\r\n");
      out.write("                errorPlacement: function (lable, element)\r\n");
      out.write("                {\r\n");
      out.write("                    if (element.hasClass(\"l-textarea\"))\r\n");
      out.write("                    {\r\n");
      out.write("                        element.ligerTip({ content: lable.html(), target: element[0] }); \r\n");
      out.write("                    }\r\n");
      out.write("                    else if (element.hasClass(\"l-text-field\"))\r\n");
      out.write("                    {\r\n");
      out.write("                        element.parent().ligerTip({ content: lable.html(), target: element[0] });\r\n");
      out.write("                    }\r\n");
      out.write("                    else\r\n");
      out.write("                    {\r\n");
      out.write("                        lable.appendTo(element.parents(\"td:first\").next(\"td\"));\r\n");
      out.write("                    }\r\n");
      out.write("                },\r\n");
      out.write("                success: function (lable)\r\n");
      out.write("                {\r\n");
      out.write("                    lable.ligerHideTip();\r\n");
      out.write("                    lable.remove();\r\n");
      out.write("                },\r\n");
      out.write("\t\t\t\tsubmitHandler : function(){\r\n");
      out.write("\t\t\t\t\t$(\"form .l-text,.l-textarea\").ligerHideTip();\r\n");
      out.write("\t\t\t\t\tif ((flg1) && (flg2)) {\r\n");
      out.write("\t\t\t\t\t\tvar sexid = 1;\r\n");
      out.write("\t\t\t\t\t\tif (document.getElementById(\"r2\").checked) {\r\n");
      out.write("\t\t\t\t\t\t\tsexid = \"女\";\r\n");
      out.write("\t\t\t\t\t\t} else {\r\n");
      out.write("\t\t\t\t\t\t\tsexid = \"男\";\r\n");
      out.write("\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\t$.post(\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/system/Manage_teacherendadd.action?teacher.identificationnum=\" + $(\"#usernum\").val() + \"&teacher.sex=\" + encodeURI(encodeURI(sexid)) + \"&depid=\" + $(\"#depid\")\r\n");
      out.write("\t\t\t\t\t\t\t\t.val()\r\n");
      out.write("\t\t\t\t\t\t\t//+\"&role=\"+$(\"#role\").val()\t\r\n");
      out.write("\t\t\t\t\t\t\t+ \"&teacher.position=\" + encodeURI(encodeURI($(\"#position option:selected\").val())) + \"&teacher.teachername=\" + encodeURI(encodeURI($(\"#realname\").val())) + \"&teacher.telephone=\" + encodeURI(encodeURI($(\"#telephone\")\r\n");
      out.write("\t\t\t\t\t\t\t\t.val())) + \"&teacher.email=\" + encodeURI(encodeURI($(\"#email\").val())), null, function(){\r\n");
      out.write("\t\t\t\t\t\t\t\talert('添加成功!');\r\n");
      out.write("\t\t\t\t\t\t\t\tparent.m.hide();\r\n");
      out.write("\t\t\t\t\t\t\t\tparent.g.loadData();\r\n");
      out.write("\t\t\t\t\t\t\t});\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t $(\"form\").ligerForm();\r\n");
      out.write("            $(\".l-button-test\").click(function ()\r\n");
      out.write("            {\r\n");
      out.write("                alert(v.element($(\"#txtName\")));\r\n");
      out.write("            });\r\n");
      out.write("        });   */\r\n");
      out.write("        \r\n");
      out.write("    /*     \r\n");
      out.write("    function addTotable (){\r\n");
      out.write("    \t//alert(\"1\");\r\n");
      out.write("    \tif (check()){\r\n");
      out.write("    \t\treturn;\r\n");
      out.write("    \t}\r\n");
      out.write("    \tif (!checkname()){\r\n");
      out.write("    \t\talert(\"not pass\");\r\n");
      out.write("    \t\t$(\"#result\").text(\"姓名必须由2个或以上的中英文字符构成!\");\t\r\n");
      out.write("    \t\treturn;\r\n");
      out.write("    \t}\r\n");
      out.write("    \talert(\"pass\");\r\n");
      out.write("    \tif (checkmobile()){\r\n");
      out.write("    \t\treturn;\r\n");
      out.write("    \t}\r\n");
      out.write("    \tif (checkemail()){\r\n");
      out.write("    \t\treturn;\r\n");
      out.write("    \t}\r\n");
      out.write("    \t\r\n");
      out.write("    \t$.post(\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/system/Manage_teacherendadd.action?teacher.identificationnum=\" + $(\"#usernum\").val() + \"&teacher.sex=\" + encodeURI(encodeURI(sexid)) + \"&depid=\" + $(\"#depid\")\r\n");
      out.write("\t\t\t\t\t\t\t\t.val()\r\n");
      out.write("\t\t\t\t\t\t\t//+\"&role=\"+$(\"#role\").val()\t\r\n");
      out.write("\t\t\t\t\t\t\t+ \"&teacher.position=\" + encodeURI(encodeURI($(\"#position option:selected\").val())) + \"&teacher.teachername=\" + encodeURI(encodeURI($(\"#realname\").val())) + \"&teacher.telephone=\" + encodeURI(encodeURI($(\"#telephone\")\r\n");
      out.write("\t\t\t\t\t\t\t\t.val())) + \"&teacher.email=\" + encodeURI(encodeURI($(\"#email\").val())), null, function(){\r\n");
      out.write("\t\t\t\t\t\t\t\talert('添加成功!');\r\n");
      out.write("\t\t\t\t\t\t\t\tparent.m.hide();\r\n");
      out.write("\t\t\t\t\t\t\t\tparent.g.loadData();\r\n");
      out.write("\t\t\t\t\t\t\t});\r\n");
      out.write("    }\r\n");
      out.write("        \r\n");
      out.write("        \r\n");
      out.write("\tvar flg = true;\r\n");
      out.write("\tfunction check(){\r\n");
      out.write("\t\tvar str = document.getElementById(\"usernum\").value;\r\n");
      out.write("\t\tvar reg = /^(?!0)\\d{8}$/;\r\n");
      out.write("\t\tif (!reg.test(str)) {\r\n");
      out.write("\t\t\t$(\"#result\").html(\"用户编号为不能以0开头的8位数字！\");\r\n");
      out.write("\t\t\t$(\"#result\").show();\r\n");
      out.write("\t\t\tflg = false;\r\n");
      out.write("\t\t\tdocument.regFrm.username.focus();\r\n");
      out.write("\t\t\treturn false;\r\n");
      out.write("\t\t} else {\r\n");
      out.write("\t\t\t$(\"#result\").hide();\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t$.post(\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/system/Manage_teachercheck.action?teacher.identificationnum=\" + $(\"#usernum\").val(), null, function(data){\r\n");
      out.write("\t\t\tif (data == \"fail\") {\r\n");
      out.write("\t\t\t\t$(\"#result\").html(\"该用户编号已经存在!\");\r\n");
      out.write("\t\t\t\t$(\"#result\").show();\r\n");
      out.write("\t\t\t\tflg = false;\r\n");
      out.write("\t\t\t\treturn false;\r\n");
      out.write("\t\t\t} else {\r\n");
      out.write("\t\t\t\t$(\"#result\").hide();\r\n");
      out.write("\t\t\t\treturn true;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t});\r\n");
      out.write("\t}\r\n");
      out.write("\tvar flg1 = true;\r\n");
      out.write("\tfunction checkmobile(){\r\n");
      out.write("\t\tvar isMobile = /^(?:13\\d|15\\d|18\\d)\\d{5}(\\d{3}|\\*{3})$/; //手机号码验证规则\r\n");
      out.write("\t\tvar mobile = document.getElementById(\"telephone\").value;\r\n");
      out.write("\t\tif (!isMobile.test(mobile)) { //如果用户输入的值不同时满足手机号的正则\r\n");
      out.write("\t\t\t$(\"#result\").html(\"请输入正确的11位手机号!\");\r\n");
      out.write("\t\t\t$(\"#result\").show();\r\n");
      out.write("\t\t\t//$(\"#telephone\").focus(); //输入框获得光标\r\n");
      out.write("\t\t\tflg1 = false; //就弹出提示信息      \r\n");
      out.write("\t\t\treturn false;  \r\n");
      out.write("\t\t} else {\r\n");
      out.write("\t\t\t$(\"#result\").hide();\r\n");
      out.write("\t\t\treturn true;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("\tvar flg2 = true;\r\n");
      out.write("\tfunction checkemail(){\r\n");
      out.write("\t\tif (!$(\"#email\").val().match(/^\\w+((-\\w+)|(\\.\\w+))*\\@[A-Za-z0-9]+((\\.|-)[A-Za-z0-9]+)*\\.[A-Za-z0-9]+$/)) {\r\n");
      out.write("\t\t\t$(\"#result\").html(\"请输入正确的邮箱地址!\");\r\n");
      out.write("\t\t\t$(\"#result\").show();\r\n");
      out.write("\t\t\t//$(\"#email\").focus(); //输入框获得光标\r\n");
      out.write("\t\t\tflg2 = false; //就弹出提示信息   \r\n");
      out.write("\t\t\treturn false;\r\n");
      out.write("\t\t} else {\r\n");
      out.write("\t\t\t$(\"#result\").hide();\r\n");
      out.write("\t\t\treturn true;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("\tfunction checkname(){\r\n");
      out.write("\t  var realname = $(\"#realname\").val();\r\n");
      out.write("\t  \r\n");
      out.write("\t  var reg =  /^[a-zA-Z\\u4e00-\\u9fa5]{2,}$/;\r\n");
      out.write("\t  if (!reg.test(realname)) {\r\n");
      out.write("        $(\"#result\").html(\"姓名必须由2个或以上的中英文字符构成!\");\r\n");
      out.write("\t\t$(\"#result\").show();\r\n");
      out.write("\t\treturn false;\r\n");
      out.write("      } else {\r\n");
      out.write("        $(\"#result\").hide();\r\n");
      out.write("        return true;\r\n");
      out.write("      }\r\n");
      out.write("\t} */\r\n");
      out.write("\t\r\n");
      out.write("\t\tfunction clear(){\r\n");
      out.write("\t\t\t$(\"#msg\").text(\" \");\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tfunction err (msg){\r\n");
      out.write("\t\t\t$(\"#msg\").text(msg);\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tfunction submit(){\r\n");
      out.write("\t\t\tvar usernum = $(\"#usernum\");\r\n");
      out.write("\t\t\tvar realname= $(\"#realname\");\r\n");
      out.write("\t\t\tvar telephone = $(\"#telephone\");\r\n");
      out.write("\t\t\tvar email = $(\"#email\");\r\n");
      out.write(" \t\t\t\r\n");
      out.write(" \t\t\tclear();\r\n");
      out.write("\t\t\t/* if (!validate_required(usernum,\" 用户编号不能为空\")){\r\n");
      out.write("\t\t\t\treturn false;\r\n");
      out.write("\t\t\t}*/\r\n");
      out.write("\t\t\tvar reg1 = /^(?!0)\\d{8}$/;\r\n");
      out.write("\t\t\tif(usernum.val()!=null&&usernum.val()!=\"\"){\r\n");
      out.write("\t\t\t  if (!reg1.test(usernum.val())){\r\n");
      out.write("\t\t\t\terr(\"用户编号只能为不以0开始8位数字\");\r\n");
      out.write("\t\t\t\treturn false;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\tif (uniqueChk()) {\r\n");
      out.write("\t\t\t\terr(\"用户编号重复\");\r\n");
      out.write("\t\t\t\treturn;\r\n");
      out.write("\t\t\t}  \r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\tif (!validate_required(realname,\"姓名不能为空\")){\r\n");
      out.write("\t\t\t\treturn false;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\tvar reg = /^[a-zA-Z\\u4e00-\\u9fa5]{2,}$/;\r\n");
      out.write("\t\t\tif(!reg.test(realname.val())){\r\n");
      out.write("\t\t\t\terr(\"姓名由2个以上的中英文字符组成\");\r\n");
      out.write("\t\t\t\treturn;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\tif (!validate_required(telephone,\"电话号码不能为空\")){\r\n");
      out.write("\t\t\t\treturn false;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\tvar reg2 = /^(1(([35][0-9])|(47)|[8][0126789]))\\d{8}$/;\r\n");
      out.write("\t\t\tif(!reg2.test(telephone.val())){\r\n");
      out.write("\t\t\t\terr(\"电话号码格式不正确\");\r\n");
      out.write("\t\t\t\treturn;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\tif (!validate_required(email,\"邮箱不能为空\")){\r\n");
      out.write("\t\t\t\treturn false;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\tvar reg3 = /^\\w+((-\\w+)|(\\.\\w+))*\\@[A-Za-z0-9]+((\\.|-)[A-Za-z0-9]+)*\\.[A-Za-z0-9]+$/;\r\n");
      out.write("\t\t\tif(!reg3.test(email.val())){\r\n");
      out.write("\t\t\t\terr(\"邮箱格式不正确\");\r\n");
      out.write("\t\t\t\treturn;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\tvar sexid = 1;\r\n");
      out.write("\t\t\tif (document.getElementById(\"r2\").checked) {\r\n");
      out.write("\t\t\t\tsexid = \"女\";\r\n");
      out.write("\t\t\t} else {\r\n");
      out.write("\t\t\t\tsexid = \"男\";\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t var url = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/system/Manage_teacherendadd.action?teacher.identificationnum=\" + $(\"#usernum\").val() \r\n");
      out.write("\t\t\t + \"&teacher.sex=\" + encodeURI(encodeURI(sexid)) \r\n");
      out.write("\t\t\t + \"&depid=\" + $(\"#depid\").val()//\r\n");
      out.write("\t\t\t + \"&teacher.position=\" + encodeURI(encodeURI($(\"#position option:selected\").val())) \r\n");
      out.write("\t\t\t + \"&teacher.teachername=\" + encodeURI(encodeURI($(\"#realname\").val())) \r\n");
      out.write("\t\t\t + \"&teacher.telephone=\" + encodeURI(encodeURI($(\"#telephone\").val())) \r\n");
      out.write("\t\t\t + \"&teacher.email=\" + encodeURI(encodeURI($(\"#email\").val()));\r\n");
      out.write("\r\n");
      out.write("    \t\t$.post(url,null,function(){    \t\t\r\n");
      out.write("\t\t       \t//parent.window.location.reload();  \r\n");
      out.write("\t\t       \tparent.g.loadData();  \t\t\r\n");
      out.write("    \t\t\twindow.close(); \t             \r\n");
      out.write("\t\t     });\r\n");
      out.write("\t\t }\r\n");
      out.write("\t\t\r\n");
      out.write("\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tfunction validate_required(ids,alerttxt)\r\n");
      out.write("\t\t{\r\n");
      out.write("\t\t\tif (ids.val() == null || ids.val() == \"\"){\r\n");
      out.write("\t\t\t\t$(\"#msg\").text(alerttxt);\r\n");
      out.write("\t\t\t\tids.focus();\r\n");
      out.write("\t\t\t\treturn false;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\treturn true;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tfunction uniqueChk (){\r\n");
      out.write("\t\t\t$.post(\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/system/Manage_teachercheck.action?teacher.identificationnum=\" + $(\"#usernum\").val(), null, function(data){\r\n");
      out.write("\t\t\tif (data == \"fail\") {\r\n");
      out.write("\t\t\t\treturn false;\r\n");
      out.write("\t\t\t} else {\r\n");
      out.write("\t\t\t\treturn true;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\t}\r\n");
      out.write("</script>\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write("  body{ font-size:12px;}\r\n");
      out.write("        .l-table-edit {}\r\n");
      out.write("        .l-table-edit-td{ padding:4px;}\r\n");
      out.write("        .l-button-submit,.l-button-test{width:80px; float:left; margin-left:10px; padding-bottom:2px;}\r\n");
      out.write("        .l-verify-tip{ left:230px; top:120px;}\r\n");
      out.write("</style>\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body style=\"padding: 10px\">\r\n");
      out.write("\t\t<div id=\"errorLabelContainer\" class=\"l-text-invalid\"></div>\r\n");
      out.write("\t\t<table cellpadding=\"0\" cellspacing=\"0\" class=\"l-table-edit\">\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td align=\"right\" class=\"l-table-edit-td\">教师编号:</td>\r\n");
      out.write("\t\t\t\t<td align=\"left\" class=\"l-table-edit-td\"><input name=\"usernum\"type=\"text\" class=\"required\" id=\"usernum\"  ltype=\"text\" placeholder=\"请输入教师编号\"  nullText=\"不能为空!\" /></td>\r\n");
      out.write("\t\t\t\t<td align=\"left\" ></td>\r\n");
      out.write("\t\t\t</tr>\t\t\t\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td align=\"right\" class=\"l-table-edit-td\">姓名:<font color=\"#ff0000\">*</font></td>\r\n");
      out.write("\t\t\t\t<td align=\"left\" class=\"l-table-edit-td\"><input name=\"realname\"type=\"text\" id=\"realname\" type=\"text\"  /></td>\r\n");
      out.write("\t\t\t\t<td align=\"left\"></td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td align=\"right\" class=\"l-table-edit-td\">电话:<font color=\"#ff0000\">*</font></td>\r\n");
      out.write("\t\t\t\t<td align=\"left\" class=\"l-table-edit-td\"><input name=\"telephone\"type=\"text\"  id=\"telephone\" ltype=\"text\" /></td>\r\n");
      out.write("\t\t\t\t<td align=\"left\"></td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td align=\"right\" class=\"l-table-edit-td\">E-mail:<font color=\"#ff0000\">*</font></td>\r\n");
      out.write("\t\t\t\t<td align=\"left\" class=\"l-table-edit-td\"><input name=\"email\"type=\"text\" id=\"email\"  ltype=\"text\"  /></td>\r\n");
      out.write("\t\t\t\t<td align=\"left\"></td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td align=\"right\" class=\"l-table-edit-td\" valign=\"top\">性别:</td>\r\n");
      out.write("\t\t\t\t<td align=\"left\" class=\"l-table-edit-td\"><input id=\"r1\"\r\n");
      out.write("\t\t\t\t\ttype=\"radio\" name=\"rbtnl\" value=\"1\" checked=\"checked\" /><label\r\n");
      out.write("\t\t\t\t\tfor=\"rbtnl_0\">男</label> <input id=\"r2\" type=\"radio\" name=\"rbtnl\"\r\n");
      out.write("\t\t\t\t\tvalue=\"2\" /><label for=\"rbtnl_1\">女</label></td>\r\n");
      out.write("\t\t\t\t<td align=\"left\"></td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td align=\"right\" class=\"l-table-edit-td\">职称:</td>\r\n");
      out.write("\t\t\t\t<td align=\"left\" class=\"l-table-edit-td\">\r\n");
      out.write("\t\t\t\t<select name=\"position\" id=\"position\" ltype=\"select\" style=\"width:150px;\" >\r\n");
      out.write("\t\t\t\t\t<option value=\"教授\">教授</option>\r\n");
      out.write("\t\t\t\t\t<option value=\"副教授\">副教授</option>\r\n");
      out.write("\t\t\t\t\t<option value=\"讲师\">讲师</option>\r\n");
      out.write("\t\t\t\t</select></td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td align=\"right\" class=\"l-table-edit-td\">部门:</td>\r\n");
      out.write("\t\t\t\t<td align=\"left\" class=\"l-table-edit-td\">\r\n");
      out.write("\t\t\t\t<select name=\"depid\" id=\"depid\" ltype=\"select\" style=\"width:150px;\"  >\r\n");
      out.write("\t\t\t\t\t    ");
      if (_jspx_meth_s_005fiterator_005f0(_jspx_page_context))
        return;
      out.write("\t\t\t\t\t \r\n");
      out.write("\t\t\t\t</select></td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<!-- <tr>\r\n");
      out.write("\t\t\t\t<td align=\"right\" class=\"l-table-edit-td\">角色:</td>\r\n");
      out.write("\t\t\t\t<td align=\"left\" class=\"l-table-edit-td\">\r\n");
      out.write("\t\t\t\t<select  name=\"role\" id=\"role\">  \r\n");
      out.write("                              <option value=\"2\">任课教师</option>       \r\n");
      out.write("                              <option value=\"3\">班主任</option>  \r\n");
      out.write("                </select></td>\r\n");
      out.write("\t\t\t</tr>\t -->\t\t \r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<th align=\"left\" class=\"l-table-edit-td\"colspan=\"3\"></br>注：<font size=\"1\" style=\"font-weight: normal;\" color=\"#ff0080\">用户编号外聘教师无需输入，本校教师必须输入！</font></th>\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t</tr>\t\t\t\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td align=\"right\" class=\"l-table-edit-td\"></td>\r\n");
      out.write("\t\t\t\t<td align=\"left\" class=\"l-table-edit-td\"><br /> <input\r\n");
      out.write("\t\t\t\t\tonclick=\"submit()\" value=\"添&nbsp;&nbsp;加\" id=\"Button1\"\r\n");
      out.write("\t\t\t\t\tclass=\"l-button l-button-submit\" />\r\n");
      out.write("\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t<td align=\"left\">\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t</table>\r\n");
      out.write("\t\t<p id=\"msg\" style=\"color:red\"></p>\r\n");
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

  private boolean _jspx_meth_s_005fiterator_005f0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  s:iterator
    org.apache.struts2.views.jsp.IteratorTag _jspx_th_s_005fiterator_005f0 = (org.apache.struts2.views.jsp.IteratorTag) _005fjspx_005ftagPool_005fs_005fiterator_005fvalue_005fid.get(org.apache.struts2.views.jsp.IteratorTag.class);
    _jspx_th_s_005fiterator_005f0.setPageContext(_jspx_page_context);
    _jspx_th_s_005fiterator_005f0.setParent(null);
    // /WEB-INF/manage/teacheradd.jsp(336,9) name = value type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_s_005fiterator_005f0.setValue("#deptlist");
    // /WEB-INF/manage/teacheradd.jsp(336,9) name = id type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_s_005fiterator_005f0.setId("gg");
    int _jspx_eval_s_005fiterator_005f0 = _jspx_th_s_005fiterator_005f0.doStartTag();
    if (_jspx_eval_s_005fiterator_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      if (_jspx_eval_s_005fiterator_005f0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.pushBody();
        _jspx_th_s_005fiterator_005f0.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
        _jspx_th_s_005fiterator_005f0.doInitBody();
      }
      do {
        out.write("\r\n");
        out.write("\t\t\t\t\t\t\t<option value=\"");
        if (_jspx_meth_s_005fproperty_005f0(_jspx_th_s_005fiterator_005f0, _jspx_page_context))
          return true;
        out.write('"');
        out.write('>');
        if (_jspx_meth_s_005fproperty_005f1(_jspx_th_s_005fiterator_005f0, _jspx_page_context))
          return true;
        out.write("</option>\r\n");
        out.write("\t\t\t\t\t\t");
        int evalDoAfterBody = _jspx_th_s_005fiterator_005f0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
      if (_jspx_eval_s_005fiterator_005f0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.popBody();
      }
    }
    if (_jspx_th_s_005fiterator_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fs_005fiterator_005fvalue_005fid.reuse(_jspx_th_s_005fiterator_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fs_005fiterator_005fvalue_005fid.reuse(_jspx_th_s_005fiterator_005f0);
    return false;
  }

  private boolean _jspx_meth_s_005fproperty_005f0(javax.servlet.jsp.tagext.JspTag _jspx_th_s_005fiterator_005f0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  s:property
    org.apache.struts2.views.jsp.PropertyTag _jspx_th_s_005fproperty_005f0 = (org.apache.struts2.views.jsp.PropertyTag) _005fjspx_005ftagPool_005fs_005fproperty_005fvalue_005fnobody.get(org.apache.struts2.views.jsp.PropertyTag.class);
    _jspx_th_s_005fproperty_005f0.setPageContext(_jspx_page_context);
    _jspx_th_s_005fproperty_005f0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_s_005fiterator_005f0);
    // /WEB-INF/manage/teacheradd.jsp(337,22) name = value type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_s_005fproperty_005f0.setValue("#gg.deptid");
    int _jspx_eval_s_005fproperty_005f0 = _jspx_th_s_005fproperty_005f0.doStartTag();
    if (_jspx_th_s_005fproperty_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fs_005fproperty_005fvalue_005fnobody.reuse(_jspx_th_s_005fproperty_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fs_005fproperty_005fvalue_005fnobody.reuse(_jspx_th_s_005fproperty_005f0);
    return false;
  }

  private boolean _jspx_meth_s_005fproperty_005f1(javax.servlet.jsp.tagext.JspTag _jspx_th_s_005fiterator_005f0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  s:property
    org.apache.struts2.views.jsp.PropertyTag _jspx_th_s_005fproperty_005f1 = (org.apache.struts2.views.jsp.PropertyTag) _005fjspx_005ftagPool_005fs_005fproperty_005fvalue_005fnobody.get(org.apache.struts2.views.jsp.PropertyTag.class);
    _jspx_th_s_005fproperty_005f1.setPageContext(_jspx_page_context);
    _jspx_th_s_005fproperty_005f1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_s_005fiterator_005f0);
    // /WEB-INF/manage/teacheradd.jsp(337,56) name = value type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_s_005fproperty_005f1.setValue("#gg.deptname");
    int _jspx_eval_s_005fproperty_005f1 = _jspx_th_s_005fproperty_005f1.doStartTag();
    if (_jspx_th_s_005fproperty_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fs_005fproperty_005fvalue_005fnobody.reuse(_jspx_th_s_005fproperty_005f1);
      return true;
    }
    _005fjspx_005ftagPool_005fs_005fproperty_005fvalue_005fnobody.reuse(_jspx_th_s_005fproperty_005f1);
    return false;
  }
}
