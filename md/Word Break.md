## [Word Break](https://leetcode.com/problems/word-break/)

### Problem

Given a string s and a dictionary of words dict, determine if s can be segmented into a space-separated sequence of one or more dictionary words.

For example, given

s = `"leetcode"`,

dict = [`"leet"`, `"code"`].

Return true because `"leetcode"` can be segmented as `"leet code"`.

### Solution


### Code

``` Java
public class Solution {
	public boolean wordBreak(String s, Set<String> dict) {
		if (s.length() == 0) {
			return true;
		}
		if (dict.size() == 0) {
			return false;
		}

		int length = s.length();
		boolean[] flags = new boolean[length + 1];
		flags[0] = true;

		for (int i = 1; i < length + 1; i++) {
			for (int j = 0; j < i; j++) {
				if (flags[j] && dict.contains(s.subSequence(j, i))) {
					flags[i] = true;
					break;
				}
			}
		}

		return flags[length];
	}
}
```

### Refinement
