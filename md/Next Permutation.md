## [Next Permutation](https://leetcode.com/problems/next-permutation/)

### Problem

Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).

The replacement must be in-place, do not allocate extra memory.

Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.

`1,2,3` → `1,3,2`

`3,2,1` → `1,2,3`

`1,1,5` → `1,5,1`

### Solution


### Code

``` Python
class Solution:
    # @param num, a list of integer
    # @return nothing (void), do not return anything, modify num in-place instead.
    def nextPermutation(self, num):
        def reverse(i, j):
            while i < j:
                a = num[i]
                num[i] = num[j]
                num[j] = a
                i += 1
                j -= 1
        if not num:
            return
        length = len(num)
        if length < 2:
            return
        i = length - 2
        while i >= 0 and num[i] >= num[i+1]:
            i -= 1
        if i == -1:
            reverse(0, length-1)
            return
        j = length - 1
        while j > i:
            if num[j] > num[i]:
                a = num[i]
                num[i] = num[j]
                num[j] = a
                break
            j -= 1
        reverse(i+1, length - 1)
```

### Refinement
