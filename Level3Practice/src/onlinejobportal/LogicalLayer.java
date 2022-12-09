package onlinejobportal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LogicalLayer
{
	private Map<Long,Applicant> candidates = new HashMap<>();
	private Map<Long,Company> companies = new HashMap<>();
	private Map<String,List<JobDescription>> vacancies = new HashMap<>();
	private Map<Long,Map<Long,JobDescription>> sheduled = new HashMap<>();
	
	public void initialize()
	{
		Applicant app = new Applicant();
		app.setApplicantId(1);
		app.setPassword("1234");
		app.setName("Jebaraj");
		app.setAge(22);
		app.setDegree("B.Tech");
		app.setEmail("jebaraj@gmail.com");
		candidates.put(app.getApplicantId(), app);
		Company comp = new Company();
		comp.setCompanyId(1);
		comp.setPassword("9876");
		comp.setName("Shyam.Ltd");
		comp.setEmail("saman@gmail.com");
		companies.put(comp.getCompanyId(), comp);
		List<JobDescription> list = new ArrayList<JobDescription>();
		JobDescription job1 = new JobDescription();
		job1.setTitle("H.R.Manager");
		job1.setDegreeReq("B.com");
		job1.setCompanyId(1);
		job1.setDate("09.12.2022");
		if(vacancies.containsKey(job1.getTitle()))
		{
			list = vacancies.get(job1.getTitle());
		}
		list.add(job1);
		vacancies.put(job1.getTitle(), list);
		list = new ArrayList<JobDescription>();
		JobDescription job2 = new JobDescription();
		job2.setTitle("Structural Engineer");
		job2.setDegreeReq("B.Tech");
		job2.setCompanyId(1);
		job2.setDate("11.12.2022");
		if(vacancies.containsKey(job2.getTitle()))
		{
			list = vacancies.get(job2.getTitle());
		}
		list.add(job2);
		vacancies.put(job2.getTitle(), list);
	}
	public void createApplicant(Applicant app)
	{
		candidates.put(app.getApplicantId(), app);
	}
	public void createCompany(Company comp)
	{
		companies.put(comp.getCompanyId(), comp);
	}
	public void createJobs(JobDescription job)
	{
		List<JobDescription> list = new ArrayList<JobDescription>();
		list.add(job);
		vacancies.put(job.getTitle(), list);
	}
	public void createInterview(long appId,JobDescription job)
	{
		Map<Long,JobDescription> hm = new HashMap<>();
		if(sheduled.containsKey(appId))
		{
			hm = sheduled.get(appId);
		}
		hm.put(job.getCompanyId(), job);
		sheduled.put(appId, hm);
	}
	public boolean companyExist(long compId)
	{
		return companies.containsKey(compId);
	}
	public boolean applicantExist(long appId)
	{
		return candidates.containsKey(appId);
	}
	public boolean compPasswordVerification(long compId, String password)
	{
		return companies.get(compId).getPassword().equals(password);
	}
	public boolean appPasswordVerification(long compId, String password)
	{
		return companies.get(compId).getPassword().equals(password);
	}
	public List<JobDescription> availableJobs(long appId, String title)
	{
		List<JobDescription> list = new ArrayList<JobDescription>();
		Applicant app = candidates.get(appId);
		for(JobDescription job : vacancies.get(title))
		{
			if(job.getDegreeReq() == app.getDegree())
			{
				list.add(job);
			}
		}
		return list;
	}
	public Company companyDetails(long companyId)
	{
		return companies.get(companyId);
	}
}
