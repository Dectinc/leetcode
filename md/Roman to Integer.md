## [Roman to Integer](http://oj.leetcode.com/problems/roman-to-integer/)

**Problem**

Given a roman numeral, convert it to an integer.

Input is guaranteed to be within the range from 1 to 3999.

**Solution**

Traverse all the characters, considering the following conditions:

- When current value represented by current character is larger than the last value, then their contribution to the number is their difference
- When current value equals to last one, then add it to the buffer
- When current value is smaller than the last one
	- if the buffer is null, then assign current value to the buffer
	- or add the number with buffer and assign the current value to the buffer
	- actually these two are of the same

**Code**

``` java
public class Solution {
    private static HashMap<Character, Integer> charMap;
    
    static {
        //I(1), V(5), X(10), L(50), C(100), D(500), M(1000)
        charMap = new HashMap<Character, Integer>();
        charMap.put('I', 1);
        charMap.put('V', 5);
        charMap.put('X', 10);
        charMap.put('L', 50);
        charMap.put('C', 100);
        charMap.put('D', 500);
        charMap.put('M', 1000);
    }
    
    public int romanToInt(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        int curDigits = 0;
        int curNum = 0;
        char[] cs = s.toCharArray();
        int last = charMap.get(cs[0]);
        
        for (char c : cs) {
            int value = charMap.get(c);
            if (value == last) {
                curDigits += value;
                continue;
            } else if (value > last) {
                curNum += value - curDigits;
                curDigits = 0;
            }  else {
                curNum += curDigits;
                curDigits = value;
            }
            last = value;
        }
        
        if (curDigits > 0) {
            curNum += curDigits;
        }
        
        return curNum;
    }
}
```

**Refinement**