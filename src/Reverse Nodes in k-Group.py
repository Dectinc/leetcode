# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    # @param head, a ListNode
    # @param k, an integer
    # @return a ListNode
    def reverseKGroup(self, head, k):
        if not head or k <= 1:
            return head
        p = head
        q = head
        t = head
        _head = head
        _tmp = head
        while True:
            i = 1
            while t is not None and i < k:
                t = t.next
                i += 1
            if not t or i < k:
                break
            while p != t:
                q = p.next
                p.next = t.next
                t.next = p
                p = q

            if _head == head:
                head = p
            else:
                _tmp.next = p
            _tmp = _head
            p = q = t = _head = _head.next
        return head
