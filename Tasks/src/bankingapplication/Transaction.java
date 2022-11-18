package bankingapplication;

public class Transaction
{
	private int id;
	private String accountNumber;
	private float amount;
	private String modeOfTransaction;
	private String toAccount;
	private long time;
	private String creditOrDebit;
	private String approval = "auto approved";
	private long transaction_id;
	public void setId(int id)
	{
		this.id = id;
	}
	public void setAccountNumber(String accountNumber)
	{
		this.accountNumber = accountNumber;
	}
	public void setAmount(float amount)
	{
		this.amount = amount;
	}
	public void setModeOfTransaction(String transactionType)
	{
		this.modeOfTransaction = transactionType;
	}
	public void setToAccount(String toAccount)
	{
		this.toAccount = toAccount;
	}
	public void setTime(long time)
	{
		this.time = time;
	}
	public void setCreditOrDebit(String creditOrDebit)
	{
		this.creditOrDebit = creditOrDebit;
	}
	public void setApproval(String approval)
	{
		this.approval = approval;
	}
	public void setTransaction_id(long transaction_id)
	{
		this.transaction_id = transaction_id;
	}
	public String getAccountNumber()
	{
		return accountNumber;
	}
	public float getAmount()
	{
		return amount;
	}
	public String getModeOfTransaction()
	{
		return modeOfTransaction;
	}
	public String getToAccount()
	{
		return toAccount;
	}
	public long getTime()
	{
		return time;
	}
	public String getCreditOrDebit()
	{
		return creditOrDebit;
	}
	public String getApproval()
	{
		return approval;
	}
	public long getTransaction_id()
	{
		return transaction_id;
	}
	public int getId()
	{
		return id;
	}
}
