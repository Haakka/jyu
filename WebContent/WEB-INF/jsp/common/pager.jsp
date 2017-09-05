<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


	<div class="col-sm-6">
		<div id="sample-table-2_info" class="dataTables_info">
				共有 <s:property value="pager.rowCount" /> 条记录，每页行数：
			<s:select name="pageSize" id="pageSize" list="pager.pageSizeIndexs" theme="simple" value="pager.pageSize"
					onchange="$('#pageNo').val('1');$('#form1').submit();" /> 当前第
          	<s:select name="pageNo" id="pageNo" list="pager.pageNoIndexs" theme="simple"
					value="pager.pageNo" onchange="$('#form1').submit();" /> 页
		</div>
	</div>
	<div class="col-sm-6">
		<div class="dataTables_paginate paging_bootstrap">
			<div class="pagination">
				<c:if test="${pager.pageNo == '1'}">
					<button class="btn btn-light btn-sm disabled">首页</button>
					<button class="btn btn-light btn-sm disabled">上一页</button>
				</c:if>
				<c:if test="${pager.pageNo != '1'}">
					<a class="btn btn-white btn-sm" href="javascript:$('#pageNo').val('<s:property value="pager.firstPageNo" />');$('#form1').submit();">首页</a>
					<a class="btn btn-white btn-sm" href="javascript:$('#pageNo').val('<s:property value="pager.prePageNo" />');$('#form1').submit();">上一页</a>
	            </c:if>
	            
	            <c:if test="${pager.pageNo == pager.pageCount}">
	            	<button class="btn btn-light disabled btn-sm">下一页</button>
					<button class="btn btn-light disabled btn-sm">尾页</button>
				</c:if>
				<c:if test="${pager.pageNo != pager.pageCount}">
	               	<a class="btn btn-white btn-sm" href="javascript:$('#pageNo').val('<s:property value="pager.nextPageNo" />');$('#form1').submit();">下一页</a>
					<a class="btn btn-white btn-sm" href="javascript:$('#pageNo').val('<s:property value="pager.lastPageNo" />');$('#form1').submit();">尾页</a>
	            </c:if>
            </div>
		</div>
	</div>	
