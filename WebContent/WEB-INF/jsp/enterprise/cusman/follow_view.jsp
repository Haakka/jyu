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
				<li class="active">我的跟进</li>
			</ul>
		</div><!-- .breadcrumb -->
		
	<div class="page-content">
			<div>
				<h3 class="row-fluid header smaller  blue" style="line-height: 39px;">
					<span class="span7">跟进信息 </span><!-- /span -->

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
							<div class="profile-info-name">客户</div>
							<div class="profile-info-value">
								${follow.consumerId.name }
							</div>
						</div>
						<div class="profile-info-row">
							<div class="profile-info-name">跟进方式</div>
							<div class="profile-info-value">
								${follow.type.name }
							</div>
						</div>
						<div class="profile-info-row">
							<div class="profile-info-name">跟进时间</div>
							<div class="profile-info-value">
								<fmt:formatDate value="${follow.followTime }" pattern="yyyy-MM-dd HH:mm:ss"/>
							</div>
						</div>
						<div class="profile-info-row">
							<div class="profile-info-name">跟进内容</div>
							<div class="profile-info-value">
								${follow.content }
							</div>
						</div>
						<div class="profile-info-row">
							<div class="profile-info-name">添加时间</div>
							<div class="profile-info-value">
								<fmt:formatDate value="${follow.addTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
							</div>
						</div>
						<div class="profile-info-row">
							<div class="profile-info-name">跟进人</div>
							<div class="profile-info-value">
								${follow.follower.name }
							</div>
						</div>
						<div class="profile-info-row">
							<div class="profile-info-name">是否删除 </div>
							<div class="profile-info-value">
								<c:choose>
									<c:when test="${follow.isDel eq '0'}">否</c:when>
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
			$("#parent_3").addClass("active open");
			$("#sub_34").addClass("active");
		}
	</script>
	</body>
</html>