package arrayl2;

import java.util.ArrayList;
import java.util.List;

public class LocalMinima
{
	public static void main(String[] args)
	{
		LocalMinima test = new LocalMinima();
		int[] arr = {16, 17, 49, 3, 77, 21};
		for(int i:test.up(arr))
		{
			System.out.print(i + " ");
		}
	}
	private List<Integer> up(int[] arr)
	{
		int n = arr.length;
		List<Integer> list = new ArrayList<>();
		if(n < 2)
		{
			return list;
		}
		if(arr[0]<arr[1])
		{
			list.add(arr[0]);
		}
		if(arr[n-1] < arr[n-2])
		{
			list.add(arr[n-1]);
		}
		for(int i=1;i<n-1; i++)
		{
			if(arr[i]<arr[i+1] && arr[i]<arr[i-1])
			{
				list.add(arr[i]);
			}
		}
		return list;
	}
}
