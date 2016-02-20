package org.apache.jsp.WEB_002dINF.arrange;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import org.springframework.web.context.request.SessionScope;
import java.util.*;

public final class arrangecourse_jsp extends org.apache.jasper.runtime.HttpJspBase
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
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">\r\n");
      out.write("<html>\r\n");
      out.write("  <head>\r\n");
      out.write("    <base href=\"");
      out.print(basePath);
      out.write("\">   \r\n");
      out.write("    <title>天津工业大学排课管理系统</title>\t    \r\n");
      out.write("\t<link href=\"");
      out.print(basePath);
      out.write("js/ligerUI/skins/Aqua/css/ligerui-all.css\" rel=\"stylesheet\"type=\"text/css\" />\t\r\n");
      out.write("\t<link href=\"");
      out.print(basePath );
      out.write("js/ligerUI/skins/Gray/css/all.css\" rel=\"stylesheet\" type=\"text/css\"/>\t\r\n");
      out.write("    <script type=\"text/javascript\" src=\"js/jquery-validation/jquery.validate.min.js\" charset=\"utf-8\"></script>\r\n");
      out.write("    <script type=\"text/javascript\" src=\"js/json2.js\" charset=\"utf-8\"></script>\r\n");
      out.write("    <script type=\"text/javascript\" src=\"js/jquery-validation/jquery.metadata.js\" charset=\"utf-8\"></script>\r\n");
      out.write("    <script type=\"text/javascript\" src=\"js/jquery-validation/messages_cn.js\" charset=\"utf-8\"></script>\r\n");
      out.write("    <script src=\"js/jquery/jquery-1.3.2.min.js\"type=\"text/javascript\"></script>\r\n");
      out.write("\t<script src=\"js/ligerUI/core/base.js\" type=\"text/javascript\"></script>\r\n");
      out.write("\t<script src=\"js/ligerUI/ligerui.all.js\" type=\"text/javascript\"></script>\r\n");
      out.write("\t<!-- <script type=\"text/javascript\" src=\"js/semester.js\" ></script> -->\r\n");
      out.write("<script type=\"text/javascript\">  \r\n");
      out.write("   var CourseData = { \r\n");
      out.write("\t        Rows: [");
String s=(String) request.getAttribute("courselist");
      out.print(s);
      out.write("]};\r\n");
      out.write("   var CourseList = CourseData.Rows;\r\n");
      out.write("   var CoursecreditData = { \r\n");
      out.write("\t         Rows: [");
String ss=(String) request.getAttribute("coursecredit");
      out.print(ss);
      out.write("]};\r\n");
      out.write("   var CourseCredit = CoursecreditData.Rows;\r\n");
      out.write("   var CourseCharacterData = { \r\n");
      out.write("\t        Rows: [ ");
String sss=(String) request.getAttribute("character");
      out.write(' ');
      out.print(sss);
      out.write("]};\r\n");
      out.write("   var CourseCharacter = CourseCharacterData.Rows;\r\n");
      out.write("   var CourseCheckwayData = { \r\n");
      out.write("\t        Rows: [");
String ssss=(String) request.getAttribute("checkway");
      out.write(' ');
      out.print(ssss);
      out.write("]};\r\n");
      out.write("   var CourseCheckway = CourseCheckwayData.Rows;\r\n");
      out.write("   var IsElectiveData = [{ isElective: '0', text: '必修' }, { isElective: '1', text: '限选'}, { isElective: '2', text: '任选'}];\r\n");
      out.write("\t$(f_initGrid);\r\n");
      out.write("\tvar manager, g;\r\n");
      out.write("\tfunction f_initGrid() {\r\n");
      out.write("\t\tg = manager = $(\"#maingrid\").ligerGrid(\r\n");
      out.write("\t\t\t\t{\r\n");
      out.write("\t\t\t\tcolumns : [{\r\n");
      out.write("\t\t\t\tdisplay : 'ID',\r\n");
      out.write("\t\t\t\tname : 'id',\r\n");
      out.write("\t\t\t\twidth : 60,\r\n");
      out.write("\t\t\t\thide:true,\r\n");
      out.write("\t\t\t\ttype : 'int'\r\n");
      out.write("\t\t\t}, {\r\n");
      out.write("\t\t\t\tdisplay : '课程编号',\r\n");
      out.write("\t\t\t\tname : 'coursenum',\r\n");
      out.write("\t\t\t\tminWidth : 120,\r\n");
      out.write("\t\t\t\teditor: { type: 'text'}\r\n");
      out.write("\t\t\t} , {\r\n");
      out.write("\t\t\t\tdisplay : '班级',\r\n");
      out.write("\t\t\t\tname : 'classes',\r\n");
      out.write("\t\t\t\tminWidth : 120,\r\n");
      out.write("\t\t\t\teditor: { type: 'text'}\r\n");
      out.write("\t\t\t} , {\r\n");
      out.write("\t\t\t\tdisplay : '课程名称',\r\n");
      out.write("\t\t\t\tname : 'coursename',\r\n");
      out.write("\t\t\t\tminWidth : 120,\r\n");
      out.write("\t\t\t\teditor: { type: 'text'}\r\n");
      out.write("\t\t\t} , {\r\n");
      out.write("\t\t\t\tdisplay : '开课周数',columns:[\r\n");
      out.write("\t\t\t\t{ display:'起始周' , name:'begainweek',minWidth : 60,editor: { type: 'int'} },\r\n");
      out.write("\t\t\t\t{ display:'结束周' , name:'endweek',  minWidth : 60,editor: { type: 'int'} }\r\n");
      out.write("\t\t\t\t]\t\t\t\r\n");
      out.write("\t\t\t} , {\r\n");
      out.write("\t\t\t\tdisplay : '学分',\r\n");
      out.write("\t\t\t\tname : 'credits',\r\n");
      out.write("\t\t\t\tminWidth : 60\r\n");
      out.write("\t\t\t\t/* editor: { type: 'select', data: CourseCredit, valueColumnName: 'Coursecredit', displayColumnName: 'Coursecredit' }, \r\n");
      out.write("                  render: function (item)\r\n");
      out.write("                    {\r\n");
      out.write("                        for (var i = 0; i < CourseCredit.length; i++)\r\n");
      out.write("                        {\r\n");
      out.write("                            if (CourseCredit[i]['Coursecredit'] == item.credits)\r\n");
      out.write("                                return CourseCredit[i]['Coursecredit'];\r\n");
      out.write("                        }\r\n");
      out.write("                        return item.Coursecredit;\r\n");
      out.write("                    } */\r\n");
      out.write("\t\t\t} , {\r\n");
      out.write("\t\t\t\tdisplay : '课程性质',\r\n");
      out.write("\t\t\t\tname : 'isElective',\r\n");
      out.write("\t\t\t\tminWidth : 80,\r\n");
      out.write("\t\t\t\teditor: { type: 'select', data: IsElectiveData, valueField: 'isElective' },\r\n");
      out.write("                    render: function (item)\r\n");
      out.write("                    {\r\n");
      out.write("                        if (parseInt(item.isElective) == 0){ return '必修';}\r\n");
      out.write("                        else if (parseInt(item.isElective) == 1) { return '限选';}\r\n");
      out.write("                        else if (parseInt(item.isElective) == 2) { return '任选';}                                              \r\n");
      out.write("                    }\r\n");
      out.write("\t\t\t} /* , {\r\n");
      out.write("\t\t\t\tdisplay : '考核方式',\r\n");
      out.write("\t\t\t\tname : 'checkway',\r\n");
      out.write("\t\t\t\tminWidth : 120,\r\n");
      out.write("\t\t\t\teditor: { type: 'select', data: CourseCheckway, valueColumnName: 'Coursecheckway', displayColumnName: 'Coursecheckway' }, \r\n");
      out.write("                  render: function (item)\r\n");
      out.write("                    {\r\n");
      out.write("                        for (var i = 0; i < CourseCheckway.length; i++)\r\n");
      out.write("                        {\r\n");
      out.write("                            if (CourseCheckway[i]['Coursecheckway'] == item.checkway)\r\n");
      out.write("                                return CourseCheckway[i]['Coursecheckway'];\r\n");
      out.write("                        }\r\n");
      out.write("                        return item.Coursecheckway;\r\n");
      out.write("                    } \r\n");
      out.write("\t\t\t}  */, {\r\n");
      out.write("\t\t\t\tdisplay : '任课教师',\r\n");
      out.write("\t\t\t\tname : 'teachername',\r\n");
      out.write("\t\t\t\twidth : 120,\r\n");
      out.write("\t\t\t\teditor: { type: 'text'}\r\n");
      out.write("\t\t\t} ],\r\n");
      out.write("\t\t\t\t\tonSelectRow : function(rowdata, rowindex) {\r\n");
      out.write("\t\t\t\t\t\t$(\"#txtrowindex\").val(rowindex);\r\n");
      out.write("\t\t\t\t\t},\r\n");
      out.write("\t\t\t\t\tenabledEdit : true,\r\n");
      out.write("\t\t\t\t\tclickToEdit : false,\r\n");
      out.write("\t\t\t\t\tisScroll : false,\r\n");
      out.write("\t\t\t\t\tcheckbox:false,\r\n");
      out.write("\t\t\t\t\tpageSize:15,\r\n");
      out.write("\t\t\t        rownumbers:true,\r\n");
      out.write("\t\t\t\t\turl :'");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/system/Manage_semestercourselist.action',\r\n");
      out.write("\t\t\t\t\twidth : '100%'\r\n");
      out.write("\t\t\t\t});\r\n");
      out.write("\t}\r\n");
      out.write("\tvar m ;\t\r\n");
      out.write("    function f_next(){\r\n");
      out.write("       var semester = $(\"#semester option:selected\").val();\r\n");
      out.write("       if(semester.length!=0){\r\n");
      out.write("         var str = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/system/Manage_setemptyslot.action?semester=\"+semester;      \r\n");
      out.write("         m=$.ligerDialog.open({\r\n");
      out.write("\t\t\turl : str,\r\n");
      out.write("\t\t\theight : 400,\r\n");
      out.write("\t\t\twidth : 600,\r\n");
      out.write("\t\t\tisDrag:true,\r\n");
      out.write("\t\t\tshowMax:true,\r\n");
      out.write("\t\t\tshowToggle:true,\r\n");
      out.write("\t\t\tslide: false,\t\t\t\r\n");
      out.write("\t\t\tmodal:false,\r\n");
      out.write("\t\t\tleft:200,\r\n");
      out.write("\t\t\ttitle:'设置选修上课时间',\r\n");
      out.write("\t\t\tallowClose:true,\r\n");
      out.write("\t\t    isResize : false\r\n");
      out.write("\t\t});\r\n");
      out.write("       }else{\r\n");
      out.write("         alert(\"请先选定学期\");\r\n");
      out.write("     \r\n");
      out.write("       }\r\n");
      out.write("    }\r\n");
      out.write("    \r\n");
      out.write("  $(document).ready(function(){\r\n");
      out.write("\t\tloadSemester();\r\n");
      out.write("\t\t\r\n");
      out.write("\t});\r\n");
      out.write("   \r\n");
      out.write("    var flag = false;\r\n");
      out.write("    function loadSemester(){\r\n");
      out.write("    \tvar semester = $(\"#semester\").val();\r\n");
      out.write("    \tif (semester == null){\r\n");
      out.write("    \t\tif (flag)\r\n");
      out.write("    \t\t\talert(\"请选择学期！\");\r\n");
      out.write("    \t\tflag = true;\r\n");
      out.write("    \t\treturn;\r\n");
      out.write("    \t}\r\n");
      out.write("    \t//alert(semester);\r\n");
      out.write("    \tvar str = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/system/Manage_Searchsemestercourselist.action?semester=\" + semester;    \t\r\n");
      out.write("\t\t$(\"#maingrid\").ligerGrid({\r\n");
      out.write("\t\t\t\t\turl : str\r\n");
      out.write("\t\t });\r\n");
      out.write("    }\r\n");
      out.write("    \r\n");
      out.write("   function manual(){\r\n");
      out.write("   \tvar str = \"system/Manage_manualArrange.action?semChosenCourse.semester=\"+$(\"#semester\").val();\r\n");
      out.write("\t window.location.href=str;\r\n");
      out.write("   }\r\n");
      out.write(" $(document).ready(function(){\t\t\t\r\n");
      out.write("\tvar nowDate = new Date();\r\n");
      out.write("\tvar nowYear = nowDate.getFullYear();  \r\n");
      out.write("\tvar lastYear = nowYear-1;\r\n");
      out.write("\tvar before = lastYear-1;\r\n");
      out.write("\tvar nextYear = nowYear+1;\r\n");
      out.write("\tvar nowuptext = lastYear+\"-\"+nowYear+\"学年第一学期\";\r\n");
      out.write("\tvar nowupvalue = nowYear+\"01\";\r\n");
      out.write("\tvar nowdowntext = lastYear+\"-\"+nowYear + \"学年第二学期\";\r\n");
      out.write("\tvar nowdownvalue = nowYear+\"02\";\r\n");
      out.write("\tvar semester = document.getElementById(\"semester\");\r\n");
      out.write("\tvar objOption=document.createElement(\"OPTION\"); \r\n");
      out.write("    var objOption1=document.createElement(\"OPTION\");   \r\n");
      out.write("    objOption.value=nowupvalue;   objOption.text=nowuptext;\r\n");
      out.write("    objOption1.value=nowdownvalue;  objOption1.text=nowdowntext;\r\n");
      out.write("    var month = nowDate.getMonth();\r\n");
      out.write("\tvar now;\r\n");
      out.write("\tif (month > 9) {\r\n");
      out.write("\t\tnow = nowYear + \"01\";\r\n");
      out.write("\t} else {\r\n");
      out.write("\t\tnow = nowYear + \"02\";\r\n");
      out.write("\t}\r\n");
      out.write("\tif(now==nowupvalue){\r\n");
      out.write("        semester.add(objOption);\r\n");
      out.write("        semester.options[semester.options.length-1].selected='selected';     \t\t\r\n");
      out.write("\t}else if(now==nowdownvalue) {      \r\n");
      out.write("        semester.add(objOption1); \r\n");
      out.write("        semester.options[semester.options.length-1].selected='selected';\r\n");
      out.write("\t}\r\n");
      out.write("        \r\n");
      out.write("    \r\n");
      out.write("})   \r\n");
      out.write("</script>\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write("body {\r\n");
      out.write("\tfont-size: 12px;\r\n");
      out.write("}\r\n");
      out.write(".l-button{\r\n");
      out.write("  font-size: 12px;\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("\t</head>\r\n");
      out.write("\t<body style=\"padding: 2px\">\t\t\t\r\n");
      out.write("\t<dir style=\"float: left; padding-left:10px\">\r\n");
      out.write("\t<div style=\"margin:10px;\" ><font size=\"4\"><strong>注：</strong>\r\n");
      out.write("\t</font><br>&nbsp;&nbsp; &nbsp; 排课之前，请先设置学期开课课程，学期使用教室。\r\n");
      out.write("\t<!-- <strong style=\"color:red\">任选课必须手动置入。</strong> -->\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<table >\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td colspan=\"4\"><img alt=\"flow_chat\" src=\"images/flow_chat1.jpg\" height=\"100px\"></td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t    <td width=\"60px\" >学期：&nbsp;</td>\t\t\t    \r\n");
      out.write("\t\t\t    <td width=\"80px\" >\r\n");
      out.write("\t\t\t    <select id=\"semester\" name=\"semester\">\r\n");
      out.write("\t\t\t     <!-- <option value=\"\" ></option>\r\n");
      out.write("\t\t\t     <option value=\"201401\" >2014学年上学期</option>\r\n");
      out.write("\t\t\t     <option value=\"201402\" >2014学年下学期</option>\r\n");
      out.write("\t\t\t     <option value=\"201501\" >2015学年上学期</option>\r\n");
      out.write("\t\t\t     <option value=\"201502\" >2015学年下学期</option> -->\r\n");
      out.write("\t\t\t   </select></td>\r\n");
      out.write("\t\t\t\t<td height=\"25px\">\r\n");
      out.write("\t\t\t\t\t<a class=\"l-button\" style=\"width:60px;float:left; margin-left:10px\" onclick=\"f_next()\" >下一步</a>\r\n");
      out.write("\t\t\t\t</td>\t\t\t\t\r\n");
      out.write("\t\t\t\t<td height=\"25px\">\r\n");
      out.write("\t\t\t\t\t<a class=\"l-button\" style=\"width:60px;float:left; margin-left:10px\" onclick=\"manual()\" >手动排课</a>\r\n");
      out.write("\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t<td></td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t</table>\r\n");
      out.write("\t\t</dir>\r\n");
      out.write("\t\t<div class=\"l-clear\"></div>\r\n");
      out.write("\t\t<div id=\"maingrid\" ></div>\r\n");
      out.write("\t</body>\r\n");
      out.write("</html>\r\n");
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
