package arraylisttask;

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
	public List<String> createStrList()
	{
		List<String> list = new ArrayList<String>();
		return list;
	}
	public List<Integer> createIntList()
	{
		List<Integer> list = new ArrayList<Integer>();
		return list;
	}
	public List<Long> createLongList()
	{
		List<Long> list = new ArrayList<Long>();
		return list;
	}
	public List<Float> createFloatList()
	{
		List<Float> list = new ArrayList<Float>();
		return list;
	}
	public List<Lion> createLionList()
	{
		List<Lion> list = new ArrayList<Lion>();
		return list;
	}
	public List<Object> createObjectList()
	{
		List<Object> list = new ArrayList<Object>();
		return list;
	}
	public <T> int arrLen(List<T> list) throws UserException
	{
		check(list);
		return list.size();
	}
	public List<String> addition(String[] str) throws UserException
	{
		check(str);
		List<String> list = createStrList();//swami -resolved
		for(int i=0; i<str.length; i++)//swami - resolved
		{//swami - resolved
			list.add(str[i]);
		}
		return list;
	}
	public List<Integer> intAddition(int... num)
	{
		List<Integer> list = createIntList();//swami - resolved
		for(int i=0; i<num.length; i++)//swami - resolved
		{
			list.add(num[i]);
		}
		return list;
	}
	public List<Long> longAddition(long... num)
	{
		List<Long> list = createLongList();//swami - resolved
		for(int i=0; i<num.length; i++)//swami - resolved
		{
			list.add(num[i]);
		}
		return list;
	}
	public List<Float> decimalAddition(float... num)
	{
		List<Float> list = createFloatList();
		for(int i=0; i<num.length; i++)
		{
			list.add(num[i]);
		}
		return list;
	}
	public List<Lion> objAddition(Lion... num) throws UserException
	{
		check(num);
		List<Lion> list = createLionList();
		for(int i=0; i<num.length; i++)
		{//swami - resolved
			list.add(num[i]);
		}
		return list;
	}
	public List<Object> multiAddition(String[] str,int[] num,Lion... roar) throws UserException
	{
		check(str);
		check(num);
		check(roar);
		List<Object> list = createObjectList();
		for(int i=0; i<str.length; i++)//swami - resolved
		{//swami - resolved
			list.add(str[i]);
		}
		for(int i=0; i<num.length; i++)//swami - resolved
		{
			list.add(num[i]);
		}
		for(int i=0; i<roar.length; i++)
		{//swami - resolved
			list.add(roar[i]);
		}
		return list;
	}
	public int find(List<String> list, String str) throws UserException
	{
		check(list);//swami - resolved
		return list.indexOf(str);
	}
	public <T> void printList(List<T> list) throws UserException
	{
		if(list.isEmpty())
		{
			System.out.println("the Array List is empty ");
			return;
		}
		
		System.out.println("The Array List elements are ");
		Iterator<T> repeat = list.iterator();
		while(repeat.hasNext())
		{
			System.out.println(repeat.next());
		}
	}
	public String show(List<String> list, int index) throws UserException
	{
		if(index<0 || index>=arrLen(list))//swami - resolved
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
		if(index<0 || index>=arrLen(list))//swami - resolved
		{
			throw new UserException("Entered index value invalid ");
		}
		list.add(index,str);
		return list;
	}
	public List<String> subList(List<String> list,int beg,int end) throws UserException
	{
		if(beg<0 || end>=arrLen(list) || beg>end)
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
		List<String> arrList = createStrList();//swami - resolved
		arrList.addAll(list);
		arrList.addAll(bill);
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