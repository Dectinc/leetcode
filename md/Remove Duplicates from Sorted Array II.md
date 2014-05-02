## [Remove Duplicates from Sorted Array II](http://oj.leetcode.com/problems/remove-duplicates-from-sorted-array-ii/)

Follow up for "Remove Duplicates":
What if duplicates are allowed at most twice?

For example,
Given sorted array A = `[1,1,1,2,2,3]`,

Your function should return length = 5, and A is now `[1,1,2,2,3]`.

``` java
public class Solution {
    public int removeDuplicates(int[] A) {
		if (A == null || A.length == 0) {
			return 0;
		}

		int curNum = A[0], lastNum = A[0], curCount = 1;
		int curIdx = 1, curNewIdx = 1;
		int len = A.length;
		List<Integer> result = new ArrayList<Integer>();
		result.add(A[0]);

		while (curIdx < len) {
			curNum = A[curIdx];
			if (lastNum == curNum) {
				if (curCount > 0) {
					curCount--;
					curNewIdx++;
					result.add(curNum);
				}
			} else {
				result.add(curNum);
				curCount = 1;
				curNewIdx++;
			}
			curIdx++;
			lastNum = curNum;
		}

		A = new int[curNewIdx];
		for (int i = 0; i < curNewIdx; i++) {
			A[i] = result.get(i);
			// System.out.print("\t" + A[i]);
		}
		return curNewIdx;
    }
}
```