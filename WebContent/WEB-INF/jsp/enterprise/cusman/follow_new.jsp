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
					<a href="${ctx}/cusman/followAction!retrieveAllFollows.action">客户管理</a>
				</li>
				<li class="active">我的跟进</li>
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
					<form action="#" method="post" id="followForm"  class="form-horizontal" role="form">
						
						<div class="form-group">
							<label class="col-xs-12 col-sm-1 control-label no-padding-right" for="form-field-1">跟进客户</label>
							<div class="col-xs-12 col-sm-10">
								<div class="clearfix">
									<select name="consumerId" data-placeholder="请选择客户..." class="width-80 chosen-select" id="form-field-select-1" style="width: 250px">
										<option value=""></option>
										<c:forEach items="${consumers }" var="consumer">
											<option value="${consumer.id }">${consumer.name }</option>
										</c:forEach>
									</select>
								</div>
							</div>
						</div>
						<div class="form-group">
							<label class="col-xs-12 col-sm-1 control-label no-padding-right" for="form-field-1">跟进方式</label>
							<div class="col-xs-12 col-sm-10">
								<div class="clearfix">
									<select name="typeId" class="form-control" id="form-field-select-1" style="width: 250px">
										<c:forEach items="${types }" var="type">
											<option value="${type.id }">${type.name }</option>
										</c:forEach>
									</select>
								</div>
							</div>
						</div>
						<div class="form-group">
							<label class="col-xs-12 col-sm-1 control-label no-padding-right" for="form-field-1">跟进时间</label>
							<div class="col-xs-12 col-sm-10">
								<div class="input-group date form_datetime col-md-4" data-date-format="yyyy-mm-dd HH:mm:ss" data-link-field="followTime">
				                    <input class="form-control" style="margin-left: -13px;" size="16" type="text" value="" readonly>
				                    <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
									<span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
				                </div>
								<input type="hidden" id="followTime" name ="follow.followTime" value="" /><br/>
							</div>
						</div>
						<div class="form-group">
							<label class="col-xs-12 col-sm-1 control-label no-padding-right" for="form-field-1">跟进内容</label>
							<div class="col-xs-12 col-sm-10">
								<div class="clearfix">
									<textarea name="follow.content" style="width: 385px;height: 100px;" placeholder="最多输入500个字符"></textarea>
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
			$("#sub_34").addClass("active");
		}
	</script>
	<script>
		
		$(document).ready(function(){

			$("#followForm").validate({
				errorElement: 'div',
				errorClass: 'help-block',
				 rules: { 
					'consumerId': { 
	        			required: true,
	    			},
	    			'typeId': {
	    				required: true
	    			},
	    			'follow.followTime': {
	    				required: true
	    			},
	    			'follow.content': {
	    				required: true
	    			}
				},
				messages: {
					'consumerId': { 
	        			required: "不能为空",
	    			},
	    			'typeId': {
	    				required: "不能为空"
	    			},
	    			'follow.followTime': {
	    				required: "不能为空"
	    			},
	    			'follow.content': {
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
					 ajaxAdd(form,'followAction!newFollow.action');
			    }
			});
			
			$(".chosen-select").chosen({no_results_text : "未找到此选项!",search_contains: true});
		});
	</script>
	
	
	
	</body>
</html>