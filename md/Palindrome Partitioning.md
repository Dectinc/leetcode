## [Palindrome Partitioning](https://leetcode.com/problems/palindrome-partitioning/)

### Problem

Given a string s, partition s such that every substring of the partition is a palindrome.

Return all possible palindrome partitioning of s.

For example, given s = `"aab"`,
Return
```
  [
    ["aa","b"],
    ["a","a","b"]
  ]
```

### Solution


### Code

``` Java
public class Solution {
    private final List<List<String>> result = new ArrayList<List<String>>();

    public List<List<String>> partition(String s) {
        if (s == null || s.isEmpty()) {
            return result;
        }
        helper(s, new ArrayList<String>());
        return result;
    }

    public void helper(String s, List<String> cur) {
        int length = s.length();
        if (length == 0) {
            result.add(cur);
            return;
        }
        for (int i = 1; i <= length; i++) {
            if (isPalindrome(s, 0, i - 1)) {
                String sub = s.substring(0, i);
                List<String> newList = new ArrayList<String>(cur);
                newList.add(sub);
                helper(s.substring(i), newList);
            }
        }
    }

    private boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
```

### Refinement
