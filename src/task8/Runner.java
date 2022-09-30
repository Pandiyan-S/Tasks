package task8;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Properties;
import java.util.Scanner;
import check.UserException;

public class Runner
{
	enum Rainbow
	{
		VIOLET (1),
		INDIGO (2),
		BLUE (3),
		GREEN (4),
		YELLOW (5),
		ORANGE (6),
		RED (7);
		private final int Sno;
		Rainbow(int Sno)
		{
			this.Sno = Sno;
		}
	}
	private static void menu()
	{
		System.out.println("Choose the operation to be performed");;
		System.out.println("\t1. Create a file sample.txt programmatically and write the lines.");
		System.out.println("\t2. store the values in java.util.Properties object. Keys & Values can be provided "
				+ "from the runner class.After loading the properties with the provided keys & values, "
				+ "store the values in a text file.");
		System.out.println("\t3. read the keys & values from the above created myprops.txt file & store "
				+ "those values back into the java.util.Properties object and print the properties.");
		System.out.println("\t4. creating the files sample.txt, myprops.txt under /home/INC*/myDir. and perform "
				+ "the above methods");
		System.out.println("\t5. Invoke the constructor which takes a string as an input and print your object.");
		System.out.println("\t6. create an instance for the pojo class using the overloaded constructor & "
				+ "print your object");
		System.out.println("\t7. create an instance for the above POJO class using the default constructor. "
				+ "call the appropriate setter and getter methods to input and print the variables. ");
		System.out.println("\t8. In the runner class,without importing POJO class\n"
				+ "\t1. Invoke the default constructor of the POJO from the runner class\n"
				+ "\t2. Invoke the overloaded constructor of the POJO from the runner class\n"
				+ "\t3. Invoke any one getter method of the POJO from the runner class\n"
				+ "\t4. Invoke any one setter method of the POJO from the runner class");
		System.out.println("\t9. Define an Enum for the rainbow colors, with values(colorcode) ranging from 1 to 7. "
				+ "Print the color and its corresponding color code from the main method.");
		System.out.println("\t10. Write a Singleton class");
		System.out.println("\t11. Test Time package methods");
		System.out.println("\t13.Exit");
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
				System.out.print("the entered value is not an integer, please input correct value");
				sc.nextLine();
				ex = true;
			}
		}while(ex);
		return choice;
	}
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		Runner run = new Runner();
		FileMethods file = new FileMethods();
		int choice = 0;
		int def = 0;
		File folder;
		try
		{
			while (choice != 13 && def < 10)
			{
				menu();
				choice = run.intInput(sc);
				switch(choice)
				{
				case 1:
					folder = new File("Sample.txt");
					try(FileWriter stringWriter = new FileWriter(folder))
					{
						file.sampleWords(stringWriter,"Programmatically created file.\n");
						file.sampleWords(stringWriter,"These words were written programmatically.\n");
						file.sampleWords(stringWriter,"All is Well. Be happy & enjoy the moment.");
					}
					catch(IOException e)
					{
						e.printStackTrace();
					}
					break;
				case 2:
					Properties before = new Properties();
					System.out.println("Enter the number of properties to be entered ");
					int noOfProp = run.intInput(sc);
					sc.nextLine();
					String key;
					String value;
					for(int i=0; i<noOfProp; i++)
					{
						System.out.println("Enter the key " + i + " : ");
						key = sc.nextLine();
						System.out.println("Enter the value " + i + " : ");
						value = sc.nextLine();
						file.append(before,key,value);
					}
					folder = new File("myprops.txt");
					file.serial(before,folder);
					break;
				case 3:
					Properties after = new Properties();
					folder = new File("myprops.txt");
					file.deserial(after,folder);
					System.out.println(after);
					break;
				case 4:
					File directory = new File("/home/inc2/myDir.");
					directory.mkdir();
					File string = new File("/home/inc2/myDir./Sample.txt");
					try(FileWriter stringWriter = new FileWriter(string))
					{
						file.sampleWords(stringWriter,"Programmatically created file.\n");
						file.sampleWords(stringWriter,"These words were written programmatically.\n");
						file.sampleWords(stringWriter,"All is Well. Be happy & enjoy the moment.");
					}
					catch(IOException e)
					{
						e.printStackTrace();
					}
					File deflate = new File("/home/inc2/myDir./Sample.txt");
					Properties habitate = new Properties();
					file.append(habitate,"Lion","Grasslands");
					file.append(habitate,"Tiger","Forest");
					file.append(habitate,"Whale","Ocean");
					file.append(habitate,"Camel","Desert");
					file.append(habitate,"Walrus","IceLands");
					file.serial(habitate,deflate);
					Properties match = new Properties();
					file.deserial(match, directory);
					System.out.println(match);
					break;
				case 5:
					POJObasic base = new POJObasic("Hello World");
					System.out.println(base.getStr());
					break;
				case 6:
					Object pojo = new TruePOJO("Hello World : ",2022);
					System.out.println(pojo);
					break;
				case 7:
					TruePOJO normalPojo = new TruePOJO();
					normalPojo.setStr("This is Pandiyan");
					normalPojo.setNo(10);
					System.out.println(normalPojo.getStr());
					System.out.println(normalPojo.getNo());
					break;
				case 8:
					try
					{
						Class<?> c = Class.forName("pojopackage.ThisIsPojo");
						Constructor<?> ctor = c.getDeclaredConstructor();
						ctor.setAccessible(true);
						Object defaultRef = ctor.newInstance();
						Constructor<?> ctorArgs = c.getDeclaredConstructor(String.class,int.class);
						ctorArgs.setAccessible(true);
						Object overRef = ctorArgs.newInstance("My name is Pandi ", 50);
						Method setter = c.getDeclaredMethod("setStr",String.class);
						setter.invoke(defaultRef, "Pandiyan ");
						Method getter = c.getDeclaredMethod("getStr");
						System.out.println(getter.invoke(defaultRef));
						System.out.println(getter.invoke(overRef));
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
					break;
				case 9:
					for(Rainbow color: Rainbow.values())
					{
						System.out.print(color);
						System.out.print(" : ");
						System.out.println(color.Sno);
						System.out.print("The ordinal is ");
						System.out.println(color.ordinal());
					}
					break;
				case 10:
					Singleton once = Singleton.getInstance();
					System.out.println(once.str);
					break;
				case 11:
					sc.nextLine();
					LocalDateTime today = file.getDateTime();
					System.out.println("The current date and time : " + today);
					System.out.println("The current time in milli seconds : " + file.milliTime());
					ZoneId city1 = ZoneId.of("Europe/London");
					System.out.println("London Time : " + file.worldTime(city1));
					ZoneId city2 = ZoneId.of("America/New_York");
					System.out.println("New York Time : " + file.worldTime(city2));
					System.out.println("Today's day is " + file.weekDay(today));
					LocalDateTime bday = LocalDateTime.of(2001, 6, 7, 6, 12);
					System.out.println("The day of 07/06/2001 is " + file.weekDay(bday));
					System.out.println("The month of 07/06/2001 is " + file.Month(bday));
					System.out.println("The year of 07/06/2001 is " + file.Years(bday));
					break;
				case 13:
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
		catch(UserException e)
		{
			System.out.println(e);
		}
		finally
		{
			sc.close();
		}
	}
}
