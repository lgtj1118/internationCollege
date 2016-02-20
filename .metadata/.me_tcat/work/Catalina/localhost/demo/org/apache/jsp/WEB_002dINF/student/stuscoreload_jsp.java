package org.apache.jsp.WEB_002dINF.student;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;

public final class stuscoreload_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fs_005fiterator_005fvalue_005fid;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fs_005fiterator_005fvalue_005fid = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fs_005fiterator_005fvalue_005fid.release();
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
      out.write("    <title></title>\t   \r\n");
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
      out.write("    <script src=\"");
      out.print(basePath);
      out.write("js/jquery/jquery-1.6.min.js\" type=\"text/javascript\"></script>\r\n");
      out.write("\t<script src=\"js/ligerUI/core/base.js\" type=\"text/javascript\"></script>\r\n");
      out.write("\t<script src=\"js/ligerUI/ligerui.all.js\" type=\"text/javascript\"></script>\r\n");
      out.write("\t<!-- <script type=\"text/javascript\" src=\"js/semester.js\" charset=\"utf-8\" ></script>  -->\r\n");
      out.write("<script type=\"text/javascript\">  \r\n");
      out.write("\tvar IsmakeupData = [{ ismakeup: 0, text: '否' }, { ismakeup: 1, text: '是'}];  \r\n");
      out.write("\t$(f_initGrid);\r\n");
      out.write("\tvar manager, g;\r\n");
      out.write("\tfunction f_initGrid() {\r\n");
      out.write("\t\tg = manager = $(\"#maingrid\").ligerGrid(\r\n");
      out.write("\t\t\t\t{\r\n");
      out.write("\t\t\t\tcolumns : [{display : '序号',    name : 'id',       width : 60,    hide:true,type : 'int'}, \r\n");
      out.write("\t\t\t\t           {display : '学期',    name : 'semester', minWidth : 160, editor: { type: 'text'}} ,\r\n");
      out.write("\t\t\t\t           {display : '课程名称', name : 'coursename',minWidth : 120,editor: { type: 'text'}}, \r\n");
      out.write("\t\t\t\t           {display : '护照号',    name : 'passport',     width : 120,   editor: { type: 'text'}}, \r\n");
      out.write("\t\t\t\t           {display : '姓名',    name : 'stuname',   width : 120,  editor: { type: 'text'}}, \r\n");
      out.write("\t\t\t\t           {display : '班级',    name : 'classname', width : 120,  editor: { type: 'text'}}, \r\n");
      out.write("\t\t\t\t           {display : '成绩',    width : 80,columns:[{\r\n");
      out.write("\t\t\t\t                       display:'出勤', name:'attendence', editor:{type:'text'}},\r\n");
      out.write("\t\t\t\t                     { display:'作业', name:'homework',   editor:{type:'text'}},\r\n");
      out.write("\t\t\t\t                     { display:'期中', name:'midexam',    editor:{type:'text'}},\r\n");
      out.write("\t\t\t\t                     { display:'期末', name:'finalexam',  editor:{type:'text'} }\r\n");
      out.write("\t\t\t\t                     ,{ display:'综合', name:'summary', editor:{type:'text'}}]}\r\n");
      out.write("\t\t\t\t                      ,\r\n");
      out.write("\t\t\t\t           {display : '是否补考',name : 'ismakeup',width : 60,\r\n");
      out.write("\t\t\t\t                 editor: { type: 'select', data: IsmakeupData, valueField: 'ismakeup' },\r\n");
      out.write("                                    render: function (item){\r\n");
      out.write("                                         if (parseInt(item.ismakeup) == 0){ var h=\"否\" ;return h;}\r\n");
      out.write("                                         else if (parseInt(item.ismakeup) == 1) { var h=\"<span style='color:red;'>是</span>\" ;return h;}\r\n");
      out.write("                                    }\r\n");
      out.write("\t\t\t               }, {display : '补考',name : 'makeup',width : 60,editor: { type: 'text'}} ],\r\n");
      out.write("\t\t\t\t\tonSelectRow : function(rowdata, rowindex) {\r\n");
      out.write("\t\t\t\t\t\t$(\"#txtrowindex\").val(rowindex);\r\n");
      out.write("\t\t\t\t\t},\r\n");
      out.write("\t\t\t\t\tenabledEdit : true,\r\n");
      out.write("\t\t\t\t\tclickToEdit : false,\r\n");
      out.write("\t\t\t\t\tisScroll : false,\r\n");
      out.write("\t\t\t\t\tcheckbox:false,\r\n");
      out.write("\t\t\t        rownumbers:true,\r\n");
      out.write("\t\t\t        pageSize:30,\r\n");
      out.write("\t\t\t        url:'");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/system/Manage_allstuscorelist.action',\r\n");
      out.write("\t\t\t\t\twidth : '100%'\r\n");
      out.write("\t\t\t\t});\r\n");
      out.write("\t}\r\n");
      out.write("   function check(){\r\n");
      out.write("     var studentid = $(\"#stuid\").val();\r\n");
      out.write("     var reg = /^[\\u4e00-\\u9fa5]+$/gi;\r\n");
      out.write("\t if(studentid.length!=0){\r\n");
      out.write("\t   if (reg.test(studentid)) {\r\n");
      out.write("\t\t\t$(\"#result\").html(\"学号不能包含中文！\");\r\n");
      out.write("\t\t\t$(\"#result\").show();\r\n");
      out.write("\t\t\treturn false;\r\n");
      out.write("\t\t} else {\r\n");
      out.write("\t\t\t$(\"#result\").hide();\r\n");
      out.write("\t\t}$.post(\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/system/Manage_stucheck.action?stu.stuid=\"\r\n");
      out.write("\t\t\t\t\t\t+ $(\"#stuid\").val(), null, function(data) {\r\n");
      out.write("\t\t\t\t\tif (data == \"fail\") {\r\n");
      out.write("\t\t\t\t\t\t$(\"#result\").html(\"该学号不存在!\");\r\n");
      out.write("\t\t\t\t\t\t$(\"#result\").show();\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t} else {\r\n");
      out.write("\t\t\t\t\t\t$(\"#result\").hide();\r\n");
      out.write("\t\t\t\t\t\tf_search();\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t});\t\r\n");
      out.write("\t }\t\r\n");
      out.write("\t\t\t\r\n");
      out.write("   }\r\n");
      out.write("   function f_search(){\r\n");
      out.write("      var semester = $(\"#semester option:selected\").val();\r\n");
      out.write("      //alert(semester);\r\n");
      out.write("      //alert(semester);\r\n");
      out.write("      var classid = $(\"#classid\").val();\r\n");
      out.write("      var studentid = $(\"#stuid\").val();\r\n");
      out.write("      var coursenum = $(\"#courseid\").val();\r\n");
      out.write("      if (semester.length==0&&classid.length==0&&(studentid.length==0||studentid==null)&&coursenum==null) {\r\n");
      out.write("\t\t\t$(\"#maingrid\").ligerGrid({\r\n");
      out.write("\t\t\t\t\turl : '");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/system/Manage_allstuscorelist.action'\r\n");
      out.write("\t\t\t   })\r\n");
      out.write("\t  } else {\r\n");
      out.write("\t     var str = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/system/Manage_searchstuscorelist.action?semChosenCourse.semester=\"\r\n");
      out.write("\t     +semester+\"&cls.id=\"+classid+\"&stu.passport=\"+studentid\r\n");
      out.write("\t     + \"&semChosenCourse.coursenum=\"+ $(\"#courseid\").val();\r\n");
      out.write("\t\t  $(\"#maingrid\").ligerGrid({\r\n");
      out.write("\t\t\turl : str\r\n");
      out.write("\t\t })\r\n");
      out.write("\t  }\r\n");
      out.write(" }\r\n");
      out.write(" \r\n");
      out.write(" \r\n");
      out.write(" \tfunction schange(){ \t\t\r\n");
      out.write(" \t\tvar semester = $(\"#semester\").val();\r\n");
      out.write(" \t\tvar url = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/system/Manage_courseNameList.action?semester=\" + semester;\r\n");
      out.write("\t\t$.ajax({  \r\n");
      out.write("\t        type : \"POST\",  \r\n");
      out.write("\t        url : url,\r\n");
      out.write("\t        dataType : \"JSON\", \r\n");
      out.write("\t        error: function (){\r\n");
      out.write("\t        \t;\r\n");
      out.write("\t        },\r\n");
      out.write("\t        success : function(data) {\r\n");
      out.write("\t        \t$(\"#courseid\").empty(); \r\n");
      out.write("\t        \tif (data.length > 0){\r\n");
      out.write("\t        \t  document.getElementById(\"courseid\").options.add(new Option('',''));\r\n");
      out.write("\t        \t\tfor(var n=0;n<data.length;n++){\r\n");
      out.write("\t                \tdocument.getElementById(\"courseid\").options.add(new Option(data[n].courseName,data[n].num));\r\n");
      out.write("\t          \t\t} \r\n");
      out.write("\t          \t//\tgetOldroom(); \r\n");
      out.write("\t        \t} else {\r\n");
      out.write("\t        \t\t\r\n");
      out.write("\t        \t}\r\n");
      out.write("\t        }  \r\n");
      out.write("\t    }); \r\n");
      out.write(" \t}\r\n");
      out.write(" \tfunction f_class(){\r\n");
      out.write(" \t\tvar classid = $(\"#classid\").val();\r\n");
      out.write(" \t\tvar url = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/system/Class_classStuList.action?cls.id=\" + classid;\r\n");
      out.write("\t\t$.ajax({  \r\n");
      out.write("\t        type : \"POST\",  \r\n");
      out.write("\t        url : url,\r\n");
      out.write("\t        dataType : \"JSON\", \r\n");
      out.write("\t        error: function (){\r\n");
      out.write("\t        \t;\r\n");
      out.write("\t        },\r\n");
      out.write("\t        success : function(data) {\r\n");
      out.write("\t        \t$(\"#stuid\").empty(); \r\n");
      out.write("\t        \tif (data.length > 0){\r\n");
      out.write("\t        \tdocument.getElementById(\"stuid\").options.add(new Option('',''));\r\n");
      out.write("\t        \t\tfor(var n=0;n<data.length;n++){\r\n");
      out.write("\t                \tvar name = data[n].stuname+\"(\"+data[n].firstname+\" \"+data[n].lastname+\")\";\r\n");
      out.write("\t                \tdocument.getElementById(\"stuid\").options.add(new Option(name,data[n].passport));\r\n");
      out.write("\t          \t\t} \r\n");
      out.write("\t        \t} else {\r\n");
      out.write("\t        \t}\r\n");
      out.write("\t        }  \r\n");
      out.write("\t    }); \r\n");
      out.write(" \t}\r\n");
      out.write(" \t$(document).ready(function(){\t\t\t\r\n");
      out.write("\tvar nowDate = new Date();\r\n");
      out.write("\tvar nowYear = nowDate.getFullYear();\r\n");
      out.write("\tvar lastYear = parseInt(nowYear)-1;\r\n");
      out.write("\tvar before = parseInt(lastYear)-1;\r\n");
      out.write("\tvar nextYear = parseInt(nowYear)+1;\r\n");
      out.write("\tvar nowuptext = lastYear+\"-\"+nowYear+\"学年第一学期\";//2014-2015\r\n");
      out.write("\tvar nowupvalue = lastYear+\"01\";\r\n");
      out.write("\tvar nowdowntext = lastYear+\"-\"+nowYear + \"学年第二学期\";\r\n");
      out.write("\tvar nowdownvalue = nowYear+\"02\";\r\n");
      out.write("\tvar lastuptext = before+\"-\"+lastYear+\"学年第一学期\";\r\n");
      out.write("\tvar lastupvalue = before+\"01\";\r\n");
      out.write("\tvar lastdowntext = before+\"-\"+lastYear+\"学年第二学期\";\r\n");
      out.write("\tvar lastdownvalue = lastYear+\"02\";\r\n");
      out.write("\tvar nextuptext = nowYear+\"-\"+nextYear+\"学年第一学期\";\r\n");
      out.write("\tvar nextupvalue = nowYear+\"01\";\r\n");
      out.write("\tvar nextdowntext = nowYear+\"-\"+nextYear+\"学年第二学期\";\r\n");
      out.write("\tvar nextdownvalue = nextYear+\"02\";\r\n");
      out.write("\tvar semester = document.getElementById(\"semester\");\r\n");
      out.write("\tvar objOption=document.createElement(\"OPTION\"); \r\n");
      out.write("    var objOption1=document.createElement(\"OPTION\");\r\n");
      out.write("    var objOption2=document.createElement(\"OPTION\"); \r\n");
      out.write("    var objOption3=document.createElement(\"OPTION\"); \r\n");
      out.write("    var objOption4=document.createElement(\"OPTION\"); \r\n");
      out.write("    var objOption5=document.createElement(\"OPTION\"); \r\n");
      out.write("    objOption.value=nowupvalue;   objOption.text=nowuptext;\r\n");
      out.write("    objOption1.value=nowdownvalue;  objOption1.text=nowdowntext;\r\n");
      out.write("    objOption2.value=lastupvalue;  objOption2.text=lastuptext;\r\n");
      out.write("    objOption3.value=lastdownvalue;  objOption3.text=lastdowntext;\r\n");
      out.write("    objOption4.value=nextupvalue;  objOption4.text=nextuptext;\r\n");
      out.write("    objOption5.value=nextdownvalue;  objOption5.text=nextdowntext;\r\n");
      out.write("    var month = nowDate.getMonth();\r\n");
      out.write("\tvar now;\r\n");
      out.write("\tif (month > 9) {\r\n");
      out.write("\t\tnow = nowYear + \"01\";\r\n");
      out.write("\t} else {\r\n");
      out.write("\t\tnow = nowYear + \"02\";\r\n");
      out.write("\t}\r\n");
      out.write("\tif(now==nowupvalue){\r\n");
      out.write("\t\tsemester.add(objOption2);\r\n");
      out.write("        semester.add(objOption3);\r\n");
      out.write("        semester.add(objOption);\r\n");
      out.write("        semester.options[semester.options.length-1].selected='selected';\r\n");
      out.write("        semester.add(objOption1);                \r\n");
      out.write("        semester.add(objOption4);\r\n");
      out.write("        semester.add(objOption5);        \t\t\r\n");
      out.write("\t}else if(now==nowdownvalue) {\r\n");
      out.write("\t\tsemester.add(objOption2);\r\n");
      out.write("        semester.add(objOption3);\r\n");
      out.write("        semester.add(objOption);        \r\n");
      out.write("        semester.add(objOption1); \r\n");
      out.write("        semester.options[semester.options.length-1].selected='selected';\r\n");
      out.write("        semester.add(objOption4);\r\n");
      out.write("        semester.add(objOption5);\r\n");
      out.write("\t}\r\n");
      out.write("        \r\n");
      out.write("    \r\n");
      out.write("})  \r\n");
      out.write("</script>\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write("#head{\r\n");
      out.write(" width: 99%;\r\n");
      out.write(" height:100px;\r\n");
      out.write(" margin:auto;\r\n");
      out.write(" border:4px solid #c6c6c6 ;\r\n");
      out.write("}\r\n");
      out.write(".title{\r\n");
      out.write(" float: left;\r\n");
      out.write(" height: 100%;\r\n");
      out.write(" width: 10%;\r\n");
      out.write(" text-aligncenter;\r\n");
      out.write(" border-right:2px solid #c6c6c6 ;\r\n");
      out.write("}\r\n");
      out.write(".search{\r\n");
      out.write("  float: left;\r\n");
      out.write("}\r\n");
      out.write(".l-table-edit{\r\n");
      out.write(" height:90px;\r\n");
      out.write(" align:center;\r\n");
      out.write(" width: 100%;\r\n");
      out.write("}\r\n");
      out.write(".search.l-table-edit td{\r\n");
      out.write("  border-bottom: 1px solid #c6c6c6 ;\r\n");
      out.write("}\r\n");
      out.write(".link{\r\n");
      out.write("width:180px;height:25px;background: #fefefe;border: 1px solid #bbb;font-size: 14px;color: #333;border-radius: 3px;\r\n");
      out.write("}\r\n");
      out.write(".l-button{\r\n");
      out.write(" width:70px;float:left; margin:0px 160px 5px ;\r\n");
      out.write(" border-radiux:5px;\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("\t</head>\r\n");
      out.write("\t<body style=\"padding: 2px\">\t\r\n");
      out.write("      <div id=\"head\">\r\n");
      out.write("\t      <div class=\"title\" ><br><br><div align=\"center\"><font face=\"微软雅黑\" color=\"#400000\" size=\"4\"><strong>条件选择</strong></font></div></div>\r\n");
      out.write("\t      <div class=\"search\" >\r\n");
      out.write("\t         <table  cellpadding=\"0\" cellspacing=\"0\" class=\"l-table-edit\"  >\t\t\t \r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t   <td align=\"right\" class=\"l-table-edit-td\">&nbsp;&nbsp;&nbsp;开课学期:&nbsp;</td>\r\n");
      out.write("\t\t\t\t<td align=\"left\" class=\"l-table-edit-td\">\r\n");
      out.write("\t\t\t\t   <select id=\"semester\" name=\"semester\" class=\"link\" <!-- onchange=\"schange()\" -->   >\r\n");
      out.write("\t\t\t\t      <option value=\"\" ></option>\t\t\t\t     \r\n");
      out.write("\t\t\t\t   </select>\r\n");
      out.write("\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t<td align=\"right\" class=\"l-table-edit-td\" width=\"100px\" >&nbsp;&nbsp;课程:&nbsp;</td>\r\n");
      out.write("\t\t\t\t<td align=\"left\" class=\"l-table-edit-td\">\r\n");
      out.write("\t\t\t\t  <select id=\"courseid\" name=\"courseid\" class=\"link\" onchange=\"f_search()\"  >\r\n");
      out.write("\t\t\t\t    <option value=\"\" ></option>\r\n");
      out.write("\t\t\t\t    ");
      if (_jspx_meth_s_005fiterator_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t\t\t  </select>\r\n");
      out.write("\t\t\t\t</td>\t\t\t\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t <tr>\t\t\t\t\r\n");
      out.write("\t\t\t    <!-- <td align=\"right\" class=\"l-table-edit-td\" width=\"100px\" >&nbsp;&nbsp;专业:&nbsp;</td>\r\n");
      out.write("\t\t\t\t<td align=\"left\" class=\"l-table-edit-td\">\r\n");
      out.write("\t\t\t\t  <input id=\"major\" class=\"link\" name=\"major\" value=\"汉语言\" disabled=\"disabled\" />\r\n");
      out.write("\t\t\t\t</td> -->\r\n");
      out.write("\t\t\t\t<td align=\"right\" class=\"l-table-edit-td\" width=\"100px\" >&nbsp;&nbsp;班级:&nbsp;</td>\r\n");
      out.write("\t\t\t\t<td align=\"left\" class=\"l-table-edit-td\">\r\n");
      out.write("\t\t\t\t  <select id=\"classid\" name=\"classid\" class=\"link\" onchange=\"f_class();f_search()\" >\r\n");
      out.write("\t\t\t\t     <option value=\"\" ></option>\r\n");
      out.write("\t\t\t\t     ");
      if (_jspx_meth_s_005fiterator_005f1(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t\t\t  </select>\r\n");
      out.write("\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t<td align=\"right\" class=\"l-table-edit-td\">&nbsp;&nbsp;学生姓名:&nbsp;</td>\r\n");
      out.write("\t\t\t\t<td align=\"left\" class=\"l-table-edit-td\">\r\n");
      out.write("\t\t\t\t <!--  <input id=\"stuid\" class=\"link\" name=\"stuid\" value=\"\"  onblur=\"check()\" /> -->\r\n");
      out.write("\t\t\t\t  <select id=\"stuid\" name=\"stuid\" class=\"link\" onchange=\"f_search()\" ></select>\r\n");
      out.write("\t\t\t\t</td>\t\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t   <td></td><td></td><td></td>\r\n");
      out.write("\t\t\t   <td  ><div id=\"result\" style=\"color:red; font-size: 10px;\"></div></td>\r\n");
      out.write("\t\t\t</tr>\t\t\t\t\t\t\r\n");
      out.write("\t\t</table>\r\n");
      out.write("\t\t<a class=\"l-button\" onclick=\"f_search()\"><strong>查&nbsp;&nbsp;询</strong></a>\r\n");
      out.write("\t      </div>\r\n");
      out.write("\t    </div>\t\t\r\n");
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

  private boolean _jspx_meth_s_005fiterator_005f0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  s:iterator
    org.apache.struts2.views.jsp.IteratorTag _jspx_th_s_005fiterator_005f0 = (org.apache.struts2.views.jsp.IteratorTag) _005fjspx_005ftagPool_005fs_005fiterator_005fvalue_005fid.get(org.apache.struts2.views.jsp.IteratorTag.class);
    _jspx_th_s_005fiterator_005f0.setPageContext(_jspx_page_context);
    _jspx_th_s_005fiterator_005f0.setParent(null);
    // /WEB-INF/student/stuscoreload.jsp(266,8) name = value type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_s_005fiterator_005f0.setValue("#courselist");
    // /WEB-INF/student/stuscoreload.jsp(266,8) name = id type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_s_005fiterator_005f0.setId("gg");
    int _jspx_eval_s_005fiterator_005f0 = _jspx_th_s_005fiterator_005f0.doStartTag();
    if (_jspx_eval_s_005fiterator_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      if (_jspx_eval_s_005fiterator_005f0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.pushBody();
        _jspx_th_s_005fiterator_005f0.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
        _jspx_th_s_005fiterator_005f0.doInitBody();
      }
      do {
        out.write("\r\n");
        out.write("\t\t\t\t      <option value=\"");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${gg.num}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
        out.write('"');
        out.write(' ');
        out.write('>');
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${gg.coursename }", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
        out.write("</option>\r\n");
        out.write("\t\t\t\t    ");
        int evalDoAfterBody = _jspx_th_s_005fiterator_005f0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
      if (_jspx_eval_s_005fiterator_005f0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.popBody();
      }
    }
    if (_jspx_th_s_005fiterator_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fs_005fiterator_005fvalue_005fid.reuse(_jspx_th_s_005fiterator_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fs_005fiterator_005fvalue_005fid.reuse(_jspx_th_s_005fiterator_005f0);
    return false;
  }

  private boolean _jspx_meth_s_005fiterator_005f1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  s:iterator
    org.apache.struts2.views.jsp.IteratorTag _jspx_th_s_005fiterator_005f1 = (org.apache.struts2.views.jsp.IteratorTag) _005fjspx_005ftagPool_005fs_005fiterator_005fvalue_005fid.get(org.apache.struts2.views.jsp.IteratorTag.class);
    _jspx_th_s_005fiterator_005f1.setPageContext(_jspx_page_context);
    _jspx_th_s_005fiterator_005f1.setParent(null);
    // /WEB-INF/student/stuscoreload.jsp(281,9) name = id type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_s_005fiterator_005f1.setId("c");
    // /WEB-INF/student/stuscoreload.jsp(281,9) name = value type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_s_005fiterator_005f1.setValue("#classlist");
    int _jspx_eval_s_005fiterator_005f1 = _jspx_th_s_005fiterator_005f1.doStartTag();
    if (_jspx_eval_s_005fiterator_005f1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      if (_jspx_eval_s_005fiterator_005f1 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.pushBody();
        _jspx_th_s_005fiterator_005f1.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
        _jspx_th_s_005fiterator_005f1.doInitBody();
      }
      do {
        out.write("\r\n");
        out.write("\t\t\t\t       <option value=\"");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${c.id }", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
        out.write('"');
        out.write(' ');
        out.write('>');
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${c.classname }", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
        out.write("</option>\r\n");
        out.write("\t\t\t\t     ");
        int evalDoAfterBody = _jspx_th_s_005fiterator_005f1.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
      if (_jspx_eval_s_005fiterator_005f1 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.popBody();
      }
    }
    if (_jspx_th_s_005fiterator_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fs_005fiterator_005fvalue_005fid.reuse(_jspx_th_s_005fiterator_005f1);
      return true;
    }
    _005fjspx_005ftagPool_005fs_005fiterator_005fvalue_005fid.reuse(_jspx_th_s_005fiterator_005f1);
    return false;
  }
}
