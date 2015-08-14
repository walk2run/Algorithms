public class Solution {
    public int lengthOfLastWord(String s) {
		if (s.isEmpty()) return 0;
        int i = s.length() - 1;
		while (i >= 0 && s.charAt(i) == ' ') i--;
		if (s.charAt(i) == ' ') return 0;
		int j = i;
		while (j >= 0 && s.charAt(j) != ' ') j--;
		if (s.charAt(j) == ' ')
			return i - j;
		else
			return i - j + 1; 
    }
}