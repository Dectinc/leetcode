## [Longest Common Prefix](http://oj.leetcode.com/problems/longest-common-prefix/)

Write a function to find the longest common prefix string amongst an array of strings.

``` java
public class Solution {
    public String longestCommonPrefix(String[] strs) {
        // Whether strs is an empty array?
        if (strs == null || strs.length == 0) {
            return "";
        }
        return longestCommonPrefix(strs, 0, strs.length - 1);
    }
    
    private String longestCommonPrefix(String[] strs, int start, int end) {
        if (start == end) {
            return strs[start];
        }
        int mid = (start + end) / 2;
        return getCommonString(longestCommonPrefix(strs, start, mid), longestCommonPrefix(strs, mid+1, end));
    }
    
    private String getCommonString(String str1, String str2) {
        if (str1.isEmpty() || str2.isEmpty()) {
            return "";  // Should I return "" or null?
        }
        int len = Math.min(str1.length(), str2.length());
        int i = 0;
        for (i = 0; i < len; i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                break;
            }
        }
        return str1.substring(0, i);
    }
}
```