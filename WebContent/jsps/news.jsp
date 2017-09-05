<%@ page contentType="text/html;charset=utf-8"%>

<%@ include file="/jsps/modules/top.jsp"%>

<!--container begin-->
<div id="container">
   
	<!--container_newsList_L-->
	<%@ include file="/jsps/modules/left.jsp"%>
   	
	<div id="container_newsList_R">
		<!--container_newsList_R_banner-->
		<%@ include file="/jsps/modules/right.jsp"%>
   		
		<div class="container_newsList_R_info">
           	<c:if test="${enterpriseNews.isOnlyContent==0}">
           		<div class="news_title">${enterpriseNews.title}</div>
				<div class="news_disc">
					<div class="news_author">发表者：${enterpriseNews.users.name}</div>
					<div class="news_source">来源：${enterpriseNews.source}</div>
					<div class="news_time">更新时间：<fmt:formatDate value="${enterpriseNews.editeTime}" pattern="yyyy-MM-dd"/></div>
				</div>
			</c:if>
			<div class="news_detail">
				${enterpriseNews.contents}
			</div>
		</div>
	</div>
</div>
<script>
$(document).ready(function(){
	uParse('.news_detail', {
	    rootPath: '${ctx}/ueditor/'
	});
});
</script>
<!--container end-->

<div class="clear"></div>

<%@ include file="/jsps/modules/copyRight.jsp"%>