<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>天津工业大学排课管理系统</title>
    <title>天津工业大学排课管理系统</title>
	<link href="<%=basePath%>js/ligerUI/skins/Aqua/css/ligerui-all.css" rel="stylesheet"type="text/css" />	
	<link href="<%=basePath %>js/ligerUI/skins/Gray/css/all.css" rel="stylesheet" type="text/css"/>	
    <script src="js/jquery/jquery-1.3.2.min.js"type="text/javascript"></script>
	<script src="js/ligerUI/core/base.js" type="text/javascript"></script>
	<script src="js/ligerUI/ligerui.all.js" type="text/javascript"></script>
<script type="text/javascript">
  var m;
  function teacheredit(){
    var str = "${pageContext.request.contextPath}/system/Manage_teacherbaseupdate.action?teacher.identificationnum="+$("#id").val();
    m=$.ligerDialog.open({		   
			url : str,
			height : 500,
			width : 400,
			title:'个人信息修改',
			isResize : true
		});
  }
  var n ;
  function changeimgs(){
    var str = "${pageContext.request.contextPath}/system/Manage_teacherbegainchangeimg.action?teacher.identificationnum="+$("#id").val();
    n=$.ligerDialog.open({		   
			url : str,
			height : 400,
			width : 500,
			title:'照片修改',
			isResize : true
		});
  }
</script>
<style type="text/css">
body{
 /*  background-color: #e9edf0; */
}
#container{
 width: 70%;
 margin:auto;
 margin-top:20px;
 margin-left:20%;
 height:99%;
 /* background-color: #fbfaf5; */
 /* border: 2px solid #cce4ed ; */
}
#imginfo{
  float: left;
  width: 200px;
  height:250px;
  margin-top:20px;
  /* border: 2px solid #cce4ed ; */
}
.imginfo1{
  width: 150px;
  height:180px;
  margin:auto;
  border: 2px solid #cce4ed ;
}
#info{
margin-top:20px;
  float: left;
  width:69%;
}

.l-edit{
 text-align: center;
 color: #cbc6c6;
}
.l-edit-l{
 font-family: 楷体;
}
.l-button{
 width:80px;float:left; margin:3px;
 margin-left: 30%;
 margin-top: 30px;
}
.a-change{
  font-size: 10px;
  float: right;
  background-color: #fff;
  text-decoration: none;
}
#zhaopian{
 width: 100%;
 height: 100%;
}
#baseinfo{
  margin-top:0px;
  width: 100%;
}
#baseinfo td{
  height: 30px;
}
</style>
  </head>
 
  <body>
  <div id="container"  > 
  <h2  style="font-family: 微软雅黑;margin-top: 40px ;margin-left: 50%;" >基本信息</h2>    
      <div style="color: red">${message }</div> 
      <input id="id" value="${teachers.identificationnum }" type="hidden">   
      <div id="imginfo" >
        <div class="imginfo1" > <img id="zhaopian" src="${teachers.imgurl }" ></div>
        <img src="images/touxiang.png" style="width:100px;height: 40px; cursor:pointer; margin-left:50px;margin-top: 10px; " onclick="changeimgs()"  >      
      </div>
      <div id="info">
         <table id="baseinfo" border="1" cellspacing="0" width="800px" align="center">
        <tr>
            <td class="l-edit" ><font color="#808080">姓名</font></td><td class="l-edit-l" align="center">${teachers.teachername }</td>
        </tr>
        <tr>
            <td class="l-edit" ><font color="#808080">教师编号</font></td><td class="l-edit-l" align="center">${teachers.identificationnum}</td>
        </tr>
        <tr>
            <td class="l-edit" ><font color="#808080">性别</font></td><td class="l-edit-l" align="center">${teachers.sex }</td>
        </tr>
        <tr>
            <td class="l-edit" ><font color="#808080">职称</font></td><td class="l-edit-l" align="center">${teachers.position }</td>
        </tr>
         <tr>
            <td class="l-edit" ><font color="#808080">联系方式</font></td><td class="l-edit-l" align="center">${teachers.telephone }</td>
        </tr>
        <tr>
            <td class="l-edit" ><font color="#808080">所属部门</font></td><td class="l-edit-l" align="center">${dept.deptname}</td>
        </tr>
        <tr>
            <td class="l-edit" ><font color="#808080">e-mail</font></td><td class="l-edit-l" align="center">${teachers.email }</td>
        </tr>       
      </table>
      </div>           
     <input id="button" class="l-button" type="button" value="修&nbsp;&nbsp;&nbsp;&nbsp;改" onclick="teacheredit()"/> 
    </div>
  </body>
</html>
