<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>admin</title>
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/CSS/top.css">
	</head>
	<body>
		<header>
			<div class="top">	
				<div class="dropdown">
					<button class="circle"><img class="circle" alt="user" src="Images/profile.png"/></button>
					<div class="droppedList">
					   <form action="<%=request.getContextPath()%>/servlet" target="center">
						   <button class="btn" value="myInfo" type="submit" name="action" class="droppedList">My Profile</button>
					    </form>
					    <form action="<%=request.getContextPath()%>/servlet" target="center">
						   <button class="btn" value="changePassword" type="submit" name="action" class="droppedList">Change Password</button>
					    </form>
					    <form action="<%=request.getContextPath()%>/servlet" method="post" target="_parent">
					    	<button class="btn" value="signout" type="submit" name="action" class="droppedList">Logout</button>
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
			<!-- <iframe src="JSP/top.jsp" name="top" height="200px" width="100%" style="border:none;"></iframe> -->
			<iframe src="JSP/adminMenu.jsp" name="Menu" height="850px" width="15%" style="border:none;">menu</iframe>
			<iframe src="JSP/adminHome.jsp" name="center" height="850px" width="84%" style="border:none;">home</iframe>
		</div>
	</body>
</html>