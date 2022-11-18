package bankingapplication;

import java.util.Map;
import check.UserException;

public interface Administration extends UserInter
{

	public Map<Integer, Customer> showAllCustomers() throws UserException;

	public Map<String, AccountDetails> getCustomerAccounts(int id) throws UserException;

	public Admin showAdminProfile(int id) throws UserException;

	public Map<String, Transaction> pendingList() throws UserException;

	public void giveApproval(Transaction waiting) throws UserException;

	public String customerTransactionStatus(int id,long Transaction_id) throws UserException;
	
	public Map<Integer,Map<String,AccountDetails>> getAllAccounts() throws UserException;
	
	public Map<String,Map<Long,Transaction>> getAllTransactions(int id) throws UserException;
	
	public Float viewCustomerBalance(String accNo) throws UserException;

	public boolean checkAccountActive(String accNo) throws UserException;
	
	public void newCustomer(Customer custom) throws UserException;
}