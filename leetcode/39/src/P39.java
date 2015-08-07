import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by yfy on 2015/8/7.
 * Combination Sum
 */

class Solution {
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		this.target = target;
		this.num = Arrays.stream(candidates).distinct().toArray();
		Arrays.sort(this.num);
		search(0, 0);
		return lists;
	}

	void search(int i, int sum) {
		if (sum == target) {
			lists.add(new ArrayList<>(list));
			return;
		}
		if (i == num.length) return;
		search(i + 1, sum);
		if (sum + num[i] <= target) {
			list.add(num[i]);
			search(i, sum + num[i]);
			list.remove(list.size() - 1);
		}
	}

	int[] num;
	int target;
	List<List<Integer>> lists = new ArrayList<>();
	List<Integer> list = new ArrayList<>();
}

public class P39 {
	public static void main(String[] args) {
		System.out.println(new Solution().combinationSum(
				new int[]{2, 2, 3, 6, 7}, 7));
	}
}
