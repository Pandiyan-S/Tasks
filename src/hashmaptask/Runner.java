package hashmaptask;

import java.util.Scanner;
import check.UserException;
import java.util.Map;

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
		while (choice != 21 && def < 10)
		{
			menu();
			choice = run.intInput();
			try
			{
				switch(choice)
				{
				case 1:
					Map<String,String> hmString = map.createStrHM();
					map.display(hmString);
					System.out.println("The length of Hash map is " + map.mapLength(hmString));
					break;
				case 2:
					System.out.println("Enter the number of pairs to be added ");
					noOfPairs = run.intInput();
					sc.nextLine();
					String keyString;
					String valueString;
					Map<String,String> hmEntryString = map.createStrHM();
					for(int i=0; i<noOfPairs; i++)
					{
						System.out.println("Enter pair " + (i+1));
						System.out.println("Enter string ");
						keyString = sc.nextLine();
						System.out.println("Enter string ");
						valueString = sc.nextLine();
						map.add(hmEntryString,keyString,valueString);
					}
					map.display(hmEntryString);
					System.out.println("The length of Hash map is " + map.mapLength(hmEntryString));
					break;
				case 3:
					System.out.println("Enter the number of pairs to be added ");
					noOfPairs = run.intInput();
					Integer keyInt;
					Integer valueInt;
					Map<Integer,Integer> hmInt = map.createIntHM();
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
					Map<String,Integer> hmStringInt = map.createStrIntHM();
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
					Map<String,Lion> hmStringObj = map.createStrObjHM();
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
					Map<String,String> hmNuullValueString = map.createStrHM();
					map.add(hmNuullValueString,"First","one");
					map.add(hmNuullValueString,"Second","two");
					map.add(hmNuullValueString,"Third",null);
					map.display(hmNuullValueString);
					System.out.println("The length of Hash map is " + map.mapLength(hmNuullValueString));
					break;
				case 7:
					Map<String,String> hmNullKeyString = map.createStrHM();
					map.add(hmNullKeyString,"First","one");
					map.add(hmNullKeyString,"Second","two");
					map.add(hmNullKeyString,null,"three");
					map.display(hmNullKeyString);
					System.out.println("The length of Hash map is " + map.mapLength(hmNullKeyString));
					break;
				case 8:
					Map<String,String> hmHasKeyString = map.createStrHM();
					map.add(hmHasKeyString,"First","one");
					map.add(hmHasKeyString,"Second","two");
					map.add(hmHasKeyString,"Third","three");
					if(map.keyChecker(hmHasKeyString,"Third"))
					{
						System.out.println("The value exists in the hashmap ");
					}
					else
					{
						System.out.println("The value does not exist in the hashmap ");
					}
					break;
				case 9:
					Map<String,String> hmHasValueString = map.createStrHM();
					map.add(hmHasValueString,"First","one");
					map.add(hmHasValueString,"Second","two");
					map.add(hmHasValueString,"Third","three");
					if(map.valueChecker(hmHasValueString,"Three"))
					{
						System.out.println("The value exists in the hashmap ");
					}
					else
					{
						System.out.println("The value does not exist in the hashmap ");
					}
					break;
				case 10:
					Map<String,String> hmReplaceString = map.createStrHM();
					map.add(hmReplaceString,"First","one");
					map.add(hmReplaceString,"Second","two");
					map.add(hmReplaceString,"Third","three");
					map.display(hmReplaceString);
					System.out.println("The length of Hash map is " + map.mapLength(hmReplaceString));
					map.add(hmReplaceString,"First","1");
					map.add(hmReplaceString,"Second","2");
					map.add(hmReplaceString,"Third","3");
					map.display(hmReplaceString);
					System.out.println("The length of Hash map is " + map.mapLength(hmReplaceString));
					break;
				case 11:
					Map<String,String> hmCorrectKeyString = map.createStrHM();
					map.add(hmCorrectKeyString,"First","one");
					map.add(hmCorrectKeyString,"Second","two");
					map.add(hmCorrectKeyString,"Third","three");
					System.out.println("The value is " + map.getValue(hmCorrectKeyString, "First"));
					break;
				case 12:
					Map<String,String> hmIncorrectKeyString = map.createStrHM();
					map.add(hmIncorrectKeyString,"First","one");
					map.add(hmIncorrectKeyString,"Second","two");
					map.add(hmIncorrectKeyString,"Third","three");
					System.out.println("The value is " + map.getValue(hmIncorrectKeyString, "Fourth"));
					break;
				case 13:
					Map<String,String> hmDefaultString = map.createStrHM();
					map.add(hmDefaultString,"First","one");
					map.add(hmDefaultString,"Second","two");
					map.add(hmDefaultString,"Third","three");
					System.out.println("The value is " + map.getDefaultValue(hmDefaultString, "Fourth"));
					break;
				case 14:
					Map<String,String> hmKeyRemoveString = map.createStrHM();
					map.add(hmKeyRemoveString,"First","one");
					map.add(hmKeyRemoveString,"Second","two");
					map.add(hmKeyRemoveString,"Third","three");
					map.display(hmKeyRemoveString);
					System.out.println("The length of Hash map is " + map.mapLength(hmKeyRemoveString));
					map.remove(hmKeyRemoveString,"First");
					map.display(hmKeyRemoveString);
					System.out.println("The length of Hash map is " + map.mapLength(hmKeyRemoveString));
					break;
				case 15:
					Map<String,String> hmIfMatchRemoveString = map.createStrHM();
					map.add(hmIfMatchRemoveString,"First","one");
					map.add(hmIfMatchRemoveString,"Second","two");
					map.add(hmIfMatchRemoveString,"Third","three");
					map.display(hmIfMatchRemoveString);
					System.out.println("The length of Hash map is " + map.mapLength(hmIfMatchRemoveString));
					map.removeIfExist(hmIfMatchRemoveString,"First","three");
					map.display(hmIfMatchRemoveString);
					System.out.println("The length of Hash map is " + map.mapLength(hmIfMatchRemoveString));
					map.removeIfExist(hmIfMatchRemoveString,"First","one");
					map.display(hmIfMatchRemoveString);
					System.out.println("The length of Hash map is " + map.mapLength(hmIfMatchRemoveString));
					break;
				case 16:
					Map<String,String> hmReplaceKeyString = map.createStrHM();
					map.add(hmReplaceKeyString,"First","one");
					map.add(hmReplaceKeyString,"Second","two");
					map.add(hmReplaceKeyString,"Third","three");
					map.display(hmReplaceKeyString);
					System.out.println("The length of Hash map is " + map.mapLength(hmReplaceKeyString));
					map.replace(hmReplaceKeyString,"First","3");
					map.display(hmReplaceKeyString);
					System.out.println("The length of Hash map is " + map.mapLength(hmReplaceKeyString));
					break;
				case 17:
					Map<String,String> hmIfMatchReplaceString = map.createStrHM();
					map.add(hmIfMatchReplaceString,"First","one");
					map.add(hmIfMatchReplaceString,"Second","two");
					map.add(hmIfMatchReplaceString,"Third","three");
					map.display(hmIfMatchReplaceString);
					System.out.println("The length of Hash map is " + map.mapLength(hmIfMatchReplaceString));
					map.replaceIfMatch(hmIfMatchReplaceString,"First","one","3");
					map.display(hmIfMatchReplaceString);
					System.out.println("The length of Hash map is " + map.mapLength(hmIfMatchReplaceString));
					map.replaceIfMatch(hmIfMatchReplaceString,"Second","one","3");
					map.display(hmIfMatchReplaceString);
					System.out.println("The length of Hash map is " + map.mapLength(hmIfMatchReplaceString));
					break;
				case 18:
					Map<String,String> hmTransferString = map.createStrHM();
					map.add(hmTransferString,"First","one");
					map.add(hmTransferString,"Second","two");
					map.add(hmTransferString,"Third","three");
					map.display(hmTransferString);
					System.out.println("The length of Hash map is " + map.mapLength(hmTransferString));
					Map<String,String> hmSecondString = map.createStrHM();
					map.add(hmSecondString,"Fourth","four");
					map.add(hmSecondString,"Fifth","five");
					map.add(hmSecondString,"First","six");
					map.display(hmSecondString);
					System.out.println("The length of Hash map is " + map.mapLength(hmSecondString));
					map.join(hmTransferString,hmSecondString);
					map.display(hmTransferString);
					System.out.println("The length of Hash map is " + map.mapLength(hmTransferString));
					break;
				case 19:
					Map<String,String> hmIterateString = map.createStrHM();
					map.add(hmIterateString,"First","one");
					map.add(hmIterateString,"Second","two");
					map.add(hmIterateString,"Third","three");
					map.elementDisplay(hmIterateString);
					break;
				case 20:
					Map<String,String> hmDeleteString = map.createStrHM();
					map.add(hmDeleteString,"First","one");
					map.add(hmDeleteString,"Second","two");
					map.add(hmDeleteString,"Third","three");
					map.display(hmDeleteString);
					System.out.println("The length of Hash map is " + map.mapLength(hmDeleteString));
					map.clear(hmDeleteString);
					map.display(hmDeleteString);
					System.out.println("The length of Hash map is " + map.mapLength(hmDeleteString));
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
