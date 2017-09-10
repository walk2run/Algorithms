import java.util.Scanner;

public class P3 {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    String s = scan.next();
    int m = scan.nextInt();
    int[] c = new int[26];
    for (int i = 0; i < s.length(); i++)
      c[s.charAt(i) - 'a']++;
    int max = 0;
    for (int i = 0; i < 26; i++)
      max = Math.max(c[i], max);
    System.out.println(max);
  }
}
