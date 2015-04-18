/**
 * 
 */
package cc.dectinc.leetcode;

/**
 * @author Dectinc
 * @version Apr 18, 2015 10:02:20 PM
 * 
 */
public class MaximumProductSubarray {
	public int maxProduct(int[] nums) {
		int length = nums.length;
		if (length == 0) {
			return 0;
		}
		int mid = (length - 1) / 2;
	}

	public static void main(String[] args) {
		MaximumProductSubarray sol = new MaximumProductSubarray();
		int[] nums = { 2, 3, -2, 4 };
		System.out.println(sol.maxProduct(nums));
	}

}
