package model.bankingapplication;

import java.util.Map;

public interface CustomerMethods extends UserInter
{

	public Map<String, AccountDetails> customerAccounts (int id) throws UserException;

	public Customer showCustomerProfile(int id) throws UserException;

	public void deposit(int id,String accNo, float amount) throws UserException;

	public void withdraw(int id,String accNo, float amount) throws UserException;

	public void transfer(int id,String accNo, String toAcc, float amount) throws UserException;
	
	public Float viewBalance(int id,String accNo) throws UserException;
	
	public Map<Long, Transaction> statement(int id,String accNo) throws UserException;

	public boolean checkCustomerAccountActive(int id,String accNo) throws UserException;

	void customerLogin(int id) throws UserException;

	void logOut(int id) throws UserException;

}