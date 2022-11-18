package task7;

import java.util.Scanner;

import task7.Lion;

import java.util.HashMap;

public class Runner
{
	private static Scanner sc = new Scanner(System.in);
	private static void menu()
	{
		System.out.println("Choose the operation to be performed");;
		System.out.println("\t2. reate an instance for Swift. Using that, call all the setter "
				+ "methods & then all the getter methods in Swift class alone. Print the values returned "
				+ "from the getter methods");
		System.out.println("\t3. create an instance for SCross. Using that, call all the setter "
				+ "methods & then all the getter methods in SCross including superclass methods."
				+ "Print the values returned from the getter methods.");
		System.out.println("\t4. create a method which accepts a Car object as an argument.Try "
				+ "to invoke that method with objects of XUV, SCross & Swift. For eg Swift obj = new Swift()");
		System.out.println("\t5. In the method created above, identify the actual underlying object of the incoming "
				+ "Car object. If the incoming object is Swift print “Hatch'', if XUV print SUV & if SCross "
				+ "print Sedan.");
		System.out.println("\t6. create another method which accepts a Swift object as an argument.\n"
				+ "\t1. Try to invoke that method with an Swift object i.e Swift obj = new Swift()\n"
				+ "\t2. Try to invoke that method with a Car object which is assigned a Swift Object. "
				+ "i.e Car obj = new Swift(); Understand how different this scenario is from (i).\n"
				+ "\t3. Try to invoke that method with objects of XUV, SCross & understand how "
				+ "different this scenario is from the 14th task.");
		System.out.println("\t7. create a method maintenance () . Inside that print \" Car under "
				+ "maintenance\" . Now override this method in SCross class & print “Maruti SCross "
				+ "under maintenance” .\n"
				+ "\tIn the runner class perform the following & understand the flow in each scenario.\n"
				+ "\t1. Create an instance for Scross object & call maintenance() method\n"
				+ "\t2. Create an instance for SCross object & assign it to Car variable(Car obj = "
				+ "new SCross();) & call maintenance() method\n"
				+ "\t3. Create an instance for Car object & call maintenance() method\n"
				+ "\t4. Create an instance for Swift object & call maintenance() method.");
		System.out.println("\t8. create an overloaded constructor which accepts a String & print the "
				+ "incoming String. In the XUV class’s default constructor, try to call the overloaded "
				+ "Constructor of the super class. You should not create the overloaded constructor in "
				+ "XUV class. Now from the runner class,\n"
				+ "\t1. Try to create an instance of XUV using default constructor\n"
				+ "\t2. Try to create an instance of XUV using the overloaded constructor");
		System.out.println("\t9. Create an abstract class BirdAbstract with two methods: fly() & speak(). Both the fly() "
				+ "& speak() can print a statement & these methods need not be abstract. From a "
				+ "runner class try to create an instance for the BirdAbstract class.\n"
				+ "\t1. Now compile the runner class & check the output & understand.\n"
				+ "\t2. Now create a subclass ParrotMod extending BirdAbstract & you need not "
				+ "override the methods fly & speak. Create an instance for the ParrotMod from "
				+ "the runner class & invoke the fly & speak methods.");
		System.out.println("\t10. Create a class Bird with two methods: fly() & speak(). Let the fly() method alone be "
				+ "abstract. Now create a subclass Duck extending Bird & provide implementation for "
				+ "the fly. Create an instance for the Duck from the runner class & invoke the fly & speak methods.");
		System.out.println("\t11.Exit");
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
	public String[] multiStringInput(int no)
	{
		String str[] = new String[no];
		for(int i=0;i<no;i++)
		{
			System.out.println("Enter string " + i);
			str[i] = sc.nextLine();
		}
		return str;
	}
	public Integer[] multiIntInput(int no)
	{
		Integer str[] = new Integer[no];
		for(int i=0;i<no;i++)
		{
			System.out.println("Enter number " + i);
			str[i] = intInput();
		}
		return str;
	}
	public Lion[] multiLionInput(int no)
	{
		Lion str[] = new Lion[no];
		for(int i=0;i<no;i++)
		{
			System.out.println("Enter number " + i);
			str[i] = lionInput();
		}
		return str;
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
					System.out.println("Enter the number of pairs to be added");
					noOfPairs = run.intInput();
					hmString = map.create("", "");
					for(int i=0; i<noOfPairs; i++)
					{
						hmString = map.add(keyString,valueString);
					}
					map.display(hmString);
					System.out.println("The length of Hash map is " + map.mapLength(hmString));
					break;
				case 3:
					System.out.println("Enter the number of pairs to be added");
					noOfPairs = run.intInput();
					System.out.println("Enter the Keys ");
					Integer keyInt[] = run.multiIntInput(noOfPairs);
					System.out.println("Enter the values ");
					Integer valueInt[] = run.multiIntInput(noOfPairs);
					hmInt = map.create(def, def);
					hmInt = map.add(keyInt,valueInt);
					map.display(hmInt);
					System.out.println("The length of Hash map is " + map.mapLength(hmInt));
					break;
				case 4:
					System.out.println("Enter the number of pairs to be added");
					noOfPairs = run.intInput();
					System.out.println("Enter the Keys ");
					String keyStringInt[] = run.multiStringInput(noOfPairs);
					System.out.println("Enter the values ");
					Integer valueStringInt[] = run.multiIntInput(noOfPairs);
					hmStringInt = map.create("", def);
					hmStringInt = map.add(keyStringInt,valueStringInt);
					map.display(hmStringInt);
					System.out.println("The length of Hash map is " + map.mapLength(hmStringInt));
					break;
				case 5:
					System.out.println("Enter the number of pairs to be added");
					noOfPairs = run.intInput();
					System.out.println("Enter the Keys ");
					String keyStringObj[] = run.multiStringInput(noOfPairs);
					System.out.println("Enter the values ");
					Lion valueStringObj[] = run.multiLionInput(noOfPairs);
					Lion simba = null;
					hmStringObj = map.create("", simba);
					hmStringObj = map.add(keyStringObj,valueStringObj);
					map.display(hmStringObj);
					System.out.println("The length of Hash map is " + map.mapLength(hmStringObj));
					break;
				case 6:
					
					break;
				case 7:
					break;
				case 8:
					
					break;
				case 9:
					
					break;
				case 10:
					
					break;
				case 11:
					
					break;
				case 21:
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
