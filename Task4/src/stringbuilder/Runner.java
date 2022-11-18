package stringbuilder;

import java.util.Scanner;
public class Runner 
{
	private static void menu()
	{
		System.out.println("Choose the operation to be performed");
		System.out.println("\t1. create a StringBuilder with no String & print the length of it. Then add "
				+ "a String to it & print the length & the final String");
		System.out.println("\t2. create a StringBuilder with a String & print the length of it. Then "
				+ "add n Strings to it & each String separated by a character & print the length & the final "
				+ "String");
		System.out.println("\t3. create a StringBuilder with n Strings with a space in between & "
				+ "print the length of it. Then insert another String in between those Strings & print "
				+ "the length & the final String.");
		System.out.println("\t4. create a StringBuilder with n Strings with a space in between & "
				+ "print the length of it. Then delete the first String & print the length & the final String");
		System.out.println("\t5. reate a StringBuilder with n Strings with a space in between & "
				+ "print the length of it. Then replace the space with a character & print the length & the final "
				+ "String");
		System.out.println("\t6. create a StringBuilder with n Strings with a space in between & "
				+ "print the length of it. Then reverse the string & print the length & the final String");
		System.out.println("\t7. create a StringBuilder with a String(minimum 10 chars) & print the "
				+ "length of it. Then delete the characters from one index to another index & print the length & "
				+ "the final String");
		System.out.println("\t8. create a StringBuilder with a String(minimum 10 chars) & print the "
				+ "length of it. Then replace the characters from an index with the given string & print the "
				+ "length & the final String");
		System.out.println("\t9. create a StringBuilder with n Strings with a “#” in between & print\n"
				+ "the length of it. Then find the index of the first “#” in the StringBuilder");
		System.out.println("\t10. create a StringBuilder with n Strings with a “#” in between & print\n"
				+ "the length of it. Then find the index of the last “#” in the StringBuilder");
		System.out.println("\t11.Exit");

	}
	private void display(StringBuilder str)
	{
		if(str.substring(0) == "")
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
	private String[] multiInput()
	{
		Scanner sc = new Scanner(System.in);
		int numOfStrings = 0;
		System.out.println("enter the number of string ");
		numOfStrings = intInput();
		numOfStrings = Math.abs(numOfStrings);
		String[] Arr = new String[numOfStrings];
		for(int i=0; i<numOfStrings; i++)
		{
			System.out.println("enter string number " + (i+1));
			Arr[i] = sc.nextLine();
		}
		return Arr;
	}
	public static void main(String[] args)
	{
		Runner run = new Runner();
		BuilderMethods build = new BuilderMethods();
		Scanner sc = new Scanner(System.in);
		int choice = 0;
		int numOfStrings = 0;
		int def = 0;
		String line;
		StringBuilder str= build.create();
		while (choice != 11 && def < 10)
		{
			menu();
			choice = run.intInput();
			try
			{
				switch(choice)
				{
				case 1:
					line = "";
					System.out.println("the length of string is " + build.getLength(line));
					System.out.println("enter the string ");
					line = sc.nextLine();
					run.display(new StringBuilder(line));
					System.out.println("the length of string is " + build.getLength(line));
					break;
				case 2:
					System.out.println("enter the number of strings ");
					numOfStrings = run.intInput();
					numOfStrings = Math.abs(numOfStrings);
					System.out.println("enter the character to be inserted ");
					String temp = sc.nextLine();
					char ch = temp.charAt(0);
					String[] strarr = new String[numOfStrings];
					System.out.println("enter string number 1 ");
					strarr[0] = sc.nextLine();
					System.out.println("the length of string 1 is " + build.getLength(strarr[0]));
					for(int i=1; i<numOfStrings; i++)
					{
						System.out.println("enter string number " + (i+1));
						strarr[i] = sc.nextLine();
					}
					StringBuilder joinedLine = build.join(ch,strarr);
					run.display(joinedLine);
					System.out.println("the length of string is " + build.builderLength(joinedLine));
					break;
				case 3:
					String[] lineArr = run.multiInput();
					StringBuilder insertLine = build.join(' ',lineArr);
					run.display(insertLine);
					System.out.println("the length of string is " + build.builderLength(insertLine));
					System.out.println("enter the string to be entered ");
					String midLine = sc.nextLine();
					insertLine = build.insertString(insertLine,midLine);
					run.display(insertLine);
					System.out.println("the length of string is " + build.builderLength(insertLine));
					break;
				case 4:
					String[] deleteArr = run.multiInput();
					StringBuilder deleteLine = build.join(' ',deleteArr);
					run.display(deleteLine);
					System.out.println("the length of string is " + build.builderLength(deleteLine));
					deleteLine = build.deleteFirstString(deleteLine);
					run.display(deleteLine);
					System.out.println("the length of string is " + build.builderLength(deleteLine));
					break;
				case 5:
					String[] replaceArr = run.multiInput();
					StringBuilder replaceLine = build.join(' ',replaceArr);
					run.display(replaceLine);
					System.out.println("the length of string is " + build.builderLength(replaceLine));
					System.out.println("enter the character to be inserted ");
					String temp2 = sc.nextLine();
					char mid = temp2.charAt(0);
					replaceLine = build.replace(replaceLine,mid);
					run.display(replaceLine);
					System.out.println("the length of string is " + build.builderLength(replaceLine));
					break;
				case 6:
					String[] reverseArr = run.multiInput();
					StringBuilder reverseLine = build.join(' ',reverseArr);
					run.display(reverseLine);
					System.out.println("the length of string is " + build.builderLength(reverseLine));
					reverseLine = build.reverse(reverseLine);
					run.display(reverseLine);
					System.out.println("the length of string is " + build.builderLength(reverseLine));
					break;
				case 7:
					line = "";
					System.out.println("enter the string ");
					line = sc.nextLine();
					str.append(line);
					System.out.println("the length of string is " + build.builderLength(str));
					System.out.println("enter the starting index of string to be deleted ");
					int start = 0;
					int end = 0;
					start = run.intInput();
					start = Math.abs(start);
					System.out.println("enter the ending index of string to be deleted ");
					end = run.intInput();
					end = Math.abs(end);
					try
					{
						str = build.delete(start,end,str);
					}
					catch(UserException e)
					{
						System.out.println(e);
					}
					run.display(str);
					System.out.println("the length of string is " + build.builderLength(str));
					break;
				case 8:
					line = "";
					System.out.println("enter the string ");
					line = sc.nextLine();
					str.append(line);
					System.out.println("the length of string is " + build.builderLength(str));
					System.out.println("enter the string to be replaced ");
					line = "";
					line = sc.nextLine();
					System.out.println("enter the starting index of string to be replaced ");
					int beg = 0;
					beg = run.intInput();
					beg = Math.abs(beg);
					try
					{
						str = build.stringReplace(beg,str,line);
					}
					catch(UserException e)
					{
						System.out.println(e);
					}
					run.display(str);
					System.out.println("the length of string is " + build.builderLength(str));
					break;
				case 9:
					String[] firstSymbolArr = run.multiInput();
					StringBuilder firstSymbolLine = build.join('#',firstSymbolArr);
					run.display(firstSymbolLine);
					System.out.println("the length of string is " + build.builderLength(firstSymbolLine));
					int first = build.firstSymbol(firstSymbolLine);
					if(first == -1)
					{
						System.out.println("# does not exist in the builder ");
					}
					else
					{
						System.out.println("the index of first # is " + first);
					}
				case 10:
					String[] lastSymbolArr = run.multiInput();
					StringBuilder lastSymbolLine = build.join('#',lastSymbolArr);
					run.display(lastSymbolLine);
					System.out.println("the length of string is " + build.builderLength(lastSymbolLine));
					int last = build.lastSymbol(lastSymbolLine);
					if(last == -1)
					{
						System.out.println("# does not exist in the builder ");
					}
					else
					{
						System.out.println("the index of last # is " + last);
					}
				case 11:
					System.out.println("The program is closing");
					break;
				default:
					System.out.println("the choice is invalid");
					def++;
					if(def==9)
					{
						System.out.println("9 invalid inputs, if there is 1 more invalid input the program will shut down ");
					}
					if(def == 10)
					{
						System.out.println("10 invalid inputs,the program is shutting down ");
					}
				}
			}
			catch(UserException e)
			{
				System.out.println(e);
			}
		}
	}
}
