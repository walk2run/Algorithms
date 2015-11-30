import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by qwordy on 11/30/15.
 * 1004. Sightseeing Trip
 * Floyd, minimum cycle
 */

public class P1004 {
	public static void main(String[] args) {
		scanner = new Scanner(System.in);
		while (solve() == 0);
	}

	static int solve() {
		int n, m, v1, v2, len, i, j, k, minLen;
		int[][] g = new int[101][101];
		int[][] d = new int[101][101];
		mid = new int[101][101];

		n = scanner.nextInt();
		if (n == -1) return -1;
		m = scanner.nextInt();
		for (i = 1; i <= n; i++) {
			for (j = i + 1; j <= n; j++)
				g[i][j] = g[j][i] = d[i][j] = d[j][i] = INF;
			g[i][i] = d[i][i] = 0;
		}
		for (i = 0; i < m; i++) {
			v1 = scanner.nextInt();
			v2 = scanner.nextInt();
			len = scanner.nextInt();
			if (len < g[v1][v2])
				g[v1][v2] = g[v2][v1] = d[v1][v2] = d[v2][v1] = len;
		}

		minLen = INF;
		path = new ArrayList<>();
		for (i = 1; i <= n; i++) {
			for (j = 1; j < i; j++)
				for (k = j + 1; k < i; k++) {
					len = d[j][k] + g[j][i] + g[i][k];
					if (len < minLen) {
						minLen = len;
						path.clear();
						path.add(j);
						dfs(j, k);
						path.add(i);
					}
				}
			for (j = 1; j < n; j++)
				for (k = j + 1; k <= n; k++) {
					len = d[j][i] + d[i][k];
					if (len < d[j][k]) {
						d[j][k] = d[k][j] = len;
						mid[j][k] = mid[k][j] = i;
					}
				}
		}

		if (path.size() > 0) {
			for (int v : path)
				System.out.print(v + " ");
			System.out.println();
		} else {
			System.out.println("No solution.");
		}

		return 0;
	}

	static void dfs(int i, int j) {
		int m = mid[i][j];
		if (m == 0) {
			path.add(j);
		} else {
			dfs(i, m);
			dfs(m, j);
		}
	}

	static Scanner scanner;
	static int[][] mid;
	static List<Integer> path;
	final static int INF = 999999;
}
