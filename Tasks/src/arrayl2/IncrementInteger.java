package arrayl2;

public class IncrementInteger
{
	public static void main(String[] args)
	{
		IncrementInteger test = new IncrementInteger();
		int[] arr = {2, 5, 9};
		for(int i:test.increment(arr))
		{
			System.out.print(i);
		}
	}
	private int[] increment(int[] arr)
	{
		int n = arr.length;
		for(int i=n-1; i>=0; i--)
		{
			if(arr[i] != 9)
			{
				arr[i]++;
				return arr;
			}
			arr[i] = 0;
		}
		int[] bigger = new int[n+1];
		bigger[0] = 1;
		return bigger;
	}
}
