<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Admin profile</title>
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/CSS/style.css">
	</head>
	<body>
		<h1>Admin</h1>
		<div class="centerDisplay" id="Admin profile">
			<table class="profile">
				<tr>
					<td class="sideHead">ID : </td>
					<td>${myInfo.getId()}</td>
				</tr>
				<tr>
					<td class="sideHead">Name : </td>
					<td>${myInfo.getName()}</td>
				</tr>
				<tr>
					<td class="sideHead">DOB : </td>
					<td>${myInfo.getDob()}</td>
				</tr>
				<tr>
					<td class="sideHead">PhoneNumber : </td>
					<td>${myInfo.getPhoneNumber()}</td>
				</tr>
				<tr>
					<td class="sideHead">email : </td>
					<td>${myInfo.getEmail()}</td>
				</tr>
				<tr>
					<td class="sideHead">Address : </td>
					<td>${myInfo.getAddress()}</td>
				</tr>
			</table>
		</div>
	</body>
</html>