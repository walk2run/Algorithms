import java.util.Arrays;
import java.util.Scanner;

class Bear implements Comparable<Bear> {
  int fight, hunger, id;

  public Bear(int fight, int hunger, int id) {
    this.fight = fight;
    this.hunger = hunger;
    this.id = id;
  }

  @Override
  public int compareTo(Bear o) {
    return o.fight - fight;
  }
}

public class P2 {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int n = scan.nextInt();
    int m = scan.nextInt();
    int[] candy = new int[m];
    Bear[] bears = new Bear[n];
    for (int i = 0; i < m; i++)
      candy[i] = scan.nextInt();
    for (int i = 0; i < n; i++)
      bears[i] = new Bear(scan.nextInt(), scan.nextInt(), i);
    Arrays.sort(bears);
    Arrays.sort(candy);
    for (int i = 0; i < n; i++) {
      for (int j = m - 1; j >= 0; j--) {
        if (candy[j] <= 100 && candy[j] <= bears[i].hunger) {
          bears[i].hunger -= candy[j];
          candy[j] = 999;
        }
      }
    }
    int[] ans = new int[n];
    for (int i = 0; i < n; i++)
      ans[bears[i].id] = bears[i].hunger;
    for (int i = 0; i < n; i++)
      System.out.println(ans[i]);
  }
}
