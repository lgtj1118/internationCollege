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
				name : 'num',
				minWidth : 120,
				editor: { type: 'text'}
			} , {
				display : '课程名称',
				name : 'coursename',
				minWidth : 120,
				editor: { type: 'text'}
			}, {
				display : '课程名称（英文）',
				name : 'coursename_en',
				minWidth : 120,
				editor: { type: 'text'}
			},{
				display : '开课周数',columns:[
				{ display:'起始周' , name:'beginweeks',minWidth : 60,editor: { type: 'int'} },
				{ display:'结束周' , name:'endweeks',  minWidth : 60,editor: { type: 'int'} }
				]			
			} , {
				display : '学分',
				name : 'credits',
				minWidth : 60
			}, {
				display : '学时',columns:[
				{ display:'周学时' , name:'weeklesson',minWidth : 60,editor: { type: 'int'} },
				{ display:'总学时' , name:'lessoncount',  minWidth : 60,editor: { type: 'int'} }
				]			
			}, {
				display : '课程性质',
				name : 'character',
				minWidth : 120			
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
				display : '开课学院',
				name : 'academic',
				minWidth : 120				
			} , {
				display : '负责教师',
				name : 'teacher',
				width : 120,
				editor: { type: 'text'}
			}  , {
				display : '状态',
				name : 'isDeleted',
				width : 120,
				editor: { type: 'text'},
				render:function (item) {
					if (parseInt(item.isDeleted) == 1) {
						return "<font style='color:red'>不可用</font>";
					} else {
						return "<font style='color:green'>正常</font>";
					}
				}
				
			} ],
					onSelectRow : function(rowdata, rowindex) {
						$("#txtrowindex").val(rowindex);
					},
					enabledEdit : true,
					clickToEdit : false,
					isScroll : false,
					checkbox:false,
			        rownumbers:true,
			        pageSize:15,
					url :'${pageContext.request.contextPath}/system/Class_courselist.action',
					width : '100%'
				});
	}
   function beginEdit() {
            var row = manager.getSelectedRow();
            if (!row) { alert('请选择一个课程！'); return; }
            manager.beginEdit(row);
        }
	function cancelEdit(rowid) {
		manager.cancelEdit(rowid);
	}
	function endEdit(rowid) {
	 var row = manager.getSelectedRow();
		manager.endEdit(row);
	$.post("${pageContext.request.contextPath}/system/Class_courseupdate.action?course.id="+ row.id
				+"&course.num="+encodeURI(encodeURI(row.num))
				+"&course.coursename="+encodeURI(encodeURI(row.coursename))
				+"&course.beginweeks="+encodeURI(encodeURI(row.beginweeks))
				+"&course.endweeks="+encodeURI(encodeURI(row.endweeks))
			    +"&course.credits="+encodeURI(encodeURI(row.credits))
			  	+"&course.character="+encodeURI(encodeURI(row.character))
			    +"&course.checkway="+encodeURI(encodeURI(row.checkway))
				+"&course.teacher="+encodeURI(encodeURI(row.teacher))
				);
	}
	var m;
    function add(){
	var str = "${pageContext.request.contextPath}/system/Class_coursebeginadd.action";
		m=$.ligerDialog.open({
			url : str,
			height : 450,
			width : 430,
			title:'课程添加',
			isDrag:true,
			isResize : true
		});
		
	}
	function deleterow() {
	var row = manager.getSelectedRow();
		if (!row) {
			alert('请选择课程！');
			return;
		}
	$.ligerDialog.confirm('请先确认没有班级开设这门课程！', function (yes){
                       if(yes){
		  var rows = g.getCheckedRows();
            var str = "";
            $(rows).each(function ()
            {
                str += this.id + ",";
            });
	     $.post("${pageContext.request.contextPath}/system/Class_coursedelete.action?ids="
				+ str);
			 manager.deleteSelectedRow();
		}
		});
	}
	
</script>
	</head>
	<body style="padding: 2px">	
		<div class="l-clear"></div>
		<div id="maingrid" ></div>
	</body>
</html>
