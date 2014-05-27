## [Climbing Stairs](https://oj.leetcode.com/problems/climbing-stairs/)

### Problem

You are climbing a stair case. It takes n steps to reach to the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

### Solution

Recurrence relation:

a(n) = a(n-1) + a(n-2)

### Code

``` java
public class Solution {
    public int climbStairs(int n) {
        if (n < 2) {
            return 1;
        }
        int count = 0;
        int lc = 1, llc = 1;
        for (int i = 1; i < n; i++) {
            count = lc + llc;
            lc = llc;
            llc = count;
        }
        return count;
    }
}
```

### Refinement