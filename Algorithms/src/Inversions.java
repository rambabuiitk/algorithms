
public class Inversions {

	public static int getInversionCount(int arr[])
	{
	  int invCount = 0;
	  int i, j;
	  int n = arr.length;
	 
	  for(i = 0; i < n - 1; i++)
	  {
	    for(j = i+1; j < n; j++)
	    {
	      if(arr[i] > arr[j])
	    	  invCount++;
	    }
	  }
	 
	  return invCount;
	}
	
	
	/* An auxiliary recursive function that sorts the input array and
	  returns the number of inversions in the array. */
	public static int mergeSort(int arr[], int temp[], int left, int right)
	{
	  int mid, invCount = 0;
	  if (right > left)
	  {
	    // Divide the array into two parts and call _mergeSortAndCountInv()
	    //   for each of the parts 
	    mid = (right + left)/2;
	  
	    // Inversion count will be sum of inversions in left-part, right-part
	    //  and number of inversions in merging 
	    invCount  = mergeSort(arr, temp, left, mid);
	    invCount += mergeSort(arr, temp, mid+1, right);
	  
	    //Merge the two parts
	    invCount += merge(arr, temp, left, mid+1, right);
	  }
	  return invCount;
	}
	  
	// This function merges two sorted arrays and returns inversion count in
	//  the arrays.
	public static int merge(int arr[], int temp[], int left, int mid, int right)
	{
	  int i, j, k;
	  int inv_count = 0;
	  
	  i = left; // i is index for left subarray
	  j = mid;  // i is index for right subarray
	  k = left; // i is index for resultant merged subarray
	  while ((i <= mid - 1) && (j <= right))
	  {
	    if (arr[i] <= arr[j])
	    {
	      temp[k++] = arr[i++];
	    }
	    else
	    {
	      temp[k++] = arr[j++];
	      inv_count = inv_count + (mid - i);
	    }
	  }
	  
	  // Copy the remaining elements of left subarray
	  // (if there are any) to temp
	  while (i <= mid - 1)
	    temp[k++] = arr[i++];
	  
	  // Copy the remaining elements of right subarray
	  // (if there are any) to temp
	  while (j <= right)
	    temp[k++] = arr[j++];
	  
	  // Copy back the merged elements to original array
	  for (i=left; i <= right; i++)
	    arr[i] = temp[i];
	  
	  return inv_count;
	}
	  
		 
	
	public static void main(String args[])
	{
	  int arr[] = {1,3,5,2,4,6};
	  System.out.println(" Number of inversions are "+getInversionCount(arr));
	}
	
}
