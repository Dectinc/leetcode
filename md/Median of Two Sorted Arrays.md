## [Median of Two Sorted Arrays](http://oj.leetcode.com/problems/median-of-two-sorted-arrays/)

**Problem**

There are two sorted arrays A and B of size m and n respectively. Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).

**Solution**

Merge the given two arrays using merging sort.

We do not have to merge the whole two arrays but the first `(m+n)/2+1` numbers, then return the median number according to the number of integers in the two arrays.

**Code**

``` java
public class Solution {
    public double findMedianSortedArrays(int A[], int B[]) {
        if (A == null && B == null) {
            return 0;
        } 
        int lena = 0, lenb = 0;
        if (A != null) {
            lena = A.length;
        }
        if (B != null) {
            lenb = B.length;
        }
        int m = (lena + lenb) / 2 + 1;
        int i = 0, j = 0, k = 0;
        int last1 = -1, last2 = -1;	// two integer variables denote the last two visited numbers, which will be used to calculate the median
        while (i < lena && j < lenb && k < m) {
            if (A[i] > B[j]) {
                last1 = last2;
                last2 = B[j];
                j++;
                k++;
            } else {
                last1 = last2;
                last2 = A[i];
                i++;
                k++;
            }
        }
        if (i == lena) {
            while (k < m) {
                last1 = last2;
                last2 = B[j];
                k++;
                j++;
            }
        }
        if (j == lenb) {
            while (k < m) {
                last1 = last2;
                last2 = A[i];
                i++;
                k++;
            }
        }
        return (lena + lenb) % 2 == 0 ? (double)(last1 + last2) / 2 : last2;
    }
}
```