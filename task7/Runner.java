package task7;

import java.util.Scanner;
import check.UserException;
import java.util.HashMap;

public class Runner
{
	private static Scanner sc = new Scanner(System.in);
	private static void menu()
	{
		System.out.println("Choose the operation to be performed");;
		System.out.println("\t1. create a HashMap. Print the HashMap & it’s size.");
		System.out.println("\t2. create a HashMap & add 3 pairs of keys(String) & values(String). "
				+ "Print the HashMap & it’s size.");
		System.out.println("\t3. create a HashMap & add 3 pairs of keys(Integer) & values(Integer). "
				+ "Print the HashMap & it’s size");
		System.out.println("\t4. create a HashMap & add 3 pairs of keys(String) & values(Integer). "
				+ "Print the HashMap & it’s size");
		System.out.println("\t5. create a HashMap & add 3 pairs of keys(String) & value(your own object). "
				+ "Print the HashMap & it’s size");
		System.out.println("\t6. create a HashMap & add 3 keys(String). With a null value to one "
				+ "of the keys.. Print the HashMap & it’s size");
		System.out.println("\t7. create a HashMap & add a null key & non null value to it. Print the "
				+ "HashMap & it’s size.");
		System.out.println("\t8. check a key exists in a HashMap");
		System.out.println("\t9. check a value exists in a HashMap");
		System.out.println("\t10. create a HashMap & add 3 pairs of keys(String) & values(String). "
				+ "Now change the values for all the 3 keys. Print the HashMap & it’s size before & after "
				+ "the change.");
		System.out.println("\t11. get the value of a existing key in a HashMap");
		System.out.println("\t12. get the value of a non existing key in a HashMap");
		System.out.println("\t13. return “Zoho” as a value for a given non existing key in a HashMap."
				+ "Print the HashMap & it’s size before & after the change.");
		System.out.println("\t14. remove an existing key in a HashMap.Print the HashMap & it’s size before "
				+ "& after the change.");
		System.out.println("\t15. remove an existing key only if it’s value matches with the given value in "
				+ "a HashMap.Print the HashMap & it’s size before & after the change.");
		System.out.println("\t16. replace the value of an existing key in a HashMap.Print the HashMap & "
				+ "it’s size before & after the change.");
		System.out.println("\t17. replace the value of an existing key only if it’s value matches with "
				+ "the given value in a HashMap.Print the HashMap & it’s size before & after the change.");
		System.out.println("\t18. transfer all the keys & values of a HashMap to another HashMapwhich has 3 pairs "
				+ "of keys & values already. Print both the HashMaps & their size before & after the change.");
		System.out.println("\t19. terate over a HashMap & print all it’s key & its corresponding value.");
		System.out.println("\t20. remove all entries in a HashMap.Print both the HashMaps & their\n"
				+ "size before & after the change");
		System.out.println("\t21.Exit");
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
	public static void main(String[] args)
	{
		Runner run = new Runner();
		HashMapMethods map = new HashMapMethods();
		int choice = 0;
		int def = 0;
		int noOfPairs = 0;
		HashMap<String,String> hmString;
		HashMap<Integer,Integer> hmInt;
		HashMap<String,Integer> hmStringInt;
		HashMap<String,Lion> hmStringObj;
		while (choice != 21 && def < 10)
		{
			menu();
			choice = run.intInput();
			try
			{
				switch(choice)
				{
				case 1:
					hmString = map.create(" "," ");
					map.display(hmString);
					System.out.println("The length of Hash map is " + map.mapLength(hmString));
					break;
				case 2:
					System.out.println("Enter the number of pairs to be added ");
					noOfPairs = run.intInput();
					sc.nextLine();
					String keyString;
					String valueString;
					hmString = map.create("", "");
					for(int i=0; i<noOfPairs; i++)
					{
						System.out.println("Enter pair " + (i+1));
						System.out.println("Enter string ");
						keyString = sc.nextLine();
						System.out.println("Enter string ");
						valueString = sc.nextLine();
						map.add(hmString,keyString,valueString);
					}
					map.display(hmString);
					System.out.println("The length of Hash map is " + map.mapLength(hmString));
					break;
				case 3:
					System.out.println("Enter the number of pairs to be added ");
					noOfPairs = run.intInput();
					Integer keyInt;
					Integer valueInt;
					hmInt = map.create(def, def);
					for(int i=0; i<noOfPairs; i++)
					{
						System.out.println("Enter pair " + (i+1));
						System.out.println("Enter integer ");
						keyInt = run.intInput();
						System.out.println("Enter integer ");
						valueInt = run.intInput();
						map.add(hmInt,keyInt,valueInt);
					}
					map.display(hmInt);
					System.out.println("The length of Hash map is " + map.mapLength(hmInt));
					break;
				case 4:
					System.out.println("Enter the number of pairs to be added ");
					noOfPairs = run.intInput();
					sc.nextLine();
					String keyStringInt;
					Integer valueStringInt;
					hmStringInt = map.create("", def);
					for(int i=0; i<noOfPairs; i++)
					{
						System.out.println("Enter pair " + (i+1));
						System.out.println("Enter string ");
						keyStringInt = sc.nextLine();
						System.out.println("Enter integer ");
						valueStringInt = run.intInput();
						sc.nextLine();
						map.add(hmStringInt,keyStringInt,valueStringInt);
					}
					map.display(hmStringInt);
					System.out.println("The length of Hash map is " + map.mapLength(hmStringInt));
					break;
				case 5:
					System.out.println("Enter the number of pairs to be added ");
					noOfPairs = run.intInput();
					sc.nextLine();
					String keyStringObj;
					Lion valueStringObj;
					Lion simba = null;
					hmStringObj = map.create("", simba);
					for(int i=0; i<noOfPairs; i++)
					{
						System.out.println("Enter pair " + (i+1));
						System.out.println("Enter string ");
						keyStringObj = sc.nextLine();
						System.out.println("Enter Lion ");
						valueStringObj = run.lionInput();
						sc.nextLine();
						map.add(hmStringObj,keyStringObj,valueStringObj);
					}
					map.display(hmStringObj);
					System.out.println("The length of Hash map is " + map.mapLength(hmStringObj));
					break;
				case 6:
					hmString = map.create("", "");
					map.add(hmString,"First","one");
					map.add(hmString,"Second","two");
					map.add(hmString,"Third",null);
					map.display(hmString);
					System.out.println("The length of Hash map is " + map.mapLength(hmString));
					break;
				case 7:
					hmString = map.create("", "");
					map.add(hmString,"First","one");
					map.add(hmString,"Second","two");
					map.add(hmString,null,"three");
					map.display(hmString);
					System.out.println("The length of Hash map is " + map.mapLength(hmString));
					break;
				case 8:
					hmString = map.create("", "");
					map.add(hmString,"First","one");
					map.add(hmString,"Second","two");
					map.add(hmString,"Third","three");
					if(map.keyChecker(hmString,"Third"))
					{
						System.out.println("The value exists in the hashmap ");
					}
					else
					{
						System.out.println("The value does not exist in the hashmap ");
					}
					break;
				case 9:
					hmString = map.create("", "");
					map.add(hmString,"First","one");
					map.add(hmString,"Second","two");
					map.add(hmString,"Third","three");
					if(map.valueChecker(hmString,"Three"))
					{
						System.out.println("The value exists in the hashmap ");
					}
					else
					{
						System.out.println("The value does not exist in the hashmap ");
					}
					break;
				case 10:
					hmString = map.create("", "");
					map.add(hmString,"First","one");
					map.add(hmString,"Second","two");
					map.add(hmString,"Third","three");
					map.display(hmString);
					System.out.println("The length of Hash map is " + map.mapLength(hmString));
					String[] replacekeys = {"First","Second","Third"};
					String[] replaceValues = {"1","2","3"};
					map.change(hmString,replacekeys,replaceValues);
					map.display(hmString);
					System.out.println("The length of Hash map is " + map.mapLength(hmString));
					break;
				case 11:
					hmString = map.create("", "");
					map.add(hmString,"First","one");
					map.add(hmString,"Second","two");
					map.add(hmString,"Third","three");
					System.out.println("The value is " + map.getValue(hmString, "First"));
					break;
				case 12:
					hmString = map.create("", "");
					map.add(hmString,"First","one");
					map.add(hmString,"Second","two");
					map.add(hmString,"Third","three");
					System.out.println("The value is " + map.getValue(hmString, "Fourth"));
					break;
				case 13:
					hmString = map.create("", "");
					map.add(hmString,"First","one");
					map.add(hmString,"Second","two");
					map.add(hmString,"Third","three");
					System.out.println("The value is " + map.getDefaultValue(hmString, "Fourth"));
					break;
				case 14:
					hmString = map.create("", "");
					map.add(hmString,"First","one");
					map.add(hmString,"Second","two");
					map.add(hmString,"Third","three");
					map.display(hmString);
					System.out.println("The length of Hash map is " + map.mapLength(hmString));
					map.remove(hmString,"First");
					map.display(hmString);
					System.out.println("The length of Hash map is " + map.mapLength(hmString));
					break;
				case 15:
					hmString = map.create("", "");
					map.add(hmString,"First","one");
					map.add(hmString,"Second","two");
					map.add(hmString,"Third","three");
					map.display(hmString);
					System.out.println("The length of Hash map is " + map.mapLength(hmString));
					map.removeIfExist(hmString,"First","three");
					map.display(hmString);
					System.out.println("The length of Hash map is " + map.mapLength(hmString));
					map.removeIfExist(hmString,"First","one");
					map.display(hmString);
					System.out.println("The length of Hash map is " + map.mapLength(hmString));
					break;
				case 16:
					hmString = map.create("", "");
					map.add(hmString,"First","one");
					map.add(hmString,"Second","two");
					map.add(hmString,"Third","three");
					map.display(hmString);
					System.out.println("The length of Hash map is " + map.mapLength(hmString));
					map.replace(hmString,"First","3");
					map.display(hmString);
					System.out.println("The length of Hash map is " + map.mapLength(hmString));
					break;
				case 17:
					hmString = map.create("", "");
					map.add(hmString,"First","one");
					map.add(hmString,"Second","two");
					map.add(hmString,"Third","three");
					map.display(hmString);
					System.out.println("The length of Hash map is " + map.mapLength(hmString));
					map.replaceIfMatch(hmString,"First","one","3");
					map.display(hmString);
					System.out.println("The length of Hash map is " + map.mapLength(hmString));
					map.replaceIfMatch(hmString,"Second","one","3");
					map.display(hmString);
					System.out.println("The length of Hash map is " + map.mapLength(hmString));
					break;
				case 18:
					hmString = map.create("", "");
					map.add(hmString,"First","one");
					map.add(hmString,"Second","two");
					map.add(hmString,"Third","three");
					map.display(hmString);
					System.out.println("The length of Hash map is " + map.mapLength(hmString));
					HashMap<String,String> hmSecondString = map.create("", "");
					map.add(hmSecondString,"Fourth","four");
					map.add(hmSecondString,"Fifth","five");
					map.add(hmSecondString,"First","six");
					map.display(hmSecondString);
					System.out.println("The length of Hash map is " + map.mapLength(hmSecondString));
					map.join(hmString,hmSecondString);
					map.display(hmString);
					System.out.println("The length of Hash map is " + map.mapLength(hmString));
					break;
				case 19:
					hmString = map.create("", "");
					map.add(hmString,"First","one");
					map.add(hmString,"Second","two");
					map.add(hmString,"Third","three");
					map.elementDisplay(hmString);
					break;
				case 20:
					hmString = map.create("", "");
					map.add(hmString,"First","one");
					map.add(hmString,"Second","two");
					map.add(hmString,"Third","three");
					map.display(hmString);
					System.out.println("The length of Hash map is " + map.mapLength(hmString));
					map.clear(hmString);
					map.display(hmString);
					System.out.println("The length of Hash map is " + map.mapLength(hmString));
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
