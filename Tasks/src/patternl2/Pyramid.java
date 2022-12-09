package patternl2;

public class Pyramid
{
	public static void main(String[] args)
	{
		int n = 20;
		for(int i=1; i<=n; i++)
		{
			for(int j=n-i; j>=0; j--)
			{
				System.out.print(" ");
			}
			for(int j=1; j<=i; j++)
			{
				System.out.print("* ");
			}
			System.out.println();
		}
	}
}
