## Single Number

Given an array of integers, every element appears twice except for one. Find that single one.

**Note:**

Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

``` java
public class Solution {
    public int singleNumber(int[] A) {
        int len = A.length;
        int res = 0;
        for (int i = 0; i < len; i++) {
            res = res ^ A[i];
        }
        
        return res;
    }
}
```