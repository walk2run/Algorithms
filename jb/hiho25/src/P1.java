import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class Name implements Comparable<Name> {
  String name, roman;
  int num;
  Name(String name, String roman) {
    this.name = name;
    this.roman = roman;
    this.num = romanToInt(roman);
  }

  @Override
  public String toString() {
    return name + " " + roman;
  }

  @Override
  public int compareTo(Name n) {
    if (name.compareTo(n.name) < 0) return -1;
    if (name.compareTo(n.name) > 0) return 1;
    if (num < n.num) return -1;
    if (num == n.num) return 0;
    return 1;
  }

  int romanToInt(String s) {
    int nums[] = new int[s.length()];
    for (int i = 0; i < s.length(); i++) {
      switch (s.charAt(i)) {
        case 'M':
          nums[i] = 1000;
          break;
        case 'D':
          nums[i] = 500;
          break;
        case 'C':
          nums[i] = 100;
          break;
        case 'L':
          nums[i] = 50;
          break;
        case 'X':
          nums[i] = 10;
          break;
        case 'V':
          nums[i] = 5;
          break;
        case 'I':
          nums[i] = 1;
          break;
      }
    }
    int sum = 0;
    for (int i = 0; i < nums.length - 1; i++) {
      if (nums[i] < nums[i + 1])
        sum -= nums[i];
      else
        sum += nums[i];
    }
    return sum + nums[nums.length - 1];
  }
}

public class P1 {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int n = scan.nextInt();
    List<Name> list = new ArrayList<>();
    for (int i = 0; i < n; i++)
      list.add(new Name(scan.next(), scan.next()));
    Collections.sort(list, null);
    for (Name name : list)
      System.out.println(name);
  }
}
