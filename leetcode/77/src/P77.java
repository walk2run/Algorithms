import java.util.ArrayList;
import java.util.List;

/**
 * Created by yfy on 11/9/15.
 * Combinations
 */

class Solution {
	public List<List<Integer>> combine(int n, int k) {
		this.n = n;
		this.k = k;
		search(1, 1);
		return lists;
	}

	void search(int depth, int begin) {
		for (int i = begin; i <= n - k + depth; i++) {
			list.add(i);
			if (depth == k)
				lists.add(new ArrayList<Integer>(list));
			else
				search(depth + 1, i + 1);
			list.remove(list.size() - 1);
		}
	}

	int n, k;
	List<Integer> list = new ArrayList<>();
	List<List<Integer>> lists = new ArrayList<>();
}

public class P77 {
}
