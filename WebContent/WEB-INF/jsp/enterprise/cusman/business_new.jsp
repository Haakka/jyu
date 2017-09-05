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
					<span class="span7">添加</span><!-- /span -->

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
						
						<div class="form-group">
							<label class="col-xs-12 col-sm-1 control-label no-padding-right" for="form-field-1">名称</label>
							<div class="col-xs-12 col-sm-10">
								<div class="clearfix">
									<input type="text" class="col-xs-10 col-sm-5" name="business.name" id="business.name" value="${sessionScope.name }"/>
								</div>
							</div>
						</div>
						<div class="form-group">
							<label class="col-xs-12 col-sm-1 control-label no-padding-right" for="form-field-1">商机来源</label>
							<div class="col-xs-12 col-sm-10">
								<div class="clearfix">
									<select name="originId" class="form-control" id="form-field-select-1" style="width: 250px">
										<c:forEach items="${origins }" var="origin">
											<option value="${origin.id }">${origin.name }</option>
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
											<option value="${type.id }">${type.name }</option>
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
											<option value="${value.id }">${value.name }</option>
										</c:forEach>
									</select>
								</div>
							</div>
						</div>
						<div class="form-group">
							<label class="col-xs-12 col-sm-1 control-label no-padding-right" for="form-field-1">赢单率</label>
							<div class="col-xs-12 col-sm-10">
								<div class="clearfix">
									<input type="text" style="width: 50px;" name="business.rate" />%
								</div>
							</div>
						</div>
						<div class="form-group">
							<label class="col-xs-12 col-sm-1 control-label no-padding-right" for="form-field-1">客户</label>
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
							<label class="col-xs-12 col-sm-1 control-label no-padding-right" for="form-field-1">联系人</label>
							<div class="col-xs-12 col-sm-10">
								<div class="clearfix">
									<select name="contactorId" data-placeholder="请选择联系人..." id="form-field-select-2" style="width: 250px">
										<option value=""></option>
									</select>
								</div>
							</div>
						</div>
						<div class="form-group">
							<label class="col-xs-12 col-sm-1 control-label no-padding-right" for="form-field-1">状态</label>
							<div class="col-xs-12 col-sm-10">
								<div class="clearfix">
									<select name="business.status" class="form-control" id="form-field-select-1" style="width: 250px">
										<option value="0">初次接洽</option>
										<option value="1">已报价</option>
										<option value="2">价格谈判</option>
										<option value="3">赢单</option>
										<option value="4">赢单</option>
									</select>
								</div>
							</div>
						</div>
						<div class="form-group">
							<label class="col-xs-12 col-sm-1 control-label no-padding-right" for="form-field-1">备注</label>
							<div class="col-xs-12 col-sm-10">
								<div class="clearfix">
									<textarea name="business.remark" style="width: 385px;height: 100px;" placeholder="最多输入500个字符"></textarea>
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
	    				maxlength:500
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
					 ajaxAdd(form,'ajaxBusinessAction!newBusiness.action');
			    }
			});
			
			
			$(".chosen-select").chosen({no_results_text : "未找到此选项!",search_contains: true});
			
			$(".chosen-select").chosen().on("change", function (evt, params) {
			    $.ajax({
			    	url:"ajaxContactAction!ajaxFindContactByConsumerId.action",
			    	type:'post',
			    	data:{'id':params.selected},
			    	datatype:"json",
			    	success:function(data){
			    		var json = eval("("+data+")");
			    		$("#form-field-select-2").empty();
			    		if(json.code == '200'){
			    			var result = json.result;
			    			console.log(result);
			    			if(result.length > 0){
			    				var str = "";
			    				for(var i=0; i<result.length; i++){
			    					str += '<option value="'+json.result[i].id+'">'+json.result[i].name+'</option>';
			                    } 
			    				$("#form-field-select-2").html(str);
			    				$("#form-field-select-2").attr("disabled",false); 
			    			}else{
			    				bootbox.alert("该客户暂未添加联系人哦!");
			    			}
			    		}else{
			    			bootbox.alert("查询联系人失败!");
			    		}
			    	},
			    	error:function(data){
			    		bootbox.alert("网络出错!请稍后再试");
			    	}
			    });
			});
		});
	</script>
	
	
	
	</body>
</html>