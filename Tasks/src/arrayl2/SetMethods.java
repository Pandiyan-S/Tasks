package arrayl2;

import java.util.ArrayList;
import java.util.List;

public class SetMethods
{
	public static void main(String[] args)
	{
		SetMethods test = new SetMethods();
		int[] arr1 = {1, 2, 5, 3, 8, 9};
		int[] arr2 = {1, 7, 5, 8, 8};
		System.out.print("Union: ");
		for(int i:test.union(arr1,arr2))
		{
			System.out.print(i + " ");
		}
		System.out.print("\nExcept: ");
		for(int i:test.except(arr1,arr2))
		{
			System.out.print(i + " ");
		}
		System.out.print("\nIntersect: ");
		for(int i:test.intersect(arr1,arr2))
		{
			System.out.print(i + " ");
		}
	}
	private List<Integer> union(int[] arr1, int[] arr2)
	{
		int n = arr1.length;
		int m = arr2.length;
		List<Integer> union = new ArrayList<>();
		for(int i=0; i<n; i++)
		{
			if(!union.contains(arr1[i]))
			{
				union.add(arr1[i]);
			}
		}
		for(int i=0; i<m; i++)
		{
			for(int j=0; j<n; j++)
			{
				if(arr2[i] != arr1[j] && j==n-1)
				{
					if(!union.contains(arr1[i]))
					{
						union.add(arr1[i]);
					}
					continue;
				}
				break;
			}
		}
		return union;
	}
	private List<Integer> except(int[] arr1, int[] arr2)
	{
		int n = arr1.length;
		int m = arr2.length;
		List<Integer> except = new ArrayList<>();
		for(int i=0; i<n; i++)
		{
			if(arr1[i]%2 == 0)
			{
				except.add(arr1[i]);
			}
		}
		for(int i=0; i<m; i++)
		{
			if(arr2[i]%2 == 1)
			{
				except.add(arr2[i]);
			}
		}
		return except;
	}
	private List<Integer> intersect(int[] arr1, int[] arr2)
	{
		int n = arr1.length;
		int m = arr2.length;
		List<Integer> intersect = new ArrayList<>();
		for(int i=0; i<m; i++)
		{
			for(int j=0; j<n; j++)
			{
				if(arr2[i] == arr1[j])
				{
					if(!intersect.contains(arr2[j]))
					{
						intersect.add(arr2[j]);
					}
					break;
				}
			}
		}
		return intersect;
	}
}
