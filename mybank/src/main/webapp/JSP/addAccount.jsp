<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Add new Account</title>
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/CSS/style.css">
		<style>
			table
			{
				font-size:28px;
			}
		</style>
	</head>
	<body>
		<h1>Add Account</h1>
		<div class="centerDisplay" id="Add new account">
			<form class="adding" action="<%=request.getContextPath()%>/servlet" target="center">
				<label for="ID">ID</label>
				<p class="hash">*</p><input type="number" name="ID" min=0 required>
				<label for="accountNumber">Account Number</label>
				<p class="hash">*</p><input type="text" name="accountNumber" required>
				<label for="Balance">Balance</label>					
				<p class="hash">*</p><input type="number" name="Balance" min=0 required>
				<label for="Branch">Branch</label>
				<p class="hash">*</p><br>
				<select name="Branch" required>
					<option value="Chennai">Chennai</option>
					<option value="Madurai">Madurai</option>
					<option value="Thichi">Thichi</option>
					<option value="Coiambatore">Coiambatore</option>
					<option value="Karaikudi">Karaikudi</option>
				</select>
				<label for="type">Account type </label>
				<p class="hash">*</p><br>
				<select name="type" required>
					<option value="Chennai">Savings</option>
					<option value="Chennai">FD</option>
					<option value="Chennai">Salary</option>
				</select>
				<p class="error">${ Error }</p>
				<button class="formSubmit" name="newAccount">Submit</button>
			</form>
		</div>
	</body>
</html>