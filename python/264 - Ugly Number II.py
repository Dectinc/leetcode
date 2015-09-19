# -*- coding: utf-8 -*-
# @filename 264 - Ugly Number II
# @author   Dectinc
# @date     2015-09-19 14:03 PM
class Solution(object):
    def nthUglyNumber(self, n):
        """
        :type n: int
        :rtype: int
        """
        if n == 1:
            return 1
        uglyFactors = (2, 3, 5)
        times = [[x] for x in uglyFactors]
        numFactors = len(uglyFactors)
        cur = 1
        for i in xrange(1, n):
            curMin, q = times[0][0], 0
            for j in range(1, numFactors):
                if times[j][0] < curMin:
                    curMin = times[j][0]
                    q = j
            cur = times[q][0]
            times[q] = times[q][1:]
            for j in range(q, numFactors):
                times[j].append(cur*uglyFactors[j])
            print cur
        return cur

    def nthUglyNumber1(self, n):
        ugly = [1]
        i2, i3, i5 = 0, 0, 0
        while n > 1:
            u2, u3, u5 = 2 * ugly[i2], 3 * ugly[i3], 5 * ugly[i5]
            umin = min((u2, u3, u5))
            if umin == u2:
                i2 += 1
            if umin == u3:
                i3 += 1
            if umin == u5:
                i5 += 1
            ugly.append(umin)
            n -= 1
        return ugly[-1]

if __name__ == '__main__':
    sol = Solution()
    print sol.nthUglyNumber(11)