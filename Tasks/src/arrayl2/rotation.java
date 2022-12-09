package arrayl2;


public class rotation
{
	public static void main(String[] args)
	{
		rotation test = new rotation();
		int[] arr = {0, 14, 0, 4, 7, 8, 3, 5, 7};
		int num = 11;
		for(int i:test.sum(arr,num))
		{
			System.out.println(i);
		}
	}
	private int[] sum(int[] arr, int num)
	{
		int n = arr.length;
		num = num%n;
		int index = 0;
		int[] array = new int[n];
		for(int i=num; i<n; i++)
		{
			array[index++] = arr[i];
		}
		for(int i=0; i<num; i++)
		{
			array[index++] = arr[i];
		}
		return array;
	}
}
