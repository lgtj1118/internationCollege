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
    <title></title>	   
	<link href="<%=basePath%>js/ligerUI/skins/Aqua/css/ligerui-all.css" rel="stylesheet"type="text/css" />	
	<link href="<%=basePath %>js/ligerUI/skins/Gray/css/all.css" rel="stylesheet" type="text/css"/>	
	<link href="<%=basePath%>css/date.css" rel="stylesheet" type="text/css"/>
	<link href="js/ligerUI/skins/ligerui-icons.css" rel="stylesheet" type="text/css">
	<script src="js/ligerUI/plugins/ligerToolBar.js" type="text/javascript"></script>
    <script src="js/jquery/jquery-1.6.min.js"type="text/javascript"></script>
    <script src="js/jquery/jquery.js"type="text/javascript"></script>
	<script src="js/ligerUI/core/base.js" type="text/javascript"></script>
	<script src="js/ligerUI/ligerui.all.js" type="text/javascript"></script>
	<script src="js/ligerUI/plugins/ligerDateEditor.js" type="text/javascript"></script>
	<script src="<%=basePath%>js/jquery.date_input.pack.js" type="text/javascript"></script>
<script type="text/javascript">
    $(function(){
	  $('.date_picker').date_input();
   })
    var AttendenceData = { 
	Rows: [<%String s = (String) request.getAttribute("attendencelist");%> <%=s%>]};
    var TypeData = [{ type: 0, text: '正常' }, { type: 1, text: '迟到'}, { type: 2, text: '早退'}, { type: 3, text: '旷课'}];
   $(f_initGrid);
	var manager, g;
	function f_initGrid() {
		g = manager = $("#maingrid").ligerGrid(
			{columns : [
			{   display : '序号',  name : 'id',     width : 40,  type : 'int',hide:true
			}, {display : '护照号', name : 'passport',  minWidth : 120, editor: { type: 'text'}
			}, {display : '中文名', name : 'stuname',minWidth : 80, editor: { type: 'text'}
			},{
				display : '考勤状态',columns:[
				{ display:'正常' , name:'normal',minWidth : 60,editor: { type: 'int'} },
				{ display:'迟到' , name:'late',  minWidth : 60,editor: { type: 'int'} },
				{ display:'早退' , name:'leaveearly',  minWidth : 60,editor: { type: 'int'} },
				{ display:'旷课' , name:'truancy',  minWidth : 60,editor: { type: 'int'} },				
				]			
			},{ display:'缺勤率（%）' , name:'probability',  minWidth : 60,/* editor: { type: 'float'}, */
			    render:function (item) {
					if (parseFloat(item.probability)<=10) {
						return "<font style='color:black'>"+item.probability+"</font>";
					} else if(parseFloat(item.probability)>10&&parseFloat(item.probability)<=20) {
						return "<font style='color:orange'>"+item.probability+"</font>";
					}else{
					    return "<font style='color:red'>"+item.probability+"</font>";
					}
					}
			 } ],
					onSelectRow : function(rowdata, rowindex) {
						$("#txtrowindex").val(rowindex);
					},
					enabledEdit : true,
					clickToEdit : false,
					isScroll : false,
			        rownumbers:true,
			        pageSize:10,
					url : '${pageContext.request.contextPath}/system/Manage_attendencestatistical.action',
					width : '99%',
					toolbar: { items: [					                   
                                       { text: '导出',click: itemclick,  icon: 'outbox' }               
                    ]}
				});//'${pageContext.request.contextPath}/system/Manage_attendencestulist.action'
	}	
  function f_search(){ 
      var startdate = $("#startdate").val();
      var enddate = $("#enddate").val();
      if(startdate.length==0&&enddate.length!=0){
        alert("请输入起始日期！");
      }else{
        if(startdate.length!=0&&enddate.length==0){
           alert("请输入截止日期！");
        }else{
          if (startdate.length==0&&enddate.length==0) {
			$("#maingrid").ligerGrid({
					url : '${pageContext.request.contextPath}/system/Manage_attendencestatistical.action'
			 })
	      } else {
	       var str = "${pageContext.request.contextPath}/system/Manage_singlecourseattendencestatistical.action?course.num="+$("#coursenum").val()+"&cls.id="+$("#classid").val()+"&startdate="+startdate+"&enddate="+enddate;
		   $("#maingrid").ligerGrid({
			 url : str
		   })
	     }
       }
    }
  }
  function itemclick(){
      var startdate = $("#startdate").val();
      var enddate = $("#enddate").val();
      if(startdate.length==0&&enddate.length!=0){
        alert("请输入起始日期！");
      }else{
        if(startdate.length!=0&&enddate.length==0){
           alert("请输入截止日期！");
        }else{
           var str = "${pageContext.request.contextPath}/system/Manage_classattendencedownload.action?course.num="+$("#coursenum").val()+"&cls.id="+$("#classid").val()+"&startdate="+startdate+"&enddate="+enddate; 
           window.location.href=str;
        } 
      }   
  }
    
</script>
	</head>
	<style type="text/css">
body{
  font-size: 12px;
}
#head{
 width: 99%;
 height:100px;
 margin:auto;
 border:4px solid #c6c6c6 ;
}
.title{
 float: left;
 height: 100%;
 width: 10%;
 text-aligncenter;
 border-right:2px solid #c6c6c6 ;
}
.search{
  float: left;
}
.l-table-edit{
 height:90px;
 align:center;
 width: 100%;
}
.search.l-table-edit td{
  border-bottom: 1px solid #c6c6c6 ;
}
.link{
width:180px;height:25px;background: #fefefe;border: 1px solid #bbb;font-size: 14px;color: #333;border-radius: 3px;
}
.l-button{
 width:70px;float:left; margin:0px 160px 5px ;
 border-radiux:5px;
}
</style>
	</head>
	<body >
	<div id="head">
		  <div class="title" ><br><br><div align="center"><font face="微软雅黑" color="#400000" size="4"><strong>条件选择</strong></font></div></div>
	      <div class="search" >	        
		  <table  cellpadding="0" cellspacing="0" class="l-table-edit"  >			 
			<tr>
			    <td align="right" class="l-table-edit-td" width="100px" >&nbsp;&nbsp;起始日期:&nbsp;</td>
				<td align="left" class="l-table-edit-td">
				  <input  id="startdate"   class="date_picker link" >
				</td>
				<td align="right" class="l-table-edit-td">&nbsp;&nbsp;截止日期:&nbsp;</td>
				<td align="left" class="l-table-edit-td">
				  <input  id="enddate"   class="date_picker link"  >
				</td>	
			</tr>									
		</table>
		<a class="l-button" style="width:70px;float:left; margin:0px 160px 5px ;" onclick="f_search()">查&nbsp;&nbsp;询</a>		
		 </div>
	    </div>	
	    <input id="classid" value="${classid }" type="hidden" />
	    <input id="coursenum" value="${coursenum }" type="hidden" />	    
		<div style="margin-top:20px;font-size: 16px;margin-left: 10px;">考勤统计：</div>
	    <div class="l-clear"></div>
		<div id="maingrid" ></div>
		<div  style="display:none;">
	

</body>
</html>