import java.util.Scanner;

public class P1 {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int n = scan.nextInt();
    int k = scan.nextInt();
    int[] temp = new int[101];
    for (int i = 0; i < n; i++) {
      int low = scan.nextInt();
      int high = scan.nextInt();
      for (int j = low; j <= high; j++)
        temp[j + 50]++;
    }
    int min = 999, max = 999;
    for (int i = 0; i <= 100; i++) {
      if (temp[i] >= k) {
        min = i - 50;
        break;
      }
    }
    for (int i = 100; i >= 0; i--) {
      if (temp[i] >= k) {
        max = i - 50;
        break;
      }
    }
    if (min != 999 && max != 999)
      System.out.println(min + " " + max);
    else
      System.out.println("error");
  }
}
