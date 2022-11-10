<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Customer</title>
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/CSS/top.css">
	</head>
	<body>
		<header>
			<div class="top">	
				<div class="dropdown">
					<button class="circle"><img class="circle" alt="user" src="Images/profile.png"/></button>
					<div class="droppedList">
					   <form action="<%=request.getContextPath()%>/servlet" target="center">
						   <button class="btn" value="customerProfile" type="submit" name="action" class="droppedList">My Profile</button>
					    </form>
					    <form action="<%=request.getContextPath()%>/servlet" target="center">
						   <button class="btn" value="changePassword" type="submit" name="action" class="droppedList">Change Password</button>
					    </form>
					    <form action="<%=request.getContextPath()%>/servlet" method="post" target="_parent">
					    	<button class="btn" value="logout" type="submit" name="action" class="droppedList">Logout</button>
					    </form>
					</div>
				</div>
				<div>
					<img class="logo" src="Images/banklogo.png"/>
				</div>
				<div class="bank">
					<h1>Great Indian Bank</h1>
				</div>
			</div>
		</header>
		<div class="main" id="iframe page">
			<iframe src="JSP/menu.jsp" name="Menu" height="850px" width="15%" style="border:none; top:100px;">menu</iframe>
			<iframe src="JSP/customerHome.jsp" name="center" height="850px" width="84%" style="border:none; top:100px; ">home</iframe>
		</div>
	</body>
</html>