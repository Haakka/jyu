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
					<a href="#">用户角色</a>
				</li>
				<li class="active">用户管理</li>
			</ul>
		</div><!-- .breadcrumb -->

		<div class="page-content">
			<div>
				<h3 class="row-fluid header smaller  blue" style="line-height: 39px;">
					<span class="span7"> 用户列表 </span><!-- /span -->

					<span class="span5 pull-right">
						<label class="inline">
							<a class="btn btn-success btn-sm" href="usersAction!add_page.action">
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
					<div class="widget-box">
							<div class="widget-header header-color-blue2"></div>
							<div class="widget-body">
								<div class="table-responsive">
									<div class="dataTables_wrapper" role="grid">
									<table id="sample-table-1" class="table table-striped table-bordered table-hover dataTable">
										<thead>
											<tr>
												<th>登录名称</th>
												<th>角色</th>
												<th class="hidden-480">真实名字</th>
												<th class="hidden-480">编辑时间</th>
												<th>状态</th>
												<th>操作</th>
											</tr>
										</thead>
			
										<tbody>
											<c:forEach var="tusers" items="${usersList}">
												<tr>
													<td>
														${tusers.loginName}
													</td>
													<td>
														<c:forEach var="ro" items="${tusers.usersRoleses}">
															${ro.roles.name}&nbsp;&nbsp;&nbsp;&nbsp;
														</c:forEach>
													</td>
													<td class="hidden-480">${tusers.name}</td>
				
													<td class="hidden-480">
														<fmt:formatDate value="${tusers.updateTime}" pattern="yyyy-MM-dd HH:mm:ss" />
													</td>
													<td>
														<c:if test="${tusers.state == 1}"><!-- 已启用 --><s:text name="common.word.has.opened" /></c:if>
														<c:if test="${tusers.state == 0}">
															<font color="red"><!-- 已停用 --><s:text name="common.word.has.closed" /></font>
														</c:if>
													</td>
													<td class=" ">
														<div class="visible-md visible-lg hidden-sm hidden-xs action-buttons">
															<a class="blue" href="usersAction!view.action?id=${tusers.id}" data-rel="tooltip" title="查看">
																<i class="icon-zoom-in bigger-130"></i>
															</a>
				
															<a class="green" href="usersAction!edit.action?id=${tusers.id}" data-rel="tooltip" title="编辑">
																<i class="icon-pencil bigger-130"></i>
															</a>
															<a class="orange" href="updatePasswordAction!resetview.action?id=${tusers.id}" data-rel="tooltip" title="重置密码">
																<i class="icon-lock bigger-130"></i>
															</a>
				
															<a class="red" href="#" onclick="doDelete(${tusers.id})" data-rel="tooltip" title="删除">
																<i class="icon-trash bigger-130"></i>
															</a>
														</div>
				
														<div class="visible-xs visible-sm hidden-md hidden-lg">
															<div class="inline position-relative">
																<button class="btn btn-minier btn-yellow dropdown-toggle" data-toggle="dropdown">
																	<i class="icon-caret-down icon-only bigger-120"></i>
																</button>
				
																<ul class="dropdown-menu dropdown-only-icon dropdown-yellow pull-right dropdown-caret dropdown-close">
																	<li>
																		<a href="usersAction!view.action?id=${tusers.id}" class="tooltip-info" data-rel="tooltip" title="" data-original-title="View">
																			<span class="blue">
																				<i class="icon-zoom-in bigger-120"></i>
																			</span>
																		</a>
																	</li>
				
																	<li>
																		<a href="usersAction!edit.action?id=${tusers.id}" class="tooltip-success" data-rel="tooltip" title="" data-original-title="Edit">
																			<span class="green">
																				<i class="icon-edit bigger-120"></i>
																			</span>
																		</a>
																	</li>
																	
																	<li>
																		<a href="updatePasswordAction!resetview.action?id=${tusers.id}" class="tooltip-success" data-rel="tooltip" title="" data-original-title="重置密码">
																			<span class="orange">
																				<i class="icon-lock bigger-120"></i>
																			</span>
																		</a>
																	</li>
				
																	<li>
																		<a href="#" onclick="doDelete(${tusers.id});" class="tooltip-error" data-rel="tooltip" title="" data-original-title="Delete">
																			<span class="red">
																				<i class="icon-trash bigger-120"></i>
																			</span>
																		</a>
																	</li>
																</ul>
															</div>
														</div>
													</td>
												</tr>
											</c:forEach>
			
										</tbody>
									</table>
									<div class="row">
										<s:form action="usersAction" method="get" id="form1" name="form1"
												theme="simple">
											<%@ include file="../../common/pager.jsp"%>
										</s:form>
									</div>
									<!-- 分页 -->
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
			$("#sub_21").addClass("active");
		}
	</script>
	
	<script>
		function doDelete(id) {
			bootbox.confirm("确定要删除吗?", function(result) {
				if(result) {
					window.location.href="${ctx}/usersAction!delete.action?id="+id;
				}
			});
		}
	</script>
	</body>
</html>


