package org.apache.jsp.WEB_002dINF.course;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;

public final class personattendence_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fs_005fiterator_005fvalue_005fid;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fs_005fproperty_005fvalue_005fnobody;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fs_005fiterator_005fvalue_005fid = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fs_005fproperty_005fvalue_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fs_005fiterator_005fvalue_005fid.release();
    _005fjspx_005ftagPool_005fs_005fproperty_005fvalue_005fnobody.release();
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
      out.write("\t<link href=\"");
      out.print(basePath);
      out.write("css/date.css\" rel=\"stylesheet\" type=\"text/css\"/>\r\n");
      out.write("    <script src=\"js/jquery/jquery-1.6.min.js\"type=\"text/javascript\"></script>\r\n");
      out.write("    <script src=\"js/jquery/jquery.js\"type=\"text/javascript\"></script>\r\n");
      out.write("\t<script src=\"js/ligerUI/core/base.js\" type=\"text/javascript\"></script>\r\n");
      out.write("\t<script src=\"js/ligerUI/ligerui.all.js\" type=\"text/javascript\"></script>\r\n");
      out.write("\t<script src=\"js/ligerUI/plugins/ligerDateEditor.js\" type=\"text/javascript\"></script>\r\n");
      out.write("\t<script src=\"");
      out.print(basePath);
      out.write("js/jquery.date_input.pack.js\" type=\"text/javascript\"></script>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("    $(function(){\r\n");
      out.write("\t  $('.date_picker').date_input();\r\n");
      out.write("   })\r\n");
      out.write("    var AttendenceData = { \r\n");
      out.write("\tRows: [");
String s = (String) request.getAttribute("attendencelist");
      out.write(' ');
      out.print(s);
      out.write("]};\r\n");
      out.write("    var TypeData = [{ type: 0, text: '正常' }, { type: 1, text: '迟到'}, { type: 2, text: '早退'}, { type: 3, text: '旷课'}];\r\n");
      out.write("   $(f_initGrid);\r\n");
      out.write("\tvar manager, g;\r\n");
      out.write("\tfunction f_initGrid() {\r\n");
      out.write("\t\tg = manager = $(\"#maingrid\").ligerGrid(\r\n");
      out.write("\t\t\t{columns : [\r\n");
      out.write("\t\t\t{   display : '序号',  name : 'id',     width : 40,  type : 'int',hide:true\r\n");
      out.write("\t\t\t}, {display : '学号', name : 'stunum',  minWidth : 120, editor: { type: 'text'}\r\n");
      out.write("\t\t\t}, {display : '中文名', name : 'stuname',minWidth : 80, editor: { type: 'text'}\r\n");
      out.write("\t\t\t}, {display : '课程名称', name : 'coursename',minWidth : 80, editor: { type: 'text'}\r\n");
      out.write("\t\t\t}, {display : '日期', name : 'date',minWidth : 80, editor: { type: 'text'}\r\n");
      out.write("\t\t\t}, {display : '时间', name : 'time',minWidth : 80, editor: { type: 'text'}\t\t\t\r\n");
      out.write("            }, {display : '考勤状态', name : 'type',minWidth : 80, \r\n");
      out.write("            editor: { type: 'select', data: TypeData, valueField: 'type' },\r\n");
      out.write("                    render: function (item)\r\n");
      out.write("                    {\r\n");
      out.write("                        if (parseInt(item.type) == 0){ var h=\"<span style='color:black;'>正常</span>\" ;return h;}\r\n");
      out.write("                        else if (parseInt(item.type) == 1) { var h=\"<span style='color:orange;'>迟到</span>\" ;return h;}\r\n");
      out.write("                        else if (parseInt(item.type) == 2) { var h=\"<span style='color:blue;'>早退</span>\" ;return h;}\r\n");
      out.write("                        else if (parseInt(item.type) == 3) { var h=\"<span style='color:red;'>旷课</span>\" ;return h;}\r\n");
      out.write("                    }}\r\n");
      out.write("\t\t\t],\r\n");
      out.write("\t\t\t\t\tonSelectRow : function(rowdata, rowindex) {\r\n");
      out.write("\t\t\t\t\t\t$(\"#txtrowindex\").val(rowindex);\r\n");
      out.write("\t\t\t\t\t},\r\n");
      out.write("\t\t\t\t\tenabledEdit : true,\r\n");
      out.write("\t\t\t\t\tclickToEdit : false,\r\n");
      out.write("\t\t\t\t\tisScroll : false,\r\n");
      out.write("\t\t\t        rownumbers:true,\r\n");
      out.write("\t\t\t        pageSize:10,\r\n");
      out.write("\t\t\t\t\turl : '");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/system/Manage_personattendencelist.action',\r\n");
      out.write("\t\t\t\t\twidth : '100%'\r\n");
      out.write("\t\t\t\t});//'");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/system/Manage_attendencestulist.action'\r\n");
      out.write("\t}\t\r\n");
      out.write("  function f_search(){ \r\n");
      out.write("   if ((document.all.course.value ==\"\")&&(document.all.date.value ==\"\")&&(document.all.type.value ==\"\")){\r\n");
      out.write("\t$(\"#maingrid\").ligerGrid({\r\n");
      out.write("\t\t  url:'");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/system/Manage_personattendencelist.action'\r\n");
      out.write("\t\t})\r\n");
      out.write("   }else{\r\n");
      out.write("       // alert($(\"#course option:selected\").val());\r\n");
      out.write("\t\tvar str = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/system/Manage_stuattendenceresearch.action?attendence.choosencourseid=\" + encodeURI(encodeURI($(\"#course option:selected\").val())\r\n");
      out.write("\t\t+\"&attendence.date=\"+encodeURI(encodeURI($(\"#date\").val()))\r\n");
      out.write("\t\t+\"&attendence.type=\"+encodeURI(encodeURI($(\"#type\").val())));\r\n");
      out.write("\t\t$(\"#maingrid\").ligerGrid({\r\n");
      out.write("\t\t  url:str\r\n");
      out.write("\t\t})\r\n");
      out.write("   }\r\n");
      out.write("  }\r\n");
      out.write("    \r\n");
      out.write("</script>\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write("body{font-size: 12px;padding: 2px}\r\n");
      out.write(".l-table-edit-td{font-size: 14px;padding: 5px;margin-left: 2px;}\r\n");
      out.write(".link{width:160px;height:25px;background: #fefefe;border: 1px solid #bbb;font-size: 14px;color: #333;border-radius: 3px;}\r\n");
      out.write(".data-table{ border:1px #ebebeb solid; border-bottom:none;width:70%;border-spacing: 0px;margin: auto;}\r\n");
      out.write(".data-table td{height:28px; padding-left:5px; border-bottom:1px #ebebeb solid;}\r\n");
      out.write(".td-cb{ width:20px;}\r\n");
      out.write(".data-table a{ color:#3377aa;text-decoration:none;}\r\n");
      out.write(".data-table a:hover{background:none;color:#3377aa;text-decoration:underline;}\r\n");
      out.write(".data-table tbody tr:hover{ background:#ffffe1;}\r\n");
      out.write("td .action{ width:20px; position:relative;}\r\n");
      out.write(".ac td .act-box a{text-decoration:none;}\r\n");
      out.write(".action .arrow{ text-align:center; width:16px; height:16px; border:1px solid #DADADA; cursor:pointer; z-index:-1;}\r\n");
      out.write(".action .arrow img{ margin-top:6px;}\r\n");
      out.write(".action .act-box{ position:absolute; min-width:80px; text-align:center; right:2px; background-color:White; border:1px solid #DADADA; display:none; z-index:100;}\r\n");
      out.write(".act-box a{ display:block; width:80px; height:20px; line-height:20px;text-decoration:none;}\r\n");
      out.write(".act-box a:hover{ color:White; background:#37A; text-decoration:none;}\r\n");
      out.write("#content{\r\n");
      out.write("  margin-top:20px;\r\n");
      out.write("}\r\n");
      out.write("#table3{\r\n");
      out.write("  margin:auto;\r\n");
      out.write("  margin-top: 10px;\r\n");
      out.write("  font-size: 15px;\r\n");
      out.write("  width: 350px;\r\n");
      out.write("}\r\n");
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
      out.write("  margin-top: 25px;\r\n");
      out.write("}\r\n");
      out.write(".l-table-edit{\r\n");
      out.write(" margin-top: 10px;\r\n");
      out.write(" margin-left: 20px;\r\n");
      out.write("}\r\n");
      out.write(".link{\r\n");
      out.write("width:160px;height:25px;background: #fefefe;border: 1px solid #bbb;font-size: 14px;color: #333;border-radius: 3px;\r\n");
      out.write("}\r\n");
      out.write(".l-button{\r\n");
      out.write(" width:70px;float:left; margin:20px 160px 5px ;\r\n");
      out.write(" border-radiux:5px;\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("\t</head>\r\n");
      out.write("\t<body >\r\n");
      out.write("\t<div id=\"head\">\r\n");
      out.write("\t      <div class=\"title\" ><br><br><div align=\"center\"><font face=\"微软雅黑\" color=\"#400000\" size=\"4\"><strong>条件选择</strong></font></div></div>\r\n");
      out.write("\t      <div class=\"search\" >\r\n");
      out.write("\t\t  <table cellpadding=\"0\" cellspacing=\"0\" class=\"l-table-edit\" >\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td align=\"right\" class=\"l-table-edit-td\">&nbsp;课程:</td>\r\n");
      out.write("\t\t\t\t<td align=\"left\" class=\"l-table-edit-td\">\r\n");
      out.write("\t\t\t\t  <select name=\"course\" id=\"course\" ltype=\"select\" class=\"link\">\r\n");
      out.write("\t\t\t\t\t\t<option></option>\r\n");
      out.write("\t\t\t\t\t\t");
      if (_jspx_meth_s_005fiterator_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t\t\t</select>\r\n");
      out.write("\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t<td align=\"right\" class=\"l-table-edit-td\">&nbsp;时间:</td>\r\n");
      out.write("\t\t\t\t<td align=\"left\" class=\"l-table-edit-td\"><input  id=\"date\" class=\"date_picker link\"></td>\r\n");
      out.write("\t\t\t    <!-- <td align=\"right\" class=\"l-table-edit-td\">&nbsp;节次:</td>\r\n");
      out.write("\t\t\t\t<td align=\"left\" class=\"l-table-edit-td\">\r\n");
      out.write("\t\t\t\t  <select id=\"time\" name=\"time\" class=\"link\"   >\r\n");
      out.write("\t\t\t\t    <option value=\"\"></option>\r\n");
      out.write("\t\t\t\t    <option value=\"8:20-10:00\">第一大节</option>\t\t\t\t  \r\n");
      out.write("\t\t\t\t    <option value=\"10:20-12:00\">第二大节</option>\r\n");
      out.write("\t\t\t\t    <option value=\"14:00-15:40\">第三大节</option>\r\n");
      out.write("\t\t\t\t    <option value=\"16:00-17:40\">第四大节</option>\r\n");
      out.write("\t\t\t\t    <option value=\"18:30-20:10\">第五大节</option>\r\n");
      out.write("\t\t\t\t  </select>\r\n");
      out.write("\t\t\t\t</td> -->\r\n");
      out.write("\t\t\t\t<td align=\"right\" class=\"l-table-edit-td\">&nbsp;出勤状态:</td>\r\n");
      out.write("\t\t\t\t<td align=\"left\" class=\"l-table-edit-td\">\r\n");
      out.write("\t\t\t\t  <select id=\"type\" name=\"type\" class=\"link\"  >\r\n");
      out.write("\t\t\t\t    <option value=\"\"></option>\r\n");
      out.write("\t\t\t\t    <option value=\"0\">正常</option>\t\t\t\t  \r\n");
      out.write("\t\t\t\t    <option value=\"1\">迟到</option>\r\n");
      out.write("\t\t\t\t    <option value=\"2\">早退</option>\r\n");
      out.write("\t\t\t\t    <option value=\"3\">旷课</option>\t\t\t\t    \r\n");
      out.write("\t\t\t\t  </select>\r\n");
      out.write("\t\t\t\t</td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t</table>\r\n");
      out.write("\t\t<a class=\"l-button\" onclick=\"f_search()\"><strong>查&nbsp;&nbsp;询</strong></a>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t    </div>\t\r\n");
      out.write("\t\t<div style=\"margin-top:20px;font-size: 16px;margin-left: 30px;\">考勤记录：</div>\r\n");
      out.write("\t    <div class=\"l-clear\"></div>\r\n");
      out.write("\t\t<div id=\"maingrid\" ></div>\r\n");
      out.write("\t\t<div  style=\"display:none;\">\r\n");
      out.write("\t\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
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
    // /WEB-INF/course/personattendence.jsp(145,6) name = value type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_s_005fiterator_005f0.setValue("#courselist");
    // /WEB-INF/course/personattendence.jsp(145,6) name = id type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
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
        out.write("\t\t\t\t\t\t   <option value=\"");
        if (_jspx_meth_s_005fproperty_005f0(_jspx_th_s_005fiterator_005f0, _jspx_page_context))
          return true;
        out.write('"');
        out.write('>');
        if (_jspx_meth_s_005fproperty_005f1(_jspx_th_s_005fiterator_005f0, _jspx_page_context))
          return true;
        out.write("</option>\r\n");
        out.write("\t\t\t\t\t\t");
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

  private boolean _jspx_meth_s_005fproperty_005f0(javax.servlet.jsp.tagext.JspTag _jspx_th_s_005fiterator_005f0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  s:property
    org.apache.struts2.views.jsp.PropertyTag _jspx_th_s_005fproperty_005f0 = (org.apache.struts2.views.jsp.PropertyTag) _005fjspx_005ftagPool_005fs_005fproperty_005fvalue_005fnobody.get(org.apache.struts2.views.jsp.PropertyTag.class);
    _jspx_th_s_005fproperty_005f0.setPageContext(_jspx_page_context);
    _jspx_th_s_005fproperty_005f0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_s_005fiterator_005f0);
    // /WEB-INF/course/personattendence.jsp(146,24) name = value type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_s_005fproperty_005f0.setValue("#gg.num");
    int _jspx_eval_s_005fproperty_005f0 = _jspx_th_s_005fproperty_005f0.doStartTag();
    if (_jspx_th_s_005fproperty_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fs_005fproperty_005fvalue_005fnobody.reuse(_jspx_th_s_005fproperty_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fs_005fproperty_005fvalue_005fnobody.reuse(_jspx_th_s_005fproperty_005f0);
    return false;
  }

  private boolean _jspx_meth_s_005fproperty_005f1(javax.servlet.jsp.tagext.JspTag _jspx_th_s_005fiterator_005f0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  s:property
    org.apache.struts2.views.jsp.PropertyTag _jspx_th_s_005fproperty_005f1 = (org.apache.struts2.views.jsp.PropertyTag) _005fjspx_005ftagPool_005fs_005fproperty_005fvalue_005fnobody.get(org.apache.struts2.views.jsp.PropertyTag.class);
    _jspx_th_s_005fproperty_005f1.setPageContext(_jspx_page_context);
    _jspx_th_s_005fproperty_005f1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_s_005fiterator_005f0);
    // /WEB-INF/course/personattendence.jsp(146,55) name = value type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_s_005fproperty_005f1.setValue("#gg.coursename");
    int _jspx_eval_s_005fproperty_005f1 = _jspx_th_s_005fproperty_005f1.doStartTag();
    if (_jspx_th_s_005fproperty_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fs_005fproperty_005fvalue_005fnobody.reuse(_jspx_th_s_005fproperty_005f1);
      return true;
    }
    _005fjspx_005ftagPool_005fs_005fproperty_005fvalue_005fnobody.reuse(_jspx_th_s_005fproperty_005f1);
    return false;
  }
}
