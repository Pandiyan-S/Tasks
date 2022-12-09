package stringl2;

import java.util.Scanner;

public class MagicalString
{
	public static void main(String[] args)
	{
		String str1;
		String str2;
		MagicalString test = new MagicalString();
		System.out.println("Enter string 1");
		Scanner sc = new Scanner(System.in);
		str1 = sc.nextLine();
		System.out.println("Enter string 2");
		str2 = sc.nextLine();
		System.out.println(test.magic(str1,str2));
		
	}
	private String magic(String str1,String str2)
	{
		char[] ch1 = str1.toCharArray();
		char[] ch2 = str2.toCharArray();
		int n = ch1.length;
		if(n == 1)
		{
			if(ch2[0]-ch1[0] == 1)
			{
				return "No such string";
			}
		}
		for(int i=n-1; i>=0; i--)
		{
			if(ch1[i] == 'z')
			{
				ch1[i] = 'a';
				continue;
			}
			ch1[i]++;
			break;
		}
		boolean result = false;
		for(int i=0; i<n; i++)
		{
			if(ch1[i] != ch2[i])
			{
				result = true;
			}
		}
		if(result)
		{
			str1 = "";
			for(int i=0; i<n; i++)
			{
				str1 += ch1[i];
			}
			return str1;
		}
		return "No such string";
	}
}
