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
	public int maxProductTest(int[] nums) {
		int n = nums.length;
		if (n == 0) {
			return 0;
		}
		int max = nums[0];
		int min = nums[0];
		for (int i = 1; i < n; i++) {
			int cur = nums[i];
			int lastMax = max;
			max = Math.max(max, Math.max(min * cur, max * cur));
			min = Math.min(min, Math.min(min * cur, lastMax * cur));
		}
		return max;
	}

	public int maxProduct(int[] nums) {
		int n = nums.length;
		if (n == 0) {
			return 0;
		}
		int frontProduct = 1;
		int backProduct = 1;
		int ans = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++) {
			frontProduct *= nums[i];
			backProduct *= nums[n - i - 1];
			ans = Math.max(ans, Math.max(frontProduct, backProduct));
			frontProduct = frontProduct == 0 ? 1 : frontProduct;
			backProduct = backProduct == 0 ? 1 : backProduct;
		}
		return ans;
	}

	public static void main(String[] args) {
		MaximumProductSubarray sol = new MaximumProductSubarray();
		// int[] nums = { 0, 0, 0, 0 };
		// int[] nums = { -2 };
		int[] nums = { 2, 3, -2, 4 };
		System.out.println(sol.maxProduct(nums));
	}

}
