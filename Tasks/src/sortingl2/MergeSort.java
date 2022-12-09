package sortingl2;

import java.io.IOException;

public class MergeSort
{
	public static void main(String[] args) throws IOException
    {
		MergeSort test = new MergeSort();
        int[] nums = {1,5,6,3,8,4};
        int n = nums.length;
        test.mergeSort(nums,0,n-1);
        for(int i:nums)
        {
        	System.out.print(i + " ");
        }
    }
    public void mergeSort(int nums[],int l,int r)
    {
    	if(l<r)
    	{
    		int diff = (r-l)/2;
    		int m = diff + l;
    		mergeSort(nums,l,m);
    		mergeSort(nums,m+1,r);
    		merge(nums,l,m,r);
    	}
    }
    public void merge(int nums[],int l,int m,int r)
    {
    	int n1 = m-l+1;
    	int n2 = r-m;
    	int[] L = new int[n1];
    	int[] R = new int[n2];
    	for(int i=0; i<n1; i++)
    	{
    		L[i] = nums[l+i];
    	}
    	for(int i=0; i<n2; i++)
    	{
    		R[i] = nums[m+1+i];
    	}
    	int i = 0;
    	int j = 0;
    	int index = l;
    	while(i<n1 &&j<n2)
    	{
    		if(L[i]<=R[j])
    		{
    			nums[index] = L[i];
    			i++;
    			index++;
    		}
    		else
    		{
    			nums[index] = R[j];
    			j++;
    			index++;
    		}
    	}
    	while(i<n1)
    	{
    		nums[index] = L[i];
    		i++;
    		index++;
    	}
    	while(j<n2)
    	{
    		nums[index] = R[j];
    		j++;
    		index++;
    	}
    }
}
