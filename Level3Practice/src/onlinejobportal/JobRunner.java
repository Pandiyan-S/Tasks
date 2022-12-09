package onlinejobportal;

import java.util.List;
import java.util.Scanner;

public class JobRunner
{
	public static void main(String[] args)
	{
		LogicalLayer logic = new LogicalLayer();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter 1 sign up");
		System.out.println("Enter any other key for sign in");
		try
		{
			char choice = sc.nextLine().charAt(0);
			if (choice == '1')
			{
				System.out.println("Enter 1 for organisation sign up");
				System.out.println("Enter any other key for applicant sign up");
				char type = sc.nextLine().charAt(0);
				if (type == '1')
				{
					Company comp = new Company();
					System.out.println("Enter the Company id");
					long compId = sc.nextLong();
					if(logic.companyExist(compId))
					{
						System.out.println("sorry the Id already exists");
					}
					else
					{
						comp.setCompanyId(compId);
						System.out.println("Enter the Password");
						sc.nextLine();
						String password = sc.nextLine();
						System.out.println("Enter the Company Name");
						String name = sc.nextLine();
						System.out.println("Enter the Email");
						String email = sc.nextLine();
						comp.setPassword(password);
						comp.setName(name);
						comp.setEmail(email);
						logic.createCompany(comp);
						System.out.println("Sign up successful");
					}
				}
				else
				{
					Applicant app = new Applicant();
					System.out.println("Enter the Company id");
					long appId = sc.nextLong();
					if(logic.applicantExist(appId))
					{
						System.out.println("sorry the Id already exists");
					}
					else
					{
						app.setApplicantId(appId);
						System.out.println("Enter the Password");
						sc.nextLine();
						String password = sc.nextLine();
						System.out.println("Enter the Company Name");
						String name = sc.nextLine();
						System.out.println("Enter the Age");
						int age = sc.nextInt();
						System.out.println("Enter the Degree");
						String degree = sc.nextLine();
						System.out.println("Enter the Email");
						String email = sc.nextLine();
						app.setPassword(password);
						app.setName(name);
						app.setAge(age);
						app.setDegree(degree);
						app.setEmail(email);
						logic.createApplicant(app);
						System.out.println("Sign up successful");
					}
				}
			}
			else
			{
				System.out.println("Enter 1 for organisation sign in");
				System.out.println("Enter any other key for applicant sign in");
				char type = sc.nextLine().charAt(0);
				if (type == '1')
				{
					System.out.println("Enter the Company Id");
					long compId = sc.nextLong();
					if(logic.companyExist(compId))
					{
						System.out.println("Enter the password");
						sc.nextLine();
						String password = sc.nextLine();
						if(logic.compPasswordVerification(compId,password))
						{
							logic.initialize();
							System.out.println("Enter the Vacancy job title");
							String title = sc.nextLine();
							System.out.println("Enter the degree required");
							String degree = sc.nextLine();
							System.out.println("Enter the date");
							String date = sc.nextLine();
							JobDescription job = new JobDescription();
							job.setCompanyId(compId);
							job.setTitle(title);
							job.setDegreeReq(degree);
							job.setDate(date);
							logic.createJobs(job);
							System.out.println("Vacancy has been posted");
						}
						else
						{
							System.out.println("Invalid password");
						}
					}
					else
					{
						System.out.println("sorry the Id does not exists");
					}
				}
				else
				{
					System.out.println("Enter the Applicant Id");
					long appId = sc.nextLong();
					if(logic.applicantExist(appId))
					{
						System.out.println("Enter the password");
						sc.nextLine();
						String password = sc.nextLine();
						if(logic.appPasswordVerification(appId,password))
						{
							logic.initialize();
							System.out.println("Enter the job title");
							String title = sc.nextLine();
							System.out.println("all available jobs for your criteria");
							List<JobDescription> list = logic.availableJobs(appId,title);
							for(JobDescription job : list)
							{
								System.out.println(job.toString());
								System.out.println(logic.companyDetails(job.getCompanyId()).toString());
							}
							System.out.println("Enter the company Id");
							long compId = sc.nextLong();
							String date = null;
							for(JobDescription job : list)
							{
								if(compId == job.getCompanyId())
								{
									logic.createInterview(appId,job);
									date = job.getDate();
									
								}
							}
							if(date != null)
							{
								System.out.println("Interview has been sheduled on " + date);
							}
							else
							{
								System.out.println("Invalid company Id");
							}
						}
						else
						{
							System.out.println("Invalid password");
						}
					}
					else
					{
						System.out.println("sorry the Id does not exists");
					}
				}
			} 
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			sc.close();
		}
	}
}
