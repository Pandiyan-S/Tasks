package task9;

public class ExtendedSleepThread extends Thread
{
	private int num;
	ExtendedSleepThread()
	{
		num = 60000;
	}
	ExtendedSleepThread(String str)
	{
		num = 60000;
		this.setName(str);
	}
	ExtendedSleepThread(int no,String str)
	{
		num = Math.abs(no) * 1000;
		this.setName(str);
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
		{
			e.printStackTrace();
		}
		System.out.println("After sleeping: " + this.getName());
	}
}
