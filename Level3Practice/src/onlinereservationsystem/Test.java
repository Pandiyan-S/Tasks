package onlinereservationsystem;

import java.util.LinkedList;
import java.util.Queue;

public class Test
{
	public static void main(String[] args)
	{
		Queue<Integer> q = new LinkedList();
		q.add(1);
		System.out.println(q.size());
		q.add(2);
		q.add(3);
		System.out.println(q.size());
		q.poll();
		System.out.println(q.size());
		
	}
}
