## [Add Binary](https://leetcode.com/problems/add-binary/)

### Problem

 Given two binary strings, return their sum (also a binary string).

For example,
a = `"11"`
b = `"1"`
Return `"100"`. 

### Solution


### Code

``` Python
class Solution:
    # @param a, a string
    # @param b, a string
    # @return a string
    def addBinary(self, a, b):
        a = [int(i) for i in a]
        b = [int(i) for i in b]
        m = len(a)-1
        n = len(b)-1
        if m<n:
            a, b = b, a
            m, n = n, m
        flag = 0
        while n != -1:
            k = a[m] + b[n] + flag
            a[m] = k&1
            flag = k>>1
            m -= 1
            n -= 1
        while m != -1:
            k = a[m] + flag
            a[m] = k&1
            flag = k>>1
            m -= 1
        if flag:
            a.insert(0, flag)
        return ''.join([str(i) for i in a ])
```

### Refinement
