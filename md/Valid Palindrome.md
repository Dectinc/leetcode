## [Valid Palindrome](http://oj.leetcode.com/problems/valid-palindrome/)

Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

For example,
`"A man, a plan, a canal: Panama"` is a palindrome.
`"race a car"` is not a palindrome.

**Note:**
Have you consider that the string might be empty? This is a good question to ask during an interview.

For the purpose of this problem, we define empty string as valid palindrome.

``` java 
public class Solution {
    public boolean isPalindrome(String s) {
        if (s.isEmpty()) {
            return true;
        }
        s = s.replaceAll("[^a-zA-Z0-9]", "");
        s = s.toLowerCase();
        int i = 0;
        int j = s.length() - 1;
        
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            } else {
                i++;
                j--;
            }
        }
        
        return true;
    }
}
```