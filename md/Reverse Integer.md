## [Reverse Integer](http://oj.leetcode.com/problems/reverse-integer/)

### Problem

Reverse digits of an integer.

> Example1: x = 123, return 321

> Example2: x = -123, return -321

Here are some good questions to ask before coding. Bonus points for you if you have already thought through this!

- If the integer's last digit is 0, what should the output be? ie, cases such as 10, 100.

- Did you notice that the reversed integer might overflow? Assume the input is a 32-bit integer, then the reverse of 1000000003 overflows. How should you handle such cases?

- Throw an exception? Good, but what if throwing an exception is not an option? You would then have to re-design the function (ie, add an extra parameter).

### Solution


### Code

``` Java
public int reverse(int x) {
	if (x < 0 && -x < 0) {
		return 0;
	}
	if (x < 0) {
		return -reverse(-x);
	}
	int reversed = 0;
	int remains = x;
	
	while (remains > 0) {
		int d = remains %10;
		if (reversed > (Integer.MAX_VALUE-d)/10) {
			return 0;
		}
		reversed = reversed*10+d;
		remains = remains/10;
	}
	
	return reversed;
}

public int reverse2014(int x) {
	if (x == 0) {
		return 0;
	}
	if (x < 0) {
		return 0 - reverse2014(0 - x);
	}

	String s = "" + x;
	int len = s.length();
	String curInt = "";
	for (int i = len - 1; i > -1; i--) {
		curInt += s.charAt(i);
	}
	long tmp = Long.parseLong(curInt);
	return (int) (tmp % Integer.MAX_VALUE);
}
```

### Refinement
