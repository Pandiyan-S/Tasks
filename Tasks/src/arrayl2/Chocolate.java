package arrayl2;

public class Chocolate
{
	public static void main(String[] args)
	{
		Chocolate test = new Chocolate();
		int[] arr = {4,1,2,1,2};
		int M = 4;
		System.out.println(test.distribute(arr, M));
	}
	private int distribute(int[] arr, int M)
	{
		int n = arr.length;
		for(int i=n-1; i>=0; i--)
		{
			for(int j=0; j<i; j++)
			{
				if(arr[j]>arr[j+1])
				{
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
		int min = Integer.MAX_VALUE;
		for(int i=0; i+M-1<n; i++)
		{
			int diff = arr[i+M-1] - arr[i];
			if(diff<min)
			{
				min = diff;
			}
		}
		return min;
	}
}
