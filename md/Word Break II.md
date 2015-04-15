## [Word Break II](https://leetcode.com/problems/word-break-ii/)

### Problem

Given a string s and a dictionary of words dict, add spaces in s to construct a sentence where each word is a valid dictionary word.

Return all such possible sentences.

For example, given

s = `"catsanddog"`,

dict = [`"cat"`, `"cats"`, `"and"`, `"sand"`, `"dog"`].

A solution is `["cats and dog", "cat sand dog"]`.

### Solution


### Code

``` Java
public class Solution {
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
}
```

### Refinement
