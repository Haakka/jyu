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
					<a href="${ctx}/orders/orderAction!retrieveAllOrders.action">合同订单</a>
				</li>
				<li class="active">订单管理</li>
			</ul>
		</div><!-- .breadcrumb -->

		<div class="page-content">
			<div>
				<h3 class="row-fluid header smaller  blue" style="line-height: 39px;">
					<span class="span7">添加 </span><!-- /span -->

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
					<form action="#" method="post" id="orderForm"  class="form-horizontal" role="form">
					
						<div class="form-group">
							<label class="col-xs-12 col-sm-1 control-label no-padding-right" for="form-field-1">合同</label>
							<div class="col-xs-12 col-sm-10">
								<div>
									<select name="contractId" style="width:300px;" class="width-80 chosen-select" id="form-field-select-3" data-placeholder="请选择合同...">
										<option value=""></option>
										<c:forEach items="${contracts }" var="contract">
											<option value="${contract.id }">${contract.num }</option>
										</c:forEach>
									</select>
								</div>
							</div>
						</div>
						<div class="form-group">
							<label class="col-xs-12 col-sm-1 control-label no-padding-right" for="form-field-1">完成人</label>
							<div class="col-xs-12 col-sm-10">
								<div class="clearfix">
									<select name="finisherId" class="width-80 chosen-select" id="form-field-select-3" data-placeholder="请选择完成者...">
										<option value=""></option>
										<c:forEach items="${finishers }" var="finisher">
											<option value="${finisher.id }">${finisher.name }</option>
										</c:forEach>
									</select>
								</div>
							</div>
						</div>
						<div class="form-group">
							<label class="col-xs-12 col-sm-1 control-label no-padding-right" for="form-field-1">订单金额</label>
							<div class="col-xs-12 col-sm-10">
								<div class="clearfix">
									<input type="text" class="col-xs-10 col-sm-5" name="order.totalAmount" style="width:200px;"/>
								</div>
							</div>
						</div>
						<div class="form-group">
							<label class="col-xs-12 col-sm-1 control-label no-padding-right" for="form-field-1">支付时间</label>
							<div class="col-xs-12 col-sm-10">
								<div class="input-group">
									<input class="form-control date-picker" name="order.payTime" id="id-date-picker-1" type="text" data-date-format="yyyy-mm-dd" style="width: 261px;"/>
									<span class="input-group-addon" style="width: 40px;">
										<i class="icon-calendar bigger-110"></i>
									</span>
								</div>
							</div>
						</div>
						<div class="form-group">
							<label class="col-xs-12 col-sm-1 control-label no-padding-right" for="form-field-1">支付方式</label>
							<div class="col-xs-12 col-sm-10">
								<div class="clearfix">
									<select name="payTypeId"  id="form-field-select-2">
										<c:forEach items="${payTypes }" var="payType">
											<option value="${payType.id }">${payType.name }</option>
										</c:forEach>
									</select>
								</div>
							</div>
						</div>
						
						<div class="form-group">
							<label class="col-xs-12 col-sm-1 control-label no-padding-right" for="form-field-tags">产品</label>
							<div class="col-xs-12 col-sm-10">
								<select name="productId" style="width:300px;" class="width-80 chosen-select" id="form-field-select-3" data-placeholder="请选择合同...">
										<option value=""></option>
										<c:forEach items="${products }" var="product">
											<option value="${product.id }">${product.name }</option>
										</c:forEach>
									</select>
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
			$("#parent_4").addClass("active open");
			$("#sub_42").addClass("active");
		}
	</script>
	<script>
		
		$(document).ready(function(){

			$("#orderForm").validate({
				errorElement: 'div',
				errorClass: 'help-block',
				 rules: { 
					'order.payTime': { 
	        			required: true,
	    			},
	    			'order.totalAmount': {
	    				required: true,
	    				number : true,
	    			},
	    			'contractId': {
	    				required: true
	    			},
	    			'payTypeId' : {
	    				required: true
	    			},
	    			'finisherId' : {
	    				required: true
	    			}
				},
				messages: {
					'order.payTime': { 
	        			required: "不能为空"
	    			},
	    			'order.totalAmount': {
	    				required: "不能为空",
	    				number : "请输入数字",
	    			},
	    			'contractId': {
	    				required: "不能为空",
	    			},
	    			'payTypeId' : {
	    				required: "不能为空",
	    			},
	    			'finisherId' : {
	    				required: "不能为空",
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
					ajaxAdd(form,'orderAction!newOrder.action');
			    }
			});
			
			
			$('.date-picker').datepicker({autoclose:true}).next().on(ace.click_event, function(){
				$(this).prev().focus();
			});
			
			$(".chosen-select").chosen({no_results_text : "未找到此选项!",search_contains: true});
			
			
			
		});
	</script>
	
	
	
	</body>
</html>