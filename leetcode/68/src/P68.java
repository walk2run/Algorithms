import java.util.ArrayList;
import java.util.List;

/**
 * Created by yfy on 9/26/15.
 * Text Justification
 */

class Solution {
	public List<String> fullJustify(String[] words, int maxWidth) {
		int start, end, sum, i, j, blanks, rem, quo;
		List<String> list = new ArrayList<>();
		start = 0;
		while (start < words.length) {
			sum = 0;
			end = start;
			do {
				if (end == words.length) break;
				if (sum + words[end].length() > maxWidth) break;
				sum += words[end].length() + 1;
				end++;
			} while (true);
			end--;

			StringBuilder sb = new StringBuilder(maxWidth);
			if (end == words.length - 1) {
				for (i = start; i < end; i++)
					sb.append(words[i]).append(' ');
				sb.append(words[end]);
				while (sb.length() < maxWidth)
					sb.append(' ');
			} else if (end == start) {
				sb.append(words[end]);
				for (i = 0; i < maxWidth - words[end].length(); i++)
					sb.append(' ');
			} else {
				blanks = maxWidth - (sum - (end - start + 1));
				quo = blanks / (end - start);
				rem = blanks % (end - start);
				for (i = start; i < end; i++) {
					sb.append(words[i]);
					for (j = 0; j < quo; j++)
						sb.append(' ');
					if (i - start + 1 <= rem)
						sb.append(' ');
				}
				sb.append(words[end]);
			}
			list.add(sb.toString());

			//System.out.printf("%d %d\n", start, end);
			start = end + 1;
		}

		return list;
	}
}

public class P68 {
	public static void main(String[] args) {
		System.out.println(new Solution().fullJustify(new String[]{"What","must","be","shall","be."}, 12));
	}
}
