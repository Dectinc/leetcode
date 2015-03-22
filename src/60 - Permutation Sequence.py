# -*- coding: utf-8 -*-
# @filename 60 - Permutation Sequence
# @author   Dectinc
# @date     2015-03-22 22:24 PM


num_permutations = [1, 2, 6, 24, 120, 720, 5040, 40320, 362880]

class Solution:
    # @return a string
    def getPermutation(self, n, k):
        if k > num_permutations[n-1]:
            return None
        res = []
        isTaken = [False] * (n)
        def getUntaken(i):
            for j in range(n):
                if not isTaken[j]:
                    i -= 1
                    if i < 0:
                        return j
        k -= 1
        for i in range(n-2, -1, -1):
            shouldTake = getUntaken(k/num_permutations[i])
            res.append(shouldTake+1)
            isTaken[shouldTake] = True
            k = k%num_permutations[i]
        res.append(isTaken.index(False) + 1)
        return ''.join([str(a) for a in res])


if __name__ == '__main__':
    sol = Solution()
    n = 9
    k = 54494
    print sol.getPermutation(n, k)