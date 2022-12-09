package patternl2;

public class Triangle
{
	public static void main(String[] args)
	{
		int n = 10;
		for(int i=1; i<n; i++)
		{
			for(int j=n-i; j>0; j--)
			{
				System.out.print(" ");
			}
			System.out.print("*");
			for(int j=1; j<2*i-2; j++)
			{
				System.out.print(" ");
			}
			if(i!=1)
			{
				System.out.print("*");
			}
			System.out.println();
		}
		for(int i=1; i<2*n; i++)
		{
			System.out.print("*");
		}
	}
}
