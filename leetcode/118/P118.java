public class Solution {
  public List<List<Integer>> generate(int numRows) {
    List<List<Integer>> lists = new ArrayList<>();
    for (int i = 0; i < numRows; i++) {
      List<Integer> list = new ArrayList<>();
      list.add(1);
      if (i > 0) {
        List<Integer> prevList = lists.get(i - 1);
        for (int j = 1; j < i; j++)
          list.add(prevList.get(j - 1) + prevList.get(j));
        list.add(1);
      }
      lists.add(list);
    }
    return lists;
  }
}
