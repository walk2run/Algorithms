// Created by qwordy on 11/18/15.
// 1003. Parity
import java.util.HashMap;
import java.util.Scanner;

public class P1003 {
	public static void main(String[] args) {
		scan = new Scanner(System.in);
		while (solve() == 0);
	}

	static int solve() {
		int len, n, i, a, b, ans;
		String parity;
		len = scan.nextInt();
		if (len == -1) return -1;
		n = scan.nextInt();
		DisjointSet set = new DisjointSet();
		ans = 0;
		for (i = 0; i < n; i++){
			a = scan.nextInt();
			b = scan.nextInt();
			parity = scan.next();
			if (ans > 0) continue;
			if (a < 1 || a > len || b < 1 || b > len)
				ans = i;
			b++;
			if (parity.equals("even")) {
				set.union(a, b);
				set.union(-a, -b);
			} else {
				set.union(a, -b);
				set.union(-a, b);
			}
			if (set.connected(a, -a)) ans = i;
		}
		System.out.println(ans == 0 ? n : ans);
		return 0;
	}

	static Scanner scan;
}

class Pair {
	public Pair(int value, int height, Pair father) {
		this.value = value;
		this.height = height;
		this.father = father;
	}
	public int value, height;
	public Pair father;
}

class DisjointSet {
	public Pair root(int a) {
		Pair f = map.get(a);
		if (f == null) return null;
		while (f.father != null)
			f = f.father;
		return f;
	}

	public void union(int a, int b) {
		Pair ra = root(a);
		Pair rb = root(b);
		if (ra == null) {
			ra = new Pair(a, 1, null);
			map.put(a, ra);
		}
		if (rb == null) {
			rb = new Pair(b, 1, null);
			map.put(b, rb);
		}
		if (ra == rb) return;
		if (ra.height < rb.height) {
			ra.father = rb;
		} else {
			rb.father = ra;
			ra.height = Math.max(rb.height + 1, ra.height);
		}
	}

	public boolean connected(int a, int b) {
		Pair p = root(a);
		return p != null && p == root(b);
	}

	HashMap<Integer, Pair> map = new HashMap<>();
}
