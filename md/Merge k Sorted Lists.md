## [Merge k Sorted Lists](http://leetcode.com/problems/merge-k-sorted-lists/)

### Problem

Merge _k_ sorted linked lists and return it as one sorted list. Analyze and describe its complexity.

### Solution


### Code

- 1393ms

``` Python
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    # @param a list of ListNode
    # @return a ListNode
    def mergeKLists(self, lists):
        result = None
        p = None
        heads = []
        i = 0
        while i < len(lists):
            l = lists[i]
            if l is not None:
                heads.append(l.val)
                i += 1
            else:
                lists.remove(l)
        if len(heads) == 0:
            return None
        while len(heads) > 0:
            minValue = min(heads)
            node = ListNode(minValue)
            if result is None:
                result = node
            else:
                p.next = node
            p = node
            iList = heads.index(minValue)
            lists[iList] = lists[iList].next
            if lists[iList] is not None:
                heads[iList] = lists[iList].val
            else:
                del(lists[iList])
                del(heads[iList])
        return result
```

### Refinement
