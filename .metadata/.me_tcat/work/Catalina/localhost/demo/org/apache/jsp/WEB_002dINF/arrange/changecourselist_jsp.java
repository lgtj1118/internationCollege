package org.apache.jsp.WEB_002dINF.arrange;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import org.springframework.web.context.request.SessionScope;
import java.util.*;

public final class changecourselist_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\t\t\t\tcolumns : [{\r\n");
      out.write("\t\t\t\tdisplay : '序号',\r\n");
      out.write("\t\t\t\tname : 'id',\r\n");
      out.write("\t\t\t\twidth : 60,\r\n");
      out.write("\t\t\t\thide:true,\r\n");
      out.write("\t\t\t\ttype : 'int'\r\n");
      out.write("\t\t\t}, {\r\n");
      out.write("\t\t\t\tdisplay : '原课程',\r\n");
      out.write("\t\t\t\tcolumns:[\r\n");
      out.write("\t\t\t\t\t {\r\n");
      out.write("\t\t\t\t\tdisplay : '课程编号',\r\n");
      out.write("\t\t\t\t\tname : 'oldcoursenum',\r\n");
      out.write("\t\t\t\t\tminWidth : 100,\r\n");
      out.write("\t\t\t\t\teditor: { type: 'text'}\r\n");
      out.write("\t\t\t\t\t} ,\r\n");
      out.write("\t\t\t\t\t{\r\n");
      out.write("\t\t\t\t\tdisplay : '课程名称',\r\n");
      out.write("\t\t\t\t\tname : 'oldCourseName',\r\n");
      out.write("\t\t\t\t\tminWidth : 120,\r\n");
      out.write("\t\t\t\t\teditor: { type: 'text'}\r\n");
      out.write("\t\t\t\t\t} ,\r\n");
      out.write("\t\t\t\t\t{\r\n");
      out.write("\t\t\t\t\tdisplay : '地点',\r\n");
      out.write("\t\t\t\t\tname : 'oldroomName',\r\n");
      out.write("\t\t\t\t\tminWidth : 150,\r\n");
      out.write("\t\t\t\t\teditor: { type: 'text'}\r\n");
      out.write("\t\t\t\t\t} \r\n");
      out.write("\t\t\t\t]\t\t\t\r\n");
      out.write("\t\t\t}, {\r\n");
      out.write("\t\t\t\tdisplay : '调整负责教师',\r\n");
      out.write("\t\t\t\tname : 'applyTeacher.teachername',\r\n");
      out.write("\t\t\t\twidth : 120,\r\n");
      out.write("\t\t\t\thide:true,\r\n");
      out.write("\t\t\t\teditor: { type: 'text'}\r\n");
      out.write("\t\t\t}, {\r\n");
      out.write("\t\t\t\tdisplay : '调整课程',\r\n");
      out.write("\t\t\t\tcolumns:[\r\n");
      out.write("\t\t\t\t\t {\r\n");
      out.write("\t\t\t\t\tdisplay : '课程编号',\r\n");
      out.write("\t\t\t\t\tname : 'newcoursenum',\r\n");
      out.write("\t\t\t\t\tminWidth : 100,\r\n");
      out.write("\t\t\t\t\teditor: { type: 'text'}\r\n");
      out.write("\t\t\t\t\t} ,\r\n");
      out.write("\t\t\t\t\t{\r\n");
      out.write("\t\t\t\t\tdisplay : '课程名称',\r\n");
      out.write("\t\t\t\t\tname : 'newCourseName',\r\n");
      out.write("\t\t\t\t\tminWidth : 120,\r\n");
      out.write("\t\t\t\t\teditor: { type: 'text'}\r\n");
      out.write("\t\t\t\t\t} ,\r\n");
      out.write("\t\t\t\t\t{\r\n");
      out.write("\t\t\t\t\tdisplay : '地点',\r\n");
      out.write("\t\t\t\t\tname : 'newroomName',\r\n");
      out.write("\t\t\t\t\tminWidth : 150,\r\n");
      out.write("\t\t\t\t\teditor: { type: 'text'}\r\n");
      out.write("\t\t\t\t\t} \r\n");
      out.write("\t\t\t\t]\t\t\t\r\n");
      out.write("\t\t\t} , {\r\n");
      out.write("\t\t\t\tdisplay : '调课原因',\r\n");
      out.write("\t\t\t\tname : 'reason',\r\n");
      out.write("\t\t\t\tminWidth : 160,\r\n");
      out.write("\t\t\t\teditor: { type: 'text'}\r\n");
      out.write("\t\t\t}  , {\r\n");
      out.write("\t\t\t\tdisplay : '课程原始时间',\r\n");
      out.write("\t\t\t\tcolumns:[\r\n");
      out.write("\t\t\t\t{ display:'上课日期' , name:'olddate',minWidth : 120,editor: { type: 'int'} },\r\n");
      out.write("\t\t\t\t{ display:'节次' , name:'oldslot',  minWidth : 60,editor: { type: 'int'} }\r\n");
      out.write("\t\t\t\t]\t\t\t\r\n");
      out.write("\t\t\t} , {\r\n");
      out.write("\t\t\t\tdisplay : '计划上课时间',\r\n");
      out.write("\t\t\t\tcolumns:[\r\n");
      out.write("\t\t\t\t{ display:'上课日期' , name:'newdate',minWidth : 120,editor: { type: 'int'} },\r\n");
      out.write("\t\t\t\t{ display:'节次' , name:'newslot',  minWidth : 60,editor: { type: 'int'} }\r\n");
      out.write("\t\t\t\t]\t\r\n");
      out.write("\t\t\t}  , {\r\n");
      out.write("\t\t\t\tdisplay : '申请日期',\r\n");
      out.write("\t\t\t\tname : 'applytime',\r\n");
      out.write("\t\t\t\twidth : 120,\r\n");
      out.write("\t\t\t\teditor: { type: 'text'}\r\n");
      out.write("\t\t\t}  , {\r\n");
      out.write("\t\t\t\tdisplay : '状态',\r\n");
      out.write("\t\t\t\tname : 'status',\r\n");
      out.write("\t\t\t\twidth : 120,\r\n");
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
      out.write("\t\t\t\t\turl :\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/system/Manage_prvChangeCourseList.action\",\r\n");
      out.write("\t\t\t\t\twidth : '100%'\r\n");
      out.write("\t\t\t\t});\r\n");
      out.write("\t}\r\n");
      out.write("\tvar m;\r\n");
      out.write("\tfunction apply(){\r\n");
      out.write("\t var str = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/system/Manage_changecourseapply.action\";\r\n");
      out.write("\t m=$.ligerDialog.open({\r\n");
      out.write("\t\t\turl : str,\r\n");
      out.write("\t\t\theight : 400,\r\n");
      out.write("\t\t\twidth : 640,\r\n");
      out.write("\t\t\tisDrag:true,\r\n");
      out.write("\t\t\tshowMax:true,\r\n");
      out.write("\t\t\tshowToggle:true,\r\n");
      out.write("\t\t\tslide: false,\t\t\t\r\n");
      out.write("\t\t\tmodal:false,\r\n");
      out.write("\t\t\tleft:200,\r\n");
      out.write("\t\t\ttitle:'调课申请',\r\n");
      out.write("\t\t\tallowClose:true,\r\n");
      out.write("\t\t    isResize : false\r\n");
      out.write("\t\t});\r\n");
      out.write("\t}\t\r\n");
      out.write("\t\r\n");
      out.write("\tfunction emptyApply(){\r\n");
      out.write("\t var str = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/system/Manage_emptyroomApply.action\";\r\n");
      out.write("\t m=$.ligerDialog.open({\r\n");
      out.write("\t\t\turl : str,\r\n");
      out.write("\t\t\theight : 400,\r\n");
      out.write("\t\t\twidth : 640,\r\n");
      out.write("\t\t\tisDrag:true,\r\n");
      out.write("\t\t\tshowMax:true,\r\n");
      out.write("\t\t\tshowToggle:true,\r\n");
      out.write("\t\t\tslide: false,\t\t\t\r\n");
      out.write("\t\t\tmodal:false,\r\n");
      out.write("\t\t\tleft:200,\r\n");
      out.write("\t\t\ttitle:'调课申请',\r\n");
      out.write("\t\t\tallowClose:true,\r\n");
      out.write("\t\t    isResize : false\r\n");
      out.write("\t\t});\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("</script>\r\n");
      out.write("\t</head>\r\n");
      out.write("\t<body style=\"padding: 2px\">\t\t\r\n");
      out.write("\t\t<div style=\"margin-top:10px;\" >&nbsp;<font size=\"2\">&nbsp;&nbsp;注：<br>&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp; 申请调课批复前，请先查看申请调课日期相关教室是否已安排课程。</font><br><br></div>\r\n");
      out.write("\t\t<a class=\"l-button\" style=\"width:100px;float:left; margin:3px;\" onclick=\"apply()\">与现有课程调换</a>\r\n");
      out.write("\t\t<a class=\"l-button\" style=\"width:100px;float:left; margin:3px;\" onclick=\"emptyApply()\">调换至空闲教室</a>\r\n");
      out.write("\t\t<!-- <a class=\"l-button\" style=\"width:60px;float:left; margin-left:10px\"  href=\"system/Manage_changecourseapply.action\">申&nbsp;&nbsp;请</a> -->\r\n");
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
