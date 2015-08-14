import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by yfy on 2015/8/11.
 * Jump Game II
 */

class Solution {
	public int jump(int[] nums) {
		int p0, p1, step, i, n;
		n = nums.length;
		int[] use = new int[n];
		int[] steps = new int[n];
		Queue<Integer> que = new LinkedList<>();
		que.add(0);
		while (!que.isEmpty()) {
			p0 = que.remove();
			step = nums[p0];
			for (p1 = Math.min(p0 + step, n - 1); p1 > p0; p1--) {
				if (p1 == n - 1)
					return steps[p0] + 1;
				if (steps[p1] == 0) {
					que.add(p1);
					steps[p1] = steps[p0] + 1;
				}
			}
		}
		return 0;
	}
}

public class P45 {
	public static void main(String[] args) {
		System.out.println(new Solution().jump(new int[]{2, 3, 1, 1, 4}));
	}
}
