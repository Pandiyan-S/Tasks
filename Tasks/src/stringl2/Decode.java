package stringl2;

import java.util.Scanner;

public class Decode
{
	public static void main(String[] args)
	{
		String str;
		Decode test = new Decode();
		System.out.println("Enter string 1");
		Scanner sc = new Scanner(System.in);
		str = sc.nextLine();
		System.out.println(test.decode(str));
	}
	private String decode(String str)
	{
		char[] ch = str.toCharArray();
		int n = ch.length;
		int count = 0;
		StringBuilder word = new StringBuilder();
		for(int i=0; i<n; i++)
		{
			if(Character.isDigit(ch[i]))
			{
				count = count*10 + Integer.parseInt(toString().valueOf(ch[i]));
				continue;
			}
			if(count == 0)
			{
				count = 1;
			}
			if(ch[i] == '(' && i+1<n)
			{
				int last = str.lastIndexOf(')');
				String sub = str.substring(i+1, last);
				String inter = decode(sub);
				for(int j=0; j<count; j++)
				{
					word.append(inter);
				}
				count = 0;
				i = last;
				continue;
			}
			for(int j=0; j<count; j++)
			{
				word.append(ch[i]);
			}
			count = 0;
		}
		return word.toString();
	}
}
