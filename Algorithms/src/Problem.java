import java.util.Arrays;

public class Problem {

	public static String longestTwoUnique(String s) {
		char str[] = s.toCharArray();
		int[] set = new int[256];
		Arrays.fill(set, -1);
		int i = 0, j = 0;
		String res = "";
		int count = 0;
		while (j < s.length()) {
			if (set[str[j]] == -1) {
				set[str[j]] = j;
				count++;
				if (res.length() <= j - i)
					res = s.substring(i, j);
				if (count > 2) {
					count--;
					int nextI = set[str[i]];
					set[str[i]] = -1;
					i = nextI + 1;
				}
			} else {
				set[str[j]] = j;
				if (res.length() <= j - i)
					res = s.substring(i, j);
			}
			j++;
		}
		if (count <= 2 && res.length() <= j - i)
			res = s.substring(i, j);
		return res;
	}

	public static void main(String args[]) {
		System.out.println("longest string"
				+ longestTwoUnique("aabbccccceeedd"));

	}
}
