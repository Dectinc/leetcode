#! /usr/bin/env python
# -*- coding: utf-8 -*-
# @filename  46 - Permutations
# @author   dectinc@icloud.com
# @date     2015-03-22 00:39

class Solution:
    # @param num, a list of integer
    # @return a list of lists of integers
    def permute(self, num):
        res = []
        if len(num) < 1:
            return res
        nums = sorted(num)
        num = len(nums)
        res.append(nums[:])
        while True:
            nums = self.nextPermutation(nums, num)
            if nums is None:
                return res
            res.append(nums[:])

    def nextPermutation(self, nums, num):
        i = num - 1
        while i > 0:
            if nums[i] > nums[i - 1]:
                a = nums[i - 1]
                idx, toSwap = i, nums[i]
                j = i
                while j < num:
                    if nums[j] > a and toSwap > nums[j]:
                        idx, toSwap = j, nums[j]
                    j += 1
                nums[i - 1], nums[idx] = nums[idx], nums[i - 1]
                nums = nums[:i] + sorted(nums[i:])
                break
            else:
                i -= 1
        if i == 0:
            return None
        else:
            return nums


if __name__ == '__main__':
    sol = Solution()
    num = [0, 1, 2]
    print sol.permute(num)