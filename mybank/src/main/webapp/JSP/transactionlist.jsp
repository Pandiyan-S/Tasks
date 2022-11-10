<%@page import="java.util.Map"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/CSS/style.css">
	</head>
	<body>
		<h1>Transaction List</h1>
		<div class="centerDisplay" id="Transactions">
			<table>
				<tr>
					<th>ID</th>
					<th>Account Number</th>
					<th>Amount</th>
					<th>Mode</th>
					<th>Time</th>
					<th>Transaction Account</th>
					<th>Type</th>
					<th>Status</th>
				</tr>
				<c:forEach var="hm" items="${Statement}" >
				<jsp:useBean id="transactionDate" class="java.util.Date"/>
				<c:set target="${transactionDate}" property="time" value="${hm.value.getTime()}"/>
					<tr>
						<td>${hm.key}</td>
						<td>${hm.value.getAccountNumber()}</td>
						<td>${hm.value.getAmount()}</td>
						<td>${hm.value.getModeOfTransaction()}</td>
						<td><fmt:formatDate value="${transactionDate}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
						<td>${hm.value.getToAccount()}</td>
						<td>${hm.value.getCreditOrDebit()}</td>
						<td>${hm.value.getApproval()}</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</body>
</html>