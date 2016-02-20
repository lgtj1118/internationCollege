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
    <title>天津工业大学国际教育学院助理班主任报名表</title>
	<script type="text/javascript" src="js/jquery/jquery-1.4.4.min.js" ></script>
	<script type="text/javascript" src="js/jquery.jqprint-0.3.js" ></script>
<script type="text/javascript">
   function tabclose(){
     window.close();
   }
   function tabprint(){
     $("#contain").jqprint();
     
   }
</script>
<style type="text/css">
#head{
  margin:auto;
  width:200px;
  
}
#contain{
margin:auto;
}
.contenttable{
  margin:auto;
  width:80%;
  border:1px solid #c7c7c7 ;
  
}
.contenttable td{
  border: 1px solid #fff ; 
}
</style>
  </head>
  
  <body>
    <div id="head" >
        <font face="楷体"><input align="center" type="button" value="关  闭" onclick="tabclose()"> 
        <input type="button" value="打  印" onclick="tabprint()"></font>
    </div>
    <div id="contain">
    <s:if test="#leaves.type==1">
       <div align="center"> 
	     <font face="楷体"><span style="font-family: 楷体; font-weight: bold; font-size: 18pt;">&nbsp;天津工业大学国际教育学院学院请假单（一）<br></span>&nbsp;<span style="font-family: 'Times New Roman'; font-weight: bold; font-size: 12pt;">Application&nbsp;Form&nbsp;for&nbsp;Leave&nbsp;of&nbsp;School&nbsp;of&nbsp;International&nbsp;Education,</span><br>&nbsp;<span style="font-family: 'Times New Roman'; font-weight: bold; font-size: 12pt;"> Tianjin&nbsp;Polytechnic&nbsp;University（1）</span><span style="font-family: 'Times New Roman'; font-weight: bold; font-size: 12pt;"><br>（短期请假Short&nbsp;Leave）</span></font> 
         </div>
         <p class="MsoNormal" style="text-align:right;margin-right: 30%;">
	        <font face="楷体"><span style="font-family: 楷体_GB2312; font-weight: bold; font-size: 10.5pt;">&nbsp; 国教院（表</span><span style="font-family: 'Times New Roman'; font-weight: bold; font-size: 10.5pt;">1</span><span style="font-family: 楷体_GB2312; font-weight: bold; font-size: 10.5pt;">）</span><span style="font-family: 'Times New Roman'; font-weight: bold; font-size: 10.5pt;">[2015](&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;)</span><span style="font-family: 'Times New Roman'; font-weight: bold; font-size: 12pt;"></span></font>
         </p>
      
    </s:if>
    <s:elseif test="#leaves.type==2">
         <div align="center"> 
	     <font face="楷体"><span style="font-family: 楷体; font-weight: bold; font-size: 18pt;">&nbsp;天津工业大学国际教育学院学院请假单（一）<br></span>&nbsp;<span style="font-family: 'Times New Roman'; font-weight: bold; font-size: 12pt;">Application&nbsp;Form&nbsp;for&nbsp;Leave&nbsp;of&nbsp;School&nbsp;of&nbsp;International&nbsp;Education,</span><br>&nbsp;<span style="font-family: 'Times New Roman'; font-weight: bold; font-size: 12pt;"> Tianjin&nbsp;Polytechnic&nbsp;University（1）</span><span style="font-family: 'Times New Roman'; font-weight: bold; font-size: 12pt;"><br>（长期请假Long&nbsp;Leave）</span></font> 
         </div>
         <p class="MsoNormal" style="text-align:right;margin-right: 30%;">
	        <font face="楷体"><span style="font-family: 楷体_GB2312; font-weight: bold; font-size: 10.5pt;">&nbsp; 国教院（表</span><span style="font-family: 'Times New Roman'; font-weight: bold; font-size: 10.5pt;">2</span><span style="font-family: 楷体_GB2312; font-weight: bold; font-size: 10.5pt;">）</span><span style="font-family: 'Times New Roman'; font-weight: bold; font-size: 10.5pt;">[2015](&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;)</span><span style="font-family: 'Times New Roman'; font-weight: bold; font-size: 12pt;"></span></font>
         </p>
    </s:elseif>
     
     
      <table class="contenttable" border="1" cellpadding="0" cellspacing="0" >
	    <tbody>
		<tr>
			<td colspan="2" style="border:1pt solid windowtext;" valign="center" width="200"><font face="楷体">&nbsp; 
				中文姓名 Chinese&nbsp;Name：&nbsp; ${student.stuname}</font></td>
			<td colspan="5" style="border:1pt solid windowtext;" valign="center" width="300"><font face="楷体"> 
				专业 Major：${student.classes.major}</font></td>
			<td colspan="5" style="border:1pt solid windowtext;" valign="center" width="300"><font face="楷体">&nbsp; 
				国籍 Nationality： ${student.nation }
			</font></td>
		</tr>
		<tr>
			<td colspan="2" style="border:1pt solid windowtext;" valign="center" width="200"><font face="楷体">&nbsp;英文姓名 Englist Name：${student.firstname}${student.lastname} </font></td>
			<td colspan="5" style="border:1pt solid windowtext;" valign="center" width="300"><font face="楷体"> 
				班级Class： ${student.classes.classname }
			</font></td>
			<td colspan="5" style="border:1pt solid windowtext;" valign="center" width="300"><font face="楷体">&nbsp; 
				联系号码 Contact&nbsp;Number:${leaves.telephone } 
			</font></td>
		</tr>
		<tr>
			<td style="border:1pt solid windowtext;" colspan="2" valign="center" width="200"><div align="center"> 
				<font face="楷体"><strong><br></strong><br>请假<br>事由  
				Reasons <br>for <br>Leave<strong><br><br><br></strong></font></div> 
			</td>
			<td colspan="10" style="border:1pt solid windowtext;" valign="center" width="600"><font face="楷体">
				&nbsp;&nbsp;${leaves.leavereason }&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <br><br><br>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; 签字 Signature
				： &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <br><br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 年&nbsp;yy&nbsp;&nbsp;&nbsp;&nbsp;月&nbsp;mm&nbsp;&nbsp;&nbsp;&nbsp;日&nbsp;dd				
			</font></td>
		</tr>
		<tr>
			<td style="border:1pt solid windowtext;" valign="center" colspan="2" width="200" align="center">
				<font face="楷体"><strong><br></strong>请假时间Leaving&nbsp;period<strong><br><br> 
			</strong></font></td>
			<td colspan="10" style="border:1pt solid windowtext;"  valign="center" width="600" align="center"><font face="楷体">
				从&nbsp; &nbsp;<s:property value="#leaves.leavingdate.substring(0,4)" /> &nbsp;&nbsp; 年 &nbsp; &nbsp;<s:property value="#leaves.leavingdate.substring(5,7)" /> &nbsp; 月&nbsp; &nbsp;<s:property value="#leaves.leavingdate.substring(8)" />&nbsp; &nbsp; 日至&nbsp;&nbsp;<s:property value="#leaves.backdate.substring(0,4)" /> &nbsp; &nbsp; 年&nbsp; &nbsp;<s:property value="#leaves.backdate.substring(5,7)" />&nbsp; 月 &nbsp;<s:property value="#leaves.backdate.substring(8)" /> &nbsp; 日，共 &nbsp; &nbsp; 天。
                <br><br>From&nbsp;the &nbsp;&nbsp;<s:property value="#leaves.leavingdate.substring(0,4)" /> &nbsp; yy&nbsp; &nbsp;<s:property value="#leaves.leavingdate.substring(5,7)" /> &nbsp; mm&nbsp; &nbsp; <s:property value="#leaves.leavingdate.substring(8)" />&nbsp; dd&nbsp;&nbsp;to&nbsp;&nbsp;&nbsp;<s:property value="#leaves.backdate.substring(0,4)" />&nbsp;&nbsp;yy&nbsp; &nbsp;<s:property value="#leaves.backdate.substring(5,7)" />&nbsp; mm&nbsp; &nbsp;<s:property value="#leaves.backdate.substring(8)" />&nbsp; dd,&nbsp;Totally&nbsp;_____days.
			</font></td>
		</tr>
		<s:if test="#leaves.type==1">
		   <tr>
			<td style="border:1pt solid windowtext;" colspan="2" valign="center" width="200" align="center"> 
				<font face="楷体">批准Approved&nbsp;by<strong>  
			</strong></font></td>
			<td colspan="5" style="border:1pt solid windowtext;" valign="top" width="300"  >
<font face="楷体">			  班主任意见/Supervisor</font>：<br><br><br><br><br><br><br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <font face="楷体">签字Signature：</font><br><br><br><br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; <font face="楷体">年 yy &nbsp;&nbsp;    月 mm&nbsp;&nbsp;&nbsp;&nbsp;    日 dd
</font>			
			</td>
			<td colspan="5" style="border:1pt solid windowtext;" valign="top" width="300" align="left"><font face="楷体">  
				学院教学办意见（211办公室）/Teaching&nbsp;Affairs/Teaching&nbsp;Affairs <br>Administration&nbsp;Office&nbsp;Ⅲ&nbsp;(Room&nbsp;211)&nbsp;：  
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <br><br><br><br><br></font><div align="center"><font face="楷体">&nbsp;签字Signature： <br><br><br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 年&nbsp;yy&nbsp;&nbsp;&nbsp;&nbsp;月&nbsp;mm&nbsp;&nbsp;&nbsp;&nbsp;日&nbsp;dd<br><br></font></div></td>
		</tr>
		</s:if>
		<s:elseif test="#leaves.type==2">
		   <tr>
			<td style="border:1pt solid windowtext;" valign="center" width="200" colspan="2" align="center"> 
				<font face="楷体">批准Approved&nbsp;by<strong>  
			</strong></font></td>
			<td colspan="3" style="border:1pt solid windowtext;" valign="top" width="250"><font face="楷体">
				班主任意见/Supervisor： &nbsp;&nbsp;
				<br><br><br><br><br><br><br>签字 Signature：<br><br>&nbsp;<br>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; 年&nbsp;yy&nbsp;&nbsp;&nbsp;&nbsp;月&nbsp;mm&nbsp;&nbsp;&nbsp;&nbsp;日&nbsp;dd
			</font></td>
			<td colspan="3" style="border:1pt solid windowtext;" valign="top" width="350" align=""><font face="楷体"> 
				学院教学办意见（211办公室）/Teaching&nbsp;Affairs/Teaching&nbsp;Affairs&nbsp;Administration&nbsp;Office&nbsp;Ⅲ&nbsp;(Room&nbsp;211)&nbsp;： 
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <br><br><br><br><br></font><div align="center"><font face="楷体">&nbsp;签字Signature： <br><br><br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
年&nbsp;yy&nbsp;&nbsp;&nbsp;&nbsp;月&nbsp;mm&nbsp;&nbsp;&nbsp;&nbsp;日&nbsp;dd 
			</font></div></td>
			<td colspan="4" style="border:1pt solid windowtext;" valign="top" width="250" align="left"><font face="楷体">  
				教学副院长意见/Depty Dean ：  
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <br><br><br><br><br></font><div align="center"><font face="楷体">&nbsp;签字Signature： <br><br><br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
年&nbsp;yy&nbsp;&nbsp;&nbsp;&nbsp;月&nbsp;mm&nbsp;&nbsp;&nbsp;&nbsp;日&nbsp;dd 
			</font></div></td>
		</tr>
		</s:elseif>
		<tr>
			<td style="border:1pt solid windowtext;" colspan="2" valign="center" width="200" align="center"> 
				<font face="楷体">备注Notes<strong>  
			</strong></font></td>
			<td colspan="10" style="border:1pt solid windowtext;" valign="center" width="619"> 
				<font face="楷体"><strong></strong></font><p><font face="宋体">1、此表用于3日及以内的短期请假； This form is used for leave no more 3 days;</font></p><p><font face="宋体">2、学生到学院401室办理请假手续，并将请假批准单出示给任课老师；</font></p><p><font face="宋体">&nbsp;You need to make an application at room 401, after getting the permission, show it to the course teacher; </font></p><p><font face="宋体"> 
3、无法及时到401室办理请假手续者，须补办，并在上课之前告知任课老师;</font></p><p><font face="宋体">&nbsp;Fail to go through the procedure in time, you need to inform the course teacher first and you have to do it as soon as possible; </font></p><p><font face="宋体"> 
4、未经请假或请假未经批准而缺席者，视为旷课；  
</font></p><p><font face="宋体">Without permission, any leave will be seen as absence; </font></p><p><font face="宋体"> 
5、及时销假：学生需在回校后当天（最晚不超过第2天）将请假单交回401，否则按旷课处理；  
You need to report back from leave at room 401 within two days after returning to school and give the application form back to 401,failing to obey the rule will be seen as absent;  
</font></p><p><font face="宋体">6、请假期间注意安全，一切后果自行负责。  
You should be responsible for yourself, especially your safety during the days of leave.</font></p><font face="宋体"><strong></strong></font></td>
		</tr>
		<tr>
			<td style="border:1pt solid windowtext;" valign="center" colspan="2" width="106" align="center"><font face="楷体"><strong> 
				</strong>销假<br>Report&nbsp;back<br>&nbsp;from&nbsp;Leave 
			</font></td>
			<td colspan="5" style="border:1pt solid windowtext;" valign="center" width="288"><p><font face="楷体"><strong> 
				</strong>销假日期Date&nbsp;：<strong> 
			</strong></font></p></td>
			<td colspan="5" style="border:1pt solid windowtext;" valign="center" width="330"><font face="楷体"><strong> 
				</strong>销假人签字Signature：<strong> 
			</strong></font></td>
		</tr>
	</tbody>
</table>
</div>
  </body>
</html>
