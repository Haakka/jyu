<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/common/taglibs.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<!-- seo begin-->
		<meta name="keywords" content="
			<c:choose>
			       <c:when test="${not empty enterpriseNews.priKey}">
			              ${enterpriseNews.priKey}
			       </c:when>
			       <c:when test="${not empty mcProductInfo.keywords}">
			              ${mcProductInfo.keywords}
			       </c:when>
			</c:choose>
		"/>
		<meta name="description" content="
			<c:choose>
			       <c:when test="${not empty enterpriseNews.shortMeta}">
			              ${enterpriseNews.shortMeta}
			       </c:when>
			       <c:when test="${not empty mcProductInfo.description}">
			              ${mcProductInfo.description}
			       </c:when>
			</c:choose>
		"/>
		<!-- seo end -->
		<title>${webSite.title}</title>
		<link href="${ctx}/jsps/theme/${webSite.webSkin.filename}/image/style.css" rel="stylesheet" type="text/css" />
		<script src="${ctx}/jsps/theme/${webSite.webSkin.filename}/js/jquery-1.4.4.min.js" type="text/javascript"></script>
		<script src="${ctx}/jsps/theme/${webSite.webSkin.filename}/js/news.js" type="text/javascript"></script>
		<script src="${ctx}/jsps/theme/${webSite.webSkin.filename}/js/imgnews.js" type="text/javascript"></script>
		<script src="${ctx}/ueditor/ueditor.parse.js" type="text/javascript"></script>
		<%@ include file="/jsps/modules/useragent.jsp"%>

		<script type="text/javascript">
			var enabled = 0; today = new Date();
			var day; var date;
			if(today.getDay()==0) day = " 星期日"
			if(today.getDay()==1) day = " 星期一"
			if(today.getDay()==2) day = " 星期二"
			if(today.getDay()==3) day = " 星期三"
			if(today.getDay()==4) day = " 星期四"
			if(today.getDay()==5) day = " 星期五"
			if(today.getDay()==6) day = " 星期六"
			document.fgColor = "000000";
			date = (today.getFullYear()) + "年" + (today.getMonth() + 1 ) + "月" + today.getDate() + "日  " + day +"";
		
			$(document).ready(function(){
				
				$("#addFavorite").click(function(){
					if (window.sidebar) {        // Firefox
		                window.sidebar.addPanel ('MCCMS演示站', 'http://www.messcat.com', '');
		            } 
		            else {
		                if (window.external && ('AddFavorite' in window.external)) {
		                        // Internet Explorer
		                    window.external.AddFavorite ('http://www.messcat.com', 'MCCMS演示站');
		                }
		                else {  // Opera, Google Chrome and Safari
		                    alert ("你的浏览器不支持这个操作！");
		                } 
		            }
				    
				});
			});
			
			function submitForm(formId){
				var title = $("#title");
				if(title.val()=='' || title.val()=='关键字'){
					alert('请输入关键字');
				} else {
					$("#"+formId).submit();
				}
			}
		</script>
	</head>

	<body>
		<!--head begin-->
		<div id="head">
			<a href="#" class="logo"><img src="${ctx}/upload/enterprice/${standbyList.bgphoto2}" /></a>
			<div class="head_r">
				<ul class="head_r_menu">
					<li><a href="${ctx}/epIndexNewsAction.htm">首页</a></li>
		            <li>|</li>
		            <li><a target="_top"  id="addFavorite">收藏本站</a></li>
		            <li>|</li>
		            <li><a href="${ctx}/epIndexNewsAction!webmap.htm">网站地图</a></li>
				</ul>
		        <div class="head_search">
		        	<form action="epIndexNewsAction!search.action" method="post" id="searchNews">
						<div class="search_l"><input id="title" type="text" name="title" autocomplete="off" placeholder="关键字"></div>
						<a href="#" onclick="javascript:submitForm('searchNews');"><div class="search_r"></div></a>
					</form>
				</div>
			</div>
		</div>
		
		<!--nav begin-->
		<div id="nav">
			<ul class="nav_menu">
				<li>
					<a href="${ctx}/epIndexNewsAction.htm">首页</a>
				</li>
				<c:forEach var="column" items="${columns}" begin="0" end="7">
					<c:if test="${column.isValidInNav=='1'}">
						<li>
							<a href="${column.linkUrl}">${column.names}</a>
						</li>
					</c:if>
				</c:forEach>
			</ul>
		</div>

		<!--notice begin-->
		<div id="loginwrap">
			<div id="userwrap"><span>用户名</span><span><input id="username" type="text" placeholder="用户名"/></span></div>
			<div id="pawwrap"><span>密&nbsp;&nbsp;&nbsp;码</span><span><input id="username" type="password" placeholder="密码"/></span></div>
			<div id="btwrap">
		     	<span id="loginbutton"><a href="">登录</a></span>
				<span id="registerbutton"><a href="#">注册</a></span>
				<span>|</span>
				<span id="forgerpawbutton"><a href="#">忘记密码</a></span>
			</div>
			<div class="datetime">您是本站第<b><font color="red"><%=application.getAttribute("counter")%></font></b>位访客！&nbsp;&nbsp;&nbsp;<script>document.write(date);</script></div>
		</div>