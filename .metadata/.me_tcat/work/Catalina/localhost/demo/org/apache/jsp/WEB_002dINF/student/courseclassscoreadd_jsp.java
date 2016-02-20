package org.apache.jsp.WEB_002dINF.student;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import org.springframework.web.context.request.SessionScope;
import java.util.*;

public final class courseclassscoreadd_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fs_005fif_005ftest;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fs_005felseif_005ftest;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fs_005fif_005ftest = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fs_005felseif_005ftest = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fs_005fif_005ftest.release();
    _005fjspx_005ftagPool_005fs_005felseif_005ftest.release();
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
      out.write("    <script type=\"text/javascript\" src=\"js/jquery-validation/jquery.validate.min.js\" charset=\"utf-8\"></script>\r\n");
      out.write("    <script type=\"text/javascript\" src=\"js/json2.js\" charset=\"utf-8\"></script>\r\n");
      out.write("    <script type=\"text/javascript\" src=\"js/jquery-validation/jquery.metadata.js\" charset=\"utf-8\"></script>\r\n");
      out.write("    <script type=\"text/javascript\" src=\"js/jquery-validation/messages_cn.js\" charset=\"utf-8\"></script>\r\n");
      out.write("    <script src=\"js/jquery/jquery-1.3.2.min.js\"type=\"text/javascript\"></script>\r\n");
      out.write("\t<script src=\"js/ligerUI/core/base.js\" type=\"text/javascript\"></script>\r\n");
      out.write("\t<script src=\"js/ligerUI/ligerui.all.js\" type=\"text/javascript\"></script>\r\n");
      out.write("<script type=\"text/javascript\">  \r\n");
      out.write("var IsmakeupData = [{ ismakeup: 0, text: '否' }, { ismakeup: 1, text: '是'}];\r\n");
      out.write("\t$(f_initGrid);\r\n");
      out.write("\tvar manager, g;\r\n");
      out.write("\tfunction f_initGrid() {\r\n");
      out.write("\t\tg = manager = $(\"#maingrid\").ligerGrid(\r\n");
      out.write("\t\t\t\t{\r\n");
      out.write("\t\t\t\tcolumns : [{\r\n");
      out.write("\t\t\t\tdisplay : '序号',\r\n");
      out.write("\t\t\t\tname : 'id',\r\n");
      out.write("\t\t\t\twidth : 60,\r\n");
      out.write("\t\t\t\thide:true\r\n");
      out.write("\t\t\t\t/* type : 'int' */\r\n");
      out.write("\t\t\t}, {\r\n");
      out.write("\t\t\t\tdisplay : '学期',\r\n");
      out.write("\t\t\t\tname : 'semester',\r\n");
      out.write("\t\t\t\tminWidth : 160,\r\n");
      out.write("\t\t\t\trender: function (item)\r\n");
      out.write("                    {\r\n");
      out.write("                       if (item.semester.substring(5,6)==1){ var h=item.semester.substring(0,4)+\"-\"+parseInt(item.semester.substring(0,4)+1)+\"学年第一学期\";return h;}\r\n");
      out.write("                       else{ var h=parseInt(item.semester.substring(0,4)-1)+\"-\"+parseInt(item.semester.substring(0,4))+\"学年第二学期\";return h;}\r\n");
      out.write("                        \r\n");
      out.write("                    }\r\n");
      out.write("\t\t\t\t/* editor: { type: 'text'} */\r\n");
      out.write("\t\t\t} , {\r\n");
      out.write("\t\t\t\tdisplay : '课程名称',\r\n");
      out.write("\t\t\t\tname : 'coursename',\r\n");
      out.write("\t\t\t\tminWidth : 120\r\n");
      out.write("\t\t\t\t/* editor: { type: 'text'} */\r\n");
      out.write("\t\t\t}, {\r\n");
      out.write("\t\t\t\tdisplay : '护照号',\r\n");
      out.write("\t\t\t\tname : 'passport',\r\n");
      out.write("\t\t\t\twidth : 120\r\n");
      out.write("\t\t\t\t/* editor: { type: 'text'} */\r\n");
      out.write("\t\t\t}, {\r\n");
      out.write("\t\t\t\tdisplay : '姓名',\r\n");
      out.write("\t\t\t\tname : 'stuname',\r\n");
      out.write("\t\t\t\twidth : 120\r\n");
      out.write("\t\t\t\t/* editor: { type: 'text'} */\r\n");
      out.write("\t\t\t}, {\r\n");
      out.write("\t\t\t\tdisplay : '成绩',\r\n");
      out.write("\t\t\t\tminWidth : 120,\r\n");
      out.write("\t\t\t\tcolumns:[{\r\n");
      out.write("\t\t\t\t   display:'出勤',\r\n");
      out.write("\t\t\t\t   name:'attendence',\r\n");
      out.write("\t\t\t\t   editor:{type:'float'},\t\t\t\t     \r\n");
      out.write("\t\t\t\t   render: function (item)\r\n");
      out.write("                    {\r\n");
      out.write("                        if (parseInt(item.attendence) < 60){ var h=\"<font color='red' >\"+item.attendence+\"</font>\" ;return h;}\r\n");
      out.write("                        else{ var h=item.attendence;return h;}\r\n");
      out.write("                        \r\n");
      out.write("                    }\r\n");
      out.write("\t\t\t\t},{\r\n");
      out.write("\t\t\t\t   display:'作业',\r\n");
      out.write("\t\t\t\t   name:'homework',\r\n");
      out.write("\t\t\t\t   editor:{type:'float'},\r\n");
      out.write("\t\t\t\t   render: function (item)\r\n");
      out.write("                    {\r\n");
      out.write("                        if (parseInt(item.homework) < 60){ var h=\"<font color='red' >\"+item.homework+\"</font>\" ;return h;}\r\n");
      out.write("                        else{ var h=item.homework ;return h;}\r\n");
      out.write("                        \r\n");
      out.write("                    }\r\n");
      out.write("\t\t\t\t},{\r\n");
      out.write("\t\t\t\t   display:'期中',\r\n");
      out.write("\t\t\t\t   name:'midexam',\r\n");
      out.write("\t\t\t\t   editor:{type:'float'},\r\n");
      out.write("\t\t\t\t   render: function (item)\r\n");
      out.write("                    {\r\n");
      out.write("                        if (parseInt(item.midexam) < 60){ var h=\"<font color='red' >\"+item.midexam+\"</font>\" ;return h;}\r\n");
      out.write("                        else{ var h=item.midexam ;return h;}\r\n");
      out.write("                        \r\n");
      out.write("                    }\r\n");
      out.write("\t\t\t\t   \r\n");
      out.write("\t\t\t\t},{\r\n");
      out.write("\t\t\t\t   display:'期末',\r\n");
      out.write("\t\t\t\t   name:'finalexam',\r\n");
      out.write("\t\t\t\t   editor:{type:'float'},\r\n");
      out.write("\t\t\t\t    render: function (item)\r\n");
      out.write("                    {\r\n");
      out.write("                        if (parseInt(item.finalexam) < 60){ var h=\"<font color='red' >\"+item.finalexam+\"</font>\" ;return h;}\r\n");
      out.write("                        else{ var h=item.finalexam;return h;}\r\n");
      out.write("                        \r\n");
      out.write("                    }\r\n");
      out.write("\t\t\t\t},{\r\n");
      out.write("\t\t\t\t   display:'综合',\r\n");
      out.write("\t\t\t\t   name:'summary',\r\n");
      out.write("\t\t\t\t   //editor:{type:'float'},\r\n");
      out.write("\t\t\t\t   render: function (item)\r\n");
      out.write("                    {\r\n");
      out.write("                        if (parseInt(item.summary) < 60){ var h=\"<font color='red' >\"+item.summary+\"</font>\" ;return h;}\r\n");
      out.write("                        else{ var h=item.summary;return h;}\r\n");
      out.write("                        \r\n");
      out.write("                    }\r\n");
      out.write("\t\t\t    }]}, {\r\n");
      out.write("\t\t\t\tdisplay : '是否补考',\r\n");
      out.write("\t\t\t\tname : 'ismakeup',\r\n");
      out.write("\t\t\t\twidth : 60,\r\n");
      out.write("\t\t\t\t/* editor: { type: 'select', data: IsmakeupData, valueField: 'ismakeup' }, */\r\n");
      out.write("                    render: function (item)\r\n");
      out.write("                    {\r\n");
      out.write("                        if (parseInt(item.ismakeup) == 0){ var h=\"否\" ;return h;}\r\n");
      out.write("                        else if (parseInt(item.ismakeup) == 1) { var h=\"<span style='color:red;'>是</span>\" ;return h;}\r\n");
      out.write("                        \r\n");
      out.write("                    }\r\n");
      out.write("\t\t\t}, {\r\n");
      out.write("\t\t\t\tdisplay : '补考',\r\n");
      out.write("\t\t\t\tname : 'makeup',\r\n");
      out.write("\t\t\t\twidth : 60\r\n");
      out.write("\t\t\t\t/* editor: { type: 'text'} */\r\n");
      out.write("\t\t\t} ],\r\n");
      out.write("\t\t\t\t\tonSelectRow : function(rowdata, rowindex) {\r\n");
      out.write("\t\t\t\t\t\t$(\"#txtrowindex\").val(rowindex);\r\n");
      out.write("\t\t\t\t\t},\r\n");
      out.write("\t\t\t\t\tenabledEdit : true,\r\n");
      out.write("\t\t\t\t\tclickToEdit : true,\r\n");
      out.write("\t\t\t\t\tisScroll : false,\r\n");
      out.write("\t\t\t\t\tcheckbox:false,\r\n");
      out.write("\t\t\t        rownumbers:true,\r\n");
      out.write("\t\t\t        pageSize:30,\r\n");
      out.write("\t\t\t        url:'");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/system/Manage_stuscorelist.action',\r\n");
      out.write("\t\t\t\t\twidth : '100%'\t\t\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t});\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("   function f_scoreadd(){\r\n");
      out.write("     var row = manager.getSelectedRow();\r\n");
      out.write("     if(!row){\r\n");
      out.write("       alert(\"请选择一个条目！\");\r\n");
      out.write("       return ;\r\n");
      out.write("     }    \r\n");
      out.write("     if(row.ismakeup==1){\r\n");
      out.write("        alert(\"该学生已补考，不能再录入成绩！\");\r\n");
      out.write("     }else{\r\n");
      out.write("        var str = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/system/Manage_courseclassscorebegainadd.action?cls.id=\"+$(\"#classid\").val()+\"&semChosenCourse.semester=\"+$(\"#semester\").val()+\"&course.num=\"+$(\"#coursenum\").val()+\"&stu.passport=\"+row.passport;\r\n");
      out.write("        m=$.ligerDialog.open({\r\n");
      out.write("\t\t\turl : str,\r\n");
      out.write("\t\t\theight : 350,\r\n");
      out.write("\t\t\twidth : 380,\r\n");
      out.write("\t\t\tisDrag:true,\r\n");
      out.write("\t\t\tshowMax:true,\r\n");
      out.write("\t\t\tshowToggle:true,\r\n");
      out.write("\t\t\tslide: false,\t\t\t \r\n");
      out.write("\t\t\tmodal:false,\r\n");
      out.write("\t\t\tleft:200,\r\n");
      out.write("\t\t\ttitle:'添加成绩',\r\n");
      out.write("\t\t\tallowClose:true,\r\n");
      out.write("\t\t    isResize : false\r\n");
      out.write("\t\t});\r\n");
      out.write("     }\r\n");
      out.write("     \r\n");
      out.write("   }\r\n");
      out.write("   function f_makeupscoreadd(){\r\n");
      out.write("     var row = manager.getSelectedRow();\r\n");
      out.write("     if(!row){ alert(\"请选择一个条目！\"); return ; }\r\n");
      out.write("     if(row.ismakeup==1){\r\n");
      out.write("        alert(\"该学生已补考，不能再录入成绩！\");\r\n");
      out.write("     }else{\r\n");
      out.write("         if(row.summary>=60){\r\n");
      out.write("           alert(\"该学生总评成绩已达60分，无需补考！\");\r\n");
      out.write("          }else{\r\n");
      out.write("              var str = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/system/Manage_courseclassmakeupscorebegainadd.action?cls.id=\"+$(\"#classid\").val()+\"&semChosenCourse.semester=\"+$(\"#semester\").val()+\"&course.num=\"+$(\"#coursenum\").val()+\"&stu.stuid=\"+row.stuid;\r\n");
      out.write("                 m=$.ligerDialog.open({\r\n");
      out.write("\t\t\t           url : str,\r\n");
      out.write("\t\t\t           height : 350,\r\n");
      out.write("\t\t\t           width : 380,\r\n");
      out.write("\t\t\t           isDrag:true,\r\n");
      out.write("\t\t\t           showMax:true,\r\n");
      out.write("\t\t\t          showToggle:true,\r\n");
      out.write("\t\t\t          slide: false,\t\t\t \r\n");
      out.write("\t\t\t           modal:false,\r\n");
      out.write("\t\t\t           left:200,\r\n");
      out.write("\t\t\t           title:'添加补考成绩',\r\n");
      out.write("\t\t\t           allowClose:true,\r\n");
      out.write("\t\t               isResize : false\r\n");
      out.write("\t\t         });\r\n");
      out.write("           }\r\n");
      out.write("      }\r\n");
      out.write("}\r\n");
      out.write("   var m;\r\n");
      out.write("   function f_set(){\r\n");
      out.write("      var str = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/system/Manage_setsummary.action?semester=\"+$(\"#semester\").val()+\"&coursenum=\"+$(\"#coursenum\").val()+\"&classid=\"+$(\"#classid\").val(); \r\n");
      out.write("      m=$.ligerDialog.open({\r\n");
      out.write("\t\t\turl : str,\r\n");
      out.write("\t\t\theight : 350,\r\n");
      out.write("\t\t\twidth : 400,\r\n");
      out.write("\t\t\tisDrag:true,\r\n");
      out.write("\t\t\tshowMax:true,\r\n");
      out.write("\t\t\tshowToggle:true,\r\n");
      out.write("\t\t\tslide: false,\t\t\t\r\n");
      out.write("\t\t\tmodal:false,\r\n");
      out.write("\t\t\tleft:200,\r\n");
      out.write("\t\t\ttitle:'总评计算设置',\r\n");
      out.write("\t\t\tallowClose:true,\r\n");
      out.write("\t\t    isResize : false\r\n");
      out.write("\t\t});\t\t\r\n");
      out.write("   }\r\n");
      out.write(" function f_save(){\r\n");
      out.write("\t   var updated = $(\"#maingrid\").ligerGrid('getChanges', \"updated\");\r\n");
      out.write("\t   var effectRow = new Object(); \r\n");
      out.write("\t   var test = new Array();\t   \r\n");
      out.write("\t   if (updated.length) { \r\n");
      out.write("\t     effectRow[\"updated\"] = encodeURI(JSON2.stringify(updated),\"UTF-8\");\r\n");
      out.write("\t     test = JSON2.stringify(updated);\r\n");
      out.write("\t    // alert(effectRow[\"updated\"]); \t    \r\n");
      out.write("\t   }\r\n");
      out.write("\t   var flg = true;\r\n");
      out.write("\t   var tt = eval(test);\t\r\n");
      out.write("\t   var t= /^100|(^([1-9]{0,1})([0-9]{1})(\\.[0-9])?)$/;\r\n");
      out.write("       for(var i=0;i<tt.length;i++){\r\n");
      out.write("        if(t.test(tt[i].attendence)&&t.test(tt[i].homework)&&t.test(tt[i].midexam)&&t.test(tt[i].finalexam)){\r\n");
      out.write("          continue;\r\n");
      out.write("        }else{\r\n");
      out.write("          $.ligerDialog.warn(\"护照号：\"+tt[i].passport+\" 姓名：\"+tt[i].stuname+\" 的成绩输入格式不正确，请修改后保存！\");\t\r\n");
      out.write("          flg = false;\r\n");
      out.write("        }                   \r\n");
      out.write("       }   \t   \r\n");
      out.write("\t   var ff=encodeURI(encodeURI(effectRow[\"updated\"]));\r\n");
      out.write("\t   if(flg){\r\n");
      out.write("\t   \r\n");
      out.write("\t   //$.ligerDialog.confirm('保存成绩前，请先确认已设置总评计算比例，如未设置将无法产生总评成绩？', function (yes){\r\n");
      out.write("\t   $.ligerDialog.confirm('保存成绩前，请先确认录入的各项成绩？', function (yes){\r\n");
      out.write("       if(yes){\t\r\n");
      out.write("\t     $.post(\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/system/Manage_semestercoursescoreadd.action\",effectRow, function(){   \r\n");
      out.write("          alert(\"更新成功！\");\r\n");
      out.write("          window.location.reload();\r\n");
      out.write("          //g.loadData();\r\n");
      out.write("         }); \r\n");
      out.write("         }\r\n");
      out.write("         }); \r\n");
      out.write("\t   }\t\t         \t\r\n");
      out.write("} \r\n");
      out.write("</script>\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write(".l-button{\r\n");
      out.write(" width:80px;float:left; margin:10px 30px 5px ;\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("\t</head>\r\n");
      out.write("\t<body style=\"padding: 2px\">\t\r\n");
      out.write("\t    <br>\r\n");
      out.write("\t    <input id=\"semester\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${semester }", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\" type=\"hidden\" />\r\n");
      out.write("        <input id=\"coursenum\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${coursenum }", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\" type=\"hidden\"/>\r\n");
      out.write("        <input id=\"classid\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${classid }", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\" type=\"hidden\"/>\r\n");
      out.write("        ");
      if (_jspx_meth_s_005fif_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("        ");
      if (_jspx_meth_s_005felseif_005f0(_jspx_page_context))
        return;
      out.write("        \t\t\t\r\n");
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

  private boolean _jspx_meth_s_005fif_005f0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  s:if
    org.apache.struts2.views.jsp.IfTag _jspx_th_s_005fif_005f0 = (org.apache.struts2.views.jsp.IfTag) _005fjspx_005ftagPool_005fs_005fif_005ftest.get(org.apache.struts2.views.jsp.IfTag.class);
    _jspx_th_s_005fif_005f0.setPageContext(_jspx_page_context);
    _jspx_th_s_005fif_005f0.setParent(null);
    // /WEB-INF/student/courseclassscoreadd.jsp(266,8) name = test type = java.lang.String reqTime = false required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_s_005fif_005f0.setTest("#flag==0");
    int _jspx_eval_s_005fif_005f0 = _jspx_th_s_005fif_005f0.doStartTag();
    if (_jspx_eval_s_005fif_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      if (_jspx_eval_s_005fif_005f0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.pushBody();
        _jspx_th_s_005fif_005f0.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
        _jspx_th_s_005fif_005f0.doInitBody();
      }
      do {
        out.write("\r\n");
        out.write("           <!-- <div>注：<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 1.录入成绩前，请先设置总评计算比例 &nbsp;&nbsp;&nbsp;&nbsp; <br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 2.点击学生录入成绩</div> -->\r\n");
        out.write("           <div>注：<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 1.总评计算比例默认设置为：考勤比例=10%，作业比例=20%，期中比例=30%，期末比例=40%。 &nbsp;&nbsp;&nbsp;&nbsp; <br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 2.点击学生各项，录入成绩</div>\r\n");
        out.write("           <!-- <a class=\"l-button\" onclick=\"f_set()\"><strong>总评计算设置</strong></a> -->\r\n");
        out.write("           <a class=\"l-button\" onclick=\"f_scoreadd()\"><strong>录&nbsp;&nbsp;入</strong></a>  \r\n");
        out.write("           <a class=\"l-button\"onclick=\"f_save()\">保&nbsp;存</a>\t\t   \t      \r\n");
        out.write("        ");
        int evalDoAfterBody = _jspx_th_s_005fif_005f0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
      if (_jspx_eval_s_005fif_005f0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.popBody();
      }
    }
    if (_jspx_th_s_005fif_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fs_005fif_005ftest.reuse(_jspx_th_s_005fif_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fs_005fif_005ftest.reuse(_jspx_th_s_005fif_005f0);
    return false;
  }

  private boolean _jspx_meth_s_005felseif_005f0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  s:elseif
    org.apache.struts2.views.jsp.ElseIfTag _jspx_th_s_005felseif_005f0 = (org.apache.struts2.views.jsp.ElseIfTag) _005fjspx_005ftagPool_005fs_005felseif_005ftest.get(org.apache.struts2.views.jsp.ElseIfTag.class);
    _jspx_th_s_005felseif_005f0.setPageContext(_jspx_page_context);
    _jspx_th_s_005felseif_005f0.setParent(null);
    // /WEB-INF/student/courseclassscoreadd.jsp(273,8) name = test type = java.lang.String reqTime = false required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_s_005felseif_005f0.setTest("#flag==1");
    int _jspx_eval_s_005felseif_005f0 = _jspx_th_s_005felseif_005f0.doStartTag();
    if (_jspx_eval_s_005felseif_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      if (_jspx_eval_s_005felseif_005f0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.pushBody();
        _jspx_th_s_005felseif_005f0.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
        _jspx_th_s_005felseif_005f0.doInitBody();
      }
      do {
        out.write("\r\n");
        out.write("           <div>注：<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 请点击学生录入补考成绩</div>\r\n");
        out.write("\t\t   <a class=\"l-button\" onclick=\"f_makeupscoreadd()\"><strong>补考成绩录入</strong></a> \r\n");
        out.write("        ");
        int evalDoAfterBody = _jspx_th_s_005felseif_005f0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
      if (_jspx_eval_s_005felseif_005f0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.popBody();
      }
    }
    if (_jspx_th_s_005felseif_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fs_005felseif_005ftest.reuse(_jspx_th_s_005felseif_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fs_005felseif_005ftest.reuse(_jspx_th_s_005felseif_005f0);
    return false;
  }
}
