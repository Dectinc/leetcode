## [Distinct Subsequences](https://leetcode.com/problems/distinct-subsequences/)

### Problem

Given a string __S__ and a string __T__, count the number of distinct subsequences of __T__ in __S__.

A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, `"ACE"` is a subsequence of `"ABCDE"` while `"AEC"` is not).

Here is an example:
__S__ = `"rabbbit"`, __T__ = `"rabbit"`

Return `3`.

### Solution


### Code

``` Java
public class Solution {
    public int numDistinct(String S, String T) {
        int lenS = S.length();
        int lenT = T.length();
        if (lenS < lenT || lenT == 0) {
            return 0;
        }
        int[] lastRow = new int[lenS+1];
        int[] curRow = new int[lenS+1];
        for (int i = 0; i <= lenS; i++) {
            lastRow[i] = 1;
        }
        for (int i = 0; i < lenT; i++) {
            for (int j = 0; j < lenS; j++) {
                if (T.charAt(i) == S.charAt(j)) {
                    curRow[j+1] = curRow[j] + lastRow[j];
                } else {
                    curRow[j+1] = curRow[j];
                }
            }
            for(int k=0; k <= lenS; k++){
                lastRow[k] = curRow[k];
            }
        }
        return lastRow[lenS];
    }
}
```

### Refinement
