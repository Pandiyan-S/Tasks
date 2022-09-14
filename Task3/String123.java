package beginnerstring;

import java.util.Objects;
public class String123
{
	public void check(Object obj) throws UserException
	{
		if(Objects.isNull(obj))
		{
			throw new UserException("the value is null ");
		}
	}
	public int getLen(String line) throws UserException
	{
		check(line);
		return line.length();
	}
	public char[] toCharArr(String line) throws UserException
	{
		check(line);
		return line.toCharArray();
	}
	public char nUltimate(int n, String line) throws UserException
	{
		int lineLen = getLen(line);
		if(lineLen<n || n < 0)
		{
			throw new UserException("invalid integer input");
		}
		else
		{
			return (line.charAt(lineLen-n));
		}
		
	}
	public int findOcc(char ch, String line) throws UserException
	{
		int lineLen = getLen(line);
		int count = 0;
		for(int i = 0 ; i < lineLen ; i++)
		{
			if(line.charAt(i) == ch)
			{
				count++;
			}
		}
		return count;
	}
	public int greatestPos(char ch,String line) throws UserException
	{
		check(line);
		return line.lastIndexOf(ch);
	}
	public String lastN(int n,String line) throws UserException
	{
		int lineLen = getLen(line);
		if(lineLen<n || n<0)
		{
			throw new UserException("invalid integer input");
		}
		else
		{
			return line.substring(lineLen-n);
		}
	}
	public String firstN(int n,String line) throws UserException
	{
		if(getLen(line)<n || n<0)
		{
			throw new UserException("Invalid integer input");
		}
		else
		{
			return line.substring(0,n);
		}
		
	}
	public String replace(String line,String str) throws UserException
	{
		int n = getLen(str);
		if(getLen(line)< n)
		{
			throw new UserException("Replacing string is larger than original string");
		}
		else
		{
			return line.replaceFirst(line.substring(0,n),str);
		}
	}
	public boolean isBeginningWith(String line,String beg) throws UserException
	{
		int n = getLen(beg);
		if(getLen(line)<n)
		{
			throw new UserException("prefixing string is larger than original string");
		}
		line = correct(line);
		if(line.isEmpty() || beg.isEmpty())
		{
			return false;
		}
		return line.startsWith(beg);
	}
	public boolean isEndingWith(String line, String end) throws UserException
	{
		int n = end.length();
		if(getLen(line)<n)
		{
			throw new UserException("suffixing string is larger than original string");
		}
		line = correct(line);
		if(line.isEmpty() || end.isEmpty())
		{
			return false;
		}
		return line.endsWith(end);
	}
	public String convertToUpper(String line) throws UserException
	{
		check(line);
		return line.toUpperCase();
	}
	public String convertToLower(String line) throws UserException
	{
		check(line);
		return line.toLowerCase();
	}
	public String reverse(String line) throws UserException
	{
		char[] str1 = toCharArr(line);
		if(str1.length != 0)
		{
			char[] str2 = new char[str1.length];
			for(int i=0; i<last ; i++)
			{
				str2[last-1-i] = str1[i];
			}
			line = line.valueOf(str2);
		}
		return line;
	}
	public String remove(String line, String undo) throws UserException
	{
		check(line);
		check(undo);
		return line.replace(undo,"");
	}
	public String[] splitString(String line, String breaker) throws UserException
	{
		check(line);
		try
		{
			return line.split(breaker);
		}
		catch(Exception e)
		{
			throw new UserException("the splitting string does not exist in the original line");
		}
	}
	public String mergeString(int num, String[] strArr) throws UserException
	{
		check(strArr);
		if(num != strarr.length)
		{
			throw new UserException("missmatch between number of strings and integer value");
		}
		check(strarr[0]);
		String str = strArr[0];
		for(int i=1; i<strArr.length; i++)
		{
			check(strarr[i]);
			if(!strarr[i].isEmpty())
			{
				str = str + "-" + strarr[i];
			}
		}
		if(num == 0)
		{
			throw new UserException("no strings in array");
		}
		return str;
	}
	public boolean csComp(String str1,String str2) throws UserException
	{
		check(str1);
		check(str2);
		return str1.equals(str2);
	}
	public boolean ncsComp(String str1,String str2) throws UserException
	{
		check(str1);
		check(str2);
		return str1.equalsIgnoreCase(str2);
	}
	public String correct(String line) throws UserException
	{
		check(line);
		return line.trim();
	}
}
