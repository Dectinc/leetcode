## [Find Minimum in Rotated Sorted Array II](https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/)

### Problem
```
Follow up for "Find Minimum in Rotated Sorted Array":
What if duplicates are allowed?

Would this affect the run-time complexity? How and why?
```
Suppose a sorted array is rotated at some pivot unknown to you beforehand.

(i.e., `0 1 2 4 5 6 7` might become `4 5 6 7 0 1 2`).

Find the minimum element.

The array may contain duplicates.

### Solution


### Code

``` Java
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
```

### Refinement
