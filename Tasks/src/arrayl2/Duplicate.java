package arrayl2;


public class Duplicate
{
	public static void main(String[] args)
	{
		Duplicate test = new Duplicate();
		int[] arr = {2 ,3, 6,2,2,1,6};
		test.printNo(arr);
	}
	private void printNo(int[] arr)
	{
		int n = arr.length;
		int count;
		for(int i=0; i<n; i++)
		{
			if(arr[i] == -1)
			{
				continue;
			}
			count = 1;
			System.out.print(arr[i] + " - ");
			for(int j=i+1; j<n; j++)
			{
				if(arr[i] == arr[j])
				{
					count++;
					arr[j] = -1;
				}
			}
			System.out.println(count);
		}
	}
}
