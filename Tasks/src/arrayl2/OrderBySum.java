package arrayl2;

import java.util.ArrayList;
import java.util.List;

public class OrderBySum
{
	public static void main(String[] args)
	{
		OrderBySum test = new OrderBySum();
		int[] arr = {0, 14, 0, 4, 7, 8, 3, 5, 7};
		for(List<Integer> i:test.order(arr))
		{
			System.out.println(i.get(1));
		}
	}
	private List<List<Integer>> order(int[] arr)
	{
		int n = arr.length;
		List<List<Integer>> list= new ArrayList<List<Integer>>();
		for(int i=0; i<n; i++)
		{
			List<Integer> pair = new ArrayList<Integer>();
			pair.add(sum(arr[i]));
			pair.add(arr[i]);
			list.add(pair);
		}
		for(int i=n-1; i>=0; i--)
		{
			for(int j=0; j<i; j++)
			{
				if(list.get(j).get(0)>list.get(j+1).get(0))
				{
					List<Integer> temp = list.get(j);
					list.set(j, list.get(j+1));
					list.set(j+1,temp);
				}
				if(list.get(j).get(0) == list.get(j+1).get(0))
				{
					if(list.get(j).get(1) > list.get(j+1).get(1))
					{
						List<Integer> temp = list.get(j);
						list.set(j, list.get(j+1));
						list.set(j+1,temp);
					}
				}
			}
		}
		return list;
	}
	private int sum(int num)
	{
		int sum = 0;
		while(num != 0)
		{
			sum += num%10;
			num = num/10;
		}
		return sum;
	}
}
