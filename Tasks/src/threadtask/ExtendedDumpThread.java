package threadtask;

public class ExtendedDumpThread extends Thread
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
			System.out.println("this thread is ...." + this.getName());//swami
			try
			{
				sleep(5000);
			}
			catch(Exception e)
			{
				//e.printStackTrace();
			}
			trial--;
		}
		
	}
}
