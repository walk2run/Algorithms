import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by yfy on 2015/8/11.
 * Substring with Concatenation of All Words
 */

class Solution {
	public List<Integer> findSubstring(String s, String[] words) {
		Map<String, Integer> map = new HashMap<>();
		for (String word : words) {
			Integer i = map.get(word);
			if (i == null)
				map.put(word, 1);
			else
				map.put(word, i + 1);
		}

		int i, j, i2;
		List<Integer> list = new ArrayList<>();
		Map<String, Integer> map2;
		int wordLen = words[0].length();
		for (i = 0; i <= s.length() - wordLen * words.length; i++) {
			j = i;
			i2 = i + wordLen * words.length;
			map2 = new HashMap<>();
			while (j < i2) {
				String word = s.substring(j, j + wordLen);
				Integer count = map.get(word);
				if (count == null) break;
				Integer count2 = map2.get(word);
				if (count2 == null)
					map2.put(word, 1);
				else {
					map2.put(word, count2 + 1);
					if (count2 + 1 > count) break;
				}
				j += wordLen;
			}
			if (j >= i2) list.add(i);
		}

		return list;
	}
}

public class P30 {
	public static void main(String[] args) {
		System.out.println(new Solution()
				.findSubstring("barfoothefoobarman", new String[]{"foo", "bar"}));
	}
}
