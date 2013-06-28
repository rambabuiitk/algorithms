import java.util.Stack;

public class Histogram {
	public static void main(String[] args) {
		int[] A = { 4, 1, 6, 3, 4, 7, 5, 2 };
		int area = largestRectangleArea(A);

		System.out
				.println("reactange with largest area under the curve and above the axis: "
						+ area);
	}

	public static int largestRectangleArea(int[] height) {

		Stack<Integer> stack = new Stack<Integer>();
		int i = 0, max = 0;
		while (i < height.length) {
			if (stack.isEmpty() || height[stack.peek()] <= height[i])
				stack.push(i++);
			else
				max = Math.max(max, height[stack.pop()]
						* (stack.isEmpty() ? i : i - stack.peek() - 1));
		}
		while (!stack.isEmpty())
			max = Math.max(max, height[stack.pop()]
					* (stack.isEmpty() ? i : i - stack.peek() - 1));
		return max;
	}

}