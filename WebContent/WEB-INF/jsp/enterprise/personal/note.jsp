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
					<a href="noteAction!retrieveAllNotes.action">父级栏目</a>
				</li>
				<li class="active">当前栏目</li>
			</ul>
		</div><!-- .breadcrumb -->

		<div class="page-content">
			<div>
				<h3 class="row-fluid header smaller  blue" style="line-height: 39px;">
					<span class="span7">当前栏目列表 </span><!-- /span -->

					<span class="span5 pull-right">
						<label class="inline">
							<a class="btn btn-success btn-sm" href="noteAction!newPage.action">
								<i class="icon-plus"></i>
								添加
							</a>
						</label>
						<label class="inline">
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
					<div class="input-group" style="width: 300px;float: right;margin-top: -5px;margin-bottom: 10px;">
							<input type="text" class="form-control search-query" placeholder="输入关键字" />
							<span class="input-group-btn">
								<button type="button" class="btn btn-primary btn-sm">
									查询
									<i class="icon-search icon-on-right bigger-110"></i>
								</button>
							</span>
					</div>
					<div class="table-responsive">
						<div class="dataTables_wrapper" role="grid">
						<table id="sample-table-1" class="table table-striped table-bordered table-hover dataTable">
							<thead>
								<tr>
									<th>序号</th>
									<th>content</th>
									<th>isDel</th>
									<th>addTime</th>
									<th>deleteTime</th>

									<th>操作</th>
								</tr>
							</thead>

							<tbody>
								<c:forEach var="bean" items="${notes}" varStatus="status">
									<tr>
										<td>${status.count}</td>
										<td>${bean.content}</td>
										<td>${bean.isDel}</td>
										<td>${bean.addTime}</td>
										<td>${bean.deleteTime}</td>

										<td>
											<div class="hidden-sm">
												<a class="btn btn-info btn-xs"  title="" href="noteAction!retrieveNoteById.action?id=${bean.id}&pageNo=${pager.pageNo}">修改</a>
												<a class="btn btn-danger btn-xs"  title="" href="#" onclick="doDelete(${bean.id});">删除</a>
											</div>
										</td>
									</tr>
								</c:forEach>

							</tbody>
						</table>
						<c:if test="${not empty notes}">
						<div class="row">
							<s:form action="noteAction!retrieveAllNotes.action" 
								namespace="/personal" method="get" id="form1" name="form1"
									theme="simple">
								<%@ include file="../../common/pager.jsp"%>
							</s:form>
						</div>
						<!-- 分页 -->
						</c:if>
						</div>
					</div><!-- /.table-responsive -->
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
			$("#parent_x").addClass("active open");
			$("#sub_xx").addClass("active");
		}
	</script>
	
	<script>
		function doDelete(id) {
			bootbox.confirm("确定要删除吗?", function(result) {
				if(result) {
					window.location.href="noteAction!delNote.action?id="+id;
				}
			});
		}
	</script>
	</body>
</html>