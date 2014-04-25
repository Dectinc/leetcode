## [Single Number II](http://oj.leetcode.com/problems/single-number-ii/)

Given an array of integers, every element appears three times except for one. Find that single one.

**Note:**

Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

``` java
public class Solution {
    public int singleNumber(int[] A) {
        int size_of_int = Integer.SIZE;
		int[] sum = new int[32];

		for (int i = A.length - 1; i > -1; i--) {
			int curNum = A[i];
			for (int j = 0; j < size_of_int; j++) {
				if ((curNum >> j) % 2 != 0) {
					sum[j] = sum[j] + 1;
				}
			}
		}

		int res = 0;
		for (int j = 0; j < size_of_int; j++) {
			res |= ((sum[j] % 3) << j);
		}

		return res;
    }
}
```