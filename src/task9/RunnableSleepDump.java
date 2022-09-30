package task9;


public class RunnableSleepDump implements Runnable
{
	boolean condition = true;
	private String threadName;
	RunnableSleepDump()
	{
		setThreadName("Extended Thread");
	}
	RunnableSleepDump(String str)
	{
		setThreadName(str);
	}
	public void setThreadName(String str)
	{
		threadName = str;
	}
	public void setCondition(boolean b)
	{
		condition = b;
	}
	public void run()
	{
		Thread.currentThread().setName(threadName);
		while(condition)
			{
				System.out.println(Thread.currentThread().getName()+ "\t" + Thread.currentThread().getPriority()+
						"\t" + Thread.currentThread().getState());
				try
				{
				Thread.sleep(1000);
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
		System.out.println(Thread.currentThread().getName() + " Thread stopped");
	}
}
