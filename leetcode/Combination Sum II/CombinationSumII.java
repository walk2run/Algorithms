import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
	public List<List<Integer>> combinationSum2(int[] num, int target) {
		this.num = num;
		this.target = target;
		Arrays.sort(this.num);
		search(0, 0);
		return lists;
	}
	
	void search(int i, int sum) {
		if (sum == target) {
			lists.add(new ArrayList<Integer>(list));
			return;
		}
		if (i == num.length) return;
		if (sum + num[i] <= target && (i == 0 || num[i-1] == num[i] && use || num[i-1] != num[i])) {
			list.add(num[i]);
			use = true;
			search(i + 1, sum + num[i]);
			list.remove(list.size() - 1);
		}
		use = false;
		search(i + 1, sum);
	}
	
	int[] num;
	int target;
	boolean use;
	List<List<Integer>> lists = new ArrayList<List<Integer>>();
	List<Integer> list = new ArrayList<Integer>();
}

public class CombinationSumII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Solution().combinationSum2(new int[]{10,1,2,7,6,1,5}, 8);
	}

}
