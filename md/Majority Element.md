## [Majority Element](https://leetcode.com/problems/majority-element/)

### Problem

Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.

You may assume that the array is non-empty and the majority element always exist in the array.

### Solution


### Code

``` Python
class Solution:
    # @param num, a list of integers
    # @return an integer
    def majorityElement(self, num):
        num.sort()
        return num[len(num) / 2]
```

- TLE

``` Python
class Solution:
    # @param num, a list of integers
    # @return an integer
    def majorityElement(self, num):
        return self.qsort(num, 0, len(num)-1, len(num)/2)
        
    def qsort(self, num, i, j, target):
        #import random
        #u = random.randint(i, j)
        #num[i], num[u] = num[u], num[i]
        u = i
        v = j
        while u < v:
            while u < v and num[u] <= num[v]:
                v -= 1
            if u<v:
                num[u], num[v] = num[v], num[u]
            while u < v and num[u] <= num[v]:
                u += 1
            if u<v:
                num[u], num[v] = num[v], num[u]
        if target == u:
            return num[target]
        elif target > u:
            return self.qsort(num, u+1, j, target)
        else:
            return self.qsort(num, i, u-1, target)
```



### Refinement

- 10 ms C solution
[](https://leetcode.com/discuss/26948/share-my-10ms-c-solution)