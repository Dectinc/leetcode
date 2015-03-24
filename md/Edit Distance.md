## [Edit Distance](https://leetcode.com/problems/edit-distance/)

### Problem

Given two words word1 and word2, find the minimum number of steps required to convert word1 to word2. (each operation is counted as 1 step.)

You have the following 3 operations permitted on a word:

- Insert a character
- Delete a character
- Replace a character

### Solution


### Code

``` Python
class Solution:
    # @return an integer
    def minDistance(self, word1, word2):
        length1, length2 = len(word1), len(word2)
        if length1 == 0 or length2 == 0:
            return max(length1, length2)
        edit = [i+1 for i in range(length1)] + [0]
        for i in range(length2):
            pre, edit[-1] = edit[-1], i+1
            for j in range(length1):
                pre, edit[j] = edit[j], min(edit[j-1]+1, edit[j]+1, pre+(0 if word1[j]==word2[i] else 1))
        return edit[length1-1]
```

### Refinement
