package stringl2;

import java.util.Scanner;

public class BalancedWord
{
	public static void main(String[] args)
	{
		String str;
		BalancedWord test = new BalancedWord();
		System.out.println("Enter string 1");
		Scanner sc = new Scanner(System.in);
		str = sc.nextLine();
		System.out.println(test.balance(str));
		
	}
	private String balance(String str)
	{
		char[] ch = str.toCharArray();
		int n = ch.length;
		if(n<3)
		{
			return "NO balance charaacter";
		}
		int mid = n/2;
		char dir = ' ';
		while(mid>0 && mid<n)
		{
			int cross = 1;
			int left = 0;
			int right = 0;
			for(int i=0; i<mid; i++)
			{
				left += (ch[i] - 'A' + 1)*cross;
				cross++;
			}
			cross = 1;
			for(int i=mid+1; i<n; i++)
			{
				right += (ch[i] - 'A' + 1)*cross;
				cross++;
			}
			if(left == right)
			{
				return String.valueOf(ch[mid]);
			}
			if(left>right)
			{
				if(dir == 'r')
				{
					return "NO balance charaacter";
				}
				dir = 'l';
				mid--;
				continue;
			}
			if(dir == 'l')
			{
				return "NO balance charaacter";
			}
			dir = 'r';
			mid++;
		}
		return "NO balance charaacter";
	}
}
