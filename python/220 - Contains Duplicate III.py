# -*- coding: utf-8 -*-
# @filename 220 - Contains Duplicate III
# @author   v-shijch
# @date     2015-07-09 11:42 AM


def containsNearbyAlmostDuplicate(nums, k, t):
    ind = sorted(range(len(nums)), key=lambda x: nums[x])
    for i in range(len(nums) - 1):
        j = i + 1
        while j < len(nums) and nums[ind[j]] - nums[ind[i]] <= t:
            if abs(ind[i] - ind[j]) <= k:
                return True
            j += 1
    return False


def containsNearbyAlmostDuplicate1(nums, k, t):
    n = len(nums)
    if k == 0:
        return False
    ind = sorted(xrange(n), key=lambda x: nums[x])
    for i in xrange(n - 1):
        j = i + 1
        margin = nums[ind[i]] + t
        while j < n and nums[ind[j]] <= margin:
            if abs(ind[i] - ind[j]) <= k:
                return True
            j += 1
    return False


if __name__ == '__main__':
    nums, k, t = [4,1,6,3], 100, 1
    print containsNearbyAlmostDuplicate(nums, k, t)
    print containsNearbyAlmostDuplicate1(nums, k, t)
