package model.bankingapplication;

public class Customer extends UserInfo
{
	private String panId;
	private String status;
	private long aadarId;
	public void setPanId(String panId)
	{
		this.panId = panId;
	}
	public void setStatus(String status)
	{
		this.status = status;
	}
	public void setAadarId(long aadarId)
	{
		this.aadarId = aadarId;
	}
	public String getPanId()
	{
		return panId;
	}
	public String getStatus()
	{
		return status;
	}
	public long getAadarId()
	{
		return aadarId;
	}
}
