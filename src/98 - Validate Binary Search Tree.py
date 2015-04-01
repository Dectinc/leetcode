#!/usr/bin/env python
# -*- coding: utf-8 -*-
# @Date    : 2015-04-01 12:54:28
# @Author  : chenshijiang (i@dectinc.cc)
# @Link    : http://dectinc.cc
# @Version : 0.0.1

from TreeUtil import *


class Solution:
    # @param root, a tree node
    # @return a boolean
    def isValidBST(self, root, _min=None, _max=None):
        if root is None:
            return True
        validLeft = self.isValidBST(root.left, _min, root.val)
        validRight = self.isValidBST(root.right, root.val, _max)
        return validLeft and validRight \
               and (True if _min is None else root.val > _min) \
               and (True if _max is None else root.val < _max)


if __name__ == '__main__':
    sol = Solution()
    # nums = [10, 5, 15, '#', '#', 12, 20]
    # nums = [15,12,20]
    nums = [0, '#', -1]
    root = constructTree(nums)
    print sol.isValidBST(root)

