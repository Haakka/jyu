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
					<span class="span7">用户信息 </span><!-- /span -->

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
					<div class="profile-user-info profile-user-info-striped">
						<div class="profile-info-row">
							<div class="profile-info-name">登录名称 </div>
							<div class="profile-info-value">
								${tusers.loginName}
							</div>
						</div>
						<div class="profile-info-row">
							<div class="profile-info-name">密码 </div>
							<div class="profile-info-value">
								*********
							</div>
						</div>
						<div class="profile-info-row">
							<div class="profile-info-name">真实名字 </div>
							<div class="profile-info-value">
								${tusers.name}
							</div>
						</div>
						<div class="profile-info-row">
							<div class="profile-info-name">性别 </div>
							<div class="profile-info-value">
								<c:choose>
									<c:when test="${tusers.sex eq '0'}">男</c:when>
									<c:when test="${tusers.sex eq '1'}">女</c:when>
								</c:choose>
							</div>
						</div>
						<div class="profile-info-row">
							<div class="profile-info-name">身份证 </div>
							<div class="profile-info-value">
								${tusers.idcardno}
							</div>
						</div>
						<div class="profile-info-row">
							<div class="profile-info-name">生日</div>
							<div class="profile-info-value">
								<fmt:formatDate value="${tusers.birthday}" pattern="yyyy-MM-dd"/>
							</div>
						</div>
						<div class="profile-info-row">
							<div class="profile-info-name">入职日期</div>
							<div class="profile-info-value">
								<fmt:formatDate value="${tusers.entryDate}" pattern="yyyy-MM-dd"/>
							</div>
						</div>
						<div class="profile-info-row">
							<div class="profile-info-name">详细地址 </div>
							<div class="profile-info-value">
								${tusers.address}
							</div>
						</div>
						<div class="profile-info-row">
							<div class="profile-info-name">工作电话 </div>
							<div class="profile-info-value">
								${tusers.workphone}
							</div>
						</div>
						<div class="profile-info-row">
							<div class="profile-info-name">移动电话</div>
							<div class="profile-info-value">
								${tusers.mobile}
							</div>
						</div>
						<div class="profile-info-row">
							<div class="profile-info-name">联系QQ</div>
							<div class="profile-info-value">
								${tusers.qq}
							</div>
						</div>
						<div class="profile-info-row">
							<div class="profile-info-name">E-mail</div>
							<div class="profile-info-value">
								${tusers.email}
							</div>
						</div>
						<div class="profile-info-row">
							<div class="profile-info-name">岗位</div>
							<div class="profile-info-value">
								${tusers.positionId.name}
							</div>
						</div>
						<div class="profile-info-row">
							<div class="profile-info-name">角色 </div>
							<div class="profile-info-value">
								<c:forEach var="usersRolesList" items="${usersRolesList}">
									${usersRolesList.roles.name}&nbsp;&nbsp;
								</c:forEach>
							</div>
						</div>
						<div class="profile-info-row">
							<div class="profile-info-name">状态 </div>
							<div class="profile-info-value">
								<c:if test="${tusers.state == 1}">启用 </c:if>
								<c:if test="${tusers.state == 0}"><font color="red">停用</font></c:if>
							</div>
						</div>
					</div>
					<!-- PAGE CONTENT ENDS -->
				</div><!-- /.col -->
			</div><!-- /.row -->
		</div><!-- /.page-content -->
		
		
		<%@ include file="/common/copyright.jsp"%>
	</div><!-- /.main-content -->

				

	<%@ include file="/common/bottom-import.jsp"%>
	<script type="text/javascript">
		jQuery(function($) {
			setCurrent();
		});
		
		function setCurrent(){
			$("#parent_2").addClass("active open");
			$("#sub_21").addClass("active");
		}
	</script>
	</body>
</html>

