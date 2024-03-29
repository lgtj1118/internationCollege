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
    <script src="js/jquery/jquery-1.3.2.min.js"type="text/javascript"></script>
	<script src="js/ligerUI/core/base.js" type="text/javascript"></script>
	<script src="js/ligerUI/ligerui.all.js" type="text/javascript"></script>
    <script type="text/javascript">			
		var ClassData = { 
	Rows: [<%String s = (String) request.getAttribute("classlist");%> <%=s%>]};
    var ClassList = ClassData.Rows;
    var sexData = [{ Sex: 1, text: '男' }, { Sex: 2, text: '女'}];
   $(f_initGrid);
	var manager, g;
	function f_initGrid() {
		g = manager = $("#maingrid").ligerGrid(
			{columns : [
			{   display : '序号',  name : 'id',     width : 40,  type : 'int',hide:true
			},{display : '护照', name : 'passport', minWidth : 100,  editor:{type:'text'}	}
			, {display : '学号', name : 'stuid',  wiminWidthdth : 120, editor: { type: 'text'}
			}, {display : '英文名', name : 'firstname',minWidth : 100, editor: { type: 'text'}
			}, {display : '英文姓', name : 'lastname',minWidth : 100, editor: { type: 'text'}
			}, {display : '中文名', name : 'stuname',minWidth : 80, editor: { type: 'text'}
			} ,{display : '性别', name : 'stusex', minWidth : 50,  editor:{type:'text'}				
			} ,{ display: '班级',  name: 'classid', minWidth: 100, isSort: false,
            editor: { type: 'select', data: ClassList, valueColumnName: 'Classid', displayColumnName: 'Classname' }, 
                  render: function (item)
                    {for (var i = 0; i < ClassList.length; i++)
                        { if (ClassList[i]['Classid'] == item.classid)
                                return ClassList[i]['Classname'];
                        }
                        return item.Classname;
                    }
                }
             ,{display : '电话', name : 'telephone', minWidth : 100,  editor:{type:'text'} 
             } ,{display : '住址', name : 'roomplace', minWidth : 120,  editor:{type:'text'}
             } ,{display : '国籍', name : 'nation', minWidth : 100,  editor:{type:'text'}	}
             ],
					onSelectRow : function(rowdata, rowindex) {
						$("#txtrowindex").val(rowindex);
					},
					//checkbox:true,
					enabledEdit : true,
					clickToEdit : false,
					isScroll : false,
					rownumbers:true, 
					pageSize:30,
					url :'${pageContext.request.contextPath}/system/Stu_stulist.action',
					width : '100%'
					
				});
	}
		var flg= false;
		function f_search(){
			if ((document.all.stuname.value =="")&&(document.all.passport.value =="")){
				$("#maingrid").ligerGrid({
					url : '${pageContext.request.contextPath}/system/Stu_stulist.action'
			   })
			}else{
			var str ="${pageContext.request.contextPath}/system/Stu_stusearch.action?stu.stuname=" + encodeURI(encodeURI($("#stuname").val())
		+"&stu.passport="+encodeURI(encodeURI($("#passport").val())));
			$("#maingrid").ligerGrid({
					url : str
			   })
			}			
		}
		
	function fuzzy (){
		var query = $("#query").val();
		var str ="${pageContext.request.contextPath}/system/Stu_stuFuzzySearch.action?query=" + encodeURI(encodeURI(query));
		$("#maingrid").ligerGrid({
				url : str,
		});
	}
</script>
<style type="text/css">
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
width:200px;height:25px;background: #fefefe;border: 1px solid #bbb;font-size: 14px;color: #333;border-radius: 3px;
}
.l-button{
 width:70px;float:left; margin:20px 160px 5px ;
 border-radiux:5px;
}
</style>
</head>
	<body style="font-size: 12px;">
	<div id="head">
	      <!-- <div class="title" ><br><br><div align="center"><font face="微软雅黑" color="#400000" size="4"><strong>条件选择</strong></font></div></div> -->
	      <div class="search" >
	         <table cellpadding="0" cellspacing="0" class="l-table-edit" >
			<tr>
				<!-- <td align="right" class="l-table-edit-td">&nbsp;姓名:&nbsp;</td>
				<td align="left" class="l-table-edit-td">
				   <input id="stuname" class="link" name="stuname"   />
				</td>
			    <td align="right" class="l-table-edit-td">&nbsp;&nbsp;护照号:&nbsp;</td>
				<td align="left" class="l-table-edit-td">
				  <input id="passport" class="link" name="passport"   />
				</td> -->
				 <td align="right" class="l-table-edit-td">&nbsp;&nbsp;关键字:&nbsp;</td>
				<td align="left" class="l-table-edit-td">
				  <input id="query" class="link" onkeyup="fuzzy()" placeholder="学号 姓名 班级 护照 国籍"/>
				</td>
				<td align="right" class="l-table-edit-td"></td>
				<td align="left" class="l-table-edit-td"></td>				
			</tr>
			<tr>
			  <th colspan="6"><div id="result1"></div></th>
			</tr>						
		</table>
		<!-- <a class="l-button" onclick="f_search()"><strong>查&nbsp;&nbsp;询</strong></a> -->
		<!-- <a class="l-button" onclick="fuzzy()"><strong>查&nbsp;&nbsp;询</strong></a> -->
	      </div>
	    </div>		
		<h2 style="margin: 20px;" ><font face="华文楷体">查询结果显示：</font></h2>			  
		<div class="l-clear"></div>
		<div id="maingrid" ></div>
	</body>
</html>

