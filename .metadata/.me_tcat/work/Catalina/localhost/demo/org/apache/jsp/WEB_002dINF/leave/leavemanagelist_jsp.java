package org.apache.jsp.WEB_002dINF.leave;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;

public final class leavemanagelist_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("var TypeData = [{ type: 1, text: '短假' }, { type: 2, text: '长假'}];\r\n");
      out.write("var StatusData = [{ status: 0, text: '审核中' }, { status: 1, text: '教学办审核中'}, { status: 2, text: '学院审核中'}, { status: 3, text: '批准'}, { status: 4, text: '未批准'}, { status: 5, text: '已销假'}, { status: 4, text: '学院审核中'}];\r\n");
      out.write("\r\n");
      out.write("   $(f_initGrid);\r\n");
      out.write("\tvar manager, g;\r\n");
      out.write("\tfunction f_initGrid() {\r\n");
      out.write("\t\tg = manager = $(\"#maingrid\").ligerGrid(\r\n");
      out.write("\t\t\t{columns : [\r\n");
      out.write("\t\t\t{  display : '序号',  name : 'id',     width : 40,  type : 'int',hide:true\r\n");
      out.write("\t\t\t},{display : '护照号', name : 'passport',  minWidth : 120, editor: { type: 'text'}\r\n");
      out.write("\t\t\t},{display : '姓名', name : 'stuname',minWidth : 80, editor: { type: 'text'}\r\n");
      out.write("\t\t\t},{display : '班级', name : 'classname',minWidth : 80, editor: { type: 'text'}\r\n");
      out.write("\t\t\t},{display : '电话', name : 'telephone', minWidth : 100,  editor:{type:'text'} \r\n");
      out.write("            },{display : '请假时间', name : 'applydate', minWidth : 100,  editor:{type:'text'}\t           \t\t\t\t\r\n");
      out.write("\t\t\t},{display : '开始时间', name : 'leavingdate', minWidth : 100,  editor:{type:'text'}\t\t\t\t\r\n");
      out.write("\t\t\t},{display : '截止时间', name : 'backdate', minWidth : 100,  editor:{type:'text'}\t\r\n");
      out.write("\t\t\t} ,{display : '请假事由', name : 'leavereason', minWidth : 100,  editor:{type:'textarea'}\t\r\n");
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
      out.write("                        else if (parseInt(item.status) == 5) { var h=\"<span style='color:blue;'>已销假</span>\" ;return h;}                 \r\n");
      out.write("                   }},{display : '附件', name : 'doc', minWidth : 100,  editor:{type:'text'}}],\r\n");
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
      out.write("/system/Manage_loadstuleave.action',\r\n");
      out.write("\t\t\t\twidth : '100%'\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t}\r\n");
      out.write("\tfunction approval(){\r\n");
      out.write("\t  var row = manager.getSelectedRow();\r\n");
      out.write("\t\tif (!row) {\r\n");
      out.write("\t\t\talert('请选择一项！');\r\n");
      out.write("\t\t\treturn;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t  var status = row.status;\r\n");
      out.write("\t  var userrow = ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${session.user.roles.rolerank}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write(";\r\n");
      out.write("\t  if(userrow==2){\r\n");
      out.write("\t    if(status==0){\r\n");
      out.write("\t     var str = 1;\r\n");
      out.write("\t     $.post(\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/system/Manage_stuleaveupdate.action?leave.id=\"+row.id+\"&leave.status=\"+str,null,function(){\r\n");
      out.write("\t         alert(\"提交成功！\");\r\n");
      out.write("\t         g.loadData();\r\n");
      out.write("\t     });\r\n");
      out.write("\t   }else{\r\n");
      out.write("\t    alert(\"请确认请假状态！\");\r\n");
      out.write("\t   }\r\n");
      out.write("\t  }else if(userrow==0){//院领导\r\n");
      out.write("\t    if(row.type==2){\r\n");
      out.write("\t      if(status==2){\r\n");
      out.write("\t        var str = 3;\r\n");
      out.write("\t          $.post(\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/system/Manage_stuleaveupdate.action?leave.id=\"+row.id+\"&leave.status=\"+str,null,function(){\r\n");
      out.write("\t             alert(\"提交成功！\");\r\n");
      out.write("\t             g.loadData();\r\n");
      out.write("\t          });\r\n");
      out.write("\t      }else if(status==0||status==1) {\r\n");
      out.write("\t        alert(\"教务处处理后方可处理！\");\r\n");
      out.write("\t      }else{\r\n");
      out.write("\t         alert(\"该请假已处理！\");\r\n");
      out.write("\t      }\r\n");
      out.write("\t    }else{\r\n");
      out.write("\t      alert(\"无需处理短期请假！\");\r\n");
      out.write("\t    }\t    \r\n");
      out.write("\t  }else if(userrow==1){//教学办\r\n");
      out.write("\t    if(row.type==1){\r\n");
      out.write("\t       if(status==1||status==0){\r\n");
      out.write("\t          var str = 3;\r\n");
      out.write("\t          $.post(\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/system/Manage_stuleaveupdate.action?leave.id=\"+row.id+\"&leave.status=\"+str,null,function(){\r\n");
      out.write("\t             alert(\"提交成功！\");\r\n");
      out.write("\t             g.loadData();\r\n");
      out.write("\t          });\r\n");
      out.write("\t       }else{\r\n");
      out.write("\t         alert(\"该请假已处理！\");\r\n");
      out.write("\t       }\r\n");
      out.write("\t    }else{\r\n");
      out.write("\t       if(status==1||status==0){\r\n");
      out.write("\t         var str = 2;\r\n");
      out.write("\t         $.post(\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/system/Manage_stuleaveupdate.action?leave.id=\"+row.id+\"&leave.status=\"+str,null,function(){\r\n");
      out.write("\t             alert(\"提交成功！\");\r\n");
      out.write("\t             g.loadData();\r\n");
      out.write("\t         });\r\n");
      out.write("\t         }else{\r\n");
      out.write("\t            alert(\"该请假已处理！\");\r\n");
      out.write("\t         }\r\n");
      out.write("\t       }\t    \t    \r\n");
      out.write("\t   }\t  \t  \r\n");
      out.write("\t}\r\n");
      out.write("\tfunction nonapproval(){\r\n");
      out.write("\t  var row = manager.getSelectedRow();\r\n");
      out.write("\t\tif (!row) {\r\n");
      out.write("\t\t\talert('请选择一项！');\r\n");
      out.write("\t\t\treturn;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t  var status = row.status;\r\n");
      out.write("\t  if(status==0){\r\n");
      out.write("\t     var str = 4;\r\n");
      out.write("\t     $.post(\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/system/Manage_stuleaveupdate.action?leave.id=\"+row.id+\"&leave.status=\"+str,null,function(){\r\n");
      out.write("\t     alert(\"提交成功！\");\r\n");
      out.write("\t     g.loadData();\r\n");
      out.write("\t  });\r\n");
      out.write("\t  }else{\r\n");
      out.write("\t    alert(\"该确认请假状态！\");\r\n");
      out.write("\t  }\r\n");
      out.write("\t  \r\n");
      out.write("\t}\r\n");
      out.write("\tfunction cancelleave(){\r\n");
      out.write("\t  var row = manager.getSelectedRow();\r\n");
      out.write("\t  if (!row) {alert('请选择一项！');return;}\r\n");
      out.write("\t  var status = row.status;\r\n");
      out.write("\t  if(status==3){\r\n");
      out.write("\t    var str = 5;\r\n");
      out.write("\t    $.post(\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/system/Manage_stuleaveupdate.action?leave.id=\"+row.id+\"&leave.status=\"+str,null,function(){\r\n");
      out.write("\t    alert(\"提交成功！\");\r\n");
      out.write("\t    g.loadData();\r\n");
      out.write("\t  });\r\n");
      out.write("\t  }else{\r\n");
      out.write("\t    alert(\"请先确认请假状态！\");\r\n");
      out.write("\t  } \r\n");
      out.write("\t  \r\n");
      out.write("\t}\r\n");
      out.write("    function deleteleave() {\r\n");
      out.write("\tvar row = manager.getSelectedRow();\r\n");
      out.write("\tif (!row) {alert('请选择一项！');return;}\r\n");
      out.write("\tif(row.status==0||row.status==1||row.status==2){\r\n");
      out.write("\t   $.ligerDialog.confirm('该请假还未审核，确认删除吗？', function (yes){\r\n");
      out.write("        if(yes){\t\r\n");
      out.write("\t     $.post(\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/system/Manage_leavedelete.action?leave.id=\"\r\n");
      out.write("\t\t\t\t+ row.id,null,function(){\r\n");
      out.write("\t\t\t\t\t manager.deleteSelectedRow();\r\n");
      out.write("\t\t\t\t\t manager.loadData();\r\n");
      out.write("\t\t\t\t});\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t});\r\n");
      out.write("\t}else if(row.status==3){\r\n");
      out.write("\t   alert(\"该请假还未销假，不能删除！\");\r\n");
      out.write("\t}else{\r\n");
      out.write("\t   $.ligerDialog.confirm('确认删除吗？', function (yes){\r\n");
      out.write("        if(yes){\t\r\n");
      out.write("\t     $.post(\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/system/Manage_leavedelete.action?leave.id=\"\r\n");
      out.write("\t\t\t\t+ row.id,null,function(){\r\n");
      out.write("\t\t\t\t\t manager.deleteSelectedRow();\r\n");
      out.write("\t\t\t\t\t manager.loadData();\r\n");
      out.write("\t\t\t\t});\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t});\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\t}\t\r\n");
      out.write("</script>\r\n");
      out.write("\t</head>\r\n");
      out.write("\t<body style=\"padding: 2px\">\r\n");
      out.write("\t");
      if (_jspx_meth_s_005fif_005f0(_jspx_page_context))
        return;
      out.write('\r');
      out.write('\n');
      out.write('	');
      if (_jspx_meth_s_005felseif_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t <div class=\"l-clear\"></div>\r\n");
      out.write("\t <div id=\"maingrid\" ></div>\r\n");
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

  private boolean _jspx_meth_s_005fif_005f0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  s:if
    org.apache.struts2.views.jsp.IfTag _jspx_th_s_005fif_005f0 = (org.apache.struts2.views.jsp.IfTag) _005fjspx_005ftagPool_005fs_005fif_005ftest.get(org.apache.struts2.views.jsp.IfTag.class);
    _jspx_th_s_005fif_005f0.setPageContext(_jspx_page_context);
    _jspx_th_s_005fif_005f0.setParent(null);
    // /WEB-INF/leave/leavemanagelist.jsp(191,1) name = test type = java.lang.String reqTime = false required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_s_005fif_005f0.setTest("#session.user.roles.rolerank==0||#session.user.roles.rolerank==1");
    int _jspx_eval_s_005fif_005f0 = _jspx_th_s_005fif_005f0.doStartTag();
    if (_jspx_eval_s_005fif_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      if (_jspx_eval_s_005fif_005f0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.pushBody();
        _jspx_th_s_005fif_005f0.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
        _jspx_th_s_005fif_005f0.doInitBody();
      }
      do {
        out.write("\r\n");
        out.write("\t<a class=\"l-button\" style=\"width:70px;float:left; margin:3px;\" onclick=\"approval()\">批&nbsp;&nbsp;准</a>\r\n");
        out.write("\t    <a class=\"l-button\" style=\"width:70px;float:left; margin:3px;\" onclick=\"nonapproval()\">不批准</a>\r\n");
        out.write("\t    <a class=\"l-button\" style=\"width:70px;float:left; margin:3px;\" onclick=\"cancelleave()\">销&nbsp;&nbsp;假</a>\r\n");
        out.write("\t    <a class=\"l-button\" style=\"width:70px;float:left; margin:3px;\" onclick=\"deleteleave()\">删&nbsp;&nbsp;除</a>\t\t\t\r\n");
        out.write("\t");
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
    // /WEB-INF/leave/leavemanagelist.jsp(197,1) name = test type = java.lang.String reqTime = false required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_s_005felseif_005f0.setTest("#session.user.roles.rolerank==2");
    int _jspx_eval_s_005felseif_005f0 = _jspx_th_s_005felseif_005f0.doStartTag();
    if (_jspx_eval_s_005felseif_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      if (_jspx_eval_s_005felseif_005f0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.pushBody();
        _jspx_th_s_005felseif_005f0.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
        _jspx_th_s_005felseif_005f0.doInitBody();
      }
      do {
        out.write("\r\n");
        out.write("\t    <a class=\"l-button\" style=\"width:70px;float:left; margin:3px;\" onclick=\"approval()\">批&nbsp;&nbsp;准</a>\r\n");
        out.write("\t    <a class=\"l-button\" style=\"width:70px;float:left; margin:3px;\" onclick=\"nonapproval()\">不批准</a>\r\n");
        out.write("\t    <a class=\"l-button\" style=\"width:70px;float:left; margin:3px;\" onclick=\"cancelleave()\">销&nbsp;&nbsp;假</a>\r\n");
        out.write("\t    <a class=\"l-button\" style=\"width:70px;float:left; margin:3px;\" onclick=\"deleteleave()\">删&nbsp;&nbsp;除</a>\t\t\t\r\n");
        out.write("\t");
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
