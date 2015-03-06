## [Palindrome Number](https://oj.leetcode.com/problems/palindrome-number/)

### Problem

Determine whether an integer is a palindrome. Do this without extra space.

**Some hints**:

Could negative integers be palindromes? (ie, -1)

If you are thinking of converting the integer to string, note the restriction of using extra space.

You could also try reversing an integer. However, if you have solved the problem "Reverse Integer", you know that the reversed integer might overflow. How would you handle such case?

There is a more generic way of solving this problem.

### Solution


### Code

``` Python
class Solution:
    # @return a boolean
    def isPalindrome(self, x):
        if x < 0:
            return False
        if x < 10:
            return True
        p = x
        q = 0
        while p >= 10:
            q = q * 10 + p%10
            p /= 10
        return q == x/10
```

### Refinement
