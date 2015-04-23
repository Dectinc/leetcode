package cc.dectinc.leetcode;

public class BestTimetoBuyandSellStock2 {

	/**
	 * @param prices
	 * @return
	 */
	public int maxProfit(int[] prices) {
		int length = prices.length;
		if (length < 2) {
			return 0;
		}
		int last = prices[0];
		int profit = 0;
		for (int i = 1; i < length; i++) {
			int cur = prices[i];
			if (cur > last) {
				profit += cur - last;
			}
			last = cur;
		}
		return profit;
	}

	public int maxProfit2014(int[] prices) {
		int profit = 0;
		int curBuy = 0, curSell = 0;
		boolean holding = false;
		int ndays = prices.length;
		if (ndays < 2) {
			return 0;
		}

		for (int i = 0; i < ndays - 1; i++) {
			if (prices[i] < prices[i + 1] && !holding) {
				curBuy = prices[i];
				holding = true;
			} else if (holding && prices[i] >= prices[i + 1]) {
				curSell = prices[i];
				holding = false;
				profit += curSell - curBuy;
			}
		}

		if (prices[ndays - 1] > curBuy && holding) {
			curSell = prices[ndays - 1];
			holding = false;
			profit += curSell - curBuy;
		}

		return profit;
	}

	public static void main(String[] args) {
		BestTimetoBuyandSellStock2 sol = new BestTimetoBuyandSellStock2();
		int[] prices = {};
		System.out.println(sol.maxProfit(prices));
	}
}