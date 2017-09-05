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
				<li class="active">角色管理</li>
			</ul>
		</div><!-- .breadcrumb -->

		<div class="page-content">
			<div>
				<h3 class="row-fluid header smaller  blue" style="line-height: 39px;">
					<span class="span7">角色权限配置 </span><!-- /span -->

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
					<div class="table-responsive">
						<div class="dataTables_wrapper" role="grid">
							<form action="rolesAction!update.action" method="post" id="linksForm" enctype="multipart/form-data" method="post">
							<input type="hidden" name="roles.id" value="${roles.id}" />
							<table id="sample-table-1" class="table table-striped table-bordered table-hover dataTable">
								<thead>
									<tr>
										<th width="40%">菜单</th>
										<th width="40%">栏目</th>
										<th width="20%">功能</th>
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
													menu.config.check = true;
													menu.config.checkName = 'checkedMenu';
													menu.add(0,-1,'MCCMS','javascript:void(0);','MCCMS');
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
														column.config.check = true;
														column.config.checkName = 'checkedMenu';
														column.add(0,-1,'<s:text name="common.word.site.center" />','','<s:text name="common.word.site.center" />');
														${column}
														document.write(column);
													</script>
												</div>
											</c:if>
										</td>
										<td>
											<c:if test="${not empty function}">
												<div><input id="selectAllforCheckedMenu" type="checkbox"
														name="selectAllforCheckedMenu" style="vertical-align: middle;" />
													<!-- 全选功能列表 --><s:text name="enterprise.system.role.select.all" />
												</div>
												<c:forEach var="authorities" items="${function}">
													<div>
														<input type="checkbox" name="checkedMenu" value="${authorities.id}"
																<c:forEach var="roleAuth" items="${roles.rolesAuthoritieses}">
														<c:if test="${authorities.id == roleAuth.authorities.id}">
															checked
														</c:if>
													</c:forEach> style="vertical-align: middle;" class="fn" />
														${authorities.displayName}
													</div>
												</c:forEach>
											</c:if>
										</td>
									</tr>
									<tr>
										<td colspan="3" style="text-align:center;">
											<input type="submit" class="btn btn-info btm-xs" value='提交' />
										</td>
									</tr>
								</tbody>
							</table>
							<s:token></s:token>
							</form>
						</div>
					</div><!-- /.table-responsive -->
					<!-- PAGE CONTENT ENDS -->
				</div><!-- /.col -->
			</div><!-- /.row -->
		</div><!-- /.page-content -->
		
		
		<%@ include file="/common/copyright.jsp"%>
	</div><!-- /.main-content -->

				

	<%@ include file="/common/bottom-import.jsp"%>
	
	<script src="${ctx}/js/assets/js/fuelux/fuelux.wizard.min.js"></script>
	<script src="${ctx}/js/assets/js/jquery.validate.min.js"></script>
	
	<script type="text/javascript">
		jQuery(function($) {
			setCurrent();
		});
		
		function setCurrent(){
			$("#parent_2").addClass("active open");
			$("#sub_22").addClass("active");
		}
	</script>
	
	
	</body>
</html>

