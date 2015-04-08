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
		if (dict.size() == 0)
			return 0;

		dict.add(end);

		LinkedList<String> wordQueue = new LinkedList<String>();
		LinkedList<Integer> distanceQueue = new LinkedList<Integer>();

		wordQueue.add(start);
		distanceQueue.add(1);

		// track the shortest path
		int result = Integer.MAX_VALUE;
		while (!wordQueue.isEmpty()) {
			String currWord = wordQueue.pop();
			Integer currDistance = distanceQueue.pop();

			if (currWord.equals(end)) {
				result = Math.min(result, currDistance);
			}

			for (int i = 0; i < currWord.length(); i++) {
				char[] currCharArr = currWord.toCharArray();
				for (char c = 'a'; c <= 'z'; c++) {
					currCharArr[i] = c;

					String newWord = new String(currCharArr);
					if (dict.contains(newWord)) {
						wordQueue.add(newWord);
						distanceQueue.add(currDistance + 1);
						dict.remove(newWord);
					}
				}
			}
		}

		if (result < Integer.MAX_VALUE)
			return result;
		else
			return 0;
	}

	public int ladderLength2(String start, String end, Set<String> dict) {
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

	public int ladderLength1(String start, String end, Set<String> dict) {
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
		char[] a = word.toCharArray();
		char[] b = another.toCharArray();
		for (int i = 0; i < wordLength; i++) {
			if (a[i] == b[i]) {
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
		String start = "a";
		String end = "c";
		String[] strings = new String[] { "a", "b", "c" };
		Set<String> dict = new HashSet<String>();
		dict.addAll(Arrays.asList(strings));
		System.out.println(new WordLadder().ladderLength2(start, end, dict));
	}
}
