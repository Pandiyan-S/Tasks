package model.bankingapplication;

public class UserInfo
{
	private int id;
	private String password;
	private String userType;
	private String name;
	private String dob;
	private long phoneNumber;
	private String email;
	private String address;
	public void setId(int id)
	{
		this.id = id;
	}
	public void setPassword(String password)
	{
		this.password = password;
	}
	public void setUserType(String userType)
	{
		this.userType = userType;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public void setDob(String dob)
	{
		this.dob = dob;
	}
	public void setPhoneNumber(long phoneNumber)
	{
		this.phoneNumber = phoneNumber;
	}
	public void setEmail(String email)
	{
		this.email = email;
	}
	public void setAddress(String address)
	{
		this.address = address;
	}
	public int getId()
	{
		return id;
	}
	public String getPassword()
	{
		return password;
	}
	public String getUserType()
	{
		return userType;
	}
	public String getName()
	{
		return name;
	}
	public String getDob()
	{
		return dob;
	}
	public long getPhoneNumber()
	{
		return phoneNumber;
	}
	public String getEmail()
	{
		return email;
	}
	public String getAddress()
	{
		return address;
	}
}
