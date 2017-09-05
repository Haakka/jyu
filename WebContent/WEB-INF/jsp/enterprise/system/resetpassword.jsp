<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html>
<html lang="zh-cn">
	<head>
		<meta charset="utf-8" />
		<title>美陶陶瓷管理平台</title>
		<meta name="keywords" content="" />
		<meta name="description" content="" />
		<meta name="viewport" content="" />
		
	</head>
	<%@ include file="/common/head-import.jsp"%>
	

	<div class="main-content">
		<div class="breadcrumbs" id="breadcrumbs">
			<script type="text/javascript">
				try{ace.settings.check('breadcrumbs' , 'fixed')}catch(e){}
			</script>

			<ul class="breadcrumb">
				<li>
					<i class="icon-home home-icon"></i>
					<a href="#">首页</a>
				</li>

				<li class="active">重置密码</li>
			</ul>
		</div><!-- .breadcrumb -->

		<div class="page-content">
			<div class="">
				<h3 class="row-fluid header smaller  blue" style="line-height: 39px;">
					<span class="span7">重置密码</span><!-- /span -->

					<span class="span5">
						<label class="pull-right inline">
							<button class="btn btn-white btm-xs" onclick="history.back();">
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
					<form action="updatePasswordAction!reset.action" method="post" name="passwordForm" id="passwordForm" class="form-horizontal" role="form">
						<input type="hidden" name="id" value="${id }"/>
						<div class="form-group">
							<label class="col-xs-12 col-sm-1 control-label no-padding-right" for="form-field-1">新密码</label>

							<div class="col-xs-12 col-sm-10">
								<div class="clearfix">
								<input type="password" id="newpassword" name="newpassword" class="col-xs-10 col-sm-5"/>
								</div>
							</div>
						</div>
						<div class="form-group">
							<label class="col-xs-12 col-sm-1 control-label no-padding-right" for="form-field-1">确认密码</label>

							<div class="col-xs-12 col-sm-10">
								<div class="clearfix">
								<input type="password" name="repassword" class="col-xs-10 col-sm-5"/>
								</div>
							</div>
						</div>
						<div class="form-group">
							<label class="col-xs-12 col-sm-1 control-label no-padding-right" for="form-field-1"></label>
							<div class="col-xs-12 col-sm-10">
								<input type="submit" class="btn btn-info" value="保存">
							</div>
						</div>
					</form>
					<!-- PAGE CONTENT ENDS -->
				</div><!-- /.col -->
			</div><!-- /.row -->
		</div><!-- /.page-content -->
		
		
		<div class="breadcrumbs" id="breadcrumbs" style="position:fixed; bottom: 0; right:0; width: 100%; text-align: center;">
			佛山市高明美陶陶瓷有限公司
		</div><!-- .breadcrumb -->
	</div><!-- /.main-content -->

				

	<%@ include file="/common/bottom-import.jsp"%>
	
	<script src="${ctx}/js/assets/js/fuelux/fuelux.wizard.min.js"></script>
	<script src="${ctx}/js/assets/js/jquery.validate.min.js"></script>
	<script type="text/javascript">
		jQuery(function($) {
			setCurrent();
		});
		
		function setCurrent(){
			$("#parent_2").addClass("active open");
			$("#sub_21").addClass("active");
		}
	</script>
	<script>
		$(document).ready(function(){
	 		
			$("#newpassword").focus();
			$("#passwordForm").validate({
				errorElement: 'div',
				errorClass: 'help-block',
				 rules: { 
					newpassword: {
		                required: true, 
		    			maxlength:16,
		    			minlength:6
		    	    },
		    	    repassword:{
		    	    	required: true, 
		    			maxlength:16,
		    			minlength:6,
		    			equalTo:"#newpassword"
		    	    }
				},
				messages: {
					newpassword: {
						required: "新密码不能为空",
						minlength: '新密码长度最少6位',
						maxlength: '新密码长度最多16位'
					},
					repassword: {
						required: "确认密码不能为空",
						minlength: '确认密码长度最少6位',
						maxlength: '确认密码长度最多16位',
						equalTo:'密码不一致'
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
				}
			});
		});
	</script>
	</body>
</html>


