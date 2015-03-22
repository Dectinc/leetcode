# -*- coding: utf-8 -*-
# @filename 49 - Anagrams
# @author   Dectinc
# @date     2015-03-22 16:44 PM

from collections import defaultdict

class Solution:
    # @param strs, a list of strings
    # @return a list of strings
    def anagrams(self, strs):
        dic = defaultdict(list)
        for astr in strs:
            key = ''.join(sorted(astr))
            dic[key].append(astr)
        res = []
        for key in dic:
            if len(dic[key]) > 1:
                res.extend(dic[key])
        return res


if __name__ == '__main__':
    sol = Solution()
    strs = ['aa', 'ab', 'ba']
    print sol.anagrams(strs)
