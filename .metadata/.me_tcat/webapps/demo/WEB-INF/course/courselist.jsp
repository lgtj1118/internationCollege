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
    <script src="js/jquery/jquery-1.3.2.min.js"type="text/javascript"></script>
	<script src="js/ligerUI/core/base.js" type="text/javascript"></script>
	<script src="js/ligerUI/ligerui.all.js" type="text/javascript"></script>
	<script src="js/ligerUI/plugins/ligerToolBar.js" type="text/javascript"></script>
<script type="text/javascript">  
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
					width : '100%',
					toolbar: { items: [{ text: '添加',click: add,  icon: 'add' },
					                   { text: '修改',click: beginEdit,  icon: 'edit' },
					                   { text: '删除',click: deleterow,  icon: 'delete' },
					                   { text: '恢复',click: recoveryrow,  icon: 'save' },
					                   { text: '批量添加', click: batchAdd, icon:'add'}
					                   ]}
				});
	}
	
	function batchAdd(){
		var str = "${pageContext.request.contextPath}/system/Class_jmpLoadTxt.action";
		m=$.ligerDialog.open({		   
			url : str,
			height : 400,
			width : 800,
			isResize : true
		});
	}
	
	var m;
   function beginEdit() {
      var row = manager.getSelectedRow();
      if (!row) { alert('请选择一个课程！'); return; }
      var str = "${pageContext.request.contextPath}/system/Class_courseedit.action?course.id="+ row.id
				/* +"&course.num="+encodeURI(encodeURI(row.num))
				+"&course.coursename="+encodeURI(encodeURI(row.coursename))
				+"&course.beginweeks="+encodeURI(encodeURI(row.beginweeks))
				+"&course.endweeks="+encodeURI(encodeURI(row.endweeks))
			    //+"&course.credits="+row.credits
			  	+"&course.character="+encodeURI(encodeURI(row.character))
			    +"&course.checkway="+encodeURI(encodeURI(row.checkway))
				+"&course.teacher="+encodeURI(encodeURI(row.teacher)) */;
	  m=$.ligerDialog.open({
			url : str,
			height : 450,
			width : 430,
			title:'更新课程',
			isDrag:true,
			isResize : true
		});
	}
	var m;
    function add(){
	var str = "${pageContext.request.contextPath}/system/Class_coursebeginadd.action";	
		m=$.ligerDialog.open({
			url : str,
			height : 540,
			width : 430,
			isDrag:true,
			showMax:true,
			showToggle:true,
			slide: false,			
			modal:false,
			left:200,
			title:'添加课程',
			allowClose:true,
		    isResize : false
		});
		 //window.open(str,'toolbar=no,scrollbars=yes,resizable=no,top=0,left=0,width=400,height=300');
	   //window.open (str, 'newwindow', 'height=450, width=300, top=200, left=400, toolbar=no, menubar=no, scrollbars=no, resizable=no,location=n o, status=no');
	}
	function deleterow() {
	var row = manager.getSelectedRow();
		if (!row) {
			alert('请选择课程！');
			return;
		}
	$.ligerDialog.confirm("是否删除？第一次删除将会使该课程不可用。如果没有成绩或记录与此课程关联，第二次删除会彻底清除记录，否则不做任何操作。", function (yes){
         if(yes){
            $.ligerDialog.prompt('请输入确认密码', function (yes, value){
               if (yes){
                //验证密码
                  var userid = ${sessionScope.user.id};
                  $.post("${pageContext.request.contextPath}/system/User_pwdcheck.action?user.id="+ userid
		            +"&user.password="+value , null, function(data) {
					if (data == "fail") {
						alert("输入的密码不正确!");						
					} else {
						var rows = g.getCheckedRows();
                        var str = "";
                        $(rows).each(function (){ str += this.id; });
	                    /* $.post("${pageContext.request.contextPath}/system/Class_coursedelete.action?ids="+ str); */
			            $.post("${pageContext.request.contextPath}/system/Class_coursedelete.action?ids="+str,null,function(){
			             //manager.deleteSelectedRow();
			            //window.location.reload();
			            g.loadData();
			            });
			           
					}
				   });	
			    }
			});														          
		}
	});
}
	function fuzzy () {
		var t = $("#searchText").val();
		$("#maingrid").ligerGrid({
		  url:"${pageContext.request.contextPath}/system/Class_courseFuzzy.action?fuzzyText=" + encodeURI(encodeURI(t))
		  	+ "&queryType=" + $("#coursecharacter").val() 
		});
	}
	function recoveryrow(){
	  var row = g.getSelectedRow();
	  if(!row){alert("请先选择一项！");return;}
	  if(row.isDeleted==0){
	     //alert("该课程未被删除，无需恢复！");
	  }else{
	     $.post("${pageContext.request.contextPath}/system/Class_courserecovery.action?course.id="+row.id,null,function(){
	       //alert("该课程已恢复！");
	       //window.location.reload();
	       g.loadData();
	     })
	  }
	}
	
/* 	function f_search(){
	  var coursename = $("#coursename").val();
	  var num = $("#num").val();
	  var character = $("#coursecharacter").val();
	  if(coursename.length==0&&num.length==0&&character.length==0){
	    $("#maingrid").ligerGrid({
		  url:'${pageContext.request.contextPath}/system/Class_courselist.action'
		})
	  }else{
	    var str = "${pageContext.request.contextPath}/system/Class_coursesearch.action?course.coursename="+encodeURI(encodeURI(coursename))
	    +"&course.num="+encodeURI(encodeURI(num))
	    +"&course.character="+encodeURI(encodeURI(character));
	    $("#maingrid").ligerGrid({
		  url:str
		})
	    
	  }
	} */
</script>
<style type="text/css">
#head{
 width: 99%;
 height:80px;
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
width:160px;height:25px;background: #fefefe;border: 1px solid #bbb;font-size: 14px;color: #333;border-radius: 3px;
}
.l-button{
 width:70px;float:left; margin:15px 160px 5px ;
 border-radiux:5px;
}
.l-dialog{
  width:300px;
}
</style>
	</head>
	<body style="padding: 2px">		
		<div id="head">
	      <div class="search" >
	         <table cellpadding="0" cellspacing="0" class="l-table-edit" width="100%" >
			  
			<tr>
				<td align="right" class="l-table-edit-td" width="100px" >&nbsp;&nbsp;关键字:&nbsp;</td>
				<td align="left" class="l-table-edit-td">
				  <input id="searchText" class="link" onkeyup="fuzzy()" name="searchText" />
				</td>		
			   <td align="right" class="l-table-edit-td">&nbsp;&nbsp;&nbsp;课程性质:&nbsp;</td>
				<td align="left" class="l-table-edit-td">
				   <select id="coursecharacter" name="coursecharacter" onchange="fuzzy()" class="link" >
				      <option value="-1" ></option>
				      <option value="0" >必修</option>
				      <option value="1" >限选</option>
				      <option value="2" >任选</option>				 
				   </select>
				</td>
				<!-- <td align="right" class="l-table-edit-td"><a class="l-button" onclick="fuzzy()"><strong>查&nbsp;&nbsp;询</strong></a></td> -->	
			</tr>						
		</table>
		<!-- <a class="l-button" onclick="f_search()"><strong>查&nbsp;&nbsp;询</strong></a> -->
		
	      </div>
	    </div>		
		<div class="l-clear"></div>
		<div id="maingrid" ></div>
	</body>
</html>
