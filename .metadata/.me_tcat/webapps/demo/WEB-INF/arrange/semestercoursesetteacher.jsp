<%@page import="com.opensymphony.xwork2.ActionContext"%>
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
     <link href="js/ligerUI/skins/ligerui-icons.css" rel="stylesheet" type="text/css">
    <script type="text/javascript" src="js/jquery-validation/jquery.validate.min.js" charset="utf-8"></script>
    <script type="text/javascript" src="js/json2.js" charset="utf-8"></script>
    <script type="text/javascript" src="js/jquery-validation/jquery.metadata.js" charset="utf-8"></script>
    <script type="text/javascript" src="js/jquery-validation/messages_cn.js" charset="utf-8"></script>
    <script src="js/jquery/jquery-1.6.min.js"type="text/javascript"></script>
	<script src="js/ligerUI/core/base.js" type="text/javascript"></script>
	<script src="js/ligerUI/ligerui.all.js" type="text/javascript"></script>
	<script src="js/ligerUI/plugins/ligerToolBar.js" type="text/javascript"></script>
<script type="text/javascript" charset="utf-8" >  
   var CoursecreditData = { 
	         Rows: [<%String ss=(String) request.getAttribute("coursecredit");%><%=ss%>]};
   var CourseCredit = CoursecreditData.Rows;
   var CourseCharacterData = { 
	        Rows: [ <%String sss=(String) request.getAttribute("character");%> <%=sss%>]};
   var CourseCharacter = CourseCharacterData.Rows;
   var CourseCheckwayData = { 
	        Rows: [<%String ssss=(String) request.getAttribute("checkway");%> <%=ssss%>]};
   var CourseCheckway = CourseCheckwayData.Rows;  
    var TypeData = [{ roomtype: '多媒体教室', text: '多媒体教室' }, { roomtype: '语音室', text: '语音室'}, { roomtype: '计算机室', text: '计算机室'}, { roomtype: '体验馆', text: '体验馆'}];
	var IsElectiveData = [{ isElective: '0', text: '必修' }, { isElective: '1', text: '限选'}, { isElective: '2', text: '任选'}];	
	$(f_initGrid);
	var manager, g;
	function f_initGrid() {
		g = manager = $("#maingrid").ligerGrid(
				{
			
				columns : [{
				display : '序号',
				name : 'id',
				width : 60,
				hide:true,
				type : 'int'
			}, {
				display : '课程编号',
				name : 'coursenum',
				minWidth : 80,
				//editor: { type: 'int'}
			} , {
				display : '课程名称',
				name : 'coursename',
				minWidth : 80,
				//editor: { type: 'text'}
			}, {
				display : '开课周数',columns:[
				{ display:'起始周' , name:'begainweek',minWidth : 60/* ,editor: { type: 'int'} */ },
				{ display:'结束周' , name:'endweek',  minWidth : 60/* ,editor: { type: 'int'} */ }
				]			
			} , {
				display : '学分',
				name : 'credits',
				minWidth : 60,
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
			}, {
				display : '周课时',
				name : 'weeklesson',
				minWidth : 80,
				//editor: { type: 'int'}
			}, {
				display : '总课时',
				name : 'lessonCount',
				minWidth : 80,
				//editor: { type: 'int'}
			}, {
				display : '课程性质',
				name : 'isElective',
				minWidth : 80,
				//editor: { type: 'select', data: IsElectiveData, valueField: 'isElective' },
                     render: function (item)
                    {
                        if (parseInt(item.isElective) == 0){ return '必修';}
                        else if (parseInt(item.isElective) == 1) { return '限选';} 
                        else if (parseInt(item.isElective) == 2) { return '任选';}                                              
                    } 
			}, {
				display : '教室类型',
				name : 'roomtype',
				minWidth : 80,
				editor: { type: 'select', data: TypeData, valueField: 'roomtype' },
                    render: function (item)
                    {
                        for (var i = 0; i < TypeData.length; i++)
                        {
                            if (TypeData[i]['roomtype'] == item.roomtype)
                                return TypeData[i]['roomtype'];
                        }
                        return item.roomtype;
                    }
			}, {
				display : '任课教师',
				name : 'teachername',
				width : 120,
				render : function(item) {
				  var h = "";
				  h += "<a href='javascript:courseteacher("+ ")'>"+item.teachername+"</a> ";
				  return h;
				 }
			} , {
				display : '上课班级',
				name : 'classes',
				width : 120,
				render : function(item) {
				  var h = "";
				  h += "<a href='javascript:courseclass("+ ")' title='"+item.classes+"' >"+item.classes+"</a> ";
				  return h;
				 }
			}  ],
					onSelectRow : function(rowdata, rowindex) {
						$("#txtrowindex").val(rowindex);
					},
					enabledEdit : true,
					clickToEdit : true,
					isScroll : false,
					checkbox:false,
			        rownumbers:true,
			        pageSize:10,
					url :'${pageContext.request.contextPath}/system/Manage_semestercourselist.action',
					width : '100%',					
				});
	}
	function courseteacher(){
	  var row = manager.getSelectedRow();
	 	if (!row) {
			alert('请选择课程！');
			return;
		}
      var str = "${pageContext.request.contextPath}/system/Manage_courseteacherselect.action?semChosenCourse.id="+row.id;
	  m=$.ligerDialog.open({
			url : str,
			height : 500,
			width : 800,
			title:'课程教师选择',
			isDrag:true,
			isResize : true
		});
	}
	function courseclass(){
	  var row = manager.getSelectedRow();
	 	if (!row) {
			alert('请选择课程！');
			return;
		}
      var str = "${pageContext.request.contextPath}/system/Manage_semesterclassselect.action?semChosenCourse.id="+row.id;
	  m=$.ligerDialog.open({
			url : str,
			height : 500,
			width : 800,
			title:'课程班级选择',
			isDrag:true,
			isResize : true
		});
	}
	function f_save(){
	   var updated = $("#maingrid").ligerGrid('getChanges', "updated");
	   var effectRow = new Object(); 
	   if (updated.length) { 
	     effectRow["updated"] = encodeURI(JSON2.stringify(updated),"UTF-8");	
	     //alert(effectRow["updated"]);  
	   }
	   var ff=encodeURI(encodeURI(effectRow["updated"]));	  
	   /*  $.ajax({
             url: "${pageContext.request.contextPath}/system/Manage_semestercourseteacheradd.action?ff="+ff,
             type: 'post',
             contentType:"application/x-www-form-urlencoded; charset=utf-8",
             success: function(html){
                  //alert("更新成功！");
                  window.location.reload();
             }
});  */
	   $.post("${pageContext.request.contextPath}/system/Manage_semestercourseteacheradd.action", effectRow,   function(){   
          alert("更新成功！");
          window.location.reload();
         }); 
	} 

</script>
<style type="text/css">
body{
 font-size: 12px;
}
.l-button{
 width:70px;float:left; margin:15px 160px 5px ;
 border-radiux:5px;
}
</style>
	</head>
	<% String semester = (String) ActionContext.getContext().get("semestertext"); %>
	<body style="padding: 2px">
	    <div style="margin:10px;" ><font size="4"><strong>注：</strong><br></font>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 请点击设置各个课程的教室类型、任课教师以及上课班级，设置成功后请点击保存按钮！<br><br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <font size="4">学期课程设置学期为：<%-- ${semestertext } --%> <%=semester %></font></div>		
		<div class="l-clear"></div>
		<div id="maingrid" ></div>
		 <strong><a class="l-button" style="width: 80px; margin-top: 20px; margin-left: 40%;" onclick="f_save()">保&nbsp;存</a></strong>
	</body>
</html>