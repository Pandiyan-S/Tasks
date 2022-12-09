package arrayl2;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class FindSingle
{
	public static void main(String[] args)
	{
		FindSingle test = new FindSingle();
		int[] arr = {4,1,2,1,2};
		System.out.println(test.find(arr));
	}
	private int find(int[] arr)
	{
		int n = arr.length;
		Set<Integer> hm = new HashSet<Integer>();
		if(n == 1)
		{
			return arr[0];
		}
		for(int i=0; i<n; i++)
		{
			if(hm.contains(arr[i]))
			{
				hm.remove(arr[i]);
				continue;
			}
			hm.add(arr[i]);
		}
		Iterator<Integer> it = hm.iterator();
		return it.next();
	}
}
