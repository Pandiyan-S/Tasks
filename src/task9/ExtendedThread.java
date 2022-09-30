package task9;

public class ExtendedThread extends Thread
{
	ExtendedThread(){}
	ExtendedThread(String str)
	{
		this.setName(str);
	}
	@Override
	public void run()
	{
		System.out.println("run method....." + this.getName());
		System.out.println("run method....." + this.getPriority());
		System.out.println("run method....." + this.getState());
	}
}
