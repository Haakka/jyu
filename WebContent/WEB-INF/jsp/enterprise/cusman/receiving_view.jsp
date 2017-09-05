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
					<a href="#">财务管理</a>
				</li>
				<li class="active">收款管理</li>
			</ul>
		</div><!-- .breadcrumb -->
		
	<div class="page-content">
			<div>
				<h3 class="row-fluid header smaller  blue" style="line-height: 39px;">
					<span class="span7">收款信息 </span><!-- /span -->

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
							<div class="profile-info-name">收款金额</div>
							<div class="profile-info-value">
								${receiving.money }
							</div>
						</div>
						<div class="profile-info-row">
							<div class="profile-info-name">收款时间</div>
							<div class="profile-info-value">
								<fmt:formatDate value="${receiving.payTime}" pattern="yyyy-MM-dd"/>
							</div>
						</div>
						<div class="profile-info-row">
							<div class="profile-info-name">订单</div>
							<div class="profile-info-value">
								${receiving.orderId.orderSn }
							</div>
						</div>
						<div class="profile-info-row">
							<div class="profile-info-name">备注</div>
							<div class="profile-info-value">
								${receiving.remark }
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
			$("#parent_5").addClass("active open");
			$("#sub_52").addClass("active");
		}
	</script>
	</body>
</html>