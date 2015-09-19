# -*- coding: utf-8 -*-
# @filename 218 - The Skyline Problem
# @author   Dectinc
# @date     2015-09-19 15:21 PM

class Solution(object):
    def getSkyline(self, buildings):
        if not buildings:
            return []
        buildings = [[[left, height], [right, 0]] for left,right, height in buildings]
        while len(buildings) > 1:
            buildings = [self.merge(buildings[2*i], buildings[2*i+1]) for i in xrange(len(buildings) / 2)] + (buildings[-1] if len(buildings) % 2 else [])
        return buildings[0]

    def merge(self, left, right):
        res, l, r = [], 0, 0
        nLeft, nRight = len(left), len(right)
        leftHeight, rightHeight = 0, 0
        while l < nLeft and r < nRight:
            lx, rx = left[l][0], right[r][0]
            if lx <= rx:
                cur, leftHeight = left[l], left[l][1]
                l += 1
            if lx >= rx:
                cur, rightHeight = right[r], right[r][1]
                r += 1
            cur[1] = max(leftHeight, rightHeight)
            if res and res[-1][1] == cur[1]:
                continue
            res.append(cur)
        res += left[l:] if l < nLeft else right[r:]
        return res


if __name__ == '__main__':
    buildings = [[0,2,3],[2,5,3]]
    sol = Solution()
    print sol.getSkyline(buildings)