package org.apache.jsp.WEB_002dINF.arrange;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;

public final class setemptyslot_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\tfunction f_addselect(){\r\n");
      out.write("\t  var slottable = document.getElementById(\"setslot\");\r\n");
      out.write("\t  var size=$('select').size()/2;\r\n");
      out.write("\t  NewRow = slottable.insertRow(-1); \r\n");
      out.write("\t  NewRow.setAttribute('class', 'tabletr');//添加行\r\n");
      out.write("      newcell1= NewRow.insertCell(-1);                     //添加列\r\n");
      out.write("      newcell2=NewRow.insertCell(-1);\r\n");
      out.write("      newcell3=NewRow.insertCell(-1);\r\n");
      out.write("      newcell4=NewRow.insertCell(-1);\r\n");
      out.write("      newcell1.setAttribute('class','l-table-edit-td');  \r\n");
      out.write("\t  newcell2.setAttribute('class','l-table-edit-td');  \r\n");
      out.write("\t  newcell3.setAttribute('class','l-table-edit-td');  \r\n");
      out.write("\t  newcell4.setAttribute('class','l-table-edit-td');  \r\n");
      out.write("      newcell1.innerHTML = \"星期:&nbsp;\";\r\n");
      out.write("      var num =parseInt(size)+parseInt(1);  \r\n");
      out.write("      var select = \"<select id='weekday\"+num+\"'><option value='' ></option> <option value='0' >周一</option><option value='1' >周二</option><option value='2' >周三</option><option value='3' >周四</option> <option value='4' >周五</option><option value='5' >周六</option><option value='6' >周天</option> </select>\";\r\n");
      out.write("      var slot = \"<select id='slot\"+num+\"'><option value='' ></option> <option value='0' >第一大节</option><option value='1' >第二大节</option><option value='2' >第三大节</option><option value='3' >第四大节</option> <option value='4' >第五大节</option> </select>\";//添加数据\r\n");
      out.write("      newcell2.innerHTML=select;//\r\n");
      out.write("      newcell3.innerHTML = \"节次:&nbsp;\";\r\n");
      out.write("      newcell4.innerHTML =  slot;  \r\n");
      out.write("\t}\r\n");
      out.write("\tvar flg = true;\r\n");
      out.write("\tfunction f_next(){\r\n");
      out.write("\t   var size=$('select').size()/2;\r\n");
      out.write("\t   var str = \"\";\r\n");
      out.write("\t   for(var i=1;i<=size;i++){\r\n");
      out.write("\t      var weekday ,slot;\r\n");
      out.write("\t      weekday = $(\"#weekday\"+i+\" option:selected\").val();\r\n");
      out.write("\t      slot = $(\"#slot\"+i+\" option:selected\").val();\r\n");
      out.write("\t      if(weekday.length!=0){\r\n");
      out.write("\t        if(slot.length!=0){\r\n");
      out.write("\t            var test = parseInt(weekday)*5+parseInt(slot);\r\n");
      out.write("\t            str = str + test+\",\";\r\n");
      out.write("\t            $(\"#result\").hide();\r\n");
      out.write("\t        }else{\r\n");
      out.write("\t            $(\"#result\").html(\"请设置节次！\");\r\n");
      out.write("\t            $(\"#result\").show();\r\n");
      out.write("\t            flg=false;\r\n");
      out.write("\t            $(\"#slot\").focus();\r\n");
      out.write("\t        }\r\n");
      out.write("\t      }\r\n");
      out.write("\t   }\t  \r\n");
      out.write("\t   if(flg){\r\n");
      out.write("\t      parent.m.hide();\r\n");
      out.write("\t      var url =\"Manage_chkRooms.action?semChosenCourse.semester=\"+$(\"#semester\").val()+\"&setemptyslot=\"+str;\r\n");
      out.write("\t      parent.window.location.href=url;\r\n");
      out.write("\t   }\r\n");
      out.write("\t   \r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("</script>\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write("body{ font-size:12px;}\r\n");
      out.write(".l-table-edit {}\r\n");
      out.write(".l-table-edit-td{ padding:4px;}\r\n");
      out.write(".l-button-submit,.l-button-test{width:80px; float:left; margin-left:10px; padding-bottom:2px;}\r\n");
      out.write(".l-verify-tip{ left:230px; top:120px;}\r\n");
      out.write("#errorLabelContainer{ padding:10px; width:300px; border:1px solid #FF4466; display:none; background:#FFEEEE; color:Red;}\r\n");
      out.write("select {\r\n");
      out.write("\twidth:160px;\r\n");
      out.write("}\r\n");
      out.write(".tabletr{\r\n");
      out.write(" text-align: center;\r\n");
      out.write(" margin-top: 10px;\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body style=\"padding: 10px\">\r\n");
      out.write("\r\n");
      out.write("\t<form name=\"form1\" method=\"post\" action=\"\" id=\"form1\">\r\n");
      out.write("\t    <input id=\"semester\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${semester }", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\" type=\"hidden\"  />\r\n");
      out.write("\t\t<div id=\"errorLabelContainer\" class=\"l-text-invalid\"></div>\r\n");
      out.write("\t\t<div align=\"center\" style=\"font-size: 16px;\" >设定选修课程上课时间</div>\r\n");
      out.write("\t\t<table id=\"setslot\" cellpadding=\"0\" cellspacing=\"0\" class=\"l-table-edit\" align=\"center\" >\r\n");
      out.write("\t\t\t<tr class=\"tabletr\" >\r\n");
      out.write("\t\t\t\t<td  class=\"l-table-edit-td\">星期:&nbsp;</td>\r\n");
      out.write("\t\t\t\t<td  class=\"l-table-edit-td\">\r\n");
      out.write("\t\t\t\t   <select id=\"weekday1\" name=\"weekday1\" >\r\n");
      out.write("\t\t\t\t       <option value=\"\" ></option>\r\n");
      out.write("\t\t\t\t       <option value=\"0\" >周一</option>\r\n");
      out.write("\t\t\t\t       <option value=\"1\" >周二</option>\r\n");
      out.write("\t\t\t\t       <option value=\"2\" >周三</option>\r\n");
      out.write("\t\t\t\t       <option value=\"3\" >周四</option>\r\n");
      out.write("\t\t\t\t       <option value=\"4\" >周五</option>\r\n");
      out.write("\t\t\t\t       <option value=\"5\" >周六</option>\r\n");
      out.write("\t\t\t\t       <option value=\"6\" >周天</option>\r\n");
      out.write("\t\t\t\t   </select>\r\n");
      out.write("\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t<td  class=\"l-table-edit-td\">节次:</td>\r\n");
      out.write("\t\t\t\t<td  class=\"l-table-edit-td\">\r\n");
      out.write("\t\t\t\t   <select id=\"slot1\" name=\"slot1\" >\r\n");
      out.write("\t\t\t\t       <option value=\"\" ></option>\r\n");
      out.write("\t\t\t\t       <option value=\"0\" >第一大节</option>\r\n");
      out.write("\t\t\t\t       <option value=\"1\" >第二大节</option>\r\n");
      out.write("\t\t\t\t       <option value=\"2\" >第三大节</option>\r\n");
      out.write("\t\t\t\t       <option value=\"3\" >第四大节</option>\r\n");
      out.write("\t\t\t\t       <option value=\"4\" >第五大节</option>\r\n");
      out.write("\t\t\t\t   </select>\r\n");
      out.write("\t\t\t\t</td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr class=\"tabletr\">\r\n");
      out.write("\t\t\t\t<td  class=\"l-table-edit-td\">星期:&nbsp;</td>\r\n");
      out.write("\t\t\t\t<td  class=\"l-table-edit-td\">\r\n");
      out.write("\t\t\t\t   <select id=\"weekday2\" name=\"weekday2\" >\r\n");
      out.write("\t\t\t\t       <option value=\"\" ></option>\r\n");
      out.write("\t\t\t\t       <option value=\"0\" >周一</option>\r\n");
      out.write("\t\t\t\t       <option value=\"1\" >周二</option>\r\n");
      out.write("\t\t\t\t       <option value=\"2\" >周三</option>\r\n");
      out.write("\t\t\t\t       <option value=\"3\" >周四</option>\r\n");
      out.write("\t\t\t\t       <option value=\"4\" >周五</option>\r\n");
      out.write("\t\t\t\t       <option value=\"5\" >周六</option>\r\n");
      out.write("\t\t\t\t       <option value=\"6\" >周天</option>\r\n");
      out.write("\t\t\t\t   </select>\r\n");
      out.write("\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t<td  class=\"l-table-edit-td\">节次:</td>\r\n");
      out.write("\t\t\t\t<td  class=\"l-table-edit-td\">\r\n");
      out.write("\t\t\t\t   <select id=\"slot2\" name=\"slot2\" >\r\n");
      out.write("\t\t\t\t       <option value=\"\" ></option>\r\n");
      out.write("\t\t\t\t       <option value=\"0\" >第一大节</option>\r\n");
      out.write("\t\t\t\t       <option value=\"1\" >第二大节</option>\r\n");
      out.write("\t\t\t\t       <option value=\"2\" >第三大节</option>\r\n");
      out.write("\t\t\t\t       <option value=\"3\" >第四大节</option>\r\n");
      out.write("\t\t\t\t       <option value=\"4\" >第五大节</option>\r\n");
      out.write("\t\t\t\t   </select>\r\n");
      out.write("\t\t\t\t</td>\r\n");
      out.write("\t\t\t</tr>\t \t\t\t\r\n");
      out.write("\t\t\t<tr class=\"tabletr\" >\r\n");
      out.write("\t\t\t\t<td  class=\"l-table-edit-td\">星期:&nbsp;</td>\r\n");
      out.write("\t\t\t\t<td  class=\"l-table-edit-td\">\r\n");
      out.write("\t\t\t\t   <select id=\"weekday3\" name=\"weekday3\" >\r\n");
      out.write("\t\t\t\t       <option value=\"\" ></option>\r\n");
      out.write("\t\t\t\t       <option value=\"0\" >周一</option>\r\n");
      out.write("\t\t\t\t       <option value=\"1\" >周二</option>\r\n");
      out.write("\t\t\t\t       <option value=\"2\" >周三</option>\r\n");
      out.write("\t\t\t\t       <option value=\"3\" >周四</option>\r\n");
      out.write("\t\t\t\t       <option value=\"4\" >周五</option>\r\n");
      out.write("\t\t\t\t       <option value=\"5\" >周六</option>\r\n");
      out.write("\t\t\t\t       <option value=\"6\" >周天</option>\r\n");
      out.write("\t\t\t\t   </select>\r\n");
      out.write("\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t<td  class=\"l-table-edit-td\">节次:</td>\r\n");
      out.write("\t\t\t\t<td  class=\"l-table-edit-td\">\r\n");
      out.write("\t\t\t\t   <select id=\"slot3\" name=\"slot3\" >\r\n");
      out.write("\t\t\t\t       <option value=\"\" ></option>\r\n");
      out.write("\t\t\t\t       <option value=\"0\" >第一大节</option>\r\n");
      out.write("\t\t\t\t       <option value=\"1\" >第二大节</option>\r\n");
      out.write("\t\t\t\t       <option value=\"2\" >第三大节</option>\r\n");
      out.write("\t\t\t\t       <option value=\"3\" >第四大节</option>\r\n");
      out.write("\t\t\t\t       <option value=\"4\" >第五大节</option>\r\n");
      out.write("\t\t\t\t   </select>\r\n");
      out.write("\t\t\t\t</td>\r\n");
      out.write("\t\t\t</tr>\t\t\t\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t   <td colspan=\"4\" align=\"center\" ><br /></td>\r\n");
      out.write("\t\t\t</tr>\t\t\t\r\n");
      out.write("\t\t</table>\r\n");
      out.write("\t\t<div align=\"center\"><strong>注：</strong>如无需设定的定上课日期，可留空点击设置！</div>\r\n");
      out.write("\t\t<div align=\"center\">\r\n");
      out.write("\t\t<input type=\"button\" style=\"margin-right: 120px;margin-top:30px;\" onclick=\"f_next()\" value=\"设&nbsp;置\" id=\"Button1\" class=\"l-button\" />\r\n");
      out.write("\t\t<input type=\"button\" style=\"margin-left: 10px;margin-top:30px;\"  onclick=\"f_addselect()\" value=\"添加一行\" id=\"Button\" class=\"l-button \" />\r\n");
      out.write("\t\t     \r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t</div>\r\n");
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
