import java.util.HashMap;

/**
 * Created by yfy on 11/3/15.
 * Minimum Window Substring
 */

class Solution {
	public String minWindow(String s, String t) {
		int begin, end, go, remain;
		String min, newMin;

		HashMap<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < t.length(); i++) {
			char ch = t.charAt(i);
			if (map.containsKey(ch))
				map.put(ch, map.get(ch) + 1);
			else
				map.put(ch, 1);
		}

		begin = 0;
		end = -1;
		go = 1;
		remain = t.length();
		min = null;
		while (end < s.length() - 1 || go == 0) {
			//System.out.printf("%d %d ", begin, end);
			if (go == 1) {
				end++;
				if (map.containsKey(s.charAt(end))) {
					int v = map.get(s.charAt(end));
					map.put(s.charAt(end), v - 1);
					if (v > 0)
						if (--remain == 0) {
							newMin = s.substring(begin, end + 1);
							if (min == null || newMin.length() < min.length())
								min = newMin;
							go = 0;
						}
				}
			} else {
				if (map.containsKey(s.charAt(begin))) {
					int v = map.get(s.charAt(begin));
					map.put(s.charAt(begin), v + 1);
					if (v >= 0)
						if (++remain > 0) go = 1;
				}
				begin++;
				if (go == 0) {
					newMin = s.substring(begin, end + 1);
					if (min == null || newMin.length() < min.length())
						min = newMin;
				}
			}
			//System.out.printf("%d %d %s\n", begin, end, min);
		}

		if (min == null)
			return "";
		else
			return min;
	}
}

public class P76 {
	public static void main(String[] args) {
		System.out.println(new Solution().minWindow("ADOBECODEBANC", "ABC"));
	}
}
