<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@page import="com.tjpu.bean.Syllabus"%>
<%@page import="com.opensymphony.xwork2.ActionContext"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title></title>
<%-- <link href="<%=basePath%>js/ligerUI/skins/Aqua/css/ligerui-all.css" rel="stylesheet"type="text/css" />	
<link href="<%=basePath %>js/ligerUI/skins/Gray/css/all.css" rel="stylesheet" type="text/css"/> --%>
<link href="<%=basePath%>js/ligerUI/skins/Gray/css/form.css"rel="stylesheet" type="text/css" />
<link href="<%=basePath%>js/ligerUI/skins/Gray/css/common.css"rel="stylesheet" type="text/css" />
<link href="<%=basePath%>css/date.css" rel="stylesheet" type="text/css" />
<script src="<%=basePath%>js/jquery/jquery-1.6.min.js"type="text/javascript"></script>
<script src="<%=basePath%>js/ligerUI/core/base.js"type="text/javascript"></script>
<script src="<%=basePath%>js/ligerUI/plugins/ligerForm.js"type="text/javascript"></script>
<script src="<%=basePath%>js/ligerUI/plugins/ligerDateEditor.js"type="text/javascript"></script>
<script src="<%=basePath%>js/ligerUI/plugins/ligerComboBox.js"type="text/javascript"></script>
<script src="<%=basePath%>js/ligerUI/plugins/ligerSpinner.js"type="text/javascript"></script>
<script src="<%=basePath%>js/ligerUI/plugins/ligerTextBox.jstype="text/javascript"></script>
<%-- <script src="<%=basePath%>js/ligerUI/plugins/ligerRadio.js" type="text/javascript"></script> --%>
<script src="<%=basePath%>js/ligerUI/plugins/ligerTip.js"type="text/javascript"></script>
<script src="<%=basePath%>js/jquery-validation/jquery.validate.min.js"type="text/javascript"></script>
<script src="<%=basePath%>js/jquery-validation/jquery.metadata.js"type="text/javascript"></script>
<script src="<%=basePath%>js/jquery-validation/messages_cn.js"type="text/javascript"></script>
<script src="<%=basePath%>js/jquery.date_input.pack.js"type="text/javascript"></script>
<script type="text/javascript">
	$(function() {
		$('.date_picker').date_input();
	})
	var eee;
	$(function() {
		$.metadata.setType("attr", "validate");
		var v = $("form")
				.validate(
						{
							//调试状态，不会提交数据的
							debug : true,
							errorPlacement : function(lable, element) {

								if (element.hasClass("l-textarea")) {
									element.addClass("l-textarea-invalid");
								} else if (element.hasClass("l-text-field")) {
									element.parent().addClass("l-text-invalid");
								}

								var nextCell = element.parents("td:first")
										.next("td");
								if (nextCell.find("div.l-exclamation").length == 0) {
									$(
											'<div class="l-exclamation" title="'
													+ lable.html() + '"></div>')
											.appendTo(nextCell).ligerTip();
								}
							},
							invalidHandler : function(form, validator) {
								var errors = validator.numberOfInvalids();
								if (errors) {
									var message = errors == 1 ? '该字段不能为空！'
											: '这 ' + errors + ' 个字段不能为空！';
									$("#errorLabelContainer").html(message)
											.show();
								}
							},
							submitHandler : function() {
								$("form .l-text,.l-textarea").ligerHideTip();
								if (flg) {
									$.post("${pageContext.request.contextPath}/system/Class_classendadd.action?cls.classname="
										+ encodeURI(encodeURI($("#classname").val()))
										+ "&cls.major="+ encodeURI(encodeURI($("#major").val())),
										null,function() {
											alert('添加成功!');
											parent.m.hide();
											parent.g.window.location.reload();
											parent.g.loadData();
									});
								}
							}
						});
		$("form").ligerForm();
		$(".l-button-test").click(function() {
			alert(v.element($("#txtName")));
		});

	});
	var flg = true;
	function check() {
		$
				.post(
						"${pageContext.request.contextPath}/system/Class_classcheck.action?cls.classname="
								+ $("#classname").val(), null, function(data) {
							if (data == "fail") {
								$("#result").html("该班级名称已经存在!");
								$("#result").show();
								flg = false;
							} else {
								$("#result").hide();
							}
						});

	}

	function changChild(tid) {
		$.post("childSelect", {
			"tid" : tid
		}, function(json) {
			$(".child").html("");//清空学生下拉框  
			for ( var i = 0; i < json.length; i++) {
				//添加一个学生  
				$(".child").append("<option value='"+json[i].id+"'>" + json[i].slot+ "</option>");
			}
		}, 'json');
	}
	
	$(function() {
		//初始化教师下拉框  
		$.post("parentSelect", null, function(json) {
			for ( var i = 0; i < json.length; i++) {
				//添加一个教师  
				$(".parent").append("<option value='"+json[i].id+"'>" + json[i].courseName+ "</option>");
			}
			changChild($(".parent").val());
		}, 'json');
		//注册教师下拉框事件  
		$(".parent").change(function() {
			changChild($(this).val());
		});
	});
</script>
<style type="text/css">
body {
	font-size: 12px;
}

.l-table-edit {
	
}

.l-table-edit-td {
	padding: 4px;
}

.l-button-submit,.l-button-test {
	width: 80px;
	float: left;
	margin-left: 10px;
	padding-bottom: 2px;
}

.l-verify-tip {
	left: 230px;
	top: 120px;
}

#errorLabelContainer {
	padding: 10px;
	width: 300px;
	border: 1px solid #FF4466;
	display: none;
	background: #FFEEEE;
	color: Red;
}

.link {
	width: 170px;
	height: 25px;
	background: #fefefe;
	border: 1px solid #bbb;
	font-size: 12px;
	color: #333;
	border-radius: 3px;
}

textarea {
	width: 100%;
	height: 100px;
}
</style>

</head>

<body style="padding: 10px;  ">
	<form name="form1" method="post" action="" id="form1">
		<div id="errorLabelContainer" class="l-text-invalid"></div>
		<table cellpadding="0" cellspacing="0" class="l-table-edit"  >
			<tr>
				<td align="center" class="l-table-edit-td">课程编号:</td>
				<td align="left" class="l-table-edit-td"><input
					name="oldcoursenum" type="text" onblur="check()" id="oldcoursenum"
					ltype="text" validate="{required:true,minlength:1,maxlength:20}" />
				</td>
				<td align="center" width="70px">课程名称:</td>
				<!-- <td align="left" class="l-table-edit-td"><input
					name="oldcoursename" type="text" id="coursename" ltype="text"
					validate="{required:true,minlength:1,maxlength:20}" />
				</td> -->
				
				<td>
				<%
							List<Syllabus> oldCourses = (List<Syllabus>) ActionContext.getContext().get("oldCourses");
							
					%>
					
					<select id="oldCourseName">
						<%
							for (Syllabus s : oldCourses) {
						%>
								<option value="<%=s.getId() %>"> <%=s.getCourseName() %> </option>
						<%
							}
						 %>	
					</select>
					</td>
					<select id="test123"></select>
					<script type="text/javascript">
						 $(document).ready(function(){
						    $("#oldCourseName").change(selectChange());
						});
						 //$("#test123").append("<option>s</option>");
						function selectChange () {
							//alert("here");
							var oldCourse = $("#oldCourseName").val();
							var url = "${pageContext.request.contextPath}/system/Manage_getDat.action";
							 $.ajax({  
						        type : "POST",  
						        url : url,
						        dataType : "JSON", 
						        error: function (){
						        	alert("error function");
						        },
						        success : function(data) {
						        	//alert(data.length);  
						          	for(var n=0;n<data.length;n++){
						            	//alert(eval(data[n]).v);
						            	//alert($("#newtime").val());
						                //$("#newtime").append("<option>"+eval(data[n]).v+"</option>");
						                //$("#test123").append("<option>s</option>");
						                //$("<option value='n+1'>第N+1项</option>").appendTo("#value"); 
						                document.getElementById("test123").options.add(new Option("test","test"))
						          	} 
						        }  
						    });
						}
						
					</script>
			</tr>
			<tr>
				<td align="center" class="l-table-edit-td">新课程编号:</td>
				<td align="left" class="l-table-edit-td"><input
					name="coursenum" type="text" onblur="check()" id="coursenum"
					ltype="text" validate="{required:true,minlength:1,maxlength:20}" />
				</td>
				<td align="center" width="70px">新课程名称:</td>
				<td align="left" class="l-table-edit-td">
				<input name="coursename" type="text" id="coursename" ltype="text"
					validate="{required:true,minlength:1,maxlength:20}" />		
				</td>
				<td align="left"></td>
			</tr>
			<tr>
				<td align="center" class="l-table-edit-td">计划上课日期:</td>
				<td align="left" class="l-table-edit-td"><input name="plandate"
					id="plandate" class="date_picker " />
				</td>
				<td align="center" class="l-table-edit-td">计划上课日期:</td>
				<td align="left" class="l-table-edit-td"><input name="plandate"
					id="plandate" class="date_picker " /></td>
				<td align="left"></td>
			</tr>
			<tr>
				<td align="center" class="l-table-edit-td">节次:</td>
				<td align="left" class="l-table-edit-td">
				<select id="newtime" class="link">
						<option id="value"> value</option>
				</select>
				</td>
				<td align="center" class="l-table-edit-td">节次:</td>
				<td align="left" class="l-table-edit-td"><select id="oldtime"
					name="oldtime" class="link">
						<option value="8:20-10:00">第一大节</option>
						<option value="10:20-12:00">第二大节</option>
						<option value="14:00-15:40">第三大节</option>
						<option value="16:00-17:40">第四大节</option>
						<option value="18:30-20:10">第五大节</option>
				</select></td>
				<td align="left"></td>
			</tr>
			<tr>
				<td align="center" class="l-table-edit-td">调课原因:</td>
				<th align="left" class="l-table-edit-td" colspan="4"><textarea
						id="reason"></textarea></th>
			</tr>
			<tr>
				<th align="center" class="l-table-edit-td" colspan="3"><div
						id="result" style="color: red;"></div></th>
			</tr>
			<tr>
				<td align="right" class="l-table-edit-td"></td>
				<td align="right" class="l-table-edit-td"></td>
				<td align="left" class="l-table-edit-td"><input type="submit"
					value="申&nbsp;&nbsp;请" id="Button1"
					class="l-button l-button-submit" />
				</td>
				<td align="left">
					<td align="left">
			</tr>
		</table>
		<br />
	</form>
</body>
</html>