import java.util.ArrayList;
import java.util.List;

/**
 * Created by yfy on 2015/8/11.
 * Permutations
 */

class Solution {
	public List<List<Integer>> permute(int[] nums) {
		use = new boolean[nums.length];
		search(0, nums);
		return lists;
	}

	void search(int depth, int[] nums) {
		if (depth == nums.length) {
			lists.add(new ArrayList<>(list));
			return;
		}
		for (int i = 0; i < nums.length; i++) {
			if (!use[i]) {
				list.add(nums[i]);
				use[i] = true;
				search(depth + 1, nums);
				list.remove(list.size() - 1);
				use[i] = false;
			}
		}
	}

	boolean[] use;
	List<Integer> list = new ArrayList<>();
	List<List<Integer>> lists = new ArrayList<>();
}

public class P46 {
	public static void main(String[] args) {
		System.out.println(new Solution().permute(new int[]{1, 2, 4}));
	}
}
