package task7;

import java.util.HashMap;
import java.util.Iterator;
import check.UserException;
import java.util.Objects;

public class HashMapMethods
{
	public void check(Object obj) throws UserException
	{
		if(Objects.isNull(obj))
		{
			throw new UserException("the value is null ");
		}
	}
	//ex1
	public <T,U> HashMap<T,U> create(T type1, U Type2)
	{
		HashMap<T,U> hm = new HashMap<T,U>();
		return hm;
	}
	public <T,U> int mapLength(HashMap<T,U> hm) throws UserException
	{
		check(hm);
		return hm.size();
	}
	//ex2,3,4,5,6,7
	public <T,U> void display(HashMap<T,U> hm) throws UserException
	{
		check(hm);
		System.out.println(hm);
	}
	public <T,U> void add(HashMap<T,U> hm, T keys,U values) throws UserException
	{
		check(hm);
		hm.put(keys, values);
	}
	//ex8
	public <T,U> boolean keyChecker(HashMap<T,U> hm, T keys) throws UserException
	{
		check(hm);
		check(keys);
		return hm.containsKey(keys);
	}
	//ex9
	public <T,U> boolean valueChecker(HashMap<T,U> hm, U values) throws UserException
	{
		check(hm);
		check(values);
		return hm.containsValue(values);
	}
	//ex10
	public <T,U> void change(HashMap<T,U> hm,T[] key,U[] val) throws UserException
	{
		int len = mapLength(hm);
		for(int i=0; i<len; i++)
		{
			add(hm, key[i], val[i]);
		}
	}
	//ex11,12
	public <T,U> U getValue(HashMap<T,U> hm,T key) throws UserException
	{
		check(hm);
		check(key);
		return hm.get(key);
	}
	//ex13
	public <T> String getDefaultValue(HashMap<T,String> hm,T key) throws UserException
	{
		check(hm);
		check(key);
		return hm.getOrDefault(key,"Zoho");
	}
	//ex14
	public <T,U> void remove(HashMap<T,U> hm,T key) throws UserException
	{
		check(hm);
		check(key);
		hm.remove(key);
	}
	//ex15
	public <T,U> void removeIfExist(HashMap<T,U> hm,T key,U value) throws UserException
	{
		check(hm);
		check(key);
		hm.remove(key,value);
	}
	//ex16
	public <T,U> void replace(HashMap<T,U> hm,T key,U value) throws UserException
	{
		check(hm);
		check(key);
		add(hm,key,value);
	}
	//ex17
	public <T,U> void replaceIfMatch(HashMap<T,U> hm,T key,U oldValue,U newValue) throws UserException
	{
		check(hm);
		check(key);
		hm.replace(key,oldValue,newValue);
	}
	//ex18
	public <T,U> void join(HashMap<T,U> hm,HashMap<T,U> hashM) throws UserException
	{
		check(hm);
		check(hashM);
		hm.putAll(hashM);
	}
	//ex19
	public <T,U> void elementDisplay(HashMap<T,U> hm) throws UserException
	{
		check(hm);
		Iterator<HashMap.Entry<T,U>> repeat = hm.entrySet().iterator();
		while(repeat.hasNext())
		{
			System.out.println(repeat.next());
		}
	}
	//ex20
	public <T,U> void clear(HashMap<T,U> hm) throws UserException
	{
		check(hm);
		hm.clear();
	}
}
