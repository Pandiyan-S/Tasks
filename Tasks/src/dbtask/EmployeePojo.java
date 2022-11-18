package dbtask;

public class EmployeePojo
{
	private int employeeID;
	private String name;
	private long mobile;
	private String department;
	private String eMail;
	public void setEmployeeID(int num)
	{
		employeeID = num;
	}
	public void setName(String str)
	{
		name = str;
	}
	public void setMobile(long num)
	{
		mobile = num;
	}
	public void setDepartment(String str)
	{
		department = str;
	}
	public void setEmail(String str)
	{
		eMail = str;
	}
	public int getEmployeeID()
	{
		return employeeID;
	}
	public String getName()
	{
		return name;
	}
	public long getMobile()
	{
		return mobile;
	}
	public String getDepartment()
	{
		return department;
	}
	public String getEmail()
	{
		return eMail;
	}
}
