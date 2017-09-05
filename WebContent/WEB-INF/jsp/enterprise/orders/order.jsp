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
					<a href="${ctx}/usersAction!center.htm">首页</a>
				</li>
				<li>
					<a href="orderAction!retrieveAllOrders.action">合同订单</a>
				</li>
				<li class="active">订单管理</li>
			</ul>
		</div><!-- .breadcrumb -->

		<div class="page-content">
			<div>
				<h3 class="row-fluid header smaller  blue" style="line-height: 39px;">
					<span class="span7">订单列表 </span><!-- /span -->

					<span class="span5 pull-right">
						<label class="inline">
							<a class="btn btn-success btn-sm" href="orderAction!newPage.action">
								<i class="icon-plus"></i>
								添加
							</a>
						</label>
						<label class="inline">
							<button class="btn btn-purple btn-sm" id="export">
								<i class="icon-download"></i>
								导出
							</button>
						</label>
					</span><!-- /span -->
				</h3>
			</div><!-- /.page-header -->
			<div class="row">
				<div class="col-xs-12">
					<!-- PAGE CONTENT BEGINS -->
					<form class="form-search" id="searchForm" name="searchForm" method="post" action="${ctx }/orderAction!retrieveAllOrders.action">
						<div class="row">
							<div class="col-xs-12 col-sm-8" style="margin-left: 33.6%;">
								<div class="input-group" style="width: 300px;float: right;margin-top: -5px;margin-bottom: 10px;">
									<input type="text" name="keyWord" id="keyWord" value="${keyWord }" class="form-control search-query" placeholder="输入关键字" />
									<span class="input-group-btn" id="searchBtn">
											<button type="button" class="btn btn-primary btn-sm">
												查询
											<i class="icon-search icon-on-right bigger-110"></i>
										</button>
									</span>
								</div>
							</div>
						</div>
					</form>
						<div class="widget-box">
							<div class="widget-header header-color-blue2"></div>
							<div class="widget-body">	
							<div class="table-responsive">
								<div class="dataTables_wrapper" role="grid">
								<table id="sample-table-1" class="table table-striped table-bordered table-hover dataTable">
									<thead>
										<tr>
											<th>序号</th>
											<th>订单编号</th>
											<th>添加时间</th>
											<th>支付时间</th>
											<th>订单金额</th>
											<th>已开票</th>
											<th>操作</th>
										</tr>
									</thead>
		
									<tbody>
										<c:forEach var="bean" items="${pager.resultList}" varStatus="status">
											<tr>
												<td>${status.count}</td>
												<td>${bean.orderSn}</td>
												<td>
													<fmt:formatDate value="${bean.addTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
												</td>
												<td>
													<fmt:formatDate value="${bean.payTime}" pattern="yyyy-MM-dd"/>
												</td>
												<td>
													${bean.totalAmount}
												</td>
												<td>
													<c:choose>
														<c:when test="${bean.isInvoice eq '0'}">否</c:when>
														<c:otherwise>是</c:otherwise>
													</c:choose>
												</td>
		
												<td>
													<div class="action-buttons">
														 <a class="blue" href="orderAction!viewPage.action?id=${bean.id}&token=${bean.token}" data-rel="tooltip" title="查看">
															 <i class="icon-eye-open bigger-130"></i>
														</a> 
														<a class="green" title="编辑" data-rel="tooltip" href="orderAction!retrieveOrderById.action?id=${bean.id}&token=${bean.token}">
															<i class="icon-pencil bigger-130"></i>
														</a>
														<a class="red"  title="删除" href="#" data-rel="tooltip" onclick="ajaxUpdateDel(${bean.id},this,'${ctx}/ajaxOrderAction!delOrder.action');">
															<i class="icon-trash bigger-130"></i>
														</a>
														<input type="hidden" class="security-token" value="${bean.token}">
													</div>
												</td>
											</tr>
										</c:forEach>
		
									</tbody>
								</table>
								<c:if test="${not empty pager.resultList}">
								<div class="row">
									<s:form action="orderAction!retrieveAllOrders.action" 
										namespace="/" method="get" id="form1" name="form1"
											theme="simple">
										<input type="hidden" name="keyWord" value="${keyWord }" />
										<%@ include file="../../common/pager.jsp"%>
									</s:form>
								</div>
								<!-- 分页 -->
								</c:if>
								</div>
							</div><!-- /.table-responsive -->
						</div><!-- widget-body end -->
					</div><!-- widget-box end -->
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
			$('[data-rel=tooltip]').tooltip();
			
			$("#searchBtn").click(function(){
				 $("#searchForm").submit();  
			});
			
			$("#export").click(function(){
				window.location.href = "${ctx}/orderAction!export.action";
			});
			
		});
		
		function setCurrent(){
			$("#parent_4").addClass("active open");
			$("#sub_42").addClass("active");
		}
	</script>
	
	</body>
</html>