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
        <script src="js/jquery/jquery-1.3.2.min.js" type="text/javascript"></script>
    <script src="js/json2.js" type="text/javascript"></script>
    <script src="js/ligerUI/ligerui.all.js" type="text/javascript"></script>
    <script src="js/ligerUI/js/core/base.js" type="text/javascript"></script>
    <script src="js/ligerUI/plugins/ligerDialog.js" type="text/javascript"></script>
    <script src="js/ligerUI/plugins/ligerTextBox.js" type="text/javascript"></script>
    <script src="js/ligerUI/plugins/ligerCheckBox.js" type="text/javascript"></script>
    <script src="js/ligerUI/plugins/ligerComboBox.js" type="text/javascript"></script>
    <script src="js/ligerUI/plugins/ligerGrid.js" type="text/javascript"></script>
    <script src="js/ligerUI/plugins/ligerToolBar.js" type="text/javascript"></script>
    <script src="js/ligerUI/plugins/ligerDateEditor.js" type="text/javascript"></script>
    <script src="js/ligerUI/plugins/ligerSpinner.js" type="text/javascript"></script>
    <title>公告列表</title>
<script type="text/javascript">
  function moreannouncement(){
    var str = "${pageContext.request.contextPath}/system/User_moreannouncementlist.action";
    top.f_addTab("moreannouncement","通知公告",str);
  }
</script>
<style type="text/css">
body{font-size: 12px;}
#announcementlist{
border-top: 2px solid #2E4285;
padding:5px;
min-height:400px;
box-shadow: 2px 2px 2px 2px #EEE;
}
.title-box{
margin-left: 10px;color: #2E4285;
line-height: 10px;
border-bottom: 1px solid #F1F1F1;
}
.title-more{
 float: right;
 margin-top:-20px;
 margin-right:20px;
}
a{margin-left: 0px;margin-top: 8px;font-family: 微软雅黑;color: black;text-decoration: none;}
a:hover{text-decoration:underline;}/*鼠标滑过样式*/
a:visited {color:#333;text-decoration:none;}/*访问后的样式*/
.content{
width:330px;white-space:nowrap;word-break:keep-all;overflow:hidden;text-overflow:ellipsis;
}
</style>
  </head>
  
  <body>
    <div id="announcementlist" >      
      <div class="title-box" align="left" ><h2>通知公告&nbsp; Announcement</h2></div>      
      <div style="width: 100%;height:80%;" >
         <table width="100%" >
        <s:iterator value="pageBean.resultList" id="announcements" >
        <tr>
          <td><div class="content" ><a title="${announcements.title }" href="system/User_announcementdetail.action?announcement.id=${announcements.id }" target="_blank">${announcements.title }</a></div></td>
          <td align="right" > <s:property value="#announcements.createdtime.substring(0,11)" /></td>
        </tr>
       </s:iterator>          
      </table>
      </div>
      
      <table style="width: 50%;margin:20  auto;">
				<tr>
					<s:if test="pageBean.currentPage== 1">
						<td>第一页</td> <td>上一页</td>
					</s:if>
					<s:else>
						<td ><a href="system/User_moreannouncementlist.action?page=1&menu_id=${menuid }&art_id=-1">第一页</a> </td>
						<td><a href="system/User_moreannouncementlist.action?page=${pageBean.currentPage-1 }&menu_id=${menuid }&art_id=-1">上一页</a></td>
					</s:else>
					<td>当前第&nbsp;<s:property value="pageBean.currentPage" />&nbsp;页</td>
					<s:if test="pageBean.currentPage >= pageBean.pageSUM">
						<td>下一页</td> <td>最后一页</td>
					</s:if>
					<s:else>
						<td><a href="system/User_moreannouncementlist.action?page=${pageBean.currentPage+1 }&menu_id=${menuid }&art_id=-1">下一页</a></td>
						<td><a href="system/User_moreannouncementlist.action?page=${pageBean.pageSUM }&menu_id=${menuid }&art_id=-1">最后一页</a></td>
					</s:else>
					<td>共<s:property value="pageBean.pageSUM" /> 页 &nbsp;&nbsp;<s:property value="pageBean.recordSUM" /> 条记录</td>
				</tr>
			</table>
    </div>    
  </body>
</html>
