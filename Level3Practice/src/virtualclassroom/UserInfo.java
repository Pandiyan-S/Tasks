package virtualclassroom;

public class UserInfo
{
	int userId;
	String password;
	String name;
	String dob;
	long phoneNumber;
	String type;
	public int getUserId()
	{
		return userId;
	}
	public void setUserId(int userId)
	{
		this.userId = userId;
	}
	public String getPassword()
	{
		return password;
	}
	public void setPassword(String password)
	{
		this.password = password;
	}
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public String getDob()
	{
		return dob;
	}
	public void setDob(String dob)
	{
		this.dob = dob;
	}
	public long getPhoneNumber()
	{
		return phoneNumber;
	}
	public void setPhoneNumber(long phoneNumber)
	{
		this.phoneNumber = phoneNumber;
	}
	public String getType()
	{
		return type;
	}
	public void setType(String type)
	{
		this.type = type;
	}
	@Override
	public String toString()
	{
		StringBuilder str = new StringBuilder();
		str.append("\nUser Id:");
		str.append( userId);
		str.append("\nName:");
		str.append(name);
		str.append("\nDOB:");
		str.append(dob);
		str.append("\nPh No:");
		str.append(phoneNumber);
		str.append("\nType:");
		str.append( type);
		return str.toString();
	}
}
