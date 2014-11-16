import java.util.*;

class Solution {
	public int evalRPN(String[] tokens) {
		int num1, num2, result = 0;
		for (String token : tokens) {
			if (Arrays.asList("+", "-", "*", "/").contains(token)) {
				num1 = stack.get(stack.size() - 2);
				num2 = stack.get(stack.size() - 1);
				switch (token) {
				case "+":
					result = num1 + num2; break;
				case "-":
					result = num1 - num2; break;
				case "*":
					result = num1 * num2; break;
				case "/":
					result = num1 / num2; break;
				}
				stack.remove(stack.size() - 1);
				stack.remove(stack.size() - 1);
				stack.add(result);
			} else {
				stack.add(Integer.parseInt(token));
			}
		}
		return stack.get(0);
	}

	List<Integer> stack = new ArrayList<Integer>();
}

class Main {
	public static void main(String[] args) {
		String[] tokens = { "4", "13", "5", "/", "+" };
		System.out.println(new Solution().evalRPN(tokens));
	}
}