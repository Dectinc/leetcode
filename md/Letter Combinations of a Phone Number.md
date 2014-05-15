## [Letter Combinations of a Phone Number](http://oj.leetcode.com/problems/letter-combinations-of-a-phone-number/)

**Problem**

Given a digit string, return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below.

![](../img/Telephone-keypad2.png)

```
Input:Digit string "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
```

**Note:**

Although the above answer is in lexicographical order, your answer could be in any order you want.

**Solution**

Use DFS to generate all the possible combinations.

**Code**

``` java
public class Solution {
	private static HashMap<Character, Character[]> map;	// must use Character
	char[] curResult;
	ArrayList<String> res;

	static {
		map = new HashMap<Character, Character[]>();
		// note the way to initilize a Character array when update the hashmap
		map.put('2', new Character[] { 'a', 'b', 'c' });
		map.put('3', new Character[] { 'd', 'e', 'f' });
		map.put('4', new Character[] { 'g', 'h', 'i' });
		map.put('5', new Character[] { 'j', 'k', 'l' });
		map.put('6', new Character[] { 'm', 'n', 'o' });
		map.put('7', new Character[] { 'p', 'q', 'r', 's' });
		map.put('8', new Character[] { 't', 'u', 'v' });
		map.put('9', new Character[] { 'w', 'x', 'y', 'z' });
	}

	public ArrayList<String> letterCombinations(String digits) {
		res = new ArrayList<String>();
		char[] chars = digits.toCharArray();
		int len = chars.length;
		curResult = new char[len];

		letterCombinatations(chars, 0);

		return res;
	}

	private void letterCombinatations(char[] chars, int start) {
		if (start == chars.length) {
			res.add(String.valueOf(curResult));
			return;
		}

		Character[] cs = map.get(chars[start]);
		for (char c : cs) {
			curResult[start] = c;
			letterCombinatations(chars, start + 1);
		}
	}
}
```

**Refinement**
