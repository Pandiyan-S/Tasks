package model.bankingapplication;

import java.util.Map;
import java.util.regex.Pattern;

public class Modules implements CustomerMethods, Administration
{
	private StoreageLayer store = new DatabaseStorage();
	private boolean validatePanId(String PanId)
	{
		return Pattern.matches("^[A-Z]{3}[PCHABGJLFT][A-Z]\\d{4}[A-Z]$",PanId);
	}
	private boolean validateAadarId(long aadarId)
	{
		String aadar = String.valueOf(aadarId);
		return Pattern.matches("\\d{12}",aadar);
	}
	private boolean validatePhone(long num)
	{
		String phno = String.valueOf(num);
		return Pattern.matches("^[6-9]\\d{9}",phno);
	}
	private boolean validateEmail(String email)
	{
		return Pattern.matches("^+[a-zA-Z0-9.-_]+[@]+[a-zA-Z0-9-]+[.]+[a-zA-Z0-9.]+$",email);
	}
	private boolean validateAccountNumber(String accNo)
	{
		return Pattern.matches("^\\d{12,17}",accNo);
	}
	@Override
	public boolean signIn(int id,String password) throws UserException
	{
		NullChecker.check(password);
		if(!store.verifyPassword(id,password))
		{
			return false;
		}
		return true;
	}
	@Override
	public void customerLogin(int id) throws UserException
	{
		store.login(id);
	}
	@Override
	public void adminLogin(int id) throws UserException
	{
		store.adminLogin(id);
	}
	@Override
	public String userType(int id) throws UserException
	{
		if(store.isAdmin(id))
		{
			return "admin";
		}
		return "customer";
	}
	@Override
	public Map<String,AccountDetails> customerAccounts(int id) throws UserException
	{
		if(store.isAdmin(id))
		{
			throw new UserException("The current id is not a customer ");
		}
		Map<String, AccountDetails> hm = store.getAccounts(id);
		return hm;
	}
	@Override
	public Map<Integer,Customer> showAllCustomers() throws UserException
	{
		Map<Integer, Customer> hm = store.getCustomers();
		return hm;
	}
	@Override
	public Map<String,AccountDetails> getCustomerAccounts(int id) throws UserException
	{
		Map<String, AccountDetails> hm = store.getAccounts(id);
		return hm;
	}
	@Override
	public Customer showCustomerProfile(int id) throws UserException
	{
		if(store.isAdmin(id))
		{
			throw new UserException("The current id is not a customer ");
		}
		Customer profile = store.getMyCustomerInfo(id);
		return profile;
	}
	@Override
	public Customer showParticularProfile(int id) throws UserException
	{
		Customer profile = store.getMyCustomerInfo(id);
		return profile;
	}
	@Override
	public Admin showAdminProfile(int id) throws UserException
	{
		if(!store.isAdmin(id))
		{
			throw new UserException("The current id is not an admin ");
		}
		Admin profile = store.getMyAdminInfo(id);
		return profile;
	}
	@Override
	public void deposit(int id,String accNo,float amount) throws UserException
	{
		NullChecker.check(accNo);
		if(store.isAdmin(id))
		{
			throw new UserException("The current id is not a customer ");
		}
		store.checkIfIn(accNo,id);
		Transaction income = new Transaction();
		income.setAccountNumber(accNo);
		income.setAmount(amount);
		income.setModeOfTransaction("Deposit");
		income.setToAccount(null);
		income.setTime(System.currentTimeMillis());
		income.setCreditOrDebit("Credit");
		income.setApproval("auto approved");
		income.setId(id);
		store.transaction(income);
	}
	@Override
	public void withdraw(int id,String accNo,float amount) throws UserException
	{
		NullChecker.check(accNo);
		if(store.isAdmin(id))
		{
			throw new UserException("The current id is not a customer ");
		}
		if(amount>viewBalance(id,accNo))
		{
			throw new UserException("the amount is larger than the balance");
		}
		store.checkIfIn(accNo,id);
		Transaction income = new Transaction();
		income.setAccountNumber(accNo);
		income.setAmount(amount);
		income.setModeOfTransaction("Withdraw");
		income.setToAccount(null);
		income.setTime(System.currentTimeMillis());
		income.setCreditOrDebit("Debit");
		income.setApproval("auto approved");
		income.setId(id);
		store.transaction(income);
	}
	@Override
	public void transfer(int id,String accNo,String toAcc,float amount) throws UserException
	{
		NullChecker.check(accNo);
		NullChecker.check(toAcc);
		if(store.isAdmin(id))
		{
			throw new UserException("The current id is not a customer ");
		}
		if(amount>viewBalance(id,accNo))
		{
			throw new UserException("the amount is larger than the balance");
		}
		store.checkIfIn(accNo,id);
		Transaction income = new Transaction();
		income.setAccountNumber(accNo);
		income.setAmount(amount);
		income.setModeOfTransaction("Transfer");
		income.setToAccount(toAcc);
		income.setTime(System.currentTimeMillis());
		income.setCreditOrDebit("Debit");
		income.setApproval("auto approved");
		income.setId(id);
		store.transaction(income);
	}
	@Override
	public Map<String,Transaction> pendingList() throws UserException
	{
		Map<String,Transaction> hm = store.transactionToApprove();
		return hm;
	}
	@Override
	public void giveApproval(long transactionId) throws UserException
	{
		store.approveTransaction(transactionId);
	}
	@Override
	public void denyApproval(long transactionId) throws UserException
	{
		store.rejectTransaction(transactionId);
	}
	@Override
	public String customerTransactionStatus(int id,long Transaction_id) throws UserException
	{
		store.checkIfIn(Transaction_id,id);
		String status = store.currentStatus(Transaction_id) ;
		return status;
	}
	public String transactionStatus(int id,long Transaction_id) throws UserException
	{
		if(store.isAdmin(id))
		{
			throw new UserException("The current id is not a customer ");
		}
		store.checkIfIn(Transaction_id,id);
		String status = store.currentStatus(Transaction_id) ;
		return status;
	}
	@Override
	public Float viewBalance(int id,String accNo) throws UserException
	{
		NullChecker.check(accNo);
		if(store.isAdmin(id))
		{
			throw new UserException("The current id is not a customer ");
		}
		store.checkIfIn(accNo,id);
		Float balance = store.getAccountBalance(accNo);
		return balance;
	}
	@Override
	public Map<Long,Transaction> statement(int id,String accNo) throws UserException
	{
		NullChecker.check(accNo);
		if(store.isAdmin(id))
		{
			throw new UserException("The current id is not a customer ");
		}
		store.checkIfIn(accNo);
		Map<Long,Transaction> statement = store.transactionList(accNo,System.currentTimeMillis());
		return statement;
	}
	@Override
	public Map<Long,Transaction> statement(String accNo) throws UserException
	{
		NullChecker.check(accNo);
		store.checkIfIn(accNo);
		Map<Long,Transaction> statement = store.transactionList(accNo,System.currentTimeMillis());
		return statement;
	}
	@Override
	public boolean changePassword(int id,String oldPassword,String newPassword) throws UserException
	{
		NullChecker.check(oldPassword);
		NullChecker.check(newPassword);
		try
		{
			store.changePassword(id,oldPassword,newPassword);
			return true;
		}
		catch(UserException e)
		{
			return false;
		}
	}
	@Override
	public Map<Integer,Map<String,AccountDetails>> getAllAccounts() throws UserException
	{
		Map<Integer,Map<String,AccountDetails>> hm = store.allAccounts();
		return hm;
	}
	@Override
	public Map<String,Map<Long,Transaction>> getAllTransactions(int id) throws UserException
	{
		Map<String, Map<Long, Transaction>> hm = store.allTransactions(id);
		return hm;
	}
	@Override
	public Float viewCustomerBalance(String accNo) throws UserException
	{
		NullChecker.check(accNo);
		store.checkIfIn(accNo);
		Float balance = store.getAccountBalance(accNo);
		return balance;
	}
	@Override
	public void signOut(int id) throws UserException
	{
		store.signout(id);
	}
	@Override
	public void logOut(int id) throws UserException
	{
		store.logout(id);
	}
	@Override
	public boolean checkCustomerAccountActive(int id,String accNo) throws UserException
	{
		NullChecker.check(accNo);
		store.checkIfIn(accNo,id);
		return store.getIfActive(accNo);
	}
	@Override
	public boolean checkAccountActive(String accNo) throws UserException
	{
		NullChecker.check(accNo);
		store.checkIfIn(accNo);
		return store.getIfActive(accNo);
	}
	@Override
	public void newCustomer(Customer custom) throws UserException
	{
		NullChecker.check(custom);
		NullChecker.check(custom.getPanId());
		NullChecker.check(custom.getAadarId());
		NullChecker.check(custom.getDob());
		NullChecker.check(custom.getName());
		NullChecker.check(custom.getPhoneNumber());
		NullChecker.check(custom.getUserType());
		NullChecker.check(custom.getPassword());
		if(!validatePanId(custom.getPanId()))
		{
			throw new UserException("PAN number is not valid");
		}
		if(!validateAadarId(custom.getAadarId()))
		{
			throw new UserException("Aadar ID is not valid");
		}
		if(!validatePhone(custom.getPhoneNumber()))
		{
			throw new UserException("Phone number is not valid");
		}
		if(!validateEmail(custom.getEmail()))
		{
			throw new UserException("Email is not valid");
		}
		store.createCustomer(custom);
	}
	@Override
	public void newAccount(AccountDetails acc) throws UserException
	{
		NullChecker.check(acc);
		NullChecker.check(acc.getId());
		NullChecker.check(acc.getAccountNumber());
		NullChecker.check(acc.getAccountType());
		NullChecker.check(acc.getBalance());
		NullChecker.check(acc.getBranch());
		NullChecker.check(acc.getState());
		if(store.isIdIn(acc.getId()))
		{
			
		}
		if(!validateAccountNumber(acc.getAccountNumber()))
		{
			throw new UserException("account number is not valid");
		}
		store.createAccount(acc);
	}
	@Override
	public void edit(Customer custom,int id) throws UserException
	{
		NullChecker.check(custom);
		NullChecker.check(custom.getPanId(),"PAN ID");
		NullChecker.check(custom.getAadarId(),"Aadar");
		NullChecker.check(custom.getDob(),"Date of Birth");
		NullChecker.check(custom.getName(),"Name");
		NullChecker.check(custom.getPhoneNumber(),"Phone Number");
		NullChecker.check(custom.getUserType(),"User Type");
		if(!validatePanId(custom.getPanId()))
		{
			throw new UserException("PAN number is not valid");
		}
		if(!validateAadarId(custom.getAadarId()))
		{
			throw new UserException("Aadar ID is not valid");
		}
		if(!validatePhone(custom.getPhoneNumber()))
		{
			throw new UserException("Phone number is not valid");
		}
		if(!validateEmail(custom.getEmail()))
		{
			throw new UserException("Email is not valid");
		}
		store.changeCustomeer(custom,id);
	}
}
