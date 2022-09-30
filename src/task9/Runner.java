package task9;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Runner
{
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
		System.out.println("\t8.Exit");
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
	public void printExtendedState(ExtendedThread t)
	{
		System.out.println(t.getName());
		System.out.println(t.getPriority());
		System.out.println(t.getState());
	}
	public void printState(Thread t)
	{
		System.out.println(t.getName());
		System.out.println(t.getPriority());
		System.out.println(t.getState());
	}
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		Runner run = new Runner();
		int choice = 0;
		int def = 0;
		try
		{
			while (choice != 8 && def < 10)
			{
				menu();
				//Scanner sc = new Scanner(System.in);

				choice = run.intInput(sc);
				switch(choice)
				{
				case 1:
					ExtendedThread t1 = new ExtendedThread();
					System.out.println("Before ...");
					run.printExtendedState(t1);
					t1.start();
					t1.join();
					System.out.println("After ...");
					run.printExtendedState(t1);
					break;
				case 2:
					RunnableThread runThread = new RunnableThread();
					Thread t = new Thread(runThread);
					System.out.println("Before ...");
					run.printState(t);
					t.start();
					t.join();
					System.out.println("After ...");
					run.printState(t);
					break;
				case 3:
					sc.nextLine();
					System.out.println("Enter the name of the extended thread ");
					String name = sc.nextLine();
					ExtendedThread extendedThread = new ExtendedThread(name);
					System.out.println("Before ...");
					run.printExtendedState(extendedThread);
					extendedThread.start();
					extendedThread.join();
					System.out.println("After ...");
					run.printExtendedState(extendedThread);
					System.out.println("Enter the name of the runnable thread ");
					name = sc.nextLine();
					RunnableThread runnableThread = new RunnableThread();
					Thread runT = new Thread(runnableThread);
					runnableThread = new RunnableThread(runT,name);
					System.out.println("Before ...");
					run.printState(runT);
					runT.start();
					runT.join();
					System.out.println("After ...");
					run.printState(runT);
					break;
				case 4:
					sc.nextLine();
					for(int i=0; i<5; i++)
					{
						System.out.println("Enter the name of the extended thread ");
						String sleepName = sc.nextLine();
						ExtendedSleepThread sleepThread = new ExtendedSleepThread(sleepName);
						sleepThread.start();
						System.out.println("Enter the name of the runnable thread ");
						sleepName = sc.nextLine();
						RunnableSleepThread runnableSleepThread = new RunnableSleepThread(sleepName);
						Thread sleepT = new Thread(runnableSleepThread);
						sleepT.start();
					}
					break;
				case 5:
					System.out.println("Enter the number of threads ");
					int n = run.intInput(sc);
					for(int i=0; i<n; i++)
					{
						sc.nextLine();
						System.out.println("Enter the name of the extended thread ");
						String sleepNameN = sc.nextLine();
						System.out.println("Enter the number of seconds that the thread should sleep ");
						int sec = run.intInput(sc);
						ExtendedSleepThread sleepThread = new ExtendedSleepThread(sec,sleepNameN);
						sleepThread.start();
						sc.nextLine();
						System.out.println("Enter the name of the runnable thread ");
						sleepNameN = sc.nextLine();
						RunnableSleepThread runnableSleepThread = new RunnableSleepThread(sec,sleepNameN);
						Thread sleepTN = new Thread(runnableSleepThread);
						System.out.println("Enter the number of seconds that the thread should sleep ");
						sec = run.intInput(sc);
						sleepTN.start();
					}
					break;
				case 6:
					ExtendedDumpThread newDump = new ExtendedDumpThread();
					newDump.start();
					RunnableDumpThread newDumpRun = new RunnableDumpThread();
					Thread dumpT = new Thread(newDumpRun);
					dumpT.start();
					break;
				case 7:
					System.out.println("Enter the number of threads ");
					int num = run.intInput(sc);
					sc.nextLine();
					ArrayList<ExtendedSleepDump> sleepDump = new ArrayList<ExtendedSleepDump>();
					ArrayList<RunnableSleepDump> sleepDumpRun = new ArrayList<RunnableSleepDump>();
					ArrayList<Thread> th = new ArrayList<Thread>();
					String[] extendedName = new String[num];
					String[] runnerName = new String[num];
					for(int i=0; i<num ;i++)
					{
						System.out.println("Enter the name of Extended thread " + (i+1) + " : ");
						extendedName[i] = sc.nextLine();
						System.out.println("Enter the name of Runnable thread " + (i+1) + " : ");
						runnerName[i] = sc.nextLine();
					}
					for(int i=0; i<num; i++)
					{
						ExtendedSleepDump dum = new ExtendedSleepDump(extendedName[i]);
						sleepDump.add(dum);
						RunnableSleepDump dumprun = new RunnableSleepDump(runnerName[i]);
						sleepDumpRun.add(dumprun);
						Thread sleepDumpT = new Thread(dumprun);
						dum.start();
						sleepDumpT.start();
						th.add(dum);
						th.add(sleepDumpT);
						try
						{
							Thread.sleep(3000);
						}
						catch(Exception e){}
					}
					for(int i=0;i<num;i++)
					{
						sleepDump.get(i).setCondition(false);
						try
						{
							Thread.sleep(3000);
						}
						catch(Exception e){}
						sleepDumpRun.get(i).setCondition(false);
						try
						{
							Thread.sleep(3000);
						}
						catch(Exception e){}
					}
					Iterator<Thread> it = th.iterator();
					while(it.hasNext())
					{
						Thread thread = it.next();
						while(thread.isAlive())
						{
							try
							{
								Thread.sleep(100);
							}
							catch(Exception e){}
						}
						it.remove();
					}
					break;
				case 8:
					System.out.println("The program is closing");
					break;
				default:
					System.out.println("the choice is invalid");
					def++;
					if(def==9)
					{
						System.out.println("9 invalid inputs, if there is 1 more invalid input the program will close ");
					}
					if(def == 10)
					{
						System.out.println("10 invalid inputs,the program is closing ");
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
