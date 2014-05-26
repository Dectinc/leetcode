## [Integer to Roman](https://oj.leetcode.com/problems/integer-to-roman/)

### Problem

Given an integer, convert it to a roman numeral.

Input is guaranteed to be within the range from 1 to 3999.

### Solution

_Solution 1: _ Use an String array to store all the possibilies.

_Solution 2:_ Obey the generating rules.

### Code

``` java
public class Solution {
    static String[][] roman = {
				{ "", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX" },
				{ "", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC" },
				{ "", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM" },
				{ "", "M", "MM", "MMM" } };
    
    public String intToRoman(int num) {
        StringBuffer sb = new StringBuffer();
        int i, j, n;
        for(j = 0, i = 10000; j < 4; ++j, i/=10)
        {
            n = (num%i) / (i/10);
            sb.append(roman[3-j][n]);
        }
        return sb.toString();
    }
}
```

### Refinement