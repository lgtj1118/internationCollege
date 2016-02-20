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
    <script src="js/jquery/jquery-1.6.min.js"type="text/javascript"></script>
	<script src="js/ligerUI/core/base.js" type="text/javascript"></script>
	<script src="js/ligerUI/ligerui.all.js" type="text/javascript"></script>
	<script src="js/ligerUI/plugins/ligerDateEditor.js" type="text/javascript"></script>
<script type="text/javascript">
    var ClassData = { 
	Rows: [<%String s = (String) request.getAttribute("classlist");%> <%=s%>]};
    var ClassList = ClassData.Rows;
    var sexData = [{ Sex: 1, text: '男' }, { Sex: 2, text: '女'}];
    var TypeData = [{ academictype: 0, text: '审核中' }, { academictype: 1, text: '批准'}, { academictype: 2, text: '批准'}];
   $(f_initGrid);
	var manager, g;
	function f_initGrid() {
		g = manager = $("#maingrid").ligerGrid(
			{columns : [
			{   display : '序号',  name : 'id',     minWidth : 40,  type : 'int',hide:true
			},{display : '姓名', name : 'name', minWidth : 80,  editor:{type:'text'}	}
			,{display : '性别', name : 'gender', minWidth : 30,  editor:{type:'text'}	}
			, {display : '出生年月', name : 'brithdate',  minWidth : 100, editor: { type: 'text'}
			}, {display : '民族', name : 'nation',  minWidth : 80, editor: { type: 'text'}
			} ,{display : '政治面貌', name : 'politicalstatus',minWidth : 70,editor: { type: 'password'}
			}, {display : '专业', name : 'major',minWidth : 100, editor: { type: 'text'}
			}, {display : '学号', name : 'assistantnum',minWidth : 80, editor: { type: 'text'}
			}, {display : '班级', name : 'classname',minWidth : 80, editor: { type: 'text'}
			}, {display : '教育层次', name : 'edulevel',minWidth : 80, editor: { type: 'text'}
			} ,{display : '所在学院', name : 'department', minWidth : 80,  editor:{type:'text'}
			} ,{display : '负责人',  minWidth : 80,columns:[
			   {display:'姓名',name:'responsiblename',minWidth:80},
			   {display:'电话',name:'responsibletelephone'}
			]
			} ,{display : '所在学院', name : 'department', minWidth : 80,  editor:{type:'text'}
			} ,{display : '外语语种', name : 'secondlanguagetype', minWidth : 80,  editor:{type:'text'}								
			} ,{display : '外语等级', name : 'secondlanguagelevel', minWidth : 80,  editor:{type:'text'} 
            } ,{display : '联系方式', name : 'telephone', minWidth : 120,  editor:{type:'text'}
            } ,{display : '邮箱', name : 'email', minWidth : 140,  editor:{type:'text'}
            } ,{display : '负责班级', name : 'assistclass', minWidth : 140,  editor:{type:'text'}	}      
           /*  ,{display : '学校意见', name : 'academictype', minWidth : 120,  editor: { type: 'select', data: TypeData, valueField: 'academictype' },
                    render: function (item)
                    {
                        if (parseInt(item.academictype) == 0){ var h="<span style='color:red;'>审核中</span>" ;return h;}
                        else if (parseInt(item.academictype) == 1) { var h="<span style='color:red;'>批准</span>" ;return h;}
                        else if (parseInt(item.academictype) == 2) { var h="<span style='color:red;'>未批准</span>" ;return h;}
                        
                    }} */],
					onSelectRow : function(rowdata, rowindex) {
						$("#txtrowindex").val(rowindex);
					},
					//checkbox:true,
					enabledEdit : true,
					clickToEdit : false,
					isScroll : false,
					rownumbers:true, 
					pageSize:30,
					url :'${pageContext.request.contextPath}/system/Class_assistlist.action',
					width : '100%'
				});
	}	 
	
	function print(){
	  var row = manager.getSelectedRow();
	  var str = "${pageContext.request.contextPath}/system/Class_assistprint.action?assistantteacher.id="+row.id;
	  window.open(str);
	}
</script>
	</head>
	<body style="padding: 2px">
	       
	<!--  <a class="l-button" style="width:70px;float:left; margin:3px;" onclick="print()">打&nbsp;&nbsp;印</a> -->
		<div class="l-clear"></div>
		<div id="maingrid" ></div>
	</body>
</html>

