## [Permutation Sequence](https://leetcode.com/problems/permutation-sequence/)

### Problem

The set `[1,2,3,…,n]` contains a total of n! unique permutations.

By listing and labeling all of the permutations in order,
We get the following sequence (ie, for n = 3):

+ `"123"`
+ `"132"`
+ `"213"`
+ `"231"`
+ `"312"`
+ `"321"`

Given n and k, return the kth permutation sequence.

__Note:__ Given n will be between 1 and 9 inclusive.

### Solution


### Code

``` Python
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
```

### Refinement
