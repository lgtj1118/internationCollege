<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>验证插件</title>
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

<body style="padding: 50px;">
<div class="demobox" style="width: 800px; background: #fff; border: #ddd solid 1px; padding: 30px;">
    <div class="bl-notes bl-notes-info">
        <h3>规则说明：</h3>
        <p>如：input type="email" value="" name="title" class="fn-tinput" required data-rule-<em>email</em>="true" data-msg-required="请输入email地址" data-msg-<em>email</em>="请输入正确的email地址"</p>
        <div class="fn-hr fn-mt10 fn-mb10"></div>
        <p>required //必填</p>
        <p>data-rule-<em>email</em>="true" //正则为 email </p>
        <p>data-msg-required="请输入您的电子邮箱" //为空时的提示信息</p>
        <p>data-msg-<em>email</em>="邮箱格式不正确" //不符合正则的提示</p>
        <p>placeholder="电子邮件"   //input中没有填写的提示</p>
        <strong>更多信息请参考源代码</strong>
        <p>表单的样式是随手写了一下，只是看起来稍微好看一点，样式不是本文重点，验证规则与书写方法和样式无关，可以自行定义。懒人建站http://www.51xuediannao.com/</p>
    </div>
	<form action="js/test.json" method="post" class="bl-form bl-formhor" id="jsForm">
        <ul>
        	<li class="bl-form-group">
                <label><em>*</em>必填：</label>
                <div class="controls">
                   <input id="pwdid" class="fn-tinput" data-rule-remote="http://www.baidu.com" type="password" name="OldPassword" placeholder="原始密码" required data-msg-required="请输入原始密码" minlength="6" data-msg-minlength="至少输入6个字符" />
                </div>
            </li>
        	
            <li class="bl-form-group">
                <label><em>*</em>必填：</label>
                <div class="controls">
                    <input type="text" value="" name="0" class="fn-tinput" placeholder="大于0" required data-msg-required="不能为空" data-rule-gt="true" data-gt="0"/>
                </div>
            </li>
            <li class="bl-form-group">
                <label><em>*</em>必填：</label>
                <div class="controls">
                    <input type="text" value="" name="1" class="fn-tinput" placeholder="必填" required data-msg-required="不能为空"/>
                </div>
            </li>
            <li class="bl-form-group">
                <label><em>*</em>Email：</label>
                <div class="controls">
                    <input type="email" value="" name="2" class="fn-tinput" placeholder="请输入email地址" required data-rule-email="true" data-msg-required="请输入email地址" data-msg-email="请输入正确的email地址" />
                </div>
            </li>
            <li class="bl-form-group">
                <label>手机：</label>
                <div class="controls">
                    <input type="text" value="" name="3" class="fn-tinput" placeholder="手机号" required data-rule-mobile="true" data-msg-required="请输入手机号" data-msg-mobile="请输入正确格式" />
                </div>
            </li>
            <li class="bl-form-group">
                <label>邮箱或手机：</label>
                <div class="controls">
                    <input type="text" value="" name="4" class="fn-tinput" placeholder="邮箱或手机" required data-rule-mm="true" data-msg-required="请输入邮箱" data-msg-mm="请输入正确格式" />
                </div>
            </li>
            <li class="bl-form-group">
                <label>数字6-20位：</label>
                <div class="controls">
                    <input type="text" value="" name="5" class="fn-tinput" placeholder="数字6-20位" required data-rule-number="true" data-msg-required="不能为空" data-msg-number="请输入正确的数字" data-msg-minlength="请输入最小6位" minlength="6" maxlength="20"/>
                </div>
            </li>
            <li class="bl-form-group">
                <label>年龄：</label>
                <div class="controls">
                    <input type="text" value="" name="6" class="fn-tinput" placeholder="年龄" required data-rule-age="true" data-msg-required="不能为空" data-msg-age="请输入数字" />
                </div>
            </li>
            <li class="bl-form-group">
                <label>新密码：</label>
                <div class="controls">
                    <input class="fn-tinput" type="password" name="password" value="" placeholder="新密码" required id="password" data-rule-remote="php.php">
                </div>
            </li>
            <li class="bl-form-group">
                <label>确认新密码：</label>
                <div class="controls">
                    <input class="fn-tinput" type="password"  name="confirm_password" value="" placeholder="确认新密码" required equalTo="#password">
                </div>
            </li>
            <li class="bl-form-group bl-form-text">
                <label>单选：</label>
                <div class="controls">
                    <label><input name="radio1" type="radio" value="" required>置顶</label>
                    <label><input name="radio1" type="radio" value="">推荐</label>
                    <span for="radio1" class="error"></span>
                </div>
            </li>
            <li class="bl-form-group bl-form-text">
                <label>多选：</label>
                <div class="controls">
                    <label><input name="checkbox1" type="checkbox" value="" required>黑色</label>
                    <label><input name="checkbox1" type="checkbox" value="">白色</label>
                    <span for="checkbox1" class="error"></span>
                </div>
            </li>
            <li class="bl-form-group">
                <label>下拉菜单：</label>
                <div class="controls">
                    <select name="select1" required>
                    	<option value="">----选择菜单----</option>
                        <option value="1">菜单1</option>
                        <option value="2">菜单2</option>
                        <option value="3">菜单3</option>
                        <option value="4">菜单4</option>
                    </select>
                </div>
            </li>
            <li class="bl-form-group">
                <label>文本域：</label>
                <div class="controls editor">
                    <textarea name="textarea1" cols="" rows="" required></textarea>
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
</div>
<script src="js/jquery-1.10.2.min.js"></script>
<script src="js/jquery-validation/jquery.validate.js"></script>
<script>
$(function(){
    //jquery.validate
	$("#jsForm").validate({
		submitHandler: function() {
			//验证通过后 的js代码写在这里
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
}, "格式不对");

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
