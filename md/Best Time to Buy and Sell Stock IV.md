## [Best Time to Buy and Sell Stock IV](https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/)

### Problem

Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete at most __k__ transactions.

__Note:__
You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).

### Solution

The main idea referres to [Is it Best Solution with O(n), O(1).](https://leetcode.com/discuss/18330/is-it-best-solution-with-o-n-o-1)

One condsideration has to be taken: while k is large enough(k >= len(prices)/2), the problem is equal to [Best Time to Buy and Sell Stock III](https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/)


### Code

``` Python
#! /usr/bin/env python
# -*- coding: utf-8 -*-
# @filename  188 - Best Time to Buy and Sell Stock IV
# @author   dectinc@icloud.com
# @date     2015-03-19 15:03

class Solution:
    # @return an integer as the maximum profit
    def maxProfit(self, k, prices):
        if k >= len(prices)/2:
            profit = 0
            for i in range(1, len(prices)):
                if prices[i] > prices[i-1]:
                    profit += prices[i] - prices[i-1]
            return profit

        import sys

        minint = -sys.maxint - 1
        holds = [minint] * (k + 1)
        releases = [0] * (k + 1)
        for price in prices:
            for i in range(k, 0, -1):
                releases[i] = max(releases[i], holds[i] + price)
                holds[i] = max(holds[i], releases[i - 1] - price)
        return releases[k]
```

### Refinement
