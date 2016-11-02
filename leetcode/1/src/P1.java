import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by yfy on 11/1/16.
 * Two Sum
 * 1. hash
 * 2. sort, squeeze
 */

class Solution {
  public int[] twoSum(int[] nums, int target) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      Integer idx = map.get(nums[i]);
      if (idx == null)
        map.put(nums[i], i);
      else
        if (nums[i] * 2 == target) return new int[]{idx, i};
    }
    for (int num : nums) {
      Integer idx2 = map.get(target - num);
      if (idx2 != null) {
        int idx1 = map.get(num);
        if (idx1 == idx2) continue;
        return new int[]{Math.min(idx1, idx2), Math.max(idx1, idx2)};
      }
    }
    return null;
  }
}

class Solution2 {
  public int[] twoSum(int[] nums, int target) {
    int i, j, sum;
    List<Node> list = new ArrayList<>();
    for (i = 0; i < nums.length; i++)
      list.add(new Node(nums[i], i));
    list.sort((o1, o2) -> o1.num - o2.num);
    i = 0;
    j = nums.length - 1;
    while (true) {
      Node node1 = list.get(i);
      Node node2 = list.get(j);
      sum = node1.num + node2.num;
      if (sum == target)
        return new int[]{Math.min(node1.pos, node2.pos), Math.max(node1.pos, node2.pos)};
      if (sum < target)
        i++;
      else
        j--;
    }
  }

  private static class Node {
    int num, pos;
    public Node(int n, int p) {
      num = n;
      pos = p;
    }
  }
}

public class P1 {
  public static void main(String[] args) {
    new Solution().twoSum(new int[]{3, 2, 4}, 6);
  }
}
