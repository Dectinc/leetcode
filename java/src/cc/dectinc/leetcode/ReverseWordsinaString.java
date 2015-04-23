package cc.dectinc.leetcode;

public class ReverseWordsinaString {
	public String reverseWords(String s) {
		String res = "";
		String curWord = "";
		boolean space = true;
		for (char c : s.toCharArray()) {
			if (c == ' ' && space) {
				continue;
			}
			if (c != ' ') {
				space = false;
				curWord += c;
			} else {
				space = true;
				res = " " + curWord + res;
				curWord = "";
			}
		}
		if (curWord.length() > 0) {
			res = " " + curWord + res;
		}
		return res.length() == 0 ? res : res.substring(1);
	}

	public String reverseWords2014(String s) {
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

	public static void main(String[] args) {
		ReverseWordsinaString sol = new ReverseWordsinaString();
		String s = " a ";
		System.out.println("------" + sol.reverseWords(s) + "------");
	}
}