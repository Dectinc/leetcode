## [Combination Sum II](https://leetcode.com/problems/combination-sum-ii/)

### Problem

Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

Each number in C may only be used __once__ in the combination.

__Note:__

 - All numbers (including target) will be positive integers.
 - Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
 - The solution set must not contain duplicate combinations.

For example, given candidate set `10,1,2,7,6,1,5` and target `8`,

A solution set is:
```
[1, 7]
[1, 2, 5]
[2, 6]
[1, 1, 6]
```
### Solution


### Code

``` Python
class Solution:
    # @param candidates, a list of integers
    # @param target, integer
    # @return a list of lists of integers
    def __init__(self):
        self.output = []

    def combinationSum2(self, candidates, target, temp = None, pos = 0):
        if temp is None:
            candidates.sort()
        temp = temp or []

        if target == 0:
            self.output.append(temp[:])
            return

        last = None
        for i in range(pos, len(candidates)):
            num = candidates[i]
            if target - num < 0:
                break
            if last == num:
                continue

            last = num
            temp.append(num)
            self.combinationSum2(candidates, target - num, temp, i + 1)
            temp.pop()

        return self.output
```

### Refinement
