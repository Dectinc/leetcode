## [Single Number](http://oj.leetcode.com/problems/single-number/)

### Problem

Given an array of integers, every element appears twice except for one. Find that single one.

**Note:**

Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

### Solution


### Code

``` Java
public class Solution {
    public int singleNumber(int[] nums) {
        int result = 0;
        
        for (int num : nums) {
            result = result^num;
        }
        
        return result;
    }
}
```

### Refinement
