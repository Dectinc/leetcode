## [Best Time to Buy and Sell Stock III](http://oj.leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/)

### Problem

Say you have an array for which the i^th^ element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete at most two transactions.

__Note:__

You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).

### Solution

Don't need DP to solve this problem. It is still O(n) and basically use the same algorithm solving "Stock I" four times.

Get the max profit with one transaction to the full array. Keep down the start and end positions.
the start and end positions will be included in the result of two transaction. It falls into two categories: A) it is one full transaction, B) they belong to two separate transactions(start belongs to first transaction and end belongs to second transaction).

if A)-- get max profit with one transaction to subarray from 0 to start ; get max profit with one transaction to subarray from end to prices.length.

if B)-- get the max profit with one transaction within ****start and end** in **reverse order****

return the max profit in those cases.

### Code

``` java
public class Solution {
    public int maxProfit(int[] prices) {
        Result res_all = partMaxProfit(prices, 0, prices.length-1);
        Result res_start = partMaxProfit(prices, 0, res_all.start-1);
        Result res_end = partMaxProfit(prices, res_all.end+1, prices.length-1);
        Result res_reverse = partMaxProfit(prices, res_all.end, res_all.start);
        
        int tmpProfit = Math.max(res_start.profit, res_end.profit);
        tmpProfit = Math.max(tmpProfit, res_reverse.profit);
        
        return res_all.profit + tmpProfit;
    }
    
    private Result partMaxProfit(int[] prices, int start, int end) {
        Result res = new Result();
		if (start < 0 || end < 0 || start > prices.length - 1
				|| end > prices.length - 1) {
            return res;
        }
        int nDays = Math.abs(end - start) + 1;
        if (nDays <= 1) {
            return res;
        }
        int step = end > start ? 1 : -1;
        int curSum = 0;
        int pos = start+step;
        int tmpStart = 0;
        for (int i = 1; i < nDays; i++, pos += step) {
            if (curSum <= 0) {
                curSum = prices[pos] - prices[pos-step];
                tmpStart = pos-step;
            } else {
                curSum += prices[pos] - prices[pos-step];
            }
            if (curSum > res.profit) {
                res.profit = curSum;
                res.start = tmpStart;
                res.end = pos;
            }
        }
        
        return res;
    }
    
    class Result{
        int profit;
        int start;
        int end;
        
        public Result() {
            profit = 0;
            start = -1;
            end = -1;
        }
    }
}
```

### Refinement