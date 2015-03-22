## [Anagrams](https://leetcode.com/problems/anagrams/)

### Problem

Given an array of strings, return all groups of strings that are anagrams.

Note: All inputs will be in lower-case.

### Solution


### Code

``` Python
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
```

### Refinement
