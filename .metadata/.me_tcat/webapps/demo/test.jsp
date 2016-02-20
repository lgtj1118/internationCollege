<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
  <html xmlns="http://www.w3.org/1999/xhtml">
  <head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <title>无标题文档</title>
  <link href="<%=basePath%>js/ligerUI/skins/Gray/css/form.cssrel="stylesheet" type="text/css" />
<link href="<%=basePath%>js/ligerUI/skins/Gray/css/common.css"rel="stylesheet" type="text/css" />
<script src="<%=basePath%>js/jquery/jquery-1.3.2.min.js"type="text/javascript"></script>
<script src="<%=basePath%>js/ligerUI/core/base.js"type="text/javascript"></script>
<script src="<%=basePath%>js/ligerUI/plugins/ligerForm.js"type="text/javascript"></script>
<script src="<%=basePath%>js/ligerUI/plugins/ligerDateEditor.js"type="text/javascript"></script>
<script src="<%=basePath%>js/ligerUI/plugins/ligerComboBox.js"type="text/javascript"></script>
<script src="<%=basePath%>js/ligerUI/plugins/ligerDialog.js"type="text/javascript"></script>
<script src="<%=basePath%>js/ligerUI/plugins/ligerDrag.js"type="text/javascript"></script>
<script src="<%=basePath%>js/ligerUI/plugins/ligerSpinner.js"type="text/javascript"></script>
<script src="<%=basePath%>js/ligerUI/plugins/ligerTextBox.js"type="text/javascript"></script>
<script src="<%=basePath%>js/ligerUI/plugins/ligerTip.js"type="text/javascript"></script>
<script src="<%=basePath%>js/jquery-validation/jquery.validate.min.js"type="text/javascript"></script>
<script src="<%=basePath%>js/jquery-validation/jquery.metadata.js"type="text/javascript"></script>
<script src="<%=basePath%>js/jquery-validation/messages_cn.js"type="text/javascript"></script>
  </head>
  
  <body>
  <table width="500" border="0" cellpadding="5" cellspacing="1" bgcolor="#999999" id="table1">
 <tbody id="table2">
   <tr>
     <td bgcolor="#FFFFFF">test</td>
     <td bgcolor="#FFFFFF">&nbsp;</td>
     <td bgcolor="#FFFFFF">&nbsp;</td>
     <td bgcolor="#FFFFFF">&nbsp;</td>
     <td bgcolor="#FFFFFF">&nbsp;</td>
   </tr>
   <tr>
     <td bgcolor="#FFFFFF">1</td>
     <td bgcolor="#FFFFFF">&nbsp;</td>
     <td bgcolor="#FFFFFF">&nbsp;</td>
     <td bgcolor="#FFFFFF">&nbsp;</td>
     <td bgcolor="#FFFFFF">&nbsp;</td>
   </tr>
   <tr>
     <td bgcolor="#FFFFFF">2</td>
     <td bgcolor="#FFFFFF">&nbsp;</td>
     <td bgcolor="#FFFFFF">&nbsp;</td>
     <td bgcolor="#FFFFFF">&nbsp;</td>
     <td bgcolor="#FFFFFF">&nbsp;</td>
   </tr>
   <tr>
     <td bgcolor="#FFFFFF">3</td>
     <td bgcolor="#FFFFFF">&nbsp;</td>
     <td bgcolor="#FFFFFF">&nbsp;</td>
     <td bgcolor="#FFFFFF">&nbsp;</td>
     <td bgcolor="#FFFFFF">&nbsp;</td>
   </tr>
   <tr>
     <td bgcolor="#FFFFFF">4</td>
     <td bgcolor="#FFFFFF">&nbsp;</td>
     <td bgcolor="#FFFFFF">&nbsp;</td>
     <td bgcolor="#FFFFFF">&nbsp;</td>
     <td bgcolor="#FFFFFF">&nbsp;</td>
   </tr>
   <tr>
     <td bgcolor="#FFFFFF">5</td>
     <td bgcolor="#FFFFFF">&nbsp;</td>
     <td bgcolor="#FFFFFF">&nbsp;</td>
     <td bgcolor="#FFFFFF">&nbsp;</td>
     <td bgcolor="#FFFFFF">&nbsp;</td>
   </tr>
   <tr>
     <td bgcolor="#FFFFFF">6</td>
     <td bgcolor="#FFFFFF">&nbsp;</td>
     <td bgcolor="#FFFFFF">&nbsp;</td>
     <td bgcolor="#FFFFFF">&nbsp;</td>
     <td bgcolor="#FFFFFF">&nbsp;</td>
   </tr>
   <tr>
     <td bgcolor="#FFFFFF">7</td>
     <td bgcolor="#FFFFFF">&nbsp;</td>
     <td bgcolor="#FFFFFF">&nbsp;</td>
     <td bgcolor="#FFFFFF">&nbsp;</td>
     <td bgcolor="#FFFFFF">&nbsp;</td>
   </tr>
   <tr>
     <td bgcolor="#FFFFFF">8</td>
     <td bgcolor="#FFFFFF">&nbsp;</td>
     <td bgcolor="#FFFFFF">&nbsp;</td>
     <td bgcolor="#FFFFFF">&nbsp;</td>
     <td bgcolor="#FFFFFF">&nbsp;</td>
   </tr>
   <tr>
     <td bgcolor="#FFFFFF">9</td>
     <td bgcolor="#FFFFFF">&nbsp;</td>
     <td bgcolor="#FFFFFF">&nbsp;</td>
     <td bgcolor="#FFFFFF">&nbsp;</td>
     <td bgcolor="#FFFFFF">&nbsp;</td>
   </tr>
   <tr>
     <td bgcolor="#FFFFFF">10</td>
     <td bgcolor="#FFFFFF">&nbsp;</td>
     <td bgcolor="#FFFFFF">&nbsp;</td>
     <td bgcolor="#FFFFFF">&nbsp;</td>
     <td bgcolor="#FFFFFF">&nbsp;</td>
   </tr>
   <tr>
     <td bgcolor="#FFFFFF">11</td>
     <td bgcolor="#FFFFFF">&nbsp;</td>
     <td bgcolor="#FFFFFF">&nbsp;</td>
     <td bgcolor="#FFFFFF">&nbsp;</td>
     <td bgcolor="#FFFFFF">&nbsp;</td>
   </tr>
   </tbody>
 </table> 
 <span id="spanFirst">第一页</span> <span id="spanPre">上一页</span> <span id="spanNext">下一页</span> <span id="spanLast">最后一页</span> 第<span id="spanPageNum"></span>页/共<span id="spanTotalPage"></span>页
 
 </body>
 </html>
 <script>
     var theTable = document.getElementById("table2");
     var totalPage = document.getElementById("spanTotalPage");
     var pageNum = document.getElementById("spanPageNum");


     var spanPre = document.getElementById("spanPre");
     var spanNext = document.getElementById("spanNext");
     var spanFirst = document.getElementById("spanFirst");
     var spanLast = document.getElementById("spanLast");


     var numberRowsInTable = theTable.rows.length;
     var pageSize = 3;
     var page = 1;


     //下一页
     function next() {


         hideTable();


         currentRow = pageSize * page;
         maxRow = currentRow + pageSize;
         if (maxRow > numberRowsInTable) maxRow = numberRowsInTable;
         for (var i = currentRow; i < maxRow; i++) {
             theTable.rows[i].style.display = '';
         }
         page++;


         if (maxRow == numberRowsInTable) { nextText(); lastText(); }
         showPage();
         preLink();
         firstLink();
     }


     //上一页
     function pre() {


         hideTable();


         page--;


         currentRow = pageSize * page;
         maxRow = currentRow - pageSize;
         if (currentRow > numberRowsInTable) currentRow = numberRowsInTable;
         for (var i = maxRow; i < currentRow; i++) {
             theTable.rows[i].style.display = '';
         }




         if (maxRow == 0) { preText(); firstText(); }
         showPage();
         nextLink();
         lastLink();
     }


     //第一页
     function first() {
         hideTable();
         page = 1;
         for (var i = 0; i < pageSize; i++) {
             theTable.rows[i].style.display = '';
         }
         showPage();


         preText();
         nextLink();
         lastLink();
     }


     //最后一页
     function last() {
         hideTable();
         page = pageCount();
         currentRow = pageSize * (page - 1);
         for (var i = currentRow; i < numberRowsInTable; i++) {
             theTable.rows[i].style.display = '';
         }
         showPage();


         preLink();
         nextText();
         firstLink();
     }


     function hideTable() {
         for (var i = 0; i < numberRowsInTable; i++) {
             theTable.rows[i].style.display = 'none';
         }
     }


     function showPage() {
         pageNum.innerHTML = page;
     }


     //总共页数
     function pageCount() {
         var count = 0;
         if (numberRowsInTable % pageSize != 0) count = 1;
         return parseInt(numberRowsInTable / pageSize) + count;
     }


     //显示链接
     function preLink() { spanPre.innerHTML = "<a href='javascript:pre();'>上一页</a>"; }
     function preText() { spanPre.innerHTML = "上一页"; }


     function nextLink() { spanNext.innerHTML = "<a href='javascript:next();'>下一页</a>"; }
     function nextText() { spanNext.innerHTML = "下一页"; }


     function firstLink() { spanFirst.innerHTML = "<a href='javascript:first();'>第一页</a>"; }
     function firstText() { spanFirst.innerHTML = "第一页"; }


     function lastLink() { spanLast.innerHTML = "<a href='javascript:last();'>最后一页</a>"; }
     function lastText() { spanLast.innerHTML = "最后一页"; }


     //隐藏表格
     function hide() {
         for (var i = pageSize; i < numberRowsInTable; i++) {
             theTable.rows[i].style.display = 'none';
         }


         totalPage.innerHTML = pageCount();
         pageNum.innerHTML = '1';


         nextLink();
         lastLink();
     }


     hide();
</script>