package arrayl2;

public class PerfectDigit
{
	public static void main(String[] args)
	{
		PerfectDigit test = new PerfectDigit();
		long arr = 465465465138855626L;
		System.out.println(test.perfect(arr));
	}
	private long perfect(long arr)
	{
		long num = arr;
		while(num/10 != 0)
		{
			int sum = 0;
			while(num != 0)
			{
				sum += num%10;
				num = num/10;
			}
			num = sum;
		}
		return arr *10 + (10-num);
	}
		
}
