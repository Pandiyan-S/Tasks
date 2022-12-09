package stringl2;

import java.util.Scanner;

public class RemovePalindrome
{
	public static void main(String[] args)
	{
		String str;
		RemovePalindrome test = new RemovePalindrome();
		System.out.println("Enter string 1");
		Scanner sc = new Scanner(System.in);
		str = sc.nextLine();
		char[] ch = str.toCharArray();
		int n = ch.length;
		String word = "";
		int len = 0;
		for(int i=0; i<ch.length; i++)
		{
			if(ch[i] == ' ')
			{
				if(word.isEmpty())
				{
					continue;
				}
				if(test.isReverse(word))
				{
					i = i-len;
					ch = test.remove(ch,i,len);
					i--;
				}
				word = "";
				len = 0;
				continue;
			}
			if(i==n-1)
			{
				word += ch[i];
				if(test.isReverse(word))
				{
					i = i-len;
					ch = test.remove(ch,i,len);
					i--;
				}
				word = "";
				len = 0;
				continue;
			}
			word += ch[i];
			len++;
		}
		
		for(char c:ch)
		{
			System.out.print(c);
		}
	}
	private boolean isReverse(String str)
	{
		char[] ch = str.toCharArray();
		int n = ch.length;
		for(int i=0; i<n+1/2; i++)
		{
			if(ch[i] != ch[n-1-i])
			{
				return false;
			}
		}
		return true;
	}
	private char[] remove(char[] ch, int start, int len)
	{
		int n = ch.length;
		for(int i=start; i<n; i++)
		{
			if(i+len+1<n)
			{
				ch[i] = ch[i+len+1];
			}
			else
			{
				ch[i] = ' ';
			}
		}
		return ch;
	}
}
