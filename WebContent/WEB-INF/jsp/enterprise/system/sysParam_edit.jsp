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
					<a href="${ctx}/system/sysParamAction!retrieveAllSysParams.action">系统参数</a>
				</li>
			</ul>
		</div><!-- .breadcrumb -->

		<div class="page-content">
			<div>
				<h3 class="row-fluid header smaller  blue" style="line-height: 39px;">
					<span class="span7">参数编辑 </span><!-- /span -->

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
					<form action="#" method="post" id="sysParamForm"  class="form-horizontal" role="form">
						<input type="hidden" name="sysParam.id" value="${sysParam.id}"/>
						<input type="hidden" name="sysParam.token" value="${sysParam.token}"/>
						<div class="form-group">
							<label class="col-xs-12 col-sm-1 control-label no-padding-right" for="form-field-1">参数名称</label>
							<div class="col-xs-12 col-sm-10">
								<div class="clearfix">
									<input type="text" class="col-xs-10 col-sm-5" name="sysParam.name" value="${sysParam.name}" />
								</div>
							</div>
						</div>
						<div class="form-group">
							<label class="col-xs-12 col-sm-1 control-label no-padding-right" for="form-field-1">排序</label>
							<div class="col-xs-12 col-sm-10">
								<div class="clearfix">
									<input type="text" class="col-xs-10 col-sm-5" name="sysParam.sort" value="${sysParam.sort}" />
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
			$("#parent_x").addClass("active open");
			$("#sub_xx").addClass("active");
		}
	</script>
	<script>
		
		$(document).ready(function(){

			$("#sysParamForm").validate({
				errorElement: 'div',
				errorClass: 'help-block',
				 rules: { 
					'sysParam.name': { 
						required: true,
	        			maxlength:250,
	        			remote:{
	    		            url: "sysParamTypeAction!isUniqueName.action",
	    		            type: "post",
	    		            dataType: 'json',
	    			        data: {
	    			            name:  function() {   
                                   			 return $("#sysParamType\\.typeName").val();   
                                		}  
	    			            }
	    		            }
	    			},
	    			'sysParam.sort': {
	    				required: true,
	    				number:true,
	    				digits:true,
	    				range:[1,999]
	    			},
	    			'sysParam.isDel': {
	    				required: true
	    			}
				},
				messages: {
					'sysParam.name': { 
						required: "不能为空",
	        			maxlength:"最多输入250个字符",
	        			remote: '该名称已存在'
	    			},
	    			'sysParam.sort': {
	    				required: "不能为空",
	    				number: "必须输入合法的数字(自然数)",
	    				digits: "必须输入合法的数字(自然数)",
	    				range: "请输入1~999之间的数字"
	    			},
	    			'sysParam.isDel': {
	    				required: "请选择"
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
					 ajaxUpdate(form,'sysParamAction!editSysParam.action');
			     }
			});
		});
	</script>
	
	
	
	</body>
</html>