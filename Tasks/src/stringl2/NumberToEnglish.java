package stringl2;

import java.util.Scanner;

public class NumberToEnglish
{
	public static void main(String[] args)
	{
		String[] one = {"zero","one","two","three","four","five","six","seven","eight","nine"};
		String[] ten = {"ten","eleven","twelve","thirteen","fourteen","fifteen","sixteen","seventeen","eighteen","nineteen"};
		String[] ty = {"twenty","thirty","forty","fifty","sixty","seventy","eighty","ninety"};
		boolean zero = true;
		System.out.println("Enter the number : ");
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int i = num/1000;
		if(i != 0)
		{
			zero = false;
			System.out.print(one[i] + " thousand ");
		}
		i = num/100;
		i = i%10;
		if(i !=0)
		{
			zero = false;
			System.out.print(one[i] + " hundred ");
		}
		i = num/10;
		i = i%10;
		if(i >1)
		{
			zero = false;
			System.out.print(ty[i-2] + " ");
			i = num%10;
			if(i!=0)
			{
				System.out.print(one[i]);
			}
		}
		if(i == 1)
		{
			zero = false;
			i = num%10;
			System.out.print(ten[i]);
		}
		if(i == 0)
		{
			i = num%10;
			if(i!=0 || zero == true)
			{
				System.out.print(one[i]);
			}
		}
	}
}
