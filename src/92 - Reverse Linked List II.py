#!/usr/bin/env python
# -*- coding: utf-8 -*-
# @Date    : 2015-04-01 12:54:28
# @Author  : chenshijiang (i@dectinc.cc)
# @Link    : http://dectinc.cc
# @Version : 0.0.1

from ListUtil import *

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    # @param head, a ListNode
    # @param m, an integer
    # @param n, an integer
    # @return a ListNode
    def reverseBetween(self, head, m, n):
        h = ListNode(0)
        h.next = head
        p = q = h
        for ii in xrange(m):
            q = p
            p = p.next
        r = p
        p = p.next
        for ii in xrange(n-m):
            r.next = p.next
            p.next = q.next
            q.next = p
            p = r.next
        return h.next


if __name__ == '__main__':
    sol = Solution()
    head, m, n = [3,5], 1, 2
    head = constructList(head)
    result = sol.reverseBetween(head, m, n)
    print linkListToList(result)

