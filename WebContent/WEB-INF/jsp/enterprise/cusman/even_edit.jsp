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
					<a href="${ctx}/personal/evenAction!retrieveAllEvens.action">客户管理</a>
				</li>
				<li class="active">交往记录</li>
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
					<form action="#" method="post" id="evenForm"  class="form-horizontal" role="form">
						<input type="hidden" name="even.id" value="${even.id}"/>
						<input type="hidden" name="even.token" value="${even.token}"/>
						
						<div class="form-group">
							<label class="col-xs-12 col-sm-1 control-label no-padding-right" for="form-field-1">主题</label>
							<div class="col-xs-12 col-sm-10">
								<div class="clearfix">
									<input type="text" class="col-xs-10 col-sm-5" name="even.subject" id="even.subject" value="${even.subject }"/>
								</div>
							</div>
						</div>
						<div class="form-group">
							<label class="col-xs-12 col-sm-1 control-label no-padding-right" for="form-field-1">客户</label>
							<div class="col-xs-12 col-sm-10">
								<div class="clearfix">
									<select name="consumerId" class="width-80 chosen-select" id="form-field-select-1" style="width: 250px" disabled="disabled">
										<c:forEach items="${consumers }" var="consumer">
											<option value="${consumer.id }" <c:if test="${even.consumer.id == consumer.id }">selected="selected"</c:if> >
												${consumer.name }
											</option>
										</c:forEach>
									</select>
								</div>
							</div>
						</div>
						<div class="form-group">
							<label class="col-xs-12 col-sm-1 control-label no-padding-right" for="form-field-1">联系人</label>
							<div class="col-xs-12 col-sm-10">
								<div class="clearfix">
									<select name="contactorId" class="width-80 chosen-select" id="form-field-select-2" style="width: 250px" disabled="disabled">
										<option value="${even.contactor.id }">${even.contactor.name }</option>
									</select>
								</div>
							</div>
						</div>
						<div class="form-group">
							<label class="col-xs-12 col-sm-1 control-label no-padding-right" for="form-field-1">活动地点</label>
							<div class="col-xs-12 col-sm-10">
								<div class="clearfix">
									<input type="text" class="col-xs-10 col-sm-5" name="even.venue" value="${even.venue }"/>
								</div>
							</div>
						</div>
						<div class="form-group">
							<label class="col-xs-12 col-sm-1 control-label no-padding-right" for="form-field-1">开始时间</label>
							<div class="col-xs-12 col-sm-10">
								<div class="input-group date form_datetime col-md-4" data-date-format="yyyy-mm-dd HH:mm:ss" data-link-field="startDate">
				                    <input class="form-control" style="margin-left: -13px;" size="16" type="text" value="<fmt:formatDate value="${even.startDate}" pattern="yyyy-MM-dd HH:mm:ss"/>" readonly>
				                    <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
									<span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
				                </div>
								<input type="hidden" id="startDate" name ="even.startDate" value="<fmt:formatDate value="${even.startDate}" pattern="yyyy-MM-dd HH:mm:ss"/>" /><br/>
							</div>
						</div>
						<div class="form-group">
							<label class="col-xs-12 col-sm-1 control-label no-padding-right" for="form-field-1">结束时间</label>
							<div class="col-xs-12 col-sm-10">
								<div class="input-group date form_datetime col-md-4" data-date-format="yyyy-mm-dd HH:mm:ss" data-link-field="endDate">
				                    <input class="form-control" style="margin-left: -13px;" size="16" type="text" value="<fmt:formatDate value="${even.endDate }" pattern="yyyy-MM-dd HH:mm:ss"/>" readonly>
				                    <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
									<span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
				                </div>
								<input type="hidden" id="endDate" name ="even.endDate" value="<fmt:formatDate value="${even.endDate }" pattern="yyyy-MM-dd HH:mm:ss"/>" /><br/>
							</div>
						</div>
						<div class="form-group">
							<label class="col-xs-12 col-sm-1 control-label no-padding-right" for="form-field-1">描述</label>
							<div class="col-xs-12 col-sm-10">
								<div class="clearfix">
									<textarea name="even.description" style="width: 385px;height: 100px;" placeholder="最多输入500个字符">${even.description }</textarea>
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
			$("#sub_35").addClass("active");
		}
	</script>
	<script>
		
		$(document).ready(function(){
	 		
			$("#even.subject").focus();
			$("#evenForm").validate({
				errorElement: 'div',
				errorClass: 'help-block',
				 rules: { 
					'even.subject': { 
	        			required: true,
	    			},
	    			'even.venue': { 
	        			required: true,
	    			},
	    			'even.startDate': {
	    				required: true
	    			},
	    			'even.endDate': {
	    				required: true
	    			},
	    			'even.description':{
	    				maxlength:500
	    			}
				},
				messages: {
					'even.subject': { 
						required: "不能为空"
	    			},
	    			'even.venue': { 
	    				required: "不能为空"
	    			},
	    			'even.startDate': {
	    				required: "不能为空"
	    			},
	    			'even.endDate': {
	    				required: "不能为空"
	    			},
	    			'even.description':{
	    				maxlength:"字符长度不要超过500哦"
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
					 ajaxUpdate(form,'evenAction!editEven.action');
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