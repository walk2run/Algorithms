public class Solution {
  private int[] a;
  private int target;
  private List<Integer> list;
  private List<List<Integer>> lists;
  
  public List<List<Integer>> combinationSum(int[] candidates, int target) {
    a = candidates;
    this.target = target;
    lists = new ArrayList<>();
    list = new ArrayList<>();
    search(0, 0);
    return lists;
  }
  
  private void search(int i, int sum) {
    if (sum > target) return;
    if (sum == target) {
      lists.add(new ArrayList<>(list));
      return;
    }
    if (i == a.length) return;
    search(i + 1, sum);
    int count = 0;
    while (true) {
      count++;
      list.add(a[i]);
      sum += a[i];
      if (sum <= target)
        search(i + 1, sum);
      else
        break;
    }
    for (int j = 0; j < count; j++)
      list.remove(list.size() - 1);
  }
}

// dp
public class Solution {
  public List<List<Integer>> combinationSum(int[] candidates, int target) {
    int[] a = candidates;
    
  }
}