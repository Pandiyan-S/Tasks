<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>My accounts</title>
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/CSS/style.css">
	</head>
	<body>
		<div class="centerDisplay" id="Accounts">
			<h1>My Accounts</h1>
			<form action="<%=request.getContextPath()%>/servlet" target="center">
				<table>
					<tr>
						<th>Account Number</th>
						<th>Branch</th>
						<th>Account Type</th>
						<th>Balance</th>
					</tr>
					<c:forEach var="hm" items="${myAccounts}">
						<tr>
							<td><button value="${hm.key}" name="myAccounts">${hm.key}</button></td>
							<td><button value="${hm.key}" name="myAccounts">${hm.value.getBranch()}</button></td>
							<td><button value="${hm.key}" name="myAccounts">${hm.value.getAccountType()}</button></td>
							<td><button value="${hm.key}" name="myAccounts">${hm.value.getBalance()}</button></td>
						</tr>
					</c:forEach>
				</table>
			</form>
			<p class="error">${ Error }</p>
		</div>
	</body>
</html>