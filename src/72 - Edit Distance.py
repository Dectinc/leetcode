# -*- coding: utf-8 -*-
# @filename 72 - Edit Distance
# @author   Dectinc
# @date     2015-03-24 19:19 PM


class Solution:
    # @return an integer
    def minDistance(self, word1, word2):
        length1, length2 = len(word1), len(word2)
        if length1 == 0 or length2 == 0:
            return max(length1, length2)
        edit = [i+1 for i in range(length1)] + [0]
        for i in range(length2):
            pre, edit[-1] = edit[-1], i+1
            for j in range(length1):
                pre, edit[j] = edit[j], min(edit[j-1]+1, edit[j]+1, pre+(0 if word1[j]==word2[i] else 1))
        return edit[length1-1]

if __name__ == '__main__':
    sol = Solution()
    word1 = 'acca'
    word2 = 'aba'
    print sol.minDistance(word1, word2)