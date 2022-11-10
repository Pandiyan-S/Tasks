package model.bankingapplication;

import java.util.Map;

public interface Administration extends UserInter
{

	public Map<Integer, Customer> showAllCustomers() throws UserException;

	public Map<String, AccountDetails> getCustomerAccounts(int id) throws UserException;

	public Admin showAdminProfile(int id) throws UserException;

	public Map<String, Transaction> pendingList() throws UserException;

	public void giveApproval(long transactionId) throws UserException;

	public String customerTransactionStatus(int id,long Transaction_id) throws UserException;
	
	public Map<Integer,Map<String,AccountDetails>> getAllAccounts() throws UserException;
	
	public Map<String,Map<Long,Transaction>> getAllTransactions(int id) throws UserException;
	
	public Float viewCustomerBalance(String accNo) throws UserException;

	public boolean checkAccountActive(String accNo) throws UserException;
	
	public void newCustomer(Customer custom) throws UserException;

	Customer showParticularProfile(int id) throws UserException;

	Map<Long, Transaction> statement(String accNo) throws UserException;

	void newAccount(AccountDetails acc) throws UserException;

	void adminLogin(int id) throws UserException;

	void signOut(int id) throws UserException;

	void denyApproval(long transactionId) throws UserException;

	void edit(Customer custom, int userId) throws UserException;
}