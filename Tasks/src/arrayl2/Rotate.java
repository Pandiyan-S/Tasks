package arrayl2;

public class Rotate
{
	public static void main(String[] args)
	{
		Rotate test = new Rotate();
		int[] arr = {1,2,3,4,5,6,7,8,9,10};
		for(int i:test.oneStep(arr))
		{
			System.out.print(i + " ");
		}
	}
	private int[] oneStep(int[] arr)
	{
		int n = arr.length;
		int temp = arr[n-1];
		if(n == 1)
		{
			arr[0] = temp;
			return arr;
		}
		for(int i=n-1; i>0; i--)
		{
			arr[i] = arr[i-1];
		}
		arr[0] = temp;
		return arr;
	}
}
