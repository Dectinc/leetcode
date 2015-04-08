/**
 * 
 */
package cc.dectinc.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * @author Dectinc
 * @version Apr 8, 2015 8:13:39 PM
 * 
 */
public class WordLadder {

	public int ladderLength(String start, String end, Set<String> dict) {
		if (dict.size() == 0) {
			return 0;
		}
		int wordLength = start.length();

		Queue<String> words = new LinkedList<String>();
		words.add(start);
		HashMap<String, Integer> visited = new HashMap<String, Integer>();
		visited.put(start, 1);
		Set<String> rest = new HashSet<String>();
		rest.addAll(dict);
		rest.remove(start);

		while (!words.isEmpty()) {
			String word = words.poll();
			rest.remove(word);
			for (String string : rest) {
				if (!rest.contains(string)) {
					continue;
				}
				if (isNeighbour(word, end, wordLength)) {
					return visited.get(word) + 1;
				}
				if (isNeighbour(word, string, wordLength)) {
					visited.put(string, visited.get(word) + 1);
					words.add(string);
				}
			}
		}

		return 0;
	}

	private boolean isNeighbour(String word, String another, int wordLength) {
		boolean flag = true;
		for (int i = 0; i < wordLength; i++) {
			if (word.charAt(i) == another.charAt(i)) {
				continue;
			}
			if (flag == false) {
				return flag;
			} else {
				flag = false;
			}
		}
		return !flag;
	}

	public static void main(String[] args) {
		// System.out.println(new WordLadder().isNeighbour("hot", "hit", 3));
		String start = "hit";
		String end = "cog";
		String[] strings = new String[] { "hot", "dot", "dog", "lot", "log" };
		Set<String> dict = new HashSet<String>();
		dict.addAll(Arrays.asList(strings));
		System.out.println(new WordLadder().ladderLength(start, end, dict));
	}
}
