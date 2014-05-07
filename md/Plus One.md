## [Plus One](http://oj.leetcode.com/problems/plus-one/)

Given a non-negative number represented as an array of digits, plus one to the number.

The digits are stored such that the most significant digit is at the head of the list.

``` java
public class Solution {
    public int[] plusOne(int[] digits) {
        int len = digits.length;
        
        int pass = 1;
        for (int i = len-1; i>=0; i--) {
            int curDigit = digits[i] + pass;
            digits[i] = curDigit % 10;
            pass = curDigit / 10;
        }
        
        if (pass == 0) {
            return digits;
        }
        else {
            int[] result = new int[len + 1];
            result[0] = 1;
            for (int i = 0; i < len; i++) {
                result[i+1] = digits[i];
            }
            return result;
        }
    }
}
```