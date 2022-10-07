package task10;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

public class Runner
{
	private static void menu(Logger logger)
	{
		logger.info("Choose the operation to be performed");
		logger.info("\t1. Create a file sample.txt programmatically and write the lines.");
	}
	public int intInput(Scanner sc)
	{
		int choice = 0;
		boolean ex = true;
		do
		{
			try
			{
				choice = sc.nextInt();
				ex = false;
			}
			catch(Exception e)
			{
				System.out.println("the entered value is not an integer, please input correct value");
				sc.nextLine();
				ex = true;
			}
		}while(ex);
		return choice;
	}
	public long longInput(Scanner sc)
	{
		long choice = 0;
		boolean ex = true;
		do
		{
			try
			{
				choice = sc.nextLong();
				ex = false;
			}
			catch(Exception e)
			{
				System.out.println("the entered value is not an integer, please input correct value");
				sc.nextLine();
				ex = true;
			}
		}while(ex);
		return choice;
	}
	public void uploadDetails(Logger logger,Scanner sc) throws SQLException
	{
		logger.info("enter the number of employees");
		int noOfEmployee = intInput(sc);
		sc.nextLine();
		DataBaseMethods db = new DataBaseMethods();
		EmployeePojo pojo;
		for(int i=0; i<noOfEmployee; i++)
		{
			pojo = new EmployeePojo();
			logger.info("Enter the Name");
			String employeeName = sc.nextLine();
			pojo.setName(employeeName);
			logger.info("Enter the Mobile number");
			long Mobile = longInput(sc);
			pojo.setMobile(Mobile);
			sc.nextLine();
			logger.info("Enter the Email");
			String EMail = sc.nextLine();
			pojo.setEmail(EMail);
			logger.info("Enter the Department");
			String Department = sc.nextLine();
			pojo.setDepartment(Department);
			db.setEmpDetails(pojo);
		}
	}
	public void displayEmp(List<EmployeePojo> list)
	{
		Iterator<EmployeePojo> numIt = list.iterator();
		EmployeePojo pojo;
		while(numIt.hasNext())
		{
			pojo = numIt.next();
			System.out.println("Employee_ID = "+pojo.getEmployeeID());
			System.out.println("Name = "+pojo.getName());
			System.out.println("Mobile = "+pojo.getMobile());
			System.out.println("Email = "+pojo.getEmail());
			System.out.println("Department = "+pojo.getDepartment());
		}
	}
	public void retrieve(Logger logger,Scanner sc) throws SQLException
	{
		DataBaseMethods db = new DataBaseMethods();
		logger.info("Enter the name of the employee");
		String name = sc.nextLine();
		List<EmployeePojo> empList = db.findPojoDetails(name);
		displayEmp(empList);
	}
	public void nEmployee(Logger logger,Scanner sc) throws SQLException
	{
		DataBaseMethods db = new DataBaseMethods();
		logger.info("Enter the number of the employee to show");
		int n = intInput(sc);
		List<EmployeePojo> empList = db.pojoShow(n);
		displayEmp(empList);
	}
	public void nSortedEmployee(Logger logger,Scanner sc) throws SQLException
	{
		DataBaseMethods db = new DataBaseMethods();
		logger.info("Enter the number of the employee to show");
		int no = intInput(sc);
		sc.nextLine();
		logger.info("Enter the name of the column to be sorted by");
		String sortColumn = sc.nextLine();
		logger.info(" Press 1 for ascending order and any other key for descending order ");
		char ch = sc.next().charAt(0);
		String direction;
		if(ch == '1')
		{
			direction = "asc";
		}
		else
		{
			direction = "desc";
		}
		List<EmployeePojo> sortedEmpList = db.sortedPojoShow(no,sortColumn,direction);
		displayEmp(sortedEmpList);
	}
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		DataBaseMethods db = new DataBaseMethods();
		Logger logger = Logger.getLogger("info logger");
		Runner run = new Runner();
		int choice = 0;
		int def = 0;
		try
		{
			while (choice != 13 && def < 10)
			{
				menu(logger);

				choice = run.intInput(sc);
				switch(choice)
				{
				case 1:
					db.create();
					break;
				case 2:
					logger.info("enter the number of employees");
					int noOfEmployee = run.intInput(sc);
					sc.nextLine();
					for(int i=0; i<noOfEmployee; i++)
					{
						logger.info("Enter the Name");
						String employeeName = sc.nextLine();
						logger.info("Enter the Mobile number");
						long Mobile = run.longInput(sc);
						sc.nextLine();
						logger.info("Enter the Email");
						String EMail = sc.nextLine();
						logger.info("Enter the Department");
						String Department = sc.nextLine();
						db.setEmpDetails(employeeName,Mobile,EMail,Department);
					}
					break;
				case 3:
					sc.nextLine();
					logger.info("Enter the name of the employee");
					String name = sc.nextLine();
					List<HashMap<String,Object>> empList = db.findDetails(name);
					Iterator<HashMap<String,Object>> it = empList.iterator();
					while(it.hasNext())
					{
						System.out.println(it.next());
					}
					break;
				case 4:
					sc.nextLine();
					logger.info("Enter the name of the employee");
					String replaceName = sc.nextLine();
					logger.info("Enter the name of the column to be updated");
					String column = sc.nextLine();
					logger.info("Enter the name updated information");
					long mobile = 0;
					if(column.equalsIgnoreCase("mobile"))
					{
						mobile = run.longInput(sc);
						db.updateDB(replaceName,column,mobile);
						break;
					}
					String info = sc.nextLine();
					db.updateDB(replaceName,column,info);
					break;
				case 5:
					logger.info("Enter the number of the employee to show");
					int n = run.intInput(sc);
					List<HashMap<String,Object>> numberedEmpList = db.show(n);
					Iterator<HashMap<String,Object>> numIt = numberedEmpList.iterator();
					while(numIt.hasNext())
					{
						System.out.println(numIt.next());
					}
					break;
				case 6:
					logger.info("Enter the number of the employee to show");
					int no = run.intInput(sc);
					sc.nextLine();
					logger.info("Enter the name of the column to be sorted by");
					String sortColumn = sc.nextLine();
					logger.info(" Press 1 for ascending order and any other key for descending order ");
					char ch = sc.next().charAt(0);
					String direction;
					if(ch == '1')
					{
						direction = "asc";
					}
					else
					{
						direction = "desc";
					}
					List<HashMap<String,Object>> sortedEmpList = db.sortedShow(no,sortColumn,direction);
					Iterator<HashMap<String,Object>> sortIt = sortedEmpList.iterator();
					while(sortIt.hasNext())
					{
						System.out.println(sortIt.next());
					}
					break;
				case 7:
					logger.info("Enter the employee id to be deleted");
					int id = run.intInput(sc);
					db.fire(id);
					logger.info("Enter the number of the employee to show");
					int newNo = run.intInput(sc);
					List<HashMap<String,Object>> deletedEmpList = db.show(newNo);
					Iterator<HashMap<String,Object>> deleteIt = deletedEmpList.iterator();
					while(deleteIt.hasNext())
					{
						
						System.out.println(deleteIt.next());
					}
					break;
				case 8:
					sc.nextLine();
					run.uploadDetails(logger,sc);
					run.retrieve(logger,sc);
					run.nEmployee(logger,sc);
					run.nSortedEmployee(logger,sc);
					break;
				case 9:
					db.createDependTable();
					break;
				case 10:
					logger.info("Enter the employee id of the relations to be added");
					int relationId = run.intInput(sc);
					logger.info("Enter the number of relations of the employee to be added");
					int relationNo = run.intInput(sc);
					sc.nextLine();
					for(int i=0; i<relationNo; i++)
					{
						logger.info("Enter the Name");
						String relationName = sc.nextLine();
						logger.info("Enter the Age");
						int relatioAge = run.intInput(sc);
						sc.nextLine();
						logger.info("Enter the Relationship");
						String relationType = sc.nextLine();
						db.assignRelation(relationId,relationName,relatioAge,relationType);
					}
					break;
				case 11:
					logger.info("Enter 1 to  enter employee id of the relations to be displayed");
					int idOrNot = run.intInput(sc);
					List<Integer> ids = new ArrayList<Integer>();
					if(idOrNot == 1)
					{
						logger.info("Enter the id");
						int identity = run.intInput(sc);
						ids.add(identity);
					}
					else
					{
						sc.nextLine();
						logger.info("Enter the Name");
						String guardian = sc.nextLine();
						ids = db.idOfName(guardian);
					}
					List<HashMap<String,Object>> dependentList = db.getDependent(ids);
					Iterator<HashMap<String,Object>> dependentIt = dependentList.iterator();
					System.out.println("EMPLOYEE_ID\t\tNAME\t\tAGE\t\tRELATIONSHIP");
					while(dependentIt.hasNext())
					{
						System.out.println(dependentIt.next());
					}
					break;
				case 12:
					logger.info("Enter number of employees whose relations are to be displayed");
					int relationNO = run.intInput(sc);
					List<HashMap<String,Object>> mergeList = db.mergedDependent(relationNO);
					Iterator<HashMap<String,Object>> mergeIt = mergeList.iterator();
					while(mergeIt.hasNext())
					{
						System.out.println(mergeIt.next());
					}
					break;
				case 14:
					System.out.println("The program is closing");
					break;
				default:
					logger.info("the choice is invalid");
					def++;
					if(def==9)
					{
						logger.info("9 invalid inputs, if there is 1 more invalid input the program will close ");
					}
					if(def == 10)
					{
						logger.info("10 invalid inputs,the program is closing ");
					}
				}
			}
		}
		catch(SQLException e)
		{
			logger.warning("SQL Exception generated");
		}
		finally
		{
			sc.close();
		}
	}
}
