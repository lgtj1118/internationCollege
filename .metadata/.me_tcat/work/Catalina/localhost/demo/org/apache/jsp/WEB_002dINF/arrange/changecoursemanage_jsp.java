package org.apache.jsp.WEB_002dINF.arrange;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import org.springframework.web.context.request.SessionScope;
import java.util.*;

public final class changecoursemanage_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("    <title>天津工业大学排课管理系统</title>\t   \r\n");
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
      out.write("    <script type=\"text/javascript\"> \r\n");
      out.write("    var StatusData = [{ status: 0, text: '审核中' }, { status: 1, text: '批准'}, { status: 2, text: '未批准'}]; \r\n");
      out.write("\t$(f_initGrid);\r\n");
      out.write("\tvar manager, g;\r\n");
      out.write("\tfunction f_initGrid() {\r\n");
      out.write("\t\tg = manager = $(\"#maingrid\").ligerGrid(\r\n");
      out.write("\t\t\t\t{\r\n");
      out.write("\t\t\t\tcolumns : [\r\n");
      out.write("\t\t\t\t{ display : '序号',name : 'id',width : 60,hide:true,type : 'int'}, \r\n");
      out.write("\t\t\t\t{ display : '原课程',columns:[\r\n");
      out.write("\t\t\t\t\t {display : '课程编号', name : 'oldcoursenum', minWidth : 100,editor: { type: 'text'}} ,\r\n");
      out.write("\t\t\t\t\t {display : '课程名称', name : 'oldCourseName', minWidth : 120,editor: { type: 'text'}} ,\r\n");
      out.write("\t\t\t\t\t {display : '地点',    name : 'oldroomName',   minWidth : 150,editor: { type: 'text'}} , \r\n");
      out.write("\t\t\t\t\t {display : '教师编号', name : 'applyTeacher.identificationnum',width : 120,hide:false,editor: { type: 'text'}},\r\n");
      out.write("\t\t\t\t\t {display : '任课教师', name : 'applyTeacher.teachername',width : 120,hide:false,editor: { type: 'text'}}\r\n");
      out.write("\t\t\t\t]}, \r\n");
      out.write("\t\t\t\t{ display : '调整课程',columns:[\r\n");
      out.write("\t\t\t\t\t {display : '课程编号',name : 'newcoursenum',minWidth : 100,editor: { type: 'text'}} ,\r\n");
      out.write("\t\t\t\t\t {display : '课程名称',name : 'newCourseName',minWidth : 120,editor: { type: 'text'}} ,\r\n");
      out.write("\t\t\t\t\t {display : '地点',name : 'newroomName',minWidth : 150,editor: { type: 'text'}} ,\r\n");
      out.write("\t\t\t\t\t {display : '教师编号', name : 'newTeacher.identificationnum',width : 120,hide:false,editor: { type: 'text'}},\r\n");
      out.write("\t\t\t\t\t {display : '任课教师', name : 'newTeacher.teachername',width : 120,hide:false,editor: { type: 'text'}}\r\n");
      out.write("\t\t\t\t]} , \r\n");
      out.write("\t\t\t\t{ display : '调课原因',name : 'reason',minWidth : 160,editor: { type: 'text'}}  , \r\n");
      out.write("\t\t\t\t{ display : '课程原始时间',\r\n");
      out.write("\t\t\t\tcolumns:[\r\n");
      out.write("\t\t\t\t{ display:'上课日期' , name:'olddate',minWidth : 120,editor: { type: 'int'} },\r\n");
      out.write("\t\t\t\t{ display:'节次' , name:'oldslot',  minWidth : 60,editor: { type: 'int'} }\r\n");
      out.write("\t\t\t\t]\t\t\t\r\n");
      out.write("\t\t\t} ,{display : '计划上课时间',\r\n");
      out.write("\t\t\t\tcolumns:[\r\n");
      out.write("\t\t\t\t{ display:'上课日期' , name:'newdate',minWidth : 120,editor: { type: 'int'} },\r\n");
      out.write("\t\t\t\t{ display:'节次' , name:'newslot',  minWidth : 60,editor: { type: 'int'} }\r\n");
      out.write("\t\t\t\t]\t\r\n");
      out.write("\t\t\t}, {display : '申请日期',name : 'applytime',width : 120,editor: { type: 'text'}}  , \r\n");
      out.write("\t\t\t{   display : '状态',name : 'status',width : 120,\r\n");
      out.write("\t\t\t\teditor: { type: 'select', data: StatusData, valueField: 'status' },\r\n");
      out.write("                    render: function (item)\r\n");
      out.write("                    {\r\n");
      out.write("                        if (parseInt(item.status) == 0){ var h=\"<span style='color:red;'>审核中</span>\" ;return h;}\r\n");
      out.write("                        else if (parseInt(item.status) == 1) { var h=\"<span style='color:blue;'>批准</span>\" ;return h;}\r\n");
      out.write("                        else if (parseInt(item.status) == 2) { var h=\"<span style='color:orange;'>未批准</span>\" ;return h;}                                   \r\n");
      out.write("                   }\r\n");
      out.write("\t\t\t} ],\r\n");
      out.write("\t\t\t\t\tonSelectRow : function(rowdata, rowindex) {\r\n");
      out.write("\t\t\t\t\t\t$(\"#txtrowindex\").val(rowindex);\r\n");
      out.write("\t\t\t\t\t},\r\n");
      out.write("\t\t\t\t\tenabledEdit : true,\r\n");
      out.write("\t\t\t\t\tclickToEdit : false,\r\n");
      out.write("\t\t\t\t\tisScroll : false,\r\n");
      out.write("\t\t\t\t\tcheckbox:false,\r\n");
      out.write("\t\t\t        rownumbers:true,\r\n");
      out.write("\t\t\t\t\turl :'");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/system/Manage_changecourselist.action',\r\n");
      out.write("\t\t\t\t\twidth : '100%'\r\n");
      out.write("\t\t\t\t});\r\n");
      out.write("\t}\t\r\n");
      out.write("\tfunction add(){\r\n");
      out.write("\t  var row = manager.getSelectedRow();\r\n");
      out.write("\t  if (row.status != 0){\r\n");
      out.write("\t  \talert(\"只能批准未审核状态的申请\");\r\n");
      out.write("\t  \treturn;\r\n");
      out.write("\t  }\r\n");
      out.write("\t  var flag = true;\r\n");
      out.write("\t  $.post(\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/system/Manage_checkAdjustApply.action?isApprove=\"+flag+\"&adjustcourseID=\"+row.id,null,function(){\r\n");
      out.write("\t    //alert(\"提交成功！\");\r\n");
      out.write("\t    g.loadData();\r\n");
      out.write("\t  });\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\tfunction deleterow(){\r\n");
      out.write("\t\tvar row = manager.getSelectedRow();\r\n");
      out.write("\t\tif (row.status != 0){\r\n");
      out.write("\t\t  \talert(\"只能驳回未审核状态的申请\");\r\n");
      out.write("\t\t  \treturn;\r\n");
      out.write("\t\t }\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tvar flag = \"false\";\r\n");
      out.write("\t\t$.post(\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/system/Manage_checkAdjustApply.action?isApprove=\"+flag+\"&adjustcourseID=\"+row.id,null,function(){\r\n");
      out.write("\t\t  //alert(\"提交成功！\");\r\n");
      out.write("\t\t  g.loadData();\r\n");
      out.write("\t\t})\r\n");
      out.write("\t}\r\n");
      out.write("</script>\r\n");
      out.write("\t</head>\r\n");
      out.write("\t<body style=\"padding: 2px\">\t\t\r\n");
      out.write("\t\t<div style=\"margin-top:10px;\" >&nbsp;<font size=\"2\">&nbsp;&nbsp;注：<br>&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp; 申请调课批复前，请先查看申请调课日期相关教室是否已安排课程。</font><br><br></div>\r\n");
      out.write("\t\t<a class=\"l-button\" style=\"width:60px;float:left; margin:3px;\" onclick=\"add()\">批&nbsp;&nbsp;准</a>\r\n");
      out.write("\t\t<a class=\"l-button\" style=\"width:60px;float:left; margin:3px;\" onclick=\"deleterow()\">驳&nbsp;&nbsp;回</a>\t\t\t\r\n");
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
