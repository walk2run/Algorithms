import com.sun.deploy.util.ArrayUtil;

import java.util.*;

/**
 * Created by yfy on 2015/8/12.
 * Group Anagrams
 */

class Solution {
	public List<List<String>> groupAnagrams(String[] strs) {
		Map<String, List<String>> map = new HashMap<>();
		for (String word : strs) {
			char[] chars = word.toCharArray();
			Arrays.sort(chars);
			String sortedWord = new String(chars);
			List<String> list = map.get(sortedWord);
			if (list == null)
				map.put(sortedWord, new ArrayList<>(Arrays.asList(word)));
			else
				list.add(word);
		}
		List<List<String>> lists = new ArrayList<>(map.values());
		for (List<String> list : lists)
			Collections.sort(list);
		return lists;
	}
}

public class P49 {
	public static void main(String[] args) {
		System.out.println(new Solution().
				groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
	}
}
