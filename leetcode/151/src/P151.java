class Solution {
	public String reverseWords(String s) {
		String[] words = s.split(" +");
		StringBuilder answer = new StringBuilder(s.length());
		for (int i = words.length - 1; i >= 0; i--)
			if (!words[i].equals(""))
				answer.append(words[i]).append(" ");
		if (answer.length() > 0)
			answer.deleteCharAt(answer.length() - 1);
		return answer.toString();
	}
}

public class P151 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print(new Solution().reverseWords(" 1"));
		System.out.print("###");
	}

}
