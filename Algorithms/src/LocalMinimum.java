public class LocalMinimum {

	public static int findLocalMinimum(int[] elements, int lowIndex, int highIndex) {
		if (lowIndex > highIndex) {
			return -1;
		}

		if (lowIndex == highIndex) {
			return lowIndex;
		}

		if (lowIndex + 1 == highIndex) {
			if (elements[lowIndex] < elements[highIndex]) {
				return lowIndex;
			}
			return highIndex;
		}

		int midIndex = (lowIndex + highIndex) / 2;

		if ((elements[midIndex] <= elements[midIndex - 1])
				&& (elements[midIndex] <= elements[midIndex + 1])) {
			return midIndex;
		}

		if (elements[midIndex] >= elements[midIndex + 1]) {
			return findLocalMinimum(elements, midIndex, highIndex);
		} else {
			return findLocalMinimum(elements, lowIndex, midIndex);
		}
	}
	
	public static void main(String[] args){
		int Arr[] = {8,5,4,3,1,2,6,9};
		int index = findLocalMinimum(Arr, 0, Arr.length-1);
		System.out.println("local mimimum is "+Arr[index]);
	}

}
