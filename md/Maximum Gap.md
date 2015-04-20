## [Maximum Gap](https://leetcode.com/problems/maximum-gap/)

### Problem

Given an unsorted array, find the maximum difference between the successive elements in its sorted form.

Try to solve it in linear time/space.

Return 0 if the array contains less than 2 elements.

You may assume all elements in the array are non-negative integers and fit in the 32-bit signed integer range.

### Solution


### Code

``` Java
public class Solution {
    public int maximumGap(int[] num) {
        int length = num.length;
        if (length < 2) {
            return 0;
        }
        int[] lowBounds = new int[length];
        int[] upBounds = new int[length];

        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int a : num) {
            min = Math.min(min, a);
            max = Math.max(max, a);
        }

        int avgGap = (max - min + length) / length;

        for (int a : num) {
            int bucketIndex = (a - min) / avgGap;
            int curMin = lowBounds[bucketIndex], curMax = upBounds[bucketIndex];
            if (curMin == 0 || curMin > a) {
                curMin = a;
            }
            if (curMax == 0 || curMax < a) {
                curMax = a;
            }
            lowBounds[bucketIndex] = curMin;
            upBounds[bucketIndex] = curMax;
        }

        int maxGap = upBounds[0] - lowBounds[0];
        int preMax = upBounds[0];
        for (int i = 1; i < length; i++) {
            if (lowBounds[i] == 0) {
                continue;
            }
            maxGap = Math.max(maxGap, lowBounds[i] - preMax);
            preMax = upBounds[i];
        }

        return maxGap;
    }
}
```

### Refinement
