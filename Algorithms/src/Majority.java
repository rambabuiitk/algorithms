
public class Majority {

	public static int FindMostFrequentElement(int[] sequence)
	{
	    int best = 0; 
	    int count = 0;
	    for(int element:sequence)
	    {
	        if (count == 0)
	        {
	            best = element;
	            count = 1;
	        }
	        else
	        {
	            // Vote current choice up or down
	            count += (best == element) ? 1 : -1;
	        }
	    }
	    return best;
	}
	public static void main(String[] args) {
		int [] A = {7,11,8,11,11,9,11,7,11,8,11,9,11};
		System.out.println("Majority Element is"+FindMostFrequentElement(A));
	}
}
