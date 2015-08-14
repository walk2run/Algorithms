import java.util.ArrayList;
import java.util.List;

/**
 * Created by yfy on 2015/8/14.
 * Insert Interval
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
	public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
		int i, start, end;
		List<Interval> list = new ArrayList<>();
		if (intervals.isEmpty()) {
			list.add(newInterval);
			return list;
		}
		i = 0;
		while (intervals.get(i).end < newInterval.start) {
			list.add(intervals.get(i));
			i++;
			if (i == intervals.size()) {
				list.add(newInterval);
				return list;
			}
		}
		start = Math.min(intervals.get(i).start, newInterval.start);
		while (intervals.get(i).start <= newInterval.end) {
			i++;
			if (i == intervals.size()) break;
		}
		if (i > 0)
			end = Math.max(intervals.get(i - 1).end, newInterval.end);
		else
			end = newInterval.end;
		list.add(new Interval(start, end));
		while (i < intervals.size())
			list.add(intervals.get(i++));
		return list;
	}
}

public class P57 {
}
