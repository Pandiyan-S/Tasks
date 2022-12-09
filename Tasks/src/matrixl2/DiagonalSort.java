package matrixl2;

public class DiagonalSort
{
	public static void main(String[] args)
	{
		DiagonalSort test = new DiagonalSort();
		int[][] arr = { {5, 2, 0, 7, 1},
						{3, 4, 2, 9, 14},
						{5, 1, 3, 5, 2},
						{4, 2, 6, 2, 1},
						{0, 6, 3, 5, 1} };
		test.sort(arr);
		int n = arr.length;
		for(int i=0; i<n; i++)
		{
			for(int j:arr[i])
			{
				System.out.print(j + " ");
			}
			System.out.println("");
		}
	}
	private void sort(int[][] arr)
	{
		int n = arr.length;
		for(int i=n-1; i>=0; i--)
		{
			for(int j=0; j<i; j++)
			{
				if(arr[j+1][j+1] < arr[j][j] )
				{
					int temp = arr[j][j];
					arr[j][j] = arr[j+1][j+1];
					arr[j+1][j+1] = temp;
				}
			}
		}
	}
}
