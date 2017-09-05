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
 	String fileName="订单信息.xls";
	response.setContentType("application/vnd.ms-excel;charset=UTF-8");
   	response.setHeader("Content-disposition","attachment; filename= "+ new String( fileName.getBytes("gb2312"), "ISO8859-1")+"");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>订单信息</title>
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
									<th>订单编号</th>
									<th>添加时间</th>
									<th>支付时间</th>
									<th>状态</th>
									<th>订单金额</th>
									<th>已开票</th>
								</tr>
			</thead>
			      <c:forEach var="bean" items="${orders}">
						<tr>
								<td>'${bean.orderSn}</td>
								<td>
									<fmt:formatDate value="${bean.addTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
								</td>
								<td>
									<fmt:formatDate value="${bean.payTime}" pattern="yyyy-MM-dd"/>
								</td>
								<td>
									<c:choose>
										<c:when test="${bean.status eq '0'}">未付款</c:when>
										<c:when test="${bean.status eq '1'}">已付款</c:when>
										<c:otherwise>已退款</c:otherwise>
									</c:choose>
								</td>
								<td>
									${bean.totalAmount}
								</td>
								<td>
									<c:choose>
										<c:when test="${bean.isInvoice eq '0'}">否</c:when>
										<c:otherwise>是</c:otherwise>
									</c:choose>
								</td>
								
						</tr>
					</c:forEach>
		</table>
	</body>
</html>