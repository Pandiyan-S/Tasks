package task9;

public class RunnableThread implements Runnable
{
	RunnableThread(){}
	RunnableThread(Thread t,String str)
	{
		t.setName(str);
	}
	public void run()
	{
		System.out.println("run method....." + Thread.currentThread().getName());
		System.out.println("run method....." + Thread.currentThread().getPriority());
		System.out.println("run method....." + Thread.currentThread().getState());
	}
}
