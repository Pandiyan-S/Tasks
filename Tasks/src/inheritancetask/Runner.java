package inheritancetask;

import java.util.Scanner;

public class Runner
{
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
	public void carTrial(Car trial)
	{
		Swift swiftTrial = new Swift();
		SCross scrossTrial = new SCross();
		XUV xuvTrial = new XUV();
		if(trial.equals(swiftTrial))
		{
			System.out.println("Hatch");
		}
		if(trial.equals(scrossTrial))
		{
			System.out.println("Sedan");
		}
		if(trial.equals(xuvTrial))
		{
			System.out.println("SUV");
		}
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Year of make ");
		int yearOfMake = intInput();
		trial.setYearOfMake(yearOfMake);
		System.out.println("Enter the Engine number ");
		String engineNumber = sc.nextLine();
		trial.setEngineNumber(engineNumber);
		System.out.println("Enter the car type ");
		String type = sc.nextLine();
		trial.setType(type);
		System.out.println("The year of make is " + trial.getYearOfMake());
		System.out.println("The engine number is " + trial.getEngineNumber());
		System.out.println("The car type is " + trial.getType());
	}
	public void invoke(Swift trial)
	{
		
	}
	public static void main(String[] args)
	{
		Runner run = new Runner();
		Scanner sc = new Scanner(System.in);
		int choice = 0;
		int def = 0;
		while (choice != 11 && def < 10)
		{
			menu();
			choice = run.intInput();
			switch(choice)
			{
			case 2:
				Swift swiftObj = new Swift();
				System.out.println("Enter the number of seats ");
				int swiftSeat = run.intInput();
				swiftObj.setSeats(swiftSeat);
				System.out.println("Enter the number of airbags ");
				int swiftBags = run.intInput();
				swiftObj.setAirbags(swiftBags);
				System.out.println("Enter the model ");
				String swiftModel = sc.nextLine();
				swiftObj.setModel(swiftModel);
				System.out.println("Enter the color ");
				String swiftColor = sc.nextLine();
				swiftObj.setColor(swiftColor);
				System.out.println("The number of seats are " + swiftObj.getSeats());
				System.out.println("The number of airbags are " + swiftObj.getAirbags());
				System.out.println("The model is " + swiftObj.getModel());
				System.out.println("The color is " + swiftObj.getColor());
				break;
			case 3:
				SCross scrossObj = new SCross();
				System.out.println("Enter the Year of make ");
				int scrossYearOfMake = run.intInput();
				scrossObj.setYearOfMake(scrossYearOfMake);
				System.out.println("Enter the number of seats ");
				int scrossSeat = run.intInput();
				scrossObj.setSeats(scrossSeat);
				System.out.println("Enter the number of airbags ");
				int scrossBags = run.intInput();
				scrossObj.setAirbags(scrossBags);
				System.out.println("Enter the Engine number ");
				String scrossEngineNumber = sc.nextLine();
				scrossObj.setEngineNumber(scrossEngineNumber);
				System.out.println("Enter the car type ");
				String scrossType = sc.nextLine();
				scrossObj.setType(scrossType);
				System.out.println("Enter the model ");
				String scrossModel = sc.nextLine();
				scrossObj.setModel(scrossModel);
				System.out.println("Enter the color ");
				String scrossColor = sc.nextLine();
				scrossObj.setColor(scrossColor);
				System.out.println("The year of make is " + scrossObj.getYearOfMake());
				System.out.println("The engine number is " + scrossObj.getEngineNumber());
				System.out.println("The car type is " + scrossObj.getType());
				System.out.println("The number of seats are " + scrossObj.getSeats());
				System.out.println("The number of airbags are " + scrossObj.getAirbags());
				System.out.println("The model is " + scrossObj.getModel());
				System.out.println("The color is " + scrossObj.getColor());
				break;
			case 4:
			case 5:
				Swift swiftTest = new Swift();
				SCross scrossTest = new SCross();
				XUV xuvTest = new XUV();
				System.out.println("Swift test : ");
				run.carTrial(swiftTest);
				System.out.println("SCross test : ");
				run.carTrial(scrossTest);
				System.out.println("XUV test : ");
				run.carTrial(xuvTest);
				break;
			case 6:
				Swift swiftInvoke = new Swift();
				SCross scrossInvoke = new SCross();
				XUV xuvInvoke = new XUV();
				Car carInvoke = new Swift();
				System.out.println("Swift test : ");
				run.invoke(swiftInvoke);
				System.out.println("SCross test : ");
				//run.invoke(scrossInvoke);
				System.out.println("XUV test : ");
				//run.invoke(xuvInvoke);
				System.out.println("Car test : ");
				//run.invoke(carInvoke);
				break;
			case 7:
				SCross scrossMaintain = new SCross();
				Car carSCrossMaintain = new SCross();
				Car carMaintain = new Car();
				Swift swiftMaintain = new Swift();
				System.out.println("SCross maintenance : ");
				scrossMaintain.maintenance();
				System.out.println("SCross in car maintenance : ");
				carSCrossMaintain.maintenance();
				System.out.println("Car maintenance : ");
				carMaintain.maintenance();
				System.out.println("Swift maintenance : ");
				swiftMaintain.maintenance();
				break;
			case 8:
				XUV xuvConstructor = new XUV();
				//XUV xuvConstructorOverloaded = new XUV("Hi ");
				break;
			case 9:
				//BirdAbstract abs = new BirdAbstract();
				//abs.fly();
				//abs.speak();
				ParrotMod mod = new ParrotMod();
				mod.fly();
				mod.speak();
				break;
			case 10:
				Duck donald = new Duck();
				donald.fly();
				donald.speak();
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
	}
}
