package model.bankingapplication;

import java.util.Objects;

public class NullChecker
{
	public static void check(Object obj) throws UserException
	{
		if(Objects.isNull(obj))
		{
			throw new UserException("the value is null ");
		}
	}
}
