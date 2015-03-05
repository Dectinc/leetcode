## [ZigZag Conversion](https://oj.leetcode.com/problems/zigzag-conversion/)

### Problem

The string `"PAYPALISHIRING"` is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

```
P   A   H   N
A P L S I I G
Y   I   R
```

And then read line by line: `"PAHNAPLSIIGYIR"`
Write the code that will take a string and make this conversion given a number of rows:
```
string convert(string text, int nRows);
```
`convert("PAYPALISHIRING", 3)` should return `"PAHNAPLSIIGYIR"`.

### Solution


### Code

``` Python
class Solution:
    # @return a string
    def convert(self, s, nRows):
        if nRows == 1:
            return s
        if not s:
            return ''
        collections = [''] * nRows
        length = len(s)
        loop = 2*nRows - 2
        for i in range(length):
            zig = i % loop
            collections[nRows-1-abs(zig-nRows+1)] += s[i]
        return ''.join(collections)
```

### Refinement
