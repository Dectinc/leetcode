/**
 * 
 */
package cc.dectinc.leetcode;

import java.util.HashMap;

/**
 * @author Dectinc
 * @version Apr 9, 2015 9:45:35 PM
 * 
 */
public class LongestConsecutiveSequence {
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

	public static void main(String args[]) {
		int[] num = { 100, 4, 200, 1, 3, 2 };
		System.out.println(new LongestConsecutiveSequence()
				.longestConsecutive(num));
	}
}
