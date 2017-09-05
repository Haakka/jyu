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
					<a href="${ctx}/cusman/productAction!retrieveAllProducts.action">产品管理</a>
				</li>
				<li class="active">产品编辑</li>
			</ul>
		</div><!-- .breadcrumb -->

		<div class="page-content">
			<div>
				<h3 class="row-fluid header smaller  blue" style="line-height: 39px;">
					<span class="span7">产品编辑 </span><!-- /span -->

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
					<form action="#" method="post" id="productForm"  class="form-horizontal" role="form">
						<input type="hidden" name="product.id" value="${product.id}"/>
						<input type="hidden" name="product.token" value="${product.token}"/>
						<div class="form-group">
							<label class="col-xs-12 col-sm-1 control-label no-padding-right" for="form-field-1">产品名称</label>
							<div class="col-xs-12 col-sm-10">
								<div class="clearfix">
									<input type="text" class="col-xs-10 col-sm-5" name="product.name" id="product.name" value="${product.name }"/>
								</div>
							</div>
						</div>
						<div class="form-group">
							<label class="col-xs-12 col-sm-1 control-label no-padding-right" for="form-field-1">产品价格</label>
							<div class="col-xs-12 col-sm-10">
								<div class="clearfix">
									<input type="text" class="col-xs-10 col-sm-5" name="product.price" value="${product.price }"/>
								</div>
							</div>
						</div>
						<div class="form-group">
							<label class="col-xs-12 col-sm-1 control-label no-padding-right" for="form-field-1">成本价格</label>
							<div class="col-xs-12 col-sm-10">
								<div class="clearfix">
									<input type="text" class="col-xs-10 col-sm-5" name="product.costPrice" value="${product.costPrice }"/>
								</div>
							</div>
						</div>
						<div class="form-group">
							<label class="col-xs-12 col-sm-1 control-label no-padding-right" for="form-field-1">规格</label>
							<div class="col-xs-12 col-sm-10">
								<div class="clearfix">
									<input type="text" class="col-xs-10 col-sm-5" name="product.size" value="${product.size }"/>
								</div>
							</div>
						</div>
						<div class="form-group">
							<label class="col-xs-12 col-sm-1 control-label no-padding-right" for="form-field-1">单位</label>
							<div class="col-xs-12 col-sm-10">
								<div class="clearfix">
									<input type="text" class="col-xs-10 col-sm-5" name="product.unit" value="${product.unit }"/>
								</div>
							</div>
						</div>
						<div class="form-group">
							<label class="col-xs-12 col-sm-1 control-label no-padding-right" for="form-field-1">备注</label>
							<div class="col-xs-12 col-sm-10">
								<div class="clearfix">
									<textarea name="product.remark" style="width: 385px;height: 100px;" placeholder="最多输入500个字符">${product.remark }</textarea>
								</div>
							</div>
						</div>
						<div class="form-group">
							<label class="col-xs-12 col-sm-1 control-label no-padding-right" for="form-field-1">产品类型</label>
							<div class="col-xs-12 col-sm-10">
								<div class="clearfix">
									<select name="typeId" class="form-control" id="form-field-select-1" style="width: 250px">
										<option value="${product.type.id }">${product.type.name }</option>
										<c:forEach items="${types }" var="type">
											<option value="${type.id }">${type.name }</option>
										</c:forEach>
									</select>
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
			$("#parent_7").addClass("active open");
		}
	</script>
	<script>
		
		$(document).ready(function(){

			$("#product.name").focus();
			$("#productForm").validate({
				errorElement: 'div',
				errorClass: 'help-block',
				 rules: { 
						'product.name': { 
		        			required: true,
		    			},
		    			'product.price': {
		    				required: true,
		    				number:true
		    			},
		    			'product.costPrice': {
		    				required: true,
		    				number:true
		    			},
		    			'product.size': { 
		        			required: true,
		    			},
		    			'product.unit': {
		    				required: true
		    			},
		    			'product.remark': {
		    				maxlength:500
		    			},
		    			'typeId': {
		    				required: true
		    			}
					},
					messages: {
						'product.name': { 
		        			required:  "不能为空",
		    			},
		    			'product.price': {
		    				required:  "不能为空",
		    				number:"请输入数字"
		    			},
		    			'product.costPrice': {
		    				required:  "不能为空",
		    				number:"请输入数字"
		    			},
		    			'product.size': { 
		        			required: "不能为空",
		    			},
		    			'product.unit': {
		    				required:  "不能为空"
		    			},
		    			'product.remark': {
		    				maxlength: "最多输入500个字符"
		    			},
		    			'typeId': {
		    				required:  "不能为空"
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
					 ajaxUpdate(form,'productAction!editProduct.action');
			    }
			});
		});
	</script>
	
	
	
	</body>
</html>