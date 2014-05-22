## [Search in Rotated Sorted Array](https://oj.leetcode.com/problems/search-in-rotated-sorted-array/)

### Problem

Suppose a sorted array is rotated at some pivot unknown to you beforehand.

(i.e., `0 1 2 4 5 6 7` might become `4 5 6 7 0 1 2`).

You are given a target value to search. If found in the array return its index, otherwise return -1.

You may assume no duplicate exists in the array.

### Solution


### Code

``` java
public class Solution {
    public int search(int[] A, int target) {
        if (A == null) {
            return -1;
        }
        int len = A.length;
        if (len == 0) {
            return -1;
        }
        return search(A, target, 0, len-1);        
    }
    
    private int search(int[] A, int target, int start, int end) {
        if (start > end || (start==end && A[end] != target)) {
            return -1;
        }
        int mid = (start+end) / 2;
        if (A[mid] == target) {
            return mid;
        } else if (A[mid] < A[end]) {
            if (A[mid] < target && A[end] >= target) {
                return biSearch(A, target, mid+1, end);
            } else {
                return search(A, target, start, mid-1);
            }
        } else {
            if (A[mid] > target && A[start] <= target) {
                return biSearch(A, target, start, mid-1);
            } else {
                return search(A, target, mid+1, end);
            }
        }
    }
    
    private int biSearch(int[] A, int target, int start, int end) {
        if (start > end) {
            return -1;
        }
        int mid = (start+end) / 2;
        if (A[mid] == target) {
            return mid;
        } else if (A[mid] < target) {
            return biSearch(A, target, mid+1, end);
        } else {
            return biSearch(A, target, start, mid-1);
        }
    }
}
```

### Refinement

``` java
public class Solution {
	public int search(int[] A, int target) {
		if (A == null || A.length == 0) {
			return -1;
		}
		int start = 0, end = A.length - 1;
		while (start <= end) {
			int mid = (start + end) / 2;
			if (A[mid] == target) {
				return mid;
			}
			if (start == end) {
				return -1;
			}
			if (A[end] < A[mid]) {
				if (A[start] <= target && target < A[mid]) {
					end = mid - 1;
				} else {
					start = mid + 1;
				}
			} else if (A[mid] < A[end]) {
				if (A[mid] < target && target <= A[end]) {
					start = mid + 1;
				} else {
					end = mid - 1;
				}
			}
		}
		return -1;
	}
}
```