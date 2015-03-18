## [Intersection of Two Linked Lists](https://leetcode.com/problems/intersection-of-two-linked-lists/)

### Problem

Write a program to find the node at which the intersection of two singly linked lists begins.

For example, the following two linked lists:

```
A:          a1 → a2
                   ↘
                     c1 → c2 → c3
                   ↗            
B:     b1 → b2 → b3
```
begin to intersect at node c1.

__Notes:__

- If the two linked lists have no intersection at all, return `null`.
- The linked lists must retain their original structure after the function returns.
- You may assume there are no cycles anywhere in the entire linked structure.
- Your code should preferably run in O(n) time and use only O(1) memory.


### Solution

- First, get the length of two linked list; second, search for 2 linked list of the same length

### Code

``` Python
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None
class Solution:
    # @param two ListNodes
    # @return the intersected ListNode
    def getIntersectionNode(self, headA, headB):
        lengthA = self.getLength(headA)
        lengthB = self.getLength(headB)
        while lengthA > lengthB:
            lengthA -= 1
            headA = headA.next
        while lengthB > lengthA:
            lengthB -= 1
            headB = headB.next
        while headA:
            if headA == headB:
                return headA
            else:
                headA = headA.next
                headB = headB.next
        return None
        
    def getLength(self, head):
        length = 0
        while head:
            length += 1
            head = head.next
        return length
```

### Refinement
