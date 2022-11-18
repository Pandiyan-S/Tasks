package threadtask;


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
			System.out.println("this thread is ..... " + Thread.currentThread().getName());
			try
			{
				Thread.sleep(5000);
			}
			catch(Exception e)
			{}
			trial--;
		}
	}
}
