import java.util.List;
import java.util.ArrayList;

class Solution {
	public List<Integer> grayCode(int n) {
		search(n - 1);
		return list;
	}

	void search(int i) {
		if (i == -1) {
			list.add(x);
			return;
		}
		search(i - 1);
		x = x ^ (1 << i);
		search(i - 1);
	}

	List<Integer> list = new ArrayList<>();
	int x = 0;
}

public class P89 {
	public static void main(String[] args) {
	}
}

