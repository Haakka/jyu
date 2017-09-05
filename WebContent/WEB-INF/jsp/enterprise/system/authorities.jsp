<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

	<%@ include file="/common/head-import.jsp"%>
	<script src="${ctx}/js/dtree/dtree.js" type="text/javascript"></script>
	<link href="${ctx}/js/dtree/dtree.css" rel="stylesheet" type="text/css"></link>
	
	<style>
		.dTreeNode{height:22px;margin-top:-4px;}
	</style>

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
				<li class="active">权限管理</li>
			</ul>
		</div><!-- .breadcrumb -->

		<div class="page-content">
			<div>
				<h3 class="row-fluid header smaller  blue" style="line-height: 39px;">
					<span class="span7">权限信息 </span><!-- /span -->

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
					<div class="widget-box">
							<div class="widget-header header-color-blue2"></div>
							<div class="widget-body">
								<div class="table-responsive">
									<div class="dataTables_wrapper" role="grid">
										<form action="rolesAction!update.action" method="post" id="linksForm" enctype="multipart/form-data" method="post">
										<input type="hidden" name="roles.id" value="${roles.id}" />
										<table id="sample-table-1" class="table table-striped table-bordered table-hover dataTable">
											<thead>
												<tr>
													<th width="40%">菜单
														<a class="pull-right action-buttons" href="${ctx}/authoritiesAction!add_page.action?fatherAuthName=MCCMS&type=0" data-rel="tooltip" title="新增菜单权限">
														<i class="icon-plus bigger-130"></i>
														</a>
													</th>
													<th width="40%">栏目
														<a class="pull-right action-buttons" href="${ctx}/authoritiesAction!add_page.action?fatherAuthName=总站&type=1" data-rel="tooltip" title="新增栏目权限">
														<i class="icon-plus bigger-130"></i>
														</a>
													</th>
													<th width="20%">功能
														<a class="pull-right action-buttons" href="${ctx}/authoritiesAction!add_page.action?type=2" data-rel="tooltip" title="新增功能权限">
														<i class="icon-plus bigger-130"></i>
														</a>
													</th>
												</tr>
											</thead>
				
											<tbody>
												<tr>
													<td>
														<c:if test="${not empty menu}">
															<div class="dtree">
																<p><a href="javascript: menu.openAll();"><!-- 全部展开 --><s:text name="common.word.openall" /></a> | 
																	<a href="javascript: menu.closeAll();"><!-- 全部合并 --><s:text name="common.word.closeall" /></a></p>
																
																<script type="text/javascript">
																	menu = new dTree('menu');
																	menu.add(0,-1,'MCCMS','','MCCMS');
																	${menu}
																	document.write(menu);
																</script>
															</div>
														</c:if>
													</td>
													<td>
														<c:if test="${not empty column}">
															<div class="dtree">
																<p><a href="javascript: column.openAll();"><!-- 全部展开 --><s:text name="common.word.openall" /></a> | 
																	<a href="javascript: column.closeAll();"><!-- 全部合并 --><s:text name="common.word.closeall" /></a></p>
																
																<script type="text/javascript">
																	column = new dTree('column');
																	column.add(0,-1,'<s:text name="common.word.site.center" />','','<s:text name="common.word.site.center" />');
																	${column}
																	document.write(column);
																</script>
															</div>
														</c:if>
													</td>
													<td>
														<c:if test="${not empty function}">
															<c:forEach var="authorities" items="${function}">
																<div>
																<a href="authoritiesAction!edit.action?id=${authorities.id}" title="${authorities.name}">${authorities.displayName}</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
																<a href="#" onclick="doDelete(${authorities.id})"> 删除</a>
																</div>
															</c:forEach>
														</c:if>
													</td>
												</tr>
											</tbody>
										</table>
										<s:token></s:token>
										</form>
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
	
	<script src="${ctx}/js/assets/js/fuelux/fuelux.wizard.min.js"></script>
	<script src="${ctx}/js/assets/js/jquery.validate.min.js"></script>
	<script src="${ctx}/js/assets/js/bootbox.min.js"></script>
	<script src="${ctx}/js/assets/js/ace-elements.min.js"></script>
	
	<script type="text/javascript">
		jQuery(function($) {
			setCurrent();
			$('[data-rel=tooltip]').tooltip();
		});
		
		function setCurrent(){
			$("#parent_2").addClass("active open");
			$("#sub_23").addClass("active");
		}
	</script>
	
	<script>
			function doDelete(id) {
				bootbox.confirm("确定要删除吗?", function(result) {
					if(result) {
						//alert(id);
						window.location.href="${ctx}/authoritiesAction!delete.action?id="+id;
					}
				});
			}


			
			
			//点击节点后，选择更多操作
			function loadMenu(obj) {
				bootbox.dialog({
					message: "<span class='bigger-110'>请选择你需要的操作</span>",
					buttons: 			
					{
						"success" :
						 {
							"label" : "新增",
							"className" : "btn-sm btn-success",
							"callback": function() {
								window.location.href='authoritiesAction!add_page.action?id='+obj
							}
						},
						"click" :
						{
							"label" : "编辑",
							"className" : "btn-sm btn-primary",
							"callback": function() {
								window.location.href='authoritiesAction!edit.action?id='+obj
							}
						},
						"danger" :
						{
							"label" : "删除",
							"className" : "btn-sm btn-danger",
							"callback": function() {
								doDelete(obj);
							}
						},
					}
				});
			}
			
		</script>
	</body>
</html>

