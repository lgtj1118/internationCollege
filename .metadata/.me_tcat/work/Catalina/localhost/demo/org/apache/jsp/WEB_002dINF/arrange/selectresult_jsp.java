package org.apache.jsp.WEB_002dINF.arrange;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;

public final class selectresult_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("    <title>天津工业大学国际教育学院教学服务系统</title>\t   \r\n");
      out.write("\t<link href=\"");
      out.print(basePath);
      out.write("js/ligerUI/skins/Aqua/css/ligerui-all.css\" rel=\"stylesheet\"type=\"text/css\" />\t\r\n");
      out.write("\t<link href=\"");
      out.print(basePath );
      out.write("js/ligerUI/skins/Gray/css/all.css\" rel=\"stylesheet\" type=\"text/css\"/>\t\r\n");
      out.write("     <link href=\"js/ligerUI/skins/ligerui-icons.css\" rel=\"stylesheet\" type=\"text/css\">\r\n");
      out.write("    <script src=\"js/jquery/jquery-1.3.2.min.js\" type=\"text/javascript\"></script>\r\n");
      out.write("    <script src=\"js/json2.js\" type=\"text/javascript\"></script>\r\n");
      out.write("    <script src=\"js/ligerUI/ligerui.all.js\" type=\"text/javascript\"></script>\r\n");
      out.write("    <script src=\"js/ligerUI/js/core/base.js\" type=\"text/javascript\"></script>\r\n");
      out.write("    <script src=\"js/ligerUI/plugins/ligerDialog.js\" type=\"text/javascript\"></script>\r\n");
      out.write("    <script src=\"js/ligerUI/plugins/ligerTextBox.js\" type=\"text/javascript\"></script>\r\n");
      out.write("    <script src=\"js/ligerUI/plugins/ligerCheckBox.js\" type=\"text/javascript\"></script>\r\n");
      out.write("    <script src=\"js/ligerUI/plugins/ligerComboBox.js\" type=\"text/javascript\"></script>\r\n");
      out.write("    <script src=\"js/ligerUI/plugins/ligerGrid.js\" type=\"text/javascript\"></script>\r\n");
      out.write("    <script src=\"js/ligerUI/plugins/ligerToolBar.js\" type=\"text/javascript\"></script>\r\n");
      out.write("    <script src=\"js/ligerUI/plugins/ligerDateEditor.js\" type=\"text/javascript\"></script>\r\n");
      out.write("    <script src=\"js/ligerUI/plugins/ligerSpinner.js\" type=\"text/javascript\"></script>\r\n");
      out.write("    <script type=\"text/javascript\">\r\n");
      out.write("    var ClassData = { \r\n");
      out.write("\tRows: [");
String s = (String) request.getAttribute("classlist");
      out.write(' ');
      out.print(s);
      out.write("]};\r\n");
      out.write("    var ClassList = ClassData.Rows;\r\n");
      out.write("    var sexData = [{ Sex: 1, text: '男' }, { Sex: 2, text: '女'}];\r\n");
      out.write("   $(f_initGrid);\r\n");
      out.write("\tvar manager, g;\r\n");
      out.write("\tfunction f_initGrid() {\r\n");
      out.write("\t\tg = manager = $(\"#maingrid\").ligerGrid(\r\n");
      out.write("\t\t\t{columns : [\r\n");
      out.write("\t\t\t{   display : '序号',  name : 'id',     width : 40,  type : 'int',hide:true},\r\n");
      out.write("\t\t\t{display : '护照', name : 'passport', minWidth : 100,  editor:{type:'text'}\t}\r\n");
      out.write("\t\t\t, {display : '学号', name : 'stuid',  wiminWidthdth : 120, editor: { type: 'text'}\r\n");
      out.write("\t\t\t}, {display : '英文名', name : 'firstname',minWidth : 100, editor: { type: 'text'}\r\n");
      out.write("\t\t\t}, {display : '英文姓', name : 'lastname',minWidth : 100, editor: { type: 'text'}\r\n");
      out.write("\t\t\t}, {display : '中文名', name : 'stuname',minWidth : 80, editor: { type: 'text'}\r\n");
      out.write("\t\t\t} ,{display : '性别', name : 'stusex', minWidth : 50,  editor:{type:'text'}\t\t\t\t\r\n");
      out.write("\t\t\t} ,{ display: '班级',  name: 'classid', minWidth: 100, isSort: false,\r\n");
      out.write("            editor: { type: 'select', data: ClassList, valueColumnName: 'Classid', displayColumnName: 'Classname' }, \r\n");
      out.write("                  render: function (item)\r\n");
      out.write("                    {for (var i = 0; i < ClassList.length; i++)\r\n");
      out.write("                        { if (ClassList[i]['Classid'] == item.classid)\r\n");
      out.write("                                return ClassList[i]['Classname'];\r\n");
      out.write("                        }\r\n");
      out.write("                        return item.Classname;\r\n");
      out.write("                    }\r\n");
      out.write("                }\r\n");
      out.write("             ,{display : '电话', name : 'telephone', minWidth : 100,  editor:{type:'text'} \r\n");
      out.write("             }],\r\n");
      out.write("\t\t\t\t\tonSelectRow : function(rowdata, rowindex) {\r\n");
      out.write("\t\t\t\t\t\t$(\"#txtrowindex\").val(rowindex);\r\n");
      out.write("\t\t\t\t\t},\r\n");
      out.write("\t\t\t\t\tcheckbox:true,\r\n");
      out.write("\t\t\t\t\tenabledEdit : true,\r\n");
      out.write("\t\t\t\t\tclickToEdit : false,\r\n");
      out.write("\t\t\t\t\tisScroll : false,\r\n");
      out.write("\t\t\t\t\trownumbers:true, \r\n");
      out.write("\t\t\t\t\tpageSize:30,\r\n");
      out.write("\t\t\t\t\turl :'");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/system/Manage_selectresultlist.action',\r\n");
      out.write("\t\t\t\t\twidth : '100%',\r\n");
      out.write("\t\t\t\t\ttoolbar: { items: [\r\n");
      out.write("                         { text: '导出',click: itemclick,  icon: 'add' }               \r\n");
      out.write("                    ]}\r\n");
      out.write("\t\t\t\t});\r\n");
      out.write("\t}\r\n");
      out.write("\tfunction itemclick(item){\r\n");
      out.write("       var str = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/system/Stu_coursestudownload.action?coursenum=\"+$(\"#coursenum\").val()+\"&semester=\"+$(\"#semester\").val(); \r\n");
      out.write("       window.location.href=str;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("</script>\r\n");
      out.write("\t</head>\r\n");
      out.write("\t<body style=\"padding: 2px\">\r\n");
      out.write("\t <input id=\"coursenum\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${coursenum }", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\" type=\"hidden\" />\r\n");
      out.write("\t <input id=\"semester\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${semester }", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\" type=\"hidden\" />\r\n");
      out.write("\t <div class=\"l-clear\"></div>\r\n");
      out.write("\t <div id=\"maingrid\" ></div>\r\n");
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
