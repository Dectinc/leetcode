## [Implement Queue using Stacks](https://leetcode.com/problems/implement-queue-using-stacks/)

### Problem

mplement the following operations of a queue using stacks.

- push(x) -- Push element x to the back of queue.
- pop() -- Removes the element from in front of queue.
- peek() -- Get the front element.
- empty() -- Return whether the queue is empty.

### Solution


### Code

``` Python
class Queue(object):
    def __init__(self):
        """
        initialize your data structure here.
        """
        self.stack = []
        

    def push(self, x):
        """
        :type x: int
        :rtype: nothing
        """
        tmp = []
        while self.stack:
            tmp.append(self.stack.pop())
        self.stack.append(x)
        while tmp:
            self.stack.append(tmp.pop())
        

    def pop(self):
        """
        :rtype: nothing
        """
        self.stack.pop()
        

    def peek(self):
        """
        :rtype: int
        """
        return self.stack[-1]
        

    def empty(self):
        """
        :rtype: bool
        """
        return not self.stack
```

### Refinement
