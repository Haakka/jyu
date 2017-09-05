<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

	<%@ include file="/common/head-import.jsp"%>

	<div class="main-content">
		<div class="breadcrumbs" id="breadcrumbs">
			<script type="text/javascript">
				try{ace.settings.check('breadcrumbs' , 'fixed')}catch(e){}
			</script>

			<ul class="breadcrumb">
				<li>
					<i class="icon-home home-icon"></i>
					<a href="${ctx}/usersAction!center.htm">首页</a>
				</li>
				<li>
					<a href="${ctx}/cusman/contactAction!retrieveAllContacts.action">客户管理</a>
				</li>
				<li class="active">联系人管理</li>
			</ul>
		</div><!-- .breadcrumb -->

		<div class="page-content">
			<div>
				<h3 class="row-fluid header smaller  blue" style="line-height: 39px;">
					<span class="span7">编辑 </span><!-- /span -->

					<span class="span5">
						<label class="pull-right inline">
							<button class="btn btn-light btn-sm" onclick="history.back();">
								<i class="icon-arrow-left"></i>
								返回
							</button>
						</label>
					</span><!-- /span -->
				</h3>
			</div><!-- /.page-header -->
			<div class="row">
				<div class="col-xs-12">
					<!-- PAGE CONTENT BEGINS -->
					<form action="#" method="post" id="contactForm"  class="form-horizontal" role="form">
						<input type="hidden" name="contact.id" value="${contact.id}"/>
						<input type="hidden" name="contact.token" value="${contact.token}"/>
						<div class="form-group">
							<label class="col-xs-12 col-sm-1 control-label no-padding-right" for="form-field-1">姓名</label>
							<div class="col-xs-12 col-sm-10">
								<div class="clearfix">
									<input type="text" class="col-xs-10 col-sm-5" name="contact.name" value="${contact.name}" />
								</div>
							</div>
						</div>
						<div class="form-group">
							<label class="col-xs-12 col-sm-1 control-label no-padding-right" for="form-field-1">手机号码</label>
							<div class="col-xs-12 col-sm-10">
								<div class="clearfix">
									<input type="text" class="col-xs-10 col-sm-5" name="contact.phone" value="${contact.phone }" />
								</div>
							</div>
						</div>
						<div class="form-group">
							<label class="col-xs-12 col-sm-1 control-label no-padding-right" for="form-field-1">性别</label>
							<div class="col-xs-12 col-sm-10">
								<div class="clearfix">
									<select name="contact.sex" class="form-control" id="form-field-select-1" style="width: 50px">
										<option value="0" <c:if test="${contact.sex eq '0'}">selected="selected"</c:if>>男</option>
										<option value="1" <c:if test="${contact.sex eq '1'}">selected="selected"</c:if>>女</option>
									</select>
								</div>
							</div>
						</div>
						<div class="form-group">
							<label class="col-xs-12 col-sm-1 control-label no-padding-right" for="form-field-1">称呼</label>
							<div class="col-xs-12 col-sm-10">
								<div class="clearfix">
									<input type="text" class="col-xs-10 col-sm-5" name="contact.displayName" value="${contact.displayName }" />
								</div>
							</div>
						</div>
						<div class="form-group">
							<label class="col-xs-12 col-sm-1 control-label no-padding-right" for="form-field-1">邮箱</label>
							<div class="col-xs-12 col-sm-10">
								<div class="clearfix">
									<input type="text" class="col-xs-10 col-sm-5" name="contact.email" value="${contact.email }" />
								</div>
							</div>
						</div>
						<div class="form-group">
							<label class="col-xs-12 col-sm-1 control-label no-padding-right" for="form-field-1">QQ</label>
							<div class="col-xs-12 col-sm-10">
								<div class="clearfix">
									<input type="text" class="col-xs-10 col-sm-5" name="contact.qq" value="${contact.qq }" />
								</div>
							</div>
						</div>
						<div class="form-group">
							<label class="col-xs-12 col-sm-1 control-label no-padding-right" for="form-field-1">详细地址</label>
							<div class="col-xs-12 col-sm-10">
								<div class="clearfix">
									<input type="text" class="col-xs-10 col-sm-5" name="contact.address" value="${contact.address}" />
								</div>
							</div>
						</div>
						<div class="form-group">
							<label class="col-xs-12 col-sm-1 control-label no-padding-right" for="form-field-1">邮编</label>
							<div class="col-xs-12 col-sm-10">
								<div class="clearfix">
									<input type="text" class="col-xs-10 col-sm-5" name="contact.postCode" value="${contact.postCode }" />
								</div>
							</div>
						</div>
						<div class="form-group">
							<label class="col-xs-12 col-sm-1 control-label no-padding-right" for="form-field-1">所属客户</label>
							<div class="col-xs-12 col-sm-10">
								<div class="clearfix">
									<input type="text" disabled="disabled" class="col-xs-10 col-sm-5" name="consumerId" value="${contact.consumerId.name}" />
								</div>
							</div>
						</div>
						<div class="form-group">
							<label class="col-xs-12 col-sm-1 control-label no-padding-right" for="form-field-1">所属部门</label>
							<div class="col-xs-12 col-sm-10">
								<div class="clearfix">
									<input type="text" class="col-xs-10 col-sm-5" name="contact.department" value="${contact.department }" />
								</div>
							</div>
						</div>
						<div class="form-group">
							<label class="col-xs-12 col-sm-1 control-label no-padding-right" for="form-field-1">所属职位</label>
							<div class="col-xs-12 col-sm-10">
								<div class="clearfix">
									<input type="text" class="col-xs-10 col-sm-5" name="contact.position" value="${contact.position }" />
								</div>
							</div>
						</div>
						<div class="form-group">
							<label class="col-xs-12 col-sm-1 control-label no-padding-right" for="form-field-1">备注</label>
							<div class="col-xs-12 col-sm-10">
								<div class="clearfix">
									<textarea name="contact.remark" style="width: 385px;height: 100px;" placeholder="最多输入500个字符">${contact.remark }</textarea>
								</div>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-1 control-label no-padding-right" for="form-field-1"></label>
							<div class="col-sm-10">
								<input type="submit" id="submitButton" class="btn btn-info" value="保存">
							</div>
						</div>
						<s:token></s:token>
					</form>
					<!-- PAGE CONTENT ENDS -->
				</div><!-- /.col -->
			</div><!-- /.row -->
		</div><!-- /.page-content -->
		
		
		<%@ include file="/common/copyright.jsp"%>
	</div><!-- /.main-content -->

				

	<%@ include file="/common/bottom-import.jsp"%>
	
	<script src="${ctx}/js/assets/js/fuelux/fuelux.wizard.min.js"></script>
	<script src="${ctx}/js/assets/js/jquery.validate.min.js"></script>
	<script type="text/javascript">
		jQuery(function($) {
			setCurrent();
		});
		
		function setCurrent(){
			$("#parent_3").addClass("active open");
			$("#sub_32").addClass("active");
		}
	</script>
	<script>
		
		$(document).ready(function(){

			// 手机号码验证
			jQuery.validator.addMethod("isMobile", function(value, element) {
			    var length = value.length;
			    var mobile = /^(13[0-9]{9})|(18[0-9]{9})|(14[0-9]{9})|(17[0-9]{9})|(15[0-9]{9})$/;
			    return this.optional(element) || (length == 11 && mobile.test(value));
			}, "请正确填写您的手机号码");
			
			// 邮政编码验证 
			jQuery.validator.addMethod("isZipCode", function(value, element) { 
			  var tel = /^[0-9]{6}$/; 
			  return this.optional(element) || (tel.test(value)); 
			}, "请正确填写您的邮政编码"); 
			
			$("#contact.name").focus();
			$("#contactForm").validate({
				errorElement: 'div',
				errorClass: 'help-block',
				 rules: { 
					'contact.name': { 
	        			required: true,
	    			},
	    			'contact.phone': {
	    				required: true,
	    				isMobile : true
	    			},
	    			'contact.sex': {
	    				required: true
	    			},
	    			'contact.displayName' : {
	    				required: true
	    			},
	    			'contact.email': { 
	    				email:true
	    			},
	    			'contact.qq': {
	    				number:true,
	    				digits:true
	    			},
	    			'contact.address': {
	    				required: true
	    			},
	    			'contact.postCode' : {
	    				isZipCode : true
	    			},
	    			'consumerId' : {
	    			},
	    			'contact.department': {
	    				required: true
	    			},
	    			'contact.position': {
	    				required: true
	    			},
	    			'contact.remark' : {
	    				maxlength:500
	    			}
				},
				messages: {
					'contact.name': { 
	        			required: "请输入姓名",
	    			},
	    			'contact.phone': {
	    				required: "请输入手机号码",
	    				isMobile : "请输入正确的手机号码"
	    			},
	    			'contact.sex': {
	    				required: "请选择性别"
	    			},
	    			'contact.displayName' : {
	    				required: "请输入称呼"
	    			},
	    			'contact.email': { 
	    				email:"请输入正确的邮箱"
	    			},
	    			'contact.qq': {
	    				number:"只能输入数字",
	    				digits:"只能输入整数"
	    			},
	    			'contact.address': {
	    				required: "请输入详细地址"
	    			},
	    			'contact.postCode' : {
	    				isZipCode:"请输入正确的邮政编码"
	    			},
	    			'consumerId' : {
	    			},
	    			'contact.department': {
	    				required: "请输入所属部门"
	    			},
	    			'contact.position': {
	    				required: "请输入所属岗位"
	    			},
	    			'contact.remark' : {
	    				maxlength:"最多输入500个字符"
	    			}
				},
				
				highlight: function (e) {
					$(e).closest('.form-group').removeClass('has-info').addClass('has-error');
				},
		
				success: function (e) {
					$(e).closest('.form-group').removeClass('has-error').addClass('has-info');
					$(e).remove();
				},
		
				errorPlacement: function (error, element) {
					if(element.is(':checkbox') || element.is(':radio')) {
						var controls = element.closest('div[class*="col-"]');
						if(controls.find(':checkbox,:radio').length > 1) controls.append(error);
						else error.insertAfter(element.nextAll('.lbl:eq(0)').eq(0));
					}
					else if(element.is('.select2')) {
						error.insertAfter(element.siblings('[class*="select2-container"]:eq(0)'));
					}
					else if(element.is('.chosen-select')) {
						error.insertAfter(element.siblings('[class*="chosen-container"]:eq(0)'));
					}
					else error.insertAfter(element.parent());
				},
				submitHandler:function(form){
					ajaxUpdate(form,'contactAction!editContact.action');
			    }
				
			});
			
			$(".chosen-select").chosen({no_results_text : "未找到此选项!",search_contains: true});
		});
	</script>
	
	
	
	</body>
</html>