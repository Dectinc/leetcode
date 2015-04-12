## [Palindrome Partitioning II](https://leetcode.com/problems/palindrome-partitioning-ii/)

### Problem

Given a string s, partition s such that every substring of the partition is a palindrome.

Return the minimum cuts needed for a palindrome partitioning of s.

For example, given s = `"aab"`,

Return `1` since the palindrome partitioning `["aa","b"]` could be produced using 1 cut.

### Solution


### Code

``` Java
public class Solution {
    public int minCut(String s) {
        if (s == null || s.length() < 2) {
            return 0;
        }
        char[] chars = s.toCharArray();
        int length = chars.length;
        int[] numCuts = new int[length + 1];
        for (int i = 0; i < length + 1; i++) {
            numCuts[i] = i - 1;
        }
        for (int i = 0; i < length; i++) {
            for (int j = 0; i - j >= 0 && i + j < length && chars[i - j] == chars[i + j]; j++) {
                numCuts[i + j + 1] = Math.min(numCuts[i + j + 1], 1 + numCuts[i - j]);
            }
            for (int j = 1; i - j + 1 >= 0 && i + j < length && chars[i - j + 1] == chars[i + j]; j++) {
                numCuts[i + j + 1] = Math.min(numCuts[i + j + 1], 1 + numCuts[i - j + 1]);
            }
        }
        return numCuts[length];
    }
}
```

### Refinement
