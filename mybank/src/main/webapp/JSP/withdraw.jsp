<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Withdraw</title>
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/CSS/style.css">
	</head>
	<body>
		<div class="centerDisplay" id="withdraw">
			<form class="adding" action="<%=request.getContextPath()%>/servlet" target="center">
				<h1>Withdraw</h1>
				<label for="accountNumbers">choose an account number</label>
				<select name="withdrawAcc">
					<c:forEach var="hm" items="${myAccounts}">
						<option value="${hm.key}">${hm.key}</option>
					</c:forEach>
				</select><br>
				<label for="Amount">Amount : </label>
				<input type="number" name="Amount" placeholder="Enter the Amount" min=0 required>
				<p style="text-align:center">${ Error }</p>
				<button name="withdraw">Submit</button>
			</form>
		</div>
	</body>
</html>