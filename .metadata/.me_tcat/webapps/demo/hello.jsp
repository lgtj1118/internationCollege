<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
    <base href="<%=basePath%>">   
    <title></title>
	<link href="<%=basePath%>js/ligerUI/skins/Aqua/css/ligerui-all.css" rel="stylesheet"type="text/css" />	
	<link href="<%=basePath %>js/ligerUI/skins/Gray/css/all.css" rel="stylesheet" type="text/css"/>	
    <script type="text/javascript" src="<%=basePath %>js/jquery/jquery-1.3.2.min.js"></script>
	<script src="<%=basePath %>js/ligerUI/core/base.js" type="text/javascript"></script>
	<script src="<%=basePath %>js/ligerUI/ligerui.all.js" type="text/javascript"></script>
	<!-- <script type="text/javascript">
        var manager;
        $(function ()
        {
            $("#portalMain").ligerPortal({
                draggable : true,
                rows: [ 
                    {
                        columns: [
                       /* {
                            width: 500,                            
                            panels: [{
                                title: '公告',
                                width: '100%',
                                height: 300,
                               url: 'system/User_announcementlist.action'
                            }]
                        } ,,{
                            width: 400,
                            panels: [{
                                title: '常用链接',
                                width: '100%',
                                height: 300,
                                url:'system/User_hellolinks.action'
                            }]
                        } */{
                            width: '60%',
                            panels: [{
                                title: '提醒事项',
                                width: '98%',
                                height: 300,
                                url:'system/Stu_stupermission.action'
                            }]
                        } ]
                    }
                ]
            }); 
        }); 
    </script> -->
<style type="text/css">
#contain{ 
  margin-top: 20px;
  margin-left: 30px;
  height: 90%;
  
}
#frameset{
  height: 100%;
}
.iframe1{
width:80%;height: 300px;border: 0px;
}
.iframe2{
  margin-top:10px;
  width:80%;height: 300px;border:0px;
}
</style>
</head>

<body style="padding:10px">
      <!-- <div style="width:98%;height: 50%;margin-top: 3%;margin-left: 20px;" id="portalMain"> </div>  --> 
      <div id="contain" >         
           <s:if test="#session.user.roles.rolerank==0||#session.user.roles.rolerank==1">
             <frameset rows="45%,45%" id="frameset" >
                <iframe class="iframe1" src="system/User_announcementlist.action" scrolling="no" ></iframe>
                <iframe class="iframe2" src="system/Stu_stupermission.action"     scrolling="no" ></iframe>
             </frameset>
           </s:if>
           <s:else >
            <frameset rows="100%" id="frameset" >
               <iframe src="system/User_announcementlist.action" class="iframe1" scrolling="no"></iframe>
            </frameset>
           </s:else> 
         
      </div>      
</body>
</html>