## [Maximum Product Subarray](https://leetcode.com/problems/maximum-product-subarray/)

### Problem

Find the contiguous subarray within an array (containing at least one number) which has the largest product.

For example, given the array `[2,3,-2,4]`, the contiguous subarray `[2,3]` has the largest product = `6`.

### Solution


### Code

``` Java
public class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int max = 0;
        int min = 0;
        for (int i = 0; i < n; i++) {
            int cur = nums[i];
            int lastMax = max;
            max = Math.max(max, Math.max(min * cur, max * cur));
            min = Math.min(min, Math.min(min * cur, lastMax * cur));
        }
        return max;
    }
}
```

### Refinement
