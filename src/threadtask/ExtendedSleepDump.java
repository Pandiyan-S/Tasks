package threadtask;


public class ExtendedSleepDump extends Thread
{
	boolean condition = true;//swami
	public void setCondition(boolean bool)
	{
		condition = bool;
	}
	public void run()
	{
		while(condition)
		{
			System.out.println(this.getName()+ " Thread running");
			try
			{
				sleep(5000);
			}
			catch(Exception e){}
		}
		System.out.println(Thread.currentThread().getName() + " Thread stopped");
	}
}
