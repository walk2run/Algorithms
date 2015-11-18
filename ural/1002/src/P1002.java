import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by yfy on 11/18/15.
 */

public class P1002 {
	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		int ch;
		br.mark(1);
		while ((ch = br.read()) != '-') {
			br.reset();
			solve();
			br.mark(1);
		}
	}

	static void solve() throws Exception {
		int n, i, maxWordLen, wordLen, j, numLen;
		char[] digits = new char[50];
		HashMap<String, Integer> map = new HashMap<>();

		String number = br.readLine();
		numLen = number.length();
		n = Integer.parseInt(br.readLine());
		int[] f = new int[numLen];
		String[] ans = new String[numLen];
		String[] words = new String[n];
		maxWordLen = 0;
		for (i = 0; i < n; i++) {
			words[i] = br.readLine();
			wordLen = words[i].length();
			if (wordLen > maxWordLen)
				maxWordLen = wordLen;
			for (j = 0; j < wordLen; j++)
				digits[j] = c2d[words[i].charAt(j) - 'a'];
			map.put(new String(digits, 0, wordLen), i);
		}

		for (i = 0; i < numLen; i++) f[i] = INF;
		for (i = 0; i < numLen; i++) {
			for (j = Math.max(i - maxWordLen + 1, 0); j <= i; j++) {
				Integer v = map.get(number.substring(j, i + 1));
				if (v != null) {
					if (j == 0) {
						f[i] = 1;
						ans[i] = words[v];
					} else if (f[j - 1] + 1 < f[i]) {
						f[i] = f[j - 1] + 1;
						ans[i] = words[v];
					}
				}
			}
		}

		ArrayList<String> list = new ArrayList<>();
		if (f[numLen - 1] == INF)
			System.out.println("No solution.");
		else {
			i = numLen - 1;
			while (i >= 0) {
				list.add(ans[i]);
				i -= ans[i].length();
			}
			for (i = list.size() - 1; i > 0; i--)
				System.out.print(list.get(i) + ' ');
			System.out.println(list.get(0));
		}
	}

	static BufferedReader br;
	static char[] c2d = {'2', '2', '2', '3', '3', '3', '4', '4', '1', '1', '5',
			'5', '6', '6', '0', '7', '0', '7', '7', '8', '8', '8', '9', '9', '9', '0'};
	final static int INF = 99999;
}
