
public class MaximumBitonic {

	public static int getMaximumElement(int a[], int low, int high)
	{
		if(low == high) return high;
		int mid = low + (high - low)/2;
		if(a[mid] < a[mid+1])
			return getMaximumElement(a, mid+1, high);
		else if(a[mid] > a[mid+1])
			return getMaximumElement(a, low, mid-1);
		else return mid;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
