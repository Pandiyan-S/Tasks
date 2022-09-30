package task9;


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
			this.setName("Extended Thread ......");
			System.out.println(this.getName());
			System.out.println(this.getPriority());
			System.out.println(this.getState());
			try
			{
				sleep(5000);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			trial--;
		}
		
	}
}
