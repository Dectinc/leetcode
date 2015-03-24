## [Combinations](https://leetcode.com/problems/combinations/)

### Problem

Given two integers _n_ and _k_, return all possible combinations of _k_ numbers out of 1 ... n.

For example,
If _n = 4_ and _k = 2_, a solution is:
```
[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]
```

### Solution


### Code

- recursive

``` Python
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
```

### Refinement
