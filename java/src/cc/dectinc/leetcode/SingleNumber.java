package cc.dectinc.leetcode;

public class SingleNumber {
	public int singleNumber(int[] nums) {
		int result = 0;

		for (int num : nums) {
			result = result ^ num;
		}

		return result;
	}

	public int singleNumber2014(int[] A) {
		int len = A.length;
		int res = 0;
		for (int i = 0; i < len; i++) {
			res = res ^ A[i];
		}

		return res;
	}
}