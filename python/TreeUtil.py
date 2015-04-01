#!/usr/bin/env python
# -*- coding: utf-8 -*-
# @Date    : 2015-04-01 12:54:28
# @Author  : chenshijiang (i@dectinc.cc)
# @Link    : http://dectinc.cc
# @Version : 0.0.1

# Definition for a  binary tree node
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

    def inOrderTraversal(self):
        nodes = []
        traversal = []
        pointer = self
        while pointer is not None:
            nodes.append(pointer)
            if pointer.left is not None:
                pointer = pointer.left
            else:
                try:
                    pointer = nodes.pop()
                    traversal.append(pointer.val)
                    while pointer.right is None:
                        pointer = nodes.pop()
                        traversal.append(pointer.val)
                    pointer = pointer.right
                except:
                    break
        return traversal

    def preOrderTraversal(self):
        nodes = []
        traversal = []
        pointer = self
        while pointer is not None:
            if pointer.right is not None:
                nodes.insert(0, pointer.right)
            traversal.append(pointer.val)
            if pointer.left is not None:
                pointer = pointer.left
            else:
                if len(nodes) == 0:
                    break
                pointer = nodes.pop(0)
        return traversal

    def postOrderTraversal(self):
        nodes = []
        traversal = []
        pointer = self
        while pointer is not None:
            pointer.visited = False
            nodes.append(pointer)
            if pointer.left is not None:
                pointer = pointer.left
            elif len(nodes) == 0:
                break
            else:
                try:
                    pointer = nodes.pop()
                    if pointer.visited:
                        traversal.append(pointer.val)
                        pointer = nodes.pop()
                    else:
                        while pointer.right is None or pointer.visited:
                            traversal.append(pointer.val)
                            pointer = nodes.pop()
                        pointer.visited = True
                        nodes.append(pointer)
                        pointer = pointer.right
                except:
                    break
        return traversal


def constructTree(nums):
    '''
    construct tree from list like {10,5,15,#,#,6,20}
    '''
    if len(nums) == 0:
        return None
    root = TreeNode(nums[0])
    curLevel = [root]
    length = len(nums)
    ii = 1
    while len(curLevel) > 0 and ii < length:
        newLevel = []
        for node in curLevel:
            if ii == length:
                break
            if nums[ii] == '#':
                node.left = None
            else:
                newNode = TreeNode(nums[ii])
                node.left = newNode
                newLevel.append(newNode)
            ii += 1
            if ii == length:
                break
            if nums[ii] == '#':
                node.right = None
            else:
                newNode = TreeNode(nums[ii])
                node.right = newNode
                newLevel.append(newNode)
            ii += 1
        curLevel = newLevel[:]
    return root


if __name__ == '__main__':
    nums = [10,5,15,'#','#',6,20]
    print constructTree(nums)
