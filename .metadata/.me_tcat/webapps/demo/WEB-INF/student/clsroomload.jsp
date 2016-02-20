<%@page import="com.tjpu.bean.Classroom"%>
<%@page import="com.opensymphony.xwork2.ActionContext"%>
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
    <script type="text/javascript" src="js/json.js" charset="utf-8"></script>
    <script type="text/javascript" src="js/jquery-validation/jquery.metadata.js" charset="utf-8"></script>
    <script type="text/javascript" src="js/jquery-validation/messages_cn.js" charset="utf-8"></script>
    <script src="<%=basePath%>js/jquery/jquery-1.6.min.js" type="text/javascript"></script>
	<script src="js/ligerUI/core/base.js" type="text/javascript"></script>
	<script src="js/ligerUI/ligerui.all.js" type="text/javascript"></script>
    <script type="text/javascript">			
		$(f_initGrid);
	var manager, g;
	function f_initGrid() {
		g = manager = $("#maingrid").ligerGrid(
			{columns : [
			{   display : 'ID',  name : 'id',     width : 60,  type : 'int',hide:true
			}, {display : '编号', name : 'num',  minWidth : 120, editor: { type: 'text'}
			}, {display : '名称', name : 'roomname',  minWidth : 120, editor: { type: 'text'}
			} ,{display : '位置', name : 'roomplace',minWidth : 120,editor: { type: 'text'}
			}, {display : '类型', name : 'roomtype',minWidth : 120, editor: { type: 'text'}
			}, {display : '容量', name : 'roomcapacity',minWidth : 100, editor: { type: 'text'}
			}, {display : '实际容量', name : 'realcapacity',minWidth : 100, editor: { type: 'text'}			
			}, {display : '备注', name : 'note',minWidth : 120, editor: { type: 'text'}
			} ],
					onSelectRow : function(rowdata, rowindex) {
						$("#txtrowindex").val(rowindex);
					},
					//checkbox:true,
					enabledEdit : true,
					clickToEdit : false,
					isScroll : false,
					rownumbers:true, 
					pageSize:30,
					url :'${pageContext.request.contextPath}/system/Class_roomlist.action',
					width : '100%'
				});
	}
		
	var flg = false;
	function f_search(){
	  if ((document.all.roomname.value == "") && (document.all.roomcapacity.value == "")) {
			$("#maingrid").ligerGrid({
					url : '${pageContext.request.contextPath}/system/Class_roomlist.action'
			   })
		} else {
			var str = "${pageContext.request.contextPath}/system/Class_roomsearch.action?room.roomname=" + encodeURI(encodeURI($("#roomname").val()) + "&room.roomcapacity=" + encodeURI(encodeURI($("#roomcapacity").val())));
			   $("#maingrid").ligerGrid({
					url : str
			   })
		}
	}
	
	$(document).ready(function(){
		pChan();
		
	});
	
	function fuzzy (){
		var foo = $("#foo").val();
		var str = "${pageContext.request.contextPath}/system/Class_roomSearch.action?room.roomplace=" 
		+ encodeURI(encodeURI($("#address").val())) + "&room.roomcapacity=" + $("#capable").val()+ "&room.roomtype=" + encodeURI(encodeURI(foo));
		
		//	var str = "${pageContext.request.contextPath}/system/Class_roomSearch.action?room.roomplace=" 
		//+ encodeURI(encodeURI($("#address").val())) + "&room.roomcapacity=" + $("#capable").val();
			
			   $("#maingrid").ligerGrid({
					url : str
		 });
	}
	
	function pChan () {
		//alert("2");
		$("#capable").empty();
		var address = $("#address").val();
		var foo = $("#foo").val();
		var url = "${pageContext.request.contextPath}/system/Class_getCapList.action?room.roomplace=" + encodeURI(encodeURI(address)) + "&room.roomtype=" + encodeURI(encodeURI(foo));
		$.ajax({  
	        type : "POST",  
	        url : url,
	        dataType : "JSON", 
	        error: function (){
	        	alert("数据传输错误，请联系管理员！");
	        },
	        success : function(data) {
	        	//alert(data);
	        	
	        	if (data.length > 0){
	        		for(var n=0;n<data.length;n++){
	                	document.getElementById("capable").options.add(new Option(data[n].roomcapacity,data[n].roomcapacity));
	          		}
	          		fuzzy();
	        	} else {
	        		
	        	}
	        }  
	    }); 
	}
	
</script>
<style type="text/css">
h2{
margin-top: 20px;
}
#head{
 width: 99%;
 height:90px;
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
  margin-top: 25px;
}
.l-table-edit{
 margin-top: 10px;
 margin-left: 20px;
}
.link{
width:160px;height:25px;background: #fefefe;border: 1px solid #bbb;font-size: 14px;color: #333;border-radius: 3px;
}
.l-button{
 width:70px;float:left; margin:20px 160px 5px ;
 border-radiux:5px;
}
#address{
  font-size: 12px;
}
</style>
</head>
	<body style="font-size: 12px;">
	<div id="head">
	      <div class="title" ><br><br><div align="center"><font face="微软雅黑" color="#400000" size="4"><strong>条件选择</strong></font></div></div>
	      <div class="search" >
	         <table cellpadding="0" cellspacing="0" class="l-table-edit" >
			<tr>
				<!-- <td align="right" class="l-table-edit-td">&nbsp;教室名称:&nbsp;</td>
				<td align="left" class="l-table-edit-td">
				   <input id="roomname" name="roomname" value="" />
				</td>
			    <td align="right" class="l-table-edit-td">&nbsp;&nbsp;教室容量:&nbsp;</td>
				<td align="left" class="l-table-edit-td">
				  <input id="roomcapacity" class="link" name="roomcapacity" value=""  />
				</td> -->
				<!-- <td align="right" class="l-table-edit-td">&nbsp;教室位置:&nbsp;</td>
				<td align="left" class="l-table-edit-td">
				   <input id="roomname" name="roomname" value="" />
				</td> -->
				<!-- 用下拉框选取所有学院 -->
				<td align="right" class="l-table-edit-td">&nbsp;教室位置:&nbsp;</td>
				<td align="left" class="l-table-edit-td">
					<select id="address" class="link" onchange="pChan()" >
						<%
							List<Classroom> rooms = (List<Classroom>) ActionContext.getContext().get("allRooms");
							Set<String> place = new HashSet<String>();
							for (Classroom r : rooms){
							
								if (!place.contains(r.getRoomplace())){
									place.add(r.getRoomplace());
								
						 %>
						 	<option value="<%=r.getRoomplace() %>"><%=r.getRoomplace() %> </option>
						 <%
						 		}
						 	}
						  %>
					</select>
				</td>
				<td align="right" class="l-table-edit-td">&nbsp;教室类型:&nbsp;</td>
				<td align="left" class="l-table-edit-td">
					<select id="foo" class="link" onchange="pChan()" >
						<%
							Set<String> set = new HashSet<String>();
							for (Classroom r : rooms){
							
								if (!set.contains(r.getRoomtype())){
									set.add(r.getRoomtype());
								
						 %>
						 	<option value="<%=r.getRoomtype() %>"><%=r.getRoomtype() %> </option>
						 <%
						 		}
						 	}
						  %>
					</select>
				</td>
				<td align="right" class="l-table-edit-td">&nbsp;&nbsp;教室容量:&nbsp;</td>
				<td align="right" class="l-table-edit-td">
					<select id="capable" onchange="fuzzy()" class="link" ></select>
				</td>
				<!--   <td align="right" class="l-table-edit-td">&nbsp;&nbsp;教室容量:&nbsp;</td>
				<td align="left" class="l-table-edit-td">
				  <input id="low" class="link" style="width:40px"/>
				  ~
				  <input id="upper" class="link" style="width:40px"/>
				</td> -->
				<!-- <td align="right" class="l-table-edit-td"></td>
				<td align="left" class="l-table-edit-td"></td>	 -->			
			</tr>
			<tr>
			  <th colspan="6"><div id="result1"></div></th>
			</tr>						
		</table>
		<!-- <a class="l-button" onclick="f_search()"><strong>查&nbsp;&nbsp;询</strong></a> -->
		<!-- <a class="l-button" onclick="fuzzy()"><strong>查&nbsp;&nbsp;询</strong></a> -->
	      </div>
	    </div>			
		<h2><font face="华文楷体">查询结果显示：</font></h2>			  
		<div class="l-clear"></div>
		<div id="maingrid" ></div>
	</body>
</html>

