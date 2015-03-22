#! /usr/bin/env python
# -*- coding: utf-8 -*-
# @filename  179 - Largest Number
# @author   dectinc@icloud.com
# @date     2015-03-19 17:09
class Solution:
    # @param num, a list of integers
    # @return a string
    def largestNumber(self, num):
        def compareNum(x, y):
            xy = str(x) + str(y)
            yx = str(y) + str(x)
            for i in range(len(xy)):
                if xy[i] == yx[i]:
                    continue
                else:
                    return int(xy[i]) - int(yx[i])
            return 0

        num = sorted(num, cmp=compareNum, reverse=True)
        return ''.join([str(a) for a in num])


if __name__ == '__main__':
    sol = Solution()
    num = [3, 43, 48, 94, 85, 33, 64, 32, 63, 66]
    # num = [121, 12]
    print sol.largestNumber(num)
    # print compareNum(12, 128)