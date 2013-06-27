import java.util.Arrays;

public class IncreasingSeqWithArray {

	// Binary search
	public static int GetCeilIndex(int A[], int T[], int l, int r, int key) {
		int m;

		while (r - l > 1) {
			m = l + (r - l) / 2;
			if (A[T[m]] >= key)
				r = m;
			else
				l = m;
		}

		return r;
	}

	public static int LongestIncreasingSubsequence(int A[], int size) {
		// Add boundary case, when array size is zero
		// Depend on smart pointers

		int tailIndices[] = new int[size];
		int prevIndices[] = new int[size];
		int len;

		Arrays.fill(prevIndices, -1);

		tailIndices[0] = 0;
		prevIndices[0] = -1;
		len = 1; // it will always point to empty location
		for (int i = 1; i < size; i++) {
			if (A[i] < A[tailIndices[0]]) {
				// new smallest value
				tailIndices[0] = i;
			} else if (A[i] > A[tailIndices[len - 1]]) {
				// A[i] wants to extend largest subsequence
				prevIndices[i] = tailIndices[len - 1];
				tailIndices[len++] = i;
			} else {
				// A[i] wants to be a potential condidate of future subsequence
				// It will replace ceil value in tailIndices
				int pos = GetCeilIndex(A, tailIndices, -1, len - 1, A[i]);

				prevIndices[i] = tailIndices[pos - 1];
				tailIndices[pos] = i;
			}
		}
		System.out.println("LIS of given input");
		for (int i = tailIndices[len - 1]; i >= 0; i = prevIndices[i])
			System.out.print(A[i] + "   ");

		return len;
	}

	public static void main(String args[]) {
		int A[] = { 2, 5, 3, 7, 11, 8, 10, 13, 6 };
		int size = A.length;

		System.out.println("LIS size " + LongestIncreasingSubsequence(A, size));

	}
}
