<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

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
	
		<!-- CSS -->
		<link rel="stylesheet" href="${ctx}/js/assets/css/bootstrap.min.css" />
		<link rel="stylesheet" href="${ctx}/js/assets/css/bootstrap-datetimepicker.min.css" />
		<link rel="stylesheet" href="${ctx}/js/assets/css/datepicker.css" />
		<link rel="stylesheet" href="${ctx}/js/assets/css/mystyle.css" />
		<link rel="stylesheet" href="${ctx}/js/assets/css/chosen.css" />
		<link rel="stylesheet" href="${ctx}/js/assets/css/font-awesome.min.css" />
		<link rel="stylesheet" href="${ctx}/js/assets/css/inbox.css" />
		<link rel="stylesheet" href="${ctx}/js/assets/css/ace.min.css" />
		<link rel="stylesheet" href="${ctx}/js/assets/css/ace-rtl.min.css" />
		<link rel="stylesheet" href="${ctx}/js/assets/css/ace-skins.min.css" />
		<link rel="stylesheet" href="${ctx}/js/assets/css/select2.css" />
	
		<!-- 公共类 -->
		<script src='${ctx}/js/assets/js/jquery-2.0.3.min.js' type="text/javascript" ></script>
		<script src="${ctx}/js/utils/common.js" type="text/javascript"></script>
		<script src="${ctx}/js/utils/bootbox.js" type="text/javascript"></script>
		<script src="${ctx}/js/utils/jsUtils.js" type="text/javascript"></script>
		<script src="${ctx}/js/assets/js/chosen.jquery.min.js" type="text/javascript"></script>
		<script src="${ctx}/js/assets/js/bootstrap-tag.min.js" type="text/javascript"></script>
		<script src="${ctx}/js/utils/jquery.cityselect.js" type="text/javascript"></script>
		<script src="${ctx}/js/assets/js/select2.min.js" type="text/javascript" ></script>
		<script src="${ctx}/js/assets/js/ace-extra.min.js" type="text/javascript" ></script>
	
		
		<style type="text/css">
			.btx{color: red}
			.order-form{padding:0 15px;}
			.order-form-box{width:100%;border:1px solid #f2f2fa;padding:10px 10px 0 10px;}
			.order-form-items{border:1px solid #ccc;display:inline-block;font-size:0;margin-right:2px;margin-bottom:10px;}
			.order-form-items label{background-color:#eee;color:#000;border-right:1px solid #ccc;font-size:14px;padding:5px 10px;margin:0;vertical-align: top;}
			.order-form-items .order-input{width:140px;padding:5px;font-size:14px;border:none;outline:none;line-height:1.5;}
			.order-form-items .order-select{width:90px;}
		</style>
	</head>
	
	<body>
		<div class="navbar navbar-default" id="navbar">
			<script type="text/javascript">
				try{ace.settings.check('navbar' , 'fixed')}catch(e){}
			</script>

			<div class="navbar-container" id="navbar-container">
				<div class="pull-left" style="margin-top: 10px;">
					<i class="icon-leaf white bigger-200"></i>
				</div>
				<div class="navbar-header pull-left">
					<a href="#" class="navbar-brand">
						<small>
							JYU客户关系管理系统
						</small>
					</a><!-- /.brand -->
				</div><!-- /.navbar-header -->

				<div class="navbar-header pull-right" role="navigation">
					<ul class="nav ace-nav">
						<!-- <li class="green">
							<a data-toggle="dropdown" class="dropdown-toggle" href="#">
								<i class="icon-envelope icon-animated-vertical"></i>
								<span class="badge badge-success">5</span>
							</a>
						</li>
						
						<li class="purple">
							<a data-toggle="dropdown" class="dropdown-toggle" href="#">
								<i class="icon-bell-alt icon-animated-bell"></i>
								<span class="badge badge-important">8</span>
							</a>
						</li> -->

						<li class="light-blue">
							<a data-toggle="dropdown" href="#" class="dropdown-toggle">
								<img class="nav-user-photo" src="${ctx}/js/assets/avatars/avatar2.png" alt="Jason's Photo" />
								<span class="user-info">
									<small>你好</small>
									${currentUserName}
								</span>

								<i class="icon-caret-down"></i>
							</a>

							<ul class="user-menu pull-right dropdown-menu dropdown-yellow dropdown-caret dropdown-close">
								<li>
									<a href="${ctx}/basic/updatePasswordAction.action">
										<i class="icon-cog"></i>
										修改密码
									</a>
								</li>

								<li class="divider"></li>

								<li>
									<a href="${ctx}/j_spring_security_logout">
										<i class="icon-off"></i>
										退出
									</a>
								</li>
							</ul>
						</li>
					</ul><!-- /.ace-nav -->
				</div><!-- /.navbar-header -->
			</div><!-- /.container -->
		</div>

		<div class="main-container" id="main-container">
			<script type="text/javascript">
				try{ace.settings.check('main-container' , 'fixed')}catch(e){}
			</script>

			<div class="main-container-inner">
				<a class="menu-toggler" id="menu-toggler" href="#">
					<span class="menu-text"></span>
				</a>

				<div class="sidebar" id="sidebar">
					<script type="text/javascript">
						try{ace.settings.check('sidebar' , 'fixed')}catch(e){}
					</script>

					
					<%@ include file="/common/navigation.jsp"%>
					<!-- /.nav-list -->

					<div class="sidebar-collapse" id="sidebar-collapse">
						<i class="icon-double-angle-left" data-icon1="icon-double-angle-left" data-icon2="icon-double-angle-right"></i>
					</div>

					<script type="text/javascript">
						try{ace.settings.check('sidebar' , 'collapsed')}catch(e){}
					</script>
				</div>