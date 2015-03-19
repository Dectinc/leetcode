## [Repeated DNA Sequences](https://leetcode.com/problems/repeated-dna-sequences/)

### Problem

 All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T, for example: "ACGAATTCCG". When studying DNA, it is sometimes useful to identify repeated sequences within the DNA.

Write a function to find all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule.

For example,
```
Given s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT",

Return:
["AAAAACCCCC", "CCCCCAAAAA"].
```

### Solution


### Code

``` Python
class Solution:
    # @param s, a string
    # @return a list of strings
    def findRepeatedDnaSequences(self, s):
        res = []
        occurs = {}
        for i in range(10, len(s)+1):
            cur = s[i - 10:i]
            if cur in occurs and occurs[cur]:
                res.append(cur)
                occurs[cur] = False
            elif cur not in occurs:
                occurs[cur] = True
        return res
```

### Refinement
