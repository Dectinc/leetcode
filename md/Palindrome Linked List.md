## [Palindrome Linked List](https://leetcode.com/problems/palindrome-linked-list/)

### Problem

Given a singly linked list, determine if it is a palindrome.

Follow up:

Could you do it in O(n) time and O(1) space?

### Solution


### Code

``` Python
# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def isPalindrome(self, head):
        """
        :type head: ListNode
        :rtype: bool
        """
        if head is None or head.next is None:
            return True
        fast, slow = head.next, head
        while fast is not None and fast.next is not None:
            fast = fast.next.next
            slow = slow.next
        r = self.reverse(slow.next)
        l = head
        while r is not None and l.val == r.val:
            l = l.next
            r = r.next
        return r is None
        
    def reverse(self, head):
        r = head
        p = q = None
        while r is not None:
            q = r.next
            r.next = p
            p = r
            r = q
        return p
```

### Refinement
