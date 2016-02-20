package org.apache.jsp.WEB_002dINF.arrange;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import org.springframework.web.context.request.SessionScope;
import java.util.*;

public final class semestercourse_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("    <title>天津工业大学国际教育学院教学服务系统</title>\t   \r\n");
      out.write("\t<link href=\"");
      out.print(basePath);
      out.write("js/ligerUI/skins/Aqua/css/ligerui-all.css\" rel=\"stylesheet\"type=\"text/css\" />\t\r\n");
      out.write("\t<link href=\"");
      out.print(basePath );
      out.write("js/ligerUI/skins/Gray/css/all.css\" rel=\"stylesheet\" type=\"text/css\"/>\t\r\n");
      out.write("     <link href=\"js/ligerUI/skins/ligerui-icons.css\" rel=\"stylesheet\" type=\"text/css\">\r\n");
      out.write("    <script type=\"text/javascript\" src=\"js/jquery-validation/jquery.validate.min.js\" charset=\"utf-8\"></script>\r\n");
      out.write("    <script type=\"text/javascript\" src=\"js/json2.js\" charset=\"utf-8\"></script>\r\n");
      out.write("    <script type=\"text/javascript\" src=\"js/jquery-validation/jquery.metadata.js\" charset=\"utf-8\"></script>\r\n");
      out.write("    <script type=\"text/javascript\" src=\"js/jquery-validation/messages_cn.js\" charset=\"utf-8\"></script>\r\n");
      out.write("    <script src=\"js/jquery/jquery-1.3.2.min.js\"type=\"text/javascript\"></script>\r\n");
      out.write("\t<script src=\"js/ligerUI/core/base.js\" type=\"text/javascript\"></script>\r\n");
      out.write("\t<script src=\"js/ligerUI/ligerui.all.js\" type=\"text/javascript\"></script>\r\n");
      out.write("\t<script src=\"js/ligerUI/plugins/ligerToolBar.js\" type=\"text/javascript\"></script>\r\n");
      out.write("\t<!-- <script type=\"text/javascript\" src=\"js/semester.js\" ></script> -->\r\n");
      out.write("<script type=\"text/javascript\">  \r\n");
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
      out.write("  \r\n");
      out.write("\t$(f_initGrid);\r\n");
      out.write("\t$(f_initGrid1);\r\n");
      out.write("\tvar manager, g;\r\n");
      out.write("\tfunction f_initGrid() {\r\n");
      out.write("\t\tg = manager = $(\"#maingrid1\").ligerGrid(\r\n");
      out.write("\t\t\t\t{\t\t\t\r\n");
      out.write("\t\t\t\tcolumns : [{\r\n");
      out.write("\t\t\t\tdisplay : 'ID',\r\n");
      out.write("\t\t\t\tname : 'id',\r\n");
      out.write("\t\t\t\twidth : 60,\r\n");
      out.write("\t\t\t\thide:true,\r\n");
      out.write("\t\t\t\ttype : 'int'\r\n");
      out.write("\t\t\t}, {\r\n");
      out.write("\t\t\t\tdisplay : '课程编号',\r\n");
      out.write("\t\t\t\tname : 'num',\r\n");
      out.write("\t\t\t\tminWidth : 120,\r\n");
      out.write("\t\t\t\teditor: { type: 'text'}\r\n");
      out.write("\t\t\t} , {\r\n");
      out.write("\t\t\t\tdisplay : '课程名称',\r\n");
      out.write("\t\t\t\tname : 'coursename',\r\n");
      out.write("\t\t\t\tminWidth : 120,\r\n");
      out.write("\t\t\t\teditor: { type: 'text'}\r\n");
      out.write("\t\t\t}],\r\n");
      out.write("\t\t\t\t\tonSelectRow : function(rowdata, rowindex) {\r\n");
      out.write("\t\t\t\t\t\t$(\"#txtrowindex\").val(rowindex);\r\n");
      out.write("\t\t\t\t\t},\r\n");
      out.write("\t\t\t\t\tenabledEdit : true,\r\n");
      out.write("\t\t\t\t\tclickToEdit : false,\r\n");
      out.write("\t\t\t\t\tisScroll : false,\r\n");
      out.write("\t\t\t\t\tcheckbox:true,\r\n");
      out.write("\t\t\t        rownumbers:true,\r\n");
      out.write("\t\t\t        title:'待选课程',\r\n");
      out.write("\t\t\t        pageSize:15,\r\n");
      out.write("\t\t\t\t\turl :'");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/system/Manage_courselist.action',\r\n");
      out.write("\t\t\t\t\twidth : '38%',\r\n");
      out.write("\t\t\t\t\theight:'70%'\t\t\t\t\r\n");
      out.write("\t\t\t\t});\r\n");
      out.write("\t}\r\n");
      out.write("var managers, gs;\r\n");
      out.write("\tfunction f_initGrid1() {\r\n");
      out.write("\t\tgs = managers = $(\"#maingrid2\").ligerGrid(\r\n");
      out.write("\t\t\t\t{\t\t\t\r\n");
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
      out.write("\t\t\t\tdisplay : '课程名称',\r\n");
      out.write("\t\t\t\tname : 'coursename',\r\n");
      out.write("\t\t\t\tminWidth : 120,\r\n");
      out.write("\t\t\t\teditor: { type: 'text'}\r\n");
      out.write("\t\t\t}],\r\n");
      out.write("\t\t\t\t\tonSelectRow : function(rowdata, rowindex) {\r\n");
      out.write("\t\t\t\t\t\t$(\"#txtrowindex\").val(rowindex);\r\n");
      out.write("\t\t\t\t\t},\r\n");
      out.write("\t\t\t\t\tenabledEdit : true,\r\n");
      out.write("\t\t\t\t\tclickToEdit : false,\r\n");
      out.write("\t\t\t\t\tisScroll : false,\r\n");
      out.write("\t\t\t\t\tcheckbox:true,\r\n");
      out.write("\t\t\t        rownumbers:true,\r\n");
      out.write("\t\t\t        title:'已选课程',\r\n");
      out.write("\t\t\t        pageSize:15,\r\n");
      out.write("\t\t\t\t\turl :'");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/system/Manage_semestercourselist.action',\r\n");
      out.write("\t\t\t\t\twidth : '38%',\r\n");
      out.write("\t\t\t\t\theight:'70%'\t\t\t\r\n");
      out.write("\t\t\t\t});\r\n");
      out.write("\t}\r\n");
      out.write("\tfunction f_selected(){\r\n");
      out.write("\t  var semester = $(\"#semester option:selected\").val();\r\n");
      out.write("       if(semester.length!=0){\r\n");
      out.write("\t      var row = manager.getSelectedRow();\r\n");
      out.write("          if (!row) { alert('请至少选择一个课程！'); return; }\r\n");
      out.write("          var rows = g.getCheckedRows();\r\n");
      out.write("          var str = \"\";\r\n");
      out.write("          $(rows).each(function () {\r\n");
      out.write("              str += this.id + \",\";\r\n");
      out.write("          });\r\n");
      out.write("          $.post(\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/system/Manage_semestercourseadd.action?ids=\"+str+\"&semester=\"+semester,null,function(){\r\n");
      out.write("              //alert(\"选定成功！\");\r\n");
      out.write("              window.location.reload();\r\n");
      out.write("              //manager.deleteSelectedRow();\r\n");
      out.write("          })\r\n");
      out.write("      }else{\r\n");
      out.write("        alert(\"请先选定学期！\");\r\n");
      out.write("      }\r\n");
      out.write("\t}\r\n");
      out.write("\tfunction f_delete(){\r\n");
      out.write("\t  var row1 = managers.getSelectedRow();\r\n");
      out.write("\t  if (!row1) { alert('请至少选择一个课程！'); return; }\r\n");
      out.write("      var rows1 = gs.getCheckedRows();\r\n");
      out.write("      var str = \"\";\r\n");
      out.write("      $(rows1).each(function ()\r\n");
      out.write("      {\r\n");
      out.write("         str += this.id + \",\";\r\n");
      out.write("      });\r\n");
      out.write("      $.post(\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/system/Manage_semestercoursedelete.action?ids=\"+str,null,function(){\r\n");
      out.write("        //alert(\"删选成功！\");\r\n");
      out.write("        window.location.reload();        \r\n");
      out.write("      })\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\tfunction batch(){\r\n");
      out.write("\tvar str = \"/demo/system/Manage_batchSemesterCourse.action\";\r\n");
      out.write("\t\tm=$.ligerDialog.open({\t\t   \r\n");
      out.write("\t\t\turl : str,\r\n");
      out.write("\t\t\theight : 400,\r\n");
      out.write("\t\t\twidth : 800,\r\n");
      out.write("\t\t\tisResize : true\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\t\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\tfunction f_next(){\r\n");
      out.write("\t   var semester = $(\"#semester option:selected\").text();\r\n");
      out.write("\t   var str = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/system/Manage_semestercoursesetteacher.action?semestertext=\"+  encodeURI(encodeURI(semester));\r\n");
      out.write("\t   window.location.href=str;\r\n");
      out.write("\t}\r\n");
      out.write("\t/* function check(){\r\n");
      out.write("\t  var semester= $(\"#semester option:selected \").val();\r\n");
      out.write("\t  var str = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/system/Manage_Searchcourselist.action?semester=\"+semester;\r\n");
      out.write("\t  $(\"#maingrid1\").ligerGrid({\r\n");
      out.write("\t\t\t\t\turl :str,\r\n");
      out.write("\t  })\r\n");
      out.write("\t  var str1 = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/system/Manage_Searchsemestercourselist.action?semester=\"+semester;\t  \r\n");
      out.write("\t  $(\"#maingrid2\").ligerGrid({\r\n");
      out.write("\t\t\t\t\turl :str1,\r\n");
      out.write("\t  });\r\n");
      out.write("\t} */\r\n");
      out.write("\t $(document).ready(function(){\t\t\t\r\n");
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
      out.write("\t}           \r\n");
      out.write("})  \r\n");
      out.write("</script>\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write("#contain{\r\n");
      out.write(" width: 100%;\r\n");
      out.write(" border: 1px solid #c6c6c6;\r\n");
      out.write("}\r\n");
      out.write(".l-button{\r\n");
      out.write(" width:80px; margin:20px 50px ;\r\n");
      out.write(" border-radiux:5px;\r\n");
      out.write("}\r\n");
      out.write("#l-l-button{\r\n");
      out.write(" width:80px; \r\n");
      out.write(" margin-top:100px;\r\n");
      out.write(" border-radiux:5px;\r\n");
      out.write("}\r\n");
      out.write(".l-button-l{\r\n");
      out.write("  margin-left: 20px;\r\n");
      out.write("  margin-top:-5px;\r\n");
      out.write(" }\r\n");
      out.write("</style>\r\n");
      out.write("\t</head>\r\n");
      out.write("\t<body style=\"padding: 2px\">\t\r\n");
      out.write("\t    <div style=\"margin: 10px;\"><font size=\"4\"><strong>注：</strong></font><br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 选择课程后，点击底部下一步按钮，即可设置本学期，开课课程详细信息。 \r\n");
      out.write("\t    \t<a class=\"l-button\" onclick=\"batch()\"><strong>批量上传</strong></a>\r\n");
      out.write("\t    </div>\t\t\t\r\n");
      out.write("\t\t<div class=\"l-clear\"></div>\r\n");
      out.write("\t\t<div id=\"maingrid1\" style=\"margin: 4px;margin-left:10px;margin-top:-10px; padding: 0; float: left;\" ></div>\r\n");
      out.write("\t\t<div id=\"btnclass\" style=\"width:16%;margin: 4px; padding: 0; float: left;\" >\r\n");
      out.write("\t\t  <div> 学期：&nbsp;<select id=\"semester\" style=\"\" name=\"semester\" >\t<!--  onchange=\"check()\"\t -->\t     \t\t\t     \r\n");
      out.write("\t\t   </select></div>\r\n");
      out.write("\t\t  \r\n");
      out.write("\t\t   <a class=\"l-button\" onclick=\"f_selected()\"><strong>选定课程>></strong></a>\r\n");
      out.write("\t\t   <a class=\"l-button\" onclick=\"f_delete()\"><strong><<移除课程</strong></a>\r\n");
      out.write("\t\t   <!-- <a class=\"l-button\" onclick=\"f_allselected()\"><strong>全部选定>></strong></a>\r\n");
      out.write("\t\t   <a class=\"l-button\" onclick=\"f_alldelete()\"><strong><<全部移除</strong></a> -->\r\n");
      out.write("\t\t   <a class=\"l-button \" id=\"l-l-button\" onclick=\"f_next()\"><strong>下一步</strong></a>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div id=\"maingrid2\" align=\"right\" style=\"margin: 4px;margin-right:10px;margin-top:-10px; padding: 0; margin-left: 10px; float: left;\" ></div>\t\t \r\n");
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
