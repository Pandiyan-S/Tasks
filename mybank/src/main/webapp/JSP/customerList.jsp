<%@page import="java.util.Map"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Customer list</title>
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/CSS/style.css">
	</head>
	<body>
		<h1>Customers</h1>
		<div class="centerDisplay" id="customers">
			<form action="<%=request.getContextPath()%>/servlet" target="center">
				<table>
					<tr>
						<th>ID</th>
						<th>Name</th>
						<th>Current Status</th>
					</tr>
					<c:forEach var="hm" items="${customerListHm}" >
						<tr>
							<td><button type="submit" value="${hm.key}" name="customerInfo">${hm.key}</button></td>
							<td><button type="submit" value="${hm.key}" name="customerInfo">${hm.value.getName()}</button></td>
							<td><button type="submit" value="${hm.key}" name="customerInfo">${hm.value.getStatus()}</button></td>
						</tr>
					</c:forEach>
				</table>
			</form>
		</div>
	</body>
</html>