## [House Robber](https://leetcode.com/problems/house-robber/)

### Problem

You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and __it will automatically contact the police if two adjacent houses were broken into on the same night__.

Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight __without alerting the police__.

### Solution


### Code

```Java
public class Solution {
	public int rob(int[] num) {
		int n = num.length;

		int last = 0;
		int pre = 0;
		for (int i = 0; i < n; i++) {
			int cur = Math.max(last + num[i], pre);
			last = pre;
			pre = cur;
		}

		return pre;
	}
}
```

``` Java
public class Solution {
	public int rob(int[] num) {
		int n = num.length;
		if (n == 0) {
			return 0;
		} else if (n == 1) {
			return num[0];
		} else if (n == 2) {
			return Math.max(num[0], num[1]);
		}

		int last = num[0];
		int pre = Math.max(num[0], num[1]);
		for (int i = 2; i < n; i++) {
			int cur = Math.max(last + num[i], pre);
			last = pre;
			pre = cur;
		}

		return pre;
	}
}
```

### Refinement
