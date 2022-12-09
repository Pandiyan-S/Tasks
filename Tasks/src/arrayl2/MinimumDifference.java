package arrayl2;

public class MinimumDifference
{
	public static void main(String[] args)
	{
		MinimumDifference test = new MinimumDifference();
		int[] arr = {2, 5, 9};
		for(int i:test.minimum(arr))
		{
			System.out.print(i);
		}
	}
	private int[] minimum(int[] arr)
	{
		int n = arr.length;
		int[] pair = new int[2];
		int min = 0;
		for(int i=0; i<n; i++)
		{
			for(int j = i+1; j<n; j++)
			{
				int diff = arr[i] - arr[j];
				diff = Math.abs(diff);
				if(diff<min)
				{
					min = diff;
					pair[0] = arr[i];
					pair[1] = arr[j];
				}
			}
		}
		return pair;
	}
}
