## [Word Ladder II](https://leetcode.com/problems/word-ladder-ii/)

### Problem

Given two words (start and end), and a dictionary, find the length of shortest transformation sequence from start to end, such that:

- Only one letter can be changed at a time
- Each intermediate word must exist in the dictionary

For example,

Given:

_start_ = `"hit"`

_end_ = `"cog"`

_dict_ = `["hot","dot","dog","lot","log"]`

Return
```
  [
    ["hit","hot","dot","dog","cog"],
    ["hit","hot","lot","log","cog"]
  ]
```
Note:

- All words have the same length.
- All words contain only lowercase alphabetic characters.


### Solution


### Code

``` Java
public class Solution {
	class WordNode {
		String word;
		List<String> path;
		int distance;
		WordNode from;

		public WordNode(String word, WordNode from, int distance) {
			this.word = word;
			this.from = from;
			this.distance = distance;
			this.path = new ArrayList<String>();
			if (from != null) {
				this.path.addAll(from.path);
			}
			this.path.add(word);
		}
	}

	public List<List<String>> findLadders(String start, String end,
			Set<String> dict) {
		if (dict == null || dict.size() == 0) {
			return null;
		}
		List<List<String>> result = new ArrayList<List<String>>();

		LinkedList<WordNode> wordNodes = new LinkedList<WordNode>();
		wordNodes.add(new WordNode(start, null, 1));
		dict.remove(start);
		dict.remove(end);
		int wordLength = start.length();

		int foundLength = Integer.MAX_VALUE;
		while (dict.size() > 0 && !wordNodes.isEmpty()) {
			WordNode node = wordNodes.poll();
			String word = node.word;
			int distance = node.distance + 1;
			List<String> path = node.path;
			if (distance > foundLength) {
				continue;
			}
			for (int i = 0; i < wordLength; i++) {
				char[] chars = word.toCharArray();
				for (char c = 'a'; c <= 'z'; c++) {
					chars[i] = c;
					String curWord = new String(chars);
					if (curWord.equals(end)) {
						foundLength = distance;
						path.add(end);
						result.add(path);
						continue;
					}
					if (!dict.contains(curWord) || path.contains(curWord)) {
						continue;
					}
					wordNodes.add(new WordNode(curWord, node, distance));
				}
			}
		}

		return result;
	}
}
```

### Refinement
