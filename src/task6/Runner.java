package task6;

import java.util.Scanner;
import check.UserException;
import java.util.List;

public class Runner
{
	public static Scanner sc = new Scanner(System.in);
	private static void menu()
	{
		System.out.println("Choose the operation to be performed");
		System.out.println("\t1. Create an ArrayList & print the size of it");
		System.out.println("\t2. create an ArrayList & add 5 Strings from the command line to it. "
				+ "Print the ArrayList & the size of it");
		System.out.println("\t3. Create an ArrayList & add 5 integers from the command line to it. "
				+ "Print the ArrayList & the size of it");
		System.out.println("\t4. Create an ArrayList & add your custom objects to it. Print the "
				+ "ArrayList & the size of it");
		System.out.println("\t5. Create an ArrayList & add 2 integers, add 3 Strings from "
				+ "command line & 2 custom objects.Print the ArrayList & the size of it");
		System.out.println("\t6. create an ArrayList & add 4 Strings from the command line to it. "
				+ "Then find the index of any one of the already added String. Print the ArrayList & the "
				+ "size of it as well ");
		System.out.println("\t7. create an ArrayList & add 5 Strings from the command line to it. "
				+ "Use the iterator method & for loop to print each element in the ArrayList");
		System.out.println("\t8. create an ArrayList & add Strings from the command line to it. "
				+ "Print the String at a given index in the ArrayList & the size of it");
		System.out.println("\t9. create an ArrayList & add 5 Strings(with duplicates) from the "
				+ "command line to it. Find the first & last position(index) of a duplicate string.");
		System.out.println("\t10. create an ArrayList & add 5 Strings from the command line to it. "
				+ "After that add a given String at the 2nd position of the ArrayList. Print the ArrayList & "
				+ "the size of it as well");
		System.out.println("\t11. create an ArrayList(first ArrayList) & add 10 Strings from the "
				+ "command line to it. Using that ArrayList create a new ArrayList(second ArrayList) "
				+ "with elements from 3 to 8 position of the first ArrayList");
		System.out.println("\t12. Create an ArrayList(first ArrayList) & add n Strings from the "
				+ "command line to it. Create another ArrayList(second ArrayList) with n more Strings "
				+ "from the Command line. Now create another ArrayList (third ArrayLIst) using the "
				+ "above two ArrayLists. Print the third ArrayList & size of it. Note: You should not use a "
				+ "loop to create a 3rd ArrayList");
		System.out.println("\t13. create an ArrayList(first ArrayList) & add 5 Strings from the "
				+ "command line to it. Create another ArrayList(second ArrayList) with 3 more Strings "
				+ "from the Command line. Now create another ArrayList (third ArrayLIst) using theabove "
				+ "two ArrayLists. But all the elements of secondArrayList should be ahead of the "
				+ "first ArrayList elements. Print the third ArrayList & size of it. Note: You should not use "
				+ "a loop to create a 3rd ArrayList");
		System.out.println("\t14. reate an ArrayList & add 5 decimal values from the command "
				+ "line to it. Remove one of the decimal values from the ArrayList.Print the ArrayList & "
				+ "the size of it as well.");
		System.out.println("\t15. create an ArrayList & add 5 decimal values from the command "
				+ "line to it. Remove a decimal value at position 4 from the ArrayList.Print the ArrayList "
				+ "& the size of it as well.");
		System.out.println("\t16. create an ArrayList & add 10 long values from the command line "
				+ "to it. Remove long values from position 4 to 8 from the ArrayList.Print the ArrayList & "
				+ "the size of it as well.Note: You should not use a loop to remove valuest.");
		System.out.println("\t17. create an ArrayList(first ArrayList) & add 5 Strings from the "
				+ "command line to it. Create another ArrayList(second ArrayList) with the same 3 "
				+ "Strings in the previous 5 Strings. Now remove the elements from the first ArrayList "
				+ "which are present in the secondArrayList. Note: You should not use a loop to remove "
				+ "the elements. Print the ArrayList & the size of it as well.");
		System.out.println("\t18. create an ArrayList(first ArrayList) & add 5 Strings from the "
				+ "command line to it. Create another ArrayList(second ArrayList) with the same 3 "
				+ "Strings in the previous 5 Strings. Now remove the elements from the first ArrayList "
				+ "which are not present in the secondArrayList. Note: You should not use a loop to "
				+ "remove the elements. Print the ArrayList & the size of it as well.");
		System.out.println("\t19. create an ArrayList & add 10 long values from the command line\n"
				+ "to it. Remove all the long values from the ArrayLIst.Print the ArrayList & the size of it\n"
				+ "as well.");
		System.out.println("\t20. create an ArrayList & add 5 String values from the command line\n"
				+ "to it. Check whether a given String is present in the ArrayList.Print the ArrayList & the\n"
				+ "size of it as well.");
	}
	public int intInput()
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
				System.out.print("the entered value is not an integer, please input correct value");
				sc.nextLine();
				ex = true;
			}
		}while(ex);
		return choice;
	}
	public float floatInput()
	{
		float choice = 0.0f;
		boolean ex = true;
		do
		{
			try
			{
				choice = sc.nextFloat();
				ex = false;
			}
			catch(Exception e)
			{
				System.out.print("the entered value is not a decimal, please input correct value");
				sc.nextLine();
				ex = true;
			}
		}while(ex);
		return choice;
	}
	public long longInput()
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
				System.out.print("the entered value is not long, please input correct value");
				sc.nextLine();
				ex = true;
			}
		}while(ex);
		return choice;
	}
	private Lion lionInput()
	{
		Lion simba = new Lion();
		System.out.println("Enter the height ");
		int height = intInput();
		System.out.println("Enter the weight ");
		int weight = intInput();
		simba.input(weight,height);
		return simba;
	}
	private String[] multiInput()
	{
		int numOfStrings = 0;
		System.out.println("enter the number of string ");
		numOfStrings = intInput();
		sc.nextLine();
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
		ArrayListMethods list = new ArrayListMethods();
		int choice = 0;
		int def = 0;
		String[] str;
		List<String> arrStringList = list.create("");
		List<String> secondArrList = list.create("");
		List<String> thirdArrList = list.create("");
		while (choice != 21 && def < 10)
		{
			menu();
			choice = run.intInput();
			try
			{
				switch(choice)
				{
				case 1:
					arrStringList = list.create("");
					System.out.println("The length of Array List is " + list.arrLen(arrStringList));
					break;
				case 2:
					str = run.multiInput();
					arrStringList = list.addition(str);
					list.printList(arrStringList);
					System.out.println("The length of Array List is " + list.arrLen(arrStringList));
					break;
				case 3:
					System.out.println("enter the number of integers ");
					int noOfInt = run.intInput();
					Integer[] intNo = new Integer[noOfInt];
					for(int i=0; i<noOfInt; i++)
					{
						System.out.println("enter the number " + (i+1) + " : ");
						intNo[i] = run.intInput();
					}
					List<Integer> arrIntList = list.intAddition(intNo);
					list.printList(arrIntList);
					System.out.println("The length of Array List is " + list.arrLen(arrIntList));
					break;
				case 4:
					System.out.println("enter the number of lions ");
					int noOfLions = run.intInput();
					Lion[] objLion = new Lion[noOfLions];
					for(int i=0; i<noOfLions; i++)
					{
						System.out.println("Enter details of Lion " + (i+1));
						objLion[i] = run.lionInput();
					}
					List<Lion> arrObjList = list.addition(objLion);
					list.printList(arrObjList);
					System.out.println("The length of Array List is " + list.arrLen(arrObjList));
					break;
				case 5:
					str = run.multiInput();
					System.out.println("enter the number of integers ");
					int noOfMixedInt = run.intInput();
					int[] intMixedNo = new int[noOfMixedInt];
					for(int i=0; i<noOfMixedInt; i++)
					{
						System.out.println("enter the number " + (i+1) + " : ");
						intMixedNo[i] = run.intInput();
					}
					System.out.println("enter the number of lions ");
					int noOfMixedLions = run.intInput();
					Lion[] objMixedLion = new Lion[noOfMixedLions];
					for(int i=0; i<noOfMixedLions; i++)
					{
						System.out.println("Enter details of Lion " + (i+1));
						objMixedLion[i] = run.lionInput();
					}
					List<Object> arrMixedList = list.multiAddition(str,intMixedNo,objMixedLion);
					list.printList(arrMixedList);
					System.out.println("The length of Array List is " + list.arrLen(arrMixedList));
					break;
				case 6:
					str = run.multiInput();
					arrStringList = list.addition(str);
					System.out.println("Enter the string to find ");
					String findStr = sc.nextLine();
					int index = list.find(arrStringList,findStr);
					if(index == -1)
					{
						System.out.println("the string does not exist in the list");
					}
					else
					{
						System.out.println("The first index of given string is " + index);
					}
					System.out.println("The length of Array List is " + list.arrLen(arrStringList));
					break;
				case 7:
					str = run.multiInput();
					arrStringList = list.addition(str);
					list.printList(arrStringList);
					return;
				case 8:
					str = run.multiInput();
					arrStringList = list.addition(str);
					System.out.println("Enter the index to be displayed ");
					int pos = run.intInput();
					System.out.println("The string at given index is " + list.show(arrStringList,pos));
					System.out.println("The length of Array List is " + list.arrLen(arrStringList));
					break;
				case 9:
					str = run.multiInput();
					arrStringList = list.addition(str);
					System.out.println("Enter the string duplicate ");
					String dupeStr = sc.nextLine();
					int first = list.find(arrStringList,dupeStr);
					int last = list.findLast(arrStringList,dupeStr);
					if(first == -1)
					{
						System.out.println("the string does not exist in the list");
					}
					else if(last == first)
					{
						System.out.println("the string does not have duplicate in the list");
					}
					else
					{
						System.out.println("The first index of duplicate string is " + first);
						System.out.println("The last index of duplicate string is " + last);
					}
					break;
				case 10:
					str = run.multiInput();
					arrStringList = list.addition(str);
					System.out.println("Enter the string to insert ");
					String insertStr = sc.nextLine();
					System.out.println("Enter the index to insert the string ");
					int insertIndex = run.intInput();
					arrStringList = list.insert(arrStringList,insertStr,insertIndex);
					list.printList(arrStringList);
					break;
				case 11:
					str = run.multiInput();
					arrStringList = list.addition(str);
					System.out.println("Enter the starting index ");
					int startIndex = run.intInput();
					System.out.println("Enter the ending index ");
					int endIndex = run.intInput();
					secondArrList = list.subList(arrStringList,startIndex,endIndex);
					list.printList(secondArrList);
					break;
				case 12:
					str = run.multiInput();
					arrStringList = list.addition(str);
					str = run.multiInput();
					secondArrList = list.addition(str);
					thirdArrList = list.combine(arrStringList,secondArrList);
					list.printList(thirdArrList);
					System.out.println("The length of Array List is " + list.arrLen(thirdArrList));
					break;
				case 13:
					str = run.multiInput();
					arrStringList = list.addition(str);
					str = run.multiInput();
					secondArrList = list.addition(str);
					thirdArrList = list.invCombine(arrStringList,secondArrList);
					list.printList(thirdArrList);
					System.out.println("The length of Array List is " + list.arrLen(thirdArrList));
					break;
				case 14:
					System.out.println("Enter the number of decimal values ");
					int pointNum1 = run.intInput();
					Float[] point = new Float[pointNum1];
					for(int i=0; i<pointNum1; i++)
					{
						point[i] = run.floatInput();
					}
					List<Float> arrPointList = list.intAddition(point);
					System.out.println("Enter the decimal to be deleted ");
					float deleteValue = run.floatInput();
					arrPointList = list.delete(arrPointList,deleteValue);
					list.printList(arrPointList);
					System.out.println("The length of Array List is " + list.arrLen(arrPointList));
					break;
				case 15:
					System.out.println("Enter the number of decimal values ");
					int pointNum2 = run.intInput();
					Float[] decimal = new Float[pointNum2];
					for(int i=0; i<pointNum2; i++)
					{
						decimal[i] = run.floatInput();
					}
					List<Float> arrDecimalList = list.intAddition(decimal);
					System.out.println("Enter the index to be deleted ");
					int deletePos = run.intInput();
					arrDecimalList = list.remove(arrDecimalList,deletePos);
					list.printList(arrDecimalList);
					System.out.println("The length of Array List is " + list.arrLen(arrDecimalList));
					break;
				case 17:
					str = run.multiInput();
					arrStringList = list.addition(str);
					str = run.multiInput();
					secondArrList = list.addition(str);
					thirdArrList = list.exclude(arrStringList,secondArrList);
					list.printList(thirdArrList);
					System.out.println("The length of Array List is " + list.arrLen(thirdArrList));
					break;
				case 18:
					str = run.multiInput();
					arrStringList = list.addition(str);
					str = run.multiInput();
					secondArrList = list.addition(str);
					thirdArrList = list.retain(arrStringList,secondArrList);
					list.printList(thirdArrList);
					System.out.println("The length of Array List is " + list.arrLen(thirdArrList));
					break;
				case 19:
					System.out.println("Enter the number of long values ");
					int bigNum = run.intInput();
					Long[] big = new Long[bigNum];
					for(int i=0; i<bigNum; i++)
					{
						big[i] = run.longInput();
					}
					List<Long> bigList = list.intAddition(big);
					bigList = list.empty(bigList);
					list.printList(bigList);
					System.out.println("The length of Array List is " + list.arrLen(bigList));
					break;
				case 20:
					str = run.multiInput();
					arrStringList = list.addition(str);
					System.out.println("Enter the string to find ");
					String searchStr = sc.nextLine();
					boolean check = list.contain(arrStringList,searchStr);
					if(check)
					{
						System.out.println("The list contains the string ");
					}
					else
					{
						System.out.println("The list does not contain the string ");
					}
					list.printList(arrStringList);
					System.out.println("The length of Array List is " + list.arrLen(arrStringList));
					break;
				case 21:
					System.out.println("The program is closing");
					sc.close();
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
						sc.close();
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
