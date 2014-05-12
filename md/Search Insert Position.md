## [Search Insert Position](http://oj.leetcode.com/problems/search-insert-position/)

Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You may assume no duplicates in the array.

Here are few examples.
`[1,3,5,6]`, 5 → 2
`[1,3,5,6]`, 2 → 1
`[1,3,5,6]`, 7 → 4
`[1,3,5,6]`, 0 → 0

``` java
public class Solution {
    public int searchInsert(int[] A, int target) {
        if (A == null || A.length == 0 || target <= A[0]) {
            return 0;
        } else if (target > A[A.length-1]) {
            return A.length;
        }
        return biSearch(A, 0, A.length-1, target);
    }
    
    private int biSearch(int[] A, int start, int end, int target) {
        if (start == end) {
            return start;
        }
        int mid = (start + end) / 2;
        int midNum = A[mid];
        if (midNum == target) {
            return mid;
        } else if (midNum < target) {
            return biSearch(A, mid+1, end, target);
        } else {
            return biSearch(A, start, mid, target);
        }
        
    }
}
```