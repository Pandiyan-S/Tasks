package arrayl2;

import java.util.ArrayList;
import java.util.List;

public class SevenUp
{
	public static void main(String[] args)
	{
		SevenUp test = new SevenUp();
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
		list.add(arr[0]);
		if(n == 1)
		{
			return list;
		}
		for(int i=1;i<n; i++)
		{
			if(arr[i-1]%7 == 0)
			{
				list.add(arr[i]);
			}
		}
		return list;
	}
}
