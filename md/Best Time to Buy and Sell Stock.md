## [Best Time to Buy and Sell Stock](http://oj.leetcode.com/problems/best-time-to-buy-and-sell-stock/)

Say you have an array for which the i^{th} element is the price of a given stock on day i.

If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.

``` java
public class Solution {
    public int maxProfit(int[] prices) {
        int nDays = prices.length;
        if(nDays <= 1) {
            return 0;
        }
        int res = 0, currsum = 0;
        for(int i = 1; i < nDays; i++) {
            if(currsum <= 0) {
                currsum = prices[i] - prices[i-1];
            } else {
                currsum += prices[i] - prices[i-1];
            }
            if(currsum > res) {
                res = currsum;
            }
        }
        return res;
    }
}
```