<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>create user</title>
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/CSS/style.css">
		
	</head>
	<body>
		<h1>Add User</h1>
		<div class="centerDisplay" id="Add new Customer">
			<form class="adding" action="<%=request.getContextPath()%>/servlet" target="center">
				<p class="hash">*</p><input type="text" name="Name" placeholder="Name" required>
				<p class="hash">*</p><input type="date" name="DOB" placeholder="Date of birth" max="2012-01-01" required>
				<p class="hash">*</p><input type="tel" name="Phone Number" placeholder="Phone Number" required>
				<input type="email" name="email" placeholder="Email">
				<p class="hash">*</p><input type="password" name="Password" placeholder="Password" required>
				<input type="text" name="Address" placeholder="Address">
				<p class="hash">*</p><input type="text" name="PAN ID" placeholder="PAN ID" required>
				<p class="hash">*</p><input type="number" name="Aadar ID" placeholder="Aadar ID" required>
				<p class="error">${ Error }</p>
				<button class="formSubmit" name="newUser">Submit</button>
			</form>
		</div>
	</body>
</html>