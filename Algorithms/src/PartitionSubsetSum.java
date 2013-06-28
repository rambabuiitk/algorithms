public class PartitionSubsetSum {

	public static boolean findPartion(int arr[]) {
		int sum = 0;
		int i, j;
		// Calculate sum of all elements
		for (i = 0; i < arr.length; i++)
			sum += arr[i];
		if (sum % 2 != 0)
			return false;
		boolean part[][] = new boolean[sum / 2 + 1][arr.length + 1];
		// initialize top row as true
		for (i = 0; i <= arr.length; i++)
			part[0][i] = true;
		// initialize leftmost column, except part[0][0], as 0
		for (i = 1; i <= sum / 2; i++)
			part[i][0] = false;
		// Fill the partition table in bottom up manner
		for (i = 1; i <= sum / 2; i++) {
			for (j = 1; j <= arr.length; j++) {
				part[i][j] = part[i][j - 1];
				if (i >= arr[j - 1])
					part[i][j] = part[i][j] || part[i - arr[j - 1]][j - 1];
			}
		}
		return part[sum / 2][arr.length];
	}
	public static void main(String[] args) {
		int arr[] = { 3, 1, 1, 2, 2, 1 };
		if (findPartion(arr) == true)
		{
			System.out.println("Can be divided into two subsets of equal sum");
		}
		else
		{
			System.out.println("Can not be divided into two subsets of equal sum");
		}
	}
}
