#! /usr/bin/env python
# -*- coding: utf-8 -*-
# @filename  86 - Partition List
# @author   dectinc@icloud.com
# @date     2015-04-01 01:39

from ListUtil import *

class Solution:
    # @param head, a ListNode
    # @param x, an integer
    # @return a ListNode
    def partition(self, head, x):
        headLeft, headRight = ListNode(0), ListNode(0)
        p, q, r = headLeft, headRight, head
        while r is not None:
            if r.val < x:
                p.next = r
                p = p.next
            else:
                q.next = r
                q = q.next
            r = r.next
        p.next = headRight.next
        return headLeft.next


if __name__ == '__main__':
    sol = Solution()
    head, x = [2,1], 2
    print sol.partition(constructList(head), x)
    