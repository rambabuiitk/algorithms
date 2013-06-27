import java.util.Stack;

public class ExpressionValidate {

	public static String validateExpression(String expr) {

		char r[] = expr.toCharArray();
		char s[] = expr.toCharArray();
		Stack<Integer> st = new Stack<Integer>();
		int i = 0;
		while (i < s.length) 
		{
			if (s[i] == '(') {
				if (s[i + 1] == '(') {
					st.push(-i);
				} else {
					st.push(i);
				}
				i++;
			} else if (s[i] != ')' && s[i] != '(') {
				i++;
			} else if (s[i] == ')') {
				int top = st.peek();
				if (s[i - 1] == ')' && top < 0) {
					r[-top] = '$';
					r[i] = '$';
					st.pop();
				}

				else if (s[i - 1] == ')' && top > 0) {
					System.out.println("Something is wrong!!");
				}

				else if (s[i - 1] != ')' && top > 0)
					st.pop();
				i++;
			}
		}

		StringBuffer result = new StringBuffer();

		for (i = 0; i<r.length; i++) {
			if (r[i] == '$') {
				continue;
			}
			result.append(r[i]);
		}

		return result.toString();

	}

	public static void main(String[] args) {
		String expr = "((((A+B))C))";
		System.out.println("Validate expression"+validateExpression(expr));

	}

}
