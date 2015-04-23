## [Best Time to Buy and Sell Stock II](http://oj.leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/)

### Problem

Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times). However, you may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).

### Solution


### Code

``` Java
public class Solution {
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
}
```

``` java
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
```

### Refinement
