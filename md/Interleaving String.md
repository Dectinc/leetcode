## [Interleaving String](https://oj.leetcode.com/problems/interleaving-string/)

### Problem

Given *s1*, *s2*, *s3*, find whether *s3* is formed by the interleaving of *s1* and *s2*.

For example,

Given:

*s1* = `"aabcc"`,

*s2* = `"dbbca"`,

When *s3* = `"aadbbcbcac"`, return true.
When *s3* = `"aadbbbaccc"`, return false.

### Solution

Dynamic Programming

### Code

``` Python
class Solution:
    # @return a boolean
    def isInterleave(self, s1, s2, s3):
        if len(s3) != len(s1) + len(s2):
            return False
        if not s1:
            return s2 == s3
        if not s2:
            return s1 == s3
        p = []
        len1 = len(s1)
        len2 = len(s2)
        for i in range(len1 + 1):
            p.append([False] * (len2+1))
        p[0][0] = True
        for i in range(len1+1):
            for j in range(len2+1):
                k = i+j
                if i > 0 and s1[i-1] == s3[k-1]:
                    p[i][j] = p[i][j] or p[i-1][j]
                if j > 0 and s2[j-1] == s3[k-1]:
                    p[i][j] = p[i][j] or p[i][j-1]
        return p[len1][len2]
```

### Refinement
