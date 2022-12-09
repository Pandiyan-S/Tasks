package stringl2;

import java.util.Scanner;

public class StringNotMatch
{
	public static void main(String[] args)
	{
		String str1;
		String str2;
		System.out.println("Enter string 1");
		Scanner sc = new Scanner(System.in);
		str1 = sc.nextLine();
		System.out.println("Enter string 2");
		str2 = sc.nextLine();
		char[] ch1 = str1.toCharArray();
		char[] ch2 = str2.toCharArray();
		int n = ch1.length;
		StringBuilder build1 = new StringBuilder();
		StringBuilder build2 = new StringBuilder();
		for(int i=0; i<n; i++)
		{
			if(ch1[i]!=ch2[i])
			{
				build1.append(ch1[i]);
				build2.append(ch2[i]);
				continue;
			}
			if(!build1.toString().isEmpty())
			{
				System.out.println(build1 + "," + build2);
				build1 = new StringBuilder();
				build2 = new StringBuilder();
			}
		}
		if(!build1.toString().isEmpty())
		{
			System.out.println(build1 + "," + build2);
			build1 = new StringBuilder();
			build2 = new StringBuilder();
		}
	}
	//my name is pandiyan
	//my name of pandiiam
}
