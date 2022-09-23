package task6;

import java.util.ArrayList;
import java.util.Iterator;
import check.UserException;
import java.util.List;
import java.util.Objects;

public class ArrayListMethods 
{
	public void check(Object obj) throws UserException
	{
		if(Objects.isNull(obj))
		{
			throw new UserException("the value is null ");
		}
	}
	public <T> List<T> create(T... str)
	{
		List<T> list = new ArrayList<T>();
		return list;
	}
	public <T> int arrLen(List<T> list) throws UserException
	{
		check(list);
		return list.size();
	}
	public <T> List<T> addition(T[] str) throws UserException
	{
		List<T> list = create(str);
		for(int i=0; i<str.length; i++)
		{
			check(str[i]);
			list.add(str[i]);
		}
		return list;
	}
	public <T> List<T> intAddition(T[] num)
	{
		List<T> list = create(num);
		for(int i=0; i<num.length; i++)
		{
			list.add(num[i]);
		}
		return list;
	}
//	public List<Float> decimalAddition(Float... num)
//	{
//		List<Float> list = create(num);
//		for(int i=0; i<num.length; i++)
//		{
//			list.add(num[i]);
//		}
//		return list;
//	}
//	public ArrayList<Lion> objAddition(Lion... num) throws UserException
//	{
//		ArrayList<Lion> list = new ArrayList<Lion>();
//		for(int i=0; i<num.length; i++)
//		{
//			check(num[i]);
//			list.add(num[i]);
//		}
//		return list;
//	}
	public List<Object> multiAddition(String[] str,int[] num,Lion... roar) throws UserException
	{
		List<Object> list = create();
		for(int i=0; i<str.length; i++)
		{
			check(str[i]);
			list.add(str[i]);
		}
		for(int i=0; i<num.length; i++)
		{
			list.add(num[i]);
		}
		for(int i=0; i<roar.length; i++)
		{
			check(roar[i]);
			list.add(roar[i]);
		}
		return list;
	}
	public int find(List<String> list, String str) throws UserException
	{
		check(list);
		check(str);
		return list.indexOf(str);
	}
	public <T> void printList(List<T> list) throws UserException
	{
		if(list.isEmpty())
		{
			System.out.println("the Array List is empty ");
		}
		else
		{
			System.out.println("The Array List elements are ");
			Iterator<T> repeat = list.iterator();
			while(repeat.hasNext())
			{
				System.out.println(repeat.next());
			}
		}
	}
	public String show(List<String> list, int index) throws UserException
	{
		if(index<0 || index>arrLen(list))
		{
			throw new UserException("Entered index value invalid ");
		}
		return list.get(index);
	}
	public int findLast(List<String> list, String str) throws UserException
	{
		check(list);
		check(str);
		return list.lastIndexOf(str);
	}
	public List<String> insert(List<String> list, String str, int index) throws UserException
	{
		check(str);
		if(index<0 || index>arrLen(list))
		{
			throw new UserException("Entered index value invalid ");
		}
		list.add(index,str);
		return list;
	}
	public List<String> subList(List<String> list,int beg,int end) throws UserException
	{
		if(beg<0 || end>arrLen(list) || beg>end)
		{
			throw new UserException("Entered index value invalid ");
		}
		list = list.subList(beg, end);
		return list;
	}
	public List<String> combine(List<String> list,List<String> bill) throws UserException
	{
		check(list);
		check(bill);
		List<String> arrList = create("");
		arrList.addAll(list);
		arrList.addAll(bill);
		return arrList;
	}
	public List<String> invCombine(List<String> list,List<String> bill) throws UserException
	{
		check(list);
		check(bill);
		List<String> arrList = create("");
		arrList.addAll(bill);
		arrList.addAll(list);
		return arrList;
	}
	public List<Float> delete(List<Float> list,float point) throws UserException
	{
		check(list);
		list.remove(point);
		return list;
	}
	public List<Float> remove(List<Float> list,int index) throws UserException
	{
		check(list);
		list.remove(index);
		return list;
	}
	public List<String> exclude(List<String> list,List<String> bill) throws UserException
	{
		check(list);
		check(bill);
		list.removeAll(bill);
		return list;
	}
	public List<String> retain(List<String> list,List<String> bill) throws UserException
	{
		check(list);
		check(bill);
		list.retainAll(bill);
		return list;
	}
	public List<Long> empty(List<Long> list) throws UserException
	{
		check(list);
		list.clear();
		return list;
	}
	public boolean contain(List<String> list,String str) throws UserException
	{
		check(list);
		check(str);
		return list.contains(str);
	}
}