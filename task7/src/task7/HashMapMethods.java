package task7;

import java.util.HashMap;
import java.util.Objects;

import task7.UserException;

public class HashMapMethods
{
	public void check(Object obj) throws UserException
	{
		if(Objects.isNull(obj))
		{
			throw new UserException("the value is null ");
		}
	}
	public <T,U> HashMap<T,U> create(T type1, U Type2)
	{
		HashMap<T,U> hm = new HashMap<T,U>();
		return hm;
	}
	public <T,U> void display(HashMap<T,U> hm) throws UserException
	{
		check(hm);
		System.out.println(hm);
	}
	public <T,U> int mapLength(HashMap<T,U> hm) throws UserException
	{
		check(hm);
		return hm.size();
	}
	public <T,U> void add(HashMap hm, T keys,U values) throws UserException
	{
		check(hm);
		hm.put(keys, values);
	}
}
