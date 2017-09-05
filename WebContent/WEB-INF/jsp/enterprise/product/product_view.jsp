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
					<a href="#">产品管理</a>
				</li>
				<li class="active">查看信息</li>
			</ul>
		</div><!-- .breadcrumb -->
		
	<div class="page-content">
			<div>
				<h3 class="row-fluid header smaller  blue" style="line-height: 39px;">
					<span class="span7">产品信息 </span><!-- /span -->

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
							<div class="profile-info-name">产品名称 </div>
							<div class="profile-info-value">
								${product.name }
							</div>
						</div>
						<div class="profile-info-row">
							<div class="profile-info-name">产品价格</div>
							<div class="profile-info-value">
								${product.price }
							</div>
						</div>
						<div class="profile-info-row">
							<div class="profile-info-name">成本价格</div>
							<div class="profile-info-value">
								${product.costPrice }
							</div>
						</div>
						<div class="profile-info-row">
							<div class="profile-info-name">规格</div>
							<div class="profile-info-value">
								${product.size }
							</div>
						</div>
						<div class="profile-info-row">
							<div class="profile-info-name">单位</div>
							<div class="profile-info-value">
								${product.unit }
							</div>
						</div>
						<div class="profile-info-row">
							<div class="profile-info-name">备注</div>
							<div class="profile-info-value">
								${product.remark }
							</div>
						</div>
						<div class="profile-info-row">
							<div class="profile-info-name">产品类型</div>
							<div class="profile-info-value">
								${product.type.name }
							</div>
						</div>
						<div class="profile-info-row">
							<div class="profile-info-name">添加时间</div>
							<div class="profile-info-value">
								<fmt:formatDate value="${product.addTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
							</div>
						</div>
						<div class="profile-info-row">
							<div class="profile-info-name">是否删除 </div>
							<div class="profile-info-value">
								<c:if test="${product.isDel eq '0'}">否</c:if>
								<c:if test="${product.isDel eq '1'}"><font color="red">是</font></c:if>
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
			$("#parent_7").addClass("active open");
		}
	</script>
	</body>
</html>