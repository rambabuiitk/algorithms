import java.util.Arrays;
import java.util.Comparator;

public class ArthimeticProgression {

	public static void main(String[] args) {
		int a[] = {1,-2,3,5,7,-3,8,11,15,19,-5,22,25,-11};
		PrintLongestProg(a);
	}
	
	public static int FindIndex(RECORD rc[], int n, int index)
	{
		for (int i = 0; i < n; i++)
		{
			if (rc[i].nIndex == index)
				return i;
		}
		return -1;
	}

	public static int PrintLongestProg(int a[])
	{
		int n = a.length;
		if (n <= 1) return n;

		RECORD recs[] = new RECORD[n];
		for (int i = 0; i < n; i++)
		{
			recs[i] = new RECORD();
			recs[i].nVal = a[i];
			recs[i].nIndex = i;
		}

		Arrays.sort(recs, new LessThan());

		int pDP[][] = new int[n][n];

		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				pDP[i][j] = 2;

		int nStart = n - 2;
		int nEnd = n - 1;

		for (int i = n - 2; i >= 1; i--)
		{
			int index = FindIndex(recs, n, i);
			if (index < 0) break;

			int l = index - 1;
			int r = index + 1;
			while (l >= 0 && r < n)
			{
				if (recs[l].nVal + recs[r].nVal == 2 * recs[index].nVal)
				{
					if (recs[l].nIndex < i && recs[r].nIndex > i)
					{
						pDP[recs[l].nIndex][i] = pDP[i][recs[r].nIndex] + 1;
						if (pDP[nStart][nEnd] < pDP[recs[l].nIndex][i])
						{
							nStart = recs[l].nIndex;
							nEnd = i;
						}
					}

					l--;
					r++;
				}
				else if (recs[l].nVal + recs[r].nVal < 2 * recs[index].nVal)
					r++;
				else 
					l--;
			}
		}


		int nRet = pDP[nStart][nEnd];
		int nInterval = a[nEnd] - a[nStart];
		System.out.print(a[nStart]+" ");

		while (nEnd < n)
		{
			if (a[nEnd] - a[nStart] == nInterval)
			{
				System.out.print(a[nEnd]+" ");
				nStart = nEnd;
			}

			nEnd++;
		}

		return nRet;
	}
}

class RECORD 
{
	public int nVal;
	public int nIndex;
};

class LessThan implements Comparator<RECORD>
{
	@Override
	public int compare(RECORD r1, RECORD r2) {
		return ((Integer)r1.nVal).compareTo((Integer)r2.nVal);
	}
	
}

