## [Single Number II](http://oj.leetcode.com/problems/single-number-ii/)

### Problem

Given an array of integers, every element appears three times except for one. Find that single one.

**Note:**

Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

### Solution


### Code

``` Java
public int singleNumber(int[] A) {
     int x1 = 0;   
     int x2 = 0; 
     int mask = 0;

     for (int i : A) {
        x2 ^= x1 & i;
        x1 ^= i;
        mask = ~(x1 & x2);
        x2 &= mask;
        x1 &= mask;
     }

     return x1;  // p = 1, in binary form p = '01', then p1 = 1, so we should return x1; 
                 // if p = 2, in binary form p = '10', then p2 = 1, so we should return x2.
}
```

``` Java
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

### Refinement
