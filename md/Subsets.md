## [Subsets](https://leetcode.com/problems/subsets/)

### Problem

Given a set of distinct integers, S, return all possible subsets.

__Note__:

- Elements in a subset must be in non-descending order.
- The solution set must not contain duplicate subsets.

For example,

If __S__ = `[1,2,3]`, a solution is:
```
[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
```

### Solution


### Code

``` Python
class Solution:
    def __init__(self):
        self.res = [[]]
        self.sorted = False
    # @param S, a list of integer
    # @return a list of lists of integer
    def subsets(self, S, used=None, current=None, start=0):
        length = len(S)
        if length == 0:
            return self.res
        if not self.sorted:
            S.sort()
        if used is None:
            used = [False] * length
            current = []
            start = S[0]-1
        if len(current) == len(S):
            return self.res
        for i in xrange(length):
            if used[i]:
                continue
            if S[i] < start:
                continue
            used[i] = True
            current.append(S[i])
            self.res.append(current[:])
            self.subsets(S, used, current, S[i])
            current.pop()
            used[i] = False
        return self.res

```

### Refinement
