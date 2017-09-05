<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html>
<html lang="zh-cn">
	<head>
		<meta charset="utf-8" />
		<title>客户关系管理系统</title>
		<meta name="keywords" content="" />
		<meta name="description" content="" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0" />
		<meta http-equiv="Cache-Control" content="no-store"/>
        <meta http-equiv="Pragma" content="no-cache"/>
        <meta http-equiv="Expires" content="0"/>
		<meta http-equiv="Page-Exit"; content="blendTrans(Duration=1.0)"/>
		<meta http-equiv="Page-Enter"; content="blendTrans(Duration=1.0)"/>
		
		<!-- 这里引入网站图标 -->
		<link rel="shortcut icon" href="${ctx}/image/favicon.ico" />
		<link rel="bookmark"href="${ctx}/image/favicon.ico" />

		<!-- basic styles -->

		<link href="${ctx}/js/assets/css/bootstrap.min.css" rel="stylesheet" />
		<link rel="stylesheet" href="${ctx}/js/assets/css/font-awesome.min.css" />

		<!--[if IE 7]>
		  <link rel="stylesheet" href="${ctx}/js/assets/css/font-awesome-ie7.min.css" />
		<![endif]-->

		<!-- ace styles -->

		<link rel="stylesheet" href="${ctx}/js/assets/css/ace.min.css" />
		<link rel="stylesheet" href="${ctx}/js/assets/css/ace-rtl.min.css" />

		<!--[if lte IE 8]>
		  <link rel="stylesheet" href="${ctx}/js/assets/css/ace-ie.min.css" />
		<![endif]-->

		<!-- inline styles related to this page -->

		<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->

		<!--[if lt IE 9]>
		<script src="${ctx}/js/assets/js/html5shiv.js"></script>
		<script src="${ctx}/js/assets/js/respond.min.js"></script>
		<![endif]-->
	</head>

	<body class="login-layout">
		<div class="main-container">
			<div class="main-content">
				<div class="row">
					<div class="col-sm-10 col-sm-offset-1" style="margin-top: 8%;">
						<div class="login-container">
							<div class="center">
								<h1>
									<i class="icon-leaf green"></i>
									<span class="white">JYU客户关系管理系统</span>
								</h1>
								<h4 class="blue">&copy; 嘉应学院计算机学院</h4>
							</div>

							<div class="space-6"></div>

							<div class="position-relative">
								<div id="login-box" class="login-box visible widget-box no-border">
									<div class="widget-body">
										<div class="widget-main">
											<h4 class="header blue lighter bigger">
												<i class="icon-coffee green"></i>
												账号信息
											</h4>

											<div class="space-6"></div>
											<div id="login_error">
												<%
													if (session.getAttribute(AbstractProcessingFilter.SPRING_SECURITY_LAST_EXCEPTION_KEY) != null) {
												%>
												<span style="color: red; font-size: 12px;">${sessionScope['SPRING_SECURITY_LAST_EXCEPTION'].message}</span>
												<%
													}
												%>
											</div>

											<form id="loginForm" name="loginForm" action="${ctx}/j_spring_security_check" method="post">
												<fieldset>
													<label class="block clearfix form-group">
														<span class="block input-icon input-icon-right">
															<input type="text" class="form-control" name="j_username" id="j_username" maxlength="20" placeholder="用户名" />
															<i class="icon-user"></i>
														</span>
													</label>

													<label class="block clearfix form-group">
														<span class="block input-icon input-icon-right">
															<input type="password" class="form-control" name="j_password" id="j_password" maxlength="20" placeholder="密码"  />
															<i class="icon-lock"></i>
														</span>
													</label>

													<div class="space"></div>

													<div class="clearfix">
														<button id="lobingBtn" class="width-35 pull-right btn btn-sm btn-primary" data-last="Finish">
															<i class="icon-key"></i>
															登录
														</button>
													</div>

													<div class="space-4"></div>
												</fieldset>
											</form>

										</div><!-- /widget-main -->

									</div><!-- /widget-body -->
								</div><!-- /login-box -->
							</div><!-- /position-relative -->
						</div>
					</div><!-- /.col -->
				</div><!-- /.row -->
			</div>
		</div><!-- /.main-container -->

		<!-- basic scripts -->

	<script src='${ctx}/js/assets/js/jquery-2.0.3.min.js'>

	<script type="text/javascript">
		if("ontouchend" in document) document.write("<script src='${ctx}/js/assets/js/jquery.mobile.custom.min.js'>"+"<"+"/script>");
	</script>
	<script src="${ctx}/js/assets/js/bootstrap.min.js"></script>
	<script src="${ctx}/js/assets/js/typeahead-bs2.min.js"></script>

	<!-- page specific plugin scripts -->
	<script src="${ctx}/js/assets/js/fuelux/fuelux.wizard.min.js"></script>
	<script src="${ctx}/js/assets/js/jquery.validate.min.js"></script>

	<!-- ace scripts -->

	<script src="${ctx}/js/assets/js/ace-elements.min.js"></script>
	<script src="${ctx}/js/assets/js/ace.min.js"></script>
	
	<script type="text/javascript">
		jQuery(function($) {
			$('#loginForm').validate({
				errorElement: 'div',
				errorClass: 'help-block',
				focusInvalid: false,
				rules: {
					j_username: {
						required: true,
						minlength: 4,
						maxlength: 32
					},
					j_password: {
						required: true,
						minlength: 4,
						maxlength: 64
					}
				},
		
				messages: {
					j_username: {
						required: "请输入用户名.",
						minlength: "用户名长度最少4位",
				 		maxlength: "用户名长度最多32位"
					},
					j_password: {
						required: "请输入密码",
						minlength: "密码长度最少4位",
				 		maxlength: "密码长度最多64位"
					}
				},
		
				invalidHandler: function (event, validator) { //display error alert on form submit   
					$('.alert-danger', $('.login-form')).show();
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
		
				submitHandler: function (form) {
					$("#lobingBtn").html('<i class="icon-spinner icon-spin"></i>登录中');
					form.submit();
				},
				invalidHandler: function (form) {
				}
			});
		});
	</script>
</body>
</html>
