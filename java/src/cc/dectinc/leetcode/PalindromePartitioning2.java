/**
 * 
 */

package cc.dectinc.leetcode;

/**
 * @author chenshijiang
 * @date Apr 12, 2015 4:01:00 PM
 * 
 */
public class PalindromePartitioning2 {
	public int minCut(String s) {
		if (s == null || s.length() < 2) {
			return 0;
		}
		char[] chars = s.toCharArray();
		int length = chars.length;
		int[] numCuts = new int[length + 1];
		for (int i = 0; i < length + 1; i++) {
			numCuts[i] = i - 1;
		}
		for (int i = 0; i < length; i++) {
			for (int j = 0; i - j >= 0 && i + j < length && chars[i - j] == chars[i + j]; j++) {
				numCuts[i + j + 1] = Math.min(numCuts[i + j + 1], 1 + numCuts[i - j]);
			}
			for (int j = 1; i - j + 1 >= 0 && i + j < length && chars[i - j + 1] == chars[i + j]; j++) {
				numCuts[i + j + 1] = Math.min(numCuts[i + j + 1], 1 + numCuts[i - j + 1]);
			}
		}
		return numCuts[length];
	}

	public static void main(String[] args) {
		String s = "aab";
		PalindromePartitioning2 sol = new PalindromePartitioning2();
		System.out.println(sol.minCut(s));
	}

}
