## [Maximum Subarray](https://oj.leetcode.com/problems/maximum-subarray/)

### Problem

Find the contiguous subarray within an array (containing at least one number) which has the largest sum.

For example, given the array `[−2,1,−3,4,−1,2,1,−5,4]`,
the contiguous subarray `[4,−1,2,1]` has the largest sum = `6`.

**More practice**:

If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.

### Solution


### Code

- O(n) solution

``` Python
class Solution:
    # @param A, a list of integers
    # @return an integer
    def maxSubArray(self, A):
        max_ending_here = max_so_far = A[0]
        for x in A[1:]:
            max_ending_here = max(x, max_ending_here + x)
            max_so_far = max(max_so_far, max_ending_here)
        return max_so_far
```

- Divide and conquer

``` Python
class Solution:
    # @param A, a list of integers
    # @return an integer
    def maxSubArrayGivenRange(self, A, start, end):
        if start >= end:
            return A[end]
        mid = (start + end) / 2
        maxLeft = self.maxSubArrayGivenRange(A, start, mid)
        maxRight = self.maxSubArrayGivenRange(A, mid+1, end)
        p = mid-1
        maxMidLeft = A[mid]
        tmpSum = maxMidLeft
        while p >= start:
            tmpSum += A[p]
            maxMidLeft = max(maxMidLeft, tmpSum)
            p -= 1
        p = mid+2
        maxMidRight = A[mid+1]
        tmpSum = maxMidRight
        while p <= end:
            tmpSum += A[p]
            maxMidRight = max(maxMidRight, tmpSum)
            p += 1
        maxSum = max(maxLeft, maxRight)
        return max(maxSum, maxMidLeft + maxMidRight)

    def maxSubArray(self, A):
        return self.maxSubArrayGivenRange(A, 0, len(A)-1)
```

### Refinement
