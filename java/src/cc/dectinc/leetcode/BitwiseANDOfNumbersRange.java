/**
 * 
 */
package cc.dectinc.leetcode;

/**
 * @author Dectinc
 * @version Apr 21, 2015 11:16:23 PM
 * 
 */
public class BitwiseANDOfNumbersRange {
	public int rangeBitwiseAnd(int m, int n) {
		if (m == n) {
			return m;
		}
		int nums = n - m, t = m;
		int result = 0, pos = 0;

		while (m > 0) {
			pos++;
			int curRoutine = (int) Math.pow(2, pos);
			if ((m & 1) == 1
					&& (t % curRoutine + nums < curRoutine || curRoutine == Integer.MAX_VALUE)) {
				result = 1 << (pos - 1) | result;
			}
			m = m >> 1;
			// System.out.println("" + pos + "\t" +
			// Integer.toBinaryString(result));
		}
		return result;
	}

	public int rangeBitwiseAndNice(int m, int n) {
		if (m == 0) {
			return 0;
		}
		int moveFactor = 1;
		while (m != n) {
			m >>= 1;
			n >>= 1;
			moveFactor <<= 1;
		}
		return m * moveFactor;
	}

	public static void main(String[] args) {
		BitwiseANDOfNumbersRange sol = new BitwiseANDOfNumbersRange();
		int m = 1;
		int n = 2;
		// int m = 2147483646;
		// int n = 2147483647;
		System.out.println(sol.rangeBitwiseAnd(m, n));
	}

}
