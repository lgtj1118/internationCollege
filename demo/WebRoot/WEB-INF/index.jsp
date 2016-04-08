<%@page import="org.springframework.web.context.request.SessionScope"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>天津工业大学国际教育学院教学服务系统</title>
<link href="<%=basePath %>js/ligerUI/skins/Aqua/css/ligerui-all.css"rel="stylesheet" type="text/css" />
<link href="<%=basePath %>js/ligerUI/skins/Gray/css/all.css"rel="stylesheet" type="text/css" />
<%-- <link rel="stylesheet" type="text/css" href="<%=basePath %>css/menu-css.css"> --%>
<link rel="stylesheet" type="text/css" href="<%=basePath %>css/style.css"> 
<link rel="shortcut icon" href="<%=basePath %>images/icon.ico"/>
<script src="<%=basePath %>js/jquery/jquery-1.3.2.min.js" type="text/javascript"></script>
<script src="<%=basePath %>js/jquery/ligerUI/plugins/ligerDialog.js" type="text/javascript"></script>
<script src="<%=basePath %>js/jquery/ligerUI/plugins/ligerDrag.js" type="text/javascript"></script>
<script src="<%=basePath %>js/ligetUI/plugins/ligerTab.js" type="text/javascript"></script>
<script src="<%=basePath %>js/ligerUI/ligerui.all.js" type="text/javascript"></script>
<script type="text/javascript">
	var tab = null;
	var accordion = null;
	var tree = null;
	$(function(){
		//布局
		$("#layout1").ligerLayout({
			leftWidth : 230,
			isRightCollapse : true,
			height : '100%',
			heightDiff : -34,
			allowLeftCollapse:true,
			space : 4,
			onHeightChanged : f_heightChanged
		});
		var height = $(".l-layout-center").height();
		//Tab
		$("#framecenter").ligerTab({
			height : height
		});
		//面板
		$("#accordion1").ligerAccordion({
			height : height - 24,
			speed : 200
		});
		$(".l-link").hover(function(){
			$(this).addClass("l-link-over");
		}, function(){
			$(this).removeClass("l-link-over");
		});
		tab = $("#framecenter").ligerGetTabManager();
		accordion = $("#accordion1").ligerGetAccordionManager();
		tree = $("#tree1").ligerGetTreeManager();
		$("#pageloading").hide();
		var userrole = ${session.user.roles.rolerank};
		if(userrole==3){
		   /* var day =${perday};
		   if(day!=-999&&day<0){
		     var wel = $.ligerDialog.tip({  title: '温馨提示',content:'<font style="color:red;" >您的居留许可已过期，请及时更新！！</font>' });
             setTimeout(function () { wel.close(); }, 5000);
		   }else if(day!=-999&&day<45){
		     var wel = $.ligerDialog.tip({  title: '温馨提示',content:'您的居留许可有效期还有<font style="color:red;font-size:24px;" >'+day+' </font>天到期，请注意更新！' });
             setTimeout(function () { wel.close(); }, 8000);
		   }else{ */
		     var wel = $.ligerDialog.tip({  title: '温馨提示',content:'欢迎您的登录！' });
             setTimeout(function () { wel.close(); }, 8000);
		   //}
		}				
	});
	function f_heightChanged(options){
		if (tab)
			tab.addHeight(options.diff);
		if (accordion && options.middleHeight - 24 > 0)
			accordion.setHeight(options.middleHeight - 24);
	}
	 function f_addTab(tabid,text, url){ 
        tab.addTabItem({ tabid : tabid,text: text, url: url });
     }  
     function f_closeTab(){
        tab.removeSelectedTabItem();
        tab.reload(tab.getSelectedTabItemID());
     }    
     var m;
	 function changepwd(){	
	  var roleid =${sessionScope.user.roles.rolerank};
	  if(roleid==3){
	    var str = "${pageContext.request.contextPath}/system/Stu_changepwd.action?stu.id="+${sessionScope.user.id};
		m=$.ligerDialog.open({
			url : str,
			height : 300,
			width : 350,
			title:'修改密码',
			left:500,
			allowClose:true,
		    isResize : false
		});	
	 }else{
	    var str = "${pageContext.request.contextPath}/system/User_changepwd.action?user.id="+${sessionScope.user.id};
		m=$.ligerDialog.open({
			url : str,
			height : 300,
			width : 350,
			title:'修改密码',			
			left:500,
			allowClose:true,
		    isResize : false
		});		
	 }	
	} 
  function fopenlink(){
   alert("如有疑问请发邮件到：China_ximeng@sohu.com");
  }	
</script>

</head>
<body>
<!-- 顶部 -->
<div class="l-page-top">
    <div class="l-page-title"><strong><font face="楷体"><font color="white" size="5" style="margin-top: 5px;">&nbsp; 天津工业大学国际教育学院教学服务系统</font></font></strong></div>
    <div class="userinfo">
    <a class="l-page-link2"  >
    <strong>${sessionScope.user.realname }</strong>&nbsp;(${sessionScope.user.roles.roledescribe })  
    </a>
        <span class="space">|</span>
        <!-- <a class="l-link2" onclick="deleteCache();" style="cursor: pointer;">清除缓存</a><span class="space">|</span> -->
        <a class="l-page-link2" onclick="changepwd()" style="cursor: pointer;">修改密码</a><span class="space">|</span>
        <a href="loginout" class="l-page-link2" target="_self">退出</a>
    </div>
</div>
<!-- 左侧导航 -->
	<div id="layout1" style="width:99.5%; margin:0 5px auto; margin-top:4px; height: 80%;"> 
		<div position="left" title="导航栏"  id="accordion1" > <!-- title="导航栏" -->
		    <s:if test="#session.user.roles.rolerank==3">
		        <s:iterator value="#request.map" id="column">					
					  <div title="<s:property value="#column.key"/>">					
						<s:iterator value="#column.value" status="s">
							<a class="l-link" href="javascript:f_addTab('<s:property value="enname"/>','<s:property value="namenav"/>','<s:property value="menuurl"/>');">
							<s:property value="namenav" />(&nbsp;<s:property value="enname" />&nbsp;)
							</a>
						</s:iterator>
					</div>
		        </s:iterator>
	        </s:if>
	        <s:else>
		     <s:iterator value="#request.map" id="column">					
					  <div title="<s:property value="#column.key"/>">					
						<s:iterator value="#column.value" status="s">
							<a class="l-link" href="javascript:f_addTab('<s:property value="enname"/>','<s:property value="namenav"/>','<s:property value="menuurl"/>');">
							<s:property value="namenav" />
							</a>
						</s:iterator>
					</div>
		     </s:iterator>
	        </s:else>
		</div>
	   
<!--中间内容显示  -->
		 <div position="center" id="framecenter"> 
			<div tabid="home" title="主页">
                <iframe frameborder="0" name="home" id="home" src="hello.jsp"></iframe> 
            </div> 
		</div>				
		</div>	
		<div id="footer"align="center">版权所有© 天津工业大学国际教育学院<br>技术支持：<a href="javascript:void(0)" onclick="fopenlink()" style="color: rgb(102, 102, 102);" >绿色之园工作组</a></div>	
</body>
</html>
