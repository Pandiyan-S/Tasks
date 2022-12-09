package arrayl2;


public class SumOfSmallAndLarge
{
	public static void main(String[] args)
	{
		SumOfSmallAndLarge test = new SumOfSmallAndLarge();
		int[] arr = {7, 10, 4, 3, 20, 15};
		int k = 3;
		int n = 2;
		System.out.println(test.sum(arr,k,n));
	}
	private int sum(int[] arr, int k, int n)
	{
		int no = arr.length;
		for(int i=no-1; i>=0; i--)
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
		int sum = arr[k-1] + arr[no-n];
		return sum;
	}
}
