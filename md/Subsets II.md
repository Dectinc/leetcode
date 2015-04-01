## [Subsets II](https://leetcode.com/problems/subsets-ii/)

### Problem

Given a collection of integers that might contain duplicates, S, return all possible subsets.

__Note__:
- Elements in a subset must be in non-descending order.
- The solution set must not contain duplicate subsets.

For example,

If S = `[1,2,2]`, a solution is:
```
[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]
```

### Solution


### Code

``` Python
class Solution:
    # @param num, a list of integer
    # @return a list of lists of integer
    def subsetsWithDup(self, S):
        result = [[]]
        l = 1
        S.sort()
        for i in xrange(len(S)):
            if i == 0 or S[i] != S[i-1]:
                l = len(result)
            for j in range(len(result)-l, len(result)):
                result.append(result[j] + [S[i]])
        return result
```

### Refinement
