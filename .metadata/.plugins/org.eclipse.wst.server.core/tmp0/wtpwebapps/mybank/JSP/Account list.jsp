<%@page import="java.util.Map"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>account list</title>
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/CSS/style.css">
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
		<style type="text/css">
			.search:hover
			{
				color:maroon;
			}
		</style>
	</head>
	<body>
		<h1>Customer Accounts</h1>
		<div class="centerDisplay" id="Customer Accounts">
			<form action="<%=request.getContextPath()%>/servlet" target="center">
				<div class="inline" style="float:right;margin-right:5%">
					<input class="box" type="number" name="ID" placeholder="Customer ID" min=0>
					<button class="search" style="height:30px;background-color:transparent" type="submit" name="particularAcc"><i class="fa fa-search"></i></button>
				</div>
				<p class="error">${ Error }</p>
				<table class="${disp}">
					<tr>
						<th>Customer Id</th>
						<th>Account Number</th>
						<th>Branch</th>
						<th>Account Type</th>
						<th>Balance</th>
						<th>Account status</th>
					</tr>
					<c:forEach var="hm" items="${accountsListHm}" >
						<c:forEach var="map" items="${hm.value}" >
							<tr>
								<td><button value="${map.key}" name="customerStatement">${hm.key}</button></td>
								<td><button value="${map.key}" name="customerStatement">${map.key}</button></td>
								<td><button value="${map.key}" name="customerStatement">${map.value.getBranch()}</button></td>
								<td><button value="${map.key}" name="customerStatement">${map.value.getAccountType()}</button></td>
								<td><button value="${map.key}" name="customerStatement">${map.value.getBalance()}</button></td>
								<td><button value="${map.key}" name="customerStatement">${map.value.getState()}</button></td>
							</tr>
						</c:forEach>
					</c:forEach>
				</table>
			</form>
		</div>
	</body>
</html>