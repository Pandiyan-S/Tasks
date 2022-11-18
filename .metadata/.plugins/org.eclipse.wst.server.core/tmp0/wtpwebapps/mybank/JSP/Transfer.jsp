<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Transfer</title>
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/CSS/style.css">
	</head>
	<body>
		<div class="centerDisplay" id="withdraw">
			<form class="adding" action="<%=request.getContextPath()%>/servlet" target="center">
				<h1>Transfer</h1>
				<label for="fromAccount">From account : </label>
				<select name="transferAcc">
					<c:forEach var="hm" items="${myAccounts}">
						<option value="${hm.key}">${hm.key}</option>
					</c:forEach>
				</select><br>
				<label for="toAccount">To account : </label>
				<input type="text" name="toAccount" placeholder="Enter the recievers account" required><br>	
				<label for="Amount">Amount : </label>
				<input type="number" name="transferAmount" placeholder="Enter the Amount" min=0 required>
				<p style="text-align:center">${ Error }</p><br>
				<button name="transfer">Submit</button>
			</form>
		</div>	
	</body>
</html>