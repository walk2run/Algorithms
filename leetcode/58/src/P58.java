/**
 * Created by yfy on 2015/8/15.
 * Length of Last Word
 */

class Solution {
	public int lengthOfLastWord(String s) {
		String[] strs = s.split(" ");
		if (strs.length == 0) return 0;
		return strs[strs.length - 1].length();
	}
}

public class P58 {
}
