<%@page import="org.springframework.web.context.request.SessionScope"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">   
    <title>天津工业大学排课管理系统</title>	    
	<link href="<%=basePath%>js/ligerUI/skins/Aqua/css/ligerui-all.css" rel="stylesheet"type="text/css" />	
	<link href="<%=basePath %>js/ligerUI/skins/Gray/css/all.css" rel="stylesheet" type="text/css"/>	
    <script type="text/javascript" src="js/jquery-validation/jquery.validate.min.js" charset="utf-8"></script>
    <script type="text/javascript" src="js/json2.js" charset="utf-8"></script>
    <script type="text/javascript" src="js/jquery-validation/jquery.metadata.js" charset="utf-8"></script>
    <script type="text/javascript" src="js/jquery-validation/messages_cn.js" charset="utf-8"></script>
    <script src="js/jquery/jquery-1.3.2.min.js"type="text/javascript"></script>
	<script src="js/ligerUI/core/base.js" type="text/javascript"></script>
	<script src="js/ligerUI/ligerui.all.js" type="text/javascript"></script>
	<!-- <script type="text/javascript" src="js/semester.js" ></script> -->
<script type="text/javascript">  
   var CourseData = { 
	        Rows: [<%String s=(String) request.getAttribute("courselist");%><%=s%>]};
   var CourseList = CourseData.Rows;
   var CoursecreditData = { 
	         Rows: [<%String ss=(String) request.getAttribute("coursecredit");%><%=ss%>]};
   var CourseCredit = CoursecreditData.Rows;
   var CourseCharacterData = { 
	        Rows: [ <%String sss=(String) request.getAttribute("character");%> <%=sss%>]};
   var CourseCharacter = CourseCharacterData.Rows;
   var CourseCheckwayData = { 
	        Rows: [<%String ssss=(String) request.getAttribute("checkway");%> <%=ssss%>]};
   var CourseCheckway = CourseCheckwayData.Rows;
   var IsElectiveData = [{ isElective: '0', text: '必修' }, { isElective: '1', text: '限选'}, { isElective: '2', text: '任选'}];
	$(f_initGrid);
	var manager, g;
	function f_initGrid() {
		g = manager = $("#maingrid").ligerGrid(
				{
				columns : [{
				display : 'ID',
				name : 'id',
				width : 60,
				hide:true,
				type : 'int'
			}, {
				display : '课程编号',
				name : 'coursenum',
				minWidth : 120,
				editor: { type: 'text'}
			} , {
				display : '班级',
				name : 'classes',
				minWidth : 120,
				editor: { type: 'text'}
			} , {
				display : '课程名称',
				name : 'coursename',
				minWidth : 120,
				editor: { type: 'text'}
			} , {
				display : '开课周数',columns:[
				{ display:'起始周' , name:'begainweek',minWidth : 60,editor: { type: 'int'} },
				{ display:'结束周' , name:'endweek',  minWidth : 60,editor: { type: 'int'} }
				]			
			} , {
				display : '学分',
				name : 'credits',
				minWidth : 60
				/* editor: { type: 'select', data: CourseCredit, valueColumnName: 'Coursecredit', displayColumnName: 'Coursecredit' }, 
                  render: function (item)
                    {
                        for (var i = 0; i < CourseCredit.length; i++)
                        {
                            if (CourseCredit[i]['Coursecredit'] == item.credits)
                                return CourseCredit[i]['Coursecredit'];
                        }
                        return item.Coursecredit;
                    } */
			} , {
				display : '课程性质',
				name : 'isElective',
				minWidth : 80,
				editor: { type: 'select', data: IsElectiveData, valueField: 'isElective' },
                    render: function (item)
                    {
                        if (parseInt(item.isElective) == 0){ return '必修';}
                        else if (parseInt(item.isElective) == 1) { return '限选';}
                        else if (parseInt(item.isElective) == 2) { return '任选';}                                              
                    }
			} /* , {
				display : '考核方式',
				name : 'checkway',
				minWidth : 120,
				editor: { type: 'select', data: CourseCheckway, valueColumnName: 'Coursecheckway', displayColumnName: 'Coursecheckway' }, 
                  render: function (item)
                    {
                        for (var i = 0; i < CourseCheckway.length; i++)
                        {
                            if (CourseCheckway[i]['Coursecheckway'] == item.checkway)
                                return CourseCheckway[i]['Coursecheckway'];
                        }
                        return item.Coursecheckway;
                    } 
			}  */, {
				display : '任课教师',
				name : 'teachername',
				width : 120,
				editor: { type: 'text'}
			} ],
					onSelectRow : function(rowdata, rowindex) {
						$("#txtrowindex").val(rowindex);
					},
					enabledEdit : true,
					clickToEdit : false,
					isScroll : false,
					checkbox:false,
					pageSize:15,
			        rownumbers:true,
					url :'${pageContext.request.contextPath}/system/Manage_semestercourselist.action',
					width : '100%'
				});
	}
	var m ;	
    function f_next(){
       var semester = $("#semester option:selected").val();
       if(semester.length!=0){
         var str = "${pageContext.request.contextPath}/system/Manage_setemptyslot.action?semester="+semester;      
         m=$.ligerDialog.open({
			url : str,
			height : 400,
			width : 600,
			isDrag:true,
			showMax:true,
			showToggle:true,
			slide: false,			
			modal:false,
			left:200,
			title:'设置选修上课时间',
			allowClose:true,
		    isResize : false
		});
       }else{
         alert("请先选定学期");
     
       }
    }
    
  $(document).ready(function(){
		loadSemester();
		
	});
   
    var flag = false;
    function loadSemester(){
    	var semester = $("#semester").val();
    	if (semester == null){
    		if (flag)
    			alert("请选择学期！");
    		flag = true;
    		return;
    	}
    	//alert(semester);
    	var str = "${pageContext.request.contextPath}/system/Manage_Searchsemestercourselist.action?semester=" + semester;    	
		$("#maingrid").ligerGrid({
					url : str
		 });
    }
    
   function manual(){
   	var str = "system/Manage_manualArrange.action?semChosenCourse.semester="+$("#semester").val();
	 window.location.href=str;
   }
 $(document).ready(function(){			
	var nowDate = new Date();
	var nowYear = nowDate.getFullYear();  
	var lastYear = nowYear-1;
	var before = lastYear-1;
	var nextYear = nowYear+1;
	var nowuptext = lastYear+"-"+nowYear+"学年第一学期";
	var nowupvalue = nowYear+"01";
	var nowdowntext = lastYear+"-"+nowYear + "学年第二学期";
	var nowdownvalue = nowYear+"02";
	var semester = document.getElementById("semester");
	var objOption=document.createElement("OPTION"); 
    var objOption1=document.createElement("OPTION");   
    objOption.value=nowupvalue;   objOption.text=nowuptext;
    objOption1.value=nowdownvalue;  objOption1.text=nowdowntext;
    var month = nowDate.getMonth();
	var now;
	if (month > 9) {
		now = nowYear + "01";
	} else {
		now = nowYear + "02";
	}
	if(now==nowupvalue){
        semester.add(objOption);
        semester.options[semester.options.length-1].selected='selected';     		
	}else if(now==nowdownvalue) {      
        semester.add(objOption1); 
        semester.options[semester.options.length-1].selected='selected';
	}
        
    
})   
</script>
<style type="text/css">
body {
	font-size: 12px;
}
.l-button{
  font-size: 12px;
}
</style>
	</head>
	<body style="padding: 2px">			
	<dir style="float: left; padding-left:10px">
	<div style="margin:10px;" ><font size="4"><strong>注：</strong>
	</font><br>&nbsp;&nbsp; &nbsp; 排课之前，请先设置学期开课课程，学期使用教室。
	<!-- <strong style="color:red">任选课必须手动置入。</strong> -->
	</div>
	<table >
			<tr>
				<td colspan="4"><img alt="flow_chat" src="images/flow_chat1.jpg" height="100px"></td>
			</tr>
			<tr>
			    <td width="60px" >学期：&nbsp;</td>			    
			    <td width="80px" >
			    <select id="semester" name="semester">
			     <!-- <option value="" ></option>
			     <option value="201401" >2014学年上学期</option>
			     <option value="201402" >2014学年下学期</option>
			     <option value="201501" >2015学年上学期</option>
			     <option value="201502" >2015学年下学期</option> -->
			   </select></td>
				<td height="25px">
					<a class="l-button" style="width:60px;float:left; margin-left:10px" onclick="f_next()" >下一步</a>
				</td>				
				<td height="25px">
					<a class="l-button" style="width:60px;float:left; margin-left:10px" onclick="manual()" >手动排课</a>
				</td>
				<td></td>
			</tr>
		</table>
		</dir>
		<div class="l-clear"></div>
		<div id="maingrid" ></div>
	</body>
</html>
