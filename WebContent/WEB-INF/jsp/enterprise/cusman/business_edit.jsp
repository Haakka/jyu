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
					<a href="${ctx}/cusman/businessAction!retrieveAllBusinesss.action">客户管理</a>
				</li>
				<li class="active">商机线索</li>
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
					<form action="#" method="post" id="businessForm"  class="form-horizontal" role="form">
						<input type="hidden" name="business.id" value="${business.id}"/>
						<input type="hidden" name="business.token" value="${business.token}"/>
						<div class="form-group">
							<label class="col-xs-12 col-sm-1 control-label no-padding-right" for="form-field-1">名称</label>
							<div class="col-xs-12 col-sm-10">
								<div class="clearfix">
									<input type="text" class="col-xs-10 col-sm-5" name="business.name" id="business.name" value="${business.name }"/>
								</div>
							</div>
						</div>
						<div class="form-group">
							<label class="col-xs-12 col-sm-1 control-label no-padding-right" for="form-field-1">商机来源</label>
							<div class="col-xs-12 col-sm-10">
								<div class="clearfix">
									<select name="originId" class="form-control" id="form-field-select-1" style="width: 250px">
										<c:forEach items="${origins }" var="origin">
											<option value="${origin.id }" <c:if test="${business.originId.id == origin.id }">selected="selected"</c:if>>${origin.name }</option>
										</c:forEach>
									</select>
								</div>
							</div>
						</div>
						<div class="form-group">
							<label class="col-xs-12 col-sm-1 control-label no-padding-right" for="form-field-1">商机类型</label>
							<div class="col-xs-12 col-sm-10">
								<div class="clearfix">
									<select name="typeId" class="form-control" id="form-field-select-1" style="width: 250px">
										<c:forEach items="${types }" var="type">
											<option value="${type.id }" <c:if test="${business.typeId.id == type.id }">selected="selected"</c:if>>${type.name }</option>
										</c:forEach>
									</select>
								</div>
							</div>
						</div>
						<div class="form-group">
							<label class="col-xs-12 col-sm-1 control-label no-padding-right" for="form-field-1">商机价值</label>
							<div class="col-xs-12 col-sm-10">
								<div class="clearfix">
									<select name="valueId" class="form-control" id="form-field-select-1" style="width: 250px">
										<c:forEach items="${values }" var="value">
											<option value="${value.id }" <c:if test="${business.valueId.id == value.id }">selected="selected"</c:if>>${value.name }</option>
										</c:forEach>
									</select>
								</div>
							</div>
						</div>
						<div class="form-group">
							<label class="col-xs-12 col-sm-1 control-label no-padding-right" for="form-field-1">赢单率</label>
							<div class="col-xs-12 col-sm-10">
								<div class="clearfix">
									<input type="text" style="width: 50px;"  name="business.rate" value="${business.rate }"/>%
								</div>
							</div>
						</div>
						<div class="form-group">
							<label class="col-xs-12 col-sm-1 control-label no-padding-right" for="form-field-1">客户</label>
							<div class="col-xs-12 col-sm-10">
								<div class="clearfix">
									<select name="consumerId" class="width-80 chosen-select" id="form-field-select-1" style="width: 250px">
										<c:forEach items="${consumers }" var="consumer">
											<option value="${consumer.id }" <c:if test="${business.consumer.id == consumer.id }">selected="selected"</c:if>>${consumer.name }</option>
										</c:forEach>
									</select>
								</div>
							</div>
						</div>
						<div class="form-group">
							<label class="col-xs-12 col-sm-1 control-label no-padding-right" for="form-field-1">联系人</label>
							<div class="col-xs-12 col-sm-10">
								<div class="clearfix">
									<select name="contactorId" class="width-80 chosen-select" id="form-field-select-2" style="width: 250px">
										<c:forEach items="${contactors }" var="contactor">
											<option value="${contactor.id }" <c:if test="${business.contactor.id == contactor.id }">selected="selected"</c:if>>${contactor.name }</option>
										</c:forEach>
									</select>
								</div>
							</div>
						</div>
						<div class="form-group">
							<label class="col-xs-12 col-sm-1 control-label no-padding-right" for="form-field-1">状态</label>
							<div class="col-xs-12 col-sm-10">
								<div class="clearfix">
									<select name="business.status" class="form-control" id="form-field-select-1" style="width: 250px">
										<option value="0" <c:if test="${business.status eq '0'}"> selected="selected"</c:if>>初次接洽</option>
										<option value="1" <c:if test="${business.status eq '1'}"> selected="selected"</c:if>>已报价</option>
										<option value="2" <c:if test="${business.status eq '2'}"> selected="selected"</c:if>>价格谈判</option>
										<option value="3" <c:if test="${business.status eq '3'}"> selected="selected"</c:if>>赢单</option>
										<option value="4" <c:if test="${business.status eq '4'}"> selected="selected"</c:if>>赢单</option>
									</select>
								</div>
							</div>
						</div>
						<div class="form-group">
							<label class="col-xs-12 col-sm-1 control-label no-padding-right" for="form-field-1">备注</label>
							<div class="col-xs-12 col-sm-10">
								<div class="clearfix">
									<textarea name="business.remark" style="width: 385px;height: 100px;" placeholder="最多输入500个字符">${business.remark }</textarea>
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
			$("#sub_33").addClass("active");
		}
	</script>
	<script>
		
		$(document).ready(function(){

	 		
			$("#business.name").focus();
			$("#businessForm").validate({
				errorElement: 'div',
				errorClass: 'help-block',
				 rules: { 
						'business.name': { 
		        			required: true,
		    			},
		    			'originId': {
		    				required: true
		    			},
		    			'typeId': {
		    				required: true
		    			},
		    			'valueId': { 
		        			required: true,
		    			},
		    			'business.rate': {
		    				required: true,
		    				number:true,
		    				digits:true,
		    				min : 0
		    			},
		    			'consumerId': {
		    				required: true
		    			},
		    			'business.name': { 
		        			required: true,
		    			},
		    			'contactorId': {
		    				required: true
		    			},
		    			'business.status': {
		    				required: true
		    			},
		    			'business.remark' :{
		    				
		    			}
					},
					messages: {
						'business.name': { 
		        			required: "不能为空"
		    			},
		    			'originId': {
		    				required: "不能为空"
		    			},
		    			'typeId': {
		    				required: "不能为空"
		    			},
		    			'valueId': { 
		        			required: "不能为空",
		    			},
		    			'business.rate': {
		    				required: "不能为空",
		    				number:"请输入数字",
		    				digits:"请输入整数",
		    				min : "输入值不能小于 0"
		    			},
		    			'consumerId': {
		    				required: "不能为空"
		    			},
		    			'business.name': { 
		        			required: "不能为空",
		    			},
		    			'contactorId': {
		    				required: "不能为空"
		    			},
		    			'business.status': {
		    				required:"不能为空"
		    			},
		    			'business.remark' :{
		    				
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
					ajaxUpdate(form,'businessAction!editBusiness.action');
			    }
				
			});
			
			$(".chosen-select").chosen({no_results_text : "未找到此选项!",search_contains: true}); 
		});
	</script>
	
	
	
	</body>
</html>