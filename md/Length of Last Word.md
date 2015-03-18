## [Length of Last Word](https://leetcode.com/problems/length-of-last-word/)

### Problem

Given a string s consists of upper/lower-case alphabets and empty space characters `' '`, return the length of last word in the string.

If the last word does not exist, return 0.

__Note:__ A word is defined as a character sequence consists of non-space characters only.

For example,

Given _s_ = `"Hello World"`,

return `5`. 

### Solution


### Code

``` Python
class Solution:
    # @param s, a string
    # @return an integer
    def lengthOfLastWord(self, s):
        lastLength = 0
        length = 0
        for i in s:
            if i == ' ':
                if length > 0:
                    lastLength = length
                length = 0
            else:
                length += 1
        if length != 0:
            return length
        else:
            return lastLength
```

### Refinement
