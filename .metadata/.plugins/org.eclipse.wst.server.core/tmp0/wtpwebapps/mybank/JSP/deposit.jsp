<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Deposit</title>
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/CSS/style.css">
	</head>
	<body>
		<div class="centerDisplay" id="deposit">
			<form class="adding" action="<%=request.getContextPath()%>/servlet" target="center">
				<h1>Deposit</h1>
				<label for="accountNumbers">choose an account number</label>
				<select name="depositAcc">
					<c:forEach var="hm" items="${myAccounts}">
						<option value="${hm.key}">${hm.key}</option>
					</c:forEach>
				</select><br>
				<label for="Amount">Amount : </label>
				<input type="number" name="Amount" placeholder="Enter the Amount" min=0 required>
				<p class="error">${ Error }</p>
				<button name="deposit">Submit</button>
			</form>
		</div>
	</body>
</html>