#!/usr/bin/env python
# -*- coding: utf-8 -*-
# @Date    : 2015-04-01 12:54:28
# @Author  : chenshijiang (i@dectinc.cc)
# @Link    : http://dectinc.cc
# @Version : 0.0.1

from TreeUtil import *

# Definition for a  binary tree node
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    # @return a list of tree node
    def generateTrees(self, n):
        return self.generateTree([i+1 for i in xrange(n)])

    def generateTree(self, nums):
        if len(nums) == 0:
            return [None]
        if len(nums) == 1:
            return [TreeNode(nums[0])]
        result = []
        length = len(nums)
        for i in range(length):
            for left in self.generateTree(nums[:i]):
                for right in self.generateTree(nums[i+1:]):
                    node = TreeNode(nums[i])
                    node.left = left
                    node.right = right
                    result.append(node)
        return result


if __name__ == '__main__':
    sol = Solution()
    n = 4
    result = sol.generateTrees(n)
    for tree in result:
        print tree.preOrderTraversal()
