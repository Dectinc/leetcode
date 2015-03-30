## [Largest Rectangle in Histogram](https://leetcode.com/problems/largest-rectangle-in-histogram/)

### Problem

 Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.

![](http://www.leetcode.com/wp-content/uploads/2012/04/histogram.png)

Above is a histogram where width of each bar is 1, given height = `[2,1,5,6,2,3]`.

![](http://www.leetcode.com/wp-content/uploads/2012/04/histogram_area.png)

The largest rectangle is shown in the shaded area, which has area = `10` unit.

For example,

Given height = `[2,1,5,6,2,3]`,

return `10`. 

### Solution

Divide and conquer

### Code

``` Python
class Solution:
    # @param height, a list of integer
    # @return an integer
    def largestRectangleArea(self, height, begin=0, end=-1):
        if not height or len(height) == 0:
            return 0
        if end < 0:
            end = len(height) - 1
        if begin > end:
            return 0
        if begin == end:
            return height[begin]
        mid = (begin+end)/2
        leftArea = self.largestRectangleArea(height, begin, mid)
        rightArea = self.largestRectangleArea(height, mid+1, end)
        middleArea = self.expandMiddle(height, begin, end, mid)
        return max(leftArea, rightArea, middleArea)

    def expandMiddle(self, height, begin, end, mid):
        left = mid
        right = mid+1
        curHeight = min(height[left], height[right])
        maxArea = curHeight*2
        while left >= begin and right <= end:
            curHeight = min(curHeight, height[left], height[right])
            maxArea = max(maxArea, curHeight*(right-left+1))
            if left == begin:
                right += 1
            elif right == end:
                left -= 1
            else:
                if height[left-1] > height[right+1]:
                    left -= 1
                else:
                    right += 1
        return maxArea
```

### Refinement
