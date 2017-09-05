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
					<a href="${ctx}/cusman/receivingAction!retrieveAllReceivings.action">财务管理</a>
				</li>
				<li class="active">收款管理</li>
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
					<form action="#" method="post" id="receivingForm"  class="form-horizontal" role="form">
						<input type="hidden" name="receiving.id" value="${receiving.id}"/>
						<input type="hidden" name="receiving.token" value="${receiving.token}"/>
						<div class="form-group">
							<label class="col-xs-12 col-sm-1 control-label no-padding-right" for="form-field-1">收款金额</label>
							<div class="col-xs-12 col-sm-10">
								<div class="clearfix">
									<input type="text" class="col-xs-10 col-sm-5" name="receiving.money" value="${receiving.money }"/>
								</div>
							</div>
						</div>
						<div class="form-group">
							<label class="col-xs-12 col-sm-1 control-label no-padding-right" for="form-field-1">收款时间</label>
							<div class="col-xs-12 col-sm-10">
								<div class="input-group">
									<input class="form-control date-picker" name="receiving.payTime" id="id-date-picker-1" type="text" data-date-format="yyyy-mm-dd" style="width: 210px;" value="<fmt:formatDate value="${receiving.payTime }" pattern="yyyy-MM-dd"/>"/>
									<span class="input-group-addon" style="width: 40px;">
										<i class="icon-calendar bigger-110"></i>
									</span>
								</div>
							</div>
						</div>
						<div class="form-group">
							<label class="col-xs-12 col-sm-1 control-label no-padding-right" for="form-field-1">订单</label>
							<div class="col-xs-12 col-sm-10">
								<div class="clearfix">
									<select name="orderId" id="form-field-select-1" style="width: 250px" disabled="disabled">
										<option value="${receiving.orderId.id}">${receiving.orderId.orderSn}</option>
									</select>
								</div>
							</div>
						</div>
						<div class="form-group">
							<label class="col-xs-12 col-sm-1 control-label no-padding-right" for="form-field-1">备注</label>
							<div class="col-xs-12 col-sm-10">
								<div class="clearfix">
									<textarea name="receiving.remark" style="width: 385px;height: 100px;" placeholder="最多输入500个字符">${receiving.remark }</textarea>
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
			$("#sub_51").addClass("active");
		}
	</script>
	<script>
		
		$(document).ready(function(){
			$("#receiving.money").focus();
			$("#receivingForm").validate({
				errorElement: 'div',
				errorClass: 'help-block',
				 rules: { 
					'receiving.money': { 
	        			required: true,
	    			},
	    			'receiving.payTime': {
	    				required: true
	    			},
	    			'orderId': {
	    				required: true
	    			},
	    			'receiving.remark':{
	    				maxlength:500
	    			}
				},
				messages: {
					'receiving.money': { 
	        			required: "不能为空",
	    			},
	    			'receiving.payTime': {
	    				required: "不能为空"
	    			},
	    			'orderId': {
	    				required: "不能为空"
	    			},
	    			'receiving.remark':{
	    				maxlength:"字符长度不能超过500"
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
					ajaxAdd(form,'receivingAction!editReceiving.action');
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