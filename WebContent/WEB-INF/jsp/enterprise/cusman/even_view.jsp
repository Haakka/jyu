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
				<li class="active">交往记录</li>
			</ul>
		</div><!-- .breadcrumb -->
		
	<div class="page-content">
			<div>
				<h3 class="row-fluid header smaller  blue" style="line-height: 39px;">
					<span class="span7">交往记录信息 </span><!-- /span -->

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
							<div class="profile-info-name">主题</div>
							<div class="profile-info-value">
								${even.subject }
							</div>
						</div>
						<div class="profile-info-row">
							<div class="profile-info-name">客户</div>
							<div class="profile-info-value">
								${even.consumer.name }
							</div>
						</div>
						<div class="profile-info-row">
							<div class="profile-info-name">联系人</div>
							<div class="profile-info-value">
								${even.contactor.name }
							</div>
						</div>
						<div class="profile-info-row">
							<div class="profile-info-name">活动地点</div>
							<div class="profile-info-value">
								${even.venue }
							</div>
						</div>
						<div class="profile-info-row">
							<div class="profile-info-name">开始时间</div>
							<div class="profile-info-value">
								<fmt:formatDate value="${even.startDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
							</div>
						</div>
						<div class="profile-info-row">
							<div class="profile-info-name">结束时间 </div>
							<div class="profile-info-value">
								<fmt:formatDate value="${even.endDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
							</div>
						</div>
						<div class="profile-info-row">
							<div class="profile-info-name">描述</div>
							<div class="profile-info-value">
								${even.description }
							</div>
						</div>
						<div class="profile-info-row">
							<div class="profile-info-name">创建时间</div>
							<div class="profile-info-value">
								<fmt:formatDate value="${even.addTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
							</div>
						</div>
						<div class="profile-info-row">
							<div class="profile-info-name">是否删除 </div>
							<div class="profile-info-value">
								<c:choose>
									<c:when test="${even.isDel eq '0'}">否</c:when>
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
			$("#sub_35").addClass("active");
		}
	</script>
	</body>
</html>