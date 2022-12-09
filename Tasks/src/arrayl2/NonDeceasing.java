package arrayl2;

public class NonDeceasing
{
	public static void main(String[] args)
	{
		NonDeceasing test = new NonDeceasing();
		int[] arr = {10, 22, 33, 21, 41, 60, 80};
		System.out.println(test.longest(arr));
	}
	private boolean longest(int[] arr)
	{
		int n = arr.length;
		if(n == 1)
		{
			return true;
		}
		int count = 0;
		for(int i=1; i<n; i++)
		{
			if(count>1)
			{
				return false;
			}
			if(arr[i]<arr[i-1])
			{
				count++;
				continue;
			}
		}
		if(count>1)
		{
			return false;
		}
		return true;
	}
}
