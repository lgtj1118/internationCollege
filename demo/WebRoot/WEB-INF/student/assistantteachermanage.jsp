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
	<script src="js/ligerUI/plugins/ligerToolBar.js" type="text/javascript"></script>
    <script src="js/jquery/jquery-1.6.min.js"type="text/javascript"></script>
	<script src="js/ligerUI/core/base.js" type="text/javascript"></script>
	<script src="js/ligerUI/ligerui.all.js" type="text/javascript"></script>
	<script src="js/ligerUI/plugins/ligerDateEditor.js" type="text/javascript"></script>
<script type="text/javascript">
    var ClassData = { 
	Rows: [<%String s = (String) request.getAttribute("classlist");%> <%=s%>]};
    var ClassList = ClassData.Rows;
    var sexData = [{ Sex: 1, text: '男' }, { Sex: 2, text: '女'}];
     var TypeData = [{ academictype: 0, text: '审核中' }, { academictype: 1, text: '批准'}, { academictype: 2, text: '未批准'}];
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
			} ,{display : '负责人',  minWidth : 120,columns:[
			   {display:'姓名',name:'responsiblename',minWidth:80},
			   {display:'电话',name:'responsibletelephone'}
			]
			} ,{display : '外语语种', name : 'secondlanguagetype', minWidth : 80,  editor:{type:'text'}								
			} ,{display : '外语等级', name : 'secondlanguagelevel', minWidth : 80,  editor:{type:'text'} 
            } ,{display : '联系方式', name : 'telephone', minWidth : 120,  editor:{type:'text'}
            } ,{display : '邮箱', name : 'email', minWidth : 140,  editor:{type:'text'}
            } ,{display : '负责班级', name : 'assistclass', minWidth : 140,  editor:{type:'text'}	}           
            /* ,{display : '学校意见', name : 'academictype', minWidth : 120,  editor: { type: 'select', data: TypeData, valueField: 'academictype' },
                    render: function (item)
                    {
                        if (parseInt(item.academictype) == 0){ var h="<span style='color:red;'>审核中</span>" ;return h;}
                        else if (parseInt(item.academictype) == 1) { var h="<span style='color:red;'>批准</span>" ;return h;}
                        else if (parseInt(item.academictype) == 2) { var h="<span style='color:red;'>未批准</span>" ;return h;}
                        
                    }}   */ ],
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
					width : '100%',
					toolbar: { items: [{ text: '录入',click: applyassist,  icon: 'add' },
					                   { text: '修改',click: editassist,  icon: 'edit' },
					                   { text: '删除',click: deleteassist,  icon: 'delete' }				                   
					                   ]}
				});
	}	 
	var m;
	function apply(){
	var row = manager.getSelectedRow();
		if (!row) {
			alert('请选择至少一项！');
			return;
		}
    if(row.academictype==1||row.academictype==2){
       alert('该项已审核！');
    }else{
       $.post("${pageContext.request.contextPath}/system/Class_assistagree.action?assistantteacher.id="+row.id,null,function(){
         alert('提交成功！');
         g.loadData();
       });
    }
	}
	function against(){
	var row = manager.getSelectedRow();
		if (!row) {
			alert('请选择至少一项！');
			return;
		}
    if((row.academictype==1)||(row.academictype==2)){
       alert('该项已审核或驳回！');
    }else{
       $.post("${pageContext.request.contextPath}/system/Class_assistagainst.action?assistantteacher.id="+row.id,null,function(){
         alert('提交成功！');
         g.loadData();
       });
    }
	}
	function print(){
	  var row = manager.getSelectedRow();
	  if(row.academictype==1){
	    var str = "${pageContext.request.contextPath}/system/Class_assistprint.action?assistantteacher.id="+row.id;
	    window.open(str);
	  }else{
	     alert("请先审核通过再打印！");
	  }
	  
	}
	var m;
	function applyassist(){	
	var str = "${pageContext.request.contextPath}/system/Class_assistapply.action";
		m=$.ligerDialog.open({
			url : str,
			height : 600,
			width : 750,
			isDrag:true,
			showMax:true,
			showToggle:true,
			slide: false,			
			modal:false,
			left:200,
			title:'助理班主任申请',
			allowClose:true,
		    isResize : false
		});		
	}
	function editassist(){	
	var row = manager.getSelectedRow();
	if (!row) {alert('请选择至少一项！');return;}
	var str = "${pageContext.request.contextPath}/system/Class_assistedit.action?assistantteacher.id="+row.id;
		m=$.ligerDialog.open({
			url : str,
			height : 600,
			width : 750,
			isDrag:true,
			showMax:true,
			showToggle:true,
			slide: false,			
			modal:false,
			left:200,
			title:'助理班主任修改',
			allowClose:true,
		    isResize : false
		});		
	}
	function deleteassist(){
	  var row = manager.getSelectedRow();
	  if (!row) {alert('请选择至少一项！');return;}
	  $.ligerDialog.confirm('确认删除该助理班主任？', function (yes){
       if(yes){	
          $.ligerDialog.prompt('请输入确认密码', function (yes, value){
                   if (yes){ //验证密码
                        var userid = ${sessionScope.user.id};
                        $.post("${pageContext.request.contextPath}/system/User_pwdcheck.action?user.id="+ userid
		                +"&user.password="+value , null, function(data) {
					       if (data == "fail") {
						     alert("输入的密码不正确!");						
					       } else {
	                         if(row.assistclass.length==0){
	                            $.post("${pageContext.request.contextPath}/system/Class_assistdelete.action?assistantteacher.id="+row.id,null,function(){
	                              // window.location.reload();
	                              g.loadData();
	                            })
	                         }else{
	                            alert("该生已分配管理班级，不能删除,如需删除，请先重新设置相关班级助理班主任！");
	                         }
	                       }
	                   });
	                }
	      });
	   }
	   });
	   }
</script>
	</head>
	<body style="padding: 2px">
	 <!-- <a class="l-button" style="width:70px;float:left; margin:3px;" onclick="applyassist()">录&nbsp;&nbsp;入</a>
	 <a class="l-button" style="width:70px;float:left; margin:3px;" onclick="editassist()">修&nbsp;&nbsp;改</a>
	 <a class="l-button" style="width:70px;float:left; margin:3px;" onclick="deleteassist()">删&nbsp;&nbsp;除</a> -->
	 <!-- <a class="l-button" style="width:70px;float:left; margin:3px;" onclick="apply()">批&nbsp;&nbsp;准</a>
	 <a class="l-button" style="width:70px;float:left; margin:3px;" onclick="against()">驳&nbsp;&nbsp;回</a>   
	 <a class="l-button" style="width:70px;float:left; margin:3px;" onclick="print()">打&nbsp;&nbsp;印</a>  -->   
		<div class="l-clear"></div>
		<div id="maingrid" style="" ></div>
	</body>
</html>

