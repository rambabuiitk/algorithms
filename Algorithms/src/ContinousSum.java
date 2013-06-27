public class ContinousSum {

	public static void findContinousArray(int A[], int target) {
		for (int i = 0, j = 0, sum = 0; i < A.length; i++) {
			while(j < A.length && sum < target) {
				sum += A[j];
				if(sum >= target)break;
				j++;
			}
			if (sum == target) {
				System.out.println("sub array indices" + i + "," + j);
				return;
			}
			sum -= A[i];
		
		}

	}

	public static void main(String[] args) {
		int a[] = { 1, 2, 3, 4 };
		findContinousArray(a, 5);

	}
}
