package task9;


public class ExtendedSleepDump extends Thread
{
	private String threadName;
	boolean condition = true;
	ExtendedSleepDump()
	{
		setThreadName("Extended Thread");
	}
	ExtendedSleepDump(String str)
	{
		setThreadName(str);
	}
	public void setCondition(boolean b)
	{
		condition = b;
	}
	public void setThreadName(String str)
	{
		threadName = str;
	}
	public void run()
	{
		this.setName(threadName);
		
			while(condition)
			{
				System.out.println(this.getName()+ "\t" + this.getPriority()+"\t" + this.getState());
				try
				{
				sleep(1000);
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
			System.out.println(Thread.currentThread().getName() + " Thread stopped");
		
		
	}
}
