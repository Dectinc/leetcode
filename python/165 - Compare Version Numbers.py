#! /usr/bin/env python
# -*- coding: utf-8 -*-
# @filename  165 - Compare Version Numbers
# @author   dectinc@icloud.com
# @date     2015-03-18 00:25

class Solution:
    # @param version1, a string
    # @param version2, a string
    # @return an integer
    def compareVersion(self, version1, version2):
        parts1 = [int(a) for a in version1.split('.')]
        parts2 = [int(a) for a in version2.split('.')]
        length1 = len(parts1)
        length2 = len(parts2)
        i = 0
        while i < min(length1, length2):
            if parts1[i] < parts2[i]:
                return -1
            elif parts1[i] > parts2[i]:
                return 1
            i += 1

        def f(x):
            return x != 0

        if length1 > length2 and filter(f, parts1[length2:]):
            return 1
        elif length1 < length2 and filter(f, parts2[length1:]):
            return -1
        return 0


if __name__ == '__main__':
    sol = Solution()
    version1 = '1'
    version2 = '1.1'
    print sol.compareVersion(version1, version2)