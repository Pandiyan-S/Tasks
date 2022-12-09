package sortingl2;

import java.io.IOException;

public class QuickSort
{
	public static void main(String[] args) throws IOException
    {
		QuickSort test = new QuickSort();
        int[] nums = {2, 8, 5, 4, 4};
        int n = nums.length;
        test.quickSort(nums,0,n-1);
        for(int i:nums)
        {
        	System.out.print(i + " ");
        }
    }
    public void quickSort(int nums[],int l,int r)
    {
    	if(l<r)
    	{
    		int pi = partition(nums,l,r);
    		quickSort(nums,l,pi-1);
    		quickSort(nums,pi+1,r);
    	}
    }
	private int partition(int[] nums, int l, int r)
	{
		int pivot = nums[r];
		int index = l;
		for(int i=l; i<r; i++)
		{
			if(nums[i]<pivot)
			{
				int temp = nums[index];
				nums[index] = nums[i];
				nums[i] = temp;
				index++;
			}
		}
		int temp = nums[index];
		nums[index] = nums[r];
		nums[r] = temp;
		return index;
	}
}
