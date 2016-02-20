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
    
    <title>天津工业大学国际教育学院教学服务系统</title>
	<link href="<%=basePath%>js/ligerUI/skins/Aqua/css/ligerui-all.css" rel="stylesheet"type="text/css" />	
	<link href="<%=basePath %>js/ligerUI/skins/Gray/css/all.css" rel="stylesheet" type="text/css"/>	
    <script src="js/jquery/jquery-1.3.2.min.js"type="text/javascript"></script>
	<script src="js/ligerUI/core/base.js" type="text/javascript"></script>
	<script src="js/ligerUI/ligerui.all.js" type="text/javascript"></script>
<script type="text/javascript">
  var m;
  function stuedit(){
    var str = "${pageContext.request.contextPath}/system/Stu_stubaseupdate.action?stu.id="+$("#stuid").val();
    m=$.ligerDialog.open({		   
			url : str,
			height : 400,
			width : 700,
			title:'个人信息修改',
			isResize : true
		});
  }
  var n ;
  function changeimgs(){
    var str = "${pageContext.request.contextPath}/system/Stu_begainchangeimg.action?stu.id="+$("#stuid").val();
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
 margin-left: 48%;
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
  
    <div id="container"> 
      <h2 align="center" style="font-family: 微软雅黑;margin-top: 20px;margin-left:180px; " >基本信息(Base Info)</h2>    
      <div style="color: red">${message }</div> 
      <input id="stuid" value="${student.id }" type="hidden">   
      <div id="imginfo" >
        <div class="imginfo1" > <img id="zhaopian" src="${student.imgurl }" ></div>
        <img src="images/touxiang.png" style="width:100px;height: 40px; cursor:pointer; margin-left:50px;margin-top: 10px; " onclick="changeimgs()"  >
      
      </div>
      <div id="info">
        <table id="baseinfo" border="1" cellspacing="0" width="800px" align="center">
        <%-- <tr>
            <td  rowspan="3" width="100px" height="130px"></td><td class="l-edit">First Name：</td><td class="l-edit">${student.firstname }</td><td class="l-edit">FamilyName：</td><td class="l-edit">${student.lastname }</td>
        </tr> --%>
        <tr>
            <td class="l-edit"><font color="#808080">中文名(Chinese name)</font></td><td class="l-edit-l" align="center">${student.stuname }</td>
        </tr>
        <tr>
            <td class="l-edit"><font color="#808080">英文姓名(English name)</font></td><td class="l-edit-l" align="center">${student.firstname }&nbsp;${student.lastname }</td>
        </tr>
        <tr>
            <td class="l-edit"><font color="#808080">性别(Gender)</font></td><td class="l-edit-l" align="center">${student.sex }</td>
        </tr>
        <tr>
            <td class="l-edit"><font color="#808080">出生年月(Birthday)</font></td><td class="l-edit-l" align="center">${student.brithdate }</td>
        </tr>
        <tr>
            <td class="l-edit"><font color="#808080">国籍(Nationality)</font></td><td class="l-edit-l" align="center">${student.nation }</td>
        </tr>
        <tr>
            <td class="l-edit"><font color="#808080">学号(Number)</font></td><td class="l-edit-l" align="center">${student.stuid }</td>
        </tr>
        <tr>
            <td class="l-edit"><font color="#808080">护照号(Passport)</font></td><td class="l-edit-l" align="center">${student.passport }</td>
        </tr>
         <tr>
            <td class="l-edit"><font color="#808080">联系方式(Telephone)</font></td><td class="l-edit-l" align="center">${student.telephone }</td>
        </tr>
        <tr>
            <td class="l-edit" ><font color="#808080">住宿地点(Dormitory)</font><td class="l-edit-l" align="center">${student.roomplace }</td>
        </tr>
        <tr>
            <td class="l-edit"><font color="#808080">学生类别(Type)</font></td><td class="l-edit-l" align="center">${student.studentType }</td>
        </tr>
        <tr>
            <td class="l-edit"><font color="#808080">班级(Class)</font></td><td class="l-edit-l" align="center">${student.classes.classname }</td>
        </tr>
        <tr>
            <td class="l-edit" ><font color="#808080">专业(Major)</font><td class="l-edit-l" align="center">${student.classes.major }</td>
        </tr>
        <!-- <tr>
            <td class="l-edit"><font color="#808080">学院</font></td><td class="l-edit-l" align="center"><br></td>
        </tr> -->
        <tr>
            <td class="l-edit" ><font color="#808080">入学时间(Admission time)</font><td class="l-edit-l" align="center">${student.startdate}</td>
        </tr>
        <tr>
            <td class="l-edit" ><font color="#808080">离校时间(Leave time)</font><td class="l-edit-l" align="center">${student.enddate}</td>
        </tr>
        <tr>
           <td class="l-edit" ><font color="#808080">居留许可有效期</font><td class="l-edit-l" align="center">${student.validResidencePermit}</td>
        </tr>
        <tr>
           <td class="l-edit" ><font color="#808080">学生来源(Source)</font><td class="l-edit-l" align="center">${student.source}</td>
        </tr>
      </table>               
      </div>               
      <input id="button" class="l-button" type="button" value="修&nbsp;&nbsp;&nbsp;&nbsp;改(Edit)" onclick="stuedit()"/>
    </div>
  </body>
</html>
