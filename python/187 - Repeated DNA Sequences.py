#! /usr/bin/env python
# -*- coding: utf-8 -*-
# @filename  187 - Repeated DNA Sequences
# @author   dectinc@icloud.com
# @date     2015-03-19 11:05

class Solution:
    # @param s, a string
    # @return a list of strings
    def findRepeatedDnaSequences(self, s):
        res = []
        occurs = {}
        for i in range(10, len(s)+1):
            cur = s[i - 10:i]
            if cur in occurs and occurs[cur]:
                res.append(cur)
                occurs[cur] = False
            elif cur not in occurs:
                occurs[cur] = True
        return res


if __name__ == '__main__':
    sol = Solution()
    s = 'AAAAAAAAAAA'
    print sol.findRepeatedDnaSequences(s)