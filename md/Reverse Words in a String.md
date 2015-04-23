## [Reverse Words in a String](http://oj.leetcode.com/problems/reverse-words-in-a-string/)

### Problem

Given an input string, reverse the string word by word.

For example,
```
Given s = "the sky is blue",
return "blue is sky the".
```

Clarification:

- What constitutes a word?

    A sequence of non-space characters constitutes a word.

- Could the input string contain leading or trailing spaces?

    Yes. However, your reversed string should not contain leading or trailing spaces.

- How about multiple spaces between two words?

    Reduce them to a single space in the reversed string.

### Solution


### Code

``` Java
public class Solution {
    public String reverseWords(String s) {
        String res = "";
        String curWord = "";
        boolean space = true;
        for (char c : s.toCharArray()) {
            if (c == ' ' && space) {
                continue;
            }
            if (c != ' ') {
                space = false;
                curWord += c;
            } else {
                space = true;
                res = " " + curWord + res;
                curWord = "";
            }
        }
        if (curWord.length() > 0) {
            res = " " + curWord + res;
        }
        return res.length() == 0 ? res : res.substring(1);
    }
}
```

### Refinement
