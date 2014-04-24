## Reverse Words in a String

Given an input string, reverse the string word by word.

For example,
```
Given s = "the sky is blue",
return "blue is sky the".
```

Clarification:

> What constitutes a word?
>> A sequence of non-space characters constitutes a word.

- Could the input string contain leading or trailing spaces?

Yes. However, your reversed string should not contain leading or trailing spaces.

- How about multiple spaces between two words?

Reduce them to a single space in the reversed string.

``` java
public class Solution {
    public String reverseWords(String s) {
        int len = s.length();
        if (s == null) {
            return null;
        }
        
        String[] words = s.split(" ");
        String res = "";
        int num = words.length;
        for (int i = num - 1; i > -1; i--) {
            String word = words[i];
            if (word.length() > 0)
            {
                res += " " + word;
            }
        }
        if (res.length() > 0) {
            return res.substring(1);
        }
        else {
            return res;
        }
    }
}
```