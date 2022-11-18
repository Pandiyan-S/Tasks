package hashmaptask;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

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
	public Map<String,String> createStrHM()
	{
		Map<String,String> hm = new HashMap<String,String>();
		return hm;
	}
	public Map<Integer,Integer> createIntHM()
	{
		Map<Integer,Integer> hm = new HashMap<Integer,Integer>();
		return hm;
	}
	public Map<String,Integer> createStrIntHM()
	{
		Map<String,Integer> hm = new HashMap<String,Integer>();
		return hm;
	}
	public Map<String,Lion> createStrObjHM()
	{
		Map<String,Lion> hm = new HashMap<String,Lion>();
		return hm;
	}
	public <T,U> int mapLength(Map<T,U> hm) throws UserException
	{
		check(hm);
		return hm.size();
	}
	//ex2,3,4,5,6,7
	public <T,U> void display(Map<T,U> hm) throws UserException
	{
		check(hm);
		System.out.println(hm);
	}
	public <T,U> void add(Map<T,U> hm, T keys,U values) throws UserException
	{
		check(hm);
		hm.put(keys, values);
	}
	//ex8
	public <T,U> boolean keyChecker(Map<T,U> hm, T keys) throws UserException
	{
		check(hm);
		check(keys);
		return hm.containsKey(keys);
	}
	//ex9
	public <T,U> boolean valueChecker(Map<T,U> hm, U values) throws UserException
	{
		check(hm);
		check(values);
		return hm.containsValue(values);
	}
	//ex11,12
	public <T,U> U getValue(Map<T,U> hm,T key) throws UserException
	{
		check(hm);//swami - resolved
		return hm.get(key);
	}
	//ex13
	public <T> String getDefaultValue(Map<T,String> hm,T key) throws UserException
	{
		check(hm);//swami - resolved
		return hm.getOrDefault(key,"Zoho");
	}
	//ex14
	public <T,U> void remove(Map<T,U> hm,T key) throws UserException
	{
		check(hm);
		hm.remove(key);
	}
	//ex15
	public <T,U> void removeIfExist(Map<T,U> hm,T key,U value) throws UserException
	{
		check(hm);
		hm.remove(key,value);
	}
	//ex16
	public <T,U> void replace(Map<T,U> hm,T key,U value) throws UserException
	{
		check(hm);
		add(hm,key,value);
	}
	//ex17
	public <T,U> void replaceIfMatch(Map<T,U> hm,T key,U oldValue,U newValue) throws UserException
	{
		check(hm);
		hm.replace(key,oldValue,newValue);
	}
	//ex18
	public <T,U> void join(Map<T,U> hm,Map<T,U> hashM) throws UserException
	{
		check(hm);
		check(hashM);
		hm.putAll(hashM);
	}
	//ex19
	public <T,U> void elementDisplay(Map<T,U> hm) throws UserException
	{
		check(hm);
		Iterator<Map.Entry<T,U>> repeat = hm.entrySet().iterator();
		while(repeat.hasNext())
		{
			System.out.println(repeat.next());
		}
	}
	//ex20
	public <T,U> void clear(Map<T,U> hm) throws UserException
	{
		check(hm);
		hm.clear();
	}
}
