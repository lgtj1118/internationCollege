package org.apache.jsp.WEB_002dINF.student;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;

public final class stupermissionlist_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("    <title></title>\t   \r\n");
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
      out.write("\t\t\t{   display : '序号',  name : 'id',     width : 40,  type : 'int',hide:true\r\n");
      out.write("\t\t\t},{display : '护照', name : 'passport', minWidth : 100,  editor:{type:'text'}\t}\r\n");
      out.write("\t\t\t, {display : '学号', name : 'stuid',  wiminWidthdth : 120, editor: { type: 'text'}\r\n");
      out.write("\t\t\t} ,{display : '密码', name : 'password',minWidth : 80,hide:true,editor: { type: 'password'}\r\n");
      out.write("\t\t\t }, {display : '英文名', name : 'firstname',minWidth : 100, editor: { type: 'text'}\r\n");
      out.write("\t\t\t}, {display : '英文姓', name : 'lastname',minWidth : 100, editor: { type: 'text'}\r\n");
      out.write("\t\t\t}, {display : '姓名', name : 'stuname',minWidth : 80, editor: { type: 'text'}\r\n");
      out.write("\t\t\t} ,{display : '性别', name : 'stusex', minWidth : 50,  editor:{type:'text'}\t\r\n");
      out.write("\t\t\t} ,{display : '出生年月', name : 'brithdate', minWidth : 50,  editor:{type:'text'}\t\t\t\t\r\n");
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
      out.write("             ,{display : '专业', name : 'major', minWidth : 120,  editor:{type:'text'}}\r\n");
      out.write("             ,{display : '电话', name : 'telephone', minWidth : 100,  editor:{type:'text'} \r\n");
      out.write("             } ,{display : '住址', name : 'roomplace', minWidth : 120,  editor:{type:'text'}\r\n");
      out.write("             } ,{display : '国籍', name : 'nation', minWidth : 100,  editor:{type:'text'}\t}\r\n");
      out.write("             \r\n");
      out.write("             ,{display : '学生类别', name : 'studentType', minWidth : 80,  editor:{type:'text'}\t}\r\n");
      out.write("             ,{display : '入校时间', name : 'startdate', minWidth : 80, editor:{type:'text'} /* type: 'date', format: 'yyyy-MM-dd', width: 100, editor: { type: 'date'} */\t}\t\r\n");
      out.write("             ,{display : '离校时间', name : 'enddate', minWidth : 80,  editor:{type:'text'}\t}\r\n");
      out.write("             ,{display : '居留许可有效期', name : 'validResidencePermit', minWidth : 120,  editor:{type:'text'}\t}\r\n");
      out.write("             ,{display : '来源', name : 'source', minWidth : 80,  editor:{type:'text'}\t}\r\n");
      out.write("             ,{display : '学制', name : 'duration', minWidth : 80,  editor:{type:'text'}\t}\r\n");
      out.write("             ,{display : '层次', name : 'studyLevel', minWidth : 80,  editor:{type:'text'}\t}\r\n");
      out.write("             ,{display : '是否毕业', name : 'status', minWidth : 80,  editor:{type:'text'},\r\n");
      out.write("               render:function (item) {\r\n");
      out.write("\t\t\t\t\tif (parseInt(item.status) == 1) {\r\n");
      out.write("\t\t\t\t\t\treturn \"<font style='color:red'>已毕业</font>\";\r\n");
      out.write("\t\t\t\t\t} else if(parseInt(item.status) == 0) {\r\n");
      out.write("\t\t\t\t\t\treturn \"<font style='color:green'>未毕业</font>\";\r\n");
      out.write("\t\t\t\t\t}else{\r\n");
      out.write("\t\t\t\t\t    return \"<font style='color:orange'>审核驳回</font>\";\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t}\t}\r\n");
      out.write("\t\t\t,{display : '状态', name : 'source', minWidth : 80,  editor:{type:'text'},\r\n");
      out.write("               render:function (item) {\r\n");
      out.write("\t\t\t\t\tif (parseInt(item.isDeleted) == 1) {\r\n");
      out.write("\t\t\t\t\t\treturn \"<font style='color:red'>不可用</font>\";\r\n");
      out.write("\t\t\t\t\t} else {\r\n");
      out.write("\t\t\t\t\t\treturn \"<font style='color:green'>正常</font>\";\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t}\t}],\r\n");
      out.write("\t\t\t\t\tonSelectRow : function(rowdata, rowindex) {\r\n");
      out.write("\t\t\t\t\t\t$(\"#txtrowindex\").val(rowindex);\r\n");
      out.write("\t\t\t\t\t},\r\n");
      out.write("\t\t\t\t\tcheckbox:true,\r\n");
      out.write("\t\t\t\t\tenabledEdit : true,\r\n");
      out.write("\t\t\t\t\tclickToEdit : false,\r\n");
      out.write("\t\t\t\t\tisScroll : false,\r\n");
      out.write("\t\t\t\t\trownumbers:true, \r\n");
      out.write("\t\t\t\t\tpageSize:20,\r\n");
      out.write("\t\t\t\t\turl :'");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/system/Stu_stupermissionlistmap.action',\r\n");
      out.write("\t\t\t\t\twidth : '100%'\t\t\t\t\t\r\n");
      out.write("\t\t\t\t});\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("</script>\r\n");
      out.write("\t</head>\r\n");
      out.write("\t<body style=\"padding: 2px\">\r\n");
      out.write("\t <div class=\"l-clear\"></div>\r\n");
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
