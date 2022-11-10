<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>change password</title>
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/CSS/style.css">
	</head>
	<body>
		<h1>Change Password</h1>
		<div class="centerDisplay" id="change password">
			<form class="adding" action="<%=request.getContextPath()%>/servlet" target="center">
				<label for="old password">Old Password : </label>
				<input type="password" name="oldPassword" required><br><br>
				<label for="new password">New Password : </label>
				<input type="password" name="newPassword" required><br><br>
				<label for="new password2">Re-enter Password : </label>
				<input type="password" name="newPassword2" required><br><br>
				<p class="error">${ Error }</p>
				<button class="formSubmit" name="changePassword">Submit</button>
			</form>
		</div>
	</body>
	
</html>