import java.util.Scanner;
import java.util.Stack;

/**
 * Created by yfy on 2017/3/17.
 */
public class P3 {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    String str = scan.next();
    Stack<Integer> stack = new Stack<>();
    for (int i = 0; i < str.length(); i++) {
      char ch = str.charAt(i);
      if (ch == '+' || ch == '-' || ch == '*') {
        int b = stack.pop();
        int a = stack.pop();
        int c = 0;
        switch (ch) {
          case '+':
            c = a + b; break;
          case '-':
            c = a - b; break;
          case '*':
            c = a * b; break;
        }
        stack.push(c);
      } else {
        stack.push(Integer.parseInt(ch + "", 16));
      }
    }
    System.out.println(stack.peek());
  }
}
