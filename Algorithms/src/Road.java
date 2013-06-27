import java.util.HashMap;
import java.util.Map;

public class Road {

	static Map<String, Integer> map = new HashMap<String, Integer>();
	int size;
	static int distance_sum[];

	public Road(String[] towns, int[] distances) {

		if (towns.length < 2 || distances.length < 1
				|| distances.length != towns.length - 1)
			return;

		distance_sum = new int[distances.length];
		for (int i = 0; i < towns.length; i++) {
			map.put(towns[i], i);
		}

		distance_sum[0] = 0;
		for (int i = 1; i < distances.length + 1; i++) {
			distance_sum[i] += distances[i - 1] + distance_sum[i - 1];
		}
	}

	public static int findDistance(String from, String to) {
		int startIndex = -1;
		if (map.get(from) != null)
			startIndex = map.get(from);

		int toIndex = -1;
		if (map.get(to) != null)
			toIndex = map.get(to);

		if (toIndex == -1 || startIndex == -1)
			return -1;
		if (startIndex == toIndex)
			return 0;

		if (startIndex > toIndex) {
			return distance_sum[startIndex] - distance_sum[toIndex];
		} else
			return distance_sum[toIndex] - distance_sum[startIndex];
	}

}
