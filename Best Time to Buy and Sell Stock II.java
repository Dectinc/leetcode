public class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int curBuy = 0, curSell = 0;
        boolean holding = false;
        int ndays = prices.length;
        if (ndays < 2) {
            return 0;
        }
        
        for (int i = 0; i < ndays - 1; i++) {
            if (prices[i] < prices[i+1] && !holding) {
                curBuy = prices[i];
                holding = true;
            }
            else if (holding && prices[i] >= prices[i+1]) {
                curSell = prices[i];
                holding = false;
                profit += curSell - curBuy;
            }
        }
        
        if (prices[ndays-1] > curBuy && holding) {
            curSell = prices[ndays-1];
            holding = false;
            profit += curSell - curBuy;
        }
        
        return profit;
    }
}