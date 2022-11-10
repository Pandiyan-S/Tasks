<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Menu</title>
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/CSS/menu.css">
	</head>
	<body>
		<h1>Welcome ${customerInfo.getName()}</h1>
		<form action="<%=request.getContextPath()%>/servlet" target="center">
			<div style="display:block;">
				<button type="submit" value="customerHome" name="action">Home</button><br>
				<button type="submit" value="Accounts" name="action">Accounts</button><br>
				<button type="submit" value="deposit" name="action">Deposit</button><br>
				<button type="submit" value="withdraw" name="action">Withdraw</button><br>
				<button type="submit" value="transfer" name="action">Transfer</button><br>
			</div>
		</form>
	</body>
</html>