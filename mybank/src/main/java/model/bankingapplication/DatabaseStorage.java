package model.bankingapplication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DatabaseStorage implements StoreageLayer
{
	private static Connection connector()
	{
		String url = "jdbc:mysql://localhost:3306/BankingDB";
		String userName = "Task10";
		String password = "Thirsty@Elephant0241";
		Connection connect = null;
		try
		{
			connect = DriverManager.getConnection(url, userName, password);
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return connect;
	}
	private void shutDown(Connection link,PreparedStatement state)
	{
		try
		{
			state.close();
			NullChecker.check(link);
			link.close();
		}
		catch (SQLException e)
		{
			//e.printStackTrace();
		}
		catch (UserException e)
		{
			
		}
	}
	@Override
	public boolean verifyPassword(int id,String password) throws UserException
	{
		boolean truth = false;
		NullChecker.check(password);
		Connection wire = connector();
		PreparedStatement query = null;
		try
		{
			query = wire.prepareStatement("Select Password from UserInfo where ID = ?;");
			query.setInt(1, id);
			String str = "";
			try(ResultSet rset = query.executeQuery())
			{
				rset.next();
				str = rset.getString("Password");
				if(str.equals(password))
				{
					truth = true;
				}
			}
			if(str.isEmpty())
			{
				throw new UserException("Either the password or the User Id is wrong");
			}
			return truth;
		}
		catch(SQLException e)
		{
			throw new UserException(e.getLocalizedMessage(),e);
		}
		finally
		{
			shutDown(wire,query);
		}
	}
	@Override
	public void login(int id) throws UserException
	{
		Connection wire = connector();
		PreparedStatement query = null;
		try
		{
			query = wire.prepareStatement("Update CustomerInfo set Status = 'loggedin' where Id = ?;");
			query.setInt(1, id);
			query.executeUpdate();
		}
		catch(SQLException e)
		{
			throw new UserException(e.getLocalizedMessage(),e);
		}
		finally
		{
			shutDown(wire,query);
		}
	}
	@Override
	public void adminLogin(int id) throws UserException
	{
		Connection wire = connector();
		PreparedStatement query = null;
		try
		{
			query = wire.prepareStatement("Update AdminInfo set Status = 'loggedin' where Id = ?;");
			query.setInt(1, id);
			query.executeUpdate();
		}
		catch(SQLException e)
		{
			throw new UserException(e.getLocalizedMessage(),e);
		}
		finally
		{
			shutDown(wire,query);
		}
	}
	@Override
	public boolean isAdmin(int id)
	{
		boolean truth = false;
		Connection wire = connector();
		PreparedStatement query = null;
		try
		{
			query = wire.prepareStatement("Select User_Type from UserInfo where ID = ?;");
			query.setInt(1, id);
			try(ResultSet rset = query.executeQuery())
			{
				rset.next();
				if(rset.getString("User_Type").equalsIgnoreCase("admin"))
				{
					truth = true;
				}
			}
			return truth;
		}
		catch(SQLException e)
		{
			return false;
		}
		finally
		{
			shutDown(wire,query);
		}
	}
	@Override
	public Map<String,AccountDetails> getAccounts(int id) throws UserException
	{
		Connection wire = connector();
		PreparedStatement query = null;
		try
		{
			query = wire.prepareStatement("Select * from AccountInfo where ID = ?;");
			query.setInt(1, id);
			Map<String,AccountDetails> hm = new HashMap<String,AccountDetails>();
			try(ResultSet rset = query.executeQuery())
			{
				while(rset.next())
				{
					AccountDetails accounts = new AccountDetails();
					accounts.setId(rset.getInt("ID"));
					accounts.setAccountNumber(rset.getString("Account_Number"));
					accounts.setBranch(rset.getString("Branch"));
					accounts.setAccountType(rset.getString("Account_Type"));
					accounts.setBalance(rset.getFloat("Balance"));
					accounts.setState(rset.getString("Account_status"));
					hm.put(accounts.getAccountNumber(), accounts);
				}
			}
			return hm;
		}
		catch(SQLException e)
		{
			throw new UserException(e.getLocalizedMessage(),e);
		}
		finally
		{
			shutDown(wire,query);
		}
	}
	@Override
	public Map<Integer,Customer> getCustomers() throws UserException
	{
		Connection wire = connector();
		PreparedStatement query = null;
		try
		{
			query = wire.prepareStatement("SELECT UserInfo.ID, UserInfo.User_Type, UserInfo.Name, "
					+ "UserInfo.DOB, UserInfo.Phone_number, UserInfo.email, UserInfo.Address, UserInfo.Password, "
					+ "CustomerInfo.Status, CustomerInfo.PAN_ID, CustomerInfo.Aadar_Id FROM UserInfo "
					+ "INNER JOIN CustomerInfo ON UserInfo.ID = CustomerInfo.ID;");
			Map<Integer,Customer> hm = new HashMap<Integer,Customer>();
			try(ResultSet rset = query.executeQuery())
			{
				while(rset.next())
				{
					
					Customer customer = new Customer();
					customer.setId(rset.getInt("ID"));
					customer.setUserType(rset.getString("User_Type"));
					customer.setName(rset.getString("Name"));
					customer.setDob(rset.getString("dob"));
					customer.setPhoneNumber(rset.getLong("Phone_number"));
					customer.setEmail(rset.getString("email"));
					customer.setAddress(rset.getString("Address"));
					customer.setStatus(rset.getString("Status"));
					customer.setPanId(rset.getString("PAN_ID"));
					customer.setAadarId(rset.getLong("Aadar_Id"));
					hm.put(customer.getId(), customer);
				}
			}
			if(hm.isEmpty())
			{
				throw new UserException("No user exists ");
			}
			return hm;
		}
		catch(SQLException e)
		{
			throw new UserException(e.getLocalizedMessage(),e);
		}
		finally
		{
			shutDown(wire,query);
		}
	}
	@Override
	public Customer getMyCustomerInfo(int id) throws UserException
	{
		Connection wire = connector();
		PreparedStatement query = null;
		try
		{
			query = wire.prepareStatement("SELECT UserInfo.ID, UserInfo.User_Type, UserInfo.Name, "
					+ "UserInfo.DOB, UserInfo.Phone_number, UserInfo.email, UserInfo.Address, UserInfo.Password, "
					+ "CustomerInfo.Status, CustomerInfo.PAN_ID, CustomerInfo.Aadar_Id FROM UserInfo "
					+ "INNER JOIN CustomerInfo ON UserInfo.ID = CustomerInfo.ID where CustomerInfo.ID = ?;");
			query.setInt(1, id);
			Customer customer = null;
			try(ResultSet rset = query.executeQuery())
			{
				rset.next();
				customer = new Customer();
				customer.setId(rset.getInt("ID"));
				customer.setUserType(rset.getString("User_Type"));
				customer.setName(rset.getString("Name"));
				customer.setDob(rset.getString("dob"));
				customer.setPhoneNumber(rset.getLong("Phone_number"));
				customer.setEmail(rset.getString("email"));
				customer.setAddress(rset.getString("Address"));
				customer.setStatus(rset.getString("Status"));
				customer.setPanId(rset.getString("PAN_ID"));
				customer.setAadarId(rset.getLong("Aadar_Id"));
			}
			return customer;
		}
		catch(SQLException e)
		{
			throw new UserException(e.getLocalizedMessage(),e);
		}
		finally
		{
			shutDown(wire,query);
		}
	}
	@Override
	public Admin getMyAdminInfo(int id) throws UserException
	{
		Connection wire = connector();
		PreparedStatement query = null;
		try
		{
			query = wire.prepareStatement("Select * from UserInfo where ID = ?;");
			query.setInt(1, id);
			Admin admin = null;
			try(ResultSet rset = query.executeQuery())
			{
				rset.next();
				admin = new Admin();
				admin.setId(rset.getInt("ID"));
				admin.setUserType(rset.getString("User_Type"));
				admin.setName(rset.getString("Name"));
				admin.setDob(rset.getString("dob"));
				admin.setPhoneNumber(rset.getLong("Phone_number"));
				admin.setEmail(rset.getString("email"));
				admin.setAddress(rset.getString("Address"));
			}
			return admin;
		}
		catch(SQLException e)
		{
			throw new UserException(e.getLocalizedMessage(),e);
		}
		finally
		{
			shutDown(wire,query);
		}
	}
	@Override
	public void transaction(Transaction change) throws UserException
	{
		NullChecker.check(change);
		Connection wire = connector();
		String approval = change.getApproval();
		String accNo = change.getAccountNumber();
		String type = change.getModeOfTransaction();
		float amount = change.getAmount();
		String operation = change.getCreditOrDebit();
		String toAccount = change.getToAccount();
		PreparedStatement query = null;
		PreparedStatement updateQuery = null;
		try
		{
			if(!approval.equalsIgnoreCase("approved"))
			{
				query = wire.prepareStatement("Insert into Transaction"
						+ "(Account_number,Transaction_amount,Mode_Of_Transaction,Time,Transaction_account,"
						+ "Transaction_type,approval,ID) values (?,?,?,?,?,?,?,?)");
				query.setString(1, accNo);
				query.setFloat(2, amount);
				query.setString(3, type);
				query.setLong(4, change.getTime());
				query.setString(5, toAccount);
				query.setString(6, operation);
				if(type.equalsIgnoreCase("withdraw"))
				{
					if(amount>1000)
					{
						change.setApproval("pending");
					}
				}
				query.setString(7, change.getApproval());
				query.setInt(8, change.getId());
				query.executeUpdate();
				if(approval.equalsIgnoreCase("pending"))
				{
					return;
				}
			}
			float balance = getAccountBalance(accNo);
			if(operation.equalsIgnoreCase("credit"))
			{
				balance += amount;
			}
			else
			{
				balance -= amount;
			}
			updateQuery = wire.prepareStatement("Update AccountInfo set Balance = ? where Account_number = ?");
			updateQuery.setFloat(1, balance);
			updateQuery.setString(2, accNo);
			updateQuery.executeUpdate();
			if(type.equalsIgnoreCase("Transfer"))
			{
				PreparedStatement transferQuery = null;
				PreparedStatement transferQuery2 = null;
				try
				{
					float toAccountBalance = getAccountBalance(toAccount);
					toAccountBalance += amount;
					transferQuery = wire.prepareStatement("Update AccountInfo set Balance = ? where Account_number = ?");
					transferQuery.setFloat(1, toAccountBalance);
					transferQuery.setString(2, toAccount);
					transferQuery.executeUpdate();
					transferQuery2 = wire.prepareStatement("Insert into Transaction "
							+ "(Account_number,Transaction_amount,Mode_Of_Transaction,Time,Transaction_account,"
							+ "Transaction_type,approval,ID) values (?,?,?,?,?,?,?,?)");
					transferQuery2.setString(1, toAccount);
					transferQuery2.setFloat(2, amount);
					transferQuery2.setString(3, type);
					transferQuery2.setLong(4, change.getTime());
					transferQuery2.setString(5, accNo);
					transferQuery2.setString(6, "credit");
					transferQuery2.setString(7, change.getApproval());
					transferQuery2.setInt(8, findId(toAccount));
					transferQuery2.executeUpdate();
				}
				catch (SQLException e)
				{
					e.printStackTrace();
				}
				finally
				{
					shutDown(wire,transferQuery);
					shutDown(wire,transferQuery2);
				}
			}
		}
		catch(SQLException e)
		{
			throw new UserException(e.getLocalizedMessage(),e);
		}
		finally
		{
			shutDown(wire,query);
			shutDown(wire,updateQuery);
		}
	}
	@Override
	public Map<String,Transaction> transactionToApprove() throws UserException
	{
		Connection wire = connector();
		PreparedStatement query = null;
		try
		{
			query = wire.prepareStatement("Select * from Transaction where approval = 'pending'");
			Map<String,Transaction> hm = new HashMap<String,Transaction>();
			Transaction change =null;
			try(ResultSet rset = query.executeQuery())
			{
				while (rset.next())
				{
					change = new Transaction();
					change.setAccountNumber(rset.getString("Account_number"));
					change.setAmount(rset.getFloat("Transaction_amount"));
					change.setModeOfTransaction(rset.getString("Mode_Of_Transaction"));
					change.setToAccount(rset.getString("Transaction_account"));
					change.setTime(rset.getLong("time"));
					change.setCreditOrDebit(rset.getString("Transaction_type"));
					change.setApproval(rset.getString("approval"));
					change.setTransaction_id(rset.getLong("Transaction_id"));
					change.setId(rset.getInt("ID"));
					hm.put(change.getAccountNumber(), change);
				}
			}
			return hm;
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			System.out.println("hi");
			throw new UserException(e.getLocalizedMessage(),e);
		}
		finally
		{
			shutDown(wire,query);
		}
	}
	@Override
	public void approveTransaction(long transactionId) throws UserException
	{
		Connection wire = connector();
		PreparedStatement query = null;
		PreparedStatement secondQuery = null;
		try
		{
			query = wire.prepareStatement("Update Transaction set approval = 'approved' where Transaction_id = ?");
			query.setLong(1, transactionId);
			query.executeUpdate();
			secondQuery = wire.prepareStatement("Select * from Transaction where Transaction_id = ?");
			secondQuery.setLong(1, transactionId);
			Transaction change =null;
			try(ResultSet rset = secondQuery.executeQuery())
			{
				rset.next();
				change = new Transaction();
				change.setAccountNumber(rset.getString("Account_number"));
				change.setAmount(rset.getFloat("Transaction_amount"));
				change.setModeOfTransaction(rset.getString("Mode_Of_Transaction"));
				change.setToAccount(rset.getString("Transaction_account"));
				change.setTime(rset.getLong("time"));
				change.setCreditOrDebit(rset.getString("Transaction_type"));
				change.setApproval(rset.getString("approval"));
				change.setTransaction_id(rset.getLong("Transaction_id"));
				change.setId(rset.getInt("ID"));
			}
			transaction(change);
		}
		catch(SQLException e)
		{
			throw new UserException(e.getLocalizedMessage(),e);
		}
		finally
		{
			shutDown(wire,query);
		}
	}
	@Override
	public void rejectTransaction(long transactionId) throws UserException
	{
		Connection wire = connector();
		PreparedStatement query = null;
		PreparedStatement secondQuery = null;
		try
		{
			query = wire.prepareStatement("Update Transaction set approval = 'denied' where Transaction_id = ?");
			query.setLong(1, transactionId);
			query.executeUpdate();
			secondQuery = wire.prepareStatement("delete from Transaction where Transaction_id = ?");
			secondQuery.setLong(1, transactionId);
			secondQuery.executeUpdate();
		}
		catch(SQLException e)
		{
			throw new UserException(e.getLocalizedMessage(),e);
		}
		finally
		{
			shutDown(wire,query);
		}
	}
	@Override
	public String currentStatus(long transactionNumber) throws UserException
	{
		Connection wire = connector();
		PreparedStatement query = null;
		try
		{
			query = wire.prepareStatement("select approval from Transaction where Transaction_id = ?;");
			query.setLong(1, transactionNumber);
			String change =null;
			try(ResultSet rset = query.executeQuery())
			{
				rset.next();
				change = rset.getString(1);
			}
			return change;
		}
		catch(SQLException e)
		{
			throw new UserException(e.getLocalizedMessage(),e);
		}
		finally
		{
			shutDown(wire,query);
		}
	}
	@Override
	public float getAccountBalance(String accNo) throws UserException
	{
		NullChecker.check(accNo);
		Connection wire = connector();
		PreparedStatement query = null;
		try
		{
			query = wire.prepareStatement("Select Balance from AccountInfo where Account_number = ?");
			query.setString(1, accNo);
			float balance;
			try(ResultSet rset = query.executeQuery())
			{
				rset.next();
				balance = rset.getLong(1);
			}
			return balance;
		}
		catch(SQLException e)
		{
			throw new UserException(e.getLocalizedMessage(),e);
		}
		finally
		{
			shutDown(wire,query);
		}
	}
	@Override
	public Map<Long,Transaction> transactionList(String accNo,long currenttime) throws UserException
	{
		NullChecker.check(accNo);
		Connection wire = connector();
		long time = currenttime - (7*24*60*60*1000);
		PreparedStatement query = null;
		try
		{
			query = wire.prepareStatement("Select * from Transaction where Account_number = ? and Time > ?");
			query.setString(1, accNo);
			query.setLong(2, time);
			Map<Long,Transaction> statement = new HashMap<Long,Transaction>();
			Transaction change = null;
			try(ResultSet rset = query.executeQuery())
			{
				while (rset.next())
				{
					change = new Transaction();
					long transId = rset.getLong("Transaction_id");
					change.setAccountNumber(rset.getString("Account_number"));
					change.setAmount(rset.getFloat("Transaction_amount"));
					change.setModeOfTransaction(rset.getString("Mode_Of_Transaction"));
					change.setToAccount(rset.getString("Transaction_account"));
					change.setTime(rset.getLong("Time"));
					change.setCreditOrDebit(rset.getString("Transaction_type"));
					change.setApproval(rset.getString("approval"));
					change.setTransaction_id(transId);
					change.setId(rset.getInt("ID"));
					statement.put(transId,change);
				}
			}
			return statement;
		}
		catch(SQLException e)
		{
			throw new UserException(e.getLocalizedMessage(),e);
		}
		finally
		{
			shutDown(wire,query);
		}
	}
	@Override
	public void changePassword(int id,String oldPassword,String newPassword) throws UserException
	{
		NullChecker.check(oldPassword);
		NullChecker.check(newPassword);
		Connection wire = connector();
		PreparedStatement query = null;
		try
		{
			query = wire.prepareStatement("Select Password from UserInfo where id = ?;");
			query.setInt(1, id);
			try(ResultSet rset = query.executeQuery())
			{
				rset.next();
				if(!rset.getString(1).equals(oldPassword))
				{
					throw new UserException("Incorrect password ");
				}
				PreparedStatement secondQuery = wire.prepareStatement("Update UserInfo set Password = ? where id = ?;");
				secondQuery.setString(1, newPassword);
				secondQuery.setInt(2, id);
				secondQuery.executeUpdate();
				shutDown(wire,secondQuery);
			}
		}
		catch(SQLException e)
		{
			throw new UserException(e.getLocalizedMessage(),e);
		}
		finally
		{
			shutDown(wire,query);
		}
	}
	@Override
	public Map<Integer,Map<String,AccountDetails>> allAccounts() throws UserException
	{
		Connection wire = connector();
		Map<Integer,Map<String,AccountDetails>> accountList = new HashMap<Integer,Map<String,AccountDetails>>();
		PreparedStatement query = null;
		try
		{
			query = wire.prepareStatement("Select distinct(id) from AccountInfo");
			List<Integer> ids = new ArrayList<Integer>();
			try(ResultSet rset = query.executeQuery())
			{
				while(rset.next())
				{
					ids.add(rset.getInt(1));
				}
			}
			for(int i:ids)
			{
				query = wire.prepareStatement("Select * from AccountInfo where id = ?;");
				query.setInt(1,i);
				Map<String,AccountDetails> hm = new HashMap<String,AccountDetails>();
				try(ResultSet rset = query.executeQuery())
				{
					while(rset.next())
					{
						AccountDetails accounts = new AccountDetails();
						accounts.setId(rset.getInt("ID"));
						accounts.setAccountNumber(rset.getString("Account_Number"));
						accounts.setBranch(rset.getString("Branch"));
						accounts.setAccountType(rset.getString("Account_Type"));
						accounts.setBalance(rset.getFloat("Balance"));
						accounts.setState(rset.getString("Account_status"));
						hm.put(accounts.getAccountNumber(), accounts);
					}
				}
				accountList.put(i, hm);
			}
			return accountList;
		}
		catch(SQLException e)
		{
			throw new UserException(e.getLocalizedMessage(),e);
		}
		finally
		{
			shutDown(wire,query);
		}
	}
	@Override
	public Map<String,Map<Long,Transaction>> allTransactions(int id) throws UserException
	{
		Connection wire = connector();
		Map<String,Map<Long,Transaction>> accountList = new HashMap<String,Map<Long,Transaction>>();
		PreparedStatement query = null;
		try
		{
			query = wire.prepareStatement("Select Account_number from UserInfo where id = ?;");
			query.setInt(1, id);
			List<String> ids = new ArrayList<String>();
			try(ResultSet rset = query.executeQuery())
			{
				while(rset.next())
				{
					ids.add(rset.getString(1));
				}
			}
			if(ids.isEmpty())
			{
				throw new UserException("No such user exists ");
			}
			for(String str:ids)
			{
				query = wire.prepareStatement("Select * from Transaction where Account_number = ?");
				query.setString(1,str);
				Map<Long,Transaction> hm = new HashMap<Long,Transaction>();
				try(ResultSet rset = query.executeQuery())
				{
					while(rset.next())
					{
						Transaction change = new Transaction();
						change.setAccountNumber(rset.getString("Account_number"));
						change.setAmount(rset.getFloat("Transaction_amount"));
						change.setModeOfTransaction(rset.getString("Mode_Of_Transaction"));
						change.setToAccount(rset.getString("Transaction_account"));
						change.setTime(rset.getLong("time"));
						change.setCreditOrDebit(rset.getString("Transaction_type"));
						change.setApproval(rset.getString("approval"));
						change.setTransaction_id(rset.getLong("Transaction_id"));
						change.setId(rset.getInt("ID"));
						hm.put(change.getTransaction_id(), change);
					}
				}
				accountList.put(str, hm);
			}
			return accountList;
		}
		catch(SQLException e)
		{
			throw new UserException(e.getLocalizedMessage(),e);
		}
		finally
		{
			shutDown(wire,query);
		}
	}
	@Override
	public boolean checkIfIn(String accNo) throws UserException
	{
		NullChecker.check(accNo);
		boolean truth = false;
		Connection wire = connector();
		PreparedStatement query = null;
		try
		{
			query = wire.prepareStatement("Select count(*) from AccountInfo where Account_number = ?");
			query.setString(1,accNo);
			try(ResultSet rset = query.executeQuery())
			{
				rset.next();
				if(rset.getInt(1) != 0)
				{
					truth = true;
				}
			}
			catch(SQLException e)
			{
				throw new UserException("No such account exists ");
			}
			return truth;
		}
		catch(SQLException e)
		{
			throw new UserException(e.getLocalizedMessage(),e);
		}
		finally
		{
			shutDown(wire,query);
		}
	}
	@Override
	public boolean checkIfIn(String accNo,int id) throws UserException
	{
		NullChecker.check(accNo);
		boolean truth = false;
		Connection wire = connector();
		PreparedStatement query = null;
		try
		{
			query = wire.prepareStatement("Select id from AccountInfo where Account_number = ?");
			query.setString(1,accNo);
			try(ResultSet rset = query.executeQuery())
			{
				rset.next();
				if(rset.getInt("id") == id)
				{
					truth = true;
				}
			}
			catch(SQLException e)
			{
				e.printStackTrace();
				throw new UserException("No such account exists ");
			}
			return truth;
		}
		catch(SQLException e)
		{
			throw new UserException(e.getLocalizedMessage(),e);
		}
		finally
		{
			shutDown(wire,query);
		}
	}
	@Override
	public void logout(int id) throws UserException
	{
		Connection wire = connector();
		PreparedStatement query = null;
		try
		{
			query = wire.prepareStatement("Update CustomerInfo set Status = 'loggedout' where Id = ?;");
			query.setInt(1, id);
			query.executeUpdate();
		}
		catch(SQLException e)
		{
			throw new UserException(e.getLocalizedMessage(),e);
		}
		finally
		{
			shutDown(wire,query);
		}
	}
	@Override
	public void signout(int id) throws UserException
	{
		Connection wire = connector();
		PreparedStatement query = null;
		try
		{
			query = wire.prepareStatement("Update AdminInfo set Status = 'loggedout' where Id = ?;");
			query.setInt(1, id);
			query.executeUpdate();
		}
		catch(SQLException e)
		{
			throw new UserException(e.getLocalizedMessage(),e);
		}
		finally
		{
			shutDown(wire,query);
		}
	}
	@Override
	public boolean getIfActive(String accNo) throws UserException
	{
		NullChecker.check(accNo);
		boolean truth = false;
		Connection wire = connector();
		PreparedStatement query = null;
		try
		{
			query = wire.prepareStatement("select Account_status from AccountInfo where Account_number = ?");
			query.setString(1, accNo);
			try(ResultSet rset = query.executeQuery())
			{
				rset.next();
				if(rset.getString("Account_status").equalsIgnoreCase("active"))
				{
					truth = true;
				}
			}
			return truth;
		}
		catch(SQLException e)
		{
			throw new UserException(e.getLocalizedMessage(),e);
		}
		finally
		{
			shutDown(wire,query);
		}
	}
	@Override
	public boolean checkIfIn(long transaction_id,int id) throws UserException
	{
		NullChecker.check(transaction_id);
		boolean truth = false;
		Connection wire = connector();
		PreparedStatement query = null;
		try
		{
			query = wire.prepareStatement("Select id from Transaction where Transaction_id = ?;");
			query.setLong(1,transaction_id);
			try(ResultSet rset = query.executeQuery())
			{
				rset.next();
				if(rset.getInt("id") == id)
				{
					truth = true;
				}
			}
			catch(SQLException e)
			{
				throw new UserException("No such account exists ");
			}
			return truth;
		}
		catch(SQLException e)
		{
			throw new UserException(e.getLocalizedMessage(),e);
		}
		finally
		{
			shutDown(wire,query);
		}
	}
	private int findId(String accNo) throws UserException
	{
		NullChecker.check(accNo);
		Connection wire = connector();
		PreparedStatement query = null;
		try
		{
			query = wire.prepareStatement("Select id from AccountInfo where Account_number = ?;");
			query.setString(1,accNo);
			try(ResultSet rset = query.executeQuery())
			{
				rset.next();
				return rset.getInt("id");
			}
		}
		catch(SQLException e)
		{
			throw new UserException(e.getLocalizedMessage(),e);
		}
		finally
		{
			shutDown(wire,query);
		}
	}
	@Override
	public void createCustomer(Customer custom) throws UserException
	{
		NullChecker.check(custom);
		Connection wire = connector();
		PreparedStatement query = null;
		PreparedStatement secondQuery = null;
		try
		{
			query = wire.prepareStatement("Insert into UserInfo (User_Type,Name,DOB,Phone_number,email,Address,"
								+ "Password) values (?,?,?,?,?,?,?)",Statement.RETURN_GENERATED_KEYS);
			query.setString(1,"User");
			query.setString(2,custom.getName());
			query.setString(3,custom.getDob());
			query.setLong(4,custom.getPhoneNumber());
			query.setString(5,custom.getEmail());
			query.setString(6,custom.getAddress());
			query.setString(7,custom.getPassword());
			query.executeUpdate();
			try(ResultSet rset = query.getGeneratedKeys())
			{
				rset.next();
				custom.setId(rset.getInt(1));
			}
			secondQuery = wire.prepareStatement("Insert into CustomerInfo (ID,PAN_ID,Aadar_Id) values (?,?,?)");
			secondQuery.setInt(1,custom.getId());
			secondQuery.setString(2,custom.getPanId());
			secondQuery.setLong(3,custom.getAadarId());
			secondQuery.executeUpdate();
		}
		catch(SQLException e)
		{
			throw new UserException(e.getLocalizedMessage(),e);
		}
		finally
		{
			shutDown(wire,query);
			shutDown(wire,secondQuery);
		}
	}
	@Override
	public void createAccount(AccountDetails acc) throws UserException
	{
		NullChecker.check(acc);
		Connection wire = connector();
		PreparedStatement query = null;
		try
		{
			query = wire.prepareStatement("Insert into AccountInfo values (?,?,?,?,?,?)");
			query.setInt(1,acc.getId());
			query.setString(2,acc.getAccountNumber());
			query.setString(3,acc.getBranch());
			query.setString(4,acc.getAccountType());
			query.setFloat(5,acc.getBalance());
			query.setString(6,acc.getState());
			query.executeUpdate();
		}
		catch(SQLException e)
		{
			throw new UserException(e.getLocalizedMessage(),e);
		}
		finally
		{
			shutDown(wire,query);
		}
	}
	@Override
	public boolean isIdIn(int i) throws UserException
	{
		Connection wire = connector();
		PreparedStatement query = null;
		try
		{
			query = wire.prepareStatement("Select * from CustomerInfo where ID = ");
			query.setInt(1,i);
			try(ResultSet rset = query.getGeneratedKeys())
			{
				rset.next();
				rset.getInt(1);
				return true;
			}
			catch(Exception e)
			{
				return false;
			}
		}
		catch(SQLException e)
		{
			throw new UserException(e.getLocalizedMessage(),e);
		}
		finally
		{
			shutDown(wire,query);
		}
	}
	@Override
	public void changeCustomeer(Customer cust,int id) throws UserException
	{
		Connection wire = connector();
		PreparedStatement query = null;
		PreparedStatement secondQuery = null;
		try
		{
			query = wire.prepareStatement("Update from UserInfo set Name = ?,DOB = ?,Phone_number = ?,"
											+ "email = ?,Address = ? where ID = ?");
			query.setString(1, cust.getName());
			query.setString(2, cust.getDob());
			query.setLong(3, cust.getPhoneNumber());
			query.setNString(4, cust.getEmail());
			query.setString(5, cust.getAddress());
			query.setInt(6,id);
			query.executeUpdate();
			secondQuery = wire.prepareStatement("Update from CustomerInfo set PAN_ID = ?,Aadar_Id = ? where ID = ?");
			secondQuery.setString(1, cust.getPanId());
			secondQuery.setLong(2, cust.getAadarId());
			secondQuery.setInt(3,id);
			secondQuery.executeUpdate();
		}
		catch(SQLException e)
		{
			throw new UserException(e.getLocalizedMessage(),e);
		}
		finally
		{
			shutDown(wire,query);
			shutDown(wire,secondQuery);
		}
	}
}
