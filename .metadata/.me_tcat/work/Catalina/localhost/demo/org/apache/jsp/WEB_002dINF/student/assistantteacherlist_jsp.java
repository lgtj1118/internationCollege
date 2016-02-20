package org.apache.jsp.WEB_002dINF.student;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;

public final class assistantteacherlist_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write('\r');
      out.write('\n');

String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">\r\n");
      out.write("<html>\r\n");
      out.write("  <head>\r\n");
      out.write("    <base href=\"");
      out.print(basePath);
      out.write("\">   \r\n");
      out.write("    <title>天津工业大学排课管理系统</title>\t   \r\n");
      out.write("\t<link href=\"");
      out.print(basePath);
      out.write("js/ligerUI/skins/Aqua/css/ligerui-all.css\" rel=\"stylesheet\"type=\"text/css\" />\t\r\n");
      out.write("\t<link href=\"");
      out.print(basePath );
      out.write("js/ligerUI/skins/Gray/css/all.css\" rel=\"stylesheet\" type=\"text/css\"/>\t\r\n");
      out.write("    <script src=\"js/jquery/jquery-1.6.min.js\"type=\"text/javascript\"></script>\r\n");
      out.write("\t<script src=\"js/ligerUI/core/base.js\" type=\"text/javascript\"></script>\r\n");
      out.write("\t<script src=\"js/ligerUI/ligerui.all.js\" type=\"text/javascript\"></script>\r\n");
      out.write("\t<script src=\"js/ligerUI/plugins/ligerDateEditor.js\" type=\"text/javascript\"></script>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("    var ClassData = { \r\n");
      out.write("\tRows: [");
String s = (String) request.getAttribute("classlist");
      out.write(' ');
      out.print(s);
      out.write("]};\r\n");
      out.write("    var ClassList = ClassData.Rows;\r\n");
      out.write("    var sexData = [{ Sex: 1, text: '男' }, { Sex: 2, text: '女'}];\r\n");
      out.write("    var TypeData = [{ academictype: 0, text: '审核中' }, { academictype: 1, text: '批准'}, { academictype: 2, text: '批准'}];\r\n");
      out.write("   $(f_initGrid);\r\n");
      out.write("\tvar manager, g;\r\n");
      out.write("\tfunction f_initGrid() {\r\n");
      out.write("\t\tg = manager = $(\"#maingrid\").ligerGrid(\r\n");
      out.write("\t\t\t{columns : [\r\n");
      out.write("\t\t\t{   display : '序号',  name : 'id',     minWidth : 40,  type : 'int',hide:true\r\n");
      out.write("\t\t\t},{display : '姓名', name : 'name', minWidth : 80,  editor:{type:'text'}\t}\r\n");
      out.write("\t\t\t,{display : '性别', name : 'gender', minWidth : 30,  editor:{type:'text'}\t}\r\n");
      out.write("\t\t\t, {display : '出生年月', name : 'brithdate',  minWidth : 100, editor: { type: 'text'}\r\n");
      out.write("\t\t\t}, {display : '民族', name : 'nation',  minWidth : 80, editor: { type: 'text'}\r\n");
      out.write("\t\t\t} ,{display : '政治面貌', name : 'politicalstatus',minWidth : 70,editor: { type: 'password'}\r\n");
      out.write("\t\t\t}, {display : '专业', name : 'major',minWidth : 100, editor: { type: 'text'}\r\n");
      out.write("\t\t\t}, {display : '学号', name : 'assistantnum',minWidth : 80, editor: { type: 'text'}\r\n");
      out.write("\t\t\t}, {display : '班级', name : 'classname',minWidth : 80, editor: { type: 'text'}\r\n");
      out.write("\t\t\t}, {display : '教育层次', name : 'edulevel',minWidth : 80, editor: { type: 'text'}\r\n");
      out.write("\t\t\t} ,{display : '所在学院', name : 'department', minWidth : 80,  editor:{type:'text'}\r\n");
      out.write("\t\t\t} ,{display : '外语语种', name : 'secondlanguagetype', minWidth : 80,  editor:{type:'text'}\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t} ,{display : '外语等级', name : 'secondlanguagelevel', minWidth : 80,  editor:{type:'text'} \r\n");
      out.write("            } ,{display : '联系方式', name : 'telephone', minWidth : 120,  editor:{type:'text'}\r\n");
      out.write("            } ,{display : '邮箱', name : 'email', minWidth : 140,  editor:{type:'text'}\r\n");
      out.write("            } ,{display : '负责班级', name : 'assistclass', minWidth : 140,  editor:{type:'text'}\t}      \r\n");
      out.write("           /*  ,{display : '学校意见', name : 'academictype', minWidth : 120,  editor: { type: 'select', data: TypeData, valueField: 'academictype' },\r\n");
      out.write("                    render: function (item)\r\n");
      out.write("                    {\r\n");
      out.write("                        if (parseInt(item.academictype) == 0){ var h=\"<span style='color:red;'>审核中</span>\" ;return h;}\r\n");
      out.write("                        else if (parseInt(item.academictype) == 1) { var h=\"<span style='color:red;'>批准</span>\" ;return h;}\r\n");
      out.write("                        else if (parseInt(item.academictype) == 2) { var h=\"<span style='color:red;'>未批准</span>\" ;return h;}\r\n");
      out.write("                        \r\n");
      out.write("                    }} */],\r\n");
      out.write("\t\t\t\t\tonSelectRow : function(rowdata, rowindex) {\r\n");
      out.write("\t\t\t\t\t\t$(\"#txtrowindex\").val(rowindex);\r\n");
      out.write("\t\t\t\t\t},\r\n");
      out.write("\t\t\t\t\t//checkbox:true,\r\n");
      out.write("\t\t\t\t\tenabledEdit : true,\r\n");
      out.write("\t\t\t\t\tclickToEdit : false,\r\n");
      out.write("\t\t\t\t\tisScroll : false,\r\n");
      out.write("\t\t\t\t\trownumbers:true, \r\n");
      out.write("\t\t\t\t\tpageSize:30,\r\n");
      out.write("\t\t\t\t\turl :'");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/system/Class_assistlist.action',\r\n");
      out.write("\t\t\t\t\twidth : '100%'\r\n");
      out.write("\t\t\t\t});\r\n");
      out.write("\t}\t \r\n");
      out.write("\t\r\n");
      out.write("\tfunction print(){\r\n");
      out.write("\t  var row = manager.getSelectedRow();\r\n");
      out.write("\t  var str = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/system/Class_assistprint.action?assistantteacher.id=\"+row.id;\r\n");
      out.write("\t  window.open(str);\r\n");
      out.write("\t}\r\n");
      out.write("</script>\r\n");
      out.write("\t</head>\r\n");
      out.write("\t<body style=\"padding: 2px\">\r\n");
      out.write("\t       \r\n");
      out.write("\t<!--  <a class=\"l-button\" style=\"width:70px;float:left; margin:3px;\" onclick=\"print()\">打&nbsp;&nbsp;印</a> -->\r\n");
      out.write("\t\t<div class=\"l-clear\"></div>\r\n");
      out.write("\t\t<div id=\"maingrid\" ></div>\r\n");
      out.write("\t</body>\r\n");
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
