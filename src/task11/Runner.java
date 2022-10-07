package task11;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
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
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		RegExMethods rex = new RegExMethods();
		Logger logger = Logger.getLogger("info logger");
		Runner run = new Runner();
		int choice = 0;
		int def = 0;
		try
		{
			while (choice != 9 && def < 10)
			{
				menu(logger);

				choice = run.intInput(sc);
				switch(choice)
				{
				case 1:
					sc.nextLine();
					logger.info("Enter the mobile number ");
					String mobile;
					do
					{
					mobile = sc.nextLine();
					}while(!rex.isDigit(mobile));
					if(rex.isMobileValid(mobile))
					{
						logger.info("The mobile number is valid");
					}
					else
					{
						logger.info("The mobile number is not valid");
					}
					break;
				case 2:
					sc.nextLine();
					logger.info("Enter the string ");
					String str = sc.nextLine();
					
					if(rex.isAlphaNum(str))
					{
						logger.info("The string is Alpha Numeric");
					}
					else
					{
						logger.info("The string is not Alpha Numeric");
					}
					break;
				case 3:
					sc.nextLine();
					logger.info("Enter the given string ");
					String givenStr = sc.nextLine();
					logger.info("Enter the matching string ");
					String matchingStr = sc.nextLine();
					if(rex.isStartingWith(givenStr,matchingStr))
					{
						logger.info("The given string starts with the matching string ");
					}
					else
					{
						logger.info("The given string does not start with the matching string ");
					}
					if(rex.contains(givenStr,matchingStr))
					{
						logger.info("The given string contains the matching string ");
					}
					else
					{
						logger.info("The given string does not contains the matching string ");
					}
					if(rex.isEndingWith(givenStr,matchingStr))
					{
						logger.info("The given string ends with the matching string ");
					}
					else
					{
						logger.info("The given string does not end with the matching string ");
					}
					if(rex.isMatchingWith(givenStr,matchingStr))
					{
						logger.info("The given string is an exact match ");
					}
					else
					{
						logger.info("The given string is not an exact match ");
					}
					break;
				case 4:
					logger.info("Enter the number of strings ");
					int strNo = run.intInput(sc);
					List<String> list = new ArrayList<String>();
					sc.nextLine();
					logger.info("Enter the strings ");
					for(int i=0; i<strNo; i++)
					{
						String line = sc.nextLine();
						list.add(line);
					}
					logger.info("Enter the matching string ");
					String matchStr = sc.nextLine();
					Iterator<String> it = list.iterator();
					while(it.hasNext())
					{
						String give = it.next();
						if(rex.isMatchingInsensitiveWith(give, matchStr))
						{
							logger.info("The string " + give +" matches with " + matchStr);
						}
					}
					break;
				case 5:
					sc.nextLine();
					logger.info("Enter the given email ");
					String email = sc.nextLine();
					if(rex.isEmailValid(email))
					{
						logger.info("The given email is valid ");
					}
					else
					{
						logger.info("The given email is not valid ");
					}
					break;
				case 6:
					logger.info("Enter the number of strings ");
					int rangeStrNo = run.intInput(sc);
					List<String> rangeList = new ArrayList<String>();
					sc.nextLine();
					logger.info("Enter the strings ");
					for(int i=0; i<rangeStrNo; i++)
					{
						String line = sc.nextLine();
						rangeList.add(line);
					}
					if(rex.isWithinRange(rangeList))
					{
						logger.info("All strings are within range ");
					}
					else
					{
						logger.info("All strings are not within range ");
					}
					break;
				case 7:
					logger.info("Enter the number of strings ");
					int StrNo1 = run.intInput(sc);
					List<String> list1 = new ArrayList<String>();
					sc.nextLine();
					logger.info("Enter the strings ");
					for(int i=0; i<StrNo1; i++)
					{
						String line = sc.nextLine();
						list1.add(line);
					}
					logger.info("Enter the number of strings ");
					int StrNo2 = run.intInput(sc);
					List<String> list2 = new ArrayList<String>();
					sc.nextLine();
					logger.info("Enter the strings ");
					for(int i=0; i<StrNo2; i++)
					{
						String line = sc.nextLine();
						list2.add(line);
					}
					Map<String,Integer> hm = rex.makeMap(list1,list2);
					logger.info("The hashmap is ");
					System.out.println(hm);
					break;
				case 8:
					String html = "<p>The <code>President</code> of India is the first\n citizen of our country.</p>";
					List<String> htmlList = rex.getTags(html);
					Iterator<String> htmlIt = htmlList.iterator();
					while(htmlIt.hasNext())
					{
						String line = htmlIt.next();
						logger.info(line);
					}
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
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			sc.close();
		}
	}
}
