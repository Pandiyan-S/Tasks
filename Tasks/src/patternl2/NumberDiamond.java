package patternl2;

public class NumberDiamond
{
	public static void main(String[] args)
	{
		int n = 9;
		for(int i=1; i<=n; i++)
		{
			for(int j=n-i; j>0; j--)
			{
				System.out.print(" ");
			}
			for(int j=i; j>0; j--)
			{
				System.out.print(j);
			}
			for(int j=2; j<=i; j++)
			{
				System.out.print(j);
			}
			System.out.println();
		}
		for(int i=1; i<n; i++)
		{
			for(int j=1; j<=i; j++)
			{
				System.out.print(" ");
			}
			for(int j=n-i; j>0; j--)
			{
				System.out.print(j);
			}
			for(int j=2; j<=n-i; j++)
			{
				System.out.print(j);
			}
			System.out.println();
		}
	}
}
