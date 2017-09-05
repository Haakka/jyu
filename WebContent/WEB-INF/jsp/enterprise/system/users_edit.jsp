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
					<a href="#">首页</a>
				</li>

				<li>
					<a href="#">用户角色</a>
				</li>
				<li class="active">用户管理</li>
			</ul>
		</div><!-- .breadcrumb -->

		<div class="page-content">
			<div>
				<h3 class="row-fluid header smaller  blue" style="line-height: 39px;">
					<span class="span7">用户编辑 </span><!-- /span -->

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
					<form action="usersAction!update.action" method="post" id="userForm"  class="form-horizontal" role="form">
						<s:token></s:token>
						<input type="hidden" name="id" value="${tusers.id}"/>
						<div class="form-group">
							<label class="col-xs-12 col-sm-1 control-label no-padding-right" for="form-field-1">登录名称</label>
							<div class="col-xs-12 col-sm-10">
								<div class="clearfix">
									<input type="text" readonly="readonly"  value="${tusers.loginName}"/>
									<font color="red">&nbsp;&nbsp;&nbsp;&nbsp;登录名称不能修改</font>
								</div>
							</div>
						</div>
						<div class="form-group">
							<label class="col-xs-12 col-sm-1 control-label no-padding-right" for="form-field-1">真实名字</label>
							<div class="col-xs-12 col-sm-10">
								<div class="clearfix">
									<input type="text" name="name" class="col-xs-10 col-sm-5" value="${tusers.name}"/>
								</div>
							</div>
						</div>
						<div class="form-group">
							<label class="col-xs-12 col-sm-1 control-label no-padding-right" for="form-field-1">所属角色</label>
							<div class="col-xs-12 col-sm-10">
								<div class="clearfix">
									  <c:forEach var="rolesList" items="${rolesList}">
										<label class="inline">
											<input type="checkbox" class="ace" value="${rolesList.id}" name="checkmenu" 
												<c:forEach var="usersRolesList" items="${usersRolesList}">
													<c:if test="${usersRolesList.roles.id==rolesList.id}">
														checked
													</c:if>
												</c:forEach>
											/>
											<span class="lbl"> ${rolesList.name}&nbsp;&nbsp;</span>
										</label>
									  </c:forEach>
								</div>
							</div>
						</div>
						<div class="form-group">
							<label class="col-xs-12 col-sm-1 control-label no-padding-right" for="form-field-1">职位</label>
							<div class="col-xs-12 col-sm-10">
								<div class="clearfix">
									<select name="positionId" class="width-80 chosen-select" id="form-field-select-1" style="width: 250px" data-placeholder="请选择职位...">
										<c:forEach items="${positions }" var="position">
											<option value="${position.id }" <c:if test="${position.id == tusers.positionId.id }">selected="selected"</c:if>>${position.name }</option>
										</c:forEach>
									</select>
								</div>
							</div>
						</div>
						<div class="form-group">
							<label class="col-xs-12 col-sm-1 control-label no-padding-right" for="form-field-1">生日</label>
							<div class="col-xs-12 col-sm-10">
								<div class="input-group">
									<input class="form-control date-picker" name="birthday" id="id-date-picker-1" type="text" data-date-format="yyyy-mm-dd" style="width: 210px;" value="<fmt:formatDate value="${tusers.birthday}" pattern="yyyy-MM-dd"/>"/>
									<span class="input-group-addon" style="width: 40px;">
										<i class="icon-calendar bigger-110"></i>
									</span>
								</div>
							</div>
						</div>
						<div class="form-group">
							<label class="col-xs-12 col-sm-1 control-label no-padding-right" for="form-field-1">入职日期</label>
							<div class="col-xs-12 col-sm-10">
								<div class="input-group">
									<input class="form-control date-picker" name="entryDate" id="id-date-picker-1" type="text" data-date-format="yyyy-mm-dd" style="width: 210px;" value="<fmt:formatDate value="${tusers.entryDate}" pattern="yyyy-MM-dd"/>"/>
									<span class="input-group-addon" style="width: 40px;">
										<i class="icon-calendar bigger-110"></i>
									</span>
								</div>
							</div>
						</div>
						<div class="form-group">
							<label class="col-xs-12 col-sm-1 control-label no-padding-right" for="form-field-1">身份证信息</label>
							<div class="col-xs-12 col-sm-10">
								<div class="clearfix">
									<input type="text" name="idcardno" class="col-xs-10 col-sm-5" value="${tusers.idcardno}"/>
								</div>
							</div>
						</div>
						<div class="form-group">
							<label class="col-xs-12 col-sm-1 control-label no-padding-right" for="form-field-1">性别</label>
							<div class="col-xs-12 col-sm-10">
								<div class="clearfix">
									<select name="sex">
										<option value="0" <c:if test="${tusers.sex eq '0'}"> selected="selected"</c:if>>男</option>
										<option value="1" <c:if test="${tusers.sex eq '1'}"> selected="selected"</c:if>>女</option>
									</select>
								</div>
							</div>
						</div>
						<div class="form-group">
							<label class="col-xs-12 col-sm-1 control-label no-padding-right" for="form-field-1">办公电话</label>
							<div class="col-xs-12 col-sm-10">
								<div class="clearfix">
									<input type="text" name="workphone" class="col-xs-10 col-sm-5" value="${tusers.workphone}"/>
								</div>
							</div>
						</div>
						<div class="form-group">
							<label class="col-xs-12 col-sm-1 control-label no-padding-right" for="form-field-1">邮箱</label>
							<div class="col-xs-12 col-sm-10">
								<div class="clearfix">
									<input type="text" name="email" class="col-xs-10 col-sm-5" value="${tusers.email}"/>
								</div>
							</div>
						</div>
						<div class="form-group">
							<label class="col-xs-12 col-sm-1 control-label no-padding-right" for="form-field-1">手机号码</label>
							<div class="col-xs-12 col-sm-10">
								<div class="clearfix">
									<input type="text" name="mobile" class="col-xs-10 col-sm-5" value="${tusers.mobile}"/>
								</div>
							</div>
						</div>
						<div class="form-group">
							<label class="col-xs-12 col-sm-1 control-label no-padding-right" for="form-field-1">备注</label>
							<div class="col-xs-12 col-sm-10">
								<div class="clearfix">
									<textarea name="remark" style="width: 385px;height: 100px;" placeholder="最多输入500个字符">${tusers.remark}</textarea>
								</div>
							</div>
						</div>
						<div class="form-group">
							<label class="col-xs-12 col-sm-1 control-label no-padding-right" for="form-field-1">详细地址</label>
							<div class="col-xs-12 col-sm-10">
								<div class="clearfix">
									<input type="text" name="address" class="col-xs-10 col-sm-5" value="${tusers.address}"/>
								</div>
							</div>
						</div>
						<div class="form-group">
							<label class="col-xs-12 col-sm-1 control-label no-padding-right" for="form-field-1">QQ</label>
							<div class="col-xs-12 col-sm-10">
								<div class="clearfix">
									<input type="text" name="qq" class="col-xs-10 col-sm-5" value="${tusers.qq}"/>
								</div>
							</div>
						</div>
						<div class="form-group">
							<label class="col-xs-12 col-sm-1 control-label no-padding-right" for="form-field-1">状态</label>
							<div class="col-xs-12 col-sm-10">
								<div class="clearfix">
									<select name="state">
										<option value="1">启用</option>
										<option value="0" <c:if test="${tusers.state==0}">selected</c:if>>停用</option>
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
			$("#parent_2").addClass("active open");
			$("#sub_21").addClass("active");
		}
	</script>
	<script>
		$(document).ready(function(){
	 		
			// 手机号码验证
			jQuery.validator.addMethod("isMobile", function(value, element) {
			    var length = value.length;
			    var mobile = /^(13[0-9]{9})|(18[0-9]{9})|(14[0-9]{9})|(17[0-9]{9})|(15[0-9]{9})$/;
			    return this.optional(element) || (length == 11 && mobile.test(value));
			}, "请正确填写您的手机号码");
	 		
			$("#loginName").focus();
			$("#userForm").validate({
				errorElement: 'div',
				errorClass: 'help-block',
				 rules: { 
				 	loginName: 
				 	{ 
				 		required: true, 
	        			minlength:4,
	        			maxlength:12,
	        			remote: "usersAction!checkName.action?orgName=''&math="+Math.random(),
	        			isLoginName: true
				 	},
					name: { 
	        			required: true, 
	        			maxlength:12
	    			},
	    			password: {
	    				required: true, 
	        			minlength:6,
	        			maxlength:16
	    			},
	    			repassword: {
	    				required: true, 
	        			minlength:6,
	        			maxlength:16,
	        			equalTo:"#password"
	    			},
	    			checkmenu: {
	    				required: true
	    			},
	    			birthday: {
	    				required: true,
	    				
	    			},
	    			entryDate:{
	    				required: true,
	    			},
	    			idcardno :{
	    				required: true,
	    				maxlength:18,
	    			},
	    			sex:{
	    				required: true,
	    			},
	    			workphone:{
	    				required: true,
	    				number:true
	    			},
	    			email:{
	    				required: true,
	    				email:true
	    			},
	    			mobile:{
	    				required: true,
	    				isMobile:true
	    			},
	    			remark:{
	    				maxlength: 500,
	    			},
	    			address:{
	    				required: true,
	    				maxlength: 100
	    			},
	    			qq:{
	    				required: true,
	    				maxlength: 11
	    			},
	    			positionId:{
	    				required: true,
	    			}
	    			
	    			
				},
				messages: {
					loginName: {
						required: "登录名称不能为空",
						remote: '该登录名称已被占用',
						minlength: '登录名称长度最少4位',
						maxlength: '登录名称长度最多12位'
					},
					name: {
						required: "真实名字不能为空",
						maxlength: '真实名字长度最多12位'
					},
					password: {
						required: "密码不能为空",
						minlength: '密码长度最少6位',
						maxlength: '密码长度最多16位'
					},
					repassword: {
						required: "重复密码不能为空",
						minlength: '重复密码长度最少6位',
						maxlength: '重复密码长度最多16位',
						equalTo:'密码不一致'
					},
					checkmenu: {
						required: "所属角色不能为空"
					},
					birthday: {
	    				required: "不能为空",
	    				
	    			},
	    			entryDate:{
	    				required: "不能为空",
	    			},
	    			idcardno :{
	    				required: "不能为空",
	    				maxlength:"字符长度不能超过18",
	    			},
	    			sex:{
	    				required:"不能为空",
	    			},
	    			workphone:{
	    				required: "不能为空",
	    				number:"请输入数字"
	    			},
	    			email:{
	    				required:"不能为空",
	    				email:"请输入正确的邮箱"
	    			},
	    			mobile:{
	    				required: "不能为空",
	    				isMobile:"请输入正确的手机号码"
	    			},
	    			remark:{
	    				maxlength:"字符长度不能超过500",
	    			},
	    			address:{
	    				required: "不能为空",
	    				maxlength: "字符长度不能超过100",
	    			},
	    			qq:{
	    				required: "不能为空",
	    				maxlength:"字符长度不能超过11",
	    			},
	    			positionId:{
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

