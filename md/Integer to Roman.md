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

``` java
public class Solution {
    public String intToRoman(int num) {
        String result = "";
        int base[] = {1000,500,100,50,10,5,1,0};
        char baseC[] = {'M','D','C','L','X','V','I'};
        int basen = 0;
        while(num != 0) {
            if(basen%2 == 0 && num/base[basen] == 4) {
                result += baseC[basen];
                result += baseC[basen-1];
                num -= base[basen] * 4;
            } else if(num >= base[basen]) {
                result += baseC[basen];
                num -= base[basen];
            } else if(basen%2 == 0 && num / base[basen+2] == 9) {
                result += baseC[basen+2];
                result += baseC[basen];
                num -= base[basen+2]*9;
            } else {
                basen++;
            }
        }
        return result;
    }
}
```

### Refinement