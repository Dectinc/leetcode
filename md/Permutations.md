## [Permutations](https://leetcode.com/problems/permutations/)

### Problem

 Given a collection of numbers, return all possible permutations.

For example,

`[1,2,3]` have the following permutations:

`[1,2,3]`, `[1,3,2]`, `[2,1,3]`, `[2,3,1]`, `[3,1,2]`, and `[3,2,1]`. 

### Solution

Using next permutation


### Code

``` Python
class Solution:
    # @param num, a list of integer
    # @return a list of lists of integers
    def permute(self, num):
        res = []
        if len(num) < 1:
            return res
        nums = sorted(num)
        num = len(nums)
        res.append(nums[:])
        while True:
            nums = self.nextPermutation(nums, num)
            if nums is None:
                return res
            res.append(nums[:])

    def nextPermutation(self, nums, num):
        i = num - 1
        while i > 0:
            if nums[i] > nums[i - 1]:
                a = nums[i - 1]
                idx, toSwap = i, nums[i]
                j = i
                while j < num:
                    if nums[j] > a and toSwap > nums[j]:
                        idx, toSwap = j, nums[j]
                    j += 1
                nums[i - 1], nums[idx] = nums[idx], nums[i - 1]
                nums = nums[:i] + sorted(nums[i:])
                break
            else:
                i -= 1
        if i == 0:
            return None
        else:
            return nums
```

### Refinement
