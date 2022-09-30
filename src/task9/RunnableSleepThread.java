package task9;

public class RunnableSleepThread implements Runnable
{
	private int num;
	private String name;
	RunnableSleepThread()
	{
		num = 45000;
	}
	RunnableSleepThread(String str)
	{
		num = 45000;
		name = str;
	}
	RunnableSleepThread(int no,String str)
	{
		num = Math.abs(no) * 1000;
		name = str;
	}
	@Override
	public void run() 
	{
		Thread.currentThread().setName(name);
		System.out.println("Going to sleep: " + Thread.currentThread().getName());
		try
		{
			Thread.sleep(num);
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
		System.out.println("After sleeping: " + Thread.currentThread().getName());
	}
}
