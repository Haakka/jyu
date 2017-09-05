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
					<a href="${ctx}/orders/contractAction!retrieveAllContracts.action">合同订单</a>
				</li>
				<li class="active">合同管理</li>
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
					<form action="#" method="post" id="contractForm"  class="form-horizontal" role="form">
						<input type="hidden" name="contract.id" value="${contract.id}"/>
						<input type="hidden" name="contract.token" value="${contract.token}"/>
						
						<div class="form-group">
							<label class="col-xs-12 col-sm-1 control-label no-padding-right" for="form-field-1">合同名称</label>
							<div class="col-xs-12 col-sm-10">
								<div class="clearfix">
									<input type="text" class="col-xs-10 col-sm-5" name="contract.name" id="contract.name" value="${contract.name }"/>
								</div>
							</div>
						</div>
						<div class="form-group">
							<label class="col-xs-12 col-sm-1 control-label no-padding-right" for="form-field-1">合同编号</label>
							<div class="col-xs-12 col-sm-10">
								<div class="clearfix">
									<input type="text" class="col-xs-10 col-sm-5" name="contract.num" value="${contract.num }"/>
								</div>
							</div>
						</div>
						<div class="form-group">
							<label class="col-xs-12 col-sm-1 control-label no-padding-right" for="form-field-1">客户</label>
							<div class="col-xs-12 col-sm-10">
								<input type="text" name="consumerName" id="consumerName" value="${contract.consumerId.name}" disabled="disabled"/>
								<input type="hidden" name="consumerId" id="consumerId" value="${contract.consumerId.id}" />
							</div>
						</div>
						<div class="form-group">
							<label class="col-xs-12 col-sm-1 control-label no-padding-right" for="form-field-1">商机</label>
							<div class="col-xs-12 col-sm-10">
								<div class="clearfix">
									<input type="text" name="businessName" id="businessName" value="${contract.businessId.name}" disabled="disabled"/>
									<input type="hidden" name="businessId" id="businessId" value="${contract.businessId.id}" />
								</div>
							</div>
						</div>
						<div class="form-group">
							<label class="col-xs-12 col-sm-1 control-label no-padding-right" for="form-field-1">签约日期</label>
							<div class="col-xs-12 col-sm-10">
								<div class="input-group">
									<input class="form-control date-picker" value="<fmt:formatDate value="${contract.contractDate }" pattern="yyyy-MM-dd"/>" name="contract.contractDate" id="id-date-picker-1" type="text" data-date-format="yyyy-mm-dd" style="width: 210px;"/>
									<span class="input-group-addon" style="width: 40px;">
										<i class="icon-calendar bigger-110"></i>
									</span>
								</div>
							</div>
						</div>
						<div class="form-group">
							<label class="col-xs-12 col-sm-1 control-label no-padding-right" for="form-field-1">总价</label>
							<div class="col-xs-12 col-sm-10">
								<div class="clearfix">
									<input type="text" class="col-xs-10 col-sm-5" name="contract.price" value="${contract.price }" style="width: 250px;"/>
								</div>
							</div>
						</div>
						<div class="form-group">
							<label class="col-xs-12 col-sm-1 control-label no-padding-right" for="form-field-1">内容</label>
							<div class="col-xs-12 col-sm-10">
								<div class="clearfix">
									<textarea name="contract.content" style="width: 385px;height: 100px;" placeholder="最多输入500个字符">${contract.content }</textarea>
								</div>
							</div>
						</div>
						<div class="form-group">
							<label class="col-xs-12 col-sm-1 control-label no-padding-right" for="form-field-1">描述</label>
							<div class="col-xs-12 col-sm-10">
								<div class="clearfix">
									<textarea name="contract.description" style="width: 385px;height: 100px;" placeholder="最多输入500个字符">${contract.description }</textarea>
								</div>
							</div>
						</div>
						<div class="form-group">
							<label class="col-xs-12 col-sm-1 control-label no-padding-right" for="form-field-1">备注</label>
							<div class="col-xs-12 col-sm-10">
								<div class="clearfix">
									<textarea name="contract.remark" style="width: 385px;height: 100px;" placeholder="最多输入500个字符">${contract.remark }</textarea>
								</div>
							</div>
						</div>
						<div class="form-group">
							<label class="col-xs-12 col-sm-1 control-label no-padding-right" for="form-field-1">状态</label>
							<div class="col-xs-12 col-sm-10">
								<div class="clearfix">
									<select name="contract.status" class="form-control" id="form-field-select-1" style="width: 250px">
										<option value="0" <c:if test="${contract.status eq '0' }"> selected="selected"</c:if>>无效</option>
										<option value="1" <c:if test="${contract.status eq '1' }"> selected="selected"</c:if>>可撤销</option>
										<option value="2" <c:if test="${contract.status eq '2' }"> selected="selected"</c:if>>待定</option>
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
			$("#parent_4").addClass("active open");
			$("#sub_41").addClass("active");
		}
	</script>
	<script>
		
		$(document).ready(function(){
	 		
			$("#contract.name").focus();
			$("#contractForm").validate({
				errorElement: 'div',
				errorClass: 'help-block',
				rules: { 
					'contract.name': { 
	        			required: true,
	    			},
	    			'contract.num': {
	    				required: true
	    			},
	    			'consumerId': {
	    				required: true
	    			},
	    			'businessId': {
	    				required: true
	    			},
	    			'contract.contractDate': {
	    				required: true
	    			},
	    			'contract.price': {
	    				required: true
	    			},
	    			'contract.content':{
	    				
	    			},
					'contract.remark':{
	    				
	    			},
	    			'contract.status':{
	    				required: true
	    			}
				},
				messages: {
					'contract.name': { 
	        			required:"不能为空",
	    			},
	    			'contract.num': {
	    				required: "不能为空"
	    			},
	    			'consumerId': {
	    				required: "不能为空"
	    			},
	    			'businessId': {
	    				required: "不能为空"
	    			},
	    			'contract.contractDate': {
	    				required: "不能为空"
	    			},
	    			'contract.price': {
	    				required: "不能为空"
	    			},
	    			'contract.content':{
	    				
	    			},
					'contract.remark':{
	    				
	    			},
	    			'contract.status':{
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
					 ajaxUpdate(form,'contractAction!editContract.action');
			    }
			});
			
			$('.date-picker').datepicker({autoclose:true}).next().on(ace.click_event, function(){
				$(this).prev().focus();
			});
			
		});
	</script>
	
	
	
	</body>
</html>