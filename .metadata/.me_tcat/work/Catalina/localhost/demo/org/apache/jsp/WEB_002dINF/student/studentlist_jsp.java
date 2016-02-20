package org.apache.jsp.WEB_002dINF.student;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;

public final class studentlist_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("     <link href=\"js/ligerUI/skins/ligerui-icons.css\" rel=\"stylesheet\" type=\"text/css\">\r\n");
      out.write("    <script src=\"js/jquery/jquery-1.3.2.min.js\" type=\"text/javascript\"></script>\r\n");
      out.write("    <script src=\"js/json2.js\" type=\"text/javascript\"></script>\r\n");
      out.write("    <script src=\"js/ligerUI/ligerui.all.js\" type=\"text/javascript\"></script>\r\n");
      out.write("    <script src=\"js/ligerUI/js/core/base.js\" type=\"text/javascript\"></script>\r\n");
      out.write("    <script src=\"js/ligerUI/plugins/ligerDialog.js\" type=\"text/javascript\"></script>\r\n");
      out.write("    <script src=\"js/ligerUI/plugins/ligerTextBox.js\" type=\"text/javascript\"></script>\r\n");
      out.write("    <script src=\"js/ligerUI/plugins/ligerCheckBox.js\" type=\"text/javascript\"></script>\r\n");
      out.write("    <script src=\"js/ligerUI/plugins/ligerComboBox.js\" type=\"text/javascript\"></script>\r\n");
      out.write("    <script src=\"js/ligerUI/plugins/ligerGrid.js\" type=\"text/javascript\"></script>\r\n");
      out.write("    <script src=\"js/ligerUI/plugins/ligerToolBar.js\" type=\"text/javascript\"></script>\r\n");
      out.write("    <script src=\"js/ligerUI/plugins/ligerDateEditor.js\" type=\"text/javascript\"></script>\r\n");
      out.write("    <script src=\"js/ligerUI/plugins/ligerSpinner.js\" type=\"text/javascript\"></script>\r\n");
      out.write("    <script type=\"text/javascript\">\r\n");
      out.write("    var ClassData = { \r\n");
      out.write("\tRows: [");
String s = (String) request.getAttribute("classlist");
      out.write(' ');
      out.print(s);
      out.write("]};\r\n");
      out.write("    var ClassList = ClassData.Rows;\r\n");
      out.write("    var sexData = [{ Sex: 1, text: '男' }, { Sex: 2, text: '女'}];\r\n");
      out.write("   $(f_initGrid);\r\n");
      out.write("\tvar manager, g;\r\n");
      out.write("\tfunction f_initGrid() {\r\n");
      out.write("\t\tg = manager = $(\"#maingrid\").ligerGrid(\r\n");
      out.write("\t\t\t{columns : [\r\n");
      out.write("\t\t\t{   display : '序号',  name : 'id',     width : 40,  type : 'int',hide:true\r\n");
      out.write("\t\t\t},{display : '护照', name : 'passport', minWidth : 100,  editor:{type:'text'}\t}\r\n");
      out.write("\t\t\t, {display : '学号', name : 'stuid',  wiminWidthdth : 120, editor: { type: 'text'}\r\n");
      out.write("\t\t\t} ,{display : '密码', name : 'password',minWidth : 80,hide:true,editor: { type: 'password'}\r\n");
      out.write("\t\t\t }, {display : '英文名', name : 'firstname',minWidth : 100, editor: { type: 'text'}\r\n");
      out.write("\t\t\t}, {display : '英文姓', name : 'lastname',minWidth : 100, editor: { type: 'text'}\r\n");
      out.write("\t\t\t}, {display : '姓名', name : 'stuname',minWidth : 80, editor: { type: 'text'}\r\n");
      out.write("\t\t\t} ,{display : '性别', name : 'stusex', minWidth : 50,  editor:{type:'text'}\t\r\n");
      out.write("\t\t\t} ,{display : '出生年月', name : 'brithdate', minWidth : 50,  editor:{type:'text'}\t\t\t\t\r\n");
      out.write("\t\t\t} ,{ display: '班级',  name: 'classid', minWidth: 100, isSort: false,\r\n");
      out.write("            editor: { type: 'select', data: ClassList, valueColumnName: 'Classid', displayColumnName: 'Classname' }, \r\n");
      out.write("                  render: function (item)\r\n");
      out.write("                    {for (var i = 0; i < ClassList.length; i++)\r\n");
      out.write("                        { if (ClassList[i]['Classid'] == item.classid)\r\n");
      out.write("                                return ClassList[i]['Classname'];\r\n");
      out.write("                        }\r\n");
      out.write("                        return item.Classname;\r\n");
      out.write("                    }\r\n");
      out.write("                }\r\n");
      out.write("             ,{display : '专业', name : 'major', minWidth : 120,  editor:{type:'text'}}\r\n");
      out.write("             ,{display : '电话', name : 'telephone', minWidth : 100,  editor:{type:'text'} \r\n");
      out.write("             } ,{display : '住址', name : 'roomplace', minWidth : 120,  editor:{type:'text'}\r\n");
      out.write("             } ,{display : '国籍', name : 'nation', minWidth : 100,  editor:{type:'text'}\t}\r\n");
      out.write("             \r\n");
      out.write("             ,{display : '学生类别', name : 'studentType', minWidth : 80,  editor:{type:'text'}\t}\r\n");
      out.write("             ,{display : '入校时间', name : 'startdate', minWidth : 80, editor:{type:'text'} /* type: 'date', format: 'yyyy-MM-dd', width: 100, editor: { type: 'date'} */\t}\t\r\n");
      out.write("             ,{display : '离校时间', name : 'enddate', minWidth : 80,  editor:{type:'text'}\t}\r\n");
      out.write("             ,{display : '居留许可有效期', name : 'validResidencePermit', minWidth : 120,  editor:{type:'text'}\t}\r\n");
      out.write("             ,{display : '来源', name : 'source', minWidth : 80,  editor:{type:'text'}\t}\r\n");
      out.write("             ,{display : '学制', name : 'duration', minWidth : 80,  editor:{type:'text'}\t}\r\n");
      out.write("             ,{display : '欠费', name : 'isPaid', minWidth : 80,  editor:{type:'text'}\t}\r\n");
      out.write("             ,{display : '层次', name : 'studyLevel', minWidth : 80,  editor:{type:'text'}\t}\r\n");
      out.write("             ,{display : '是否毕业', name : 'status', minWidth : 80,  editor:{type:'text'},\r\n");
      out.write("               render:function (item) {\r\n");
      out.write("\t\t\t\t\tif (parseInt(item.status) == 1) {\r\n");
      out.write("\t\t\t\t\t\treturn \"<font style='color:red'>已毕业</font>\";\r\n");
      out.write("\t\t\t\t\t} else if(parseInt(item.status) == 0) {\r\n");
      out.write("\t\t\t\t\t\treturn \"<font style='color:green'>未毕业</font>\";\r\n");
      out.write("\t\t\t\t\t}else{\r\n");
      out.write("\t\t\t\t\t    return \"<font style='color:orange'>审核驳回</font>\";\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t}\t}\r\n");
      out.write("\t\t\t,{display : '状态', name : 'source', minWidth : 80,  editor:{type:'text'},\r\n");
      out.write("               render:function (item) {\r\n");
      out.write("\t\t\t\t\tif (parseInt(item.isDeleted) == 1) {\r\n");
      out.write("\t\t\t\t\t\treturn \"<font style='color:red'>不可用</font>\";\r\n");
      out.write("\t\t\t\t\t} else {\r\n");
      out.write("\t\t\t\t\t\treturn \"<font style='color:green'>正常</font>\";\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t}\t}],\r\n");
      out.write("\t\t\t\t\tonSelectRow : function(rowdata, rowindex) {\r\n");
      out.write("\t\t\t\t\t\t$(\"#txtrowindex\").val(rowindex);\r\n");
      out.write("\t\t\t\t\t},\r\n");
      out.write("\t\t\t\t\tcheckbox:true,\r\n");
      out.write("\t\t\t\t\tenabledEdit : true,\r\n");
      out.write("\t\t\t\t\tclickToEdit : false,\r\n");
      out.write("\t\t\t\t\tisScroll : false,\r\n");
      out.write("\t\t\t\t\trownumbers:true, \r\n");
      out.write("\t\t\t\t\tpageSize:20,\r\n");
      out.write("\t\t\t\t\turl :'");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/system/Stu_stulist.action',\r\n");
      out.write("\t\t\t\t\twidth : '100%',\r\n");
      out.write("\t\t\t\t\ttoolbar: { items: [\r\n");
      out.write("\t\t\t\t\t                   { text: '添加',click: addstu,  icon: 'add' },\r\n");
      out.write("\t\t\t\t\t                   { text: '修改',click: beginEdit,  icon: 'edit' },\r\n");
      out.write("\t\t\t\t\t                   { text: '删除',click: deleterow,  icon: 'delete' },\r\n");
      out.write("\t\t\t\t\t                   { text: '重置',click: recovery,  icon: 'save' },\r\n");
      out.write("\t\t\t\t\t                   { text: '批量添加', click: addbatchstu, icon:'add'},\r\n");
      out.write("                                       { text: '导出',click: itemclick,  icon: 'outbox' }               \r\n");
      out.write("                    ]}\r\n");
      out.write("\t\t\t\t});\r\n");
      out.write("\t}\r\n");
      out.write("\tfunction itemclick(item){\r\n");
      out.write("       var str = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/system/Stu_studownload.action\"; \r\n");
      out.write("       window.location.href=str;\r\n");
      out.write("        }\r\n");
      out.write("\tvar m;\r\n");
      out.write("\tfunction beginEdit() {\r\n");
      out.write("       var row = manager.getSelectedRow();\r\n");
      out.write("       if (!row) { alert('请选择一名学生！'); return; }      \r\n");
      out.write("       var str = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/system/Stu_stuedit.action?stu.id=\"+ row.id;\r\n");
      out.write("           m=$.ligerDialog.open({\r\n");
      out.write("\t\t\turl : str,\r\n");
      out.write("\t\t\theight : 450,\r\n");
      out.write("\t\t\twidth : 750,\r\n");
      out.write("\t\t\tisDrag:true,\r\n");
      out.write("\t\t\tshowMax:true,\r\n");
      out.write("\t\t\tshowToggle:true,\r\n");
      out.write("\t\t\tslide: false,\t\t\t\r\n");
      out.write("\t\t\tmodal:false,\r\n");
      out.write("\t\t\tleft:200,\r\n");
      out.write("\t\t\ttitle:'学生更新',\r\n");
      out.write("\t\t\tallowClose:true,\r\n");
      out.write("\t\t    isResize : false\r\n");
      out.write("\t\t});\r\n");
      out.write("\t}\t\r\n");
      out.write("\tfunction deleterow() {\r\n");
      out.write("\t    var row = manager.getSelectedRow();\r\n");
      out.write("\t\tif (!row) {alert('请选择一名学生！');return;}\r\n");
      out.write("\t\t$(\".l-dialog-inputtext\").focus(function(){  \r\n");
      out.write("             $(this).attr('type','password');  \r\n");
      out.write("        });\r\n");
      out.write("\t    $.ligerDialog.confirm(\"是否删除？第一次删除将会使该学生不可用。如果没有成绩或记录与此学生关联，第二次删除会彻底清除记录，否则不做任何操作。\", function (yes){\r\n");
      out.write("            if(yes){\r\n");
      out.write("               $.ligerDialog.prompt('请输入确认密码', function (yes, value){\r\n");
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
      out.write("\t\t                     var rows = g.getCheckedRows();\r\n");
      out.write("                             var str = \"\";\r\n");
      out.write("                             $(rows).each(function (){ str += this.id;});\r\n");
      out.write("\t\t\t                 $.post(\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/system/Stu_studelete.action?ids=\"+str,null,function(){\r\n");
      out.write("\t\t\t                   g.loadData();\r\n");
      out.write("\t\t\t                   //window.location.reload(); \r\n");
      out.write("\t\t\t                 });\r\n");
      out.write("\t\t\t                 \r\n");
      out.write("\t\t                   }\r\n");
      out.write("\t\t                 });\r\n");
      out.write("\t\t             }\r\n");
      out.write("\t\t         });\r\n");
      out.write("\t\t     }\r\n");
      out.write("\t\t});\r\n");
      out.write("\t} \r\n");
      out.write("\tvar m;\r\n");
      out.write("\tfunction addstu(){\r\n");
      out.write("\tvar win1;\r\n");
      out.write("\tif (win1) win1.show();\r\n");
      out.write("\telse{\r\n");
      out.write("\tvar str = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/system/Stu_stubeginadd.action\";\r\n");
      out.write("\t\tm=$.ligerDialog.open({\r\n");
      out.write("\t\t\turl : str,\r\n");
      out.write("\t\t\theight : 450,\r\n");
      out.write("\t\t\twidth : 750,\r\n");
      out.write("\t\t\tisDrag:true,\r\n");
      out.write("\t\t\tshowMax:true,\r\n");
      out.write("\t\t\tshowToggle:true,\r\n");
      out.write("\t\t\tslide: false,\t\t\t\r\n");
      out.write("\t\t\tmodal:false,\r\n");
      out.write("\t\t\tleft:200,\r\n");
      out.write("\t\t\ttitle:'添加学生',\r\n");
      out.write("\t\t\tallowClose:true,\r\n");
      out.write("\t\t    isResize : false\r\n");
      out.write("\t\t});}\r\n");
      out.write("\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t}\r\n");
      out.write("\tfunction addbatchstu(){\r\n");
      out.write("\tvar str = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/system/Stu_stubatchadd.action\";\r\n");
      out.write("\t\tm=$.ligerDialog.open({\r\n");
      out.write("\t\t\turl : str,\r\n");
      out.write("\t\t\theight : 500,\r\n");
      out.write("\t\t\twidth : 700,\r\n");
      out.write("\t\t\tisResize : true\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\t\r\n");
      out.write("\t}\r\n");
      out.write("\tfunction recovery(){\r\n");
      out.write("\t  var row = manager.getSelectedRow();\r\n");
      out.write("\t\tif (!row) {alert('请选择一名学生！');return;}\r\n");
      out.write("\t\tif(row.isDeleted==0){\r\n");
      out.write("\t\t  if (confirm('确认将重置学生密码，设为初始密码（123456）?')) {\r\n");
      out.write("            $.post(\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/system/Stu_sturecovery.action?ids=\"+row.id,null,function(){\r\n");
      out.write("            //window.location.reload();\r\n");
      out.write("            g.loadData();\r\n");
      out.write("            });\r\n");
      out.write("            \r\n");
      out.write("          }\r\n");
      out.write("\t   }else{\r\n");
      out.write("\t      $.ligerDialog.confirm(\"是否重置该学生为可用，确认后同时设置密码为初始密码（123456）？\", function (yes){\r\n");
      out.write("         if(yes){\r\n");
      out.write("\t\t  var rows = g.getCheckedRows();\r\n");
      out.write("            var str = \"\";\r\n");
      out.write("            $(rows).each(function () {\r\n");
      out.write("                str += this.id;\r\n");
      out.write("            });\r\n");
      out.write("\t\t\t$.post(\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/system/Stu_sturecovery.action?ids=\"\r\n");
      out.write("\t\t\t+  str,null,function(){\r\n");
      out.write("            //window.location.reload();\r\n");
      out.write("            g.loadData();\r\n");
      out.write("            });\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t});\r\n");
      out.write("\t   }\r\n");
      out.write("\t\t\r\n");
      out.write("\t}\r\n");
      out.write("</script>\r\n");
      out.write("\t</head>\r\n");
      out.write("\t<body style=\"padding: 2px\">\r\n");
      out.write("\t <!-- <a class=\"l-button\" style=\"width:70px;float:left; margin:3px;\" onclick=\"addstu()\">添&nbsp;&nbsp;加</a>\r\n");
      out.write("\t <a class=\"l-button\" style=\"width:70px;float:left; margin:3px;\" onclick=\"addbatchstu()\">批量添加</a>       \r\n");
      out.write("\t <a class=\"l-button\" style=\"width:70px;float:left; margin:3px;\" onclick=\"deleterow()\">删&nbsp;&nbsp;除</a>\r\n");
      out.write("\t <a class=\"l-button\" style=\"width:70px;float:left; margin:3px;\" onclick=\"beginEdit()\">修&nbsp;&nbsp;改</a>\r\n");
      out.write("\t <a class=\"l-button\" style=\"width:70px;float:left; margin:3px;\" onclick=\"recovery()\">重&nbsp;&nbsp;置</a> -->\r\n");
      out.write("\t <!-- <a class=\"l-button\" style=\"width:80px;float:left; margin:3px;\" onclick=\"cancelEdit()\">取消修改</a>\r\n");
      out.write("\t <a class=\"l-button\" style=\"width:70px;float:left; margin:3px;\" onclick=\"endEdit()\">保存</a>\r\n");
      out.write("\t -->\t<div class=\"l-clear\"></div>\r\n");
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
