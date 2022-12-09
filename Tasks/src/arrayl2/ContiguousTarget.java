package arrayl2;

import java.util.ArrayList;
import java.util.List;

public class ContiguousTarget
{
	public static void main(String[] args)
	{
		ContiguousTarget test = new ContiguousTarget();
		int[] arr = {1,2,3,4,5,6,7,8,9,10};
		int S = 15;
		for(int i:test.kadence(arr, S))
		{
			System.out.print(i + " ");
		}
	}
	private List<Integer> kadence(int[] arr, int S)
	{
		int n = arr.length;
		List<Integer> list = new ArrayList<>();
		int now = 0;
		int start = 0;
		boolean sub = true;
        for(int i=0; i<n; i++)
        {
            if(sub)
            {
            	now += arr[i];
            }
            if(now>S)
            {
                now -= arr[start];
                start++;
                i--;
                sub = false;
                continue;
            }
            if(now == S)
            {
            	list.add(start);
            	list.add(i);
            	return list;
            }
            sub = true;
        }
        if(now == S)
        {
        	list.add(start);
        	list.add(n-1);
        	return list;
        }
        return list;
	}
}
