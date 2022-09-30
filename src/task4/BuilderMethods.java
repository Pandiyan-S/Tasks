package task4;

import java.util.Objects;
import check.UserException;

public class BuilderMethods 
{
	public void check(Object obj) throws UserException
	{
		if(Objects.isNull(obj))
		{
			throw new UserException("the value is null ");
		}
	}
	public StringBuilder create()
	{
		StringBuilder fresh = new StringBuilder();
		return fresh;
	}
	//ex1
	public int getLength(String str)
	{
		StringBuilder line = create();
		line.append(str);
		return line.length();
	}
	//ex2
	public StringBuilder join(char delimiter, String... lines) throws UserException
	{
		StringBuilder line = create();
		check(lines);
		int n = lines.length;
		for(int i = 0 ; i < n ; i++ )
		{
			line.append(lines[i]);
			line.append(delimiter);
		}
		int last = lastSymbol(line,String.valueOf(delimiter));
		line.deleteCharAt(last);
		return line;
	}
	public int builderLength(StringBuilder line) throws UserException
	{
		check(line);
		return line.length();
	}
	//ex3
	public StringBuilder insertString (StringBuilder line,String str, char delimiter) throws UserException
	{
		check(line);
		int index = line.indexOf(String.valueOf(delimiter));
		while(index !=-1)
		{
			line.insert(index++, delimiter);
			line.insert(index, str);
			index = index + str.length()+1;
			index = line.indexOf(String.valueOf(delimiter),(index));
		}
		return line;
	}
	public StringBuilder insertString (StringBuilder line,String str) throws UserException
	{
		return insertString(line,str,' ');
	}
	//ex4
	public StringBuilder deleteFirstString (StringBuilder line,String delimiter) throws UserException
	{
		check(line);
		check(delimiter);
		int index = line.indexOf(delimiter)+1;
		if(index != -1)
		{
			line = line.replace(0,index,"");
		}
		return line;
	}
	public StringBuilder deleteFirstString (StringBuilder line) throws UserException
	{
		return deleteFirstString(line," ");
	}
	//ex5
	public StringBuilder replace (StringBuilder line,char ch,String delimiter) throws UserException
	{
		check(line);
		int rep = getLength(delimiter);
		String str ;
		str = String.valueOf(ch);
		int index = line.indexOf(delimiter);
		while(index !=-1)
		{
			line.replace(index,index+rep,str);
			index = line.indexOf(delimiter,(index));
		}
		return line;
	}
	public StringBuilder replace (StringBuilder line,char ch) throws UserException
	{
		return replace(line,ch," ");
	}
	//ex6
	public StringBuilder reverse (StringBuilder line) throws UserException
	{
		check(line);
		return line.reverse();
	}
	//ex7
	public StringBuilder delete (int beg,int end,StringBuilder line) throws UserException
	{
		int len = builderLength(line);
		if(len<10)
		{
			throw new UserException("the string should have minimum 10 characters ");
		}
		if(beg < 0 || end >= len || beg > end)
		{
			throw new UserException("invalid index arguments ");
		}
		line = line.delete(beg,end+1);
		return line;
	}
	//ex8
	public StringBuilder stringReplace (int beg,StringBuilder line, String str) throws UserException
	{
		int len = builderLength(line);
		if(len<10)
		{
			throw new UserException("the string should have minimum 10 characters ");
		}
		if(beg < 0 || beg > len)
		{
			throw new UserException("invalid index arguments ");
		}
		if(len<getLength(str))
		{
			throw new UserException("the replacing should not be greater than original string ");
		}
		line = line.replace(beg,getLength(str)+beg,str);
		return line;
	}
	//ex9
	public int firstSymbol(StringBuilder line,String delimiter) throws UserException
	{
		check(line);
		check(delimiter);
		return line.indexOf(delimiter);
	}
	public int firstSymbol(StringBuilder line) throws UserException
	{
		return firstSymbol(line, " ");
	}
	//ex10
	public int lastSymbol(StringBuilder line,String delimiter) throws UserException
	{
		check(line);
		check(delimiter);
		return line.lastIndexOf(delimiter);
	}
	public int lastSymbol(StringBuilder line) throws UserException
	{
		return lastSymbol(line, " ");
	}
}
