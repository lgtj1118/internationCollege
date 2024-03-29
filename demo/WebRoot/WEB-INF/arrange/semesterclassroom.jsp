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
     <link href="js/ligerUI/skins/ligerui-icons.css" rel="stylesheet" type="text/css">
    <script type="text/javascript" src="js/jquery-validation/jquery.validate.min.js" charset="utf-8"></script>
    <script type="text/javascript" src="js/json2.js" charset="utf-8"></script>
    <script type="text/javascript" src="js/jquery-validation/jquery.metadata.js" charset="utf-8"></script>
    <script type="text/javascript" src="js/jquery-validation/messages_cn.js" charset="utf-8"></script>
    <script src="js/jquery/jquery-1.3.2.min.js"type="text/javascript"></script>
	<script src="js/ligerUI/core/base.js" type="text/javascript"></script>
	<script src="js/ligerUI/ligerui.all.js" type="text/javascript"></script>
	<script src="js/ligerUI/plugins/ligerToolBar.js" type="text/javascript"></script>
	<script type="text/javascript" src="js/semester.js" ></script>
<script type="text/javascript">  
   $(f_initGrid);
	$(f_initGrid1);
	var manager, g;
	function f_initGrid() {
		g = manager = $("#maingrid1").ligerGrid(
		{			
				columns : [
			{   display : 'ID',  name : 'id',     width : 60,  type : 'int',hide:true
			}, {display : '编号', name : 'num',  minWidth : 120, editor: { type: 'text'}
			}, {display : '名称', name : 'roomname',  minWidth : 120, editor: { type: 'text'}
			} ,{display : '位置', name : 'roomplace',minWidth : 140,editor: { type: 'text'}
			}, {display : '类型', name : 'roomtype',minWidth : 120, editor: { type: 'text'}
			}, {display : '容量', name : 'roomcapacity',minWidth : 100, editor: { type: 'text'}
			}, {display : '实际容量', name : 'realcapacity',minWidth : 100, editor: { type: 'text'}			
			}, {display : '备注', name : 'note',minWidth : 120, editor: { type: 'text'}
			} ],
					onSelectRow : function(rowdata, rowindex) {
						$("#txtrowindex").val(rowindex);
					},
					checkbox:true,
					enabledEdit : true,
					clickToEdit : false,
					isScroll : false,
					rownumbers:true, 
					pageSize:30,
					title:'待选教室',
					url :'${pageContext.request.contextPath}/system/Manage_roomlist.action',
					width : '38%'
				});
				}
var managers, gs;
	function f_initGrid1() {
		gs = managers = $("#maingrid2").ligerGrid(
				{			
				columns : [
			{   display : 'ID',  name : 'id',     width : 60,  type : 'int',hide:true
			}, {display : '编号', name : 'num',  minWidth : 120, editor: { type: 'text'}
			}, {display : '名称', name : 'roomname',  minWidth : 120, editor: { type: 'text'}
			} ,{display : '位置', name : 'roomplace',minWidth : 140,editor: { type: 'text'}
			}, {display : '类型', name : 'roomtype',minWidth : 120, editor: { type: 'text'}
			}, {display : '容量', name : 'roomcapacity',minWidth : 100, editor: { type: 'text'}
			}, {display : '实际容量', name : 'realcapacity',minWidth : 100, editor: { type: 'text'}			
			}, {display : '备注', name : 'note',minWidth : 120, editor: { type: 'text'}
			} ],
					onSelectRow : function(rowdata, rowindex) {
						$("#txtrowindex").val(rowindex);
					},
					checkbox:true,
					enabledEdit : true,
					clickToEdit : false,
					isScroll : false,
					rownumbers:true, 
					pageSize:30,
					title:'已选教室',
					url :'${pageContext.request.contextPath}/system/Manage_semesterroomlist.action',
					width : '38%'
				});
				}
	function f_selected(){
	 var semester = $("#semester option:selected").val();
       if(semester.length!=0){
	       var row = manager.getSelectedRow();
           if (!row) { alert('请至少选择一个课程！'); return; }
           var rows = g.getCheckedRows();
           var str = "";
           $(rows).each(function () {
               str += this.id + ",";
           });
           $.post("${pageContext.request.contextPath}/system/Manage_semesterroomadd.action?ids="+str+"&semester="+semester,null,function(){
           alert("选定成功！");
            window.location.reload();
           //manager.deleteSelectedRow();
          })
	   }else{
	     alert("请先选定学期");
	   }
	   }
	function f_delete(){
	var row = managers.getSelectedRow();
      if (!row) { alert('请至少选择一个课程！'); return; }
      var rows = gs.getCheckedRows();
      var str = "";
      $(rows).each(function ()
      {
         str += this.id + ",";
      });
      $.post("${pageContext.request.contextPath}/system/Manage_semesterroomdelete.action?ids="+str,null,function(){
        alert("删选成功！");
        window.location.reload();        
      })
	}

</script>
<style type="text/css">
#contain{
 width: 100%;
 border: 1px solid #c6c6c6;
}
.l-button{
 width:80px; margin:20px 50px ;
 border-radiux:5px;
}
#l-l-button{
 width:80px; 
 margin-top:100px;
 border-radiux:5px;
}
</style>
	</head>
	<body style="padding: 2px">	
	    <div style="margin: 10px;">选择教室，即可作为本学期课程可用教室</div>			
		<div class="l-clear"></div>
		<div id="maingrid1" style="margin: 4px;margin-left:10px; padding: 0; float: left;" ></div>
		<div id="btnclass" style="width:14%;margin: 4px; padding: 0; float: left;" >
		   <div> 学期：&nbsp;<select id="semester" style="" name="semester" >
			     <option value="" ></option>			     
		   </select></div>
		   <a class="l-button" onclick="f_selected()"><strong>选定教室>></strong></a>
		   <a class="l-button" onclick="f_delete()"><strong><<移除教室</strong></a>
		   <!-- <a class="l-button" onclick="f_allselected()"><strong>全部选定>></strong></a>
		   <a class="l-button" onclick="f_alldelete()"><strong><<全部移除</strong></a> -->
		   
		</div>
		<div id="maingrid2" style="margin: 4px;margin-right:10px; padding: 0; margin-left: 10px; float: left;" ></div>		 
	</body>
</html>
