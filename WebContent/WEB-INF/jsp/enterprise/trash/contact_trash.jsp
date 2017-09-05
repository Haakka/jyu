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
					<span class="span7">可回收联系人列表 </span><!-- /span -->

				</h3>
			</div><!-- /.page-header -->
			<div class="row">
				<div class="col-xs-12">
					<!-- PAGE CONTENT BEGINS -->
					<div class="widget-box">
						<div class="widget-header header-color-blue2"></div>
						<div class="widget-body">
							<div class="table-responsive">
								<table id="sample-table-1" class="table table-striped table-bordered table-hover">
									<thead>
										<tr>
											<th>序号</th>
											<th>姓名</th>
											<th>手机号码</th>
											<th>性别</th>
											<th>称呼</th>
											<th>所属客户</th>
											<th>所属部门</th>
											<th>所属职位</th>
											<th>添加时间</th>
											<th>操作</th>
										</tr>
									</thead>
		
									<tbody>
										<c:forEach var="bean" items="${pager.resultList}" varStatus="status">
											<tr>
												<td>${status.count}</td>
												<td>${bean.name}</td>
												<td>${bean.phone}</td>
												<td>${bean.sex}</td>
												<td>${bean.displayName}</td>
												<td>${bean.consumerId.name }</td>
												<td>${bean.department}</td>
												<td>${bean.position}</td>
												<td>
													<fmt:formatDate value="${bean.addTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
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
									<s:form action="contactAction!retrieveAllTrash.action" 
										namespace="/" method="get" id="form1" name="form1"
											theme="simple">
										<%@ include file="../../common/pager.jsp"%>
									</s:form>
								</div>
								<!-- 分页 -->
								</c:if>
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
						url:'${ctx}/contactAction!recycleWaste.action',
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