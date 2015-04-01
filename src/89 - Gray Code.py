#!/usr/bin/env python
# -*- coding: utf-8 -*-
# @Date    : 2015-04-01 10:46:00
# @Author  : chenshijiang (i@dectinc.cc)
# @Link    : http://dectinc.cc
# @Version : 0.0.1

class Solution:
    # @return a list of integers
    def grayCode1(self, n):
        result = []
        for i in xrange(1<<n):
            result.append(i^(i>>1))
        return result

    def grayCode2(self, n):
        result = [0]
        for i in xrange(n):
            tmp = []
            flag = 0
            for a in result:
                tmp.append(flag<<i | a)
                flag = flag^1
                tmp.append(flag<<i | a)
            result = tmp
        return result

    def convertToInteger(self, alist):
        result = 0
        for a in alist:
            result = result*2 + a
        return result


if __name__ == '__main__':
    sol = Solution()
    for n in range(4):
        result = sol.grayCode2(n)
        print result
        for a in result:
            print bin(a)[2:].zfill(n)