<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
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
<style>
body,a{ font-size:14px; color:#666;}
ul,li{ margin:0; padding:0; list-style:none}
.fn-vhid{ visibility:hidden;}
.fn-tinput{ width:240px; height:30px; line-height:30px\9; border:#ddd solid 1px; background-color:transparent; padding:0 6px;}
textarea {border:#ddd solid 1px; background-color:transparent; width:60%}
.fn-tinput:focus,textarea:focus{ border-color:#c00;}
.bl-form label{ float:left; width:100px; text-align:right; padding-top:6px;}
.bl-form .controls label{ width:auto;}
.bl-form li{ margin-top:20px; overflow:hidden;}
em{ color:#C00;}
span.error{color:#C00; padding:0 6px;}
</style>
  </head>
  
  <body>
    <form action="" method="post" class="bl-form bl-formhor" id="jsForm">
        <ul>        	
            <li class="bl-form-group">
                <label>教师编号：</label>
                <div class="controls">
                    <input type="text" value="" name="0" class="fn-tinput" id="usernum"  required data-rule-number="true" data-msg-required="不能为空" data-msg-number="请输入正确的数字" data-msg-minlength="请输入最小6位" minlength="6" maxlength="20"/>
                </div>
            </li>
            <li class="bl-form-group">
                <label>姓名:</label>
                <div class="controls">
                    <input type="text" value="" name="1" class="fn-tinput" id="realname" placeholder="必填" required required data-rule-chinese="true"  data-msg-required="不能为空"/>
                </div>
            </li>
            <li class="bl-form-group">
                <label>Email：</label>
                <div class="controls">
                    <input type="email" value="" name="2" id="email" class="fn-tinput" placeholder="请输入email地址" required data-rule-email="true" data-msg-required="请输入email地址" data-msg-email="请输入正确的email地址" />
                </div>
            </li>
            <li class="bl-form-group">
                <label>手机：</label>
                <div class="controls">
                    <input type="text" value="" name="3" id="telephone" class="fn-tinput" placeholder="手机号" required data-rule-mobile="true" data-msg-required="请输入手机号" data-msg-mobile="请输入正确格式" />
                </div>
            </li>         
            <li class="bl-form-group">
                <label>性别：</label>
                <div class="controls">
                 <label for="rbtnl_0"><input id="r1" type="radio" name="rbtnl" value="1" checked="checked" /> 男</label>
				 <label for="rbtnl_1"><input id="r2" type="radio" name="rbtnl" value="2" />  女</label>
                </div>
            </li>
            <li class="bl-form-group">
                <label>职位：</label>
                <div class="controls">
                    <select name="position" id="position" ltype="select">
					<option value="教授">教授</option>
					<option value="副教授">副教授</option>
					<option value="讲师">讲师</option>
				</select>
                </div>
            </li>
            <li class="bl-form-group">
                <label>部门：</label>
                <div class="controls">
                    <select name="depid" id="depid" ltype="select">
						<s:iterator value="#deptlist" id="gg">
							<option value="<s:property value="#gg.deptid"/>"><s:property value="#gg.deptname" /></option>
						</s:iterator>
				</select>
                </div>
            </li>           
            <li class="bl-form-group bl-form-btns">
                <label class="fn-vhid">提交：</label>
                <div class="controls">
                    <button class="fn-btn btn-primary btn-submit submitBtn" type="submit">提交按钮</button>
            		<button type="reset" class="fn-btn">重置</button>
                </div>
            </li>
        </ul>
    </form>
    <script src="js/jquery-1.10.2.min.js"></script>
<script src="js/jquery-validation/jquery.validate.js"></script>
<script>
$(function(){
    //jquery.validate
	$("#jsForm").validate({
		submitHandler: function() {
			var sexid=1;
				   if(document.getElementById("r2").checked){
	                 sexid="女";
                   }else{
                     sexid="男";
                   }              
				$.post("${pageContext.request.contextPath}/system/Manage_teacherendadd.action?teacher.identificationnum="+ $("#usernum").val()
		        +"&teacher.sex="+ encodeURI(encodeURI(sexid))
		        +"&depid="+ $("#depid").val()
		        //+"&role="+$("#role").val()	
		        +"&teacher.position="+ encodeURI(encodeURI($("#position option:selected").val()))            
		        +"&teacher.teachername="+ encodeURI(encodeURI($("#realname").val()))
		        +"&teacher.telephone="+ encodeURI(encodeURI($("#telephone").val()))
		        +"&teacher.email="+ encodeURI(encodeURI($("#email").val())),null,function(){
		        alert('添加成功!');
		        parent.m.hide();
	            parent.g.loadData();
		       });
		}
	})
		
})


//下面是一些常用的验证规则扩展

/*-------------验证插件配置 懒人建站http://www.51xuediannao.com/-------------*/

//配置错误提示的节点，默认为label，这里配置成 span （errorElement:'span'）
$.validator.setDefaults({
	errorElement:'span'
});

//配置通用的默认提示语
$.extend($.validator.messages, {
	required: '必填',
    equalTo: "请再次输入相同的值"
});

/*-------------扩展验证规则 懒人建站http://www.51xuediannao.com/-------------*/
//邮箱 
jQuery.validator.addMethod("mail", function (value, element) {
	var mail = /^[a-z0-9._%-]+@([a-z0-9-]+\.)+[a-z]{2,4}$/;
	return this.optional(element) || (mail.test(value));
}, "邮箱格式不对");

//电话验证规则
jQuery.validator.addMethod("phone", function (value, element) {
    var phone = /^0\d{2,3}-\d{7,8}$/;
    return this.optional(element) || (phone.test(value));
}, "电话格式如：0371-68787027");

//区号验证规则  
jQuery.validator.addMethod("ac", function (value, element) {
    var ac = /^0\d{2,3}$/;
    return this.optional(element) || (ac.test(value));
}, "区号如：010或0371");

//无区号电话验证规则  
jQuery.validator.addMethod("noactel", function (value, element) {
    var noactel = /^\d{7,8}$/;
    return this.optional(element) || (noactel.test(value));
}, "电话格式如：68787027");

//手机验证规则  
jQuery.validator.addMethod("mobile", function (value, element) {
    var mobile = /^1[3|4|5|7|8]\d{9}$/;
	return this.optional(element) || (mobile.test(value));
}, "手机格式不对");

//邮箱或手机验证规则  
jQuery.validator.addMethod("mm", function (value, element) {
    var mm = /^[a-z0-9._%-]+@([a-z0-9-]+\.)+[a-z]{2,4}$|^1[3|4|5|7|8]\d{9}$/;
	return this.optional(element) || (mm.test(value));
}, "格式不对");

//电话或手机验证规则  
jQuery.validator.addMethod("tm", function (value, element) {
    var tm=/(^1[3|4|5|7|8]\d{9}$)|(^\d{3,4}-\d{7,8}$)|(^\d{7,8}$)|(^\d{3,4}-\d{7,8}-\d{1,4}$)|(^\d{7,8}-\d{1,4}$)/;
    return this.optional(element) || (tm.test(value));
}, "格式不对");

//年龄
jQuery.validator.addMethod("age", function(value, element) {   
	var age = /^(?:[1-9][0-9]?|1[01][0-9]|120)$/;
	return this.optional(element) || (age.test(value));
}, "不能超过120岁"); 
///// 20-60   /^([2-5]\d)|60$/

//传真
jQuery.validator.addMethod("fax",function(value,element){
    var fax = /^(\d{3,4})?[-]?\d{7,8}$/;
    return this.optional(element) || (fax.test(value));
},"传真格式如：0371-68787027");

//验证当前值和目标val的值相等 相等返回为 false
jQuery.validator.addMethod("equalTo2",function(value, element){
    var returnVal = true;
    var id = $(element).attr("data-rule-equalto2");
    var targetVal = $(id).val();
    if(value === targetVal){
        returnVal = false;
    }
    return returnVal;
},"不能和原始密码相同");

//大于指定数
jQuery.validator.addMethod("gt",function(value, element){
    var returnVal = false;
    var gt = $(element).data("gt");
    if(value > gt && value != ""){
        returnVal = true;
    }
    return returnVal;
},"不能小于0 或空");

//汉字
jQuery.validator.addMethod("chinese", function (value, element) {
    var chinese = /^[\u4E00-\u9FFF]+$/;
    return this.optional(element) || (chinese.test(value));
}, "请输入正确的姓名");

//指定数字的整数倍
jQuery.validator.addMethod("times", function (value, element) {
    var returnVal = true;
    var base=$(element).attr('data-rule-times');
    if(value%base!=0){
        returnVal=false;
    }
    return returnVal;
}, "必须是发布赏金的整数倍");

//身份证
jQuery.validator.addMethod("idCard", function (value, element) {
    var isIDCard1=/^[1-9]\d{7}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])\d{3}$/;//(15位)
    var isIDCard2=/^[1-9]\d{5}[1-9]\d{3}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])\d{3}([0-9]|X)$/;//(18位)

    return this.optional(element) || (isIDCard1.test(value)) || (isIDCard2.test(value));
}, "格式不对");


</script>
  </body>
</html>
