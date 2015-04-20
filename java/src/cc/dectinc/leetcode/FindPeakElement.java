/**
 * 
 */

package cc.dectinc.leetcode;

/**
 * @author chenshijiang
 * @date Apr 20, 2015 4:25:10 PM
 * 
 */
public class FindPeakElement {
	public int findPeakElementNaive(int[] nums) {
		int length = nums.length;
		if (length == 0) {
			return Integer.MIN_VALUE;
		} else if (length == 1) {
			return 0;
		} else {
			if (nums[0] > nums[1]) {
				return 0;
			} else if (nums[length - 1] > nums[length - 2]) {
				return length - 1;
			}
		}
		for (int i = 1; i < length - 1; i++) {
			if (nums[i] > nums[i - 1] && nums[i] > nums[i + 1]) {
				return i;
			}
		}
		return -1;
	}

	public int findPeakElement(int[] num) {
		int start = 0;
		int end = num.length - 1;
		while (start < end) {
			int mid = (start + end) / 2;
			if (num[mid] < num[mid + 1]) {
				start = mid + 1;
			} else {
				end = mid;
			}
		}
		return start;
	}

	public static void main(String[] args) {
		FindPeakElement sol = new FindPeakElement();
		int[] numArray = { 1, 2, 3 };
		// System.out.println(sol.findPeakElement(numArray));
		System.out.println(sol.findPeakElementNaive(numArray));
	}

}
