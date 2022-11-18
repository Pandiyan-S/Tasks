package bankingapplication;

import java.util.Map;

import check.UserException;

public interface StoreageLayer {

	public boolean verifyPassword(int id, String password) throws UserException;

	public void login(int id) throws UserException;

	public boolean isAdmin(int id) throws UserException;

	public Map<String, AccountDetails> getAccounts(int id) throws UserException;

	public Map<Integer, Customer> getCustomers() throws UserException;

	public Customer getMyCustomerInfo(int id) throws UserException;

	public Admin getMyAdminInfo(int id) throws UserException;

	public void transaction(Transaction change) throws UserException;

	public Map<String, Transaction> transactionToApprove() throws UserException;

	public void approveTransaction(Transaction change) throws UserException;

	public String currentStatus(long transactionNumber) throws UserException;

	public float getAccountBalance(String accNo) throws UserException;

	public Map<Long, Transaction> transactionList(String accNo) throws UserException;

	public void changePassword(int id, String oldPassword, String newPassword) throws UserException;

	public Map<Integer, Map<String, AccountDetails>> allAccounts() throws UserException;

	public Map<String, Map<Long, Transaction>> allTransactions(int id) throws UserException;

	public boolean checkIfIn(String accNo) throws UserException;

	public boolean checkIfIn(String accNo, int id) throws UserException;

	public void logout(int id) throws UserException;

	public boolean getIfActive(String accNo) throws UserException;

	public boolean checkIfIn(long transaction_id, int id) throws UserException;

	public void createCustomer(Customer custom) throws UserException;

}