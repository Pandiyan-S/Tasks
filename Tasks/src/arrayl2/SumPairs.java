package arrayl2;

import java.util.ArrayList;
import java.util.List;

public class SumPairs
{
	public static void main(String[] args)
	{
		SumPairs test = new SumPairs();
		int[] arr = {0, 14, 0, 4, 7, 8, 3, 5, 7};
		int sum = 11;
		for(String i:test.sum(arr,sum))
		{
			System.out.println(i);
		}
	}
	private List<String> sum(int[] arr, int sum)
	{
		int n = arr.length;
		List<String> list = new ArrayList<>();
		String str = "(";
		for(int i=n-1; i>=0; i--)
		{
			for(int j=i-1; j>=0; j--)
			{
				if(arr[i]+arr[j] == sum)
				{
					str += arr[i] + "," + arr[j] + ")";
					list.add(str);
					str = "(";
				}
			}
		}
		return list;
	}
}
