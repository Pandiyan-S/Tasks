package bankingapplication;

public class AccountDetails
{
	private int id;
	private String accountNumber;
	private String branch;
	private String accountType;
	private float balance;
	private int minBalance;
	private String state;
	public void setId(int id)
	{
		this.id = id;
	}
	public void setAccountNumber(String accountNumber)
	{
		this.accountNumber = accountNumber;
	}
	public void setBranch(String branch)
	{
		this.branch = branch;
	}
	public void setAccountType(String accountType)
	{
		this.accountType = accountType;
	}
	public void setBalance(float balance)
	{
		this.balance = balance;
	}
	public void setMinBalance(int minBalance)
	{
		this.minBalance = minBalance;
	}
	public void setState(String state)
	{
		this.state = state;
	}
	public int getId()
	{
		return id;
	}
	public String getAccountNumber()
	{
		return accountNumber;
	}
	public String getBranch()
	{
		return branch;
	}
	public String getAccountType()
	{
		return accountType;
	}
	public float getBalance()
	{
		return balance;
	}
	public int getMinBalance()
	{
		return minBalance;
	}
	public String getState()
	{
		return state;
	}
}
