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
					<a href="#">客户管理</a>
				</li>
				<li class="active">联系人管理</li>
			</ul>
		</div><!-- .breadcrumb -->
		
	<div class="page-content">
			<div>
				<h3 class="row-fluid header smaller  blue" style="line-height: 39px;">
					<span class="span7">联系人信息 </span><!-- /span -->

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
							<div class="profile-info-name">姓名</div>
							<div class="profile-info-value">
								${contact.name }
							</div>
						</div>
						<div class="profile-info-row">
							<div class="profile-info-name">手机号码</div>
							<div class="profile-info-value">
								${contact.phone }
							</div>
						</div>
						<div class="profile-info-row">
							<div class="profile-info-name">性别</div>
							<div class="profile-info-value">
								<c:choose>
									<c:when test="${contact.sex eq '0'}">男</c:when>
									<c:otherwise>女</c:otherwise>
								</c:choose>
							</div>
						</div>
						<div class="profile-info-row">
							<div class="profile-info-name">称呼</div>
							<div class="profile-info-value">
								${contact.displayName }
							</div>
						</div>
						<div class="profile-info-row">
							<div class="profile-info-name">邮箱</div>
							<div class="profile-info-value">
								${contact.email }
							</div>
						</div>
						<div class="profile-info-row">
							<div class="profile-info-name">QQ</div>
							<div class="profile-info-value">
								${contact.qq }
							</div>
						</div>
						<div class="profile-info-row">
							<div class="profile-info-name">所属客户</div>
							<div class="profile-info-value">
								${contact.consumerId.name }
							</div>
						</div>
						<div class="profile-info-row">
							<div class="profile-info-name">所属部门</div>
							<div class="profile-info-value">
								${contact.department}
							</div>
						</div>
						<div class="profile-info-row">
							<div class="profile-info-name">所属岗位</div>
							<div class="profile-info-value">
								${contact.position}
							</div>
						</div>
						<div class="profile-info-row">
							<div class="profile-info-name">地址</div>
							<div class="profile-info-value">
								${contact.address }
							</div>
						</div>
						<div class="profile-info-row">
							<div class="profile-info-name">邮编</div>
							<div class="profile-info-value">
								${contact.postCode }
							</div>
						</div>
						<div class="profile-info-row">
							<div class="profile-info-name">备注</div>
							<div class="profile-info-value">
								${contact.remark }
							</div>
						</div>
						<div class="profile-info-row">
							<div class="profile-info-name">添加时间</div>
							<div class="profile-info-value">
								<fmt:formatDate value="${contact.addTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
							</div>
						</div>
						<div class="profile-info-row">
							<div class="profile-info-name">更新时间</div>
							<div class="profile-info-value">
								<fmt:formatDate value="${contact.updateTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
							</div>
						</div>
						<div class="profile-info-row">
							<div class="profile-info-name">创建人</div>
							<div class="profile-info-value">
								${contact.userId.name }
							</div>
						</div>
						<div class="profile-info-row">
							<div class="profile-info-name">是否删除 </div>
							<div class="profile-info-value">
								<c:choose>
									<c:when test="${contact.isDel eq '0'}">否</c:when>
									<c:otherwise><font color="red">是</font></c:otherwise>
								</c:choose>
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