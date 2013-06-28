
public class BinarySearchApproach {

	public static int findIndex(int arr[])
	{
	    assert(arr != null);
	    assert(arr.length > 0);
	    int low = 0;
	    int high = arr.length-1;
	    while (low <= high)
	    {
	        int middle = (low + high)/2;
	        if (arr[middle] == middle)
	            return middle;
	        if (arr[middle] < middle)
	            low = middle + 1;
	        else
	            high = middle - 1;
	    }
	    return -1;
	}
	public static void main(String[] args) {
		int a[] = {-10, -9, -8, 3};
		System.out.println("Index is "+findIndex(a));
	}
}
