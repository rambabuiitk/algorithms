import java.util.Stack;

public class NextGreaterElement {

	public static void NGE(int a[]) {
		Stack<Integer> stack = new Stack<Integer>();
		int current;
		int next;
		stack.push(a[0]);
		for (int i = 1; i < a.length; i++) {
			next = a[i];
			if (!(stack.isEmpty())) {
				current = stack.peek();
				while (current < next) {
					if (stack.isEmpty()) {
						break;
					}
					current = stack.pop();
					System.out.println(current + "," + next);
				}
				stack.push(next);
			}
		}
		
		while(!(stack.isEmpty()))
		{
			current = stack.pop();
			System.out.println(current + ", -1");
		}
	}

	public static void main(String[] args) {
		int a[] = { 11, 3, 21, 3, 25, 6, 2 };
		NGE(a);
	}
}
