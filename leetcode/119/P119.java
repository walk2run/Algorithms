public class Solution {
  public List<Integer> getRow(int rowIndex) {
    List<Integer> list = null, prevList = null;
    for (int i = 0; i <= rowIndex; i++) {
      list = new ArrayList<>();
      list.add(1);
      if (i > 0) {
        for (int j = 1; j < i; j++)
          list.add(prevList.get(j - 1) + prevList.get(j));
        list.add(1);
      }
      prevList = list;
    }
    return list;
  }
}
