package cc.dectinc.leetcode;

public class ReverseInteger {
	public int reverse(int x) {
		if (x < 0 && -x < 0) {
			return 0;
		}
		if (x < 0) {
			return -reverse(-x);
		}
		int reversed = 0;
		int remains = x;

		while (remains > 0) {
			int d = remains % 10;
			if (reversed > (Integer.MAX_VALUE - d) / 10) {
				return 0;
			}
			reversed = reversed * 10 + d;
			remains = remains / 10;
		}

		return reversed;
	}

	public int reverse2014(int x) {
		if (x == 0) {
			return 0;
		}
		if (x < 0) {
			return 0 - reverse2014(0 - x);
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