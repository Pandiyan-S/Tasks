package task11;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExMethods
{
	public boolean isDigit(String mobile)
	{
		return Pattern.matches("\\d{0,}",mobile);
	}
	public boolean isMobileValid(String mobile)
	{
		return Pattern.matches("[7-9]\\d{9}",mobile);
	}
	public boolean isAlphaNum(String str)
	{
		return Pattern.matches("[0-9a-zA-Z]{0,}",str);
	}
	public boolean isStartingWith(String givenStr,String matchingStr)
	{
		Pattern pat = Pattern.compile("^"+matchingStr);
		Matcher mat = pat.matcher(givenStr);
		return mat.find();
	}
	public boolean contains(String givenStr,String matchingStr)
	{
		Pattern pat = Pattern.compile(matchingStr);
		Matcher mat = pat.matcher(givenStr);
		return mat.find();
	}
	public boolean isEndingWith(String givenStr,String matchingStr)
	{
		Pattern pat = Pattern.compile(matchingStr + "$");
		Matcher mat = pat.matcher(givenStr);
		return mat.find();
	}
	public boolean isMatchingWith(String givenStr,String matchingStr)
	{
		Pattern pat = Pattern.compile("^"+matchingStr+"$");
		Matcher mat = pat.matcher(givenStr);
		return mat.find();
	}
	public boolean isMatchingInsensitiveWith(String givenStr,String matchingStr)
	{
		Pattern pat = Pattern.compile("^"+matchingStr+"$",Pattern.CASE_INSENSITIVE);
		Matcher mat = pat.matcher(givenStr);
		return mat.find();
	}
	public boolean isEmailValid(String email)
	{
		return Pattern.matches("^+\\S+[@]+\\S+[.]+\\S+$",email);
	}
	public boolean isWithinRange(List<String> strList)
	{
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
	public Map<String,Integer> makeMap(List<String> list1,List<String> list2)
	{
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
	public List<String> getTags(String str)
	{
		List<String> list = new ArrayList<String>();
		Pattern pat = Pattern.compile("[<]([^>]+)[>]");
		Matcher mat = pat.matcher(str);
		while(mat.find())
		{
			list.add(mat.group());
		}
		return list;
	}
}
