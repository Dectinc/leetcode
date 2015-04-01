#! /usr/bin/env python
# -*- coding: utf-8 -*-
# @filename  ListUtil
# @author   dectinc@icloud.com
# @date     2015-04-01 01:40


# Definition for singly-linked list.
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None


def constructList(aList):
    head = None
    p = head
    for a in aList:
        node = ListNode(a)
        if not head:
            head = node
            p = node
        else:
            p.next = node
            p = p.next
    return head


def linkListToList(head):
    a = []
    while head is not None:
        a.append(head.val)
        head = head.next
    return a


if __name__ == '__main__':
    a = [2,1]
    linkList = constructList(a)
    print linkListToList(linkList)
    