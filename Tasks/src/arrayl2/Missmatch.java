package arrayl2;

import java.util.ArrayList;
import java.util.List;

public class Missmatch
{
	public static void main(String[] args)
	{
		Missmatch test = new Missmatch();
		char[] arr1 = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h'};
		char[] arr2 = {'a', 'b', 'd', 'e', 'e', 'g', 'g', 'i'};
		for(String i:test.different(arr1, arr2))
		{
			System.out.print(i + ",");
		}
	}
	private List<String> different(char[] arr1, char[] arr2)
	{
		int n = arr1.length;
		List<String> list = new ArrayList<>();
		if(n == 1)
		{
			if(arr1[0] != arr2[0])
			{
				list.add(String.valueOf(arr1[0]));
				list.add(String.valueOf(arr2[0]));
			}
			return list;
		}
		String add1 = "";
		String add2 = "";
		boolean truth = false;
		for(int i=0; i<n; i++)
		{
			if(truth && add1!="" && add2!="")
			{
				list.add(add1);
				list.add(add2);
				add1 = "";
				add2 = "";
			}
			if(arr1[i] != arr2[i])
			{
				add1 += arr1[i];
				add2 += arr2[i];
				truth = false;
				continue;
			}
			truth = true;
		}
		list.add(add1);
		list.add(add2);
		return list;
	}
}
