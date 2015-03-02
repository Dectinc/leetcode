## [Excel Sheet Column Number](https://oj.leetcode.com/submissions/detail/22064299/)

### Problem

Related to question [Excel Sheet Column Title](https://oj.leetcode.com/problems/excel-sheet-column-title/)

Given a column title as appear in an Excel sheet, return its corresponding column number.

For example:

```
    A -> 1
    B -> 2
    C -> 3
    ...
    Z -> 26
    AA -> 27
    AB -> 28
```

### Solution


### Code

``` java
public class Solution {
    public int titleToNumber(String s) {
        int number = 0;
        int length = s.length();
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            number = number * 26 + (c - 'A') + 1;
        }
        return number;
    }
}
```

``` python
class Solution:
    # @param s, a string
    # @return an integer
    def titleToNumber(self, s):
        s = s.upper()
        number = 0
        _ascii_a = ord('A')
        for c in s:
            number = number * 26 + ord(c) - _ascii_a + 1
        return number
```

### Refinement
