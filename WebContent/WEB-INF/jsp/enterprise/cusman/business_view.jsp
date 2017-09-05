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
				<li class="active">商机线索</li>
			</ul>
		</div><!-- .breadcrumb -->
		
	<div class="page-content">
			<div>
				<h3 class="row-fluid header smaller  blue" style="line-height: 39px;">
					<span class="span7">查看商机线索</span><!-- /span -->

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
							<div class="profile-info-name">名称</div>
							<div class="profile-info-value">
								${business.name }
							</div>
						</div>
						<div class="profile-info-row">
							<div class="profile-info-name">商机来源</div>
							<div class="profile-info-value">
								${business.originId.name }
							</div>
						</div>
						<div class="profile-info-row">
							<div class="profile-info-name">商机类型</div>
							<div class="profile-info-value">
								${business.typeId.name }
							</div>
						</div>
						<div class="profile-info-row">
							<div class="profile-info-name">商机价值</div>
							<div class="profile-info-value">
								${business.valueId.name }
							</div>
						</div>
						<div class="profile-info-row">
							<div class="profile-info-name">赢单率</div>
							<div class="profile-info-value">
								${business.rate }
							</div>
						</div>
						<div class="profile-info-row">
							<div class="profile-info-name">备注</div>
							<div class="profile-info-value">
								${business.remark }
							</div>
						</div>
						<div class="profile-info-row">
							<div class="profile-info-name">状态</div>
							<div class="profile-info-value">
								<c:choose>
									<c:when test="${business.status eq '0'}">初次接洽</c:when>
									<c:when test="${business.status eq '1'}">已报价</c:when>
									<c:when test="${business.status eq '2'}">价格谈判</c:when>
									<c:when test="${business.status eq '3'}">赢单</c:when>
									<c:when test="${business.status eq '4'}">输单</c:when>
								</c:choose>
							</div>
						</div>
						<div class="profile-info-row">
							<div class="profile-info-name">客户</div>
							<div class="profile-info-value">
								${business.consumer.name }
							</div>
						</div>
						<div class="profile-info-row">
							<div class="profile-info-name">联系人</div>
							<div class="profile-info-value">
								${business.contactor.name }
							</div>
						</div>
						
						<div class="profile-info-row">
							<div class="profile-info-name">添加时间</div>
							<div class="profile-info-value">
								<fmt:formatDate value="${business.addTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
							</div>
						</div>
						
						<div class="profile-info-row">
							<div class="profile-info-name">创建人</div>
							<div class="profile-info-value">
								${business.userId.name }
							</div>
						</div>
						<div class="profile-info-row">
							<div class="profile-info-name">是否删除 </div>
							<div class="profile-info-value">
								<c:if test="${business.isDel eq '0'}">否</c:if>
								<c:if test="${business.isDel eq '1'}"><font color="red">是</font></c:if>
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
			$("#sub_33").addClass("active");
		}
	</script>
	</body>
</html>