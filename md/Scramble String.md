## [Scramble String](https://leetcode.com/problems/scramble-string/)

### Problem

Given a string s1, we may represent it as a binary tree by partitioning it to two non-empty substrings recursively.

Below is one possible representation of s1 = `"great"`:
```
    great
   /    \
  gr    eat
 / \    /  \
g   r  e   at
           / \
          a   t
```
To scramble the string, we may choose any non-leaf node and swap its two children.

For example, if we choose the node `"gr"` and swap its two children, it produces a scrambled string `"rgeat"`.
```
    rgeat
   /    \
  rg    eat
 / \    /  \
r   g  e   at
           / \
          a   t
```
We say that `"rgeat"` is a scrambled string of `"great"`.

Similarly, if we continue to swap the children of nodes `"eat"` and `"at"`, it produces a scrambled string `"rgtae"`.
```
    rgtae
   /    \
  rg    tae
 / \    /  \
r   g  ta  e
       / \
      t   a
```
We say that `"rgtae"` is a scrambled string of `"great"`.

Given two strings s1 and s2 of the same length, determine if s2 is a scrambled string of s1. 

### Solution

- separate s1 into two parts, namely --ls1--, --------rs1--------
- separate s2 into two parts, namely --ls2--, --------rs2--------, and test the corresponding part (s11 and s21 && s12 and s22) with isScramble.
- separate s2 into two parts, namely --------rls2--------, --rrs2--, and test the corresponding part (s11 and s24 && s12 and s23) with isScramble.
- Note that before testing each sub-part with isScramble, anagram is used first to test if the corresponding parts are anagrams. If not, skip directly.

### Code

``` Python
class Solution:
    # @return a boolean
    def isScramble(self, s1, s2):
        if s1 == s2: return True
        if sorted(s1) != sorted(s2): return False

        for i in xrange(1, len(s1)):
            ls1, rs1 = s1[:i], s1[i:]
            ls2, rs2 = s2[:i], s2[i:]
            rls2, rrs2 = s2[:-i], s2[-i:]

            if (self.isScramble(ls1, ls2) and self.isScramble(rs1, rs2) or
                    self.isScramble(ls1, rrs2) and self.isScramble(rs1, rls2)):
                return True

        return False
        
```

### Refinement
