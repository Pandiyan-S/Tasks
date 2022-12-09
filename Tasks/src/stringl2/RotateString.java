package stringl2;

import java.util.Scanner;

public class RotateString
{
	public static void main(String[] args)
	{
		String str1;
		String str2;
		System.out.println("Enter string 1");
		Scanner sc = new Scanner(System.in);
		str1 = sc.nextLine();
		int n = str1.length();
		System.out.println("Enter string 2");
		str2 = sc.nextLine();
		int m = str2.length();
		str1 = str1 + str1;
		if(str1.contains(str2) && n == m)
		{
			System.out.println("Yes");
		}
		else
		{
			System.out.println("No");
		}
	}
}
