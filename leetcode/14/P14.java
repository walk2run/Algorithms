public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        int i = 0;
        char ch = 0;
        StringBuilder sb = new StringBuilder();
        while (true) {
            if (i < strs[0].length()) ch = strs[0].charAt(i);
            for (String str : strs) {
                if (i >= str.length()) return sb.toString();
                if (ch != str.charAt(i)) return sb.toString();
            }
            sb.append(ch);
            i++;
        }
    }
}
