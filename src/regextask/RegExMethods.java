package regextask;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import check.UserException;

public class RegExMethods
{
	public void check(Object obj) throws UserException
	{
		if(Objects.isNull(obj))
		{
			throw new UserException("the value is null ");
		}
	}
	public boolean isMobileValid(String mobile) throws UserException
	{
		check(mobile);
		return Pattern.matches("[7-9]\\d{9}",mobile);
	}
	public boolean isAlphaNum(String str) throws UserException
	{
		check(str);
		return Pattern.matches("^[0-9a-zA-Z]{0,}$",str);
	}
	public boolean isStartingWith(String givenStr,String matchingStr) throws UserException
	{
		check(givenStr);
		check(matchingStr);
		Pattern pat = Pattern.compile("^"+matchingStr);
		Matcher mat = pat.matcher(givenStr);
		return mat.find();
	}
	public boolean contains(String givenStr,String matchingStr) throws UserException
	{
		check(givenStr);
		check(matchingStr);
		Pattern pat = Pattern.compile(matchingStr);
		Matcher mat = pat.matcher(givenStr);
		return mat.find();
	}
	public boolean isEndingWith(String givenStr,String matchingStr) throws UserException
	{
		check(givenStr);
		check(matchingStr);
		Pattern pat = Pattern.compile(matchingStr + "$");
		Matcher mat = pat.matcher(givenStr);
		return mat.find();
	}
	public boolean isMatchingWith(String givenStr,String matchingStr) throws UserException
	{
		check(givenStr);
		check(matchingStr);
		Pattern pat = Pattern.compile("^"+matchingStr+"$");
		Matcher mat = pat.matcher(givenStr);
		return mat.find();
	}
	public boolean isMatchingInsensitiveWith(String givenStr,String matchingStr) throws UserException
	{
		check(givenStr);
		check(matchingStr);
		Pattern pat = Pattern.compile("^"+matchingStr+"$",Pattern.CASE_INSENSITIVE);
		Matcher mat = pat.matcher(givenStr);
		return mat.find();
	}
	public boolean isEmailValid(String email) throws UserException
	{
		check(email);
		return Pattern.matches("^+[a-zA-Z0-9.-_]+[@]+[a-zA-Z0-9-]+[.]+[a-zA-Z0-9.]+$",email);
	}
	public boolean isWithinRange(List<String> strList) throws UserException
	{
		check(strList);
		Iterator<String> it = strList.iterator();
		while(it.hasNext())
		{
			boolean condition = Pattern.matches("\\S{1,6}",it.next());
			if(!condition)
			{
				return false;
			}
		}
		return true;
	}
	public Map<String,Integer> makeMap(List<String> list1,List<String> list2) throws UserException
	{
		check(list1);
		check(list2);
		Map<String,Integer> hm = new HashMap<String,Integer>();
		Iterator<String> it = list2.iterator();
		while(it.hasNext())
		{
			String str = it.next();
			for(int i=0; i<list1.size(); i++)
			{
				if(isMatchingWith(str,list1.get(i)))
				{
					hm.put(str,i);
					break;
				}
			}
		}
		return hm;
	}
	public List<String> getTags(String str) throws UserException
	{
		check(str);
		List<String> list = new ArrayList<String>();
		Pattern pat = Pattern.compile("</?([^>]+)>");
		Matcher mat = pat.matcher(str);
		while(mat.find())
		{
			list.add(mat.group());
		}
		return list;
	}
}
