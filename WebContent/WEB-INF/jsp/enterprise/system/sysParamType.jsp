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
					<a href="#">系统设置</a>
				</li>
				<li class="active">系统参数类型</li>
			</ul>
		</div><!-- .breadcrumb -->

		<div class="page-content">
			<div>
				<h3 class="row-fluid header smaller  blue" style="line-height: 39px;">
					<span class="span7">参数类型列表 </span><!-- /span -->

					<span class="span5 pull-right">
						<label class="inline">
							<a class="btn btn-success btn-sm" href="sysParamTypeAction!newPage.action">
								<i class="icon-plus"></i>
								添加
							</a>
						</label>
					</span><!-- /span -->
				</h3>
			</div><!-- /.page-header -->
			<div class="row">
				<div class="col-xs-12">
					<!-- PAGE CONTENT BEGINS -->
					<form class="form-search">
							<div class="row">
								<div class="col-xs-12 col-sm-8" style="margin-left: 33.6%;">
									<div class="input-group" style="width: 300px;float: right;margin-top: -5px;margin-bottom: 10px;">
										<input type="text" class="form-control search-query" placeholder="输入关键字" />
										<span class="input-group-btn">
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
												<th>类型名称</th>
												<th>排序</th>
												<th>是否删除</th>
												<th>删除时间</th>
												<th>操作</th>
											</tr>
										</thead>
			
										<tbody>
											<c:forEach var="bean" items="${pager.resultList}" varStatus="status">
												<tr>
													<td>${status.count}</td>
													<td>${bean.typeName}</td>
													<td>${bean.sort}</td>
													<td>
														<c:choose>
															<c:when test="${bean.isDel eq '1'}">是</c:when>
															<c:when test="${bean.isDel eq '0'}">否</c:when>
														</c:choose>
													</td>
													<td>
														<fmt:formatDate value="${bean.deleteTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
													</td>
			
													<td>
														<div class="action-buttons">
															 <a class="blue" href="sysParamAction!findAllByTypeId.action?id=${bean.id}&token=${bean.token}" data-rel="tooltip" title="查看">
																 <i class="icon-eye-open bigger-130"></i>
															</a> 
															<a class="green" title="编辑" data-rel="tooltip" href="sysParamTypeAction!retrieveSysParamTypeById.action?id=${bean.id}&token=${bean.token}">
																<i class="icon-pencil bigger-130"></i>
															</a>
															<a class="red"  title="删除" href="#" data-rel="tooltip" onclick="ajaxUpdateDel(${bean.id},this,'${ctx}/ajaxSysParamTypeAction!delSysParamType.action');">
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
										<s:form action="sysParamTypeAction!retrieveAllSysParamTypes.action" 
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
		});
		
		function setCurrent(){
			$("#parent_2").addClass("active open");
			$("#sub_24").addClass("active");
		}
	</script>
	
	</body>
</html>