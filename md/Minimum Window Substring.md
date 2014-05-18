## [Minimum Window Substring](http://oj.leetcode.com/problems/minimum-window-substring/)

### Problem

Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).

For example,

__S__ = `"ADOBECODEBANC"`

__T__ = `"ABC"`

Minimum window is `"BANC"`.

__Note:__

If there is no such window in S that covers all characters in T, return the emtpy string `""`.

If there are multiple such windows, you are guaranteed that there will always be only one unique minimum window in S.

### Solution


### Code[Reference]

``` java
public class Solution {
    public String minWindow(String S, String T) {
        HashMap<Character, Integer> needToFill = new HashMap<Character, Integer>();
        HashMap<Character, Integer> hasFound = new HashMap<Character, Integer>();
        int count = 0;
        for(int i = 0; i < T.length(); i++){
            if(!needToFill.containsKey(T.charAt(i))){
                needToFill.put(T.charAt(i), 1);
                hasFound.put(T.charAt(i), 0);
            }else {
                needToFill.put(T.charAt(i), needToFill.get(T.charAt(i)) + 1);
            }
        }
        int minWinBegin = -1;
        int minWinEnd = S.length();
        for(int begin = 0, end = 0; end < S.length(); end++){
            char c = S.charAt(end);
            if(needToFill.containsKey(c)){
                hasFound.put(c, hasFound.get(c) + 1);
                if(hasFound.get(c) <= needToFill.get(c)){
                    count++;
                }
                if(count == T.length()){
                    while(!needToFill.containsKey(S.charAt(begin)) ||
                            hasFound.get(S.charAt(begin)) > needToFill.get(S.charAt(begin))) {
                        if(needToFill.containsKey(S.charAt(begin)) 
                                && hasFound.get(S.charAt(begin)) > needToFill.get(S.charAt(begin))){
                            hasFound.put(S.charAt(begin), hasFound.get(S.charAt(begin)) - 1);
                        }
                        begin++;
                    }
                    if(end - begin < minWinEnd - minWinBegin){
                        minWinEnd = end;
                        minWinBegin = begin;
                    }
                }
            }
        }
        return minWinBegin == -1 ? "" : S.substring(minWinBegin, minWinEnd + 1);
    }
}
```

### Refinement