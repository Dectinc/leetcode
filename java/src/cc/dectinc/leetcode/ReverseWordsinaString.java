package cc.dectinc.leetcode;

public class ReverseWordsinaString {
	public String reverseWords(String s) {
		String[] words = s.split(" ");
		String res = "";
		int num = words.length;
		for (int i = num - 1; i > -1; i--) {
			String word = words[i];
			if (word.length() > 0) {
				res += " " + word;
			}
		}
		if (res.length() > 0) {
			return res.substring(1);
		} else {
			return res;
		}
	}
}