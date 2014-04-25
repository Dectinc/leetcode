## [Longest Substring Without Repeating Characters](http://oj.leetcode.com/problems/longest-substring-without-repeating-characters/)

Given a string, find the length of the longest substring without repeating characters. For example, the longest substring without repeating letters for "abcabcbb" is "abc", which the length is 3. For "bbbbb" the longest substring is "b", with the length of 1.

``` java
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int curLen = 0, maxLen = 0, strLen = s.length();
        String curLongestSubstring = "";
        
        for (int i = 0; i < strLen; i++) {
            char t_char = s.charAt(i);
            int idx = curLongestSubstring.indexOf(t_char);
            
            if (idx == -1) {
                curLen++;
                curLongestSubstring += t_char;
            }
            else {
                if (curLen > maxLen) {
                    maxLen = curLen;
                }
                if (idx == curLen - 1) {
                    curLongestSubstring = "" + t_char;
                    curLen = 1;
                }
                else {
                    curLongestSubstring = curLongestSubstring.substring(idx+1) + t_char;
                    curLen = curLongestSubstring.length();
                }
            }
        }
        // there should be a comparison when the loop ends
        if (curLen > maxLen) {
            maxLen = curLen;
        }
        
        return maxLen;
    }
}
```

### Change list
- 2014-04-25 22:14:49

	I forgot to compare curLen with maxLen when the loop ends, thus, if the longest substring occurs at the end of the given string, the right answer connot be returned.