package arrayl2;


public class LongestIncreasingSubSequence
{
	public static void main(String[] args)
	{
		LongestIncreasingSubSequence test = new LongestIncreasingSubSequence();
		int[] arr = {10, 22, 9, 33, 21, 50, 41, 60, 80};
		System.out.println(test.longest(arr));
	}
	private int longest(int[] arr)
	{
		int n = arr.length;
		int[] count = new int[n];
		if(n == 1)
		{
			return 1;
		}
		for(int i=0; i<n; i++)
		{
			count[i] = 1;
		}
		for(int i=1; i<n; i++)
		{
			for(int j=0; j<i; j++)
			{
				if(arr[i] > arr[j] && count[i]<count[j]+1)
				{
					count[i] = count[j]+1;
				}
			}
		}
		int max = 0;
		for(int i=0; i<n; i++)
		{
			if(count[i]>max)
			{
				max = count[i];
			}
		}
		return max;
	}
}
