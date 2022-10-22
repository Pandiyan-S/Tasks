package check;

@SuppressWarnings("serial")
public class UserException extends Exception
{
	public UserException(String str)
	{
		super(str);
	}
	public UserException(String str,Exception e)
	{
		super(str,e);
	}
}