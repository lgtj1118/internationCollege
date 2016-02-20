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
    <title>天津工业大学国籍教育学院教学服务系统</title>	   
	<link href="<%=basePath%>js/ligerUI/skins/Aqua/css/ligerui-all.css" rel="stylesheet"type="text/css" />	
	<link href="<%=basePath %>js/ligerUI/skins/Gray/css/all.css" rel="stylesheet" type="text/css"/>	
	<link href="<%=basePath%>css/date.css" rel="stylesheet" type="text/css"/>
    <script src="js/jquery/jquery-1.6.min.js"type="text/javascript"></script>
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
			}, {display : '课程名称', name : 'coursename',  minWidth : 120, editor: { type: 'text'}
			}, {display : '护照号', name : 'passport',  minWidth : 120, editor: { type: 'text'}
			}, {display : '英文名', name : 'firstname',minWidth : 100, editor: { type: 'text'}
			}, {display : '英文姓', name : 'lastname',minWidth : 100, editor: { type: 'text'}
			}, {display : '中文名', name : 'stuname',minWidth : 80, editor: { type: 'text'}
			}, { display: '班级',  name: 'classname', minWidth: 100, editor: { type: 'text'}
            }, {display : '日期', name : 'date',minWidth : 80, editor: { type: 'text'}
			}, {display : '时间', name : 'time',minWidth : 80, editor: { type: 'text'}			
            }, {display : '考勤状态', name : 'type',minWidth : 80, 
            editor: { type: 'select', data: TypeData, valueField: 'type' },
                    render: function (item)
                    {
                        if (parseInt(item.type) == 0){ var h="<span style='color:black;'>正常</span>" ;return h;}
                        else if (parseInt(item.type) == 1) { var h="<span style='color:orange;'>迟到</span>" ;return h;}
                        else if (parseInt(item.type) == 2) { var h="<span style='color:blue;'>早退</span>" ;return h;}
                        else if (parseInt(item.type) == 3) { var h="<span style='color:red;'>旷课</span>" ;return h;}
                    }}
			],
					onSelectRow : function(rowdata, rowindex) {
						$("#txtrowindex").val(rowindex);
					},
					enabledEdit : true,
					clickToEdit : false,
					isScroll : false,
			         rownumbers:true,
			         pageSize:20,
					//data : AttendenceData,
					url:'${pageContext.request.contextPath}/system/Manage_allattendencelist.action',
					width : '100%'
				});
	}	
 	function f_class(){
 		var classid = $("#classid").val();
 		var url = "${pageContext.request.contextPath}/system/Class_classStuList.action?cls.id=" + classid;
		$.ajax({  
	        type : "POST",  
	        url : url,
	        dataType : "JSON", 
	        error: function (){
	        	;
	        },
	        success : function(data) {
	        	$("#stuid").empty(); 
	        	if (data.length > 0){
	        	document.getElementById("stuid").options.add(new Option('',''));
	        		for(var n=0;n<data.length;n++){
	                	var name = data[n].stuname+"("+data[n].firstname+" "+data[n].lastname+")";
	                	document.getElementById("stuid").options.add(new Option(name,data[n].passport));
	          		} 
	        	} else {
	        	}
	        }  
	    }); 
 	}
 	function f_search(){
      var classid = $("#classid").val();
      var studentid = $("#stuid").val();
      var coursenum = $("#courseid").val();
      var startdate = $("#startdate").val();
      var enddate = $("#enddate").val();
      if(startdate.length==0&&enddate.length!=0){
        alert("请输入起始日期！");
      }else{
        if(startdate.length!=0&&enddate.length==0){
           alert("请输入截止日期！");
        }else{
          if (classid.length==0&&(studentid==null||studentid.length==0)&&coursenum.length==0&&startdate.length==0&&enddate.length==0) {
			$("#maingrid").ligerGrid({
					url : '${pageContext.request.contextPath}/system/Manage_allattendencelist.action'
			 })
	      } else {
	       var str = "${pageContext.request.contextPath}/system/Manage_searchattendencelist.action?cls.id="+classid+"&stu.stuid="+studentid
	        + "&semChosenCourse.coursenum="+ $("#courseid").val()+"&startdate="+startdate+"&enddate="+enddate;
		   $("#maingrid").ligerGrid({
			 url : str
		   })
	     }
       }
    }
 }
</script>
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
				<td align="right" class="l-table-edit-td" width="100px" >&nbsp;&nbsp;课程:&nbsp;</td>
				<td align="left" class="l-table-edit-td">
				  <select id="courseid" name="courseid" class="link" onchange="f_search()"  >
				    <option value="" ></option>
				    <s:iterator value="#courselist" id="gg" >
				      <option value="${gg.num}" >${gg.coursename }</option>
				    </s:iterator>
				  </select>
				</td>			
			</tr>
			 <tr>				
			    <td align="right" class="l-table-edit-td" width="100px" >&nbsp;&nbsp;班级:&nbsp;</td>
				<td align="left" class="l-table-edit-td">
				  <select id="classid" name="classid" class="link" onchange="f_class();f_search()" >
				     <option value="" ></option>
				     <s:iterator id="c" value="#classlist" >
				       <option value="${c.id }" >${c.classname }</option>
				     </s:iterator>
				  </select>
				</td>
				<td align="right" class="l-table-edit-td">&nbsp;&nbsp;学生姓名:&nbsp;</td>
				<td align="left" class="l-table-edit-td">
				 <select id="stuid" name="stuid" class="link" onchange="f_search()" ></select>
				</td>	
			</tr>
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
		</div>
		
		<div class="l-clear"></div>
		<div id="maingrid" ></div>
	</body>
</html>

