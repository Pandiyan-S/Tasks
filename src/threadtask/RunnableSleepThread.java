package threadtask;

public class RunnableSleepThread implements Runnable
{
	private int num;
	public RunnableSleepThread()
	{
		num = 45000;
	}
	public RunnableSleepThread(int no)
	{
		num = Math.abs(no) * 1000;
	}
	@Override
	public void run() 
	{
		System.out.println("Going to sleep: " + Thread.currentThread().getName());
		try
		{
			Thread.sleep(num);
		}
		catch (InterruptedException e)
		{
			//e.printStackTrace();
		}
		System.out.println("After sleeping: " + Thread.currentThread().getName());
	}
}
