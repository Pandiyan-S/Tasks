package basictask;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Properties;
import java.util.Scanner;
import java.util.logging.Logger;

import check.UserException;

public class Runner
{
	private static void menu(Logger logger)
	{
		logger.info("Choose the operation to be performed");;
		logger.info("\t1. Create a file sample.txt programmatically and write the lines.");
		logger.info("\t2. store the values in java.util.Properties object. Keys & Values can be provided "
				+ "from the runner class.After loading the properties with the provided keys & values, "
				+ "store the values in a text file.");
		logger.info("\t3. read the keys & values from the above created myprops.txt file & store "
				+ "those values back into the java.util.Properties object and print the properties.");
		logger.info("\t4. creating the files sample.txt, myprops.txt under /home/INC*/myDir. and perform "
				+ "the above methods");
		logger.info("\t5. Invoke the constructor which takes a string as an input and print your object.");
		logger.info("\t6. create an instance for the pojo class using the overloaded constructor & "
				+ "print your object");
		logger.info("\t7. create an instance for the above POJO class using the default constructor. "
				+ "call the appropriate setter and getter methods to input and print the variables. ");
		logger.info("\t8. In the runner class,without importing POJO class\n"
				+ "\t1. Invoke the default constructor of the POJO from the runner class\n"
				+ "\t2. Invoke the overloaded constructor of the POJO from the runner class\n"
				+ "\t3. Invoke any one getter method of the POJO from the runner class\n"
				+ "\t4. Invoke any one setter method of the POJO from the runner class");
		logger.info("\t9. Define an Enum for the rainbow colors, with values(colorcode) ranging from 1 to 7. "
				+ "Print the color and its corresponding color code from the main method.");
		logger.info("\t10. Write a Singleton class");
		logger.info("\t11. Test Time package methods");
		logger.info("\t13.Exit");
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
	private void writeStringInFile(Logger logger,Scanner sc,String fileName) throws UserException, IOException
	{
		FileMethods file = new FileMethods();
		logger.info("Enter the number of lines to input :");
		int noOfLines = intInput(sc);
		sc.nextLine();
		String[] stringInput = new String[noOfLines];
		for (int i=0; i<noOfLines; i++)
		{
			logger.info("Enter the line " + i + " :");
			stringInput[i] = sc.nextLine();
		}
		file.sampleWords(fileName,stringInput);
	}
	private void writePropertyInFile(Logger logger,Scanner sc,String storageFileName) throws UserException, IOException
	{
		FileMethods file = new FileMethods();
		Properties before = new Properties();
		logger.info("Enter the number of properties to be entered ");
		int noOfProp = intInput(sc);
		sc.nextLine();
		String key;
		String value;
		for(int i=0; i<noOfProp; i++)
		{
			System.out.println("Enter the key " + i + " : ");
			key = sc.nextLine();
			System.out.println("Enter the value " + i + " : ");
			value = sc.nextLine();
			before = file.append(before,key,value);
		}
		file.serial(before,storageFileName);
	}
	private void readPropertyFromFile(Logger logger,String readFileName) throws UserException, IOException
	{
		FileMethods file = new FileMethods();
		Properties after = new Properties();
		file.deSerial(after,readFileName);
		logger.info(after.toString());
	}
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		Runner run = new Runner();
		FileMethods file = new FileMethods();
		Logger logger = Logger.getLogger("Trial logger");
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
					sc.nextLine();
					logger.info("Enter the file name :");
					String fileName = sc.nextLine();
					run.writeStringInFile(logger,sc,fileName);
					break;
				case 2:
					sc.nextLine();
					logger.info("Enter the file name :");
					String storageFileName = sc.nextLine();
					run.writePropertyInFile(logger,sc,storageFileName);
					break;
				case 3:
					sc.nextLine();
					logger.info("Enter the file name :");
					String readFileName = sc.nextLine();
					run.readPropertyFromFile(logger,readFileName);
					break;
				case 4:
					sc.nextLine();
					logger.info("Enter the directory :");
					String directoryName = sc.nextLine();
					file.createDirectory(directoryName);
					run.writeStringInFile(logger,sc,directoryName);
					run.writePropertyInFile(logger,sc,directoryName);
					run.readPropertyFromFile(logger,directoryName);
					break;
				case 5:
					Pojobasic base = new Pojobasic("Hello World");
					logger.info(base.getStr());
					break;
				case 6:
					Object pojo = new TruePojo("Hello World : ",2022);
					logger.info(pojo.toString());
					break;
				case 7:
					TruePojo normalPojo = new TruePojo();
					normalPojo.setStr("This is Pandiyan");
					normalPojo.setNo(10);
					logger.info(normalPojo.getStr());
					logger.info(normalPojo.getNo().toString());
					break;
				case 8:
					sc.nextLine();
					logger.info("Enter the path of pojo :");
					String pojoPathName = sc.nextLine();
					Class<?> c = file.findClass(pojoPathName);
					Constructor<?> ctor = file.defaultConstructor(c);
					Object defaultRef = file.createDefaultObj(ctor);
					Constructor<?> ctorArgs = file.argsConstructor(c,String.class,int.class);
					ctorArgs.setAccessible(true);
					Object overRef = file.createOverObj(ctorArgs, "My name is Pandi ", 50);
					Method setter = file.methodCall(c,"setStr",String.class);
					file.setterInvoke(setter,defaultRef,"Pandiyan");
					Method getter = file.methodCall(c,"getStr");
					Object str = file.getterInvoke(getter,defaultRef);
					logger.info(str.toString());
					str = file.getterInvoke(getter,overRef);
					logger.info(str.toString());
					break;
				case 9:
					for(Rainbow color: Rainbow.values())
					{
						logger.info(color.toString()+":"+color.getSno()+" \nThe ordinal is "+color.ordinal());
					}
					break;
				case 10:
					Singleton once = Singleton.getInstance();
					logger.info(once.getStr());
					break;
				case 11:
					sc.nextLine();
					LocalDateTime today = file.getDateTime();
					logger.info("The current date and time : " + today);
					logger.info("The current time in milli seconds : " + file.milliTime());
					ZoneId city1 = ZoneId.of("Europe/London");
					logger.info("London Time : " + file.worldTime(city1));
					ZoneId city2 = ZoneId.of("America/New_York");
					logger.info("New York Time : " + file.worldTime(city2));
					logger.info("Today's day is " + file.weekDay(today));
					LocalDateTime bday = LocalDateTime.of(2001, 6, 7, 6, 12);
					logger.info("The day of 07/06/2001 is " + file.weekDay(bday));
					logger.info("The month of 07/06/2001 is " + file.month(bday));
					logger.info("The year of 07/06/2001 is " + file.years(bday));
					break;
				case 13:
					logger.info("The program is closing");
					break;
				default:
					logger.info("the choice is invalid");
					def++;
					if(def==9)
					{
						logger.info("9 invalid inputs, if there is 1 more invalid input the program will shut down ");
					}
					if(def == 10)
					{
						logger.info("10 invalid inputs,the program is shutting down ");
					}
				}
			}
		}
		catch(UserException e)
		{
			logger.warning(e.getLocalizedMessage());
		}
		catch(IOException e)
		{
			logger.warning(e.getLocalizedMessage());
		}
		catch(ReflectiveOperationException e)
		{
			logger.warning(e.getLocalizedMessage());
		}
		finally
		{
			sc.close();
		}
	}
}
