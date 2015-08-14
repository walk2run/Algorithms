import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by yfy on 2015/8/14.
 * Merge Intervals
 */

class Interval {
	int start;
	int end;
	Interval() { start = 0; end = 0; }
	Interval(int s, int e) { start = s; end = e; }

	@Override
	public String toString() {
		return start + " " + end;
	}
}

class Solution {
	public List<Interval> merge(List<Interval> intervals) {
		List<Interval> list = new ArrayList<>();
		if (intervals.isEmpty()) return list;
		int start, end;
		Collections.sort(intervals, (a, b) -> {
			if (a.start < b.start) return -1;
			else if (a.start == b.start) return 0;
			else return 1;
		});
		start = intervals.get(0).start;
		end = intervals.get(0).end;
		for (Interval in : intervals) {
			if (in.start > end) {
				list.add(new Interval(start, end));
				start = in.start;
				end = in.end;
			} else if (in.end > end)
				end = in.end;
		}
		list.add(new Interval(start, end));
		return list;
	}
}

public class P56 {
	public static void main(String[] args) {
		List<Interval> list = new ArrayList<>();
		list.add(new Interval(8, 10));
		list.add(new Interval(1, 4));
		list.add(new Interval(3, 5));
		System.out.println(new Solution().merge(list));
	}
}
