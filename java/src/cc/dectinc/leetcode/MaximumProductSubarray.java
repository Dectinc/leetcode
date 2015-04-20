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
		return maxProduct(nums, 0, length - 1);
	}

	private int maxProduct(int[] nums, int start, int end) {
		if (start == end) {
			return nums[start];
		}
		int mid = (start + end) / 2;
		int maxLeft = maxProduct(nums, start, mid);
		int maxRight = maxProduct(nums, mid + 1, end);
		int maxMiddle = nums[mid] * nums[mid + 1];
		for (int i = mid - 1; i >= start; i--) {
			for (int j = mid + 2; j <= end; j++) {
				// maxMiddle = maxMiddle
			}
		}
		return 0;
	}

	public static void main(String[] args) {
		MaximumProductSubarray sol = new MaximumProductSubarray();
		int[] nums = { 2, 3, -2, 4 };
		System.out.println(sol.maxProduct(nums));
	}

}
