package org.apache.jsp.WEB_002dINF.course;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;

public final class courseadd_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\r\n");
      out.write("<html xmlns=\"http://www.w3.org/1999/xhtml\">\r\n");
      out.write("<head>\r\n");
      out.write("<title>天津工业大学排课管理系统</title>\r\n");
      out.write("\r\n");
      out.write("<script src=\"");
      out.print(basePath);
      out.write("js/jquery/jquery-1.6.min.js\" type=\"text/javascript\"></script>\r\n");
      out.write("<script src=\"");
      out.print(basePath);
      out.write("js/ligerUI/core/base.js\" type=\"text/javascript\"></script>\r\n");
      out.write("\r\n");
      out.write("<script src=\"");
      out.print(basePath);
      out.write("js/ligerUI/plugins/ligerTip.js\" type=\"text/javascript\"></script>\r\n");
      out.write("<script src=\"");
      out.print(basePath);
      out.write("js/jquery-validation/jquery.validate.js\"type=\"text/javascript\"></script>\r\n");
      out.write("<script src=\"");
      out.print(basePath);
      out.write("js/jquery-validation/jquery.metadata.js\" type=\"text/javascript\"></script>\r\n");
      out.write("<script src=\"");
      out.print(basePath);
      out.write("js/jquery-validation/messages_cn.js\" type=\"text/javascript\"></script>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\tvar eee;\r\n");
      out.write("        $(function () {\r\n");
      out.write("            $.metadata.setType(\"attr\", \"validate\");\r\n");
      out.write("            var v = $(\"form\").validate({\r\n");
      out.write("                //调试状态，不会提交数据的\r\n");
      out.write("                debug: true,\r\n");
      out.write("                errorPlacement: function (lable, element) {\r\n");
      out.write("                    if (element.hasClass(\"l-textarea\")) {\r\n");
      out.write("                        element.addClass(\"l-textarea-invalid\");\r\n");
      out.write("                    }\r\n");
      out.write("                    else if (element.hasClass(\"l-text-field\")) {\r\n");
      out.write("                        element.parent().addClass(\"l-text-invalid\");\r\n");
      out.write("                    }\r\n");
      out.write("                    var nextCell = element.parents(\"td:first\").next(\"td\");\r\n");
      out.write("                    if (nextCell.find(\"div.l-exclamation\").length == 0) {\r\n");
      out.write("                        $('<div class=\"l-exclamation\" title=\"' + lable.html() + '\"></div>').appendTo(nextCell).ligerTip();\r\n");
      out.write("                    }\r\n");
      out.write("                },\r\n");
      out.write("                invalidHandler: function (form, validator) {\r\n");
      out.write("                    var errors = validator.numberOfInvalids();\r\n");
      out.write("                     if (errors) {\r\n");
      out.write("                        var message = errors == 1\r\n");
      out.write("                          ? '该字段有误！'\r\n");
      out.write("                          : '这 ' + errors + ' 个字段填写不正确！';\r\n");
      out.write("                        $(\"#errorLabelContainer\").html(message).show();\r\n");
      out.write("                    } \r\n");
      out.write("                },\r\n");
      out.write("                submitHandler : function() {\r\n");
      out.write("\t\t\t\t$(\"form .l-text,.l-textarea\").ligerHideTip();\t\t\t\t\r\n");
      out.write("\t\t\t\t////var flg = check();\r\n");
      out.write("\t\t\t\t//var flg1= check1();\r\n");
      out.write("\t\t\t\t//var flg2= check2();\r\n");
      out.write("\t\t\t\t//alert(check());\r\n");
      out.write("\t\t\t\t//if(flg&&flg1&&flg2){\r\n");
      out.write("\t\t\t\t$.post(\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/system/Class_courseendadd.action?course.coursename=\"\r\n");
      out.write("\t\t\t\t+  encodeURI(encodeURI($(\"#coursename\").val()))\r\n");
      out.write("\t\t        +\"&course.teacher=\"+  encodeURI(encodeURI($(\"#teacher\").val()))\r\n");
      out.write("\t\t        +\"&course.character=\"+  encodeURI(encodeURI($(\"#character\").val()))\r\n");
      out.write("\t\t        //+\"&course.checkway=\"+  encodeURI(encodeURI($(\"#checkway\").val()))\r\n");
      out.write("\t\t        +\"&course.beginweeks=\"+ $(\"#beginweeks\").val()\r\n");
      out.write("\t\t        +\"&course.endweeks=\"+ $(\"#endweeks\").val()\r\n");
      out.write("\t\t        +\"&course.credits=\"+ $(\"#credit\").val()\r\n");
      out.write("\t\t        +\"&course.academic=\"+ $(\"#academic option:selected\").val()\r\n");
      out.write("\t\t        +\"&course.num=\"+  encodeURI(encodeURI($(\"#num\").val())),null,function(){\r\n");
      out.write("\t\t        alert('添加成功！');\r\n");
      out.write("                 parent.m.hide();\r\n");
      out.write("\t             parent.g.loadData();\r\n");
      out.write("\t\t        });\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t//}\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\t$(\"form\").ligerForm();\r\n");
      out.write("\t\t$(\".l-button-test\").click(function() {\r\n");
      out.write("\t\t\talert(v.element($(\"#txtName\")));\r\n");
      out.write("\t\t});\r\n");
      out.write("\r\n");
      out.write("\t});\r\n");
      out.write("\r\n");
      out.write("\tfunction check() {\r\n");
      out.write("\t   var str = document.getElementById(\"coursename\").value;\r\n");
      out.write("\t   var reg =/[\\u4e00-\\u9fa5]/g;\r\n");
      out.write("\t   if(!reg.test(str)){\r\n");
      out.write("\t     $(\"#result\").html(\"请正确填写课程名！\");\r\n");
      out.write("\t     $(\"#result\").show();\r\n");
      out.write("\t     return  false;\r\n");
      out.write("\t   }else{\r\n");
      out.write("\t   $.post(\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/system/Class_coursecheck.action?course.coursename=\"\r\n");
      out.write("\t\t\t\t\t\t+ $(\"#coursename\").val(), null, function(data) {\r\n");
      out.write("\t\t\t\t\tif (data == \"fail\") {\r\n");
      out.write("\t\t\t\t\t\t$(\"#result\").html(\"该课程名已经存在!\");\r\n");
      out.write("\t\t\t\t\t\t$(\"#result\").show();\r\n");
      out.write("\t\t\t\t\t\treturn false;\r\n");
      out.write("\t\t\t\t\t} else {\r\n");
      out.write("\t\t\t\t\t\t$(\"#result\").hide();\r\n");
      out.write("\t\t\t\t\t\treturn true;\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t});\r\n");
      out.write("\t   }\t\t\r\n");
      out.write("\t}\r\n");
      out.write("\tfunction check1() {\r\n");
      out.write("\t\tvar str = document.getElementById(\"num\").value;\r\n");
      out.write("\t\tvar reg =/^(+|-)?d+$/;\r\n");
      out.write("\t\tif(reg.test(str)){\r\n");
      out.write("\t\t  $.post(\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/system/Class_coursecheck1.action?course.num=\"\r\n");
      out.write("\t\t\t\t\t\t+ $(\"#num\").val(), null, function(data) {\r\n");
      out.write("\t\t\t\t\tif (data == \"fail\") {\r\n");
      out.write("\t\t\t\t\t\t$(\"#result3\").html(\"该课程编号已经存在!\");\r\n");
      out.write("\t\t\t\t\t\t$(\"#result3\").show();\r\n");
      out.write("\t\t\t\t\t\treturn false;\r\n");
      out.write("\t\t\t\t\t} else {\r\n");
      out.write("\t\t\t\t\t\t$(\"#result3\").hide();\r\n");
      out.write("\t\t\t\t\t\treturn true;\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t});\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t}else{\r\n");
      out.write("\t\t    $(\"#result3\").html(\"请输入正确的数字!\");\r\n");
      out.write("\t\t\t$(\"#result3\").show();\r\n");
      out.write("\t\t\treturn  false;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t}\r\n");
      out.write("\tfunction check2(){\r\n");
      out.write("\t  var str1 = document.getElementById(\"beginweeks\").value;\r\n");
      out.write("\t  var str2 = document.getElementById(\"endweeks\").value;\r\n");
      out.write("\t  if(parseInt(str1)>parseInt(str2)){\r\n");
      out.write("\t    $(\"#result2\").html(\"起始周不能大于结束周！\");\r\n");
      out.write("\t    $(\"#result2\").show();\r\n");
      out.write("\t    return false;\r\n");
      out.write("\t  }else{\r\n");
      out.write("\t    $(\"#result2\").hide();\r\n");
      out.write("\t    return  true;\r\n");
      out.write("\t  }\r\n");
      out.write("\t}\r\n");
      out.write("</script>\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write("body{ font-size:12px;}\r\n");
      out.write(".l-table-edit {}\r\n");
      out.write(".l-table-edit-td{ padding:4px;}\r\n");
      out.write(".l-button-submit,.l-button-test{width:80px; float:left; margin-left:10px; padding-bottom:2px;}\r\n");
      out.write(".l-verify-tip{ left:230px; top:120px;}\r\n");
      out.write("#errorLabelContainer{ padding:10px; width:300px; border:1px solid #FF4466; display:none; background:#FFEEEE; color:Red;}\r\n");
      out.write(".l-text{\r\n");
      out.write("   width: 80px;\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body style=\"padding: 10px\" onload=\"refresh()\">\r\n");
      out.write("\r\n");
      out.write("\t<form name=\"form1\" method=\"post\" action=\"\" id=\"form1\"   >\r\n");
      out.write("\t\t<div id=\"errorLabelContainer\" class=\"l-text-invalid\"></div>\r\n");
      out.write("\t\t<table cellpadding=\"0\" cellspacing=\"0\" class=\"l-table-edit\">\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td align=\"right\" class=\"l-table-edit-td\">课程编号:</td>\r\n");
      out.write("\t\t\t\t<td align=\"left\" class=\"l-table-edit-td\"><input name=\"num\"type=\"text\" onchange=\"check1()\" id=\"num\" ltype=\"text\" /></td>\r\n");
      out.write("\t\t\t\t<td align=\"left\"><div id=\"result1\" style=\"margin-top:-10px;color: red;font-size: 10px;\"></div>\r\n");
      out.write("\t\t\t\t   <div id=\"result3\" style=\"margin-top:-10px;color: red;font-size: 10px;\"></div>\r\n");
      out.write("\t\t\t\t</td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td align=\"right\" class=\"l-table-edit-td\">课程名称:</td>\r\n");
      out.write("\t\t\t\t<td align=\"left\" class=\"l-table-edit-td\">\r\n");
      out.write("\t\t\t\t<input name=\"name\" type=\"text\" id=\"coursename\"  ltype=\"text\" onchange=\"tovalid()\" /></td>\r\n");
      out.write("\t\t\t\t<td align=\"left\"><div id=\"result\" style=\"color: red;font-size: 10px;\"></div></td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr >\r\n");
      out.write("\t\t\t\t<td  align=\"right\" class=\"l-table-edit-td\">开课起始周:</td>\t<!-- validate=\"{required:true,minlength:1,maxlength:20}\"\t\t\t -->\r\n");
      out.write("\t\t\t\t<td align=\"left\" class=\"l-table-edit-td\"><input name=\"beginweeks\" width=\"30px\" type=\"text\" id=\"beginweeks\"    /></td>\r\n");
      out.write("\t\t\t\t<td align=\"left\">\t\t\t\t\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr >\r\n");
      out.write("\t\t\t\t<td  align=\"right\" class=\"l-table-edit-td\">开课结束周:</td><!-- \tonblur=\"check2()\" validate=\"{required:true,minlength:1,maxlength:20}\"\t -->\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t<td align=\"left\" class=\"l-table-edit-td\"><input name=\"endweeks\" type=\"text\" onchange=\"check2()\" id=\"endweeks\" /></td>\r\n");
      out.write("\t\t\t\t<td align=\"left\">\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td align=\"right\" class=\"l-table-edit-td\">学分:</td>\r\n");
      out.write("\t\t\t\t<td align=\"left\" class=\"l-table-edit-td\">\r\n");
      out.write("\t\t\t\t<select type=\"select\" id=\"credit\" style=\"width:155px;\" >\r\n");
      out.write("\t\t\t\t    <option value=\"\"  ></option>\r\n");
      out.write("\t\t\t\t    <option value=\"1\">1</option>\r\n");
      out.write("\t\t\t\t    <option value=\"2\">2</option>\r\n");
      out.write("\t\t\t\t    <option value=\"3\">3</option>\r\n");
      out.write("\t\t\t\t    <option value=\"4\">4</option>\r\n");
      out.write("\t\t\t\t    <option value=\"5\">5</option>\r\n");
      out.write("\t\t\t\t    <option value=\"6\">6</option>\r\n");
      out.write("\t\t\t\t    <option value=\"7\">7</option>\r\n");
      out.write("\t\t\t\t</select>\r\n");
      out.write("\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t<td align=\"left\"></td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("            \r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td align=\"right\" class=\"l-table-edit-td\">课程性质:</td>\r\n");
      out.write("\t\t\t\t<td align=\"left\" style=\"padding-left: 4px\">\r\n");
      out.write("\t\t\t\t<select type=\"select\" id=\"character\" style=\"width:155px;\" >\r\n");
      out.write("\t\t\t\t    <option value=\"必修\">必修</option>\r\n");
      out.write("\t\t\t\t    <option value=\"现选\">现选</option>\r\n");
      out.write("\t\t\t\t    <option value=\"任选\">任选</option>\r\n");
      out.write("\t\t\t\t</select>\r\n");
      out.write("\t\t\t\t\t<!-- <input name=\"character\" type=\"text\"  id=\"character\" ltype='text' value=\"必修\" /> -->\r\n");
      out.write("\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t \r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<!-- <tr>\r\n");
      out.write("\t\t\t\t\t<td align=\"right\" class=\"l-table-edit-td\">考核方式:</td>\r\n");
      out.write("\t\t\t\t<td align=\"left\" style=\"padding-left: 4px\">\r\n");
      out.write("\t\t\t\t\t<select type=\"select\" id=\"checkway\">\r\n");
      out.write("\t\t\t\t        <option value=\"集中式\">集中式</option>\r\n");
      out.write("\t\t\t\t        <option value=\"非集中式\">非集中式</option>\r\n");
      out.write("\t\t\t\t    </select>\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t \r\n");
      out.write("\t\t\t\t</tr> -->\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td align=\"right\" class=\"l-table-edit-td\">开课学院:</td>\r\n");
      out.write("\t\t\t\t    <td align=\"left\" style=\"padding-left: 4px\">\r\n");
      out.write("\t\t\t\t    <select type=\"select\" id=\"academic\" name=\"academic\" style=\"width: 155px;\">\r\n");
      out.write("\t\t\t\t\t\t<option value=\"国际教育学院 \"  >国际教育学院</option>\r\n");
      out.write("\t\t\t\t\t\t<option value=\"纺织学院\">纺织学院</option>\r\n");
      out.write("\t\t\t\t\t\t<option value=\"材料科学与工程学院\">材料科学与工程学院</option>\r\n");
      out.write("\t\t\t\t\t\t<option value=\"环境与化学工程学院\">环境与化学工程学院</option>\r\n");
      out.write("\t\t\t\t\t\t<option value=\"机械工程学院\">机械工程学院</option>\r\n");
      out.write("\t\t\t\t\t\t<option value=\"计算机科学与软件学院\">计算机科学与软件学院</option>\r\n");
      out.write("\t\t\t\t\t\t<option value=\"电气工程与自动化学院 \">电气工程与自动化学院</option>\r\n");
      out.write("\t\t\t\t\t\t<option value=\"电子与信息工程学院 \">电子与信息工程学院</option>\r\n");
      out.write("\t\t\t\t\t\t<option value=\"理学院\">理学院</option>\r\n");
      out.write("\t\t\t\t\t\t<option value=\"艺术与服装学院\">艺术与服装学院</option>\r\n");
      out.write("\t\t\t\t\t\t<option value=\"管理学院 \">管理学院</option>\r\n");
      out.write("\t\t\t\t\t\t<option value=\"经济学院\">经济学院</option>\r\n");
      out.write("\t\t\t\t\t\t<option value=\"人文与法学院\">人文与法学院</option>\r\n");
      out.write("\t\t\t\t\t\t<option value=\"外国语学院 \">外国语学院</option>\r\n");
      out.write("\t\t\t\t\t\t<option value=\"马克思主义学院\">马克思主义学院</option>\r\n");
      out.write("\t\t\t\t\t\t<option value=\"应用技术学院\">应用技术学院</option>\r\n");
      out.write("\t\t\t\t\t\t<option value=\"继续教育学院\">继续教育学院</option>\r\n");
      out.write("\t\t\t\t</select>\r\n");
      out.write("\t\t\t\t</td>\t\t\t\t\t \r\n");
      out.write("\t\t\t\t</tr><tr>\r\n");
      out.write("\t\t\t\t\t<td align=\"right\" class=\"l-table-edit-td\">负责教师:</td>\r\n");
      out.write("\t\t\t\t    <td align=\"left\" style=\"padding-left: 4px\">\r\n");
      out.write("\t\t\t\t\t   <input name=\"teacher\" type=\"text\"  id=\"teacher\" ltype='text' />\r\n");
      out.write("\t\t\t\t    </td>\r\n");
      out.write("\t\t\t\t\t \r\n");
      out.write("\t\t\t\t</tr>\t\t\t\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td align=\"right\" class=\"l-table-edit-td\"></td>\r\n");
      out.write("\t\t\t\t<td align=\"left\"><div id=\"result2\" style=\"color: red;\">\r\n");
      out.write("\t\t\t\t<td align=\"left\" class=\"l-table-edit-td\"></td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td align=\"right\" class=\"l-table-edit-td\"></td>\r\n");
      out.write("\t\t\t\t<td align=\"left\"><br /><input type=\"submit\"value=\"添&nbsp;&nbsp;加\" id=\"Button1\"class=\"l-button l-button-submit\" /></td>\r\n");
      out.write("\t\t\t\t<td align=\"left\" class=\"l-table-edit-td\"></td>\t\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t</table>\r\n");
      out.write("\t\t<br />\r\n");
      out.write("\t</form>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("  function tovalid(){\r\n");
      out.write("    \r\n");
      out.write("  }\r\n");
      out.write("</script>\r\n");
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
