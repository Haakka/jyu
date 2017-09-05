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
					<a href="contactAction!retrieveAllContacts.action">客户管理</a>
				</li>
				<li class="active">联系人管理</li>
			</ul>
		</div><!-- .breadcrumb -->

		<div class="page-content">
			<div>
				<h3 class="row-fluid header smaller  blue" style="line-height: 39px;">
					<span class="span7">联系人列表 </span><!-- /span -->

					<span class="span5 pull-right">
						<label class="inline">
							<a class="btn btn-success btn-sm" href="contactAction!newPage.action">
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
					<form class="form-search" id="searchForm" name="searchForm" method="post" action="${ctx }/contactAction!retrieveAllContacts.action">
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
												<td>
													<c:choose>
														<c:when test="${bean.sex eq '0'}">男</c:when>
														<c:otherwise>女</c:otherwise>
													</c:choose>
												</td>
												<td>${bean.displayName}</td>
												<td>${bean.consumerId.name }</td>
												<td>${bean.department}</td>
												<td>${bean.position}</td>
												<td>
													<fmt:formatDate value="${bean.addTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
												</td>
												<td>
													<div class="action-buttons">
														 <a class="blue" href="contactAction!viewPage.action?id=${bean.id}&token=${bean.token}" data-rel="tooltip" title="查看">
															 <i class="icon-eye-open bigger-130"></i>
														</a> 
														<a class="green" title="编辑" data-rel="tooltip" href="contactAction!retrieveContactById.action?id=${bean.id}&token=${bean.token}">
															<i class="icon-pencil bigger-130"></i>
														</a>
														<a class="red"  title="删除" href="#" data-rel="tooltip" onclick="ajaxUpdateDel(${bean.id},this,'${ctx}/ajaxContactAction!delContact.action');">
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
									<s:form action="contactAction!retrieveAllContacts.action" 
										namespace="/" method="get" id="form1" name="form1"
											theme="simple">
											<input type="hidden" name="keyWord" value="${keyWord }" />
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
			
			$("#export").click(function(){
				window.location.href = "${ctx}/contactAction!export.action";
			});
			
		});
		
		function setCurrent(){
			$("#parent_3").addClass("active open");
			$("#sub_32").addClass("active");
		}
	</script>
	
	</body>
</html>