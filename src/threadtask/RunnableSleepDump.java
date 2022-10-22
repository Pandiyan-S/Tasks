package threadtask;


public class RunnableSleepDump implements Runnable
{
	boolean condition = true;
	public void setCondition()
	{}
	public void setCondition(boolean bool)
	{
		condition = bool;
	}
	public void run()
	{
		while(condition)
			{
				System.out.println(Thread.currentThread().getName()+ " Thread running");
				try
				{
				Thread.sleep(5000);
				}
				catch(Exception e)
				{
					//e.printStackTrace();
				}
			}
		System.out.println(Thread.currentThread().getName() + " Thread stopped");
	}
}
