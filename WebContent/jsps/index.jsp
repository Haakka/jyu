<%@ page contentType="text/html;charset=utf-8"%>

<%@ include file="/jsps/modules/top.jsp"%>

    <!--container begin-->
    <div id="container">
    	<div id="container_1">
        	<div id="container_1L" class="container_L">
            	<div class="banner_gray_style">
                	<div class="banner_gray_style_title2">
						<!-- 信息公告 -->
	                   	<c:if test="${not empty map.bulletin}">
                        	${map.bulletin.enterpriseColumn.names}
                        </c:if>
						<c:if test="${empty map.bulletin}">
				         	模块row1column1
				        </c:if>
					</div>
                    <div class="banner_more2">
                    	<a href="${map.bulletin.enterpriseColumn.linkUrl}">more</a>
					</div>
                </div>
                <div id="container_1L_infowrap">
                	<div class="container_L_newslist">
                    	<ul>
                    		<c:forEach var="news" items="${map.bulletin.enterpriseNewsList}" begin="0" end="9">
                    			<li>
                                	<div class="container_L_newslist_headline">
                                		<a href="${ctx}/navigation.htm?columnType=news&newsId=${news.id}" target="_blank">
								            
								            <%-- 下面是两种调用按中英文字符截取字符串函数的方法，两种都可用 --%>
	                                   		<mtag:cutString value="${news.title}" size="9" mark="..." /><br />
	                                   		${mtag:cutString(news.title,9,'...')}
	                                    </a>
                                	</div>
                                	<div class="date">
                                		<fmt:formatDate value="${news.editeTime}" pattern="MM/dd" />
                                	</div>
                            	</li>
                    		</c:forEach>
                        </ul>
                    </div>	
                </div>    	
            </div>
            <div id="container_1R">
            	<div class="banner_green_style2">
                	<div class="banner_green_style_titlewrap2">
                    	<div class="banner_green_style_title2">
							<!-- 国内环保新闻 -->
		                   	<c:if test="${not empty map.row1column2}">
	                        	${map.row1column2.enterpriseColumn.names}
	                        </c:if>
							<c:if test="${empty map.row1column2}">
					         	模块row1column2
					        </c:if>
						</div>
                    </div>
                    <div class="banner_more2">
                    	<a href="${map.row1column2.enterpriseColumn.linkUrl}">more</a>
					</div>
                </div>
                <div id="container_1R_infowrap">
                	<div id="container_1R1_infowrap">
                		<c:forEach var="news" items="${map.row1column2.enterprisePhotoNewsList}" begin="0" end="0">
                			<a href="${ctx}/navigation.htm?columnType=news&newsId=${news.id}">
								<img src="${ctx}/upload/enterprice/${news.photo}" />
							</a>
						</c:forEach>
                    </div>
                    <div id="container_1R2_infowrap">
                    	<ul>
                    		<c:forEach var="news" items="${map.row1column2.enterpriseNewsList}" begin="0" end="9">
                    			<li>
                                	 <div class="container_1R_newslist_headline">
                                		<a href="${ctx}/navigation.htm?columnType=news&newsId=${news.id}" target="_blank">
			                            	${mtag:cutString(news.title,21,'...')}
	                                    </a>
                                	</div>
                                	<div class="date">
                                		<fmt:formatDate value="${news.editeTime}" pattern="MM/dd" />
                                	</div>
                            	</li>
                    		</c:forEach>
                    	</ul>
                    </div>
                </div>
            </div>
        </div>
        <div class="clear"></div>
        <div id="container_2">
        	<div id="container_2L" class="container_L">
            	<div class="banner_white_style">
                	<div class="banner_gray_style_title">
                		<!-- 图片新闻 -->
	                   	<c:if test="${not empty map.row2column1}">
                        	${map.row2column1.enterpriseColumn.names}
                        </c:if>
						<c:if test="${empty map.row2column1}">
				         	模块row2column1
				        </c:if>
                	</div>
                    <div class="banner_more2">
                    	<a href="${map.row2column1.enterpriseColumn.linkUrl}">more</a>
                    </div>
                </div>
                <div class="clear"></div>
                <div id="container_2L_infowrap">
                	<div id="container_2L_info_L"><img id="lastButton" src="${ctx}/jsps/theme/${webSite.webSkin.filename}/image/newsLast.gif" onclick="lxfLast();" /></div>
                    <div id="container_2L_info_C" >
                    	<div id="container_2L_info_C_img" class="lxfscroll">
                        	<ul>
                        		<c:forEach var="news" items="${map.row2column1.enterprisePhotoNewsList}" begin="0" end="3">
                        			<li><a href="${ctx}/navigation.htm?columnType=news&newsId=${news.id}"><img src="${ctx}/upload/enterprice/${news.photo}" /></a></li>
								</c:forEach>
                            </ul>
                        </div>
                        <div id="container_2L_info_C_text" class="textscroll">
                        	<ul>
                        		<c:forEach var="news" items="${map.row2column1.enterpriseNewsList}" begin="0" end="3">
                    				<li>
		                            	${mtag:cutString(news.shortMeta,38,'...')}
	                            	</li>
                    			</c:forEach>
                            </ul>
                        </div>
                    </div>
                    <div id="container_2L_info_R"><img id="nextButton" src="${ctx}/jsps/theme/${webSite.webSkin.filename}/image/newsNext.gif" onclick="lxfNext();"/></div>
                </div>
            </div>
            <div id="container_2C" class="container_C">
            	<div class="banner_green_style2">
                	<div class="banner_green_style_titlewrap2">
                    	<div class="banner_green_style_title2">
                    		<!-- 综合新闻 -->
		                   	<c:if test="${not empty map.row2column2}">
	                        	${map.row2column2.enterpriseColumn.names}
	                        </c:if>
							<c:if test="${empty map.row2column2}">
					         	模块row2column2
					        </c:if>
                    	</div>
                    </div>
                    <div class="banner_more2">
                    	<a href="${map.row2column2.enterpriseColumn.linkUrl}">more</a>
                    </div>
                </div>
                <div id="container_2C_infowrap">
                	<div class="container_C_newslist">
                        <ul>
                        	<c:forEach var="news" items="${map.row2column2.enterpriseNewsList}" begin="0" end="9">
                    			<li>
                    				<div class="orangeicon"><img src="${ctx}/jsps/theme/${webSite.webSkin.filename}/image/orangeicon.gif"></div>
                                	<div class="container_C_newslist_headline">
                                		<a href="${ctx}/navigation.htm?columnType=news&newsId=${news.id}" target="_blank">
			                            	${mtag:cutString(news.title,24,'...')}
	                                    </a>
                                	</div>
                                	<div class="date">
                                		<fmt:formatDate value="${news.editeTime}" pattern="MM/dd" />
                                	</div>
                            	</li>
                    		</c:forEach>
                        </ul>
                    </div>
                </div>
            </div>
            <div id="container_2R" class="container_R">
            	<div class="banner_green_style2">
                	<div class="banner_green_style_titlewrap2">
                    	<div class="banner_green_style_title2">
                    		<!-- 科学研究动态 -->
		                   	<c:if test="${not empty map.row2column3}">
	                        	${map.row2column3.enterpriseColumn.names}
	                        </c:if>
							<c:if test="${empty map.row2column3}">
					         	模块row2column3
					        </c:if>
                    	</div>
                    </div>
                    <div class="banner_more2">
                    	<a href="${map.row2column3.enterpriseColumn.linkUrl}">more</a>
                    </div>
                </div>
                 <div id="container_2R_infowrap">
                	<div class="container_R_newslist">
                        <ul>
                        	<c:forEach var="news" items="${map.row2column3.enterpriseNewsList}" begin="0" end="9">
                    			<li>
                    				<div class="orangeicon"><img src="${ctx}/jsps/theme/${webSite.webSkin.filename}/image/orangeicon.gif"></div>
                                	<div class="container_R_newslist_headline">
                                		<a href="${ctx}/navigation.htm?columnType=news&newsId=${news.id}" target="_blank">
			                            	${mtag:cutString(news.title,13,'...')}
	                                    </a>
                                	</div>
                                	<div class="date">
                                		<fmt:formatDate value="${news.editeTime}" pattern="MM/dd" />
                                	</div>
                            	</li>
                    		</c:forEach>
                    	</ul>
                	</div>
            	</div>
            </div>
        </div>
        <div class="clear"></div>
        <div id="container_3">
        	<div id="container_3L"><a href=""><img src="${ctx}/jsps/theme/${webSite.webSkin.filename}/image/20130105174447.jpg" /></a></div>
            <div id="container_3C"><a href=""><img src="${ctx}/jsps/theme/${webSite.webSkin.filename}/image/20130105174448.jpg" /></a></div>
            <div id="container_3R"><a href=""><img src="${ctx}/jsps/theme/${webSite.webSkin.filename}/image/20130105174449.jpg" /></a></div>
        </div>
        <div class="clear"></div>
        <div id="container_4">
        	<div id="container_4L"><a href=""><img src="${ctx}/jsps/theme/${webSite.webSkin.filename}/image/20130105174450.jpg" /></a></div>
            <div id="container_4C"><a href=""><img src="${ctx}/jsps/theme/${webSite.webSkin.filename}/image/20130105174451.jpg" /></a></div>
            <div id="container_4R"><a href=""><img src="${ctx}/jsps/theme/${webSite.webSkin.filename}/image/20130105174452.jpg" /></a></div>
        </div>
        <div class="clear"></div>
        <div id="container_5">
        	<div id="container_5L" class="container_L">
            	<div class="banner_white_style">
                	<div class="banner_gray_style_title">
                		<!-- 环评公众参与公示 -->
	                   	<c:if test="${not empty map.row5column1}">
                        	${map.row5column1.enterpriseColumn.names}
                        </c:if>
						<c:if test="${empty map.row5column1}">
				         	模块row5column1
				        </c:if>
                	</div>
                    <div class="banner_more2">
                    	<a href="${map.row5column1.enterpriseColumn.linkUrl}">more</a>
                    </div>
                </div>
                <div id="container_5L_infowrap">
                	<div class="container_L_newslist">
                    	<ul>
                    		<c:forEach var="news" items="${map.row5column1.enterpriseNewsList}" begin="0" end="9">
                    			<li>
                                	<div class="container_L_newslist_headline">
                                		<a href="${ctx}/navigation.htm?columnType=news&newsId=${news.id}" target="_blank">
			                            	${mtag:cutString(news.title,9,'...')}
	                                    </a>
                                	</div>
                                	<div class="date">
                                		<fmt:formatDate value="${news.editeTime}" pattern="MM/dd" />
                                	</div>
                            	</li>
                    		</c:forEach>
                        </ul>
                    </div>
                </div>
            </div>
            <div id="container_5C" class="container_C">
            	<div class="banner_green_style2">
                	<div class="banner_green_style_titlewrap2">
                    	<div class="banner_green_style_title2">
                    		<!-- 廉政建设 -->
		                   	<c:if test="${not empty map.row5column2}">
	                        	${map.row5column2.enterpriseColumn.names}
	                        </c:if>
							<c:if test="${empty map.row5column2}">
					         	模块row5column2
					        </c:if>
                    	</div>
                    </div>
                    <div class="banner_more2">
                    	<a href="${map.row5column2.enterpriseColumn.linkUrl}">more</a>
                    </div>
                </div>
                <div id="container_5C_infowrap">
                	<div class="container_C_newslist">
                        <ul>
                        	<c:forEach var="news" items="${map.row5column2.enterpriseNewsList}" begin="0" end="9">
                    			<li>
                    				<div class="orangeicon"><img src="${ctx}/jsps/theme/${webSite.webSkin.filename}/image/orangeicon.gif"></div>
                                	<div class="container_C_newslist_headline">
                                		<a href="${ctx}/navigation.htm?columnType=news&newsId=${news.id}" target="_blank">
			                            	${mtag:cutString(news.title,24,'...')}
	                                    </a>
                                	</div>
                                	<div class="date">
                                		<fmt:formatDate value="${news.editeTime}" pattern="MM/dd" />
                                	</div>
                            	</li>
                    		</c:forEach>
                        </ul>
                    </div>
                </div>
            </div>
            <div id="container_5R" class="container_R">
            	<div class="banner_green_style2">
                	<div class="banner_green_style_titlewrap2">
                    	<div class="banner_green_style_title2">
                    		<!-- 技术服务动态 -->
		                   	<c:if test="${not empty map.row5column3}">
	                        	${map.row5column3.enterpriseColumn.names}
	                        </c:if>
							<c:if test="${empty map.row5column3}">
					         	模块row5column3
					        </c:if>
                    	</div>
                    </div>
                    <div class="banner_more2">
                    	<a href="${map.row5column3.enterpriseColumn.linkUrl}">more</a>
                    </div>
                </div>
                 <div id="container_5R_infowrap">
                	<div class="container_R_newslist">
                        <ul>
                        	<c:forEach var="news" items="${map.row5column3.enterpriseNewsList}" begin="0" end="9">
                    			<li>
                    				<div class="orangeicon"><img src="${ctx}/jsps/theme/${webSite.webSkin.filename}/image/orangeicon.gif"></div>
                                	<div class="container_R_newslist_headline">
                                		<a href="${ctx}/navigation.htm?columnType=news&newsId=${news.id}" target="_blank">
			                            	${mtag:cutString(news.title,13,'...')}
	                                    </a>
                                	</div>
                                	<div class="date">
                                		<fmt:formatDate value="${news.editeTime}" pattern="MM/dd" />
                                	</div>
                            	</li>
                    		</c:forEach>
                    	</ul>
                	</div>
            	</div>
            </div>
        </div>
        <div class="clear"></div>
        <div id="container_6"><a href=""><img src="${ctx}/jsps/theme/${webSite.webSkin.filename}/image/20130105174453.jpg" /></a></div>
        <div class="clear"></div>
    </div>
     <!--container right end-->

<%@ include file="/jsps/modules/copyRight.jsp"%>