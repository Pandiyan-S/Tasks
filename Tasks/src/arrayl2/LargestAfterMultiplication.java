package arrayl2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LargestAfterMultiplication
{
	public static void main(String[] args)
	{
		LargestAfterMultiplication test = new LargestAfterMultiplication();
		int[] arr = {2 ,-3, 6,2,2,1,-6};
		System.out.println(test.largest(arr));
	}
	private int largest(int[] arr)
	{
		int n = arr.length;
		if(n == 3)
		{
			return arr[0]*arr[1]*arr[2];
		}
		List<Integer> neg = new ArrayList<Integer>();
		List<Integer> pos = new ArrayList<Integer>();
		for(int i=0; i<n; i++)
		{
			if(arr[i]<0)
			{
				neg.add(arr[i]);
			}
			pos.add(arr[i]);
		}
		Collections.sort(neg);
		int minus = neg.size();
		Collections.sort(pos);
		int plus = pos.size();
		if(plus == 0 && minus >2)
		{
			return neg.get(minus-1)*neg.get(minus-2)*neg.get(minus-3);
		}
		int cross2 = pos.get(plus-3)*pos.get(plus-2)*pos.get(plus-1);
		if(minus < 2)
		{
			return cross2;
		}
		int cross1 = neg.get(minus-1)*neg.get(minus-2)*pos.get(plus-1);
		if(cross1>cross2)
		{
			return cross1;
		}
		return cross2;
	}
}
