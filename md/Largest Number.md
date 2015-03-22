## [Largest Number](https://leetcode.com/problems/largest-number/)

### Problem

Given a list of non negative integers, arrange them such that they form the largest number.

For example, given `[3, 30, 34, 5, 9]`, the largest formed number is `9534330`.

Note: The result may be very large, so you need to return a string instead of an integer.

### Solution


### Code

``` Python
class Solution:
    # @param num, a list of integers
    # @return a string
    def largestNumber(self, num):
        def compareNum(x, y):
            xy = str(x) + str(y)
            yx = str(y) + str(x)
            for i in range(len(xy)):
                if xy[i] == yx[i]:
                    continue
                else:
                    return int(xy[i]) - int(yx[i])
            return 0

        num = sorted(num, cmp=compareNum, reverse=True)
        tmp = ''.join([str(a) for a in num])
        i = 0
        while i < len(tmp) and tmp[i] == '0':
            i += 1
        if i == len(tmp):
            return '0'
        else:
            return tmp[i:]
```

### Refinement
