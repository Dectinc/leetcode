#!/usr/bin/env python
# -*- coding: utf-8 -*-
# @Date    : 2015-04-01 12:54:28
# @Author  : chenshijiang (i@dectinc.cc)
# @Link    : http://dectinc.cc
# @Version : 0.0.1

class Solution:
    # @param s, a string
    # @return a list of strings
    def restoreIpAddresses(self, s, need=4):
        result = []
        length = len(s)
        if length < need or length > 3*need:
            return result
        if need == 1 and not (s[0] == '0' and len(s)>1) and not int(s) > 255:
            return [s]
        for i in range(1,4):
            if int(s[:i]) > 255:
                continue
            if s[0] == '0' and i > 1:
                continue
            tmp = self.restoreIpAddresses(s[i:], need-1)
            for a in tmp:
                result.append(s[:i] + '.' + a)
        return result


if __name__ == '__main__':
    sol = Solution()
    s = '172162541'
    print sol.restoreIpAddresses(s)
