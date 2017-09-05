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
					<a href="businessAction!retrieveAllBusinesss.action">客户管理</a>
				</li>
				<li class="active">商机线索</li>
			</ul>
		</div><!-- .breadcrumb -->

		<div class="page-content">
			<div>
				<h3 class="row-fluid header smaller  blue" style="line-height: 39px;">
					<span class="span7">商机线索列表 </span><!-- /span -->

					<span class="span5 pull-right">
						<label class="inline">
							<a class="btn btn-success btn-sm" href="businessAction!newPage.action">
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
					<form class="form-search" id="searchForm" name="searchForm" method="post" action="${ctx }/businessAction!retrieveAllBusinesss.action">
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
											<th>名称</th>
											<th>来源</th>
											<th>类型</th>
											<th>价值</th>
											<th>客户</th>
											<th>联系人</th>
											<th>创建时间</th>
											<th>状态</th>
											<th>操作</th>
										</tr>
									</thead>
		
									<tbody>
										<c:forEach var="bean" items="${pager.resultList}" varStatus="status">
											<tr>
												<td>${status.count}</td>
												<td>${bean.name}</td>
												<td>${bean.originId.name }</td>
												<td>${bean.typeId.name}</td>
												<td>${bean.valueId.name}</td>
												<td>${bean.consumer.name}</td>
												<td>${bean.contactor.name}</td>
												<td>
													<fmt:formatDate value="${bean.addTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
												</td>
												<td>
													<c:choose>
														<c:when test="${bean.status eq '0'}">初次接洽</c:when>
														<c:when test="${bean.status eq '1'}">已跟进</c:when>
														<c:when test="${bean.status eq '2'}">价格谈判</c:when>
														<c:when test="${bean.status eq '3'}">赢单</c:when>
														<c:when test="${bean.status eq '4'}">输单</c:when>
													</c:choose>
												</td>
		
												<td>
													<div class="action-buttons">
														 <a class="blue" href="businessAction!viewPage.action?id=${bean.id}&token=${bean.token}" data-rel="tooltip" title="查看">
															 <i class="icon-eye-open bigger-130"></i>
														</a> 
														<a class="green" title="编辑" data-rel="tooltip" href="businessAction!retrieveBusinessById.action?id=${bean.id}&token=${bean.token}">
															<i class="icon-pencil bigger-130"></i>
														</a>
														<a class="red"  title="删除" href="#" data-rel="tooltip" onclick="ajaxUpdateDel(${bean.id},this,'${ctx}/ajaxBusinessAction!delBusiness.action');">
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
									<s:form action="businessAction!retrieveAllBusinesss.action" 
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
			
			<!-- 模态框（Modal） -->
			<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			    <div class="modal-dialog" >
			        <div class="modal-content">
			            <div class="modal-header">
			                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
			                    &times;
			                </button>
			                <h4 class="modal-title" id="myModalLabel">
			                    	客户指派
			                </h4>
			            </div>
			            <form id="form_data" class="form-horizontal" role="form">
					            <div class="modal-body" style="height:100px;">
					            	 <div style="margin-left: 100px;">
											<font size="4">指派:</font>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
											<select name="finisherId" data-placeholder="请选择..." style="width: 250px;" class="chosen-select" >
												<option value=""></option>
												<c:forEach items="${finishers }" var="finisher">
													<option value="${finisher.id }">${finisher.name }</option>
												</c:forEach>
											</select>
						              </div>
					            </div>
					            <div class="modal-footer" style="text-align: center;">
					                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					                <button type="button" onclick="assignSubmit()" class="btn btn-primary">提交</button>
					            </div>
			            </form>
			        </div><!-- /.modal-content -->
			    </div>
			</div><!-- /.modal -->
			
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
		
		function setCurrent(){
			$("#parent_3").addClass("active open");
			$("#sub_33").addClass("active");
		}
		
		function assign(id,obj) {
			var token = $(obj).siblings(".security-token").val();
			var idInput = "<input type='hidden' id='id' value='"+id+"' >";
			var tokenInput = "<input type='hidden' id='token' value='"+token+"' >";
			$("#form_data").append(idInput);
			$("#form_data").append(tokenInput);
			$("#myModal").modal('show');
		}
		
		function assignSubmit() {
			
			$.ajax({
				   type: "POST",
				   url: "${ctx}/consumerAction!assign.action",
				   data: $("#form_data").serialize(),
				   success: function(data){
					   $("#id").remove();
					   $("#token").remove();
				   },
				   error : function (data) {
						
				   }
				});
		}
		
		$(document).ready(function(){
			
			$("#myModal").on('hide.bs.modal', function () {
				$("#id").remove();
				$("#token").remove();
			});
			
			$(".chosen-select").chosen({no_results_text : "未找到此选项!",search_contains: true});
		
		});
		
	</script>
	
	</body>
</html>