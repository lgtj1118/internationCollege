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
    <title>天津工业大学国际教育学院教学服务系统</title>	    
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
   var IsElectiveData = [{ isElective: '0', text: '必修' }, { isElective: '1', text: '选修'}];
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
				display : '课程名称',
				name : 'coursename',
				minWidth : 120,
				editor: { type: 'text'}
			} , {
				display : '开课周数',columns:[
				{ display:'起始周' , name:'begainweek',minWidth : 60,editor: { type: 'int'} },
				{ display:'结束周' , name:'endweek',  minWidth : 60,editor: { type: 'int'} }
				]			
			}  , {
				display : '学分',
				name : 'credits',
				minWidth : 60
				
			}, {
				display : '周课时',
				name : 'weeklesson',
				minWidth : 80,
				editor: { type: 'int'}
			}, {
				display : '总课时',
				name : 'lessonCount',
				minWidth : 80
				//editor: { type: 'int'}
			}, {
				display : '课程性质',
				name : 'isElective',
				minWidth : 80,
				render: function (item)
                    {
                        if (parseInt(item.isElective) == 0){ return '必修';}
                        else if (parseInt(item.isElective) == 1) { return '现选';} 
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
			} , {
				display : '班级',
				name : 'classes',
				minWidth : 120,
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
    $(document).ready(function(){
       var semesterlist = ${semesterlist};
       var semester = document.getElementById("semester");
       var date = new Date();
       var nowyear = date.getFullYear(); 
       var nowmonth = date.getMonth();
       var nowsemester ;
       if(nowmonth>9){
           nowsemester = nowyear +"01";
       }else{
           nowsemester = nowyear +"02";
       }
       for(var i=0;i<semesterlist.length;i++){
         var fullyear = semesterlist[i].semester;
         var year = fullyear.substring(0,4);
         var month = fullyear.substring(5,7);        
         var objOption=document.createElement("OPTION");
         if(nowsemester==fullyear){
             if(month==02){
               var semestertext = (parseInt(year)-1)+"-"+year+"学年第二学期";          
             }else if(month==01){
                var semestertext = year+"-"+(parseInt(year)+1)+"学年第一学期";
             }
          objOption.value=fullyear;   
          objOption.text=semestertext;
          semester.add(objOption);
          semester.options[semester.options.length-1].selected='selected';
         }else{
            if(month==02){
              var semestertext = (parseInt(year)-1)+"-"+year+"学年第二学期";          
            }else if(month==01){
               var semestertext = year+"-"+(parseInt(year)+1)+"学年第一学期";
            }
             objOption.value=fullyear;   
             objOption.text=semestertext;
             semester.add(objOption);
         }        
       }     
    });
    function loadSemester(){
    	var semester = $("#semester").val();
    	if (semester == null){    		
    			alert("请选择学期！");
    		return;
    	}
    	var str = "${pageContext.request.contextPath}/system/Manage_Searchsemestercourselist.action?semester=" + semester;   	
		$("#maingrid").ligerGrid({
					url : str
		 });
    }
    function f_download(){
     var semester = $("#semester").val();
    	if (semester == null){    		
    			alert("请选择学期！");
    		return;
    	}
    	var str = "${pageContext.request.contextPath}/system/Manage_semestercoursedownload.action?semester=" + semester;   	
        window.location.href=str;
    }
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
	<table style="margin-top:10px;"  >
	   <tr>
			    <td width="60px" >学期：&nbsp;</td>			    
			    <td width="80px" >
			    <select id="semester" name="semester" onchange="loadSemester()" >			    
			   </select></td>
				<td height="25px">
					<a class="l-button" style="width:60px;float:left; margin-left:10px" onclick="f_download()" >导出</a>
				</td>								
			</tr>
		</table>
		</dir>
		<div class="l-clear"></div>
		<div id="maingrid" ></div>
	</body>
</html>
