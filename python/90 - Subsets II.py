#!/usr/bin/env python
# -*- coding: utf-8 -*-
# @Date    : 2015-04-01 12:54:28
# @Author  : chenshijiang (i@dectinc.cc)
# @Link    : http://dectinc.cc
# @Version : 0.0.1

class Solution:
    # @param num, a list of integer
    # @return a list of lists of integer
    def subsetsWithDup(self, S):
        result = [[]]
        l = 1
        S.sort()
        for i in xrange(len(S)):
            if i == 0 or S[i] != S[i-1]:
                l = len(result)
            for j in range(len(result)-l, len(result)):
                result.append(result[j] + [S[i]])
        return result


if __name__ == '__main__':
    sol = Solution()
    S = [1,2,2]
    print sol.subsetsWithDup(S)
