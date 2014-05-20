## [Trapping Rain Water](http://oj.leetcode.com/problems/trapping-rain-water/)

### Problem

Given _n_ non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.

For example, 

Given `[0,1,0,2,1,0,1,3,2,1,2,1]`, return `6`.

![](../img/rainwatertrap.png)

### Solution


### Code

``` java
public class Solution {
    public int trap(int[] A) {
        if (A == null || A.length < 3) {
            return 0;
        }
        int len = A.length;
        int trapW = 0;
        
        int max = biSearch(A, 0, len-1, true);
        int leftMax = 0, curLeftMax = max, rightMax = len - 1, curRightMax = max, tmpHeight = 0;
        while (true) {
            leftMax = biSearch(A, 0, curLeftMax-1, false);
            if (leftMax < 0) {
                break;
            }
            tmpHeight = Math.min(A[leftMax], A[curLeftMax]);
            for (int i = leftMax + 1; i < curLeftMax; i++) {
                trapW += tmpHeight - A[i];
            }
            curLeftMax = leftMax;
        }
        
        while (true) {
            rightMax = biSearch(A, curRightMax+1, len-1, true);
            if (rightMax < 0) {
                break;
            }
            tmpHeight = Math.min(A[rightMax], A[curRightMax]);
            for (int i = curRightMax + 1; i < rightMax; i++) {
                trapW += tmpHeight - A[i];
            }
            curRightMax = rightMax;
        }
        
        return trapW;
    }
    
    private int biSearch(int[] A, int start, int end, boolean preferLeft) {
        if (start > end) {
            return -1;
        }
        if (start == end) {
            return start;
        }
        int mid = (start + end) / 2;
        int left = biSearch(A, start, mid, false);
        int right = biSearch(A, mid+1, end, true);
        if (A[left] > A[right]) {
            return left;
        } else if (A[left] < A[right]){
            return right;
        }
        return preferLeft ? left : right;
    }
}
```

### Refinement