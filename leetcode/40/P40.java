public class Solution {
  private int[] a;
  private int target;
  private List<Integer> list;
  private List<List<Integer>> lists;
  private boolean use;
  
  public List<List<Integer>> combinationSum2(int[] candidates, int target) {
    a = candidates;
    Arrays.sort(a);
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
    if (i == 0 || a[i] == a[i - 1] && use || a[i] != a[i - 1]) {
      list.add(a[i]);
      use = true;
      search(i + 1, sum + a[i]);
      list.remove(list.size() - 1);
    }
    use = false;
    search(i + 1, sum);
  }
}