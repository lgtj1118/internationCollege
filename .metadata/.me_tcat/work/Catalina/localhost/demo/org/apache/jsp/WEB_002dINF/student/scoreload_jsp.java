package org.apache.jsp.WEB_002dINF.student;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import org.springframework.web.context.request.SessionScope;
import java.util.*;

public final class scoreload_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("    <script src=\"js/jquery/jquery-1.6.min.js\"type=\"text/javascript\"></script>\r\n");
      out.write("\t<script src=\"js/ligerUI/core/base.js\" type=\"text/javascript\"></script>\r\n");
      out.write("\t<script src=\"js/ligerUI/ligerui.all.js\" type=\"text/javascript\"></script>\r\n");
      out.write("\t<script type=\"text/javascript\" src=\"js/semester.js\" ></script>\r\n");
      out.write("<script type=\"text/javascript\">  \r\n");
      out.write("\tvar IsmakeupData = [{ ismakeup: 0, text: '否' }, { ismakeup: 1, text: '是'}];  \r\n");
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
      out.write("\t\t\t\tdisplay : '学期(Term)',\r\n");
      out.write("\t\t\t\tname : 'semester',\r\n");
      out.write("\t\t\t\tminWidth : 40,\r\n");
      out.write("\t\t\t\teditor: { type: 'text'}\r\n");
      out.write("\t\t\t} , {\r\n");
      out.write("\t\t\t\tdisplay : '课程名称(CourseName)',\r\n");
      out.write("\t\t\t\tname : 'coursename',\r\n");
      out.write("\t\t\t\tminWidth : 120,\r\n");
      out.write("\t\t\t\teditor: { type: 'text'}\r\n");
      out.write("\t\t\t}, {\r\n");
      out.write("\t\t\t\tdisplay : '护照号(Passport)',\r\n");
      out.write("\t\t\t\tname : 'passport',\r\n");
      out.write("\t\t\t\twidth : 120,\r\n");
      out.write("\t\t\t\teditor: { type: 'text'}\r\n");
      out.write("\t\t\t}, {\r\n");
      out.write("\t\t\t\tdisplay : '姓名(Chinename)',\r\n");
      out.write("\t\t\t\tname : 'stuname',\r\n");
      out.write("\t\t\t\twidth : 120,\r\n");
      out.write("\t\t\t\teditor: { type: 'text'}\r\n");
      out.write("\t\t\t}, {\r\n");
      out.write("\t\t\t\tdisplay : '成绩(score)',\r\n");
      out.write("\t\t\t\tminWidth : 120,\r\n");
      out.write("\t\t\t\tcolumns:[{\r\n");
      out.write("\t\t\t\t   display:'出勤',\r\n");
      out.write("\t\t\t\t   name:'attendence',\r\n");
      out.write("\t\t\t\t   editor:{type:'text'}\r\n");
      out.write("\t\t\t\t},{\r\n");
      out.write("\t\t\t\t   display:'作业',\r\n");
      out.write("\t\t\t\t   name:'homework',\r\n");
      out.write("\t\t\t\t   editor:{type:'text'}\r\n");
      out.write("\t\t\t\t},{\r\n");
      out.write("\t\t\t\t   display:'期中',\r\n");
      out.write("\t\t\t\t   name:'midexam',\r\n");
      out.write("\t\t\t\t   editor:{type:'text'}\r\n");
      out.write("\t\t\t\t},{\r\n");
      out.write("\t\t\t\t   display:'期末',\r\n");
      out.write("\t\t\t\t   name:'finalexam',\r\n");
      out.write("\t\t\t\t   editor:{type:'text'}\r\n");
      out.write("\t\t\t\t},{\r\n");
      out.write("\t\t\t\t   display:'综合',\r\n");
      out.write("\t\t\t\t   name:'summary',\r\n");
      out.write("\t\t\t\t   editor:{type:'text'}\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t    } ]}, {\r\n");
      out.write("\t\t\t\tdisplay : '是否补考(Is make-up)',\r\n");
      out.write("\t\t\t\tname : 'ismakeup',\r\n");
      out.write("\t\t\t\twidth : 60,\r\n");
      out.write("\t\t\t\teditor: { type: 'select', data: IsmakeupData, valueField: 'ismakeup' },\r\n");
      out.write("                    render: function (item)\r\n");
      out.write("                    {\r\n");
      out.write("                        if (parseInt(item.ismakeup) == 0){ var h=\"否\" ;return h;}\r\n");
      out.write("                        else if (parseInt(item.ismakeup) == 1) { var h=\"<span style='color:red;'>是</span>\" ;return h;}\r\n");
      out.write("                        \r\n");
      out.write("                    }\r\n");
      out.write("\t\t\t}, {\r\n");
      out.write("\t\t\t\tdisplay : '补考(Make-up)',\r\n");
      out.write("\t\t\t\tname : 'makeup',\r\n");
      out.write("\t\t\t\twidth : 80,\r\n");
      out.write("\t\t\t\teditor: { type: 'text'}\r\n");
      out.write("\t\t\t} ],\r\n");
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
      out.write("/system/Manage_singlestuscorelist.action',\r\n");
      out.write("\t\t\t\t\twidth : '100%'\r\n");
      out.write("\t\t\t\t});\r\n");
      out.write("\t}\r\n");
      out.write("   function f_search(){\r\n");
      out.write("      var semester = $(\"#semester\").val();\r\n");
      out.write("      var coursenum = $(\"#coursenum\").val();\r\n");
      out.write("      if (semester.length==0&&coursenum.length==0) {\r\n");
      out.write("      \t$(\"#maingrid\").ligerGrid({\r\n");
      out.write("\t\t\t\t\turl : '");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/system/Manage_singlescorelist.action'\r\n");
      out.write("\t\t\t   })\r\n");
      out.write("\t  } else {\r\n");
      out.write("\t     var str = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/system/Manage_searchsinglestuscorelist.action?semChosenCourse.semester=\"+semester+\"&coursenum=\"+coursenum;\r\n");
      out.write("\t\t  $(\"#maingrid\").ligerGrid({\r\n");
      out.write("\t\t\turl : str\r\n");
      out.write("\t\t })\r\n");
      out.write("\t  }\r\n");
      out.write(" }\r\n");
      out.write(" function check(){\r\n");
      out.write("   var semester = $(\"#semester\").val();\r\n");
      out.write("   var url = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/system/Manage_stucourseNameList.action?semester=\" + semester;\r\n");
      out.write("\t\t$.ajax({  \r\n");
      out.write("\t        type : \"POST\",  \r\n");
      out.write("\t        url : url,\r\n");
      out.write("\t        dataType : \"JSON\", \r\n");
      out.write("\t        error: function (){\r\n");
      out.write("\t        \t;\r\n");
      out.write("\t        },\r\n");
      out.write("\t        success : function(data) {\r\n");
      out.write("\t        \t$(\"#coursenum\").empty(); \r\n");
      out.write("\t        \tif (data.length > 0){\r\n");
      out.write("\t        \t  document.getElementById(\"coursenum\").options.add(new Option('',''));\r\n");
      out.write("\t        \t\tfor(var n=0;n<data.length;n++){\r\n");
      out.write("\t        \t\t    document.getElementById(\"coursenum\").options.add(new Option(data[n].coursename,data[n].num));\r\n");
      out.write("\t          \t\t} \r\n");
      out.write("\t        \t} else {\r\n");
      out.write("\t        \t\t\r\n");
      out.write("\t        \t}\r\n");
      out.write("\t        }  \r\n");
      out.write("\t    }); \r\n");
      out.write(" }\r\n");
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
      out.write(" height:100%;\r\n");
      out.write(" align:center;\r\n");
      out.write("}\r\n");
      out.write(".search.l-table-edit td{\r\n");
      out.write("  border-bottom: 1px solid #c6c6c6 ;\r\n");
      out.write("}\r\n");
      out.write(".link{\r\n");
      out.write("width:180px;height:25px;background: #fefefe;border: 1px solid #bbb;font-size: 14px;color: #333;border-radius: 3px;\r\n");
      out.write("}\r\n");
      out.write(".l-button{\r\n");
      out.write(" width:70px;float:left; margin:35px 160px 5px ;\r\n");
      out.write(" border-radiux:5px;\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("\t</head>\r\n");
      out.write("\t<body style=\"padding: 2px\">\t\r\n");
      out.write("\t    <div id=\"head\">\r\n");
      out.write("\t      <div class=\"title\" ><br><br><div align=\"center\"><font face=\"微软雅黑\" color=\"#400000\" size=\"4\"><strong>条件选择</strong></font></div></div>\r\n");
      out.write("\t      <div class=\"search\" >\r\n");
      out.write("\t         <table style=\"margin-top: 30px;\" >\r\n");
      out.write("\t            <tr>\r\n");
      out.write("\t               <td style=\"margin-top: 40px;\" >&nbsp;&nbsp;&nbsp;&nbsp;开课学期：</td>\r\n");
      out.write("\t               <td>\r\n");
      out.write("\t                   <select id=\"semester\" class=\"link\" onchange=\"check()\" >\r\n");
      out.write("\t                      <option value=\"\" ></option>\r\n");
      out.write("\t                   </select>\r\n");
      out.write("\t               </td>\r\n");
      out.write("\t                   <td>&nbsp;&nbsp;&nbsp;&nbsp;课程名称：</td>\r\n");
      out.write("\t                   <td><select id=\"coursenum\" class=\"link\" >\r\n");
      out.write("\t                      <option value=\"\" ></option>\r\n");
      out.write("\t                      ");
      if (_jspx_meth_s_005fiterator_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t                   </select></td>\r\n");
      out.write("\t            </tr>\r\n");
      out.write("\t         </table>\r\n");
      out.write("\t\t<a class=\"l-button\" onclick=\"f_search()\"><strong>查&nbsp;&nbsp;询</strong></a>\r\n");
      out.write("\t      </div>\r\n");
      out.write("\t    </div>\t\t\t\r\n");
      out.write("\t\t<div class=\"l-clear\"></div>\r\n");
      out.write("\t\t<div id=\"maingrid\" ></div>\r\n");
      out.write("\t\t<div style=\"margin:10px;\" > 备注：&nbsp;&nbsp;出勤：Attendance； 作业：Homework； 期中：Middle Examination； 期末：Final Examination；综合：Total Score；</div>\r\n");
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
    // /WEB-INF/student/scoreload.jsp(197,23) name = value type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_s_005fiterator_005f0.setValue("#courselist");
    // /WEB-INF/student/scoreload.jsp(197,23) name = id type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_s_005fiterator_005f0.setId("c");
    int _jspx_eval_s_005fiterator_005f0 = _jspx_th_s_005fiterator_005f0.doStartTag();
    if (_jspx_eval_s_005fiterator_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      if (_jspx_eval_s_005fiterator_005f0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.pushBody();
        _jspx_th_s_005fiterator_005f0.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
        _jspx_th_s_005fiterator_005f0.doInitBody();
      }
      do {
        out.write("\r\n");
        out.write("\t                         <option value=\"");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${c.num }", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
        out.write('"');
        out.write(' ');
        out.write('>');
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${c.coursename }", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
        out.write("(&nbsp;");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${c.coursename_en }", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
        out.write(" )</option>\r\n");
        out.write("\t                      ");
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
}
