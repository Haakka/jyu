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
					<a href="javascript:;">数据回收</a>
				</li>
				<li class="active">CRM回收</li>
			</ul>
		</div><!-- .breadcrumb -->

		<div class="page-content">
			<div>
				<h3 class="row-fluid header smaller  blue" style="line-height: 39px;">
					<span class="span7">可回收订单列表 </span><!-- /span -->

				</h3>
			</div><!-- /.page-header -->
			<div class="row">
				<div class="col-xs-12">
					<!-- PAGE CONTENT BEGINS -->
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
													<fmt:formatDate value="${bean.payTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
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
														<a class="blue" href="javascript:;" onclick="recycle(${bean.id},'${bean.token }');" data-rel="tooltip" title="回收">
															<i class="icon-refresh bigger-130"></i>
														</a> 
													</div>
												</td>
											</tr>
										</c:forEach>
		
									</tbody>
								</table>
								<c:if test="${not empty pager.resultList}">
								<div class="row">
									<s:form action="orderAction!retrieveAllTrash.action" 
										namespace="/" method="get" id="form1" name="form1"
											theme="simple">
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
		});
		
		function recycle(id,token){
			bootbox.confirm("确定要回收吗?", function(result) {
				if(result) {
					$.ajax({
						url:'${ctx}/orderAction!recycleWaste.action',
						data:{
							'id':id,
							'token':token
						},
						dataType:'json',
						success:function(data){
							if(data.code == '200'){
								bootbox.alert({
								    message: "操作成功!",
								    callback: function () {
								    	window.location.reload();
								    }
								});
							}else{
								bootbox.alert({
								    message: "操作失败!",
								    callback: function () {
								    	window.location.reload();
								    }
								});
							}
						},
						error:function(data){
							bootbox.alert({
							    message: "网络出错!",
							});
						}
					});
				}
			});
		}
		
		function setCurrent(){
			$("#parent_8").addClass("active open");
			$("#sub_82").addClass("active");
		}
	</script>
	
	</body>
</html>