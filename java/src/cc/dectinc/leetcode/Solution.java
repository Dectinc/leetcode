/**
 * 
 */
package cc.dectinc.leetcode;

/**
 * @author Dectinc
 * @version Jul 19, 2015 5:14:26 PM
 * 
 */
public class Solution {
	public static void nextPermutation(int[] nums) {
		// 从右向左找，找到降序的点，将左边的数与右边的第一个比其大的数交换
		int len = nums.length;
		if (len == 0 || len == 1)
			return;
		int pos = len - 1;
		int right = nums[pos];
		while (pos > 0 && right <= nums[pos - 1]) {
			pos--;
			right = nums[pos];
		}

		int tmp = 0;
		if (pos == len - 1) {
			tmp = right;
			nums[pos] = nums[pos - 1];
			nums[pos - 1] = tmp;
		} else if (pos == 0) {
			reverse(nums, 0, len - 1);
		} else {
			// 找到右边最小的比nums[pos-1]大的数，然后reverse pos~len-1
			tmp = nums[pos - 1];
			int j = pos;
			int min = Integer.MAX_VALUE;
			int minPos = 0;
			while (j < len) {
				if (nums[j] > tmp && nums[j] < min) {
					min = nums[j];
					minPos = j;
				}
				j++;
			}
			nums[pos - 1] = min;
			nums[minPos] = tmp;
			reverse(nums, pos, len - 1);
		}
	}

	public static void reverse(int[] nums, int s, int t) {
		for (int i = s, j = t; i < j; i++, j--) {
			int tmp = nums[i];
			nums[i] = nums[j];
			nums[j] = tmp;
		}
	}

	public static void main(String[] args) {
		int[] nums = { 2, 3, 1, 3, 3 };
		nextPermutation(nums);
		for (int i : nums) {
			System.out.print(i + ",");
		}
	}
}
