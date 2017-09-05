<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<%@ include file="/common/meta.jsp"%>
		<title>MCCMS</title>
		<link href="${ctx}/js/validate/jquery.validate.css" type="text/css"
			rel="stylesheet" />
		<script src="${ctx}/js/validate/jquery.validate.js"
			type="text/javascript"></script>
		<script src="${ctx}/js/validate/messages_cn.js" type="text/javascript"></script>
		<link href="${ctx}/image/login5/style.css" rel="stylesheet"
			type="text/css" />
		<script type="text/javascript">
  			$(document).ready(function(){
				$("#loginForm").validate({
					 rules: { 
					 	j_username:
						{
							required: true,
							minlength: 4,
							maxlength: 32
						},
						j_password:
						{
							required: true,
							minlength: 4,
							maxlength: 64
						},
					 	vercode: 
					 	{ 
					 		required: true, 
		        			remote: "checkCodeAction!checkCode.action?math="+Math.random()
					 	}
					 },
					 messages: {
					 	j_username:{
					 		minlength: '<s:text name="login.validate.name.minlength" />',
					 		maxlength: '<s:text name="login.validate.name.maxlength" />'
					 	},
					 	j_password:{
					 		minlength: '<s:text name="login.validate.password.minlength" />',
					 		maxlength: '<s:text name="login.validate.password.minlength" />'
					 	},
					 	vercode: {
							remote: '<s:text name="login.validate.check" />'
						}
					 },
					 success: function(label) {
						label.html("&nbsp;").addClass("checked");
			         }
				});
				
				$("#AuthImg").click(function(){
					var timenow = new Date().getTime();
  					this.src="${ctx}/AuthImg?d="+timenow;
				});
				
 			});
  		</script>
	</head>
	<body>
		<center>
			<div id="body2">
				<div id="content">
					<div id="login_error">
						<%
							if (session.getAttribute(AbstractProcessingFilter.SPRING_SECURITY_LAST_EXCEPTION_KEY) != null) {
						%>
						<span style="color: red; font-size: 12px;">${sessionScope['SPRING_SECURITY_LAST_EXCEPTION'].message}</span>
						<%
							}
						%>
					</div>

					<form id="loginForm" name="loginForm"
						action="${ctx}/j_spring_security_check" method="post">

						<!--用户名(帐号)-->
						<div id="username">
							<s:text name="login.name" />
							<input value="" type="text" name="j_username" id="j_username"
								maxlength="20" />
						</div>

						<!--密码-->
						<div id="password">
							<s:text name="login.password" />
							<input value="" type="password" name="j_password" id="j_password"
								maxlength="20" />
						</div>

						<!--验证码-->
						<div id="checkCode">
							<s:text name="login.check" />
							<input type="text" name="vercode" id="vercode" />
							<img id="AuthImg" name="AuthImg" src="${ctx}/AuthImg"
								alt='<s:text name="login.check.change" />' />
						</div>

						<!--登陆按钮-->
						<div id="loginButton">
							<input type="submit"
								value='<s:text name="login.button.submit" />' />
						</div>

						<!--重置按钮-->
						<div id="resetButton">
							<input type="reset" value='<s:text name="login.button.reset" />' />
						</div>
						<div id="copyright">
							<s:text name="login.copyright" />
						</div>
					</form>
				</div>
			</div>
		</center>
	</body>
</html>
