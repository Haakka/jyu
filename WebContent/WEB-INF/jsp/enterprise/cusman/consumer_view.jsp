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
					<a href="#">客户列表</a>
				</li>
				<li class="active">查看信息</li>
			</ul>
		</div><!-- .breadcrumb -->
		
	<div class="page-content">
			<div>
				<h3 class="row-fluid header smaller  blue" style="line-height: 39px;">
					<span class="span7">客户信息 </span><!-- /span -->

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
							<div class="profile-info-name">客户名称 </div>
							<div class="profile-info-value">
								${consumer.name }
							</div>
						</div>
						<div class="profile-info-row">
							<div class="profile-info-name">联系方式</div>
							<div class="profile-info-value">
								${consumer.phone }
							</div>
						</div>
						<div class="profile-info-row">
							<div class="profile-info-name">详细地址</div>
							<div class="profile-info-value">
								${consumer.address }
							</div>
						</div>
						<div class="profile-info-row">
							<div class="profile-info-name">客户描述</div>
							<div class="profile-info-value">
								${consumer.description }
							</div>
						</div>
						<div class="profile-info-row">
							<div class="profile-info-name">客户行业</div>
							<div class="profile-info-value">
								${consumer.industryId.name }
							</div>
						</div>
						<div class="profile-info-row">
							<div class="profile-info-name">客户类型</div>
							<div class="profile-info-value">
								${consumer.typeId.name }
							</div>
						</div>
						<div class="profile-info-row">
							<div class="profile-info-name">客户等级</div>
							<div class="profile-info-value">
								${consumer.levelId.name }
							</div>
						</div>
						<div class="profile-info-row">
							<div class="profile-info-name">客户备注</div>
							<div class="profile-info-value">
								${consumer.remark }
							</div>
						</div>
						<div class="profile-info-row">
							<div class="profile-info-name">传真号码</div>
							<div class="profile-info-value">
								${consumer.fax }
							</div>
						</div>
						<div class="profile-info-row">
							<div class="profile-info-name">邮编</div>
							<div class="profile-info-value">
								${consumer.postCode}
							</div>
						</div>
						<div class="profile-info-row">
							<div class="profile-info-name">营业额</div>
							<div class="profile-info-value">
								<c:choose>
									<c:when test="${empty consumer.revenue}">0.00</c:when>
									<c:otherwise>${consumer.revenue}</c:otherwise>
								</c:choose>
							</div>
						</div>
						<div class="profile-info-row">
							<div class="profile-info-name">添加时间</div>
							<div class="profile-info-value">
								<fmt:formatDate value="${consumer.addTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
							</div>
						</div>
						<div class="profile-info-row">
							<div class="profile-info-name">编辑时间 </div>
							<div class="profile-info-value">
								<fmt:formatDate value="${consumer.updateTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
							</div>
						</div>
						<div class="profile-info-row">
							<div class="profile-info-name">创建人</div>
							<div class="profile-info-value">
								${consumer.userId.name }
							</div>
						</div>
						<div class="profile-info-row">
							<div class="profile-info-name">是否删除 </div>
							<div class="profile-info-value">
								<c:if test="${consumer.isDel eq '0'}">否</c:if>
								<c:if test="${consumer.isDel eq '1'}"><font color="red">是</font></c:if>
							</div>
						</div>
						<div class="profile-info-row">
							<div class="profile-info-name">是否锁定</div>
							<div class="profile-info-value">
								<c:if test="${consumer.isLock eq '0'}">否</c:if>
								<c:if test="${consumer.isLock eq '1'}"><font color="red">是</font></c:if>
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