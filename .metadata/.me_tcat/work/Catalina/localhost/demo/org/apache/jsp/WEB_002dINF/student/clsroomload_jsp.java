package org.apache.jsp.WEB_002dINF.student;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.tjpu.bean.Classroom;
import com.opensymphony.xwork2.ActionContext;
import java.util.*;

public final class clsroomload_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("    <title>天津工业大学排课管理系统</title>\t   \r\n");
      out.write("\t<link href=\"");
      out.print(basePath);
      out.write("js/ligerUI/skins/Aqua/css/ligerui-all.css\" rel=\"stylesheet\"type=\"text/css\" />\t\r\n");
      out.write("\t<link href=\"");
      out.print(basePath );
      out.write("js/ligerUI/skins/Gray/css/all.css\" rel=\"stylesheet\" type=\"text/css\"/>\t\r\n");
      out.write("    <script type=\"text/javascript\" src=\"js/jquery-validation/jquery.validate.min.js\" charset=\"utf-8\"></script>\r\n");
      out.write("    <script type=\"text/javascript\" src=\"js/json.js\" charset=\"utf-8\"></script>\r\n");
      out.write("    <script type=\"text/javascript\" src=\"js/jquery-validation/jquery.metadata.js\" charset=\"utf-8\"></script>\r\n");
      out.write("    <script type=\"text/javascript\" src=\"js/jquery-validation/messages_cn.js\" charset=\"utf-8\"></script>\r\n");
      out.write("    <script src=\"");
      out.print(basePath);
      out.write("js/jquery/jquery-1.6.min.js\" type=\"text/javascript\"></script>\r\n");
      out.write("\t<script src=\"js/ligerUI/core/base.js\" type=\"text/javascript\"></script>\r\n");
      out.write("\t<script src=\"js/ligerUI/ligerui.all.js\" type=\"text/javascript\"></script>\r\n");
      out.write("    <script type=\"text/javascript\">\t\t\t\r\n");
      out.write("\t\t$(f_initGrid);\r\n");
      out.write("\tvar manager, g;\r\n");
      out.write("\tfunction f_initGrid() {\r\n");
      out.write("\t\tg = manager = $(\"#maingrid\").ligerGrid(\r\n");
      out.write("\t\t\t{columns : [\r\n");
      out.write("\t\t\t{   display : 'ID',  name : 'id',     width : 60,  type : 'int',hide:true\r\n");
      out.write("\t\t\t}, {display : '编号', name : 'num',  minWidth : 120, editor: { type: 'text'}\r\n");
      out.write("\t\t\t}, {display : '名称', name : 'roomname',  minWidth : 120, editor: { type: 'text'}\r\n");
      out.write("\t\t\t} ,{display : '位置', name : 'roomplace',minWidth : 120,editor: { type: 'text'}\r\n");
      out.write("\t\t\t}, {display : '类型', name : 'roomtype',minWidth : 120, editor: { type: 'text'}\r\n");
      out.write("\t\t\t}, {display : '容量', name : 'roomcapacity',minWidth : 100, editor: { type: 'text'}\r\n");
      out.write("\t\t\t}, {display : '实际容量', name : 'realcapacity',minWidth : 100, editor: { type: 'text'}\t\t\t\r\n");
      out.write("\t\t\t}, {display : '备注', name : 'note',minWidth : 120, editor: { type: 'text'}\r\n");
      out.write("\t\t\t} ],\r\n");
      out.write("\t\t\t\t\tonSelectRow : function(rowdata, rowindex) {\r\n");
      out.write("\t\t\t\t\t\t$(\"#txtrowindex\").val(rowindex);\r\n");
      out.write("\t\t\t\t\t},\r\n");
      out.write("\t\t\t\t\t//checkbox:true,\r\n");
      out.write("\t\t\t\t\tenabledEdit : true,\r\n");
      out.write("\t\t\t\t\tclickToEdit : false,\r\n");
      out.write("\t\t\t\t\tisScroll : false,\r\n");
      out.write("\t\t\t\t\trownumbers:true, \r\n");
      out.write("\t\t\t\t\tpageSize:30,\r\n");
      out.write("\t\t\t\t\turl :'");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/system/Class_roomlist.action',\r\n");
      out.write("\t\t\t\t\twidth : '100%'\r\n");
      out.write("\t\t\t\t});\r\n");
      out.write("\t}\r\n");
      out.write("\t\t\r\n");
      out.write("\tvar flg = false;\r\n");
      out.write("\tfunction f_search(){\r\n");
      out.write("\t  if ((document.all.roomname.value == \"\") && (document.all.roomcapacity.value == \"\")) {\r\n");
      out.write("\t\t\t$(\"#maingrid\").ligerGrid({\r\n");
      out.write("\t\t\t\t\turl : '");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/system/Class_roomlist.action'\r\n");
      out.write("\t\t\t   })\r\n");
      out.write("\t\t} else {\r\n");
      out.write("\t\t\tvar str = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/system/Class_roomsearch.action?room.roomname=\" + encodeURI(encodeURI($(\"#roomname\").val()) + \"&room.roomcapacity=\" + encodeURI(encodeURI($(\"#roomcapacity\").val())));\r\n");
      out.write("\t\t\t   $(\"#maingrid\").ligerGrid({\r\n");
      out.write("\t\t\t\t\turl : str\r\n");
      out.write("\t\t\t   })\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\t$(document).ready(function(){\r\n");
      out.write("\t\tpChan();\r\n");
      out.write("\t\t\r\n");
      out.write("\t});\r\n");
      out.write("\t\r\n");
      out.write("\tfunction fuzzy (){\r\n");
      out.write("\t\tvar foo = $(\"#foo\").val();\r\n");
      out.write("\t\tvar str = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/system/Class_roomSearch.action?room.roomplace=\" \r\n");
      out.write("\t\t+ encodeURI(encodeURI($(\"#address\").val())) + \"&room.roomcapacity=\" + $(\"#capable\").val()+ \"&room.roomtype=\" + encodeURI(encodeURI(foo));\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t//\tvar str = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/system/Class_roomSearch.action?room.roomplace=\" \r\n");
      out.write("\t\t//+ encodeURI(encodeURI($(\"#address\").val())) + \"&room.roomcapacity=\" + $(\"#capable\").val();\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t   $(\"#maingrid\").ligerGrid({\r\n");
      out.write("\t\t\t\t\turl : str\r\n");
      out.write("\t\t });\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\tfunction pChan () {\r\n");
      out.write("\t\t//alert(\"2\");\r\n");
      out.write("\t\t$(\"#capable\").empty();\r\n");
      out.write("\t\tvar address = $(\"#address\").val();\r\n");
      out.write("\t\tvar foo = $(\"#foo\").val();\r\n");
      out.write("\t\tvar url = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/system/Class_getCapList.action?room.roomplace=\" + encodeURI(encodeURI(address)) + \"&room.roomtype=\" + encodeURI(encodeURI(foo));\r\n");
      out.write("\t\t$.ajax({  \r\n");
      out.write("\t        type : \"POST\",  \r\n");
      out.write("\t        url : url,\r\n");
      out.write("\t        dataType : \"JSON\", \r\n");
      out.write("\t        error: function (){\r\n");
      out.write("\t        \talert(\"数据传输错误，请联系管理员！\");\r\n");
      out.write("\t        },\r\n");
      out.write("\t        success : function(data) {\r\n");
      out.write("\t        \t//alert(data);\r\n");
      out.write("\t        \t\r\n");
      out.write("\t        \tif (data.length > 0){\r\n");
      out.write("\t        \t\tfor(var n=0;n<data.length;n++){\r\n");
      out.write("\t                \tdocument.getElementById(\"capable\").options.add(new Option(data[n].roomcapacity,data[n].roomcapacity));\r\n");
      out.write("\t          \t\t}\r\n");
      out.write("\t          \t\tfuzzy();\r\n");
      out.write("\t        \t} else {\r\n");
      out.write("\t        \t\t\r\n");
      out.write("\t        \t}\r\n");
      out.write("\t        }  \r\n");
      out.write("\t    }); \r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("</script>\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write("h2{\r\n");
      out.write("margin-top: 20px;\r\n");
      out.write("}\r\n");
      out.write("#head{\r\n");
      out.write(" width: 99%;\r\n");
      out.write(" height:90px;\r\n");
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
      out.write("#address{\r\n");
      out.write("  font-size: 12px;\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("</head>\r\n");
      out.write("\t<body style=\"font-size: 12px;\">\r\n");
      out.write("\t<div id=\"head\">\r\n");
      out.write("\t      <div class=\"title\" ><br><br><div align=\"center\"><font face=\"微软雅黑\" color=\"#400000\" size=\"4\"><strong>条件选择</strong></font></div></div>\r\n");
      out.write("\t      <div class=\"search\" >\r\n");
      out.write("\t         <table cellpadding=\"0\" cellspacing=\"0\" class=\"l-table-edit\" >\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<!-- <td align=\"right\" class=\"l-table-edit-td\">&nbsp;教室名称:&nbsp;</td>\r\n");
      out.write("\t\t\t\t<td align=\"left\" class=\"l-table-edit-td\">\r\n");
      out.write("\t\t\t\t   <input id=\"roomname\" name=\"roomname\" value=\"\" />\r\n");
      out.write("\t\t\t\t</td>\r\n");
      out.write("\t\t\t    <td align=\"right\" class=\"l-table-edit-td\">&nbsp;&nbsp;教室容量:&nbsp;</td>\r\n");
      out.write("\t\t\t\t<td align=\"left\" class=\"l-table-edit-td\">\r\n");
      out.write("\t\t\t\t  <input id=\"roomcapacity\" class=\"link\" name=\"roomcapacity\" value=\"\"  />\r\n");
      out.write("\t\t\t\t</td> -->\r\n");
      out.write("\t\t\t\t<!-- <td align=\"right\" class=\"l-table-edit-td\">&nbsp;教室位置:&nbsp;</td>\r\n");
      out.write("\t\t\t\t<td align=\"left\" class=\"l-table-edit-td\">\r\n");
      out.write("\t\t\t\t   <input id=\"roomname\" name=\"roomname\" value=\"\" />\r\n");
      out.write("\t\t\t\t</td> -->\r\n");
      out.write("\t\t\t\t<!-- 用下拉框选取所有学院 -->\r\n");
      out.write("\t\t\t\t<td align=\"right\" class=\"l-table-edit-td\">&nbsp;教室位置:&nbsp;</td>\r\n");
      out.write("\t\t\t\t<td align=\"left\" class=\"l-table-edit-td\">\r\n");
      out.write("\t\t\t\t\t<select id=\"address\" class=\"link\" onchange=\"pChan()\" >\r\n");
      out.write("\t\t\t\t\t\t");

							List<Classroom> rooms = (List<Classroom>) ActionContext.getContext().get("allRooms");
							Set<String> place = new HashSet<String>();
							for (Classroom r : rooms){
							
								if (!place.contains(r.getRoomplace())){
									place.add(r.getRoomplace());
								
						 
      out.write("\r\n");
      out.write("\t\t\t\t\t\t \t<option value=\"");
      out.print(r.getRoomplace() );
      out.write('"');
      out.write('>');
      out.print(r.getRoomplace() );
      out.write(" </option>\r\n");
      out.write("\t\t\t\t\t\t ");

						 		}
						 	}
						  
      out.write("\r\n");
      out.write("\t\t\t\t\t</select>\r\n");
      out.write("\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t<td align=\"right\" class=\"l-table-edit-td\">&nbsp;教室类型:&nbsp;</td>\r\n");
      out.write("\t\t\t\t<td align=\"left\" class=\"l-table-edit-td\">\r\n");
      out.write("\t\t\t\t\t<select id=\"foo\" class=\"link\" onchange=\"pChan()\" >\r\n");
      out.write("\t\t\t\t\t\t");

							Set<String> set = new HashSet<String>();
							for (Classroom r : rooms){
							
								if (!set.contains(r.getRoomtype())){
									set.add(r.getRoomtype());
								
						 
      out.write("\r\n");
      out.write("\t\t\t\t\t\t \t<option value=\"");
      out.print(r.getRoomtype() );
      out.write('"');
      out.write('>');
      out.print(r.getRoomtype() );
      out.write(" </option>\r\n");
      out.write("\t\t\t\t\t\t ");

						 		}
						 	}
						  
      out.write("\r\n");
      out.write("\t\t\t\t\t</select>\r\n");
      out.write("\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t<td align=\"right\" class=\"l-table-edit-td\">&nbsp;&nbsp;教室容量:&nbsp;</td>\r\n");
      out.write("\t\t\t\t<td align=\"right\" class=\"l-table-edit-td\">\r\n");
      out.write("\t\t\t\t\t<select id=\"capable\" onchange=\"fuzzy()\" class=\"link\" ></select>\r\n");
      out.write("\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t<!--   <td align=\"right\" class=\"l-table-edit-td\">&nbsp;&nbsp;教室容量:&nbsp;</td>\r\n");
      out.write("\t\t\t\t<td align=\"left\" class=\"l-table-edit-td\">\r\n");
      out.write("\t\t\t\t  <input id=\"low\" class=\"link\" style=\"width:40px\"/>\r\n");
      out.write("\t\t\t\t  ~\r\n");
      out.write("\t\t\t\t  <input id=\"upper\" class=\"link\" style=\"width:40px\"/>\r\n");
      out.write("\t\t\t\t</td> -->\r\n");
      out.write("\t\t\t\t<!-- <td align=\"right\" class=\"l-table-edit-td\"></td>\r\n");
      out.write("\t\t\t\t<td align=\"left\" class=\"l-table-edit-td\"></td>\t -->\t\t\t\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t  <th colspan=\"6\"><div id=\"result1\"></div></th>\r\n");
      out.write("\t\t\t</tr>\t\t\t\t\t\t\r\n");
      out.write("\t\t</table>\r\n");
      out.write("\t\t<!-- <a class=\"l-button\" onclick=\"f_search()\"><strong>查&nbsp;&nbsp;询</strong></a> -->\r\n");
      out.write("\t\t<!-- <a class=\"l-button\" onclick=\"fuzzy()\"><strong>查&nbsp;&nbsp;询</strong></a> -->\r\n");
      out.write("\t      </div>\r\n");
      out.write("\t    </div>\t\t\t\r\n");
      out.write("\t\t<h2><font face=\"华文楷体\">查询结果显示：</font></h2>\t\t\t  \r\n");
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
}
