package basictask;

import check.UserException;

public class Singleton
{
	private static volatile Singleton single = null;//swami
	private String str;
	public static Singleton getSingle()
	{
		return single;
	}
	public String getStr() {
		return str;
	}
	private Singleton() throws UserException
	{
		if(single != null)
		{
			throw new UserException("The singleton class already has an Instance ");
		}
		str = "Hello";
	}
	public static Singleton getInstance() throws UserException
	{
		if(single ==null)
		{
			synchronized(Singleton.class)
			{
				if(single == null)
				{
					single = new Singleton();
				}
			}
		}
		return single;
	}
}
