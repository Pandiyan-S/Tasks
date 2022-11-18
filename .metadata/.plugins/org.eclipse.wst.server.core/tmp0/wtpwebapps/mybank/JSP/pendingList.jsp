<%@page import="java.util.Map"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>pending list</title>
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/CSS/style.css">
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	</head>
	<body>
		<h1>Pending Transaction List</h1>
		<div class="centerDisplay" id="Transactions">
			<form action="<%=request.getContextPath()%>/servlet" target="center">
				<table>
					<tr>
						<th>Transaction ID</th>
						<th>Account Number</th>
						<th>Amount</th>
						<th>Mode</th>
						<th>Time</th>
						<th>Type</th>
						<th>Status</th>
						<th>Action</th>
					</tr>
					<c:forEach var="hm" items="${pendingHm}" >
					<jsp:useBean id="transactionDate" class="java.util.Date"/>
					<c:set target="${transactionDate}" property="time" value="${hm.value.getTime()}"/>
						<tr>
							<td>${hm.key}</td>
							<td>${hm.value.getAccountNumber()}</td>
							<td>${hm.value.getAmount()}</td>
							<td>${hm.value.getModeOfTransaction()}</td>
							<td><fmt:formatDate value="${transactionDate}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
							<td>${hm.value.getCreditOrDebit()}</td>
							<td>${hm.value.getApproval()}</td>
							<td><button value="${hm.value.getTransaction_id()}" name="approve" style="width:40%;color:green;">
								<i class="fa fa-check" aria-hidden="true"></i>
							</button>
							<button value="${hm.value.getTransaction_id()}" name="deny" style="width:40%;color:red;">
								<i class="fa fa-times" aria-hidden="true"></i>
							</button></td>
						</tr>
					</c:forEach>
				</table>
			</form>
			<p class="error">${ Error }</p>
		</div>
	</body>
</html>