package sortingl2;

import java.io.IOException;

public class SelectionSort 
{
	public static void main(String[] args) throws IOException
    {
		SelectionSort test = new SelectionSort();
        int[] nums = {2, 8, 5, 4, 4};
        test.selectedSort(nums);
        for(int i:nums)
        {
        	System.out.print(i + " ");
        }
    }
    public void selectedSort(int nums[])
    {
    	int n = nums.length;
    	for(int i=0; i<n-1; i++)
    	{
    		int min = i;
    		for(int j=i+1; j<n; j++)
    		{
    			if(nums[min]> nums[j])
    			{
    				min = j;
    			}
    		}
    		if(min != i)
    		{
    			int temp = nums[i];
    			nums[i] = nums[min];
    			nums[min] = temp;
    		}
    	}
    }
}
