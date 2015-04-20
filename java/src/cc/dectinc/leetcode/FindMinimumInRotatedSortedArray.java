/**
 * 
 */

package cc.dectinc.leetcode;

/**
 * @author chenshijiang
 * @date Apr 20, 2015 3:32:21 PM
 * 
 */
public class FindMinimumInRotatedSortedArray {
	public int findMin(int[] nums) {
		int start = 0;
		int end = nums.length - 1;
		while (start < end) {
			if (nums[start] < nums[end]) {
				return nums[start];
			}
			int mid = (start + end) / 2;
			if (nums[mid] < nums[start]) {
				end = mid;
			} else if (nums[mid] > nums[end]) {
				start = mid + 1;
			}
		}
		return nums[start];
	}

	public int findMin2(int[] num) {
		return binarySearch(num, 0, num.length - 1);
	}

	private int binarySearch(int[] num, int begin, int end) {
		while (begin < end) {
			int middle = (begin + end) / 2;
			if (num[middle] > num[middle + 1])
				return num[middle + 1];
			if (num[middle] > num[end])
				begin = middle + 1;
			else
				end = middle;
		}
		return num[begin];
	}

	public int findMinNaive(int[] nums) {
		int length = nums.length;
		if (length == 0) {
			return 0;
		}
		int last = nums[0];
		for (int i = 1; i < length; i++) {
			if (nums[i] < last) {
				return nums[i];
			}
		}
		return last;
	}

	public static void main(String[] args) {
		FindMinimumInRotatedSortedArray sol = new FindMinimumInRotatedSortedArray();
		int[] nums = { 3, 1, 2 };
		// int[] nums = { 4, 5, 6, 7, 0, 1, 2 };
		System.out.println(sol.findMin(nums));
	}

}
