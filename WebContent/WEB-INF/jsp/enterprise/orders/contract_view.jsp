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
					<a href="#">合同订单</a>
				</li>
				<li class="active">合同管理</li>
			</ul>
		</div><!-- .breadcrumb -->
		
	<div class="page-content">
			<div>
				<h3 class="row-fluid header smaller  blue" style="line-height: 39px;">
					<span class="span7">合同信息 </span><!-- /span -->

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
							<div class="profile-info-name">合同名称</div>
							<div class="profile-info-value">
								${contract.name }
							</div>
						</div>
						<div class="profile-info-row">
							<div class="profile-info-name">合同编号</div>
							<div class="profile-info-value">
								${contract.num }
							</div>
						</div>
						<div class="profile-info-row">
							<div class="profile-info-name">客户</div>
							<div class="profile-info-value">
								${contract.consumerId.name }
							</div>
						</div>
						<div class="profile-info-row">
							<div class="profile-info-name">商机</div>
							<div class="profile-info-value">
								${contract.businessId.name }
							</div>
						</div>
						<div class="profile-info-row">
							<div class="profile-info-name">签约日期</div>
							<div class="profile-info-value">
								<fmt:formatDate value="${contract.contractDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
							</div>
						</div>
						<div class="profile-info-row">
							<div class="profile-info-name">总价</div>
							<div class="profile-info-value">
								${contract.price }
							</div>
						</div>
						<div class="profile-info-row">
							<div class="profile-info-name">合同内容</div>
							<div class="profile-info-value">
								${contract.content }
							</div>
						</div>
						<div class="profile-info-row">
							<div class="profile-info-name">描述</div>
							<div class="profile-info-value">
								${contract.description }
							</div>
						</div>
						<div class="profile-info-row">
							<div class="profile-info-name">备注</div>
							<div class="profile-info-value">
								${contract.remark }
							</div>
						</div>
						<div class="profile-info-row">
							<div class="profile-info-name">状态</div>
							<div class="profile-info-value">
								<c:choose>
									<c:when test="${contract.status eq '0'}">无效</c:when>
									<c:when test="${contract.status eq '1'}">可撤销</c:when>
									<c:when test="${contract.status eq '2'}">待定</c:when>
								</c:choose>
							</div>
						</div>
						
						<div class="profile-info-row">
							<div class="profile-info-name">添加时间</div>
							<div class="profile-info-value">
								<fmt:formatDate value="${contract.addTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
							</div>
						</div>
						<div class="profile-info-row">
							<div class="profile-info-name">跟进人</div>
							<div class="profile-info-value">
								${contract.userId.name }
							</div>
						</div>
						<div class="profile-info-row">
							<div class="profile-info-name">是否删除 </div>
							<div class="profile-info-value">
								<c:choose>
									<c:when test="${contract.isDel eq '0'}">否</c:when>
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
			$("#parent_4").addClass("active open");
			$("#sub_41").addClass("active");
		}
	</script>
	</body>
</html>