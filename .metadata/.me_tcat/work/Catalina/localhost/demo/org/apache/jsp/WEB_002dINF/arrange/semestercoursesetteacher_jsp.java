package org.apache.jsp.WEB_002dINF.arrange;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.opensymphony.xwork2.ActionContext;
import org.springframework.web.context.request.SessionScope;
import java.util.*;

public final class semestercoursesetteacher_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("    <script src=\"js/jquery/jquery-1.6.min.js\"type=\"text/javascript\"></script>\r\n");
      out.write("\t<script src=\"js/ligerUI/core/base.js\" type=\"text/javascript\"></script>\r\n");
      out.write("\t<script src=\"js/ligerUI/ligerui.all.js\" type=\"text/javascript\"></script>\r\n");
      out.write("\t<script src=\"js/ligerUI/plugins/ligerToolBar.js\" type=\"text/javascript\"></script>\r\n");
      out.write("<script type=\"text/javascript\" charset=\"utf-8\" >  \r\n");
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
      out.write("   var CourseCheckway = CourseCheckwayData.Rows;  \r\n");
      out.write("    var TypeData = [{ roomtype: '多媒体教室', text: '多媒体教室' }, { roomtype: '语音室', text: '语音室'}, { roomtype: '计算机室', text: '计算机室'}, { roomtype: '体验馆', text: '体验馆'}];\r\n");
      out.write("\tvar IsElectiveData = [{ isElective: '0', text: '必修' }, { isElective: '1', text: '限选'}, { isElective: '2', text: '任选'}];\t\r\n");
      out.write("\t$(f_initGrid);\r\n");
      out.write("\tvar manager, g;\r\n");
      out.write("\tfunction f_initGrid() {\r\n");
      out.write("\t\tg = manager = $(\"#maingrid\").ligerGrid(\r\n");
      out.write("\t\t\t\t{\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t\tcolumns : [{\r\n");
      out.write("\t\t\t\tdisplay : '序号',\r\n");
      out.write("\t\t\t\tname : 'id',\r\n");
      out.write("\t\t\t\twidth : 60,\r\n");
      out.write("\t\t\t\thide:true,\r\n");
      out.write("\t\t\t\ttype : 'int'\r\n");
      out.write("\t\t\t}, {\r\n");
      out.write("\t\t\t\tdisplay : '课程编号',\r\n");
      out.write("\t\t\t\tname : 'coursenum',\r\n");
      out.write("\t\t\t\tminWidth : 80,\r\n");
      out.write("\t\t\t\t//editor: { type: 'int'}\r\n");
      out.write("\t\t\t} , {\r\n");
      out.write("\t\t\t\tdisplay : '课程名称',\r\n");
      out.write("\t\t\t\tname : 'coursename',\r\n");
      out.write("\t\t\t\tminWidth : 80,\r\n");
      out.write("\t\t\t\t//editor: { type: 'text'}\r\n");
      out.write("\t\t\t}, {\r\n");
      out.write("\t\t\t\tdisplay : '开课周数',columns:[\r\n");
      out.write("\t\t\t\t{ display:'起始周' , name:'begainweek',minWidth : 60/* ,editor: { type: 'int'} */ },\r\n");
      out.write("\t\t\t\t{ display:'结束周' , name:'endweek',  minWidth : 60/* ,editor: { type: 'int'} */ }\r\n");
      out.write("\t\t\t\t]\t\t\t\r\n");
      out.write("\t\t\t} , {\r\n");
      out.write("\t\t\t\tdisplay : '学分',\r\n");
      out.write("\t\t\t\tname : 'credits',\r\n");
      out.write("\t\t\t\tminWidth : 60,\r\n");
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
      out.write("\t\t\t}, {\r\n");
      out.write("\t\t\t\tdisplay : '周课时',\r\n");
      out.write("\t\t\t\tname : 'weeklesson',\r\n");
      out.write("\t\t\t\tminWidth : 80,\r\n");
      out.write("\t\t\t\t//editor: { type: 'int'}\r\n");
      out.write("\t\t\t}, {\r\n");
      out.write("\t\t\t\tdisplay : '总课时',\r\n");
      out.write("\t\t\t\tname : 'lessonCount',\r\n");
      out.write("\t\t\t\tminWidth : 80,\r\n");
      out.write("\t\t\t\t//editor: { type: 'int'}\r\n");
      out.write("\t\t\t}, {\r\n");
      out.write("\t\t\t\tdisplay : '课程性质',\r\n");
      out.write("\t\t\t\tname : 'isElective',\r\n");
      out.write("\t\t\t\tminWidth : 80,\r\n");
      out.write("\t\t\t\t//editor: { type: 'select', data: IsElectiveData, valueField: 'isElective' },\r\n");
      out.write("                     render: function (item)\r\n");
      out.write("                    {\r\n");
      out.write("                        if (parseInt(item.isElective) == 0){ return '必修';}\r\n");
      out.write("                        else if (parseInt(item.isElective) == 1) { return '限选';} \r\n");
      out.write("                        else if (parseInt(item.isElective) == 2) { return '任选';}                                              \r\n");
      out.write("                    } \r\n");
      out.write("\t\t\t}, {\r\n");
      out.write("\t\t\t\tdisplay : '教室类型',\r\n");
      out.write("\t\t\t\tname : 'roomtype',\r\n");
      out.write("\t\t\t\tminWidth : 80,\r\n");
      out.write("\t\t\t\teditor: { type: 'select', data: TypeData, valueField: 'roomtype' },\r\n");
      out.write("                    render: function (item)\r\n");
      out.write("                    {\r\n");
      out.write("                        for (var i = 0; i < TypeData.length; i++)\r\n");
      out.write("                        {\r\n");
      out.write("                            if (TypeData[i]['roomtype'] == item.roomtype)\r\n");
      out.write("                                return TypeData[i]['roomtype'];\r\n");
      out.write("                        }\r\n");
      out.write("                        return item.roomtype;\r\n");
      out.write("                    }\r\n");
      out.write("\t\t\t}, {\r\n");
      out.write("\t\t\t\tdisplay : '任课教师',\r\n");
      out.write("\t\t\t\tname : 'teachername',\r\n");
      out.write("\t\t\t\twidth : 120,\r\n");
      out.write("\t\t\t\trender : function(item) {\r\n");
      out.write("\t\t\t\t  var h = \"\";\r\n");
      out.write("\t\t\t\t  h += \"<a href='javascript:courseteacher(\"+ \")'>\"+item.teachername+\"</a> \";\r\n");
      out.write("\t\t\t\t  return h;\r\n");
      out.write("\t\t\t\t }\r\n");
      out.write("\t\t\t} , {\r\n");
      out.write("\t\t\t\tdisplay : '上课班级',\r\n");
      out.write("\t\t\t\tname : 'classes',\r\n");
      out.write("\t\t\t\twidth : 120,\r\n");
      out.write("\t\t\t\trender : function(item) {\r\n");
      out.write("\t\t\t\t  var h = \"\";\r\n");
      out.write("\t\t\t\t  h += \"<a href='javascript:courseclass(\"+ \")' title='\"+item.classes+\"' >\"+item.classes+\"</a> \";\r\n");
      out.write("\t\t\t\t  return h;\r\n");
      out.write("\t\t\t\t }\r\n");
      out.write("\t\t\t}  ],\r\n");
      out.write("\t\t\t\t\tonSelectRow : function(rowdata, rowindex) {\r\n");
      out.write("\t\t\t\t\t\t$(\"#txtrowindex\").val(rowindex);\r\n");
      out.write("\t\t\t\t\t},\r\n");
      out.write("\t\t\t\t\tenabledEdit : true,\r\n");
      out.write("\t\t\t\t\tclickToEdit : true,\r\n");
      out.write("\t\t\t\t\tisScroll : false,\r\n");
      out.write("\t\t\t\t\tcheckbox:false,\r\n");
      out.write("\t\t\t        rownumbers:true,\r\n");
      out.write("\t\t\t        pageSize:10,\r\n");
      out.write("\t\t\t\t\turl :'");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/system/Manage_semestercourselist.action',\r\n");
      out.write("\t\t\t\t\twidth : '100%',\t\t\t\t\t\r\n");
      out.write("\t\t\t\t});\r\n");
      out.write("\t}\r\n");
      out.write("\tfunction courseteacher(){\r\n");
      out.write("\t  var row = manager.getSelectedRow();\r\n");
      out.write("\t \tif (!row) {\r\n");
      out.write("\t\t\talert('请选择课程！');\r\n");
      out.write("\t\t\treturn;\r\n");
      out.write("\t\t}\r\n");
      out.write("      var str = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/system/Manage_courseteacherselect.action?semChosenCourse.id=\"+row.id;\r\n");
      out.write("\t  m=$.ligerDialog.open({\r\n");
      out.write("\t\t\turl : str,\r\n");
      out.write("\t\t\theight : 500,\r\n");
      out.write("\t\t\twidth : 800,\r\n");
      out.write("\t\t\ttitle:'课程教师选择',\r\n");
      out.write("\t\t\tisDrag:true,\r\n");
      out.write("\t\t\tisResize : true\r\n");
      out.write("\t\t});\r\n");
      out.write("\t}\r\n");
      out.write("\tfunction courseclass(){\r\n");
      out.write("\t  var row = manager.getSelectedRow();\r\n");
      out.write("\t \tif (!row) {\r\n");
      out.write("\t\t\talert('请选择课程！');\r\n");
      out.write("\t\t\treturn;\r\n");
      out.write("\t\t}\r\n");
      out.write("      var str = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/system/Manage_semesterclassselect.action?semChosenCourse.id=\"+row.id;\r\n");
      out.write("\t  m=$.ligerDialog.open({\r\n");
      out.write("\t\t\turl : str,\r\n");
      out.write("\t\t\theight : 500,\r\n");
      out.write("\t\t\twidth : 800,\r\n");
      out.write("\t\t\ttitle:'课程班级选择',\r\n");
      out.write("\t\t\tisDrag:true,\r\n");
      out.write("\t\t\tisResize : true\r\n");
      out.write("\t\t});\r\n");
      out.write("\t}\r\n");
      out.write("\tfunction f_save(){\r\n");
      out.write("\t   var updated = $(\"#maingrid\").ligerGrid('getChanges', \"updated\");\r\n");
      out.write("\t   var effectRow = new Object(); \r\n");
      out.write("\t   if (updated.length) { \r\n");
      out.write("\t     effectRow[\"updated\"] = encodeURI(JSON2.stringify(updated),\"UTF-8\");\t\r\n");
      out.write("\t     //alert(effectRow[\"updated\"]);  \r\n");
      out.write("\t   }\r\n");
      out.write("\t   var ff=encodeURI(encodeURI(effectRow[\"updated\"]));\t  \r\n");
      out.write("\t   /*  $.ajax({\r\n");
      out.write("             url: \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/system/Manage_semestercourseteacheradd.action?ff=\"+ff,\r\n");
      out.write("             type: 'post',\r\n");
      out.write("             contentType:\"application/x-www-form-urlencoded; charset=utf-8\",\r\n");
      out.write("             success: function(html){\r\n");
      out.write("                  //alert(\"更新成功！\");\r\n");
      out.write("                  window.location.reload();\r\n");
      out.write("             }\r\n");
      out.write("});  */\r\n");
      out.write("\t   $.post(\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/system/Manage_semestercourseteacheradd.action\", effectRow,   function(){   \r\n");
      out.write("          alert(\"更新成功！\");\r\n");
      out.write("          window.location.reload();\r\n");
      out.write("         }); \r\n");
      out.write("\t} \r\n");
      out.write("\r\n");
      out.write("</script>\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write("body{\r\n");
      out.write(" font-size: 12px;\r\n");
      out.write("}\r\n");
      out.write(".l-button{\r\n");
      out.write(" width:70px;float:left; margin:15px 160px 5px ;\r\n");
      out.write(" border-radiux:5px;\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("\t</head>\r\n");
      out.write("\t");
 String semester = (String) ActionContext.getContext().get("semestertext"); 
      out.write("\r\n");
      out.write("\t<body style=\"padding: 2px\">\r\n");
      out.write("\t    <div style=\"margin:10px;\" ><font size=\"4\"><strong>注：</strong><br></font>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 请点击设置各个课程的教室类型、任课教师以及上课班级，设置成功后请点击保存按钮！<br><br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <font size=\"4\">学期课程设置学期为：");
      out.write(' ');
      out.print(semester );
      out.write("</font></div>\t\t\r\n");
      out.write("\t\t<div class=\"l-clear\"></div>\r\n");
      out.write("\t\t<div id=\"maingrid\" ></div>\r\n");
      out.write("\t\t <strong><a class=\"l-button\" style=\"width: 80px; margin-top: 20px; margin-left: 40%;\" onclick=\"f_save()\">保&nbsp;存</a></strong>\r\n");
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
