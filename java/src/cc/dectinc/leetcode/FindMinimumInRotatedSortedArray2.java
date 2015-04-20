/**
 * 
 */

package cc.dectinc.leetcode;

/**
 * @author chenshijiang
 * @date Apr 20, 2015 4:13:49 PM
 * 
 */
public class FindMinimumInRotatedSortedArray2 {
	public int findMin(int[] nums) {
		int start = 0;
		int end = nums.length - 1;
		while (start < end) {
			if (nums[start] < nums[end]) {
				return nums[start];
			}
			int mid = start + (end - start) / 2;
			if (nums[mid] < nums[start]) {
				end = mid;
			} else if (nums[mid] > nums[end]) {
				start = mid + 1;
			} else {
				start++;
			}
		}
		return nums[start];
	}

	public static void main(String[] args) {
		FindMinimumInRotatedSortedArray2 sol = new FindMinimumInRotatedSortedArray2();
		int[] nums = { 3, 1, 2 };
		System.out.println(sol.findMin(nums));
	}
}
