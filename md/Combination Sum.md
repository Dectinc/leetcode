## [Combination Sum](https://leetcode.com/problems/combination-sum/)

### Problem

Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

The __same__ repeated number may be chosen from C unlimited number of times.

__Note:__

 - All numbers (including target) will be positive integers.
 - Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
 - The solution set must not contain duplicate combinations.

For example, given candidate set `2,3,6,7` and target `7`,

A solution set is:

`[7]`

`[2, 2, 3]`

### Solution


### Code

``` Python
class Solution:
    # @param candidates, a list of integers
    # @param target, integer
    # @return a list of lists of integers
    def __init__(self):
        self.output = []

    def combinationSum(self, candidates, target, temp = None, pos = 0):
        if temp is None:
            candidates.sort()
            temp = []
        # temp = temp or []

        if target == 0:
            self.output.append(temp[:])
            return

        for i in range(pos, len(candidates)):
            num = candidates[i]
            if target - num < 0:
                break

            temp.append(num)
            self.combinationSum(candidates, target - num, temp, i)
            temp.pop()

        return self.output
```

### Refinement
