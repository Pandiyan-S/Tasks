package bankingapplication;

import java.util.Map;
import check.UserException;

public class Modules implements CustomerMethods, Administration
{
	private StoreageLayer store = new DatabaseStorage();
	@Override
	public boolean signIn(int id,String password) throws UserException
	{
		NullChecker.check(password);
		if(!store.verifyPassword(id,password))
		{
			return false;
		}
		store.login(id);
		return true;
	}
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
	public void giveApproval(Transaction waiting) throws UserException
	{
		NullChecker.check(waiting);
		store.approveTransaction(waiting);
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
		Map<Long,Transaction> statement = store.transactionList(accNo);
		return statement;
	}
	@Override
	public void changePassword(int id,String oldPassword,String newPassword) throws UserException
	{
		NullChecker.check(oldPassword);
		NullChecker.check(newPassword);
		store.changePassword(id,oldPassword,newPassword);
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
		store.createCustomer(custom);
	}
}
