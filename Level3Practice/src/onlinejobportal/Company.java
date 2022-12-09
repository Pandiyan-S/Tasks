package onlinejobportal;

public class Company
{
	long companyId;
	String password;
	String name;
	String email;
	public long getCompanyId()
	{
		return companyId;
	}
	public void setCompanyId(long companyId)
	{
		this.companyId = companyId;
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
	public String getEmail()
	{
		return email;
	}
	public void setEmail(String email)
	{
		this.email = email;
	}
	@Override
	public String toString() {
		return "\nCompany Id = " + companyId + "\nName = " + name + "\nEmail = " + email;
	}
}
