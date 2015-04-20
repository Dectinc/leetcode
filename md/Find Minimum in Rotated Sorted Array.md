## [Find Minimum in Rotated Sorted Array](https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/)

### Problem

Suppose a sorted array is rotated at some pivot unknown to you beforehand.

(i.e., `0 1 2 4 5 6 7` might become `4 5 6 7 0 1 2`).

Find the minimum element.

You may assume no duplicate exists in the array.

### Solution


### Code

``` Java
public class Solution {
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
}
```

### Refinement
