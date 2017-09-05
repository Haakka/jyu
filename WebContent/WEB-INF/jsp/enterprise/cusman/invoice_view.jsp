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
				<li class="active">开票管理</li>
			</ul>
		</div><!-- .breadcrumb -->
		
	<div class="page-content">
			<div>
				<h3 class="row-fluid header smaller  blue" style="line-height: 39px;">
					<span class="span7">发票信息 </span><!-- /span -->

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
							<div class="profile-info-name">订单</div>
							<div class="profile-info-value">
								${invoice.orderId.orderSn }
							</div>
						</div>
						<div class="profile-info-row">
							<div class="profile-info-name">发票号码</div>
							<div class="profile-info-value">
								${invoice.num }
							</div>
						</div>
						<div class="profile-info-row">
							<div class="profile-info-name">发票代码</div>
							<div class="profile-info-value">
								${invoice.code }
							</div>
						</div>
						<div class="profile-info-row">
							<div class="profile-info-name">发票类型</div>
							<div class="profile-info-value">
								<c:choose>
									<c:when test="${invoice.type eq '0'}">普通发票</c:when>
									<c:otherwise>增值税发票</c:otherwise>
								</c:choose>
							</div>
						</div>
						<div class="profile-info-row">
							<div class="profile-info-name">发票金额</div>
							<div class="profile-info-value">
								${invoice.amount }
							</div>
						</div>
						<div class="profile-info-row">
							<div class="profile-info-name">开票日期</div>
							<div class="profile-info-value">
								<fmt:formatDate value="${invoice.startDate}" pattern="yyyy-MM-dd"/>
							</div>
						</div>
						<div class="profile-info-row">
							<div class="profile-info-name">付款方名称</div>
							<div class="profile-info-value">
								${invoice.payer }
							</div>
						</div>
						<div class="profile-info-row">
							<div class="profile-info-name">付款方地址</div>
							<div class="profile-info-value">
								${invoice.payerAddress }
							</div>
						</div>
						<div class="profile-info-row">
							<div class="profile-info-name">付款方电话</div>
							<div class="profile-info-value">
								${invoice.payerTel }
							</div>
						</div>
						<div class="profile-info-row">
							<div class="profile-info-name">付款方开户行</div>
							<div class="profile-info-value">
								${invoice.payerBank }
							</div>
						</div>
						<div class="profile-info-row">
							<div class="profile-info-name">付款方账号</div>
							<div class="profile-info-value">
								${invoice.payerAcount }
							</div>
						</div>
						<div class="profile-info-row">
							<div class="profile-info-name">收款方名称</div>
							<div class="profile-info-value">
								${invoice.receiver }
							</div>
						</div>
						<div class="profile-info-row">
							<div class="profile-info-name">收款方地址</div>
							<div class="profile-info-value">
								${invoice.receiverAdderss }
							</div>
						</div>
						<div class="profile-info-row">
							<div class="profile-info-name">收款方电话</div>
							<div class="profile-info-value">
								${invoice.receiverTel }
							</div>
						</div>
						<div class="profile-info-row">
							<div class="profile-info-name">收款方开户行</div>
							<div class="profile-info-value">
								${invoice.receiverBank }
							</div>
						</div>
						<div class="profile-info-row">
							<div class="profile-info-name">收款方账户</div>
							<div class="profile-info-value">
								${invoice.receiverAcount }
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