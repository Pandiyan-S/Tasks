package threadtask;

public class ExtendedSleepThread extends Thread
{
	private int num;
	public ExtendedSleepThread()
	{
		num = 60000;
	}
	public ExtendedSleepThread(int no)
	{
		num = Math.abs(no) * 1000;
	}
	@Override
	public void run() 
	{
		System.out.println("Going to sleep: " + this.getName());
		try
		{
			sleep(num);
		}
		catch (InterruptedException e)
		{}
		System.out.println("After sleeping: " + this.getName());
	}
}
