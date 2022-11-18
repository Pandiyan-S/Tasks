<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Customer Info</title>
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/CSS/style.css">
		<style>
		.customer{
		 display:none;
		}
		</style>
	</head>
	<body>
		<h1>Customers</h1>
		<div class="centerDisplay" id="Customer profile">
			<form>
				<table class="profile">
					<tr>
						<td class="sideHead">ID : </td>
						<td><input type="number" value="${customerInfo.getId()}" name="id" readonly></td>
					</tr>
					<tr>
						<td class="sideHead">Name : </td>
						<td><input type="text" value="${customerInfo.getName()}" name="Name"></td>
					</tr>
					<tr>
						<td class="sideHead">DOB : </td>
						<td><input type="date" value="${customerInfo.getDob()}" name="DOB"></td>
					</tr>
					<tr>
						<td class="sideHead">PhoneNumber : </td>
						<td><input type="number" value="${customerInfo.getPhoneNumber()}" name="Phone Number"></td>
					</tr>
					<tr>
						<td class="sideHead">email : </td>
						<td><input type="email" value="${customerInfo.getEmail()}" name="email"></td>
					</tr>
					<tr>
						<td class="sideHead">Address : </td>
						<td><input type="text" value="${customerInfo.getAddress()}" name="Address"></td>
					</tr>
					<tr>
						<th class="sideHead">PAN ID : </th>
						<td><input type="number" value="${customerInfo.getPanId()}" name="PAN ID"></td>
					</tr>
					<tr>
						<th class="sideHead">Aadar ID : </th>
						<td><input type="number" value="${customerInfo.getAadarId()}" name="Aadar ID"></td>
					</tr>
					<tr class="${caller}">
						<th class="sideHead">Current Status :</th>
						<td><input type="number" value="${customerInfo.getStatus()}" name="Status" readonly></td>
					</tr>
				</table>
				<p class="error">${ Error }</p>
				<button class="formSubmit" name="edit">Submit</button>
			</form>
		</div>
	</body>
</html>