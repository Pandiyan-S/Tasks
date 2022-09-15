package beginnerstring;

import java.util.Scanner;
public class Runner
{
	private static void menu()
	{
		System.out.println("Choose the operation to be performed");
		System.out.println("\t0. enter a string to perform the operations");
		System.out.println("\t1. find the length of string");
		System.out.println("\t2. convert a string to char array");
		System.out.println("\t3. find the penultimate character");
		System.out.println("\t4. find the number of occurances of the given characters");
		System.out.println("\t5. find the greatest position of a character");
		System.out.println("\t6. print last n charactetrs of a string");
		System.out.println("\t7. print first n charactetrs of a string");
		System.out.println("\t8. replace first 3 charactetrs of a string with a given string");
		System.out.println("\t9. check if a string starts with a given string");
		System.out.println("\t10. check whether a String ends with a given string");
		System.out.println("\t11. convert an all lowercase string to an uppercase string");
		System.out.println("\t12. convert an all uppercase string to an lowercase string");
		System.out.println("\t13. reverse a String");
		System.out.println("\t14. accept a line with multiple Strings");
		System.out.println("\t15. accept a line with multiple Strings and remove entered string");
		System.out.println("\t16. accept a line with multiple Strings & enclose each String into a String array");
		System.out.println("\t17. accept multiple Strings & merge each String with “-” in between");
		System.out.println("\t18. check whether the two given input String are equal -case sensitive");
		System.out.println("\t19. check whether the two given input String are equal -case in sensitive");
		System.out.println("\t20. remove space at the beginning or end.");
		System.out.println("\t21. Exit");
	}
	private void display(String str)
	{
		if(str == "")
		{
			System.out.println("The string is empty");
		}
		else
		{
			System.out.println("The string is " + str);
		}
	}
	public int intInput()
	{
		Scanner sc = new Scanner(System.in);
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
				System.out.print("the entered value is not an integer, please input correct value");
				sc.nextLine();
				ex = true;
			}
		}while(ex);
		return choice;
	}
	public static void main(String[] args)
	{
		Runner run = new Runner();
		Scanner sc = new Scanner(System.in);
		String123 s1 = new String123();
		int choice = 0;
		int def=0;
		int noOfLoops = 0;
		boolean ex = false;
		String mainString;
		try
		{
			mainString = args[0];
		}
		catch(Exception e)
		{
			System.out.println("please enter the string ");
			mainString = "";
		}
		while (choice != 21 && def < 10)
		{
			menu();
			run.display(mainString);
			choice = run.intInput();
			switch(choice)
			{
			case 0:
				System.out.print("enter the string");
				sc.nextLine();
				mainString = sc.nextLine();
				break;
			case 1:
				try
				{
					System.out.println(s1.getLen(mainString));
				}
				catch(UserException e)
				{
					System.out.println(e);
				}
				break;
			case 2:
				try
				{
					char[] chararr = s1.toCharArr(mainString);
					System.out.println("the array elements are");
					for(int i=0;i<s1.getLen(mainString);i++)
					{
						System.out.println(chararr[i]);
					}
				}
				catch(UserException e)
				{
					System.out.println(e);
				}
				break;
			case 3:
				int back = 0;
				System.out.println("enter which position from the last should be printed ");
				back = run.intInput();
				try
				{
					System.out.println("the charecter " + back + " from last is "+s1.nUltimate(back,mainString));
				}
				catch(UserException e)
				{
					System.out.println(e);
				}
				break;
			case 4:
				System.out.println("enter the chracter ");
				String character1 = sc.next();
				char ch1 = character1.charAt(0);
				try
				{
					int fo = s1.findOcc(ch1,mainString);
					System.out.println("the number of occurances of "+ ch1 +" is " + fo);
				}
				catch(UserException e)
				{
					System.out.println(e);
				}
				break;
			case 5:
				System.out.println("enter the chracter ");
				String character2 = sc.next();
				char ch2 = character2.charAt(0);
				try
				{
					int gp = s1.greatestPos(ch2,mainString);
					if(gp == -1)
					{
						System.out.println(ch2 +" doesn't exist in the entered string ");
					}
					else
					{
						System.out.println("the greatest position of "+ ch2 +" is " + gp);
					}
				}
				catch(UserException e)
				{
					System.out.println(e);
				}
				break;
			case 6:
				int last = 0;
				System.out.println("enter how many charecters from the last should be printed ");
				last = run.intInput();
				try
				{
					System.out.println("the last characters are ");
					System.out.println(s1.lastN(last, mainString));
				}
				catch(UserException e)
				{
					System.out.println(e);
				}
				break;
			case 7:
				int first = 0;
				System.out.println("enter how many charecters from the first should be printed ");
				first = run.intInput();
				try
				{
					System.out.println("the first characters are ");
					System.out.println(s1.firstN(first,mainString));
				}
				catch(UserException e)
				{
					System.out.println(e);
				}
				break;
			case 8:
				System.out.println("enter string that has to replace the existing string");
				sc.nextLine();
				String replaceLine = sc.nextLine();
				try
				{
					mainString = s1.replace(mainString,replaceLine);
					run.display(mainString);
					
				}
				catch(UserException e)
				{
					System.out.println(e);
				}
				break;
			case 9:
				System.out.println("enter string that you think is the prefix");
				sc.nextLine();
				String beg = sc.nextLine();
				try
				{
					if(s1.isBeginningWith(mainString,beg))
					{
						System.out.println("YES, the string begins with " + beg);
					}
					else
					{
						System.out.println("NO, the string doesn't begins with " + beg);
					}
					
				}
				catch(UserException e)
				{
					System.out.println(e);
				}
				break;
			case 10:
				System.out.println("enter string that you think is the suffix");
				sc.nextLine();
				String end = sc.nextLine();
				try
				{
					if(s1.isEndingWith(mainString,end))
					{
						System.out.println("YES, the string ends with " + end);
					}
					else
					{
						System.out.println("NO, the string doesn't end with " + end);
					}
					
				}
				catch(UserException e)
				{
					System.out.println(e);
				}
				break;
			case 11:
				try
				{
					mainString = s1.convertToUpper(mainString);
					run.display(mainString);
					
				}
				catch(UserException e)
				{
					System.out.println(e);
				}
				break;
			case 12:
				try
				{
					mainString = s1.convertToLower(mainString);
					run.display(mainString);
					
				}
				catch(UserException e)
				{
					System.out.println(e);
				}
				break;
			case 13:
				try
				{
					mainString = s1.reverse(mainString);
					run.display(mainString);
				}
				catch(UserException e)
				{
					System.out.println(e);
				}
				break;
			case 14:
				System.out.println("enter the new string ");
				sc.nextLine();
				mainString = sc.nextLine();
				run.display(mainString);
				break;
			case 15:
				System.out.println("enter the new string ");
				sc.nextLine();
				mainString = sc.nextLine();
				System.out.println("enter string that has to be removed ");
				String delete = sc.nextLine();
				try
				{
					mainString = s1.remove(mainString,delete);
					run.display(mainString);
				}
				catch(UserException e)
				{
					System.out.println(e);
				}
				break;
			case 16:
				System.out.println("enter the new string ");
				sc.nextLine();
				mainString = sc.nextLine();
				System.out.println("enter string on which the original string is split ");
				String splt = sc.nextLine();
				try
				{
					String[] part = s1.splitString(mainString,splt);
					if(part.length != 0)
					{
						System.out.println("the array elements are ");
					}
					for(int i=0; i<part.length ; i++)
					{
						System.out.println(part[i]);
					}
				}
				catch(UserException e)
				{
					System.out.println(e);
				}
				break;
			case 17:
				int no = 0;
				System.out.println("enter the number of strings to be added ");
				no = run.intInput();
				String[] merger = new String[no];
				sc.nextLine();
				boolean trial = false;
				for(int i=0; i<no ; i++)
				{
					System.out.println("Enter string no " + (i+1));
					merger[i] = sc.next();
				}
				try
				{
					mainString = s1.mergeString(no,merger);
					run.display(mainString);
				}
				catch(Exception e)
				{
					System.out.println(e);
				}
				break;
			case 18:
				System.out.println("enter the 1st string ");
				sc.nextLine();
				String str1 = sc.nextLine();
				System.out.println("enter the 2nd string ");
				String str2 = sc.nextLine();
				try
				{
					if(s1.csComp(str1,str2))
					{
						System.out.println("YES, the 2 strings are equal ");
					}
					else
					{
						System.out.println("NO, the 2 strings are not equal ");
					}
				}
				catch(UserException e)
				{
					System.out.println(e);
				}
				break;
			case 19:
				System.out.println("enter the 1st string ");
				sc.nextLine();
				String str3 = sc.nextLine();
				System.out.println("enter the 2nd string ");
				String str4 = sc.nextLine();
				try
				{
					if(s1.ncsComp(str3,str4))
					{
						System.out.println("YES, the 2 strings are equal ");
					}
					else
					{
						System.out.println("NO, the 2 strings are not equal ");
					}
				}
				catch(UserException e)
				{
					System.out.println(e);
				}
				break;
			case 20:
				try
				{
					mainString = s1.correct(mainString);
					run.display(mainString);
				}
				catch(UserException e)
				{
					System.out.println(e);
				}
				break;
			case 21:
				System.out.println("The program is closing");
				break;
			default:
				System.out.println("the choice is invalid");
				def++;
				if(def==9)
				{
					System.out.println("9 invalid inputs, if one more invalid input is entered the program will shut down ");
				}
				if(def == 10)
				{
					System.out.println("10 invalid inputs,the program is shutting down ");
				}
			}
		}
		
	}
}
