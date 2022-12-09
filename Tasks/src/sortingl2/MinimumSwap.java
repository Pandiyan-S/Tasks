package sortingl2;

import java.io.IOException;

public class MinimumSwap
{
    public static void main(String[] args) throws IOException
    {
    	MinimumSwap test = new MinimumSwap();
        int[] nums = {2, 8, 5, 4,4};
        System.out.println(test.minSwaps(nums));
    }
    public int minSwaps(int nums[])
    {
        int n = nums.length;
        int count = 0;
        for(int i=0; i<n-1; i++)
        {
            int min = i;
            for(int j=i+1; j<n; j++)
            {
                if(nums[j]<nums[min])
                {
                    min = j;
                }
            }
            if(min != i)
            {
                count++;
                int temp = nums[min];
                nums[min] = nums[i];
                nums[i] = temp;
            }
        }
        return count;
    }
}
