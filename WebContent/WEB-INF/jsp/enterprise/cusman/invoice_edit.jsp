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
					<a href="${ctx}/cusman/invoiceAction!retrieveAllInvoices.action">财务管理</a>
				</li>
				<li class="active">开票管理</li>
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
					<form action="#" method="post" id="invoiceForm"  class="form-horizontal" role="form">
						<input type="hidden" name="invoice.id" value="${invoice.id}"/>
						<input type="hidden" name="invoice.token" value="${invoice.token}"/>
						<div class="form-group">
							<label class="col-xs-12 col-sm-1 control-label no-padding-right" for="form-field-1">订单</label>
							<div class="col-xs-12 col-sm-10">
								<div class="clearfix">
									<select name="orderId" id="form-field-select-1" style="width: 250px" disabled="disabled">
										<option value="${invoice.orderId.id }">${invoice.orderId.orderSn }</option>
									</select>
								</div>
							</div>
						</div>
						<div class="form-group">
							<label class="col-xs-12 col-sm-1 control-label no-padding-right" for="form-field-1">发票号码</label>
							<div class="col-xs-12 col-sm-10">
								<div class="clearfix">
									<input type="text" class="col-xs-10 col-sm-5" name="invoice.num" value="${invoice.num }"/>
								</div>
							</div>
						</div>
						<div class="form-group">
							<label class="col-xs-12 col-sm-1 control-label no-padding-right" for="form-field-1">发票代码</label>
							<div class="col-xs-12 col-sm-10">
								<div class="clearfix">
									<input type="text" class="col-xs-10 col-sm-5" name="invoice.code" value="${invoice.code }"/>
								</div>
							</div>
						</div>
						<div class="form-group">
							<label class="col-xs-12 col-sm-1 control-label no-padding-right" for="form-field-1">发票类型</label>
							<div class="col-xs-12 col-sm-10">
								<div class="clearfix">
									<select name="invoice.type">
										<option value="0" <c:if test="${invoice.type eq '0' }">selected="selected"</c:if>>普通发票</option>
										<option value="1" <c:if test="${invoice.type eq '1' }">selected="selected"</c:if>>增值税专用发票</option>
									</select>
								</div>
							</div>
						</div>
						<div class="form-group">
							<label class="col-xs-12 col-sm-1 control-label no-padding-right" for="form-field-1">发票金额</label>
							<div class="col-xs-12 col-sm-10">
								<div class="clearfix">
									<input type="text" class="col-xs-10 col-sm-5" name="invoice.amount" value="${invoice.amount }"/>
								</div>
							</div>
						</div>
						<div class="form-group">
							<label class="col-xs-12 col-sm-1 control-label no-padding-right" for="form-field-1">开票日期</label>
							<div class="col-xs-12 col-sm-10">
								<div class="input-group">
									<input class="form-control date-picker" name="invoice.startDate" id="id-date-picker-1" type="text" data-date-format="yyyy-mm-dd" style="width: 210px;" value="<fmt:formatDate value="${invoice.startDate }" pattern="yyyy-MM-dd"/>"/>
									<span class="input-group-addon" style="width: 40px;">
										<i class="icon-calendar bigger-110"></i>
									</span>
								</div>
							</div>
						</div>
						<div class="form-group">
							<label class="col-xs-12 col-sm-1 control-label no-padding-right" for="form-field-1">付款方名称</label>
							<div class="col-xs-12 col-sm-10">
								<div class="clearfix">
									<input type="text" class="col-xs-10 col-sm-5" name="invoice.payer" value="${invoice.payer }"/>
								</div>
							</div>
						</div>
						<div class="form-group">
							<label class="col-xs-12 col-sm-1 control-label no-padding-right" for="form-field-1">付款方地址</label>
							<div class="col-xs-12 col-sm-10">
								<div class="clearfix">
									<input type="text" class="col-xs-10 col-sm-5" name="invoice.payerAddress" value="${invoice.payerAddress }"/>
								</div>
							</div>
						</div>
						<div class="form-group">
							<label class="col-xs-12 col-sm-1 control-label no-padding-right" for="form-field-1">付款方电话</label>
							<div class="col-xs-12 col-sm-10">
								<div class="clearfix">
									<input type="text" class="col-xs-10 col-sm-5" name="invoice.payerTel" value="${invoice.payerTel }"/>
								</div>
							</div>
						</div>
						<div class="form-group">
							<label class="col-xs-12 col-sm-1 control-label no-padding-right" for="form-field-1">付款方开户行</label>
							<div class="col-xs-12 col-sm-10">
								<div class="clearfix">
									<input type="text" class="col-xs-10 col-sm-5" name="invoice.payerBank" value="${invoice.payerBank }"/>
								</div>
							</div>
						</div>
						<div class="form-group">
							<label class="col-xs-12 col-sm-1 control-label no-padding-right" for="form-field-1">付款方账号</label>
							<div class="col-xs-12 col-sm-10">
								<div class="clearfix">
									<input type="text" class="col-xs-10 col-sm-5" name="invoice.payerAcount" value="${invoice.payerAcount }"/>
								</div>
							</div>
						</div>
						<div class="form-group">
							<label class="col-xs-12 col-sm-1 control-label no-padding-right" for="form-field-1">收款方名称</label>
							<div class="col-xs-12 col-sm-10">
								<div class="clearfix">
									<input type="text" class="col-xs-10 col-sm-5" name="invoice.receiver" value="${invoice.receiver }"/>
								</div>
							</div>
						</div>
						<div class="form-group">
							<label class="col-xs-12 col-sm-1 control-label no-padding-right" for="form-field-1">收款方地址</label>
							<div class="col-xs-12 col-sm-10">
								<div class="clearfix">
									<input type="text" class="col-xs-10 col-sm-5" name="invoice.receiverAdderss" value="${invoice.receiverAdderss}"/>
								</div>
							</div>
						</div>
						<div class="form-group">
							<label class="col-xs-12 col-sm-1 control-label no-padding-right" for="form-field-1">收款方电话</label>
							<div class="col-xs-12 col-sm-10">
								<div class="clearfix">
									<input type="text" class="col-xs-10 col-sm-5" name="invoice.receiverTel" value="${invoice.receiverTel }"/>
								</div>
							</div>
						</div>
						<div class="form-group">
							<label class="col-xs-12 col-sm-1 control-label no-padding-right" for="form-field-1">收款方开户行</label>
							<div class="col-xs-12 col-sm-10">
								<div class="clearfix">
									<input type="text" class="col-xs-10 col-sm-5" name="invoice.receiverBank"  value="${invoice.receiverBank }"/>
								</div>
							</div>
						</div>
						<div class="form-group">
							<label class="col-xs-12 col-sm-1 control-label no-padding-right" for="form-field-1">收款方账户</label>
							<div class="col-xs-12 col-sm-10">
								<div class="clearfix">
									<input type="text" class="col-xs-10 col-sm-5" name="invoice.receiverAcount" value="${invoice.receiverAcount }"/>
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
			$("#parent_5").addClass("active open");
			$("#sub_52").addClass("active");
		}
	</script>
	<script>
		
		$(document).ready(function(){
	 		
			$("#invoice.num").focus();
			$("#invoiceForm").validate({
				errorElement: 'div',
				errorClass: 'help-block',
				 rules: { 
					'orderId': { 
	        			required: true,
	    			},
	    			'invoice.num': {
	    				required: true
	    			},
	    			'invoice.code': {
	    				required: true
	    			},
	    			'invoice.type': { 
	        			required: true,
	    			},
	    			'invoice.amount': {
	    				required: true
	    			},
	    			'invoice.startDate': {
	    				required: true
	    			},
	    			'invoice.payer': { 
	        			required: true,
	    			},
	    			'invoice.payerAddress': {
	    				required: true
	    			},
	    			'invoice.payerTel': {
	    				required: true
	    			},
	    			'invoice.payerBank': { 
	        			required: true,
	    			},
	    			'invoice.payerAcount': {
	    				required: true
	    			},
	    			'invoice.receiver': {
	    				required: true
	    			},
	    			'invoice.receiverAdderss': { 
	        			required: true,
	    			},
	    			'invoice.receiverTel': {
	    				required: true
	    			},
	    			'invoice.receiverBank': {
	    				required: true
	    			},
	    			'invoice.receiverAcount': { 
	        			required: true,
	    			}
				},
				messages: {
					'orderId': { 
	        			required: "请选择",
	    			},
	    			'invoice.num': {
	    				required: "不能为空"
	    			},
	    			'invoice.code': {
	    				required: "不能为空"
	    			},
	    			'invoice.type': { 
	    				required: "请选择"
	    			},
	    			'invoice.amount': {
	    				required: "不能为空"
	    			},
	    			'invoice.startDate': {
	    				required: "不能为空"
	    			},
	    			'invoice.payer': { 
	    				required: "不能为空"
	    			},
	    			'invoice.payerAddress': {
	    				required: "不能为空"
	    			},
	    			'invoice.payerTel': {
	    				required: "不能为空"
	    			},
	    			'invoice.payerBank': { 
	    				required: "不能为空"
	    			},
	    			'invoice.payerAcount': {
	    				required: "不能为空"
	    			},
	    			'invoice.receiver': {
	    				required: "不能为空"
	    			},
	    			'invoice.receiverAdderss': { 
	    				required: "不能为空"
	    			},
	    			'invoice.receiverTel': {
	    				required: "不能为空"
	    			},
	    			'invoice.receiverBank': {
	    				required: "不能为空"
	    			},
	    			'invoice.receiverAcount': { 
	    				required: "不能为空"
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
					ajaxUpdate(form,'invoiceAction!editInvoice.action');
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