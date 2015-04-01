## [Decode Ways](https://leetcode.com/problems/decode-ways/)

### Problem

A message containing letters from `A-Z` is being encoded to numbers using the following mapping:
```
'A' -> 1
'B' -> 2
...
'Z' -> 26
```
Given an encoded message containing digits, determine the total number of ways to decode it.

For example,

Given encoded message `"12"`, it could be decoded as `"AB"` (1 2) or `"L"` (12).

The number of ways decoding `"12"` is 2.

### Solution


### Code

``` Python
class Solution:
    # @param s, a string
    # @return an integer
    def numDecodings(self, s):
        if len(s) > 0 and s[0] == '0':
            return 0
        if len(s) < 2:
            return len(s)
        nums = [1] + [0]*(len(s)-1) + [0, 1]
        for i in xrange(1, len(s)):
            if s[i] != '0':
                nums[i] += nums[i-1]
            if s[i-1] != '0' and int(s[i-1:i+1]) < 27:
                nums[i] += nums[i-2]
        return nums[len(s)-1]
```

### Refinement
