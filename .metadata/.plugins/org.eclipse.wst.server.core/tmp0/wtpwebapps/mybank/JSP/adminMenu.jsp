<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Admin menu</title>
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/CSS/menu.css">
	</head>
	<body>
		<h1>Welcome ${myInfo.getName()}</h1>
		<form action="<%=request.getContextPath()%>/servlet" target="center">
			<div style="display:block;">
				<button type="submit" value="adminHome" name="action">Home</button><br>
				<button type="submit" value="customerList" name="action">Customers</button><br>
				<button type="submit" value="pendingList" name="action">Pending List</button><br>
				<button type="submit" value="customerAccounts" name="action">Accounts</button><br>
				<button type="submit" value="addUser" name="action">Add User</button><br>
				<button type="submit" value="addAccount" name="action">Add Account</button><br>
			</div>
		</form>
	</body>
</html>