package sortingl2;

import java.io.IOException;

public class InsertionSort
{
	public static void main(String[] args) throws IOException
    {
		InsertionSort test = new InsertionSort();
        int[] nums = {2, 8, 5, 4, 4};
        test.insertionSort(nums);
        for(int i:nums)
        {
        	System.out.print(i + " ");
        }
    }
    public void insertionSort(int nums[])
    {
    	int n = nums.length;
    	for(int i=1; i<n; i++)
    	{
    		int temp = nums[i];
    		int j = i-1;
    		while(j>=0 && nums[j]>temp)
    		{
    			nums[j+1] = nums[j];
    			j--;
    		}
    		nums[++j] = temp;
    	}
    }
}
