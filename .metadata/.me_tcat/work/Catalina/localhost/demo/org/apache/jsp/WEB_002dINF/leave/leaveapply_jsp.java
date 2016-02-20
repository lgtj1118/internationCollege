package org.apache.jsp.WEB_002dINF.leave;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;

public final class leaveapply_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\r\n");
      out.write("\r\n");
      out.write("<html xmlns=\"http://www.w3.org/1999/xhtml\">\r\n");
      out.write("\t<head>\r\n");
      out.write("\t<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\r\n");
      out.write("\t\t<title>班级列表</title>\r\n");
      out.write("\t<link href=\"");
      out.print(basePath);
      out.write("js/ligerUI/skins/Aqua/css/ligerui-all.css\" rel=\"stylesheet\"type=\"text/css\" />\t\r\n");
      out.write("\t<link href=\"");
      out.print(basePath );
      out.write("js/ligerUI/skins/Gray/css/all.css\" rel=\"stylesheet\" type=\"text/css\"/>\t\r\n");
      out.write("    <script type=\"text/javascript\" src=\"");
      out.print(basePath );
      out.write("js/jquery-validation/jquery.validate.min.js\" charset=\"utf-8\"></script>\r\n");
      out.write("    <script type=\"text/javascript\" src=\"");
      out.print(basePath );
      out.write("js/json2.js\" charset=\"utf-8\"></script>\r\n");
      out.write("    <script type=\"text/javascript\" src=\"");
      out.print(basePath );
      out.write("js/jquery-validation/jquery.metadata.js\" charset=\"utf-8\"></script>\r\n");
      out.write("    <script type=\"text/javascript\" src=\"");
      out.print(basePath );
      out.write("js/jquery-validation/messages_cn.js\" charset=\"utf-8\"></script>\r\n");
      out.write("    <script type=\"text/javascript\" src=\"");
      out.print(basePath );
      out.write("js/ligerUI/plugins/ligerTab.js\"></script>\r\n");
      out.write("    <script type=\"text/javascript\" src=\"");
      out.print(basePath );
      out.write("js/jquery/jquery-1.3.2.min.js\"></script>\r\n");
      out.write("\t<script src=\"");
      out.print(basePath );
      out.write("js/ligerUI/core/base.js\" type=\"text/javascript\"></script>\r\n");
      out.write("\t<script src=\"");
      out.print(basePath );
      out.write("js/ligerUI/ligerui.all.js\" type=\"text/javascript\"></script>\t\r\n");
      out.write("\t<script type=\"text/javascript\">\r\n");
      out.write("\tvar TypeData = [{ type: 1, text: '短假' }, { type: 2, text: '长假'}];\r\n");
      out.write("    var StatusData = [{ status: 0, text: '审核中' }, { status: 1, text: '批准'}, { status: 2, text: '未批准'}, { status: 3, text: '已销假'}];  \r\n");
      out.write("   $(f_initGrid);\r\n");
      out.write("\tvar manager, g;\r\n");
      out.write("\tfunction f_initGrid() {\r\n");
      out.write("\t\tg = manager = $(\"#maingrid\").ligerGrid(\r\n");
      out.write("\t\t\t{columns : [\r\n");
      out.write("\t\t\t{  display : '序号',  name : 'id',     width : 40,  type : 'int',hide:true\r\n");
      out.write("\t\t\t},{display : '护照号', name : 'passport',  minWidth : 120, editor: { type: 'text'}\r\n");
      out.write("\t\t\t},{display : '姓名', name : 'stuname',minWidth : 80, editor: { type: 'text'}\r\n");
      out.write("\t\t\t},{display : '电话', name : 'telephone', minWidth : 100,  editor:{type:'text'} \r\n");
      out.write("            },{display : '请假时间', name : 'applydate', minWidth : 100,  editor:{type:'text'}\t           \t\t\t\t\r\n");
      out.write("\t\t\t},{display : '开始时间', name : 'leavingdate', minWidth : 100,  editor:{type:'text'}\t\t\t\t\r\n");
      out.write("\t\t\t},{display : '截止时间', name : 'backdate', minWidth : 100,  editor:{type:'text'}\t\r\n");
      out.write("\t\t\t} ,{display : '请假事由', name : 'leavereason', minWidth : 100,  editor:{type:'text'}\t\r\n");
      out.write("\t\t\t} ,{display : '请假时长', name : 'type', minWidth : 100,  editor: { type: 'select', data: TypeData, valueField: 'type' },\r\n");
      out.write("                    render: function (item)\r\n");
      out.write("                    {\r\n");
      out.write("                        if (parseInt(item.type) == 1){ return '短假';}\r\n");
      out.write("                        else if (parseInt(item.type) == 2) { return '长假';}              \r\n");
      out.write("                    }\r\n");
      out.write("           } ,{display : '状态', name : 'status', minWidth : 100,  editor: { type: 'select', data: StatusData, valueField: 'status' },\r\n");
      out.write("                    render: function (item)\r\n");
      out.write("                    {\r\n");
      out.write("                        if (parseInt(item.status) == 0){ var h=\"<span style='color:red;'>审核中</span>\" ;return h;}                       \r\n");
      out.write("                        else if (parseInt(item.status) == 1) { var h=\"<span style='color:red;'>教学办审核中</span>\" ;return h;}\r\n");
      out.write("                        else if (parseInt(item.status) == 2) { var h=\"<span style='color:red;'>院领导审核中</span>\" ;return h;}  \r\n");
      out.write("                        else if (parseInt(item.status) == 3) { var h=\"<span style='color:green;'>批准</span>\" ;return h;}\r\n");
      out.write("                        else if (parseInt(item.status) == 4) { var h=\"<span style='color:orange;'>未批准</span>\" ;return h;}  \r\n");
      out.write("                        else if (parseInt(item.status) == 5) { var h=\"<span style='color:blue;'>已销假</span>\" ;return h;}                             \r\n");
      out.write("                   }}],\r\n");
      out.write("\t\t\tonSelectRow : function(rowdata, rowindex) {\r\n");
      out.write("\t\t\t\t$(\"#txtrowindex\").val(rowindex);\r\n");
      out.write("\t\t\t},\r\n");
      out.write("\t\t\t\tcheckbox:true,\r\n");
      out.write("\t\t\t\tenabledEdit : true,\r\n");
      out.write("\t\t\t\tclickToEdit : false,\r\n");
      out.write("\t\t\t\tisScroll : false,\r\n");
      out.write("\t\t\t\trownumbers:true, \r\n");
      out.write("\t\t\t\tpageSize:30,\r\n");
      out.write("\t\t\t\turl :'");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/system/Manage_stuloadleave.action',\r\n");
      out.write("\t\t\t\twidth : '100%'\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t}\r\n");
      out.write("    function shortleave(){\r\n");
      out.write("\t   var str = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/system/Manage_shortleave.action\";\r\n");
      out.write("\t   m=$.ligerDialog.open({\r\n");
      out.write("\t\t\turl : str,\r\n");
      out.write("\t\t\theight : 500,\r\n");
      out.write("\t\t\twidth : 650,\r\n");
      out.write("\t\t\ttitle:'短期请假',\r\n");
      out.write("\t\t\tisDrag:true,\r\n");
      out.write("\t\t\tshowMax:true,\r\n");
      out.write("\t\t\tshowToggle:true,\r\n");
      out.write("\t\t\tslide: false,\t\t\t\r\n");
      out.write("\t\t\tmodal:false,\r\n");
      out.write("\t\t\tleft:200,\r\n");
      out.write("\t\t\tallowClose:true,\r\n");
      out.write("\t\t    isResize : false\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\t\r\n");
      out.write("\t}\r\n");
      out.write("\tfunction longleave(){\r\n");
      out.write("\t   var str = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/system/Manage_longleave.action\";\r\n");
      out.write("\t   m=$.ligerDialog.open({\r\n");
      out.write("\t\t\turl : str,\r\n");
      out.write("\t\t\theight : 500,\r\n");
      out.write("\t\t\twidth : 650,\r\n");
      out.write("\t\t\ttitle:'长期请假',\r\n");
      out.write("\t\t\tisDrag:true,\r\n");
      out.write("\t\t\tshowMax:true,\r\n");
      out.write("\t\t\tshowToggle:true,\r\n");
      out.write("\t\t\tslide: false,\t\t\t\r\n");
      out.write("\t\t\tmodal:false,\r\n");
      out.write("\t\t\tleft:200,\r\n");
      out.write("\t\t\tallowClose:true,\r\n");
      out.write("\t\t    isResize : false\r\n");
      out.write("\t\t});\r\n");
      out.write("\t \r\n");
      out.write("\t}\r\n");
      out.write("\tfunction print(){\r\n");
      out.write("\t   var row = manager.getSelectedRow(); \r\n");
      out.write("\t   if(!row){\r\n");
      out.write("\t     alert(\"请先选择一项！\");\r\n");
      out.write("\t     return ;\r\n");
      out.write("\t   }\r\n");
      out.write("\t   if(row.status==3){\r\n");
      out.write("\t     var str = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/system/Manage_leaveprint.action?leave.id=\"+row.id;\r\n");
      out.write("\t     window.open(str);\r\n");
      out.write("\t   }else if(row.status==0||row.status==1||row.status==2) {\r\n");
      out.write("\t     alert(\"该请假还未处理，请审核通过后打印！\");\r\n");
      out.write("\t   }else{\r\n");
      out.write("\t     alert(\"该请假不能打印！\");\r\n");
      out.write("\t   }\r\n");
      out.write("\t   \r\n");
      out.write("\t}\r\n");
      out.write("\tfunction leaveedit(){\r\n");
      out.write("\t   var row = manager.getSelectedRow();\r\n");
      out.write("\t   if(!row){alert(\"请先选择一项！\");return ;}\r\n");
      out.write("\t   if(row.status==0){\r\n");
      out.write("\t     var str = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/system/Manage_leaveedit.action?leave.id=\"+row.id;\r\n");
      out.write("         m=$.ligerDialog.open({\r\n");
      out.write("\t\t\turl : str,\r\n");
      out.write("\t\t\theight : 500,\r\n");
      out.write("\t\t\twidth : 650,\r\n");
      out.write("\t\t\ttitle:'请假修改',\r\n");
      out.write("\t\t\tisDrag:true,\r\n");
      out.write("\t\t\tshowMax:true,\r\n");
      out.write("\t\t\tshowToggle:true,\r\n");
      out.write("\t\t\tslide: false,\t\t\t\r\n");
      out.write("\t\t\tmodal:false,\r\n");
      out.write("\t\t\tleft:200,\r\n");
      out.write("\t\t\tallowClose:true,\r\n");
      out.write("\t\t    isResize : false\r\n");
      out.write("\t\t});\r\n");
      out.write("\t   }else{\r\n");
      out.write("\t     alert(\"请假已处理不能修改！\");\r\n");
      out.write("\t   }\r\n");
      out.write("\t}\r\n");
      out.write("\tfunction leavecancel(){\r\n");
      out.write("\t   var row = manager.getSelectedRow();\r\n");
      out.write("\t   if(!row){alert(\"请先选择一项！\");return ;}\r\n");
      out.write("\t   if(row.status==0){\r\n");
      out.write("\t   $.ligerDialog.confirm('确认取消该请假？', function (yes){\r\n");
      out.write("\t      $.post(\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/system/Manage_leavedelete.action?leave.id=\"+row.id,null,function(){\r\n");
      out.write("\t        window.location.reload();\r\n");
      out.write("\t      });\r\n");
      out.write("\t      });\r\n");
      out.write("\t   }else{\r\n");
      out.write("\t     alert(\"请假已处理不能取消！\");\r\n");
      out.write("\t   }\r\n");
      out.write("\t}\r\n");
      out.write("\tfunction reloadthistab() {\r\n");
      out.write("\t\tg.reload();\r\n");
      out.write("\t}\r\n");
      out.write("</script>\r\n");
      out.write("\t</head>\r\n");
      out.write("\t<body style=\"padding: 2px\">\r\n");
      out.write("\t\t\t<a class=\"l-button\" style=\"width:100px;float:left; margin:3px;\" onclick=\"shortleave()\">短期请假申请</a>\r\n");
      out.write("\t\t\t<a class=\"l-button\" style=\"width:100px;float:left; margin:3px;\" onclick=\"longleave()\">长期请假申请</a>\r\n");
      out.write("\t\t\t<a class=\"l-button\" style=\"width:80px;float:left; margin:3px;\" onclick=\"leaveedit()\">修&nbsp;&nbsp;改</a>\r\n");
      out.write("\t\t\t<a class=\"l-button\" style=\"width:80px;float:left; margin:3px;\" onclick=\"leavecancel()\">取&nbsp;&nbsp;消</a>\r\n");
      out.write("\t\t\t<a class=\"l-button\" style=\"width:60px;float:left; margin:3px;\" onclick=\"print()\">打&nbsp;&nbsp;印</a>\t\r\n");
      out.write("<!-- \t\t\t<a class=\"l-button\" style=\"width:60px;float:left; margin:3px;\" onclick=\"reloadthistab()\">reload</a>\t -->\t\r\n");
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
