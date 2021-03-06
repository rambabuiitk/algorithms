public class IncreasingSequence {

	public static int CeilIndex(int A[], int l, int r, int key) {
		int m;

		while (r - l > 1) {
			m = l + (r - l) / 2;
			if (A[m] >= key)
				r = m;
			else
				l = m;
		}
		return r;
	}

	public static int LongestIncreasingSubsequenceLength(int A[], int size) {
		// Add boundary case, when array size is one

		int tailTable[] = new int[size];
		int len; // always points empty slot

		tailTable[0] = A[0];
		len = 1;
		for (int i = 1; i < size; i++) {
			if (A[i] < tailTable[0])
				// new smallest value
				tailTable[0] = A[i];
			else if (A[i] > tailTable[len - 1])
				// A[i] wants to extend largest subsequence
				tailTable[len++] = A[i];
			else
				// A[i] wants to be current end candidate of an existing
				// subsequence
				// It will replace ceil value in tailTable
				tailTable[CeilIndex(tailTable, -1, len - 1, A[i])] = A[i];
			// tailTable[Arrays.binarySearch(tailTable,A[i])] = A[i];
		}

		return len;
	}

	public static void main(String args[]) {
		int A[] = { 2, 5, 3, 7, 11, 8, 10, 13, 6 };
		int n = A.length;

		System.out.println("Length of Longest Increasing Subsequence is "
				+ IncreasingSequence.LongestIncreasingSubsequenceLength(A, n));

	}
}
