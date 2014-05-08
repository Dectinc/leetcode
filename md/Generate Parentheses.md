## [Generate Parentheses](http://oj.leetcode.com/problems/generate-parentheses/)

Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:

```
"((()))", "(()())", "(())()", "()(())", "()()()"
```

``` java
public class Solution {
    ArrayList<String> res = new ArrayList<String>();
    char[] s;
    int len = 0;
    
    public ArrayList<String> generateParenthesis(int n) {
        if (n == 0) {
            return null;
        }
        len = 2*n;
        s = new char[len];
        generateOne(0, n, n);
        
        return res;
    }
    
    public void generateOne(int pos, int left, int right) {
        if (left > right || left < 0) {
            return;
        }
        else if (left == 0 && right > 0) {
            while (right-- != 0) {
                s[pos++] = ')';
            }
            res.add(new String(s));
        }
        else if (left == right) {
            s[pos] = '(';
            generateOne(pos+1, left - 1, right);
        }
        else if (left < right) {
            s[pos] = '(';
            generateOne(pos+1, left - 1, right);
            
            s[pos] = ')';
            generateOne(pos+1, left, right - 1);
        }
    }
}
```