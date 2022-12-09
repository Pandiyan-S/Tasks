package arrayl2;

import java.util.ArrayList;
import java.util.List;

public class FamilyTree
{
	public static void main(String[] args)
	{
		FamilyTree test = new FamilyTree();
		String[][] arr = {{"Ram", "Syam"},{"Akil", "Syam"},{"Nikil", "Ram"},{"Subhash", "Nikil"},{"Karthik", "Akil"}};
		String name = "Syam";
		int num = 3;
		System.out.println(test.descendent(arr ,name ,num));
	}
	private int descendent(String[][] arr, String name, int num)
	{
//		int n = arr.length;
//		Map<String,List<String>> hm = new HashMap<String,List<String>>();
//		for(int i=0; i<n; i++)
//		{
//			if(hm.containsKey(arr[i][1]))
//			{
//				hm.get(arr[i][1]).add(arr[i][0]);
//				continue;
//			}
//			List<String> str = new ArrayList<String>();
//			str.add(arr[i][0]);
//			hm.put(arr[i][1], str);
//		}
		int count = number(arr,name,num).size();
		return count;
	}
	private List<String> number(String[][] arr, String name, int num)
	{
		int n = arr.length;
		List<String> son = new ArrayList<>();
		for(int i=0; i<n; i++)
		{
			if(arr[i][1].equals(name))
			{
				son.add(arr[i][0]);
			}
		}
		if(num == 1)
		{
			return son;
		}
		List<String> child = new ArrayList<>();
		for(String father:son)
		{
			child.addAll(number(arr,father,num-1));
		}
		return child;
	}
//	private List<String> number(Map<String,List<String>> hm, String name, int num)
//	{
//		List<String> son = new ArrayList<String>();
//		son = hm.get(name);
//		if(num == 1)
//		{
//			return list;
//		}
//		List<String> child = new ArrayList<>();
//		for(String father:son)
//		{
//			child.addAll(number(hm,father,num-1));
//		}
//		return child;
//	}
}
