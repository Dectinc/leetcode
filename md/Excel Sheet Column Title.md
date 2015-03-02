## [Excel Sheet Column Title](https://oj.leetcode.com/problems/excel-sheet-column-title/)

### Problem

Given a positive integer, return its corresponding column title as appear in an Excel sheet.

For example:

```
    1 -> A
    2 -> B
    3 -> C
    ...
    26 -> Z
    27 -> AA
    28 -> AB
```

### Solution

convert number to base-26 system

### Code

``` python
class Solution:
    # @return a string
    def convertToTitle(self, num):
        if not num > 0:
            return ''
        res = ''
        _ascii_a = ord('A')
        while num > 0:
            num = num - 1
            res = chr(_ascii_a + num % 26) + res
            num = num / 26
        return res
```

### Refinement
