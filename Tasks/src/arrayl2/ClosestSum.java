package arrayl2;


public class ClosestSum
{
	public static void main(String[] args)
	{
		ClosestSum test = new ClosestSum();
		int[] arr = {1,2,3,4,5,6,7,8,9,10};
		int X = 15;
		for(int i:test.difference(arr, X))
		{
			System.out.print(i + " ");
		}
	}
	private int[] difference(int[] arr, int X)
	{
		int n = arr.length;
		int min = Integer.MAX_VALUE;
		int[] list = new int[2];
		for(int i=0; i<n-1; i++)
		{
			int diff = arr[i]+arr[i+1] - X;
			diff = Math.abs(diff);
			if(diff<min)
			{
				min = diff;
				list[0] = arr[i];
				list[1] = arr[i+1];
			}
		}
		return list;
	}
}
