# -*- coding: utf-8 -*-
# @filename 209 - Minimum Size Subarray Sum
# @author   v-shijch
# @date     2015-07-07 19:29 PM

import sys

class Solution:
    # @param {integer} s
    # @param {integer[]} nums
    # @return {integer}
    def minSubArrayLen(self, s, nums):
        return self.nSolution(s, nums)
        # length = len(nums)
        # result = self.minSubArrayHelper(s, nums, 0, length-1)
        # return 0 if result > length else result

    def nSolution(self, s, nums):
        total, left = 0, 0
        result = len(nums) + 1
        for right, n in enumerate(nums):
            total += n
            while total >= s:
                result = min(result, right-left+1)
                total -= nums[left]
                left += 1
        return result if result <= len(nums) else 0

    def minSubArrayHelper(self, s, nums, i, j):
        '''
        This solution is wrong
        :param s:
        :param nums:
        :param i:
        :param j:
        :return:
        '''
        length = j-i+1
        allSum = sum(nums[i:j+1])
        if allSum < s:
            return sys.maxint
        elif allSum == s:
            return length
        elif i == j:
            return 1
        mid = i + (j-i) / 2
        minLeft = self.minSubArrayHelper(s, nums, i, mid)
        minRight = self.minSubArrayHelper(s, nums, mid+1, j)
        p, q = mid, mid+1
        cur = nums[mid] + nums[mid+1]
        minMiddle = sys.maxint
        if cur < s:
            p, q = p-1, q+1
            while p >= i or q <= j:
                if p < i or (q <= j and nums[p] <= nums[q]):
                    cur += nums[q]
                    q += 1
                elif q > j or (p >= i and nums[p] > nums[q]):
                    cur += nums[p]
                    p -= 1
                if cur >= s:
                    minMiddle = q-p-1
                    break
        else:
            minMiddle = 2
        return min(min(minLeft, minRight), minMiddle)


if __name__ == '__main__':
    sol = Solution()
    s, nums = 11, [1,2,3,4,5]
    print sol.minSubArrayLen(s, nums)