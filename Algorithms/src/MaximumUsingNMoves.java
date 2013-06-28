
public class MaximumUsingNMoves {

	public static void MakeMax(int a[], int m)
	{
		int nCount = m;
		for (int i = 0; i < a.length && nCount >= 0; i++)
		{
			//find the maximum number at right
			int nMax = i;
			for (int j = i; j < a.length && nCount >= 0 ; j++)
			{
				nMax = a[j] > a[nMax] ? j : nMax;
				nCount--;
			}

			for (int k = nMax; k != i; k--)
			{
				int nTmp = a[k];
				a[k] = a[k - 1];
				a[k - 1] = nTmp;
				
			}
		}
	}	
	public static void main(String[] args) {
		int a[] = {1,2,3,4,5,6,7,8,9};
		MakeMax(a,12);

		for (int i = 0; i < a.length; i++)
			System.out.print(a[i]+" ");
	}
}
