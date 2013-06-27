import java.util.ArrayList;
import java.util.List;

public class KSumProblem {

	public static List<Pair> k_sum(int A[], int B[], int m, int n, int k) {

		List<Pair> resultList = new ArrayList<Pair>();
		int indexA = 0;
		int indexB = 0;
		int i, s1, s2, sA = 0, sB = 0;
		resultList.add(new Pair(A[0], B[0]));
		int maxsum = A[0] + B[0];

		for (i = 0; i < k - 1; i++) {
			s1 = A[sA] + B[indexB];
			s2 = A[indexA] + B[sB];

			if (s1 >= s2) {
				if (indexB == n - 1) {
					indexB = sB + 1;
					++sA;
				} else {
					++indexB;
				}
				maxsum = s1;
			} else {
				if (indexA == m - 1) {
					indexA = sA + 1;
					++sB;
				} else {
					++indexA;
				}
				maxsum = s2;
			}

			System.out.println("index A" + indexA + "index B" + indexB + "sA"
					+ sA + "sB" + sB);
			resultList.add(new Pair(A[indexA], B[indexB]));
		}

		return resultList;
	}

	public static void main(String args[]) {
		int A[] = { 10, 9, 6, 4, 3 };
		int B[] = { 15, 13, 12, 10, 7, 5 };
		List<Pair> resultList = k_sum(A, B, 5, 6, 4);
		for(Pair p:resultList)
		{
			System.out.println("("+p.a+","+p.b+")");
		}

	}
}

class Pair {
	int a;
	int b;

	Pair(int x, int y) {
		a = x;
		b = y;
	}

}
