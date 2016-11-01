import java.util.*;

class Solution {
	public List<List<Integer>> subsets(int[] S) {
		Arrays.sort(S);
		this.S = S;
		search(0);
		return subsets;
	}

	void search(int i) {
		if (i == S.length) {
			subsets.add(new ArrayList<Integer>(subset));
			return;
		}
		subset.add(S[i]);
		search(i + 1);
		subset.remove(subset.size() - 1);
		search(i + 1);
	}

	List<List<Integer>> subsets = new ArrayList<List<Integer>>();
	ArrayList<Integer> subset = new ArrayList<Integer>();
	int[] S;
}

public class P78 {
	public static void main(String[] args) {
		new Solution().subsets(new int[] { 1, 2, 3 });
	}
}
