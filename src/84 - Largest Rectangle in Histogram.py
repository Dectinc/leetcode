#! /usr/bin/env python
# -*- coding: utf-8 -*-
# @filename  84 - Largest Rectangle in Histogram
# @author   dectinc@icloud.com
# @date     2015-03-30 22:49

class Solution1:
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


class Solution:
    # @param height, a list of integer
    # @return an integer
    def largestRectangleArea(self, height):
        if not height or len(height) == 0:
            return 0
        stack = []
        maxArea = 0
        i = 0

        while i < len(height):
            if len(stack) == 0 or height[i] > height[stack[-1]]:
                stack.append(i)
                i += 1
            else:
                top = stack[-1]
                stack.pop()
                maxArea = max(maxArea, height[top] * (
                    i if len(stack) == 0 else i - stack[-1] - 1))

        while len(stack) > 0:
            top = stack[-1]
            stack.pop()
            maxArea = max(maxArea, height[top] * (
                i if len(stack) == 0 else i - stack[-1] - 1))

        return maxArea


if __name__ == '__main__':
    sol = Solution()
    height = [4,2]
    print sol.largestRectangleArea(height)
    