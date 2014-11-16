class Solution {
	public int maxProfit(int[] prices) {
		int[] profitLeft = new int[prices.length + 1];
		int[] profitRight = new int[prices.length + 1];
		int min = Integer.MAX_VALUE;
		profitLeft[0] = 0;
		for (int i = 1; i <= prices.length; i++) {
			int price = prices[i - 1];
			if (price < min) min = price;
			if (price - min > profitLeft[i - 1])
				profitLeft[i] = price - min;
			else
				profitLeft[i] = profitLeft[i - 1];
		}
		
		int max = Integer.MIN_VALUE;
		profitRight[prices.length] = 0;
		for (int i = prices.length - 1; i >= 0; i--) {
			int price = prices[i];
			if (price > max) max = price;
			if (max - price > profitRight[i + 1])
				profitRight[i] = max - price;
			else
				profitRight[i] = profitRight[i + 1];
		}
		
		/*for (int x : profitLeft)
			System.out.print(x + " ");
		System.out.println();
		for (int x : profitRight)
			System.out.print(x + " ");
		System.out.println();*/
		
		max = Integer.MIN_VALUE;
		for (int i = 0; i <= prices.length; i++)
			if (profitLeft[i] + profitRight[i] > max)
				max = profitLeft[i] + profitRight[i];
		return max;
	}
}

public class BestTimeToBuyAndSellStockIII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new Solution().maxProfit(new int[] { 1, 2, 5, 0, 7, 6, 8 }));

	}

}
