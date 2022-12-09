package onlinejobportal;

public class JobDescription
{
	String title;
	String degreeReq;
	long companyId;
	String date;
	public String getTitle()
	{
		return title;
	}
	public void setTitle(String title)
	{
		this.title = title;
	}
	public String getDegreeReq()
	{
		return degreeReq;
	}
	public void setDegreeReq(String degreeReq)
	{
		this.degreeReq = degreeReq;
	}
	public long getCompanyId()
	{
		return companyId;
	}
	public void setCompanyId(long companyId)
	{
		this.companyId = companyId;
	}
	public String getDate()
	{
		return date;
	}
	public void setDate(String date)
	{
		this.date = date;
	}
	@Override
	public String toString()
	{
		return "\nTitle = " + title + "\nDegree Required = " + degreeReq + "\nCompany Id = "
				+ companyId + "\nInterview Date = " + date;
	}
	
}
