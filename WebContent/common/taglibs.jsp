<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="mtag" uri="http://www.messcat.com/taglib/mtag" %>
<%@ taglib uri="http://java.fckeditor.net" prefix="FCK" %>
<%@ page import="org.springframework.security.ui.AbstractProcessingFilter"%>
<%@ page import="org.springframework.security.ui.webapp.AuthenticationProcessingFilter"%>
<%@ page import="org.springframework.security.AuthenticationException"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<c:set var="imagePath" value="${ctx}/jsps/theme/${webSite.webSkin.filename}/image" />
<c:set var="jsPath" value="${ctx}/jsps/theme/${webSite.webSkin.filename}/js" />
<c:set var="uploadPath" value="${ctx}/upload/enterprice" />
<c:set var="uploadImgPath" value="${ctx}/upload/enterprice/head_img" />
<c:set var="uploadBannerPath" value="${ctx}/upload/enterprice/banner" />
<c:set var="uploadNewsPath" value="${ctx}/upload/enterprice/news" />
<c:set var="uploadProductPath" value="${ctx}/upload/enterprice/product" />
<c:set var="uploadVideoPath" value="${ctx}/upload/enterprice/video" />
<c:set var="projectname" value="jyu" />
<c:set var="cssPath_front" value="${ctx}/${projectname}/theme/css" />
<c:set var="fontsPath_front" value="${ctx}/${projectname}/theme/fonts" />
<c:set var="imagePath_front" value="${ctx}/${projectname}/theme/images" />
<c:set var="imgPath_front" value="${ctx}/${projectname}/theme/img" />
<c:set var="jsPath_front" value="${ctx}/${projectname}/theme/js" />