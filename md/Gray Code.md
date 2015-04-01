## [Gray Code](https://leetcode.com/problems/gray-code/)

### Problem

The gray code is a binary numeral system where two successive values differ in only one bit.

Given a non-negative integer n representing the total number of bits in the code, print the sequence of gray code. A gray code sequence must begin with 0.

For example, given n = 2, return `[0,1,3,2]`. Its gray code sequence is:
```
00 - 0
01 - 1
11 - 3
10 - 2
```

__Note__:
For a given n, a gray code sequence is not uniquely defined.

For example, `[0,2,3,1]` is also a valid gray code sequence according to the above definition.

For now, the judge is able to judge based on one instance of gray code sequence. Sorry about that.

### Solution


### Code

``` Python
class Solution:
    # @return a list of integers
    def grayCode(self, n):
        result = []
        for i in xrange(1<<n):
            result.append(i^(i>>1))
        return result
```

``` Python
class Solution:
    # @return a list of integers
    def grayCode(self, n):
        result = [0]
        for i in xrange(n):
            tmp = []
            flag = 0
            for a in result:
                tmp.append(flag<<i | a)
                flag = flag^1
                tmp.append(flag<<i | a)
            result = tmp
        return result
```

### Refinement
