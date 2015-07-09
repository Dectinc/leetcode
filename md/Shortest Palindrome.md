## [Shortest Palindrome](https://leetcode.com/problems/shortest-palindrome/)

### Problem

Given a string S, you are allowed to convert it to a palindrome by adding characters in front of it. Find and return the shortest palindrome you can find by performing this transformation.

For example:

Given `"aacecaaa"`, return `"aaacecaaa"`.

Given `"abcd"`, return `"dcbabcd"`.

### Solution


### Code

- Method like KMP, O(n)

``` Python
class Solution:
    # @param {string} s
    # @return {string}
    def shortestPalindrome(self, s):
        p = self.getNext(s + '#' + s[::-1])
        remain = s[p[-1]:]
        return remain[::-1] + s

    def getNext(self, s):
        n = len(s)
        p = [0] * n
        j, k = 1, 0
        while j < n:
            if s[j] == s[k]:
                k += 1
                p[j] = k
                j += 1
            elif k == 0:
                j += 1
            else:
                k = p[k-1]
        return p
```

- Another, O(n^2)

find the longest palindrome prefix

### Refinement
