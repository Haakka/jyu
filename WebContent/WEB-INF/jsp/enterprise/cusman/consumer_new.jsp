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
					<a href="#">客户管理</a>
				</li>
				<li class="active">客户添加</li>
			</ul>
		</div><!-- .breadcrumb -->

		<div class="page-content">
			<div>
				<h3 class="row-fluid header smaller  blue" style="line-height: 39px;">
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
					<form method="post" id="consumerForm"  class="form-horizontal" role="form">
						<div class="form-group">
							<label class="col-xs-12 col-sm-1 control-label no-padding-right" for="form-field-1">客户名称</label>
							<div class="col-xs-12 col-sm-10">
								<div class="clearfix">
									<input type="text" class="col-xs-10 col-sm-5" name="consumer.name" id="consumer.name"/>
								</div>
							</div>
						</div>
						<div class="form-group">
							<label class="col-xs-12 col-sm-1 control-label no-padding-right" for="form-field-1">联系方式</label>
							<div class="col-xs-12 col-sm-10">
								<div class="clearfix">
									<input type="text" class="col-xs-10 col-sm-5" name="consumer.phone" />
								</div>
							</div>
						</div>
						<div class="form-group">
							<label class="col-xs-12 col-sm-1 control-label no-padding-right" for="form-field-1">详细地址</label>
							<div class="col-xs-12 col-sm-10">
								<div class="clearfix">
									<input type="text" class="col-xs-10 col-sm-5" name="consumer.address" />
								</div>
							</div>
						</div>
						<div class="form-group">
							<label class="col-xs-12 col-sm-1 control-label no-padding-right" for="form-field-1">客户行业</label>
							<div class="col-xs-12 col-sm-10">
								<div class="clearfix">
									<select name="industryId" class="form-control" id="form-field-select-1" style="width: 250px">
										<c:forEach items="${consumerindustry }" var="industry">
											<option value="${industry.id }">${industry.name }</option>
										</c:forEach>
									</select>
								</div>
							</div>
						</div>
						<div class="form-group">
							<label class="col-xs-12 col-sm-1 control-label no-padding-right" for="form-field-1">客户类型</label>
							<div class="col-xs-12 col-sm-10">
								<div class="clearfix">
									<select name="typeId" class="form-control" id="form-field-select-1" style="width: 250px">
										<c:forEach items="${consumerType }" var="type">
											<option value="${type.id }">${type.name }</option>
										</c:forEach>
									</select>
								</div>
							</div>
						</div>
						<div class="form-group">
							<label class="col-xs-12 col-sm-1 control-label no-padding-right" for="form-field-1">客户等级</label>
							<div class="col-xs-12 col-sm-10">
								<div class="clearfix">
									<select name="levelId" class="form-control" id="form-field-select-1" style="width: 250px">
										<c:forEach items="${consumerLevel }" var="level">
											<option value="${level.id }">${level.name }</option>
										</c:forEach>
									</select>
								</div>
							</div>
						</div>
						<div class="form-group">
							<label class="col-xs-12 col-sm-1 control-label no-padding-right" for="form-field-1">客户描述</label>
							<div class="col-xs-12 col-sm-10">
								<div class="clearfix">
									<textarea name="consumer.description" style="width: 385px;height: 100px;" placeholder="最多输入500个字符"></textarea>
								</div>
							</div>
						</div>
						<div class="form-group">
							<label class="col-xs-12 col-sm-1 control-label no-padding-right" for="form-field-1">传真号码</label>
							<div class="col-xs-12 col-sm-10">
								<div class="clearfix">
									<input type="text" class="col-xs-10 col-sm-5" name="consumer.fax" />
								</div>
							</div>
						</div>
						<div class="form-group">
							<label class="col-xs-12 col-sm-1 control-label no-padding-right" for="form-field-1">邮政编码</label>
							<div class="col-xs-12 col-sm-10">
								<div class="clearfix">
									<input type="text" class="col-xs-10 col-sm-5" name="consumer.postCode" />
								</div>
							</div>
						</div>
						<div class="form-group">
							<label class="col-xs-12 col-sm-1 control-label no-padding-right" for="form-field-1">营业额</label>
							<div class="col-xs-12 col-sm-10">
								<div class="clearfix">
									<input type="text" class="col-xs-10 col-sm-5" name="consumer.revenue" />
								</div>
							</div>
						</div>
						<div class="form-group">
							<label class="col-xs-12 col-sm-1 control-label no-padding-right" for="form-field-1">客户备注</label>
							<div class="col-xs-12 col-sm-10">
								<div class="clearfix">
									<textarea name="consumer.remark" style="width: 385px;height: 100px;" placeholder="最多输入500个字符"></textarea>
								</div>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-1 control-label no-padding-right" for="form-field-1"></label>
							<div class="col-sm-10">
								<input type="submit" id="submitButton" class="btn btn-info" value="保存">
							</div>
						</div>
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
			$("#sub_31").addClass("active");
		}
	</script>
	<script>
		
		$(document).ready(function(){
			
			// 手机号码验证 
			jQuery.validator.addMethod("isMobile", function(value, element) { 
			  var length = value.length; 
			  var mobile = /^(((13[0-9]{1})|(15[0-9]{1}))+\d{8})$/; 
			  return this.optional(element) || (length == 11 && mobile.test(value)); 
			}, "请正确填写您的手机号码"); 
			
			// 邮政编码验证 
			jQuery.validator.addMethod("isZipCode", function(value, element) { 
			  var tel = /^[0-9]{6}$/; 
			  return this.optional(element) || (tel.test(value)); 
			}, "请正确填写您的邮政编码"); 
	 		
			$("#consumer.name").focus();
			$("#consumerForm").validate({
				errorElement: 'div',
				errorClass: 'help-block',
				 rules: { 
					'consumer.name': { 
	        			required: true,
	    			},
	    			'consumer.phone': {
	    				required: true
	    			},
	    			'consumer.address': {
	    				required: true
	    			},
	    			'industryId': { 
	        			required: true,
	    			},
	    			'typeId': {
	    				required: true
	    			},
	    			'levelId': {
	    				required: true
	    			},
	    			'consumer.description': { 
	    				maxlength:500
	    			},
	    			'consumer.fax': {
	    				required: true
	    			},
	    			'consumer.postCode': {
	    				required: true,
	    				isZipCode : true
	    			},
	    			'consumer.revenue': {
	    				required: true,
	    				number:true
	    			},
	    			'consumer.remark': {
	    				maxlength:500
	    			}
				},
				messages: {
					'consumer.name': { 
	        			required: "不能为空",
	    			},
	    			'consumer.phone': {
	    				required: "不能为空",
	    			},
	    			'consumer.address': {
	    				required: "不能为空",
	    			},
	    			'industryId': { 
	        			required: "请选择",
	    			},
	    			'typeId': {
	    				required: "请选择",
	    			},
	    			'levelId': {
	    				required: "请选择",
	    			},
	    			'consumer.description': { 
	    				maxlength: "最多输入500个字符"
	    			},
	    			'consumer.fax': {
	    				required: "不能为空"
	    			},
	    			'consumer.postCode': {
	    				required: "不能为空",
	    				isZipCode:"请输入正确的邮政编码"
	    			},
	    			'consumer.revenue': {
	    				required: "不能为空",
	    				number:"请输入数字"
	    			},
	    			'consumer.remark': {
	    				maxlength: "最多输入500个字符"
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
					 ajaxAdd(form,'consumerAction!newConsumer.action');
			    }
			});
		});
	</script>
	
	
	
	</body>
</html>