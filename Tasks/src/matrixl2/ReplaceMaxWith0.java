package matrixl2;


public class ReplaceMaxWith0
{
	public static void main(String[] args)
	{
		ReplaceMaxWith0 test = new ReplaceMaxWith0();
		int[][] arr = { {0, 1, 1, 1},
						{0, 0, 1, 1},
						{1, 1, 1, 1},
						{0, 0, 0, 0} };
		test.replace(arr);
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
	private void replace(int[][] arr)
	{
		int n = arr.length;
		int m = arr[0].length;
		int max = 0;
		int num = -1;
		for(int i=0; i<n; i++)
		{
			int count = 0;
			for(int j=0; j<m; j++)
			{
				if(arr[i][j] == 1)
				{
					count++;
				}
			}
			if(count>max)
			{
				max = count;
				num = i;
			}
		}
		if(num != -1)
		{
			for(int i=0; i<m; i++)
			{
				arr[num][i] = 0;
			}
		}
	}
}
