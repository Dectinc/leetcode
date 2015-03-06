## [Container With Most Water](https://oj.leetcode.com/problems/container-with-most-water/)

### Problem

Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.

**Note**: You may not slant the container.

### Solution


### Code

``` Python
class Solution:
    # @return an integer
    def maxArea(self, height):
        left = 0
        right = len(height) - 1
        mostWater = 0
        while left < right:
            mostWater = max(mostWater, min(height[right], height[left]) * (right - left))
            if height[right] > height[left]:
                left += 1
            else:
                right -= 1
        return mostWater
```

### Refinement
