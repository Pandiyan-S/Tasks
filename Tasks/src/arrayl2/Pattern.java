package arrayl2;

public class Pattern
{
	public static void main(String[] args)
	{
		Pattern test = new Pattern();
		int[] arr = {11,12,13,14,15,16,17,18,19,20,21,22,23,24,25};
		test.printNo(arr);
	}
	private void printNo(int[] arr)
	{
		int n = arr.length;
		int index = 0;
		for(int i=1; index<n; i++)
		{
			for(int j=0; j<i; j++)
			{
				System.out.print(arr[index++] + " ");
				if(index == n)
				{
					break;
				}
			}
			System.out.println("");
		}
	}
}
