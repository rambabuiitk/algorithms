import java.util.Arrays;

public class MaxSumInRectangle {

	public int start = 0, finish = 0;

	public int maxSubArraySum(int arr[]) {
		// initialize sum, maxSum and start
		int sum = 0, maxSum = Integer.MIN_VALUE, i;

		// needed if sum NEVER becomes less than 0
		start = 0;
		// Standard Kadane's algorithm. See following link
		for (i = 0; i < arr.length; ++i) {
			sum += arr[i];
			if (sum < 0) {
				sum = 0;
				start = i + 1;
			} else if (sum > maxSum) {
				maxSum = sum;
				finish = i;
			}
		}
		return maxSum;
	}

	// The main function that finds maximum sum rectangle in M[][]
	public void findMaxSum(int M[][]) {
		// Variables to store the final output
		int maxSum = 0, finalLeft = 0, finalRight = 0, 
		finalTop = 0, finalBottom = 0;

		int left, right, i;
		int temp[] = new int[M.length];
		int sum;

		// Set the left column
		for (left = 0; left < M[0].length; ++left) {
			// Initialize all elements of temp as 0
			Arrays.fill(temp, 0);
			// Set the right column for the left column set by outer loop
			for (right = left; right < M[0].length; ++right) {
				// Calculate sum between current left and right for every row 'i'
				for (i = 0; i < M.length; ++i)
					temp[i] += M[i][right];

				// Find the maximum sum subarray in temp[]. The kadane() function
				// also sets values of start and finish. So 'sum' is sum of
				// rectangle between (start, left) and (finish, right) which is
				// the maximum sum with boundary columns strictly as left and right.
				sum = maxSubArraySum(temp);

				// Compare sum with maximum sum so far. If sum is more, then update
				// maxSum and other output values
				if (sum > maxSum) {
					maxSum = sum;
					finalLeft = left;
					finalRight = right;
					finalTop = start;
					finalBottom = finish;
				}
			}
		}

		// Print final values
		System.out.println("(Top, Left) (" + finalTop + "," + finalLeft + ")");
		System.out.println("(Bottom, Right) (" + finalBottom + "," + finalRight
				+ ")");
		System.out.println("Max sum is: " + maxSum);
	}

	public static void main(String args[]) {
		int M[][] = { { 1, 2, -1, -4, -20 }, { -8, -3, 4, 2, 1 },
				{ 3, 8, 10, 1, 3 }, { -4, -1, 1, 7, -6 } };

		new MaxSumInRectangle().findMaxSum(M);
	}
}
