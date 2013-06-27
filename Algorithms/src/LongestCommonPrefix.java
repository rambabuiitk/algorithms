public class LongestCommonPrefix {
	public static String findLongestCommonPrefix(String[] array) {
		String prefix;
		if (array.length > 0) {
			prefix = array[0];
		} else {
			return "";
		}

		for (int i = 1; i < array.length; i++) {
			String s = array[i];
			int j = 0;
			for (; j < Math.min(prefix.length(), s.length()); j++) {
				if (prefix.charAt(j) != s.charAt(j))
					break;
			}

			prefix = prefix.substring(0, j);
		}

		return prefix;
	}

	public static void main(String args[]) {
		String str[] = { "hello", "hellohel", "hellohello" };
		System.out.println("Longest common prefix is"
				+ findLongestCommonPrefix(str));
	}
}