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
					<a href="#">首页</a>
				</li>

				<li>
					<a href="#">用户角色</a>
				</li>
				<li class="active">权限管理</li>
			</ul>
		</div><!-- .breadcrumb -->

		<div class="page-content">
			<div>
				<h3 class="row-fluid header smaller  blue" style="line-height: 39px;">
					<span class="span7">新增权限 </span><!-- /span -->

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
					<form action="authoritiesAction!add.action" method="post" id="authForm"  class="form-horizontal" role="form">
						<s:token></s:token>
						<div class="form-group">
							<label class="col-xs-12 col-sm-1 control-label no-padding-right" for="form-field-1">权限类型</label>
							<div class="col-xs-12 col-sm-10">
								<div class="clearfix">
									<c:if test="${type == 0}">
										<input type="text" readonly="readonly"  value="菜单"/>
										<input type="hidden" name="authorities.authoritiesType"  value="0"/>
									</c:if>
									<c:if test="${type == 1}">
										<input type="text" readonly="readonly"  value="栏目"/>
										<input type="hidden" name="authorities.authoritiesType"  value="1"/>
									</c:if>
									<c:if test="${type == 2}">
										<input type="text" readonly="readonly"  value="功能"/>
										<input type="hidden" name="authorities.authoritiesType"  value="2"/>
									</c:if>
								</div>
							</div>
						</div>
						
						<div class="form-group" <c:if test="${type == 2}">style="display: none;"</c:if>>
							<label class="col-xs-12 col-sm-1 control-label no-padding-right" for="form-field-1">父级权限</label>
							<div class="col-xs-12 col-sm-10">
								<div class="clearfix">
									<input type="text" name="fatherAuthName" id="fatherAuthName" value="${fatherAuthName}" onfocus="listAuthorities();" readonly class="col-xs-10 col-sm-5"/>
								</div>
							</div>
						</div>
						<div class="form-group">
							<label class="col-xs-12 col-sm-1 control-label no-padding-right" for="form-field-1">权限名称</label>
							<div class="col-xs-12 col-sm-10">
								<div class="clearfix">
									<input type="text" id="" name="name" class="col-xs-10 col-sm-5"/>
								</div>
							</div>
						</div>
						<div class="form-group">
							<label class="col-xs-12 col-sm-1 control-label no-padding-right" for="form-field-1">显示名称</label>
							<div class="col-xs-12 col-sm-10">
								<div class="clearfix">
									<input type="text" id="displayName" name="displayName" class="col-xs-10 col-sm-5"/>
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
			$("#parent_2").addClass("active open");
			$("#sub_23").addClass("active");
		}
	</script>
	<script>
		$(document).ready(function(){
	 		
			$("#fatherAuthName").focus();
			$("#authForm").validate({
				errorElement: 'div',
				errorClass: 'help-block',
				 rules: { 
					name: { 
		    			required: true, 
		    			maxlength:50,
		    			remote: "rolesAction!checkName.action?orgName=''&math="+Math.random()
					},
					displayName:
					{
						required: true, 
		    			maxlength:50,
		    			remote: "authoritiesAction!checkDisplayName.action?orgName=''&math="+Math.random()
					}
				},
				messages: {
					name: {
						required: "角色名称不能为空",
						maxlength: '角色名称长度最多50位',
						remote: '角色名称已经被占用'	
					},
					displayName:
					{
						required: "显示名称不能为空",
						maxlength: '显示名称长度最多50位',
						remote: '该显示名称已存在'
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
