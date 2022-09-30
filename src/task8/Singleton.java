package task8;

public class Singleton
{
	private static Singleton single = null;
	public String str;
	private Singleton()
	{
		str = "Hello";
	}
	public static Singleton getInstance()
	{
		if(single == null)
		{
			single = new Singleton();
		}
		return single;
	}
}
