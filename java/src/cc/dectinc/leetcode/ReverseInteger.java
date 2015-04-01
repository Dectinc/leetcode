package cc.dectinc.leetcode;

public class ReverseInteger {
	public int reverse(int x) {
		if (x == 0) {
			return 0;
		}
		if (x < 0) {
			return 0 - reverse(0 - x);
		}

		String s = "" + x;
		int len = s.length();
		String curInt = "";
		for (int i = len - 1; i > -1; i--) {
			curInt += s.charAt(i);
		}
		long tmp = Long.parseLong(curInt);
		return (int) (tmp % Integer.MAX_VALUE);
	}
}