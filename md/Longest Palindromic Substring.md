## [Longest Palindromic Substring](https://oj.leetcode.com/problems/longest-palindromic-substring/)

### Problem

Given a string S, find the longest palindromic substring in S. You may assume that the maximum length of S is 1000, and there exists one unique longest palindromic substring.

### Solution


### Code

- Time O(n^2) & Space O(n^2)

``` Python
class Solution:
    # @return a string
    def longestPalindrome(self, s):
        if s is None:
            return None
        if len(s) < 2:
            return s
        maxLength = 0
        longestString = ''

        length = len(s)
        flagTable = []
        for i in range(length):
            flagTable.append([False] * length)

        for i in range(length):
            flagTable[i][i] = True

        for i in range(length - 1):
            if s[i] == s[i + 1]:
                flagTable[i][i + 1] = True
                longestString = s[i:i + 2]

        for k in range(3, length + 1):
            for i in range(length - k + 1):
                j = i + k - 1
                if s[i] == s[j]:
                    flagTable[i][j] = flagTable[i + 1][j - 1]
                    if flagTable[i][j] == 1 and k > maxLength:
                        longestString = s[i:j + 1]
                        maxLength = k
                else:
                    flagTable[i][j] = False
        return longestString
```

- Time O(n^2) & Space O(1)

``` Java
public class Solution {
    public String longestPalindrome(String s) {
        if (s.isEmpty()) {
            return null;
        }

        if (s.length() == 1) {
            return s;
        }

        String longest = s.substring(0, 1);
        for (int i = 0; i < s.length(); i++) {
            // get longest palindrome with center of i
            String tmp = helper(s, i, i);
            if (tmp.length() > longest.length()) {
                longest = tmp;
            }

            // get longest palindrome with center of i, i+1
            tmp = helper(s, i, i + 1);
            if (tmp.length() > longest.length()) {
                longest = tmp;
            }
        }

        return longest;
    }

    // Given a center, either one letter or two letter,
    // Find longest palindrome
    public String helper(String s, int begin, int end) {
        while (begin >= 0 && end <= s.length() - 1 && s.charAt(begin) == s.charAt(end)) {
            begin--;
            end++;
        }
        return s.substring(begin + 1, end);
    }
}
```

``` Python
def preProcess(s):
    return '#' + '#'.join(list(s)) + '#'

class Solution:
    # @return a string
    def longestPalindrome(self, s):
        ss = preProcess(s)
        length = len(ss)
        p = [0] * length
        c = 0
        mx = 0
        for i in range(1, length-1):
            i_mirror = 2*c - i
            if i > mx:
                p[i] = 0
            else:
                p[i] = min(mx - i, p[i_mirror])

            # Attempt to expand palindrome centered at i
            m = i+1+p[i]
            n = i-1-p[i]
            while m < length and n > -1 and ss[m] == ss[n]:
                p[i] += 1
                m += 1
                n -= 1

            if i + p[i] > mx:
                c = i
                mx = i + p[i]

        maxLen = 0
        center = 0
        for i in range(1, length):
            if p[i] > maxLen:
                maxLen = p[i]
                center = i

        return s[(center-maxLen)/2: (center+1+maxLen)/2]
```

### Refinement
