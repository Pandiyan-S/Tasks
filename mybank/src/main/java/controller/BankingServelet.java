package controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.bankingapplication.AccountDetails;
import model.bankingapplication.Administration;
import model.bankingapplication.Customer;
import model.bankingapplication.CustomerMethods;
import model.bankingapplication.Modules;
import model.bankingapplication.Transaction;
import model.bankingapplication.UserException;
import model.bankingapplication.UserInter;

@WebServlet("/servlet")
public class BankingServelet extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	private int userId;
    public BankingServelet()
    {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		try
		{
			runner(request,response);
		}
		catch (ServletException e)
		{
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		catch (UserException e)
		{
			e.printStackTrace();
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		try
		{
			runner(request,response);
		}
		catch (ServletException e)
		{
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		catch (UserException e)
		{
			e.printStackTrace();
		}
	}
	private void runner(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, UserException
	{
		RequestDispatcher requestDispatcher;
		String choice = request.getParameter("action");
		if(choice == null)
		{
			choice = "";
		}
		Administration admin = new Modules();
		CustomerMethods cust = new Modules();
		HttpSession session = request.getSession(true);
		UserInter logic = new Modules();
		switch(choice)
		{
		case "login":
			userId = Integer.parseInt(request.getParameter("userId"));
			String password = request.getParameter("password");
			String path;
			try
			{
				if(!logic.signIn(userId, password))
				{
					path = "JSP/login.jsp";
					request.setAttribute("Error","The password is invalid");
				}
				else
				{
					session.setAttribute("userId", userId);
					if(logic.userType(userId).equalsIgnoreCase("admin"))
					{
//						session.setAttribute("customerListHm", admin.showAllCustomers());
						session.setAttribute("myInfo", admin.showAdminProfile(userId));
						admin.adminLogin(userId);
						path = "JSP/admin.jsp";
					}
					else
					{
						session.setAttribute("customerInfo", cust.showCustomerProfile(userId));
//						session.setAttribute("myAccounts",cust.customerAccounts(userId));
						cust.customerLogin(userId);
						path = "JSP/home.jsp";
					}
				}
			}			
			catch (UserException e)
			{
				path = "JSP/login.jsp";
				request.setAttribute("Error","The user id is invalid");
			}
			requestDispatcher = request.getRequestDispatcher(path);
			requestDispatcher.forward(request, response);
			break;
		case "customerList":
			Map<Integer,Customer> customerListHm = admin.showAllCustomers();
			request.setAttribute("customerListHm",customerListHm);
			requestDispatcher = request.getRequestDispatcher("JSP/customerList.jsp");
			requestDispatcher.forward(request, response);
			break;
		case "Accounts":
			Map<String,AccountDetails> myAccounts = cust.customerAccounts(userId);
			request.setAttribute("myAccounts",myAccounts);
			requestDispatcher = request.getRequestDispatcher("JSP/myAccounts.jsp");
			requestDispatcher.forward(request, response);
			break;
		case "customerHome":
			requestDispatcher = request.getRequestDispatcher("JSP/customerHome.jsp");
			requestDispatcher.forward(request, response);
			break;
		case "adminHome":
			requestDispatcher = request.getRequestDispatcher("JSP/adminHome.jsp");
			requestDispatcher.forward(request, response);
			break;
		case "pendingList":
			Map<String,Transaction> pendingHm = admin.pendingList();
			request.setAttribute("pendingHm", pendingHm);
			requestDispatcher = request.getRequestDispatcher("JSP/pendingList.jsp");
			requestDispatcher.forward(request, response);
			break;
		case "customerAccounts":
			Map<Integer,Map<String,AccountDetails>> accountsListHm = admin.getAllAccounts();
			request.setAttribute("accountsListHm", accountsListHm);
			requestDispatcher = request.getRequestDispatcher("JSP/Account list.jsp");
			requestDispatcher.forward(request, response);
			break;
		case "addUser":
			requestDispatcher = request.getRequestDispatcher("JSP/addUser.jsp");
			requestDispatcher.forward(request, response);
			break;
		case "addAccount":
			requestDispatcher = request.getRequestDispatcher("JSP/addAccount.jsp");
			requestDispatcher.forward(request, response);
			break;
		case "myInfo":
//			Admin myInfo = admin.showAdminProfile(userId);
//			request.setAttribute("myInfo", myInfo);
			requestDispatcher = request.getRequestDispatcher("JSP/admin1.jsp");
			requestDispatcher.forward(request, response);
			break;
		case "deposit":
			myAccounts = cust.customerAccounts(userId);
			request.setAttribute("myAccounts",myAccounts);
			requestDispatcher = request.getRequestDispatcher("JSP/deposit.jsp");
			requestDispatcher.forward(request, response);
			break;
		case "withdraw":
			myAccounts = cust.customerAccounts(userId);
			request.setAttribute("myAccounts",myAccounts);
			requestDispatcher = request.getRequestDispatcher("JSP/withdraw.jsp");
			requestDispatcher.forward(request, response);
			break;
		case "transfer":
			myAccounts = cust.customerAccounts(userId);
			request.setAttribute("myAccounts",myAccounts);
			requestDispatcher = request.getRequestDispatcher("JSP/Transfer.jsp");
			requestDispatcher.forward(request, response);
			break;
		case "statement":
			requestDispatcher = request.getRequestDispatcher("JSP/statement.jsp");
			requestDispatcher.forward(request, response);
			break;
		case "customerProfile":
			String caller = "customer";
//			Customer profile = cust.showCustomerProfile(userId);
//			request.setAttribute("customerInfo",profile);
			request.setAttribute("caller",caller);
			requestDispatcher = request.getRequestDispatcher("JSP/customer1.jsp");
			requestDispatcher.forward(request, response);
			break;
		case "changePassword":
			requestDispatcher = request.getRequestDispatcher("JSP/changepassword.jsp");
			requestDispatcher.forward(request, response);
			break;
		case "signout":
			admin.signOut(userId);
			session.invalidate();
			requestDispatcher = request.getRequestDispatcher("JSP/login.jsp");
			requestDispatcher.forward(request, response);
			break;
		case "logout":
			cust.logOut(userId);
			session.invalidate();
			requestDispatcher = request.getRequestDispatcher("JSP/login.jsp");
			requestDispatcher.forward(request, response);
			break;
		}
		String info = request.getParameter("customerInfo");
		if(info != null)
		{
			int id = Integer.parseInt(info);
			String caller = "Admin";
			Customer customerInfo = admin.showParticularProfile(id);
			request.setAttribute("customerInfo",customerInfo);
			request.setAttribute("caller",caller);
			requestDispatcher = request.getRequestDispatcher("JSP/customer1.jsp");
			requestDispatcher.forward(request, response);
		}
		String approve = request.getParameter("approve");
		if(approve != null)
		{
			long transactionId = Long.parseLong(approve);
			try
			{
				admin.giveApproval(transactionId);
			}
			catch(UserException e)
			{
				request.setAttribute("Error",e.getMessage());
			}
			finally
			{
				Map<String,Transaction> pendingHm = admin.pendingList();
				request.setAttribute("pendingHm", pendingHm);
				requestDispatcher = request.getRequestDispatcher("JSP/pendingList.jsp");
				requestDispatcher.forward(request, response);
			}
		}
		String deny = request.getParameter("deny");
		if(deny != null)
		{
			long transactionId = Long.parseLong(deny);
			try
			{
				admin.denyApproval(transactionId);
			}
			catch(UserException e)
			{
				request.setAttribute("Error",e.getMessage());
			}
			finally
			{
				Map<String,Transaction> pendingHm = admin.pendingList();
				request.setAttribute("pendingHm", pendingHm);
				requestDispatcher = request.getRequestDispatcher("JSP/pendingList.jsp");
				requestDispatcher.forward(request, response);
			}
		}
		String statementAccNo = request.getParameter("customerStatement");
		if(statementAccNo != null)
		{
			Map<Long,Transaction> Statement = admin.statement(statementAccNo);
			request.setAttribute("Statement", Statement);
			requestDispatcher = request.getRequestDispatcher("JSP/transactionlist.jsp");
			requestDispatcher.forward(request, response);
		}
		String addCustomer = request.getParameter("newUser");
		if(addCustomer !=null)
		{
			String newName = request.getParameter("Name");
			String newDob = request.getParameter("DOB");
			String newPhone = request.getParameter("Phone Number");
			String newEmail = request.getParameter("email");
			String newAddress = request.getParameter("Address");
			String newPassword = request.getParameter("Password");
			String newPan = request.getParameter("PAN ID");
			String newAadar = request.getParameter("Aadar ID");
			Customer newCustom = new Customer();
			newCustom.setUserType("User");
			newCustom.setName(newName);
			newCustom.setDob(newDob);
			newCustom.setPhoneNumber(Long.parseLong(newPhone));
			newCustom.setEmail(newEmail);
			newCustom.setAddress(newAddress);
			newCustom.setPassword(newPassword);
			newCustom.setPanId(newPan);
			newCustom.setAadarId(Long.parseLong(newAadar));
			newCustom.setStatus("loggedout");
			try
			{
				admin.newCustomer(newCustom);
				request.setAttribute("ID", newCustom.getId());
				request.setAttribute("password", newCustom.getPassword());
				requestDispatcher = request.getRequestDispatcher("JSP/newUserCredentials.jsp");
				requestDispatcher.forward(request, response);
			}
			catch(UserException e)
			{
				request.setAttribute("Error",e.getMessage());
				requestDispatcher = request.getRequestDispatcher("JSP/addUser.jsp");
				requestDispatcher.forward(request, response);
			}
		}
		String addAccount = request.getParameter("newAccount");
		if(addAccount !=null)
		{
			String newId = request.getParameter("ID");
			String newAccountNumber = request.getParameter("accountNumber");
			String newBranch = request.getParameter("Branch");
			String newType = request.getParameter("type");
			String newBalance = request.getParameter("Balance");
			AccountDetails newAccount = new AccountDetails();
			newAccount.setId(Integer.parseInt(newId));
			newAccount.setAccountNumber(newAccountNumber);
			newAccount.setBranch(newBranch);
			newAccount.setAccountType(newType);
			newAccount.setBalance(Float.parseFloat(newBalance));
			newAccount.setState("active");
			try
			{
				admin.newAccount(newAccount);
				request.setAttribute("AccNo", newAccount.getAccountNumber());
				request.setAttribute("Balance", newAccount.getBalance());
				requestDispatcher = request.getRequestDispatcher("JSP/newAccountCredentials.jsp");
				requestDispatcher.forward(request, response);
			}
			catch(UserException e)
			{
				request.setAttribute("Error",e.getMessage());
				requestDispatcher = request.getRequestDispatcher("JSP/addAccount.jsp");
				requestDispatcher.forward(request, response);
			}
		}
		String change = request.getParameter("changePassword");
		if(change!=null)
		{
			String oldPassword = request.getParameter("oldPassword");
			String newPassword = request.getParameter("newPassword");
			String newPassword2 = request.getParameter("newPassword2");
			if(!newPassword.equals(newPassword2))
			{
				request.setAttribute("Error","re-entered password does not match new password");
			}
			else if(admin.changePassword(userId, oldPassword, newPassword))
			{
				request.setAttribute("Error", "Password changed");
			}
			else
			{
				request.setAttribute("Error", "Old Password is invalid");
			}
			requestDispatcher = request.getRequestDispatcher("JSP/changepassword.jsp");
			requestDispatcher.forward(request, response);
		}
		String myAccount = request.getParameter("myAccounts");
		if(myAccount != null)
		{
			try
			{
				Map<Long,Transaction> statement = cust.statement(userId, myAccount);
				request.setAttribute("Statement", statement);
				requestDispatcher = request.getRequestDispatcher("JSP/transactionlist.jsp");
				requestDispatcher.forward(request, response);
			}
			catch(UserException e)
			{
				request.setAttribute("Error",e.getMessage());
				requestDispatcher = request.getRequestDispatcher("JSP/myAccounts.jsp");
				requestDispatcher.forward(request, response);
			}
		}
		String deposit = request.getParameter("deposit");
		if(deposit != null)
		{
			int amount = Integer.parseInt(request.getParameter("Amount"));
			String depositAcc = request.getParameter("depositAcc");
			try
			{
				cust.deposit(userId, depositAcc, amount);
				request.setAttribute("Error","Transaction Successfull");
			}
			catch(UserException e)
			{
				request.setAttribute("Error",e.getMessage());
			}
			finally
			{
				Map<String, AccountDetails> myAccounts = cust.customerAccounts(userId);
				request.setAttribute("myAccounts",myAccounts);
				requestDispatcher = request.getRequestDispatcher("JSP/deposit.jsp");
				requestDispatcher.forward(request, response);
			}
		}
		String withdraw = request.getParameter("withdraw");
		if(withdraw != null)
		{
			int amount = Integer.parseInt(request.getParameter("Amount"));
			String withdrawAcc = request.getParameter("withdrawAcc");
			try
			{
				cust.withdraw(userId, withdrawAcc, amount);
				if(amount<1000)
				{
					request.setAttribute("Error","Transaction Successfull");
				}
				else
				{
					request.setAttribute("Error","Transaction pending approval");
				}
			}
			catch(UserException e)
			{
				request.setAttribute("Error",e.getMessage());
			}
			finally
			{
				Map<String, AccountDetails> myAccounts = cust.customerAccounts(userId);
				request.setAttribute("myAccounts",myAccounts);
				requestDispatcher = request.getRequestDispatcher("JSP/withdraw.jsp");
				requestDispatcher.forward(request, response);
			}
		}
		String transfer = request.getParameter("transfer");
		if(transfer != null)
		{
			float amount = Float.parseFloat(request.getParameter("transferAmount"));
			String reciverAcc = request.getParameter("toAccount");
			String transferAcc = request.getParameter("transferAcc");
			try
			{
				cust.transfer(userId, transferAcc, reciverAcc, amount);
				request.setAttribute("Error", "Transaction Successful");
			}
			catch(UserException e)
			{
				request.setAttribute("Error", e.getMessage());
			}
			finally
			{
				Map<String, AccountDetails> myAccounts = cust.customerAccounts(userId);
				request.setAttribute("myAccounts",myAccounts);
				requestDispatcher = request.getRequestDispatcher("JSP/Transfer.jsp");
				requestDispatcher.forward(request, response);
			}
		}
		String edit = request.getParameter("edit");
		if(edit != null)
		{
			String newName = request.getParameter("Name");
			String newDob = request.getParameter("DOB");
			String newPhone = request.getParameter("Phone Number");
			String newEmail = request.getParameter("email");
			String newAddress = request.getParameter("Address");
			String newPassword = request.getParameter("Password");
			String newPan = request.getParameter("PAN ID");
			String newAadar = request.getParameter("Aadar ID");
			Customer newCustom = new Customer();
			newCustom.setUserType("User");
			newCustom.setName(newName);
			newCustom.setDob(newDob);
			newCustom.setPhoneNumber(Long.parseLong(newPhone));
			newCustom.setEmail(newEmail);
			newCustom.setAddress(newAddress);
			newCustom.setPassword(newPassword);
			newCustom.setPanId(newPan);
			newCustom.setAadarId(Long.parseLong(newAadar));
			newCustom.setStatus("loggedout");
			if(newCustom.equals(admin.showParticularProfile(userId)))
			{
				request.setAttribute("Error","No change made");
			}
			int amount = Integer.parseInt(request.getParameter("Amount"));
			String withdrawAcc = request.getParameter("withdrawAcc");
			try
			{
				cust.withdraw(userId, withdrawAcc, amount);
				if(amount<1000)
				{
					request.setAttribute("Error","Transaction Successfull");
				}
				else
				{
					request.setAttribute("Error","Transaction pending approval");
				}
			}
			catch(UserException e)
			{
				request.setAttribute("Error",e.getMessage());
			}
			finally
			{
				Map<String, AccountDetails> myAccounts = cust.customerAccounts(userId);
				request.setAttribute("myAccounts",myAccounts);
				requestDispatcher = request.getRequestDispatcher("JSP/withdraw.jsp");
				requestDispatcher.forward(request, response);
			}
		}
		String part = request.getParameter("particularAcc");
		if(part != null)
		{
			int id = Integer.parseInt(request.getParameter("ID"));
			try
			{
				Map<String, AccountDetails> accounts = admin.getCustomerAccounts(id);
				if(accounts.isEmpty())
				{
					request.setAttribute("disp","hide");
					request.setAttribute("Error","The entered id does not have any accounts");
				}
				else
				{
					Map<Integer,Map<String,AccountDetails>> accountsListHm = new HashMap<Integer,Map<String,AccountDetails>>();
					accountsListHm.put(id, accounts);
					request.setAttribute("accountsListHm",accountsListHm);
					request.setAttribute("disp","show");
				}
			}
			catch(UserException e)
			{
				request.setAttribute("disp","hide");
				request.setAttribute("Error",e.getLocalizedMessage());
			}
			finally
			{
				requestDispatcher = request.getRequestDispatcher("JSP/Account list.jsp");
				requestDispatcher.forward(request, response);
			}
		}
	}
}