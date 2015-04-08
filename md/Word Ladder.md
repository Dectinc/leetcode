## [Word Ladder](https://leetcode.com/problems/word-ladder/)

### Problem

Given two words (start and end), and a dictionary, find the length of shortest transformation sequence from start to end, such that:

- Only one letter can be changed at a time
- Each intermediate word must exist in the dictionary

For example,

Given:

_start_ = `"hit"`

_end_ = `"cog"`

_dict_ = `["hot","dot","dog","lot","log"]`

As one shortest transformation is `"hit" -> "hot" -> "dot" -> "dog" -> "cog"`,
return its length 5.

Note:

- Return 0 if there is no such transformation sequence.
- All words have the same length.
- All words contain only lowercase alphabetic characters.


### Solution


### Code

``` Java
public class Solution {
	public int ladderLength(String start, String end, Set<String> dict) {
		if (dict.size() == 0) {
			return 0;
		}
		int wordLength = start.length();
		dict.add(end);

		LinkedList<String> words = new LinkedList<String>();
		words.add(start);
		LinkedList<Integer> distances = new LinkedList<Integer>();
		distances.add(1);
		dict.remove(start);

		while (dict.size() > 0 && !words.isEmpty()) {
			String word = words.pop();
			int distance = distances.pop();
			distance++;
			for (int i = 0; i < wordLength; i++) {
				char[] chars = word.toCharArray();
				for (char c = 'a'; c <= 'z'; c++) {
					chars[i] = c;
					String newWord = new String(chars);
					if (dict.contains(newWord)) {
						if (newWord.equals(end)) {
							return distance;
						}
						words.add(newWord);
						distances.add(distance);
						dict.remove(newWord);
					}
				}
			}
		}

		return 0;
	}
}
```

### Refinement
