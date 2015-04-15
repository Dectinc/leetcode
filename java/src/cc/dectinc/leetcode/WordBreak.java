/**
 * 
 */
package cc.dectinc.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Dectinc
 * @version Apr 13, 2015 9:43:48 PM
 * 
 */
public class WordBreak {
	private int maxLength = -1;

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

	public boolean wordBreakOrigin(String s, Set<String> dict) {
		if (dict.size() == 0) {
			return false;
		}
		maxLength = getMaxLength(dict);
		return helper(s, dict);
	}

	private boolean helper(String s, Set<String> dict) {
		if (s.isEmpty() || dict.contains(s)) {
			return true;
		}
		int length = Math.min(s.length(), maxLength);
		for (int i = 1; i <= length; i++) {
			if (dict.contains(s.subSequence(0, i))
					&& helper(s.substring(i), dict)) {
				return true;
			}
		}
		return false;
	}

	private int getMaxLength(Set<String> dict) {
		int length = 0;
		for (String string : dict) {
			length = Math.max(length, string.length());
		}
		return length;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		WordBreak sol = new WordBreak();
		String s = "aaaaaaaaaaaaaaaaaab";
		Set<String> dict = new HashSet<String>();
		String[] strings = { "a", "aa", "aaa", "aaaa", "aaaaa", "aaaaaa",
				"aaaaaaa", "aaaaaaaa", "aaaaaaaaa", "aaaaaaaaaa" };
		dict.addAll(Arrays.asList(strings));
		System.out.println(sol.wordBreak(s, dict));
	}

}
