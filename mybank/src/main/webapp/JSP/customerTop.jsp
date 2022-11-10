<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/CSS/top.css">
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	</head>
	<body>
		<div class="top">	
			<div class="dropdown">
				<button style="" class="btn"><i class="fa fa-bars"></i></button>
				<div class="droppedList">
				   <form action="<%=request.getContextPath()%>/servlet" target="center">
					   <button value="customerProfile" type="submit" name="action" class="droppedList">My Profile</button>
				    </form>
				    <form action="<%=request.getContextPath()%>/servlet" target="center">
					   <button value="changePassword" type="submit" name="action" class="droppedList">Change Password</button>
				    </form>
				    <form action="<%=request.getContextPath()%>/servlet" method="post" target="_parent">
				    	<button value="logout" type="submit" name="action" class="droppedList">Logout</button>
				    </form>
				</div>
			</div>
			<h1>Great Indian Bank</h1>
			<img src="https://images.squarespace-cdn.com/content/v1/5e21a4b1d763a90de6f8a722/1606490598077-JPX2V901HSE6LOID2BCT/logga_png.png" alt="GIB logo"/>
		</div>
	</body>
</html>