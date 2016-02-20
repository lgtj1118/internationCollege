package org.apache.jsp.WEB_002dINF.course;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;

public final class courseattendenceload_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("    ");
      out.write("\r\n");
      out.write("    var TypeData = [{ type: 0, text: '正常' }, { type: 1, text: '迟到'}, { type: 2, text: '早退'}, { type: 3, text: '旷课'}];\r\n");
      out.write("   $(f_initGrid);\r\n");
      out.write("\tvar manager, g;\r\n");
      out.write("\tfunction f_initGrid() {\r\n");
      out.write("\t\tg = manager = $(\"#maingrid\").ligerGrid(\r\n");
      out.write("\t\t\t{columns : [\r\n");
      out.write("\t\t\t{   display : '序号',  name : 'id',     width : 40,  type : 'int',hide:true\r\n");
      out.write("\t\t\t}, {display : '护照号', name : 'passport',  minWidth : 120, editor: { type: 'text'}\r\n");
      out.write("\t\t\t}, {display : '英文名', name : 'firstname',minWidth : 100, editor: { type: 'text'}\r\n");
      out.write("\t\t\t}, {display : '英文姓', name : 'lastname',minWidth : 100, editor: { type: 'text'}\r\n");
      out.write("\t\t\t}, {display : '中文名', name : 'stuname',minWidth : 80, editor: { type: 'text'}\r\n");
      out.write("\t\t\t}, { display: '班级',  name: 'classname', minWidth: 100, editor: { type: 'text'}\r\n");
      out.write("            }, {display : '日期', name : 'date',minWidth : 80, editor: { type: 'text'}\r\n");
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
      out.write("\t\t\t        pageSize:15,\r\n");
      out.write("\t\t\t\t\t//data : AttendenceData,\r\n");
      out.write("\t\t\t\t\turl:'");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/system/Manage_searchcourseattendencelist.action',\r\n");
      out.write("\t\t\t\t\twidth : '100%'\r\n");
      out.write("\t\t\t\t});//\r\n");
      out.write("\t}\t\r\n");
      out.write("\tfunction f_class(){\r\n");
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
      out.write("\tfunction f_search(){\r\n");
      out.write("\t  var classid = $(\"#classid\").val();\r\n");
      out.write("      var studentid = $(\"#stuid\").val();\r\n");
      out.write("      var startdate = $(\"#startdate\").val();\r\n");
      out.write("      var enddate = $(\"#enddate\").val();\r\n");
      out.write("      var time = $(\"#time\").val();\r\n");
      out.write("      var type = $(\"#type\").val();\r\n");
      out.write("      if(startdate.length==0&&enddate.length!=0){\r\n");
      out.write("        alert(\"请输入起始日期！\");\r\n");
      out.write("      }else{\r\n");
      out.write("        if(startdate.length!=0&&enddate.length==0){\r\n");
      out.write("           alert(\"请输入截止日期！\");\r\n");
      out.write("        }else{\r\n");
      out.write("          if (classid.length==0&&(studentid==null||studentid.length==0)&&time.length==0&&type.length==0&&startdate.length==0&&enddate.length==0) {\r\n");
      out.write("\t\t\t$(\"#maingrid\").ligerGrid({\r\n");
      out.write("\t\t\t\t\turl : '");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/system/Manage_searchcourseattendencelist.action'\r\n");
      out.write("\t\t\t })\r\n");
      out.write("\t      } else {\r\n");
      out.write("\t       var str = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/system/Manage_searchattendencelistmap.action?cls.id=\"+classid+\"&stu.stuid=\"+studentid\r\n");
      out.write("\t        + \"&semChosenCourse.coursenum=\"+ $(\"#coursenum\").val()+\"&startdate=\"+startdate+\"&enddate=\"+enddate+\"&time=\"+time+\"&type=\"+type;\r\n");
      out.write("\t\t   $(\"#maingrid\").ligerGrid({\r\n");
      out.write("\t\t\t url : str\r\n");
      out.write("\t\t   })\r\n");
      out.write("\t     }\r\n");
      out.write("       }\r\n");
      out.write("    }\r\n");
      out.write("           /*  g.options.data = $.extend(true, {}, AttendenceData);\r\n");
      out.write("            g.loadData(f_getWhere());\r\n");
      out.write("     }\r\n");
      out.write("        function f_getWhere()\r\n");
      out.write("        {\r\n");
      out.write("            if (!g) return null;\r\n");
      out.write("            var clause = function (rowdata, rowindex)\r\n");
      out.write("            {\r\n");
      out.write("                var startdate = $(\"#startdate\").val();\r\n");
      out.write("                var enddate = $(\"#enddate\").val();\r\n");
      out.write("                var rtime = $(\"#time option:selected\").val();\r\n");
      out.write("                var rtype = $(\"#type\").val();\r\n");
      out.write("                if(startdate.length==0&&enddate.lengt!=0){\r\n");
      out.write("                  alert(\"请输入起始日期！\");\r\n");
      out.write("                }else if(startdate.length!=0&&enddate.length==0) {\r\n");
      out.write("                  alert(\"请输入截止日期！\");\r\n");
      out.write("                }else{\r\n");
      out.write("                   if(startdate.length!=0&&enddate.length!=0){\r\n");
      out.write("                     if(rtime.length!=0){\r\n");
      out.write("                       if(rtype.length!=0){\r\n");
      out.write("                         return (rowdata.date.indexOf(rdate) > -1)&&(rowdata.time.indexOf(rtime) > -1)&&(rowdata.type.indexOf(rtype) > -1);\r\n");
      out.write("                       }else{\r\n");
      out.write("                           return (rowdata.date.indexOf(rdate) > -1)&&(rowdata.time.indexOf(rtime) > -1);\r\n");
      out.write("                       }\r\n");
      out.write("                      }else{\r\n");
      out.write("                        return (rowdata.date.indexOf(rdate) > -1)&&(rowdata.type.indexOf(rtype) > -1);\r\n");
      out.write("                     }\r\n");
      out.write("                   }else{\r\n");
      out.write("                       if(rtime.length!=0){\r\n");
      out.write("                         if(rtype.length!=0){\r\n");
      out.write("                           return (rowdata.time.indexOf(rtime) > -1)&&(rowdata.type.indexOf(rtype) > -1);\r\n");
      out.write("                         }else{\r\n");
      out.write("                           return (rowdata.time.indexOf(rtime) > -1);\r\n");
      out.write("                         }\r\n");
      out.write("                       }else{\r\n");
      out.write("                           return rowdata.type.indexOf(rtype) > -1; \r\n");
      out.write("                       }\r\n");
      out.write("                   }\r\n");
      out.write("                }\r\n");
      out.write("                \r\n");
      out.write("                \r\n");
      out.write("            };\r\n");
      out.write("            return clause;  */\r\n");
      out.write("        } \r\n");
      out.write("</script>\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write("body{\r\n");
      out.write("  font-size: 12px;\r\n");
      out.write("}\r\n");
      out.write("#head{\r\n");
      out.write(" width: 98%;\r\n");
      out.write(" height:105px;\r\n");
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
      out.write(" margin-top:5px;\r\n");
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
      out.write("\t<body >\r\n");
      out.write("\t<div id=\"head\">\r\n");
      out.write("\t\t  <div class=\"title\" ><br><br><div align=\"center\"><font face=\"微软雅黑\" color=\"#400000\" size=\"4\"><strong>条件选择</strong></font></div></div>\r\n");
      out.write("\t      <div class=\"search\" >\t  \r\n");
      out.write("\t\t  <table cellpadding=\"0\" cellspacing=\"0\" class=\"l-table-edit\" >\r\n");
      out.write("\t\t\t<tr>\t\t\t\t\r\n");
      out.write("\t\t\t    <td align=\"right\" class=\"l-table-edit-td\" width=\"100px\" >&nbsp;&nbsp;班级:&nbsp;</td>\r\n");
      out.write("\t\t\t\t<td align=\"left\" class=\"l-table-edit-td\">\r\n");
      out.write("\t\t\t\t  <select id=\"classid\" name=\"classid\" class=\"link\" onchange=\"f_class()\" >\r\n");
      out.write("\t\t\t\t     <option value=\"\" ></option>\r\n");
      out.write("\t\t\t\t     ");
      if (_jspx_meth_s_005fiterator_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t\t\t  </select>\r\n");
      out.write("\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t<td align=\"right\" class=\"l-table-edit-td\">&nbsp;&nbsp;学生姓名:&nbsp;</td>\r\n");
      out.write("\t\t\t\t<td align=\"left\" class=\"l-table-edit-td\">\r\n");
      out.write("\t\t\t\t <select id=\"stuid\" name=\"stuid\" class=\"link\"  ></select>\r\n");
      out.write("\t\t\t\t</td>\t\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td align=\"right\" class=\"l-table-edit-td\">&nbsp;&nbsp;起始日期:&nbsp;</td>\r\n");
      out.write("\t\t\t\t<td align=\"left\" class=\"l-table-edit-td\"><input  id=\"startdate\" onblur=\"check()\"  class=\"date_picker link\"></td>\r\n");
      out.write("\t\t\t    <td align=\"right\" class=\"l-table-edit-td\">&nbsp;&nbsp;截止日期:&nbsp;</td>\r\n");
      out.write("\t\t\t\t<td align=\"left\" class=\"l-table-edit-td\"><input  id=\"enddate\" onblur=\"check()\"  class=\"date_picker link\"></td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t    <td align=\"right\" class=\"l-table-edit-td\">&nbsp;&nbsp;节次:&nbsp;</td>\r\n");
      out.write("\t\t\t\t<td align=\"left\" class=\"l-table-edit-td\">\r\n");
      out.write("\t\t\t\t  <select id=\"time\" name=\"time\" class=\"link\"   >\r\n");
      out.write("\t\t\t\t    <option value=\"\"></option>\r\n");
      out.write("\t\t\t\t    <option value=\"8:20-10:00\">第一大节</option>\t\t\t\t  \r\n");
      out.write("\t\t\t\t    <option value=\"10:20-12:00\">第二大节</option>\r\n");
      out.write("\t\t\t\t    <option value=\"14:00-15:40\">第三大节</option>\r\n");
      out.write("\t\t\t\t    <option value=\"16:00-17:40\">第四大节</option>\r\n");
      out.write("\t\t\t\t    <option value=\"18:30-20:10\">第五大节</option>\r\n");
      out.write("\t\t\t\t  </select>\r\n");
      out.write("\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t<td align=\"right\" class=\"l-table-edit-td\">&nbsp;&nbsp;考勤状态:&nbsp;</td>\r\n");
      out.write("\t\t\t\t<td align=\"left\" class=\"l-table-edit-td\">\r\n");
      out.write("\t\t\t\t  <select id=\"type\" name=\"type\" class=\"link\"  >\r\n");
      out.write("\t\t\t\t    <option value=\"\"></option>\r\n");
      out.write("\t\t\t\t    <option value=\"0\">正常</option>\t\t\t\t  \r\n");
      out.write("\t\t\t\t    <option value=\"1\">迟到</option>\r\n");
      out.write("\t\t\t\t    <option value=\"2\">早退</option>\r\n");
      out.write("\t\t\t\t    <option value=\"3\">旷课</option>\t\t\t\t    \r\n");
      out.write("\t\t\t\t  </select>\r\n");
      out.write("\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t<td align=\"right\" class=\"l-table-edit-td\"><input id=\"coursenum\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${coursenum }", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\" type=\"hidden\"/></td>\r\n");
      out.write("\t\t\t\t<td align=\"left\" class=\"l-table-edit-td\"><input class=\"link\" ltype=\"text\" name=\"coursename\"type=\"hidden\" disabled=\"disabled\" id=\"coursename\" ltype=\"text\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${course.coursename }", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\"  validate=\"{required:true,minlength:1,maxlength:20}\" /></td>\t\t\t\t\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t  <th colspan=\"6\"><div id=\"result1\"></div></th>\r\n");
      out.write("\t\t\t</tr>\t\t\t\t\t\t\r\n");
      out.write("\t\t</table>\r\n");
      out.write("\t\t<a class=\"l-button\" style=\"width:70px;float:left; margin:0px 160px 5px ;\" onclick=\"f_search()\">查&nbsp;&nbsp;询</a>\t\t\r\n");
      out.write("\t\t </div>\r\n");
      out.write("\t    </div>\t\r\n");
      out.write("\t\t<div class=\"l-clear\"></div>\r\n");
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

  private boolean _jspx_meth_s_005fiterator_005f0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  s:iterator
    org.apache.struts2.views.jsp.IteratorTag _jspx_th_s_005fiterator_005f0 = (org.apache.struts2.views.jsp.IteratorTag) _005fjspx_005ftagPool_005fs_005fiterator_005fvalue_005fid.get(org.apache.struts2.views.jsp.IteratorTag.class);
    _jspx_th_s_005fiterator_005f0.setPageContext(_jspx_page_context);
    _jspx_th_s_005fiterator_005f0.setParent(null);
    // /WEB-INF/course/courseattendenceload.jsp(206,9) name = id type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_s_005fiterator_005f0.setId("c");
    // /WEB-INF/course/courseattendenceload.jsp(206,9) name = value type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_s_005fiterator_005f0.setValue("#classlist");
    int _jspx_eval_s_005fiterator_005f0 = _jspx_th_s_005fiterator_005f0.doStartTag();
    if (_jspx_eval_s_005fiterator_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      if (_jspx_eval_s_005fiterator_005f0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.pushBody();
        _jspx_th_s_005fiterator_005f0.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
        _jspx_th_s_005fiterator_005f0.doInitBody();
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
