package org.apache.jsp.WEB_002dINF.student;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.opensymphony.xwork2.ActionContext;
import java.util.*;

public final class graduatestulist_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<title>天津工业大学排课管理系统</title>\r\n");
      out.write("<link href=\"");
      out.print(basePath);
      out.write("js/ligerUI/skins/Aqua/css/ligerui-all.css\"\r\n");
      out.write("\trel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("<link href=\"");
      out.print(basePath);
      out.write("js/ligerUI/skins/Gray/css/all.css\"\r\n");
      out.write("\trel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("<script type=\"text/javascript\"\r\n");
      out.write("\tsrc=\"js/jquery-validation/jquery.validate.min.js\" charset=\"utf-8\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"js/json2.js\" charset=\"utf-8\"></script>\r\n");
      out.write("<script type=\"text/javascript\"\r\n");
      out.write("\tsrc=\"js/jquery-validation/jquery.metadata.js\" charset=\"utf-8\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"js/jquery-validation/messages_cn.js\"\r\n");
      out.write("\tcharset=\"utf-8\"></script>\r\n");
      out.write("<script src=\"js/jquery/jquery-1.3.2.min.js\" type=\"text/javascript\"></script>\r\n");
      out.write("<script src=\"js/ligerUI/core/base.js\" type=\"text/javascript\"></script>\r\n");
      out.write("<script src=\"js/ligerUI/ligerui.all.js\" type=\"text/javascript\"></script>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\tvar StatusData = [ {\r\n");
      out.write("\t\tstatus : 0,\r\n");
      out.write("\t\ttext : '未审核'\r\n");
      out.write("\t}, {\r\n");
      out.write("\t\tstatus : 1,\r\n");
      out.write("\t\ttext : '通过'\r\n");
      out.write("\t}, , {\r\n");
      out.write("\t\tstatus : 2,\r\n");
      out.write("\t\ttext : '未通过'\r\n");
      out.write("\t} ];\r\n");
      out.write("\t$(f_initGrid);\r\n");
      out.write("\tvar manager, g;\r\n");
      out.write("\tfunction f_initGrid() {\r\n");
      out.write("\t\tg = manager = $(\"#maingrid\")\r\n");
      out.write("\t\t\t\t.ligerGrid(\r\n");
      out.write("\t\t\t\t\t\t{\r\n");
      out.write("\t\t\t\t\t\t\tcolumns : [\r\n");
      out.write("\t\t\t\t\t\t\t\t\t{\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tdisplay : '序号',\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tname : 'id',\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tminWidth : 40,\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\ttype : 'int',\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\thide : true\r\n");
      out.write("\t\t\t\t\t\t\t\t\t},\r\n");
      out.write("\t\t\t\t\t\t\t\t\t{\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tdisplay : '护照号',\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tname : 'passport',\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tminWidth : 120,\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\teditor : {\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\ttype : 'text'\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\t\t\t\t},\r\n");
      out.write("\t\t\t\t\t\t\t\t\t{\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tdisplay : '密码',\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tname : 'password',\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\thide : true,\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\teditor : {\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\ttype : 'password'\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\t\t\t\t},\r\n");
      out.write("\t\t\t\t\t\t\t\t\t{\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tdisplay : '英文名',\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tname : 'firstname',\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tminWidth : 100,\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\teditor : {\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\ttype : 'text'\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\t\t\t\t},\r\n");
      out.write("\t\t\t\t\t\t\t\t\t{\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tdisplay : '英文姓',\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tname : 'lastname',\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tminWidth : 100,\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\teditor : {\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\ttype : 'text'\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\t\t\t\t},\r\n");
      out.write("\t\t\t\t\t\t\t\t\t{\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tdisplay : '中文名',\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tname : 'stuname',\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tminWidth : 80,\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\teditor : {\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\ttype : 'text'\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\t\t\t\t},\r\n");
      out.write("\t\t\t\t\t\t\t\t\t{\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tdisplay : '性别',\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tname : 'stusex',\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tminWidth : 50,\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\teditor : {\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\ttype : 'text'\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\t\t\t\t},\r\n");
      out.write("\t\t\t\t\t\t\t\t\t{\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tdisplay : '电话',\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tname : 'telephone',\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tminWidth : 100,\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\teditor : {\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\ttype : 'text'\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\t\t\t\t},\r\n");
      out.write("\t\t\t\t\t\t\t\t\t{\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tdisplay : '住址',\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tname : 'roomplace',\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tminWidth : 120,\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\teditor : {\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\ttype : 'text'\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\t\t\t\t},\r\n");
      out.write("\t\t\t\t\t\t\t\t\t{\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tdisplay : '国籍',\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tname : 'nation',\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tminWidth : 100,\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\teditor : {\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\ttype : 'text'\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\t\t\t\t},\r\n");
      out.write("\t\t\t\t\t\t\t\t\t{\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tdisplay : '学生类别',\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tname : 'studentType',\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tminWidth : 80,\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\teditor : {\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\ttype : 'text'\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\t\t\t\t},\r\n");
      out.write("\t\t\t\t\t\t\t\t\t{\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tdisplay : '状态',\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tname : 'status',\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tminWidth : 80,\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\teditor : {\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\ttype : 'select',\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\tdata : StatusData,\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\tvalueField : 'status'\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t},\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\trender : function(item) {\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\tif (parseInt(item.status) == 0) {\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\tvar h = \"<span style='color:red;'>未审核</span>\";\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\treturn h;\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t} else if (parseInt(item.status) == 1) {\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\tvar h = \"<span style='color:green;'>通过</span>\";\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\treturn h;\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t} else if (parseInt(item.status) == 2) {\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\tvar h = \"<span style='color:orange;'>未通过</span>\";\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\treturn h;\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t}\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\t\t\t\t} ],\r\n");
      out.write("\t\t\t\t\t\t\tonSelectRow : function(rowdata, rowindex) {\r\n");
      out.write("\t\t\t\t\t\t\t\t$(\"#txtrowindex\").val(rowindex);\r\n");
      out.write("\t\t\t\t\t\t\t},\r\n");
      out.write("\t\t\t\t\t\t\tcheckbox : true,\r\n");
      out.write("\t\t\t\t\t\t\tenabledEdit : true,\r\n");
      out.write("\t\t\t\t\t\t\tclickToEdit : false,\r\n");
      out.write("\t\t\t\t\t\t\tisScroll : false,\r\n");
      out.write("\t\t\t\t\t\t\trownumbers : true,\r\n");
      out.write("\t\t\t\t\t\t\tpageSize : 30,\r\n");
      out.write("\t\t\t\t\t\t\turl : '");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/system/Class_loadclassstu.action',\r\n");
      out.write("\t\t\t\t\t\t\twidth : '100%'\r\n");
      out.write("\t\t\t\t\t\t});\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\tfunction stuprint() {\r\n");
      out.write("\t\tvar row = manager.getSelectedRow();\r\n");
      out.write("\t\tserial = $('#serial').val()\r\n");
      out.write("\t\tif (!row) {\r\n");
      out.write("\t\t\talert('请选择一项！');\r\n");
      out.write("\t\t\treturn;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tif (row.status == 1) {\r\n");
      out.write("\t\t\tvar str = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/system/Class_printDiploma.action?stu.id=\"\r\n");
      out.write("\t\t\t\t\t+ row.id + \"&serial=\" + serial;\r\n");
      out.write("\t\t\ttemp = Number(serial)\r\n");
      out.write("\t\t\ttemp += 1\r\n");
      out.write("\t\t\tserial = temp + \"\"\r\n");
      out.write("\t\t\tif (temp < 10)\r\n");
      out.write("\t\t\t\tserial = '0' + serial\r\n");
      out.write("\t\t\tif (temp < 100)\r\n");
      out.write("\t\t\t\tserial = '0' + serial\r\n");
      out.write("\t\t\t$('#serial').val(serial)\r\n");
      out.write("\t\t\tlocation.href = str;\r\n");
      out.write("\t\t} else {\r\n");
      out.write("\t\t\talert(\"不符合打印条件或请先对学生进行审核！\");\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\tfunction batchprint() {\r\n");
      out.write("\t\tvar row = manager.getSelectedRow();\r\n");
      out.write("\t\tif (!row) {\r\n");
      out.write("\t\t\talert('请选择一项！');\r\n");
      out.write("\t\t\treturn;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tvar rows = g.getCheckedRows();\r\n");
      out.write("\t\tvar str = \"\";\r\n");
      out.write("\t\t$(rows).each(function() {\r\n");
      out.write("\t\t\tif (this.status == 1) {\r\n");
      out.write("\t\t\t\tstr += this.id + \",\";\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\tvar str = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/system/Stu_graduatebatchprint.action?ids=\"\r\n");
      out.write("\t\t\t\t+ str;\r\n");
      out.write("\t\twindow.location.href = str;\r\n");
      out.write("\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");
      out.write("<body style=\"padding: 2px\">\r\n");
      out.write("\t<!-- <a class=\"l-button\" href=\"system/Stu_printDiploma.action\">打印毕业证</a> -->\r\n");
      out.write("\t<a class=\"l-button\" style=\"width:70px;float:left; margin:3px;\"\r\n");
      out.write("\t\ttarget=\"_blank\" onclick=\"stuprint()\">打印毕业证</a>\r\n");
      out.write("\t&nbsp;&nbsp;&nbsp;当前流水号：\r\n");
      out.write("\t<input \r\n");
      out.write("\t\tonkeypress=\"return event.keyCode>=48&&event.keyCode<=57||event.keyCode==46\"\r\n");
      out.write("\t\tonpaste=\"return !clipboardData.getData('text').match(/\\D/)\"\r\n");
      out.write("\t\tondragenter=\"return false\" style=\"ime-mode:Disabled;margin-top: 5px;\"\r\n");
      out.write("\t\tvalue=\"");
      out.print((String) ActionContext.getContext().get("serial"));
      out.write("\"\r\n");
      out.write("\t\tclass=\"link\" id=\"serial\">\r\n");
      out.write("\r\n");
      out.write("\t<!-- <a class=\"l-button\" style=\"width:70px;float:left; margin:3px;\" target=\"_blank\" onclick=\"batchprint()\">批量打印</a> -->\r\n");
      out.write("\t<div class=\"l-clear\"></div>\r\n");
      out.write("\t<div id=\"maingrid\"></div>\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
      out.write("\r\n");
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
