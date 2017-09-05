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
				<li class="active">角色管理</li>
			</ul>
		</div><!-- .breadcrumb -->

		<div class="page-content">
			<div>
				<h3 class="row-fluid header smaller  blue" style="line-height: 39px;">
					<span class="span7"> 角色列表 </span><!-- /span -->

					<span class="span5 pull-right">
						<label class="inline">
							<a class="btn btn-success btn-sm" href="rolesAction!add_page.action">
								<i class="icon-plus"></i>
								添加角色
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
												<th>角色名称</th>
												<th>状态</th>
												<th>操作</th>
											</tr>
										</thead>
			
										<tbody>
											<c:forEach var="rolesList" items="${rolesList}">
												<tr>
													<td>${rolesList.name}</td>
													<td>
														<c:if test="${rolesList.state == 1}">启用</c:if>
														<c:if test="${rolesList.state == 0}"><font color="red">停用</font></c:if>
													</td>
													<td class=" ">
														<div class="visible-md visible-lg hidden-sm hidden-xs action-buttons">
															<a class="green" href="rolesAction!edit.action?id=${rolesList.id}" data-rel="tooltip" title="编辑">
																<i class="icon-pencil bigger-130"></i>
															</a>
															<a class="green" href="rolesAction!editAuth.action?id=${rolesList.id}" data-rel="tooltip"  title="权限配置">
																<i class="icon-eye-open bigger-130"></i>
															</a>
															<a class="red" href="#" onclick="doDelete(${rolesList.id});" data-rel="tooltip" title="删除">
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
																		<a href="rolesAction!edit.action?id=${rolesList.id}" class="tooltip-success" data-rel="tooltip" title="" data-original-title="编辑">
																			<span class="green">
																				<i class="icon-edit bigger-120"></i>
																			</span>
																		</a>
																	</li>
																	<li>
																		<a href="rolesAction!editAuth.action?id=${rolesList.id}" class="tooltip-success" data-rel="tooltip" title="" data-original-title="权限">
																			<span class="green">
																				<i class="icon-eye-open bigger-120"></i>
																			</span>
																		</a>
																	</li>
																	
																	<li>
																		<a href="#" onclick="doDelete(${rolesList.id});" class="tooltip-error" data-rel="tooltip" title="" data-original-title="删除">
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
			$("#sub_22").addClass("active");
		}
	</script>
	
	<script>
		function doDelete(id) {
			bootbox.confirm("确定要删除吗?", function(result) {
				if(result) {
					window.location.href="${ctx}/rolesAction!delete.action?id="+id;
				}
			});
		}
	</script>
	</body>
</html>


