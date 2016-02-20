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
    <script src="js/jquery/jquery-1.3.2.min.js" type="text/javascript"></script>
    <script src="js/json2.js" type="text/javascript"></script>
    <script src="js/ligerUI/ligerui.all.js" type="text/javascript"></script>
    <script src="js/ligerUI/js/core/base.js" type="text/javascript"></script>
    <script src="js/ligerUI/plugins/ligerDialog.js" type="text/javascript"></script>
    <script src="js/ligerUI/plugins/ligerTextBox.js" type="text/javascript"></script>
    <script src="js/ligerUI/plugins/ligerCheckBox.js" type="text/javascript"></script>
    <script src="js/ligerUI/plugins/ligerComboBox.js" type="text/javascript"></script>
    <script src="js/ligerUI/plugins/ligerGrid.js" type="text/javascript"></script>
    <script src="js/ligerUI/plugins/ligerToolBar.js" type="text/javascript"></script>
    <script src="js/ligerUI/plugins/ligerDateEditor.js" type="text/javascript"></script>
    <script src="js/ligerUI/plugins/ligerSpinner.js" type="text/javascript"></script>
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
			} ,{display : '密码', name : 'password',minWidth : 80,hide:true,editor: { type: 'password'}
			 }, {display : '英文名', name : 'firstname',minWidth : 100, editor: { type: 'text'}
			}, {display : '英文姓', name : 'lastname',minWidth : 100, editor: { type: 'text'}
			}, {display : '姓名', name : 'stuname',minWidth : 80, editor: { type: 'text'}
			} ,{display : '性别', name : 'stusex', minWidth : 50,  editor:{type:'text'}	
			} ,{display : '出生年月', name : 'brithdate', minWidth : 50,  editor:{type:'text'}				
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
             ,{display : '专业', name : 'major', minWidth : 120,  editor:{type:'text'}}
             ,{display : '电话', name : 'telephone', minWidth : 100,  editor:{type:'text'} 
             } ,{display : '住址', name : 'roomplace', minWidth : 120,  editor:{type:'text'}
             } ,{display : '国籍', name : 'nation', minWidth : 100,  editor:{type:'text'}	}
             
             ,{display : '学生类别', name : 'studentType', minWidth : 80,  editor:{type:'text'}	}
             ,{display : '入校时间', name : 'startdate', minWidth : 80, editor:{type:'text'} /* type: 'date', format: 'yyyy-MM-dd', width: 100, editor: { type: 'date'} */	}	
             ,{display : '离校时间', name : 'enddate', minWidth : 80,  editor:{type:'text'}	}
             ,{display : '居留许可有效期', name : 'validResidencePermit', minWidth : 120,  editor:{type:'text'}	}
             ,{display : '来源', name : 'source', minWidth : 80,  editor:{type:'text'}	}
             ,{display : '学制', name : 'duration', minWidth : 80,  editor:{type:'text'}	}
             ,{display : '欠费', name : 'isPaid', minWidth : 80,  editor:{type:'text'}	}
             ,{display : '层次', name : 'studyLevel', minWidth : 80,  editor:{type:'text'}	}
             ,{display : '是否毕业', name : 'status', minWidth : 80,  editor:{type:'text'},
               render:function (item) {
					if (parseInt(item.status) == 1) {
						return "<font style='color:red'>已毕业</font>";
					} else if(parseInt(item.status) == 0) {
						return "<font style='color:green'>未毕业</font>";
					}else{
					    return "<font style='color:orange'>审核驳回</font>";
					}
				}	}
			,{display : '状态', name : 'source', minWidth : 80,  editor:{type:'text'},
               render:function (item) {
					if (parseInt(item.isDeleted) == 1) {
						return "<font style='color:red'>不可用</font>";
					} else {
						return "<font style='color:green'>正常</font>";
					}
				}	}],
					onSelectRow : function(rowdata, rowindex) {
						$("#txtrowindex").val(rowindex);
					},
					checkbox:true,
					enabledEdit : true,
					clickToEdit : false,
					isScroll : false,
					rownumbers:true, 
					pageSize:20,
					url :'${pageContext.request.contextPath}/system/Stu_stulist.action',
					width : '100%',
					toolbar: { items: [
					                   { text: '添加',click: addstu,  icon: 'add' },
					                   { text: '修改',click: beginEdit,  icon: 'edit' },
					                   { text: '删除',click: deleterow,  icon: 'delete' },
					                   { text: '重置',click: recovery,  icon: 'save' },
					                   { text: '批量添加', click: addbatchstu, icon:'add'},
                                       { text: '导出',click: itemclick,  icon: 'outbox' }               
                    ]}
				});
	}
	function itemclick(item){
       var str = "${pageContext.request.contextPath}/system/Stu_studownload.action"; 
       window.location.href=str;
        }
	var m;
	function beginEdit() {
       var row = manager.getSelectedRow();
       if (!row) { alert('请选择一名学生！'); return; }      
       var str = "${pageContext.request.contextPath}/system/Stu_stuedit.action?stu.id="+ row.id;
           m=$.ligerDialog.open({
			url : str,
			height : 450,
			width : 750,
			isDrag:true,
			showMax:true,
			showToggle:true,
			slide: false,			
			modal:false,
			left:200,
			title:'学生更新',
			allowClose:true,
		    isResize : false
		});
	}	
	function deleterow() {
	    var row = manager.getSelectedRow();
		if (!row) {alert('请选择一名学生！');return;}
		$(".l-dialog-inputtext").focus(function(){  
             $(this).attr('type','password');  
        });
	    $.ligerDialog.confirm("是否删除？第一次删除将会使该学生不可用。如果没有成绩或记录与此学生关联，第二次删除会彻底清除记录，否则不做任何操作。", function (yes){
            if(yes){
               $.ligerDialog.prompt('请输入确认密码', function (yes, value){
                   if (yes){ //验证密码
                        var userid = ${sessionScope.user.id};
                        $.post("${pageContext.request.contextPath}/system/User_pwdcheck.action?user.id="+ userid
		                +"&user.password="+value , null, function(data) {
					       if (data == "fail") {
						     alert("输入的密码不正确!");						
					       } else {
		                     var rows = g.getCheckedRows();
                             var str = "";
                             $(rows).each(function (){ str += this.id;});
			                 $.post("${pageContext.request.contextPath}/system/Stu_studelete.action?ids="+str,null,function(){
			                   g.loadData();
			                   //window.location.reload(); 
			                 });
			                 
		                   }
		                 });
		             }
		         });
		     }
		});
	} 
	var m;
	function addstu(){
	var win1;
	if (win1) win1.show();
	else{
	var str = "${pageContext.request.contextPath}/system/Stu_stubeginadd.action";
		m=$.ligerDialog.open({
			url : str,
			height : 450,
			width : 750,
			isDrag:true,
			showMax:true,
			showToggle:true,
			slide: false,			
			modal:false,
			left:200,
			title:'添加学生',
			allowClose:true,
		    isResize : false
		});}
	
		
	}
	function addbatchstu(){
	var str = "${pageContext.request.contextPath}/system/Stu_stubatchadd.action";
		m=$.ligerDialog.open({
			url : str,
			height : 500,
			width : 700,
			isResize : true
		});
		
	}
	function recovery(){
	  var row = manager.getSelectedRow();
		if (!row) {alert('请选择一名学生！');return;}
		if(row.isDeleted==0){
		  if (confirm('确认将重置学生密码，设为初始密码（123456）?')) {
            $.post("${pageContext.request.contextPath}/system/Stu_sturecovery.action?ids="+row.id,null,function(){
            //window.location.reload();
            g.loadData();
            });
            
          }
	   }else{
	      $.ligerDialog.confirm("是否重置该学生为可用，确认后同时设置密码为初始密码（123456）？", function (yes){
         if(yes){
		  var rows = g.getCheckedRows();
            var str = "";
            $(rows).each(function () {
                str += this.id;
            });
			$.post("${pageContext.request.contextPath}/system/Stu_sturecovery.action?ids="
			+  str,null,function(){
            //window.location.reload();
            g.loadData();
            });
		}
		});
	   }
		
	}
</script>
	</head>
	<body style="padding: 2px">
	 <!-- <a class="l-button" style="width:70px;float:left; margin:3px;" onclick="addstu()">添&nbsp;&nbsp;加</a>
	 <a class="l-button" style="width:70px;float:left; margin:3px;" onclick="addbatchstu()">批量添加</a>       
	 <a class="l-button" style="width:70px;float:left; margin:3px;" onclick="deleterow()">删&nbsp;&nbsp;除</a>
	 <a class="l-button" style="width:70px;float:left; margin:3px;" onclick="beginEdit()">修&nbsp;&nbsp;改</a>
	 <a class="l-button" style="width:70px;float:left; margin:3px;" onclick="recovery()">重&nbsp;&nbsp;置</a> -->
	 <!-- <a class="l-button" style="width:80px;float:left; margin:3px;" onclick="cancelEdit()">取消修改</a>
	 <a class="l-button" style="width:70px;float:left; margin:3px;" onclick="endEdit()">保存</a>
	 -->	<div class="l-clear"></div>
		<div id="maingrid" ></div>
	</body>
</html>

