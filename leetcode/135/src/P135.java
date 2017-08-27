// 135. Candy

class Solution {
  public int candy(int[] ratings) {
    if (ratings.length == 0) return 0;
    int sum = 1, num = 1;
    for (int i = 1; i < ratings.length; i++) {
      if (ratings[i] > ratings[i - 1]) {
        sum += ++num;
      } else if (ratings[i] == ratings[i - 1]) {
        sum += (num = 1);
      } else {
        int count = 0;
        while (i < ratings.length && ratings[i] < ratings[i - 1]) {
          count++;
          if (count < num) sum += count; else sum += count + 1;
          i++;
        }
        i--;
        num = 1;
      }
    }
    return sum;
  }
}

public class P135 {
}
