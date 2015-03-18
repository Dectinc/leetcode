## [Reverse Bits](https://leetcode.com/problems/reverse-bits/)

### Problem

Reverse bits of a given 32 bits unsigned integer.

For example, given input 43261596 (represented in binary as `00000010100101000001111010011100`), return 964176192 (represented in binary as `00111001011110000010100101000000`).

### Solution


### Code

``` Python
class Solution:
    # @param n, an integer
    # @return an integer
    def reverseBits(self, n):
        if n == 0:
            return 0
        res = 0
        for i in range(32):
            flag = n & 1
            n = n >> 1
            res = res << 1
            res = res | flag
        return res
```

``` Python
class Solution:
    # @param n, an integer
    # @return an integer
    def reverseBits(self, n):
        oribin='{0:032b}'.format(n)
        reversebin=oribin[::-1]
        return int(reversebin,2)
```

### Refinement
