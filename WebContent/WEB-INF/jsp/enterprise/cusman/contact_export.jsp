<%@page import="com.modules.util.DateHelper"%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%-- <%@ page contentType="application/vnd.ms-excel;charset=gbk"%> --%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="javax.servlet.http.HttpServletResponse"%>
<%@ include file="/common/taglibs.jsp"%>
<%
	//HttpServletResponse response = ServletActionContext.getResponse();
	//SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
 	String fileName="联系人信息.xls";
	response.setContentType("application/vnd.ms-excel;charset=UTF-8");
   	response.setHeader("Content-disposition","attachment; filename= "+ new String( fileName.getBytes("gb2312"), "ISO8859-1")+"");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>联系人信息</title>
		<style>
			.headbg {/*background: #c9e6f5;*/font-weight: bold;padding-left: 15px;height: 30px;}
			.txt{mso-number-format:"\@";}
			.headbg td {font-weight: bold;/* text-align: left; */}
			.footbg td{font-weight: bold;text-align: left;}
			.footbg1 td{text-align: left;}
		</style>
	</head>
	<body>
	<table class="listTable3" onmouseover="changeto()" onmouseout="changeback()" border="1">
			<thead>
								<tr>
									<th>姓名</th>
									<th>手机号码</th>
									<th>性别</th>
									<th>称呼</th>
									<th>所属客户</th>
									<th>所属部门</th>
									<th>所属职位</th>
									<th>添加时间</th>
								</tr>
			</thead>
			      <c:forEach var="bean" items="${contacts}">
						<tr>
								<td>${bean.name}</td>
								<td>${bean.phone}</td>
								<td><c:choose>
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
								
						</tr>
					</c:forEach>
		</table>
	</body>
</html>