## [Longest Consecutive Sequence](https://leetcode.com/problems/longest-consecutive-sequence/)

### Problem

 Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

For example,

Given `[100, 4, 200, 1, 3, 2]`,

The longest consecutive elements sequence is `[1, 2, 3, 4]`. Return its length: `4`.

Your algorithm should run in O(n) complexity. 

### Solution


### Code

``` Java
public class Solution {
	public int longestConsecutive(int[] num) {
		if (num == null || num.length == 0) {
			return 0;
		}
		int maxLength = 1;
		HashMap<Integer, Integer> lengthMap = new HashMap<Integer, Integer>();
		for (int a : num) {
			if (lengthMap.containsKey(a)) {
				continue;
			}
			lengthMap.put(a, 1);

			int end = a;
			int begin = a;

			if (lengthMap.containsKey(a - 1)) {
				begin -= lengthMap.get(a - 1);
			}
			if (lengthMap.containsKey(a + 1)) {
				end += lengthMap.get(a + 1);
			}
			int curLength = end - begin + 1;
			maxLength = Math.max(maxLength, curLength);
			lengthMap.put(end, curLength);
			lengthMap.put(begin, curLength);
		}
		return maxLength;
	}
}
```

### Refinement
