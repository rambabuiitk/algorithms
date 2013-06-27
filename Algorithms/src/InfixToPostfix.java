import java.util.*;

public class InfixToPostfix {

	// Translate's the expression to postfix

	public static Double evaluatePostfix(String rpn) {
		char[] exp = rpn.toCharArray();
		Stack<Double> stack = new Stack<Double>();

		int len = exp.length;
		for (int i = 0; i < len; i++) {
			if (!isOperator(exp[i])) {
				stack.push(Double.parseDouble("" + exp[i]));
			} else {
				double b = stack.pop();
				double a = stack.pop();
				stack.push(evaluate(a, b, exp[i]));
			}
		}
		double result = stack.pop();
		System.out.println("Result:" + result);
		return result;
	}

	private static Double evaluate(double a, double b, char operator) {
		double result = 0.0;
		switch (operator) {
		case '/':
			result = a / b;
			break;
		case '*':
			result = a * b;
			break;
		case '+':
			result = a + b;
			break;
		case '-':
			result = a - b;
			break;
		}
		return result;
	}

	public static String translate(String expression) {

		String output = "";
		char character = ' ';
		Stack<Character> stack = new Stack<Character>();

		for (int x = 0; x < expression.length(); x++) {
			character = expression.charAt(x);

			if (isOperator(character)) {
				while (!stack.empty()
						&& precedence(stack.peek()) >= precedence(character))
					output += stack.pop() + " ";
				stack.push(character);
			} else if (character == '(') {
				stack.push(character);
			} else if (character == ')') {
				while (!stack.peek().equals('('))
					output += stack.pop();
				stack.pop();
			} else {
				output += character;
			}
		}

		while (!stack.empty()) {
			output += stack.pop();
		}

		return output;
	}

	// Check priority on characters
	public static int precedence(char operator) {
		if (operator == '+' || operator == '-')
			return 1;
		else if (operator == '*' || operator == '/')
			return 2;
		else
			return 0;
	}

	public static boolean isOperator(char element) {
		if (element == '*' || element == '-' || element == '/'
				|| element == '+')
			return true;
		else
			return false;
	}

	public static void main(String args[]) {
		evaluatePostfix(translate("((2*3)-5)/4"));

	}
}