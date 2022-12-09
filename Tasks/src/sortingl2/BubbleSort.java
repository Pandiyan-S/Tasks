package sortingl2;

import java.io.IOException;

public class BubbleSort
{
	public static void main(String[] args) throws IOException
    {
		BubbleSort test = new BubbleSort();
        int[] nums = {2, 8, 5, 4, 4};
        test.bubbleSort(nums);
        for(int i:nums)
        {
        	System.out.print(i + " ");
        }
    }
    public void bubbleSort(int nums[])
    {
    	int n = nums.length;
    	for(int i=n-1; i>=0; i--)
    	{
    		for(int j=0; j<i; j++)
    		{
    			if(nums[j]> nums[j+1])
    			{
    				int temp = nums[j];
    				nums[j] = nums[j+1];
    				nums[j+1] = temp;
    			}
    		}
    	}
    }
}
