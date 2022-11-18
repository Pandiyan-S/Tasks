<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>User Login</title>
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/CSS/login.css">
	</head>
	<body>
		<div class="first" id="login">
			<h1>Great Indian Bank</h1>
			<h2>User Login</h2>
			<form action="<%=request.getContextPath()%>/servlet" method="post">
				<div class="enter">	
					<div>
						<label for="UserId">User ID </label>
						<input name="userId" type="number" id="UserId" placeholder="User ID" min=0 required>
					<div>
					</div>
						<label for="Password">Password </label>
						<input name="password" type="password" id="Password" placeholder="Password" required>
					</div>
				</div>
			<p style="text-align:center">${ Error }</p>
			<div class="login" id="input" style = "position:absolute; left:45%;" >
				<button value="login" name="action">Login</button>
			</div>
			</form>
		</div>
	</body>
</html>