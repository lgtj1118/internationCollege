package org.apache.jsp.WEB_002dINF.student;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;

public final class assistantteachermanage_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write('\r');
      out.write('\n');

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
      out.write("\t<link href=\"js/ligerUI/skins/ligerui-icons.css\" rel=\"stylesheet\" type=\"text/css\">\r\n");
      out.write("\t<script src=\"js/ligerUI/plugins/ligerToolBar.js\" type=\"text/javascript\"></script>\r\n");
      out.write("    <script src=\"js/jquery/jquery-1.6.min.js\"type=\"text/javascript\"></script>\r\n");
      out.write("\t<script src=\"js/ligerUI/core/base.js\" type=\"text/javascript\"></script>\r\n");
      out.write("\t<script src=\"js/ligerUI/ligerui.all.js\" type=\"text/javascript\"></script>\r\n");
      out.write("\t<script src=\"js/ligerUI/plugins/ligerDateEditor.js\" type=\"text/javascript\"></script>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("    var ClassData = { \r\n");
      out.write("\tRows: [");
String s = (String) request.getAttribute("classlist");
      out.write(' ');
      out.print(s);
      out.write("]};\r\n");
      out.write("    var ClassList = ClassData.Rows;\r\n");
      out.write("    var sexData = [{ Sex: 1, text: '男' }, { Sex: 2, text: '女'}];\r\n");
      out.write("     var TypeData = [{ academictype: 0, text: '审核中' }, { academictype: 1, text: '批准'}, { academictype: 2, text: '未批准'}];\r\n");
      out.write("   $(f_initGrid);\r\n");
      out.write("\tvar manager, g;\r\n");
      out.write("\tfunction f_initGrid() {\r\n");
      out.write("\t\tg = manager = $(\"#maingrid\").ligerGrid(\r\n");
      out.write("\t\t\t{columns : [\r\n");
      out.write("\t\t\t{   display : '序号',  name : 'id',     minWidth : 40,  type : 'int',hide:true\r\n");
      out.write("\t\t\t},{display : '姓名', name : 'name', minWidth : 80,  editor:{type:'text'}\t}\r\n");
      out.write("\t\t\t,{display : '性别', name : 'gender', minWidth : 30,  editor:{type:'text'}\t}\r\n");
      out.write("\t\t\t, {display : '出生年月', name : 'brithdate',  minWidth : 100, editor: { type: 'text'}\r\n");
      out.write("\t\t\t}, {display : '民族', name : 'nation',  minWidth : 80, editor: { type: 'text'}\r\n");
      out.write("\t\t\t} ,{display : '政治面貌', name : 'politicalstatus',minWidth : 70,editor: { type: 'password'}\r\n");
      out.write("\t\t\t}, {display : '专业', name : 'major',minWidth : 100, editor: { type: 'text'}\r\n");
      out.write("\t\t\t}, {display : '学号', name : 'assistantnum',minWidth : 80, editor: { type: 'text'}\r\n");
      out.write("\t\t\t}, {display : '班级', name : 'classname',minWidth : 80, editor: { type: 'text'}\r\n");
      out.write("\t\t\t}, {display : '教育层次', name : 'edulevel',minWidth : 80, editor: { type: 'text'}\r\n");
      out.write("\t\t\t} ,{display : '所在学院', name : 'department', minWidth : 80,  editor:{type:'text'}\r\n");
      out.write("\t\t\t} ,{display : '负责人',  minWidth : 120,columns:[\r\n");
      out.write("\t\t\t   {display:'姓名',name:'responsiblename',minWidth:80},\r\n");
      out.write("\t\t\t   {display:'电话',name:'responsibletelephone'}\r\n");
      out.write("\t\t\t]\r\n");
      out.write("\t\t\t} ,{display : '外语语种', name : 'secondlanguagetype', minWidth : 80,  editor:{type:'text'}\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t} ,{display : '外语等级', name : 'secondlanguagelevel', minWidth : 80,  editor:{type:'text'} \r\n");
      out.write("            } ,{display : '联系方式', name : 'telephone', minWidth : 120,  editor:{type:'text'}\r\n");
      out.write("            } ,{display : '邮箱', name : 'email', minWidth : 140,  editor:{type:'text'}\r\n");
      out.write("            } ,{display : '负责班级', name : 'assistclass', minWidth : 140,  editor:{type:'text'}\t}           \r\n");
      out.write("            /* ,{display : '学校意见', name : 'academictype', minWidth : 120,  editor: { type: 'select', data: TypeData, valueField: 'academictype' },\r\n");
      out.write("                    render: function (item)\r\n");
      out.write("                    {\r\n");
      out.write("                        if (parseInt(item.academictype) == 0){ var h=\"<span style='color:red;'>审核中</span>\" ;return h;}\r\n");
      out.write("                        else if (parseInt(item.academictype) == 1) { var h=\"<span style='color:red;'>批准</span>\" ;return h;}\r\n");
      out.write("                        else if (parseInt(item.academictype) == 2) { var h=\"<span style='color:red;'>未批准</span>\" ;return h;}\r\n");
      out.write("                        \r\n");
      out.write("                    }}   */ ],\r\n");
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
      out.write("/system/Class_assistlist.action',\r\n");
      out.write("\t\t\t\t\twidth : '100%',\r\n");
      out.write("\t\t\t\t\ttoolbar: { items: [{ text: '录入',click: applyassist,  icon: 'add' },\r\n");
      out.write("\t\t\t\t\t                   { text: '修改',click: editassist,  icon: 'edit' },\r\n");
      out.write("\t\t\t\t\t                   { text: '删除',click: deleteassist,  icon: 'delete' }\t\t\t\t                   \r\n");
      out.write("\t\t\t\t\t                   ]}\r\n");
      out.write("\t\t\t\t});\r\n");
      out.write("\t}\t \r\n");
      out.write("\tvar m;\r\n");
      out.write("\tfunction apply(){\r\n");
      out.write("\tvar row = manager.getSelectedRow();\r\n");
      out.write("\t\tif (!row) {\r\n");
      out.write("\t\t\talert('请选择至少一项！');\r\n");
      out.write("\t\t\treturn;\r\n");
      out.write("\t\t}\r\n");
      out.write("    if(row.academictype==1||row.academictype==2){\r\n");
      out.write("       alert('该项已审核！');\r\n");
      out.write("    }else{\r\n");
      out.write("       $.post(\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/system/Class_assistagree.action?assistantteacher.id=\"+row.id,null,function(){\r\n");
      out.write("         alert('提交成功！');\r\n");
      out.write("         g.loadData();\r\n");
      out.write("       });\r\n");
      out.write("    }\r\n");
      out.write("\t}\r\n");
      out.write("\tfunction against(){\r\n");
      out.write("\tvar row = manager.getSelectedRow();\r\n");
      out.write("\t\tif (!row) {\r\n");
      out.write("\t\t\talert('请选择至少一项！');\r\n");
      out.write("\t\t\treturn;\r\n");
      out.write("\t\t}\r\n");
      out.write("    if((row.academictype==1)||(row.academictype==2)){\r\n");
      out.write("       alert('该项已审核或驳回！');\r\n");
      out.write("    }else{\r\n");
      out.write("       $.post(\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/system/Class_assistagainst.action?assistantteacher.id=\"+row.id,null,function(){\r\n");
      out.write("         alert('提交成功！');\r\n");
      out.write("         g.loadData();\r\n");
      out.write("       });\r\n");
      out.write("    }\r\n");
      out.write("\t}\r\n");
      out.write("\tfunction print(){\r\n");
      out.write("\t  var row = manager.getSelectedRow();\r\n");
      out.write("\t  if(row.academictype==1){\r\n");
      out.write("\t    var str = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/system/Class_assistprint.action?assistantteacher.id=\"+row.id;\r\n");
      out.write("\t    window.open(str);\r\n");
      out.write("\t  }else{\r\n");
      out.write("\t     alert(\"请先审核通过再打印！\");\r\n");
      out.write("\t  }\r\n");
      out.write("\t  \r\n");
      out.write("\t}\r\n");
      out.write("\tvar m;\r\n");
      out.write("\tfunction applyassist(){\t\r\n");
      out.write("\tvar str = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/system/Class_assistapply.action\";\r\n");
      out.write("\t\tm=$.ligerDialog.open({\r\n");
      out.write("\t\t\turl : str,\r\n");
      out.write("\t\t\theight : 600,\r\n");
      out.write("\t\t\twidth : 750,\r\n");
      out.write("\t\t\tisDrag:true,\r\n");
      out.write("\t\t\tshowMax:true,\r\n");
      out.write("\t\t\tshowToggle:true,\r\n");
      out.write("\t\t\tslide: false,\t\t\t\r\n");
      out.write("\t\t\tmodal:false,\r\n");
      out.write("\t\t\tleft:200,\r\n");
      out.write("\t\t\ttitle:'助理班主任申请',\r\n");
      out.write("\t\t\tallowClose:true,\r\n");
      out.write("\t\t    isResize : false\r\n");
      out.write("\t\t});\t\t\r\n");
      out.write("\t}\r\n");
      out.write("\tfunction editassist(){\t\r\n");
      out.write("\tvar row = manager.getSelectedRow();\r\n");
      out.write("\tif (!row) {alert('请选择至少一项！');return;}\r\n");
      out.write("\tvar str = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/system/Class_assistedit.action?assistantteacher.id=\"+row.id;\r\n");
      out.write("\t\tm=$.ligerDialog.open({\r\n");
      out.write("\t\t\turl : str,\r\n");
      out.write("\t\t\theight : 600,\r\n");
      out.write("\t\t\twidth : 750,\r\n");
      out.write("\t\t\tisDrag:true,\r\n");
      out.write("\t\t\tshowMax:true,\r\n");
      out.write("\t\t\tshowToggle:true,\r\n");
      out.write("\t\t\tslide: false,\t\t\t\r\n");
      out.write("\t\t\tmodal:false,\r\n");
      out.write("\t\t\tleft:200,\r\n");
      out.write("\t\t\ttitle:'助理班主任修改',\r\n");
      out.write("\t\t\tallowClose:true,\r\n");
      out.write("\t\t    isResize : false\r\n");
      out.write("\t\t});\t\t\r\n");
      out.write("\t}\r\n");
      out.write("\tfunction deleteassist(){\r\n");
      out.write("\t  var row = manager.getSelectedRow();\r\n");
      out.write("\t  if (!row) {alert('请选择至少一项！');return;}\r\n");
      out.write("\t  $.ligerDialog.confirm('确认删除该助理班主任？', function (yes){\r\n");
      out.write("       if(yes){\t\r\n");
      out.write("          $.ligerDialog.prompt('请输入确认密码', function (yes, value){\r\n");
      out.write("                   if (yes){ //验证密码\r\n");
      out.write("                        var userid = ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${sessionScope.user.id}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write(";\r\n");
      out.write("                        $.post(\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/system/User_pwdcheck.action?user.id=\"+ userid\r\n");
      out.write("\t\t                +\"&user.password=\"+value , null, function(data) {\r\n");
      out.write("\t\t\t\t\t       if (data == \"fail\") {\r\n");
      out.write("\t\t\t\t\t\t     alert(\"输入的密码不正确!\");\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t       } else {\r\n");
      out.write("\t                         if(row.assistclass.length==0){\r\n");
      out.write("\t                            $.post(\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/system/Class_assistdelete.action?assistantteacher.id=\"+row.id,null,function(){\r\n");
      out.write("\t                              // window.location.reload();\r\n");
      out.write("\t                              g.loadData();\r\n");
      out.write("\t                            })\r\n");
      out.write("\t                         }else{\r\n");
      out.write("\t                            alert(\"该生已分配管理班级，不能删除,如需删除，请先重新设置相关班级助理班主任！\");\r\n");
      out.write("\t                         }\r\n");
      out.write("\t                       }\r\n");
      out.write("\t                   });\r\n");
      out.write("\t                }\r\n");
      out.write("\t      });\r\n");
      out.write("\t   }\r\n");
      out.write("\t   });\r\n");
      out.write("\t   }\r\n");
      out.write("</script>\r\n");
      out.write("\t</head>\r\n");
      out.write("\t<body style=\"padding: 2px\">\r\n");
      out.write("\t <!-- <a class=\"l-button\" style=\"width:70px;float:left; margin:3px;\" onclick=\"applyassist()\">录&nbsp;&nbsp;入</a>\r\n");
      out.write("\t <a class=\"l-button\" style=\"width:70px;float:left; margin:3px;\" onclick=\"editassist()\">修&nbsp;&nbsp;改</a>\r\n");
      out.write("\t <a class=\"l-button\" style=\"width:70px;float:left; margin:3px;\" onclick=\"deleteassist()\">删&nbsp;&nbsp;除</a> -->\r\n");
      out.write("\t <!-- <a class=\"l-button\" style=\"width:70px;float:left; margin:3px;\" onclick=\"apply()\">批&nbsp;&nbsp;准</a>\r\n");
      out.write("\t <a class=\"l-button\" style=\"width:70px;float:left; margin:3px;\" onclick=\"against()\">驳&nbsp;&nbsp;回</a>   \r\n");
      out.write("\t <a class=\"l-button\" style=\"width:70px;float:left; margin:3px;\" onclick=\"print()\">打&nbsp;&nbsp;印</a>  -->   \r\n");
      out.write("\t\t<div class=\"l-clear\"></div>\r\n");
      out.write("\t\t<div id=\"maingrid\" style=\"\" ></div>\r\n");
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
