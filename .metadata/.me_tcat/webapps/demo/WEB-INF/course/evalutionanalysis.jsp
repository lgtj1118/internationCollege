<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>天津工业大学国际教育学院学生教师课务系统</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="天津工业大学国际教育学院学生教师课务系统">
<style type="text/css">
.data-list{min-height:500px;color:#333;}
.data-table{ border:1px #ebebeb solid; border-bottom:none;width:60%;border-spacing: 0px;margin: auto;}
.data-table td{height:28px; padding-left:5px; border-bottom:1px #ebebeb solid;}
.td-cb{ width:20px;}
.data-table a{ color:#3377aa;text-decoration:none;}
.data-table a:hover{background:none;color:#3377aa;text-decoration:underline;}
.data-table tbody tr:hover{ background:#ffffe1;}

td .action{ width:20px; position:relative;}
.ac td .act-box a{text-decoration:none;}
.action .arrow{ text-align:center; width:16px; height:16px; border:1px solid #DADADA; cursor:pointer; z-index:-1;}
.action .arrow img{ margin-top:6px;}
.action .act-box{ position:absolute; min-width:80px; text-align:center; right:2px; background-color:White; border:1px solid #DADADA; display:none; z-index:100;}
.act-box a{ display:block; width:80px; height:20px; line-height:20px;text-decoration:none;}
.act-box a:hover{ color:White; background:#37A; text-decoration:none;}

</style>
  </head>
  
  <body>
    <h3 align="center"><font face="微软雅黑">评价分析</font></h3><br>
    <div id="contain">
       <table class="data-table" id="data-table">
            <thead>
                <tr>
                    <td>类型</td><td>详情</td>
                </tr>               
            </thead>
            <tbody>
               <tr>
                    <td>教学态度</td><td><span class="type" >${incicators1 } </span></td>
               </tr>
               <tr>
                    <td>因材施教</td><td><span class="type" >${incicators2 } </span></td>
               </tr>
               <tr>
                    <td>教学内容</td><td><span class="type" >${incicators3 } </span></td>
               </tr>
               <tr>
                    <td>语言板书</td><td><span class="type" >${incicators4 } </span></td>
               </tr>
                <tr>
                    <td>教学方法</td><td><span class="type" >${incicators5 } </span></td>
               </tr>
                <tr>
                    <td>教学效果</td><td><span class="type" >${incicators6 } </span></td>
               </tr>
                <tr>
                    <td>总体印象</td><td><span class="type" >${incicators7 } </span></td>
               </tr>
                <tr>
                    <td>合计（分）</td><td><span class="type" >
                      <s:if test="#summary<60">
                       <font color="red" > </font>  
                      </s:if>
                      <s:else>
                         ${summary }
                      </s:else>
                    </span></td>
               </tr>
            </tbody>
        </table>
    </div>
  </body>
</html>
