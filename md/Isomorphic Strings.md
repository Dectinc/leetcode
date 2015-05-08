## [Isomorphic Strings](https://leetcode.com/problems/isomorphic-strings/)

### Problem

Given two strings __s__ and __t__, determine if they are isomorphic.

Two strings are isomorphic if the characters in __s__ can be replaced to get __t__.

All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character but a character may map to itself.

For example,
Given `"egg"`, `"add"`, return true.

Given `"foo"`, `"bar"`, return false.

Given `"paper"`, `"title"`, return true.

__Note__:

You may assume both __s__ and __t__ have the same length.

### Solution


### Code

``` Java
public class Solution {
    public boolean isIsomorphic(String s, String t) {
        int lens = s.length(), lent = t.length();
        if (lens != lent) {
            return false;
        }
        if (lens == 0) {
            return true;
        }
        HashMap<Character, Character> stMap = new HashMap<Character, Character>();
        HashMap<Character, Character> tsMap = new HashMap<Character, Character>();
        char[] scs = s.toCharArray();
        char[] tcs = t.toCharArray();
        for (int i = 0; i < lens; i++) {
            char sc = scs[i];
            char tc = tcs[i];
            if (stMap.containsKey(sc)) {
                if (stMap.get(sc) != tc) {
                    return false;
                }
            } else {
                stMap.put(sc, tc);
            }
            if (tsMap.containsKey(tc)) {
                if (tsMap.get(tc) != sc) {
                    return false;
                }
            } else {
                tsMap.put(tc, sc);
            }
        }
        return true;
    }
}
```

### Refinement
