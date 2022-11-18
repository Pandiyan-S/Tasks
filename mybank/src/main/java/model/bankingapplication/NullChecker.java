package model.bankingapplication;

import java.util.Objects;

public class NullChecker
{
	public static void check(Object obj) throws UserException
	{
		if(Objects.isNull(obj))
		{
			throw new UserException("The value is null ");
		}
	}
	public static void check(Object obj,String str) throws UserException
	{
		if(Objects.isNull(obj))
		{
			throw new UserException(str + " is null ");
		}
	}
}
