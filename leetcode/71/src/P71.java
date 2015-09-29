import java.util.ArrayList;
import java.util.List;

/**
 * Created by yfy on 9/29/15.
 * Simplify Path
 */

class Solution {
	public String simplifyPath(String path) {
		List<String> list = new ArrayList<>();
		String[] words = path.split("/+");
		for (String word : words) {
			if (!word.isEmpty())
				if (word.equals("..")) {
					if (!list.isEmpty())
						list.remove(list.size() - 1);
				} else if (!word.equals(".")) {
					list.add(word);
				}
		}
		StringBuilder sb = new StringBuilder();
		for (String word : list) {
			sb.append("/" + word);
		}
		if (sb.length() == 0) sb.append('/');
		//System.out.println(Arrays.toString(words));
		return sb.toString();
	}
}

public class P71 {
	public static void main(String[] args) {
		System.out.println(new Solution().simplifyPath("/a/./b/../../c/"));
	}
}
