import java.util.Arrays;
import java.util.Comparator;

public class ArrSortComptr {
	public static void main(String[] args) {

		int array[] = { 782, 78, 221, 212, 2211, 22111, 2122, 2120 };
		int[] sortedArr = SortPrimitiveInt(new intComp(), array);
		for (int i = 0; i < sortedArr.length; i++) {
			System.out.print(sortedArr[i]);
		}
	}

	static int[] SortPrimitiveInt(Comparator<Integer> com, int arr[]) {
		Integer[] objInt = intToObject(arr);
		Arrays.sort(objInt, com);
		return intObjToPrimitive(objInt);

	}

	static Integer[] intToObject(int[] arr) {
		Integer[] a = new Integer[arr.length];
		int cnt = 0;
		for (int val : arr)
			a[cnt++] = new Integer(val);
		return a;
	}

	static int[] intObjToPrimitive(Integer... arr) {
		int[] a = new int[arr.length];
		int cnt = 0;
		for (Integer val : arr)
			if (val != null)
				a[cnt++] = val.intValue();
		return a;

	}
}

class intComp implements Comparator<Integer> {
	public int compare(Integer a, Integer b) {
		return ((Integer) joinRight(b, a)).compareTo((Integer) joinRight(a, b));
	}

	int joinRight(int a, int b) {
		if (0 == b)
			return 0;
		int nReminder = b % 10;
		b = b / 10;
		int nRet = joinRight(a, b);

		if (0 != nRet)
			nRet = nRet * 10 + nReminder;
		else
			nRet = a;

		return nRet;
	}
}