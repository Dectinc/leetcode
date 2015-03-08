## [Merge k Sorted Lists](http://leetcode.com/problems/merge-k-sorted-lists/)

### Problem

Merge _k_ sorted linked lists and return it as one sorted list. Analyze and describe its complexity.

### Solution


### Code

- 184ms

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
        if len(lists) == 0:
            return None
        elif len(lists) == 1:
            return lists[0]
        else:
            left = len(lists) / 2;
            pl = self.mergeKLists(lists[0:left])
            pr = self.mergeKLists(lists[left:])
            result = ListNode(-1)
            p = result
            while pl is not None or pr is not None:
                if pr is None or (pl is not None and pl.val < pr.val):
                    p.next = pl
                    pl = pl.next
                else:
                    p.next = pr
                    pr = pr.next
                p = p.next
        return result.next
```


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
