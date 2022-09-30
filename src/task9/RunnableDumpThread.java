package task9;


public class RunnableDumpThread implements Runnable 
{
	private int trial = 100;
	public void setTrial(int no)
	{
		trial = no;
	}
	public void run()
	{
		while(trial!=0)
		{
			Thread.currentThread().setName("Runnnable Thread ......" + trial);
			System.out.println(Thread.currentThread().getName());
			System.out.println(Thread.currentThread().getPriority());
			System.out.println(Thread.currentThread().getState());
			try
			{
				Thread.sleep(5000);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			trial--;
		}
	}
}
