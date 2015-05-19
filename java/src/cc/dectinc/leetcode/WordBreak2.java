/**
 * 
 */
package cc.dectinc.leetcode;

import java.util.*;

/**
 * @author Dectinc
 * @version Apr 15, 2015 4:08:27 PM
 * 
 */
public class WordBreak2 {
	private List<String> result;
	private int length;
	private final HashMap<String, List<String>> cacheMap = new HashMap<String, List<String>>();

	private boolean containsSuffix(String str, Set<String> dict) {
		return containsSuffix(str, 0, dict);
	}

	private boolean containsSuffix(String str, int start, Set<String> dict) {
		for (int i = start; i < str.length(); i++) {
			if (dict.contains(str.substring(i)))
				return true;
		}
		return false;
	}

	public List<String> wordBreak(String s, Set<String> wordDict) {
		List<String> strings = new ArrayList<String>();
		int length = s.length();
		if (length == 0 || wordDict.size() == 0 || !containsSuffix(s, wordDict)) {
			return strings;
		}

		for (int i = 1; i < length; i++) {
			String word = s.substring(0, i);
			if (wordDict.contains(word)) {
				String suffix = s.substring(i);
				List<String> suffixList;
				if (cacheMap.containsKey(suffix)) {
					suffixList = cacheMap.get(suffix);
				} else {
					suffixList = wordBreak(suffix, wordDict);
					cacheMap.put(suffix, suffixList);
				}
				for (String string : suffixList) {
					strings.add(word + " " + string);
				}
			}
		}

		if (wordDict.contains(s)) {
			strings.add(s);
		}
		return strings;
	}

	public List<String> wordBreakNaive(String s, Set<String> wordDict) {
		result = new ArrayList<String>();
		length = s.length();
		if (length == 0 || wordDict.size() == 0) {
			return result;
		}

		dfs(s, 0, wordDict, new LinkedList<String>());

		return result;
	}

	private void dfs(String s, int start, Set<String> dict, List<String> set) {
		if (!containsSuffix(s, start, dict)) {
			return;
		}
		if (start == length) {
			StringBuffer sb = new StringBuffer();
			for (String word : set) {
				sb.append(" ");
				sb.append(word);
			}
			result.add(sb.toString().substring(1));
		}
		for (int j = start + 1; j <= length; j++) {
			String word = s.substring(start, j);
			if (dict.contains(word)) {
				List<String> cur = new LinkedList<String>();
				cur.addAll(set);
				cur.add(word);
				dfs(s, j, dict, cur);
			}
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		WordBreak2 sol = new WordBreak2();
		String s = "catsanddog";
		String[] words = new String[] { "cat", "cats", "and", "sand", "dog" };
		Set<String> dict = new HashSet<String>();
		dict.addAll(Arrays.asList(words));

		System.out.println(sol.wordBreak(s, dict));
	}

}
