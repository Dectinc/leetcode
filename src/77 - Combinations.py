# -*- coding: utf-8 -*-
# @filename 77 - Combinations
# @author   Dectinc
# @date     2015-03-24 21:10 PM

class Solution:
    def __init__(self):
        self.res = []
    # @return a list of lists of integers
    def combine(self, n, k, used=None, current=None, start=1):
        if k == 0:
            self.res.append(current[:])
            return self.res
        if used is None:
            used = [False] * (n+1)
            current = []
        for i in xrange(start, n+1):
            if used[i]:
                continue
            used[i] = True
            current.append(i)
            self.combine(n, k-1, used, current, i+1)
            current.pop()
            used[i] = False
        return self.res


if __name__ == '__main__':
    sol = Solution()
    n, k = 2, 1
    print sol.combine(n, k)