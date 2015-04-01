#!/usr/bin/env python
# -*- coding: utf-8 -*-
# @Date    : 2015-04-01 12:54:28
# @Author  : chenshijiang (i@dectinc.cc)
# @Link    : http://dectinc.cc
# @Version : 0.0.1

class Solution:
    # @param s, a string
    # @return an integer
    def numDecodings(self, s):
        if len(s) > 0 and s[0] == '0':
            return 0
        if len(s) < 2:
            return len(s)
        nums = [1] + [0]*(len(s)-1) + [0, 1]
        for i in xrange(1, len(s)):
            if s[i] != '0':
                nums[i] += nums[i-1]
            if s[i-1] != '0' and int(s[i-1:i+1]) < 27:
                nums[i] += nums[i-2]
        return nums[len(s)-1]


if __name__ == '__main__':
    sol = Solution()
    s = '26'
    print sol.numDecodings(s)
