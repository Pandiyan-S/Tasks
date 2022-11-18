package threadtask;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Runner
{
	private static void menu()
	{
		System.out.println("Choose the operation to be performed");
		System.out.println("\t1.Spawn a new thread using the ExtendedThread class. Print the current thread name, "
				+ "priority & its state in the runner class before & after calling the thread.start() method.");
		System.out.println("\t2. Spawn a new thread using the RunnableThread class.Print the current thread name, priority "
				+ "& its state in the runner class before & after calling the thread.start() method.");
		System.out.println("\t3. Spawn a new Thread using the ExtendedThread and provide the name for that "
				+ "thread as ExtendedThread. Spawn a new Thread using the RunnableThread & set "
				+ "the name as RunnableThread. Print the current thread name, priority & its state in the "
				+ "runner class before & after calling the thread.start() method of each thread");
		System.out.println("\t4. In the run method of ExtendedThread, print a message “Going to Sleep: "
				+ "“+threadName. After that sleep for 60 secs. Then print After sleeping: "
				+ "“+threadName.In the run method of RunnableThread,print a message “Going to "
				+ "Sleep: “+threadName. After that sleep for45 secs. Then print After sleeping: "
				+ "“+threadName.From the runner class spawn 5 ExtendedThreads with your custom "
				+ "Thread name for each thread & 5 more RunnableThreads with your custom name for "
				+ "each Thread. Observe what happens by analyzing the output prints.");
		System.out.println("\t5. accept the sleep time as an argument while creating the Thread itself for each thread.");
		System.out.println("\t6. have some condition based while loop in the run methods of RunnableThread "
				+ "& ExtendedThread class.");
		System.out.println("\t7. once all the threads are started. From the runner "
				+ "class try to stop the execution of Thread one by one by toggling the condition "
				+ "variable of the thread. The difference between two stops can be 60 seconds from the "
				+ "runner class. At the end check if all the Threads are alive or not. If all the 10 threads "
				+ "exited, you can print tasks completed. After 2 minutes of starting the runner class, "
				+ "start taking thread dumps(10 count) at 45 secs interval. ");
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
	public void printExtendedState(ExtendedThread thread)
	{
		System.out.println(thread.getName());
		System.out.println(thread.getPriority());
		System.out.println(thread.getState());
	}
	public void printState(Thread thread)
	{
		System.out.println(thread.getName());
		System.out.println(thread.getPriority());
		System.out.println(thread.getState());
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
					ExtendedThread extTh = new ExtendedThread();
					System.out.println("Before ...");
					run.printExtendedState(extTh);
					extTh.start();
//					t1.join();
					System.out.println("After ...");
					run.printExtendedState(extTh);
					break;
				case 2:
					RunnableThread runThread = new RunnableThread();
					Thread runTh = new Thread(runThread);
					System.out.println("Before ...");
					run.printState(runTh);
					runTh.start();
//					t.join();
					System.out.println("After ...");
					run.printState(runTh);
					break;
				case 3:
					sc.nextLine();
					System.out.println("Enter the name of the extended thread ");
					String name = sc.nextLine();
					ExtendedThread extendedThread = new ExtendedThread();
					extendedThread.setName(name);
					System.out.println("Before ...");
					run.printExtendedState(extendedThread);
					extendedThread.start();
//					extendedThread.join();
					System.out.println("After ...");
					run.printExtendedState(extendedThread);
					System.out.println("Enter the name of the runnable thread ");
					name = sc.nextLine();
					RunnableThread runnableThread = new RunnableThread();
					Thread runT = new Thread(runnableThread);
					runT.setName(name);
					System.out.println("Before ...");
					run.printState(runT);
					runT.start();
//					runT.join();
					System.out.println("After ...");
					run.printState(runT);
					break;
				case 4:
					sc.nextLine();
					for(int i=0; i<5; i++)
					{
						System.out.println("Enter the name of the extended thread ");
						String sleepName = sc.nextLine();
						ExtendedSleepThread sleepThread = new ExtendedSleepThread();
						sleepThread.setName(sleepName);
						sleepThread.start();
						System.out.println("Enter the name of the runnable thread ");
						sleepName = sc.nextLine();
						RunnableSleepThread runnableSleepThread = new RunnableSleepThread();
						Thread sleepT = new Thread(runnableSleepThread);
						sleepT.setName(sleepName);
						sleepT.start();
					}
					break;
				case 5:
					System.out.println("Enter the number of threads ");
					int n = run.intInput(sc);
					for(int i=0; i<n; i++)
					{
						sc.nextLine();	System.out.println("run method....." + Thread.currentThread().getState());
						
						System.out.println("Enter the name of the extended thread ");
						String sleepNameN = sc.nextLine();
						System.out.println("Enter the number of seconds that the thread should sleep ");
						int sec = run.intInput(sc);
						ExtendedSleepThread sleepThread = new ExtendedSleepThread(sec);
						sleepThread.setName(sleepNameN);
						sleepThread.start();
						sc.nextLine();
						System.out.println("Enter the name of the runnable thread ");
						sleepNameN = sc.nextLine();
						RunnableSleepThread runnableSleepThread = new RunnableSleepThread(sec);
						Thread sleepTN = new Thread(runnableSleepThread);
						sleepTN.setName(sleepNameN);
						System.out.println("Enter the number of seconds that the thread should sleep ");
						sec = run.intInput(sc);
						sleepTN.start();
					}
					break;
				case 6:
					ExtendedDumpThread newDump = new ExtendedDumpThread();
					newDump.setName("Extended thread ...");
					newDump.start();
					RunnableDumpThread newDumpRun = new RunnableDumpThread();
					Thread dumpT = new Thread(newDumpRun);
					dumpT.setName("Runnable thread ...");
					dumpT.start();
					break;
				case 7:
					System.out.println("Enter the number of threads ");
					int num = run.intInput(sc);
					sc.nextLine();
					ArrayList<ExtendedSleepDump> sleepDump = new ArrayList<ExtendedSleepDump>();
					ArrayList<RunnableSleepDump> sleepDumpRun = new ArrayList<RunnableSleepDump>();
					ArrayList<Thread> th = new ArrayList<Thread>();
					for(int i=0; i<num; i++)
					{
						ExtendedSleepDump dum = new ExtendedSleepDump();
						dum.setName("Extended Thread ... "+ (i+1));
						sleepDump.add(dum);
						RunnableSleepDump dumprun = new RunnableSleepDump();
						sleepDumpRun.add(dumprun);
						Thread sleepDumpT = new Thread(dumprun);
						sleepDumpT.setName("Runnable thread ... "+ (i+1));
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
