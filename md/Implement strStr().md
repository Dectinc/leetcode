## [Implement strStr()](https://leetcode.com/problems/implement-strstr/)

### Problem

Implement strStr().

Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack

### Solution


### Code

- Naive Method

``` Python
class Solution:
    # @param haystack, a string
    # @param needle, a string
    # @return an integer
    def strStr(self, haystack, needle):
        lenH = len(haystack)
        lenN = len(needle)
        if lenN == 0:
            return 0
        for i in range(lenH-lenN+1):
            p = i
            q = 0
            while q < lenN and haystack[p] == needle[q]:
                p += 1
                q += 1
            if q == lenN:
                return i
        return -1
```

### Refinement
